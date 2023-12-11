package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class MyFirstTestFW extends BaseTest {
	
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="bvtdata")
	public void loginTest(String username, String password) throws InterruptedException {
				
		driver.findElement(By.xpath(loc.getProperty("signin_link"))).click();
		driver.findElement(By.xpath(loc.getProperty("email_feild"))).sendKeys(username);
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("pwd_feild"))).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
		Thread.sleep(3000);
		
	}

}

