package ua.foxminded.scarb.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// создаем WebDriver из файла .properties
public class WebDriverFactory {

    static public WebDriver create() throws IOException {
        // Загрузка файла конфигурации
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/config.properties");
        properties.load(fileInputStream);
        fileInputStream.close();

        // Получение значения браузера из файла конфигурации
        String browser = properties.getProperty("browser");

        // Инициализация браузера в зависимости от значения
        if ("chrome".equalsIgnoreCase(browser)) {
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            return new FirefoxDriver();
        } else if ("edge".equalsIgnoreCase(browser)) {
            return new EdgeDriver();
        }
        System.out.println("Неподдерживаемый браузер: " + browser);
        System.exit(1); // Завершаем выполнение программы при неподдерживаемом браузере
        return null;
    }
}
