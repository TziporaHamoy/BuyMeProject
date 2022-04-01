import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PickBusiness extends BasePage{
    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(10));
    public void pickBusiness(){
        selectBusiness();
        enterChoosePrice();
        press();
    }
    //בחר עסק
    private void selectBusiness() {
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/ul/div[4]/a/div"))));
        clickElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/ul/div[4]/a/div"));
    }
    //הכנס סכום
    private void enterChoosePrice() {
        //לשאול את שני
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=tel]"))).sendKeys("100");
    }
    //לחץ על בחירה
    private void press(){
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(By.className("money-btn"))));
        clickElement(By.className("money-btn"));
    }
}

