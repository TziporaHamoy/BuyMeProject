import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class MainTest {
    private static ExtentReports extent;
    private static ExtentTest test;
    String timeNow = String.valueOf(System.currentTimeMillis());

    @BeforeClass
    public void beforeAll() throws Exception {
        String url = BasePage.getData("URL");
        DriverSingleton.getDriverInstance().get(url);
        DriverSingleton.getDriverInstance().manage().window().maximize();
        DriverSingleton.getDriverInstance().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        DriverSingleton.getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String cwd = System.getProperty("user.dir");

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html" + (dateFormat.format(date)));

        extent= new ExtentReports();
        extent.attachReporter(htmlReporter);
        test=extent.createTest("Second Project", "Sample description");
        //ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C://Users//extent.html");
        //test.log(Status.INFO, "before test method");
      /*  try {
            //DriverSingleton.getDriverInstance().get("https://buyme.co.il/");

            test.pass("Driver established successfully");
        }catch (Exception e){
            e.printStackTrace();
            test.fail("Driver connection failed! " + e.getMessage());
            throw new Exception("Driver failed");
        }*/
    }
   @Test
    public void test01_assertionURL(){
        try {
            String byMeUrl= "https://buyme.co.il/";
            Assert.assertEquals(byMeUrl,DriverSingleton.getDriverInstance().getCurrentUrl());
           // test.pass("Assertion was successful");
        } catch (Exception e){
            e.printStackTrace();
            test.fail("Assertion failed"+e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(BasePage.takeScreenShot(timeNow)).build());
        }
    }
    @Test
    public void test02_login(){
        try{
            LoginPage loginPage = new LoginPage();
            loginPage.login();
            test.pass("Registration was successful");
        } catch (Exception e){
            e.printStackTrace();
            test.fail("Registration failed"+e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(BasePage.takeScreenShot(timeNow)).build());
        }
    }
    @Test
    public void test03_homeScreen(){
        try {
            HomeScreen homeScreenPage= new HomeScreen();
            homeScreenPage.homeScreen();
            test.pass("Selection gift details was successful ");
        } catch (Exception e){
            e.printStackTrace();
            test.fail("Selection gift details failed"+e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(BasePage.takeScreenShot(timeNow)).build());
        }
    }
    @Test
    public void test04_assertionURLScreen3() {
        try {
            String byMeeURL3="https://buyme.co.il/search?budget=1&category=359&region=13";
            Assert.assertEquals(byMeeURL3, DriverSingleton.getDriverInstance().getCurrentUrl());
            test.pass("Assert URL was successful");
        } catch (Exception e){
            e.printStackTrace();
            test.fail("Assert URL failed"+e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(BasePage.takeScreenShot(timeNow)).build());
        }
    }
    @Test
    public void test05_pickBusiness() {
        try {
            PickBusiness pickBusinessPage = new PickBusiness();
            pickBusinessPage.pickBusiness();
            test.pass("Pick business was successful");
        } catch (Exception e){
            e.printStackTrace();
            test.fail("Pick business failed"+e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(BasePage.takeScreenShot(timeNow)).build());
        }
    }
    @Test
    public void test_06_receivedInformation() throws InterruptedException {
        try {
            ReceivedInformation receivedInformationPage = new ReceivedInformation();
            receivedInformationPage.receivedInformation();
            test.pass("Sender And Receiver Information was successful");
        } catch (Exception e){
            e.printStackTrace();
            test.fail("Sender And Receiver Information failed "+e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(BasePage.takeScreenShot(timeNow)).build());
        }
    }
    @Test
    public void test_07_sendInformation() {
        try {
            SendInformation sendInformationPage= new SendInformation();
            sendInformationPage.sendInformation();
            test.pass("Information for payment was successful");
        } catch (Exception e){
            e.printStackTrace();
            test.fail("Information for payment failed"+e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(BasePage.takeScreenShot(timeNow)).build());
        }
    }
    @AfterClass
    public static void afterClass() {
        test.log(Status.INFO, "@After test " + "After test method");
        // DriverSingleton.getDriverInstance().quit();
        // build and flush report
        extent.flush();
    }
}
