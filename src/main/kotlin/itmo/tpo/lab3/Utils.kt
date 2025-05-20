package itmo.tpo.lab3


const val BASE_URL = "https://auto.ru"

fun prepareDrivers() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\mreve\\Desktop\\TPOo3\\src\\drivers\\chromedriver.exe")
    //System.setProperty("webdriver.gecko.driver", "geckodriver.exe")
}