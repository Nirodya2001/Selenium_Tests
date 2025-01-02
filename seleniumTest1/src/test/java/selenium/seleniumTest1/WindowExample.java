package selenium.seleniumTest1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowExample {

WebDriver driver;
	
	@BeforeMethod
	public void openWindowTestPage(){
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.leafground.com/window.xhtml");
		
	}
	
	@Test
	public void windowTests(){
		
		 //01) Click and Confirm new Window Opens
		
		String oldWindow = driver.getWindowHandle();
		System.out.println("Parent window : " + oldWindow);
		
		
		WebElement openButton =driver.findElement(By.xpath("//*[@id=\"j_idt88:new\"]"));
		openButton.click();
		
		
		 Set<String> handles = driver.getWindowHandles();
		 System.out.println("Handle size : " + handles.size());	
		
		
		  // First method - using for-each loop
		
		 for (String newWindow :handles) {
			 System.out.println(newWindow);
			 driver.switchTo().window(newWindow);
			 System.out.println("Page title is : " + driver.getTitle());
		 }
		 
		 driver.close();
		 
		 driver.switchTo().window(oldWindow);
		 
		 WebElement openButton1 = driver.findElement(By.xpath(("//*[@id=\"j_idt88:new\"]")));
		 boolean openButtonVisibility =  openButton1.isDisplayed();
		 System.out.println("Open Button Visibility : " + openButtonVisibility);
		 
		  // second method - using list
		
		List<String> list = new ArrayList<String>(handles); //converting set to a list
		if(list.size() > 1) {
			driver.switchTo().window(list.get(1));
			System.out.println("Child tab title is : " + driver.getTitle());
			driver.close();
			driver.switchTo().window(oldWindow);
		}
		
		WebElement openButton11 = driver.findElement(By.xpath(("//*[@id=\"j_idt88:new\"]")));
		boolean openButtonVisibility1 =  openButton11.isDisplayed();
		System.out.println("Open Button Visibility : " + openButtonVisibility1);
		
		
		// 02) Find the number of open tabs
		
		WebElement multiWindow =  driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt91\"]"));
		multiWindow.click();
		
		
		Set<String> multiWindows =  driver.getWindowHandles();
		int noOfWindows =  multiWindows.size();
		System.out.println("Number of opened tabs : "+ noOfWindows);
		
		
		//03) Close all windows except Primary
		
		WebElement dontCloseMeButton = driver.findElement(By.id("j_idt88:j_idt93"));
		dontCloseMeButton.click();
		
		Set<String> newWindowHandles = driver.getWindowHandles();
		for (String allWindows :newWindowHandles) {
			if(!allWindows.equals(oldWindow)) {
				driver.switchTo().window(allWindows);
				driver.close();
			}
		}
		
		driver.quit();   // close all windows on the browser.
	}
	
	public static void main(String[] args) {
		WindowExample obj = new WindowExample();
		obj.openWindowTestPage();
		obj.windowTests();
	}
}
