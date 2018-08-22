package test_Configurations;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import test_Cases.*;

public class testcases_Executer 
{

	static String TestExecutionCategory;
	static String TestCaseName;
	
	static int ExecutionCloumnNumber=1, ExecutionRowNumber=1;
	static int TestNameCloumnNumber=2, TestNameRowNumber=1;
	
	static readContentsFromTestDataSheet readContentsFromTestDataSheetObject = new readContentsFromTestDataSheet();
	
	public static void main(String[] args) 
	{
		
		Logger logger = Logger.getLogger("testcases_Executer");	
		PropertyConfigurator.configure("./src/test_Logs/log4j.properties");
		
		logger.info("********************************** TEST EXECUTION STARTED **********************************");
		
		try
		{
			TestExecutionCategory = readContentsFromTestDataSheetObject.getTestCaseExecutionCategoryFromTestDataSheet(ExecutionCloumnNumber,ExecutionRowNumber);
		}
		catch (ArrayIndexOutOfBoundsException e) 
		{
			logger.info("Exit from \"getTestCaseExecutionCategoryFromTestDataSheet\" class with Execution coulmn value = BLANK / NULL");
			logger.info("Cell Content = BLANK / NULL");
			logger.info("No Test Case to Execute...!!!");
			logger.info("********************************* TEST EXECUTION COMPLETED *********************************");	
			return;
		}
		
		TestCaseName = readContentsFromTestDataSheetObject.getTestCaseNameFromTestDataSheet(TestNameCloumnNumber,TestNameRowNumber);
			
		while (TestExecutionCategory != "Y" && TestExecutionCategory != "")
		{
			logger.info("Execution Category is 'N'. So proceeding to increase the ExecutionRowNumber and TestNameRowNumber value by 1.");
			ExecutionRowNumber = ExecutionRowNumber + 1;
			TestNameRowNumber = TestNameRowNumber + 1;
			logger.info("Now, ExecutionRowNumber="+ExecutionRowNumber+" and TestNameRowNumber="+TestNameRowNumber);
			TestExecutionCategory = readContentsFromTestDataSheetObject.getTestCaseExecutionCategoryFromTestDataSheet(ExecutionCloumnNumber,ExecutionRowNumber);
			TestCaseName = readContentsFromTestDataSheetObject.getTestCaseNameFromTestDataSheet(TestNameCloumnNumber,TestNameRowNumber);
			logger.info("Now, TestExecutionCategory="+TestExecutionCategory+" and TestCaseName="+TestCaseName);
			
			while (TestExecutionCategory != "N" && TestExecutionCategory != "")
			{
				logger.info("Execution Category is 'Y'. So proceeding to execute the test case...!!!");
					
				switch(TestCaseName)
				{
				
					case "TC_0001_Search_Functionality":
						TC_0001_Search_Functionality TC_0001_Search_FunctionalityObject = new TC_0001_Search_Functionality();
						TC_0001_Search_FunctionalityObject.display();
						break;
							
					case "TC_0002_Verify_edit_this_page_Link_Availability":
						TC_0002_Verify_edit_this_page_Link_Availability TC_0002_Verify_edit_this_page_Link_AvailabilityObject = new TC_0002_Verify_edit_this_page_Link_Availability();
						TC_0002_Verify_edit_this_page_Link_AvailabilityObject.main(args);
						break;								
							
					default:
						logger.info("Test Case : "+TestCaseName+"class not found...!!!");
						break;
				}
						
				ExecutionRowNumber = ExecutionRowNumber + 1;
				TestNameRowNumber = TestNameRowNumber + 1;
				logger.info("Now, ExecutionRowNumber="+ExecutionRowNumber+" and TestNameRowNumber="+TestNameRowNumber);
				try
				{
					TestExecutionCategory = readContentsFromTestDataSheetObject.getTestCaseExecutionCategoryFromTestDataSheet(ExecutionCloumnNumber,ExecutionRowNumber);
				}
				catch (ArrayIndexOutOfBoundsException e) 
				{
					logger.info("Exit from \"getTestCaseExecutionCategoryFromTestDataSheet\" class with Execution coulmn value = BLANK / NULL");
					logger.info("Cell Content = BLANK / NULL");
					logger.info("No Test Case to Execute...!!!");
					logger.info("********************************* TEST EXECUTION COMPLETED *********************************");
					break;
				}
				TestCaseName = readContentsFromTestDataSheetObject.getTestCaseNameFromTestDataSheet(TestNameCloumnNumber,TestNameRowNumber);
				logger.info("Now, TestExecutionCategory="+TestExecutionCategory+" and TestCaseName="+TestCaseName);
				
			}	break;
			
		}
						
	} 

}