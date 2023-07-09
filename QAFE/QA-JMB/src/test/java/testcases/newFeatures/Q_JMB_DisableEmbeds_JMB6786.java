package testcases.newFeatures;

import org.testng.annotations.*;

import pageObjects.*;
import utils.*;

public class Q_JMB_DisableEmbeds_JMB6786 extends Q_JMB_Init {
	@BeforeMethod
	public void report() throws Exception {
		Q_JMB_Init.setItUp();
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
		Q_JMB_Controls.testStarted(tcName);
		Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
		acc.loginUser(2);
		//Navigate to any page
		Q_JMB_NavigationObjects.selectFromMenu("sales tax");
		Q_JMB_NewFeatures.verifyDisableEmbeds("type=\"application/json+oembed\"");
		Q_JMB_NewFeatures.verifyDisableEmbeds("type=\"text/xml+oembed\"");
		Q_JMB_NewFeatures.verifyDisableEmbeds("“oembed”");
		
	}


	@AfterMethod
	public void tearDown() throws Exception {
		Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
        acc.logoutUser();
		Q_JMB_Controls.tearDown();
	}
}
