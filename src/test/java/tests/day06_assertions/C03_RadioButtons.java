package tests.day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButtons {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
    @Test
    public void yazidanSecmeTesti(){//yazidan
        // a. Verilen web sayfasına gidin https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // b. Cinsiyet Radio button elementlerini locate edin
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));


        // c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
        WebElement erkekRadioYaziElementi = driver.findElement(By.xpath("//*[@for='inlineRadio2']"));
        erkekRadioYaziElementi.click();


        // d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(erkekRadioButton.isSelected());  //secili
        Assert.assertFalse(kadinRadioButton.isSelected()); //secili degil
        Assert.assertFalse(digerRadioButton.isSelected()); //secili degil
    }

    @Test
    public void butondanSecmeTesti(){//butondan
        // a. Verilen web sayfasına gidin https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // b. Cinsiyet Radio button elementlerini locate edin
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));


        // radioButtonu kullanarak erkek radio butonu secelim

        erkekRadioButton.click();

        // erkek radiobutton'un secili oldugunu test edelim
        Assert.assertTrue(erkekRadioButton.isSelected());

        // kadin ve diger radioButton'larinin secili olmadigini test edelim

        Assert.assertFalse(kadinRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());
    }
}
