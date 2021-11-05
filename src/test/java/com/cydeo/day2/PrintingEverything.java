package com.cydeo.day2;

import java.sql.*;

public class PrintingEverything {
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
        ResultSetMetaData rsmd=rs.getMetaData();
        //go through each and every row
        while (rs.next()){
            //how do you go through each and every column
            for (int columnIndex = 1; columnIndex <=rsmd.getColumnCount() ; columnIndex++) {
                System.out.print(rs.getString(columnIndex)+"  ");
            }
            System.out.println();
        }

    }
}
