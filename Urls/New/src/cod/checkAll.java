package cod;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import generic.Auto_constant;
import generic.Excel;

public class checkAll implements Auto_constant {
	// public static WebDriver driver;
	static XSSFSheet sheet;

	public static void get(WebDriver driver, XSSFWorkbook wb) throws Exception {
		int num = 2, col = 0, sl = 1, record = 0, pg = 1;

		XSSFSheet page = wb.createSheet("Sheet" + num);
		
		System.out.println();
		System.out.println("Page " + pg);
		int emp = Excel.getNum(excelSave, "Sheet1");
		for (int row = 0; row < emp; row++) {
			String url = Excel.getData(excelSave, "Sheet1", row, col);
			if (url != "null") {
				
				driver.get(url);
				String title = driver.getTitle();
				System.out.println(title);
				Excel.setData(wb, page, record, col, title, excelSave);
				record+=2;
				
				List<WebElement> tags = driver.findElements(By.tagName("a"));
				for (WebElement ele : tags) {
					String next = ele.getAttribute("href");
					if (next != null) {
						if (next.startsWith("https://www.bushwacker.com/")) {
							System.out.println(sl + " : " + next);
							sl++;
							Excel.setData(wb, page, record, col, next, excelSave);
							record++;
						} else {
//							Excel.setData(wb, page, record, col, "null", excelSave);
							continue;
						}
					}
				}
				num++;
				page = wb.createSheet("Sheet" + num);
				System.out.println();
				pg++;
				System.out.println("Page " + pg);
				record = 0;
				sl = 1;
			}
		}
//		candp.copy(wb, page,driver);
	}
}
