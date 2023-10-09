package pages;

public class TestSandbox extends BasePage{

    private String categoryDropDown = "//select[@id='formBasicSelect']";
    private String cell = "//body/div[@id='root']/div[1]/div[8]/div[1]/";
    private String mainTable = "//body/div[@id='root']/div[1]/div[8]/div[1]/table[1]";
    private String searchField = "//input[@id='formBasicText']";
    

    public TestSandbox(){
        super(driver);

    }

    public void navigateToSandbox(){

        navigateTo("https://thefreerangetester.github.io/sandbox-automation-testing/");
    }

    public void selectCategory(String category){
        
        //selectFormDropdownByValue(categoryDropDown, category);
        selectFormDropdownByIndex(categoryDropDown, 1);
    
    }

    public String getValueFromGrid(int row, int column){
        return getValueFromTable(cell, row, column);

    }

    public boolean cellStatus(){
        return elementIsDisplayed(mainTable);
    }

    public void enterSearchCriteria() throws InterruptedException{
        Thread.sleep(10000);
        write (searchField, "Washington");
    }

}
