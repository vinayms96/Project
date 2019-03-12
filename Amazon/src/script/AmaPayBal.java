package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import POM.Amazon.AccountPg;
import POM.Amazon.AmaPayPg;
import POM.Amazon.HomePg;
import POM.Amazon.LoginPg;
import generic.Openbrowser;

public class AmaPayBal extends Openbrowser {
	
		@Test(priority=4)
		public void paybal() throws InterruptedException {
		
		//Login
		LoginPg g = new LoginPg(driver);
		g.clitolog();
		g.username("vinay.srikrishna@gmail.com");
		driver.findElement(By.id("continue")).click();
		g.password("acernsrC");
		g.submit();
		
		//AmazonPayBalance
		Actions a=new Actions(driver);
		WebElement el = driver.findElement(By.id("nav-link-yourAccount"));
		a.moveToElement(el).perform();
		AccountPg ap=new AccountPg(driver);
		ap.uraccount();
		AmaPayPg apb = new AmaPayPg(driver);
		apb.amazonpay();
		driver.findElement(By.xpath("//span[.='Amazon']")).click();
		
		//Signout
		HomePg hp= new HomePg(driver);
		WebElement ele = driver.findElement(By.id("nav-link-yourAccount"));
		a.moveToElement(ele).perform();
		hp.signout();
	}

}
