package hw.steps;

import hw.DTO.WebMobileTestDTO;
import hw.assertions.WebMobileTestAssertions;
import io.appium.java_client.AppiumDriver;
import pageObjects.WebPageObject;

public class WebMobileTestSteps {

    AppiumDriver driver;

    WebMobileTestDTO dto;
    WebPageObject pageObject;
    WebMobileTestAssertions assertions;

    public WebMobileTestSteps(AppiumDriver driver) {

        this.driver = driver;

        pageObject = new WebPageObject(this.driver);
        assertions = new WebMobileTestAssertions(pageObject);
    }

    public void setDTO(WebMobileTestDTO dto) {

        this.dto = dto;
    }

    public void goToGooglePage() {

        pageObject.getGooglePage().openGooglePage();
    }

    public void searchByKeyword() {

        pageObject.getGooglePage().searchByKeyword(dto.getSearchKeyword());
    }

    public void verifyRelevanceOfResults() {

        assertions.verifyRelevantResults();
    }
}
