package itmo.tpo.lab3

import kotlinx.coroutines.*
import org.junit.jupiter.api.BeforeAll
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions

open class TestBase {

    fun beginTest(url: String, test: (WebDriver) -> Unit) = runBlocking {
        drivers.map { driver ->
            launch(Dispatchers.Default) {
                driver.manage().deleteAllCookies()
                driver.manage().window().maximize()
                driver.get(url)
                test(driver)
                driver.quit()
            }
        }.joinAll()
    }

    fun doRetryable(timeout: Int = 10_000, action: () -> Unit) {
        val currentTime = System.currentTimeMillis()
        while (System.currentTimeMillis() - currentTime < timeout) {
            try {
                action()
                return
            } catch (e: Error) {
                Thread.sleep(50)
            } catch (e: Exception) {
                Thread.sleep(50)
            }
        }
        throw RuntimeException("timeout")
    }



    companion object {
        lateinit var drivers: List<WebDriver>

        @BeforeAll
        @JvmStatic
        fun setUp() {
            prepareDrivers()
            drivers = listOf(ChromeDriver(ChromeOptions()), FirefoxDriver(FirefoxOptions()))
            //drivers = listOf(FirefoxDriver(FirefoxOptions()))
            //drivers = listOf(ChromeDriver(ChromeOptions()))
        }
    }
}