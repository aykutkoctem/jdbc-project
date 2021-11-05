package com.cydeo.day1;


import java.sql.*;

public class TestOracleConnection {

    public static void main(String[] args) {

        // make initial connection to Oracle Database we have
        // step 1 : add oracle driver dependency in pom.xml

        // Connection Information
        //  Connection String (JDBC URL)  :  jdbc:oracle:thin@54.236.150.168:1521:XE
        //  USERNAME Password  hr / hr
        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE" ;
        String username = "hr" ;
        String password = "hr" ;

        // 1. create a connection use DriverManager class and Save the connection
        try {
            // DriverManager class getConnection method is used to create connection
            Connection conn = DriverManager.getConnection(url, username, password)  ;
            System.out.println("CONNECTION WAS SUCCESSFUL ");

            // Create Statement Object from Connection so we can eventually run query
            Statement stmnt = conn.createStatement();

            // using this statement object to run query
            ResultSet rs  = stmnt.executeQuery(  "SELECT * FROM REGIONS"  );
            // ResultSet use cursor or pointer to navigate through the rows
            // by default the pointer is at a location known as BeforeFirst location
            // meaning right before first row of data
            // in order to move to the first row , we need to call next() method
            // everytime you call next method you will jump to next row
            // you can use getString( column name ) to get the cell value
            rs.next() ;  // this move the cursor to first row
            // now we are at first row , we can use getString method to get Region_name
            System.out.println(     rs.getString("REGION_NAME")              );
            rs.next() ;
            System.out.println(     rs.getString("REGION_NAME")              );



        } catch (SQLException e) {
            System.out.println("ERROR WHILE RUNNING " + e.getMessage() );
        }


    }


}