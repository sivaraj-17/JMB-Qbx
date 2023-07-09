package testcases.negative;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;

import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.io.FileNotFoundException;

public class Q_JMB_NegativeCheckout extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_StuObjects stu = new Q_JMB_StuObjects();

    @BeforeClass
    public void tcSetup (){
    }
    
    @BeforeMethod
    public void report() throws Exception {
        Q_JMB_Init.setItUp();
    }
    
    @BeforeTest
    public void setTest() throws Exception {
    }
    
    /*******************************************************************
    // * Description: Verify error message if user attempts to enter quantity over the provisioned limit for a product.
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1)
    public static void invalidCartQuantity ()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("1 oz US Quarter Copper", 99999);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qaguesttest@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.completeOrder();
    }
    
    /*******************************************************************
    // * Description: Verify when user attempts 3 digit cvv for AMEX, visa or discover an error message will be displayed
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2)
    public static void guest3dCVVAmwx ()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("1 oz US Quarter Copper", 49);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qaguesttest@jmbullion.com");
        chk.shippingAddressForm(2);
        chk.saveShippingAddress();
        chk.creditCardForm(10);
        chk.completeOrderError();
    }
    
    /*******************************************************************
    // * Description: Verify when user attempts 2 digit cvv for AMEX, visa or discover an error message will be displayed
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3)
    public static void guest2dCVVAmwx ()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("1 oz US Quarter Copper", 49);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qaguesttest@jmbullion.com");
        chk.shippingAddressForm(11);
        chk.creditCardForm(11);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.completeOrderError();
    }
    
    /*******************************************************************
    // * Description: Verify when user attempts 2 digit cvv for visa or discover an error message will be displayed
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 4)
    public static void guest2dCVVVia ()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("1 oz US Quarter Copper", 49);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qaguesttest@jmbullion.com");
        chk.shippingAddressForm(11);
        chk.creditCardForm(9);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.completeOrderError();
    }
    
    /*******************************************************************
    // * Description: Verify when user attempts 4 digit cvv for visa or discover an error message will be displayed
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 5)
    public static void guest4dCVVVia ()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("1 oz US Quarter Copper", 49);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qaguesttest@jmbullion.com");
        chk.shippingAddressForm(11);
        chk.saveShippingAddress();
        chk.creditCardForm(8);
        chk.completeOrderError();
    }
    
    /*******************************************************************
    // * Description: Verify not allowed to use special characters in their last name
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 6)
    public static void lNameInvalidChar ()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);

        acc.loginUser(35);
        chk.selectItem("1 oz US Quarter Copper", 49);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.cvvCardType(3);
        chk.completeOrderError();
    }
    
    /*******************************************************************
    // * Description: Verify user is prompted to enter first name if field is left blank
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 7)
    public static void firstNameBlank ()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(20);
        chk.selectItem("1 oz US Quarter Copper", 49);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.editShippingName(9);
        chk.saveShippingAddress("Please enter your first name.");
        Q_JMB_Controls.checkAlert();
        Q_JMB_CartPageObjects.removeItems();
        acc.logoutUser();
    }
    
    /*******************************************************************
    // * Description: Verify if the credit card on file is expired the user is prompted to enter new credit card information during checkout
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 8)
    public static void expiredCard ()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(9);
        chk.selectItem("1 oz US Quarter Copper", 49);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("bottom");
        chk.creditCardRequired();
        Q_JMB_WebElm.myWait(5000);
        Q_JMB_CartPageObjects.removeItems();
        acc.logoutUser();
    }
    
    /*******************************************************************
     // * Description: Verify if the new credit card with expired date verify woocommerce error message "Your card has expired.
     // * Please resubmit your order with an active card."
     // * Author:
     // * Jira Ticket: JMB-6420
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9)
    public static void expiredCardErrorMsg ()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(10);
        chk.selectItem("1 oz US Quarter Copper", 49);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
//        chk.selectCard("mc", "321");
        chk.newCardClick();
        chk.creditCardForm(12);
        chk.completeOrderError();
        chk.CCVError("chk.ccverror.xp", "Please verify the Credit Card Number, Expiration Date, Security Code, and " +
                "Billing Address is correct. Please review any highlighted fields, enter the correct information, and try again. " +
                "If you keep receiving this error, please contact your card provider.");

        chk.CCVError("chk.woocommerce.error.xp","Your card has expired. Please resubmit your order with an active card.");
        Q_JMB_WebElm.myWait(1000);
        Q_JMB_CartPageObjects.removeItems();
        acc.logoutUser();
    }
    
    /*******************************************************************
     // * Description: This test case verifies user could see Alert on expiring cards
     // * Author:
     // * Status: Complete
     * Prerequisites: Add card for the current month
     *  Ticket : JMB-6039(Alert on expiring cards)
     * @throws Exception
     */
    @Test(priority = 10)
    public static void expiringCardAlert() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(37);
        acc.myAccount("payments");
        acc.paymentMethods("expiring card");
        chk.selectItem("100 oz Geiger Security", 2);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        chk.creditCardForm(12);
        Q_JMB_Controls.scrolDownPixel(500);
        String checkoutErrMsg="Your card has expired. Please resubmit your order with an active card.";
        chk.completeOrder();
        System.out.println("Checkout error message: " + Q_JMB_WebElm.cnRetText(jmbProps, "chk.guest.woocommerce.error.className"));
        Assert.assertEquals(Q_JMB_WebElm.cnRetText(jmbProps, "chk.guest.woocommerce.error.className"),checkoutErrMsg);
    }
    
    /*******************************************************************
     * Description: This test case verifies credit card expiration error message by
     * giving expired date
     * Author: Tamilselvan
     * Status: Complete
     * Ticket: JMB-6420(Website Card Checkout CVV & Card Expiration Messaging Updates)
     ********************************************************************/

    @Test(priority = 11)
    public static void expiredCard_error_msg() throws Exception {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(9);
        chk.selectItem("1 oz US Quarter Copper", 49);
        cart.selectPaymentType("credit card");
        Q_JMB_WebElm.myWait(3000);
        cart.selectcheckoutBtn("top");
        chk.creditCardForm(12);
        chk.CCVError();
        chk.completeOrderError();
    }
    
    /*******************************************************************
     * Description: Verifies that after editing address on Checkout page and then
     * selecting New Shipping Address that Continue with this Address button is not visible
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6650(Continue with Address appearing on New Shipping
     * 			Address after Editing and Saving existing address)
     ********************************************************************/
    @Test(priority = 12)
    public static void verifyCwtANotDisplayingNewAddrAfterEditingAddress() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(23);
        chk.selectItem("10 Gram Perth Mint Gold Bar", 1);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        chk.editShippingAndVerifyCwtAButtonAppears("123 Automation Lane");
        chk.clickOnNewAddrAndVerifyCwtAButtonDoesNotAppear();
    }

    /*******************************************************************
     // * Description: Verifies that after selecting address with valid Local
     // * Pickup on STU Checkout page and then create a new address with a zip
     // * code without a valid Local Pickup that the option no longer appears
     // * Author: Paul Patterson
     // * Status: Complete
     // * Ticket: JMB-6752
     //********************************************************************/
    @Test(priority = 13)
    public static void verifyLocalPickup_NewAddrNonPartZipAfterEditingAddress() throws  FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        stu.selToUs();
        stu.addBbItem("gold", 14, "4");
        stu.checkoutNow();
        // Address selection xpath for STU is the same as regular orders
        chk.selectShippingAddressByZipCode("75070");
        chk.verifyLocalDropOffOptionDisplay(true);
        chk.createNewAddressWithNonPartZipAndSave();
        chk.verifyLocalDropOffOptionDisplay(false);
    }

    @AfterTest
    public void endReport(){
    }
    @AfterMethod
    public void tearDown() throws Exception {
        Q_JMB_CartPageObjects.removeItems();
        Q_JMB_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
