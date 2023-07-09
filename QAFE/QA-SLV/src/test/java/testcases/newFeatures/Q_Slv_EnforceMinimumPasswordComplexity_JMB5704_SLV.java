package testcases.newFeatures;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.*;
import pageObjects.Q_Slv_AccountSteps;
import pageObjects.Q_Slv_CartSteps;
import pageObjects.Q_Slv_CheckoutSteps;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

public class Q_Slv_EnforceMinimumPasswordComplexity_JMB5704_SLV extends Q_Slv_Init {
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
     * Description: Check password validation for new user with invalid inputs 
     * Author:
     * Status: Complete
	 * Ticket : JMB-5704 - (Enforce minimum password complexity during registration and password reset)
     ********************************************************************/
    @Test(priority =1)
    public static void registerNewUserWithInvalidPassword() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
    	for(int i=0;i<=13;i++) {
    		Q_Slv_AccountSteps.userRegistrationInvalidPassword(i);
		}
		
    }
    /*******************************************************************
     * Description: Check password validation for guest user registration with invalid inputs
     * Author:
     * Status: Complete
     * Ticket : JMB-5704 - (Enforce minimum password complexity during registration and password reset)
     ********************************************************************/
    @Test(priority =2)
    public static void registerGuestUserWithInvalidPassword() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		Q_Slv_CartSteps.silver1("1");
		Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
		Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", System.currentTimeMillis()+"@jmbullion.com");
		Q_Slv_CheckoutSteps.creditCardInput(1);
		Q_Slv_CheckoutSteps.shippingAutoAddress(1);
		Q_Slv_CheckoutSteps.completeOrder("chk.finishAndPlace.id");
		for(int i=0;i<=13;i++)
		{
			Q_Slv_AccountSteps.createAccountInvalidPasswordInput(i);
		}
    }
    /*******************************************************************
     * Description: Check password validation for change password with invalid inputs
     * Author:
     * Status: Complete
     * Ticket : JMB-5704 - (Enforce minimum password complexity during registration and password reset)
     ********************************************************************/
    @Test(priority =3)
    public static void changePasswordWithInvalidInput() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		Q_Slv_AccountSteps.login("acc.login.link.xp",22);
		for(int i = 0; i<=13; i++)
		{
			Q_Slv_AccountSteps.changePasswordInvalidInput(i);
		}
		
    }
    /*******************************************************************
     * Description: Check password validation for change password with valid inputs
     * Author:
     * Status: Complete
     * Ticket : JMB-5704 - (Enforce minimum password complexity during registration and password reset)
     ********************************************************************/
    @Test(priority =5)
    public static void changePasswordWithvalidInput() throws IOException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		Q_Slv_AccountSteps.login("acc.login.link.xp",45);
		Q_Slv_AccountSteps.resetPassvalidInputs(45);
		Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     * Description: Check password validation for guest user registration with valid input
     * Author:
     * Status: Complete
     * Ticket : JMB-5704 - (Enforce minimum password complexity during registration and password reset)
     ********************************************************************/
    @Test(priority =6)
    public static void registerGuestUserWithvalidInput() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		Q_Slv_CartSteps.silver1("1");
		Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
		Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", System.currentTimeMillis()+"@jmbullion.com");
		Q_Slv_CheckoutSteps.creditCardInput(1);
		Q_Slv_CheckoutSteps.shippingAutoAddress(1);
		Q_Slv_CheckoutSteps.completeOrder("chk.finishAndPlace.id");
		Q_Slv_AccountSteps.createAccount(14);
		Q_Slv_AccountSteps.deleteUser();
    }
    
	@AfterMethod
	public void tearDown() throws Exception {
		Q_Slv_CartSteps.emptyCart();
		Q_Slv_Controls.tearDown();
	}
	@AfterClass
	public void exitClass(){
	}
}
