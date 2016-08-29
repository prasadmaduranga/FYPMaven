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
@Table(name = "tabledimension")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabledimension.findAll", query = "SELECT t FROM Tabledimension t"),
    @NamedQuery(name = "Tabledimension.findByDimensionId", query = "SELECT t FROM Tabledimension t WHERE t.dimensionId = :dimensionId"),
    @NamedQuery(name = "Tabledimension.findByContinneous", query = "SELECT t FROM Tabledimension t WHERE t.continneous = :continneous"),
    @NamedQuery(name = "Tabledimension.findByDimensionIndex", query = "SELECT t FROM Tabledimension t WHERE t.dimensionIndex = :dimensionIndex"),
    @NamedQuery(name = "Tabledimension.findByCardinality", query = "SELECT t FROM Tabledimension t WHERE t.cardinality = :cardinality"),
    @NamedQuery(name = "Tabledimension.findByTableId", query = "SELECT t FROM Tabledimension t WHERE t.tableId = :tableId"),
    @NamedQuery(name = "Tabledimension.findByContext", query = "SELECT t FROM Tabledimension t WHERE t.context = :context")})
public class Tabledimension implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dimensionId")
    private Integer dimensionId;
    @Column(name = "continneous")
    private Short continneous;
    @Column(name = "dimensionIndex")
    private Integer dimensionIndex;
    @Column(name = "cardinality")
    private String cardinality;
    @Column(name = "context")
    private String context;
    @JoinColumn(name = "tableId", referencedColumnName = "tableId")
    @ManyToOne
    private Tables tableId;

    public Tabledimension() {
    }

    public Tabledimension(Integer dimensionId) {
        this.dimensionId = dimensionId;
    }

    public Integer getDimensionId() {
        return dimensionId;
    }

    public void setDimensionId(Integer dimensionId) {
        this.dimensionId = dimensionId;
    }

    public Short getContinneous() {
        return continneous;
    }

    public void setContinneous(Short continneous) {
        this.continneous = continneous;
    }

    public Integer getDimensionIndex() {
        return dimensionIndex;
    }

    public void setDimensionIndex(Integer dimensionIndex) {
        this.dimensionIndex = dimensionIndex;
    }

    public String getCardinality() {
        return cardinality;
    }

    public void setCardinality(String cardinality) {
        this.cardinality = cardinality;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Tables getTableId() {
        return tableId;
    }

    public void setTableId(Tables tableId) {
        this.tableId = tableId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dimensionId != null ? dimensionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabledimension)) {
            return false;
        }
        Tabledimension other = (Tabledimension) object;
        if ((this.dimensionId == null && other.dimensionId != null) || (this.dimensionId != null && !this.dimensionId.equals(other.dimensionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Tabledimension[ dimensionId=" + dimensionId + " ]";
    }
    
}
