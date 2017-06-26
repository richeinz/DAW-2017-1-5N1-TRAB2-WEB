/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.SeguroDAO;
import br.edu.ifsul.dao.SinistroDAO;
import br.edu.ifsul.modelo.Sinistro;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ricardo
 */
@ManagedBean(name = "controleSinistro")
@SessionScoped
public class ControleSinistro implements Serializable{
    
    private SinistroDAO dao;
    private Sinistro objeto;
    private SeguroDAO daoSeguro;
    
    
     public ControleSinistro(){
        dao = new SinistroDAO();
        daoSeguro = new SeguroDAO();
     }
    
    public String listar(){
        return"/privado/sinistro/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Sinistro();
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
        objeto = (Sinistro) dao.localizar(id);
    }
    
    public void remover(Integer id){
        objeto = (Sinistro) dao.localizar(id);
        if (dao.remover(objeto)){
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }
    

    public SinistroDAO getDao() {
        return dao;
    }

    public void setDao(SinistroDAO dao) {
        this.dao = dao;
    }

    public Sinistro getObjeto() {
        return objeto;
    }

    public void setObjeto(Sinistro objeto) {
        this.objeto = objeto;
    }


    public SeguroDAO getDaoSeguro() {
        return daoSeguro;
    }

    public void setDaoSeguro(SeguroDAO daoSeguro) {
        this.daoSeguro = daoSeguro;
    }

    
    
    
    
}
