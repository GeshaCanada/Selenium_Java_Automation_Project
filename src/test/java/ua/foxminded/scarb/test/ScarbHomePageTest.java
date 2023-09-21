package ua.foxminded.scarb.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScarbHomePageTest {


        private WebDriver driver;

        @BeforeMethod
        public void setUp(){
            driver = new ChromeDriver();
            String baseUrl = "https://skarb.foxminded.ua/";
            driver.get(baseUrl);
        }

        @Test
        public void getToHomePageTest(){
            WebElement title = driver.findElement(By.cssSelector("h4.text-dark-red"));
            Assert.assertEquals(title.getText(), "SKARB NGO");
        }

        @AfterMethod(alwaysRun = true)
        public void tearDown(){
            if (driver!=null){
                driver.close();
                driver.quit();
            }
        }
    }

