package itmo.tpo.lab3


const val BASE_URL = "https://auto.ru"

fun prepareDrivers() {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe")
    System.setProperty("webdriver.gecko.driver", "geckodriver.exe")
}