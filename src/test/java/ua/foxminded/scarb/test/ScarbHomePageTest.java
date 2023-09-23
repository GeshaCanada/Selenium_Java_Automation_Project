package ua.foxminded.scarb.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.foxminded.scarb.helpers.WebDriverFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ScarbHomePageTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws IOException {
         // просим WebDriverFactory создать driver
         driver = WebDriverFactory.create(); // Chrome работает а EDGE вызывает рандомную ошибку

        // Загрузка файла конфигурации (Вариант 2 без WebDriverFactory)
//        Properties properties = new Properties();
//        FileInputStream fileInputStream = new FileInputStream("src/config.properties");
//        properties.load(fileInputStream);
//        fileInputStream.close();
//
//        // Получение значения браузера из файла конфигурации
//        String browser = properties.getProperty("browser");
//
//        // Инициализация браузера в зависимости от значения
//        if ("chrome".equalsIgnoreCase(browser)) {
//            driver = new ChromeDriver();
//        } else if ("firefox".equalsIgnoreCase(browser)) {
//            driver = new FirefoxDriver();
//        } else if ("edge".equalsIgnoreCase(browser)) {
//            driver = new EdgeDriver();
//        } else {
//            System.out.println("Неподдерживаемый браузер: " + browser);
//            System.exit(1); // Завершаем выполнение программы при неподдерживаемом браузере
//        }
    }

    @Test
    public void getToHomePageTest() {
        driver.get("https://skarb.foxminded.ua");

        WebElement title = driver.findElement(By.cssSelector("h4.text-dark-red"));
        Assert.assertEquals(title.getText(), "SKARB NGO");
    }
    @Test
    public void getButtonTextTest() {
        driver.get("https://skarb.foxminded.ua");

        WebElement button = driver.findElement(By.cssSelector("button[name=tasks-button]"));
        Assert.assertEquals(button.getText(), "Смотреть задачи");
    }

    @Test
    public void taskButtonActionTest() {
        driver.get("https://skarb.foxminded.ua");

        WebElement button = driver.findElement(By.cssSelector("div.statistic button"));
        button.click();
        WebElement title = driver.findElement(By.cssSelector("h2"));
        Assert.assertEquals(title.getText(), "Поиск задач");
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
