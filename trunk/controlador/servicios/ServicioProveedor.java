/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servicios;

import controlador.daos.ProveedorDao;
import java.util.List;
import modelo.Proveedor;

/**
 *
 * @author alex
 */
public class ServicioProveedor {
    private ProveedorDao dao;

    public ServicioProveedor() {
        dao = new ProveedorDao();
    }
    public Proveedor getProveedor() {
        return dao.getProveedor();
    }
    public void fijarInstancia(Proveedor a) {
        dao.fijarInstancia(a);
    }
    public void nuevaInstancia() {
        dao.nuevaInstancia();
    }
    public boolean guardar() {
        return dao.guardar();
    }
    public List<Proveedor>listar(){
        return dao.enlistar("");
    }
    public List<Proveedor>listarCondicion(String condicion){
        return dao.enlistar(condicion);
    }
    public Proveedor obtenerId(Long id){
        return dao.obtenerPorId(id);
    }
    public List<Proveedor>buscar(String criterio, String texto){
        return dao.enlistar(" where "+criterio+" like CONCAT('"+texto+"','%')");
    }
    public Proveedor obtenerPersonaCedula(String cedula){
        return dao.obtenerPersonaCedula(cedula);
    }
}
