/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.daos;

import controlador.Conecion;
import javax.persistence.Query;


import modelo.Proveedor;

/**
 *
 * @author alex
 */
public class ProveedorDao extends DaoAdaptador<Proveedor> {

    private Proveedor proveedor;

    public ProveedorDao() {
        super(Proveedor.class, Conecion.getEm());
    }

    public Proveedor getProveedor() {
        if (proveedor == null) {
            proveedor = new Proveedor();
        }
        return proveedor;
    }

    public void fijarInstancia(Proveedor a) {
        this.proveedor = a;
    }

    public void nuevaInstancia() {
        this.proveedor = null;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            this.getManager().getTransaction().begin();
            if (this.proveedor.getId_persona()== null) {
                this.guardar(proveedor);
            }else{
                this.modificar(proveedor);
            }
            this.getManager().getTransaction().commit();
            //this.getManager().close();
            band=true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return band;
    }
    public Proveedor obtenerPersonaCedula(String cedula){
        Proveedor p=null;
        try {
            String query = "select p from Proveedor p where p.cedula_per = ?";
            Query q = this.getManager().createQuery(query);
            q.setParameter(1, cedula);
            p = (Proveedor)q.getSingleResult();
        } catch (Exception e) {
        }
        return p;
    }
}
