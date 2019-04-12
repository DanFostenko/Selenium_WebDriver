import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//explicit wait
public class WebDriver7 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //управление размером окна, максимальное
        driver.get("https://en.wikipedia.org/wiki/Special:Contributions");
        WebDriverWait wait = (new WebDriverWait(driver, 5)); //явное - ожидание элементов до их появления, которое используется 1 раз
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='mw-wiki-logo']")));
        driver.findElement(By.xpath("//select[@class='namespaceselector']")).click(); //клик на имя, кот. вызывает список
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//select[@id='namespace']/option[3]")))); //ожидание видимости элемента
        driver.findElement(By.xpath("//select[@id='namespace']/option[3]")).click();
        driver.findElement(By.xpath("//select[@class='namespaceselector']")).click(); //клик на любое имя, кот. отзовет список
 //     wait.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath("//select[@id='namespace']/option[4]")))); //ожидание невидимости элемента
        driver.quit(); //завершение работы драйвера


    }
}
