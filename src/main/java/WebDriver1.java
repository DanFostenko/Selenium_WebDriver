import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//browser init
public class WebDriver1 {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        WebDriver ffdriver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        driver.manage().window().maximize(); //управление размером окна, максимальное
        driver.manage().window().setSize(new Dimension(900,900));

        driver.get("https://www.google.com.ua");
        driver.navigate().to("https://www.seleniumhq.org"); //альтернативный метод

        ffdriver.quit();
        driver.quit(); //завершение работы драйвера
    }
}
