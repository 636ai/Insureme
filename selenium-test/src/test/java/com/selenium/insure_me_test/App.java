package com.selenium.insure_me_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    public void testHomePage() {
        WebDriver driver = new ChromeDriver();
        driver.get(System.getProperty("testUrl"));
        // your test steps...
        driver.quit();
    }

    // ✅ ADD THIS below:
    public static void main(String[] args) {
        // Pass URL as argument or fallback to local
        System.setProperty("testUrl", args.length > 0 ? args[0] : "http://localhost:8081");
        new App().testHomePage();
    }
}
