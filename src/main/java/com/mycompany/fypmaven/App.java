package com.mycompany.fypmaven;

import controller.ChartMapping;
import controller.ContextRecognizer;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
      //  String str= ChartMapping.chartMapping(new Integer(7));
     //   System.out.println(""+str);
        ContextRecognizer CR = new ContextRecognizer();
        CR.callMethod();
    }
}
