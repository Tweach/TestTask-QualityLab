package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IncomingLettersPage {
    public WebDriver driver;
    public IncomingLettersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //выпадающее меню с именем пользователя
    @FindBy(xpath = "//*[@id='PH_user-email'][text()='user_for_autotests@mail.ru']")
    private WebElement userNameDropdownMenu;

    //кнопка "выход"
    @FindBy(xpath = "//*[@id='PH_logoutLink']")
    private WebElement logoutButton;

    //кнопка "Написать письмо"
    @FindBy(xpath = "//*[@class='compose-button__wrapper']")
    private WebElement writeLetterButton;

    //проверка появления кнопки "выход"
    public void checkLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='PH_logoutLink']")));
    }

    //клик по кнопке "Написать письмо"
    public void clickWriteLetterButton() {
        writeLetterButton.click();
    }
}
