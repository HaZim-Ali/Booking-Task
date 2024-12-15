package testPackage;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class TestClass {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set the path to the ChromeDriver

        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver and navigate to the booking site
        driver = new ChromeDriver();
        driver.navigate().to("https://www.booking.com/");  // Replace with actual URL of the room details page
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
