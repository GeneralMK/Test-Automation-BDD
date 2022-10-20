package elementsModel;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utility.BaseFunctionality;
import utility.driverFactory;

import java.io.IOException;

public class CreateRentalOrder extends BaseFunctionality {

    private final WebDriver driver;

    //Create Order home page elements

    @FindBy(how = How.XPATH, using = "//body/app-root[1]/kwikspace-dashboard[1]/div[1]/div[1]/div[2]/div[1]/kwikspace-quotes[1]/div[1]/div[1]/tan-table[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/div[1]/button[1]")
    private WebElement CreateRenatlQuoteButton;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Quote Details')]")
    private WebElement iQuoteDetailsvalidation;

    @FindBy(how = How.ID, using = "CustomersByButton")
    private WebElement SearchCustomerButton;

    @FindBy(how = How.ID, using = "search-text")
    private WebElement SearchText;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/kwikspace-dashboard/div/div/div[2]/div/kwikspace-new-rental-quote/div/div/div[2]/form/div[1]/div[2]/div/div/div[4]/div/button")
    private WebElement uNames;

    @FindBy(how = How.ID, using = "building_type")
    private WebElement buildTypes;

    @FindBy(how = How.ID, using = "quote_location")
    private WebElement qouteLocation;

    @FindBy(how = How.ID, using = "organization_sector")
    private WebElement organizationsector;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/kwikspace-dashboard/div/div/div[2]/div/kwikspace-new-rental-quote/div/div/div[2]/form/div[3]/input")
    private WebElement Notes;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/kwikspace-dashboard/div/div/div[2]/div/kwikspace-new-rental-quote/div/div/div[3]/form/div[1]/div[1]/input")
    private WebElement FirstAddress;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/kwikspace-dashboard/div/div/div[2]/div/kwikspace-new-rental-quote/div/div/div[3]/form/div[1]/div[2]/input")
    private WebElement SecondAddress;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/kwikspace-dashboard/div/div/div[2]/div/kwikspace-new-rental-quote/div/div/div[3]/form/div[2]/div[1]/input")
    private WebElement iSuburb;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/kwikspace-dashboard/div/div/div[2]/div/kwikspace-new-rental-quote/div/div/div[3]/form/div[2]/div[2]/input")
    private WebElement PostalCode;

    @FindBy(how = How.ID, using = "shipping_province")
    private WebElement ddProvince;

    @FindBy(how = How.ID, using = "shipping_district")
    private WebElement ddDistrict;

    @FindBy(how = How.ID, using = "shipping_area")
    private WebElement ddArea;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'* District')]")
    private WebElement DistrictLabel;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'* Area')]")
    private WebElement AreaLabel;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'* Province')]")
    private WebElement ProvinceLocator;

    //constructor
    public CreateRentalOrder(WebDriver driver) {
        {
            this.driver = driver;
            //Initialise Elements
            PageFactory.initElements(driver, this);
        }
    }

    //Functions to action
    public void CreateRentalQuoteButton() throws IOException {
        CreateRenatlQuoteButton.click();
        TakeScreenShots("CreateRentalQuoteButton page");
    }

    public void QuoteDetailsvalidation() throws IOException {
        String quoteDetails = iQuoteDetailsvalidation.getText();
        Assert.assertEquals("Quote Details", quoteDetails);
        TakeScreenShots("QuoteDetailsvalidation page");
    }

    public void ClickOnSearchCustomerButton() throws IOException {
        SearchCustomerButton.click();
    }

    public void SelectFromTheCustomerSelectList(String UserName) throws Exception {
        // SelectAnElementFromSelectList(UserName);
        SelectAnyElementFromAnySelectList(UserName, By.xpath("/html/body/app-root/kwikspace-dashboard/div/div/div[2]/div/kwikspace-new-rental-quote/div/div/div[2]/form/div[1]/div[2]/div/div/div[4]/div/button"));

    }

    public void SelectFromBuildingTypeList(String buildingType) throws Exception {

        selectElementByIndex(buildTypes, 1);
        TakeScreenShots(buildingType);
    }

    public void SelectQuoteLocation(String quoteLocation) throws Exception {
        selectElementByIndex(qouteLocation, 1);

    }

    public void SelectOrganizationSector(String organizationSector) throws Exception {
        selectElementByIndex(organizationsector, 1);

    }

    public void SelectFromBuildingTypeCape(String buildingType) throws Exception {

        selectElementByVisibleText(buildTypes, "Clinics & Hospitals");
    }

    public void SelectLocationCape(String quoteLocation) throws Exception {
        selectElementByVisibleText(qouteLocation, "Cape Town");
    }

    public void SelectOrganizationalSecCape(String orgSector) throws Exception {
        selectElementByVisibleText(organizationsector, "Construction");
    }


    public void PopulateNotes(String notes) throws Exception {
        SendTextToIWebElementAndEnter(Notes, notes);
    }

    public void SendTextToSearchBox(String name) throws Exception {
        SendTextToIWebElementAndEnter(SearchText, name);
    }

    public void SendTextToFirstAddressLineBox(String firstAddressLine) throws Exception {
        SendTextToIWebElementAndEnter(FirstAddress, firstAddressLine);
    }

    public void SendTextToSecondAddressLineBox(String secondAddressLine) throws Exception {
        SendTextToIWebElementAndEnter(SecondAddress, secondAddressLine);
    }

    public void SendTextToSuburbBox(String suburb) throws Exception {
        SendTextToIWebElementAndEnter(iSuburb, suburb);
    }

    public void SendTextToPostalCodeBox(String postalCode) throws Exception {
        SendTextToIWebElementAndEnter(PostalCode, postalCode);
        //ScrollToElement();
        //ScrollToAnyElement((By)ProvinceLocator);
        ScrollToAnyElement(By.xpath("//label[contains(text(),'* Province')]"));

    }

    public void SelectProvince(String province) throws Exception {

        selectElementByVisibleText(ddProvince, "Gauteng");
        waitForAnElementToBeVisible(driver, DistrictLabel, 5);
    }

    public void SelectDistrict(String district) throws Exception {
        //waitForElementToBeVisible(driver,DistrictLabel,10);

        selectElementByVisibleText(ddDistrict, "Johannesburg");
    }

    public void SelectArea(String area) throws Exception {
        waitForAnElementToBeVisible(driver, AreaLabel, 5);
        selectElementByIndex(ddArea, 3);
    }

    //Example of how to implement the expandRootElement
    public void ClickToCancel() {
        waitForAnElementToBeVisible(driverFactory.driver, ddArea, 10);
        System.out.println("Validate kwikspace text");

        //identify the first shadow root to open
        WebElement root1 = driverFactory.driver.findElement(By.xpath("ls-quote"));
        WebElement shadowRoot1 = expandRootElement(root1);

        //when the first root is open, open the second root by whatever element identifier
        WebElement root2 = shadowRoot1.findElement(By.xpath("ls-quote-actions"));
        WebElement shadowRoot2 = expandRootElement(root2);

        //then click the desired btn when all roots are open
        WebElement root3 = shadowRoot2.findElement(By.id("rejected"));
        root3.click();

    }


}
