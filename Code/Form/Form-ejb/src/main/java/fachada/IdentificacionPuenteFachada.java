/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import servicio.*;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import entidades.IdentificacionPuente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */

@Stateless
public class IdentificacionPuenteFachada implements IdentificacionPuenteFachadaLocal{
    private IdentificacionPuenteServicio identificacionPuenteServicio;
    
    @EJB
    public void setIdentificacionService(IdentificacionPuenteServicio productService) {
        this.identificacionPuenteServicio = productService;
    }
    
    @Override
    public IdentificacionPuente createIdentificacion(IdentificacionPuente identificacionPuente){
        try {
            return identificacionPuenteServicio.createIdentificacion(identificacionPuente);
        } catch (Exception ex) {
            Logger.getLogger(IdentificacionPuenteFachada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
