/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "lote_producto")
public class LoteProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_lote;
    @Column(length = 50)
    private String codBarra_lote;
    private double pc_lote;
    private double pv_lote;
    @Column(length = 50)
    private String nro_compra;
    private int stock;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "id_producto",nullable = false, referencedColumnName = "id_producto")
    private Producto producto;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso_lote;
    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL)
    private List<DetalleVenta> listaDetalle = new ArrayList<DetalleVenta>();
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Long getId_lote() {
        return id_lote;
    }

    public void setId_lote(Long id_lote) {
        this.id_lote = id_lote;
    }

    public String getCodBarra_lote() {
        return codBarra_lote;
    }

    public void setCodBarra_lote(String codBarra_lote) {
        this.codBarra_lote = codBarra_lote;
    }

    public double getPc_lote() {
        return pc_lote;
    }

    public void setPc_lote(double pc_lote) {
        this.pc_lote = pc_lote;
    }

    public double getPv_lote() {
        return pv_lote;
    }

    public void setPv_lote(double pv_lote) {
        this.pv_lote = pv_lote;
    }

    public String getNro_compra() {
        return nro_compra;
    }

    public void setNro_compra(String nro_compra) {
        this.nro_compra = nro_compra;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFechaIngreso_lote() {
        return fechaIngreso_lote;
    }

    public void setFechaIngreso_lote(Date fechaIngreso_lote) {
        this.fechaIngreso_lote = fechaIngreso_lote;
    }

    public List<DetalleVenta> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetalleVenta> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_lote != null ? id_lote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoteProducto)) {
            return false;
        }
        LoteProducto other = (LoteProducto) object;
        if ((this.id_lote == null && other.id_lote != null) || (this.id_lote != null && !this.id_lote.equals(other.id_lote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.LoteProducto[ id=" + id_lote + " ]";
    }
    
}
