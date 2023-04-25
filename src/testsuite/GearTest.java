package testsuite;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void openLink()
    {
        openBrowser(baseUrl);
    }
    @After
    public void closeLink()
    {
        //closeBrowser();
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart()
    {
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-6']//span[normalize-space()='Gear']"));
        mouseHoverAndClickOnElement(By.xpath("//span[normalize-space()='Bags']"));
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        String expectedMsg = "Overnight Duffle";
        WebElement actualText = driver.findElement(By.xpath("//span[@class='base']"));
        String actualMsg = actualText.getText();
        compareElements(expectedMsg,actualMsg);
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"),"3");
        clickOnElement(By.xpath("//span[normalize-space()='Add to Cart']"));

        String expectedMessageAdded = "You added Overnight Duffle to your shopping cart.";
        WebElement actualMessageAdded = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        String actualMessageAdded1 = actualMessageAdded.getText();
        compareElements(expectedMessageAdded,actualMessageAdded1);

        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        String expectedMessageBag = "Overnight Duffle";
        WebElement actualMessageBag = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        String actualMessageBag1 = actualMessageBag.getText();
        compareElements(expectedMessageBag,actualMessageBag1);

        WebElement element12 = driver.findElement(By.cssSelector(".input-text.qty"));
        String actualQty=  element12.getAttribute("value");
        String expectedQty= "3";
        compareElements(actualQty,expectedQty);


        String expectedMessagePrice = "$135.00";
        WebElement actualMessagePrice = driver.findElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"));
        String actualMessagePrice1 = actualMessagePrice.getText();
        compareElements(expectedMessagePrice,actualMessagePrice1);

        driver.findElement(By.cssSelector(".input-text.qty")).clear();
        sendTextToElement(By.cssSelector(".input-text.qty"),"5");
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));


        //  * Verify the product price ‘$225.00’

        String expectedPrice1= "$225.00";
        String actualPrice1=getTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']"));
        compareElements(expectedPrice1,actualPrice1);
    }
}
