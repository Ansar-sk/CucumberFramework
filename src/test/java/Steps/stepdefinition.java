package Steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefinition {
	
	WebDriver driver;

	@Given("User should start {string}")
	public void user_should_start(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if  (browser.equalsIgnoreCase("edge")) {
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new ChromeDriver();
		}
	}

	@Before
	public void start() {
		System.out.println("Browser started");
	}


	@Given("user should open the app using url {string}")
	public void user_should_open_the_app_using_url(String url) {
		driver.get(url);
	}

	@BeforeStep
	public void screenshot() {
		System.out.println("Screenshot taken");
	}

	@When("user enters username {string} by using xpath {string}")
	public void user_enters_username_by_using_xpath(String text, String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@When("user enters password {string} by using xapth {string}")
	public void user_enters_password_by_using_xapth(String text, String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@Then("user clicks on button using xapth {string}")
	public void user_clicks_on_button_using_xapth(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	@Then("user verifies the title {string}")
	public void user_verifies_the_title(String string) {
		Assert.assertEquals(driver.getTitle(), string);
	}
	
	@When("user clicks on register user using xpath {string}")
	public void user_clicks_on_register_user_using_xpath(String xpath) {
	    driver.findElement(By.xpath(xpath)).click();
	}

	@When("user re-enters password {string} by using xapth {string}")
	public void user_re_enters_password_by_using_xapth(String text, String xpath) {
	   driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@When("user enters fullname {string} by using xapth {string}")
	public void user_enters_fullname_by_using_xapth(String text, String xpath) {
		 driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@When("user enters text {string} by using xapth {string}")
	public void user_enters_text_by_using_xapth(String text, String xpath) {
		 driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@Then("user clicks on checkbox using xapth {string}")
	public void user_clicks_on_checkbox_using_xapth(String xpath) {
	   driver.findElement(By.xpath(xpath)).click();
	}

	@Then("user enter details in registration form")
	public void user_enter_details_in_registration_form(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		/*by using list of list
		List<List<String>> listdata = dataTable.asLists();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(listdata.get(0).get(0));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(listdata.get(0).get(1));
		driver.findElement(By.xpath("//input[@name='re_password']")).sendKeys(listdata.get(0).get(2));
		driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(listdata.get(0).get(3));
		driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(listdata.get(0).get(4));*/
		
		//by using map k,v
		List<Map<String, String>> listdata=dataTable.asMaps();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(listdata.get(0).get("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(listdata.get(0).get("password"));
		driver.findElement(By.xpath("//input[@name='re_password']")).sendKeys(listdata.get(0).get("re-password"));
		driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(listdata.get(0).get("fullname"));
		driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(listdata.get(0).get("mail"));
		
		
		
	}






	@After
	public void teardown() {
		System.out.println("Quit driver");
		driver.quit();
	}

}
