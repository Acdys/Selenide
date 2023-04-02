import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    public static String setLocalDate(int day) {
        return LocalDate.now().plusDays(day).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldForDayThree() {
        $("[data-test-id=city] .input__control").setValue("Москва");
        $("[data-test-id=date] .input__control").doubleClick().sendKeys(setLocalDate(3));
        $("[data-test-id=name] .input__control").setValue("Иванов Петр");
        $("[data-test-id=phone] .input__control").setValue("+79991256987");
        $("[data-test-id=agreement]").click();
        $(".button__content").click();
        $("[data-test-id=notification] .notification__title").shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id=notification] .notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + setLocalDate(3)));
    }

    @Test
    void shouldForDayFour() {
        $("[data-test-id=city] .input__control").setValue("Москва");
        $("[data-test-id=date] .input__control").doubleClick().sendKeys(setLocalDate(4));
        $("[data-test-id=name] .input__control").setValue("Иванов Петр");
        $("[data-test-id=phone] .input__control").setValue("+79991256987");
        $("[data-test-id=agreement]").click();
        $(".button__content").click();
        $("[data-test-id=notification] .notification__title").shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id=notification] .notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + setLocalDate(4)));
    }

    @Test
    void shouldForDayTen() {
        $("[data-test-id=city] .input__control").setValue("Москва");
        $("[data-test-id=date] .input__control").doubleClick().sendKeys(setLocalDate(10));
        $("[data-test-id=name] .input__control").setValue("Иванов Петр");
        $("[data-test-id=phone] .input__control").setValue("+79991256987");
        $("[data-test-id=agreement]").click();
        $(".button__content").click();
        $("[data-test-id=notification] .notification__title").shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id=notification] .notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + setLocalDate(10)));
    }

    @Test
    void shouldForYear() {
        $("[data-test-id=city] .input__control").setValue("Москва");
        $("[data-test-id=date] .input__control").doubleClick().sendKeys(setLocalDate(365));
        $("[data-test-id=name] .input__control").setValue("Иванов Петр");
        $("[data-test-id=phone] .input__control").setValue("+79991256987");
        $("[data-test-id=agreement]").click();
        $(".button__content").click();
        $("[data-test-id=notification] .notification__title").shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id=notification] .notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + setLocalDate(365)));
    }

    @Test
    void shouldForSelectFromList() {
        $("[data-test-id=city] .input__control").setValue("Мс");
        $$(".menu-item__control").find(Condition.exactText("Москва")).click();
        $("[data-test-id=date] .input__control").doubleClick().sendKeys(setLocalDate(3));
        $("[data-test-id=name] .input__control").setValue("Иванов Петр");
        $("[data-test-id=phone] .input__control").setValue("+79991256987");
        $("[data-test-id=agreement]").click();
        $(".button__content").click();
        $("[data-test-id=notification] .notification__title").shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id=notification] .notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + setLocalDate(3)));
    }

}
