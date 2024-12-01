import java.util.List;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.*;

public class PageBase {
	
	protected WebDriver driver;
	private WebDriverWait wait;
	
    protected By bodyLocator = By.tagName("body");
    protected By footerTextLocator = By.xpath("//footer/div/p");
    protected By homeButtonLocator = By.xpath("//div/a[@id='home_img_holder']");

    public PageBase(WebDriver driver)
    {
        this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
    }

    protected String readPageTitle()
    {
        return this.driver.getTitle();
    }

	protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    protected List<WebElement> waitAndReturnElements(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElements(locator);
    }

    public String getBodyText()
    {
        WebElement bodyElement = waitAndReturnElement(bodyLocator);
        return bodyElement.getText();
    }

    public String getFooterCopyrightText()
    {
        WebElement footerText = waitAndReturnElement(footerTextLocator);
        return footerText.getText();
    }

    public void goToHomePage()
    {
        WebElement homeButton = waitAndReturnElement(homeButtonLocator);
        homeButton.click();
    }
}