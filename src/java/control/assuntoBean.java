/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Assunto;
import model.dao.AssuntoDAO;

/**
 *
 * @author Gabriel Souza
 */
@Named(value = "assuntoBean")
@SessionScoped
public class assuntoBean implements Serializable {
    private Assunto assunto = new Assunto();
    private List<Assunto> lista;
    private AssuntoDAO assuntodao = new AssuntoDAO();
    
      public assuntoBean() {
        this.lista = assuntodao.listaAssuntos();     
    }
    
    public String salvarAssunto(){
        assuntodao.salvar(assunto);
        
        this.lista = assuntodao.listaAssuntos();
        
        assunto = new Assunto();
        
        return "index";
    }
    
    public void excluirAssunto(){
        assuntodao.remover(assunto.getId(), Assunto.class);
        
        this.lista = assuntodao.listaAssuntos();
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    public List<Assunto> getLista() {
        return lista;
    }

    public void setLista(List<Assunto> lista) {
        this.lista = lista;
    }

    public AssuntoDAO getAssuntodao() {
        return assuntodao;
    }

    public void setAssuntodao(AssuntoDAO assuntodao) {
        this.assuntodao = assuntodao;
    }
    
    
}
