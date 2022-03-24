package allurelesson.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открыть главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Перейти в репозиторий {name}")
    public void goToRepository(final String name) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("allure-framework/allure2");
        $(".header-search-input").submit();
        $(By.linkText("allure-framework/allure2")).click();
    }

    @Step("Перейти в Issues")
    public void goToIssue() {
        $("#issues-tab").click();
    }

    @Step("Проверить название Issue {name}")
    public void checkTitleIssue(final String name) {
        $(withText("Can not generate Allure Reports on Jenkins")).should(Condition.visible);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
