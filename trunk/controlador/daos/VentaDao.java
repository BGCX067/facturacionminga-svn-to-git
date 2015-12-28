/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.daos;

import controlador.Conecion;

import modelo.Venta;

/**
 *
 * @author alex
 */
public class VentaDao extends DaoAdaptador<Venta> {

    private Venta venta;

    public VentaDao() {
        super(Venta.class, Conecion.getEm());
    }

    public Venta getVenta() {
        if (venta == null) {
            venta = new Venta();
        }
        return venta;
    }

    public void fijarInstancia(Venta a) {
        this.venta = a;
    }

    public void nuevaInstancia() {
        this.venta = null;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            this.getManager().getTransaction().begin();
            if (this.venta.getId_venta()== null) {
                this.guardar(venta);
            }else{
                this.modificar(venta);
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
