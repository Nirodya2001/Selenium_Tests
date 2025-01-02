package selenium.seleniumTest1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LinkExample {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openLinkTestPage() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.leafground.com/link.xhtml");
	}
	
	@Test
	public void LinkTests() {
	
	//01) Take Me to Dash-board
		driver = new EdgeDriver();
		WebElement homelink = driver.findElement(By.linkText("Go To Dashboard"));
		homelink.click();
		driver.navigate().back();
		
	//02) Find my destination
		WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL"));
		String path = wheretoGo.getAttribute("href");
		System.out.println("This link is going to: "+path);
		
	//03) Am I broken link
		WebElement brokenLink =  driver.findElement(By.linkText("Broken?"));
		brokenLink.click();
		
		String title = driver.getTitle();
		if(title.contains("404")) {
			System.out.println("The link is broken");
		}
		else {
			System.out.println("Not Broken");
		}
		driver.navigate().back();
		
		
	//04) Duplicate link
		WebElement homelink1 = driver.findElement(By.linkText("Go To Dashboard"));

		homelink1.click();
		driver.navigate().back();

		
		
	//05) Count page links
		List<WebElement> countfullpageLinks =  driver.findElements(By.tagName("a"));
		int pageLinkCount = countfullpageLinks.size();
		System.out.println("Count of full page links: "+ pageLinkCount);
		
	//06) Count Layout links
		WebElement layoutElement =driver.findElement(By.className("layout-main-content"));
		List<WebElement> countofLayoutLinks= layoutElement.findElements(By.tagName("a"));
		System.out.println("Count of layout links : "+countofLayoutLinks.size());
		
		
	
	}
	
	public static void main(String[]args) {
		LinkExample obj = new LinkExample();
		obj.openLinkTestPage();
		obj.LinkTests();
	}

}
