package selenium.seleniumTest1;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonExample {

	
WebDriver driver;
	
	@BeforeMethod
	public void openLinkTestPage() {
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void radioTests() {
		driver.get("https://leafground.com/radio.xhtml");
		
		//01) Find the default select radio button
		
		boolean chromeRadioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
		boolean firefoxRadioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
		boolean safariRadioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
		boolean edgeRadioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();
		
		if (chromeRadioOption) {
			String chromeText = driver.findElement(By.xpath("//label[@for=\"j_idt87:console2:0\"]")).getText();
			System.out.println("default select radio button is : " + chromeText);
			
		} else if (firefoxRadioOption) {
			String firefoxText = driver.findElement(By.xpath("//label[@for=\"j_idt87:console2:1\"]")).getText();
			System.out.println("default select radio button is : " + firefoxText);
		}else if(safariRadioOption) {
			String safariText = driver.findElement(By.xpath("//label[@for=\"j_idt87:console2:2\"]")).getText();
			System.out.println("default select radio button is : " + safariText);
		}else if(edgeRadioOption) {
			String edgeText = driver.findElement(By.xpath("//label[@for=\"j_idt87:console2:3\"]")).getText();
			System.out.println("default select radio button is : " + edgeText);
		}
		
		
		//02) Select the age group (only if not selected)
		
		WebElement myAgeGroup =driver.findElement(By.id("j_idt87:age:0"));
		boolean isCheck = myAgeGroup.isSelected();
		
		if (!isCheck) {
			//myAgeGroup.click();
			driver.findElement(By.xpath("//label[@for=\"j_idt87:age:0\"]")).click();
		}
	
	}
	
	public void checkBoxTests() {
		
		// 01) Choose your favorite language(s)
		
		driver.get("https://leafground.com/checkbox.xhtml");
		List<WebElement> checkbox = driver.findElements(By.xpath("//table[@id=\"j_idt87:basic\"]//label"));
		for (WebElement element : checkbox) {
			if (!(element.getText().equals("Others"))) {
				element.click();
			}
		}
		
		for (int i=1; i<=checkbox.size(); i++) {
			boolean checkboxStatus = driver.findElement(By.xpath("//table[@id=\"j_idt87:basic\"]//input[" + i + "]")).isSelected();
			System.out.println("Checkbox " + i + "selected status is: " + checkboxStatus );
		}
	}
	
	public static void main(String[] args) {
		RadioButtonExample obj = new RadioButtonExample();
		obj.openLinkTestPage();
		obj.radioTests();
		obj.checkBoxTests();
	}
	
}
