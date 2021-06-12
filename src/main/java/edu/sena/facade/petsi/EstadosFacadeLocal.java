/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.petsi;

import edu.sena.petsi.Estados;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL
 */
@Local
public interface EstadosFacadeLocal {

    void create(Estados estados);

    void edit(Estados estados);

    void remove(Estados estados);

    Estados find(Object id);

    List<Estados> findAll();

    List<Estados> findRange(int[] range);

    int count();
    
}
