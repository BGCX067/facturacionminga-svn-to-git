/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servicios;

import controlador.daos.CuentaDao;
import java.util.List;
import modelo.Cuenta;

/**
 *
 * @author jose
 */
public class ServicioCuenta {
    private CuentaDao dao;

    public ServicioCuenta() {
        dao = new CuentaDao();
    }
    public Cuenta getCuenta() {
        return dao.getCuenta();
    }
    public void fijarInstancia(Cuenta a) {
        dao.fijarInstancia(a);
    }
    public void nuevaInstancia() {
        dao.nuevaInstancia();
    }
    public boolean guardar() {
        return dao.guardar();
    }
    public List<Cuenta>listar(){
        return dao.enlistar("");
    }
    public List<Cuenta>listarCondicion(String condicion){
        return dao.enlistar(condicion);
    }
    public Cuenta obtenerId(Long id){
        return dao.obtenerPorId(id);
    }
    public Cuenta inicio(String user, String clave){
        return dao.inicio(user, clave);
    }
}
