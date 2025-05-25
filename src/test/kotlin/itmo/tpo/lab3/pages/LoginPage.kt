package itmo.tpo.lab3.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class LoginPage(driver: WebDriver) : BasePage(driver) {

    @FindBy(xpath = "//div[text()='Войти с Яндекс ']")
    private lateinit var yaButton: WebElement

    @FindBy(xpath = "//input[@id='passp-field-phone']")
    private lateinit var phoneInput: WebElement

    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private lateinit var enterButton: WebElement

    @FindBy(xpath = "//div[@class='Accounts-list']")
    private lateinit var userButton: WebElement

    @FindBy(xpath = "//span[contains(text(), 'картинке')]")
    private lateinit var imgButton: WebElement

    @FindBy(xpath = "//span[contains(text(), 'QR-коду')]")
    private lateinit var qrButton: WebElement

    @FindBy(xpath = "//div[@class='Textinput-Hint Textinput-Hint_state_error']")
    private lateinit var errorPhone: WebElement

    fun clickYaButton() = waitAndClick(yaButton)
    fun inputPhone(phone: String) = waitAndType(phoneInput, phone)
    fun clickEnterButton() = waitAndClick(enterButton)
    fun clickImgButton() = waitAndClick(imgButton)
    fun clickQrButton() = waitAndClick(qrButton)
    fun clickUser() = waitAndClick(userButton)
    fun errorElement() = waitAndGetElement(errorPhone)

    companion object {
        const val URL = "https://auth.auto.ru/login/?r=https%3A%2F%2Fauto.ru%2F"
    }
}