package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import pageObjects.Q_JMB_WebElm;

import java.util.Properties;

public class Q_JMB_Init {
	protected static WebDriver driver ;
	protected static Properties jmbProps;
	protected static Properties ticketsProp;
	protected static Properties newProp;

	protected static String baseUrl;
	protected static String adminUrl;

	@org.testng.annotations.Parameters(value={"browser","version","platform"})
	public static void setItUp() throws Exception {
		Q_JMB_BrowserUT but = new Q_JMB_BrowserUT();
		driver = but.getBrowser("Chrome");
		baseUrl =  "https://qa.jmbullion.com";
		adminUrl = "https://qa.jmbullion.com/admin";

		driver.manage().window().maximize();
		driver.get(baseUrl);
		Q_JMB_WebElm.myWait(2000);
		driver.navigate().refresh();
		jmbProps = Q_JMB_ResourceUtils.jmbProperties();
		ticketsProp = Q_JMB_ResourceUtils.ticketsProperties();
		newProp = Q_JMB_ResourceUtils.newFeaturesProperties();
	}

	@AfterSuite
	public static void kill(){
		//driver.close();
	}


}
