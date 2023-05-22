package ru.praktikum.scooter.qa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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


        public OrderToDoPositiveTest (String name,String surname,String address,int metroStationNumber,String telephoneNumber,String data,String duration,String colour,String comment){
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.metroStationNumber = metroStationNumber;
            this.telephoneNumber = telephoneNumber;
            this.data = data;
            this.duration = duration;
            this.colour = colour;
            this.comment = comment;
        }

    @Parameterized.Parameters
    public  static Object[][] getTextData() {
            return new Object[][]{
                    {"Незнайка","Налуне","тупикВыгорания",13,"19841984198","01.01.2024", "/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]",".//input[@id='black']","постучать три раза"},
                    {"Иней","Синий","селНаПровода",7,"77777777777","16.08.2023","/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[6]",".//input[@id='grey']","прости,прощай,привет!"}

            };
        }
    @Test
    public void checkOrderToDoByLowerOrderButton(){ //заказ создается при нажатии нижней кнопки "Заказать"
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
                    .checkLowerOrderButton()
                    .checkApprovalOrderAriaDisplayed()
                    .clickApprovalOrderButton()
                    .checkSuccessfullyOrderMessage();



        }
        @Test
        public void checkOrderToDoByUpperOrderButton(){ // заказ создается при нажатии верхней кнопки "Заказать"
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
                    .checkUpperOrderButton()
                    .checkApprovalOrderAriaDisplayed()
                    .clickApprovalOrderButton()
                    .checkSuccessfullyOrderMessage();

        }
    }



