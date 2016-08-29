/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DomainObjects.*;
import dao.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.TypedQuery;

/**
 *
 * @author User
 */
public class ChartMapping {

    public static String chartMapping(Integer tableId) {

        List<ChartTableDimensionMapping> finalChartTableMapping = new ArrayList<>();
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("com.mycompany_FYPMaven_jar_1.0-SNAPSHOTPU");
        EntityManager entitymanager = emfactory.createEntityManager();
        StringBuilder sb=new StringBuilder();
        //get table for given table id
        TypedQuery<Tables> query_getTable = entitymanager.createNamedQuery("Tables.findByTableId", Tables.class);
        query_getTable.setParameter("tableId", new Integer(tableId));
        List<Tables> results_tableSet = query_getTable.getResultList();

        //get dimension info given table
        TypedQuery<Tabledimension> query_getDimensions = entitymanager.createNamedQuery("Tabledimension.findByTableId", Tabledimension.class);
        query_getDimensions.setParameter("tableId", results_tableSet.get(0));
        List<Tabledimension> results_tableDimensionList = query_getDimensions.getResultList();

        // get charts which can visualize the number of dimensions given in the table
        TypedQuery<Chart> query_getChartSet = entitymanager.createNamedQuery("Chart.findByDimensionCount", Chart.class);
        query_getChartSet.setParameter("count", new Integer(results_tableDimensionList.size()));
        List<Chart> results_chartSet = query_getChartSet.getResultList();

        for (Chart e : results_chartSet) {
            boolean skip = false;
            List<Integer> selectedDimList = new ArrayList<Integer>();
            List<Integer> selectedChartIndecesList = new ArrayList<Integer>();

           selectedDimList.add(new Integer(6000));
           selectedChartIndecesList.add(new Integer(6000));
           // List<String> selectedDimList=new ArrayList<String>();
            ChartTableDimensionMapping sample = new ChartTableDimensionMapping(results_tableSet.get(0), e);
            for (Tabledimension j : results_tableDimensionList) {
                TypedQuery<Chartdimension> query_getCorrespondingChartDimension = entitymanager.createNamedQuery("Chartdimension.findCorrespondingChartDimensionForTableDimension", Chartdimension.class);
                query_getCorrespondingChartDimension.setParameter("contineous", j.getContinneous());
                query_getCorrespondingChartDimension.setParameter("chartId", e);
                query_getCorrespondingChartDimension.setParameter("cardinality", j.getCardinality());
                query_getCorrespondingChartDimension.setParameter("context", j.getContext());
                query_getCorrespondingChartDimension.setParameter("selectedDimensionList", selectedDimList);
                query_getCorrespondingChartDimension.setParameter("selectedChartIndecesList", selectedChartIndecesList);
                // query_getCorrespondingChartDimension.setParameter("selectedDimensionList",Arrays.asList(new Integer(2),new Integer(3),new Integer(4)) );
                List<Chartdimension> results_CorrespondingChartDimension = query_getCorrespondingChartDimension.getResultList();

                if (results_CorrespondingChartDimension.isEmpty()) {
                    skip = true;
                    break;
                }
                selectedChartIndecesList.add(results_CorrespondingChartDimension.get(0).getDimensionIndex());
                selectedDimList.add(results_CorrespondingChartDimension.get(0).getDimentionId());
                sample.addDimensionMapping(j, results_CorrespondingChartDimension.get(0));

            }
            if (skip == false) {
                finalChartTableMapping.add(sample);
            }

        }

        for (ChartTableDimensionMapping e : finalChartTableMapping) {

            sb.append(e.toString());

        }

        entitymanager.close();
        emfactory.close();
        return  sb.toString();
        
    }

}
