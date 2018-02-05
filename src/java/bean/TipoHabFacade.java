/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidades.TipoHab;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DAY
 */
@Stateless
public class TipoHabFacade extends AbstractFacade<TipoHab> {

    @PersistenceContext(unitName = "nuevooooPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoHabFacade() {
        super(TipoHab.class);
    }
    
}
