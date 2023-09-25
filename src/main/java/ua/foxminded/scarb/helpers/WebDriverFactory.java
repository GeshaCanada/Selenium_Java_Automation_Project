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

    static public WebDriver create() throws  NotSupportedBrowserException {
        // Загрузка файла конфигурации
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;

        try {
            // Попытка открыть файл
            fileInputStream = new FileInputStream("src/config.properties");
            properties.load(fileInputStream);

            // Код для работы с properties

        } catch (IOException e) {
            // Обработка исключения ввода/вывода
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                // Обработка исключения, если не удалось закрыть поток
                e.printStackTrace();
            }
        }
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
