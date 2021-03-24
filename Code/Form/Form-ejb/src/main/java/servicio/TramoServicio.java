/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import static config.Constants.PERSISTENCE_UNIT_NAME;
import entidades.Tramo;
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
public class TramoServicio {
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public Tramo createColumna(Tramo tramo) throws Exception{
        entityManager.persist(tramo);
        return tramo;
    }
    
    public Tramo editColumna(Tramo columna){
        entityManager.merge(columna);
        return columna;
    }
}
