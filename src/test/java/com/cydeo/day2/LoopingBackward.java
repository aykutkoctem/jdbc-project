package com.cydeo.day2;

import java.sql.*;

public class LoopingBackward {
    public static void main(String[] args) throws SQLException {

        //run this query - SELECT * FROM EMPLOYEES WHERE EMPLOYEES_ID<120
        //PRINT OUT THE EMPLOYEES_ID COLUMN  FROM LAST ROW UNTIL FIRST ROW

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
        ResultSet rs=stmnt.executeQuery("SELECT *FROM  EMPLOYEES WHERE EMPLOYEE_ID<120");
      //  ResultSetMetaData rsmd=rs.getMetaData();

        //Print out the employee_ID column from last row until first row
        rs.afterLast(); // move the cursor to after last location so we can use previous to move back

        while (rs.previous()){
            System.out.println(rs.getString(1));
        }
        // After we are done with Connection , Statement , ResultSet , we need to close them
        // just like Scanner , FileInputStream and so on
        // the order of closing is exactly opposite to the creation
        rs.close();
        stmnt.close();
        conn.close();
    }
}
