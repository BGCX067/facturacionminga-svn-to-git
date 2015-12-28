/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.daos;

import controlador.Conecion;
import modelo.Cuota;

/**
 *
 * @author jose
 */
public class CuotasDaos extends DaoAdaptador<Cuota>{
     private Cuota marca;

    public CuotasDaos() {
        super(Cuota.class, Conecion.getEm());
    }

    public Cuota getCuota() {
        if (marca == null) {
            marca = new Cuota();
        }
        return marca;
    }

    public void fijarInstancia(Cuota a) {
        this.marca = a;
    }

    public void nuevaInstancia() {
        this.marca = null;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            this.getManager().getTransaction().begin();
            if (this.marca.getId_cuota()== null) {
                this.guardar(marca);
            }else{
                this.modificar(marca);
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
