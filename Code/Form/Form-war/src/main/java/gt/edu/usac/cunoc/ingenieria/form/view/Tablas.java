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
public class Tablas implements Serializable {

    private Tabla tablaEstriboEntrada;
    private Tabla tablaEstriboSalida;
    private Tabla tablaPilas;
    private Tabla tablaSuperEstructura;
    private Tabla tablaElementosNoEstructurales;
    private Tabla tablaCarecteristicasDelCauce;
    private Tabla tablaOtros;

    public Tablas() {
        this.tablaEstriboEntrada = new Tabla();
        this.tablaEstriboEntrada.setNombre("EstriboDeEntrada");
        this.tablaEstriboSalida = new Tabla();
        this.tablaEstriboSalida.setNombre("EstriboDeSalida");
        createTablaEstriboEntrada(tablaEstriboEntrada);
        createTablaEstriboEntrada(tablaEstriboSalida);

        createTablaPilas();
        createTablaSuperEstructura();
        createTablaElementosNoEstructurales();
        createTablaCaracteristicasDelCauce();
        createTablaOtros();

    }
    
    
    public void createTablaOtros(){
        this.tablaOtros = new Tabla();
        this.tablaOtros.setNombre("Otros");
        List<Fila> filas = new ArrayList<>();
        
        filas.add(createFilaOtros("Hay"));
        filas.add(createFilaOtros("Estado"));
        filas.add(createFilaOtros("NoHay"));
        

        Fila datos = new Fila();
        List<Columna> columnas = new ArrayList<>();
        
        Columna alumbradoArtificial = new Columna();
        alumbradoArtificial.setNombre("AlumbradoArtificial(Existe)");
        columnas.add(alumbradoArtificial);
        //TODO: drenajes
        Columna drenajesAledaniosAlPuente = new Columna();
        drenajesAledaniosAlPuente.setNombre("DrenajesAledañosAlPuente");
        columnas.add(drenajesAledaniosAlPuente);
        Columna estadoDeDrenajes = new Columna();
        estadoDeDrenajes.setNombre("EstadoDeDrenajes");
        columnas.add(estadoDeDrenajes);
        Columna mantenimiento = new Columna();
        mantenimiento.setNombre("Mantenimiento");
        columnas.add(mantenimiento);
        Columna reparacion = new Columna();
        reparacion.setNombre("Reparacion");
        columnas.add(reparacion);
        
        
        
        datos.setNombre("Datos");
        datos.setColumnaList(columnas);
        filas.add(datos);
        this.tablaOtros.setFilaList(filas);
        
    }
    
    public Fila createFilaOtros(String nombre){
        Fila fila = new Fila();
        fila.setNombre(nombre);
        List<Columna> columnas = new ArrayList<>();
        
        Columna informativa = new Columna();
        informativa.setNombre("Informativa");
        columnas.add(informativa);
        Columna preventiva = new Columna();
        preventiva.setNombre("Preventiva");
        columnas.add(preventiva);
        Columna reglamentaria = new Columna();
        reglamentaria.setNombre("Reglamentaria");
        columnas.add(reglamentaria);
        Columna horizontal = new Columna();
        horizontal.setNombre("Horizontal");
        columnas.add(horizontal);
        fila.setColumnaList(columnas);
        
        
        return fila;
        
    }

    public void createTablaCaracteristicasDelCauce() {
        this.tablaCarecteristicasDelCauce = new Tabla();
        this.tablaCarecteristicasDelCauce.setNombre("CaracteristicasDelCauce");
        List<Fila> filas = new ArrayList<>();

        Fila datos = new Fila();
        List<Columna> columnas = new ArrayList<>();

        Columna tipoCuerpoAgua = new Columna();
        tipoCuerpoAgua.setNombre("TiposDeCuerpoDeAguaExistenteAdyacenteAlPuente");
        columnas.add(tipoCuerpoAgua);
        Columna nombre = new Columna();
        nombre.setNombre("NombreRio");
        columnas.add(nombre);
        Columna estadoDelCauce = new Columna();
        estadoDelCauce.setNombre("EstadoDelCauce");
        columnas.add(estadoDelCauce);
        Columna estadoZonaAdyacenteAEstribos = new Columna();
        estadoZonaAdyacenteAEstribos.setNombre("EstadoZonaAdyacenteAEstribos");
        columnas.add(estadoZonaAdyacenteAEstribos);
        Columna encauzamiento = new Columna();
        encauzamiento.setNombre("Encauzamiento");
        columnas.add(encauzamiento);
        Columna aPresentadoDesbordamiento = new Columna();
        aPresentadoDesbordamiento.setNombre("APresentadoDesbordamiento");
        columnas.add(aPresentadoDesbordamiento);
        Columna frecuencia = new Columna();
        frecuencia.setNombre("Frecuencia(años)");
        columnas.add(frecuencia);
        Columna fechaUltimoDesbordamiento = new Columna();
        fechaUltimoDesbordamiento.setNombre("FechaUltimoDesbordamiento");
        columnas.add(fechaUltimoDesbordamiento);
        
        datos.setNombre("Datos");
        datos.setColumnaList(columnas);
        filas.add(datos);
        
        this.tablaCarecteristicasDelCauce.setFilaList(filas);

    }

    public void createTablaPilas() {
        this.tablaPilas = new Tabla();
        this.tablaPilas.setNombre("Pilas");
        List<Fila> filas = new ArrayList<>();

        filas.add(createFilaComunPilas("VigaCabezal"));
        filas.add(createFilaComunPilas("Columnas"));
        filas.add(createFilaCuerpoPilas("Cuerpo"));
        filas.add(createFilaApoyosPilas("Apoyos"));
        filas.add(createFilaSocavacionPilas("Socavacion"));

        
        
        this.tablaPilas.setFilaList(filas);

    }

    public Fila createFilaComunPilas(String nombre) {
        Fila fila = new Fila();
        fila.setNombre(nombre);
        addColumsEstriboEntrada(fila);

        return fila;
    }

    public Fila createFilaCuerpoPilas(String nombre) {
        Fila fila = new Fila();
        fila.setNombre(nombre);
        addColumsEstriboEntrada(fila);
        deleteColumn(fila, "ExposicionDeAcero");

        return fila;
    }

    public Fila createFilaApoyosPilas(String nombre) {
        Fila fila = new Fila();
        fila.setNombre(nombre);
        addColumsEstriboEntrada(fila);
        deleteColumn(fila, "Altura");
        deleteColumn(fila, "Ancho");
        deleteColumn(fila, "GrietasEnUnaDireccion");
        deleteColumn(fila, "GrietasEnDosDirecciones");
        deleteColumn(fila, "PerdidaDePetreosPorGolpe");
        deleteColumn(fila, "ExposicionDeAcero");
        addColumn(fila, "NeoprenoAplastado");
        addColumn(fila, "FueraDeLugar");
        addColumn(fila, "Oxidado");
        addColumn(fila, "FaltaPerno");
        addColumn(fila, "PernoRoto");

        return fila;
    }

    public Fila createFilaSocavacionPilas(String nombre) {
        Fila fila = new Fila();
        fila.setNombre(nombre);
        addColumsEstriboEntrada(fila);
        deleteColumn(fila, "Material");
        deleteColumn(fila, "Otros");
        deleteColumn(fila, "Altura");
        deleteColumn(fila, "Ancho");
        deleteColumn(fila, "GrietasEnUnaDireccion");
        deleteColumn(fila, "GrietasEnDosDirecciones");
        deleteColumn(fila, "PerdidaDePetreosPorGolpe");
        deleteColumn(fila, "ExposicionDeAcero");
        addColumn(fila, "NoHay");
        addColumn(fila, "SiPeroNoHay");
        addColumn(fila, "SiHayExposicion");
        addColumn(fila, "AsentamientoDe");

        return fila;
    }

    public void createTablaElementosNoEstructurales() {
        this.tablaElementosNoEstructurales = new Tabla();
        this.tablaElementosNoEstructurales.setNombre("ElementosNoEstructurales");
        List<Fila> filas = new ArrayList<>();

        filas.add(createFilaBarandal("PasamanosBarandalIzquierdo"));
        filas.add(createFilaBarandal("PasamanosBarandalDerecho"));
        filas.add(createFilaBarandal("Barreras"));
        filas.add(createFilaJunta("Junta(Entrada)"));
        filas.add(createFilaJunta("Junta(Salida)"));
        filas.add(createFilaJunta("JuntasIntermedias"));
        filas.add(createFilaLosa("LosaAcceso(Entrada)"));
        filas.add(createFilaLosa("LosaAcceso(Salida)"));
        filas.add(createFilaObras("ObrasProteccion(AguasArriba)"));
        filas.add(createFilaObras("ObrasProteccion(AguasAbajo)"));

        //this.tablaElementosNoEstructurales.setFilaList(filas);

        this.tablaElementosNoEstructurales.setFilaList(filas);
    }

    public Fila createFilaBarandal(String nombre) {
        Fila fila = new Fila();
        fila.setNombre(nombre);
        List<Columna> columnas = new ArrayList<>();
        Columna material = new Columna();
        material.setNombre("Material");
        columnas.add(material);
        Columna ausenciaDeSeccion = new Columna();
        ausenciaDeSeccion.setNombre("AusenciaDeSeccion");
        columnas.add(ausenciaDeSeccion);
        Columna deformacionDeElemento = new Columna();
        deformacionDeElemento.setNombre("DeformacionDeElemento");
        columnas.add(deformacionDeElemento);
        Columna golpeado = new Columna();
        golpeado.setNombre("Golpeado(longitud)");
        columnas.add(golpeado);
        Columna pintura = new Columna();
        pintura.setNombre("Pintura");
        columnas.add(pintura);
        Columna otros = new Columna();
        otros.setNombre("Otros");
        columnas.add(otros);
        fila.setColumnaList(columnas);

        return fila;
    }

    public Fila createFilaJunta(String nombre) {
        Fila fila = new Fila();
        fila.setNombre(nombre);
        List<Columna> columnas = new ArrayList<>();
        Columna material = new Columna();
        material.setNombre("Material");
        columnas.add(material);
        Columna faltaElemento = new Columna();
        faltaElemento.setNombre("FaltaElemento");
        columnas.add(faltaElemento);
        Columna juntaLimpia = new Columna();
        juntaLimpia.setNombre("JuntaLimpia");
        columnas.add(juntaLimpia);
        Columna danios = new Columna();
        danios.setNombre("Daños");
        columnas.add(danios);
        fila.setColumnaList(columnas);

        return fila;
    }

    public Fila createFilaLosa(String nombre) {
        Fila fila = new Fila();
        fila.setNombre(nombre);
        List<Columna> columnas = new ArrayList<>();
        Columna material = new Columna();
        material.setNombre("Material");
        columnas.add(material);
        Columna buenEstado = new Columna();
        buenEstado.setNombre("BuenEstado");
        columnas.add(buenEstado);
        Columna danio = new Columna();
        danio.setNombre("Daño");
        columnas.add(danio);
        fila.setColumnaList(columnas);

        return fila;
    }

    public Fila createFilaObras(String nombre) {
        Fila fila = new Fila();
        fila.setNombre(nombre);
        List<Columna> columnas = new ArrayList<>();
        Columna material = new Columna();
        material.setNombre("Material");
        columnas.add(material);
        Columna tipo = new Columna();
        tipo.setNombre("Tipo(*)");
        columnas.add(tipo);
        Columna largo = new Columna();
        largo.setNombre("Largo");
        columnas.add(largo);
        Columna ancho = new Columna();
        ancho.setNombre("Ancho");
        columnas.add(ancho);
        Columna altura = new Columna();
        altura.setNombre("Altura");
        columnas.add(altura);
        fila.setColumnaList(columnas);

        return fila;
    }

    public void createTablaSuperEstructura() {
        this.tablaSuperEstructura = new Tabla();
        this.tablaSuperEstructura.setNombre("SuperEstructura");
        List<Fila> filas = new ArrayList<>();

        Fila losaDeRodamiento = new Fila();
        losaDeRodamiento.setNombre("LosaDeRodamiento");
        //columnas
        List<Columna> columnas1 = new ArrayList<>();
        Columna material = new Columna();
        material.setNombre("Material");
        columnas1.add(material);
        Columna grietasEnUnaDireccion = new Columna();
        grietasEnUnaDireccion.setNombre("GrietasEnUnaDireccion");
        columnas1.add(grietasEnUnaDireccion);
        Columna grietasEnDos = new Columna();
        grietasEnDos.setNombre("GrietasEnDos");
        columnas1.add(grietasEnDos);
        Columna desprendimientoDe = new Columna();
        desprendimientoDe.setNombre("DesprendimientoDe");
        columnas1.add(desprendimientoDe);
        Columna baches = new Columna();
        baches.setNombre("Baches");
        columnas1.add(baches);
        Columna exposicionDeAcero = new Columna();
        exposicionDeAcero.setNombre("ExposicionDeAcero");
        columnas1.add(exposicionDeAcero);
        Columna otros = new Columna();
        otros.setNombre("Otros");
        columnas1.add(otros);
        losaDeRodamiento.setColumnaList(columnas1);
        filas.add(losaDeRodamiento);

        Fila elementoPortanteDeConcreto = new Fila();
        elementoPortanteDeConcreto.setNombre("ElementoPortanteDeConcreto");
        List<Columna> columnas2 = new ArrayList<>();
        Columna grietasEnDiagonal2 = new Columna();
        grietasEnDiagonal2.setNombre("GrietasEnDiagonal");
        columnas2.add(grietasEnDiagonal2);
        Columna grietasVerticales2 = new Columna();
        grietasVerticales2.setNombre("GrietasVerticales");
        columnas2.add(grietasVerticales2);
        Columna perdidaDePetreosPorGolpe2 = new Columna();
        perdidaDePetreosPorGolpe2.setNombre("PerdidaDePetreosPorGolpe");
        columnas2.add(perdidaDePetreosPorGolpe2);
        Columna exposicionDeAcero2 = new Columna();
        exposicionDeAcero2.setNombre("ExposicionDeAcero");
        columnas2.add(exposicionDeAcero2);
        Columna otros2 = new Columna();
        otros2.setNombre("Otros");
        columnas2.add(otros2);
        elementoPortanteDeConcreto.setColumnaList(columnas2);
        filas.add(elementoPortanteDeConcreto);

        Fila elementoPortanteDeAcero = new Fila();
        elementoPortanteDeAcero.setNombre("ElementoPortanteDeAcero");
        List<Columna> columnas3 = new ArrayList<>();
        Columna oxido3 = new Columna();
        oxido3.setNombre("Oxido");
        columnas3.add(oxido3);
        Columna faltaPernos3 = new Columna();
        faltaPernos3.setNombre("FaltaPernos");
        columnas3.add(faltaPernos3);
        Columna elementoGolpeado3 = new Columna();
        elementoGolpeado3.setNombre("ElementosGolpeados");
        columnas3.add(elementoGolpeado3);
        Columna elementoCortado3 = new Columna();
        elementoCortado3.setNombre("ElementoCortado");
        columnas3.add(elementoCortado3);
        Columna pintura3 = new Columna();
        pintura3.setNombre("Pintura");
        columnas3.add(pintura3);
        Columna otros3 = new Columna();
        otros3.setNombre("Otros");
        columnas3.add(otros3);
        elementoPortanteDeAcero.setColumnaList(columnas3);
        filas.add(elementoPortanteDeAcero);

        Fila diafragmasConcreto = new Fila();
        diafragmasConcreto.setNombre("DiafragmasConcreto");
        List<Columna> columnas4 = new ArrayList<>();
        Columna grietasEnDiagonal4 = new Columna();
        grietasEnDiagonal4.setNombre("GrietasEnDiagonal");
        columnas4.add(grietasEnDiagonal4);
        Columna grietasVerticales4 = new Columna();
        grietasVerticales4.setNombre("GrietasVerticales");
        columnas4.add(grietasVerticales4);
        Columna perdidaDePetreosPorGolpe4 = new Columna();
        perdidaDePetreosPorGolpe4.setNombre("PerdidaDePetreosPorGolpe");
        columnas4.add(perdidaDePetreosPorGolpe4);
        Columna exposicionDeAcero4 = new Columna();
        exposicionDeAcero4.setNombre("ExposicionDeAcero");
        columnas4.add(exposicionDeAcero4);
        Columna otros4 = new Columna();
        otros4.setNombre("Otros");
        columnas4.add(otros4);
        diafragmasConcreto.setColumnaList(columnas4);
        filas.add(diafragmasConcreto);

        Fila diafragmasAcero = new Fila();
        diafragmasAcero.setNombre("DiafragmasAcero");
        List<Columna> columnas5 = new ArrayList<>();
        Columna oxido5 = new Columna();
        oxido5.setNombre("Oxido");
        columnas5.add(oxido5);
        Columna faltaPernos5 = new Columna();
        faltaPernos5.setNombre("FaltaPernos");
        columnas5.add(faltaPernos5);
        Columna elementoGolpeado5 = new Columna();
        elementoGolpeado5.setNombre("ElementosGolpeados");
        columnas5.add(elementoGolpeado5);
        Columna elementoCortado5 = new Columna();
        elementoCortado5.setNombre("ElementoCortado");
        columnas5.add(elementoCortado5);
        Columna pintura5 = new Columna();
        pintura5.setNombre("Pintura");
        columnas5.add(pintura5);
        Columna otros5 = new Columna();
        otros5.setNombre("Otros");
        columnas5.add(otros5);
        diafragmasAcero.setColumnaList(columnas5);
        filas.add(diafragmasAcero);

        Fila estructuraTipoSercha = new Fila();
        estructuraTipoSercha.setNombre("EstructuraTipoSercha");
        List<Columna> columnas6 = new ArrayList<>();
        Columna oxido6 = new Columna();
        oxido6.setNombre("Oxido");
        columnas6.add(oxido6);
        Columna faltaPernos6 = new Columna();
        faltaPernos6.setNombre("FaltaPernos");
        columnas6.add(faltaPernos6);
        Columna elementoGolpeado6 = new Columna();
        elementoGolpeado6.setNombre("ElementosGolpeados");
        columnas6.add(elementoGolpeado6);
        Columna elementoCortado6 = new Columna();
        elementoCortado6.setNombre("ElementoCortado");
        columnas6.add(elementoCortado6);
        Columna pintura6 = new Columna();
        pintura6.setNombre("Pintura");
        columnas6.add(pintura6);
        Columna otros6 = new Columna();
        otros6.setNombre("Otros");
        columnas6.add(otros6);
        estructuraTipoSercha.setColumnaList(columnas6);
        filas.add(estructuraTipoSercha);

        Fila drenajeSuperestructura = new Fila();
        drenajeSuperestructura.setNombre("DrenajeSuperestructura");
        List<Columna> columnas7 = new ArrayList<>();
        Columna limpios7 = new Columna();
        limpios7.setNombre("Limpios");
        columnas7.add(limpios7);
        Columna obstruidos7 = new Columna();
        obstruidos7.setNombre("Obstruidos");
        columnas7.add(obstruidos7);
        drenajeSuperestructura.setColumnaList(columnas7);
        filas.add(drenajeSuperestructura);

        this.tablaSuperEstructura.setFilaList(filas);

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
                    if (this.tablaEstriboEntrada.getFilaList().get(i).getColumnaList().get(j).getNombre().equals(columna)) {
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
    
    

}
