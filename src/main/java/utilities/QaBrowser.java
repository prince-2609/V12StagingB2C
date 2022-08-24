package utilities;

import java.net.MalformedURLException;

import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class QaBrowser extends QaRobot {

	public static WebDriver driver;
	public String browser = QaEnvironment.getProperty("browser","chrome");
	public String url = QaEnvironment.getProperty("sut.url");

	public WebDriver launchBrowser() throws Exception {
		if (this.url == null || this.url.isBlank() || this.url.isEmpty()) {
			throw new Exception("url is null");
		}
		quitBrowser();
		if (this.browser.equalsIgnoreCase("gecko")) {
			luanchFirefox();

		} else if (this.browser.equalsIgnoreCase("chrome")) {
			launchChrome();
		}
		driver.navigate().to(this.url);
		driver.manage().window().maximize();
		return driver;
	}

	public WebDriver launchBrowser(String url) throws Exception {
		this.url = url;
		return launchBrowser();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

//	@SuppressWarnings("deprecation")
	private void launchChrome() throws MalformedURLException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\chromedriver.exe");
		driver = (WebDriver) new ChromeDriver();
	}
	
	private WebDriver luanchFirefox() 
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\lib\\geckodriver1.exe");
		driver = (WebDriver) new FirefoxDriver();
		return driver;
	}

	@SuppressWarnings("unused")
	private WebDriver remoteWebDriver(DesiredCapabilities dc) throws MalformedURLException {
		throw new NotImplementedException("Remote web driver");
		// driver = new RemoteWebDriver(new URL(this.nodeUrl), dc);
		// return driver;
	}

}
