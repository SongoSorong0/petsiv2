/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.petsi;

import edu.sena.petsi.Historiaclinica;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MIGUEL
 */
@Stateless
public class HistoriaclinicaFacade extends AbstractFacade<Historiaclinica> implements HistoriaclinicaFacadeLocal {

    @PersistenceContext(unitName = "edu.sena_adsi2025316_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoriaclinicaFacade() {
        super(Historiaclinica.class);
    }
    
}
