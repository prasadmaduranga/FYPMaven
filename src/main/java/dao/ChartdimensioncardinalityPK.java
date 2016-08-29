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
public class ChartdimensioncardinalityPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "dimensionId")
    private int dimensionId;
    @Basic(optional = false)
    @Column(name = "cardinality")
    private String cardinality;

    public ChartdimensioncardinalityPK() {
    }

    public ChartdimensioncardinalityPK(int dimensionId, String cardinality) {
        this.dimensionId = dimensionId;
        this.cardinality = cardinality;
    }

    public int getDimensionId() {
        return dimensionId;
    }

    public void setDimensionId(int dimensionId) {
        this.dimensionId = dimensionId;
    }

    public String getCardinality() {
        return cardinality;
    }

    public void setCardinality(String cardinality) {
        this.cardinality = cardinality;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dimensionId;
        hash += (cardinality != null ? cardinality.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChartdimensioncardinalityPK)) {
            return false;
        }
        ChartdimensioncardinalityPK other = (ChartdimensioncardinalityPK) object;
        if (this.dimensionId != other.dimensionId) {
            return false;
        }
        if ((this.cardinality == null && other.cardinality != null) || (this.cardinality != null && !this.cardinality.equals(other.cardinality))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.ChartdimensioncardinalityPK[ dimensionId=" + dimensionId + ", cardinality=" + cardinality + " ]";
    }
    
}
