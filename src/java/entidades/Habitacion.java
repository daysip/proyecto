/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "habitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Habitacion.findAll", query = "SELECT h FROM Habitacion h")
    , @NamedQuery(name = "Habitacion.findByNumHab", query = "SELECT h FROM Habitacion h WHERE h.numHab = :numHab")
    , @NamedQuery(name = "Habitacion.findByInformacionHab", query = "SELECT h FROM Habitacion h WHERE h.informacionHab = :informacionHab")
    , @NamedQuery(name = "Habitacion.findByEstado", query = "SELECT h FROM Habitacion h WHERE h.estado = :estado")
    , @NamedQuery(name = "Habitacion.findByFotoPath", query = "SELECT h FROM Habitacion h WHERE h.fotoPath = :fotoPath")})
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "num_hab")
    private String numHab;
    @Size(max = 250)
    @Column(name = "informacion_hab")
    private String informacionHab;
    @Size(max = 25)
    @Column(name = "estado")
    private String estado;
    @Size(max = 250)
    @Column(name = "foto_path")
    private String fotoPath;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "habitacion")
    private Collection<Detalle> detalleCollection;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne
    private TipoHab idTipo;

    public Habitacion() {
    }

    public Habitacion(String numHab) {
        this.numHab = numHab;
    }

    public String getNumHab() {
        return numHab;
    }

    public void setNumHab(String numHab) {
        this.numHab = numHab;
    }

    public String getInformacionHab() {
        return informacionHab;
    }

    public void setInformacionHab(String informacionHab) {
        this.informacionHab = informacionHab;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFotoPath() {
        return fotoPath;
    }

    public void setFotoPath(String fotoPath) {
        this.fotoPath = fotoPath;
    }

    @XmlTransient
    public Collection<Detalle> getDetalleCollection() {
        return detalleCollection;
    }

    public void setDetalleCollection(Collection<Detalle> detalleCollection) {
        this.detalleCollection = detalleCollection;
    }

    public TipoHab getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoHab idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numHab != null ? numHab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitacion)) {
            return false;
        }
        Habitacion other = (Habitacion) object;
        if ((this.numHab == null && other.numHab != null) || (this.numHab != null && !this.numHab.equals(other.numHab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Habitacion[ numHab=" + numHab + " ]";
    }
    
}
