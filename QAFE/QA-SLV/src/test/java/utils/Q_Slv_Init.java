package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

import java.util.Properties;

public class Q_Slv_Init {
	

	protected static WebDriver driver ;
	protected static Properties ticketsProp;
	protected static Properties newProp;
	protected static Properties SLVqProp;

	protected static String baseUrl;
	protected static String jmAdmin;

	@org.testng.annotations.Parameters(value={"browser","version","platform"})
	public static void setItUp() throws Exception {
		Q_Slv_BrowserUT but = new Q_Slv_BrowserUT();

		driver = but.getBrowser("Chrome");
		baseUrl =  "https://qa.silver.com";
		jmAdmin = "https://qa.jmbullion.com/admin";
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.get(baseUrl);
		ticketsProp = Q_Slv_ResourceUtils.ticketsProperties();

		newProp = Q_Slv_ResourceUtils.newFeaturesProperties();
		SLVqProp = Q_Slv_ResourceUtils.SLVqProperties();
  }
	
	@AfterSuite
	public static void kill(){
		//driver.close();
	}
	
}
