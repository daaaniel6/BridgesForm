/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "Inspector")
//@NamedQueries({
//    @NamedQuery(name = "Inspector.findAll", query = "SELECT i FROM Inspector i"),
//    @NamedQuery(name = "Inspector.findByIdInspector", query = "SELECT i FROM Inspector i WHERE i.idInspector = :idInspector"),
//    @NamedQuery(name = "Inspector.findByNombre", query = "SELECT i FROM Inspector i WHERE i.nombre = :nombre"),
//    @NamedQuery(name = "Inspector.findByTelefono", query = "SELECT i FROM Inspector i WHERE i.telefono = :telefono"),
//    @NamedQuery(name = "Inspector.findByCorreo", query = "SELECT i FROM Inspector i WHERE i.correo = :correo"),
//    @NamedQuery(name = "Inspector.findByFechaInspeccion", query = "SELECT i FROM Inspector i WHERE i.fechaInspeccion = :fechaInspeccion")})
public class Inspector implements Serializable {

//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInspector")
    private Integer idInspector;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo")
    private String correo;
    @Column(name = "fechaInspeccion")
    @Temporal(TemporalType.DATE)
    private Date fechaInspeccion;
    @JoinColumn(name = "puente", referencedColumnName = "idIdentificacion")
    @ManyToOne
    private IdentificacionPuente puente;

    public Inspector() {
    }

    public Inspector(Integer idInspector) {
        this.idInspector = idInspector;
    }

    public Integer getIdInspector() {
        return idInspector;
    }

    public void setIdInspector(Integer idInspector) {
        this.idInspector = idInspector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaInspeccion() {
        return fechaInspeccion;
    }

    public void setFechaInspeccion(Date fechaInspeccion) {
        this.fechaInspeccion = fechaInspeccion;
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
        hash += (idInspector != null ? idInspector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inspector)) {
            return false;
        }
        Inspector other = (Inspector) object;
        if ((this.idInspector == null && other.idInspector != null) || (this.idInspector != null && !this.idInspector.equals(other.idInspector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Inspector[ idInspector=" + idInspector + " ]";
    }
    
}
