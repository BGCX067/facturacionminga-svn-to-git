/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servicios;

import controlador.daos.ProductoDao;
import java.util.List;

import modelo.Producto;

/**
 *
 * @author jose
 */
public class ServicioProducto {
    private ProductoDao dao;

    public ServicioProducto() {
        dao = new ProductoDao();
    }
    public Producto getProducto() {
        return dao.getProducto();
    }
    public void fijarInstancia(Producto a) {
        dao.fijarInstancia(a);
    }
    public void nuevaInstancia() {
        dao.nuevaInstancia();
    }
    public boolean guardar() {
        return dao.guardar();
    }
    public List<Producto>listar(){
        return dao.enlistar("");
    }
    public List<Producto>listarCondicion(String condicion){
        return dao.enlistar(condicion);
    }
    public Producto obtenerId(Long id){
        return dao.obtenerPorId(id);
    }
    public List<Producto>buscar(String criterio, String texto){
        return dao.enlistar(" where "+criterio+" like CONCAT('"+texto+"','%')");
    }
}
