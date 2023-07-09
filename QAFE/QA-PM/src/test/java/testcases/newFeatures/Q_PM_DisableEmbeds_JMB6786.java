package testcases.newFeatures;

import org.testng.annotations.*;

import pageObjects.*;
import testcases.cart.Q_PM_AddToCart;
import utils.*;

public class Q_PM_DisableEmbeds_JMB6786 extends Q_PM_Init {
	@BeforeMethod
	public void report() throws Exception {
		Q_PM_Init.setItUp();
	}

	// *******************************************************************
	// * Description: This test case verifies Disable Embeds
	// * Author: Tamilselvan
	// * Status: Complete
	// * Ticket : JMB-6786 [Security] Disable Embeds
	// *****************************************************************/
	@Test(priority = 1, enabled = true)
	public static void disableEmbeds()  {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Q_PM_Controls.testStarted(tcName);
		Q_PM_AccountSteps.loginUser(22);
		//Navigate to any page
		Q_PM_AddToCart.gold_1_2553140("1");
		Q_PM_NewFeatures.verifyDisableEmbeds("type=\"application/json+oembed\"");
		Q_PM_NewFeatures.verifyDisableEmbeds("type=\"text/xml+oembed\"");
		Q_PM_NewFeatures.verifyDisableEmbeds("“oembed”");
		
	}


	@AfterMethod
	public void tearDown() throws Exception {
		Q_PM_CartSteps.deleteItems();
		Q_PM_Controls.tearDown();
	}
}
