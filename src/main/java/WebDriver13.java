import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
//run tests in different browsers, run tests without browser launch
public class WebDriver13 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe"); //https://www.seleniumhq.org/download
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        //System.setProperty("phantomjs.binary.path", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\phantomjs.exe"); //http://phantomjs.org/download.html
        System.setProperty("chrome.verbose", "true"); //headless  Chrome

        WebDriver driver = new ChromeDriver();
        WebDriver ffdriver = new FirefoxDriver();
        //WebDriver phDriver = new PhantomJSDriver(); // PhantomJSDriver больше не поддерживается
        WebDriver hdlDriver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //неявное ожидание элементов до их появления
        driver.manage().window().maximize(); //управление размером окна, максимальное

        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        ffdriver.get("https://en.wikipedia.org/wiki/Main_Page");
        hdlDriver.get("https://en.wikipedia.org/wiki/Main_Page");

        driver.quit(); //завершение работы Chrome-драйвера
        ffdriver.quit(); //завершение работы Firefox-драйвера
        hdlDriver.quit(); //завершение работы headless Chrome-драйвера
    }
}
