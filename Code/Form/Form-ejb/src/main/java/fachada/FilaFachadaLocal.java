/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import servicio.*;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import entidades.Columna;
import entidades.Fila;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */

@Local
public interface FilaFachadaLocal {
    
    
}
