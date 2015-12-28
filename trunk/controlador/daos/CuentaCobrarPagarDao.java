/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.daos;

import controlador.Conecion;
import modelo.CuentaCobrarPagar;

/**
 *
 * @author jose
 */
public class CuentaCobrarPagarDao extends DaoAdaptador<CuentaCobrarPagar>{
    private CuentaCobrarPagar cuenta_cp;

    public CuentaCobrarPagarDao() {
        super(CuentaCobrarPagar.class, Conecion.getEm());
    }

    public CuentaCobrarPagar getCuentaCobrarPagar() {
        if (cuenta_cp == null) {
            cuenta_cp = new CuentaCobrarPagar();
        }
        return cuenta_cp;
    }

    public void fijarInstancia(CuentaCobrarPagar a) {
        this.cuenta_cp = a;
    }

    public void nuevaInstancia() {
        this.cuenta_cp = null;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            this.getManager().getTransaction().begin();
            if (this.cuenta_cp.getId_cuenta_cp()== null) {
                this.guardar(cuenta_cp);
            }else{
                this.modificar(cuenta_cp);
            }
            this.getManager().getTransaction().commit();
            //this.getManager().close();
            band=true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return band;
    }
    public boolean eliminar(){
        boolean band = false;
        try{
            this.getManager().getTransaction().begin();
            this.eliminar(this.cuenta_cp);
            this.getManager().getTransaction().commit();
            band = true;            
        }catch (Exception ex){
            System.out.println("Error en eliminar "+ex);
        }
        return band;
    }
}
