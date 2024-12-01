import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.*;

public class SeleniumTest {
	private EnvParser envParser = new EnvParser();
	private String email = envParser.getEnvVar("USER_EMAIL");
	private String username = envParser.getEnvVar("USERNAME");
	private String password = envParser.getEnvVar("USER_PASSWORD");

	private WebDriver driver;
	private String driverPath = envParser.getEnvVar("DRIVER_PATH");
	
    @Before
    public void setup() throws MalformedURLException
    {
		ChromeOptions options = new ChromeOptions();

		System.setProperty("webdriver.chrome.driver", driverPath);
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
    }

	@Test
    public void testSelenium() {
		MainPage mainPage = new MainPage(this.driver);
		LoginPage loginPage = new LoginPage(this.driver);
		NewTrailersPage newTrailersPage = new NewTrailersPage(this.driver);
		AccountSettingsPage accountSettingsPage = new AccountSettingsPage(this.driver);

		//Reading the page title
		System.out.println(mainPage.readPageTitle());
		assertTrue(mainPage.readPageTitle().equals("IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows"));

		assertTrue(mainPage.readSearchBarPlaceholder().equals("Search IMDb"));

		//Static page test
		mainPage.openNewTrailersPage();
		assertTrue(newTrailersPage.checkTitle().equals("Watch New Movie & TV Trailers"));
		assertTrue(newTrailersPage.countTrailers() >= 6);
		assertTrue(newTrailersPage.getFooterCopyrightText().contains("by IMDb.com, Inc."));
		
		//Login test
		mainPage.openLoginPage();
		loginPage.login(email, password);
		assertTrue(mainPage.getLoggedInUsername().equals(username));

		//Form sending with user
		mainPage.openUserSettings();
		accountSettingsPage.openEditProfile();
		accountSettingsPage.editBio("something interesting");
		accountSettingsPage.openEditProfile();
		assertTrue(accountSettingsPage.checkBio().equals("something interesting"));
		accountSettingsPage.goToHomePage();

		//Logout test
		mainPage.logout();
		assertTrue(mainPage.getLoginInButtonText().equals("Sign In"));
	}

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}