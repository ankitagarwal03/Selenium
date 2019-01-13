package amazon;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon {
	WebDriver driver;
	String username = "nkt.agarwal3@gmail.com";
	String pass = "";
	
	@BeforeTest
		public void openBrowser(){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\shreeeeee\\Downloads\\New folder\\gekpo\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.in/");
		}
	
	@Test (priority = 0)
		public void handleLink(){
			driver.findElement(By.linkText("Your Amazon.in")).click();
	}
	
	@Test (priority = 1)
		public void login() throws InterruptedException{
			// enter username
			driver.findElement(By.id("ap_email")).sendKeys(username);
			
			// click on submit button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='a-box']/div/div[2]/span/span/input")).click();
			
			// enter pass in text field
			Thread.sleep(2000);
			driver.findElement(By.id("ap_password")).sendKeys(pass);
			// click on login button
			Thread.sleep(2000);
			driver.findElement(By.id("signInSubmit")).click();
		}
	
	@Test (priority = 2)
		public void processItem() throws InterruptedException{
			Thread.sleep(4000);
			
			WebElement textBox = driver.findElement(By.xpath("//input[@class='nav-input'][@id='twotabsearchtextbox']"));
			textBox.sendKeys("moto g5");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@class='nav-input'][@type='submit']")).click();
			
			Thread.sleep(4000);
			driver.findElement(By.xpath("//div[@id='main']/div[3]/div[2]/div/div[4]/div[1]/div/ul/li[2]/div/div/div/div[1]/div[1]/div[1]/a/img")).click();
			
			Thread.sleep(2000);
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    
		    Thread.sleep(2000);
		    driver.findElement(By.id("add-to-cart-button")).click();
		    
		    Thread.sleep(2000);
		    driver.findElement(By.id("hlb-ptc-btn")).click();	
			
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//div[@class='a-spacing-base address-book']/div[1]/div[2]/span/a")).click();
		    
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//div[@class='a-row a-spacing-medium']/div[2]/div/span[1]/span[1]/input")).click();
		}
	
	@Test(priority=3)
		public void logout() throws InterruptedException{
			driver.navigate().back();
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(3000);
			
			WebElement signIn = driver.findElement(By.id("nav-link-yourAccount"));
			Actions a = new Actions(driver);
			Thread.sleep(2000);
			a.moveToElement(signIn).perform();
			Thread.sleep(2000);
			
			driver.findElement(By.linkText("Sign Out")).click();
		}
	
	
//	@Test (priority = 2)
//		public void handleText(){
//			String text = driver.findElement(By.xpath("//div[@id='nav-shop']/a/span[2]")).getText();
//			System.out.println("text are : "+text);
//	}
//	
//	@Test (priority = 3)
//		public void handleButton() throws InterruptedException{
//			//click on sign in at bottom
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			WebElement bottom = driver.findElement(By.className("navFooterBackToTopText"));
//			js.executeScript("arguments[0].scrollIntoView()", bottom);
//			Thread.sleep(3000);
//			
//			bottom.click();
//			driver.navigate().back();
//	}
//	
//	@Test (priority = 4)
//		public void handleTable(){
//			WebElement table = driver.findElement(By.className("navFooterVerticalColumn"));
//			List<WebElement> li = table.findElements(By.tagName("td"));
//			
//				for(int i=0; i<li.size(); i++){
//					WebElement td = li.get(i);
//					System.out.println(td.getText());
//					
//					List<WebElement> lis = td.findElements(By.tagName("li"));
//						for (int j = 0; j<lis.size(); j++){
//							System.out.println(lis.get(j).getText());
//						}
//				}
//	}
//	
//	@Test (priority = 5)
//		public void handleMouseHover() throws InterruptedException{
//			// handle mouse hover on hello sign in your order
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollTo(0, 0)");
//			Thread.sleep(2000);
//			WebElement signIn = driver.findElement(By.id("nav-link-yourAccount"));
//			Actions a = new Actions(driver);
//			Thread.sleep(2000);
//			a.moveToElement(signIn).perform();
//			Thread.sleep(2000);
//	}
//	
//	@Test(priority = 6)
//		public void handleImage() throws InterruptedException{
//			
//			Thread.sleep(1000);
//			WebElement image = driver.findElement(By.cssSelector(".nav-sprite.nav-logo-base"));
//			System.out.println(image.getAttribute("class"));
//			System.out.println(image.getText());
//			image.click();
//	}
//	
//	@Test (priority = 7)
//	public void handleAutoComplete() throws InterruptedException{
//		// handle auto complete in top search bar 
//		WebElement textBox = driver.findElement(By.xpath("//input[@class='nav-input'][@id='twotabsearchtextbox']"));
//		textBox.sendKeys("moto");
//		Thread.sleep(1000);
//		textBox.sendKeys(Keys.DOWN);
//		textBox.sendKeys(Keys.DOWN);
//		textBox.sendKeys(Keys.DOWN);
//		textBox.sendKeys(Keys.DOWN);
//		textBox.sendKeys(Keys.DOWN);
//		Thread.sleep(1000);
//		textBox.sendKeys(Keys.ENTER);
//	}
}
