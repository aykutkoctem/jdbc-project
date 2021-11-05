package com.cydeo.day2;

import java.sql.*;

public class FlexibleNavigation {
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
        ResultSet rs=stmnt.executeQuery("SELECT *FROM  EMPLOYEES");

        // navigations methods for moving cursors
        /**
         * next()        --move to next row and return true false according to if we have valid row
         * previous()    -move to previous row and return true false according to if we have valid row
         * first()       - move to first row from anywhere
         * last()        - move to last row from anywhere
         * beforeFirst() - move to before first location from anywhere
         * afterLast()   - move to after last location from anywhere
         * absolute(8)   - move to any row by using row number
         */
         // getting row number of current row the cursor pointing to:rs.getRow()
        System.out.println("rs.getRow() = " + rs.getRow());
        rs.next() ; // now we are at first row
        System.out.println("rs.getRow()  = " + rs.getRow() );
        System.out.println("rs.next() +    rs.getString(\"EMPLOYEE_ID\") = " + rs.getString("EMPLOYEE_ID"));

        rs.last(); // now we are at last row
        System.out.println("rs.getRow()  = " + rs.getRow() );
        System.out.println("rs.last()  +  rs.getString(\"EMPLOYEE_ID\") = " + rs.getString("EMPLOYEE_ID"));

        rs.previous() ; // now we are at 1 row before last row
        System.out.println("rs.getRow()  = " + rs.getRow() );
        System.out.println("rs.previous() +  rs.getString(\"EMPLOYEE_ID\") = " + rs.getString("EMPLOYEE_ID"));

        rs.absolute(100) ; // now we are at row 100
        System.out.println("rs.getRow()  = " + rs.getRow() );
        System.out.println("rs.absolute(100) +  rs.getString(\"EMPLOYEE_ID\") = " + rs.getString("EMPLOYEE_ID"));

        rs.first() ; // now we are at first row
        System.out.println("rs.getRow()  = " + rs.getRow() );
        System.out.println("rs.first() + rs.getString(\"EMPLOYEE_ID\") = " + rs.getString("EMPLOYEE_ID"));

        rs.afterLast(); // now we are at after last location
        System.out.println("rs.getRow()  = " + rs.getRow() );
        rs.previous() ; // go back up from after last location to previous row --> last row
        System.out.println("rs.getRow()  = " + rs.getRow() );

        System.out.println("rs.afterLast() rs.previous() + rs.getString(\"EMPLOYEE_ID\") = " + rs.getString("EMPLOYEE_ID"));
        // reset your cursor to beforeFirst
        rs.beforeFirst();

        // there is no method to get the row count in JDBC
        //so how would get total row count of query result
        //move to the last row and get row number -->> total row count
        rs.last();
        System.out.println("Total row count is " +rs.getRow());

    }
}
