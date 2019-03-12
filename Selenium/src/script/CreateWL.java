package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import POM.Amazon.HomePg;
import POM.Amazon.LoginPg;
import POM.Amazon.Wishlist;
import generic.Openbrowser;

public class CreateWL extends Openbrowser {

	@Test(priority=6)
	public void Create() throws InterruptedException {
		
	//Login
	LoginPg g = new LoginPg(driver);
	g.clitolog();
	g.username("vinay.srikrishna@gmail.com");
	driver.findElement(By.id("continue")).click();
	g.password("acernsrC");
	g.submit();
	
	//Wishlist
	HomePg hp = new HomePg(driver);
	hp.lists();
	Wishlist wl = new Wishlist(driver);
	wl.create();
	Thread.sleep(2000);
	wl.name("My List");

	wl.submit();
	
	//Signout
	driver.findElement(By.xpath("//span[.='Amazon']")).click();
	Actions a=new Actions(driver);
	WebElement ele = driver.findElement(By.id("nav-link-yourAccount"));
	a.moveToElement(ele).perform();
	hp.signout();
	
	}
}
