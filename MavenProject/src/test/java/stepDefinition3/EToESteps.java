package stepDefinition3;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EToESteps {
	public WebDriver driver;
	public Actions act;
	@Given("^User is on Login Page$")
	public void user_is_on_Login_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "F:\\MavenProject\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		   
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("user_is_on_Login_Page");
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("lileshshinde21@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("rockyrocks123");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		System.out.println("user_enters_UserName_and_Password");  
		Thread.sleep(2000);
	}

	@Then("^User is on Flipkart Homepage$")
	public void user_is_on_Flipkart_Homepage() throws Throwable {
		act = new Actions(driver);
		WebElement lilesh = driver.findElement(By.xpath("//div[text()='Lilesh']"));
		act.moveToElement(lilesh).perform();
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='pO9syL undefined']//child::li"));
		if(list.size() != 0)
		{
			for(WebElement listtext : list)
			{
				System.out.println(listtext.getText());
			}
		}
		System.out.println("user_is_on_Flipkart_Homepage");
	}

	@Then("^Massage displayed Login Successfully$")
	public void massage_displayed_Login_Successfully() throws Throwable {
		System.out.println("massage_displayed_Login_Successfully");
	}

	@Then("^User searching for the product$")
	public void user_searching_for_the_product() throws Throwable {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mobiles");
    	Thread.sleep(2000);
		WebElement btn = driver.findElement(By.xpath("//button[@type='submit']"));
    	btn.click();
		
		System.out.println("user_searching_for_the_product");
	}

	@Then("^User adding the product into cart$")
	public void user_adding_the_product_into_cart() throws Throwable {
		String mainwindow = driver.getWindowHandle();
   	    driver.findElement(By.xpath("//div[text()='POCO C31 (Royal Blue, 64 GB)']")).click();
		Set<String> childwindows = driver.getWindowHandles();
   	    Iterator<String> itr = childwindows.iterator();
   	    while(itr.hasNext())
   	    {
   		   String childwindow = itr.next();
   		   if(!mainwindow.equals(childwindow))
   		   {
   			  driver.switchTo().window(childwindow);
   			  driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
   		   }
   	    }	    	
		System.out.println("user_adding_the_product_into_cart");
		Thread.sleep(2000);
	}

	@Then("^User logout form application$")
	public void user_logout_form_application() throws Throwable {
		act = new Actions(driver);
		WebElement lilesh = driver.findElement(By.xpath("//div[text()='Lilesh']"));
		act.moveToElement(lilesh).perform();
		driver.findElement(By.xpath("//div[text()='Logout']")).click();
		System.out.println("user_logout_form_application");
	}

	@Then("^Logout massage displayed successfully$")
	public void logout_massage_displayed_successfully() throws Throwable {
		driver.quit();
		System.out.println("logout_massage_displayed_successfully");
	}
	
}
