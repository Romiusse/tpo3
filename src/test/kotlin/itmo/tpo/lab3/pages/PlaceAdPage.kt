package itmo.tpo.lab3.pages

import itmo.tpo.lab3.TestBase
import org.openqa.selenium.*
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.FindBy

class PlaceAdPage(driver: WebDriver) : BasePage(driver) {


    inner class LeftMenu : BasePage(driver) {
        @FindBy(xpath = "//div[text()='Пробег']")
        lateinit var probeg: WebElement

        @FindBy(xpath = "//div[text()='Фото']")
        lateinit var photo: WebElement

        @FindBy(xpath = "//div[text()='Опции']")
        lateinit var options: WebElement

        @FindBy(xpath = "//div[text()='ПТС']")
        lateinit var pts: WebElement

        @FindBy(xpath = "//div[text()='Описание']")
        lateinit var desc: WebElement

        @FindBy(xpath = "//div[text()='Повреждения']")
        lateinit var damage: WebElement

        @FindBy(xpath = "//div[text()='Место осмотра']")
        lateinit var place: WebElement

        @FindBy(xpath = "//div[text()='Цена']")
        lateinit var price: WebElement

        fun clickprobeg() = waitAndClick(probeg)
        fun clickPhoto() = waitAndClick(photo)
        fun clickoptions() = waitAndClick(options)
        fun clickpts() = waitAndClick(pts)
        fun clickdesc() = waitAndClick(desc)
        fun clickdamage() = waitAndClick(damage)
        fun clickplace() = waitAndClick(place)
        fun clickprice() = waitAndClick(price)

    }

    @FindBy(xpath = "//a[contains(@class, 'SalesItemTitle_inactiveEditable')]")
    private lateinit var contButton: WebElement

    @FindBy(xpath = "//span[text()='Разместить объявление']")
    private lateinit var placeAdButton: WebElement

    @FindBy(xpath = "//span[text()='Заполню всё вручную']")
    private lateinit var handWriteButton: WebElement

    /**
     * Марка
     */
    @FindBy(xpath = "//input[@name='tech.mark']")
    private lateinit var searchField: WebElement

    @FindBy(xpath = "//div[@id=\'tech.mark\']/ul/li/a/div/img")
    private lateinit var markButton: WebElement

    @FindBy(xpath = "(//input[@name='tech.mark'])[2]")
    private lateinit var subSearchField: WebElement

    @FindBy(xpath = "//a[contains(@class, 'ModelField__modelsListItem')]")
    private lateinit var subMarkButton: WebElement

    /**
     * Характеристики
     */
    private fun yearReleaseButton(year: String): WebElement {
        return waitAndGetByXpath("//span[text()=\'$year\']")
    }

    private fun genButton(gen: String): WebElement {
        return waitAndGetByXpath("//span[text()='$gen']")
    }

    private fun engineButton(engine: String): WebElement {
        return waitAndGetByXpath("//div[text()='$engine']")
    }

    private fun transmissionButton(trnsmission: String): WebElement {
        return waitAndGetByXpath("//div[text()='$trnsmission']")
    }

    private fun modificationButton(position: Int): WebElement {
        return waitAndGetByXpath("//div[@id='tech.tech_param']/label[$position]/span/span")
    }

    private fun colorButton(position: Int): WebElement {
        return waitAndGetByXpath("//div[@id=\'tech.color\']/div[$position]")
    }

    /**
     * ПРОБЕГ
     */
    @FindBy(xpath = "//input[@id=\'mileage.mileage\']")
    private lateinit var mileageButton: WebElement

    /**
     * ФОТО
     */
    @FindBy(xpath = "//div[@id=\'photos.without_photos\']/label/span/span")
    private lateinit var skipPhotoButton: WebElement

    /**
     * ПТС
     */
    @FindBy(xpath = "//span[text()='Нет ПТС']")
    private lateinit var noPtsButton: WebElement

    @FindBy(xpath = "//div[@id=\'pts.purchase_date\']/div[2]/div/button")
    private lateinit var purchaseYearButton: WebElement

    @FindBy(xpath = "//div[@id=\'pts.purchase_date\']/div[2]/div[2]/button")
    private lateinit var purchaseMonthButton: WebElement

    private fun purchaseSelectButton(position: Int): WebElement {
        return waitAndGetByXpath("//div[@class=\'MenuItem MenuItem_size_m MenuItem_hover-color_blue\'][${position}]")
    }

    /**
     * ОПИСАНИЕ
     */
    @FindBy(xpath = "//textarea[@name=\'description.description\']")
    private lateinit var descriptionField: WebElement

    /**
     * ПОВРЕЖДЕНИЯ
     */
    private fun damageSectionButton(position: Int): WebElement {
        return waitAndGetByXpath("//div[@id=\'section-damages\']/div[2]/div/div/div/div[2]/div/div/div[$position]/div")
    }

    private fun damageSectionSelectButton(position: Int): WebElement {
        return waitAndGetByXpath("//span/label[$position]/span/span")
    }

    @FindBy(xpath = "//div[2]/div/textarea")
    private lateinit var damageDescriptionField: WebElement

    @FindBy(xpath = "//div[@class=\'DamagePopup\']/button")
    private lateinit var damageSaveButton: WebElement

    /**
     * МЕСТО ОСМТОРА
     */
    @FindBy(xpath = "//div[@id=\'address.location\']/div/label/div/span/div[2]/input")
    private lateinit var cityField: WebElement

    @FindBy(xpath = "//div[@id=\'address.location\']/div/div/div/div/div/div")
    private lateinit var selectCityButton: WebElement

    @FindBy(xpath = "//div[@id=\'address.location\']/div[2]/label/div/span/div[2]/input")
    private lateinit var streetField: WebElement

    @FindBy(xpath = "//div[@id=\'address.location\']/div/div/div/div/div/div")
    private lateinit var selectStreetButton: WebElement

    @FindBy(xpath = "//div[@id=\'section-address\']/div[2]/div/div/div[2]/label/span/span")
    private lateinit var onlineViewButton: WebElement

    /**
     * ЦЕНА
     */
    @FindBy(xpath = "(//input[@value=\'\'])[10]")
    private lateinit var priceField: WebElement

    @FindBy(xpath = "//div[@id=\'price.exchange\']/label/span/span")
    private lateinit var changeButton: WebElement

    @FindBy(xpath = "//span[text()='Продолжить']")
    private lateinit var сButton: WebElement

    @FindBy(xpath = "//span[text()='Пропустить']")
    private lateinit var sButton: WebElement

    @FindBy(xpath = "//a[text()='Закрыть']")
    private lateinit var closeButton: WebElement

    fun cClick() {
        Actions(driver).scrollByAmount(0, 300).perform()
        waitAndClick(сButton)
    }

    fun sClick() {
        Actions(driver).scrollByAmount(0, 300).perform()
        waitAndClick(sButton)
    }

    fun closeClick() {
        waitAndClick(closeButton)
    }

    fun openPaceAdPage() {
        waitAndClick(placeAdButton)
        waitAndClick(handWriteButton)
    }

    fun openPaceAdPageAgain() {
        waitAndClick(contButton)
        driver.switchTo().window(driver.windowHandles.last())
    }

    fun fillMarkBlock(mark: String, submark: String) {
        waitAndType(searchField, mark)
        waitAndClick(markButton)
        waitAndType(subSearchField, submark)
        waitAndClick(subMarkButton)
    }

    fun fillCharacterBlock(
        yearRelease: String,
        genType: String? = null,
        engineType: String? = null,
        transmissionType: String? = null,
        modificationType: Int? = null,
        colorType: Int? = null,
    ) {
        waitAndClick(yearReleaseButton(yearRelease))
        genType?.let { waitAndClick(genButton(it)) }
        engineType?.let { waitAndClick(engineButton(it)) }
        transmissionType?.let { waitAndClick(transmissionButton(it)) }
        modificationType?.let { waitAndClick(modificationButton(it)) }
        colorType?.let { waitAndClick(colorButton(it)) }
    }

    fun fillMileageBlock(mileage: String) {
        waitAndType(mileageButton, mileage)
    }

    fun fillPhotoBlock() {
        waitAndClick(skipPhotoButton)
    }

    fun fillPtsBlock(year: Int, month: Int) {
        waitAndClick(noPtsButton)
        waitAndClick(purchaseYearButton)
        waitAndClick(purchaseSelectButton(year))
        waitAndClick(purchaseMonthButton)
        waitAndClick(purchaseSelectButton(month))
    }

    fun fillDescriptionBlock(description: String) {
        waitAndType(descriptionField, description)
    }

    fun fillDamageBlock(
        damagePosition: Int,
        damageTypePosition: Int,
        damageDescription: String? = null
    ) {
        waitAndClick(damageSectionButton(damagePosition))
        waitAndClick(damageSectionSelectButton(damageTypePosition))

        damageDescription?.let {
            waitAndType(damageDescriptionField, it)
        }
        waitAndClick(damageSaveButton)
    }

    fun fillAddressBlock(
        city: String,
        street: String,
        onlineView: Boolean = false
    ) {
        waitAndGetElement(cityField).apply {
            repeat(20) {
                sendKeys(Keys.BACK_SPACE)
            }
        }
        waitAndType(cityField, city)
        waitAndClick(selectCityButton)
        waitAndType(streetField, street)
        waitAndClick(selectStreetButton)

        if (onlineView) {
            waitAndClick(onlineViewButton)
        }
    }

    fun fillPriceBlock(price: String, withExchange: Boolean = false) {
        waitAndType(priceField, price)

        if (withExchange) {
            waitAndClick(changeButton)
        }
    }

    fun getDraftTitle(): String {
        return waitAndGetElement(contButton).text
    }

    companion object {
        const val URL = "https://auto.ru/my/all/"
    }
}