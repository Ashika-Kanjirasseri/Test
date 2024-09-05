package dealsdray.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationTest01 {

	public static WebDriver driver;

	@BeforeClass
	public void precondition() throws IOException {
		FileInputStream address = new FileInputStream("./src/test/resources/automationTest01.properties");
		Properties pobj = new Properties();
		pobj.load(address);
		String browser = pobj.getProperty("browser");
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		if (browser.equals("safari")) {
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	@Test(priority = 0)
	public void triggerURL() {
		driver.get("https://www.getcalley.com/page-sitemap.xml");
	}
	
	public void test() throws IOException {
		
		Dimension d1 = new Dimension(1366, 768);
		driver.manage().window().setSize(d1);
		String timeStamp1 = LocalDateTime.now().toString().replace(':', '-');
		TakesScreenshot ts1 = (TakesScreenshot) driver;
		File tempss1 = ts1.getScreenshotAs(OutputType.FILE);
		File permss1 = new File("./Desktop/1366x768/Screenshot" + timeStamp1 + ".png");
		FileUtils.copyFile(tempss1, permss1);

		Dimension d2 = new Dimension(1536, 864);
		driver.manage().window().setSize(d2);
		String timeStamp2 = LocalDateTime.now().toString().replace(':', '-');
		TakesScreenshot ts2 = (TakesScreenshot) driver;
		File tempss2 = ts2.getScreenshotAs(OutputType.FILE);
		File permss2 = new File("./Desktop/1536x864/Screenshot" + timeStamp2 + ".png");
		FileUtils.copyFile(tempss2, permss2);

		Dimension d3 = new Dimension(1920, 1080);
		driver.manage().window().setSize(d3);
		String timeStamp3 = LocalDateTime.now().toString().replace(':', '-');
		TakesScreenshot ts3 = (TakesScreenshot) driver;
		File tempss3 = ts3.getScreenshotAs(OutputType.FILE);
		File permss3 = new File("./Desktop/1920x1080/Screenshot" + timeStamp3 + ".png");
		FileUtils.copyFile(tempss3, permss3);

		Dimension d4 = new Dimension(360, 640);
		driver.manage().window().setSize(d4);
		String timeStamp4 = LocalDateTime.now().toString().replace(':', '-');
		TakesScreenshot ts4 = (TakesScreenshot) driver;
		File tempss4 = ts4.getScreenshotAs(OutputType.FILE);
		File permss4 = new File("./Mobile/360x640/Screenshot" + timeStamp4 + ".png");
		FileUtils.copyFile(tempss4, permss4);

		Dimension d5 = new Dimension(375, 667);
		driver.manage().window().setSize(d5);
		String timeStamp5 = LocalDateTime.now().toString().replace(':', '-');
		TakesScreenshot ts5 = (TakesScreenshot) driver;
		File tempss5 = ts5.getScreenshotAs(OutputType.FILE);
		File permss5 = new File("./Mobile/375x667/Screenshot" + timeStamp5 + ".png");
		FileUtils.copyFile(tempss5, permss5);

		Dimension d6 = new Dimension(414, 896);
		driver.manage().window().setSize(d6);
		String timeStamp6 = LocalDateTime.now().toString().replace(':', '-');
		TakesScreenshot ts6 = (TakesScreenshot) driver;
		File tempss6 = ts6.getScreenshotAs(OutputType.FILE);
		File permss6 = new File("./Mobile/414x896/Screenshot" + timeStamp6 + ".png");
		FileUtils.copyFile(tempss6, permss6);
		
	}

	@Test(priority = 1)
	public void link1() throws IOException {
		//first link
		driver.findElement(By.linkText("https://www.getcalley.com/")).click();
		test();
		driver.navigate().back();
	}
	
	@Test(priority = 2)
	public void link2() throws IOException {
		//second link
		driver.findElement(By.linkText("https://www.getcalley.com/calley-lifetime-offer/")).click();
		test();
		driver.navigate().back();
	}
	
	@Test(priority = 3)
	public void link3() throws IOException {
		//third link
		driver.findElement(By.linkText("https://www.getcalley.com/see-a-demo/")).click();
		test();
		driver.navigate().back();
	}
	
	@Test(priority = 4)
	public void link4() throws IOException {
		//fourth link
		driver.findElement(By.linkText("https://www.getcalley.com/calley-pro-features/")).click();
		test();
		driver.navigate().back();
	}
	
	@Test(priority = 5)
	public void link5() throws IOException {
		//fifth link
		driver.findElement(By.linkText("https://www.getcalley.com/calley-personal-features/")).click();
		test();
		driver.navigate().back();
	}
	
	@AfterClass
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}

}
