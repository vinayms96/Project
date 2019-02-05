package cod;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import generic.Auto_constant;
import generic.Excel;

public class checkow implements Auto_constant{
	static int pg, col = 0, passrow;
	
	public static void check(String url, XSSFWorkbook wb, XSSFSheet sheet, int pg) throws Exception {
		int lr = Excel.getNum(all, "Sheet1");
		// if (lr != 0) {
		for (int r = 0; r < lr; r++) {
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
		// }
	}
	
}
