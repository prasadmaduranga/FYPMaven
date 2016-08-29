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
@Table(name = "dimensioncontext")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimensioncontext.findAll", query = "SELECT d FROM Dimensioncontext d"),
    @NamedQuery(name = "Dimensioncontext.findByDimensionId", query = "SELECT d FROM Dimensioncontext d WHERE d.dimensioncontextPK.dimensionId = :dimensionId"),
    @NamedQuery(name = "Dimensioncontext.findByDescription", query = "SELECT d FROM Dimensioncontext d WHERE d.dimensioncontextPK.description = :description")})
public class Dimensioncontext implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DimensioncontextPK dimensioncontextPK;
    @JoinColumn(name = "dimensionId", referencedColumnName = "dimentionId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Chartdimension chartdimension;

    public Dimensioncontext() {
    }

    public Dimensioncontext(DimensioncontextPK dimensioncontextPK) {
        this.dimensioncontextPK = dimensioncontextPK;
    }

    public Dimensioncontext(int dimensionId, String description) {
        this.dimensioncontextPK = new DimensioncontextPK(dimensionId, description);
    }

    public DimensioncontextPK getDimensioncontextPK() {
        return dimensioncontextPK;
    }

    public void setDimensioncontextPK(DimensioncontextPK dimensioncontextPK) {
        this.dimensioncontextPK = dimensioncontextPK;
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
        hash += (dimensioncontextPK != null ? dimensioncontextPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimensioncontext)) {
            return false;
        }
        Dimensioncontext other = (Dimensioncontext) object;
        if ((this.dimensioncontextPK == null && other.dimensioncontextPK != null) || (this.dimensioncontextPK != null && !this.dimensioncontextPK.equals(other.dimensioncontextPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Dimensioncontext[ dimensioncontextPK=" + dimensioncontextPK + " ]";
    }
    
}
