/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "cuenta")
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cuenta;
    @Column(length = 20)
    private String usuario_cuenta;
    @Column(length = 20)
    private String clave_cuenta;
    @Column(length = 15)
    private String estado_cuenta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id_persona", nullable = false, columnDefinition = "id_persona")
    private Persona persona;

    public Long getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Long id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getUsuario_cuenta() {
        return usuario_cuenta;
    }

    public void setUsuario_cuenta(String usuario_cuenta) {
        this.usuario_cuenta = usuario_cuenta;
    }

    public String getClave_cuenta() {
        return clave_cuenta;
    }

    public void setClave_cuenta(String clave_cuenta) {
        this.clave_cuenta = clave_cuenta;
    }

    public String getEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(String estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_cuenta != null ? id_cuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_cuenta fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.id_cuenta == null && other.id_cuenta != null) || (this.id_cuenta != null && !this.id_cuenta.equals(other.id_cuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cuenta[ id=" + id_cuenta + " ]";
    }
    
}
