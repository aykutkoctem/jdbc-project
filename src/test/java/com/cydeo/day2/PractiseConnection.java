package com.cydeo.day2;

import java.sql.*;

public class PractiseConnection {
    public static void main(String[] args) throws SQLException {


        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE" ;
        String username = "hr" ;
        String password = "hr" ;

        //1.get connection object
        //GETcONNECTION METHOD THROWS CHECKED EXCEPTION,THIS TIME WE DECIDD TO
        //DECLARE IT INSTEAD OF HANDLING IT USING THROWS SQLEXCEPTION
        Connection conn= DriverManager.getConnection(url,username,password);

        //2.create Statement object from connection
        Statement stmnt=conn.createStatement();

        //3. get resultSet by running executeQuery method of statement object
        //we are connecting oracle  database so we can select from HR database tables
        ResultSet rs=stmnt.executeQuery("SELECT *FROM  REGIONS");

        //4. NAVIGATE THROUGH THE RESULT SET OBJECT TO GET THE CELL VALUE
        rs.next(); //move to pointer from before first locations to first row
        //5.use ResultSet getX method like getString,geInt,getDouble to actually read data
        //read REGION_ID and REGION_NAME column and print it out
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));
        // continue to go to next row get more data
        rs.next(); // moved to second row
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));

        // continue to go to next row get more data
        rs.next(); // moved to third row
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));

        // continue to go to next row get more data
        rs.next(); // moved to forth row
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));

        System.out.println("rs.next() = " + rs.next());
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));
        System.out.println("THE END");

    }
}
