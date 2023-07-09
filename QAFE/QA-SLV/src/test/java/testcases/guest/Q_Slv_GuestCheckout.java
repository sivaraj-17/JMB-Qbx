package testcases.guest;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.Q_Slv_AdminSlvSteps;
import pageObjects.Q_Slv_CartSteps;
import pageObjects.Q_Slv_CheckoutSteps;
import pageObjects.Q_Slv_WebElm;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Q_Slv_GuestCheckout extends Q_Slv_Init {

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
    
    Q_Slv_AdminSlvSteps admin = new Q_Slv_AdminSlvSteps();
    Q_Slv_CheckoutSteps chk = new Q_Slv_CheckoutSteps();
    
    /*******************************************************************
    // * Description: Turns 3DS off
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1,enabled=false)
    public void turn3DSOff() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_Controls.adminLogin();
        admin.adminMenu("settings");
        Q_Slv_WebElm.xp(SLVqProp, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("off");
        Q_Slv_WebElm.myWait(1000);
    }
    
    /*******************************************************************
    // * Description: Verify guest user can complete guestCheckout using paper check payment method
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2)

    public void existingEmail() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.gold1("1");
        Q_Slv_CheckoutSteps.guestCheckoutEx("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp", "chk.guest.email.name", "qa1auto@jmbullion.com", "chk.guest.Exist.email.className");
        
    }
    /*******************************************************************
    // * Description: Verify guests can checkout via credit card
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3)
    public void guestCreditCard() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.silver1("4");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "test123@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(1);
        Q_Slv_CheckoutSteps.shippingAutoAddress(1);

        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder("chk.finishAndPlace.id");
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        
    }
    /*******************************************************************
    // * Description: Verify guests can checkout using bank wire payment method
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 4)
    public void guesBankwire() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);

        Q_Slv_CartSteps.silver2("2");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.BW.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "test123@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(1);
        Q_Slv_CheckoutSteps.shippingAutoAddress(1);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder("chk.finishAndPlace.id");
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        
    }
    /*******************************************************************
    // * Description: Verify guests can checkout using bank wire payment method
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 5)
    public void guestPaperCheck() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);

        Q_Slv_CartSteps.copper2("50");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "test123@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(3);
        Q_Slv_CheckoutSteps.shippingAutoAddress(3);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListSh());
        Q_Slv_CheckoutSteps.completeOrder("chk.finishAndPlace.id");
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
    
    /*******************************************************************
	 * Description: Verifies the correct PDP is launched when product description is
	 * clicked on Thank You page. 
	 * Author: Asfi Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-3594
	 ********************************************************************/
	@Test(priority = 6)
	public void verifyProductTitleOnThankYouPage_guest() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		guestPaperCheck();
		chk.verifyProductDescOnThankYouPage();
	}
	
	/********************************************************************
	 * Description: Verify successful guest order with new billing address
	 * Author: Tamilselvan A
 	 * Status: Complete   
	 * Ticket: JMB-4230
	 * @throws Exception 
	 *******************************************************************/
    @Test(priority = 7,enabled=true)
    public void guestOrderBillingAddress() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.silver1("4");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "jmbqa4@gmail.com");
        Q_Slv_CheckoutSteps.creditCardInput(1);
        Q_Slv_CheckoutSteps.shippingAutoAddress(1);
        chk.verifyBillingAddressField();
        chk.changeBillingAddressButton();
        chk.clickAddNewBillAddress();
        chk.billingAddressForm(6);
        chk.saveBillingAddress();
        Q_Slv_CheckoutSteps.completeOrder();
    }   
	
    /********************************************************************
	 // * Description  : To verify Email Validations On Checkout negative Scenario
	 // * Author       : Vignesh
	 // * Param        : NA
	 // * Jira Ticket  : JMB-7551  
	 // * Status       : Completed
	 // *******************************************************************/
	@Test(priority = 8, enabled = true)
	public void verifyEmailValidationsOnCheckout_negativeScenario() throws Exception {
		String actualErrorMessage="Please enter valid email address.";
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		Q_Slv_CartSteps.silver1("8");
		Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.EC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
		Q_Slv_CheckoutSteps.shippingAutoAddress(2);
		chk.loginToOnlineCheckingAccount();
		chk.completeGuestOrder();
		String expectedErrorMessage = Q_Slv_Controls.checkAndGetAlertText();
		Assert.assertTrue(actualErrorMessage.equals(expectedErrorMessage), "Able to checkout without valid email address");
	}
    @AfterMethod
    public void tearDown() throws Exception {
        Q_Slv_CartSteps.emptyCart();
        Q_Slv_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
