package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Set;

public class DestinationDetailsPage extends pageBase {

    public DestinationDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Ensure WebDriverWait is initialized here
    }

    private final WebDriverWait wait;

    @FindBy(xpath = "//div[contains(text(),\"Tolip Hotel Alexandria\")]")
    WebElement selectHotel;

    public void selectHotelTolip() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),\"Tolip Hotel Alexandria\")]")));
        clicbutton(selectHotel);

        // Handle switching to the new tab
        switchToNewTab();
    }
    /**
     * Method to switch to the newly opened tab after selecting the hotel.
     */
    public void switchToNewTab() {
        String currentTab = driver.getWindowHandle(); // Get the current tab's handle
        Set<String> allTabs = driver.getWindowHandles(); // Get all tabs' handles

        for (String tab : allTabs) {
            if (!tab.equals(currentTab)) { // Switch to the new tab
                driver.switchTo().window(tab);
                break;
            }
        }

    }

}
