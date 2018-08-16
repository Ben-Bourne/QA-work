import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaMenu {

    @FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong")
    private WebElement greenTea;

    @FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p/span/span/strong")
    private WebElement redTea;

    @FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]/div/p/span/span/strong")
    private WebElement oolongTea;

    public boolean checkProducts(){
        boolean result = true;
        String product = greenTea.getText();
        if (!product.equals("Green Tea")){
            result = false;
        }
        product = redTea.getText();
        if (!product.equals("Red Tea")){
            result = false;
        }
        product = oolongTea.getText();
        if (!product.equals("Oolong Tea")){
            result = false;
        }
        return result;
    }
}
