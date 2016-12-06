package testng;

import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SliderRestrictions {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "/home/emilgeorgiev/Downloads/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://credissimo.bg");
		
		SliderRestrictions.changeHomeAmount(driver, "200");
		SliderRestrictions.changeHomePeriod(driver, "14");
		
		SliderRestrictions.changeHomeAmount(driver, "1150");
		SliderRestrictions.changeHomePeriod(driver, "3");
		
		SliderRestrictions.changeHomeAmount(driver, "1300");
		SliderRestrictions.changeHomePeriod(driver, "16");
		
		SliderRestrictions.changeHomeAmount(driver, "1600");
		SliderRestrictions.changeHomePeriod(driver, "4");
		
		SliderRestrictions.changeHomeAmount(driver, "1500");
		SliderRestrictions.changeHomePeriod(driver, "17");
		
		SliderRestrictions.changeHomeAmount(driver, "1450");
		SliderRestrictions.changeHomePeriod(driver, "4");
		
		SliderRestrictions.changeHomeAmount(driver, "200");
		SliderRestrictions.changeHomePeriod(driver, "14");
		
		SliderRestrictions.changeHomeAmount(driver, "1150");
		SliderRestrictions.changeHomePeriod(driver, "16");
		
		SliderRestrictions.changeHomeAmount(driver, "1350");
		SliderRestrictions.changeHomePeriod(driver, "17");
	}

	private static void changeHomeAmount(WebDriver driver, String value) {
		WebElement plusAmount = driver.findElement(By.id("plusAmount"));
		plusAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		plusAmount.sendKeys(value);
		plusAmount.sendKeys(Keys.RETURN);
	}

	private static void changeHomePeriod(WebDriver driver, String value) {
		WebElement plusPeriod = driver.findElement(By.id("plusPeriod"));
		plusPeriod.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		plusPeriod.sendKeys(value);
		plusPeriod.sendKeys(Keys.RETURN);
	}
}