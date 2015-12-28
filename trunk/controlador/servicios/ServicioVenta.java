/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servicios;

import controlador.daos.VentaDao;
import java.util.List;
import modelo.Venta;

/**
 *
 * @author jose
 */
public class ServicioVenta {
    private VentaDao dao;

    public ServicioVenta() {
        dao = new VentaDao();
    }
    public Venta getVenta() {
        return dao.getVenta();
    }
    public void fijarInstancia(Venta a) {
        dao.fijarInstancia(a);
    }
    public void nuevaInstancia() {
        dao.nuevaInstancia();
    }
    public boolean guardar() {
        return dao.guardar();
    }
    public List<Venta>listar(){
        return dao.enlistar("");
    }
    public List<Venta>listarCondicion(String condicion){
        return dao.enlistar(condicion);
    }
    public Venta obtenerId(Long id){
        return dao.obtenerPorId(id);
    }
}
