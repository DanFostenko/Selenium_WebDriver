import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
//JavaScript execution, work with JS alerts
public class WebDriver9 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //неявное ожидание элементов до их появления
        driver.manage().window().maximize(); //управление размером окна, максимальное
//JavaScript execution
        JavascriptExecutor jse = (JavascriptExecutor)driver; // выполнять JavaScript с помощью переменной
//        jse.executeScript("alert('Hello World');");

        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        jse.executeScript("window.scrollBy(0, 1000)",""); //прокрутить страницу вниз с помощью JS
        jse.executeScript("window.scrollBy(0, -1000)",""); //прокрутить страницу вверх с помощью JS

//work with JS alerts
        driver.get("https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html");
        driver.findElement(By.xpath("//a[text() = 'jdk-11.0.2_windows-x64_bin.zip']")).click();

        try {
            Thread.sleep(3000); //ожидание на 3 сек
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().alert().accept(); //переключиться на alert и принять

        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("confirm('Are you sure?');");

        try {
            Thread.sleep(3000); //ожидание на 3 сек
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().alert().dismiss(); //переключиться на alert и отклонить

        driver.quit(); //завершение работы драйвера
    }
}
