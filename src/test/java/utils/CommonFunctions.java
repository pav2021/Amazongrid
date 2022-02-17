package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//CommonFunctions as driverfactory
public class CommonFunctions {

	public static WebDriver driver;

	/*public static ThreadLocal<WebDriver> th1 = new ThreadLocal<WebDriver>();

	public void launch(String browser, String url) {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		String remaining_path = "\\Drivers\\chromedriver.exe";

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", path + remaining_path);
			th1.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Automation\\Selenium\\Drivers\\geckodriver.exe");
			th1.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("msedge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Automation\\Selenium\\Drivers\\msedgedriver.exe");
			th1.set(new EdgeDriver());
		} else {
			System.out.println("this is not the correct browser parameter>> give valid input" + browser);
			System.exit(0);
		}
		if (url != "")
			th1.get().get(url);
		else
			th1.get().get("about:blank");

		getDriver().manage().window().maximize();

		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void tearDown() {
		th1.get().quit();
	}

	public static synchronized WebDriver getDriver() {
		return th1.get();
	}*/
	
	
	//public static ThreadLocal<WebDriver> th1 = new ThreadLocal<WebDriver>();

	public void launch(String browser, String url) throws MalformedURLException {
		
		
		DesiredCapabilities capabilities =new DesiredCapabilities();
		

		if (browser.equalsIgnoreCase("chrome")) {
			capabilities.setPlatform(Platform.ANY);
			capabilities.setBrowserName(BrowserType.CHROME);
		
		} else if (browser.equalsIgnoreCase("firefox")) {
			capabilities.setPlatform(Platform.ANY);
			capabilities.setBrowserName(BrowserType.FIREFOX);
		} else if (browser.equalsIgnoreCase("msedge")) {
			capabilities.setPlatform(Platform.ANY);
			capabilities.setBrowserName(BrowserType.EDGE);
		} else {
			System.out.println("this is not the correct browser parameter>> give valid input" + browser);
			System.exit(0);
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);
		
		if (url != "")

			driver.get(url);
		
		else
			driver.get("about:blank");

		getDriver().manage().window().maximize();

		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void tearDown() {
		driver.quit();
	}

	public static synchronized WebDriver getDriver() {
		return driver;
	}
	
	

}
