package com.miljanaj;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

    static WebDriver driver = new ChromeDriver();

    public static void maximizeWindow(){
        driver.manage().window().fullscreen();
    }

    public static void goTo(String url){
        driver.get(url);
    }

    public static String title(){
        return driver.getTitle();
    }

    public static void close(){
         driver.close();
    }
    public static void setBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        Browser.driver.manage().deleteAllCookies();
    }
}
