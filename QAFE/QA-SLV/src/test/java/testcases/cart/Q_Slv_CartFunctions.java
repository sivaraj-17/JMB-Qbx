package testcases.cart;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.io.FileNotFoundException;

import static pageObjects.Q_Slv_CartSteps.*;


public class Q_Slv_CartFunctions extends Q_Slv_Init {

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
    // * Description: Verify user can add different product types with different quantities and verify cart content
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1)
    public void verifyCart (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        gold1("3");
        gold2("2");
        gold3("2");
        silver1("3");
        silver2("1");
        silver3("2");
        platinum1("2");
        platinum2("1");
        platinum3("1");
        copper1("10");
//        verifyCartContent();


    }
    /*******************************************************************
    // * Description: Verify user can edit cart content prior to checking out
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2)
    public void editCart (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        gold1("3");
        gold2("2");
        gold3("2");
        silver1("3");
        silver2("1");
        Q_Slv_CartSteps.editCart();


    }
    /*******************************************************************
    // * Description: User can return from checkout page to cart and modify cart content
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3)
    public void modifyCart () throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
        gold1("3");
        gold2("2");
        gold3("2");
        silver1("3");
        silver2("1");
        Q_Slv_WebElm.id(SLVqProp, "cart.paymentType.PC.id");
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_WebElm.xp(SLVqProp, "cart.proceedToChk.btn.xp");
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_WebElm.xp(SLVqProp, "chk.guest.reviewOrder.modify.xp");
        Q_Slv_CartSteps.editCart();
        Q_Slv_CartSteps.emptyCart();
        Q_Slv_AccountSteps.logout();

    }
    /*******************************************************************
     * Description: Verifies Cart Language for Paper Check
     * Author:
     * Status: Complete
     // * Jira Ticket: JMB-6231/ JMB-6386
     ********************************************************************/
    @Test(priority=4)
    public static void verifyUpdatedCartLanguagePaperCheck()throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
    	Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
		Q_Slv_CartSteps.gold3("1");
		Q_Slv_CartSteps.paperCheckCartLanguage();
    }

    /*******************************************************************
     * Description: Verifies Cart Language for ACH
     * Author:
     * Status: Complete
     // * Jira Ticket: JMB-6231/ JMB-6386
     ********************************************************************/
    @Test(priority=5)
    public static void verifyUpdatedCartLanguageACH()throws Exception {
    	String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
    	Q_Slv_Controls.testStarted(tcName);
		Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
		Q_Slv_CartSteps.gold3("3");
		Q_Slv_CartSteps.achCartLanguage();
    }

    /*******************************************************************
     * Description: Verifies Cart Language for Bank Wire
     * Author:
     * Status: Complete
     // * Jira Ticket: JMB-6231/ JMB-6386
     ********************************************************************/
    @Test(priority=6)
    public static void verifyUpdatedCartLanguageBankWire()throws Exception {
	 	String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
	 	Q_Slv_Controls.testStarted(tcName);
		Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
		Q_Slv_CartSteps.gold3("14");
		Q_Slv_CartSteps.wireCartLanguage();
    }

    /*******************************************************************
     * Description: This test case verifies if ordered via category page exceeds set limit.
     * Error message will appear in the modal indicating available quantity can be ordered.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 7, enabled = true)
    public void slv_cartLimit_Verification001(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_Controls.adminLogin();
        int prelimit =  Q_Slv_AdminSlvSteps.limitCount("63");
        System.out.println("Limit " + prelimit);
        Q_Slv_CartSteps.categoryProduct("cart.metal.gold.xp", "cart.gold.americanGoldEagle.xp","cart.gold.sub.goldEagleBU.xp", "cart.category.qty.beg.xp",2, "cart.category.qty.end.xp", String.valueOf(prelimit+1));
        String alertText = Q_Slv_Controls.checkAndGetAlertText();
        System.out.println(alertText);
        Assert.assertTrue(alertText.contains("we only have "+ prelimit + " of our"));
    }

    /*******************************************************************
     * Description: This test case verifies if ordered via category below set limit,
     * The product page will deduct amount ordered from preorder set limit.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 8, enabled = true)
    public void slv_cartLimit_Verification002(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_Controls.adminLogin();
        int prelimit =  Q_Slv_AdminSlvSteps.limitCount("63");
        System.out.println("Limit " + prelimit);
        Q_Slv_CartSteps.categoryProduct("cart.metal.gold.xp", "cart.gold.americanGoldEagle.xp","cart.gold.sub.goldEagleBU.xp", "cart.category.qty.beg.xp",2, "cart.category.qty.end.xp", String.valueOf(prelimit-1));
        int cartQty = Integer.valueOf(Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.modalQuantity.xp","value"));
        System.out.println(cartQty);
        Assert.assertEquals(cartQty, (prelimit-1) );
    }

    /*******************************************************************
     * Description: This test case verifies if ordered via category equals set limit,
     * The product page will adjusted limit set to 0 set.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 9, enabled = true)
    public void slv_cartLimit_Verification003(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_Controls.adminLogin();
        int prelimit =  Q_Slv_AdminSlvSteps.limitCount("63");
        System.out.println("Limit " + prelimit);
        Q_Slv_CartSteps.categoryProduct("cart.metal.gold.xp", "cart.gold.americanGoldEagle.xp","cart.gold.sub.goldEagleBU.xp", "cart.category.qty.beg.xp",2, "cart.category.qty.end.xp", String.valueOf(6));
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.BW.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_AccountSteps.logout();
        Q_Slv_WebElm.myWait(2000);
        int finalLimit =  Q_Slv_AdminSlvSteps.limitCount("63");
        System.out.println("Final product limit " + finalLimit);
        Assert.assertEquals((prelimit - finalLimit) , 6 );
    }

    /*******************************************************************
     * Description: This test case verifies if ordered via product page exceeds set limit,
     * Error message will appear in the modal indicating available quantity can be ordered.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 10, enabled = true)
    public void slv_cartLimit_Verification004(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_Controls.adminLogin();
        int prelimit =  Q_Slv_AdminSlvSteps.limitCount("63");
        System.out.println("Limit " + prelimit);
        Q_Slv_CartSteps.addPdpProduct("/1-4-oz-gold-american-eagles/", String.valueOf(prelimit + 1));
        String alertText = Q_Slv_Controls.checkAndGetAlertText();
        System.out.println(alertText);
        Assert.assertTrue(alertText.contains("we only have "+ prelimit + " of our"));
    }

    /*******************************************************************
     * Description: This test case verifies if ordered via product page equals set limit,
     * The product page will adjusted limit set to 0 set.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 11, enabled = true)
    public void slv_cartLimit_Verification005(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_Controls.adminLogin();
        int prelimit =  Q_Slv_AdminSlvSteps.limitCount("63");
        System.out.println("Limit " + prelimit);
        Q_Slv_CartSteps.addPdpProduct("/1-4-oz-gold-american-eagles/", String.valueOf(prelimit - 1));
        int cartQty = Integer.valueOf(Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.modalQuantity.xp","value"));
        System.out.println(cartQty);
        Assert.assertEquals(cartQty, (prelimit-1) );

    }
    /*******************************************************************
     * Description: This test case verifies if ordered below set limit add to cart, In cart page attempt to increase
     * quantity beyond set limtt. Error message will appear in the modal indicating available quantity can be ordered.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 12, enabled = true)
    public void slv_cartLimit_Verification006(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_Controls.adminLogin();
        int prelimit =  Q_Slv_AdminSlvSteps.limitCount("63");
        System.out.println("Limit " + prelimit);
        Q_Slv_CartSteps.addPdpProduct("/1-4-oz-gold-american-eagles/", "3");
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.qty.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.qty.xp",String.valueOf(prelimit + 1));
        Q_Slv_WebElm.xp(SLVqProp, "cart.update.xp");
        String errorText = Q_Slv_WebElm.xpRetText(SLVqProp, "cart.woocommerceError.xp");
        System.out.println(errorText);
        Assert.assertTrue(errorText.contains("we only have "+ prelimit + " of our"));

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


