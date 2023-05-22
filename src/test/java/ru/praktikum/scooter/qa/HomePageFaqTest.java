package ru.praktikum.scooter.qa;

import org.junit.Test;
import ru.praktikum.scooter.qa.pageobject.HomePage;


public class HomePageFaqTest extends BaseTest{

    @Test
    public void checkFaqAria() throws InterruptedException {
        new HomePage(webDriver)
                .clickFaqButtonCheckFaqText();

    }

}


