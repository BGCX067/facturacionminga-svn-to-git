/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.daos;

import controlador.Conecion;

import modelo.Producto;

/**
 *
 * @author alex
 */
public class ProductoDao extends DaoAdaptador<Producto> {

    private Producto producto;

    public ProductoDao() {
        super(Producto.class, Conecion.getEm());
    }

    public Producto getProducto() {
        if (producto == null) {
            producto = new Producto();
        }
        return producto;
    }

    public void fijarInstancia(Producto a) {
        this.producto = a;
    }

    public void nuevaInstancia() {
        this.producto = null;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            this.getManager().getTransaction().begin();
            if (this.producto.getId_producto()== null) {
                this.guardar(producto);
            }else{
                this.modificar(producto);
            }
            this.getManager().getTransaction().commit();
            //this.getManager().close();
            band=true;
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return band;
    }
    
}
