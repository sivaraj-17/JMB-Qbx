package testcases.salesTax;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Q_Slv_AccountSteps;
import pageObjects.Q_Slv_CartSteps;
import pageObjects.Q_Slv_CheckoutSteps;
import pageObjects.Q_Slv_WebElm;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

public class Q_Slv_CaliforniaTax extends Q_Slv_Init {
	@BeforeClass
	public void tcSetup (){

	}
	@BeforeMethod
	public void report() throws Exception {
		Q_Slv_Init.setItUp();
	}
	@BeforeTest
	public void setTest() throws Exception {
	}
	
	/*******************************************************************
     * Description: Verifies California Tax updates - Specific product under $1500 has tax 
     * Author:
     * Status: Complete
     * Ticket : JMB-6353(California Sales Tax Update)
     ********************************************************************/
	@Test(priority = 1)
    public static void californiaTaxSpecificProductLessThan1500()throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		Q_Slv_AccountSteps.login("acc.login.link.xp", 15);
		Q_Slv_CartSteps.chineseSilverPanda201630gms("37");
		Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
		Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "chk.reg.newcard.id"));
		ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
		Q_Slv_CheckoutSteps.completeOrder();
		ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
		Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);

    }

	/*******************************************************************
     * Description: Verifies California Tax updates - Specific product over $1500 has no tax 
     * Author:
     * Status: Complete
     * Ticket : JMB-6353(California Sales Tax Update)
     ********************************************************************/
	@Test(priority = 1)
    public static void californiaNoTaxSpecificProductOverThan1500()throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		Q_Slv_AccountSteps.login("acc.login.link.xp", 15);
		Q_Slv_CartSteps.chineseSilverPanda201630gms("50");
		Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
		Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "chk.reg.newcard.id"));
		ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
		Q_Slv_CheckoutSteps.completeOrder();
		ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
		Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);

    }
	@AfterMethod
	public void tearDown() throws Exception {
		Q_Slv_CartSteps.emptyCart();
		Q_Slv_AccountSteps.logout();
		Q_Slv_Controls.tearDown();
	}
	@AfterClass
	public void exitClass(){
	}

}
