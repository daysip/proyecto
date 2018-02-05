/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DAY
 */
@Embeddable
public class DetallePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_orden")
    private String idOrden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "num_hab")
    private String numHab;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_adi")
    private String idAdi;

    public DetallePK() {
    }

    public DetallePK(String idOrden, String numHab, String idAdi) {
        this.idOrden = idOrden;
        this.numHab = numHab;
        this.idAdi = idAdi;
    }

    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public String getNumHab() {
        return numHab;
    }

    public void setNumHab(String numHab) {
        this.numHab = numHab;
    }

    public String getIdAdi() {
        return idAdi;
    }

    public void setIdAdi(String idAdi) {
        this.idAdi = idAdi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        hash += (numHab != null ? numHab.hashCode() : 0);
        hash += (idAdi != null ? idAdi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePK)) {
            return false;
        }
        DetallePK other = (DetallePK) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        if ((this.numHab == null && other.numHab != null) || (this.numHab != null && !this.numHab.equals(other.numHab))) {
            return false;
        }
        if ((this.idAdi == null && other.idAdi != null) || (this.idAdi != null && !this.idAdi.equals(other.idAdi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetallePK[ idOrden=" + idOrden + ", numHab=" + numHab + ", idAdi=" + idAdi + " ]";
    }
    
}
