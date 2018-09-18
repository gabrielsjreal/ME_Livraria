
package model.dao;

import model.dao.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Livro;
/**
 *
 * @author Gabriel Souza 
 */
public class LivroDAO extends GenericDao<Livro>{
    
    public List<Livro> listaLivros() {
        List<Livro> livros = null;
        EntityManager em = jUtil.getEM();
        Query queryUsr = em.createQuery("select u from Livro u", Livro.class);
        livros = queryUsr.getResultList();
        return livros;
    }
    
}
