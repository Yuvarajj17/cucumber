package com.flipkart.stepdefinition;

import java.util.List;
import java.util.Map;
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
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TVPurchase {
	 static WebDriver driver;
	 static String TVname;
	 
		@Given("User launch the app")
		public void user_launch_the_app() {
		    WebDriverManager.chromedriver().setup();
		     driver = new ChromeDriver();
		    driver.get("https://www.flipkart.com/");
		    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		}


		@Given("User login by using credentials")
		public void user_login_by_using_credentials() {
			try {
		  WebElement button = driver.findElement(By.xpath("//button[text()='✕']"));
		  button.isDisplayed();
		  button.click();
			}catch(Exception e) {
				System.out.println("Button is not displayed");
			   }
		}

		@When("user search the Tv")
		public void user_search_the_Tv() throws InterruptedException {

			TVname="SAMSUNG 80 cm (32 inch) HD Ready LED Smart TV";
			WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
			search.sendKeys("SAMSUNG 80 cm (32 inch) HD Ready LED Smart TV", Keys.ENTER);
			
		}

		@When("user click on the Tv name")
		public void user_click_on_the_Tv_name() throws InterruptedException {
			
			Thread.sleep(2000);
			WebElement q = driver.findElement(By.xpath("(//div[contains(text(),'"+TVname+"')])[1]"));
			JavascriptExecutor j = (JavascriptExecutor)driver;
			j.executeScript("arguments[0].click()", q);
			//q.click();
			String c = driver.getWindowHandle();
			Set<String> d = driver.getWindowHandles();
			for (String e : d) {
				if (!c.equals(e)) {
					driver.switchTo().window(e);
				}

			}
		}
			

			@Then("user click on add tocart")
	public void user_click_on_add_tocart() throws InterruptedException {
		WebElement t = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true)", t);
		j.executeScript("arguments[0].click()", t);
			t.click();
			Thread.sleep(5000);
			driver.quit();
			System.out.println("TV purchase add to cart");
			}
			
			@When("user search the TV in one dim list")
			public void user_search_the_TV_in_one_dim_list(DataTable dataTable) {
			  List<String> aslist = dataTable.asList(String.class);			
			WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
	search.sendKeys(aslist.get(1),Keys.ENTER);
	TVname =aslist.get(1);
	System.out.println("one dim list");
			}		
			
		}
	