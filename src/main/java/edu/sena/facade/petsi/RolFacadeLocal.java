/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.petsi;

import edu.sena.petsi.Rol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Josarta
 */
@Local
public interface RolFacadeLocal {

    void create(Rol rol);

    void edit(Rol rol);

    void remove(Rol rol);

    Rol find(Object id);

    List<Rol> findAll();

    List<Rol> findRange(int[] range);

    int count();

    public List<Rol> usuarioNoRoles(int id_usuario);

    public boolean addRol(int id_usuario, int id_rol);

    public boolean removerRol(int id_usuario, int id_rol);
    
}
