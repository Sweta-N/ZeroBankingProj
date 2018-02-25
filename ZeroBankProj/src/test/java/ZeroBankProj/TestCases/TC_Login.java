package ZeroBankProj.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import zeroBankProj.Core.BaseClass;
import zeroBankProj.util.Testutil;


public class TC_Login extends BaseClass
{
	/*@BeforeTest
	public void isSkip() {
		if(! testutil.isExecutable("LoginTest")) {
			throw new SkipException("Skipping the test case as the run mode is set to No");
		}
	}*/ 
	
	@Test(dataProvider="getData")
	public void Logintest(String myusername, String mypassword) {
		
		driver.findElement(By.name(object.getProperty("username"))).sendKeys(myusername);
		driver.findElement(By.name(object.getProperty("password"))).sendKeys(mypassword);
		driver.findElement(By.name(object.getProperty("signin"))).click();
		Assert.assertTrue(driver.getTitle().contains("Zero - Account Summary"));
		System.out.println("Test passed");
	}
	@DataProvider
	public Object[][] getData()
	{
		return Testutil.getData("LoginTest");
	}
}

