package datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelData {
	
	@Test
	public void TC_ExcelData() throws IOException {
		
		//D:\XTGlobal\SeleniumTraining\src\test\java\datadriven\TestData.xlsx
		
		
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\datadriven\\TestData.xlsx";
		FileInputStream fis=new FileInputStream(path);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		//To get the number of sheets
		int sheetsCount=workbook.getNumberOfSheets();
		System.out.println("Number of Sheets: "+sheetsCount);
		
		//To get the row count
		
		int index=workbook.getSheetIndex("Sheet1");
		XSSFSheet sheet=workbook.getSheetAt(index);
		int rowCount=sheet.getLastRowNum();
		System.out.println("Total rows: "+(rowCount+1));
		
		//To get the row number of specific test case TC_Login_03
		
		int rowNum=0;
		for(int i=0;i<rowCount;i++) {
			XSSFCell cell=sheet.getRow(i).getCell(0);
			if(cell.getStringCellValue().equals("TC_Login_03")) {
				rowNum=i;
				break;
			}
		}
		
		System.out.println("Row number of TC_Login_03: "+(rowNum+1));
		
		//To get column count
		XSSFRow row=sheet.getRow(0);
		short colCount=row.getLastCellNum();
		System.out.println("Column count: "+colCount);
		
		//To get the column number of specific column name
		int colNum=0;
		for(int i=0;i<colCount;i++) {
			if(row.getCell(i).getStringCellValue().equals("UserName")) {
				colNum=i;
				break;
			}
		}
		
		System.out.println("Column number of UserName: "+(colNum+1));
		
		//To get the UserName column value for TC_Login_03
		row=sheet.getRow(rowNum);
		String username=row.getCell(colNum).getStringCellValue();
		System.out.println("UserName value for TC_Login_03: "+username);
		
		
		workbook.close();
		
		
	}
	
	
	
	

}


/*
.xls

HSSFWorkbook
HSSFSheet
HSSFRow
HSSFCell


.xlsx

XSSFWorkbook
XSSFSheet
XSSFRow
XSSFCell

*/