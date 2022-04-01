import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomeScreen extends BasePage {
    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(20));

    public void homeScreen() {
        price();
        region();
        category();
        findPresentToMe();
    }
    //סכום
    private void price() {
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(By.cssSelector("span[alt=סכום]"))));
        clickElement(By.cssSelector("span[alt=סכום]"));
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(By.id("ember1064"))));
        clickElement(By.id("ember1064"));
    }
    //אזור
    private void region() {
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(By.cssSelector("span[alt=אזור]"))));
        clickElement(By.cssSelector("span[alt=אזור]"));
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(By.id("ember1099"))));
        clickElement(By.id("ember1099"));
    }
    //קטגוריה
    private void category() {
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(By.cssSelector("span[alt=קטגוריה]"))));
        clickElement(By.cssSelector("span[alt=קטגוריה]"));
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(By.id("ember1160"))));
        clickElement(By.id("ember1160"));
    }
    //תמצאו לי מתנה
    private void findPresentToMe() {
        clickElement((By.linkText("תמצאו לי מתנה")));
    }
}
