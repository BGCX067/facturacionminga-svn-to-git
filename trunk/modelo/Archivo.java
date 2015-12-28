/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "respaldo_compra")
public class Archivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_archivo;
    private String direccion_arch;
    private String nombre_arch;
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "id_compra", nullable = true, referencedColumnName = "id_compra")
    private Compra compra;

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
    public Long getId_archivo() {
        return id_archivo;
    }

    public void setId_archivo(Long id_archivo) {
        this.id_archivo = id_archivo;
    }

    public String getDireccion_arch() {
        return direccion_arch;
    }

    public void setDireccion_arch(String direccion_arch) {
        this.direccion_arch = direccion_arch;
    }

    public String getNombre_arch() {
        return nombre_arch;
    }

    public void setNombre_arch(String nombre_arch) {
        this.nombre_arch = nombre_arch;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_archivo != null ? id_archivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivo)) {
            return false;
        }
        Archivo other = (Archivo) object;
        if ((this.id_archivo == null && other.id_archivo != null) || (this.id_archivo != null && !this.id_archivo.equals(other.id_archivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Archivo[ id=" + id_archivo + " ]";
    }
    
}
