package utility;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.Capabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class driverFactory {

    public static WebDriver driver = null;

    public driverFactory() {

    }

    public static WebDriver getDriver() {

        String url = "https://app-app-kwikspace-dev.azurewebsites.net/login";
        System.setProperty("webdriver.chrome.driver", "common_driver" + File.separator + "chromedriver.exe");

        if (driver == null) {
            driver = new ChromeDriver();
        }

        driver.get(url); // open the metadata hub system URL
        driver.manage().window().maximize(); //maximise the browser
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //waiting for the page to load
        return driver;
    }

    public static WebDriver getFireFoxDriver() {

        String url = "https://app-app-kwikspace-dev.azurewebsites.net/login";
        System.setProperty("webdriver.gecko.driver", "common_driver" + File.separator + "geckodriver.exe");

        if (driver == null) {
            driver = new FirefoxDriver();
        }

        driver.get(url); // open the metadata hub system URL
        driver.manage().window().maximize(); //maximise the browser
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //waiting for the page to load
        return driver;
    }

    public static WebDriver getMicrosoftEdgeDriver() {

        String url = "https://app-app-kwikspace-dev.azurewebsites.net/login";
        System.setProperty("webdriver.edge.driver", "common_driver" + File.separator + "msedgedriver.exe");

        if (driver == null) {
            driver = new EdgeDriver();
        }

        driver.get(url); // open the metadata hub system URL
        driver.manage().window().maximize(); //maximise the browser
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //waiting for the page to load
        return driver;
    }

    private static void SwitchBrowser(String browser) {
        switch (browser) {
            case "Chrome": {
                var options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("disable-extensions");
                driver = new ChromeDriver();
            }
            break;
            case "IE":
                driver = new InternetExplorerDriver();
                break;
            case "MicrosoftEdge":
                driver = new EdgeDriver();
                break;
            case "Firefox":
                //FirefoxProfile profile = new FirefoxProfile();
                //profile.setAcceptUntrustedCertificates(true);
                // driver = new FirefoxDriver(profile);
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Browser '{0}' not recognized.  Spawning default Chrome browser.");
                driver = new ChromeDriver();
                break;
        }

    }

}
