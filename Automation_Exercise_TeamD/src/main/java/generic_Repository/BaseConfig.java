package generic_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseConfig {
	public static WebDriver driver;
	@BeforeClass
	public void BrosweSetup() {
		driver=new ChromeDriver();
		driver.get("https://www.automationexercise.com/");
	}
	

}
