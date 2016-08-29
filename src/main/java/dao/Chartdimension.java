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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "chartdimension")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chartdimension.findAll", query = "SELECT c FROM Chartdimension c"),
    @NamedQuery(name = "Chartdimension.findByDimentionId", query = "SELECT c FROM Chartdimension c WHERE c.dimentionId = :dimentionId"),
    @NamedQuery(name = "Chartdimension.findByDimensionIndex", query = "SELECT c FROM Chartdimension c WHERE c.dimensionIndex = :dimensionIndex"),
    @NamedQuery(name = "Chartdimension.findCorrespondingChartDimensionForTableDimension", 
            query = "SELECT c FROM Chartdimension c INNER JOIN c.chartdimensioncardinalityCollection dc "
                    + " INNER JOIN c.dimensioncontextCollection dcc "
                    + " WHERE c.contineous= :contineous AND c.chartId= :chartId" 
                    + " AND dc.chartdimensioncardinalityPK.cardinality = :cardinality "
                    + "AND dcc.dimensioncontextPK.description = :context"
                    + " AND c.dimentionId NOT IN :selectedDimensionList"
                    + " AND c.dimensionIndex NOT IN :selectedChartIndecesList" ),
    @NamedQuery(name = "Chartdimension.findByContineous", query = "SELECT c FROM Chartdimension c WHERE c.contineous = :contineous")})
public class Chartdimension implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dimentionId")
    private Integer dimentionId;
    @Column(name = "dimensionIndex")
    private Integer dimensionIndex;
    @Column(name = "contineous")
    private Short contineous;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chartdimension")
    private Collection<Chartdimensioncardinality> chartdimensioncardinalityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chartdimension")
    private Collection<Dimensioncontext> dimensioncontextCollection;
    @JoinColumn(name = "chartId", referencedColumnName = "chartId")
    @ManyToOne
    private Chart chartId;

    public Chartdimension() {
    }

    public Chartdimension(Integer dimentionId) {
        this.dimentionId = dimentionId;
    }

    public Integer getDimentionId() {
        return dimentionId;
    }

    public void setDimentionId(Integer dimentionId) {
        this.dimentionId = dimentionId;
    }

    public Integer getDimensionIndex() {
        return dimensionIndex;
    }

    public void setDimensionIndex(Integer dimensionIndex) {
        this.dimensionIndex = dimensionIndex;
    }

    public Short getContineous() {
        return contineous;
    }

    public void setContineous(Short contineous) {
        this.contineous = contineous;
    }

    @XmlTransient
    public Collection<Chartdimensioncardinality> getChartdimensioncardinalityCollection() {
        return chartdimensioncardinalityCollection;
    }

    public void setChartdimensioncardinalityCollection(Collection<Chartdimensioncardinality> chartdimensioncardinalityCollection) {
        this.chartdimensioncardinalityCollection = chartdimensioncardinalityCollection;
    }

    @XmlTransient
    public Collection<Dimensioncontext> getDimensioncontextCollection() {
        return dimensioncontextCollection;
    }

    public void setDimensioncontextCollection(Collection<Dimensioncontext> dimensioncontextCollection) {
        this.dimensioncontextCollection = dimensioncontextCollection;
    }

    public Chart getChartId() {
        return chartId;
    }

    public void setChartId(Chart chartId) {
        this.chartId = chartId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dimentionId != null ? dimentionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chartdimension)) {
            return false;
        }
        Chartdimension other = (Chartdimension) object;
        if ((this.dimentionId == null && other.dimentionId != null) || (this.dimentionId != null && !this.dimentionId.equals(other.dimentionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Chartdimension[ dimentionId=" + dimentionId + " ]";
    }
    
}
