package selenium.seleniumTest1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class OpenGoogleTest {
	@Test
	public void googleTest() {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Colombo"+ Keys.ENTER);
	}
}
