package ru.praktikum.scooter.qa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.scooter.qa.pageobject.HomePage;
import ru.praktikum.scooter.qa.pageobject.OrderPage;


@RunWith(Parameterized.class)
public class OrderToDoPositiveTest extends BaseTest{
    private final String name;
    private final String surname;
    private final String address;
    private final int metroStationNumber;
    private final String telephoneNumber;
    private final String data;
    private final String duration;
    private final String colour;
    private final String comment;
    private final String buttonPath;
    private final String toDoOrderButtonPath;

    public OrderToDoPositiveTest (String toDoOrderButtonPath,String name,String surname,String address,int metroStationNumber,String telephoneNumber,String data,String duration,String colour,String comment,String buttonPath){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStationNumber = metroStationNumber;
        this.telephoneNumber = telephoneNumber;
        this.data = data;
        this.duration = duration;
        this.colour = colour;
        this.comment = comment;
        this.buttonPath = buttonPath;
        this.toDoOrderButtonPath = toDoOrderButtonPath;
    }

    @Parameterized.Parameters
    public  static Object[][] getTextData() {
        return new Object[][]{
                {"/html/body/div/div/div/div[1]/div[2]/button[1]","Незнайка","Налуне","тупикВыгорания",13,"19841984198","01.01.2024", "/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]",".//input[@id='black']","постучать три раза","/html/body/div/div/div[2]/div[3]/button[2]"},
                {"/html/body/div/div/div/div[4]/div[2]/div[5]/button","Иней","Синий","селНаПровода",7,"77777777777","16.08.2023","/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[6]",".//input[@id='grey']","прости,прощай,привет!","/html/body/div/div/div[1]/div[2]/button[1]"}

        };
    }
    @Test
    public void checkOrderToDo() throws InterruptedException {
        new HomePage(webDriver)
                .clickToDoOrderButton(toDoOrderButtonPath);
        new OrderPage(webDriver)
                .orderFieldInputName(name)
                .orderFieldInputSurname(surname)
                .orderFieldInputAddress(address)
                .orderFieldInputMetroStation(metroStationNumber)
                .orderFieldInputTelephone(telephoneNumber)
                .clickOnwardButton()
                .orderFieldInputRentDate(data)
                .orderFieldInputRentDuration(duration)
                .orderFieldInputColour(colour)
                .orderFieldInputComment(comment)
                .clickOrderButton(buttonPath)
                .checkApprovalOrderAriaDisplayed()
                .clickApprovalOrderButton()
                .checkSuccessfullyOrderMessage();

    }

}



