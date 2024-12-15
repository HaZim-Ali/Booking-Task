package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

public class ConfirmationPage extends pageBase{
    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Ensure WebDriverWait is initialized here
    }
    private final WebDriverWait wait;


    public void assertElementContainsText(By locator, String expectedText) {
        // Wait until the element is visible
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Retrieve the actual text of the element
        String actualText = element.getText();

        // Assert that the element contains the expected text
        Assert.assertTrue(actualText.contains(expectedText),
                "Expected text '" + expectedText + "' not found in element text: '" + actualText + "'");
    }
}

