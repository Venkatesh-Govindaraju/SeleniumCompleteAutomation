package test_Configurations;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class getTestCaseExecutionCategoryFromTestDataSheet 
{
	public static String ValueFromExcelSheet;
	
	public static String getTestCaseExecutionCategoryFromTestDataSheet(int CloumnNumber, int RowNumber)
	{		
		
		Logger logger = Logger.getLogger("getTestCaseExecutionCategoryFromTestDataSheet");	
		PropertyConfigurator.configure("./src/test_Logs/log4j.properties");
		
		File TestDataExcelSheetPath = new File("H:\\Software_Testing\\Test_Automation\\Selenium\\SeleniumTestAutomation\\Git\\Repository\\SeleniumCompleteAutomation\\src\\test_Data\\test_data.xls");
		
		try 
		{
			Workbook ExcelWorkBook = Workbook.getWorkbook(TestDataExcelSheetPath);
			logger.info("Opened ExcelWorkBook...");
			Sheet ExcelSheet = ExcelWorkBook.getSheet("Test_Data");
			logger.info("Opened ExcelSheet...");
	        Cell ExcelSheetCell = ExcelSheet.getCell(CloumnNumber,RowNumber);
	        logger.info("Copying content from Cell ("+CloumnNumber+","+RowNumber+") [Foramt : Column, Row]...");
	        ValueFromExcelSheet = ExcelSheetCell.getContents();
	        logger.info("Cell Content = "+ValueFromExcelSheet);        
		}
		catch (BiffException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	
		return ValueFromExcelSheet;
	
	}

}
