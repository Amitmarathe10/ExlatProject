package amazonwebsite;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_3_Add_to_Cart {
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
     public void Searchbox() {
     WebElement searchbox =driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));	
     searchbox.sendKeys("redmi note 10");
     WebElement searchbtn=driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
     searchbtn.click();
     WebElement product=driver.findElement(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]"));
     product.click();	
     
     Set<String> s = driver.getWindowHandles();
     ArrayList ar = new ArrayList(s);
     System.out.println(ar.get(0));
     System.out.println(ar.get(1));
     driver.switchTo().window((String)ar.get(1));
     
       WebElement Addcart=driver.findElement(By.xpath("//input[@id=\"add-to-cart-button\"]"));
       Addcart.click();
     
     }
     
     
     @AfterMethod
     public void tearDown() {
     driver.quit(); 
     }
    
}
