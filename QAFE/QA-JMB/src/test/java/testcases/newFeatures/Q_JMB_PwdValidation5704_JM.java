package testcases.newFeatures;
//JMB-5704(Enforce minimum password complexity during registration and password reset)
import org.testng.annotations.*;

//import steps.AccountSteps;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.io.FileNotFoundException;
public class Q_JMB_PwdValidation5704_JM extends Q_JMB_Init {
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
    // * Description: Check password validation for new user with invalid inputs via Create Account Modal
    // * Author:
    // * Status: Complete
    //*******************************************************************/

    @Test(priority = 15)
    public static void newUserInvalidPasswordValidation() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        //        AccountSteps.invalidPasswordInputs("jm.createAccount.id","Madhu","Jayasimha","(523) 452-3452","@jmbullion.com",password,confPassword, "jm.createRegBtn.id");
        for(int i =0;i<=13;i++)
        {
            acc.invalidPasswordInputs(i);
        }
    }
    /*******************************************************************
    // * Description: Check password validation for new user with invalid inputs via Register Page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 16)
    public static void newUserInvalidPasswordValidationViaRegisterPage() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
                for(int i =0;i<=13;i++)
        {
            acc.invalidPasswordInputsRegisterPage(i);

        }
    }
    /*******************************************************************
    // * Description: Check password validation for guest user registration with invalid inputs
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 17)
    public static void registerGuestUserInvalidPasswordValidation() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.perthMintGoldBar("1");

        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("top");
        chk.bridgeGuest();
        chk.guestEmail(System.currentTimeMillis()+"Acc@jmbullion.com");

        chk.shippingAddressForm(2);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.completeOrder();
        chk.thankYouPage();
        for(int i =0;i<=13;i++)
        {
            acc.checkoutRegistrationInvalidPassword(i);
        }
    }
    /*******************************************************************
    // * Description: Check password validation for change password with invalid inputs
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 18)
    public static void changePasswdWithInvalidInputs() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(36);
        acc.myAccount("my information");
        acc.myInfo("change password");
        for(int i =0;i<=13;i++)
        {
            acc.changePassInvalidInputs(i);
        }
    }
    /*******************************************************************
     // * Description: Check password validation for new user with valid input via Register Page
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 20)
    public static void newUserValidPasswordValidationViaRegisterPage() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
                acc.validPasswordInputsRegisterPage(14);
        acc.deleteUser();
    }
    /*******************************************************************
    // * Description: Check password validation for change password with valid inputs
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 22)
    public static void changePasswdWithvalidInputs() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(36);
        acc.myAccount("my information");
        acc.myInfo("change password");
        acc.changePassvalidInputs(14,"Jan@2021");
    }


 /****************************** Duplicate test case of MyAccount/ registerNewUser ***********************/
//    /*******************************************************************
//    // * Description: Check password validation for new user with valid input via Create Account
//    // * Author:
//    // * Status: Complete
//    //*******************************************************************/
//    @Test(priority = 19)
//    public static void newUserPasswordValidationWithValidInput() throws FileNotFoundException {
//       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
//        Controls.testStarted(tcName);
////        AccountSteps.validPasswordInputs("jm.createAccount.id","Madhu","Jayasimha","(523) 452-3452","@jmbullion.com",password,confPassword, "jm.createRegBtn.id");
//        AccountSteps.registerNow("jm.createAccount.id",4, "jm.createRegBtn.id");
//
//        Assert.assertTrue(ElemSteps.cnElementDisplayed(acctProps, "jm.welcomeMsg.className"));
//        AccountSteps.deleteUser();
//    }



    /****************************** Duplicate test case of MyAccount/ registerGuestUser***********************/
//    /*******************************************************************
//    // * Description: Check password validation for guest user registration with valid input
//    // * Author:
//    // * Status: Complete
//    //*******************************************************************/
//    @Test(priority = 21)
//    public static void registerGuestUserValidPasswordValidation() throws FileNotFoundException {
//        String tcName = "registerGuestUserValidPasswordValidation";
//        Log.startTestCase("::::::::             " + tcName + "	  ::::::::  " +  Controls.startTimeStriped());
//        Controls.testStarted(tcName);
//        CartSteps.goPerthMintGoldBar("1");
//        CheckoutSteps.guestCheckout("jm.paymentType.CC.id", "jm.cart.botBtnCheckoutNow.xp", "jm.bridgeGuestBtn.xp");
//        CheckoutSteps.guestEmail("jm.guest.email.id", System.currentTimeMillis()+"auto@jmbullion.com");
//
//        CheckoutSteps.shippingForm(2);
////        CheckoutSteps.validateAddress("jm.shipping.validate.id","jm.shipping.ContinueWithAdd.id", "jm.shipping.error.id", "saveaddress");
//        CheckoutSteps.creditForm(2);
////        CheckoutSteps.completeOrder("jm.finishAndPlace.id");
//        CheckoutSteps.completeOrder();
////        AccountSteps.checkoutRegistrationvalidPassword(password,confPassword, "jm.createRegBtn.id");
//        AccountSteps.checkoutRegistration(4, "jm.createRegBtn.id");
//
//        Controls.testPassed(tcName);
//        Log.endTestCase(tcName + "::      Finished execution" + "\t" + Controls.startTimeStriped());
//    }

//
////    @DataProvider
////    public Object[][] getInvalidPassword()
////    {
////    	Object[][] data = new Object[13][2];
////
////    	data[0][0]="12345678";
////    	data[0][1]="12345678";
////
////    	data[1][0]="abcdefgh";
////    	data[1][1]="abcdefgh";
////
////    	data[2][0]="ABCDEFGH";
////    	data[2][1]="ABCDEFGH";
////
////    	data[3][0]="abc123$$$";
////    	data[3][1]="abc123$$$";
////
////    	data[4][0]="ABC123$$$";
////    	data[4][1]="ABC123$$$";
////
////    	data[5][0]="java REGEX 123";
////    	data[5][1]="java REGEX 123";
////
////    	data[6][0]="java REGEX 123 ";
////    	data[6][1]="java REGEX 123 ";
////
////    	data[7][0]="________";
////    	data[7][1]="________";
////
////    	data[8][0]="--------";
////    	data[8][1]="--------";
////
////    	data[9][0]=" ";
////    	data[9][1]=" ";
////
////    	data[10][0]="ABC$$$$$$";
////    	data[10][1]="ABC$$$$$$";
////
////    	data[11][0]="11111111";
////    	data[11][1]="11111111";
////
////    	data[12][0]="java REGEX 123 %";
////    	data[12][1]="java REGEX 123 %";
////
////    	return data;
////
////
////
////    }
////    @DataProvider
////    public Object[][] getvalidPassword()
////    {
////    	Object[][] data = new Object[1][2];
////
////    	data[0][0]="AAAbbbccc@123";
////    	data[0][1]="AAAbbbccc@123";
////
////
////
////    	return data;
////
////
////    }
//
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