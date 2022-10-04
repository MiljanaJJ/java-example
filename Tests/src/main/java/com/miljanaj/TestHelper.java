package com.miljanaj;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TestHelper {


    ArrayList<TestCase> allTestCases;
    int numberOfTestCases = 5;

    public  TestHelper(ArrayList<TestCase> allTestCases, int numberOfTestCases) {
        this.allTestCases = allTestCases;
        this.numberOfTestCases = numberOfTestCases;

    }


    public void readTestCaseCard(){
        TestCase testCase = new TestCase();
        testCase.setTitle(Pages.editTestCase().getTCTitle());
        testCase.setDescription(Pages.editTestCase().getTCDescription());
        testCase.setExpectedResult(Pages.editTestCase().getTCExpectedResult());
        testCase.setNumberOfSteps(Pages.editTestCase().getNumberOfTCSteps());
        testCase.setSteps(Pages.editTestCase().getStepsFromTC(testCase.getNumberOfSteps()));
        allTestCases.add(testCase);
    }


    public int numberOfTestCaseSteps(TestCase TC){
        WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='preview-card']")));
        WebElement TCcard =  Browser.driver.findElement(By.xpath("//div[@class='preview-card']"));
        TCcard.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Test step'])[0]")));
        List<WebElement> allSteps = Browser.driver.findElements(By.xpath("//input[@placeholder='Test step']"));
        return allSteps.size();
    }


    public  void saveAndDeleteAllTestCases(int numberOfTestCases) throws Exception{
        try {
            for (int i = 1; i <= numberOfTestCases; i++) {
                Pages.testCases().openTestCaseCardToDelete();

                this.readTestCaseCard();
                Pages.editTestCase().deleteTC();
            }
        }
        catch (Exception e)
        {
            Assertions.assertNotNull(e.getMessage());
        }
    }


    public void addAllTestCases(ArrayList<TestCase> allTestCases) {
        for(int i=0; i<= allTestCases.size()-1; i++){
            int orderNumberOfTC = i;
            Pages.testCases().addTestCase(allTestCases.get(orderNumberOfTC), allTestCases.get(orderNumberOfTC).getNumberOfSteps());
        }
    }

    public void editAllTestCases(int numberOfTestCases)throws Exception{
        try {
            for (int i = 1; i <= numberOfTestCases + 1; i++) {
                Pages.testCases().openTestCaseCardToEdit(i);
                ArrayList<WebElement> allTCElements = Pages.editTestCase().getAllTestCaseElements();
                for (int j = 0; j <= allTCElements.size() - 1; j++) {
                    Pages.editTestCase().editTestCaseCard(allTCElements.get(j));
                }
                Pages.editTestCase().submitTestCaseCard();
            }
        }
        catch (Exception e)
        {
            Assertions.assertNotNull(e.getMessage());
        }
    }

    public  void deleteAllTestCases(int numberOfTestCases)throws Exception{
        try {
            for (int i = 1; i <= numberOfTestCases + 1; i++) {
                Pages.testCases().openTestCaseCardToDelete();
                Pages.editTestCase().deleteTC();
            }
        }
        catch (Exception e)
        {
                Assertions.assertNotNull(e.getMessage());
        }
    }
}
