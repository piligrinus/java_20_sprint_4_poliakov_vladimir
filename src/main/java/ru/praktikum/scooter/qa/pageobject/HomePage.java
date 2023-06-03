package ru.praktikum.scooter.qa.pageobject;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.praktikum.scooter.qa.constans.message;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;
import static ru.praktikum.scooter.qa.config.AppConfig.APP_URL_HOME_PAGE;
import static ru.praktikum.scooter.qa.config.AppConfig.APP_URL_ORDER_PAGE;


public class HomePage {
    WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL_HOME_PAGE);

    }

    public  HomePage clickFaqButton(int index) throws InterruptedException {
        WebElement element = webDriver.findElement(id("accordion__heading-"+index));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(300);
        webDriver.findElement(id("accordion__heading-"+index)).click();
        Thread.sleep(300);
        return this;
    }
    public HomePage checkFaqResponse(int index) {
        Assert.assertEquals(message.FAQ_TEXT[index], webDriver.findElement(id("accordion__panel-" + index)).getText());
        return this;
    }
    public HomePage clickToDoOrderButton (String toDoOrderButtonPath) throws InterruptedException {
        WebElement element = webDriver.findElement(xpath(toDoOrderButtonPath));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        webDriver.findElement(xpath(toDoOrderButtonPath)).click();
        Thread.sleep(300);
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_ORDER_PAGE));
        Thread.sleep(300);
        return this;
    }

}



