package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import POM.Amazon.HomePg;
import POM.Amazon.LoginPg;
import POM.Amazon.YourOrdersPg;
import generic.Openbrowser;

public class Orders extends Openbrowser {
		
	    @Test(priority=5)
	    public void order() throws InterruptedException {
		
		//Login
		LoginPg g = new LoginPg(driver);
		g.clitolog();
		g.username("vinay.srikrishna@gmail.com");
		driver.findElement(By.id("continue")).click();
		g.password("acernsrC");
		g.submit();
		
		//View Orders
		Actions a=new Actions(driver);
		YourOrdersPg op=new YourOrdersPg(driver);
		WebElement element = driver.findElement(By.id("nav-link-yourAccount"));
		a.moveToElement(element).perform();
		op.urorder();
		
		//Signout
		driver.findElement(By.xpath("//span[.='Amazon']")).click();
		HomePg hp= new HomePg(driver);
		WebElement ele = driver.findElement(By.id("nav-link-yourAccount"));
		a.moveToElement(ele).perform();
		hp.signout();
	}

}
