package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import pageObjects.Q_PM_WebElm;

import java.util.Properties;

public class Q_PM_Init {
	

	protected static WebDriver driver ;
	protected static Properties pmQaProps;
	protected static Properties ticketsProp;
	protected static Properties newProp;

	protected static String baseUrl;
	protected static String adminUrl;
	protected static String jmAdmin;

	@org.testng.annotations.Parameters(value={"browser","version","platform"})
	public static void setItUp() throws Exception {
		Q_PM_BrowserUT but = new Q_PM_BrowserUT();
		driver = but.getBrowser("Chrome");
		baseUrl =  "https://qa.providentmetals.com";
		adminUrl = "https://qa.providentmetals.com/admin";
		jmAdmin = "https://qa.jmbullion.com/admin";
		driver.manage().window().maximize();
		driver.get(baseUrl);
		Q_PM_WebElm.myWait(500);
		driver.navigate().refresh();
		pmQaProps = Q_PM_ResourceUtils.pmQaProperties();
		ticketsProp = Q_PM_ResourceUtils.ticketsProperties();
		newProp = Q_PM_ResourceUtils.newFeaturesProperties();
  }
	
	@AfterSuite(alwaysRun = true)
	public static void kill(){
		//driver.close();
	}
	
}
