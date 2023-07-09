package utils;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Init {

	protected static WebDriver driver ;
	protected static Properties adminProps;
//    protected static Properties orderProps;
//	protected static Properties shippingProps;
//	protected static Properties receiptsProps;
//	protected static Properties buyProps;
//	protected static Properties productProps;
//	protected static Properties checkoutProps;
//	protected static Properties settingsProps;
//	protected static Properties onHoldProps;
//	protected static Properties custProps;
	protected static Properties sanProps;
	protected static Properties ticketsProps;
	protected static Properties nfProps;
	protected static String adminUrl;
	protected static String baseUrl;


	public static void setItUp()  {
		BrowserUT but = new BrowserUT();
		driver = but.getBrowser("Chrome");
		driver.manage().window().maximize();
		adminUrl = "https://qa.jmbullion.com/admin";
//		driver.get(adminUrl);
		baseUrl = "https://qa.jmbullion.com/";
		adminProps = ResourceUtils.getAdminProperties();
		sanProps = ResourceUtils.getSanityProperties();
		ticketsProps = ResourceUtils.getTicketsProperties();
		nfProps = ResourceUtils.getNewFeaturesProperties();
  }

	
}
