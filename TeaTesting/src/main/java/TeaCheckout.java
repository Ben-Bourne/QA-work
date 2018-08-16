import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaCheckout {

    @FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000451989411\"]/div/p/span/strong")
    private WebElement message;

    public boolean checkMessage(){
        String result = message.getText();
        if(result.equals("Pay with Credit Card or Log In")){
            return true;
        }
        else{
            return false;
        }
    }
}
