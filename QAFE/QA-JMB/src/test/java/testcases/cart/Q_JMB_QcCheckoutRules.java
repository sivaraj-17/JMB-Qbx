package testcases.cart;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;

import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;


public class Q_JMB_QcCheckoutRules extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();

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
    // * Description: Verify limited quantity of 9997 can not be exceeded and alert message is displayed
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1)
    public static void limitedCartQuantity (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        Q_JMB_CategoryObjects.copperWalkingLiberty("9998");
        Q_JMB_WebElm.myWait(2000);
        Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "cart.notEnoughStock.xp"));
        Q_JMB_WebElm.xp(jmbProps, "cart.modal.CheckoutNow.xp");
    }
    /*******************************************************************
    // * Description: Verify bank wire payment method is not available for orders less than $2500.00
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 2)
    public void qcBwMinRequired(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        Q_JMB_CategoryObjects.perthMintGoldBar( "1");
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PP.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.EC.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BC.id"));
        cart.selectPaymentType("cheque");

    }

    /*******************************************************************
    // * Description: Verify when the order total is between $2500.00 and $25K all payment options will be available for qualified customers
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 3)
    public static void allMetodsAvailable(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        Q_JMB_CategoryObjects.goldEagle("3");
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PP.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.EC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BC.id"));
        cart.selectPaymentType("cheque");

    }
    /*******************************************************************
    // * Description: Verify orders above $60K will only have bank wire and bitcoin as the only available payment options
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 4)
    public static void qcBankwireAndBitcoin(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        Q_JMB_CategoryObjects.goldBar10oz("10");
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PP.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.CC.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PC.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.EC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BC.id"));
        cart.selectPaymentType("wire");

    }
    /*******************************************************************
    // * Description: Verify when order total exceeds $25K credit card and echeck will not be included in the payment options.
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 5)
    public static void noCreditCard(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        Q_JMB_CategoryObjects.goldEagle( "27");
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PP.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.EC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BC.id"));
        cart.selectPaymentType("wire");

    }
    /*******************************************************************
    // * Description: Verify orders above $50K and less than $60K will have PayPalTestCase, bitcoin and bank wire as the only available payment options
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 6)
    public static void noCreditCardOrPayPal(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        Q_JMB_CategoryObjects.goldEagle("3");
        Q_JMB_CategoryObjects.goldBar10oz("3");
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PP.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.EC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BC.id"));
        cart.selectPaymentType("wire");

    }
    /*******************************************************************
    // * Description: Verify orders between $60K and $250K will have bitcoin and bank wire as the only available payment options
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 7)
    public static void bitCoinAndBankwireOnly(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        Q_JMB_CategoryObjects.goldBar10oz("11");
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PP.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.CC.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PC.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.EC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BC.id"));
        cart.selectPaymentType("wire");

    }
    /*******************************************************************
    // * Description: Verify qc customer with orders over $250k must call customer service and a message is displayed
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 8)
    public void callCustomerService (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        Q_JMB_CategoryObjects.goldBar10oz("32");

        Assert.assertTrue(Q_JMB_WebElm.cnDisplayed(jmbProps, "cart.woocommerce.error.className"));
        driver.navigate().back();
        Q_JMB_CartPageObjects.removeItems();

    }
    @AfterTest
    public void endReport(){
    }
    @AfterMethod
    public void tearDown() throws Exception {
        Q_JMB_CartPageObjects.removeItems();
        acc.logoutUser();
        Q_JMB_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
