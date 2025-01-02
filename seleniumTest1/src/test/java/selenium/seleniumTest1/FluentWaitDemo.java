package selenium.seleniumTest1;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class FluentWaitDemo {

WebDriver driver;
	
	@BeforeMethod
	public void openWaitTestPage() {
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/waits.xhtml");		
	}
	
	@Test
	public void fluentWaitTests() {
		// declaration
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))      // maximum time to wait
				.pollingEvery(Duration.ofSeconds(5))      // frequency to check the condition
				.ignoring(NoSuchElementException.class);  // ignore specific exception
		
		
		//usage 
		
		driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt89\"]")).click();	
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply (WebDriver driver) {
				return driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt90\"]/span"));
			}
		});
		
		String newButtonText =element.getText();
		System.out.println("New button text is : " + newButtonText);
	}
	
	public static void main(String[] args) {
		FluentWaitDemo obj = new FluentWaitDemo();
		obj.openWaitTestPage();
		obj.fluentWaitTests();
		
	}
}
