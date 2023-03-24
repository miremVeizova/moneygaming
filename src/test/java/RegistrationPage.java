import dev.failsafe.internal.util.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationPage {

    private WebDriver driver;
     WebDriverWait wait;

    @BeforeEach
    public void beforeEachTest() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://moneygaming.qa.gameaccount.com/");

    }

    @AfterEach
    public void afterEachTest() {
        driver.quit();
    }


   @Test
    @DisplayName("Register a new user")
    public void registerANewUser(){

//       //Check that the navigation was successful
//       WebElement loginHeading = driver.findElement(By.xpath("//*[@class='header']//*[@title='MoneyGaming']"));
//       Assertions.assertEquals("MoneyGaming", loginHeading.getText());

        //Click the JOIN NOW button to open the registration page
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

//       Enter your last name
       WebElement lastname = driver.findElement(By.name("map(lastName)"));
       lastname.sendKeys("TestVeizova");

//       Check the tickbox with text 'I accept the Terms and Conditions and certify that I am over the age of 18.'
       WebElement tickbox = driver.findElement(By.xpath("//input[@name='map(terms)']"));
           if(!tickbox.isSelected()){
            tickbox.click();
        } else{
            System.out.println(" Terms and Conditions button is already selected");
        }
       assertTrue(tickbox.isSelected());

//Submit the form by clicking the JOIN NOW button
       driver.findElement(By.xpath("//input[@id='form']")).click();

//       Validate that a validation message with text ‘This field is required’ appears under the date of birth box
       WebElement errorMessage = driver.findElement(By.xpath("//*[@class='dobDay inline required error']"));
       Assertions.assertEquals("This field is required", errorMessage.getText());




//       assertTrue(driver.getPageSource().contains("Your order has been placed!"));
//       public void validateAttributeValueInElement(WebElement element, String att, String expectedValue){
//           String actualValue = element.getAttribute(att);
//           Assert.assertTrue(actualValue.contains(expectedValue));
//       WebElement tickbox = driver.findElement(By.xpath("//input[@name='map(terms)']"));
//      Select termsAndConditionsSelect = new Select(tickbox);
//        if(!tickbox.isSelected()){
//            tickbox.click();
//        } else{
//            System.out.println(" Terms and Conditions button is already selected");
//        }
//       assertTrue(tickbox.isSelected());

//       WebElement daySelect = driver.findElement(By.id("dobDay"));
//       Select dayDropDown = new Select(daySelect);
//       dayDropDown.selectByValue("19");
//       WebElement monthSelect = driver.findElement(By.id("dobMonth"));
//       Select monthDropDown = new Select (monthSelect);
//      monthDropDown.selectByValue("03");
//       WebElement yearSelect = driver.findElement(By.id("dobYear"));
//       Select yearDropDown = new Select(yearSelect);
//       yearDropDown.selectByValue("1978");
//       driver.findElement(By.name("map(email)"));
//       String prefix = RandomStringUtils.randomAlphabetic(7);
//       String domainPrefix = RandomStringUtils.randomAlphabetic(5);
//       String mainDomain = RandomStringUtils.randomAlphabetic(3);
//       String emailAddress = prefix + "@" + domainPrefix + "." + mainDomain;
//       driver.findElement(By.name("map(email)")).sendKeys(emailAddress);

   }
   }
