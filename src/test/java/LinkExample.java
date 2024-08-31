import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void LinkTestsPge(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }


    @Test
    public void LinkTests(){

        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();


        WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL without clicking me."));
        String path = wheretoGo.getAttribute("href");
        System.out.println("This link is going to: " +  path);

        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if (title.contains("404")){
            System.out.println("The link is broken");
        }
        else{
                System.out.println("Not Broken");
        }

        driver.navigate().back();


        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();


        List<WebElement> countFillPagesLinks = driver.findElements(By.tagName("a"));
        int pageLinkCount =  countFillPagesLinks.size();
        System.out.println("Count of full page links: "+  pageLinkCount ) ;

        WebElement layOutElements =  driver.findElement(By.className("layout-main-content"));
        List<WebElement> countLayOutsLinks =layOutElements.findElements(By.tagName("a"));

        System.out.println("Count of layOut links: "+  countLayOutsLinks.size() ) ;


    }
}
