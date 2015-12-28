/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "marca")
public class Marca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_marca;
    @Column(length = 100)
    private String nombre_marca;
    private boolean estado_marca=true;
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Producto> listaProducto = new ArrayList<Producto>();

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    public Long getId_marca() {
        return id_marca;
    }

    public void setId_marca(Long id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public boolean isEstado_marca() {
        return estado_marca;
    }

    public void setEstado_marca(boolean estado_marca) {
        this.estado_marca = estado_marca;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_marca != null ? id_marca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_marca fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.id_marca == null && other.id_marca != null) || (this.id_marca != null && !this.id_marca.equals(other.id_marca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nombre_marca;
    }
    
}
