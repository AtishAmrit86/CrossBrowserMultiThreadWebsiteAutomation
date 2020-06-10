package PracticeFramework.FrontendAutomation.runner;
import PracticeFramework.FrontendAutomation.CommonUtilities.commonUtilities;
import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.util.EnvironmentVariables;

public class runnerClass extends SerenityStories {
	
	public runnerClass() {
		
		findStoriesCalled("*.story");
		
		EnvironmentVariables envVar = getEnvironmentVariables();
		commonUtilities.setEnvironment(envVar);
		
		String platform = commonUtilities.getEnvironmetVariable("PLATFORM");
		
		if (platform.equalsIgnoreCase("mobile")) {
			commonUtilities.startAppiumServer();
		}
	
					
}
	}
