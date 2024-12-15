package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchPage extends pageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Ensure WebDriverWait is initialized here
    }

    private final WebDriverWait wait;

    @FindBy(xpath = "//input[@id=\":rh:\"]")
    WebElement location;

    @FindBy(xpath = "(//span[@data-testid='autocomplete-icon-default']/following-sibling::div//div[@class='a3332d346a d2f04c9037'])[1]")
    WebElement locationALex;

    @FindBy(xpath = "//div[@data-testid=\"searchbox-dates-container\"]")
    WebElement calendarContainer;

    @FindBy(xpath = "//td[@role='gridcell']//span[@data-date=\"2025-01-01\"]")
    WebElement selectCheckin;

    @FindBy(xpath = "//td[@role='gridcell']//span[@data-date=\"2025-01-04\"]")
    WebElement selectCheckout;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;


    public void enterLocation(String locationForTrip) throws InterruptedException {
        setTextElementText(location, locationForTrip);

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[@data-testid='autocomplete-icon-default']/following-sibling::div//div[contains(text(),'Alexandria')]")));
        Thread.sleep(3000);
        clicbutton(locationALex); // Click the autocomplete suggestion
    }

    public void openCalendar() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-testid='searchbox-dates-container']")));
        clicbutton(calendarContainer);
        clicbutton(calendarContainer);
    }

    public void searchButton() {
        clicbutton(searchButton);
    }

    public void datePicker() {
        clicbutton(selectCheckin);
        clicbutton(selectCheckout);
    }



}





