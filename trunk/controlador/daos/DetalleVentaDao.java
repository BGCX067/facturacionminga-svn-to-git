/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.daos;

import controlador.Conecion;

import modelo.DetalleVenta;

/**
 *
 * @author alex
 */
public class DetalleVentaDao extends DaoAdaptador<DetalleVenta> {

    private DetalleVenta detalleVenta;

    public DetalleVentaDao() {
        super(DetalleVenta.class, Conecion.getEm());
    }

    public DetalleVenta getDetalleVenta() {
        if (detalleVenta == null) {
            detalleVenta = new DetalleVenta();
        }
        return detalleVenta;
    }

    public void fijarInstancia(DetalleVenta a) {
        this.detalleVenta = a;
    }

    public void nuevaInstancia() {
        this.detalleVenta = null;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            this.getManager().getTransaction().begin();
            if (this.detalleVenta.getId_detalle()== null) {
                this.guardar(detalleVenta);
            }else{
                this.modificar(detalleVenta);
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
