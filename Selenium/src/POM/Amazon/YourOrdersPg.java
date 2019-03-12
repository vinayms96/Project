package POM.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourOrdersPg {
	
	@FindBy(xpath="//*[@id='nav_prefetch_yourorders']")
	private WebElement order;
	
	public YourOrdersPg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void urorder() {
		order.click();
	}

}
