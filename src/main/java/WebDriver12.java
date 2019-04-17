import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
//keystrokes emulation, screenshots creation, files uploading
public class WebDriver12 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //неявное ожидание элементов до их появления
        driver.manage().window().maximize(); //управление размером окна, максимальное
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='searchInput']"));
        searchInput.sendKeys("Selenium ");

        //имитация нажатия клавиш
        searchInput.sendKeys(Keys.chord(Keys.SHIFT, "web driver")); //сочетание клавиш; выполнить метод sendKeys, внутри которого вызвать метод chord;
        searchInput.sendKeys(Keys.ENTER); //имитация нажатия клавиши "Enter"

        //имитация нажатия горячих клавиш
        driver.navigate().back();
        searchInput = driver.findElement(By.xpath("//input[@id='searchInput']"));
        String selectAll = Keys.chord(Keys.CONTROL,"a"); //имитация горячих клавиш
        String cut = Keys.chord(Keys.CONTROL,"x");
        String paste = Keys.chord(Keys.CONTROL,"v");
        searchInput.sendKeys("Selenium ");
        searchInput.sendKeys(selectAll);
        searchInput.sendKeys(cut);
        searchInput.sendKeys(paste);
        searchInput.sendKeys(Keys.ENTER); //имитация нажатия клавиши "Enter"

        //создание скриншотов
        Date dateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy.mm.dd_hh:mm:ss");
        String fileName = dateFormat.format(dateNow) + ".png";

        /*File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //в переменную типа File поместить скриншот
        try {
            FileUtils.copyFile(screenshot,new File("C:\\Screenshots\\screenshot1.png" + fileName)); //сохранить файл на диск
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //выгрузка файлов
        driver.get("https://www.google.com.ua/imghp");
        driver.findElement(By.xpath("//span[@class='S3Wjs']")).click();
        driver.findElement(By.xpath("//a[@class='qbtbha qbtbtxt qbclr']")).click();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\pic.jpg");

        driver.quit(); //завершение работы драйвера
    }
}
