package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class ExWait {
	
	public void wait(WebDriver driver,WebElement element) {
	try {
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOf(element));
		Reporter.log("Element Found",true);
	}catch(Exception e) {
		Reporter.log("Element not Found",true);
		Assert.fail();
	}
	}
	

}
