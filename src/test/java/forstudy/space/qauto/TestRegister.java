package forstudy.space.qauto;


import forstudy.space.qauto.PageObject.GaraPage;
import forstudy.space.qauto.PageObject.RegistrationPage;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URI;
import java.time.Duration;
import java.util.function.Predicate;

public class TestRegister {

    WebDriver driver;
//    BaseVariables variables;

    public String baseLogin = "guest";
    public String basePassword = "welcome2qauto";
    public String host = "qauto.forstudy.space";

    @BeforeTest

    public void setup(){

        System.setProperty("webdriver.chrome.driver", "./drivers/chrome/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

//        driver.get("http://demo.guru99.com/V4/");

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void Test_001_Registration() {


        RegistrationPage page = new RegistrationPage(driver);
//        System.out.println(variables.host);

        Predicate<URI> uriPredicate = uri -> uri.getHost().contains(host);
        ((HasAuthentication) driver).register( uriPredicate, UsernameAndPassword.of(baseLogin, basePassword));
        driver.manage().window().maximize();

        driver.get("https://"+host);


        page.getButtonRegistration().click();
        assert page.getModalWindowRegistration().isDisplayed();
        /*new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(page.getButtonRegistration()));*/
        page.getInputName().sendKeys("MyName");
        page.getInputLastName().sendKeys("MySurname");
        long unixTime = System.currentTimeMillis() / 1000L;

        page.getInputLastEmail().sendKeys("test_"+unixTime+"@test.com");
        page.getInputPassword().sendKeys("Pa$$word1");
        page.getInputRepeatPassword().sendKeys("Pa$$word1");
        page.getButtonRegistrationInModal().click();

        assert new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("/panel/garage"));




}
    @Test
    public void Test_002_AddNewCar() {

        GaraPage page = new GaraPage(driver);

        page.getButtonAddAutoInHeader().click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(page.getModalWindowAddCar()));

        page.getDropDownCarBrand().click();
        page.getOptionFord().click();

        page.getDropDownModels().click();
        page.getModelFordFusion().click();

        page.getInputMileage().sendKeys("25");
        page.getButtonAddCar().click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(page.getCarItem()));
        assert page.getCarItem().getText().equals("Ford Fusion");

    }


};
