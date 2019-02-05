package cod;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import generic.Auto_constant;
import generic.Excel;

public class getUrl implements Auto_constant{
	static WebDriver driver;
	static XSSFWorkbook wb = new XSSFWorkbook();
	static XSSFSheet sheet = wb.createSheet("Sheet1");

	public static void main(String[] args) throws Exception {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY,options);
		System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
		driver = new ChromeDriver(options);

		hpUrl();
		driver.close();
	}
	
	public static void hpUrl() throws Exception{
		int row=0,col=0;
		
		driver.get("https://www.bushwacker.com/");
		
		List<WebElement> urls = driver.findElements(By.tagName("a"));
		for (WebElement ele : urls) {
			String val = ele.getAttribute("href");
			
//			Robot r = new Robot();
//			r.keyPress(KeyEvent.VK_CONTROL);
//			r.keyPress(KeyEvent.VK_T);
//			r.keyRelease(KeyEvent.VK_T);
//			r.keyRelease(KeyEvent.VK_CONTROL);
			
//			driver.get(val);
			String title = ele.getText();
			Excel.setData(wb, sheet, row, col+1, title, excelSave);
//			driver.close();
			
			if(val == null) {
//				Excel.setData(wb, sheet, row, col, "null", excelSave);
				continue;
			}else {
				if (val.contains("https://www.bushwacker.com/")) {
				System.out.println(val);
				save(row,col,val);
				row++;
				}
			}	
		}
		checkAll.get(driver,wb);
	}
	
	public static void save(int row,int col,String val) throws Exception {
		Excel.setData(wb, sheet, row, col, val, excelSave);
	}

}
