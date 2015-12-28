/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.daos;

import controlador.Conecion;

import modelo.LoteProducto;

/**
 *
 * @author alex
 */
public class LoteProductoDao extends DaoAdaptador<LoteProducto> {

    private LoteProducto loteProducto;
    /**
     * Constructor de la clase
     */
    public LoteProductoDao() {
        super(LoteProducto.class, Conecion.getEm());
    }

    public LoteProducto getLoteProducto() {
        if (loteProducto == null) {
            loteProducto = new LoteProducto();
        }
        return loteProducto;
    }

    public void fijarInstancia(LoteProducto a) {
        this.loteProducto = a;
    }

    public void nuevaInstancia() {
        this.loteProducto = null;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            this.getManager().getTransaction().begin();
            if (this.loteProducto.getId_lote()== null) {
                this.guardar(loteProducto);
            }else{
                this.modificar(loteProducto);
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
