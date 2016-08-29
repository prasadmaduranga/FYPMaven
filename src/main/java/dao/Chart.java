/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "chart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chart.findAll", query = "SELECT c FROM Chart c"),
    @NamedQuery(name = "Chart.findByChartId", query = "SELECT c FROM Chart c WHERE c.chartId = :chartId"),
     @NamedQuery(name = "Chart.findByDimensionCount", query = "SELECT c FROM Chart c INNER JOIN c.dimensioncountCollection dimCollection  WHERE dimCollection.count = :count"),
    @NamedQuery(name = "Chart.findByDimensionCount", query = "SELECT c FROM Chart c INNER JOIN c.dimensioncountCollection dimCollection  WHERE dimCollection.count = :count"),
    @NamedQuery(name = "Chart.findByChartName", query = "SELECT c FROM Chart c WHERE c.chartName = :chartName")})
public class Chart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "chartId")
    private Integer chartId;
    @Column(name = "chartName")
    private String chartName;
    @OneToMany(mappedBy = "chartId")
    private Collection<Intension> intensionCollection;
    @OneToMany(mappedBy = "chartId")
    private Collection<Dimensioncount> dimensioncountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chart")
    private Collection<Recommendations> recommendationsCollection;
    @OneToMany(mappedBy = "chartId")
    private Collection<Chartdimension> chartdimensionCollection;

    public Chart() {
    }

    public Chart(Integer chartId) {
        this.chartId = chartId;
    }

    public Integer getChartId() {
        return chartId;
    }

    public void setChartId(Integer chartId) {
        this.chartId = chartId;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    @XmlTransient
    public Collection<Intension> getIntensionCollection() {
        return intensionCollection;
    }

    public void setIntensionCollection(Collection<Intension> intensionCollection) {
        this.intensionCollection = intensionCollection;
    }

    @XmlTransient
    public Collection<Dimensioncount> getDimensioncountCollection() {
        return dimensioncountCollection;
    }

    public void setDimensioncountCollection(Collection<Dimensioncount> dimensioncountCollection) {
        this.dimensioncountCollection = dimensioncountCollection;
    }

    @XmlTransient
    public Collection<Recommendations> getRecommendationsCollection() {
        return recommendationsCollection;
    }

    public void setRecommendationsCollection(Collection<Recommendations> recommendationsCollection) {
        this.recommendationsCollection = recommendationsCollection;
    }

    @XmlTransient
    public Collection<Chartdimension> getChartdimensionCollection() {
        return chartdimensionCollection;
    }

    public void setChartdimensionCollection(Collection<Chartdimension> chartdimensionCollection) {
        this.chartdimensionCollection = chartdimensionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chartId != null ? chartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chart)) {
            return false;
        }
        Chart other = (Chart) object;
        if ((this.chartId == null && other.chartId != null) || (this.chartId != null && !this.chartId.equals(other.chartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Chart[ chartId=" + chartId + " ]";
    }
    
}
