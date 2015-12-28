/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.daos;

import java.util.List;

/**
 *
 * @author alex
 */
public interface InterfazDao<T> {
    public void guardar(T obj);
    public void modificar(T obj);
    public void eliminar(T obj);
    public List<T> enlistar(String texto);
    public T obtenerPorId(Long id);
    
}
