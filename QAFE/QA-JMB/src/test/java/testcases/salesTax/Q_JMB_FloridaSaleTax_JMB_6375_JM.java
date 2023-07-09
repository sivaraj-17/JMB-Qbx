package testcases.salesTax;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.util.ArrayList;

public class Q_JMB_FloridaSaleTax_JMB_6375_JM {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
    static Q_JMB_CategoryObjects cat = new Q_JMB_CategoryObjects();
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
     // * Description: Verifies Florida tax on Palladium order over $500.00 order is taxable
     // * Author:
     // * Status: Complete
     // * Ticket: JMB-6375
     // * ***************************************************************/
    @Test (priority = 1)
    public void palladium1oz() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(12);
        prod.selectTaxableItem("Palladium", 1);
        acc.logoutUser();
    }
    
    /*******************************************************************
     // * Description: Verifies Florida tax on silver artwork order under $500.00 order is taxable
     // * Author:
     // * Status: Complete
     // * Ticket: JMB-6375
     // * ***************************************************************/
//    @Test (priority = 2,  enabled= )
//    public void silverStatue() throws Exception {
//        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
//        Controls.testStarted(tcName);
//        acc.loginUser(12);
//        prod.selectTaxableItem("silver artwork", 1);
//        acc.logoutUser();
//    }
    @Test (priority = 3, enabled = false)
    public void artwork() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(12);
        prod.selectTaxableItem("silver artwork", 1);
        acc.logoutUser();
    }
    
    /*******************************************************************
     // * Description: Verifies Florida tax on accessories order under $500.00 order is taxable
     // * Author:
     // * Status: Complete
     // * Ticket: JMB-6375
     // * ***************************************************************/
    @Test (priority = 4)
    public void accessories() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(12);
        prod.selectTaxableItem("38mm coin tube", 1);
        acc.logoutUser();
    }
    
    /*******************************************************************
     // * Description: Verifies Florida tax on Copper order under $500.00 order is taxable
     // * Author:
     // * Status: Complete
     // * Ticket: JMB-6375
     // * ***************************************************************/
    @Test (priority = 5)
    public void copperQuarter() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(12);
        prod.selectTaxableItem("copperUSQuarter", 15);
        acc.logoutUser();
    }
    
    /*******************************************************************
     // * Description: Verifies Florida tax on Palladium, silver artwork, accessories and copper  order over $500.00 order is taxable
     // * Author:
     // * Status: Complete
     // * Ticket: JMB-6375
     // * ***************************************************************/
    @Test (priority = 6)
    public void floridaTaxable() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(12);
        prod.selectTaxableItem("all taxable metal", 1);
        acc.logoutUser();
    }
    
    /*******************************************************************
     // * Description:Verify all items are taxable if items other than Palladium, silver artwork, accessories and copper  order under $500.00 order is taxable
     // * Author:
     // * Status: Complete
     // * Ticket: JMB-6375
     // * ***************************************************************/
    @Test (priority = 7)
    public void taxableItemsUnder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(12);
        Q_JMB_CategoryObjects.goldEagle("1");
        Q_JMB_CategoryObjects.perthMintGoldBar("2");
        prod.selectTaxableItem("all taxable metal", 1);
        acc.logoutUser();
    }
    
    /*******************************************************************
     // * Description:Verify tax only applied to Palladium, silver artwork, accessories and copper  if remaining item on order over $500.00
     // * Author:
     // * Status: Complete
     // * Ticket: JMB-6375
     // * ***************************************************************/
    @Test (priority = 8)
    public void taxableItemsOver500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(12);
        Q_JMB_CategoryObjects.goldEagle("3");
        Q_JMB_CategoryObjects.perthMintGoldBar("4");
        prod.selectTaxableItem("all taxable metal", 1);
        acc.logoutUser();
    }
    
    @Test(priority = 9)
    public static void guestFloridaTaxableUnder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        prod.selectItem("/5-oz-silvertowne-prospector-stackable-silver-round/",1);
        prod.selectItem("/dollar-air-tite-coin-tube/",20);
        cart.paymentType("cart.paymentType.CC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa+8jmb@jmbullion.com");
        chk.shippingAddressForm(34);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.itemTax();
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     // * Description:Verify guest order tax applies Palladium, silver artwork, accessories and copper  regardless of order total
     // * Author:
     // * Status: Complete
     // * Ticket: JMB-6375
     // * ***************************************************************/
    @Test(priority = 10)
    public static void guestAllItemsTaxable() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        prod.selectItem("/1-oz-canadian-palladium-maple-leaf/",1);
        prod.selectItem("/5-oz-silvertowne-prospector-stackable-silver-round/",1);
        prod.selectItem("/dollar-air-tite-coin-tube/",20);
        prod.selectItem("/1-oz-quarter-copper-round/",20);
        cart.paymentType("cart.paymentType.CC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa+8jmb@jmbullion.com");
        chk.shippingAddressForm(34);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.itemTax();
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     // * Description:Verify on guest orders tax only applied to Palladium, silver artwork, accessories and copper  if remaining item on order over $500.00
     // * Author:
     // * Status: Complete
     // * Ticket: JMB-6375
     // * ***************************************************************/
    @Test(priority = 11)
    public static void guestMixedItemUnder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.goldBar1gSunshine("2");
        prod.selectItem("/1-oz-canadian-palladium-maple-leaf/",1);
        prod.selectItem("/5-oz-silvertowne-prospector-stackable-silver-round/",1);
        prod.selectItem("/dollar-air-tite-coin-tube/",20);
        prod.selectItem("/1-oz-quarter-copper-round/",20);
        cart.paymentType("cart.paymentType.CC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa+8jmb@jmbullion.com");
        chk.shippingAddressForm(34);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.itemTax();
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     // * Description:Verify on guest orders all items are taxable if items other than Palladium, silver artwork, accessories and copper  order under $500.00 order is taxable
     // * Author:
     // * Status: Complete
     // * Ticket: JMB-6375
     // * ***************************************************************/
    @Test(priority = 12)
    public static void guestmixedItemsOver500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.goldEagle("1");
        prod.selectItem("/1-oz-canadian-palladium-maple-leaf/",1);
        prod.selectItem("/5-oz-silvertowne-prospector-stackable-silver-round/",1);
        prod.selectItem("/dollar-air-tite-coin-tube/",20);
        prod.selectItem("/1-oz-quarter-copper-round/",20);
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa+8jmb@jmbullion.com");
        chk.shippingAddressForm(34);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.itemTax();
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     // * Description:Verify Palladium tender under $500.00 order is taxable
     // * Author:
     // * Status: Complete
     // * Ticket: JMB-6825
     // * ***************************************************************/
    @Test(priority = 13)
    public static void palladiumTenderUnder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        prod.selectItem("/2018-w-1-oz-proof-american-palladium-eagle-coin-ngc-pf70-er/",1);

        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa+8jmb@jmbullion.com");
        chk.shippingAddressForm(34);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.itemTax();
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     // * Description:Verify Palladium tender order over $500.00 order is not taxable
     // * Author:
     // * Status: Complete
     // * Ticket: JMB-6825
     // * ***************************************************************/
    @Test(priority = 14)
    public static void palladiumTenderOver500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        prod.selectItem("/2018-w-1-oz-proof-american-palladium-eagle-coin-ngc-pf70-er/",2);

        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa+8jmb@jmbullion.com");
        chk.shippingAddressForm(34);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.itemTax();
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     // * Description:Verify on guest orders all items are taxable if items other than Palladium, silver artwork, accessories and copper  order under $500.00 order is taxable
     // * Author:
     // * Status: Complete
     // * Ticket: JMB-6375
     // * ***************************************************************/
    @Test(priority = 15)
    public static void guestmixedItemsOver500WPallidiumItemUnder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.goldEagle("1");
        prod.selectItem("/2018-w-1-oz-proof-american-palladium-eagle-coin-ngc-pf70-er/",1);
        prod.selectItem("/1-oz-canadian-palladium-maple-leaf/",1);
        prod.selectItem("/5-oz-silvertowne-prospector-stackable-silver-round/",1);
        prod.selectItem("/dollar-air-tite-coin-tube/",20);
        prod.selectItem("/1-oz-quarter-copper-round/",20);
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa+8jmb@jmbullion.com");
        chk.shippingAddressForm(34);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.itemTax();
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
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
