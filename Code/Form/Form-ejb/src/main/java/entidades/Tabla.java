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
@Table(name = "Tabla")
//@NamedQueries({
//    @NamedQuery(name = "Tabla.findAll", query = "SELECT t FROM Tabla t"),
//    @NamedQuery(name = "Tabla.findByIdTabla", query = "SELECT t FROM Tabla t WHERE t.idTabla = :idTabla"),
//    @NamedQuery(name = "Tabla.findByNombre", query = "SELECT t FROM Tabla t WHERE t.nombre = :nombre"),
//    @NamedQuery(name = "Tabla.findByComentario", query = "SELECT t FROM Tabla t WHERE t.comentario = :comentario")})
public class Tabla implements Serializable {

//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTabla")
    private Integer idTabla;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "puente", referencedColumnName = "idIdentificacion")
    @ManyToOne
    private IdentificacionPuente puente;
    @OneToMany(mappedBy = "tabla")
    private List<Fila> filaList;

    public Tabla() {
    }

    public Tabla(Integer idTabla) {
        this.idTabla = idTabla;
    }

    public Integer getIdTabla() {
        return idTabla;
    }

    public void setIdTabla(Integer idTabla) {
        this.idTabla = idTabla;
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

    public IdentificacionPuente getPuente() {
        return puente;
    }

    public void setPuente(IdentificacionPuente puente) {
        this.puente = puente;
    }

    public List<Fila> getFilaList() {
        return filaList;
    }

    public void setFilaList(List<Fila> filaList) {
        this.filaList = filaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTabla != null ? idTabla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabla)) {
            return false;
        }
        Tabla other = (Tabla) object;
        if ((this.idTabla == null && other.idTabla != null) || (this.idTabla != null && !this.idTabla.equals(other.idTabla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tabla[ idTabla=" + idTabla + " ]";
    }
    
}
