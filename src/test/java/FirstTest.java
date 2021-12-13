import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");
    }

    @Test
    public void firstTest() throws InterruptedException {
        WebElement batton = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[14]/a"));
        batton.click();
        WebElement batton1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[2]"));
        batton1.click();
        WebElement batton2 = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        batton2.click();
        //Thread.sleep(1000);
       WebDriverWait wait = new WebDriverWait(driver,10);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='finish']")));
        WebElement text = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertEquals(text.getText(), "Hello World!");
    }
    @Test
    public void secondTest() throws InterruptedException {
        WebElement batton = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[18]/a"));
        batton.click();
        WebElement button2 = driver.findElement(By.xpath("//input[@id='file-upload']"));
        //button2.click();
        button2.sendKeys("C:\\Users\\st.ITSTEP\\Downloads\\chromedriver.exe");
        driver.findElement(By.xpath("//*[@id=\"file-submit\"]")).click();

    }




}