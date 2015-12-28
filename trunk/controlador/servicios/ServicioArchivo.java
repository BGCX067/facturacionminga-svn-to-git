/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servicios;

import controlador.daos.ArchivoDao;
import java.util.List;
import modelo.Archivo;

/**
 *
 * @author jose
 */
public class ServicioArchivo {
    private ArchivoDao dao;

    public ServicioArchivo() {
        dao = new ArchivoDao();
    }
    public Archivo getArchivo() {
        return dao.getArchivo();
    }
    public void fijarInstancia(Archivo a) {
        dao.fijarInstancia(a);
    }
    public void nuevaInstancia() {
        dao.nuevaInstancia();
    }
    public boolean guardar() {
        return dao.guardar();
    }
    public List<Archivo>listar(){
        return dao.enlistar("");
    }
    public List<Archivo>listarCondicion(String condicion){
        return dao.enlistar(condicion);
    }
    public Archivo obtenerId(Long id){
        return dao.obtenerPorId(id);
    }
}
