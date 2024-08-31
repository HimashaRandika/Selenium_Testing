import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExamples {
    WebDriver driver;

    @BeforeMethod
    public void dropDownTestPage() {
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800,600);
        driver.manage().window().setSize(newSize);
//        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml");
    }

    @Test
    public void leafgroundDropDownTest() {

        driver.get("https://www.leafground.com/select.xhtml");
        //1.1) ways of select values in Basic dropdown
        try {
            // 1.1) ways of select values in Basic dropdown

            WebElement dropDown = driver.findElement(By.xpath("//select[@class = 'ui-selectonemenu']"));
            Select select = new Select(dropDown);
            select.selectByIndex(1);
            Thread.sleep(3000);
            select.selectByVisibleText("Playwright");
            Thread.sleep(3000);

            //  1.2) get the number of dropdown
            //generics
            List<WebElement> listOfOptions = select.getOptions();
            int size= listOfOptions.size();
            System.out.println("Number of:" + size);

            for(WebElement element: listOfOptions){
                System.out.println(element.getText());
            }

            dropDown.sendKeys(" Puppeteer");

            WebElement dropDown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
            dropDown2.click();
            List<WebElement> listOfDropDown2Values = driver.findElements(By.xpath("(//ul[@id='j_idt87:country_items'])/li"));
            for(WebElement element: listOfDropDown2Values){
                String dropDownValue = element.getText();
                if(dropDownValue.equals("USA")){
                    element.click();
                    break;
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }

    @Test

    public void googleDropDown() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(3000);
        List<WebElement> googlesearchList = driver.findElements(By.xpath("//ul[@role = 'listbox']/li//div[@class='wM6W7d']"));
        System.out.println(googlesearchList.size());
        for (WebElement element:googlesearchList){
            System.out.println(element.getText());
        }

    }

    //Handle Hidden Auto Suggetions Drop Down and Search using DOM Debugger Trick


}




