package tests.day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BestbuyAssertions {
 // https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
 // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
 // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
 // ○ logoTest => BestBuy logosunun görüntülendigini test edin
 // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    static WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");
    }
    @After
    public void teardown(){
        driver.quit();
    }
    @Test
    public void urlTesti(){
        // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/";
        String actuelUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actuelUrl);
    }
    @Test
    public  void titleTesti(){
        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String unexpectedIcerik = "Rest";
        String actuelTitle = driver.getTitle();

        Assert.assertFalse(actuelTitle.contains(unexpectedIcerik));
    }
    @Test
    public void logoTesti(){
        // ○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement lohgoElementi = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(lohgoElementi.isDisplayed());
    }
    @Test
    public void fransizcaLinkTesti(){
        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement linkElement = driver.findElement(By.xpath("//*[text()='Français']"));

        Assert.assertTrue(linkElement.isDisplayed());
    }
}
