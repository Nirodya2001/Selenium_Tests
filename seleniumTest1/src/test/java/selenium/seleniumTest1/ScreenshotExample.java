package selenium.seleniumTest1;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenshotExample {
WebDriver driver;
	
	@BeforeMethod
	public void openWaitTestPage() {
		
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/alert.xhtml");		
	}
	
	@Test
	public void takeScreenshotTests() throws IOException, AWTException {
		//01) Capture screenshot of full page
		
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourseFile =takeScreenshot.getScreenshotAs(OutputType.FILE);		
		File desFile = new File(System.getProperty("user.dir") + "\\ScreenShot\\"+ "alaertFullPage.png");		
		FileHandler.copy(sourseFile, desFile);
		
		//02) capture screenshot of section of a web page
		
		WebElement section1Pagelement = driver.findElement(By.xpath("//*[@id=\"j_idt88\"]/div/div[1]"));
		File source =section1Pagelement.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\ScreenShot\\"+ "alaertsectionFullPage.png");
		FileUtils.copyFile(source, target);
		
		//03) capture screenshot of an element on a web page
		
		WebElement elementPage = driver.findElement(By.xpath("//*[@id=\"j_idt88\"]/div/div[1]/div[1]"));
		File source1 = elementPage.getScreenshotAs(OutputType.FILE);
		File target1 = new File(System.getProperty("user.dir") + "\\ScreenShot\\"+ "alaertElementPage.png");              
		FileUtils.copyFile(source1, target1);    
		
		//04) capture screenshot of Full entire screen
		
		WebElement alertButton = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt91\"]"));
		alertButton.click();
		
		Robot robot = new Robot();
		java.awt.Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(screenSize);
		BufferedImage source2 =robot.createScreenCapture(rectangle);
		File destination = new File(System.getProperty("user.dir")+ "\\ScreenShot\\"+"alertFullPage.png");
		ImageIO.write(source2, "png", destination);
			
		
	}
		
	
	public static void main(String[] args) throws IOException, AWTException {
		ScreenshotExample obj = new ScreenshotExample();
		obj.openWaitTestPage();
		obj.takeScreenshotTests();
		
	}
}
