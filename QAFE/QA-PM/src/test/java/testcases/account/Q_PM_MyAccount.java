package testcases.account;


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


public class Q_PM_MyAccount extends Q_PM_Init {
	Q_PM_AccountSteps acc = new Q_PM_AccountSteps();
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
    // * Description: Register New User
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =1)

    public static void registerNewUser() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.registerNow("acc.login.id", "acc.createAccount.id",4, "acc.create.regBtn.id");
        Assert.assertTrue(Q_PM_WebElm.cnDisplayed(pmQaProps, "acc.welcomeMsg.className"));
        Q_PM_AccountSteps.deleteUser();
        Assert.assertTrue(Q_PM_WebElm.idDisplayed(pmQaProps, "acc.login.submitBtn.id"));
    }

    /*******************************************************************
    // * Description: Register user at Checkout then Delete User
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =2)

    public static void regUserCheckout() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.silver_2_2553739("16");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.bridgePage("checkout register", "chk.checkoutNowGuest.xp");
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_WebElm.myWait(2000);
        Q_PM_CheckoutSteps.completeOrder("chk.finishPlaceOrder.id");
        Q_PM_AccountSteps.checkoutRegistration(4, "acc.create.regBtn.id");

        Q_PM_AccountSteps.deleteUser();
//        Assert.assertTrue(WebElm.idDisplayed(pmQaProps,"login.submitBtn.id"));
        driver.navigate().to(baseUrl);
        Q_PM_CartSteps.verifyCartItems();
        driver.navigate().refresh();
    }
    /*******************************************************************
    // * Description: Verify Dashboard page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =3)

    public static void dashboardPage(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(0);
        try{
            Q_PM_AccountSteps.accountMenu("DASHBOARD");
            Q_PM_AccountSteps.confirmAccountPage();
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
        catch(Throwable ex){
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
    }

    /*******************************************************************
    // * Description: Verify Paid order status
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =4)

    public static void paidOrder(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(22);
        try{
            Q_PM_AccountSteps.accountMenu("MY ORDERS");
            Q_PM_WebElm.myWait(2000);
            Q_PM_AccountSteps.accOrderStatus("paid");
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }

        catch(Throwable ex){
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
    }
    /*******************************************************************
    // * Description: Verified Pending order status
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =5)

    public static void pendingOrder(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(23);
        try{
            Q_PM_AccountSteps.accountMenu("MY ORDERS");
            Q_PM_AccountSteps.accOrderStatus("pending");
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
        catch(Throwable ex){
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
    }
    /*******************************************************************
    // * Description: Verified user can page Next and Previous order
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =6)

    public static void orderPaging() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(29);
        Q_PM_AccountSteps.accountMenu("MY ORDERS");
        try {
            Q_PM_AccountSteps.accOrderStatus("paging");
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
        catch(Throwable ex){
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }

    }

    /*******************************************************************
    // * Description: Edit first account address
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =7)

    public static void editAccAddress() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(0);
        Q_PM_AccountSteps.accountMenu("DASHBOARD");
        try{
            Q_PM_AccountSteps.accAddress("edit first address");
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
        catch(Throwable ex){
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
    }
    /*******************************************************************
    // * Description: Add new shipping address
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =8)

    public static void newAccAddress() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(5);
        Q_PM_AccountSteps.accountMenu("DASHBOARD");
        try{
            Q_PM_AccountSteps.accAddress("new address");
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
        catch(Throwable ex){
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
    }
    /*******************************************************************
    // * Description: Register New User
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =9)

    public static void deleteAccAddress() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(5);
        Q_PM_AccountSteps.accountMenu("DASHBOARD");
        try{
            Q_PM_AccountSteps.accAddress("delete");
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
        catch(Throwable ex){
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
    }
    /*******************************************************************
    // * Description: List cards on file
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =10)

    public static void accListCards() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(29);
        Q_PM_AccountSteps.accountMenu("DASHBOARD");
        try{
            Q_PM_AccountSteps.accPayments("list cards", 1, 5);
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
        catch(Throwable ex){
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
    }
    /*******************************************************************
    // * Description: Switch default credit cards
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =11)
    public static void accSwitchDefault() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(29);
        Q_PM_AccountSteps.accountMenu("DASHBOARD");
        try{
            Q_PM_AccountSteps.accPayments("set default", 1, 5);
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
        catch(Throwable ex){
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
    }
    /*******************************************************************
    // * Description: Add New Credit Card
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =12)
    public static void addNewCard() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(5);
        Q_PM_AccountSteps.accountMenu("DASHBOARD");
        try{
            Q_PM_AccountSteps.accPayments("new card", 2, 14);
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
        catch(Throwable ex){
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
    }
    /*******************************************************************
    // * Description: Delete Account Credit Cards
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =13)

    public static void delAccCreditCards() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(5);
        Q_PM_AccountSteps.accountMenu("DASHBOARD");
        try{
            Q_PM_AccountSteps.accPayments("delete cards", 3, 2 );
            Q_PM_AccountSteps.accAddress("delete");
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
        catch(Throwable ex){
            Q_PM_AccountSteps.accountMenu("LOGOUT");
        }
   }
    /*******************************************************************
     // * Description: Verifies Buy Again Feature
     // * Author:
     // * Status: Complete
     *  Ticket : JMB-6056(Buy Again from my account view orders)
     * @throws Exception
     */

    @Test(priority =14)
    public static void verifyBuyAgain()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(21);
        Q_PM_WebElm.myWait(3000);
        Q_PM_AccountSteps.myAccountMenu("My Orders");
        Q_PM_AccountSteps.buyAgain();
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.cardSelection("switchCard");
        Q_PM_CheckoutSteps.completeOrder();

    }
    
    /*******************************************************************************
    // * Description: To verify we donot allow customer to change email address online
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 6606
	 *******************************************************************************/	
    @Test(priority = 15, enabled = true)
	public void verifyWeDoNotAllowCustomerToChangeEmailAddressOnlineInMyAccounts() {
    	String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(1);
        driver.navigate().to(baseUrl + "/customer/account/");
        acc.validateCannotChangeEmailAddressMessage("howToChangeEmailAddress");
    }
    
    /*****************************************************************************************************
    // * Description: To verify we donot allow customer to change email address online after clicking Edit
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 6606
	 ******************************************************************************************************/	
    @Test(priority = 16, enabled = true)
	public void verifyWeDoNotAllowCustomerToChangeEmailAddressOnline() {
    	String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(1);
        driver.navigate().to(baseUrl + "/customer/account/");
        acc.validateCannotChangeEmailAddressMessage("editButton");
    }
    
    @AfterTest
    public void endReport(){
    }
    @AfterMethod
    public void tearDown() throws Exception {
        Q_PM_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}

