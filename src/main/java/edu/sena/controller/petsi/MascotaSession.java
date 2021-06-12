/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.petsi;

import edu.sena.petsi.Mascotas;
import edu.sena.facade.petsi.MascotasFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import edu.sena.facade.petsi.MascotasFacadeLocal;
import java.util.List;

@Named(value = "mascotaSession")
@SessionScoped
public class MascotaSession implements Serializable {
    @EJB
    MascotasFacadeLocal mascotasFacadeLocal;
    
    private Mascotas mctNuevo = new Mascotas();

    private String mesError = "";
        
    public MascotaSession() {
    }
    
    public void crearMascota() {
        mesError = "";
        try {
            mascotasFacadeLocal.create(mctNuevo);
            mesError = "m2";
        } catch (Exception e) {
            mesError = "m1";
        }
        //mctNuevo = new Mascotas();
    }
    
    public List<Mascotas> todosMascotas() {
        return mascotasFacadeLocal.findAll();
    }

    
    public Mascotas getMctNuevo() {
        return mctNuevo;
    }

    public void setMactNuevo(Mascotas mctNuevo) {
        this.mctNuevo = mctNuevo;
    }

    public MascotasFacadeLocal getMascotasFacadeLocal() {
        return mascotasFacadeLocal;
    }

    public void setMascotasFacadeLocal(MascotasFacadeLocal mascotasFacadeLocal) {
        this.mascotasFacadeLocal = mascotasFacadeLocal;
    }

    public String getMesError() {
        return mesError;
    }

    public void setMesError(String mesError) {
        this.mesError = mesError;
    }
}
