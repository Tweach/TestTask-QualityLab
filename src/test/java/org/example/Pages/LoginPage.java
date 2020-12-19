package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //поле ввода логина
    @FindBy(xpath = "//input[@name='username']")
    private WebElement loginField;

    //поле ввода пароля
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    //кнопка "Ввести пароль"
    @FindBy(xpath = "//*[text()='Ввести пароль']")
    private WebElement passwordEntryButton;

    //кнопка "Войти"
    @FindBy(xpath = "//*[text()='Войти']")
    private WebElement loginButton;

    //фрейм ввода логина
    @FindBy(xpath = "//iframe[@class='ag-popup__frame__layout__iframe']")
    private WebElement loginFrame;

    //ввод логина
    public void inputLogin(String login) {
        loginField.click();
        loginField.sendKeys(login);
    }

    //ввод пароля
    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    //клик по кнопке "Ввести пароль"
    public void clickPasswordEntryButton() {
        passwordEntryButton.click();
    }

    //клик по кнопке "Войти"
    public void clickLoginButton() {
        loginButton.click();
    }

    //переключение на фрейм ввода логина
    public void switchToLoginFrame() {
        driver.switchTo().frame(loginFrame);
    }

    //переключение на родительское окно
    public void switchToParentWindow() {
        driver.switchTo().defaultContent();
    }
}