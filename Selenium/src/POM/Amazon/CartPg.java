package POM.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPg {
	
	@FindBy(id="nav-cart")
	private WebElement cart;
	
	@FindBy(xpath="(//input[@value='Delete'])[1]")
	private WebElement Del;
	
	public CartPg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void cartpg() {
		cart.click();
	}
	public void delete() {
		Del.click();
	}
}
