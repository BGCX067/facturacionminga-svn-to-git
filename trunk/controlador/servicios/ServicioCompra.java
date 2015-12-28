/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servicios;

import controlador.daos.CompraDao;
import java.util.List;
import modelo.Compra;

/**
 *
 * @author jose
 */
public class ServicioCompra {
    private CompraDao dao;

    public ServicioCompra() {
        dao = new CompraDao();
    }
    public Compra getCompra() {
        return dao.getCompra();
    }
    public void fijarInstancia(Compra a) {
        dao.fijarInstancia(a);
    }
    public void nuevaInstancia() {
        dao.nuevaInstancia();
    }
    public boolean guardar() {
        return dao.guardar();
    }
    public List<Compra>listar(){
        return dao.enlistar("");
    }
    public List<Compra>listarCondicion(String condicion){
        return dao.enlistar(condicion);
    }
    public Compra obtenerId(Long id){
        return dao.obtenerPorId(id);
    }
}
