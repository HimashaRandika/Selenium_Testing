import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {
    WebDriver driver;

    @BeforeMethod
    public void LinkTestsPge() {
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800,600);
        driver.manage().window().setSize(newSize);
//        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonTest() {
        // 1) Click and confirm title
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectantTitle = "Dashboard";
        String actualTitle = driver.getTitle();

//        if (expectantTitle.equals(actualTitle)) {
//            System.out.println("Actual Title same as expectant");
//        } else {
//            System.out.println("Actual title not same as expectant");
//        }

        Assert.assertEquals(actualTitle, expectantTitle, "Title mismatched");

        driver.navigate().back();

        // 2) Get the position of a button
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("X position is : " + x + " Y position is: " + y);

        WebElement buttonColour = driver.findElement(By.id("j_idt88:j_idt96"));
       String color =buttonColour.getCssValue("background-color");
       System.out.println("Background Colr is :" + color);

       WebElement size =driver.findElement(By.id("j_idt88:j_idt98"));
       int height = size.getSize().getHeight();
       int width = size.getSize().getWidth();
       System.out.println("Height:" + height + "Width" + width );
    }
}
