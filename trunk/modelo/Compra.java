/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "compra")
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_compra;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_compra=new Date();
    @Temporal(TemporalType.DATE)
    private Date fechaFct_compra;
    private double subtotal=0;
    private double iva=0;
    private double descuento=0;
    private double total=0;
    @Column(length = 50)
    private String num_compra;
    @Column(length = 50)
    private String numFact_compra;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "id_proveedor",nullable = false, referencedColumnName = "id_persona")
    private Proveedor proveedor;
    @OneToOne(mappedBy = "compra",cascade = CascadeType.ALL, fetch = FetchType.LAZY)    
    private Archivo archivo;
    @OneToOne(mappedBy = "compra", cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
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
    
    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }
    
    public Long getId_compra() {
        return id_compra;
    }

    public void setId_compra(Long id_compra) {
        this.id_compra = id_compra;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public Date getFechaFct_compra() {
        return fechaFct_compra;
    }

    public void setFechaFct_compra(Date fechaFct_compra) {
        this.fechaFct_compra = fechaFct_compra;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNum_compra() {
        return num_compra;
    }

    public void setNum_compra(String num_compra) {
        this.num_compra = num_compra;
    }

    public String getNumFact_compra() {
        return numFact_compra;
    }

    public void setNumFact_compra(String numFact_compra) {
        this.numFact_compra = numFact_compra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_compra != null ? id_compra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.id_compra == null && other.id_compra != null) || (this.id_compra != null && !this.id_compra.equals(other.id_compra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Compra[ id=" + id_compra + " ]";
    }
    
}
