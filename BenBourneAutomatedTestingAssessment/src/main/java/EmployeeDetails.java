import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeDetails {

    @FindBy(id = "menu_pim_viewEmployeeList")
    private WebElement employeeList;

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "employee_id")
    private WebElement employeeIdField;

    public void clickEmployeeList(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        employeeList.click();
    }

    public boolean checkAdded(String firstName, String lastName, String employeeId){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean result = true;
        System.out.println(firstNameField.getAttribute("value"));
        String compare = firstNameField.getAttribute("value");
        if(!(compare.equals(firstName))){
            result = false;
        }
        compare = lastNameField.getAttribute("value");
        if(!(compare.equals(lastName))){
            result = false;
        }
        compare = employeeIdField.getAttribute("value");
        if(!(compare.equals(employeeId))){
            result = false;
        }
        return result;
    }
}
