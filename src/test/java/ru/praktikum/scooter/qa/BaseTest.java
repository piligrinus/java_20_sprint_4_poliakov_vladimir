package ru.praktikum.scooter.qa;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver = WebDriverFactory.get();

    @Before
    public void init() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @After
    public void clean() {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }

}

