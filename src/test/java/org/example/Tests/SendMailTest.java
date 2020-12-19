package org.example.Tests;

import org.example.ConfProperties;
import org.example.Pages.LoginPage;
import org.example.Pages.IncomingLettersPage;
import org.example.Pages.WriteLetterPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SendMailTest {
    public static LoginPage loginPage;
    public static IncomingLettersPage incomingLettersPage;
    public static WriteLetterPage writeLetterPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        incomingLettersPage = new IncomingLettersPage(driver);
        writeLetterPage = new WriteLetterPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void sendMailTest() {
        loginPage.switchToLoginFrame();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickPasswordEntryButton();
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLoginButton();
        loginPage.switchToParentWindow();

        incomingLettersPage.checkLogoutButton();
        incomingLettersPage.clickWriteLetterButton();

        writeLetterPage.inputReceiverEmail("user_for_autotests@mail.ru");
        writeLetterPage.inputTextOfLetter("Привет!");
        writeLetterPage.clickSendButton();
    }
}