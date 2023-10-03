package guru.qa;

import com.codeborne.selenide.Selenide;
import org.asynchttpclient.util.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static org.asynchttpclient.util.Assertions.assertNotEmpty;

public class SimpleTest {

  private String name = "Dima";

  @Tag("API")
  @Test
  void firstTest() {
    this.name = null;
  }

  @Test
  @Tags({@Tag("WEB"), @Tag("SMOKE")})
  void secondTest() {
    String testedVar = "Dima1";
  }

  private void someMethod() {
    throw new IllegalArgumentException();
  }
}
