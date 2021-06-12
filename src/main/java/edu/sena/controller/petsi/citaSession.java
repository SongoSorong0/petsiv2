
package edu.sena.controller.petsi;

import edu.sena.facade.petsi.CitasFacadeLocal;
import edu.sena.petsi.Citas;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;


@Named(value = "citaSession")
@SessionScoped
public class citaSession implements Serializable {
@EJB
  private CitasFacadeLocal citasFacadeLocal;
private Citas citNuevo = new Citas();

private String citaError = "";
    public citaSession() {
    }
    public void crearCita() {
        citaError = "";
        try {
            citasFacadeLocal.create(citNuevo);
            citaError = "m2";
        } catch (Exception e) {
            citaError = "m1";
        }
     
    }
     public List<Citas> todasCitas() {
        return citasFacadeLocal.findAll();
    }

    public CitasFacadeLocal getCitasFacadeLocal() {
        return citasFacadeLocal;
    }

    public void setCitasFacadeLocal(CitasFacadeLocal citasFacadeLocal) {
        this.citasFacadeLocal = citasFacadeLocal;
    }

    public Citas getCitNuevo() {
        return citNuevo;
    }

    public void setCitNuevo(Citas citNuevo) {
        this.citNuevo = citNuevo;
    }

    public String getCitaError() {
        return citaError;
    }

    public void setCitaError(String citaError) {
        this.citaError = citaError;
    }
    
     
}
