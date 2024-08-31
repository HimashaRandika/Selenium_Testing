import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenGoogleTest {
    @Test
    public void OpenGoogletest() {
        // Set the path to the ChromeDriver executable if needed
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        // Locate the Google search input field and type 'Colombo'
        driver.findElement(By.name("q")).sendKeys("Colombo" + Keys.ENTER);
        // Optionally submit the form by hitting Enter
//        driver.findElement(By.name("q")).submit();

        // Close the browser
//        driver.quit();
    }
}
