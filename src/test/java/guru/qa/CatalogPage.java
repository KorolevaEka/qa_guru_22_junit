package guru.qa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
public class CatalogPage {

    private SelenideElement catalogTitle = $(".cxz2sk1");

    public CatalogPage checkTitle(String title) {
        catalogTitle.shouldHave(text(title));
        return this;
    }
}
