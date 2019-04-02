package co.com.vortexbird.fuentes;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by burakergoren
 */
public class JenkinsDemo
{
	private static String Base_Url = "https://www.facebook.com";
	private WebDriver driver;

	@Before
	public void setUp() 
	{
		try {
			// Optional, if not specified, WebDriver will search your path for chromedriver.
			System.setProperty("webdriver.chrome.driver", "/Users/dmunoz/Documents/DevOpsVortexbird/DriversSelenium/chromedriver");
			driver = new ChromeDriver();
			driver.get(Base_Url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void after()
	{
		driver.quit();
	}

	@Test
	public void testCasePassed()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//form[@id='login_form']")).isDisplayed());
	}

	@Test
	public void testCaseFailed()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//form[@id='failed case']")).isDisplayed());
	}

	@Ignore
	@Test
	public void testCaseIgnored()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//form[@id='ignored case']")).isDisplayed());
	}
}