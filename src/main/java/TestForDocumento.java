import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestForDocumento {
    public static void main(String[] args) {

        // Before you start you have to specify the path of the WebDriver
        // you will use for the tests.
        /*System.setProperty("webdriver.gecko.driver", "C:/Users/Carlos_ADM/AppData/Roaming/npm/node_modules/geckodriver/geckodriver.exe");
        System.setProperty("webdriver.ie.driver","C:/Users/Carlos_ADM/AppData/Roaming/npm/node_modules/iedriver/lib/iedriver/IEDriverServer.exe");*/
        System.setProperty("webdriver.chrome.driver","C:/Users/Carlos_ADM/AppData/Roaming/npm/node_modules/chromedriver/lib/chromedriver/chromedriver.exe");

        // You can specify options for the browser you will execute the tests.
        ChromeOptions options = new ChromeOptions();

        // This options allows you to run the tests without seeing the browser.
        /*options.addArguments("--headless");*/

        // Create an new instance of th ChromeDriver
        // Notice that the remainder of the code relies on the interface
        // not the implementation.
        WebDriver driver = new ChromeDriver(options);

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com")

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // NOw submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the tittle of the page
        System.out.println("Page title is: " + driver.getTitle());

        //Google's search is rendered dynamically with JavaScript.
        //Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
