package dealsdray.com;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationTest02 {
	public static WebDriver driver;
	@BeforeClass
	public void precondition() {
		System.out.println("The exicution has been started");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(priority = 2)
	public void test() throws InterruptedException, IOException {
		driver.get("https://demo.dealsdray.com/");
		WebElement userNameTextFeild = driver.findElement(By.name("username"));
		userNameTextFeild.sendKeys("prexo.mis@dealsdray.com");
		Thread.sleep(2000);
		WebElement passwordTextFeild = driver.findElement(By.name("password"));
		passwordTextFeild.sendKeys("prexo.mis@dealsdray.com");
		Thread.sleep(2000);
		WebElement loginOption = driver.findElement(By.xpath("//button[text()='Login']"));
		loginOption.click();
		Thread.sleep(2000);
		WebElement orderOption = driver.findElement(By.xpath("//span[text()='Order']"));
		orderOption.click();
		Thread.sleep(2000);
		WebElement OrdersOption = driver.findElement(By.xpath("//span[text()='Orders']"));
		OrdersOption.click();
		Thread.sleep(2000);
		WebElement addBulkOrderOpt = driver.findElement(By.xpath("//button[text()='Add Bulk Orders']"));
		addBulkOrderOpt.click();
		Thread.sleep(2000);
		WebElement chooseFileTextFeild = driver.findElement(By.id("mui-7"));
		chooseFileTextFeild.sendKeys("C:\\Users\\midhu\\Downloads\\demo-data.xlsx");
		Thread.sleep(2000);
		WebElement importOption = driver.findElement(By.xpath("//button[text()='Import']"));
		importOption.click();
		WebElement validateOpt = driver.findElement(By.xpath("//button[text()='Validate Data']"));
		validateOpt.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		Thread.sleep(2000);
		String timeStamp=LocalDateTime.now().toString().replace(':','-' );
		TakesScreenshot ts=(TakesScreenshot) driver;
		File tempss=ts.getScreenshotAs(OutputType.FILE);
		File permss= new File("./defectshot/"+timeStamp+"AutomationTest02Screenshot.png");
		FileUtils.copyFile(tempss,permss);
		Thread.sleep(2000);
		
	}
	
	@AfterClass
	public void postcondition() {
		driver.manage().window().minimize();
		driver.quit();
	}

}
