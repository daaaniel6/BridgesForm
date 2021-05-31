/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.form.view;

import entidades.Columna;
import entidades.DatosGenerales;
import entidades.IdentificacionPuente;
import entidades.Imagen;
import entidades.Inspector;
import entidades.Tabla;
import entidades.Tramo;
import fachada.IdentificacionPuenteFachadaLocal;
import java.awt.Image;
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
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

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
    private Tabla tablaPilas;
    private Tabla tablaSuperEstructura;
    private Tabla tablaElementosNoEstructurales;
    private Tabla tablaCarecteristicasDelCauce;
    private Tabla tablaOtros;

    
    
    private Inspector inspector;
    private List<Inspector> inspectores;

    private Imagen imageBridge;
    private List<Imagen> listaImagenes;

    private UploadedFile image;
    private StreamedContent imageStream;
    String nameImage = "";

    @PostConstruct
    public void init() {
        identificacionPuente = new IdentificacionPuente();
        datosGenerales = new DatosGenerales();
        tramo1 = new Tramo();
        tramo1.setPuente(identificacionPuente);
        tramo2 = new Tramo();
        tramo2.setPuente(identificacionPuente);
        tramo3 = new Tramo();
        tramo3.setPuente(identificacionPuente);
        tramo4 = new Tramo();
        tramo4.setPuente(identificacionPuente);
        listaTablas = new ArrayList<>();
        tablas = new Tablas();

        tablaEstriboEntrada = tablas.getTablaEstriboEntrada();
        tablaEstriboSalida = tablas.getTablaEstriboSalida();
        tablaPilas = tablas.getTablaPilas();
        tablaSuperEstructura = tablas.getTablaSuperEstructura();
        tablaElementosNoEstructurales = tablas.getTablaElementosNoEstructurales();
        tablaCarecteristicasDelCauce = tablas.getTablaCarecteristicasDelCauce();
        tablaOtros = tablas.getTablaOtros();

        listaTablas.add(tablas.getTablaEstriboEntrada());
        listaTablas.add(tablas.getTablaEstriboSalida());
        listaTablas.add(tablas.getTablaPilas());
        listaTablas.add(tablas.getTablaSuperEstructura());
        listaTablas.add(tablas.getTablaElementosNoEstructurales());
        listaTablas.add(tablas.getTablaCarecteristicasDelCauce());
        listaTablas.add(tablas.getTablaOtros());

        imageBridge = new Imagen();
        listaImagenes = new ArrayList<>();
        
        
        inspector = new Inspector();
        inspector.setPuente(identificacionPuente);
        inspectores = new ArrayList<>();
        inspectores.add(inspector);
        LlavesTablas(listaTablas);
        
    }

    public void createBridge() {

        try {
            LlavesTablas(listaTablas);
            identificacionPuente.setDatosGeneralesidDatosGenerales(datosGenerales);
            List<Tramo> listTramos = new ArrayList<>();
            listTramos.add(tramo1);
            listTramos.add(tramo2);
            listTramos.add(tramo3);
            listTramos.add(tramo4);
            identificacionPuente.setTramoList(listTramos);
            identificacionPuente.setTablaList(listaTablas);
            LlavesTablas(listaTablas);
            for (int i = 0; i < listaTablas.size(); i++) {
                listaTablas.get(i).setPuente(identificacionPuente);
            }

            if (image != null) {
                //getContents Devuelve el arreglo de bytes
                imageBridge.setImagen(image.getContents());
                imageBridge.setComentario(nameImage);
                imageBridge.setPuente(identificacionPuente);
                listaImagenes.add(imageBridge);
                identificacionPuente.setImagenList(listaImagenes);

            } else {
                //MessageUtils.addErrorMessage(ERROR_PICTURE);
            }
            
            identificacionPuente.setInspectorList(inspectores);
            identificacionPuenteFachadaLocal.createIdentificacion(identificacionPuente);
            addMessage("Se ha guardado la informacion");
        } catch (Exception e) {
            addMessage(e.getMessage());
            System.out.println(e);
        }

    }

    public void LlavesTablas(List<Tabla> listaTablas){
        for (int i = 0; i < listaTablas.size(); i++) {
            listaTablas.get(i).setPuente(identificacionPuente);
            for (int j = 0; j < listaTablas.get(i).getFilaList().size(); j++) {
                listaTablas.get(i).getFilaList().get(j).setTabla(listaTablas.get(i));
                for (int k = 0; k < listaTablas.get(i).getFilaList().get(j).getColumnaList().size(); k++) {
                    listaTablas.get(i).getFilaList().get(j).getColumnaList().get(k).setFila(listaTablas.get(i).getFilaList().get(j));
                }
            }
        }
    }
    
    public void handleImage(FileUploadEvent event) {
        image = event.getFile();
        nameImage = event.getFile().getFileName();
    }

//    public void upload() {
//        if (image != null) {
//            FacesMessage message = new FacesMessage("Successful", image.getFileName() + " is uploaded.");
//            FacesContext.getCurrentInstance().addMessage(null, message);
//        }
//    }
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

    public Tabla getTablaPilas() {
        return tablaPilas;
    }

    public void setTablaPilas(Tabla tablaPilas) {
        this.tablaPilas = tablaPilas;
    }

    public Tabla getTablaSuperEstructura() {
        return tablaSuperEstructura;
    }

    public void setTablaSuperEstructura(Tabla tablaSuperEstructura) {
        this.tablaSuperEstructura = tablaSuperEstructura;
    }

    public Tabla getTablaElementosNoEstructurales() {
        return tablaElementosNoEstructurales;
    }

    public void setTablaElementosNoEstructurales(Tabla tablaElementosNoEstructurales) {
        this.tablaElementosNoEstructurales = tablaElementosNoEstructurales;
    }

    public Tabla getTablaCarecteristicasDelCauce() {
        return tablaCarecteristicasDelCauce;
    }

    public void setTablaCarecteristicasDelCauce(Tabla tablaCarecteristicasDelCauce) {
        this.tablaCarecteristicasDelCauce = tablaCarecteristicasDelCauce;
    }

    public Tabla getTablaOtros() {
        return tablaOtros;
    }

    public void setTablaOtros(Tabla tablaOtros) {
        this.tablaOtros = tablaOtros;
    }

    public Inspector getInspector() {
        
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public List<Tabla> getListaTablas() {
        return listaTablas;
    }

    public void setListaTablas(List<Tabla> listaTablas) {
        this.listaTablas = listaTablas;
    }

    
}
