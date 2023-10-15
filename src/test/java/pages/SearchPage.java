package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {
    public SelenideElement content = $("#main-content-id");
    private SelenideElement textMessage = $x("//h2[text()]");

    public SearchPage checkResult(String result) {
        content.shouldHave(text(result));
        return this;
    }

    public SearchPage checkTextMessageVisible() {
        textMessage.shouldHave(text("Вот что мы нашли"));
        return this;
    }
}
