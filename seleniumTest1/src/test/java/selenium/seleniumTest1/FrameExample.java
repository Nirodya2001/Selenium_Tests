package selenium.seleniumTest1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameExample {

WebDriver driver;
	
	@BeforeMethod
	public void openFrameTestPage() {
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/frame.xhtml");
		
	}
	
	@Test
	public void frameTests() {
		//01) Click me (Inside frame)
		
		driver.switchTo().frame(0);
		WebElement button1 =driver.findElement(By.xpath("//*[@id=\"Click\"]"));
		button1.click();
		
		String afterClickButtonText =button1.getText();
		System.out.println("Text after click : " + afterClickButtonText);
		
		//02) Click me (Inside Nested Frame)
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		
		WebElement button3 =driver.findElement(By.id("Click"));
		button3.click();
		
		String afterClickNestedFrameButton =button3.getText();
		System.out.println("Text after nested frame click : " + afterClickNestedFrameButton);
		
		//03) How many frames in this page :
		
		driver.switchTo().defaultContent();
		
		List<WebElement> getIframeTagCount =driver.findElements(By.tagName("iframe"));
		int size = getIframeTagCount.size();
		
		System.out.println("No of frames : " + size);
	}
	
	
	public static void main(String[] args)  {
		FrameExample obj = new FrameExample();
		obj.openFrameTestPage();
		obj.frameTests();
	}
}
