package cod;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import generic.Auto_constant;
import generic.Excel;
import io.restassured.RestAssured;

public class candp extends getUrl implements Auto_constant {
	static int pg, col = 0, passrow;
	// static XSSFWorkbook wb;
	// static XSSFSheet sheet;
	static WebDriver driver;

	// public static void copy(XSSFWorkbook wb, XSSFSheet sheet,WebDriver driver)
	// throws Exception {
	@Test
	public static void copy() throws Exception {

		// Open Browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
		driver = new ChromeDriver(options);

		// Get urls from Data folder
		int sht = Excel.getSheet(excelSave);

		int shtone = Excel.getNum(excelSave, "Sheet1");

		for (passrow = 0; passrow < shtone; passrow++) {
			String oneurl = Excel.getData(excelSave, "Sheet1", passrow, col);
			if (oneurl != "null") {
				candp.status(oneurl, wb, sheet, passrow, shtone);
				Excel.setData(wb, sheet, passrow, col, oneurl, all);
			}
		}

		for (pg = 2; pg <= sht; pg++) {
			int last = Excel.getNum(excelSave, "Sheet" + pg);
			for (passrow = 2; passrow < last; passrow++) {
				String url = Excel.getData(excelSave, "Sheet" + pg, passrow, col);
				if (url != "null") {
					candp.check(url, wb, sheet, pg);
				}
			}
		}
	}

	// Compare url of Data with Url of Combined
	public static void check(String url, XSSFWorkbook wb, XSSFSheet sheet, int pg) throws Exception {
		int lr = Excel.getNum(all, "Sheet1");
//		if (lr != 0) {
			for (int r = 0; r < lr; r++) {
//				int row = r;
				String checkurl = Excel.getData(all, "Sheet1", r, col);
				if (url != checkurl) {
					continue;
				}
				if (r == lr) {
					int sl = 1;
					System.out.println(sl + ":" + url);
					Excel.setData(wb, sheet, lr + 1, col, url, all);
					candp.status(url, wb, sheet, r, lr);
					sl++;
				}
			}
//		}
	}

	// Check the Url status before saving url
	public static void status(String url, XSSFWorkbook wb, XSSFSheet sheet, int r, int lr) {
		String stat1 = "(OK)", stat2 = "(Redirection)", stat3 = "(Page not Found)", stat4 = "(Server Failed)";
		driver.get(url);
		int code = RestAssured.get(url).getStatusCode();

		if (code > 199 && code < 300) {
			System.out.println(r + ": " + url + " Response: " + code + stat1);
			Excel.setIntData(wb, sheet, lr + 1, col + 1, code, all);
			Excel.setData(wb, sheet, lr + 1, col + 2, stat1, all);
		} else if (code > 299 && code < 400) {
			System.out.println(r + ": " + url + " Response: " + code + stat2);
			Excel.setIntData(wb, sheet, lr + 1, col + 1, code, all);
			Excel.setData(wb, sheet, lr + 1, col + 2, stat2, all);
		} else if (code > 399 && code < 500) {
			System.out.println(r + ": " + url + " Response: " + code + stat3);
			Excel.setIntData(wb, sheet, lr + 1, col + 1, code, all);
			Excel.setData(wb, sheet, lr + 1, col + 2, stat3, all);
		} else {
			System.out.println(r + ": " + url + " Response: " + code + stat4);
			Excel.setIntData(wb, sheet, lr + 1, col + 1, code, all);
			Excel.setData(wb, sheet, lr + 1, col + 2, stat4, all);
		}

		// driver.close();
	}

}
