
import org.junit.jupiter.api.*;
import org.junit.jupiter.engine.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationPage {

    private WebDriver driver;


    @BeforeEach
    public void beforeEachTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterEach
    public void afterEachTest() {
        driver.quit();
    }


    @Test
    @DisplayName("Register a new user")
    public void registerANewUser() {

//      Navigate to the login page
       driver.get("https://moneygaming.qa.gameaccount.com/");

//      Click the JOIN NOW button to open the registration page
        WebElement joinNow = driver.findElement(By.xpath("//*[@class='login_links']//*[@class='newUser green']"));
        joinNow.click();

        WebElement titleField = driver.findElement(By.id("title"));
        titleField.click();
//       Select a title value from the dropdown
        WebElement titleSelect = driver.findElement(By.name("map(title)"));
        Select titleDropDown = new Select(titleSelect);
        titleDropDown.selectByValue("Mrs");

//       Enter your first name
        WebElement firstname = driver.findElement(By.id("forename"));
        firstname.sendKeys("TestMiyrem");

//       Enter your surname
        WebElement surname = driver.findElement(By.name("map(lastName)"));
        surname.sendKeys("TestVeizova");

//       Check the tickbox with text 'I accept the Terms and Conditions and certify that I am over the age of 18.'
        WebElement tickbox = driver.findElement(By.xpath("//input[@name='map(terms)']"));
        if (!tickbox.isSelected()) {
            tickbox.click();
        } else {
            System.out.println(" Terms and Conditions button is already selected");
        }
        assertTrue(tickbox.isSelected());

//Submit the form by clicking the JOIN NOW button
        driver.findElement(By.xpath("//input[@id='form']")).click();

//       Validate that a validation message with text ‘This field is required’ appears under the date of birth box
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='signupForm']/fieldset[1]/label[5]"));
        Assertions.assertEquals("This field is required", errorMessage.getText());

    }
}

