package itmo.tpo.lab3.pages

import org.openqa.selenium.*
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

abstract class BasePage(protected val driver: WebDriver) {
    init {
        PageFactory.initElements(driver, this)
    }

    fun waitLoading() {
        WebDriverWait(driver, Duration.ofSeconds(30)).until { webDriver: WebDriver ->
            ((webDriver as JavascriptExecutor)
                .executeScript("return document.readyState")
                    == "complete")
        }
    }

    private fun doRetryable(action: () -> Unit) {
        val currentTime = System.currentTimeMillis()
        while (System.currentTimeMillis() - currentTime < 10_000) {
            try {
                action()
                break
            } catch (e: Error) {
                Thread.sleep(50)
            } catch (e: Exception) {
                Thread.sleep(50)
            }
        }
    }

    protected fun waitAndClick(element: WebElement) {
        doRetryable {
            WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(element))
                .also {
                    Actions(driver)
                        .scrollToElement(it)
                        .moveToElement(it)
                        .click()
                        .perform()
                }
        }
    }

    protected fun waitAndType(element: WebElement, text: String) {
        WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(element))
            .sendKeys(text)
    }

    protected fun waitAndGetElement(element: WebElement): WebElement {
        return WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(element))
    }

    protected fun waitAndPressEnter(element: WebElement) {
        WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(element))
            .sendKeys(Keys.ENTER)
    }

    protected fun waitAndGetByXpath(string: String): WebElement {
        return WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated((By.xpath(string))))
    }

    protected fun waitAndGetListByXpath(xpath: String): List<WebElement> {
        return WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)))
    }

    protected fun firefoxMoveTo(element: WebElement) {
        (driver as JavascriptExecutor).executeScript(
            "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
            element
        )
        Thread.sleep(1000)
        (driver as JavascriptExecutor).executeScript(
            "var event = new MouseEvent('mouseover', {" +
                    "    'view': window," +
                    "    'bubbles': true," +
                    "    'cancelable': true" +
                    "});" +
                    "arguments[0].dispatchEvent(event);",
            element
        )
        Thread.sleep(1000)
    }
}
