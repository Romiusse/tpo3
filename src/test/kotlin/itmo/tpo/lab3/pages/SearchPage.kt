package itmo.tpo.lab3.pages

import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.FindBy


class SearchPage(driver: WebDriver) : BasePage(driver) {


    @FindBy(xpath = "//input")
    private lateinit var inputControl: WebElement

    @FindBy(xpath = "//div[@class='SearchLineSuggestItem']")
    private lateinit var searchButtonQuery: WebElement

    @FindBy(xpath = "//div[text()='Ничего не найдено']")
    private lateinit var notFound: WebElement

    @FindBy(xpath = "//img[@class='HeaderUserMenu__userPic']")
    private lateinit var userPhoto: WebElement

    @FindBy(xpath = "//div[@class='HeaderUserMenu__userId']")
    private lateinit var userIdButton: WebElement

    inner class PredictElement(position: Int) {

        private val currentPredictXpath =
            "//div[contains(@class, 'ListingCars_outputType_list')]/div[@class='ListingItem'][$position]"

        private val currentPredict: WebElement
            get() = waitAndGetByXpath(currentPredictXpath)

        private val firstPredicateColor: WebElement
            get() = waitAndGetByXpath(
                currentPredictXpath +
                        "//div[2][@class='ListingItemTechSummaryDesktop__column']/div[2][@class='ListingItemTechSummaryDesktop__cell']"
            )

        private val firstPredicateType: WebElement
            get() = waitAndGetByXpath(
                currentPredictXpath +
                        "//div[@class='ListingItemTechSummaryDesktop__column']/div[3][@class='ListingItemTechSummaryDesktop__cell']"
            )

        private val firstPredicateYear: WebElement
            get() = waitAndGetByXpath(
                currentPredictXpath +
                        "//div[@class='ListingItem__year']"
            )

        private val firstPredicateTitle: WebElement
            get() = waitAndGetByXpath(
                currentPredictXpath +
                        "//div[@class='ListingItemTitle ListingItem__title']/a"
            )

        private val compareButton: WebElement
            get() = waitAndGetByXpath(
                currentPredictXpath +
                        "//div[contains(@class, 'ButtonCompare_type_button')]"
            )

        fun getResult() = waitAndGetElement(firstPredicateTitle)
        fun getColor() = waitAndGetElement(firstPredicateColor)
        fun getType() = waitAndGetElement(firstPredicateType)
        fun getYear() = waitAndGetElement(firstPredicateYear)
        fun clickCompareButton() {
            firefoxMoveTo(compareButton)
            Actions(driver).apply {
                scrollToElement(compareButton).perform()
                moveToElement(compareButton).perform()
            }
            waitAndClick(compareButton)
        }
    }

    inner class MenuButtons : BasePage(driver) {

        @FindBy(xpath = "//div[contains(@class, 'HeaderMyLink_type_favorites')]")
        private lateinit var favoritesButton: WebElement

        @FindBy(xpath = "//div[contains(@class, 'HeaderMyLink_type_searches')]")
        private lateinit var searchButton: WebElement

        @FindBy(xpath = "//a[contains(@class, 'HeaderMyLink_type_compare')]")
        private lateinit var compareButton: WebElement

        @FindBy(xpath = "//a[contains(@class, 'HeaderMyLink_type_compare')]/div[@class='HeaderMyLink__title']")
        private lateinit var compareButtonText: WebElement

        @FindBy(xpath = "//div[contains(@class, 'HeaderMyLink_type_messages')]")
        private lateinit var messagesButton: WebElement

        @FindBy(xpath = "//a[contains(@class, 'HeaderMyLink_type_sales')]")
        private lateinit var salesButton: WebElement

        @FindBy(xpath = "//a[contains(@class, 'HeaderUserMenu__loginButton')]")
        private lateinit var loginButton: WebElement

        fun clickFavoritesButton() = waitAndClick(favoritesButton)
        fun clickSearchButton() = waitAndClick(searchButton)
        fun clickLoginButton() = waitAndClick(loginButton)
        fun clickCompareButton() {
            firefoxMoveTo(compareButtonText)
            Actions(driver).apply {
                scrollToElement(compareButton).perform()
                moveToElement(compareButton).perform()
            }
            waitAndClick(compareButton)
        }
        fun getCompareButtonText(): WebElement {
            firefoxMoveTo(compareButtonText)
            Actions(driver).apply {
                scrollToElement(compareButton).perform()
                moveToElement(compareButton).perform()
            }
            return waitAndGetElement(compareButtonText)
        }

        fun clickMessagesButton() = waitAndClick(messagesButton)
        fun clickSalesButton() = waitAndClick(salesButton)

    }

    fun clickSearchButton() {
        firefoxMoveTo(inputControl)
        waitAndClick(inputControl)
    }
    fun inputQuery(query: String) = waitAndType(inputControl, query)
    fun pressEnterQueryButton() = waitAndClick(searchButtonQuery)
    fun getNotFound() = waitAndGetElement(notFound)

    fun clearInput() {
        waitAndGetElement(inputControl).apply {
            repeat(20) {
                sendKeys(Keys.BACK_SPACE)
            }
        }
    }

    fun clickUser() = waitAndClick(userPhoto)
    fun getUser() = waitAndGetElement(userPhoto)

    fun getUserId() = waitAndGetElement(userIdButton)

    companion object {
        const val URL = "https://auto.ru"
    }
}