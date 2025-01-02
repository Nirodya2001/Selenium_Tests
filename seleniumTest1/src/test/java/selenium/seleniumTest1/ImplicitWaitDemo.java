package selenium.seleniumTest1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWaitDemo {

WebDriver driver;
	
	@BeforeMethod
	public void openFrameTestPage() {
		
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));          // every step waits maximum 10 seconds
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));                //waits 10 secs to load the page
		driver.get("https://www.leafground.com/waits.xhtml");		
	}
	
	@Test
	public void implicitWaitTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt89\"]")).click();
		
		String newButtonText =driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt90\"]/span")).getText();
		System.out.println("New button text is : " + newButtonText);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException  {
		ImplicitWaitDemo obj = new ImplicitWaitDemo();
		obj.openFrameTestPage();
		obj.implicitWaitTest();
		obj.closeBrowser();
	}
}
