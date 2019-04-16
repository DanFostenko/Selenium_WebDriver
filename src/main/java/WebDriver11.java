import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
//elements availability and presence
public class WebDriver11 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //неявное ожидание элементов до их появления
        driver.manage().window().maximize(); //управление размером окна, максимальное

        //buttons availability
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        WebElement button1 = driver.findElement(By.xpath("//input[@type='submit']"));
        System.out.println(button1.isEnabled());
        if (button1.isEnabled()) button1.click();

        /*driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_pushbutton_disabled2");
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Try it']"));
        WebElement button3 = driver.findElement(By.xpath("//button[@id = 'myBtn']"));
        System.out.println(button3.isEnabled());
        button2.click();
        System.out.println(button3.isEnabled());*/

        //radio buttons availability
        driver.get("https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html");
        WebElement rb1 = driver.findElement(By.xpath("(//input[@name = 'agreementjdk-11.0.2-oth-JPR'])[1]"));
        WebElement rb2 = driver.findElement(By.xpath("(//input[@name = 'agreementjdk-11.0.2-oth-JPR'])[2]"));

        System.out.println("Radio button 2 selected: " + rb2.isSelected());
        if (!rb1.isSelected()) rb1.click();

        //links availability
        driver.get("https://www.ebay.com");
        WebElement link1 = driver.findElement(By.xpath("//a[text()='Smart Home']"));
        WebElement link2 = driver.findElement(By.xpath("//a[text()='Saved']"));

        System.out.println(link1.isDisplayed()); //False
        System.out.println(link2.isDisplayed()); //True

        if (link1.isDisplayed()) link1.click();
        else link2.click();

        //elements presence
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElements(By.xpath("//a[text()='Log in']")); //остается пустым, если элементы не найдены
        System.out.println(driver.findElements(By.xpath("//a[text()='Log in']")).size()); //1
        System.out.println(driver.findElements(By.xpath("//a[text()='Sign in']")).size()); //0

        if (driver.findElements(By.xpath("//a[text()='Log in']")).size() > 0)
            System.out.println("Element is present");
        else System.out.println("Element not found");

        driver.quit(); //завершение работы драйвера
    }
}
