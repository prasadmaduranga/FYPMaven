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
@Table(name = "tables")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tables.findAll", query = "SELECT t FROM Tables t"),
    @NamedQuery(name = "Tables.findByTableId", query = "SELECT t FROM Tables t WHERE t.tableId = :tableId"),
    @NamedQuery(name = "Tables.findByNumberOfRows", query = "SELECT t FROM Tables t WHERE t.numberOfRows = :numberOfRows"),
    @NamedQuery(name = "Tables.findByTableName", query = "SELECT t FROM Tables t WHERE t.tableName = :tableName")})
public class Tables implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tableId")
    private Integer tableId;
    @Column(name = "numberOfRows")
    private Integer numberOfRows;
    @Column(name = "tableName")
    private String tableName;
    @OneToMany(mappedBy = "tableId")
    private Collection<Tabledimension> tabledimensionCollection;
    @OneToMany(mappedBy = "tableId")
    private Collection<dao.Column> columnCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tables")
    private Collection<Recommendations> recommendationsCollection;
    @OneToMany(mappedBy = "tableId")
    private Collection<Partialordering> partialorderingCollection;

    public Tables() {
    }

    public Tables(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(Integer numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @XmlTransient
    public Collection<Tabledimension> getTabledimensionCollection() {
        return tabledimensionCollection;
    }

    public void setTabledimensionCollection(Collection<Tabledimension> tabledimensionCollection) {
        this.tabledimensionCollection = tabledimensionCollection;
    }

    @XmlTransient
    public Collection<dao.Column> getColumnCollection() {
        return columnCollection;
    }

    public void setColumnCollection(Collection<dao.Column> columnCollection) {
        this.columnCollection = columnCollection;
    }

    @XmlTransient
    public Collection<Recommendations> getRecommendationsCollection() {
        return recommendationsCollection;
    }

    public void setRecommendationsCollection(Collection<Recommendations> recommendationsCollection) {
        this.recommendationsCollection = recommendationsCollection;
    }

    @XmlTransient
    public Collection<Partialordering> getPartialorderingCollection() {
        return partialorderingCollection;
    }

    public void setPartialorderingCollection(Collection<Partialordering> partialorderingCollection) {
        this.partialorderingCollection = partialorderingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tableId != null ? tableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tables)) {
            return false;
        }
        Tables other = (Tables) object;
        if ((this.tableId == null && other.tableId != null) || (this.tableId != null && !this.tableId.equals(other.tableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Tables[ tableId=" + tableId + " ]";
    }
    
}
