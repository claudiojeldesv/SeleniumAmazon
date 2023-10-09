package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.List;

// Mi clase principal: Basepage donde creamos una instancia statica del driver, el webdriver lo que es la 
// instancia del navegador que usaremos para toquetear con selenium
public class BasePage {
    
    protected static WebDriver driver; //Static hace que haya 1 sola instancia para webdriver compartida para todas las clases
    private static WebDriverWait wait; // espera
    private static Actions action;


    // Creación de objetos, le pasamos las chromeoptions
    static {
        
        ChromeOptions ChromeOptions = new ChromeOptions();
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\claud\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver(ChromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        
    }

    // Constructor de esta clase
    public BasePage (WebDriver driver){
        BasePage.driver = driver;
         wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
    }

    // Crear la funcion para navegar
    public static void navigateTo(String url){
        driver.get(url);        
    }

    public void goToLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public static void closeBrowser(){
        driver.quit(); // cierra la instancia del browser
    }

    private WebElement Find(String locator) { //solo lo vamos a ocupar en esta clase
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))); // voy a esperar hasta 10 segundos el elemento
    } 

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);       
    }

    public void selectFormDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFormDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select (Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        return Find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend){       
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";       
        Find(cellToFill).sendKeys(stringToSend);    
    }

    public void switchToIframe(int iframeIndex){
        driver.switchTo().frame(iframeIndex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dissmissAlert(){
        try{
        driver.switchTo().alert().dismiss();
        }catch(NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    public String textFromElement(String locator){
        return Find(locator).getText();
    }

    public boolean elementEnabled(String locator){
        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }

    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }

}
