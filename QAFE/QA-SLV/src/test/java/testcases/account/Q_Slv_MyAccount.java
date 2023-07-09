package testcases.account;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Q_Slv_AccountSteps;
import pageObjects.Q_Slv_CartSteps;
import pageObjects.Q_Slv_CheckoutSteps;
import pageObjects.Q_Slv_WebElm;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.io.FileNotFoundException;


public class Q_Slv_MyAccount extends Q_Slv_Init {
	private Q_Slv_AccountSteps acc = new Q_Slv_AccountSteps();
	
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
    // * Description:Register new user
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =1)
    public static void registerNewUser() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        //CartSteps.linkTextElement(acctProps,"account.register.link.linkText");

        Q_Slv_AccountSteps.registerNow("acc.register.link.linkText",4, "acc.register.reg.btn.id");
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_AccountSteps.deleteUser();

        
    }
    /*******************************************************************
    // * Description: Register Guest user
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =2)
    public static void registerGuestUser() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.copper2("50");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "qa5auto@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(1);
        Q_Slv_CheckoutSteps.shippingAutoAddress(1);


        Q_Slv_CheckoutSteps.completeOrder("chk.finishAndPlace.id");
        Q_Slv_AccountSteps.createAccount();
        Q_Slv_AccountSteps.deleteUser();
        
    }
    /*******************************************************************
    // * Description: List customer credit card on file
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =3)
    public static void savedCreditCardList() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp",0);
        Assert.assertTrue(Q_Slv_AccountSteps.payment().contains("Ending in: 0056"));
        Assert.assertTrue(Q_Slv_AccountSteps.payment().contains("Ending in: 0002"));
        
    }
    /*******************************************************************
    // * Description: List customer Shipping addresses
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =4)
    public static void savedShippinAddress() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp",9);
        Assert.assertTrue(Q_Slv_AccountSteps.accountAddress().contains("4102 Honeysuckle Dr"));
        Assert.assertTrue(Q_Slv_AccountSteps.accountAddress().contains("4108 Honeysuckle Dr"));
        
    }
    /*******************************************************************
    // * Description: Verify user can edit shipping address
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =5)
    public static void editAccountPageShipAddress() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp",3);
        System.out.println(" Starting address " + Q_Slv_AccountSteps.accountAddress());
        System.out.println(" Starting address " + Q_Slv_AccountSteps.accountAddress().substring(26, 41));
        Q_Slv_AccountSteps.editShippingAdd();
        
    }
    /*******************************************************************
    // * Description: Verify customer can add and delete shipping address in the account page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =6)
    public static void addDeleteShippinAddress() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp",10);
        Q_Slv_AccountSteps.addShippingAddress("acc.ship.create.add.id");
        Q_Slv_AccountSteps.deleteShippingAddress();
        
    }
    
    /*****************************************************************************************
	 * Description: To click on add address second time to open Address form again 
	 * Author: Karthick D
 	 * Status: Completed   
	 * Ticket: JMB-8170
     * @throws Exception 
     *****************************************************************************************/
    @Test (priority=7, enabled=true)
 	public void ClickOnAddShippingAddressSecondTimeToOpenAddressFormAgain() throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_Slv_Controls.testStarted(tcName);
       Q_Slv_AccountSteps.login("acc.login.link.xp",19);
       acc.clickAddShippingAddressSecondTime();   
    }
    
    /********************************************************************
	// * Description  : To verify we donot allow customer to change email address online
	// * Author       : Vignesh
	// * Jira Ticket  : JMB-6606
	// * Status       : Complete
	//********************************************************************/
   @Test(priority = 8, enabled = true)
   public void verifyHowToChangeEmailAddressMyAccountPage() throws Exception {
	   String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
	   Q_Slv_Controls.testStarted(tcName);
	   Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
	   driver.navigate().to(baseUrl+"/my-account/");
	   acc.validateCannotChangeEmailAddressMessage();
   }
    @AfterMethod
    public void tearDown() throws Exception {
        Q_Slv_CartSteps.emptyCart();
        Q_Slv_AccountSteps.logout();
        Q_Slv_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}

