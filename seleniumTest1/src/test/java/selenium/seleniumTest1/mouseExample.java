package selenium.seleniumTest1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class mouseExample {

WebDriver driver;
	
	@BeforeMethod
	public void openDriverTestPage() {
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public void mouseOperationsTest1()   {
		
		driver.get("https://www.leafground.com/drag.xhtml");
		
		System.out.println("1) <<<<<<<<<<<<<<< Move to an Element Operation >>>>>>>>>>>>>>>");
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
		actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();
		actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();
		
		
		System.out.println("2) <<<<<<<<<<<<<<< Drag and drop Operation >>>>>>>>>>>>>>>");

		WebElement from =driver.findElement(By.id("form:drag"));
		WebElement to = driver.findElement(By.id("form:drop"));
		
		//actions.clickAndHold(from).moveToElement(to).release(to).perform();  // 1st way
		actions.dragAndDrop(from, to).perform();  //2nd way
		
		System.out.println("3) <<<<<<<<<<<<<<< Slider Operation >>>>>>>>>>>>>>>");
		
		WebElement sliderPoint1 =driver.findElement(By.xpath("//*[@id=\"form:j_idt125\"]/span[1]"));
		System.out.println("Location of slider point 1 before moving : " + sliderPoint1.getLocation() );
		
		actions.dragAndDropBy(sliderPoint1, 50, 0).perform();

		System.out.println("Location of slider point 1 after moving : " + sliderPoint1.getLocation() );

	}
	
	@Test
	public void mouseOperationTest2() {
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		System.out.println("4) <<<<<<<<<<<<<<< Right Click >>>>>>>>>>>>>>>");
		
		WebElement rightClickButton =driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
		
		Actions actions1 = new Actions(driver);
		
		actions1.contextClick(rightClickButton).perform();
		
		driver.findElement(By.xpath("/html/body/ul/li[1]/span")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert shows the text as  : " + alert.getText() );
		alert.accept();


		
	}
	
	public static void main(String[] args)    {
		mouseExample obj = new mouseExample();
		obj.openDriverTestPage();
		obj.mouseOperationsTest1();
		obj.mouseOperationTest2();
	}
}
