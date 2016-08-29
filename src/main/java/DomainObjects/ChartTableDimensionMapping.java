/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainObjects;

import java.util.HashMap;
import dao.*;

/**
 *
 * @author User
 */
public class ChartTableDimensionMapping {

    private Tables tables;
    private Chart chart;
    private HashMap<dao.Tabledimension, dao.Chartdimension> chart_table_dimensionMap;

    public ChartTableDimensionMapping(Tables tableId, Chart chartId) {
        this.tables = tableId;
        this.chart = chartId;
        chart_table_dimensionMap = new HashMap<dao.Tabledimension, dao.Chartdimension>();
    }

    public void addDimensionMapping(Tabledimension tableDimension, Chartdimension chartDimension) {
        chart_table_dimensionMap.put(tableDimension, chartDimension);
    }

    public HashMap<dao.Tabledimension, dao.Chartdimension> getDimensionMapping() {
        return chart_table_dimensionMap;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------------------------------------------\n");
        sb.append("Data set: " + tables.getTableName() + " | Recommended chart :" + chart.getChartName() + "\n");
        sb.append("-------------------------------------------------------------\n");
        sb.append("Mapping between data set and chart : ");
//        for (Column c : Column.getColumnHeaders(tables)) {
//            sb.append(c.getHeader() + " | ");
//        }
        sb.append("\n");
        sb.append("-------------------------------------------------------------\n");
        sb.append("Table dimension indices :");
        for (Tabledimension key : chart_table_dimensionMap.keySet()) {
            sb.append(key.getDimensionIndex() + " | ");
        }
        sb.append("\n");
        sb.append("-------------------------------------------------------------\n");
        sb.append("Chart dimension indices :");
        for (Tabledimension key : chart_table_dimensionMap.keySet()) {
          sb.append(chart_table_dimensionMap.get(key).getDimensionIndex() + " | ");
        }
        sb.append("\n");
        sb.append("=============================================================\n\n");
        return sb.toString();
        
       // return  chart.getChartName();
    }

    public Tables getTable() {
        return tables;
    }

    public Chart getChart() {
        return chart;
    }
}
