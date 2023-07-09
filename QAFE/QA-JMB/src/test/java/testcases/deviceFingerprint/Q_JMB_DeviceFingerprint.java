package testcases.deviceFingerprint;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import testcases.guest.Q_JMB_GuestCheckout;
import testcases.navigation.Q_JMB_FooterNavigation;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;
import java.util.Date;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Q_JMB_DeviceFingerprint extends Q_JMB_Init {
	static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
	static Q_JMB_AdminObjects adm = new Q_JMB_AdminObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_CategoryObjects cat = new Q_JMB_CategoryObjects();
    static Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();
    static Q_JMB_NavigationObjects nav = new Q_JMB_NavigationObjects();
    static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()).replace(".", "_");
    static String regEmailStart = "qa+dfp";
    static String regEmailEnd = "@jmbbullion.com";
    static String regEmail1, regEmail2, regEmail3;

    @BeforeClass
    public void tcSetup (){
    	regEmail1 = regEmailStart + timeStamp + "_1" + regEmailEnd;
    	regEmail2 = regEmailStart + timeStamp + "_2" + regEmailEnd;
    	regEmail3 = regEmailStart + timeStamp + "_3" + regEmailEnd;
    }
    @BeforeMethod
    public void report() throws Exception {
        Q_JMB_Init.setItUp();
    }
    @BeforeTest
    public void setTest() throws Exception {
    }
    
    /*******************************************************************
    // * Description: Configures device fingerprint settings in order to perform tests
    // * Author: Paul Patterson
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1)
    public void deviceFingerPrintSetup()throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       Q_JMB_Controls.adminLogin();
       driver.navigate().to(adminUrl + "/blocking-rules.php");
       adm.setCreditCardBlockingRules("2", "0", "3", "0", "3");
       adm.setAccountRegistrationBlockingRules("2", "0", "3", "0", "3");
       adm.setCheckoutBlockingRules("2", "0", "3", "0", "3");
       adm.setContactUsBlockingRules("2", "0", "3", "0", "3");
       adm.setLoginBlockingRules("2", "0", "3", "0", "3");
       adm.setResetPasswordBlockingRules("2", "0", "3", "0", "3");
       adm.toggleIPWhitelistBlockingRules(false);
       adm.toggleUpdateBlockingRuleChanges();
       Q_JMB_WebElm.myWait(3000);
    }
    
    /*******************************************************************
    // * Description: Test Register Login Blocking Rules 
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2)
    public void registerLoginBlocking()throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       acc.loginUserWrongPassword(50);
       driver.navigate().to(baseUrl);
       acc.loginUser(50);
       acc.logoutUser();
       acc.loginUserBlock(50);
    }
    
    /*******************************************************************
    // * Description: Test Account Registration Blocking Rules 
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3)
    public void accountRegistrationBlocking()throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       Q_JMB_WebElm.myWait(2000);
       acc.deviceFingerprintAccountRegistration(regEmail1);
       acc.deleteUser();
       driver.navigate().to(baseUrl);
       Q_JMB_WebElm.myWait(3000);
       acc.deviceFingerprintAccountRegistration(regEmail2);
       acc.deleteUser();
       driver.navigate().to(baseUrl);
       Q_JMB_WebElm.myWait(3000);
       acc.deviceFingerprintAccountRegistration(regEmail3);
       acc.verifyUserRegistrationBlockedBlock();
    }
    
    /*******************************************************************
    // * Description: Test Order Checkout Blocking Rules 
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 4)
    public void orderCheckoutBlocking()throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       Q_JMB_GuestCheckout.guestBankwire();
       driver.navigate().to(baseUrl);
       Q_JMB_GuestCheckout.guestBankwire();
       driver.navigate().to(baseUrl);
       chk.selectItem("100 oz Geiger Security", 3);
       chk.selectItem("1 oz US Quarter Copper", 10);
       cart.selectPaymentType("wire");
       cart.selectcheckoutBtn("top");
       chk.bridgeGuest();
       chk.guestEmail("qaguesttest@jmbullion.com");
       chk.shippingAddressForm(6);
       chk.saveShippingAddress();
       chk.creditCardForm(2);
       chk.completeOrder();
       Q_JMB_WebElm.myWait(3000);
       chk.validateErrorrMsgContains("Too many checkout attempts. Please try again later.");
    }
    
    /*******************************************************************
    // * Description: Test Add Credit Card Blocking Rules 
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 5)
    public void addCreditCardBlocking()throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       acc.loginUser(50);
       acc.myAccount("payments");
       acc.deviceFingerprintAddCreditCard(0);
       Q_JMB_WebElm.myWait(3000);
       Assert.assertFalse(Q_JMB_Controls.checkAndGetAlertText().equals("Too many attempts adding a credit card. Please try again later."), 
    		   "1st Credit Card was not added successfully.");
       Q_JMB_Controls.checkAlert();
       driver.navigate().to(baseUrl);
       acc.myAccount("payments");
       acc.deviceFingerprintAddCreditCard(1);
       Q_JMB_WebElm.myWait(3000);
       Assert.assertFalse(Q_JMB_Controls.checkAndGetAlertText().equals("Too many attempts adding a credit card. Please try again later."), 
    		   "2nd Credit Card was not added successfully.");
       Q_JMB_Controls.checkAlert();
       driver.navigate().to(baseUrl);
       acc.myAccount("payments");
       acc.deviceFingerprintAddCreditCard(2);
       Q_JMB_WebElm.myWait(3000);
       Assert.assertTrue(Q_JMB_Controls.checkAndGetAlertText().equals("Too many attempts adding a credit card. Please try again later."), 
    		   "1st Credit Card was not added successfully.");
       
       Q_JMB_Controls.checkAlert();
       driver.navigate().to(baseUrl);
       acc.myAccount("payments");
       acc.deviceFingerprintDeleteCreditCard();
       driver.navigate().to(baseUrl);
       acc.myAccount("payments");
       acc.deviceFingerprintDeleteCreditCard();
    }
    
    /*******************************************************************
    // * Description: Test Contact Us Blocking Rules 
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 6, enabled=true)
    public void contactUsBlocking()throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       Q_JMB_WebElm.myWait(3000);
       nav.deviceFingerprintContactUs();
       driver.navigate().to(baseUrl);
       nav.deviceFingerprintContactUs();
       driver.navigate().to(baseUrl);
       nav.deviceFingerprintContactUsBlock();
    }
    
    /*******************************************************************
    // * Description: Test Forgot Password Blocking Rules 
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 7)
    public void forgotPasswordBlocking() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.forgetPassword("qa1auto@jmbullion.com");
        driver.navigate().to(baseUrl);
        acc.forgetPassword("qa1auto@jmbullion.com");
        driver.navigate().to(baseUrl);
        acc.forgetPasswordBlock("qa1auto@jmbullion.com");
    }
    
    /*******************************************************************
    // * Description: Test Customer Fraud Blocking Rules 
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 8)
    public void customerFraudBlocking()throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       acc.loginUser(51);
       chk.selectItem("1994 1 oz American Silver Eagle Coin", 5);
       cart.selectPaymentType("cheque");
       cart.selectcheckoutBtn("top");
       chk.completeOrder();
       chk.thankYouPage();
       acc.logoutUser();
       
       // Flag customer as fraud
       Q_JMB_Controls.adminLogin();
       adm.adminCustomerSearch("email", "qa+dfpcustomerfraud@jmbulllion.com");
       adm.adminViewAllOrders();
       adm.toggleCustomerFraud("Yes");
       driver.navigate().to(baseUrl);
       acc.logoutUser();
       driver.navigate().to(baseUrl);
       
       // Create order with guest user and try to go to checkout
       chk.selectItem("100 oz Geiger Security", 3);
       chk.selectItem("1 oz US Quarter Copper", 10);
       cart.selectPaymentType("wire");
       cart.selectcheckoutBtn("top");
       chk.bridgeGuest();
       Q_JMB_WebElm.myWait(3000);
       chk.validateErrorrMsgContains("Limited Access - Your activities on our website may be in violation of our Terms & Conditions.");
       
       // Try to add a new CC to user
       driver.navigate().to(baseUrl);
       Q_JMB_WebElm.myWait(3000);
       //acc.logoutUser();
       //driver.navigate().to(baseUrl);
       //Q_JMB_WebElm.myWait(3000);
       acc.loginUser(50);
       driver.navigate().to(baseUrl);
       acc.myAccount("payments");
       acc.deviceFingerprintAddCreditCard(2);
       Q_JMB_WebElm.myWait(1000);
       Assert.assertTrue(Q_JMB_Controls.checkAndGetAlertText().equals("Too many attempts adding a credit card. Please try again later."), 
    		   "1st Credit Card was not added successfully.");
       Q_JMB_Controls.checkAlert();
       acc.logoutUser();
       
       // Remove Fraud from User
       driver.navigate().to(adminUrl);
       Q_JMB_Controls.adminLogin();
       adm.adminCustomerSearch("email", "qa+dfpcustomerfraud@jmbulllion.com");
       adm.adminViewAllOrders();
       adm.toggleCustomerFraud("No");
    }
    
    /*******************************************************************
    // * Description: Test Account Registration successful after Blocking time expires
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 9)
    public void accountRegistrationPostBlockingTime()throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       Q_JMB_WebElm.myWait(3000);
       acc.deviceFingerprintAccountRegistration(regEmail3);
       acc.deleteUser();
    }
    
    /*******************************************************************
    // * Description: Test Add Credit Card successful after Blocking time expires
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 10)
    public void addCreditCardPostBlockingTime()throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       acc.loginUser(50);
       acc.myAccount("payments");
       acc.deviceFingerprintAddCreditCard(2);
       Q_JMB_WebElm.myWait(2000);
       Assert.assertFalse(Q_JMB_Controls.checkAndGetAlertText().equals("Too many attempts adding a credit card. Please try again later."), 
    		   "1st Credit Card was not added successfully.");
       driver.navigate().to(baseUrl);
       acc.myAccount("payments");
       acc.deviceFingerprintDeleteCreditCard();
    }
    
    /*******************************************************************
    // * Description: Test Contact Us successful after Blocking time expires
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 11, enabled=true)
    public void contactUsPostBlockingTime()throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       Q_JMB_WebElm.myWait(3000);
       nav.deviceFingerprintContactUs();
    }
    
    /*******************************************************************
    // * Description: Test Register Login Blocking Rules 
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 12)
    public void registerLoginPostBlockingTime()throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       acc.loginUser(50);
       acc.logoutUser();
    }
    
    /*******************************************************************
    // * Description: Test Order Checkout successful after Blocking time expires
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 13)
    public void orderCheckoutPostBlockingTime()throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       Q_JMB_GuestCheckout.guestBankwire();
    }
    
    /*******************************************************************
    // * Description: Test Forgot Password Blocking Rules 
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 14)
    public void forgotPasswordPostBlockingTime() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.forgetPassword("qa1auto@jmbullion.com");
    }
    
    /*******************************************************************
    // * Description: Resets device fingerprint settings and cleans out register user for next run
    // * Author: Paul Patterson
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 15)
    public void deviceFingerPrintCleanup()throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       
       // Remove Fraud from User
       Q_JMB_Controls.adminLogin();
       adm.adminCustomerSearch("email", "qa+dfpcustomerfraud@jmbulllion.com");
       adm.adminViewAllOrders();
       adm.toggleCustomerFraud("No");
       
       // Turn back on IP Whitelist
       driver.navigate().to(adminUrl + "/blocking-rules.php");
       adm.toggleIPWhitelistBlockingRules(true);
       adm.toggleUpdateBlockingRuleChanges();
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
