package selenium.seleniumTest1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class downloadUploadExample {

WebDriver driver;
	
	@BeforeMethod
	public void openChromePage() {
		
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
			
	}
	
	@Test
	public void fileDownloadTest()  {
		driver.get("https://leafground.com/file.xhtml");
		WebElement downloadButton = driver.findElement(By.id("j_idt93:j_idt95"));
		downloadButton.click();
		
		File file = new File("C:\\Users\\DELL\\Downloads"); 
		File[] totalfiles =file.listFiles();
		for (File findFile :totalfiles) {
			if (findFile.getName().equals("TestLeaf Logo.png")) {
				System.out.println("File is downloaded.");
				break;
			}
		}
	}
	
	@Test
	public void fileUploadTest() throws AWTException {
		driver.get("https://leafground.com/file.xhtml");
		
		//1st way - Using Robot class
		
		WebElement uploadButton = driver.findElement(By.id("j_idt88:j_idt89"));
		uploadButton.click();
		
		//windows control begin here
		
		String data ="C:\\Users\\DELL\\Downloads\\sample.jpeg";
				
		StringSelection selection = new StringSelection(data);
		
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
		
		
		Robot robot  = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER); 

		//2nd way - Using sendKeys (Applicable only element type is file)

		WebElement uploadUsingSendkeys =driver.findElement(By.id("j_idt88:j_idt89_input"));
		uploadUsingSendkeys.sendKeys(data);
		
		
		
	}
	
	public static void main(String[] args) throws AWTException  {
		downloadUploadExample obj = new downloadUploadExample();
		obj.openChromePage();
		obj.fileDownloadTest();
		//obj.fileUploadTest();
		
	}
	
}
