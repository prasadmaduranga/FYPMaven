/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import dao_context.Column;
import dao_context.Table;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author lahiru
 */
public class ContextRecognizer {
    public void callMethod() throws IOException
    {
        String pythonScriptPath = "Calljson.py";
    String[] cmd = new String[3];
cmd[0] = "python"; // check version of installed python: python -V
cmd[1] = pythonScriptPath;
cmd[2] = "test2.csv";
 
// create runtime to execute external command
Runtime rt = Runtime.getRuntime();
Process pr = rt.exec(cmd);
 
// retrieve output from python script
BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
String line = "";
while((line = bfr.readLine()) != null) {

Gson gson = new Gson(); 
final Table tbl = gson.fromJson(line, Table.class);

        System.out.println("No of columns : "+tbl.columnCount);
        System.out.println("No of rows : "+tbl.NumOfRows);
        for (int i = 0; i < tbl.columnCount; i++) {
            System.out.println("_____________________________");
            Column col = tbl.Data[i];
            System.out.println("Column"+i+" : "+col.Heading);
            System.out.println("Heading classification : "+col.ClassificationByHeading);
            System.out.println("Context : "+col.Context);
            if(col.IsContinous){System.out.println("Continous");}
            else System.out.println("Discrete");
            System.out.println("No of discrete values : "+col.NoOfDiscreteValues);
        }
        

        
    }
    }
}
