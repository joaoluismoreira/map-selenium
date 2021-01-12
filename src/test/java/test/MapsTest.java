package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GoogleMapsPage;

public class MapsTest {
    WebDriver driver = new FirefoxDriver();
    GoogleMapsPage mapsPage = new GoogleMapsPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Before
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver.manage().window().maximize();
        mapsPage.openPage();
        // Dealing with cookie consent by setting the cookie approach
        driver.manage().deleteAllCookies();
        Cookie cookie = new Cookie("CONSENT", "YES+PT.pt-PT+V12+BX");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        String driverCookie = driver.manage().getCookieNamed("CONSENT").getValue();
        Assert.assertEquals("YES+PT.pt-PT+V12+BX", driverCookie);
    }

    @Test
    public void searchAndFindDublin() throws InterruptedException {
        //Create object of HomePage Class

        mapsPage.typeInSearchBox();
        Thread.sleep(3000);

    }

    @After
    public void close(){
        driver.close();
    }
}