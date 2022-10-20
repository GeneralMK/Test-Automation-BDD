package elementsModel;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseFunctionality;

import java.io.IOException;


public class KwikspaceLogin {

    private final WebDriver driver;

    //KwikSpace login home page elements
    @FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")
    private WebElement Username;

    @FindBy(how = How.XPATH, using = "//body/app-root[1]/app-login[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/form[1]/div[2]/div[1]/input[1]")
    private WebElement Password;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Login')]")
    private WebElement LoginButton;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Logout')]")
    private WebElement kwikspaceloginvalidation;


    //Constructor
    public KwikspaceLogin(WebDriver driver) {
        this.driver = driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);

    }

    public void kwikspaceLoginvalidation() throws IOException {
        String kwikspacelogin = kwikspaceloginvalidation.getText();
        Assert.assertEquals("Logout", kwikspacelogin);
        BaseFunctionality.TakeScreenShots("Home page");//Call takescreenshot funtion that extends from Base class(BaseMainPage)
    }

    public void CloseBrowser() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Logout')]")));
        driver.quit();
    }

    //action required
    public void Username() throws IOException {
        Username.sendKeys("rudi.marx@tangentsolutions.co.za");
        BaseFunctionality.TakeScreenShots("Username page");

    }

    public void vvUsername(WebElement ele, String username) throws IOException {

        BaseFunctionality.SendTextToIWebElement(Username, "rudi.marx@tangentsolutions.co.za");
        BaseFunctionality.TakeScreenShots("Username page");
    }

    public void Password() throws IOException {
        Password.sendKeys("Pass123#");
    }

    public void LoginButton() throws IOException {
        LoginButton.click();
    }
}
