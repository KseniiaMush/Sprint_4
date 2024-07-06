package praktikum;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.driverFactory.DriverFactory;
import org.junit.Test;
import praktikum.pages.ConfirmOrderPage;
import praktikum.pages.MainPage;
import praktikum.pages.OrderPage;
import praktikum.pages.RentPage;

@RunWith(Parameterized.class)
public class OrderPositiveTest {
    private static String orderButtonLocator;
    private static String name;
    private static String surname;
    private static String address;
    private static String metro;
    private static String phone;
    private static String date;
    private static String daysCount;
    private static String colour;
    private static String comment;


    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    public OrderPositiveTest (String orderButtonLocator, String name, String surname, String address, String metro, String phone, String date, String daysCount, String colour, String comment) {
        this.orderButtonLocator = orderButtonLocator;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.daysCount = daysCount;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {".//div[2]/button[text() = 'Заказать']", "Ксения", "Мишина", "г. Москва, пр-кт Вернадского, 15", "//button[@value = '78']", "79309303030", "//div[text() = '27']", "//div[text() = 'сутки']", "black", "Захвати пивка"},
                {".//div[5]/button[text() = 'Заказать']", "Лорд", "Волдеморт", "Тисовая улица", "//button[@value = '76']", "89309303030", "//div[text() = '15']", "//div[text() = 'пятеро суток']", "grey", "Авокадо Кедавра"},
        };
    }

    @Test

    public void successOrderByUp () {

        MainPage main = new MainPage(driverFactory.getDriver());
        OrderPage orderPage = new OrderPage(driverFactory.getDriver());
        RentPage rentPage = new RentPage(driverFactory.getDriver());
        ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage(driverFactory.getDriver());

        main.openMainPage();
        main.clickOnOrderButton(orderButtonLocator);

        orderPage.postOrderSettings(name, surname, address, metro, phone);

        orderPage.clickOnNextButton();

        rentPage.postRentSettings(date, daysCount, colour, comment);

        rentPage.clickOnSecondOrderButton();

        confirmOrderPage.confirmOrder();

    }
}
