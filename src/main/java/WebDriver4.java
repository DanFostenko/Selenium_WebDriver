import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
//work with dropdowns
public class WebDriver4 {

    static WebDriver driver; //вынести за пределы main-метода, чтобы использовать в selectOption

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //неявное ожидание элементов до их появления
        driver.manage().window().maximize(); //управление размером окна, максимальное

        driver.get("https://en.wikipedia.org/wiki/Special:Contributions");
        driver.findElement(By.xpath("//label[@for='namespace']/following-sibling::select")).click(); //клик на имя, кот. вызывает список
        driver.findElement(By.xpath("//option[@value='108']")).click(); //клик на элемент данного списка
        //driver.findElement(By.xpath("//option[text()='Book']")).click(); //равнозначные локаторы

        driver.get("https://www.wikidata.org/wiki/Special:Book");
        driver.findElement(By.xpath("//label[text()='Columns:']/ancestor::tr/td[last()]/select")).click();
        driver.findElement(By.xpath("//label[text()='Columns:']/ancestor::tr/td[last()]/select/option[@value='2']")).click();
        driver.findElement(By.xpath("//label[text()='Columns:']/ancestor::tr/td[last()]/select")).click();

        driver.navigate().refresh(); //обновить ту же страницу, сбросив выбранные параметры
        selectOption("Paper size:", "2"); //передать текст label и номер элемента в выпадающем списке
        selectOption("Include a table of contents", "2");
        selectOption("Columns:", "2");

        driver.quit(); //завершение работы драйвера
    }

    public static void selectOption(String listName, String option) { //принять значения имени списка и номера элемента
        String listXPath = String.format("//label[text()='%s']/ancestor::tr/td[last()]/select", listName); //сформировать XPath выпадающего списка, %s - String формат передаваемого значения
        String optionXPath = String.format("//label[text()='%s']/ancestor::tr/td[last()]/select/option[%s]", listName, option); //сформировать XPath элемента

        driver.findElement(By.xpath(listXPath)).click();
        driver.findElement(By.xpath(optionXPath)).click();

    }
}
