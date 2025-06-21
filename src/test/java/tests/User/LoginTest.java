package tests.User;
import base.BaseTest;
import data.ExcelUtils;
import db.DBUtils;
import org.junit.jupiter.api.Tag;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class LoginTest extends BaseTest {


    @Test
    @Tag("Login")
    public void testLoginWithExcel() throws Exception {

        testUserLoginWithExcel();
        testUserLogout();

    }

    @Test(groups = {"smoke", "user"})
    @Tag("LoginTest")
    public void testUserLoginHardCode() throws Exception {
        driver.findElement(By.xpath("/html/body/ul/li[3]/a")).click();

        driver.findElement(By.name("phone")).sendKeys("123");
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".button")).click();
        testUserLogout();
    }

    @Test
    @Tag("TC_01 Verify sign-up with valid credentials")
    public void VerifySignUpWithValidCredentials() throws Exception {

        List<String[]> users = ExcelUtils.readData("src/test/resources/TestData.xlsx", "CreateUsers");
        for (String[] user : users) {
            String Name = user[0];
            String Phone = user[1];
            String Password = user[2];
            String Email  = user[3];
            String ID = user[4];

            //testUserLoginWithExcel();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
          // driver.findElement(By.xpath("/html/body/ul/li[3]/a")).click(); //Click on the UserLogin
            driver.findElement(By.cssSelector("a[href='user_login.php']")).click();


            driver.findElement(By.xpath("/html/body/div/table/tbody/tr[4]/td[1]/button/a")).click(); //Click on the Sign Up
            driver.findElement(By.name("name")).sendKeys(Name);
            driver.findElement(By.name("phone")).sendKeys(Phone);
            driver.findElement(By.name("password")).sendKeys(Password);
            driver.findElement(By.name("email")).sendKeys(Email);
            driver.findElement(By.name("idproof")).sendKeys(ID);
            //driver.findElement(By.name("dob")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
           // driver.findElement(By.name("dob")).sendKeys("15/08/1995");
            driver.findElement(By.name("dob")).clear(); // optional, clears existing text
            driver.findElement(By.name("dob")).sendKeys("15/08/1995");


            driver.findElement(By.xpath("/html/body/div[1]/form/table/tbody/tr[9]/td/input")).click();

           // testUserLogout();
        }
    }



}