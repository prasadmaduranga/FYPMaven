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
@Table(name = "intension")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intension.findAll", query = "SELECT i FROM Intension i"),
    @NamedQuery(name = "Intension.findByIntensionId", query = "SELECT i FROM Intension i WHERE i.intensionId = :intensionId"),
    @NamedQuery(name = "Intension.findByIntensionDesc", query = "SELECT i FROM Intension i WHERE i.intensionDesc = :intensionDesc")})
public class Intension implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "intensionId")
    private Integer intensionId;
    @Column(name = "intensionDesc")
    private String intensionDesc;
    @JoinColumn(name = "chartId", referencedColumnName = "chartId")
    @ManyToOne
    private Chart chartId;

    public Intension() {
    }

    public Intension(Integer intensionId) {
        this.intensionId = intensionId;
    }

    public Integer getIntensionId() {
        return intensionId;
    }

    public void setIntensionId(Integer intensionId) {
        this.intensionId = intensionId;
    }

    public String getIntensionDesc() {
        return intensionDesc;
    }

    public void setIntensionDesc(String intensionDesc) {
        this.intensionDesc = intensionDesc;
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
        hash += (intensionId != null ? intensionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intension)) {
            return false;
        }
        Intension other = (Intension) object;
        if ((this.intensionId == null && other.intensionId != null) || (this.intensionId != null && !this.intensionId.equals(other.intensionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Intension[ intensionId=" + intensionId + " ]";
    }
    
}
