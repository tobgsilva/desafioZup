package core;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue()
		{	return initDriver();
			}
	};
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static WebDriver initDriver() {
		WebDriver driver = null;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.americanas.com.br/");
		return driver;
	}
	
	public static void KillDriver() throws IOException {	
		WebDriver driver = getDriver();
		
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}
}
