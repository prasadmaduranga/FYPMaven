/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "column")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Column.findAll", query = "SELECT c FROM Column c"),
    @NamedQuery(name = "Column.findByColumnId", query = "SELECT c FROM Column c WHERE c.columnId = :columnId"),
    @NamedQuery(name = "Column.findByHeader", query = "SELECT c FROM Column c WHERE c.header = :header"),
    @NamedQuery(name = "Column.findByCardinality", query = "SELECT c FROM Column c WHERE c.cardinality = :cardinality"),
    @NamedQuery(name = "Column.findByDataType", query = "SELECT c FROM Column c WHERE c.dataType = :dataType"),
    @NamedQuery(name = "Column.findByTableId", query = "SELECT c FROM Column c WHERE c.tableId = :tableId"),
    @NamedQuery(name = "Column.findByContextDesc", query = "SELECT c FROM Column c WHERE c.contextDesc = :contextDesc"),
    @NamedQuery(name = "Column.findByIsContinuous", query = "SELECT c FROM Column c WHERE c.isContinuous = :isContinuous")})
public class Column implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @javax.persistence.Column(name = "columnId")
    private Integer columnId;
    @javax.persistence.Column(name = "header")
    private String header;
    @javax.persistence.Column(name = "cardinality")
    private Integer cardinality;
    @javax.persistence.Column(name = "dataType")
    private String dataType;
    @javax.persistence.Column(name = "contextDesc")
    private String contextDesc;
    @Basic(optional = false)
    @javax.persistence.Column(name = "isContinuous")
    private short isContinuous;
    @JoinColumn(name = "tableId", referencedColumnName = "tableId")
    @ManyToOne
    private Tables tableId;
    @OneToMany(mappedBy = "columnId")
    private Collection<Partialordering> partialorderingCollection;

    public Column() {
    }

    public Column(Integer columnId) {
        this.columnId = columnId;
    }

    public Column(Integer columnId, short isContinuous) {
        this.columnId = columnId;
        this.isContinuous = isContinuous;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Integer getCardinality() {
        return cardinality;
    }

    public void setCardinality(Integer cardinality) {
        this.cardinality = cardinality;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getContextDesc() {
        return contextDesc;
    }

    public void setContextDesc(String contextDesc) {
        this.contextDesc = contextDesc;
    }

    public short getIsContinuous() {
        return isContinuous;
    }

    public void setIsContinuous(short isContinuous) {
        this.isContinuous = isContinuous;
    }

    public Tables getTableId() {
        return tableId;
    }

    public void setTableId(Tables tableId) {
        this.tableId = tableId;
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
        hash += (columnId != null ? columnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Column)) {
            return false;
        }
        Column other = (Column) object;
        if ((this.columnId == null && other.columnId != null) || (this.columnId != null && !this.columnId.equals(other.columnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Column[ columnId=" + columnId + " ]";
    }
    
}
