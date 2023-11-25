import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class FormPageHelper {

    private WebDriver driver;

    //Конструктор класса
    public FormPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    //Метод выбора вкладки
    public void switchTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }
}
