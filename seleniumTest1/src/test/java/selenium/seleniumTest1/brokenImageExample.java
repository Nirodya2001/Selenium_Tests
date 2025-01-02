package selenium.seleniumTest1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class brokenImageExample {

WebDriver driver;
	
	@BeforeMethod
	public void openImagePage()  {
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();			
	}
	
	@Test
	public void findBrokenImageTest() {
		driver.get("http://the-internet.herokuapp.com/broken_images");
		
		List<WebElement> images =driver.findElements(By.xpath("//div[@class='example']/img"));
		
		// "naturalWidth" = '0'
		
		int i = 1;
		for(WebElement image :images) {
			if(image.getAttribute("naturalWidth").equals("0")){
				System.out.println("Image " + i + " is broken");
			}
			else {
				System.out.println("Image " + i +  " is not broken");
			}
			
			i++;
			
		}
	}
	
	public static void main(String[] args)  {
		brokenImageExample obj = new brokenImageExample();
		obj.openImagePage();
		obj.findBrokenImageTest();
	}
}
