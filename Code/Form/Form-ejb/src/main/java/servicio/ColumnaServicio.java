/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import entidades.Columna;

/**
 *
 * @author daniel
 */
@Stateless
@LocalBean
public class ColumnaServicio {
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public Columna createColumna(Columna columna) throws Exception{
        entityManager.persist(columna);
        return columna;
    }
    
    public Columna editColumna(Columna columna){
        entityManager.merge(columna);
        return columna;
    }
    
    
    
}
