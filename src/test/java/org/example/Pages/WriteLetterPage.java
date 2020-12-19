package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WriteLetterPage {
    public WebDriver driver;
    public WriteLetterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //поле "Кому"
    @FindBy(xpath = "//*[@class='input--3slxg']//input")
    private WebElement receiverEmailField;

    //поле ввода текста письма
    @FindBy(xpath = "//*[contains(@class, 'editable-container')]/div/div")
    private WebElement textOfLetterField;

    //кнопка "Отправить"
    @FindBy(xpath = "//*[text()='Отправить']")
    private WebElement sendButton;

    //ввод имени получателя
    public void inputReceiverEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='input--3slxg']//input")));
        receiverEmailField.sendKeys(email);
    }

    //ввод текста письма
    public void inputTextOfLetter(String text) {
        textOfLetterField.sendKeys(text);
    }

    //клик по кнопке "Отправить"
    public void clickSendButton() {
        sendButton.click();
    }
}