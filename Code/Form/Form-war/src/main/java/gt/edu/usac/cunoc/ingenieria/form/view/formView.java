/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.form.view;

import entidades.Columna;
import entidades.DatosGenerales;
import entidades.IdentificacionPuente;
import entidades.Tabla;
import entidades.Tramo;
import fachada.IdentificacionPuenteFachadaLocal;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author daniel
 */
@Named
@ViewScoped
public class formView implements Serializable {

    @EJB
    private IdentificacionPuenteFachadaLocal identificacionPuenteFachadaLocal;

//    @Inject
//    private ExternalContext externalContext;
    private IdentificacionPuente identificacionPuente;
    private DatosGenerales datosGenerales;
    private Tramo tramo1;
    private Tramo tramo2;
    private Tramo tramo3;
    private Tramo tramo4;

    private List<Tabla> listaTablas;

    private Tablas tablas;
    private Tabla tablaEstriboEntrada;
    private Tabla tablaEstriboSalida;

    private Columna columna;

    @PostConstruct
    public void init() {
        identificacionPuente = new IdentificacionPuente();
        datosGenerales = new DatosGenerales();
        tramo1 = new Tramo();
        tramo2 = new Tramo();
        tramo3 = new Tramo();
        tramo4 = new Tramo();
        //datosGenerales.setFechaUltimaEvaluacion(new Date());
        listaTablas = new ArrayList<>();
        tablas = new Tablas();

        listaTablas.add(tablas.getTablaEstriboEntrada());
        listaTablas.add(tablas.getTablaEstriboSalida());

        tablaEstriboEntrada = tablas.getTablaEstriboEntrada();
        tablaEstriboSalida = tablas.getTablaEstriboSalida();

    }

    public void getColumnaEstriboDeEntrada() {

    }

    public void createBridge() {

        try {

            identificacionPuente.setDatosGeneralesidDatosGenerales(datosGenerales);
            List<Tramo> listTramos = new ArrayList<>();
            listTramos.add(tramo1);
            listTramos.add(tramo2);
            listTramos.add(tramo3);
            listTramos.add(tramo4);
            identificacionPuente.setTramoList(listTramos);
            identificacionPuente.setTablaList(listaTablas);
            identificacionPuenteFachadaLocal.createIdentificacion(identificacionPuente);
            addMessage("Se ha guardado la informacion");
        } catch (Exception e) {
            addMessage(e.getMessage());
        }
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public IdentificacionPuente getIdentificacionPuente() {
        return identificacionPuente;
    }

    public void setIdentificacionPuente(IdentificacionPuente identificacionPuente) {
        this.identificacionPuente = identificacionPuente;
    }

    public DatosGenerales getDatosGenerales() {
        return datosGenerales;
    }

    public void setDatosGenerales(DatosGenerales datosGenerales) {
        this.datosGenerales = datosGenerales;
    }

    public Tramo getTramo1() {
        return tramo1;
    }

    public void setTramo1(Tramo tramo1) {
        this.tramo1 = tramo1;
    }

    public Tramo getTramo2() {
        return tramo2;
    }

    public void setTramo2(Tramo tramo2) {
        this.tramo2 = tramo2;
    }

    public Tramo getTramo3() {
        return tramo3;
    }

    public void setTramo3(Tramo tramo3) {
        this.tramo3 = tramo3;
    }

    public Tramo getTramo4() {
        return tramo4;
    }

    public void setTramo4(Tramo tramo4) {
        this.tramo4 = tramo4;
    }

    public Tablas getTablas() {
        return tablas;
    }

    public void setTablas(Tablas tablas) {
        this.tablas = tablas;
    }

    public Tabla getTablaEstriboEntrada() {
        return tablaEstriboEntrada;
    }

    public void setTablaEstriboEntrada(Tabla tablaEstriboEntrada) {
        this.tablaEstriboEntrada = tablaEstriboEntrada;
    }

    public Tabla getTablaEstriboSalida() {
        return tablaEstriboSalida;
    }

    public void setTablaEstriboSalida(Tabla tablaEstriboSalida) {
        this.tablaEstriboSalida = tablaEstriboSalida;
    }

    
    
}
