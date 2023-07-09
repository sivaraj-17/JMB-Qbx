package testcases.cart;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.io.FileNotFoundException;


public class Q_JMB_CartFunctions extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();
    static Q_JMB_CategoryObjects cat = new Q_JMB_CategoryObjects();

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
    // * Description: Verify user can add multiple items with various quantities then verify cart content.
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1)
    public void verifyCart (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.goldEagle("3");
        Q_JMB_CategoryObjects.perthMintGoldBar("4");
        Q_JMB_CategoryObjects.chinesePanda("5");
        Q_JMB_CategoryObjects.silverCoin1994("5");
        Q_JMB_CategoryObjects.silverGeigerSecurity( "1");
        Q_JMB_CategoryObjects.silverPeaceSilverDollarCoi("4");
        Q_JMB_ProductPageObjects.platinumAmericanEagle("1");
        Q_JMB_ProductPageObjects.platinumRampSuisseFortuna("3");
        Q_JMB_ProductPageObjects.platinumRampSuisseFortuna10oz("1");
        Q_JMB_CategoryObjects.copperUSQuarter("10");
        Q_JMB_CartPageObjects.verifyCartContent();

    }
    //*******************************************************************
    // * Description: Verify user can edit cart content, increase, reduce, delete quantity in cart page.
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2)
    public void editCart (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.goldEagle("3");
        Q_JMB_CategoryObjects.perthMintGoldBar("3");
        Q_JMB_CategoryObjects.silverPeaceSilverDollarCoi("6");
        Q_JMB_ProductPageObjects.platinumRampSuisseFortuna("2");
        Q_JMB_CategoryObjects.copperUSQuarter("10");
        cart.selectPaymentType("wire");
        Q_JMB_CartPageObjects.editCartContent();

    }
    //*******************************************************************
    // * Description:Verify user can return from checkout page to edit cart content, increase, reduce, delete quantity in cart page.
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3)
    public void editCartModify (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.goldEagle("1");
        Q_JMB_CategoryObjects.perthMintGoldBar("1");
        Q_JMB_CategoryObjects.silverPeaceSilverDollarCoi("6");
        Q_JMB_ProductPageObjects.platinumRampSuisseFortuna("2");
        Q_JMB_CategoryObjects.copperUSQuarter("10");
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        Q_JMB_WebElm.xp(jmbProps, "chk.reviewOrderNodify.xp");
        Q_JMB_CartPageObjects.editCartContent();

    }
    //*******************************************************************
    // * Description: Verify the modal displays pricing for Check and bank wire prices bitcoin price credit card price
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 4)
    public static void modalPaymentTypePricing() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CartPageObjects.modalPrice("1");
        cart.selectPaymentType("cheque");

    }
    //*******************************************************************
    // * Description: Verify the product page displays pricing for Product page Check / Wire PriceProduct page Bitcoin / Bitcoin Cash Price
    // * and Product page Credit Card Price
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 5)
    public static void productPagePaymentTypePricing() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        prod.productPagePrice("1");

    }
    //*******************************************************************
    // * Description: Verify the cart page displays pricing for cart page Check / Wire Price, cart page Bitcoin / Bitcoin Cash Price
    // * an cart page Credit Card Price
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 6)
    public static void cartPagePaymentTypePricing() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CartPageObjects.cartPagePrice("1");

    }
    //*******************************************************************
    // * Description: cart page unit price multiplied by the quantity to obtain line item
    // * verify calculated line item equates to the displayed value on the cart page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 7)
    public static void itemMultiplequantity() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CartPageObjects.multipleItemPricing("4");

    }
    //*******************************************************************
    // * Description: Verify that gift certificate can be removed and the total price is adjusted
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 8)
    public static void giftCertificate() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.silverPeaceSilverDollarCoi("20");
        cart.selectPaymentType("cheque");
        cart.giftCertificateInput();
        cart.giftCertificateApply();
        cart.verifyGiftCertificateTotal();

    }
    //*******************************************************************
    // * Description: Verify the cart page subtract the gift certificate value from the total price
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 9)
    public static void removeGiftCertificate() throws InterruptedException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.goldEagle("1");
        cart.selectPaymentType("cheque");

        cart.giftCertificateInput();
        cart.giftCertificateApply();
        cart.verifyGiftCertificateTotal();
        Q_JMB_WebElm.myWait(1000);
        cart.removeGiftCertificate();
        cart.verifyNoGiftCertificate();

    }
    /*******************************************************************
     // * Description: Verify the cart language paper check payment
     // * Author:
     // * Jira Ticket: JMB-6231 / 6386
     // * Status: Complete
     //*******************************************************************/
    @Test(priority=10, enabled = true)
    public static void verifyUpdatedCartLanguagePaperCheck()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.chinesePanda("10");
        cart.selectPaymentType("cheque");
        cart.paperCheckCartLanguage();

    }
    /*******************************************************************
     // * Description: Verify the cart language ACH payment type
     // * Author:
     // * Jira Ticket: JMB-6231 / 6386
     // * Status: Complete
     //*******************************************************************/
    @Test(priority=11, enabled = true)
    public static void verifyUpdatedCartLanguageACH()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.chinesePanda("4");
        cart.selectPaymentType("echeck");
        cart.achCartLanguage();

    }
    /*******************************************************************
     // * Description: Verify the cart language for bank wire payment type
     // * Author:
     // * Jira Ticket: JMB-6231 / 6386
     // * Status: Complete
     //*******************************************************************/
    @Test(priority=12, enabled = true)
    public static void verifyUpdatedCartLanguageBankWire()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.silverGeigerSecurity("1");
        cart.selectPaymentType("wire");
        cart.wireCartLanguage();
    }
    /*******************************************************************
     // * Description: Verify the cart sorting
     // * Author:
     // * Jira Ticket: JMB-5908
     // * Status: Complete
     //*******************************************************************/
    @Test(priority=13, enabled = true)
    public static void sortingCategoryPagesWithPriceListCheck() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        cart.productPageListSortingPriceCheck("lowToHigh");
        cart.validatePriceLowToHigh();
        cart.productPageListSortingPriceCheck("popularity");
        cart.productPageListSortingPriceCheck("recently");
        cart.productPageListSortingPriceCheck("highToLow");
        cart.validatePriceHighToLow();
        cart.productPageListSortingPriceCheck("weightAsc");
        cart.productPageListSortingPriceCheck("weightDesc");

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
    @Test(priority = 14, enabled = true)
    public void bankwireOrderAndModifyInNewTabBelowWireLimit() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(22);
        // Create order and begin checkout with Bank Wire option
        Q_JMB_CategoryObjects.perthMintGoldBar("2");
        cart.selectPaymentType("wire");
        cart.selectcheckoutBtn("top");
        // Open a new tab & navigate to cart
//        TicketsObjects.xpOpenLinkInNewTab(".//li[@class='logo']/a");
        Q_JMB_Controls.openNewTab();
        Q_JMB_Controls.switchTab(1);
        driver.navigate().to(baseUrl + "/cart");
        // Reduce quantity below the bank wire minimum
        Q_JMB_CartPageObjects.cartLineItemMinus(2);
        Q_JMB_CartPageObjects.cartLineItemUpdateBtn(2);
        // Go back to first tab and accept changes from different window and verify bank wire is now disabled
        Q_JMB_Controls.switchTab(0);
        Q_JMB_WebElm.myWait(1000);
        Q_JMB_WebElm.xp(jmbProps, "cart.Accept.xp");
        Q_JMB_WebElm.myWait(2000);
        Assert.assertFalse(Q_JMB_WebElm.idEnabled(jmbProps, "cart.paymentType.BW.id"),"Bank Wire is not disabled after reducing below wire limit.");
    }
    @Test(priority = 15, enabled = true)
    public void verifyProductPremiumNotDisplayedOnPLP() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("gold");
        Q_JMB_CartPageObjects.category("american gold coin");
        Q_JMB_CartPageObjects.category("uncirculated gold eagle");
        String status= Q_JMB_ProductPageObjects.productStatusThroughList(
                "4-Coin Proof American Gold Eagle Set (Random Year, Box + CoA)");
        if (!status.equals("The product is not displayed"))
        {
            Assert.assertEquals(status, "Out Of Stock");
            System.out.println("The product is out of stock and displayed");
        }
        else
            System.out.println(status);
    }
    /*******************************************************************
     * Description: This test case verifies if ordered via category page exceeds set limit.
     * Error message will appear in the modal indicating available quantity can be ordered.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 16, enabled = true)
    public void jmb_cartLimit_Verification001(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_Controls.adminLogin();
        int preLimit =  Q_JMB_AdminObjects.limitCount("63");
        System.out.println("Limit " + preLimit);
        Q_JMB_CategoryObjects.quarterGoldEagle(String.valueOf(preLimit +1));
        Assert.assertTrue(Q_JMB_WebElm.xpRetText(jmbProps,"cart.popupError.xp").contains("we only have "+ preLimit + " in stock"));

    }
    /*******************************************************************
     * Description: This test case verifies if ordered via category below set limit,
     * The product page will deduct amount ordered from preorder set limit.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 17, enabled = true)
    public void jmb_cartLimit_Verification002(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_Controls.adminLogin();
        int preLimit =  Q_JMB_AdminObjects.limitCount("63");
        System.out.println("Limit " + preLimit);
        Q_JMB_CategoryObjects.quarterGoldEagle(String.valueOf(preLimit -1));
        cat.modalContinue();
        cart.selectPaymentType("wire");
        int cartQty = Integer.valueOf(Q_JMB_WebElm.xpRetAttr(jmbProps, "cart.quantity.xp", "value"));
        Assert.assertEquals(cartQty, (preLimit-1));

    }

    /*******************************************************************
     * Description: This test case verifies if ordered via category equals set limit,
     * The product page will adjusted limit set to 0 set.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 18, enabled = true)
    public void jmb_cartLimit_Verification003(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_Controls.adminLogin();
        int preLimit =  Q_JMB_AdminObjects.limitCount("63");
        System.out.println("Limit " + preLimit);
        Q_JMB_CategoryObjects.quarterGoldEagle("3");
        cat.modalContinue();
        cart.selectPaymentType("cheque");
        int cartQty = Integer.valueOf(Q_JMB_WebElm.xpRetAttr(jmbProps, "cart.quantity.xp", "value"));
        Assert.assertEquals((cartQty + (preLimit - Integer.valueOf("3"))), preLimit);
        cart.selectcheckoutBtn("top");
        Q_JMB_WebElm.myWait(1000);
        chk.completeOrder();
        acc.logoutUser();
        Q_JMB_Controls.adminLogin();
        int finalLimit =  Q_JMB_AdminObjects.limitCount("63");
        System.out.println("Final product limit " + finalLimit);
        Assert.assertEquals((preLimit - finalLimit) , 3 );
        acc.logoutUser();
    }

    /*******************************************************************
     * Description: This test case verifies if ordered via product page exceeds set limit,
     * Error message will appear in the modal indicating available quantity can be ordered.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 19, enabled = true)
    public void jmb_cartLimit_Verification004(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_Controls.adminLogin();
        int preLimit =  Q_JMB_AdminObjects.limitCount("63");
        System.out.println("Limit " + preLimit);
        cart.addProductpageItemToCart("/1-4-oz-american-gold-eagle/",  (preLimit + 1));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps,"cart.emptyWoocommerce.xp"), "Please add products to your cart in order to checkout.");
    }

    /*******************************************************************
     * Description: This test case verifies if ordered via product page equals set limit,
     * The product page will adjusted limit set to 0 set.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 20, enabled = true)
    public void jmb_cartLimit_Verification005(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_Controls.adminLogin();
        int preLimit =  Q_JMB_AdminObjects.limitCount("63");
        System.out.println("Limit " + preLimit);
        cart.addProductpageItemToCart("/1-4-oz-american-gold-eagle/",  (preLimit - 1));
        cart.selectPaymentType("wire");
        int cartQty = Integer.valueOf(Q_JMB_WebElm.xpRetAttr(jmbProps, "cart.quantity.xp", "value"));
        Assert.assertEquals(cartQty, (preLimit-1));
    }


    /*******************************************************************
     * Description: This test case verifies if ordered below set limit add to cart, In cart page attempt to increase
     * quantity beyond set limtt. Error message will appear in the modal indicating available quantity can be ordered.
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: JMB-6867
     ********************************************************************/
    @Test(priority = 21, enabled = true)
    public void jmb_cartLimit_Verification006(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_Controls.adminLogin();
        int preLimit =  Q_JMB_AdminObjects.limitCount("63");
        System.out.println("Limit " + preLimit);
        cart.addProductpageItemToCart("/1-4-oz-american-gold-eagle/",  preLimit);
        cart.selectPaymentType("wire");
        cart.cartLineItemPlus(2); //2 is the row number of item in cart
        cart.cartLineItemUpdateBtn(2);
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps,"cart.woocommerce.error.xp"));
        Assert.assertTrue(Q_JMB_WebElm.xpRetText(jmbProps,"cart.woocommerce.error.xp").contains("we only have "+ preLimit + " of our"));
    }
    
    /********************************************
    // * Description: To verify the Order Total
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 7831
	 ********************************************/	
	@Test(priority = 22, enabled = true)
	public void verifyOrderTotal() throws FileNotFoundException {		
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		Q_JMB_Controls.adminLogin();
		Q_JMB_WebElm.myWait(5000);
		chk.selectItem("10 Gram Perth Mint Gold Bar", 2);
		chk.selectItem("1 oz American Gold Eagle Coin", 2);
		chk.selectItem("100 oz Geiger Security", 2);
		Q_JMB_WebElm.myWait(3000);
        cart.selectPaymentType("echeck");
		cart.validateOrderSubtotal();
        cart.xp(jmbProps, "cart.product.beg.xp", "10 Gram Perth Mint Gold Bar (New w/ Assay)", "cart.productRemove.end.xp");
        cart.xp(jmbProps, "cart.product.beg.xp", "1 oz American Gold Eagle Coin (Random Year, BU)", "cart.productRemove.end.xp");
        cart.xp(jmbProps, "cart.product.beg.xp", "100 oz Geiger Security Line Silver Bar (New)", "cart.productRemove.end.xp");
	}

    @AfterMethod
    public static void tearDown(){
        Q_JMB_CartPageObjects.removeItems();
        Q_JMB_Controls.tearDown();
    }

    @AfterClass

    public static void kill(){
        if (driver.toString().contains("Firefox")) {

        }
    }

}
