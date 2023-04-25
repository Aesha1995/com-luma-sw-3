package testsuite;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MenTest extends Utility {
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
    public void userShouldAddProductSuccessFullyToShoppinCart()
    {
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-5']"));
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        mouseHoverAndClickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        mouseHoverOnElement(By.xpath("//img[@alt='Cronus Yoga Pant ']"));
        mouseHoverAndClickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        mouseHoverOnElement(By.xpath("//img[@alt='Cronus Yoga Pant ']"));
        mouseHoverAndClickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        clickOnElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));
        String expectedMsg = "You added Cronus Yoga Pant to your shopping cart.";
        WebElement actualText = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        String actualMsg = actualText.getText();
        compareElements(expectedMsg,actualMsg);
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")).isDisplayed();
        String expectedTextMsg = "Shopping Cart";
        WebElement actualText1 = driver.findElement(By.xpath("//span[@class='base']"));
        String actualTextMsg = actualText1.getText();
        compareElements(expectedTextMsg,actualTextMsg);

        String expectedNameMsg = "Cronus Yoga Pant";
        WebElement actualText2 = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        String actualNameMsg = actualText2.getText();
        compareElements(expectedNameMsg,actualNameMsg);

        String expectedSizeMsg = "32";
        WebElement actualText3 = driver.findElement(By.xpath("//dd[contains(text(),'32')]"));
        String actualSizeMsg = actualText3.getText();
        compareElements(expectedSizeMsg,actualSizeMsg);

        String expectedColorMsg = "Black";
        WebElement actualText4 = driver.findElement(By.xpath("//dd[contains(text(),'Black')]"));
        String actualColorMsg = actualText4.getText();
        compareElements(expectedColorMsg,actualColorMsg);
    }
}
