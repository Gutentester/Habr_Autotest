import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareerPage {

    //Драйвер для страницы career.habr.com
    private WebDriver driver;

    //Логотип страницы "Хабр Карьера"
    private final By careerTopMenuVacancies = By.xpath("//a[contains(@href, 'https://career.habr.com/vacancies')]");

    //Конструктор класса
    public CareerPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод получения текста из логотипа
    public String getCareerTopMenuVacanciesText() {
        return driver.findElement(careerTopMenuVacancies).getText();
    }
}
