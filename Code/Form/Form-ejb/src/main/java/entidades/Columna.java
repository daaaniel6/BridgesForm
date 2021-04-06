/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "Columna")
//@NamedQueries({
//    @NamedQuery(name = "Columna.findAll", query = "SELECT c FROM Columna c"),
//    @NamedQuery(name = "Columna.findByIdColumna", query = "SELECT c FROM Columna c WHERE c.idColumna = :idColumna"),
//    @NamedQuery(name = "Columna.findByNombre", query = "SELECT c FROM Columna c WHERE c.nombre = :nombre"),
//    @NamedQuery(name = "Columna.findByAtributo", query = "SELECT c FROM Columna c WHERE c.atributo = :atributo"),
//    @NamedQuery(name = "Columna.findByComentario", query = "SELECT c FROM Columna c WHERE c.comentario = :comentario")})
public class Columna implements Serializable {

//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idColumna")
    private Integer idColumna;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "atributo")
    private String atributo;
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "fila", referencedColumnName = "idFila")
    @ManyToOne(optional = false)
    private Fila fila;

    public Columna() {
    }

    public Columna(Integer idColumna) {
        this.idColumna = idColumna;
    }

    public Integer getIdColumna() {
        return idColumna;
    }

    public void setIdColumna(Integer idColumna) {
        this.idColumna = idColumna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColumna != null ? idColumna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Columna)) {
            return false;
        }
        Columna other = (Columna) object;
        if ((this.idColumna == null && other.idColumna != null) || (this.idColumna != null && !this.idColumna.equals(other.idColumna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Columna[ idColumna=" + idColumna + " ]";
    }
    
}
