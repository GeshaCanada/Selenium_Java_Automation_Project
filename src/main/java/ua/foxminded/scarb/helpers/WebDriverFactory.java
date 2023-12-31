   package ua.foxminded.scarb.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Properties;

// создаем WebDriver из файла .properties
public class WebDriverFactory {

    public static WebDriver create() {
        // Загрузка файла конфигурации
        Properties properties = ConfigLoader.loadConfig("src/config.properties");
        // Получение значения браузера из файла конфигурации
        String browser = properties.getProperty("browser");
        // Инициализация браузера в зависимости от значения
        if ("chrome".equalsIgnoreCase(browser)) {
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            return new FirefoxDriver();
        } else if ("edge".equalsIgnoreCase(browser)) {
            return new EdgeDriver();
        } else {
            throw new NotSupportedBrowserException("This " + browser + " is not supported. Please use one of the list: chrome, firefox or edge");
        }
    }
}
