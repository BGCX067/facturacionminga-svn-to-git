/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.daos;

import controlador.Conecion;
import java.util.List;
import javax.persistence.Query;
import modelo.Persona;

/**
 *
 * @author alex
 */
public class PersonaDao extends DaoAdaptador<Persona> {

    private Persona persona;

    public PersonaDao() {
        super(Persona.class, Conecion.getEm());
    }

    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
        }
        return persona;
    }

    public void fijarInstancia(Persona a) {
        this.persona = a;
    }

    public void nuevaInstancia() {
        this.persona = null;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            this.getManager().getTransaction().begin();
            if (this.persona.getId_persona()== null) {
                this.guardar(persona);
            }else{
                this.modificar(persona);
            }
            this.getManager().getTransaction().commit();
            //this.getManager().close();
            band=true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return band;
    }
    public Persona obtenerPersonaCedula(String cedula){
        Persona p=null;
        try {
            String query = "select p from Persona p where p.cedula_per = ?";
            Query q = this.getManager().createQuery(query);
            q.setParameter(1, cedula);
            p = (Persona)q.getSingleResult();
        } catch (Exception e) {
        }
        return p;
    }
    
}
