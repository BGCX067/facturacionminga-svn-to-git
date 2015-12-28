/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servicios;

import controlador.daos.CuotasDaos;
import java.util.List;
import modelo.Cuota;

/**
 *
 * @author jose
 */
public class ServicioCuota {
    private CuotasDaos dao;

    public ServicioCuota() {
        dao = new CuotasDaos();
    }
    public Cuota getCuota() {
        return dao.getCuota();
    }
    public void fijarInstancia(Cuota a) {
        dao.fijarInstancia(a);
    }
    public void nuevaInstancia() {
        dao.nuevaInstancia();
    }
    public boolean guardar() {
        return dao.guardar();
    }
    public List<Cuota>listar(){
        return dao.enlistar("");
    }
    public List<Cuota>listarCondicion(String condicion){
        return dao.enlistar(condicion);
    }
    public Cuota obtenerId(Long id){
        return dao.obtenerPorId(id);
    }
}
