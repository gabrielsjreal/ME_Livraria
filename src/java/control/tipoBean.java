
package control;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Tipo;
import model.dao.TipoDAO;

/**
 *
 * @author Gabriel Souza
 */

@Named(value = "tipoBean")
@SessionScoped
public class tipoBean implements Serializable {
    private Tipo tipo = new Tipo();
    private List<Tipo> lista;
    private TipoDAO tipodao = new TipoDAO();
    
    public tipoBean() {
        this.lista = tipodao.listaTipos();     
    }
    
     public String salvarTipo(){
        tipodao.salvar(tipo);
        
        this.lista = tipodao.listaTipos();
        
        tipo = new Tipo();
        
        return "index";
    }
     
      public void excluirTipo(){
        tipodao.remover(tipo.getId(), Tipo.class);
        
        this.lista = tipodao.listaTipos();
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<Tipo> getLista() {
        return lista;
    }

    public void setLista(List<Tipo> lista) {
        this.lista = lista;
    }

    public TipoDAO getTipodao() {
        return tipodao;
    }

    public void setTipodao(TipoDAO tipodao) {
        this.tipodao = tipodao;
    }
      
      
}
