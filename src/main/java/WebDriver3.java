import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
//work with buttons, text, links, checkboxes and radio buttons
public class WebDriver3 {

    static WebDriver driver; //вынести за пределы main-метода, чтобы использовать в selectRadioButton

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //неявное ожидание элементов до их появления
        driver.manage().window().maximize(); //управление размером окна, максимальное

        //work with buttons
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
//        driver.findElement(By.xpath("//input[@id='searchButton']")).click(); //клик на кнопку
        WebElement button = driver.findElement(By.xpath("//input[@id='searchButton']")); //использовать метод кнопки submit
        System.out.println("Button text is: " + button.getText()); //получить текст кнопки
        button.submit();
        driver.findElement(By.xpath("//a[contains(@title,'encouraged to log in')]")).click();
        driver.findElement(By.xpath("//*[@id='wpLoginAttempt']")).submit();

        //work with text
        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Selenium WebDriver"); //ввести строку в текстовое поле
        driver.findElement(By.xpath("//input[@id='searchButton']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='searchText']/input")).getAttribute("value")); //считать строку с текстового поля
        driver.findElement(By.xpath("//div[@id='searchText']/input")).clear(); //очистить текстовое поле

        //work with links
        WebElement link = driver.findElement(By.xpath("//li[@id='n-aboutsite']/a")); //получить текст ссылки
        System.out.println(link.getText());
        link.click();

        //work with checkboxes
        driver.findElement(By.xpath("//li[@id='pt-anoncontribs']/a")).click();
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='mw-show-top-only']"));
        checkbox.click(); //выделить checkbox
        checkbox.click(); //снять выделение checkbox

        //work with radio buttons
        WebElement radiobutton = driver.findElement(By.xpath("//input[@id='newbie']"));
        radiobutton.click();

        System.out.println(checkbox.isSelected()); //узнать, выделен ли элемент
        System.out.println(radiobutton.isSelected());

        if (!checkbox.isSelected()) //если переключатель не выделен, то кликнуть на него; если уже выделен, то кликать не надо
            checkbox.click();

        selectCheckBox("mw-show-top-only"); //передать id чекбоксов в метод selectCheckBox
        selectCheckBox("mw-show-new-only");
        selectCheckBox("mw-hide-minor-edits");
        selectCheckBox("ores-hide-nondamaging");

        driver.quit(); //завершение работы драйвера
    }

    public static void selectCheckBox(String name) {
        String cbXPath = "//input[@id='%s']"; //шаблон XPath, принять переменную
        if (!driver.findElement(By.xpath(String.format(cbXPath, name))).isSelected()) //проверить переключатель
            driver.findElement(By.xpath(String.format(cbXPath, name))).click(); //выделить переключатель
    }
}
