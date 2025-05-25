package itmo.tpo.lab3.usecases

import itmo.tpo.lab3.TestBase
import itmo.tpo.lab3.pages.LoginPage
import itmo.tpo.lab3.pages.SearchPage
import jdk.jfr.Description
import org.junit.jupiter.api.Test

class LoginTest: TestBase() {

    @Test
    @Description("Логин через qr код")
    fun loginUserByQRTest() {
        beginTest(SearchPage.URL) { driver ->
            val searchPage = SearchPage(driver)
            val loginPage = LoginPage(driver)

            searchPage.MenuButtons().clickLoginButton()
            loginPage.clickYaButton()
            loginPage.inputPhone("9520296851")
            loginPage.clickEnterButton()
            doRetryable(140_000) { loginPage.clickUser() }
            loginPage.clickQrButton()
            doRetryable(140_000) { searchPage.clickUser() }
            assert(searchPage.getUserId().text == "id 86944014" )
        }
    }

    @Test
    @Description("Логин через картинку")
    fun loginUserByImageTest() {
        beginTest(LoginPage.URL) { driver ->
            val searchPage = SearchPage(driver)
            val loginPage = LoginPage(driver)

            loginPage.clickYaButton()
            loginPage.inputPhone("9520296851")
            loginPage.clickEnterButton()
            doRetryable(40_000) { loginPage.clickUser() }
            loginPage.clickQrButton()
            doRetryable(40_000) { searchPage.clickUser() }
            assert(searchPage.getUserId().text == "id 86944014" )
        }
    }

    @Test
    @Description("Логин с некорректным номером телефона")
    fun loginWithErrorPhoneTest() {
        beginTest(LoginPage.URL) { driver ->
            val loginPage = LoginPage(driver)

            loginPage.clickYaButton()
            loginPage.inputPhone("952029685434341")
            loginPage.clickEnterButton()
            loginPage.errorElement()
        }
    }

}