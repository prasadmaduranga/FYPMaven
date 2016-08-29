/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "chartdimensioncardinality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chartdimensioncardinality.findAll", query = "SELECT c FROM Chartdimensioncardinality c"),
    @NamedQuery(name = "Chartdimensioncardinality.findByDimensionId", query = "SELECT c FROM Chartdimensioncardinality c WHERE c.chartdimensioncardinalityPK.dimensionId = :dimensionId"),
    @NamedQuery(name = "Chartdimensioncardinality.findByCardinality", query = "SELECT c FROM Chartdimensioncardinality c WHERE c.chartdimensioncardinalityPK.cardinality = :cardinality")})
public class Chartdimensioncardinality implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChartdimensioncardinalityPK chartdimensioncardinalityPK;
    @JoinColumn(name = "dimensionId", referencedColumnName = "dimentionId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Chartdimension chartdimension;

    public Chartdimensioncardinality() {
    }

    public Chartdimensioncardinality(ChartdimensioncardinalityPK chartdimensioncardinalityPK) {
        this.chartdimensioncardinalityPK = chartdimensioncardinalityPK;
    }

    public Chartdimensioncardinality(int dimensionId, String cardinality) {
        this.chartdimensioncardinalityPK = new ChartdimensioncardinalityPK(dimensionId, cardinality);
    }

    public ChartdimensioncardinalityPK getChartdimensioncardinalityPK() {
        return chartdimensioncardinalityPK;
    }

    public void setChartdimensioncardinalityPK(ChartdimensioncardinalityPK chartdimensioncardinalityPK) {
        this.chartdimensioncardinalityPK = chartdimensioncardinalityPK;
    }

    public Chartdimension getChartdimension() {
        return chartdimension;
    }

    public void setChartdimension(Chartdimension chartdimension) {
        this.chartdimension = chartdimension;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chartdimensioncardinalityPK != null ? chartdimensioncardinalityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chartdimensioncardinality)) {
            return false;
        }
        Chartdimensioncardinality other = (Chartdimensioncardinality) object;
        if ((this.chartdimensioncardinalityPK == null && other.chartdimensioncardinalityPK != null) || (this.chartdimensioncardinalityPK != null && !this.chartdimensioncardinalityPK.equals(other.chartdimensioncardinalityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Chartdimensioncardinality[ chartdimensioncardinalityPK=" + chartdimensioncardinalityPK + " ]";
    }
    
}
