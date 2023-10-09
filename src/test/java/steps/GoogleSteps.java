package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.GooglePage;

public class GoogleSteps {

    GooglePage google = new GooglePage();
 
    @Given("^navego a google$")
    public void navigateToGoogle(){
        google.nagigateToGoogle();
        google.clickTermsConditions();

    }

    @When("^busco algo$")
    public void enterSeachCriteria(){
            google.enterSearchCriteria("emol");
    }

    @And("^y hago click en el boton search$")
    public void clickSearchButton(){
        google.clickGoogleSearch();
    
    }

    @Then("^obtengo resultados$")
    public void validateResults(){
        Assert.assertEquals("Texto que esperamos", google.firstResult());
        
    }

}
