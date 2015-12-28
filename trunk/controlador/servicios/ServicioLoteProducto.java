/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servicios;

import controlador.daos.LoteProductoDao;
import java.util.List;
import modelo.LoteProducto;

/**
 *
 * @author jose
 */
public class ServicioLoteProducto {
    private LoteProductoDao dao;
    /**
     * Constructor de la clase
     */
    public ServicioLoteProducto() {
        dao = new LoteProductoDao();
    }
    public LoteProducto getLoteProducto() {
        return dao.getLoteProducto();
    }
    public void fijarInstancia(LoteProducto a) {
        dao.fijarInstancia(a);
    }
    public void nuevaInstancia() {
        dao.nuevaInstancia();
    }
    public boolean guardar() {
        return dao.guardar();
    }
    public List<LoteProducto>listar(){
        return dao.enlistar("");
    }
    public List<LoteProducto>listarCondicion(String condicion){
        return dao.enlistar(condicion);
    }
    public LoteProducto obtenerId(Long id){
        return dao.obtenerPorId(id);
    }
    public List<LoteProducto>buscar(String criterio, String texto){
        return dao.enlistar(" where "+criterio+" like CONCAT('"+texto+"','%')");
    }
    public List<LoteProducto>buscarLike(String texto){
        return dao.enlistar(" where p.producto.tipo.nombre_tipo like CONCAT('"+texto+"','%') OR p.producto.marca.nombre_marca like CONCAT('"+texto+"','%') OR p.codBarra_lote like CONCAT('"+texto+"','%')");
    }
}
