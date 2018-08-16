import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;

public class TeaTestImplementation {

    private ChromeDriver driver;
    private static ExtentTest test;
    private static ExtentReports extent;
    private int testNo = 1;

    @Before
    public void setUp(){
        extent = new ExtentReports(Constants.reportPath, false);
        test = extent.startTest("Test" + testNo);
        ++testNo;
        System.setProperty("webdriver.chrome.driver", Constants.chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
        extent.endTest(test);
        extent.flush();
    }

    @Given("^the correct web address$")
    public void the_correct_web_address() throws Throwable {
        driver.get(Constants.URLteaHome);
        test.log(LogStatus.INFO, "Home page opened");
    }

    @When("^I navigate to the 'Menu' page$")
    public void i_navigate_to_the_Menu_page() throws Throwable {
        TeaHome teaHomePage = PageFactory.initElements(driver, TeaHome.class);
        teaHomePage.clickMenu();
        test.log(LogStatus.INFO, "Menu button clicked");
    }

    @Then("^I can browse a list of the available products\\.$")
    public void i_can_browse_a_list_of_the_available_products() throws Throwable {
        TeaMenu teaMenuPage = PageFactory.initElements(driver, TeaMenu.class);
        boolean result = teaMenuPage.checkProducts();
        if(result){
            test.log(LogStatus.PASS, "All products present");
        }
        else{
            test.log(LogStatus.FAIL, "One or more products not found");
        }
        assertTrue(result);
    }

    @When("^I click the checkout button$")
    public void i_click_the_checkout_button() throws Throwable {
        TeaHome teaHomePage = PageFactory.initElements(driver, TeaHome.class);
        teaHomePage.clickCheckoutButton();
        test.log(LogStatus.INFO, "Checkout button clicked");
    }

    @Then("^I am taken to the checkout page$")
    public void i_am_taken_to_the_checkout_page() throws Throwable {
        TeaCheckout teaCheckoutPage = PageFactory.initElements(driver, TeaCheckout.class);
        boolean result = teaCheckoutPage.checkMessage();
        if(result){
            test.log(LogStatus.PASS, "Checkout page opened");
        }
        else{
            test.log(LogStatus.FAIL, "Checkout page not opened");
        }
        assertTrue(result);
    }
}