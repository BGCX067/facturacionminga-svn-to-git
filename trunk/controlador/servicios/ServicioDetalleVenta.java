/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servicios;

import controlador.daos.DetalleVentaDao;
import java.util.List;
import modelo.DetalleVenta;

/**
 *
 * @author jose
 */
public class ServicioDetalleVenta {
    private DetalleVentaDao dao;

    public ServicioDetalleVenta() {
        dao = new DetalleVentaDao();
    }
    public DetalleVenta getDetalleVenta() {
        return dao.getDetalleVenta();
    }
    public void fijarInstancia(DetalleVenta a) {
        dao.fijarInstancia(a);
    }
    public void nuevaInstancia() {
        dao.nuevaInstancia();
    }
    public boolean guardar() {
        return dao.guardar();
    }
    public List<DetalleVenta>listar(){
        return dao.enlistar("");
    }
    public List<DetalleVenta>listarCondicion(String condicion){
        return dao.enlistar(condicion);
    }
    public DetalleVenta obtenerId(Long id){
        return dao.obtenerPorId(id);
    }
}
