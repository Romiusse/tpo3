package itmo.tpo.lab3.usecases

import itmo.tpo.lab3.TestBase
import itmo.tpo.lab3.pages.SearchPage
import jdk.jfr.Description
import org.junit.jupiter.api.Test

class CarSearchTest: TestBase() {

    @Test
    @Description("Проверка поиска по марке")
    fun testSearch() {
        val query = "BMW X5"
        beginTest(SearchPage.URL) { driver ->
            val searchPage = SearchPage(driver)
            searchPage.clickSearchButton()
            searchPage.inputQuery(query)
            searchPage.pressEnterQueryButton()
            val result = searchPage.PredictElement(1).getResult()
            assert(result.text.contains(query))
        }
    }

    @Test
    @Description("Проверка поиска по цвету")
    fun testSearchByColor() {
        val query = "красный"
        beginTest(SearchPage.URL) { driver ->
            val searchPage = SearchPage(driver)
            searchPage.clickSearchButton()
            searchPage.inputQuery(query)
            searchPage.pressEnterQueryButton()
            val result = searchPage.PredictElement(1).getColor()
            assert(result.text.contains(query))
        }
    }

    @Test
    @Description("Проверка поиска по типу кузова")
    fun testSearchByType() {
        val query = "седан"
        beginTest(SearchPage.URL) { driver ->
            val searchPage = SearchPage(driver)
            searchPage.clickSearchButton()
            searchPage.inputQuery(query)
            searchPage.pressEnterQueryButton()
            val result = searchPage.PredictElement(1).getType()
            assert(result.text.contains(query))
        }
    }

    @Test
    @Description("Проверка поиска по году выпуска")
    fun testSearchByYear() {
        val query = "2000"
        beginTest(SearchPage.URL) { driver ->
            val searchPage = SearchPage(driver)
            searchPage.clickSearchButton()
            searchPage.inputQuery(query)
            searchPage.pressEnterQueryButton()
            val result = searchPage.PredictElement(1).getYear()
            assert(result.text.contains(query))
        }
    }

    @Test
    @Description("Проверка невалидных данных")
    fun testSearchInvalid() {
        val query = "werweqtiqewugoihgwe"
        beginTest(SearchPage.URL) { driver ->
            val searchPage = SearchPage(driver)
            searchPage.clickSearchButton()
            searchPage.inputQuery(query)
            val notFoundResult = searchPage.getNotFound()
        }
    }

}