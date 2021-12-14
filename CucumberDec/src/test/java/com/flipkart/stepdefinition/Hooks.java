package com.flipkart.stepdefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
public void beforeScenerio() {
	System.out.println("before");
}

@After
public void afterScenerio() {
	System.out.println("After");

}
}
