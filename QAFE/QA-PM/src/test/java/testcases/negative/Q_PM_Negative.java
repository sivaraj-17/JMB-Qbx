package testcases.negative;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Q_PM_AccountSteps;
import pageObjects.Q_PM_CartSteps;
import pageObjects.Q_PM_CheckoutSteps;
import pageObjects.Q_PM_WebElm;
import testcases.cart.Q_PM_AddToCart;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

import java.io.FileNotFoundException;

public class Q_PM_Negative extends Q_PM_Init {

    @BeforeClass
    public void tcSetup (){

    }
    @BeforeMethod
    public void report() throws Exception {
        Q_PM_Init.setItUp();
    }
    @BeforeTest
    public void setTest() throws Exception {
    }
    /*******************************************************************
     // * Description: Verify shipping to Puerto Rico for PM user is not allowed
     // * Author:
     // * Status: Complete
     /*******************************************************************/
    @Test(priority = 1)
    public static void regPuertoRico()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(11);
        Q_PM_AddToCart.silver_2_2553739("6");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.cardSelection("defaultCard");
        Q_PM_WebElm.id(pmQaProps, "chk.finishPlaceOrder.id");
        System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "chk.woocommerceError.cn"));
        Assert.assertTrue(Q_PM_WebElm.cnDisplayed(pmQaProps, "chk.woocommerceError.cn"));
        driver.navigate().to(baseUrl + "/cart");
        Q_PM_CartSteps.deleteItems();
        Q_PM_AccountSteps.accountMenu("LOGOUT");
    }
    /*******************************************************************
     // * Description: PayPal users cannot ship to Puerto Rico
     // * Author:
     // * Status: Complete
     /*******************************************************************/
    @Test(priority = 2)
    public static void payPalPuertoRico()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.silver_2_2553739("6");
        Q_PM_CheckoutSteps.selectPaymentType("paypal_express");
        Q_PM_CheckoutSteps.payPal("automation.tester001@jmb.paypalsandbox.com", "Testing123!");
        Q_PM_CheckoutSteps.completeOrder();
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "chk.ppPuertoError.xp"));
        Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "chk.ppPuertoError.xp").contains( "We are sorry! We do not ship to Puerto Rico or any US territory"));
        driver.navigate().to(baseUrl + "/cart");
        Q_PM_CartSteps.deleteItems();
    }
    /*******************************************************************
     // * Description: This test case verifies user could see Alert on expiring cards
     // * Author:
     // * Status: Complete
     * Prerequisites: Add card for the current month
     *  Ticket : JMB-6039(Alert on expiring cards)
     * @throws Exception
     */
    @Test (priority = 3)
    public void expiringCardAlert() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(38);
        Q_PM_AccountSteps.accountMenu("DASHBOARD");
//        AccountSteps.accPayments("expiring card", 11, 14);
//        String alertText = "General Error. To resolve this issue, please contact your bank using the number on the back of your card to proceed.";
        String errMsg="Important Note: Your default Credit Card has expired or is expiring this month. Please add a new valid Credit Card before proceeding.";
        Assert.assertTrue(Q_PM_WebElm.idRetText(pmQaProps, "chk.checkout.ccExpiring.msg.id").contains(errMsg));
//        CheckoutSteps.completeOrder();
        Q_PM_AccountSteps.accountMenu("DASHBOARD");
//        AccountSteps.accPayments("delete cards", 3, 2 );
        Q_PM_AccountSteps.accountMenu("LOGOUT");

    }

    /*******************************************************************
     // * Description: This test case verifies user could see error message during checkout if expiring card being added
     // * Author:
     // * Status: Complete
     * Prerequisites: Add card for the current month
     *  Ticket : JMB-6039(Alert on expiring cards)
     * @throws Exception
     */
    @Test (priority = 4)
    public void expiringCardCheckout() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(38);
        Q_PM_AddToCart.silver_2_2553739("1");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
//        CheckoutSteps.creditForm(11);
        Q_PM_CheckoutSteps.cardSelection("defaultCard");

        String errMsg="Important Note: Your default Credit Card has expired or is expiring this month. Please add a new valid Credit Card before proceeding.";
        Assert.assertTrue(Q_PM_WebElm.idRetText(pmQaProps, "chk.checkout.ccExpiring.msg.id").contains(errMsg));
        Q_PM_CheckoutSteps.completeOrder();
        Q_PM_AccountSteps.accountMenu("DASHBOARD");
//        AccountSteps.accPayments("delete cards", 3, 2 );
        Q_PM_AccountSteps.accountMenu("LOGOUT");

    }
    /*******************************************************************
     * Description: Verifies that after editing address on Checkout page and then
     * selecting New Shipping Address that Continue with this Address button is not visible
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6650(Continue with Address appearing on New Shipping
     * 			Address after Editing and Saving existing address)
     ********************************************************************/

    @Test(priority = 5)
    public static void verifyCwtANotDisplayingNewAddrAfterEditingAddress() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(21);
        Q_PM_AddToCart.gold_1_2553140("3");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.editShippingAndVerifyCwtAButtonAppears("123 Automation Lane");
        Q_PM_CheckoutSteps.clickOnNewAddrAndVerifyCwtAButtonDoesNotAppear();
    }
    @AfterTest
    public void endReport(){
    }
    @AfterMethod
    public void tearDown() throws Exception {
        Q_PM_CartSteps.deleteItems();
        Q_PM_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }

}
