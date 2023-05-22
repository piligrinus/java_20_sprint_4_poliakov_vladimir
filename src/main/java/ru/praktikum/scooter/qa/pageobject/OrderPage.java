package ru.praktikum.scooter.qa.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;
import static ru.praktikum.scooter.qa.config.AppConfig.APP_URL_ORDER_PAGE;

public class OrderPage {
    WebDriver webDriver;

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL_ORDER_PAGE);

    }
    private By inputNameField = xpath(".//input[@placeholder='* Имя']"); // локатор поля "Имя"
    private By inputSurnameField = xpath(".//input[@placeholder='* Фамилия']"); // локатор поля "Фамилия"
    private By inputAddressField = xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); // локатор поля "Адресс"
    private By inputMetroStationField = xpath(".//input[@placeholder='* Станция метро']"); // локатор поля "Станция метро"
    private By listMetroStation  = xpath(".//li"); // локатор списка "Станция метро"
    private By inputTelephoneNumberField = xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); // локатор поля "Телефон"
    private By onwardButton = xpath("/html/body/div/div/div[2]/div[3]/button"); // локатор кнопки "Далее"
    private By aboutRentHeader = By.className("Order_Header__BZXOb"); // локатор окна "Про аренду"
    private By inputDataDeliveryField = xpath(".//input[@placeholder='* Когда привезти самокат']"); // локатор поля выбора даты аренды
    private By inputDurationOfRentField = By.className("Dropdown-arrow"); // локатор поля выбора длительности аренды
    private By inputCommentCourier = xpath(".//input[@placeholder='Комментарий для курьера']"); // локатор поля "Комментарий"
    private By lowerOrderButton = xpath("/html/body/div/div/div[2]/div[3]/button[2]"); // локатор нижней кнопки "Заказать"
    private By upperOrderButton = xpath("/html/body/div/div/div[1]/div[2]/button[1]"); // локатор верхней кнопки "Заказать"
    private By approvalOrderAria = By.className("Order_ModalHeader__3FDaJ"); // локатор заголовка "Хотите оформить заказ?"
    private By successfullyOrderMessage = By.xpath(".//div[text()='Заказ оформлен']"); // локатор сообщения "Заказ оформлен"
    private By approvalOrderButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]"); // локатор кнопки подтверждения оформления заказа
    public OrderPage orderFieldInputName(String name) {
        webDriver.findElement(inputNameField).sendKeys(name);
        return this;
    }
    public OrderPage orderFieldInputSurname(String surname) {
        webDriver.findElement(inputSurnameField).sendKeys(surname);
        return this;
    }

    public OrderPage orderFieldInputAddress(String address) {
        webDriver.findElement(inputAddressField).sendKeys(address);
        return this;
    }
    public OrderPage orderFieldInputMetroStation(int n) {
        webDriver.findElement(inputMetroStationField).click();
        List<WebElement> elements = webDriver.findElements(listMetroStation);
        WebElement metroStation = elements.get(n);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", metroStation);
        metroStation.click();;
        return this;
    }

    public OrderPage orderFieldInputTelephone(String telephoneNumber){
        webDriver.findElement(inputTelephoneNumberField).sendKeys(telephoneNumber);
        return this;
    }
    public OrderPage clickOnwardButton(){
        webDriver.findElement(onwardButton).click();
        Assert.assertTrue(webDriver.findElement(aboutRentHeader).isDisplayed());
        return this;
    }

    public OrderPage orderFieldInputRentDate(String data){
        webDriver.findElement(inputDataDeliveryField).click();
        webDriver.findElement(inputDataDeliveryField).sendKeys(data);
        return this;
    }
    public OrderPage orderFieldInputRentDuration(String duration){
        webDriver.findElement(inputDurationOfRentField).click();
        webDriver.findElement(xpath(duration)).click();
        return this;
    }
    public OrderPage orderFieldInputColour(String colour){
        webDriver.findElement(xpath(colour)).click();
        return this;
    }
    public OrderPage orderFieldInputComment(String comment){
        webDriver.findElement(inputCommentCourier).sendKeys(comment);
        return this;
    }
    public OrderPage checkLowerOrderButton(){
        webDriver.findElement(lowerOrderButton).click();
        return this;
    }
    public OrderPage checkUpperOrderButton(){
        webDriver.findElement(upperOrderButton).click();
        return this;
    }

    public OrderPage checkApprovalOrderAriaDisplayed(){
        webDriver.findElement(approvalOrderAria).isDisplayed();
        return this;
    }
    public OrderPage clickApprovalOrderButton(){
        webDriver.findElement(approvalOrderButton).click();
        return this;
    }
    public OrderPage checkSuccessfullyOrderMessage(){
        webDriver.findElement(successfullyOrderMessage).isDisplayed();
        return this;
    }
}
