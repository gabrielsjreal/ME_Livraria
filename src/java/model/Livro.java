/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import model.dao.entidades.EntityBase;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "livro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l")
    , @NamedQuery(name = "Livro.findById", query = "SELECT l FROM Livro l WHERE l.id = :id")
    , @NamedQuery(name = "Livro.findByTitulo", query = "SELECT l FROM Livro l WHERE l.titulo = :titulo")
    , @NamedQuery(name = "Livro.findByAutores", query = "SELECT l FROM Livro l WHERE l.autores = :autores")
    , @NamedQuery(name = "Livro.findByAno", query = "SELECT l FROM Livro l WHERE l.ano = :ano")
    , @NamedQuery(name = "Livro.findByCidade", query = "SELECT l FROM Livro l WHERE l.cidade = :cidade")
    , @NamedQuery(name = "Livro.findByResumo", query = "SELECT l FROM Livro l WHERE l.resumo = :resumo")})
public class Livro implements EntityBase {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "autores")
    private String autores;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    @Temporal(TemporalType.DATE)
    private Date ano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "resumo")
    private String resumo;
    @JoinColumn(name = "tipo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipo tipoId;
    @JoinColumn(name = "assunto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Assunto assuntoId;

    public Livro() {
    }

    public Livro(Long id) {
        this.id = id;
    }

    public Livro(Long id, String titulo, String autores, Date ano, String cidade, String resumo) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.ano = ano;
        this.cidade = cidade;
        this.resumo = resumo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Tipo getTipoId() {
        return tipoId;
    }

    public void setTipoId(Tipo tipoId) {
        this.tipoId = tipoId;
    }

    public Assunto getAssuntoId() {
        return assuntoId;
    }

    public void setAssuntoId(Assunto assuntoId) {
        this.assuntoId = assuntoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Livro[ id=" + id + " ]";
    }
    
}
