import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;


public class WebDriverQuiz {
    WebDriver driver;
    WebElement element;
    WebElement element2;

    String link = "https://www.facebook.com/messages/*exampleLink*";

    @Test
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);driver.get(link);
        driver.findElement(By.xpath("//button[text()='Accept All']")).click();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='_5jb4']//input[@id='email']")).sendKeys("0735244406");
        driver.findElement(By.xpath("//div[@class='_5jb5']//input[@id='pass']")).sendKeys("PlaceholderPassword");
        driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
        Thread.sleep(3000);
        for(int i=1;i<=4;i++) {
            element = driver.findElement(By.xpath("//div[@class='_1mf _1mj']"));
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            driver.findElement(By.xpath("//div[@class='oajrlxb2 gs1a9yip g5ia77u1 mtkw9kbi tlpljxtp qensuy8j ppp5ayq2 goun2846 ccm00jje s44p3ltw mk2mc5f4 rt8b4zig n8ej3o3l agehan2d sk4xxmp2 rq0escxv nhd2j8a9 pq6dq46d mg4g778l btwxx1t3 pfnyh3mw p7hjln8o kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x tgvbjcpo hpfvmrgz cxgpxx05 dflh9lhu sj5x9vvc scb9dxdr l9j0dhe7 i1ao9s8h esuyzwwr f1sip0of du4w35lb lzcic4wl abiwlrkh p8dawk7l']//*[@class='a8c37x1j ms05siws hr662l2t b7h9ocf4']")).click();
            Thread.sleep(500);
            WebElement temp = driver.findElement(By.cssSelector("img[src='https://static.xx.fbcdn.net/images/emoji.php/v9/t98/1/28/1f917.png']"));
            wait.until(ExpectedConditions.elementToBeClickable(temp));
            temp.click();
            element.click();
            element.sendKeys(Keys.ENTER);

        }

        }
    }