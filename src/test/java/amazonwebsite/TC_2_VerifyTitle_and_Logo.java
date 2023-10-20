package amazonwebsite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_2_VerifyTitle_and_Logo {
WebDriver driver;

      @BeforeMethod
      public void setup() throws Exception {
    	  
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      Thread.sleep(5000);
      driver.get("https://www.amazon.in");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
} 
      @Test
      public void VerifyTitle() {
    	  
      String ActualTitle = driver.getTitle();
      String ExpectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
      Assert.assertEquals(ActualTitle, ExpectedTitle);
      System.out.println("Test Case is passed");
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  
 }     
      @Test(priority=1)
      public void VerifyLogo() {
    	  
      boolean flag=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
      Assert.assertTrue(flag);
    	  
 }  
      @AfterMethod
      public void tearDown() {
      driver.quit();  
    	  
 }
      
      
      
      
      
}