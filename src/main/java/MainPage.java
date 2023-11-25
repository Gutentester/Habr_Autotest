import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    //Драйвер для главной страницы habr.com
    private WebDriver driver;

    //Логотип "Хабр"
    private final By logo = By.xpath("//a[@class='tm-header__logo tm-header__logo_ru']");

    //Кнопка вызова главного меню
    private final By dropDownButton = By.xpath("//button[@class='tm-header__dropdown-toggle']");

    //Пункт "Карьера" главного меню
    private final By careerItem = By.xpath("//a[contains(@href,'https://career.habr.com?')]");

    //Заголовок Блока "Лучшие блоги"
    private final By bestBlogsSideBarHeader = By.xpath("//div[contains(@class, 'tm-sexy-sidebar')]/section[1]/header");

    //Конструктор класса
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод открытия главной страницы
    public void openMainPage() {
        driver.get(URLs.BASE_URL);
    }

    //Метод получения текста из логотипа
    public String getLogoText() {
        return driver.findElement(logo).getText();
    }

    //Метод получаения текста из заголовка блока "Лучшие блоги"
    public String getBestBlogsSideBarHeaderText() {
        return driver.findElement(bestBlogsSideBarHeader).getText();
    }

    //Метод клика по кнопке раскрытия главного меню
    public void goToCareerPage() {
        driver.findElement(dropDownButton).click();
        driver.findElement(careerItem).click();
    }
}
