package itmo.tpo.lab3.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class AuthPage(driver: WebDriver) : BasePage(driver) {
    @FindBy(xpath = "//a[.//span[span[text()='Войти']]]")
    private lateinit var loginButton: WebElement

    @FindBy(xpath = "//span[span[text()='Авто.ру']]")
    private lateinit var autoRuButton: WebElement

    @FindBy(xpath = "//button[div[text()='Далее']]")
    private lateinit var nextButton: WebElement

    @FindBy(xpath = "//input[@name='login']")
    private lateinit var emailInput: WebElement

    @FindBy(xpath = "//input[@name='password']")
    private lateinit var passwordInput: WebElement

    fun clickLoginButton() = waitAndClick(loginButton)
    fun clickAutoRuButton() = waitAndClick(autoRuButton)
    fun clickNextButton() = waitAndClick(nextButton)
    fun enterEmail(email: String) = waitAndType(emailInput, email)
    fun enterPassword(password: String) = waitAndType(passwordInput, password)
}
