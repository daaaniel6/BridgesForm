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

    public Tablas() {
        this.tablaEstriboEntrada = new Tabla();
        createTablaEstriboEntrada(tablaEstriboEntrada);

    }

    
    
    public void createTablaEstriboEntrada(Tabla tabla) {
        List<Fila> filas = this.addFilasEstriboEntrada(tablaEstriboEntrada);
        for (int i = 0; i < filas.size(); i++) {
            if (filas.get(i).getNombre().equals("Apoyos")) {
                addColumsEstriboEntrada(filas.get(i));
                //deleteColumn(filas.get(i), "Altura");
                //deleteColumn(filas.get(i), "Ancho");
                //deleteColumn(filas.get(i), "Altura");
                //deleteColumn(filas.get(i), "Altura");
                addColumn(filas.get(i), "NeoprenoAplastado");
                addColumn(filas.get(i), "FueraDeLugar");
                addColumn(filas.get(i), "Oxidado");
                addColumn(filas.get(i), "FaltaPerno");
                addColumn(filas.get(i), "PernoRoto");
            }
            if (filas.get(i).getNombre().equals("Socavacion")) {
                addColumsEstriboEntrada(filas.get(i));
                //deleteColumn(filas.get(i), "Altura");
                //deleteColumn(filas.get(i), "Ancho");
                //deleteColumn(filas.get(i), "Altura");
                //deleteColumn(filas.get(i), "Altura");
                addColumn(filas.get(i), "NoHay");
                addColumn(filas.get(i), "SiPeroNoHay");
                addColumn(filas.get(i), "SiHayExposicion");
                addColumn(filas.get(i), "AsentamientoDe");
            }
            if (filas.get(i).getNombre().equals("AguasArriba")) {
                addColumsEstriboEntrada(filas.get(i));

                addColumn(filas.get(i), "Largo");

            }
            if (filas.get(i).getNombre().equals("AguasAbajo")) {
                addColumsEstriboEntrada(filas.get(i));

                addColumn(filas.get(i), "Largo");

            } else {
                addColumsEstriboEntrada(filas.get(i));

            }
        }

    }

    public void deleteColumn(Fila fila, String nombre) {
        for (int i = 0; i < fila.getColumnaList().size(); i++) {
            if (fila.getColumnaList().get(i).getNombre().equals(nombre)) {
                fila.getColumnaList().remove(fila.getColumnaList().get(i));
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
        exposicioncolumna.setNombre("ExpocicionDeAcero");
        Columna otroscolumna = new Columna();
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

}
