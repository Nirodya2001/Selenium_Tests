package selenium.seleniumTest1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class calenderExample {

WebDriver driver;
	
	@BeforeMethod
	public void openImagePage()   {
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
	}
	
	@Test
	public void calenderTest() {
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
		
		//Method 1
		
		
		WebElement datePicker =driver.findElement(By.xpath("//*[@id=\"datepicker\"]"));
     	datePicker.sendKeys("07/02/2024");
		
		
		//Method 2 
		
		WebElement datePicker2 =driver.findElement(By.xpath("//*[@id=\"datepicker\"]"));
		datePicker2.click();
		
		
		//selectFutureDate("2025","January","3");
		selectPastDate("2023", "September", "6");
		
		
	}
	
	public void selectFutureDate(String year, String month, String date) {
		while(true) {
			String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		
			if(actualYear.equals(year) && actualMonth.equals(month)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}
		
		}
		
		List<WebElement> allDates =driver.findElements(By.xpath("//table[@class='ui-datepicker-calender']/tbody/tr/td/a"));
		
		for(WebElement dateElement :allDates) {
			if(dateElement.getText().equals(date)) {
				dateElement.click();
				break;
			}			
		}
	}
	
	public void selectPastDate(String year, String month, String date) {
		while(true) {
			String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		
			if(actualYear.equals(year) && actualMonth.equals(month)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//a[@title='Prev']")).click();
			}
		
		}
		
		List<WebElement> allDates =driver.findElements(By.xpath("//table[@class='ui-datepicker-calender']/tbody/tr/td/a"));
		
		for(WebElement dateElement :allDates) {
			if(dateElement.getText().equals(date)) {
				dateElement.click();
				break;
			}			
		}
	}
	
	
	public static void main(String[] args)   {
		calenderExample obj = new calenderExample();
		obj.openImagePage();
		obj.calenderTest();
	}
}
