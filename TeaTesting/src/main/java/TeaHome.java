import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaHome {

    @FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
    private WebElement menuButton;

    @FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")
    private WebElement checkoutButton;

    public void clickMenu(){
        menuButton.click();
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }
}
