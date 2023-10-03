package guru.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleWebTest {

  @BeforeEach
  void setup() {
    open("https://www.google.com/");
  }

  @CsvSource(value = {
      "https://selenide.org , Selenide",
      "https://junit.org    , JUnit 5"
  })
  @CsvFileSource(resources = "/successfulSearchSelenideTest.csv")
  @ParameterizedTest(name = "В поисковой выдаче google присутствует ссылка {0} для запроса {1}")
  @Tag("BLOCKER")
  void successfulSearchSelenideTest(String expectedLink, String searchQuery) {
    $("[name=q]").setValue(searchQuery)
        .pressEnter();
    $("[id=search]").shouldHave(text(expectedLink));
  }

  @DisplayName("В поисковой выдаче google присутствует ссылка https://junit.org для запроса 'JUnit 5'")
  @Test
  @Tag("BLOCKER")
  void successfulSearchJUnitTest() {
    $("[name=q]").setValue("JUnit 5")
        .pressEnter();
    $("[id=search]").shouldHave(text("https://junit.org"));
  }

  @DisplayName("В поисковой выдаче картинок google присутствует ...")
  @Test
  @Tag("BLOCKER")
  void successfulSearchPhotoTest() {
    $("[name=q]").setValue("selenide").pressEnter();
    $$("[role='navigation'] .hdtb-mitem a").first().click();
    // check images
  }
}
