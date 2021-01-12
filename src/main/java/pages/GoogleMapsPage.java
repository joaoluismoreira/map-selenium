package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMapsPage {
    private WebDriver driver;

    //Page URL
    private static String PAGE_URL="https://www.google.com/maps";

    //Locators
    @FindBy(id = "searchboxinput")
    WebElement searchBox;

    //Constructor
    public GoogleMapsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void typeInSearchBox(){

        searchBox.sendKeys("Dublin");

    }
}
