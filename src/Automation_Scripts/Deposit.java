package Automation_Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.*;


public class Deposit {
	
	WebDriver driver;
	WebDriverWait wait;
	
	

	@BeforeSuite
	public void setup() {
		
	   System.setProperty("webdriver.chrome.driver", "C:\\Selanium_Google Drive\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
	
	}
	
	@Test(priority = 0)
	public void login () {
		try {
			
			 WebElement select_profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")));
			 select_profile.click();
			 
			 WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userSelect")));
			 
			 Thread.sleep(2000);
			 
			 dropdown.click();
			 
			 WebElement user = driver.findElement(By.xpath("//*[@id=\"userSelect\"]/option[3]"));
			 user.click();
			 
			 
			 WebElement login = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button"));
			 login.click();
			
		} catch (Exception e) {
			System.out.println("The error is: " + e);
		}
		
	}
	
	@Test(priority = 1)
	public void deposit() {
		
		try {
			 WebElement oldbalanceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")));
			 String oldbalance = oldbalanceElement.getText();
			 System.out.println("Balance Before Deposit : " + oldbalance);
			 
			 WebElement deposit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")));
			 deposit.click();
			 
			 Thread.sleep(2000);
			 
			 WebElement amount =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")));
			 amount.sendKeys("10000");
			 
			 WebElement dep_button = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button"));
			 dep_button.click();
			 
			 Thread.sleep(2000);
			 
			 WebElement newbalanceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")));
			 String newbalance = newbalanceElement.getText();
			 System.out.println("Balance After Deposit : " + newbalance);
			
			
		} catch (Exception e) {
			System.out.println("The error is: " + e);
		}
	}
	

	@AfterSuite
	public void teardown() {
		driver.quit();
	}

}
