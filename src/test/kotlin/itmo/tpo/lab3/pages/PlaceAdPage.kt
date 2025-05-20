package itmo.tpo.lab3.pages

import itmo.tpo.lab3.TestBase
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class PlaceAdPage(driver: WebDriver) : BasePage(driver) {

    @FindBy(xpath = "//div[@id='app']/div/div/header/div/div/div[4]/a[2]/div")
    private lateinit var sellButton: WebElement

    @FindBy(xpath = "//div[@id=\'app\']/div/div/div/div[4]/div/div[4]/div[2]/div[2]/div[4]/a/span/span")
    private lateinit var placeAdButton: WebElement

    @FindBy(xpath = "//div[@id=\'app\']/div/div/div[2]/div/div[3]/span[@class=\'Link OfferInitialScreenCarInfo__handMadeButton-DP9Gg\']")
    private lateinit var handWriteButton: WebElement

    @FindBy(xpath = "//div[@id='app']/div/div/div[2]/div/div[3]/span[@class='Link Link_hovered OfferInitialScreenCarInfo__handMadeButton-DP9Gg']")
    private lateinit var handWriteButtonSelected: WebElement


    /**
     * Марка
     */
    @FindBy(xpath = "//input[@name='tech.mark']")
    private lateinit var searchField: WebElement

    @FindBy(xpath = "//div[@id=\\'tech.mark\\']/ul/li/a/div/img")
    private lateinit var markButton: WebElement

    private fun submarkButton(itemProp: String): WebElement {
        return driver.findElement(By.xpath("//a[@itemprop='$itemProp']"))
    }

    /**
     * Характеристики
     */
    private fun yearReleaseButton(year: String): WebElement {
        return driver.findElement(By.xpath("//span[text()='$year']"))
    }

    private fun genButton(position: Int): WebElement {
        return driver.findElement(By.xpath("//div[@id=\'tech.super_gen\']/label[${position}]/span/span"))
    }

    private fun engineButton(position: Int): WebElement {
        return driver.findElement(By.xpath("//div[@id=\'tech.engine_type\']/div/span[$position]/button/span"))
    }

    private fun transmissionButton(position: Int): WebElement {
        return driver.findElement(By.xpath("//div[@id=\'tech.transmission\']/div/span[$position]/button/span/div"))
    }

    private fun modificationButton(position: Int): WebElement {
        return driver.findElement(By.xpath("//div[@id=\'tech.tech_param\']/label[$position]/span/span"))
    }

    private fun colorButton(position: Int): WebElement {
        return driver.findElement(By.xpath("//div[@id=\'tech.color\']/div[$position]"))
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
    @FindBy(xpath = "//div[@id=\'pts.pts_status\']/div[2]/span[3]/button/span/span")
    private lateinit var noPtsButton: WebElement

    @FindBy(xpath = "//div[@id=\'pts.purchase_date\']/div[2]/div/button")
    private lateinit var purchaseYearButton: WebElement

    @FindBy(xpath = "//div[@id=\'pts.purchase_date\']/div[2]/div[2]/button")
    private lateinit var purchaseMonthButton: WebElement

    private fun purchaseSelectButton(position: Int): WebElement {
        return driver.findElement(By.xpath("//div[@class=\'MenuItem MenuItem_size_m MenuItem_hover-color_blue\'][${position}]"))
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
        return driver.findElement(By.xpath("//div[@id=\'section-damages\']/div[2]/div/div/div/div[2]/div/div/div[$position]/div"))
    }

    private fun damageSectionSelectButton(position: Int): WebElement {
        return driver.findElement(By.xpath("//span/label[$position]/span/span"))
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

    fun openPaceAdPage() {
        waitAndClick(sellButton)
        waitAndClick(placeAdButton)
        waitAndClick(handWriteButton)
        waitAndClick(handWriteButtonSelected)
    }

    fun fillMarkBlock(mark: String, submark: String) {
        waitAndType(searchField, mark)
        waitAndClick(markButton)
        waitAndClick(submarkButton(submark))
    }

    fun fillCharacterBlock(
        yearRelease: String,
        genType: Int,
        engineType: Int,
        transmissionType: Int,
        modificationType: Int,
        colorType: Int
    ) {
        waitAndClick(yearReleaseButton(yearRelease))
        waitAndClick(genButton(genType))
        waitAndClick(engineButton(engineType))
        waitAndClick(transmissionButton(transmissionType))
        waitAndClick(modificationButton(modificationType))
        waitAndClick(colorButton(colorType))
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
}