package ZeroBankProj.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import zeroBankProj.Core.BaseClass;

public class TC_SignIn extends BaseClass
{
	@Test
	public void signIn()
	{
		driver.findElement(By.id(object.getProperty("signButton"))).click();
	}
}
