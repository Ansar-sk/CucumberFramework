package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\features",
                 glue="Steps",
                 tags="@wip123",
                 stepNotifications=true,
                 
                		 plugin = {
                			        "pretty", // This prints detailed information to the console
                			        "html:target/cucumber-reports/html-report.html", // Generates an HTML report
                			        "json:target/cucumber-reports/cucumber.json", // Generates a JSON report
                			        "junit:target/cucumber-reports/cucumber.xml" // Generates a JUnit report
                			    },
                			    monochrome = true // Optional: Makes the console output more readable
                 )

public class Regrunner {

}
