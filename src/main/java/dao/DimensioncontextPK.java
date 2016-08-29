/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author User
 */
@Embeddable
public class DimensioncontextPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "dimensionId")
    private int dimensionId;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;

    public DimensioncontextPK() {
    }

    public DimensioncontextPK(int dimensionId, String description) {
        this.dimensionId = dimensionId;
        this.description = description;
    }

    public int getDimensionId() {
        return dimensionId;
    }

    public void setDimensionId(int dimensionId) {
        this.dimensionId = dimensionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dimensionId;
        hash += (description != null ? description.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimensioncontextPK)) {
            return false;
        }
        DimensioncontextPK other = (DimensioncontextPK) object;
        if (this.dimensionId != other.dimensionId) {
            return false;
        }
        if ((this.description == null && other.description != null) || (this.description != null && !this.description.equals(other.description))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.DimensioncontextPK[ dimensionId=" + dimensionId + ", description=" + description + " ]";
    }
    
}
