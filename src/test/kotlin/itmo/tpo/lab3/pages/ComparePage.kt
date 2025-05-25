package itmo.tpo.lab3.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement


class ComparePage(driver: WebDriver) : BasePage(driver) {

    fun getAllPrices(): List<Int> {
        return waitAndGetListByXpath("//span[contains(text(), '₽')]")
            .map(WebElement::getText)
            .map { it.replace(" ", "") }
            .map { it.replace("₽", "") }
            .map { it.toInt() }
    }

    fun getAllParameterValues(paramName: String): List<String> {
        val elements =
            waitAndGetListByXpath("//tr[.//div[text()='$paramName']]//div[not(text()='$paramName')][normalize-space()]")
        return elements.map { e: WebElement ->
            e.text.replace('\u00A0', ' ')
        }
    }

    companion object {
        const val URL = "https://auto.ru/compare-offers/"
    }
}