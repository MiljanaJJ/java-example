package com.miljanaj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SandboxPage {

    public void openTestCases(){

        WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-grid']/a[@href='/testcases']")));
        WebElement testCases = Browser.driver.findElement(By.xpath("//div[@class='card-grid']/a[@href='/testcases']"));
        testCases.click();
    }

}
