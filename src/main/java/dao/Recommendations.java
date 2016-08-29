/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "recommendations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recommendations.findAll", query = "SELECT r FROM Recommendations r"),
    @NamedQuery(name = "Recommendations.findByChartId", query = "SELECT r FROM Recommendations r WHERE r.recommendationsPK.chartId = :chartId"),
    @NamedQuery(name = "Recommendations.findByTableId", query = "SELECT r FROM Recommendations r WHERE r.recommendationsPK.tableId = :tableId"),
    @NamedQuery(name = "Recommendations.findByRating", query = "SELECT r FROM Recommendations r WHERE r.rating = :rating")})
public class Recommendations implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecommendationsPK recommendationsPK;
    @Column(name = "rating")
    private Integer rating;
    @JoinColumn(name = "tableId", referencedColumnName = "tableId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tables tables;
    @JoinColumn(name = "chartId", referencedColumnName = "chartId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Chart chart;

    public Recommendations() {
    }

    public Recommendations(RecommendationsPK recommendationsPK) {
        this.recommendationsPK = recommendationsPK;
    }

    public Recommendations(int chartId, int tableId) {
        this.recommendationsPK = new RecommendationsPK(chartId, tableId);
    }

    public RecommendationsPK getRecommendationsPK() {
        return recommendationsPK;
    }

    public void setRecommendationsPK(RecommendationsPK recommendationsPK) {
        this.recommendationsPK = recommendationsPK;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Tables getTables() {
        return tables;
    }

    public void setTables(Tables tables) {
        this.tables = tables;
    }

    public Chart getChart() {
        return chart;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recommendationsPK != null ? recommendationsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recommendations)) {
            return false;
        }
        Recommendations other = (Recommendations) object;
        if ((this.recommendationsPK == null && other.recommendationsPK != null) || (this.recommendationsPK != null && !this.recommendationsPK.equals(other.recommendationsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Recommendations[ recommendationsPK=" + recommendationsPK + " ]";
    }
    
}
