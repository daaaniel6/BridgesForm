/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "Fila")
//@NamedQueries({
//    @NamedQuery(name = "Fila.findAll", query = "SELECT f FROM Fila f"),
//    @NamedQuery(name = "Fila.findByIdFila", query = "SELECT f FROM Fila f WHERE f.idFila = :idFila"),
//    @NamedQuery(name = "Fila.findByNombre", query = "SELECT f FROM Fila f WHERE f.nombre = :nombre"),
//    @NamedQuery(name = "Fila.findByComentario", query = "SELECT f FROM Fila f WHERE f.comentario = :comentario")})
public class Fila implements Serializable {

//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFila")
    private Integer idFila;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "tabla", referencedColumnName = "idTabla")
    @ManyToOne
    private Tabla tabla;
    @OneToMany(mappedBy = "fila")
    private List<Columna> columnaList;

    public Fila() {
    }

    public Fila(Integer idFila) {
        this.idFila = idFila;
    }

    public Integer getIdFila() {
        return idFila;
    }

    public void setIdFila(Integer idFila) {
        this.idFila = idFila;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Tabla getTabla() {
        return tabla;
    }

    public void setTabla(Tabla tabla) {
        this.tabla = tabla;
    }

    public List<Columna> getColumnaList() {
        return columnaList;
    }

    public void setColumnaList(List<Columna> columnaList) {
        this.columnaList = columnaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFila != null ? idFila.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fila)) {
            return false;
        }
        Fila other = (Fila) object;
        if ((this.idFila == null && other.idFila != null) || (this.idFila != null && !this.idFila.equals(other.idFila))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Fila[ idFila=" + idFila + " ]";
    }
    
}
