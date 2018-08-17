import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {

    @FindBy(id = "menu_pim_viewPimModule")
    private WebElement PIMtab;

    @FindBy(id = "menu_pim_addEmployee")
    private WebElement addEmployeeButton;

    public void clickPIM(){
        PIMtab.click();
    }

    public void clickAddEmployee(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addEmployeeButton.click();
    }
}
