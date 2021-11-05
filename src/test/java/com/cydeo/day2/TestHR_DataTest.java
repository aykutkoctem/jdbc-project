package com.cydeo.day2;

import com.cydeo.Utilities.ConfigReader;
import com.cydeo.Utilities.DB_Util;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestHR_DataTest {
    //connection creation need to be only performed once
    //so @BeforeAll method is good place to put out
    @BeforeAll
    public static void init(){
        String url= ConfigReader.read("hr.database.url");
        String username=ConfigReader.read("hr.database.username");
        String password=ConfigReader.read("hr.database.password");

        DB_Util.createConnection(url,username,password);
    }

    @Test
    public void testRegion(){

        // read the first row of Regions table and verify REGION_NAME is Europe
        DB_Util.runQuery("SELECT * FROM REGIONS") ;
        String firstRegion =  DB_Util.getCellValue(1,"REGION_NAME") ;

        Assertions.assertEquals("Europe" , firstRegion ) ;


    }
//write a test to verify the max salary holder name is Steven King
// Write a test to verify the max salary holder name is Steven King
@Test
public void testEmployee(){

    String query = "SELECT FIRST_NAME || ' '|| LAST_NAME  FROM EMPLOYEES " +
            "WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEES ) " ;

    DB_Util.runQuery(query) ;
    String expectedResult = "Steven King" ;
    String actualResult = DB_Util.getFirstRowFirstColumn() ;

    Assertions.assertEquals(expectedResult, actualResult);

}



    //Closing creation need to be only performed once
    //so @AfterAll method is good place to put out
    @AfterAll
    public static void tearDown(){
        DB_Util.destroy();
    }
}
