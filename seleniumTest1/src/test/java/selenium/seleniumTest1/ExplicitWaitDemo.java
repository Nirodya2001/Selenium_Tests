package selenium.seleniumTest1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitDemo {

WebDriver driver;
	
	@BeforeMethod
	public void openWaitTestPage() {
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/waits.xhtml");		
	}
	
	@Test 
	public void explicittWaitTest()  {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10) );
		
		driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt89\"]")).click();
		
		By newButtonLocator =By.xpath("//*[@id=\"j_idt87:j_idt90\"]/span");
		
		WebElement newButtonElement =wait.until(ExpectedConditions.visibilityOfElementLocated(newButtonLocator));
		
		String newButtonText =newButtonElement.getText();
		
		System.out.println("New button text is : " + newButtonText);
	}
	
	public static void main(String[] args) {
		ExplicitWaitDemo obj = new ExplicitWaitDemo();
		obj.openWaitTestPage();
		obj.explicittWaitTest();
		
	}
}
