package seleniumwork;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MySeleniumTesting {
	
	public WebDriver webDriver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\SupportingLibraries\\chromedriver.exe");
	}
	
	@Test
	public void testGenerateTwoFactorCode() {
		String otpKeyStr = "LJKGE52QMFFVCQ3LNJYDOZSQJE"; // <- this 2FA secret key.

		Totp totp = new Totp(otpKeyStr);
		String twoFactorCode = totp.now(); // <- got 2FA coed at this time!
		System.out.println(twoFactorCode);
	}
	
	
	public String generateTwoFactorCode() {
		String otpKeyStr = "LJKGE52QMFFVCQ3LNJYDOZSQJE"; // <- this 2FA secret key.
		Totp totp = new Totp(otpKeyStr);
		String twoFactorCode = totp.now(); // <- got 2FA coed at this time!
		System.out.println(twoFactorCode);
		
		return twoFactorCode;
	}
	
	@Test
	public void addingBankAccountTest() {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		
		String twoFactorCode = generateTwoFactorCode();
		
		//Step1: Go to the login page
		webDriver.get("https://login.xero.com/");
		
		//Step2: Enter credentials and submit
		webDriver.findElement(By.id("email")).sendKeys("neelam.redhu@gmail.com");
		webDriver.findElement(By.id("password")).sendKeys("Xero@123");
		webDriver.findElement(By.id("submitButton")).click();
		
		//Step3: Enter two factor code and submit		
		WebDriverWait driverWait = new WebDriverWait(webDriver, 30);
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"auth-splashpage\"]/div/div/form/label[1]/div/input")));
		
		webDriver.findElement(By.xpath("//*[@id=\"auth-splashpage\"]/div/div/form/label[1]/div/input")).sendKeys(twoFactorCode);
		webDriver.findElement(By.xpath("//*[@id=\"auth-splashpage\"]/div/div/form/button[1]")).click();
		
		//Step4: Go to Bank account page
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header\"]/header/div/ol[1]/li[3]/button")));
		webDriver.findElement(By.xpath("//*[@id=\"header\"]/header/div/ol[1]/li[3]/button")).click();
		webDriver.findElement(By.xpath("//*[@id=\"header\"]/header/div/ol[1]/li[3]/div/div[2]/div/ol[1]/li[1]/a")).click();
		
		
		
		// Click on add a new bank account
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add Bank Account')]")));
		webDriver.findElement(By.xpath("//span[contains(text(),'Add Bank Account')]")).click();
		
		// Click of the ANZ(AU)
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dataview-1021\"]/li[1]")));
		webDriver.findElement(By.xpath("//*[@id=\"dataview-1021\"]/li[1]")).click();
		
		// Add details in bank account
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountname-1037-inputEl")));
		
		String accountName = "MyTestAccount_"+((int)(Math.random() * 100 + 1));
		webDriver.findElement(By.id("accountname-1037-inputEl")).sendKeys(accountName);
		
		WebElement element = webDriver.findElement(By.id("accounttype-1039-inputEl"));
		element.click();
		element.sendKeys(Keys.DOWN);
		element.sendKeys(Keys.ENTER);

		String bsb = "123456";
		String accountNumber = "1234" + ((int)(Math.random() * 100 + 1));
		
		webDriver.findElement(By.id("branchnumber-1045-inputEl")).sendKeys(bsb);
		webDriver.findElement(By.id("accountnumber-1046-inputEl")).sendKeys(accountNumber);


		//Click the continue button to add the account.
		webDriver.findElement(By.id("common-button-submit-1015-btnInnerEl")).click();
		
		
		// To verify the message
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/p[1]")));
		String accountCreatedText = webDriver.findElement(By.xpath("/html[1]/body[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/p[1]")).getText();
		
		Assert.assertEquals(accountCreatedText, accountName+" has been added.");
		
	}
}
