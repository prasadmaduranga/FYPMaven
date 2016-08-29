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
@Table(name = "partialordering")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partialordering.findAll", query = "SELECT p FROM Partialordering p"),
    @NamedQuery(name = "Partialordering.findByOrderId", query = "SELECT p FROM Partialordering p WHERE p.orderId = :orderId"),
    @NamedQuery(name = "Partialordering.findByParentId", query = "SELECT p FROM Partialordering p WHERE p.parentId = :parentId"),
    @NamedQuery(name = "Partialordering.findByChildId", query = "SELECT p FROM Partialordering p WHERE p.childId = :childId")})
public class Partialordering implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderId")
    private Integer orderId;
    @Column(name = "parentId")
    private Integer parentId;
    @Column(name = "childId")
    private Integer childId;
    @JoinColumn(name = "columnId", referencedColumnName = "columnId")
    @ManyToOne
    private dao.Column columnId;
    @JoinColumn(name = "tableId", referencedColumnName = "tableId")
    @ManyToOne
    private Tables tableId;

    public Partialordering() {
    }

    public Partialordering(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public dao.Column getColumnId() {
        return columnId;
    }

    public void setColumnId(dao.Column columnId) {
        this.columnId = columnId;
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
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partialordering)) {
            return false;
        }
        Partialordering other = (Partialordering) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Partialordering[ orderId=" + orderId + " ]";
    }
    
}
