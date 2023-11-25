import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.equalTo;

public class SmokeTest {

    private WebDriver driver;
    MainPage mainPage;
    CareerPage careerPage;
    FormPageHelper formPageHelper;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        careerPage = new CareerPage(driver);
        formPageHelper = new FormPageHelper(driver);
        mainPage.openMainPage();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Корректное открытие страницы https://habr.com/ru/articles")
    public void openMainPageTest() {
        MatcherAssert.assertThat(mainPage.getLogoText(), equalTo("Хабр"));
    }

    @Test
    @DisplayName("Отображение блока Лучшие блоги")
    public void bestBlogsSideBarTest() {
        MatcherAssert.assertThat(mainPage.getBestBlogsSideBarHeaderText(), equalTo("ЛУЧШИЕ БЛОГИ"));
    }

    @Test
    @DisplayName("Переход в раздел Карьера")
    public void careerPageOpeningTest() {
        mainPage.goToCareerPage();
        formPageHelper.switchTab(1);
        MatcherAssert.assertThat(careerPage.getCareerTopMenuVacanciesText(), equalTo("Вакансии"));
    }
}
