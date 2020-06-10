package com.FrontendAutomation.runner;

import net.serenitybdd.jbehave.SerenityStories;

public class interviewRunnerClass extends SerenityStories{
	
	public interviewRunnerClass()
	{
		findStoriesCalled("test*.story");
	}

}
