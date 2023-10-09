package pages;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ListPage extends BasePage{

    private String searchField = "//body/form[1]/input[1]";
    private String searchResults = "name";
    

    public ListPage(){
        super(driver);

    }

    public void navigateToSandbox(){

        navigateTo("https://amelieyeh.github.io/JS30/06-Ajax%20Type%20Ahead/index.html");
    }

    public void enterSearchCriteria(String state) throws InterruptedException{
        try{
        Thread.sleep(600);
        write (searchField, state);
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public List<String> getAllSearchResults(){
       List<WebElement> list = bringMeAllElements(searchResults); // crear dos listas
       List<String> stringsFromList = new ArrayList<String>();
       //System.out.println("hola");

       for (WebElement e:list){
            stringsFromList.add(e.getText());
            System.out.println(e.getText());
       }
       return stringsFromList;
    }

}
