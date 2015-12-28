/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.daos;

import controlador.Conecion;
import javax.persistence.Query;

import modelo.Cuenta;
import modelo.Rol;

/**
 *
 * @author alex
 */
public class CuentaDao extends DaoAdaptador<Cuenta> {

    private Cuenta cuenta;

    public CuentaDao() {
        super(Cuenta.class, Conecion.getEm());
    }

    public Cuenta getCuenta() {
        if (cuenta == null) {
            cuenta = new Cuenta();
        }
        return cuenta;
    }

    public void fijarInstancia(Cuenta a) {
        this.cuenta = a;
    }

    public void nuevaInstancia() {
        this.cuenta = null;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            this.getManager().getTransaction().begin();
            if (this.cuenta.getId_cuenta()== null) {
                this.guardar(cuenta);
            }else{
                this.modificar(cuenta);
            }
            this.getManager().getTransaction().commit();
            //this.getManager().close();
            band=true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return band;
    }
    public Cuenta inicio(String user, String clave){
        Cuenta r=null;
        try {
            String query = "select r from Cuenta r where r.usuario_cuenta = ? and r.clave_cuenta = ?";
            Query q = this.getManager().createQuery(query);
            q.setParameter(1, user);
            q.setParameter(2, clave);
            r = (Cuenta)q.getSingleResult();
        } catch (Exception e) {
        }
        return r;
    }
}
