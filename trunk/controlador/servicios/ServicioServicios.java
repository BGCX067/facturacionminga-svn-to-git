/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servicios;

import controlador.daos.ServicioDao;
import java.util.List;
import modelo.Servicio;

/**
 *
 * @author jose
 */
public class ServicioServicios {
    private ServicioDao dao;

    public ServicioServicios() {
        dao = new ServicioDao();
    }
    public Servicio getServicio() {
        return dao.getServicio();
    }
    public void fijarInstancia(Servicio a) {
        dao.fijarInstancia(a);
    }
    public void nuevaInstancia() {
        dao.nuevaInstancia();
    }
    public boolean guardar() {
        return dao.guardar();
    }
    public List<Servicio>listar(){
        return dao.enlistar("");
    }
    public List<Servicio>listarCondicion(String condicion){
        return dao.enlistar(condicion);
    }
    public Servicio obtenerId(Long id){
        return dao.obtenerPorId(id);
    }
    public List<Servicio>buscar(String criterio, String texto){
        return dao.enlistar(" where "+criterio+" like CONCAT('"+texto+"','%')");
    }
}
