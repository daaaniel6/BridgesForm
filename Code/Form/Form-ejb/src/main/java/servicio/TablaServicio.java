/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import static config.Constants.PERSISTENCE_UNIT_NAME;
import entidades.Tabla;
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
public class TablaServicio {
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public Tabla createColumna(Tabla tabla) throws Exception{
        entityManager.persist(tabla);
        return tabla;
    }
    
    public Tabla editColumna(Tabla tabla){
        entityManager.merge(tabla);
        return tabla;
    }
}
