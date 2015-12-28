/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "proveedor")
public class Proveedor extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(length = 255)
    private String empresa_prov;
    @Column(length = 255)
    private String direccion_prov;
    @Column(length = 13, unique = true)
    private String ruc_prov; 

    public String getEmpresa_prov() {
        return empresa_prov;
    }

    public void setEmpresa_prov(String empresa_prov) {
        this.empresa_prov = empresa_prov;
    }

    public String getDireccion_prov() {
        return direccion_prov;
    }

    public void setDireccion_prov(String direccion_prov) {
        this.direccion_prov = direccion_prov;
    }

    public String getRuc_prov() {
        return ruc_prov;
    }

    public void setRuc_prov(String ruc_prov) {
        this.ruc_prov = ruc_prov;
    }
   

    @Override
    public String toString() {
        return this.getApellidos_per()+" "+this.getNombres_per();
    }
    
}
