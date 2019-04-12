import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
//work with browser tabs and windows
public class WebDriver10 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //неявное ожидание элементов до их появления
        driver.manage().window().maximize(); //управление размером окна, максимальное

//work with browser tabs
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        String mainTab = driver.getWindowHandle(); //запомнить имя открытой вкладки
        ((JavascriptExecutor)driver).executeScript("window.open()"); //открыть новую вкладку

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        driver.get("https://en.wikipedia.org/wiki/Wikipedia:About");
        driver.findElement(By.xpath("//a[text()='Talk']/parent::span")).click(); //кликнуть по однозначному имени

        driver.switchTo().window(mainTab); //переключиться обратно на первую вкладку
        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Selenium WebDriver");

//        driver.close(); //закрыть вкладку

//work with browser windows
        driver.get("https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html");
        String mainWindow = driver.getWindowHandle(); //запомнить имя открытого окна
        driver.findElement(By.xpath("//a[text()='Oracle Technology Network License Agreement for Oracle Java SE']")).click(); //?новое окно почему-то не открывается

        for (String windowHandle : driver.getWindowHandles()) { //windowHandle возращает все окна, getWindowHandles() возвращает имя окна
            driver.switchTo().window(windowHandle); //переключиться на последнее открытое окно
        }

        driver.findElement(By.xpath("//a[text()='Terms']")).click();
        driver.switchTo().window(mainWindow); //переключиться обратно на первое окно
        driver.findElement(By.xpath("//span[text()='Overview']/parent::a")).click();

        driver.quit(); //завершение работы драйвера
    }
}
