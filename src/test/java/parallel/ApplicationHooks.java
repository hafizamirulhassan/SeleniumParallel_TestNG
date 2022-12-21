package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DataFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	
	private DataFactory datafactory;
	private ConfigReader configReader;
	private WebDriver driver;
	Properties prop;
	
	@Before(order = 0)
	public void getProperty() {
		
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		
	}
	
	@Before(order = 1)
	public void launchBrowser() {
	String BrowserName =	prop.getProperty("browser");
	datafactory = new DataFactory();
	driver = datafactory.init_driver(BrowserName);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
	
		if(scenario.isFailed()) {
			
			String ScreenshotName = scenario.getName().replaceAll("", "_");
		byte[] sourcePath =	((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "image/png", ScreenshotName);
			
		}
		
	}
}
