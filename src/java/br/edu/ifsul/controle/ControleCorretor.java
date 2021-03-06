/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CorretorDAO;
import br.edu.ifsul.dao.PessoaDAO;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ricardo
 */
@ManagedBean(name = "controleCorretor")
@SessionScoped
public class ControleCorretor implements Serializable{
    
    private CorretorDAO dao;
    private Corretor objeto;
    private PessoaDAO daoPessoa;

    
    
     public ControleCorretor(){
        dao = new CorretorDAO();
        daoPessoa = new PessoaDAO();
    }
    
    public String listar(){
        return"/privado/corretor/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Corretor();
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
        objeto = (Corretor) dao.localizar(id);
    }
    
    public void remover(Integer id){
        objeto = (Corretor) dao.localizar(id);
        if (dao.remover(objeto)){
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }
    

    public CorretorDAO getDao() {
        return dao;
    }

    public void setDao(CorretorDAO dao) {
        this.dao = dao;
    }

    public Corretor getObjeto() {
        return objeto;
    }

    public void setObjeto(Corretor objeto) {
        this.objeto = objeto;
    }

    public PessoaDAO getDaoPessoa() {
        return daoPessoa;
    }

    public void setDaoPessoa(PessoaDAO daoPessoa) {
        this.daoPessoa = daoPessoa;
    }
    
    
    
}
