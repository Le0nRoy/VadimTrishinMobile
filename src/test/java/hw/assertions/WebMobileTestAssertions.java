package hw.assertions;

import org.testng.Assert;
import pageObjects.WebPageObject;

import java.util.List;

public class WebMobileTestAssertions {

    WebPageObject pageObject;

    public WebMobileTestAssertions(WebPageObject pageObject) {

        this.pageObject = pageObject;
    }

    public void verifyRelevantResults() {

        List<String> actual = pageObject.getGooglePage().getSearchResults();
        Assert.assertTrue(
                (actual.size() > 0),
                "Check that some search results exist.");
    }
}
