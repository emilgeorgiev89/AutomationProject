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
		StringBuffer verificationErrors = new StringBuffer();
		System.setProperty("webdriver.gecko.driver", "/home/emilgeorgiev/Downloads/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		
		driver.get("https://credissimo.bg");
		SliderRestrictions.testSliderRestrictions(driver, verificationErrors);
	}

	public static void testSliderRestrictions(WebDriver driver, StringBuffer verificationErrors) throws Exception {
		// 200 - 1 100 лв. - изплащане от 3 до 13 месеца
		WebElement plusAmount = driver.findElement(By.id("plusAmount"));
		plusAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"), "200");
		
		WebElement plusPeriod = driver.findElement(By.id("plusPeriod"));
		plusPeriod.sendKeys(Keys.chord(Keys.CONTROL, "a"), "14");
		
		driver.findElement(By.id("plusAmount")).sendKeys("200");
		driver.findElement(By.id("plusPeriod")).clear();
		driver.findElement(By.id("plusPeriod")).sendKeys("14");
		try {
			assertEquals("Максималният срок за изплащане на суми до 1100 лв. е 13 месеца.",
					driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// 1 100 - 1 300 лв. - изплащане от 4 до 15 месеца
		// - Min
		driver.findElement(By.id("plusAmount")).clear();
		driver.findElement(By.id("plusAmount")).sendKeys("1150");
		driver.findElement(By.id("plusPeriod")).clear();
		driver.findElement(By.id("plusPeriod")).sendKeys("3");
		try {
			assertEquals("Минималният срок за изплащане на суми от 1100 лв. до 1300 лв. е 4 месеца.",
					driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// - Max
		driver.findElement(By.id("plusAmount")).clear();
		driver.findElement(By.id("plusAmount")).sendKeys("1300");
		driver.findElement(By.id("plusPeriod")).clear();
		driver.findElement(By.id("plusPeriod")).sendKeys("16");
		try {
			assertEquals("Максималният срок за изплащане на суми до 1300 лв. е 15 месеца.",
					driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// 1 300 - 1 500 лв. - зплащане от 5 до 16 месеца
		// - Min
		driver.findElement(By.id("plusAmount")).clear();
		driver.findElement(By.id("plusAmount")).sendKeys("1600");
		driver.findElement(By.id("plusPeriod")).clear();
		driver.findElement(By.id("plusPeriod")).sendKeys("4");
		try {
			assertEquals("Минималният срок за изплащане на суми от 1300 лв. до 2000 лв. е 5 месеца.",
					driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// - Max
		driver.findElement(By.id("plusAmount")).clear();
		driver.findElement(By.id("plusAmount")).sendKeys("1500");
		driver.findElement(By.id("plusPeriod")).clear();
		driver.findElement(By.id("plusPeriod")).sendKeys("17");
		try {
			assertEquals("Максималният срок за изплащане на суми до 1500 лв. е 16 месеца.",
					driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// 1 500 - 2 000 лв. - изплащане от 5 до 18 месеца
		// - Max
		driver.findElement(By.id("plusAmount")).clear();
		driver.findElement(By.id("plusAmount")).sendKeys("1450");
		driver.findElement(By.id("plusPeriod")).clear();
		driver.findElement(By.id("plusPeriod")).sendKeys("4");
		try {
			assertEquals("Минималният срок за изплащане на суми от 1300 лв. до 2000 лв. е 5 месеца.",
					driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// - Others
		driver.findElement(By.id("plusAmount")).clear();
		driver.findElement(By.id("plusAmount")).sendKeys("200");
		driver.findElement(By.id("plusPeriod")).clear();
		driver.findElement(By.id("plusPeriod")).sendKeys("14");
		try {
			assertEquals("Максималният срок за изплащане на суми до 1100 лв. е 13 месеца.",
					driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.id("plusAmount")).clear();
		driver.findElement(By.id("plusAmount")).sendKeys("1150");
		driver.findElement(By.id("plusPeriod")).clear();
		driver.findElement(By.id("plusPeriod")).sendKeys("16");
		try {
			assertEquals("Максималният срок за изплащане на суми до 1300 лв. е 15 месеца.",
					driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.id("plusAmount")).clear();
		driver.findElement(By.id("plusAmount")).sendKeys("1350");
		driver.findElement(By.id("plusPeriod")).clear();
		driver.findElement(By.id("plusPeriod")).sendKeys("17");
		try {
			assertEquals("Максималният срок за изплащане на суми до 1500 лв. е 16 месеца.",
					driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

	}

	private static void assertEquals(String string, String text) {
		// TODO Auto-generated method stub
		
	}
}