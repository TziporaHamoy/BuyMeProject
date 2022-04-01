import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage{

    public void login(){
        loginOrRegistration();
        registration();
        enterDetails();
        //existingCustomer();
    }
    private void loginOrRegistration(){
        clickElement(By.className("notSigned"));
    }
    private void registration(){
        clickElement(By.className("text-link"));
    }
    private void enterDetails(){
        //Name
        sendKeysToElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[1]/label/input"),Constants.name);
        String findName=DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[1]/label/input")).getAttribute("value");
        Assert.assertEquals(findName,Constants.name);
        //Email
        sendKeysToElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[2]/label/input"),Constants.email);
        String findEmail=DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[2]/label/input")).getAttribute("value");
        Assert.assertEquals(findEmail,Constants.email);
        //password
        sendKeysToElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[3]/label/input"),Constants.password);
        String findPassword=DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[3]/label/input")).getAttribute("value");
        Assert.assertEquals(findPassword,Constants.password);
        //validation password
        sendKeysToElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[4]/label/input"),Constants.password); //*[@id="ember1998"]
        String findValidationPassword= DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[4]/label/input")).getAttribute("value");
        Assert.assertEquals(findValidationPassword,Constants.password);
        //Buyme registration
        clickElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/button"));
    }


    /*private void existingCustomer(){
       WebElement mail= DriverSingleton.getDriverInstance().findElement(By.xpath("//*[@id=\"ember1768\"]"));
        mail.sendKeys("05271039391z@gmail.com");
        WebElement password= DriverSingleton.getDriverInstance().findElement(By.xpath("//*[@id=\"ember1775\"]"));
        password.sendKeys("Zmzm3973");
        DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[6]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/button")).click();
    }*/

}

