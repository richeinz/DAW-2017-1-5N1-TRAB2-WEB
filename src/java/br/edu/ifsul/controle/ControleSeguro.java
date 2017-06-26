/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CarroDAO;
import br.edu.ifsul.dao.CoberturaDAO;
import br.edu.ifsul.dao.CorretorDAO;
import br.edu.ifsul.dao.SeguroDAO;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Seguro;
import br.edu.ifsul.util.Util;
import br.edu.ifsul.util.UtilRelatorios;
import java.io.Serializable;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ricardo
 */
@ManagedBean(name = "controleSeguro")
@SessionScoped
public class ControleSeguro implements Serializable {

    private SeguroDAO dao;
    private Seguro objeto;
    private CorretorDAO daoCorretor;
    private CarroDAO daoCarro;
    private CoberturaDAO daoCobertura;
    private Cobertura cobertura;
    private boolean novaCobertura;

    public ControleSeguro() {
        dao = new SeguroDAO();
        daoCorretor = new CorretorDAO();
        daoCarro = new CarroDAO();
        daoCobertura = new CoberturaDAO();
    }
    
    public void novaCobertura(){
        setCobertura(new Cobertura());
        novaCobertura = true;
    }
    
    public void alterarCobertura(int index) {
        setCobertura(objeto.getCoberturas().get(index));
        novaCobertura = false;
    }

    public void salvarCobertura() {
        if (novaCobertura) {
            objeto.adicionarCobretura(getCobertura());
        } else {
        }
        Util.mensagemInformacao("Operação realizada com sucesso");
    }
    
    public void removerCobertura(int index) {
        objeto.removerCobertura(index);
        Util.mensagemInformacao("Cobertura removido com sucesso");
    }
    
    public void relatorio(){
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("TesteSeguros", parametros, dao.getListaTodos());
    }

    public String listar() {
        return "/privado/seguro/listar?faces-redirect=true";
    }

    public String novo() {
        objeto = new Seguro();
        return "formulario";
    }

    public void salvar() {
        boolean persistiu;
        if (objeto.getId() == null) {
            persistiu = dao.persist(objeto);
        } else {
            persistiu = dao.merge(objeto);
        }
        if (persistiu) {
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }

    public void editar(Integer id) {
        objeto = (Seguro) dao.localizar(id);
    }

    public void remover(Integer id) {
        objeto = (Seguro) dao.localizar(id);
        if (dao.remover(objeto)) {
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }

    public SeguroDAO getDao() {
        return dao;
    }

    public void setDao(SeguroDAO dao) {
        this.dao = dao;
    }

    public Seguro getObjeto() {
        return objeto;
    }

    public void setObjeto(Seguro objeto) {
        this.objeto = objeto;
    }

    public CorretorDAO getDaoCorretor() {
        return daoCorretor;
    }

    public void setDaoCorretor(CorretorDAO daoCorretor) {
        this.daoCorretor = daoCorretor;
    }

    public CarroDAO getDaoCarro() {
        return daoCarro;
    }

    public void setDaoCarro(CarroDAO daoCarro) {
        this.daoCarro = daoCarro;
    }

    public CoberturaDAO getDaoCobertura() {
        return daoCobertura;
    }

    public void setDaoCobertura(CoberturaDAO daoCobertura) {
        this.daoCobertura = daoCobertura;
    }

    public Cobertura getCobertura() {
        return cobertura;
    }

    public void setCobertura(Cobertura cobertura) {
        this.cobertura = cobertura;
    }

}
