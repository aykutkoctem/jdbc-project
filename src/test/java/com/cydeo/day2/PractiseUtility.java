package com.cydeo.day2;

import com.cydeo.Utilities.ConfigReader;
import com.cydeo.Utilities.DB_Util;

import java.util.List;
import java.util.Map;

public class PractiseUtility {

    public static void main(String[] args) {

        // create connection to oracle Database
        String url= ConfigReader.read("hr.database.url");
        String username=ConfigReader.read("hr.database.username");
        String password=ConfigReader.read("hr.database.password");

        DB_Util.createConnection(url,username,password);
        //RUN  query so it can set up all resultset stuff and we can call the method
        DB_Util.runQuery("SELECT * FROM COUNTRIES");
        //print out the result of the query
        DB_Util.displayAllData();
        //print out all column names
        System.out.println("Column names = " + DB_Util.getAllColumnNamesAsList());

        // print out 2row data as list
        System.out.println("Second row as list = " + DB_Util.getRowDataAsList(2));

        // print out 1st column data as list
        System.out.println("DB_Util.getColumnDataAsList(1) = " + DB_Util.getColumnDataAsList(1));
        // print out COUNTRY_NAME column data as list
        System.out.println("DB_Util.getColumnDataAsList(\"COUNTRY_NAME\") = " + DB_Util.getColumnDataAsList("COUNTRY_NAME"));
        // print out row count
        // print out column count
        System.out.println("DB_Util.getColumnCount() = " + DB_Util.getColumnCount());
        // print out the value of row number 4 column number 1
        System.out.println("DB_Util.getCellValue(4,1) = " + DB_Util.getCellValue(4, 1));
        // print out the value of row number 10 and COUNTRY_ID column
        System.out.println("DB_Util.getCellValue(10,\"COUNTRY_ID\") = " + DB_Util.getCellValue(10, "COUNTRY_ID"));
        // print out the first row first cell value
        System.out.println("DB_Util.getFirstRowFirstColumn() = " + DB_Util.getFirstRowFirstColumn());
        // print out 3rd row as Map
        System.out.println("DB_Util.getRowMap(3) = " + DB_Util.getRowMap(3));
        // print out all row as List of Map
        System.out.println("DB_Util.getAllRowAsListOfMap() = " + DB_Util.getAllRowAsListOfMap());
        //print out above List of Map item by item
        List<Map<String, String>> allRowMapList = DB_Util.getAllRowAsListOfMap();
        allRowMapList.forEach(each-> System.out.println(each));
        // close the connection
        DB_Util.destroy();

    }
}
