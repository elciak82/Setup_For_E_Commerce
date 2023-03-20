package webui.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.pages.*;

public class HeaderComponent extends BasePage {
    public HeaderComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "contact-link")
    WebElement contactUsLink;

    @FindBy(css = "[class='expand-more']")
    WebElement languageDropdown;

    @FindBy(css = "[class = 'expand-more _gray-darker']")
    WebElement currencyDropdown;

    @FindBy(css = "[class = 'logout hidden-sm-down']")
    WebElement signOut;

    @FindBy(className = "user-info")
    WebElement signIn;

    @FindBy(className = "account")
    WebElement account;

    @FindBy(id = "_desktop_cart")
    WebElement cart;

    @FindBy(id = "category-3")
    WebElement clothesLink;

    @FindBy(id = "category-6")
    WebElement accessoriesLink;

    @FindBy(id = "category-9")
    WebElement artLink;

    @FindBy(id = "category-4")
    WebElement menLink;

    @FindBy(id = "category-5")
    WebElement womenLink;

    @FindBy(css = "[class = 'account'] span[class = 'hidden-sm-down']")
    WebElement userFirstNameLastname;

    @FindBy (xpath = "//*[@id='search_widget']/form/input[2]")
    WebElement searchBy;

    @Step("Contact Us link click.")
    public ContactUsPage clickOnContactUsLink() {
        contactUsLink.click();
        return new ContactUsPage(driver);
    }

    @Step("Clothes link click.")
    public ClothesPage clickOnClothesLink() {
        clothesLink.click();
        return new ClothesPage(driver);
    }

    @Step("Accessories link click.")
    public AccessoriesPage clickOnAccessoriesLink() {
        accessoriesLink.click();
        return new AccessoriesPage(driver);
    }

    @Step("Art link click.")
    public ArtPage clickOnArtLink() {
        artLink.click();
        return new ArtPage(driver);
    }

    @Step("Men link click.")
    public MenPage clickOnMenLink() {
        mouseClickByLocator(clothesLink);
        menLink.click();
        return new MenPage(driver);
    }

    @Step("Women link click.")
    public WomenPage clickOnWomenLink() {
        mouseClickByLocator(clothesLink);
        womenLink.click();
        return new WomenPage(driver);
    }

    @Step("Sign In link click.")
    public LoginPage clickOnSignInLink() {
        signIn.click();
        return new LoginPage(driver);
    }

    @Step("Get user data from page header.")
    public String getUserFirstnameLastnameFromPage() {
        fluentWaitForElementDisplayed(userFirstNameLastname);
        return getTextFromWebElement(userFirstNameLastname);
    }

    public void clickOnSignOutButton(){
        signOut.click();
    }
}