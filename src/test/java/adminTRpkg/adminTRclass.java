
package adminTRpkg;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		features="src/test/resources/featureFiles/multiReward.feature",
		glue= {"stepDefinitionPkg"}, 
		//tags="@reward", 
		plugin= {"pretty", "html:target/ html-reports/ reports.html"}

		)

public class adminTRclass{ 

	// public class adminTRclass extends AbstractTestNGCucumberTests { 
}
