package selenium.seleniumTest1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownExample {
	
	
WebDriver driver;
	
	@BeforeMethod
	public void dropDownTestPage() {
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void leafgroundpageDropDownTest()   {
		
		//01) Ways of select values in Basic drop-down
		 driver.get("https://www.leafground.com/select.xhtml");

		 WebElement dropDown = driver.findElement(By.xpath("//select[@class=\"ui-selectonemenu\"]"));
		 Select select = new Select(dropDown);
		 
		 select.selectByIndex(1);
		 select.selectByVisibleText("Playwright");
		
		
		//02) Get the number of drop-down options
		 
		 List<WebElement> listOfOptions = select.getOptions();
		 int size = listOfOptions.size();
		 System.out.println("Number of Options: " + size);
		 
		 for (WebElement element :listOfOptions) {
			System.out.println(element.getText());
		 }
		 
		//03) Using sendKeys select drop-down value
		 
		 dropDown.sendKeys("Puppeteer");

		
		//04) Selecting values in a Bootstrap drop-down
		 
		 WebElement dropDown2 =driver.findElement(By.xpath("//div[@id=\"j_idt87:country\"]"));
		 dropDown2.click();
		 List<WebElement> listOfDropDown2= driver.findElements(By.xpath("//ul[@id=\"j_idt87:country_items\"]/li"));
		 for (WebElement element2:listOfDropDown2) {
			 String dropDownValue = element2.getText(); 
			 if (dropDownValue.equals("USA")) {
				 element2.click();
				 break;
			 }
		 }
		 
		 
		 
	}
	
	
	
	//05) Google Search - pick a value from suggestions
	
	@Test
	public void googleSearchDropDown()   {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("university");
		List<WebElement> googleSearchList=  driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li//div[@class=\"wM6W7d\"]"));
		System.out.println(googleSearchList.size());
		for (WebElement element :googleSearchList) {
			System.out.println(element.getText());
			
		}
		
		
	}
	
	
	//06) Handle hidden Auto Suggestion drop-down and search using DOM debugger trick
	
	
	

	
	public static void main(String[] args)   {
		DropdownExample obj = new DropdownExample();
		obj.dropDownTestPage();
		obj.googleSearchDropDown();
	}
}
