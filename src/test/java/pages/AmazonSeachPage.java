package pages;


public class AmazonSeachPage extends BasePage{

    private String searchbox = "//input[@id='twotabsearchtextbox']";
    private String seachButton = "//input[@id='nav-search-submit-button']"; 
    private String thirdButton = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[4]";
    private String addToCartButton = "//input[@id='add-to-cart-button']";
    private String addedMessageText = "//span[contains(text(),'Agregado al carrito')]"; 
    
    public AmazonSeachPage(){
        super(driver);        
    }

    public void navigateToAmazon(){
        navigateTo("https://www.amazon.com");    
        //clickElement(acceptCookies); 
            
    }

    public void enterSeachCriteria(String criteria){
        write(searchbox, criteria);
    }

    public void clickSeach(){
        clickElement(seachButton);
    }

    public void goToPage2(){
        goToLinkText("2");
    }

    public void pick3rdItem(){
        clickElement(thirdButton);
    }

    public void addToCart(){
        clickElement(addToCartButton);
    }

    public String addedToCartMessage(){
        deleteCookies();
        return textFromElement(addedMessageText);
    }
}
