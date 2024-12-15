package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class HotelsPage extends pageBase {
    public HotelsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Ensure WebDriverWait is initialized here
    }

    private final WebDriverWait wait;

    @FindBy(xpath = "//span[@class=\"bui-button__text js-reservation-button__text\"][contains(text(),\"reserve\")]")
    WebElement iWillReserve;

    @FindBy(xpath = "//span[contains(text(),\"Select and continue\")]")
    WebElement reserveButton;


    public void selectRoom() {
        // Locate the dropdown element
        WebElement roomDropdown = driver.findElement(By.id("hprt_nos_select_78883120_373531459_2_33_0_131741"));

        // Use the Select class to select the option with value "1"
        Select select = new Select(roomDropdown);
        select.selectByValue("1"); // Select the option where value="1"
    }

    public void clickOnIWillReserve() {
        try {
            // Check if the "Select and continue" button exists
            WebElement reserveElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//span[contains(text(),\"Select and continue\")]")
            ));

            // If the element is found, click the "Select and continue" button
            if (reserveElement.isDisplayed()) {
                clicbutton(reserveButton);
            }
        } catch (Exception e) {
            //   If "Select and continue" button is not found, fall back to the other button
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//span[@class=\"bui-button__text js-reservation-button__text\"][contains(text(),\"reserve\")]")
            ));
            clicbutton(iWillReserve);
        }
    }
}
