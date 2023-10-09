package steps;
import org.junit.Assert;
import io.cucumber.java.en.*;
import pages.TestSandbox;


public class TestSandboxSteps {


   TestSandbox sandboxPage = new TestSandbox();

   @Given("^I navigate to the sandbox page$")
   public void navigateToTheSandboxSite(){
        sandboxPage.navigateToSandbox();
   }

   @And("^select a value from the dropdown$")
   public void selectState(){
        sandboxPage.selectCategory("Tennis");
   }


   @When("^I search the list$")
   public void searchTheList() throws InterruptedException{
          sandboxPage.enterSearchCriteria();
   }

   @Then("^I can return the value I wanted$")
     public void returnValue(){
     String value = sandboxPage.getValueFromGrid(2, 2);
     System.out.println("Escenario 1");    
     Assert.assertEquals("Ronaldo" , value);

   }

    @Then("^I can validate the table displayed$")
     public void theTableIsThere(){
     System.out.println("Escenario 2");
     Assert.assertTrue("Exploto todo" ,sandboxPage.cellStatus());
     }

}