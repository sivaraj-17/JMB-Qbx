package testcases.cart;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Q_Slv_AccountSteps;
import pageObjects.Q_Slv_CartSteps;
import pageObjects.Q_Slv_WebElm;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.io.FileNotFoundException;

import static pageObjects.Q_Slv_CartSteps.*;

public class Q_Slv_QcCheckoutRules extends Q_Slv_Init {

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
     // * Description: Qualified customer order between $2000 and $5000 all payment methods are available
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 1)
    public void allMethodsAvailable() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
        gold3("2");
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PP.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.EC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BC.id"));
        System.out.println("Available payment:\n PayPal \n Credit Card\n Bank wire \n Paper Check\n Echeck\n Bitcoin\n");

    }
    /*******************************************************************
     // * Description: Qualified customer bank wire and bitcoin minimum not met
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2)
    public void qcBwMinReiquired() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
        gold2("1");
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PP.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.CC.id"));
        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.EC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BC.id"));
        System.out.println("Available payment:\n PayPal \n Credit Card\n Paper Check\n Echeck\n Bitcoin\n");

    }
    /*******************************************************************
     // * Description: Qualified customer order between 25000 and $250000 PayPal, Bank wire and Paper Check payment methods are available
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3)
    public void allExceptCreditCard() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
        gold4("2");
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PP.id"));
        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.EC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BC.id"));
        System.out.println("Available payment:\n PayPal \n Bank wire \n Paper Check\n  ");

    }
    /*******************************************************************
    // * Description: Qualified customer bank wire, Paper check, ACH,  and bitcoin minimum not met
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 4)
    public void qcBwPcAchBconly() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
//        gold1("1");
        gold4("4");
        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PP.id"));
        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.EC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BC.id"));
        System.out.println("Available payment methods :\n PayPal \n Credit Card\n Paper Check\n Echeck\n");
        
    }

    /*******************************************************************
     // * Description: Qualified customer order between $60000 and $250000 only Bank wire  payment methods is available
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5)
    public void BwBCOnlyAvailable() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
        gold4("6");
        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PP.id"));
        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BW.id"));
        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PC.id"));
        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.EC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BC.id"));
        System.out.println("Available payment:\n Bank wire \n");

    }


    /*******************************************************************
    // * Description: Qualified customer with orders over $250000 must call customer service
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 6)
    public void callCustomerService() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
        gold4("13");
        Assert.assertTrue(Q_Slv_WebElm.cnDisplayed(SLVqProp, "cart.maxError.wooCommerceError.className"));
        Assert.assertEquals(Q_Slv_WebElm.cnRetText(SLVqProp, "cart.maxError.wooCommerceError.className"), "For orders over $150,000.00, please call us at 1-888-989-7223 and we will be glad to assist you.");
        System.out.println("Error message :" + Q_Slv_WebElm.cnRetText(SLVqProp, "cart.maxError.wooCommerceError.className"));
        
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
