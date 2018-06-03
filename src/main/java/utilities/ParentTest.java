package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ParentTest {
	
	protected ChromeDriver driver = null;
	String testName = this.getClass().getSimpleName();
	Properties properties = null;	
	// to read test data
	
	// to launch browser
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vshar10\\Downloads\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://gmail.com");
	}
	
	
	// to quit browser
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String getData(String key) {
		// Get class name
		if (properties == null) {
			String filePath = System.getProperty("user.dir")+"\\src\\test\\DataFiles\\"+testName+".properties";
			properties = new Properties();
			try {
				properties.load(new FileInputStream(new File(filePath)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return properties.getProperty(key);
	}
	
	
}
