package script;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import POM.Amazon.HomePg;
import POM.Amazon.LoginPg;
import POM.Amazon.ProductPg;
import POM.Amazon.Wishlist;
import generic.Openbrowser;

public class AddtoWish extends Openbrowser {

	@Test(priority=7)
	public void add() throws InterruptedException {

		// Login
		LoginPg g = new LoginPg(driver);
		g.clitolog();
		g.username("vinay.srikrishna@gmail.com");
		driver.findElement(By.id("continue")).click();
		g.password("acernsrC");
		g.submit();
		
		//search
		HomePg hp = new HomePg(driver);
		ProductPg pp = new ProductPg(driver);
		hp.search("32gb pendrives");
		hp.searchbutton();
		pp.pendrive();
		ArrayList<String> al = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(al.get(1));
		
		//add to wishlist
		pp.addwish();
		Thread.sleep(2000);
		Wishlist wl= new Wishlist(driver);
		wl.gowish();
		//wl.moveto();
		//wl.addmylist();
		wl.seemylist();
		
		driver.close();
		driver.switchTo().window(al.get(0));
		
		//Logout
		driver.findElement(By.xpath("//span[.='Amazon']")).click();
		Actions a=new Actions(driver);
		WebElement ele = driver.findElement(By.id("nav-link-yourAccount"));
		a.moveToElement(ele).perform();
		hp.signout();
	}
}
