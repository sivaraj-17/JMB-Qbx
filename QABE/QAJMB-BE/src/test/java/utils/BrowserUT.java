package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.concurrent.TimeUnit.SECONDS;


public class BrowserUT{
	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	//
	// * Factory method for getting browsers
	//
	public WebDriver getBrowser(String browserName) {
		WebDriver driver = null;

		switch (browserName) {
			case "Firefox":
				driver = drivers.get("Firefox");
				if (driver == null) {
					String uAgent = System.getProperty("os.name");
					if (uAgent.contains("Windows"))	{
						WebDriverManager.firefoxdriver().setup();
					}
					//System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
					//System.setProperty("webdriver.gecko.driver", "../../../../SeleniumWebDrivers/geckodriver");
					//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"temp/logs.txt");
//					WebDriverManager.firefoxdriver().setup();
					ProfilesIni profile = new ProfilesIni();
					FirefoxProfile ffprofile = profile.getProfile("default");
					driver = new FirefoxDriver();
					DesiredCapabilities caps = DesiredCapabilities.firefox();
					caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
					//driver.manage().window().setSize(new Dimension(1300, 1000));
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, SECONDS);
				}
				break;
			case "Edge":
//				driver = drivers.get("Edge");
				if (driver == null) {
					WebDriverManager.edgedriver().setup();
					//WebDriverManager.edgedriver().driverVersion("98.0.1108.62").setup();
					driver = new EdgeDriver();
					//driver.manage().window().setSize(new Dimension(1350, 1000));
					//driver.manage().window().setPosition(new Point(0, 0));
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(20, SECONDS);
					driver.manage().timeouts().pageLoadTimeout(180, SECONDS);
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability("allow-blocked-content", true);
					capabilities.setCapability("allowBlockedContent", true);


				}
				break;
			case "Chrome":
				driver = drivers.get("Chrome");
				if (driver == null) {
					WebDriverManager.chromedriver().setup();
					//WebDriverManager.chromedriver().driverVersion("98.0.4758.102").setup();

					ChromeOptions options = new ChromeOptions();
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("credentials_enable_service", false);
					prefs.put("profile.password_manager_enabled", false);
					options.setExperimentalOption("prefs", prefs);
					options.addArguments("--allow-running-insecure-content");
					prefs.put("profile.default_content_settings.geolocation", false);
					options.setExperimentalOption("useAutomationExtension", false);
					options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setBrowserName("Chrome");
					capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					capabilities.setVersion("ANY");
					capabilities.setPlatform(Platform.WINDOWS);
					driver = new ChromeDriver(options);
					//driver.manage().window().setSize(new Dimension(1350, 1000));
					//driver.manage().window().setPosition(new Point(0, 0));
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(20, SECONDS);
					driver.manage().timeouts().pageLoadTimeout(180, SECONDS);
//			    drivers.put("Chrome", driver);


				}
				break;
		}
		return driver;
	}

}
