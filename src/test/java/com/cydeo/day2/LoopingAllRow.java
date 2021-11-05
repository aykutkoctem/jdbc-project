package com.cydeo.day2;

import java.sql.*;

public class LoopingAllRow {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE" ;
        String username = "hr" ;
        String password = "hr" ;

        //1.get connection object
        //GETcONNECTION METHOD THROWS CHECKED EXCEPTION,THIS TIME WE DECIDD TO
        //DECLARE IT INSTEAD OF HANDLING IT USING THROWS SQLEXCEPTION
        Connection conn= DriverManager.getConnection(url,username,password);

        //2.create Statement object from connection
        Statement stmnt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //3. get resultSet by running executeQuery method of statement object
        //we are connecting oracle  database so we can select from HR database tables
        ResultSet rs=stmnt.executeQuery("SELECT *FROM  REGIONS");

        // 4. loop through all row and print items
        // rs.next() move the cursor to next row,
        //return true if next row is valid,false if not,
        //so we can use in while condition

        while(rs.next()){ //keep looping until there is no valid next row
            System.out.println("Region Id = " + rs.getString("REGION_ID"));
            System.out.println("Region Name = " + rs.getString("REGION_NAME"));
        }
        //now you are after last location, if you run below line, it will throw exception
      //  rs.previous();
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        //ResultSet Object many navigation methods other than next()
    }
}
