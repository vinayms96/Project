package POM.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPg {
	
	@FindBy(id="ap_email")
	private WebElement ustb;
	
	@FindBy(id="ap_password")
	private WebElement pwdtb;
	
	@FindBy(id="signInSubmit")
	private WebElement submitbtn;
	
	@FindBy(id="nav-link-yourAccount")
	private WebElement logcli;
	
	public LoginPg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void username(String un) {
		ustb.sendKeys(un);
	}
	public void password(String pwd) {
		pwdtb.sendKeys(pwd);
	}
	public void submit() {
		submitbtn.click();
	}
	public void clitolog() {
		logcli.click();
	}
}
