package POM.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPg {
	
	@FindBy(xpath="//a[@title='Skullcandy JIB S2DUDZ-003 In-Ear Headphone (Black)']")
	private WebElement item1;
	
	@FindBy(xpath="//*[@id=\"result_3\"]/div/div[3]/div[1]/a/h2")
	private WebElement pen;
	
	@FindBy(name="submit.add-to-registry.wishlist")
	private WebElement adwish;
	
	@FindBy(xpath="//input[@value='Add to Cart']")
	private WebElement adcart;
	
	@FindBy(id="a-autoid-0-announce")
	private WebElement adcart1;
	
	public ProductPg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void item() {
		item1.click();
	}
	public void addcart() {
		adcart.click();
	}
	public void addcart1() {
		adcart1.click();
	}
	public void pendrive() {
		pen.click();
	}
	public void addwish() {
		adwish.click();
	}
}
