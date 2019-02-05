package cod;

import generic.Auto_constant;
import generic.Excel;

public class sample implements Auto_constant{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int last = Excel.getNum(excelSave, "Sheet1");
		System.out.println(last);
	}

}
