package itmo.tpo.lab3.usecases

import itmo.tpo.lab3.TestBase
import itmo.tpo.lab3.pages.ComparePage
import itmo.tpo.lab3.pages.SearchPage
import jdk.jfr.Description
import org.junit.jupiter.api.Test
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration


class CompareCarsTest : TestBase() {

    @Test
    @Description("Проверка счетчика добавленных машин для сравнения")
    fun compareBucketTest() {
        beginTest(SearchPage.URL) { driver ->
            val searchPage = SearchPage(driver)

            // Precondition. Получить список машин
            searchPage.clickSearchButton()
            searchPage.inputQuery("Lada")
            searchPage.pressEnterQueryButton()

            // Step 1. Добавить первую машину для сравнения
            doRetryable {
                searchPage.PredictElement(1).apply {
                    clickCompareButton()
                    // Expected. Счетчик у кнопки сравнения = 1
                    assert(searchPage.MenuButtons().getCompareButtonText().text.contains("1"))
                }
            }

            // Step 2. Добавить вторую машину для сравнения
            doRetryable {
                searchPage.PredictElement(2).apply {
                    clickCompareButton()
                    // Expected. Счетчик у кнопки сравнения = 2
                    assert(searchPage.MenuButtons().getCompareButtonText().text.contains("2"))
                }
            }
        }
    }

    @Test
    @Description("Проверка сравнения двух одинаковых машин")
    fun compareTwoSameCarsTest() {
        beginTest(SearchPage.URL) { driver ->
            val searchPage = SearchPage(driver)
            val comparePage = ComparePage(driver)

            // Precondition. Получить список машин
            searchPage.clickSearchButton()
            searchPage.inputQuery("Kia Rio III Рестайлинг красный")
            searchPage.pressEnterQueryButton()

            // Step 1. Добавить 2 машины в сравнение
            doRetryable {
                searchPage.PredictElement(1).apply {
                    clickCompareButton()
                }
            }
            doRetryable {
                searchPage.PredictElement(2).apply {
                    clickCompareButton()
                }
            }
            // Expected. Параметры у всех машин одинаковые
            doRetryable { searchPage.MenuButtons().clickCompareButton() }
            comparePage.apply {
                getAllParameterValues("Пробег на полном баке").zipWithNext().map { assert(it.second == it.first) }
                getAllParameterValues("Расположение руля").zipWithNext().map { assert(it.second == it.first) }
                getAllParameterValues("Цвет").zipWithNext().map { assert(it.second == it.first) }
            }
        }
    }

    @Test
    @Description("Проверка сравнения четырех одинаковых машин")
    fun compareFourSameCarsTest() {
        beginTest(SearchPage.URL) { driver ->
            val searchPage = SearchPage(driver)
            val comparePage = ComparePage(driver)

            // Precondition. Получить список машин
            searchPage.clickSearchButton()
            searchPage.inputQuery("Kia Rio III Рестайлинг красный")
            searchPage.pressEnterQueryButton()

            // Step 1. Добавить 4 машины в сравнение
            doRetryable {
                searchPage.PredictElement(1).apply {
                    clickCompareButton()
                }
            }
            doRetryable {
                searchPage.PredictElement(2).apply {
                    clickCompareButton()
                }
            }
            doRetryable {
                searchPage.PredictElement(3).apply {
                    clickCompareButton()
                }
            }
            doRetryable {
                searchPage.PredictElement(4).apply {
                    clickCompareButton()
                }
            }

            // Expected. Параметры у всех машин одинаковые
            doRetryable { searchPage.MenuButtons().clickCompareButton() }
            comparePage.apply {
                getAllParameterValues("Пробег на полном баке").zipWithNext().map { assert(it.second == it.first) }
                getAllParameterValues("Расположение руля").zipWithNext().map { assert(it.second == it.first) }
                getAllParameterValues("Цвет").zipWithNext().map { assert(it.second == it.first) }
            }
        }
    }

    @Test
    @Description("Проверка поиска самой дешевой машины")
    fun compareFourSameCarsAndFindLowestPriceTest() {
        beginTest(SearchPage.URL) { driver ->
            val searchPage = SearchPage(driver)
            val comparePage = ComparePage(driver)

            // Precondition. Получить список машин
            searchPage.clickSearchButton()
            searchPage.inputQuery("Kia Rio III Рестайлинг красный")
            searchPage.pressEnterQueryButton()

            // Step 1. Добавить 4 машины в сравнение
            searchPage.PredictElement(1).apply {
                clickCompareButton()
            }

            doRetryable {
                searchPage.PredictElement(2).apply {
                    clickCompareButton()
                }
            }
            doRetryable {
                searchPage.PredictElement(3).apply {
                    clickCompareButton()
                }
            }
            doRetryable {
                searchPage.PredictElement(4).apply {
                    clickCompareButton()
                }
            }

            // Expected. Найдена минимальная цена
            doRetryable { searchPage.MenuButtons().clickCompareButton() }
            val lowestPrice = comparePage.getAllPrices().min()
        }
    }

    @Test
    @Description("Проверка сравнения дорогой и дешевой машины")
    fun compareChipAndExpensiveCarsTest() {
        beginTest(SearchPage.URL) { driver ->
            val searchPage = SearchPage(driver)
            val comparePage = ComparePage(driver)

            // Step 1. Добавить 2 машины в сравнение
            searchPage.clickSearchButton()
            searchPage.inputQuery("Лада")
            searchPage.pressEnterQueryButton()

            doRetryable {
                searchPage.PredictElement(1).apply {
                    clickCompareButton()
                }
            }

            searchPage.clickSearchButton()
            searchPage.clearInput()
            searchPage.inputQuery("Porsche")
            doRetryable { searchPage.pressEnterQueryButton() }

            searchPage.waitLoading()

            doRetryable {
                searchPage.PredictElement(1).apply {
                    clickCompareButton()
                }
            }

            // Expected. Первая машина дешевле
            doRetryable { searchPage.MenuButtons().clickCompareButton() }
            comparePage.getAllPrices().apply {
                assert(first() > last())
            }
        }
    }
}