package base;

import config.Constants;
import data.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import io.github.bonigarcia.wdm.WebDriverManager;


import java.time.Duration;
import java.util.List;

public class BaseTest {
    protected WebDriver driver;

 @BeforeMethod
    public void loadUrlWithoutHead() {
        driver = new ChromeDriver();
        driver.get(Constants.BASE_URL);
        driver.manage().window().maximize();
    }


/*
@BeforeMethod
public void loadUrlWithHead(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless=new"); // or just "--headless"
    options.addArguments("--window-size=1920,1080");

    driver = new ChromeDriver(options);
    driver.get(Constants.BASE_URL);
}
*/


    // uncomment this when execute testcases using mvn
    /*
    @BeforeMethod
    public void setUp(Method m) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions();
        // Dynamically headless based on system property
        if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
            opts.addArguments("--headless=new", "--window-size=1920,1080");
        }
        driver = new ChromeDriver(opts);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Constants.BASE_URL);
    }

     */




    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    public void testUserLoginWithExcel() throws Exception {
        List<String[]> users = ExcelUtils.readData("src/test/resources/TestData.xlsx", "Users");

        for (String[] user : users) {
            String phone = user[1];
            String password = user[2];
            // String name = user[2];

           // driver.findElement(By.xpath("/html/body/ul/li[3]/a")).click();
            driver.findElement(By.name("phone")).sendKeys(phone);
            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.cssSelector(".button")).click();
        }

    }
    public void testUserLogout() throws Exception {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.findElement(By.xpath("/html/body/ul/li[6]/a")).click();

        }
}
