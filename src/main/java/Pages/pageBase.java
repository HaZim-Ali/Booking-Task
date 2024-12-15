package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pageBase {
    protected WebDriver driver;
    public pageBase(WebDriver driver ) {
        PageFactory.initElements(driver, this);
    }
    protected static void clicbutton(WebElement button) {
        button.click();
    }

    protected static void setTextElementText(WebElement textElememnt, String value) {
        textElememnt.sendKeys(value);

    }
}