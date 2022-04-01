import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriverInstance(){
        String type = BasePage.getData("browserType");
        if(driver == null) {
            if (type.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
                driver = new ChromeDriver();
            } else if (type.equals("Edge")) {
                System.setProperty("webdriver.edge.driver", Constants.EDGEDRIVER_PATH);
                driver = new EdgeDriver();
            }
        }
        return driver;
    }
}
