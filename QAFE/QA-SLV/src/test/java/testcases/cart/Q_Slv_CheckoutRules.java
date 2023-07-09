package testcases.cart;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Q_Slv_CartSteps;
import pageObjects.Q_Slv_WebElm;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import static pageObjects.Q_Slv_CartSteps.*;

public class Q_Slv_CheckoutRules extends Q_Slv_Init {

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
    // * Description: This test case verifies that the maximum digits allowed in the quantity field is 4 digits
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1)
    public void cartMaximumQuantityAllowed() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.copper1("10203");
        Q_Slv_CartSteps.cartMax();
        
    }
    /*******************************************************************
    // * Description: This test case verifies that the maximum digits allowed in the quantity field is what is provisioned on the product page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2)
    public void cartLimitQuantityAllowed() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);

        Q_Slv_CartSteps.cartLimit("6737");
        
    }
    /*******************************************************************
    // * Description: This test case verifies bank wire is not available since the minimum requirement of $2k has not been met
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3)
    public void bwMinRequired() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        silver1("3");

        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PP.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PC.id"));
        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BC.id"));
        System.out.println("Available payment methods :\n PayPal \n Credit Card\n Paper Check\n Bitcoin\n");
        
    }
    /*******************************************************************
    // * Description: This test case verifies bitcoin is not available since the minimum requirement of $100 has not been met
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 4)
    public void bwbcMinRequired() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        silver1("2");

        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PP.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PC.id"));
        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BC.id"));
        System.out.println("Available payment methods :\n PayPal \n Credit Card\n Paper Check\n ");
        
    }
    /*******************************************************************
    // * Description: Verify credit card payment method is not available for orders over $5000.00
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 5)
    public void allButCreditCard() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        silver2("3");

        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PP.id"));
        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BC.id"));
        System.out.println("Available payment methods :\n PayPal\n Paper Check\n Bank wire \n Bitcoin\n");
        
    }

    /*******************************************************************
    // * Description: This is to verify that when order total is more than $2k and less than $5k all payment types are available
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 6)
    public void allPaymentTypesAvialable() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        gold1("2");
        Q_Slv_WebElm.myWait(3000);
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PP.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BC.id"));
        System.out.println("Available payment methods :\n PayPal \n Credit Card\n Bank wire \n Paper Check\n Bitcoin\n");
        
    }
    /*******************************************************************
    // * Description: Verifying orders over $10K and less than 40k have bank wire an paper check as the only payment options
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 7)
    public void bankWireAndPaperCheck() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        //AccountSteps.login("account.login.link.linkText", 0);
        gold4("2");

        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PP.id"));
        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BC.id"));
        System.out.println("Available payment methods :\n Bank wire \n Paper Check\n ");
        
    }
    /*******************************************************************
    // * Description: This is to verify order over $40K offer bank wire as the only payment option
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 8)
    public void bankWireOnlyAvailable() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        //AccountSteps.login("account.login.link.linkText", 0);
        gold4("6");

        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PP.id"));
        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BW.id"));
        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.PC.id"));
        Assert.assertFalse(Q_Slv_WebElm.idEnabled(SLVqProp, "cart.paymentType.BC.id"));
        System.out.println("Available payment methods :\n Bank wire \n");
        
    }
    /*******************************************************************
    // * Description: All orders over $150K require customer service assistance
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 9)
    public void callCustomerService() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        //AccountSteps.login("account.login.link.linkText", 0);
        gold4("13");

        Assert.assertTrue(Q_Slv_WebElm.cnDisplayed(SLVqProp, "cart.maxError.wooCommerceError.className"));
        Assert.assertEquals(Q_Slv_WebElm.cnRetText(SLVqProp, "cart.maxError.wooCommerceError.className"), "For orders over $150,000.00, please call us at 1-888-989-7223 and we will be glad to assist you.");
        System.out.println("Error message :" + Q_Slv_WebElm.cnRetText(SLVqProp, "cart.maxError.wooCommerceError.className"));
        
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
