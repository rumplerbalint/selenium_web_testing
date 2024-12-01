import org.openqa.selenium.*;

public class LoginPage  extends PageBase {
    private By emailFieldLocator = By.xpath("//div/input[@id='ap_email']");
    private By passwordFiledLocator = By.xpath("//div/input[@id='ap_password']");
    private By loginButtonLocator = By.xpath("//span/input[@id='signInSubmit']");

    public LoginPage(WebDriver driver)
    {
        super(driver);
        waitAndReturnElement(bodyLocator);
    }

    public void login(String email, String password)
    {
        WebElement emailField = waitAndReturnElement(emailFieldLocator);
		emailField.sendKeys(email);
        WebElement passwordField = waitAndReturnElement(passwordFiledLocator);
		passwordField.sendKeys(password);
        WebElement loginButton = waitAndReturnElement(loginButtonLocator);
        loginButton.click();
    }
    
}
