/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DAY
 */
@Entity
@Table(name = "tipo_hab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoHab.findAll", query = "SELECT t FROM TipoHab t")
    , @NamedQuery(name = "TipoHab.findByIdTipo", query = "SELECT t FROM TipoHab t WHERE t.idTipo = :idTipo")
    , @NamedQuery(name = "TipoHab.findByPrecioTipo", query = "SELECT t FROM TipoHab t WHERE t.precioTipo = :precioTipo")
    , @NamedQuery(name = "TipoHab.findByNombreTipo", query = "SELECT t FROM TipoHab t WHERE t.nombreTipo = :nombreTipo")
    , @NamedQuery(name = "TipoHab.findByPersonasTipo", query = "SELECT t FROM TipoHab t WHERE t.personasTipo = :personasTipo")})
public class TipoHab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_tipo")
    private String idTipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_tipo")
    private BigDecimal precioTipo;
    @Size(max = 100)
    @Column(name = "nombre_tipo")
    private String nombreTipo;
    @Column(name = "personas_tipo")
    private BigInteger personasTipo;
    @OneToMany(mappedBy = "idTipo")
    private Collection<Habitacion> habitacionCollection;

    public TipoHab() {
    }

    public TipoHab(String idTipo) {
        this.idTipo = idTipo;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public BigDecimal getPrecioTipo() {
        return precioTipo;
    }

    public void setPrecioTipo(BigDecimal precioTipo) {
        this.precioTipo = precioTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public BigInteger getPersonasTipo() {
        return personasTipo;
    }

    public void setPersonasTipo(BigInteger personasTipo) {
        this.personasTipo = personasTipo;
    }

    @XmlTransient
    public Collection<Habitacion> getHabitacionCollection() {
        return habitacionCollection;
    }

    public void setHabitacionCollection(Collection<Habitacion> habitacionCollection) {
        this.habitacionCollection = habitacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoHab)) {
            return false;
        }
        TipoHab other = (TipoHab) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoHab[ idTipo=" + idTipo + " ]";
    }
    
}
