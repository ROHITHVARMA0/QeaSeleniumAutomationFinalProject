package projectCombinedTestRunnersPackage;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    // Path to the combined feature file(s)
    features = "src/test/java/projectCombinedFeaturesPackage", 
    
    // Path to the package containing ALL your step definition classes
    glue = "projectCombinedStepDefinitions", 
    
    // Reporting plugins
    plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"},
    
    // Makes console output more readable
    monochrome = true, 
    
    // Executes all scenarios in the feature files
    tags = "" 
)
public class ProjectTestRunner {
    // This class remains empty.
}