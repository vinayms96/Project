package POM.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePg {
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchtb;
	
	@FindBy(xpath="(//input[@class='nav-input'])[1]")
	private WebElement schbtn;
	
	@FindBy(xpath="//*[@id=\"nav-item-signout-sa\"]")
	private WebElement sign;
	
	@FindBy(xpath="//*[@id=\"nav-link-wishlist\"]/span[2]/span")
	private WebElement list;
	
	public HomePg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void search(String name) {
		searchtb.sendKeys(name);
	}
	public void searchbutton() {
		schbtn.click();
	}
	public void signout() {
		sign.click();
	}
	public void lists() {
		list.click();
	}
}
