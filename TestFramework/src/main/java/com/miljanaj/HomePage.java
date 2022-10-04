package com.miljanaj;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
     static String url = "https://qa-sandbox.ni.htec.rs/login";
     static String title = "QASandbox";

     public void goTo(){
       Browser.goTo(url);
     }

     public boolean isAt(){
         return Browser.title().equals(title);
     }

     public void login(){
         WebElement emailTextBox = Browser.driver.findElement(By.name("email"));
         emailTextBox.sendKeys("miljana.janjiceva@gmail.com");

         WebElement passwordTextBox = Browser.driver.findElement(By.name("password"));
         passwordTextBox.sendKeys("test0987");
         passwordTextBox.sendKeys(Keys.TAB);

         WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
         WebElement buttonLogin = Browser.driver.findElement(By.xpath("//button"));
         buttonLogin.click();

     }
}
