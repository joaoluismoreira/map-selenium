package pages;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleMapsPage {

    //Page URL
    private WebDriver driver;
    private static String PAGE_URL="https://www.google.com/maps";
    private WebDriverWait wait;


    //Locators
    @FindBy(id = "searchboxinput")
    WebElement searchBox;

    @FindBy(id = "searchbox-searchbutton")
    WebElement searchButton;

    @FindBy(css = ".section-hero-header-title-title.GLOBAL__gm2-headline-5")
    WebElement resultHeader;

    @FindBy(css = "*[class*=section-action-chip-button]")
    List<WebElement> directionsButton;

    @FindBy(css = "#sb_ifc52>.tactile-searchbox-input")
    WebElement destinationBox;

    //Constructor
    public GoogleMapsPage(WebDriver webDriver){
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void openWithoutCookieConsent() {
        driver.manage().window().maximize();
        openPage();
        driver.manage().deleteAllCookies();
        Cookie cookie = new Cookie("CONSENT", "YES+PT.pt-PT+V12+BX");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }


    public void typeInSearchBox(){

        searchBox.sendKeys("Dublin");

    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void clickOnDirectionsButton() {
        directionsButton.get(0).click();
    }

    public String resultHeaderText() {
        wait.until(ExpectedConditions.visibilityOf(resultHeader));
        return resultHeader.getText();
    }

    public String directionsBoxText() {
        return destinationBox.getAttribute("aria-label");
    }
}
