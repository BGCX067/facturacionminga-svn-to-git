/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.daos;

import controlador.Conecion;

import modelo.Archivo;

/**
 *
 * @author alex
 */
public class ArchivoDao extends DaoAdaptador<Archivo> {

    private Archivo archivo;

    public ArchivoDao() {
        super(Archivo.class, Conecion.getEm());
    }

    public Archivo getArchivo() {
        if (archivo == null) {
            archivo = new Archivo();
        }
        return archivo;
    }

    public void fijarInstancia(Archivo a) {
        this.archivo = a;
    }

    public void nuevaInstancia() {
        this.archivo = null;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            this.getManager().getTransaction().begin();
            if (this.archivo.getId_archivo() == null) {
                this.guardar(archivo);
            }else{
                this.modificar(archivo);
            }
            this.getManager().getTransaction().commit();
            band=true;
            //this.getManager().close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return band;
    }
    
}
