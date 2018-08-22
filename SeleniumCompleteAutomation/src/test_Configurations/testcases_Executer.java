package test_Configurations;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import test_Cases.*;

public class testcases_Executer 
{

	static int ExecutionCloumnNumber=1, ExecutionRowNumber=1;
	static int TestNameCloumnNumber=2, TestNameRowNumber=1;
	
	static getTestCaseExecutionCategoryFromTestDataSheet readDataFromTestDataSheetObject = new getTestCaseExecutionCategoryFromTestDataSheet();
	static getTestCaseNameFromTestDataSheet getTestCaseNameFromTestDataSheetObject = new getTestCaseNameFromTestDataSheet();
	
	public static void main(String[] args) 
	{
		
		Logger logger = Logger.getLogger("testcases_Executer");	
		PropertyConfigurator.configure("./src/test_Logs/log4j.properties");
		
		while (readDataFromTestDataSheetObject.getTestCaseExecutionCategoryFromTestDataSheet(ExecutionCloumnNumber,ExecutionRowNumber)!="")
		{	
			logger.info("Execution Category is not BLANK/NULL. So, entered into WHILE loop....");
			
			if (readDataFromTestDataSheetObject.getTestCaseExecutionCategoryFromTestDataSheet(ExecutionCloumnNumber,ExecutionRowNumber)=="N")
			{
				logger.info("Execution Category is 'N'. So proceeding to increase the ExecutionRowNumber value by 1.");
				ExecutionRowNumber = ExecutionRowNumber++;
				logger.info("Increased ExecutionRowNumber value by 1. So current value set to ExecutionRowNumber="+ExecutionRowNumber);
			}
			
			else if (readDataFromTestDataSheetObject.getTestCaseExecutionCategoryFromTestDataSheet(ExecutionCloumnNumber,ExecutionRowNumber)=="Y")
			{
				logger.info("Increased ExecutionRowNumber="+ExecutionRowNumber);
				
				while (readDataFromTestDataSheetObject.getTestCaseExecutionCategoryFromTestDataSheet(ExecutionCloumnNumber,ExecutionRowNumber)=="Y")
				{
					
					String TestCaseName = getTestCaseNameFromTestDataSheetObject.getTestCaseNameFromTestDataSheet(TestNameCloumnNumber,TestNameRowNumber);
					
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
							System.out.println("Test Case : "+TestCaseName+"class not found...!!!");
							break;
					}
					
					ExecutionRowNumber = ExecutionRowNumber++;
					
				}
			}
		}	
			
		System.out.println("No Test Case to Execute...!!!");	
		
			
	} 

}