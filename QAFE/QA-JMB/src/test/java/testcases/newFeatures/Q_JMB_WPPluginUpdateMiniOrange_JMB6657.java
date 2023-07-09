package testcases.newFeatures;

import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.io.FileNotFoundException;

public class Q_JMB_WPPluginUpdateMiniOrange_JMB6657 extends Q_JMB_Init {
	@BeforeMethod
	public void report() throws Exception {
		Q_JMB_Init.setItUp();
	}

	// *******************************************************************
	// * Description: This test case verifies the QAJM login from SSO
	// * Author: Tamilselvan
	// * Status: Complete
	// * Ticket : JMB-6657(WP Plugin update: MiniOrange)
	// ****************************************************************/
	@Test(priority = 1, enabled = true)
	public static void ssoLoginJM() throws FileNotFoundException {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		Q_JMB_NewFeatures.ssoLogin();
		Q_JMB_NewFeatures.ssoLoginJM();
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
		Q_JMB_Controls.testStarted(tcName);
		Q_JMB_NewFeatures.ssoLogin();
		Q_JMB_NewFeatures.ssoLoginJM();
		Q_JMB_NewFeatures.pluginVersion("miniOrange SSO using SAML 2.0", "Version 12.0.4");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Q_JMB_Controls.tearDown();
	}
}
