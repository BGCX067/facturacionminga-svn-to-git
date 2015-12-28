/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.daos;

import controlador.Conecion;

import modelo.Marca;

/**
 *
 * @author alex
 */
public class MarcaDao extends DaoAdaptador<Marca> {

    private Marca marca;

    public MarcaDao() {
        super(Marca.class, Conecion.getEm());
    }

    public Marca getMarca() {
        if (marca == null) {
            marca = new Marca();
        }
        return marca;
    }

    public void fijarInstancia(Marca a) {
        this.marca = a;
    }

    public void nuevaInstancia() {
        this.marca = null;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            this.getManager().getTransaction().begin();
            if (this.marca.getId_marca()== null) {
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
