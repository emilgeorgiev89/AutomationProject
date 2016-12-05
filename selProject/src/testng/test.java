package testng;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class test {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://new.credissimo.bg/dovedi-priyatel";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSliderRestrictions() throws Exception {
    // 200 - 1 100 лв. - изплащане от 3 до 13 месеца
    driver.get(baseUrl + "${url}");
    driver.findElement(By.id("plusAmount")).clear();
    driver.findElement(By.id("plusAmount")).sendKeys("200");
    driver.findElement(By.id("plusPeriod")).clear();
    driver.findElement(By.id("plusPeriod")).sendKeys("14");
    try {
      assertEquals("Максималният срок за изплащане на суми до 1100 лв. е 13 месеца.", driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // 1 100 - 1 300 лв. - изплащане от 4 до 15 месеца
    //  - Min
    driver.findElement(By.id("plusAmount")).clear();
    driver.findElement(By.id("plusAmount")).sendKeys("1150");
    driver.findElement(By.id("plusPeriod")).clear();
    driver.findElement(By.id("plusPeriod")).sendKeys("3");
    try {
      assertEquals("Минималният срок за изплащане на суми от 1100 лв. до 1300 лв. е 4 месеца.", driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    //  - Max
    driver.findElement(By.id("plusAmount")).clear();
    driver.findElement(By.id("plusAmount")).sendKeys("1300");
    driver.findElement(By.id("plusPeriod")).clear();
    driver.findElement(By.id("plusPeriod")).sendKeys("16");
    try {
      assertEquals("Максималният срок за изплащане на суми до 1300 лв. е 15 месеца.", driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // 1 300 - 1 500 лв. - зплащане от 5 до 16 месеца
    //  - Min
    driver.findElement(By.id("plusAmount")).clear();
    driver.findElement(By.id("plusAmount")).sendKeys("1600");
    driver.findElement(By.id("plusPeriod")).clear();
    driver.findElement(By.id("plusPeriod")).sendKeys("4");
    try {
      assertEquals("Минималният срок за изплащане на суми от 1300 лв. до 2000 лв. е 5 месеца.", driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    //  - Max
    driver.findElement(By.id("plusAmount")).clear();
    driver.findElement(By.id("plusAmount")).sendKeys("1500");
    driver.findElement(By.id("plusPeriod")).clear();
    driver.findElement(By.id("plusPeriod")).sendKeys("17");
    try {
      assertEquals("Максималният срок за изплащане на суми до 1500 лв. е 16 месеца.", driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // 1 500 - 2 000 лв. - изплащане от 5 до 18 месеца
    //  - Max
    driver.findElement(By.id("plusAmount")).clear();
    driver.findElement(By.id("plusAmount")).sendKeys("1450");
    driver.findElement(By.id("plusPeriod")).clear();
    driver.findElement(By.id("plusPeriod")).sendKeys("4");
    try {
      assertEquals("Минималният срок за изплащане на суми от 1300 лв. до 2000 лв. е 5 месеца.", driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    //  - Others
    driver.findElement(By.id("plusAmount")).clear();
    driver.findElement(By.id("plusAmount")).sendKeys("200");
    driver.findElement(By.id("plusPeriod")).clear();
    driver.findElement(By.id("plusPeriod")).sendKeys("14");
    try {
      assertEquals("Максималният срок за изплащане на суми до 1100 лв. е 13 месеца.", driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("plusAmount")).clear();
    driver.findElement(By.id("plusAmount")).sendKeys("1150");
    driver.findElement(By.id("plusPeriod")).clear();
    driver.findElement(By.id("plusPeriod")).sendKeys("16");
    try {
      assertEquals("Максималният срок за изплащане на суми до 1300 лв. е 15 месеца.", driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("plusAmount")).clear();
    driver.findElement(By.id("plusAmount")).sendKeys("1350");
    driver.findElement(By.id("plusPeriod")).clear();
    driver.findElement(By.id("plusPeriod")).sendKeys("17");
    try {
      assertEquals("Максималният срок за изплащане на суми до 1500 лв. е 16 месеца.", driver.findElement(By.xpath("//*[@id='mousetooltip']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }



  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}