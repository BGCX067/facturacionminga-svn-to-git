/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.daos;

import controlador.Conecion;

import modelo.Compra;

/**
 *
 * @author alex
 */
public class CompraDao extends DaoAdaptador<Compra> {

    private Compra compra;

    public CompraDao() {
        super(Compra.class, Conecion.getEm());
    }

    public Compra getCompra() {
        if (compra == null) {
            compra = new Compra();
        }
        return compra;
    }

    public void fijarInstancia(Compra a) {
        this.compra = a;
    }

    public void nuevaInstancia() {
        this.compra = null;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            this.getManager().getTransaction().begin();
            if (this.compra.getId_compra()== null) {
                this.guardar(compra);
            }else{
                this.modificar(compra);
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
