package seleniumwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MySeleniumTesting {
	
	public WebDriver webDriver;
	
	@Test
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\SupportingLibraries\\chromedriver.exe");
		webDriver = new ChromeDriver();
		
		webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		webDriver.findElement(By.id("email_create")).sendKeys("hello@automation.com");
		
		webDriver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
		
		String message = webDriver.findElement(By.className("page-heading")).getText();
		System.out.println(message);
		//Assert.assertEquals(message, "CREATE AN ACCOUNT");
		
		webDriver.quit();
	}
}
