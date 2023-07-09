package testcases.newFeatures;

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
import java.io.IOException;

//JMB-5704(Enforce minimum password complexity during registration and password reset)
public class Q_PM_PasswordValidation_JMB5704_PM extends Q_PM_Init {

    @BeforeClass
    public void tcSetup() {
    }

    @BeforeMethod
    public void report() throws Exception {
        Q_PM_Init.setItUp();
    }

    @BeforeTest
    public void setTest() throws Exception {
    }
    /*******************************************************************
     // * Description: Check password validation for new user with invalid inputs via Create Account Modal
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 1)
    public static void registerNewUserInvalidPasswordValidation() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps account = new Q_PM_AccountSteps();
        //        AccountSteps.registerNow("login.id","createAccount.id",4, "create.regBtn.id");
//        AccountSteps.invalidPasswordInputs("login.id","createAccount.id","Madhu","Jayasimha","(523) 452-3452","@gmail.com",password,confPassword, "create.regBtn.id");
        for (int i = 0; i <= 13; i++) {
            account.invalidPasswordInputs(i);
        }
    }

    /*******************************************************************
     // * Description: Check password validation for new user with invalid inputs via Register Page
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2)
    public static void registerNewUserInvalidPasswordValidationViaRegisterPage() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
//        AccountSteps.invalidPasswordInputsViaRegisterPage("login.id","createAccount.id","Madhu","Jayasimha","(523) 452-3452","@gmail.com",password,confPassword, "create.regBtn.id");
        for (int i = 0; i <= 13; i++) {
            Q_PM_AccountSteps.invalidPasswordInputsViaRegisterPage(i);
        }
    }

    /*******************************************************************
     // * Description: Check password validation for guest user registration with invalid inputs
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3)
    public static void regUserCheckoutInvalidPasswordValidation() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.silver_2_2553739("1");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.bridgePage("checkout register", "chk.checkoutNowGuest.xp");
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_WebElm.myWait(2000);
        Q_PM_CheckoutSteps.completeOrder("chk.finishPlaceOrder.id");
        for (int i = 0; i <= 13; i++) {
            Q_PM_AccountSteps.checkoutRegistrationInvalidPasswordValidation(i);
        }
    }

    /*******************************************************************
     // * Description: Check password validation for change password with invalid inputs
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4)
    public static void changePasswdWithInvalidInputs() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(21);
        Q_PM_AccountSteps.accountMenu("DASHBOARD");
        Q_PM_AccountSteps.myAccountMenu("Account Information");
        for (int i = 0; i <= 13; i++) {
            try {
//			AccountSteps.resetPasswordInvalidPasswordInputValidation("AAAbbbccc@123", password, confPassword);
                Q_PM_AccountSteps.resetPasswordInvalidPasswordInputValidation(i);
                Q_PM_WebElm.myWait(1000);
                Q_PM_Controls.testPassed(tcName);
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail();
            }
        }
        Q_PM_AccountSteps.accountMenu("LOGOUT");
    }

    /*******************************************************************
     // * Description: Check password validation for new user with valid input via Create Account
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5)
    public static void registerNewUservalidPasswordValidation() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);;
        Q_PM_AccountSteps.registerNow("acc.login.id", "acc.createAccount.id", 4, "acc.create.regBtn.id");
        Assert.assertTrue(Q_PM_WebElm.cnDisplayed(pmQaProps, "acc.welcomeMsg.className"));
        Q_PM_AccountSteps.deleteUser();
        Assert.assertTrue(Q_PM_WebElm.idDisplayed(pmQaProps, "acc.login.submitBtn.id"));
//        AccountSteps.validPasswordInputs("login.id","createAccount.id","Madhu","Jayasimha","(523) 452-3452","@gmail.com",password,confPassword, "create.regBtn.id");
    }

    /*******************************************************************
     // * Description: Check password validation for new user with valid input via Register Page
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6)
    public static void registerNewUservalidPasswordValidationViaRegisterPage() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.validPasswordInputsViaRegisterPage(14);
        Q_PM_WebElm.myWait(1000);
        Assert.assertTrue(Q_PM_WebElm.cnDisplayed(pmQaProps, "acc.welcomeMsg.className"));
        Q_PM_AccountSteps.deleteUser();
//        AccountSteps.accountMenu("LOGOUT");
    }

    /*******************************************************************
     // * Description: Check password validation for guest user registration with valid input
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7)
    public static void regUserCheckoutvalidPasswordValidation() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.silver_2_2553739("1");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.bridgePage("checkout register", "chk.checkoutNowGuest.xp");
        Q_PM_WebElm.myWait(3000);
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_WebElm.myWait(2000);
        Q_PM_CheckoutSteps.completeOrder("chk.finishPlaceOrder.id");
        Q_PM_WebElm.myWait(2000);
        Q_PM_AccountSteps.checkoutRegistration(4, "acc.create.regBtn.id");
        Q_PM_WebElm.myWait(2000);
        Q_PM_AccountSteps.deleteUser();
//        Assert.assertTrue(ElemSteps.idElementDisplayed(pmQaProps,"login.submitBtn.id"));
        driver.navigate().to(baseUrl);
        Q_PM_CartSteps.verifyCartItems();
        driver.navigate().refresh();

    }

    /*******************************************************************
     // * Description: Check password validation for change password with valid inputs
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8)
    public static void changePasswdWithvalidInputs() throws IOException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(36);
        Q_PM_AccountSteps.accountMenu("DASHBOARD");
        Q_PM_AccountSteps.myAccountMenu("Account Information");
//        try {
        Q_PM_AccountSteps.resetPassvalidInputs(36);
        Q_PM_AccountSteps.accountMenu("LOGOUT");
//		} catch (Exception e) {
//			e.printStackTrace();
//			Assert.fail();
//		}
    }
//    @DataProvider
//    public Object[][] getInvalidPassword()
//    {
//    	Object[][] data = new Object[13][2];
//
//    	data[0][0]="12345678";
//    	data[0][1]="12345678";
//
//    	data[1][0]="abcdefgh";
//    	data[1][1]="abcdefgh";
//
//    	data[2][0]="ABCDEFGH";
//    	data[2][1]="ABCDEFGH";
//
//    	data[3][0]="abc123$$$";
//    	data[3][1]="abc123$$$";
//
//    	data[4][0]="ABC123$$$";
//    	data[4][1]="ABC123$$$";
//
//    	data[5][0]="java REGEX 123";
//    	data[5][1]="java REGEX 123";
//
//    	data[6][0]="java REGEX 123 ";
//    	data[6][1]="java REGEX 123 ";
//
//    	data[7][0]="________";
//    	data[7][1]="________";
//
//    	data[8][0]="--------";
//    	data[8][1]="--------";
//
//    	data[9][0]=" ";
//    	data[9][1]=" ";
//
//    	data[10][0]="ABC$$$$$$";
//    	data[10][1]="ABC$$$$$$";
//
//    	data[11][0]="11111111";
//    	data[11][1]="11111111";
//
//    	data[12][0]="java REGEX 123 %";
//    	data[12][1]="java REGEX 123 %";
//
//    	return data;
//
//
//
//    }
//
//    @DataProvider
//    public Object[][] getvalidPassword()
//    {
//    	Object[][] data = new Object[1][2];
//
//    	data[0][0]="AAAbbbccc@123";
//    	data[0][1]="AAAbbbccc@123";
//
//
//
//    	return data;
//
//
//    }

    @AfterTest
    public void endReport() {
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Q_PM_CartSteps.deleteItems();
//        AccountSteps.accountMenu("LOGOUT");
        Q_PM_Controls.tearDown();
    }

    @AfterClass
    public void exitClass() {
        System.out.println("After Class");
    }
}
