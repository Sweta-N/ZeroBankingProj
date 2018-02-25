package zeroBankProj.Core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import zeroBankProj.util.Xls_Reader;

/*import busyqa.util.TestConfig;
import busyqa.util.Xls_Reader;
import busyqa.util.monitoringMail;*/

public class BaseClass
{
	/*
	 * Initialise Webdriver, properties, xls ,creating db connection
	 */
	
	public static Properties config=new Properties();
	public static Properties object=new Properties();
	public static Xls_Reader excel=null;
	public static WebDriver driver=null;
		
	@BeforeSuite()
	public static void init() throws IOException {
		if(driver==null) {
		//load config property file	
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\zeroBankProj\\properties\\config.properties");
		config.load(fis);
		
		
		//load object property file	
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\zeroBankProj\\properties\\object.properties");
		object.load(fis);
		
		
		//load excel file
		excel=new Xls_Reader(System.getProperty("user.dir")+"\\src\\main\\java\\zeroBankProj\\properties\\testdata.xlsx");
		
		
		if(config.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
		}else if(config.getProperty("browser").equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(config.getProperty("browser").equals("edge")) {
			System.setProperty("webdriver.edge.driver", "MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
		}
		
		driver.get(config.getProperty("testsiteURL"));
		driver.manage().window().maximize();
		
		
		//Global implicit Wait
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		}
	}
	
	
	
	@AfterSuite()
		public static void tearDown() throws IOException  
	{
			
			/*File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\Users\\Nityanand\\Desktop\\Automation Class\\eclipse-workspace\\ZeroBankProj\\src\\main\\java\\zeroBankProj\\screenshot\\error.jpg"));*/
			
			driver.quit();
	}
}
