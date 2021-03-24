/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import static config.Constants.PERSISTENCE_UNIT_NAME;
import entidades.Columna;
import entidades.Fila;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */

@Stateless
@LocalBean
public class FilaServicio {
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public Fila createColumna(Fila fila) throws Exception{
        entityManager.persist(fila);
        return fila;
    }
    
    public Fila editColumna(Fila fila){
        entityManager.merge(fila);
        return fila;
    }
    
}
