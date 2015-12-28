/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servicios;

import controlador.daos.PersonaDao;
import java.util.List;
import modelo.Persona;

/**
 *
 * @author jose
 */
public class ServicioPersona {
    private PersonaDao dao;

    public ServicioPersona() {
        dao = new PersonaDao();
    }
    public Persona getPersona() {
        return dao.getPersona();
    }
    public void fijarInstancia(Persona a) {
        dao.fijarInstancia(a);
    }
    public void nuevaInstancia() {
        dao.nuevaInstancia();
    }
    public boolean guardar() {
        return dao.guardar();
    }
    public List<Persona>listar(){
        return dao.enlistar("");
    }
    public List<Persona>listarCondicion(String condicion){
        return dao.enlistar(condicion);
    }
    public Persona obtenerId(Long id){
        return dao.obtenerPorId(id);
    }
    public Persona obtenerPersonaCedula(String cedula){
        return dao.obtenerPersonaCedula(cedula);
    }
    public List<Persona>buscar(String criterio, String texto){
        return dao.enlistar(" where "+criterio+" like CONCAT('"+texto+"','%')");
    }
}
