package itmo.tpo.lab3

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

fun main() {
    prepareDrivers()
    val driver = ChromeDriver(
        ChromeOptions().apply {
            setBinary("C:\\Users\\mreve\\Desktop\\TPOo3\\src\\drivers\\chrome-win64\\chrome.exe")
        }
    )
    try {
        driver.get("https://auto.ru")

        val clickableElements = driver.findElements(By.xpath("""
            //*[
                @onclick or 
                @role='button' or 
                contains(@class, 'button') or 
                contains(@class, 'btn') or 
                contains(@class, 'clickable') or 
                contains(@class, 'link') or
                self::a
            ][not(ancestor::*[contains(@style, 'display:none')])]
        """.trimIndent()))

        println("Найдено кликабельных элементов: ${clickableElements.size}")

        clickableElements.take(10).forEachIndexed { index, element ->
            println("\n--- Элемент ${index + 1} ---")
            println("Текст: '${element.text.replace("\n", " ").trim()}'")
            println("Тег: ${element.tagName}")
            println("Классы: ${element.getAttribute("class")}")
            //println("XPath: ${getElementXPath(driver, element)}")
            println("Видимый: ${element.isDisplayed}")
        }

    } finally {
        driver.quit()
    }
}