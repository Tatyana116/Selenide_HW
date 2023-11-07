package examles;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchJUnit5 {
    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        // открыть главную страницу
        open("https://github.com/");
        //ввести поле поиска одним нажатием 1
       $(".search-input").click();
       $("#query-builder-test").setValue("selenide").pressEnter();
       $("a[href='/selenide/selenide']").click();
       $$ ("a[href=\"/selenide/selenide/wiki\"]").first().click();
       $$ ("a[href=\"/selenide/selenide/wiki/SoftAssertions\"]").get(1).click();
        $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class:"));
        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));


    }
}
