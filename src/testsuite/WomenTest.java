package testsuite;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void openLink()
    {
        openBrowser(baseUrl);
    }
    @After
    public void closeLink()
    {
        closeBrowser();
    }
    @Test
    public void verifyTheSortByProductNameFilter()
    {
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
        mouseHoverAndClickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        List<WebElement> positionList = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        List<String> List = new ArrayList<>();
        for (WebElement list : positionList)
        {
            List.add(String.valueOf(list.getText()));
        }
        selectDropDownElements(By.xpath("//div[2]//div[3]//select[1]"),"Product Name");
        List<WebElement> productName = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        List<String> List1 = new ArrayList<>();
        for (WebElement list1:productName)
        {
            List1.add(String.valueOf(list1.getText()));
        }
        Collections.sort(List);

        compareElements(List.toString(),List1.toString());
    }
    @Test
    public void verifyTheSortByPriceFilter()
    {
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
        mouseHoverAndClickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        List<WebElement> positionList = driver.findElements(By.xpath("//div[@class='price-box price-final_price']//span[@class = 'price']"));
        List<String> List = new ArrayList<>();
        for (WebElement list : positionList)
        {
            List.add(String.valueOf(list.getText()));
        }
        selectDropDownElements(By.xpath("//div[2]//div[3]//select[1]"),"Price");
        //clickOnElement(By.xpath("//div[@class='column main']//div[2]//div[3]//a[1]"));
        List<WebElement> productName = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));
        List<String> List1 = new ArrayList<>();
        for (WebElement list1:productName)
        {
            List1.add(String.valueOf(list1.getText()));
        }
        Collections.sort(List);

        compareElements(List.toString(),List1.toString());
    }
}
