
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Tipo;

/**
 *
 * @author Gabriel Souza
 */
public class TipoDAO extends GenericDao<Tipo>{
    
     public List<Tipo> listaTipos() {
        List<Tipo> tipos = null;
        EntityManager em = jUtil.getEM();
        Query queryUsr = em.createQuery("select u from Tipo u", Tipo.class);
        tipos = queryUsr.getResultList();
        return tipos;
    }
}
