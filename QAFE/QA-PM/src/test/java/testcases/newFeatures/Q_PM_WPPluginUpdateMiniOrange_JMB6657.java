package testcases.newFeatures;

import org.testng.annotations.*;
import pageObjects.*;
import utils.*;
//import utils.Log;

import java.io.FileNotFoundException;

public class Q_PM_WPPluginUpdateMiniOrange_JMB6657 extends Q_PM_Init {
	@BeforeMethod
	public void report() throws Exception {
		Q_PM_Init.setItUp();
	}

	// *******************************************************************
	// * Description: This test case verifies the QAPM login from SSO
	// * Author: Tamilselvan
	// * Status: Complete
	// * Ticket : JMB-6657(WP Plugin update: MiniOrange)
	// ****************************************************************/
	@Test(priority = 1, enabled = true)
	public static void ssoLoginPM() throws FileNotFoundException {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Q_PM_Controls.testStarted(tcName);
		Q_PM_NewFeatures.ssoLogin();
		Q_PM_NewFeatures.ssoLoginPM();
	}

	// *******************************************************************
	// * Description: This test case verifies pluginversion
	// * Author: Tamilselvan
	// * Status: Complete
	// * Ticket : JMB-6657(WP Plugin update: MiniOrange)
	// ****************************************************************/
	@Test(priority = 2)
	public void miniOrangeWpPluginVersionVerifcation() {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Q_PM_Controls.testStarted(tcName);
		Q_PM_NewFeatures.ssoLogin();
		Q_PM_NewFeatures.ssoLoginPM();
		Q_PM_NewFeatures.pluginVersion("miniOrange SSO using SAML 2.0", "Version 12.0.4");
	}

	@AfterMethod
	public void tearDown() throws Exception {

		Q_PM_Controls.tearDown();
	}
}
