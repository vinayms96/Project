package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Openbrowser implements Auto_constant {
	public WebDriver driver;
	@BeforeMethod
	public void drive() {
		System.setProperty(key, value);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}
	
	@AfterMethod
	public void closeapp() {
		driver.close();
	}
	
}
