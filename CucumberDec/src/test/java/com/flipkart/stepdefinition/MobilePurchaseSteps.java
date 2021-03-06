package com.flipkart.stepdefinition;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurchaseSteps {
	 static WebDriver driver;
	@Given("User launch the application")
	public void user_launch_the_application() {
	    WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
	    driver.get("https://www.flipkart.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@Given("User log in by using credentials")
	public void user_log_in_by_using_credentials() {
		try {
	  WebElement button = driver.findElement(By.xpath("//button[text()='✕']"));
	  button.isDisplayed();
	  button.click();
		}catch(Exception e) {
			System.out.println("Button is not displayed");
		   }
	}

	@When("search mobile name")
	public void search_mobile_name() {
	    WebElement search = driver.findElement(By.name("q"));
	    search.sendKeys("realme",Keys.ENTER);
	}

	@When("click mobile name which user want")
	public void click_mobile_name_which_user_want() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement mobname = driver.findElement(By.xpath("//div[text()='realme Narzo 50A (Oxygen Green, 64 GB)']"));
		wait.until(ExpectedConditions.elementToBeClickable(mobname));
	}

	@Then("click on add to cart")
	public void click_on_add_to_cart() {
	  String par = driver.getWindowHandle();
	Set<String> child = driver.getWindowHandles();
	for (String x : child) {
		if(!par.equals(x)) {
			driver.switchTo().window(x);
		}}
	WebDriverWait wait = new WebDriverWait(driver, 50);
	try {
	WebElement cart = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)",cart);
	wait.until(ExpectedConditions.elementToBeClickable(cart));
	}catch (Exception e) {
		System.out.println("handled");
	}

	}}
