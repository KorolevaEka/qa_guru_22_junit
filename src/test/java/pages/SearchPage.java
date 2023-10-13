package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {
    public SelenideElement content = $("#main-content-id");
    private SelenideElement cart = $x("//aside[@id='CART_POPUP_ID']");

    public SearchPage checkResult(String result) {
        content.shouldHave(text(result));
        return this;
    }

    public SearchPage checkCartUnvisible() {
        cart.shouldBe(hidden);
        return this;
    }
}
