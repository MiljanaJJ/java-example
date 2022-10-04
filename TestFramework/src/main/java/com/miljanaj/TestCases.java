package com.miljanaj;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class TestCases {


    public void openTestCaseCardToEdit(int i) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='preview-card'])["+i+"]")));
            WebElement testCaseCard = Browser.driver.findElement(By.xpath("(//div[@class='preview-card'])["+i+"]"));
            testCaseCard.click();
        }
        catch(Exception e){
             throw new Exception(e);
        }

    }

    public void openTestCaseCardToDelete() throws Exception{
        try {
            WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='preview-card'])[1]")));
            WebElement testCaseCard = Browser.driver.findElement(By.xpath("(//div[@class='preview-card'])[1]"));
            testCaseCard.click();
        }
        catch(Exception e){
            throw new Exception(e);
        }

    }


    public void addTestCase(TestCase testCase,  int numberOfSteps) {
        WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='navigate-right']")));
        WebElement addTCButton = Browser.driver.findElement(By.xpath("//div[@class='navigate-right']"));
        addTCButton.click();


        WebElement testCaseCardTitle = Browser.driver.findElement(By.name("title"));
        testCaseCardTitle.click();
        testCaseCardTitle.sendKeys(testCase.getTitle());

        WebElement testCaseCardDescription = Browser.driver.findElement(By.xpath("//textarea[@placeholder='Description']"));
        testCaseCardDescription.click();
        testCaseCardDescription.sendKeys(testCase.getDescription());

        WebElement testCaseCardExpectedResult = Browser.driver.findElement(By.name("expected_result"));
        testCaseCardExpectedResult.click();
        testCaseCardExpectedResult.sendKeys(testCase.getExpectedResult());

        for (int i = 0; i < numberOfSteps; i++) {
            WebElement testCaseStep = Browser.driver.findElement(By.name("step-" + i));
            testCaseStep.click();
            testCaseStep.sendKeys(testCase.getSteps().get(i));
            WebElement buttonAddStep = Browser.driver.findElement(By.xpath("//div[@class='form-element undefined']"));
            buttonAddStep.click();
        }
        WebElement submit = Browser.driver.findElement(By.xpath("//button[@class='btn btn-primary float-right']"));
        submit.click();
    }

        public int numberOfTestCases(){
            WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='preview-card']")));
            List<WebElement> allTCS = Browser.driver.findElements(By.xpath("//div[@class='preview-card']"));
            return allTCS.size();
        }



    }


