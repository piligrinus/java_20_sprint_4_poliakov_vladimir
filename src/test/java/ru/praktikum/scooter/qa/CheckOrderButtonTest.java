package ru.praktikum.scooter.qa;

import org.junit.Test;
import ru.praktikum.scooter.qa.pageobject.HomePage;

public class CheckOrderButtonTest extends BaseTest {
    @Test
    public void checkClickOrderButton() throws InterruptedException { // тест клика по кнопкам "Заказать"
        new HomePage(webDriver)
                .clickUpperToDoOrderButton()
                .clickLowerToDoOrderButton();
    }
}