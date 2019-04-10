import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
//implicit wait, search elements
public class WebDriver2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //неявное ожидание элементов до их появления

//        driver.manage().window().maximize(); //управление размером окна, максимальное
        driver.manage().window().setSize(new Dimension(900,900));

        driver.get("https://www.google.com.ua");
        driver.navigate().to("https://www.seleniumhq.org"); //альтернативный метод
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.linkText("Log in"));
        WebElement link = driver.findElement(By.linkText("Log in")); //найти элемент по тексту в ссылке, внести в переменную
        WebElement link2 = driver.findElement(By.partialLinkText("Donate")); //найти ссылку по части текста, хранить в переменной
        WebElement searchField = driver.findElement(By.name("search")); //найти элемент по значиению "search" атрибута "name"
        WebElement searchButton = driver.findElement(By.className("searchButton")); //найти элемент по имени класса
        WebElement li = driver.findElement(By.id("ca-viewsource"));
        WebElement input = driver.findElement(By.tagName("input")); //поиск элемента по имени тега
        WebElement element = driver.findElement(By.cssSelector("div#simpleSearch input#searchButton")); //поиск по CSS-локатору
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"p-logo\"]/a")); //поиск по XPath
        WebElement element3 = driver.findElement(By.xpath("//div[@id='mw-panel']/div[@id='p-logo']//a")); //поиск по XPath

        driver.quit(); //завершение работы драйвера
    }
}
