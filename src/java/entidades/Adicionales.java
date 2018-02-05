/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "adicionales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adicionales.findAll", query = "SELECT a FROM Adicionales a")
    , @NamedQuery(name = "Adicionales.findByIdAdi", query = "SELECT a FROM Adicionales a WHERE a.idAdi = :idAdi")
    , @NamedQuery(name = "Adicionales.findByNombreAdi", query = "SELECT a FROM Adicionales a WHERE a.nombreAdi = :nombreAdi")
    , @NamedQuery(name = "Adicionales.findByPrecioAdi", query = "SELECT a FROM Adicionales a WHERE a.precioAdi = :precioAdi")})
public class Adicionales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_adi")
    private String idAdi;
    @Size(max = 100)
    @Column(name = "nombre_adi")
    private String nombreAdi;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_adi")
    private BigDecimal precioAdi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adicionales")
    private Collection<Detalle> detalleCollection;

    public Adicionales() {
    }

    public Adicionales(String idAdi) {
        this.idAdi = idAdi;
    }

    public String getIdAdi() {
        return idAdi;
    }

    public void setIdAdi(String idAdi) {
        this.idAdi = idAdi;
    }

    public String getNombreAdi() {
        return nombreAdi;
    }

    public void setNombreAdi(String nombreAdi) {
        this.nombreAdi = nombreAdi;
    }

    public BigDecimal getPrecioAdi() {
        return precioAdi;
    }

    public void setPrecioAdi(BigDecimal precioAdi) {
        this.precioAdi = precioAdi;
    }

    @XmlTransient
    public Collection<Detalle> getDetalleCollection() {
        return detalleCollection;
    }

    public void setDetalleCollection(Collection<Detalle> detalleCollection) {
        this.detalleCollection = detalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdi != null ? idAdi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adicionales)) {
            return false;
        }
        Adicionales other = (Adicionales) object;
        if ((this.idAdi == null && other.idAdi != null) || (this.idAdi != null && !this.idAdi.equals(other.idAdi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Adicionales[ idAdi=" + idAdi + " ]";
    }
    
}
