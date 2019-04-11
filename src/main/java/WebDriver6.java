import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
//work with tables
public class WebDriver6 {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //неявное ожидание элементов до их появления
        driver.manage().window().maximize(); //управление размером окна, максимальное

        driver.get("https://www.w3schools.com/html/html_tables.asp");
        WebElement tableElement = driver.findElement(By.xpath("//table[@id='customers']"));
        //WebElement table = driver.findElement(By.xpath("//*[@id='customers']"));

        WebDriver6_1 table = new WebDriver6_1(tableElement, driver);
        System.out.println("Rows number is:" + table.getRows().size());
        System.out.println(table.getValueFromCell(2,3));
        System.out.println(table.getValueFromCell(4,1));
        System.out.println(table.getValueFromCell(2,"Company"));
        System.out.println(table.getValueFromCell(2,"Country"));
        System.out.println(table.getValueFromCell(2,"Contact"));

        driver.quit(); //завершение работы драйвера
    }
}
