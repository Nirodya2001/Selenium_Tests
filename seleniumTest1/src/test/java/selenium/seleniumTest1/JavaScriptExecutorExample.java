package selenium.seleniumTest1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorExample {
WebDriver driver;
JavascriptExecutor jsExecutor;
	
	@BeforeMethod
	public void openImagePage()    {
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
	}
	
	@Test
	public void jsExecutorTests()   {
		
		jsExecutor =  (JavascriptExecutor) driver;
		
		
		//01) Get a Alert box into web page using JavaScript
		
		//jsExecutor.executeScript("alert('My name is Nirodya')");
		
		//02) Set a input value in a text box using JavaScriptExecutor
			//2.1) way 01 : set the value using the value property (common approach)
		
			WebElement inputNameTextbox = driver.findElement(By.xpath("//*[@id=\"name\"]"));
			//jsExecutor.executeScript("arguments[0].value='Nirodya Dewanjalee';", inputNameTextbox);			
			
			//2.2) way 02 : set the value using setAttribute (alternative approach)
			
			jsExecutor.executeScript("arguments[0].setAttribute('value','Niro Dewanjalee');", inputNameTextbox);
			
		//03) Highlight element
			
		jsExecutor.executeScript("arguments[0].style.border='3px solid red';", inputNameTextbox);
		jsExecutor.executeScript("arguments[0].style.background='yellow';", inputNameTextbox);
		
						
		//04) click element using javascritExecutor
		
		WebElement maleCheckbox = driver.findElement(By.xpath("//*[@id=\"male\"]"));
		jsExecutor.executeScript("arguments[0].click();", maleCheckbox);
		
		
		//05) Scrolling the page
		
		scrollPage();
		
		jsExecutor.executeScript("location.reload();");

		
		
		
		
		
	}
	
	public void scrollPage()   {
		//5.1) Scroll to some position
		jsExecutor.executeScript("window.scrollTo(0, 1000);");
		System.out.println("Current pageYOffset value is : " + jsExecutor.executeScript("return window.pageYOffset;"));
		
		jsExecutor.executeScript("window.scrollTo(0, -1000);");		
		

		
		//5.2) Scroll to bottom of the page by pixel number
		
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		

		
		//5.3) Scroll to the top of the page
		
		jsExecutor.executeScript("window.scrollTo(0,0);");
		


		//5.4) Scroll the page till element is visible
		
		WebElement scrollElement = driver.findElement(By.xpath("//*[@id=\"post-body-1307673142697428135\"]/div[3]/label"));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", scrollElement);
		

		
	}
	
	
	
	public static void main(String[] args)    {
		JavaScriptExecutorExample obj = new JavaScriptExecutorExample();
		obj.openImagePage();
		obj.jsExecutorTests();
	}
	
}
