package selenium.seleniumTest1;



import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {
	
WebDriver driver;
	
	@BeforeMethod
	public void openLinkTestPage() {
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/button.xhtml");
	}
	
	@Test
	public void buttonTests() {
		
		//01) Click and Confirm title
		
		driver.findElement(By.id("j_idt88:j_idt90")).click();
		String expectedTitle = "Dashboard";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Actual title is same as expected");
		} else {
			System.out.println("Actual title is not same as expected");
		}
		
		//Assert.assertEquals("actualTitle", "expectedTitle","Title mismatch");
		
		
		//02) Find the position o the Submit button
		
		driver.navigate().back();
		WebElement getPosition =  driver.findElement(By.id("j_idt88:j_idt94"));
		Point xyPoint =getPosition.getLocation();
		int x = xyPoint.getX();
		int y = xyPoint.getY();
		System.out.println("X Position is : " + x + "Y position is : " + y);
		
		
		//03) Find the save button color
		
		WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt96"));
		String color = buttonColor.getCssValue("background-color");
		System.out.println("Button color is " + color);
		
		
		//04) Find the height and width of this button
		
		WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
		int height = size.getSize().getHeight();
		int width = size.getSize().getWidth();
		
		System.out.println("Height : " + height + "Width : " + width);
				
	}
	
	public static void main(String[] args) {
		ButtonExample obj = new ButtonExample();
		obj.openLinkTestPage();
		obj.buttonTests();
	}
	

}
