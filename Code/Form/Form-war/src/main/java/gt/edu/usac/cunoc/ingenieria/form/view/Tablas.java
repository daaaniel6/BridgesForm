/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.form.view;

import entidades.Columna;
import entidades.Fila;
import entidades.Tabla;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class Tablas {
    private Tabla tabla;
    
    private Fila cortinaSuperiorfila;
    private Fila cortinaInferiorfila;
    private Fila vigaApoyofila;
    private Fila apoyosfila;
    private Fila columnasfila;
    private Fila cuerpofila;
    private Fila aletonesfila;
    private Fila aguasArribafila;
    private Fila aguasAbajofila;
    private Fila socavacionfila;

    public Tablas() {
        this.tabla = new Tabla();
        
    }
    
    public void addFilasEstriboEntrada(Tabla tabla){
        List<Fila> filaList = new ArrayList<>();
        
        this.cortinaSuperiorfila = new Fila();
        cortinaInferiorfila.setNombre("CortinaSuperior");
        this.cortinaInferiorfila = new Fila();
        cortinaInferiorfila.setNombre("CortinaInferior");
        this.vigaApoyofila =  new Fila();
        vigaApoyofila.setNombre("VigaDeApoyo");
        this.apoyosfila =  new Fila();
        apoyosfila.setNombre("Apoyos");
        this.columnasfila =  new Fila();
        columnasfila.setNombre("Columnas");
        this.cuerpofila = new Fila();
        cuerpofila.setNombre("Cuerpo");
        this.aletonesfila =  new Fila();
        
        this.aguasArribafila =  new Fila();
        aguasArribafila.setNombre("AguasArriba");
        this.aguasAbajofila =  new Fila();
        aguasAbajofila.setNombre("AguasAbajo");
        this.socavacionfila =  new Fila();
        socavacionfila.setNombre("Socavacion");
        
        filaList.add(cortinaSuperiorfila);
        filaList.add(cortinaInferiorfila);
        filaList.add(vigaApoyofila);
        filaList.add(apoyosfila);
        filaList.add(columnasfila);
        filaList.add(cuerpofila);
        filaList.add(aguasArribafila);
        filaList.add(aguasAbajofila);
        filaList.add(socavacionfila);
        
        
        
        tabla.setFilaList(filaList);
    }

    
    public void addColums(Fila fila){
        Columna  materialcolumna = new Columna();
        materialcolumna.setNombre("Material");
        Columna  alturacolumna = new Columna();
        alturacolumna.setNombre("Altura");
        Columna  anchocolumna = new Columna();
        anchocolumna.setNombre("Ancho");
        Columna  grietasUnaDireccioncolumna = new Columna();
        grietasUnaDireccioncolumna.setNombre("GrietasEnUnaDireccion");
        Columna  grietasDosDireccioncolumna = new Columna();
        grietasDosDireccioncolumna.setNombre("GrietasEnDosDirecciones");
        Columna  perdidacolumna = new Columna();
        perdidacolumna.setNombre("PerdidaDePetreosPorGolpe");
        Columna  exposicioncolumna = new Columna();
        exposicioncolumna.setNombre("ExpocicionDeAcero");
        Columna  otroscolumna = new Columna();
        otroscolumna.setNombre("Otros");
        
        List<Columna> columnaList = new ArrayList<>();
        columnaList.add(materialcolumna);
        columnaList.add(alturacolumna);
        columnaList.add(anchocolumna);
        columnaList.add(grietasUnaDireccioncolumna);
        columnaList.add(grietasDosDireccioncolumna);
        columnaList.add(materialcolumna);
        columnaList.add(materialcolumna);
        columnaList.add(materialcolumna);
        
        fila.setColumnaList(columnaList);
    }
    
    
    
    
    public Tabla getTabla() {
        return tabla;
    }

    public void setTabla(Tabla tabla) {
        this.tabla = tabla;
    }

    public Fila getCortinaSuperiorfila() {
        return cortinaSuperiorfila;
    }

    public void setCortinaSuperiorfila(Fila cortinaSuperiorfila) {
        this.cortinaSuperiorfila = cortinaSuperiorfila;
    }

    public Fila getCortinaInferiorfila() {
        return cortinaInferiorfila;
    }

    public void setCortinaInferiorfila(Fila cortinaInferiorfila) {
        this.cortinaInferiorfila = cortinaInferiorfila;
    }

    public Fila getVigaApoyofila() {
        return vigaApoyofila;
    }

    public void setVigaApoyofila(Fila vigaApoyofila) {
        this.vigaApoyofila = vigaApoyofila;
    }

    public Fila getApoyosfila() {
        return apoyosfila;
    }

    public void setApoyosfila(Fila apoyosfila) {
        this.apoyosfila = apoyosfila;
    }

    public Fila getColumnasfila() {
        return columnasfila;
    }

    public void setColumnasfila(Fila columnasfila) {
        this.columnasfila = columnasfila;
    }

    public Fila getCuerpofila() {
        return cuerpofila;
    }

    public void setCuerpofila(Fila cuerpofila) {
        this.cuerpofila = cuerpofila;
    }

    public Fila getAletonesfila() {
        return aletonesfila;
    }

    public void setAletonesfila(Fila aletonesfila) {
        this.aletonesfila = aletonesfila;
    }

    public Fila getAguasArribafila() {
        return aguasArribafila;
    }

    public void setAguasArribafila(Fila aguasArribafila) {
        this.aguasArribafila = aguasArribafila;
    }

    public Fila getAguasAbajofila() {
        return aguasAbajofila;
    }

    public void setAguasAbajofila(Fila aguasAbajofila) {
        this.aguasAbajofila = aguasAbajofila;
    }

    public Fila getSocavacionfila() {
        return socavacionfila;
    }

    public void setSocavacionfila(Fila socavacionfila) {
        this.socavacionfila = socavacionfila;
    }

        
    
    
    
}
