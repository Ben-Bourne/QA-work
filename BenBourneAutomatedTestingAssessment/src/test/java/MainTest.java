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
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class MainTest {

    private ChromeDriver driver;
    private static ExtentTest test;
    private static ExtentReports extent;

    private String firstName = "Harry";
    private String lastName = "Short";
    private String employeeId = "3459872";
    private String username = "chocohypnotist";
    private String password = "RabbitHatFluff";

    @Before
    public void setUp(){
        extent = new ExtentReports(Constants.reportPath, true);
        test = extent.startTest("Test title");
        System.setProperty("webdriver.chrome.driver", Constants.chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);            // for review
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
        extent.endTest(test);
        extent.flush();
    }

    @Given("^the login page$")
    public void the_login_page() throws Throwable {
        driver.get(Constants.URLlogin);
        test.log(LogStatus.INFO, "Login page opened");
    }

    @When("^I login$")
    public void i_login() throws Throwable {
        Login loginPage = PageFactory.initElements(driver, Login.class);
        loginPage.login("Admin", "AdminAdmin");
        test.log(LogStatus.INFO, "Login successful");
    }

    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab() throws Throwable {
        Home homePage = PageFactory.initElements(driver, Home.class);
        homePage.clickPIM();
        test.log(LogStatus.INFO, "PIM tab clicked");
    }

    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab() throws Throwable {
        Home homePage = PageFactory.initElements(driver, Home.class);
        homePage.clickAddEmployee();
        test.log(LogStatus.INFO, "Add employee button clicked");
    }

    @When("^I fill out the Add Employee Details correctly$")
    public void i_fill_out_the_Add_Employee_Details_correctly() throws Throwable {
        AddEmployee addEmployeePage = PageFactory.initElements(driver, AddEmployee.class);
        addEmployeePage.enterEmployeeDetails(firstName, lastName, employeeId, "London Office");
        test.log(LogStatus.INFO, "Employee details entered");
    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button() throws Throwable {
        AddEmployee addEmployeePage = PageFactory.initElements(driver, AddEmployee.class);
        addEmployeePage.clickCreateLogin();
        test.log(LogStatus.INFO, "'Create Login Details' button clicked");
    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly() throws Throwable {
        AddEmployee addEmployeePage = PageFactory.initElements(driver, AddEmployee.class);
        addEmployeePage.enterLoginDetails(username, password);
        test.log(LogStatus.INFO, "Login details entered");
    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button() throws Throwable {
        AddEmployee addEmployeePage = PageFactory.initElements(driver, AddEmployee.class);
        addEmployeePage.saveEmployee();
        test.log(LogStatus.INFO, "Employee and login details submitted");
    }

    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created() throws Throwable {
        EmployeeDetails employeeDetailsPage = PageFactory.initElements(driver, EmployeeDetails.class);
        employeeDetailsPage.clickEmployeeList();
        EmployeeList employeeListPage = PageFactory.initElements(driver, EmployeeList.class);
        employeeListPage.searchForEmployee(firstName, lastName);
        test.log(LogStatus.INFO, "Employee details searched");
    }

    @Then("^select them for inspection$")
    public void select_them_for_inspection() throws Throwable {
        EmployeeList employeeListPage = PageFactory.initElements(driver, EmployeeList.class);
        employeeListPage.clickFirstResult();
        EmployeeDetails employeeDetailsPage = PageFactory.initElements(driver, EmployeeDetails.class);
        boolean result = employeeDetailsPage.checkAdded(firstName, lastName, employeeId);
        if(result){
            test.log(LogStatus.PASS, "Employee details found");
        }
        else{
            test.log(LogStatus.FAIL, "Employee details not found");
        }
        assertTrue(result);
    }
}
