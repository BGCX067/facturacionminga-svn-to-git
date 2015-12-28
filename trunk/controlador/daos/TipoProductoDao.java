/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.daos;

import controlador.Conecion;

import modelo.TipoProducto;

/**
 *
 * @author alex
 */
public class TipoProductoDao extends DaoAdaptador<TipoProducto> {

    private TipoProducto tipoProducto;

    public TipoProductoDao() {
        super(TipoProducto.class, Conecion.getEm());
    }

    public TipoProducto getTipoProducto() {
        if (tipoProducto == null) {
            tipoProducto = new TipoProducto();
        }
        return tipoProducto;
    }

    public void fijarInstancia(TipoProducto a) {
        this.tipoProducto = a;
    }

    public void nuevaInstancia() {
        this.tipoProducto = null;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            this.getManager().getTransaction().begin();
            if (this.tipoProducto.getId_tipo()== null) {
                this.guardar(tipoProducto);
            }else{
                this.modificar(tipoProducto);
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
