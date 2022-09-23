package forstudy.space.qauto.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;

    @FindBy(css = ".hero-descriptor_btn.btn.btn-primary")
    private WebElement buttonRegistration;
    @FindBy(css = ".modal-content")
    private WebElement modalWindowRegistration;
    @FindBy(id = "signupName")
    private WebElement inputName;
    @FindBy(id = "signupLastName")
    private WebElement inputLastName;
    @FindBy(id = "signupEmail")
    private WebElement inputLastEmail;
    @FindBy(id = "signupPassword")
    private WebElement inputPassword;
    @FindBy(id = "signupRepeatPassword")
    private WebElement inputRepeatPassword;
    @FindBy(xpath = "//div[@class='modal-content']//button[@class='btn btn-primary']")
    private WebElement buttonRegistrationInModal;


    public RegistrationPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    public WebElement getButtonRegistration() {
        return buttonRegistration;
    }

    public WebElement getInputLastEmail() {
        return inputLastEmail;
    }

    public WebElement getInputLastName() {
        return inputLastName;
    }

    public WebElement getInputName() {
        return inputName;
    }

    public WebElement getModalWindowRegistration() {
        return modalWindowRegistration;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getInputRepeatPassword() {
        return inputRepeatPassword;
    }

    public WebElement getButtonRegistrationInModal() {
        return buttonRegistrationInModal;
    }
}





