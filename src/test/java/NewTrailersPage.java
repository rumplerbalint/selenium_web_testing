import java.util.List;

import org.openqa.selenium.*;

public class NewTrailersPage extends PageBase {

    private By titleLocator = By.xpath("//h1");
    private By trailersLocator = By.xpath("//main/div/section/div/*");

    public NewTrailersPage(WebDriver driver)
    {
        super(driver);
        waitAndReturnElement(bodyLocator);
    }

    public String checkTitle()
    {
        WebElement title = waitAndReturnElement(titleLocator);
		return title.getText();
    }

    public int countTrailers()
    {
        List<WebElement> trailers = waitAndReturnElements(trailersLocator);
        return trailers.size();
    }
}
