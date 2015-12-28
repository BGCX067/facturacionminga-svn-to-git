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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "venta")
public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_venta;
    @Column(length = 50)
    private String nro_venta;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente",nullable = true, referencedColumnName = "id_persona")
    private Persona cliente;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_venta;
    private Double subtotal;
    private Double iva;
    private Double descuento;
    private Double total;
    @Column(length = 20)
    private String estado;
    @Column(length = 600)
    private String observacion;
    private String tipo_fact="factura";//factura, orden, factura_orden   
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta>listaDetalle = new ArrayList<DetalleVenta>();//para el detalle de venta
    @OneToOne(mappedBy = "venta", cascade = {CascadeType.REFRESH, CascadeType.MERGE,CascadeType.ALL}, fetch = FetchType.LAZY)
    private CuentaCobrarPagar cuentapc;
    private String tipo_pago="Contado";

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }
    
    public CuentaCobrarPagar getCuentapc() {
        return cuentapc;
    }

    public void setCuentapc(CuentaCobrarPagar cuentapc) {
        this.cuentapc = cuentapc;
    }
    
    public String getTipo_fact() {
        return tipo_fact;
    }

    public void setTipo_fact(String tipo_fact) {
        this.tipo_fact = tipo_fact;
    }

    public List<DetalleVenta> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetalleVenta> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }
    
    public Long getId_venta() {
        return id_venta;
    }

    public void setId_venta(Long id_venta) {
        this.id_venta = id_venta;
    }

    public String getNro_venta() {
        return nro_venta;
    }

    public void setNro_venta(String nro_venta) {
        this.nro_venta = nro_venta;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_venta != null ? id_venta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_venta fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id_venta == null && other.id_venta != null) || (this.id_venta != null && !this.id_venta.equals(other.id_venta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Venta[ id=" + id_venta + " ]";
    }
    
}
