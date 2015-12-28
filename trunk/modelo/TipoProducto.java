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
@Table(name = "tipoProducto")
public class TipoProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_tipo;
    @Column(length = 100)
    private String nombre_tipo;
    private boolean estado_tipo=true;
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Producto> listaProducto = new ArrayList<Producto>();

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    public Long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public boolean isEstado_tipo() {
        return estado_tipo;
    }

    public void setEstado_tipo(boolean estado_tipo) {
        this.estado_tipo = estado_tipo;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_tipo != null ? id_tipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_tipo fields are not set
        if (!(object instanceof TipoProducto)) {
            return false;
        }
        TipoProducto other = (TipoProducto) object;
        if ((this.id_tipo == null && other.id_tipo != null) || (this.id_tipo != null && !this.id_tipo.equals(other.id_tipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nombre_tipo;
    }
    
}
