/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.daos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author jose
 */
public class DaoAdaptador<T> implements InterfazDao<T>{
    private Class<T> clazz;
    private EntityManager manager;

    public DaoAdaptador(Class<T> clazz, EntityManager manager) {
        this.clazz = clazz;
        this.manager = manager;
    }

    public EntityManager getManager() {
        return manager;
    }

    @Override
    public void eliminar(T obj) {
        this.manager.remove(obj);
    }

    

    @Override
    public List<T> enlistar(String texto) {
        List<T> lista=new ArrayList<T>();
        String aux = (texto.isEmpty())?"":" "+texto;
        try {
            String query=" select p from "+this.clazz.getName()+" p "+aux;
            Query q = this.manager.createQuery(query);
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public void guardar(T obj) {
        this.manager.persist(obj);
    }

    @Override
    public void modificar(T obj) {
        this.manager.merge(obj);
    }

    @Override
    public T obtenerPorId(Long id) {
        return this.manager.find(clazz, id);
    }
    
    
          
}
