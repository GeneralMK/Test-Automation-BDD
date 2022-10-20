package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true,
        features = {"C:\\Projects\\TangentBDD-main\\TangentBDD-main\\src\\test\\java\\features"},
        tags = {"@kwikspace_login"},
        glue = {"stepDefinations"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
)

public class runner {
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("src\\test\\java\\reports\\extent-config.xml"));
    }

}
