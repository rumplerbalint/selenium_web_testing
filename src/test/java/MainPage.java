import org.openqa.selenium.*;

public class MainPage extends PageBase {
    private By loginButtonLocator = By.xpath("//a//ancestor::span[contains(text(),'Sign In')]");
	private By signInButtonLocator = By.xpath("//a/span[contains(text(),'Sign in with IMDb')]");
    private By profileButtonLocator = By.xpath("//nav[@id='imdbHeader']/div[2]/div[5]/div/label[2]");
    private By logoutButtonLocator = By.xpath("//nav[@id='imdbHeader']/div[2]/div[5]/div/div/div/span/ul/a[6]");
    private By newTrailersButtonLocator = By.xpath("//a[contains(text(),'Browse trailers')]");
    private By userSettingsButtonLocator = By.xpath("//a[@href='/registration/accountsettings?ref_=nv_usr_pers_1']");
    private By searchBarLocator = By.xpath("//*[@id='suggestion-search']");

    public MainPage(WebDriver driver)
    {
        super(driver);
        this.driver.get("https://www.imdb.com/");
    }

    public void openLoginPage()
    {
        WebElement loginButton = waitAndReturnElement(loginButtonLocator);
		loginButton.click();
        WebElement signInButton = waitAndReturnElement(signInButtonLocator);
		signInButton.click();
    }

    public void logout()
    {
        WebElement profileButton = waitAndReturnElement(profileButtonLocator);
        profileButton.click();
        WebElement logoutButton = waitAndReturnElement(logoutButtonLocator);
        logoutButton.click();
    }

    public String getLoginInButtonText()
    {
        WebElement loginButton = waitAndReturnElement(loginButtonLocator);
        return loginButton.getText();
    }

    public String getLoggedInUsername()
    {
        WebElement profileButton = waitAndReturnElement(profileButtonLocator);
		return profileButton.getText();
    }

    public void openNewTrailersPage()
    {
        WebElement newTrailersButton = waitAndReturnElement(newTrailersButtonLocator);
        newTrailersButton.click();
    }

    public void openUserSettings()
    {
        WebElement profileButton = waitAndReturnElement(profileButtonLocator);
        profileButton.click();
        WebElement userSettingsButton = waitAndReturnElement(userSettingsButtonLocator);
        userSettingsButton.click();
    }

    public String readSearchBarPlaceholder()
    {
        WebElement searchBar = waitAndReturnElement(searchBarLocator);
        return searchBar.getAttribute("placeholder");
    }
}