package utilities;

import java.net.MalformedURLException;

import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class QaBrowser extends QaRobot {

	public static WebDriver driver;
	public String browser = QaEnvironment.getProperty("browser", "chrome");
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
		driver.manage().deleteAllCookies();
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

//	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
//	private void launchChrome() throws MalformedURLException {
//		WebDriverManager.chromedriver().setup();
//		tlDriver.set(new ChromeDriver());
//	}

//	@SuppressWarnings("deprecation")
	private void launchChrome() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\chromeUpdate.exe");
		//DesiredCapabilities dc = DesiredCapabilities.chrome();
		//dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*"); 
		driver = (WebDriver) new ChromeDriver(co);
	}

	private WebDriver luanchFirefox() {
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
