/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servicios;

import controlador.daos.MarcaDao;
import java.util.List;
import modelo.Marca;

/**
 *
 * @author jose
 */
public class ServicioMarca {
    private MarcaDao dao;

    public ServicioMarca() {
        dao = new MarcaDao();
    }
    public Marca getMarca() {
        return dao.getMarca();
    }
    public void fijarInstancia(Marca a) {
        dao.fijarInstancia(a);
    }
    public void nuevaInstancia() {
        dao.nuevaInstancia();
    }
    public boolean guardar() {
        return dao.guardar();
    }
    public List<Marca>listar(){
        return dao.enlistar("");
    }
    public List<Marca>listarCondicion(String condicion){
        return dao.enlistar(condicion);
    }
    public Marca obtenerId(Long id){
        return dao.obtenerPorId(id);
    }
}
