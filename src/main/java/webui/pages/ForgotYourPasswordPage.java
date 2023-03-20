package webui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ForgotYourPasswordPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "send-reset-link")
    private WebElement sendResetLinkButton;

    @FindBy(className = "item")
    private WebElement alertResetYourPassword;

    public ForgotYourPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Insert an email to the email field.")
    public void insertEmail(String email) {
        emailField.sendKeys(email);
    }

    @Step("Click on the Send reset link button.")
    public void clickOnSendResetLinkButton() {
        sendResetLinkButton.click();
    }

    @Step("Get Reset Your Password alert text.")
    public String getResetYourPasswordAlertText() {
        return alertResetYourPassword.getText();
    }
}