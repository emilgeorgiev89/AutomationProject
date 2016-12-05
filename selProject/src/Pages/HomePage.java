package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(id = "email_plus")
	private WebElement emailPlusElement;
	
	@FindBy(id = "phone_plus")
	private WebElement phonePlusElement;
	
	@FindBy(className = "first-step")
	private WebElement submitButton;
	
}