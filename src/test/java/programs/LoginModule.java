package programs;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginModule {
	WebDriver driver;
	
	@BeforeMethod
	public void initialization() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	
	
	@Test(priority = 1)
	public void signUp() {
		
		driver.get("https://auth.dev.vntech.io/");
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();

		Actions ac = new Actions(driver);

		driver.findElement(By.xpath("//p[text()='Other']")).click();	
		
		WebElement signUp = driver.findElement(By.xpath("//a[text()='Sign up']"));
		ac.moveToElement(signUp).click().build().perform();		
		signUp.click();
		
	// to create New user	
		WebElement other = driver.findElement(By.xpath("//p[text()='Other']"));
		ac.moveToElement(other).click().build().perform();		
				
	    driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Shubham");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Dhomane");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("dhomaneshubham1@gamil.com");
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
   
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	


	@Test(priority = 2)
	public void gmailVerification() {
		
//		driver.get("https://mail.google.com/mail/");
//		driver.findElement(By.id("identifierId")).sendKeys("dhomaneshubham1@gmail.com");
//		driver.findElement(By.xpath("//span[text()='Next']")).click();
//		
		
		driver.get("https://auth.dev.vntech.io/email/verify+set+password/email=dhomaneshubham1@gmail.com&uid=73973&fname=Shubham&lname=Dhomane&key=71edf926586aa3ef91657c816e54990d2c6e6a6304d8b35c4789efa7de48bc7e&platform=Secure");
       	driver.findElement(By.xpath("(//button[contains(text(),'Accept All')])[1]")).click();
       	driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Shubham@4");
       	driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Shubham@4");
       	driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
       	
	}
	
	

	@Test(priority = 3)
	public void validateLogin() {
		
		driver.get("https://auth.dev.vntech.io/");
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();

		driver.findElement(By.xpath("//p[text()='Other']")).click();	
		driver.findElement(By.id("email")).sendKeys("dhomaneshubham1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Shubham@4");
		driver.findElement(By.id("signin")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
	
	
	
	
	
	

}
