package ru.praktikum.scooter.qa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.scooter.qa.pageobject.HomePage;

@RunWith(Parameterized.class)
public class HomePageFaqTest extends BaseTest{
    private final int index;


    public HomePageFaqTest(int index){
        this.index = index;

    }
    @Parameterized.Parameters
    public static Object[][] getTextData(){
        return new Object[][]{
                {0},
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
        };
    }
    @Test
    public void FaqTest() throws InterruptedException {
        new HomePage(webDriver)
                .clickFaqButton(index)
                .checkFaqResponse(index);

    }

}
