import org.openqa.selenium.*;

public class AccountSettingsPage extends PageBase {
    private By editProfileButtonLocator = By.xpath("//a[contains(text(),'Edit profile')]");
    private By bioTextAreaLocator = By.xpath("//textarea[@name='bio']");
    private By saveBioButtonLocator = By.xpath("//div[contains(text(),'Save Description')]");


    public AccountSettingsPage(WebDriver driver)
    {
        super(driver);
        waitAndReturnElement(bodyLocator);
    }

    public void openEditProfile()
    {
        WebElement editProfileButton = waitAndReturnElement(editProfileButtonLocator);
		editProfileButton.click();
    }

    public void editBio(String text)
    {
        WebElement bioTextArea = waitAndReturnElement(bioTextAreaLocator);
        bioTextArea.clear();
		bioTextArea.click();
        bioTextArea.sendKeys(text);
        WebElement saveBioButton = waitAndReturnElement(saveBioButtonLocator);
        saveBioButton.click();
    }

    public String checkBio()
    {
        WebElement bioTextArea = waitAndReturnElement(bioTextAreaLocator);
        return bioTextArea.getAttribute("value");
    }
}