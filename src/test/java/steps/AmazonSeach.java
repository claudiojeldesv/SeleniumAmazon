package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.AmazonSeachPage;

public class AmazonSeach {

    AmazonSeachPage amazon = new AmazonSeachPage();

    @Given("^the user navigates to www.amazon.com$")
    public void navigateToAmazon(){
        amazon.navigateToAmazon();
    }

    @And("^searches for (.+)$")
    public void enterSearchCriteria(String criteria){
        amazon.enterSeachCriteria(criteria);
        amazon.clickSeach();  
    }
    
    //Comentario2
    //@And("^navigates to the second page$")
    //public void navigateToSecondPage(){
    //    amazon.goToPage2(); 
    //}

    @And("^selects the third item$")
    public void selectThirdsItem(){
        amazon.pick3rdItem(); 
    }

    @Then("^the user is able to add it to the Cart$")
    public void itemCanBeAddedToCart(){
        amazon.addToCart();
        Assert.assertEquals("Agregado al carrito", amazon.addedToCartMessage());
        
        
    }

}
