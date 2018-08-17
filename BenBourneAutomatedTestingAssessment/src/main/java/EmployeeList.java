import gherkin.lexer.Th;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeList {

    @FindBy(id = "employee_name_quick_filter_employee_list_value")
    private WebElement employeeSearchField;

    @FindBy(id = "quick_search_icon")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"employeeListTable\"]/tbody/tr[1]/td[3]")
    private WebElement firstResult;

    public void searchForEmployee(String firstName, String lastName){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        employeeSearchField.sendKeys(firstName + " " + lastName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        searchButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickFirstResult(){
        firstResult.click();
    }
}
//*[@id="employeeListTable"]/tbody/tr/td[3]
//*[@id="employeeListTable"]/tbody/tr[1]/td[3]
//*[@id="employeeListTable"]/tbody/tr[1]/td[3]