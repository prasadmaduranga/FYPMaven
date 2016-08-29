/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author User
 */
@Embeddable
public class RecommendationsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "chartId")
    private int chartId;
    @Basic(optional = false)
    @Column(name = "tableId")
    private int tableId;

    public RecommendationsPK() {
    }

    public RecommendationsPK(int chartId, int tableId) {
        this.chartId = chartId;
        this.tableId = tableId;
    }

    public int getChartId() {
        return chartId;
    }

    public void setChartId(int chartId) {
        this.chartId = chartId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) chartId;
        hash += (int) tableId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecommendationsPK)) {
            return false;
        }
        RecommendationsPK other = (RecommendationsPK) object;
        if (this.chartId != other.chartId) {
            return false;
        }
        if (this.tableId != other.tableId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.RecommendationsPK[ chartId=" + chartId + ", tableId=" + tableId + " ]";
    }
    
}
