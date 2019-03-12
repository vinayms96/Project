package POM.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wishlist {
	
	
	@FindBy(linkText="Create a List")
	private WebElement crelist;
	
	@FindBy(id="WLNEW_list_name")
	private WebElement ent;
	
	@FindBy(xpath="//*[@id=\"a-popover-content-2\"]/form/div[2]/span[3]/span/span/input")
	private WebElement sub;
	
	@FindBy(id="WLNEW_privacy_private-announce")
	private WebElement pub;
	
	@FindBy(id="WLHUC_viewlist")
	private WebElement viewwish;
	
	@FindBy(id="//*[@id=\"a-autoid-6-announce\"]/span")
	private WebElement shift;
	
	@FindBy(xpath="//*[@id=\"move_IDPX577KNVHXE_0\"]/span")
	private WebElement mtmy;
	
	@FindBy(xpath="//*[@id=\"wl-list-link-32UB18TYZ0L28\"]/div/div")
	private WebElement seemy;
	
	public Wishlist(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void create() {
		crelist.click();
	}
	public void name(String newname) {
		ent.clear();
		ent.sendKeys(newname);
	}
	public void submit() {
		sub.submit();
	}
	public void clipublic() {
		pub.click();
	}
	public void gowish() {
		viewwish.click();
	}
	public void moveto() {
		shift.click();
	}
	public void addmylist() {
		mtmy.click();
	}
	public void seemylist() {
		seemy.click();
	}
}
