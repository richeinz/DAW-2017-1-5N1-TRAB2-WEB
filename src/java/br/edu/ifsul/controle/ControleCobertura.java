/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.SeguroDAO;
import br.edu.ifsul.dao.CoberturaDAO;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ricardo
 */
@ManagedBean(name = "controleCobertura")
@SessionScoped
public class ControleCobertura implements Serializable{
    
    private CoberturaDAO dao;
    private Cobertura objeto;
    private SeguroDAO daoSeguro;
    
    
     public ControleCobertura(){
        dao = new CoberturaDAO();
        daoSeguro = new SeguroDAO();
     }
    
    public String listar(){
        return"/privado/cobertura/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Cobertura();
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
    
    public void editar(Integer id){
        objeto = (Cobertura) dao.localizar(id);
    }
    
    public void remover(Integer id){
        objeto = (Cobertura) dao.localizar(id);
        if (dao.remover(objeto)){
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }
    

    public CoberturaDAO getDao() {
        return dao;
    }

    public void setDao(CoberturaDAO dao) {
        this.dao = dao;
    }

    public Cobertura getObjeto() {
        return objeto;
    }

    public void setObjeto(Cobertura objeto) {
        this.objeto = objeto;
    }


    public SeguroDAO getDaoSeguro() {
        return daoSeguro;
    }

    public void setDaoSeguro(SeguroDAO daoSeguro) {
        this.daoSeguro = daoSeguro;
    }

    
    
    
    
}
