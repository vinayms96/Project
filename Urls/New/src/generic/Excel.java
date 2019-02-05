package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class Excel implements Auto_constant {
	
	//For String Value
	public static void setData (XSSFWorkbook wb, XSSFSheet sheet,int row,int cell,String val, String path) {
		
		XSSFRow myRow = sheet.getRow(row);
		if(myRow == null) {
			myRow=sheet.createRow(row);
		}
		XSSFCell myCell = myRow.createCell(cell);	
		myCell.setCellValue(val);
		
		try {
	        FileOutputStream out = new FileOutputStream(path);
	        wb.write(out);
	        out.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	//For Integer Value
	public static void setIntData (XSSFWorkbook wb, XSSFSheet sheet,int row,int cell,int val, String path) {
		
		XSSFRow myRow = sheet.getRow(row);
		if(myRow == null) {
			myRow=sheet.createRow(row);
		}
		XSSFCell myCell = myRow.createCell(cell);	
		myCell.setCellValue(val);
		
		try {
	        FileOutputStream out = new FileOutputStream(path);
	        wb.write(out);
	        out.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	@SuppressWarnings("finally")
	public static String getData(String path,String Sheet,int row,int cell) throws Exception {
		String s="";
		try {
			FileInputStream fi = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fi);
			s = wb.getSheet(Sheet).getRow(row).getCell(cell).getStringCellValue();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			return s;
		}
//		return s;
	}
	
	public static int getNum(String path,String sheet) throws Exception {
		int num=0;
		try {
			FileInputStream fi = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fi);
			num=wb.getSheet(sheet).getLastRowNum();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
		
	}
	
	@SuppressWarnings("resource")
	public static int getSheet(String path) throws IOException {
		FileInputStream fi = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		int sht = wb.getNumberOfSheets();
		return sht;
	}
//	
//	//For Integer value
//	public static void setData (Workbook wb,String path,String Sheet, int row, int cell, int val) throws EncryptedDocumentException, InvalidFormatException, IOException {
//			wb.getSheet(Sheet).getRow(row).createCell(cell).setCellValue(val);	
//	}
//	
//	//For String value
//	public static void setData (XSSFWorkbook wb,String sheet, int row, int cell, String val) throws EncryptedDocumentException, InvalidFormatException, IOException {
//		wb.getRow(row).createCell(cell).setCellValue(val);
//	}
//	
//	public static void writeData (Workbook wb,String Save) throws EncryptedDocumentException, InvalidFormatException, IOException {
//		try {
//			
//			FileOutputStream fo = new FileOutputStream(new File(Save));
//			wb.write(fo);
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

}
