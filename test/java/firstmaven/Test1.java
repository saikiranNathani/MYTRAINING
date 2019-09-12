package firstmaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Test1 {
	 WebDriver d=null;
  @BeforeTest
  public void setup() {
	  d=new FirefoxDriver();
	  d.get("https://ebay.com");
	  d.manage().window().maximize();
	  d.manage().deleteAllCookies();
	  d.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
  }
  @Test
  @Parameter
  public void ebaySignIn() {
	  d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  d.findElement(By.linkText("Sign in")).click();
	  d.findElement(By.id("userid")).sendKeys("kaka");
	  d.findElement(By.id("pass")).sendKeys("mama"); 
	  d.findElement(By.id("sgnBt")).submit();
  }
  
  @AfterTest
  public void teardown() {
	  d.quit();
  }
  
}
