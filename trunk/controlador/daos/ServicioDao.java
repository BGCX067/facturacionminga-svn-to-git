/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.daos;

import controlador.Conecion;

import modelo.Servicio;

/**
 *
 * @author alex
 */
public class ServicioDao extends DaoAdaptador<Servicio> {

    private Servicio servicio;

    public ServicioDao() {
        super(Servicio.class, Conecion.getEm());
    }

    public Servicio getServicio() {
        if (servicio == null) {
            servicio = new Servicio();
        }
        return servicio;
    }

    public void fijarInstancia(Servicio a) {
        this.servicio = a;
    }

    public void nuevaInstancia() {
        this.servicio = null;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            this.getManager().getTransaction().begin();
            if (this.servicio.getId_servicio()== null) {
                this.guardar(servicio);
            }else{
                this.modificar(servicio);
            }
            this.getManager().getTransaction().commit();
            //this.getManager().close();
            band=true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return band;
    }
    
}
