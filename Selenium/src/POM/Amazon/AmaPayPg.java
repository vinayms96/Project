package POM.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmaPayPg {

	@FindBy(xpath="//*[@id=\"a-page\"]/div[2]/div/div[3]/div[3]/a/div/div/div/div[2]/h2")
	private WebElement amapay;
	
	public AmaPayPg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void amazonpay() {
		amapay.click();
	}

}
