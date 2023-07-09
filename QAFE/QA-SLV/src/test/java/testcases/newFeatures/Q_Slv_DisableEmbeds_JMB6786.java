package testcases.newFeatures;

import org.testng.annotations.*;

import pageObjects.*;
import utils.*;

import java.io.FileNotFoundException;

public class Q_Slv_DisableEmbeds_JMB6786 extends Q_Slv_Init {
	@BeforeMethod
	public void report() throws Exception {
		Q_Slv_Init.setItUp();
	}

	// *******************************************************************
	// * Description: This test case verifies Disable Embeds
	// * Author: Tamilselvan
	// * Status: Complete
	// * Ticket : JMB-6786 [Security] Disable Embeds
	// *****************************************************************/
	@Test(priority = 1, enabled = true)
	public static void disableEmbeds() throws FileNotFoundException  {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
		//Navigate to any page
		Q_Slv_CartSteps.gold3("1");
		Q_Slv_NewFeatures.verifyDisableEmbeds("type=\"application/json+oembed\"");
		Q_Slv_NewFeatures.verifyDisableEmbeds("type=\"text/xml+oembed\"");
		Q_Slv_NewFeatures.verifyDisableEmbeds("“oembed”");
		
	}


	@AfterMethod
	public void tearDown() throws Exception {
		Q_Slv_CartSteps.emptyCart();
		Q_Slv_AccountSteps.logout();
		Q_Slv_Controls.tearDown();
	}
}
