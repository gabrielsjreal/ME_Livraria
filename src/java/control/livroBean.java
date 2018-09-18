
package control;


import java.io.Serializable;
import model.dao.*;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Assunto;
import model.Livro;
import model.Tipo;


/**
 *
 * @author Gabriel Souza
 */
@Named(value = "livroBean")
@SessionScoped
public class livroBean implements Serializable {
    
     private Livro livro = new Livro();
     private Tipo tipo = new Tipo();
     private Assunto assunto = new Assunto();
    private List<Livro> lista;
    private LivroDAO livrodao = new LivroDAO();
    
      public livroBean() {
        this.lista = livrodao.listaLivros();     
    }
    
    public String salvarLivro(){
        livro.setTipoId(tipo);
        livro.setAssuntoId(assunto);
        livrodao.salvar(livro);
        
        this.lista = livrodao.listaLivros();
        
        livro = new Livro();
        
        return "index";
    }
    
    public void excluirLivro(){
        livrodao.remover(livro.getId(), Livro.class);
        
        this.lista = livrodao.listaLivros();
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Livro> getLista() {
        return lista;
    }

    public void setLista(List<Livro> lista) {
        this.lista = lista;
    }

    public LivroDAO getLivrodao() {
        return livrodao;
    }

    public void setLivrodao(LivroDAO livrodao) {
        this.livrodao = livrodao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }
    
    
}
