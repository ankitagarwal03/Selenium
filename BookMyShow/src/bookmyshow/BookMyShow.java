package bookmyshow;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookMyShow {
	WebDriver driver;
	
	@BeforeTest
		public void openBrowser(){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\shreeeeee\\Downloads\\New folder\\gekpo\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://in.bookmyshow.com/");
		}
	
	@Test (priority = 0)
		public void handelTextBox() throws InterruptedException{
		//enter jaipur in location light box
			Thread.sleep(10000);
			driver.findElement(By.id("inp_RegionSearch_top")).sendKeys("jaipur");
			driver.findElement(By.cssSelector(".tt-suggestion.tt-selectable.tt-cursor")).click();
	}
	
	@Test (priority = 1)
		public void handelLink() throws InterruptedException{
		//click on movie link in header
			Thread.sleep(10000);
			driver.findElement(By.linkText("Movies")).click();
			Thread.sleep(2000);
			driver.navigate().back();
	}
	
	@Test (priority = 2)
		public void handelText() throws InterruptedException{
		//get text of link
			Thread.sleep(10000);
			String text = driver.findElement(By.linkText("Movies")).getText();
			System.out.println(text);
	}
	
	@Test (priority = 3)
		public void handelButton() throws InterruptedException{
		//click on sign in
			Thread.sleep(10000);
			driver.findElement(By.id("preSignIn")).click();;
			driver.findElement(By.xpath("//div[@id='signinPopup']/div/div/span")).click();
	}
	
	@Test(priority = 4)
		public void handleMouseHover() throws InterruptedException{
		//handle mouse hover on corporate link
			WebElement cororate = driver.findElement(By.linkText("Corporates"));
			Actions a = new Actions(driver);
			a.moveToElement(cororate).perform();
			Thread.sleep(3000);
	}
	
	@Test(priority = 6)
		public void handleImage(){
		WebElement image = driver.findElement(By.xpath("//div[@class='card-listing-section']/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/img[1]"));
		System.out.println(image.getText());
		System.out.println(image.getAttribute("alt"));
		System.out.println(image.getAttribute("src"));
	}
	
	@Test(priority = 5)
		public void handleAutoComplete() throws InterruptedException{
			WebElement input = driver.findElement(By.id("input-search-box"));
			input.click();
			WebElement in = driver.findElement(By.cssSelector(".search-box.typeahead.tt-input"));
			in.sendKeys("movie");
			Thread.sleep(3000);
			in.sendKeys(Keys.DOWN);
			Thread.sleep(1000);
			in.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			
	}
}
