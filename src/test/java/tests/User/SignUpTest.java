package tests.User;

import base.BaseTest;
import data.ExcelUtils;
import db.DBUtils;
import org.junit.jupiter.api.Tag;
import org.junit.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SignUpTest extends BaseTest {


    @Test
    @Tag("Login")
    public void testLoginWithExcel() throws Exception {

        testUserLoginWithExcel();
        testUserLogout();

        }

    @Test
    @Tag("Login")
    public void testUserLoginHardCode() throws Exception {
        driver.findElement(By.xpath("/html/body/ul/li[3]/a")).click();

            driver.findElement(By.name("phone")).sendKeys("123");
            driver.findElement(By.name("password")).sendKeys("1234");
            driver.findElement(By.cssSelector(".button")).click();
            testUserLogout();
        }



    }





