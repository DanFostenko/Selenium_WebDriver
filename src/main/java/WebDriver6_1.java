import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//table class
//отдельная таблица
public class WebDriver6_1 {
    private WebElement tableElement;
    private WebDriver driver;

    public WebDriver6_1(WebElement tableElement, WebDriver driver) {
        this.tableElement = tableElement; //данной переменной tableElement передать значение, которое передаем в конструктор
        this.driver = driver; //this указывает на данный класс
    }
    public List<WebElement> getRows() {
        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr"));
        rows.remove(0); //удалить строку заголовков
        return rows;
    }
    public List<WebElement> getHeadings() {
        WebElement headingsRow = tableElement.findElement(By.xpath(".//tr[1]")); //зайти в первую строку
        List<WebElement> headingColumns = headingsRow.findElements(By.xpath(".//th")); //найти все заголовки
        return headingColumns;
    }

    //разбить все строки на колонки
    public List<List<WebElement>> getRowsWithColumns() {
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for (WebElement row : rows) {
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td")); //разбить каждую строку на столбцы
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }

    //List - список всех строк, у которого каждая строка Map, где String - ключ, WebElement - значение
    //String - заголовок, WebElement - ячейка по данному заголовку
    public List<Map<String, WebElement>> getRowsWithColumnsByHeadings() {

        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeadings;
        List<WebElement> headingColumns = getHeadings();

        for (List<WebElement> row : rowsWithColumns) {
            rowByHeadings = new HashMap<String, WebElement>();
            for (int i = 0; i < headingColumns.size(); i++){
                String heading = headingColumns.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeadings.put(heading, cell);
            }
            rowsWithColumnsByHeadings.add(rowByHeadings);
        }
        return rowsWithColumnsByHeadings;
    }

    public String getValueFromCell(int rowNumber, int columnNumber) {
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
        return cell.getText();
    }
    public String getValueFromCell(int rowNumber, String columnName){
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
        return rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName).getText();
    }
}
