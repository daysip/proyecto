/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DAY
 */
@Entity
@Table(name = "detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d")
    , @NamedQuery(name = "Detalle.findByIdOrden", query = "SELECT d FROM Detalle d WHERE d.detallePK.idOrden = :idOrden")
    , @NamedQuery(name = "Detalle.findByNumHab", query = "SELECT d FROM Detalle d WHERE d.detallePK.numHab = :numHab")
    , @NamedQuery(name = "Detalle.findByIdAdi", query = "SELECT d FROM Detalle d WHERE d.detallePK.idAdi = :idAdi")
    , @NamedQuery(name = "Detalle.findByDiasHab", query = "SELECT d FROM Detalle d WHERE d.diasHab = :diasHab")
    , @NamedQuery(name = "Detalle.findByFechaIni", query = "SELECT d FROM Detalle d WHERE d.fechaIni = :fechaIni")})
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallePK detallePK;
    @Column(name = "dias_hab")
    private BigInteger diasHab;
    @Size(max = 100)
    @Column(name = "fecha_ini")
    private String fechaIni;
    @JoinColumn(name = "id_adi", referencedColumnName = "id_adi", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Adicionales adicionales;
    @JoinColumn(name = "num_hab", referencedColumnName = "num_hab", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Habitacion habitacion;
    @JoinColumn(name = "id_orden", referencedColumnName = "id_orden", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orden orden;

    public Detalle() {
    }

    public Detalle(DetallePK detallePK) {
        this.detallePK = detallePK;
    }

    public Detalle(String idOrden, String numHab, String idAdi) {
        this.detallePK = new DetallePK(idOrden, numHab, idAdi);
    }

    public DetallePK getDetallePK() {
        return detallePK;
    }

    public void setDetallePK(DetallePK detallePK) {
        this.detallePK = detallePK;
    }

    public BigInteger getDiasHab() {
        return diasHab;
    }

    public void setDiasHab(BigInteger diasHab) {
        this.diasHab = diasHab;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Adicionales getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(Adicionales adicionales) {
        this.adicionales = adicionales;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallePK != null ? detallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.detallePK == null && other.detallePK != null) || (this.detallePK != null && !this.detallePK.equals(other.detallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Detalle[ detallePK=" + detallePK + " ]";
    }
    
}
