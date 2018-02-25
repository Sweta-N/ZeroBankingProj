package zeroBankProj.util;

import zeroBankProj.Core.BaseClass;

public class Testutil extends BaseClass
{
/*public static boolean isExecutable(String tcid) {
		
		for(int rownum=1; rownum<=excel.getRowCount("Test_Suite"); rownum++) {
			if(excel.getCellData("Test_Suite", "tcid", rownum).equals(tcid)){
				if(excel.getCellData("Test_Suite", "runmode", rownum).equals("Y")){
					return true;
				}
				else{
					return false;
				}
			}	
					
		}
		return false;
}*/

//reading data from the excel file
	public static Object[][] getData(String sheetName){
		int rows=excel.getRowCount(sheetName);
		//System.out.println(rows + " no. of rows");
		int cols=excel.getColumnCount(sheetName);
		Object data[][]=new Object [rows-1][cols];
		for(int rowNum=2; rowNum<=rows; rowNum++) {

			for(int colNum=0; colNum<cols; colNum++) {
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}

}
