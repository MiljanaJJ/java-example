package com.miljanaj;
import com.google.common.base.MoreObjects;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.ArrayList;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestsNotInExam{


   TestHelper testHelper;

    @BeforeAll
    public void setUp(){
        Browser.setBrowser();
        int numberOfTestCases = 5;
        ArrayList<TestCase> allTestCases = new ArrayList<TestCase>(numberOfTestCases);
         testHelper = new TestHelper(allTestCases,
                numberOfTestCases);
    }

    @Test
    @Order(1)
    public void visitHomePage(){
        Pages.homePage().goTo();
        Browser.maximizeWindow();
        Assertions.assertTrue(Pages.homePage().isAt());
    }

    @Test
    @Order(2)
    public void loginToTheSandbox(){
        Pages.homePage().login();
    }

    @Test
    @Order(3)
    public  void locateTestCase(){
        Pages.sandboxPage().openTestCases();
    }



    @Test
    @Order(4)
    public  void saveAndDeleteAllTestCases() throws Exception{
        testHelper.saveAndDeleteAllTestCases(testHelper.numberOfTestCases);
        }


    @Test
    @Order(5)
    public void addAllTestCases(){
        testHelper.addAllTestCases(testHelper.allTestCases);
    }

    @Test
    @Order(6)
    public void editAllTestCases() throws Exception{
        testHelper.editAllTestCases(testHelper.numberOfTestCases);
    }

//    @Test
//    @Order(7)
//    public void deleteAllTestCases() throws Exception{
//        testHelper.deleteAllTestCases(testHelper.numberOfTestCases);
//    }



    @AfterAll
    public static void clean(){
        Browser.close();

    }


}
