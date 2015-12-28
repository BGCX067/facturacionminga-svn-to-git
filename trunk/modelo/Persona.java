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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_persona;
    @Column(length = 13, unique = true)
    private String cedula_per;
    @Column(length = 70)
    private String apellidos_per;
    @Column(length = 70)
    private String nombres_per;
    private String direccion_per;
    @Column(length = 20)
    private String fono_per;
    @Column(length = 2)
    private String genero_per;
    @Column(length = 20)
    private String estado_per="activo";
    @Temporal(TemporalType.DATE)
    private Date fechaNac_per;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "id_rol",nullable = false, referencedColumnName = "id_rol")
    private Rol rol;
    @OneToOne(mappedBy = "persona", cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Cuenta cuenta;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Venta>listaVenta = new ArrayList<Venta>();

    public List<Venta> getListaVenta() {
        return listaVenta;
    }

    public void setListaVenta(List<Venta> listaVenta) {
        this.listaVenta = listaVenta;
    }
    
    public String getGenero_per() {
        return genero_per;
    }

    public void setGenero_per(String genero_per) {
        this.genero_per = genero_per;
    }
    
    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getCedula_per() {
        return cedula_per;
    }

    public void setCedula_per(String cedula_per) {
        this.cedula_per = cedula_per;
    }

    public String getApellidos_per() {
        return apellidos_per;
    }

    public void setApellidos_per(String apellidos_per) {
        this.apellidos_per = apellidos_per;
    }

    public String getNombres_per() {
        return nombres_per;
    }

    public void setNombres_per(String nombres_per) {
        this.nombres_per = nombres_per;
    }

    public String getDireccion_per() {
        return direccion_per;
    }

    public void setDireccion_per(String direccion_per) {
        this.direccion_per = direccion_per;
    }

    public String getFono_per() {
        return fono_per;
    }

    public void setFono_per(String fono_per) {
        this.fono_per = fono_per;
    }

    public String getEstado_per() {
        return estado_per;
    }

    public void setEstado_per(String estado_per) {
        this.estado_per = estado_per;
    }

    public Date getFechaNac_per() {
        return fechaNac_per;
    }

    public void setFechaNac_per(Date fechaNac_per) {
        this.fechaNac_per = fechaNac_per;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_persona != null ? id_persona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_persona fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id_persona == null && other.id_persona != null) || (this.id_persona != null && !this.id_persona.equals(other.id_persona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Persona[ id=" + id_persona + " ]";
    }
    
}
