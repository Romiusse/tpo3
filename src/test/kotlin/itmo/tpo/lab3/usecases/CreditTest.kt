package itmo.tpo.lab3.usecases

import itmo.tpo.lab3.TestBase
import itmo.tpo.lab3.pages.CreditPage
import jdk.jfr.Description
import org.junit.jupiter.api.Test


class CreditTest : TestBase() {

    @Test
    @Description("Проверка калькулятора кредита")
    fun creditTest() {
        beginTest(CreditPage.URL) { driver ->
            val creditPage = CreditPage(driver)
            creditPage.setCreditSum("120000")
            creditPage.setYear(3)
            val result = creditPage.getResult()
            assert(result == 1600)
        }
    }

}