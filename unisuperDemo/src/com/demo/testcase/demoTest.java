package com.demo.testcase;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.demo.resources.BaseTest;

import com.demo.resources.Constants;

public class demoTest extends BaseTest {

	@BeforeSuite
	public void setupBrowser() {
	
		initConfigurations();
		initDriver();
		openBrowser();
	}


	@Test()
	// Below test is to click Angular JS link on home page and add a To-do item
	public void todomvcTest1() {
		elementClick(Constants.hrefAngular);
		elementFeed(Constants.newToDo, "abcd");
		keyboardEnter(Constants.newToDo);
	}
	
	@Test()
	//Below test is to edit the content of an existing To-do item
	public void todomvcTest2() {
		//elementDbClick(Constants.newToDoEdit);
		//elementClear(Constants.newToDoEditInput);
		elementFeed(Constants.newToDoEdit, "xyz123");
		keyboardEnter(Constants.newToDoEdit);
	}
	
	@Test()
	//Below test is to mark a To-do item as completed
	public void todomvcTest3() {
		elementClick(Constants.toDoCompleted);
	}
	
	@Test()
	//Below test is to reactivate a completed To-do item
	public void todomvcTest4() {
		elementClick(Constants.toDoCompleted);
	}
	
	@Test()
	//Below test is for adding a second To-do item
	public void todomvcTest5() {
		elementFeed(Constants.newToDo, "abcd2");
		keyboardEnter(Constants.newToDo);
	}
	
	@Test()
	//Below test is for marking all To-do items as completed
	public void todomvcTest6() {
		elementClick(Constants.toDoCompletedAll);
	}
	
	@Test()
	//Below test is for filtering To-do items by completed state
	public void todomvcTest7() {
		elementFeed(Constants.newToDo, "abcd3");
		keyboardEnter(Constants.newToDo);
		elementClick(Constants.completedState);
	}
	
	@Test()
	//Below test is for removing a single To-do item from the list
	public void todomvcTest8() {
		elementFeed(Constants.newToDo, "abcd4");
		keyboardEnter(Constants.newToDo);
		elementClick(Constants.allTodoItems);
		//elementClick(Constants.toDoRemove);
	}
	
	@Test()
	//Below test for removing all completed To-do items completely from the list
	public void todomvcTest9() {
		elementClick(Constants.clearCompleted);
	}
	
	
	
	

	@AfterSuite
	public void closeBrowser() {
		quitDriver();
	}


}