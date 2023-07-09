package testcases.negative;

import java.io.FileNotFoundException;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

public class Q_Slv_Negative extends Q_Slv_Init {
	@BeforeClass
	public void tcSetup() {
	}

	@BeforeMethod
	public void report() throws Exception {
		Q_Slv_Init.setItUp();
	}

	/*******************************************************************
	 * Description: To verify it does not let user add the quantity more than what
	 * is there in inventory through PLP 
	 * Author: Asfi Khaliq 
	 * Status: Complete
	 * Ticket: JMB-6489
	 * 
	 * @throws FileNotFoundException
	 ********************************************************************/
	@Test(priority = 1)
	public void orderPlacedAndMarkedPaidWithZEROdollarValue_throughPLP() throws FileNotFoundException {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		String quan = "9999";
		Q_Slv_CartSteps.silver4(quan);
		Q_Slv_WebElm.myWait(2000);
		String text = Q_Slv_Controls.checkAndGetAlertText();
		Assert.assertTrue(text.contains("Unfortunately, we only have"));
	}

	/*******************************************************************
	 * Description: To verify it does not let user add the quantity more than what
	 * is there in inventory through PDP 
	 * Author: Asfi Khaliq 
	 * Status: Complete
	 * Ticket: JMB-6489
	 * 
	 * @throws FileNotFoundException
	 ********************************************************************/
	@Test(priority = 2)
	public void orderPlacedAndMarkedPaidWithZEROdollarValue_throughPDP() throws FileNotFoundException {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		String quan = "9999";
		driver.navigate().to(baseUrl + "/2016-1-oz-silver-american-eagles/");
		Q_Slv_WebElm.myWait(1000);
		Q_Slv_WebElm.xpClear(SLVqProp, "cart.pdp.qty.xp");
		Q_Slv_WebElm.xpSend(SLVqProp, "cart.pdp.qty.xp", quan);
		Q_Slv_WebElm.xp(SLVqProp, "cart.pdp.atc.xp");
		Q_Slv_WebElm.myWait(2000);
		String text = Q_Slv_Controls.checkAndGetAlertText();
		Assert.assertTrue(text.contains("Unfortunately, we only have"));
	}
	/*******************************************************************
	 * Description: Verifies that after editing address on Checkout page and then
	 * selecting New Shipping Address that Continue with this Address button is not visible
	 * Author: Paul Patterson
	 * Status: Complete
	 * Ticket: JMB-6650(Continue with Address appearing on New Shipping
	 * 			Address after Editing and Saving existing address)
	 ********************************************************************/
	@Test(priority = 3)
	public static void verifyCwtANotDisplayingNewAddrAfterEditingAddress() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
		Q_Slv_CartSteps.gold2("2");
		Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
		Q_Slv_CheckoutSteps.editShippingAndVerifyCwtAButtonAppears("123 Automation Lane");
		Q_Slv_CheckoutSteps.clickOnNewAddrAndVerifyCwtAButtonDoesNotAppear();
	}
	@AfterMethod
	public void tearDown() throws Exception {
		//AccountSteps.logout();
		Q_Slv_Controls.tearDown();
	}

	@AfterClass
	public void exitClass() {
		System.out.println("After Class");
	}
}
