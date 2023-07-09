package testcases.cart;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;


public class Q_JMB_CheckoutRules extends Q_JMB_Init {
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
    // * Description: Verify maximum quantity of 9999 can be ordered if the product is available
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1)
    public static void maxCartQuantity (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.copperUSQuarter("9999");
        cart.selectPaymentType("cheque");
        System.out.println(Q_JMB_WebElm.idDisplayed(jmbProps, "cart.paymentType.BW.id"));
        try{
            Q_JMB_WebElm.idDisplayed(jmbProps, "cart.paymentType.BW.id");
            System.out.println("Maximum allowed quantity 9999");
        }
        catch(Throwable ex){
            Assert.fail("Failed maximum allowed quantity");
        }
        
    }

    /*******************************************************************
    // * Description:Verify bank wire payment method is not available for orders less than $2500.00
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 2)
    public void bwMinRequired (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.perthMintGoldBar("1");
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PP.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.EC.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BC.id"));
        cart.selectPaymentType("cheque");
        
    }
    /*******************************************************************
    // * Description: Verify credit card payment method is not available for orders over $5000.00
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 3)
    public void allButCreditCardPP (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.silverGeigerSecurity( "12");
        Q_JMB_WebElm.myWait(2000);
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PP.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.EC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BC.id"));
        cart.selectPaymentType("cheque");
        
    }
    /*******************************************************************
    // * Description: Verify all payment methods are available for orders between $2500.00 and & $5000.00
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 4)
    public void allMetodsAvailable (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.goldEagle("12");
        Q_JMB_WebElm.myWait(2000);
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PP.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.EC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BC.id"));
        cart.selectPaymentType("wire");
        
    }
    /*******************************************************************
    // * Description: Verify when order total is above $100,000,00 bank wire is the only available payment
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 5)
    public void bitCoinBankwireOnly (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        //gold4("10");
        Q_JMB_CategoryObjects.goldBar10oz("5");
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PP.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.CC.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.EC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BW.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BC.id"));
        cart.selectPaymentType("wire");
        
    }
    /*******************************************************************
    // * Description: Verify orders between $10k and $25K will not have PayPal or credit card payment type
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 6)
    public void noCreditOrPaypal (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.goldBar10oz("3");
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PP.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.CC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.EC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BW.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BC.id"));
        cart.selectPaymentType("wire");
        
    }
    /*******************************************************************
    // * Description: Verify orders between $50k and $100K will have bank wire and bitcoin as the only available options
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 7, enabled = false)
    public void bankwireOnly (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.goldBar10oz("6");
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PP.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.CC.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.EC.id"));
        Assert.assertTrue(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BW.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.PC.id"));
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BC.id"));
        cart.selectPaymentType("wire");
        
    }
    /*******************************************************************
    // * Description: Verify customer must call in any orders over $150k and a message is displayed
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 8)
    public void callCustomerService (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.goldBar10oz("15");
        Assert.assertTrue(Q_JMB_WebElm.cnDisplayed(jmbProps, "cart.woocommerce.error.className"));
        driver.navigate().back();
        Q_JMB_WebElm.myWait(2000);
        Q_JMB_CartPageObjects.removeItems();
        
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
