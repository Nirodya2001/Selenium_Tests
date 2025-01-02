package selenium.seleniumTest1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableExample {
WebDriver driver;
	
	@BeforeMethod
	public void openTestPage()  {
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
	}
	
	@Test 
	public void webTableTest()   {
		//01) How many rows in the table
		
		int rawCount =driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
		System.out.println("Number of rows in the table : " + rawCount);
		
		//02 How many columns in the table
		
		int columnCount =driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
		System.out.println("Number of columns in the table : " + columnCount);
		
		//03) Retrieve specific row/column data
		
		String value =driver.findElement(By.xpath("//table[@id=\'productTable\']/tbody/tr[3]/td[3]")).getText();
		System.out.println("Specified data value : " +value);
		
		//04) Retrieve all the data from table
		
		for (int i = 1; i <=rawCount; i++) {        //rows
			for (int j=1; j<columnCount; j++) {     //columns
				String tableData = driver.findElement(By.xpath("//table[@id=\'productTable\']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(tableData + " ");
			}
			System.out.println();
		}
		
		//05) Print ID and Name only
		//5.1) Find the product price which name related to Laptop

		
		for (int i=1; i<=rawCount; i++) {
			String tableID=driver.findElement(By.xpath("//table[@id=\'productTable\']/tbody/tr["+i+"]/td[1]")).getText();
			String productName = driver.findElement(By.xpath("//table[@id=\'productTable\']/tbody/tr["+i+"]/td[2]")).getText();
			
			System.out.println("table ID :"+ tableID + "product name: " + productName);
			
			if (productName.equals("Laptop")) {
				String productPrice =driver.findElement(By.xpath("//table[@id=\'productTable\']/tbody/tr["+i+"]/td[3]")).getText();
				System.out.println(productName + "Relevant Product Price is : " + productPrice);
				break;
			}
		}
		
		//06) Select all checkBoxes
		
		int pageCount = driver.findElements(By.xpath("//ul[@class='pagination']/li")).size();
		
		List<WebElement> pages =driver.findElements(By.xpath("//ul[@class='pagination']/li"));
		
		for (int k=0; k<pageCount; k++) {
			pages.get(k).click();
			
			for (int i=1; i<=rawCount; i++) {
				boolean attribute =driver.findElement(By.xpath("//table[@id=\'productTable\']/tbody/tr["+i+"]/td[4]/input")).isSelected();
				
				if (!attribute) {
					driver.findElement(By.xpath("//table[@id=\'productTable\']/tbody/tr["+i+"]/td[4]/input")).click();
				}
			}
		}
		
		
		//07) Select one checkBox
		
		int tableRow = 1;
		driver.findElement(By.xpath("//table[@id=\'productTable\']/tbody/tr["+tableRow+"]/td[4]/input")).click();
		
		
	}
	
	public static void main(String[] args)    {
		WebTableExample obj = new WebTableExample();
		obj.openTestPage();
		obj.webTableTest();
	}
}
