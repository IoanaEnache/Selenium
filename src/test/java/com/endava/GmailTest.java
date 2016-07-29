package com.endava;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by ienache on 7/29/2016.
 */
public class GmailTest {

    static WebDriver webDriver;

    @BeforeClass
    public static void setUP() {

        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://gmail.com");

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void testGmail(){

        // get the email field
        WebElement emailField = webDriver.findElement(By.xpath("//input[@id = 'Email']"));
        emailField.sendKeys("endavaselenium");

        // get the next button field
        WebElement nextField = webDriver.findElement(By.xpath("//input[@id='next']"));
        nextField.click();

        WebElement passwordField = webDriver.findElement(By.xpath("//input[@id='Passwd']"));
        passwordField.sendKeys("endavaqa");

        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='signIn']"));
        signInButton.click();

        WebElement composeButton = webDriver.findElement(By.xpath("//div[text()=\'COMPOSE\']"));
        composeButton.click();

        WebElement toField = webDriver.findElement(By.xpath("//textarea[@name='to']"));
        toField.sendKeys("endavaselenium@gmail.com");
        toField.sendKeys(Keys.RETURN);

        WebElement subjectField = webDriver.findElement(By.xpath("//input[@name='subjectbox']"));
        subjectField.sendKeys("Test");

        WebElement messageBox= webDriver.findElement(By.xpath("//div[@aria-label='Message Body']"));
        messageBox.sendKeys("Test");

        WebElement sendButton= webDriver.findElement(By.xpath("//div[contains(@aria-label,'Send')]"));
        sendButton.click();

    }

    @AfterClass
    public static void tearDown(){

       webDriver.close();

    }

}
