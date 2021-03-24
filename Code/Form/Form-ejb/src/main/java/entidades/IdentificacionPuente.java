/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "IdentificacionPuente")
//@NamedQueries({
//    @NamedQuery(name = "IdentificacionPuente.findAll", query = "SELECT i FROM IdentificacionPuente i"),
//    @NamedQuery(name = "IdentificacionPuente.findByIdIdentificacion", query = "SELECT i FROM IdentificacionPuente i WHERE i.idIdentificacion = :idIdentificacion"),
//    @NamedQuery(name = "IdentificacionPuente.findByNombre", query = "SELECT i FROM IdentificacionPuente i WHERE i.nombre = :nombre"),
//    @NamedQuery(name = "IdentificacionPuente.findByCodigo", query = "SELECT i FROM IdentificacionPuente i WHERE i.codigo = :codigo"),
//    @NamedQuery(name = "IdentificacionPuente.findByRuta", query = "SELECT i FROM IdentificacionPuente i WHERE i.ruta = :ruta"),
//    @NamedQuery(name = "IdentificacionPuente.findByKilometraje", query = "SELECT i FROM IdentificacionPuente i WHERE i.kilometraje = :kilometraje"),
//    @NamedQuery(name = "IdentificacionPuente.findByDepartamento", query = "SELECT i FROM IdentificacionPuente i WHERE i.departamento = :departamento"),
//    @NamedQuery(name = "IdentificacionPuente.findByMunicipio", query = "SELECT i FROM IdentificacionPuente i WHERE i.municipio = :municipio"),
//    @NamedQuery(name = "IdentificacionPuente.findByRutaPavimentada", query = "SELECT i FROM IdentificacionPuente i WHERE i.rutaPavimentada = :rutaPavimentada"),
//    @NamedQuery(name = "IdentificacionPuente.findByAlineamientoHorizontal", query = "SELECT i FROM IdentificacionPuente i WHERE i.alineamientoHorizontal = :alineamientoHorizontal"),
//    @NamedQuery(name = "IdentificacionPuente.findByEsviaje", query = "SELECT i FROM IdentificacionPuente i WHERE i.esviaje = :esviaje"),
//    @NamedQuery(name = "IdentificacionPuente.findByCoordenadasUtmN", query = "SELECT i FROM IdentificacionPuente i WHERE i.coordenadasUtmN = :coordenadasUtmN"),
//    @NamedQuery(name = "IdentificacionPuente.findByCoordenadasUtmE", query = "SELECT i FROM IdentificacionPuente i WHERE i.coordenadasUtmE = :coordenadasUtmE"),
//    @NamedQuery(name = "IdentificacionPuente.findByPoblacionAntes", query = "SELECT i FROM IdentificacionPuente i WHERE i.poblacionAntes = :poblacionAntes"),
//    @NamedQuery(name = "IdentificacionPuente.findByPoblacionDespues", query = "SELECT i FROM IdentificacionPuente i WHERE i.poblacionDespues = :poblacionDespues")})
public class IdentificacionPuente implements Serializable {

//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIdentificacion")
    private Integer idIdentificacion;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "ruta")
    private String ruta;
    @Column(name = "kilometraje")
    private String kilometraje;
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "rutaPavimentada")
    private String rutaPavimentada;
    @Column(name = "alineamientoHorizontal")
    private String alineamientoHorizontal;
    @Column(name = "esviaje")
    private String esviaje;
    @Column(name = "coordenadasUtmN")
    private String coordenadasUtmN;
    @Column(name = "coordenadasUtmE")
    private String coordenadasUtmE;
    @Column(name = "poblacionAntes")
    private String poblacionAntes;
    @Column(name = "poblacionDespues")
    private String poblacionDespues;
    @OneToMany(mappedBy = "puente",cascade = CascadeType.ALL)
    private List<Tramo> tramoList;
    @JoinColumn(name = "DatosGenerales_idDatosGenerales", referencedColumnName = "idDatosGenerales")
    @ManyToOne(cascade = CascadeType.ALL)
    private DatosGenerales datosGeneralesidDatosGenerales;
    @OneToMany(mappedBy = "puente")
    private List<Tabla> tablaList;
    @OneToMany(mappedBy = "puente")
    private List<Inspector> inspectorList;
    @OneToMany(mappedBy = "puente")
    private List<Imagen> imagenList;

    public IdentificacionPuente() {
    }

    public IdentificacionPuente(Integer idIdentificacion) {
        this.idIdentificacion = idIdentificacion;
    }

    public Integer getIdIdentificacion() {
        return idIdentificacion;
    }

    public void setIdIdentificacion(Integer idIdentificacion) {
        this.idIdentificacion = idIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getRutaPavimentada() {
        return rutaPavimentada;
    }

    public void setRutaPavimentada(String rutaPavimentada) {
        this.rutaPavimentada = rutaPavimentada;
    }

    public String getAlineamientoHorizontal() {
        return alineamientoHorizontal;
    }

    public void setAlineamientoHorizontal(String alineamientoHorizontal) {
        this.alineamientoHorizontal = alineamientoHorizontal;
    }

    public String getEsviaje() {
        return esviaje;
    }

    public void setEsviaje(String esviaje) {
        this.esviaje = esviaje;
    }

    public String getCoordenadasUtmN() {
        return coordenadasUtmN;
    }

    public void setCoordenadasUtmN(String coordenadasUtmN) {
        this.coordenadasUtmN = coordenadasUtmN;
    }

    public String getCoordenadasUtmE() {
        return coordenadasUtmE;
    }

    public void setCoordenadasUtmE(String coordenadasUtmE) {
        this.coordenadasUtmE = coordenadasUtmE;
    }

    public String getPoblacionAntes() {
        return poblacionAntes;
    }

    public void setPoblacionAntes(String poblacionAntes) {
        this.poblacionAntes = poblacionAntes;
    }

    public String getPoblacionDespues() {
        return poblacionDespues;
    }

    public void setPoblacionDespues(String poblacionDespues) {
        this.poblacionDespues = poblacionDespues;
    }

    public List<Tramo> getTramoList() {
        return tramoList;
    }

    public void setTramoList(List<Tramo> tramoList) {
        this.tramoList = tramoList;
    }

    public DatosGenerales getDatosGeneralesidDatosGenerales() {
        return datosGeneralesidDatosGenerales;
    }

    public void setDatosGeneralesidDatosGenerales(DatosGenerales datosGeneralesidDatosGenerales) {
        this.datosGeneralesidDatosGenerales = datosGeneralesidDatosGenerales;
    }

    public List<Tabla> getTablaList() {
        return tablaList;
    }

    public void setTablaList(List<Tabla> tablaList) {
        this.tablaList = tablaList;
    }

    public List<Inspector> getInspectorList() {
        return inspectorList;
    }

    public void setInspectorList(List<Inspector> inspectorList) {
        this.inspectorList = inspectorList;
    }

    public List<Imagen> getImagenList() {
        return imagenList;
    }

    public void setImagenList(List<Imagen> imagenList) {
        this.imagenList = imagenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIdentificacion != null ? idIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentificacionPuente)) {
            return false;
        }
        IdentificacionPuente other = (IdentificacionPuente) object;
        if ((this.idIdentificacion == null && other.idIdentificacion != null) || (this.idIdentificacion != null && !this.idIdentificacion.equals(other.idIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.IdentificacionPuente[ idIdentificacion=" + idIdentificacion + " ]";
    }
    
}
