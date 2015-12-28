/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servicios;

import controlador.daos.CategoriaDao;
import java.util.List;
import modelo.Categoria;

/**
 *
 * @author jose
 */
public class ServicioCategoria {
    private CategoriaDao dao;

    public ServicioCategoria() {
        dao = new CategoriaDao();
    }
    public Categoria getCategoria() {
        return dao.getCategoria();
    }
    public void fijarInstancia(Categoria a) {
        dao.fijarInstancia(a);
    }
    public void nuevaInstancia() {
        dao.nuevaInstancia();
    }
    public boolean guardar() {
        return dao.guardar();
    }
    public List<Categoria>listar(){
        return dao.enlistar("");
    }
    public List<Categoria>listarCondicion(String condicion){
        return dao.enlistar(condicion);
    }
    public Categoria obtenerId(Long id){
        return dao.obtenerPorId(id);
    }
}
