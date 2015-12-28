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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_servicio;
    @Column(length = 150)
    private String cod_servicio;
    private Double costo_serv;//sin iva
    @Column(length = 150)
    private String nombre_serv;
    @Column(length = 600)
    private String descripcion_serv; 
    @Column(length = 20)
    private String estado_serv = "En uso";
    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<DetalleVenta> listaDetalle = new ArrayList<DetalleVenta>();
    
    public String getEstado_serv() {
        return estado_serv;
    }

    public void setEstado_serv(String estado_serv) {
        this.estado_serv = estado_serv;
    }

    
    
    public String getCod_servicio() {
        return cod_servicio;
    }

    public void setCod_servicio(String cod_servicio) {
        this.cod_servicio = cod_servicio;
    }

    public List<DetalleVenta> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetalleVenta> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }
    
    
    
    public Long getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Long id_servicio) {
        this.id_servicio = id_servicio;
    }

    public Double getCosto_serv() {
        return costo_serv;
    }

    public void setCosto_serv(Double costo_serv) {
        this.costo_serv = costo_serv;
    }

    public String getNombre_serv() {
        return nombre_serv;
    }

    public void setNombre_serv(String nombre_serv) {
        this.nombre_serv = nombre_serv;
    }

    public String getDescripcion_serv() {
        return descripcion_serv;
    }

    public void setDescripcion_serv(String descripcion_serv) {
        this.descripcion_serv = descripcion_serv;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_servicio != null ? id_servicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_servicio fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.id_servicio == null && other.id_servicio != null) || (this.id_servicio != null && !this.id_servicio.equals(other.id_servicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nombre_serv;
    }
    
}
