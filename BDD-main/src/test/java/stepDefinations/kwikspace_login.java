package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import elementsModel.KwikspaceLogin;

import utility.driverFactory;

import java.io.IOException;

public class kwikspace_login {

    private final KwikspaceLogin kwikspaceObjects = new KwikspaceLogin(driverFactory.getDriver());


    @Given("^i have launched the browser$")
    public void iHaveLaunchedTheBrowser() {
        driverFactory.getDriver();
    }


    @When("^i capture username and the password$")
    public void iCaptureUsernameAndThePassword() throws IOException {
        kwikspaceObjects.Username();
        kwikspaceObjects.Password();

    }

    @Then("^i validate if the user able to login$")
    public void iValidateIfTheUserAbleToLogin() throws IOException {
        kwikspaceObjects.kwikspaceLoginvalidation();

    }

    ////new SDs
    @Given("^I have navigated to the dashboard$")
    public void iHaveNavigatedToTheDashboard() throws IOException{
        kwikspaceObjects.kwikspaceLoginvalidation();
    }

    @And("^i click on login button$")
    public void iClickOnLoginButton() throws IOException {
        kwikspaceObjects.LoginButton();
    }

    @Given("^I Login to Kwikspace page$")
    public void iLoginToKwikspacePage() throws IOException {

        driverFactory.getDriver();
        kwikspaceObjects.Username();
        kwikspaceObjects.Password();
        kwikspaceObjects.LoginButton();
        kwikspaceObjects.kwikspaceLoginvalidation();
    }

    @Then("^I close the browser$")
    public void iCloseTheBrowser()throws IOException {

        kwikspaceObjects.CloseBrowser();
    }

}
