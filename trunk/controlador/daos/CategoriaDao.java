/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.daos;

import controlador.Conecion;

import modelo.Categoria;

/**
 *
 * @author alex
 */
public class CategoriaDao extends DaoAdaptador<Categoria> {

    private Categoria categoria;

    public CategoriaDao() {
        super(Categoria.class, Conecion.getEm());
    }

    public Categoria getCategoria() {
        if (categoria == null) {
            categoria = new Categoria();
        }
        return categoria;
    }

    public void fijarInstancia(Categoria a) {
        this.categoria = a;
    }

    public void nuevaInstancia() {
        this.categoria = null;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            this.getManager().getTransaction().begin();
            if (this.categoria.getId_categoria()== null) {
                this.guardar(categoria);
            }else{
                this.modificar(categoria);
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
