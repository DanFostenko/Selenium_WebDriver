import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
//complex actions
public class WebDriver8 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //неявное ожидание элементов до их появления
        driver.manage().window().maximize(); //управление размером окна, максимальное
        driver.get("https://www.ebay.com");

        WebElement link = driver.findElement(By.xpath("//li/a[text()='Electronics']")); //записать в переменную адрес элемента
        WebElement element = driver.findElement(By.xpath("//li/a[text()='Electronics']"));
        Actions actions = new Actions(driver); //создать переменную actions класса Actions
        actions.moveToElement(link).build().perform(); //навести курсор на элемент link; build, perform выполняют метод

        actions.dragAndDrop(element, link).build().perform(); //выполнение drag&drop
        actions.clickAndHold(element).moveToElement(link).release().build().perform(); //компоновка методов с последующим выполнением
        //длительное нажатие ЛКнМ + передвижение к элементу link + отпустить ЛКнМ

        Action superaction = actions.clickAndHold(element).moveToElement(link).release().build(); //создать переменную класса Action, собрать методы
        superaction.perform(); //выполнить ряд сложным методов

        actions.doubleClick(element);
        actions.contextClick(element); //имитировать нажатие ПрКнМ
        driver.quit(); //завершение работы драйвера
    }
}
