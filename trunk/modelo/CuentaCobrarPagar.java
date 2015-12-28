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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "cuentaCobrarPagar")
public class CuentaCobrarPagar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cuenta_cp;
    private double abono;
    private double saldo_actual;
    private int nro_cuotas;
    private String estado="activo";
    private String tipo="";
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id_venta", nullable = true, columnDefinition = "id_venta")
    private Venta venta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id_compra", nullable = true, columnDefinition = "id_compra")
    private Compra compra;
    @OneToMany(mappedBy = "cuentapg", cascade = CascadeType.ALL)
    private List<Cuota> listaCuotas = new ArrayList<>();

    public List<Cuota> getListaCuotas() {
        return listaCuotas;
    }

    public void setListaCuotas(List<Cuota> listaCuotas) {
        this.listaCuotas = listaCuotas;
    }
    
    public Long getId_cuenta_cp() {
        return id_cuenta_cp;
    }

    public void setId_cuenta_cp(Long id_cuenta_cp) {
        this.id_cuenta_cp = id_cuenta_cp;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public double getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(double saldo_actual) {
        this.saldo_actual = saldo_actual;
    }

    public int getNro_cuotas() {
        return nro_cuotas;
    }

    public void setNro_cuotas(int nro_cuotas) {
        this.nro_cuotas = nro_cuotas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_cuenta_cp != null ? id_cuenta_cp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaCobrarPagar)) {
            return false;
        }
        CuentaCobrarPagar other = (CuentaCobrarPagar) object;
        if ((this.id_cuenta_cp == null && other.id_cuenta_cp != null) || (this.id_cuenta_cp != null && !this.id_cuenta_cp.equals(other.id_cuenta_cp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CuentaCobrarPagar[ id=" + id_cuenta_cp + " ]";
    }
    
}
