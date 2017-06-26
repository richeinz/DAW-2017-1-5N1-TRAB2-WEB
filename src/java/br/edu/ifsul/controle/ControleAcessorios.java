/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AcessoriosDAO;
import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ricardo
 */
@ManagedBean(name = "controleAcessorios")
@SessionScoped
public class ControleAcessorios implements Serializable{
    
    private AcessoriosDAO dao;
    private Acessorios objeto;
    
    
     public ControleAcessorios(){
        dao = new AcessoriosDAO();
    }
    
    public String listar(){
        return"/privado/acessorios/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Acessorios();
        return "formulario";
    }
    
    public void salvar(){
        boolean persistiu;
        if (objeto.getId() == null){
            persistiu = dao.persist(objeto);
        } else {
            persistiu = dao.merge(objeto);
        }
        if (persistiu){
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }
    
    public String cancelar(){
        return "listar";
    }
    
     public void editar(Integer id){
        objeto = (Acessorios) dao.localizar(id);
    }
    
    public void remover(Integer id){
        objeto = (Acessorios) dao.localizar(id);
        if (dao.remover(objeto)){
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }
    

    public AcessoriosDAO getDao() {
        return dao;
    }

    public void setDao(AcessoriosDAO dao) {
        this.dao = dao;
    }

    public Acessorios getObjeto() {
        return objeto;
    }

    public void setObjeto(Acessorios objeto) {
        this.objeto = objeto;
    } 
    
    
}
