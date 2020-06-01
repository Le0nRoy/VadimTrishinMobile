package pageObjects.webObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pageObjects.AbstractPageObject;

import java.util.ArrayList;
import java.util.List;

public class GooglePageObject extends AbstractPageObject {

    WebElement searchInput;
    WebElement searchBtn;
    List<WebElement> searchResults;

    public GooglePageObject(AppiumDriver appiumDriver) {

        super(appiumDriver);
    }

    public void openGooglePage() {

        driver.get("https://www.google.com/");
        wait.until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
    }

    public void searchByKeyword(String keyword) {

        searchInput = driver.findElement(By.xpath("//input[@name='q']"));
        searchBtn = driver.findElement(By.xpath("//button[@class='Tg7LZd']"));

        searchInput.sendKeys(keyword);
        searchBtn.click();
    }

    public List<String> getSearchResults() {

        List<String> results = new ArrayList<>();

        searchResults = driver.findElements(By.xpath("//div[contains(text(),'EPAM | Enterprise Software Development, Design & Consulting')]"));
        for (int i = 0; i < searchResults.size(); ++i) {
            results.add(searchResults.get(i).toString());
        }
        return results;
    }
}
