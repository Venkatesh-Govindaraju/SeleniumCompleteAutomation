package page_Factory;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.read.biff.CellValue;

public class readContentsFromObjectRepository 
{

	static int SerialNumber;
	static String ObjectRepositoryName;
	static String WebsiteName;
	static String WebPageName;
	static String ComponentName;
	static String LocatorType;
	static String LocatorValue;
	
	public static String ValueFromExcelSheet;
	
	static File ObjectRepositoryExcelSheetPath = new File("H:\\Software_Testing\\Test_Automation\\Selenium\\SeleniumTestAutomation\\Git\\Repository\\SeleniumCompleteAutomation\\src\\page_Factory\\Object_Repository.xls");


	
	//getObjectRepositoryLocatorType is the class to get Object Repository LocatorType from Object_Repository Excel sheet 	
	public static void getObjectRepositoryLocatorType(String ObjectRepositoryNameFromTestCase)
	{
		Logger logger = Logger.getLogger("getObjectRepositoryLocatorType");	
		PropertyConfigurator.configure("./src/test_Logs/log4j.properties");		
		try 
		{
			logger.info("Entered into \"getObjectRepositoryLocatorType\" class to get LocatorType for ObjectRepositoryNameFromTestCase = "+ObjectRepositoryNameFromTestCase);
			Workbook ExcelWorkBook = Workbook.getWorkbook(ObjectRepositoryExcelSheetPath);
			logger.info("Opened ExcelWorkBook...");
			Sheet ExcelSheet = ExcelWorkBook.getSheet("Object_Repository");
			logger.info("Opened ExcelSheet...");
			
			Cell ObjectRepositoryNameLocation = ExcelSheet.findCell(ObjectRepositoryNameFromTestCase);
			logger.info("Helooooooooooo: RowNumber="+ObjectRepositoryNameLocation.getRow());
			
//	        Cell ExcelSheetCell = ExcelSheet.getCell(5,RowNumber);
//	        logger.info("Copying content from Cell (5, "+RowNumber+") [Foramt : Column, Row]...");
//	        ValueFromExcelSheet = ExcelSheetCell.getContents();

//	        logger.info("Cell Content = "+ValueFromExcelSheet);         
//	        logger.info("Exit from \"getObjectRepositoryLocatorType\" class with LocatorType = "+ValueFromExcelSheet+" for ObjectRepositoryNameFromTestCase = \"+ObjectRepositoryNameFromTestCase");
		}
		catch (BiffException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
//		return ValueFromExcelSheet;
	}
	
	
	//getObjectRepositoryLocatorValue is the class to get Object Repository LocatorValue from Object_Repository Excel sheet
	public static void getObjectRepositoryLocatorValue(String ObjectRepositoryNameFromTestCase)
	{

	}

}
