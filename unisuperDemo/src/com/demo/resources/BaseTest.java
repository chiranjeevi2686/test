package com.demo.resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	public WebDriver driver = null;
	public static Properties CONFIG = null;

	@BeforeSuite
	public void setupCustomReport() {

	}

	@AfterSuite
	public void updatingCustomReport() {

	}

	public void initConfigurations() {
		if (CONFIG == null) {
			CONFIG = new Properties();
			try {
				FileInputStream fs = new FileInputStream(
						System.getProperty("user.dir")+"//src//com//demo//config/config.properties");
				CONFIG.load(fs);
			} catch (Exception e) {
			
			}
		}
	}

	public void initDriver() {
		
		if (driver == null) {
			if (CONFIG.getProperty("browser").equals("Mozilla")) {
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//drivers//geckodriver");
				 driver=new FirefoxDriver();
			} else if (CONFIG.getProperty("browser").equals("IE")) {
				//test code can be written to handle IE driver

			} else if (CONFIG.getProperty("browser").equals("Chrome")) {
				//test code can be written to handle chrome driver
				
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")+"//drivers//chromedriver");
				driver = new ChromeDriver();
			}
		}
	}

	public void quitDriver() {
		driver.quit();
		driver = null;
	}


	public void openBrowser() {
		try{
		String appUrl = CONFIG.getProperty("applicationUrl");
		driver.get(appUrl);
		driver.manage().window().maximize();
		}catch(Exception e ){
			reportFail("Error in openBrowser:"+e);	
		}
	}
	
	public void elementClick(String identifier) {
		try{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(identifier)));
		driver.findElement(By.xpath(identifier)).click();	
		}catch(Exception e ){
			reportFail("Error in elementClick:"+e);
		}
	}
	
	public void elementClickSpl(String identifier) {
		try{

		driver.findElement(By.xpath(identifier)).click();	
		}catch(Exception e ){
			reportFail("Error in elementClick:"+e);
		}
	}
	
	public void elementFeed(String identifier, String value) {
		try{
			
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
		driver.findElement(By.xpath(identifier)).sendKeys(value);
		}catch(Exception e ){
			reportFail("Error in elementFeed:"+e);
		}
	}
	
	public void keyboardEnter(String identifier){
		try{
		driver.findElement(By.xpath(identifier)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		}catch(Exception e ){
			reportFail("Error in keyboardEnter:"+e);
		}
	}
	
	public void elementDbClick(String identifier){
		try{
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath(identifier))).perform();
		}catch(Exception e ){
			reportFail("Error in elementDbClick:"+e);
		}
	}
	public static void reportFail(String errorMessage) {
		Assert.fail(errorMessage);
		
		}

	public void elementClear(String identifier){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(identifier)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
			driver.findElement(By.xpath(identifier)).clear();
			
		}catch(Exception e ){
			reportFail("Error in elementDbClick:"+e);
		}
	}
	
	

}
