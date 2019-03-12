package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	
	public static String actitime(String file,String sheet,int row,int cell) throws EncryptedDocumentException, InvalidFormatException, IOException {
		String s="";
		try {
			FileInputStream fi = new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(fi);
			s=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
}
