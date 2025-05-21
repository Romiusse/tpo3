package itmo.tpo.lab3.usecases

import itmo.tpo.lab3.BASE_URL
import itmo.tpo.lab3.TestBase
import itmo.tpo.lab3.pages.AuthPage
import itmo.tpo.lab3.pages.PlaceAdPage
import org.junit.jupiter.api.Test

class PlaceAdPage : TestBase() {
    @Test
    fun testPlace() {
        drivers.forEach { driver ->
            driver.get(BASE_URL)
            val placeAdPage = PlaceAdPage(driver)
            placeAdPage.openPaceAdPage()
            placeAdPage.fillMarkBlock(mark = "Audi", submark = "Q5")
            placeAdPage.closeClick()
            placeAdPage.openPaceAdPageAgain()
            placeAdPage.fillCharacterBlock(
                yearRelease = "2012",
                genType = "I (8R) Рестайлинг",
                engineType = 2,
                transmissionType = "Робот",
                modificationType = 2,
                colorType = 6,
            )
            //placeAdPage.cClick()
            placeAdPage.fillMileageBlock(mileage = "30000")
            //placeAdPage.cClick()
            placeAdPage.fillPhotoBlock()
            //placeAdPage.cClick()
            //placeAdPage.sClick()
            placeAdPage.fillPtsBlock(year = 3, month = 4)
            //placeAdPage.cClick()
            placeAdPage.fillDescriptionBlock(description = "Крутой автомобиль")
            //placeAdPage.cClick()
            placeAdPage.fillDamageBlock(
                damagePosition = 3,
                damageDescription = "краска стерлась",
                damageTypePosition = 1
            )
            //placeAdPage.cClick()
            placeAdPage.fillAddressBlock(city = "Москва", street = "красногвардейская")
            //placeAdPage.cClick()
            placeAdPage.fillPriceBlock(price = "5000000", withExchange = true)

        }
    }
}