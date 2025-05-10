package itmo.tpo.lab3.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class AuthPage(driver: WebDriver) : BasePage(driver) {
    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    private lateinit var loginButton: WebElement

    @FindBy(xpath = "//input[@name='login']")
    private lateinit var emailInput: WebElement

    @FindBy(xpath = "//input[@name='password']")
    private lateinit var passwordInput: WebElement

    fun clickLoginButton() = waitAndClick(loginButton)
    fun enterEmail(email: String) = waitAndType(emailInput, email)
    fun enterPassword(password: String) = waitAndType(passwordInput, password)
}
