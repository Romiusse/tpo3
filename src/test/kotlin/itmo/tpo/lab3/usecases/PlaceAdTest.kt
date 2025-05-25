package itmo.tpo.lab3.usecases

import itmo.tpo.lab3.TestBase
import itmo.tpo.lab3.pages.PlaceAdPage
import itmo.tpo.lab3.pages.SearchPage
import jdk.jfr.Description
import org.junit.jupiter.api.Test

class PlaceAdTest : TestBase() {

    @Test
    @Description("Проверка сохранения черновика")
    fun testDraftSaveTest() {
        beginTest(PlaceAdPage.URL) { driver ->
            val searchPage = SearchPage(driver)
            val placeAdPage = PlaceAdPage(driver)

            // Precondition. замокать черновик
            placeAdPage.openPaceAdPage()
            placeAdPage.fillMarkBlock(mark = "Audi", submark = "Q5")
            placeAdPage.fillCharacterBlock(
                yearRelease = "2012",
                genType = "I (8R) Рестайлинг",
                engineType = "Бензин",
                transmissionType = "Автомат",
                modificationType = 2,
                colorType = 6,
            )
            placeAdPage.cClick()
            placeAdPage.fillMileageBlock(mileage = "30000")
            placeAdPage.cClick()
            placeAdPage.fillPhotoBlock()
            placeAdPage.cClick()
            placeAdPage.sClick()
            placeAdPage.fillPtsBlock(year = 3, month = 4)
            placeAdPage.cClick()
            placeAdPage.fillDescriptionBlock(description = "Крутой автомобиль")
            placeAdPage.cClick()
            placeAdPage.fillDamageBlock(
                damagePosition = 3,
                damageDescription = "краска стерлась",
                damageTypePosition = 1
            )
            placeAdPage.closeClick()
            searchPage.MenuButtons().clickSalesButton()
            // Этап 1. Открыть черновик
            val title = placeAdPage.getDraftTitle()
            // Expected. Заголовок черновика совпадает с маркой
            assert(title.contains("Audi"))
        }
    }

    @Test
    @Description("Проверка возможности продолжить заполнения после выхода")
    fun continueFillFromDraft() {
        beginTest(PlaceAdPage.URL) { driver ->
            val searchPage = SearchPage(driver)
            val placeAdPage = PlaceAdPage(driver)

            // Этап 1. Начать заполнение
            placeAdPage.openPaceAdPage()
            placeAdPage.fillMarkBlock(mark = "BMW", submark = "X5")
            placeAdPage.fillCharacterBlock(
                yearRelease = "2012",
                engineType = "Дизель",
                modificationType = 1,
                colorType = 6,
            )

            // Этап 2. Выйти
            placeAdPage.closeClick()

            // Этап 3. Открыть черновик
            searchPage.MenuButtons().clickSalesButton()
            placeAdPage.openPaceAdPageAgain()

            // Этап 4. Продолжить заполнять незаполненные поля
            placeAdPage.LeftMenu().clickprobeg()
            placeAdPage.fillMileageBlock(mileage = "30000")
            placeAdPage.LeftMenu().clickPhoto()
            placeAdPage.fillPhotoBlock()
            placeAdPage.LeftMenu().clickpts()
            placeAdPage.fillPtsBlock(year = 3, month = 4)
            placeAdPage.LeftMenu().clickdesc()
            placeAdPage.fillDescriptionBlock(description = "Крутой автомобиль")
            placeAdPage.LeftMenu().clickdamage()
            placeAdPage.fillDamageBlock(
                damagePosition = 3,
                damageDescription = "краска стерлась",
                damageTypePosition = 1
            )
            placeAdPage.LeftMenu().clickplace()
            placeAdPage.fillAddressBlock(city = "Москва", street = "красногвардейская")
            placeAdPage.LeftMenu().clickprice()
            placeAdPage.fillPriceBlock("30000000")
        }
    }
}