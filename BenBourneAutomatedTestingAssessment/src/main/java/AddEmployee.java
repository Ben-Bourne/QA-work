import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployee {

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "employeeId")
    private WebElement employeeIdField;

    @FindBy(xpath = "//*[@id=\"location_inputfileddiv\"]/div/input")
    private WebElement locationDropDown;

    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    private WebElement createLoginButton;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "systemUserSaveBtn")
    private WebElement saveButton;

    public void enterEmployeeDetails(String firstName, String lastName, String employeeId, String location){
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        for(int i = 0; i < 10; ++i) {
            employeeIdField.sendKeys(Keys.BACK_SPACE);
        }
        employeeIdField.sendKeys(employeeId);
    }

    public void clickCreateLogin(){
        createLoginButton.click();
    }

    public void enterLoginDetails(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
    }

    public void saveEmployee(){
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        saveButton.click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
