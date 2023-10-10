package guru.qa;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    public SelenideElement content = $("#main-content-id");
    private SelenideElement cart = $("//aside[@id='CART_POPUP_ID']");

    public SearchPage checkResult(String result) {
        content.shouldHave(text(result));
        return this;
    }

    public SearchPage checkCartHidden() {
        cart.shouldBe(hidden);
        return this;
    }
}
