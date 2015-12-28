/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servicios;

import controlador.daos.TipoProductoDao;
import java.util.List;
import modelo.TipoProducto;

/**
 *
 * @author jose
 */
public class ServicioTipoProducto {
    private TipoProductoDao dao;

    public ServicioTipoProducto() {
        dao = new TipoProductoDao();
    }
    public TipoProducto getTipoProducto() {
        return dao.getTipoProducto();
    }
    public void fijarInstancia(TipoProducto a) {
        dao.fijarInstancia(a);
    }
    public void nuevaInstancia() {
        dao.nuevaInstancia();
    }
    public boolean guardar() {
        return dao.guardar();
    }
    public List<TipoProducto>listar(){
        return dao.enlistar("");
    }
    public List<TipoProducto>listarCondicion(String condicion){
        return dao.enlistar(condicion);
    }
    public TipoProducto obtenerId(Long id){
        return dao.obtenerPorId(id);
    }
}
