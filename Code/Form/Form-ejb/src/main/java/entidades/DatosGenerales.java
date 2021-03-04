/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "DatosGenerales")
//@NamedQueries({
//    @NamedQuery(name = "DatosGenerales.findAll", query = "SELECT d FROM DatosGenerales d"),
//    @NamedQuery(name = "DatosGenerales.findByIdDatosGenerales", query = "SELECT d FROM DatosGenerales d WHERE d.idDatosGenerales = :idDatosGenerales"),
//    @NamedQuery(name = "DatosGenerales.findByLongitud", query = "SELECT d FROM DatosGenerales d WHERE d.longitud = :longitud"),
//    @NamedQuery(name = "DatosGenerales.findByNumeroTramos", query = "SELECT d FROM DatosGenerales d WHERE d.numeroTramos = :numeroTramos"),
//    @NamedQuery(name = "DatosGenerales.findByAnchoRodadura", query = "SELECT d FROM DatosGenerales d WHERE d.anchoRodadura = :anchoRodadura"),
//    @NamedQuery(name = "DatosGenerales.findByAnchoAceraDer", query = "SELECT d FROM DatosGenerales d WHERE d.anchoAceraDer = :anchoAceraDer"),
//    @NamedQuery(name = "DatosGenerales.findByAnchoAceraIzq", query = "SELECT d FROM DatosGenerales d WHERE d.anchoAceraIzq = :anchoAceraIzq"),
//    @NamedQuery(name = "DatosGenerales.findByTipologiaPuente", query = "SELECT d FROM DatosGenerales d WHERE d.tipologiaPuente = :tipologiaPuente"),
//    @NamedQuery(name = "DatosGenerales.findByAlturaLibreSuperior", query = "SELECT d FROM DatosGenerales d WHERE d.alturaLibreSuperior = :alturaLibreSuperior"),
//    @NamedQuery(name = "DatosGenerales.findByAlturaLibreSobreRio", query = "SELECT d FROM DatosGenerales d WHERE d.alturaLibreSobreRio = :alturaLibreSobreRio"),
//    @NamedQuery(name = "DatosGenerales.findByPuenteSobre", query = "SELECT d FROM DatosGenerales d WHERE d.puenteSobre = :puenteSobre"),
//    @NamedQuery(name = "DatosGenerales.findByNumeroVias", query = "SELECT d FROM DatosGenerales d WHERE d.numeroVias = :numeroVias"),
//    @NamedQuery(name = "DatosGenerales.findByMaterialSuperestructura", query = "SELECT d FROM DatosGenerales d WHERE d.materialSuperestructura = :materialSuperestructura"),
//    @NamedQuery(name = "DatosGenerales.findByCargaDisenio", query = "SELECT d FROM DatosGenerales d WHERE d.cargaDisenio = :cargaDisenio"),
//    @NamedQuery(name = "DatosGenerales.findByAnioConstruccion", query = "SELECT d FROM DatosGenerales d WHERE d.anioConstruccion = :anioConstruccion"),
//    @NamedQuery(name = "DatosGenerales.findByMaterialSubestructura", query = "SELECT d FROM DatosGenerales d WHERE d.materialSubestructura = :materialSubestructura"),
//    @NamedQuery(name = "DatosGenerales.findByTrafico", query = "SELECT d FROM DatosGenerales d WHERE d.trafico = :trafico"),
//    @NamedQuery(name = "DatosGenerales.findByPorcentajeCamionesBuses", query = "SELECT d FROM DatosGenerales d WHERE d.porcentajeCamionesBuses = :porcentajeCamionesBuses"),
//    @NamedQuery(name = "DatosGenerales.findByFechaUltimaEvaluacion", query = "SELECT d FROM DatosGenerales d WHERE d.fechaUltimaEvaluacion = :fechaUltimaEvaluacion")})
public class DatosGenerales implements Serializable {

//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDatosGenerales")
    private Integer idDatosGenerales;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "longitud")
    private Double longitud;
    @Column(name = "numeroTramos")
    private Integer numeroTramos;
    @Column(name = "anchoRodadura")
    private Double anchoRodadura;
    @Column(name = "anchoAceraDer")
    private Double anchoAceraDer;
    @Column(name = "anchoAceraIzq")
    private Double anchoAceraIzq;
    @Column(name = "tipologiaPuente")
    private String tipologiaPuente;
    @Column(name = "alturaLibreSuperior")
    private Double alturaLibreSuperior;
    @Column(name = "alturaLibreSobreRio")
    private Double alturaLibreSobreRio;
    @Column(name = "puenteSobre")
    private String puenteSobre;
    @Column(name = "numeroVias")
    private Integer numeroVias;
    @Column(name = "materialSuperestructura")
    private String materialSuperestructura;
    @Column(name = "cargaDisenio")
    private String cargaDisenio;
    @Column(name = "anioConstruccion")
    private Integer anioConstruccion;
    @Column(name = "materialSubestructura")
    private String materialSubestructura;
    @Column(name = "trafico")
    private Double trafico;
    @Column(name = "porcentajeCamionesBuses")
    private Double porcentajeCamionesBuses;
    @Column(name = "fechaUltimaEvaluacion")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaEvaluacion;
    @OneToMany(mappedBy = "datosGeneralesidDatosGenerales")
    private List<IdentificacionPuente> identificacionPuenteList;

    public DatosGenerales() {
    }

    public DatosGenerales(Integer idDatosGenerales) {
        this.idDatosGenerales = idDatosGenerales;
    }

    public Integer getIdDatosGenerales() {
        return idDatosGenerales;
    }

    public void setIdDatosGenerales(Integer idDatosGenerales) {
        this.idDatosGenerales = idDatosGenerales;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Integer getNumeroTramos() {
        return numeroTramos;
    }

    public void setNumeroTramos(Integer numeroTramos) {
        this.numeroTramos = numeroTramos;
    }

    public Double getAnchoRodadura() {
        return anchoRodadura;
    }

    public void setAnchoRodadura(Double anchoRodadura) {
        this.anchoRodadura = anchoRodadura;
    }

    public Double getAnchoAceraDer() {
        return anchoAceraDer;
    }

    public void setAnchoAceraDer(Double anchoAceraDer) {
        this.anchoAceraDer = anchoAceraDer;
    }

    public Double getAnchoAceraIzq() {
        return anchoAceraIzq;
    }

    public void setAnchoAceraIzq(Double anchoAceraIzq) {
        this.anchoAceraIzq = anchoAceraIzq;
    }

    public String getTipologiaPuente() {
        return tipologiaPuente;
    }

    public void setTipologiaPuente(String tipologiaPuente) {
        this.tipologiaPuente = tipologiaPuente;
    }

    public Double getAlturaLibreSuperior() {
        return alturaLibreSuperior;
    }

    public void setAlturaLibreSuperior(Double alturaLibreSuperior) {
        this.alturaLibreSuperior = alturaLibreSuperior;
    }

    public Double getAlturaLibreSobreRio() {
        return alturaLibreSobreRio;
    }

    public void setAlturaLibreSobreRio(Double alturaLibreSobreRio) {
        this.alturaLibreSobreRio = alturaLibreSobreRio;
    }

    public String getPuenteSobre() {
        return puenteSobre;
    }

    public void setPuenteSobre(String puenteSobre) {
        this.puenteSobre = puenteSobre;
    }

    public Integer getNumeroVias() {
        return numeroVias;
    }

    public void setNumeroVias(Integer numeroVias) {
        this.numeroVias = numeroVias;
    }

    public String getMaterialSuperestructura() {
        return materialSuperestructura;
    }

    public void setMaterialSuperestructura(String materialSuperestructura) {
        this.materialSuperestructura = materialSuperestructura;
    }

    public String getCargaDisenio() {
        return cargaDisenio;
    }

    public void setCargaDisenio(String cargaDisenio) {
        this.cargaDisenio = cargaDisenio;
    }

    public Integer getAnioConstruccion() {
        return anioConstruccion;
    }

    public void setAnioConstruccion(Integer anioConstruccion) {
        this.anioConstruccion = anioConstruccion;
    }

    public String getMaterialSubestructura() {
        return materialSubestructura;
    }

    public void setMaterialSubestructura(String materialSubestructura) {
        this.materialSubestructura = materialSubestructura;
    }

    public Double getTrafico() {
        return trafico;
    }

    public void setTrafico(Double trafico) {
        this.trafico = trafico;
    }

    public Double getPorcentajeCamionesBuses() {
        return porcentajeCamionesBuses;
    }

    public void setPorcentajeCamionesBuses(Double porcentajeCamionesBuses) {
        this.porcentajeCamionesBuses = porcentajeCamionesBuses;
    }

    public Date getFechaUltimaEvaluacion() {
        return fechaUltimaEvaluacion;
    }

    public void setFechaUltimaEvaluacion(Date fechaUltimaEvaluacion) {
        this.fechaUltimaEvaluacion = fechaUltimaEvaluacion;
    }

    public List<IdentificacionPuente> getIdentificacionPuenteList() {
        return identificacionPuenteList;
    }

    public void setIdentificacionPuenteList(List<IdentificacionPuente> identificacionPuenteList) {
        this.identificacionPuenteList = identificacionPuenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDatosGenerales != null ? idDatosGenerales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosGenerales)) {
            return false;
        }
        DatosGenerales other = (DatosGenerales) object;
        if ((this.idDatosGenerales == null && other.idDatosGenerales != null) || (this.idDatosGenerales != null && !this.idDatosGenerales.equals(other.idDatosGenerales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DatosGenerales[ idDatosGenerales=" + idDatosGenerales + " ]";
    }
    
}
