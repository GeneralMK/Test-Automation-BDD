package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import utility.driverFactory;

import java.io.IOException;
import elementsModel.CreateRentalOrder;



public class createrental_order {

    private final CreateRentalOrder CreateRentalOrderObjects = new CreateRentalOrder(driverFactory.getDriver());


    @When("^I click on Create a rental quote button$")
    public void iClickOnCreateARentalQuoteButton() throws IOException{
        CreateRentalOrderObjects.CreateRentalQuoteButton();
    }

    @Then("^Quote details should be displayed$")
    public void quoteDetailsShouldBeDisplayed()throws IOException {
        CreateRentalOrderObjects.QuoteDetailsvalidation();
    }

    //new steps
    @And("^I click on Search Customer button$")
    public void iClickOnSearchCustomerButton()throws IOException  {
        CreateRentalOrderObjects.ClickOnSearchCustomerButton();
    }

    @Then("^I select \"([^\"]*)\" from the customer dropdown list$")
    public void iSelectFromTheCustomerDropdownList(String iname) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.SelectFromTheCustomerSelectList(iname);
    }

    @And("^I select \"([^\"]*)\" from the Building Type dropdown list$")
    public void iSelectFromTheBuildingTypeDropdownList(String buildingType) throws Exception  {
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.SelectFromBuildingTypeList(buildingType);
    }

    @And("^I select \"([^\"]*)\" from the Select Location dropdown list$")
    public void iSelectFromTheSelectLocationDropdownList(String quoteLocation) throws Exception  {
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.SelectQuoteLocation(quoteLocation);
    }

    @And("^I select \"([^\"]*)\" from the Organizational Sector dropdown list$")
    public void iSelectFromTheOrganizationalSectorDropdownList(String orgSector) throws Exception  {
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.SelectOrganizationSector(orgSector);
    }

    @Then("^I enter \"([^\"]*)\" in the notes textbox$")
    public void iEnterInTheNotesTextbox(String Quotenotes) throws Exception  {
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.PopulateNotes(Quotenotes);
    }

    @And("^I have entered \"([^\"]*)\" into the Search Textbox$")
    public void iHaveEnteredIntoTheSearchTextbox(String name) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.SendTextToSearchBox(name);
    }


    @And("^I select \"([^\"]*)\" from Building Type dropdown list$")
    public void iSelectFromBuildingTypeDropdownList(String builType) throws Exception  {
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.SelectFromBuildingTypeCape(builType);
    }

    @And("^I select \"([^\"]*)\" from the Location dropdown list$")
    public void iSelectFromTheLocationDropdownList(String quoteLocation) throws Exception  {
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.SelectLocationCape(quoteLocation);
    }

    @And("^I select \"([^\"]*)\" from Organizational Sector dropdown list$")
    public void iSelectFromOrganizationalSectorDropdownList(String OrgSector) throws Exception  {
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.SelectOrganizationalSecCape(OrgSector);
    }

    @And("^I populate \"([^\"]*)\" in first address line field$")
    public void iPopulateInFirstAddressLineField(String FirstAddressLine) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.SendTextToFirstAddressLineBox(FirstAddressLine);
    }

    @And("^I populate \"([^\"]*)\" in second address line field$")
    public void iPopulateInSecondAddressLineField(String SecondAddressLine) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.SendTextToSecondAddressLineBox(SecondAddressLine);
    }

    @And("^I populate \"([^\"]*)\" in the suburb field$")
    public void iPopulateInTheSuburbField(String Suburb) throws Exception{
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.SendTextToSuburbBox(Suburb);
    }

    @Then("^I populate \"([^\"]*)\" in the postal code field$")
    public void iPopulateInThePostalCodeField(String PostalCode) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.SendTextToPostalCodeBox(PostalCode);
    }

    @And("^I select \"([^\"]*)\" from the province dropdown list$")
    public void iSelectFromTheProvinceDropdownList(String Province) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.SelectProvince(Province);
    }

    @And("^I select \"([^\"]*)\" from the district dropdown list$")
    public void iSelectFromTheDistrictDropdownList(String District) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.SelectDistrict(District);
    }

    @And("^I select \"([^\"]*)\" from the Area dropdown list$")
    public void iSelectFromTheAreaDropdownList(String Area) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        CreateRentalOrderObjects.SelectArea(Area);
    }


}
