package com.miljanaj;

public class Pages {

    public static HomePage homePage(){
        HomePage homePage = new HomePage();
        return homePage;
    }

    public static SandboxPage sandboxPage(){
        SandboxPage sandboxPage = new SandboxPage();
        return sandboxPage;
    }

    public static TestCases testCases(){
        TestCases testCases = new TestCases();
        return testCases;
    }


    public static EditTestCase editTestCase(){
        EditTestCase editTestCase = new EditTestCase();
        return editTestCase;
    }
}
