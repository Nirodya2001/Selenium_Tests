package selenium.seleniumTest1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class keyboardExample {

WebDriver driver;
	
	@BeforeMethod
	public void openChromePage() {
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
	}
	
	@Test 
	public void KeyBoardActionTest1()   {
		driver.get("https:/www.google.com/");
		WebElement googleSearchtextbox =driver.findElement(By.name("q"));
		googleSearchtextbox.sendKeys("welcome");
		
		Actions actions = new Actions(driver);
		// Select the text
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		
		actions.keyDown(Keys.SHIFT)
		   .sendKeys("capital letters").perform();
		
		
		actions.keyUp(Keys.SHIFT) 
		   .keyDown(Keys.CONTROL)
		   .sendKeys("a")
		   .keyUp(Keys.CONTROL)
		   .keyDown(Keys.CONTROL)
		   .sendKeys("x")
		   .perform();  
		
		actions.keyDown(googleSearchtextbox, Keys.SHIFT)
			.sendKeys("capital letters")
			.perform();
		
	}
	
	
	@Test
	public void KeyBoardActionTest2()   {
		driver.get("https://leafground.com/list.xhtml");
		
		List<WebElement> selectable = driver.findElements(By.xpath("//ul[@aria-label=\"From\"]/li"));
		int size = selectable.size();
		System.out.println("Li count is: "+size);
		
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL)
			.click(selectable.get(0))
			.click(selectable.get(1))
			.click(selectable.get(2))
			.perform();
		
		
		
	}
	
	public static void main(String[] args)    {
		keyboardExample obj = new keyboardExample();
		obj.openChromePage();
		obj.KeyBoardActionTest1();
		obj.KeyBoardActionTest2();
	}
}
