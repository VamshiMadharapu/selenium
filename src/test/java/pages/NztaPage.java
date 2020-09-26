package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NztaPage {

    public NztaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[1]/div/div[2]/ul/li[5]/a/span")
    public WebElement payATollLink;

    @FindBy(xpath = "//*[text()='Buy or pay a toll']")
    public WebElement BuyOrPayAToll;

    @FindBy(name = "declare")
    public WebElement declareCheckBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement continueButton;

    @FindBy(id = "plate_number")
    public WebElement plateNumberField;

    @FindBy(id = "trip_2")
    public WebElement northGwTollField;

    @FindBy(id = "trip_3")
    public WebElement taurangaTollField;

    @FindBy(id = "trip_6")
    public WebElement takitimuTollField;

    @FindBy(xpath = "//label[text()='No thanks']")
    public WebElement noThanksRadioButton;

    @FindBy(xpath = "//input[@value='Pay now']")
    public WebElement payNowButton;

    @FindBy(xpath = "//*[@id=\"form-future-trips-confirm-vehicle\"]/div/span/input")
    public WebElement confirmation;

}
