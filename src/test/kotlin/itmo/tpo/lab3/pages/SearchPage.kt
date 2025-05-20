package itmo.tpo.lab3.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class SearchPage(driver: WebDriver) : BasePage(driver) {

    @FindBy(xpath = "//input")
    private lateinit var inputControl: WebElement

    @FindBy(xpath = "//div[@id='app']/div/div/header/div/div/div[3]/div[2]/div/div/div/div[2]/div[2]/div")
    private lateinit var searchButtonQuery: WebElement

    @FindBy(xpath = "//div[2]/div/div[2]/div/div/a")
    private lateinit var firstPredicateTitle: WebElement

    @FindBy(xpath = "//div[2]/div/div[2]/div/div[2]/div[2]/div[2][@class='ListingItemTechSummaryDesktop__cell']")
    private lateinit var firstPredicateColor: WebElement

    @FindBy(xpath = "//div[2]/div/div[2]/div/div[2]/div/div[3][@class='ListingItemTechSummaryDesktop__cell']")
    private lateinit var firstPredicateType: WebElement

    @FindBy(xpath = "//div[2]/div/div[2]/div[3]/div[@class='ListingItem__year']")
    private lateinit var firstPredicateYear: WebElement

    @FindBy(xpath = "//div[text()='Ничего не найдено']")
    private lateinit var notFound: WebElement

    fun clickSearchButton() =  waitAndClick(inputControl)
    fun inputQuery(query: String) = waitAndType(inputControl, query)
    fun pressEnterQueryButton() =  waitAndClick(searchButtonQuery)
    fun getResult() = waitAndGetElement(firstPredicateTitle)
    fun getColor() = waitAndGetElement(firstPredicateColor)
    fun getType() = waitAndGetElement(firstPredicateType)
    fun getYear() = waitAndGetElement(firstPredicateYear)
    fun getNotFound() = waitAndGetElement(notFound)


}