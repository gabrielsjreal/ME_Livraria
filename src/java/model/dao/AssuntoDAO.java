/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Assunto;


/**
 *
 * @author Gabriel Souza
 */
public class AssuntoDAO extends GenericDao<Assunto>{
    
      public List<Assunto> listaAssuntos() {
        List<Assunto> assuntos = null;
        EntityManager em = jUtil.getEM();
        Query queryUsr = em.createQuery("select u from Assunto u", Assunto.class);
        assuntos = queryUsr.getResultList();
        return assuntos;
    }
    
}
