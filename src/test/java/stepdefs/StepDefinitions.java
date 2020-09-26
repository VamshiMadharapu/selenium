package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.impl.SimpleLoggerFactory;
import util.PropertiesReader;
import pages.NztaPage;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {

	private String URL;
	private WebDriver driver;

	SimpleLoggerFactory log = new SimpleLoggerFactory();

	@Given("^i read the properties file$")
	public void iReadThePropertiesFile() {
		PropertiesReader.load(System.getProperty("user.dir") + "/src/test/java/resources/env.properties");
		URL = PropertiesReader.get("url");
		System.out.println("NZTA URL read from env.properties file");
	}

	@Given("^I navigate to the website using \"([^\"]*)\"$")
	public void iNavigateToTheWebsite(String browser) {
		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().browserVersion("85").setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("enable-automation");
			options.addArguments("--disable-infobars");
			options.addArguments("--whitelisted-ips");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation");
			driver = new ChromeDriver(options);
		} else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().browserVersion("76").setup();
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		System.out.println("Browser Initiated");
	}

	@When("^I click on payAToll button$")
	public void iClickOnPayATollButton() {
		NztaPage nzta = new NztaPage(driver);
		nzta.payATollLink.click();
		System.out.println("User able to identify and click on Pay a Toll button");
	}

	@And("^I click on buyOrPayToll button$")
	public void iClickOnBuyOrPayTollButton() {
		NztaPage nzta = new NztaPage(driver);
		nzta.BuyOrPayAToll.click();
		System.out.println("User able to identify and click on Buy or Pay a Toll button");
	}

	@And("^I checked the declare button$")
	public void iCheckedTheDeclareButton() throws InterruptedException {
		Thread.sleep(2000);
		NztaPage nzta = new NztaPage(driver);
		nzta.declareCheckBox.click();
		System.out.println("User able to confirm and check the Declare button");
	}

	@And("^I click on Continue button$")
	public void iClickOnContinueButton() throws InterruptedException {
		NztaPage nzta = new NztaPage(driver);
		nzta.continueButton.click();
		Thread.sleep(2000);
	}


	@And("^I enter \"([^\"]*)\"$")
	public void iEnter(String number) {
		NztaPage nzta = new NztaPage(driver);
		nzta.plateNumberField.click();
		nzta.plateNumberField.sendKeys(number);
		System.out.println("User able to enter the Car registration Number");
	}

	@And("^I enter \"([^\"]*)\" amount in NORTH_GW_TOLL field$")
	public void iEnterAmountInNORTH_GW_TOLLField(String NORTH_GW_TOLL) {
		NztaPage nzta = new NztaPage(driver);
		nzta.northGwTollField.click();
		nzta.northGwTollField.sendKeys(NORTH_GW_TOLL);
		System.out.println("User able to click and enter Northern Gateway Toll Road Money");
	}

	@And("^I enter \"([^\"]*)\" amount in TAURANGA_EAST_TOLL field$")
	public void iEnterAmountInTAURANGA_EAST_TOLLField(String TAURANGA_EAST_TOLL) {
		NztaPage nzta = new NztaPage(driver);
		nzta.taurangaTollField.click();
		nzta.taurangaTollField.sendKeys(TAURANGA_EAST_TOLL);
		System.out.println("User able to click and enter Tauranga Eastern Link Toll Road Money");
	}

	@And("^I enter \"([^\"]*)\" amount in TAKITIMU_TOLL field$")
	public void iEnterAmountInTAKITIMU_TOLLField(String TAKITIMU_TOLL)  {
		NztaPage nzta = new NztaPage(driver);
		nzta.takitimuTollField.click();
		nzta.takitimuTollField.sendKeys(TAKITIMU_TOLL);
		System.out.println("User able to click and enter Takitimu Drive Toll Road Money");
	}

	@And("^I click on noThanksRadioButton$")
	public void iClickOnNoThanksRadioButton() {
		NztaPage nzta = new NztaPage(driver);
		nzta.noThanksRadioButton.click();
		System.out.println("User chose not to enter email address");
	}


	@And("^I click on payNow button$")
	public void iClickOnPayNowButton() {
		NztaPage nzta = new NztaPage(driver);
		nzta.payNowButton.click();
		System.out.println("User able to click on Pay Now button");
	}

	@And("^I close the application$")
	public void iCloseTheApplication() {
		driver.quit();
	}

	@And("^I click on vehicleDetailsConfirm button$")
	public void iClickOnVehicleDetailsConfirmButton() {
		NztaPage nzta = new NztaPage(driver);
		nzta.confirmation.click();
	}
}

