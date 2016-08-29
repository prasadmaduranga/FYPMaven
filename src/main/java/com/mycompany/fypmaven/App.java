package com.mycompany.fypmaven;

import controller.ChartMapping;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String str= ChartMapping.chartMapping(new Integer(7));
        System.out.println(""+str);
    }
}
