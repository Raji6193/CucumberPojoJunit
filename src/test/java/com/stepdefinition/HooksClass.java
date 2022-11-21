package com.stepdefinition;

import com.base.LibGlobal;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass extends LibGlobal {
	
	@Before
	public void beforeExection() {
		driver = launchBrowser();
	}
	
	@After
	public void afterExecution() {
		quitBrowser();
	}

}
