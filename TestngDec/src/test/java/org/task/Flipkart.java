package org.task;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page.GetAppManifestResponse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	 static WebDriver driver;
	 static long starttime;
@BeforeClass
public static void launch() {
	System.out.println("Before class");
	WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@BeforeMethod
public void starttime() {

	System.out.println("Before");
	starttime = System.currentTimeMillis();
	System.out.println(starttime);
	
}
@AfterMethod
public  void endtime() {

	System.out.println("After");
	long endtime = System.currentTimeMillis();
	System.out.println(endtime);
	System.out.println("Timetaken is:" +(endtime-starttime));
}
@Test(priority = -1)
public  void login() {
try {
	WebElement button = driver.findElement(By.xpath("//button[text()='✕']"));
	button.isDisplayed();
	button.click();
}catch(Exception e) {
	System.out.println("Button is not displayed"); 
}
	
	WebElement searchbox = driver.findElement(By.name("q"));
	searchbox.sendKeys("realme",Keys.ENTER);
}
		
	static String Mobname;	
@Test(priority = 0)
public   void mobname()  {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement mobname = driver.findElement(By.xpath("(//div[contains(text(),'realme')])[2]"));
	Mobname = mobname.getText();
	System.out.println(Mobname);
	wait.until(ExpectedConditions.elementToBeClickable(mobname));
   }
@Test(priority = 1)
public  void windowhandle() {
	String parent = driver.getWindowHandle();
	Set<String> child = driver.getWindowHandles();
	for (String x : child) {
		if(!parent.equals(child)) {
			driver.switchTo().window(parent);
		}}}
@Test(priority = 2)
public  void newmob() {
	WebElement newmobname = driver.findElement(By.xpath("//span[contains(text(),'realme')]"));
	String Newmob = newmobname.getText();
	System.out.println(Newmob); 
	Assert.assertTrue(Newmob.equals(Mobname));
		}
		
@AfterClass
public static void quit() throws IOException {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmm");
	LocalDateTime now = LocalDateTime.now();
	String format = dtf.format(now);
	System.out.println(format);

	System.out.println("After class");
	TakesScreenshot tk =(TakesScreenshot) driver;
	File src = tk.getScreenshotAs(OutputType.FILE);
	File desc = new File(".//target//report"+format+".png");
	FileUtils.copyFile(src, desc);
	driver.quit();
}}
