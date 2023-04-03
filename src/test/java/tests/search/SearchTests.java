package tests.search;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;
import webui.components.HeaderComponent;
import webui.components.SearchComponent;
import webui.pages.AccessoriesPage;

import java.util.List;

public class SearchTests extends BaseTest {
    HeaderComponent header;
    SearchComponent search;
    String searchingValue;

    @BeforeMethod
    public void setupData(){
        header = new HeaderComponent(driver);
        search = new SearchComponent(driver);
        searchingValue = "mug";
    }

    @Test(testName = "Verifying the Search option - selecting element from the list.", description = "Behavior = Positive")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-26")
    @Parameters("browser: chrome")
    public void searchLists() {
        List<String> listsOfElements = search.getAllElementsFromSearchList(searchingValue);

        int elementNumber = 1;
        search.selectElementFromSearchList(elementNumber);

        Assert.assertEquals(listsOfElements.get(elementNumber), header.getPageTitle());
    }

    @Test(testName = "Verifying the Search option by pressing Enter.")
    @Description("Search.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-27")
    @Parameters("browser: chrome")
    public void searchValue() {
        search.searchElementByPressingOnEnter(searchingValue);

        String title = header.getPageTitle();
        Assert.assertEquals(title, "Search");
    }


}
