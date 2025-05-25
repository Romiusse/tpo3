package itmo.tpo.lab3.pages

import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions


class CreditPage(driver: WebDriver) : BasePage(driver) {

    // Находим элемент слайдера
    private val creditSum: WebElement = waitAndGetByXpath("//input[@name='amount']")
    private val creditPeriod: WebElement = waitAndGetByXpath("//span[contains(text(),'Срок кредита')]/following::div[@class='Slider__click-bar']")
    private val result: WebElement = waitAndGetByXpath("//div[contains(text(),'Платеж')]/following::div[@class='CreditCalculator2__fieldValue']")

    fun setCreditSum(sum: String) {
        waitAndGetElement(creditSum).apply {
            repeat(20) {
                sendKeys(Keys.BACK_SPACE)
            }
        }
        waitAndType(creditSum, sum)
    }

    fun setYear(year: Int) {
        val targetPeriod = (creditPeriod.size.width * year.toFloat() / 8f -0.5)
        Actions(driver)
            .scrollByAmount(0, 300)
            .scrollToElement(creditPeriod)
            .moveToElement(creditPeriod)
            .moveByOffset(targetPeriod.toInt(), 0)
            .click()
            .perform();
    }

    fun getResult(): Int {
        return result.text.replace(" ", "").replace("₽/мес.", "").toInt()
    }

    companion object {
        const val URL = "https://auto.ru/promo/finance/"
    }

}