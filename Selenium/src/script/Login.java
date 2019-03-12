package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM.Amazon.HomePg;
import POM.Amazon.LoginPg;
import generic.Openbrowser;

public class Login extends Openbrowser {
	
		@Test(priority=0)
		public void log() throws InterruptedException {
		
		//Login
		LoginPg g = new LoginPg(driver);
		g.clitolog();
		g.username("vinay.srikrishna@gmail.com");
		driver.findElement(By.id("continue")).click();
		g.password("acernsrC");
		g.submit();
		
		//Checking Title
		String t = driver.getTitle();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(t,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		
		//Signout
		HomePg hp= new HomePg(driver);
		Actions a=new Actions(driver);
		WebElement ele = driver.findElement(By.id("nav-link-yourAccount"));
		a.moveToElement(ele).perform();
		hp.signout();
		sa.assertAll();
	}

}
