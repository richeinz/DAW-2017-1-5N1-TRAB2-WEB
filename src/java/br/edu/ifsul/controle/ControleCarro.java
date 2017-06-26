/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AcessoriosDAO;
import br.edu.ifsul.dao.PessoaDAO;
import br.edu.ifsul.dao.CarroDAO;
import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ricardo
 */
@ManagedBean(name = "controleCarro")
@SessionScoped
public class ControleCarro implements Serializable{
    
    private CarroDAO dao;
    private Carro objeto;
    private PessoaDAO daoPessoa;
    private AcessoriosDAO<Acessorios> daoAcessorios;
    private Acessorios acessorios;
    
     public ControleCarro(){
        dao = new CarroDAO();
        daoPessoa = new PessoaDAO();
        daoAcessorios = new AcessoriosDAO<>();
    }
     
     public void adicionarAcessorio(){
        if(getAcessorios()!= null){
            if(!objeto.getListaAcessorio().contains(acessorios)){
                objeto.getListaAcessorio().add(getAcessorios());
                Util.mensagemInformacao("Acessório adicionado com sucesso");
            }else{
                Util.mensagemErro("Acessorio já existe na lista");
            }
        }
    }
    
    public void removerAcessorio(int index){
        objeto.getListaAcessorio().remove(index);
        Util.mensagemInformacao("Acessorio removido com sucesso");
    }
    
    public String listar(){
        return"/privado/carro/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Carro();
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
        objeto = (Carro) dao.localizar(id);
    }
    
    public void remover(Integer id){
        objeto = (Carro) dao.localizar(id);
        if (dao.remover(objeto)){
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }
    

    public CarroDAO getDao() {
        return dao;
    }

    public void setDao(CarroDAO dao) {
        this.dao = dao;
    }

    public Carro getObjeto() {
        return objeto;
    }

    public void setObjeto(Carro objeto) {
        this.objeto = objeto;
    }

    public PessoaDAO getDaoPessoa() {
        return daoPessoa;
    }

    public void setDaoPessoa(PessoaDAO daoPessoa) {
        this.daoPessoa = daoPessoa;
    }

    public AcessoriosDAO<Acessorios> getDaoAcessorios() {
        return daoAcessorios;
    }

    public void setDaoAcessorios(AcessoriosDAO<Acessorios> daoAcessorios) {
        this.daoAcessorios = daoAcessorios;
    }

    public Acessorios getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(Acessorios acessorios) {
        this.acessorios = acessorios;
    }
    
    
    
}
