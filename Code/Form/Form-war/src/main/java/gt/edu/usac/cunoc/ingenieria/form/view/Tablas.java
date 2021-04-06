/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.form.view;

import entidades.Columna;
import entidades.Fila;
import entidades.Tabla;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author daniel
 */
@Named
@ViewScoped
public class Tablas implements Serializable{

    private Tabla tablaEstriboEntrada;
    private Tabla tablaEstriboSalida;

    public Tablas() {
        this.tablaEstriboEntrada = new Tabla();
        this.tablaEstriboEntrada.setNombre("EstriboDeEntrada");
        this.tablaEstriboSalida = new Tabla();
        this.tablaEstriboSalida.setNombre("EstriboDeSalida");
        createTablaEstriboEntrada(tablaEstriboEntrada);
        createTablaEstriboEntrada(tablaEstriboSalida);

    }

    
    
    public void createTablaEstriboEntrada(Tabla tabla) {
        List<Fila> filas = this.addFilasEstriboEntrada(tabla);
        for (int i = 0; i < filas.size(); i++) {
            switch (filas.get(i).getNombre()) {
                case "Apoyos":
                    addColumsEstriboEntrada(filas.get(i));
                    deleteColumn(filas.get(i), "Altura");
                    deleteColumn(filas.get(i), "Ancho");
                    deleteColumn(filas.get(i), "GrietasEnUnaDireccion");
                    deleteColumn(filas.get(i), "GrietasEnDosDirecciones");
                    deleteColumn(filas.get(i), "PerdidaDePetreosPorGolpe"); 
                    deleteColumn(filas.get(i), "ExposicionDeAcero");
                    addColumn(filas.get(i), "NeoprenoAplastado");
                    addColumn(filas.get(i), "FueraDeLugar");
                    addColumn(filas.get(i), "Oxidado");
                    addColumn(filas.get(i), "FaltaPerno");
                    addColumn(filas.get(i), "PernoRoto");
                    break;
                case "Cuerpo":
                    addColumsEstriboEntrada(filas.get(i));
                    deleteColumn(filas.get(i), "ExposicionDeAcero");
                    break;
                        
                case "Socavacion":
                    addColumsEstriboEntrada(filas.get(i));
                    deleteColumn(filas.get(i), "Material");
                    deleteColumn(filas.get(i), "Otros");
                    deleteColumn(filas.get(i), "Altura");
                    deleteColumn(filas.get(i), "Ancho");
                    deleteColumn(filas.get(i), "GrietasEnUnaDireccion");
                    deleteColumn(filas.get(i), "GrietasEnDosDirecciones");
                    deleteColumn(filas.get(i), "PerdidaDePetreosPorGolpe");
                    deleteColumn(filas.get(i), "ExposicionDeAcero");
                    addColumn(filas.get(i), "NoHay");
                    addColumn(filas.get(i), "SiPeroNoHay");
                    addColumn(filas.get(i), "SiHayExposicion");
                    addColumn(filas.get(i), "AsentamientoDe");
                    break;
                case "AguasArriba":
                    addColumsEstriboEntrada(filas.get(i));
                    deleteColumn(filas.get(i), "Altura");
                    addColumn(filas.get(i), "Largo");
                    break;
                case "AguasAbajo":
                    addColumsEstriboEntrada(filas.get(i));
                    deleteColumn(filas.get(i), "Altura");
                    addColumn(filas.get(i), "Largo");
                    break;
                default:
                    addColumsEstriboEntrada(filas.get(i));
                    break;
            }
        }

    }

    public void deleteColumn(Fila fila, String nombre) {
        for (int i = 0; i < fila.getColumnaList().size(); i++) {
            if (fila.getColumnaList().get(i).getNombre().equals(nombre)) {
                fila.getColumnaList().remove(i);
            }
        }
    }

    public void addColumn(Fila fila, String nombre) {
        Columna columna = new Columna();
        columna.setNombre(nombre);
        fila.getColumnaList().add(columna);
    }

    public List<Fila> addFilasEstriboEntrada(Tabla tabla) {
        Fila cortinaSuperiorfila = new Fila();
        Fila cortinaInferiorfila = null;
        Fila vigaApoyofila;
        //private Fila apoyosfila;
        Fila columnasfila;
        Fila cuerpofila;
        Fila aletonesfila;
        Fila aguasArribafila;
        Fila aguasAbajofila;
        //private Fila socavacionfila;

        List<Fila> filaList = new ArrayList<>();

        cortinaSuperiorfila = new Fila();
        cortinaSuperiorfila.setNombre("CortinaSuperior");
        cortinaInferiorfila = new Fila();
        cortinaInferiorfila.setNombre("CortinaInferior");
        vigaApoyofila = new Fila();
        vigaApoyofila.setNombre("VigaDeApoyo");

        columnasfila = new Fila();
        columnasfila.setNombre("Columnas");
        cuerpofila = new Fila();
        cuerpofila.setNombre("Cuerpo");
        aletonesfila = new Fila();

        aguasArribafila = new Fila();
        aguasArribafila.setNombre("AguasArriba");
        aguasAbajofila = new Fila();
        aguasAbajofila.setNombre("AguasAbajo");

        Fila apoyosfila = new Fila();
        apoyosfila.setNombre("Apoyos");
        Fila socavacionfila = new Fila();
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
        return filaList;

    }

    public List<Columna> addColumsEstriboEntrada(Fila fila) {
        Columna materialcolumna = new Columna();
        materialcolumna.setNombre("Material");
        Columna alturacolumna = new Columna();
        alturacolumna.setNombre("Altura");
        Columna anchocolumna = new Columna();
        anchocolumna.setNombre("Ancho");
        Columna grietasUnaDireccioncolumna = new Columna();
        grietasUnaDireccioncolumna.setNombre("GrietasEnUnaDireccion");
        Columna grietasDosDireccioncolumna = new Columna();
        grietasDosDireccioncolumna.setNombre("GrietasEnDosDirecciones");
        Columna perdidacolumna = new Columna();
        perdidacolumna.setNombre("PerdidaDePetreosPorGolpe");
        Columna exposicioncolumna = new Columna();
        exposicioncolumna.setNombre("ExposicionDeAcero");
        Columna otroscolumna = new Columna();
        otroscolumna.setNombre("Otros");

        List<Columna> columnaList = new ArrayList<>();
        columnaList.add(materialcolumna);
        columnaList.add(alturacolumna);
        columnaList.add(anchocolumna);
        columnaList.add(grietasUnaDireccioncolumna);
        columnaList.add(grietasDosDireccioncolumna);
        columnaList.add(perdidacolumna);
        columnaList.add(exposicioncolumna);
        columnaList.add(otroscolumna);

        fila.setColumnaList(columnaList);
        return columnaList;
    }

    public Columna getColumnaEstriboEntrada(String fila, String columna) {
        for (int i = 0; i < this.tablaEstriboEntrada.getFilaList().size(); i++) {
            if (this.tablaEstriboEntrada.getFilaList().get(i).getNombre().equals(fila)) {
                for (int j = 0; j < this.tablaEstriboEntrada.getFilaList().get(i).getColumnaList().size(); j++) {
                    if(this.tablaEstriboEntrada.getFilaList().get(i).getColumnaList().get(j).getNombre().equals(columna)){
                        return this.tablaEstriboEntrada.getFilaList().get(i).getColumnaList().get(j);
                    }
                }
            }
        }
        
        return null;
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
