import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {
    WebDriver driver;

    @BeforeMethod
    public void LinkTestsPge(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public void textBoxTests(){
        //Type your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Himasha Randika");

        //Append country to this City
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("India");
        //Verify if text box is disable
        boolean enabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is text box enabled" + enabled);

        //Clear the typed text.
        //*[@id="j_idt88:j_idt95"]
        WebElement clearText= driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElement.getAttribute("value");
        System.out.println(value);

        //Type email and Tab. Confirm control moved to next element And Confirm control moved to next element
        WebElement email = driver.findElement(By.id("j_idt88:j_idt99"));
        email.sendKeys("himasharandika4@gmail.com" + Keys.TAB + "Confirm control moved to next element");
    }
}
