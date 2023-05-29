package page

//import org.junit.jupiter.api.Test

//import org.junit.jupiter.api.BeforeAll
//import org.junit.jupiter.api.BeforeEach

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.time.Duration


class LoginTest {
    private var driver: WebDriver? = null
    //private var driver: WebDriver = HtmlUnitDriver()


    @BeforeTest
    fun createDriver() {
        System.getProperty("webdriver.chrome.driver", "src/main/kotlin/drivers/chromedriver.exe" )
        driver = ChromeDriver()
    }

    @AfterTest
    fun tearDownDriver() {
       driver!!.quit()

    }

    @Test
    fun openWebPage() {
        val url = "https://pwa-dev.psi-connect.org/"

        driver!!.get(url)

        // Explicit wait
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))

        // Locators
        val userCodeInput = By.xpath("//input[@class='auto_compl loginUserName']")
        val pin1Input = By.cssSelector(".pin1")
        val pin2Input = By.cssSelector(".pin2")
        val pin3Input = By.cssSelector(".pin3")
        val pin4Input = By.cssSelector(".pin4")

        // wait until elements are accessible
        var userCodeInputElement = wait.until(ExpectedConditions.elementToBeClickable(userCodeInput))
        var pin1InputElement = wait.until(ExpectedConditions.elementToBeClickable(pin1Input))
        var pin2InputElement = wait.until(ExpectedConditions.elementToBeClickable(pin2Input))
        var pin3InputElement = wait.until(ExpectedConditions.elementToBeClickable(pin3Input))
        var pin4InputElement = wait.until(ExpectedConditions.elementToBeClickable(pin4Input))


        // Send keys
        userCodeInputElement.clear()
        userCodeInputElement.sendKeys("ZW_TEST_PROV")
        pin1InputElement.clear()
        pin1InputElement.sendKeys("4")
        pin2InputElement.clear()
        pin2InputElement.sendKeys("3")
        pin3InputElement.clear()
        pin3InputElement.sendKeys("2")
        pin4InputElement.clear()
        pin4InputElement.sendKeys("1")

        // wait for the elements to load
        userCodeInputElement = wait.until(ExpectedConditions.elementToBeClickable(userCodeInput))

        Assert.assertEquals(userCodeInputElement.getAttribute("value"), "ZW_TEST_PROV")

    }

    }