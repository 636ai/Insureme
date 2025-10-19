package com.selenium.insure_me_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) {
        // ✅ Check that URL is passed
        if (args.length == 0) {
            System.out.println("ERROR: No URL provided!");
            return;
        }
        String url = args[0];
        System.out.println("Opening URL: " + url);

        // ✅ Headless mode for Jenkins
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get(url);
            System.out.println("Page title: " + driver.getTitle());

            // ✅ Simple check
            WebElement element = driver.findElement(By.tagName("body"));
            if (element != null) {
                System.out.println("Test Passed ✅");
            } else {
                System.out.println("Test Failed ❌");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
