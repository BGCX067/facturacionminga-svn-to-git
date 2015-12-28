/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Date;
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
 * @author jose
 */
@Entity
@Table(name = "cuota")
public class Cuota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cuota;
    private Date fecha;
    private Date fecha_pago=new Date();
    private double valor;
    private boolean pagado=false;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "id_cuenta_cp",nullable = false, referencedColumnName = "id_cuenta_cp")
    private CuentaCobrarPagar cuentapg;

    public Long getId_cuota() {
        return id_cuota;
    }

    public void setId_cuota(Long id_cuota) {
        this.id_cuota = id_cuota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public CuentaCobrarPagar getCuentapg() {
        return cuentapg;
    }

    public void setCuentapg(CuentaCobrarPagar cuentapg) {
        this.cuentapg = cuentapg;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_cuota != null ? id_cuota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuota)) {
            return false;
        }
        Cuota other = (Cuota) object;
        if ((this.id_cuota == null && other.id_cuota != null) || (this.id_cuota != null && !this.id_cuota.equals(other.id_cuota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cuota[ id=" + id_cuota + " ]";
    }
    
}
