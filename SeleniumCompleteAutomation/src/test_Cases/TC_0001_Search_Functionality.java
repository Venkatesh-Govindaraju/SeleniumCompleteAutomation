package test_Cases;

import page_Factory.readContentsFromObjectRepository;

public class TC_0001_Search_Functionality {

	public static void display()
	{
		System.out.println("I am inside TC_0001_Search_Functionality.....!!!");
		
		readContentsFromObjectRepository readContentsFromObjectRepositoryObject = new readContentsFromObjectRepository();
		readContentsFromObjectRepositoryObject.getObjectRepositoryLocatorType("Two");		
	}

}
