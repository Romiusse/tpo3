package itmo.tpo.lab3.usecases

import itmo.tpo.lab3.BASE_URL
import itmo.tpo.lab3.TestBase
import itmo.tpo.lab3.pages.SearchPage
import org.junit.jupiter.api.Test

class CarSearchTest: TestBase() {

    @Test
    fun testSearch() {
        val query = "BMW X5"

        drivers.forEach { driver ->
            driver.get(BASE_URL);
            val searchPage = SearchPage(driver)
            searchPage.clickSearchButton()
            searchPage.inputQuery(query)
            searchPage.pressEnterQueryButton()
            val result = searchPage.getResult()
            assert(result.text.contains(query))
        }
    }

    @Test
    fun testSearchByColor() {
        val query = "красный"

        drivers.forEach { driver ->
            driver.get(BASE_URL);
            val searchPage = SearchPage(driver)
            searchPage.clickSearchButton()
            searchPage.inputQuery(query)
            searchPage.pressEnterQueryButton()
            val result = searchPage.getColor()
            assert(result.text.contains(query))
        }
    }

    @Test
    fun testSearchByType() {
        val query = "седан"

        drivers.forEach { driver ->
            driver.get(BASE_URL);
            val searchPage = SearchPage(driver)
            searchPage.clickSearchButton()
            searchPage.inputQuery(query)
            searchPage.pressEnterQueryButton()
            val result = searchPage.getType()
            assert(result.text.contains(query))
        }
    }

    @Test
    fun testSearchByYear() {
        val query = "2000"

        drivers.forEach { driver ->
            driver.get(BASE_URL);
            val searchPage = SearchPage(driver)
            searchPage.clickSearchButton()
            searchPage.inputQuery(query)
            searchPage.pressEnterQueryButton()
            val result = searchPage.getYear()
            assert(result.text.contains(query))
        }
    }

    @Test
    fun testSearchInvalid() {
        val query = "werweqtiqewugoihgwe"

        drivers.forEach { driver ->
            driver.get(BASE_URL);
            val searchPage = SearchPage(driver)
            searchPage.clickSearchButton()
            searchPage.inputQuery(query)
            val notFoundResult = searchPage.getNotFound()
        }
    }

}