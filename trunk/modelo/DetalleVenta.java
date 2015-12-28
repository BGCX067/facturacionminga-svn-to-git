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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_detalle;
    private int cant_detalle;
    private double pu_detalle;
    private double pv_detalle;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "id_servicio",nullable = true, referencedColumnName = "id_servicio")
    private Servicio servicio;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "id_lote",nullable = true, referencedColumnName = "id_lote")
    private LoteProducto lote;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "id_venta",nullable = false, referencedColumnName = "id_venta")
    private Venta venta;

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public Long getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(Long id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getCant_detalle() {
        return cant_detalle;
    }

    public void setCant_detalle(int cant_detalle) {
        this.cant_detalle = cant_detalle;
    }

    public double getPu_detalle() {
        return pu_detalle;
    }

    public void setPu_detalle(double pu_detalle) {
        this.pu_detalle = pu_detalle;
    }

    public double getPv_detalle() {
        return pv_detalle;
    }

    public void setPv_detalle(double pv_detalle) {
        this.pv_detalle = pv_detalle;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public LoteProducto getLote() {
        return lote;
    }

    public void setLote(LoteProducto lote) {
        this.lote = lote;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_detalle != null ? id_detalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.id_detalle == null && other.id_detalle != null) || (this.id_detalle != null && !this.id_detalle.equals(other.id_detalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pv_detalle+" "+pu_detalle;
    }
    
}
