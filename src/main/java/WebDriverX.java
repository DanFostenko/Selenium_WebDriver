import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
//template
public class WebDriverX {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //неявное ожидание элементов до их появления
        driver.manage().window().maximize(); //управление размером окна, максимальное

        driver.quit(); //завершение работы драйвера
    }
}
