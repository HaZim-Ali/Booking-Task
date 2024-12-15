package testPackage;

import Pages.SearchPage;
import Pages.HotelsPage;
import Pages.DestinationDetailsPage;
import Pages.ConfirmationPage;
import org.openqa.selenium.By;
import static utilities.jsonReader.getValueFromJsonFile;
import org.testng.annotations.Test;

public class AutoTest extends TestClass {
    SearchPage searchPage;
    HotelsPage hotelsPage;
    DestinationDetailsPage destinationDetailsPage;
    ConfirmationPage confirmationPage;

    @Test
    public void searchAndBookTolipHotel() throws InterruptedException {
        searchPage = new SearchPage(driver);
        hotelsPage = new HotelsPage(driver);
        destinationDetailsPage = new DestinationDetailsPage(driver);
        confirmationPage = new ConfirmationPage(driver);
        String location = getValueFromJsonFile("destination", "data");
        searchPage.enterLocation(location);
        searchPage.openCalendar();
        searchPage.datePicker();
        searchPage.searchButton();
        destinationDetailsPage.selectHotelTolip();
    }
    @Test(dependsOnMethods = "searchAndBookTolipHotel")
    public void selectHotelRoomAndReserve() throws InterruptedException {
        hotelsPage.selectRoom();
        hotelsPage.clickOnIWillReserve();

    }
    @Test(dependsOnMethods = "selectHotelRoomAndReserve")
    public void verifyHotelAndDates(){
        String hotelName = getValueFromJsonFile("hotelName","data");
        String checkIndate= getValueFromJsonFile("checkInDate","data");
        String checkOutdate= getValueFromJsonFile("checkOutDate","data");
        confirmationPage.assertElementContainsText(By.xpath("//h1[contains(text(), 'Tolip Hotel Alexandria')]"), hotelName);
        confirmationPage.assertElementContainsText(By.xpath("//div[contains(text(), 'Wed, Jan 1, 2025')]"), checkIndate);
        confirmationPage.assertElementContainsText(By.xpath("//div[contains(text(), 'Sat, Jan 4, 2025')]"), checkOutdate);
    }

}







