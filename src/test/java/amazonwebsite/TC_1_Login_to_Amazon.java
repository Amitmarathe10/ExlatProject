package amazonwebsite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_1_Login_to_Amazon {
WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
    WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
	
	@Test
	public void Singln() {
		
    driver.get("https://www.amazon.in");
    WebElement singin=driver.findElement(By.id("nav-link-accountList"));
    singin.click();
    WebElement email=driver.findElement(By.id("ap_email"));
	email.sendKeys("amitmarathe1012@gmail.com");
	WebElement cont=driver.findElement(By.id("continue"));
	cont.click();		
	WebElement password=driver.findElement(By.id("ap_password"));
	password.sendKeys("Amit@101297");
    WebElement singinBtn=driver.findElement(By.id("signInSubmit"));
	singinBtn.click();
		    
	String ActualTitle = driver.getTitle();
	String ExpectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	Assert.assertEquals(ActualTitle, ExpectedTitle);
	System.out.println("Assert passed");
}	  
	@AfterMethod
	public void closebrowser() {
	driver.close();
	
}	
	
	
	
}