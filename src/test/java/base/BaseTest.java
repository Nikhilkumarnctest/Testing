package base;

import org.testng.annotations.*;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();	
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		if(driver==null) {
			 System.out.println("The path is: " + System.getProperty("user.dir"));
			 fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
			 fr1 = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locators.properties");
			prop.load(fr);
			loc.load(fr1);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(prop.getProperty("testurl"));
			Thread.sleep(8000);
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(prop.getProperty("testurl"));	// properties
			Thread.sleep(8000);
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(prop.getProperty("testurl"));	// properties
			Thread.sleep(8000);
		}
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.close();
		System.out.println("teardown successfully");
		
	}

}
