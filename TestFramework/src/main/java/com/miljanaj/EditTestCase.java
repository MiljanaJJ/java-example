package com.miljanaj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class EditTestCase {

    public void deleteTC() {
        WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger']")));
        WebElement deleteButton = Browser.driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        deleteButton.click();
        // Browser.driver.switchTo();
        WebElement confirm = Browser.driver.findElement(By.xpath(" //div[@class='confirmation-dialog--buttons--confirm']"));
        confirm.click();

    }

    public void closeTestCaseCard() {
        WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='navigate']/a")));
        WebElement buttonExit = Browser.driver.findElement(By.xpath("//div[@class='navigate']/a"));
        buttonExit.click();

    }

    public String getTCTitle() {
        WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("title")));
        WebElement testCaseCardTitle = Browser.driver.findElement(By.name("title"));
        return testCaseCardTitle.getAttribute("value");
    }


    public String getTCDescription() {
        WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Description']")));
        WebElement testCaseCardDescription = Browser.driver.findElement(By.xpath("//textarea[@placeholder='Description']"));
        return testCaseCardDescription.getAttribute("value");

    }

    public String getTCExpectedResult() {

        WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("expected_result")));
        WebElement testCaseCardExpectedResult = Browser.driver.findElement(By.name("expected_result"));
        return testCaseCardExpectedResult.getAttribute("value");
    }

    public int getNumberOfTCSteps() {
        WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Test step']")));
        List<WebElement> allsteps = Browser.driver.findElements(By.xpath("//input[@placeholder='Test step']"));
        return allsteps.size();
    }

    public ArrayList<String> getStepsFromTC(int stepsNumber) {
        String testCaseStepText = "";
        ArrayList<String> steps = new ArrayList<String>(stepsNumber);
        for (int i = 0; i < stepsNumber; i++) {
            int counter = i;
            WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("step-" + counter)));
            WebElement testCaseStep = Browser.driver.findElement(By.name("step-" + counter));
            testCaseStepText = testCaseStep.getAttribute("value");
            steps.add(testCaseStepText);
        }

        return steps;
    }

    public ArrayList<WebElement> getAllTestCaseElements() {
        ArrayList<WebElement> TCElements = new ArrayList<>();

        WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("title")));
        WebElement testCaseCardTitle = Browser.driver.findElement(By.name("title"));

        TCElements.add(testCaseCardTitle);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Description']")));
        WebElement testCaseCardDescription = Browser.driver.findElement(By.xpath("//textarea[@placeholder='Description']"));

        TCElements.add(testCaseCardDescription);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("expected_result")));
        WebElement testCaseCardExpectedResult = Browser.driver.findElement(By.name("expected_result"));

        TCElements.add(testCaseCardExpectedResult);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Test step']")));
        List<WebElement> allsteps = Browser.driver.findElements(By.xpath("//input[@placeholder='Test step']"));
        int numberOfSteps = allsteps.size();

        for (int i = 0; i < numberOfSteps; i++) {
            int counter = i;
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("step-" + counter)));
            WebElement testCaseStep = Browser.driver.findElement(By.name("step-" + counter));
            TCElements.add(testCaseStep);
        }

        return TCElements;
    }

    public void editTestCaseCard(WebElement element) {
        element.click();
        String elementText = element.getAttribute("value") + "edited 743578";
        element.clear();
        element.sendKeys(elementText);

    }

    public void submitTestCaseCard() {
        WebDriverWait wait = new WebDriverWait(Browser.driver, 45);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary float-right']")));
        WebElement submit = Browser.driver.findElement(By.xpath("//button[@class='btn btn-primary float-right']"));
        submit.click();
    }
}
