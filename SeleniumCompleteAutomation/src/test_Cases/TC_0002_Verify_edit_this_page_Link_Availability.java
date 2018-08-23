package test_Cases;

import page_Factory.readContentsFromObjectRepository;

public class TC_0002_Verify_edit_this_page_Link_Availability {

	public static void main(String[] args) 
	{
		
		System.out.println("I am inside TC_0002_Verify_edit_this_page_Link_Availability.....!!!");
		
		readContentsFromObjectRepository readContentsFromObjectRepositoryObject = new readContentsFromObjectRepository();
		readContentsFromObjectRepositoryObject.getObjectRepositoryLocatorType("Two");	
		
	}

}
