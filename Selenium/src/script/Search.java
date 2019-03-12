package script;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import POM.Amazon.HomePg;
import POM.Amazon.LoginPg;
import POM.Amazon.ProductPg;
import generic.Openbrowser;

public class Search extends Openbrowser {
	
	@Test(priority=1)
	public void look() {
		
		//Login
		LoginPg g = new LoginPg(driver);
		g.clitolog();
		g.username("vinay.srikrishna@gmail.com");
		driver.findElement(By.id("continue")).click();
		g.password("acernsrC");
		g.submit();
		
		//Search for Product
		HomePg hp = new HomePg(driver);
		ProductPg pp = new ProductPg(driver);
		hp.search("scullcandy earphones");
		hp.searchbutton();
		pp.item();
		ArrayList<String> al = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(al.get(1));
		driver.close();
		driver.switchTo().window(al.get(0));
		
		//Signout
		driver.findElement(By.xpath("//span[.='Amazon']")).click();
		Actions a= new Actions(driver);
		WebElement ele = driver.findElement(By.id("nav-link-yourAccount"));
		a.moveToElement(ele).perform();
		hp.signout();
	}
}
