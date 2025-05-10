package itmo.tpo.lab3.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

abstract class BasePage(protected val driver: WebDriver) {
    init {
        PageFactory.initElements(driver, this)
    }

    protected fun waitAndClick(element: WebElement) {
        WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(element))
            .click()
    }

    protected fun waitAndType(element: WebElement, text: String) {
        WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(element))
            .sendKeys(text)
    }
}
