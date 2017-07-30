package com.demo.resources;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


	public class Constants {
		
		

	public static final String hrefAngular="//a[text()[contains(.,'AngularJS')]]";
	public static final String newToDo="//input[@id='new-todo']";
	public static final String toDoCompleted="//input[@ng-model='todo.completed']";
	public static final String toDoCompletedAll="//input[@id='toggle-all' and @ng-model='allChecked']";
	public static final String newToDoEdit="//label[@ng-dblclick='editTodo(todo)' and @class='ng-binding']";
	public static final String newToDoEditInput="//input[@class='edit ng-pristine ng-valid ng-touched']";
	public static final String allTodoItems="//a[@href='#/']";
	public static final String completedState="//a[@href='#/completed']";
	public static final String toDoRemove="//button[@ng-click='removeTodo(todo)']";
	public static final String clearCompleted="//button[@id='clear-completed']";
	
	
}
