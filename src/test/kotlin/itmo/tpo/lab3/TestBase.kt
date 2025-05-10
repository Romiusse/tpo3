package itmo.tpo.lab3

import org.junit.jupiter.api.BeforeAll
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

open class TestBase {
    companion object {
        lateinit var drivers: List<WebDriver>

        @BeforeAll
        @JvmStatic
        fun setUp() {
            prepareDrivers()
            drivers = listOf(ChromeDriver(), FirefoxDriver())
        }
    }
}