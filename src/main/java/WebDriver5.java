import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
//work with list of elements
public class WebDriver5 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //неявное ожидание элементов до их появления
        driver.manage().window().maximize(); //управление размером окна, максимальное

        driver.get("https://en.wikipedia.org/wiki/Special:Contributions");
        /*1. панель с элементами //fieldset[@class='mw-contributions-table']
        1.1 четвертый блок //fieldset[@class='mw-contributions-table']/div[4]
        1.1.1 все чекбоксы //fieldset[@class='mw-contributions-table']/div[4]//input[@class='mw-input']*/

        List<WebElement> checkboxes = driver.findElements(By.xpath("//fieldset[@class='mw-contributions-table']/div[4]//input[@class='mw-input']"));
        /*создать списковую переменную checkboxes
        записать список всех элементов по общему XPath
        метод findElement() != findElements()*/

        checkboxes.get(2).click(); //выделить третий элемент с индексом 2 в списке
        checkboxes.get(2).click(); //убрать выделение третьего элемента

        System.out.println("Number of elements in block: " + checkboxes.size()); //вернуть размер списка элементов

        if (checkboxes.size() == 4) System.out.println("OK");
        else System.out.println("NOK");

 //выделить все элементы
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }

        driver.quit(); //завершение работы драйвера
    }
}
