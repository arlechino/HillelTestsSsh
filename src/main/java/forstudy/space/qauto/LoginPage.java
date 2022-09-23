package forstudy.space.qauto;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;



import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URI;
import java.time.Duration;
import java.util.function.Predicate;


public class LoginPage {



//    @FindBy(css = ".modal-header")
//    private WebElement modalWindow;

//    Найти и описать UI Элементы для взаимодействия
    String modalWindow = ".modal-header";
    String SignInButton = ".btn.btn-outline-white.header_signin";
    String inputLogin = "#signinEmail";
    String inputPassword = "#signinPassword";
    String checkboxRememberMe = "#remember";
    String buttonForgotPassword = "//button[@_ngcontent-miv-c51]";
    String loginButton = ".modal-footer.d-flex.justify-content-between > .btn.btn-primary";
    String baseLogin = "guest";
    String basePassword = "welcome2qauto";
    String host = "qauto.forstudy.space";

//    Описание воспомогательны методов/Методы для работы с UI элементами
//TODO

//Написание тестов
    @BeforeClass
    public void beforeAllTests(){
        System.out.println("Tests started");
    }

    @BeforeTest
    public void beforeEachTests(){
        System.out.println("Run before each Tests");
    }

    @BeforeMethod
    public void beforeOne(){
        System.out.println("Вуйко");
    }

    @AfterTest
    public void afterAllTests(){
        System.out.println("Run after test");
    }

    @AfterClass
    public void closeBrowser(){
        System.out.println("Tests finished");

    }


 /*   @Test
    public void loginToGarage() {
        System.out.println("Test 1 ");
    }
    @Test
    public void loginToGarage1() {
        System.out.println("Test 2 ");
    }
    @Test
    public void loginToGarage2() {
        System.out.println("Test 3 ");
    }*/


    @Test
    public void loginToGarage() {
//        Где расположен веб драйвер
        System.setProperty("webdriver.chrome.driver", "./drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();

//        Открыть окно на максимальное резрешение, которое позволяет экран
        driver.manage().window().maximize();

//        Авторизация на сайте qauto.forstudy.space
        Predicate<URI> uriPredicate = uri -> uri.getHost().contains(host);
        ((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of(baseLogin, basePassword));
        driver.get("https://"+host);

//        Дождаться элемент sign in в header
        WebElement loginButtonInHeader = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(SignInButton)));

//      Click по кнопке sign in
        loginButtonInHeader.click();

//        Ожидаем отображаение модального окна логина
        WebElement modalWindows = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(modalWindow)));

//        Поиск инпута логин
        WebElement login = driver.findElement(By.cssSelector(inputLogin));

//        Запись данных в инпут login
        login.sendKeys("test_one@test.com");

        //        Поиск инпута password
        WebElement password = driver.findElement(By.cssSelector(inputPassword));
        //        Запись данных в инпут password
        password.sendKeys("P@ssword1");

        //        Поиск кнопки Login
        WebElement buttonLogin = driver.findElement(By.cssSelector(loginButton));
        //        клик по кнопке login
        buttonLogin.click();


//        assert driver.getCurrentUrl().contains("/panel/garage");
        assert new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("/panel/garage"));
        assert  driver.getTitle().equals("Hillel Qauto");


        driver.close();
        driver.quit();
    }
}
