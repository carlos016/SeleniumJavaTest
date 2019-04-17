import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestForDocumento {
    public static void main(String[] args) {
        //System.setProperty("webdriver.gecko.driver", "C:/Users/Carlos_ADM/AppData/Roaming/npm/node_modules/geckodriver/geckodriver.exe");
        //System.setProperty("webdriver.ie.driver","C:/Users/Carlos_ADM/AppData/Roaming/npm/node_modules/iedriver/lib/iedriver/IEDriverServer.exe");
        System.setProperty("webdriver.chrome.driver","C:/Users/Carlos_ADM/AppData/Roaming/npm/node_modules/chromedriver/lib/chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();

    }
}
