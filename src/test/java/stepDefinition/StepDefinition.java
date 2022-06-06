package stepDefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)


public class StepDefinition {
	public static WebDriver driver;

	@Given("Initialize the browser with Chrome")
	public void initialize_the_browser_with_Chrome() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/insurance/v1/index.php");

	}

	@When("User clicks on Register button from Login Page")
	public void user_clicks_on_Register_button_from_Login_Page() throws Throwable {
		WebElement register = driver.findElement(By.linkText("Register"));
		register.click();

	}

	@Then("User navigate on the Registration page")
	public void user_navigate_on_the_Registration_page() throws Throwable {

		System.out.println("User is on Registration page");

	}

	@When("User select and enter the valid data on the registration page and click on the Register button")
	public void user_select_and_enter_the_valid_data_on_the_registration_page_and_click_on_the_Register_button() throws Throwable {
		WebElement title = driver.findElement(By.id("user_title"));
		Select title1 = new Select(title);
		title1.selectByValue("Doctor");

		WebElement firstname = driver.findElement(By.id("user_firstname"));
		firstname.sendKeys("FirstTest");

		WebElement lastname = driver.findElement(By.name("lastname"));
		lastname.sendKeys("LastTest");

		WebElement phone = driver.findElement(By.id("user_phone"));
		phone.sendKeys("9565458956");

		Thread.sleep(2000);
		WebElement year = driver.findElement(By.xpath("//select[@id='user_dateofbirth_1i']"));
		Select year1 = new Select(year);
		year1.selectByValue("1988");

		Thread.sleep(2000);
		WebElement month = driver.findElement(By.xpath("//select[@id='user_dateofbirth_2i']"));
		Select month1 = new Select(month);
		month1.selectByValue("10");

		Thread.sleep(2000);
		WebElement day = driver.findElement(By.xpath("//select[@id='user_dateofbirth_3i']"));
		Select day1 = new Select(day);
		day1.selectByValue("16");

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebElement radioprovisional = driver.findElement(By.id("licencetype_f"));
		radioprovisional.click();

		WebElement licenceperiod = driver.findElement(By.xpath("//select[@id='user_licenceperiod']"));
		Select licenceperiod1 = new Select(licenceperiod);
		licenceperiod1.selectByIndex(6);

		WebElement occupation = driver.findElement(By.xpath("//select[@id='user_occupation_id']"));
		Select occupation1 = new Select(occupation);
		occupation1.selectByIndex(11);

		WebElement streetaddress = driver.findElement(By.id("user_address_attributes_street"));
		streetaddress.sendKeys("Gujrat");

		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys("Ahemdabad");

		WebElement country = driver.findElement(By.name("county"));
		country.sendKeys("India");

		driver.findElement(By.name("post_code")).sendKeys("380063");

		driver.findElement(By.name("email")).sendKeys("test@gmail.com");

		WebElement password = driver.findElement(By.id("user_user_detail_attributes_password"));
		password.sendKeys("Test@123");
		WebElement confirmpassword = driver.findElement(By.name("c_password"));
		confirmpassword.sendKeys("Test@123");

		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();

	}

	@Then("User navigate to the Login page again")
	public void user_navigate_to_the_Login_page_again() throws Throwable {

		System.out.println("User is on Login Page");
		
		driver.quit();

	}


}
