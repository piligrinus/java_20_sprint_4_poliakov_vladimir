package ru.praktikum.scooter.qa.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.praktikum.scooter.qa.constans.message;
import static org.openqa.selenium.By.id;
import static ru.praktikum.scooter.qa.config.AppConfig.APP_URL_HOME_PAGE;
import static ru.praktikum.scooter.qa.config.AppConfig.APP_URL_ORDER_PAGE;


public class HomePage {
    WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL_HOME_PAGE);

    }
    private By upperToDoOrderButton = By.xpath("/html/body/div/div/div/div[1]/div[2]/button[1]"); // локатор верхней кнопки "Заказать"
    private By lowerToDoOrderButton = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button"); // // локатор нижней кнопки "Заказать"
        public  HomePage clickFaqButtonCheckFaqText() throws InterruptedException {
        for (int i=0; i < 8; i++) {
            WebElement element = webDriver.findElement(id("accordion__heading-"+i)); //переменная строки FAQ
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element); // скролл до строки FAQ
            Thread.sleep(300); // ожидание действия для визуализации при отладке установить 3000.без sleep тест в ФФ падает
            webDriver.findElement(id("accordion__heading-"+i)).click(); // клик по кнопке меню FAQ
            Thread.sleep(300);// ожидание действия для визуализации при отладке установить 3000.без sleep тест в ФФ падает
            Assert.assertEquals(message.FAQ_TEXT[i], webDriver.findElement(id("accordion__panel-"+i)).getText()); // сравнение текста пункта FAQ  с эталонным

            }
        return this;
        }

        public HomePage clickUpperToDoOrderButton () throws InterruptedException { // клик по верхней кнопке "Заказать" и проверка перехода на страницу для заказа
            webDriver.findElement(upperToDoOrderButton).click();
            //Thread.sleep(3000);
            Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_ORDER_PAGE));
            //Thread.sleep(3000);
            webDriver.get(APP_URL_HOME_PAGE);
           // Thread.sleep(3000);
            return this;
}
        public HomePage clickLowerToDoOrderButton () throws InterruptedException { // клик по нижней кнопке "Заказать" и проверка перехода на страницу для заказа
            WebElement element = webDriver.findElement(lowerToDoOrderButton);
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element); // скролл до
            Thread.sleep(3000);
            webDriver.findElement(lowerToDoOrderButton).click();
            Thread.sleep(3000);
            Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_ORDER_PAGE));
            return this;
    }
}



