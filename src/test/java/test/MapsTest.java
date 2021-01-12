package test;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.GoogleMapsPage;

public class MapsTest {
    private WebDriver driver = new FirefoxDriver();
    GoogleMapsPage mapsPage = new GoogleMapsPage(driver);

    @Before
    public void setup(){
        mapsPage.openWithoutCookieConsent();
    }

    @Test
    public void searchAndFindDublinDirections(){
        mapsPage.typeInSearchBox();
        mapsPage.clickOnSearchButton();
        Assert.assertEquals("Dublin", mapsPage.resultHeaderText());
        mapsPage.clickOnDirectionsButton();
        Assert.assertTrue(mapsPage.directionsBoxText().contains("Dublin"));
    }

    @After
    public void close(){
        mapsPage.closeBrowser();
    }
}