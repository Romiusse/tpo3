package itmo.tpo.lab3.usecases

import itmo.tpo.lab3.BASE_URL
import itmo.tpo.lab3.TestBase
import itmo.tpo.lab3.pages.AuthPage
import org.junit.jupiter.api.Test

class AuthTest : TestBase() {
    @Test
    fun testLogin() {
        drivers.forEach { driver ->
            driver.get(BASE_URL)
            val authPage = AuthPage(driver)
            authPage.clickLoginButton()
            authPage.clickAutoRuButton()
            authPage.enterEmail("test@example.com")
            authPage.clickNextButton()
            authPage.enterPassword("password123")
            // Проверка успешной авторизации
            assert(driver.currentUrl.contains("profile"))
            driver.quit()
        }
    }
}