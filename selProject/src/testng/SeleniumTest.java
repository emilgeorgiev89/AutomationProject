package testng;

import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;

public class SeleniumTest {

	// @FindBy(id = "email_plus")
	// static WebElement emailPlusElement;
	//
	// @FindBy(id = "phone_plus")
	// static WebElement phonePlusElement;
	//
	// @FindBy(className = "first-step")
	// static WebElement submitButton;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "/home/emilgeorgiev/Downloads/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Launch the Online Store Website
		driver.get("https://credissimo.bg/plus");
		SeleniumTest.homepage(driver, "plus");

		driver.get("https://credissimo.bg/salary");
		SeleniumTest.homepage(driver, "salary");
	}

	public static void homepage(WebDriver driver, String type) {

		WebElement emailElement = driver.findElement(By.id("email_" + type));
		emailElement.clear();
		emailElement.sendKeys("e.georgiev@gmail.com");

		WebElement phoneElement = driver.findElement(By.id("phone_" + type));
		phoneElement.clear();
		phoneElement.sendKeys("0883484790");

		WebElement submitButton = driver.findElement(By.className("first-step"));
		submitButton.click();

		WebElement creditForm = driver.findElement(By.id("creditForm"));
		AssertJUnit.assertEquals(true, creditForm.isDisplayed());
		
		WebElement backToHomePage = driver.findElement(By.className("navbar-brand"));
		backToHomePage.click();
	}

}
