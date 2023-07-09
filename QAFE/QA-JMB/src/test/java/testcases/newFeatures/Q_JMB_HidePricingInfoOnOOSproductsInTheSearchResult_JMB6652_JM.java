package testcases.newFeatures;

import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.io.FileNotFoundException;

public class Q_JMB_HidePricingInfoOnOOSproductsInTheSearchResult_JMB6652_JM extends Q_JMB_Init {
	@BeforeMethod
	public void report() throws Exception {
		Q_JMB_Init.setItUp();
	}

	/*******************************************************************
	 * Description: This test case verifies that the price for OOS 
	 * products in the search result is not displayed 
	 * Author: Asfi.Khaliq 
	 * Status: Complete
	 * Ticket : JMB-6652
	 *******************************************************************/
	@Test(priority = 1)
	public static void hidePricingInfo_OOSproducts() throws FileNotFoundException {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		Q_JMB_NewFeatures.searchThroughMainBox("1 oz american gold eagle coin (random year)");
		Q_JMB_NewFeatures.priceInfo_OOSproducts();
		System.out.println("All OOS products do not have their respective price displayed.");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Q_JMB_Controls.tearDown();
	}
}