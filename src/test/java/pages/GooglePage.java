package pages;

// Usamos la herencia con extends
public class GooglePage extends BasePage{

    private String searchButton = "//input[@value='Buscar con Google']";
    private String acceptButtonTerms = "//*[@id=\"L2AGLb\"]";
    private String seachTextField = "//textarea[@id='APjFqb']";
    private String firstResult = ""; 

    public GooglePage(){
        super(driver); // por qué usamos super: porque una interfaz esta extendiendo a otra interfaz. Selenium es una interfaz       
    }
    
    public void nagigateToGoogle(){
        navigateTo("https://www.google.cl");
    }

    public void clickTermsConditions(){
        clickElement(acceptButtonTerms);
    }

    public void clickGoogleSearch(){
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){      
        write(seachTextField,criteria);
    }

    public String firstResult(){
        return textFromElement(firstResult);
    }
}
