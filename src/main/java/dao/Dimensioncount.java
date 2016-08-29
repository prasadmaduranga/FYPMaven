/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "dimensioncount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimensioncount.findAll", query = "SELECT d FROM Dimensioncount d"),
    @NamedQuery(name = "Dimensioncount.findByCountId", query = "SELECT d FROM Dimensioncount d WHERE d.countId = :countId"),
    @NamedQuery(name = "Dimensioncount.findByCount", query = "SELECT d FROM Dimensioncount d WHERE d.count = :count")})
public class Dimensioncount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "countId")
    private Integer countId;
    @Column(name = "count")
    private Integer count;
    @JoinColumn(name = "chartId", referencedColumnName = "chartId")
    @ManyToOne
    private Chart chartId;

    public Dimensioncount() {
    }

    public Dimensioncount(Integer countId) {
        this.countId = countId;
    }

    public Integer getCountId() {
        return countId;
    }

    public void setCountId(Integer countId) {
        this.countId = countId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
        hash += (countId != null ? countId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimensioncount)) {
            return false;
        }
        Dimensioncount other = (Dimensioncount) object;
        if ((this.countId == null && other.countId != null) || (this.countId != null && !this.countId.equals(other.countId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Dimensioncount[ countId=" + countId + " ]";
    }
    
}
