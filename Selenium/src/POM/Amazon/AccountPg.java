package POM.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPg {
	
	@FindBy(xpath="//*[@id=\"nav-flyout-yourAccount\"]/div[2]/a[1]/span")
	private WebElement acc;
	
	public AccountPg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void uraccount() {
		acc.click();
	}

}
