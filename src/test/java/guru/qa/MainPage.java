package guru.qa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement searchBar = $("#search-input-id");

    private ElementsCollection catalogElement = $$("#main-content-id a h2 span span");

    public MainPage openMainPage() {
        open(baseUrl);
        return this;
    }

    public SearchPage searchValue(String string) {
        searchBar.click();
        searchBar.setValue(string).pressEnter();
        return new SearchPage();
    }

    public SelenideElement getCatalogElement(String element) {
        return catalogElement.filter(text(element)).find(exist);
    }
}
