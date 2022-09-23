package forstudy.space.qauto.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GaraPage {
    WebDriver driver;

    @FindBy(css = ".btn.btn-primary")
    private WebElement buttonAddAutoInHeader;
    @FindBy(css = ".modal-content")
    private WebElement modalWindowAddCar;
    @FindBy(id="addCarBrand")
    private WebElement dropDownCarBrand;
    @FindBy(xpath = "//select[@id=\"addCarBrand\"]/option[text()='Ford']")
    private WebElement optionFord;
    @FindBy(id="addCarModel")
    private WebElement dropDownModels;
    @FindBy(xpath = "//select[@id='addCarModel']/option[text()='Fusion']")
    private WebElement modelFordFusion;
    @FindBy(id="addCarMileage")
    private WebElement inputMileage;
    @FindBy(xpath = "//div[@class='modal-content']//button[@class='btn btn-primary']")
    private WebElement buttonAddCar;
    @FindBy(xpath = "//*[@class='car-item'][1]//p[@class='car_name h2']")
    private WebElement carItem;



    public GaraPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    public WebElement getModalWindowAddCar() {
        return modalWindowAddCar;
    }

    public WebElement getButtonAddAutoInHeader() {
        return buttonAddAutoInHeader;
    }

    public WebElement getDropDownCarBrand() {
        return dropDownCarBrand;
    }

    public WebElement getButtonAddCar() {
        return buttonAddCar;
    }

    public WebElement getDropDownModels() {
        return dropDownModels;
    }

    public WebElement getInputMileage() {
        return inputMileage;
    }

    public WebElement getModelFordFusion() {
        return modelFordFusion;
    }

    public WebElement getOptionFord() {
        return optionFord;
    }

    public WebElement getCarItem() {
        return carItem;
    }
}
