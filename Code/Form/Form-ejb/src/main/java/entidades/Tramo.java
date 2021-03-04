/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "Tramo")
//@NamedQueries({
//    @NamedQuery(name = "Tramo.findAll", query = "SELECT t FROM Tramo t"),
//    @NamedQuery(name = "Tramo.findByIdTramo", query = "SELECT t FROM Tramo t WHERE t.idTramo = :idTramo"),
//    @NamedQuery(name = "Tramo.findByLongitud", query = "SELECT t FROM Tramo t WHERE t.longitud = :longitud"),
//    @NamedQuery(name = "Tramo.findByTipoSeccion", query = "SELECT t FROM Tramo t WHERE t.tipoSeccion = :tipoSeccion")})
public class Tramo implements Serializable {

//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTramo")
    private Integer idTramo;
    @Column(name = "longitud")
    private Integer longitud;
    @Column(name = "tipoSeccion")
    private String tipoSeccion;
    @JoinColumn(name = "puente", referencedColumnName = "idIdentificacion")
    @ManyToOne
    private IdentificacionPuente puente;

    public Tramo() {
    }

    public Tramo(Integer idTramo) {
        this.idTramo = idTramo;
    }

    public Integer getIdTramo() {
        return idTramo;
    }

    public void setIdTramo(Integer idTramo) {
        this.idTramo = idTramo;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public String getTipoSeccion() {
        return tipoSeccion;
    }

    public void setTipoSeccion(String tipoSeccion) {
        this.tipoSeccion = tipoSeccion;
    }

    public IdentificacionPuente getPuente() {
        return puente;
    }

    public void setPuente(IdentificacionPuente puente) {
        this.puente = puente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTramo != null ? idTramo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramo)) {
            return false;
        }
        Tramo other = (Tramo) object;
        if ((this.idTramo == null && other.idTramo != null) || (this.idTramo != null && !this.idTramo.equals(other.idTramo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tramo[ idTramo=" + idTramo + " ]";
    }
    
}
