package selenium.seleniumTest1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {

WebDriver driver;
	
	@BeforeMethod
	public void openAlertTestPage() {
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.leafground.com/alert.xhtml");
	}
	
	@Test
	public void alertTests() {
		//01) Alert(Simple dialog)
		
		WebElement alertbox = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt91\"]"));
		alertbox.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
		//02) Alert (Confirm dialog)
		
		WebElement confirmBox =driver.findElement(By.id("j_idt88:j_idt93"));
		confirmBox.click();
		Alert alert1 = driver.switchTo().alert();
		alert1.dismiss();
		
		//03)Alert (Prompt Dialog)
		
		WebElement promptBox =  driver.findElement(By.id("j_idt88:j_idt104"));
		promptBox.click();
		Alert alert2 = driver.switchTo().alert();
		String alertText =  alert2.getText();
		System.out.println("Alert text is : "+alertText);
		alert2.sendKeys("My name is Nirodya");
		alert2.accept();
		
	}
	
	
	
	public static void main(String[] args) {
		AlertExample obj = new AlertExample();
		obj.openAlertTestPage();
		obj.alertTests();
	}
	
}
