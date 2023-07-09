package testcases.cart;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;


public class Q_PM_CartFunction extends Q_PM_Init {

    @BeforeClass
    public void tcSetup (){

    }
    @BeforeMethod
    public void report() throws Exception {
        Q_PM_Init.setItUp();
    }
    @BeforeTest
    public void setTest() throws Exception {
    }

    /*******************************************************************
    // * Description: Increase Quantity in Modal
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2)
    public static void increaseQtyModal(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_2_2555362("1");
    }
    
    /*******************************************************************
    // * Description: Decrease Quantity in Modal
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 3)
    public static void decreaseQtyModal(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_3_2553276("3");
    }
    
    /*******************************************************************
    // * Description: Add Item From Product Page
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 4)
    public static void pdpAddItem(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.platinum_1_2568821("2");
    }
    
    /*******************************************************************
    // * Description: Increase Quantity in Product Page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 5)
    public static void pdpIncreaseQty(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.platinum_2_2568502("1");
    }
    
    /*******************************************************************
    // * Description: Decrease Quantity in Product Page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 6)
    public static void pdpReduceQty(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.platinum_3_2566983("3");
    }
    
    /*******************************************************************
    // * Description: Add Items and Verify  Cart Content
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 7)
    public static void verifyCart(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_1_2553140("6");
        Q_PM_AddToCart.gold_4_2569050("2");
        Q_PM_AddToCart.silver_1_2553427("6");
        Q_PM_AddToCart.silver_2_2553739("8");
        Q_PM_AddToCart.silver_3_2568377("2");
        Q_PM_AddToCart.platinum_1_2568821("1");
        Q_PM_CartSteps.verifyCartItems();
    }
    
    /*******************************************************************
    // * Description: Add Items to Cart, Edit and Verify Cart Content
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 8)
    public static void editVerifyCart(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_1_2553140("6");
        Q_PM_AddToCart.gold_2_2555362("2");
        Q_PM_AddToCart.silver_1_2553427("1");
        Q_PM_AddToCart.silver_3_2568377("2");
        Q_PM_CartSteps.verifyEditCart();
    }
    
    /*******************************************************************
     // * Description: Verify the paper check checkout verbose on cart page
     // * Author:
     // * Jira Ticket: JMB-6231/ JMB6386
     // * Status: Complete
     //*******************************************************************/
    @Test(priority=9)
    public static void verifyUpdatedCartLanguagePaperCheck()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(29);
        Q_PM_AddToCart.gold_1_2553140("1");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CartSteps.paperCheckCartLanguage();
    }
    
    /*******************************************************************
     // * Description: Verify the ACH/echeck checkout verbose on cart page
     // * Author:
     // * Jira Ticket: JMB-6231/ JMB6386
     // * Status: Complete
     //*******************************************************************/
    @Test(priority=10)
    public static void verifyUpdatedCartLanguageACH()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(29);
        Q_PM_AddToCart.gold_1_2553140("1");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim_echeck");
        Q_PM_CartSteps.achCartLanguage();

    }
    
    /*******************************************************************
     // * Description: Verify the bank wire checkout verbose on cart page
     // * Author:
     // * Jira Ticket: JMB-6231/ JMB6386
     // * Status: Complete
     //*******************************************************************/
    @Test(priority=11)
    public static void verifyUpdatedCartLanguageBankWire()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(29);
        Q_PM_AddToCart.gold_1_2553140("3");
        Q_PM_CheckoutSteps.selectPaymentType("bacs");
        Q_PM_CartSteps.wireCartLanguage();
    }
    
    /*******************************************************************
     * Description: This test case verifies "CONTINUE SHOPPING" button is enabled while going through checkout Page
     * Author:Mobin
     * Status: Complete
     * Ticket : JMB-4831(Add a "Continue Shopping" link/button in the ATC modal)
     */
    @Test(priority=12)
    public void verifyContinueShoppingButton() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_CartSteps.clickATCAndStay("gold");
        Assert.assertTrue(Q_PM_WebElm.idEnabled(pmQaProps, "cart.pm.checkout.ContinueShopping.id"), " Continue Shopping Button is not Available");
        Q_PM_WebElm.id(pmQaProps, "cart.pm.checkout.ContinueShopping.id");
        Q_PM_CartSteps.continueShoppingButton();
    }
    /*******************************************************************
     * Description: Verify pricing sort functionality
     * Author:Mobin
     * Status: Complete
     * Ticket : JMB-5908
     */
    @Test(priority=13)
    public static void sortingCategoryPagesWithPriceListCheck() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_CartSteps cart = new Q_PM_CartSteps();
        cart.productPageListSortingPriceCheck("lowToHigh");
        cart.validatePriceLowToHigh();
        cart.productPageListSortingPriceCheck("popularity");
        cart.productPageListSortingPriceCheck("recently");
        cart.productPageListSortingPriceCheck("highToLow");
        cart.validatePriceHighToLow();
    }

    /*******************************************************************
     * Description: This test case creates an order and starts to checkout with
     * Bank Wire, then opens a new tap and reduce the cart so amount is under bank wire
     * minimum and verifies first tab will navigate back to cart and Bank Wire option
     * is disabled
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6564(Sub $1k Wire Order)
     ********************************************************************/
    @Test(priority = 14)
    public void bankwireOrderAndModifyInNewTabBelowWireLimit() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        ArrayList<String> pt2 = new ArrayList<String>(Arrays.asList("authorize_net_cim", "paypal_express", "authorize_net_cim_echeck", "cheque", "bitpay"));
        Q_PM_AccountSteps.loginUser(22);
        // Create order and begin checkout with Bank Wire option
        Q_PM_AddToCart.gold_5_gram(15);
        Q_PM_CheckoutSteps.selectPaymentType("bacs");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        // Open a new tab & navigate to cart
//        TicketsObjects.xpOpenLinkInNewTab(".//div[@class='back-to-cart']/a");
        Q_PM_Controls.openNewTab();
        Q_PM_Controls.switchTab(1);
        driver.navigate().to(baseUrl + "/cart");
        // Reduce quantity below the bank wire minimum
        Q_PM_WebElm.xp(pmQaProps, "cart.begCartDesc.xp", 2, "cart.endCartMinus.xp");
        Q_PM_WebElm.xp(pmQaProps, "cart.begCartDesc.xp", 2, "cart.endCartUpdate.xp");
        // Go back to first tab and accept changes from different window and verify bank wire is now disabled
        Q_PM_Controls.switchTab(0);
        Q_PM_WebElm.xp(pmQaProps, "cart.pm.cart.Accept.xp");
        Q_PM_CartSteps.paymentType("Available Types", pt2);
    }
    /*******************************************************************
     * Description: This test case verifies if ordered via category page exceeds set limit.
     * Error message will appear in the modal indicating available quantity can be ordered.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 15, enabled = true)
    public void pm_cartLimit_Verification001(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_Controls.adminLogin();
        int prelimit = Q_PM_AdminPmSteps.limitCount("63");
        Q_PM_AddToCart.gold_5_63(String.valueOf(prelimit + 1));
        Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps,"cart.popupError.xp").contains("we only have "+ prelimit + " in stock"));

    }
    /*******************************************************************
     * Description: This test case verifies if ordered via category below set limit,
     * The product page will deduct amount ordered from preorder set limit.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 16, enabled = true)
    public void pm_cartLimit_Verification002(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_Controls.adminLogin();
        int prelimit = Q_PM_AdminPmSteps.limitCount("63");
        Q_PM_AddToCart.gold_5_63(String.valueOf(prelimit-1));
        int modalQty = Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.modalQuantity.xp","value"));
        System.out.println("Quantity in modal " + modalQty);
        Assert.assertEquals(modalQty, (prelimit-1) );
    }

    /*******************************************************************
     * Description: This test case verifies if ordered via category equals set limit,
     * The product page will adjusted limit set to 0 set.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 17, enabled = true)
    public void pm_cartLimit_Verification003(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_Controls.adminLogin();
        int prelimit = Q_PM_AdminPmSteps.limitCount("63");
        Q_PM_AddToCart.gold_5_63(String.valueOf(6));
        int cartQty = Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.modalQuantity.xp","value"));
        System.out.println("Quantity in cart " + cartQty);
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
        Q_PM_CheckoutSteps.selectPaymentType("bacs");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.completeOrder();
        Q_PM_WebElm.myWait(1000);
        Q_PM_AccountSteps.accountMenu("LOGOUT");
        Q_PM_WebElm.myWait(2000);
        int finalLimit =  Q_PM_AdminPmSteps.limitCount("63");
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
    @Test(priority = 18, enabled = true)
    public void pm_cartLimit_Verification004(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_Controls.adminLogin();
        int prelimit = Q_PM_AdminPmSteps.limitCount("63");
        Q_PM_CartSteps.addProductpageItemToCart("/1-4-oz-us-american-gold-eagle-coin-dates-our-choice.html", (prelimit + 1));
        int modalQty = Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.modalQuantity.xp","value"));
        System.out.println("Quantity in modal " + modalQty);
        Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps,"cart.popupError.xp").contains("we only have "+ prelimit + " in stock"));
    }

    /*******************************************************************
     * Description: This test case verifies if ordered via product page equals set limit,
     * The cart page item quantity equates to the product limit
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 19, enabled = true)
    public void pm_cartLimit_Verification005(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_Controls.adminLogin();
        int prelimit = Q_PM_AdminPmSteps.limitCount("63");
        Q_PM_CartSteps.addProductpageItemToCart("/1-4-oz-us-american-gold-eagle-coin-dates-our-choice.html", (prelimit + 1));
        int modalQty = Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.modalQuantity.xp","value"));
        System.out.println("Quantity in modal " + modalQty);
        Assert.assertEquals(modalQty, (prelimit) );
        Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps,"cart.popupError.xp").contains("we only have "+ prelimit + " in stock"));
    }

    /*******************************************************************
     * Description: This test case verifies if ordered below set limit add to cart, In cart page attempt to increase
     * quantity beyond set limtt. Error message will appear in the modal indicating available quantity can be ordered.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 20, enabled = true)
    public void pm_cartLimit_Verification006(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_Controls.adminLogin();
        int prelimit = Q_PM_AdminPmSteps.limitCount("63");
        Q_PM_CartSteps.addProductpageItemToCart("/1-4-oz-us-american-gold-eagle-coin-dates-our-choice.html", (prelimit));
        int modalQty = Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.modalQuantity.xp","value"));
        System.out.println("Quantity in modal " + modalQty);
        Q_PM_CartSteps.modalChekcout();
        Assert.assertEquals(modalQty, (prelimit) );
        Q_PM_CartSteps.increaseCartQuantity(prelimit+ 5);
        int cartQty = Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.quantityInput.xp", "value"));
        Assert.assertEquals(cartQty, prelimit);
    }

    @AfterTest
    public void endReport(){
    }
    
    @AfterMethod
    public void tearDown() throws Exception {
        Q_PM_CartSteps.deleteItems();
        Q_PM_Controls.tearDown();
    }
    
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }

}
