package testcases.salesTax;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;
import java.util.ArrayList;

public class Q_Slv_FloridaTax extends Q_Slv_Init {
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
     * Description: Verifies Florida sales tax on Palladium order over $500.00 order is not taxable
     * Author:
     * Status: Complete
     * Ticket: JMB-6375
     *****************************************************************/
    @Test(priority = 1)
    public void floridaTaxPalladium1ozUnder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 12);
        Q_Slv_CartSteps.addPdpProduct("/2018-w-1-oz-proof-palladium-american-eagle-coins-ngc-ms70-er/", "1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
    }
    /*******************************************************************
     * Description: Verifies Florida sales tax on silver artwork order under $500.00 order is taxable
     * Author:
     * Status: Complete
     * Ticket: JMB-6375
     *****************************************************************/
    @Test (priority = 2)
    public void floridaTaxArtworkUnder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 12);
        Q_Slv_CartSteps.silver1("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
    }
    /*******************************************************************
     * Description: Verifies Florida sales tax on accessories order under $500.00 order is taxable
     * Author:
     * Status: Complete
     * Ticket: JMB-6375
     *****************************************************************/
    @Test (priority = 3)
    public void floridaTaxAccessoriesUnder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 12);
        Q_Slv_CartSteps.addPdpProduct("/41-mm-air-tite-coin-tubes/", "10");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
    }
    /*******************************************************************
     * Description: Verifies Florida sales tax on Copper order under $500.00 order is taxable
     * Author:
     * Status: Complete
     * Ticket: JMB-6375
     *****************************************************************/
    @Test (priority = 4)
    public void floridaTaxCopperQuarterUnder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 12);
        Q_Slv_CartSteps.addPdpProduct("/1-oz-us-quarter-copper-rounds/", "10");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);

    }
    /*******************************************************************
     * Description: Verifies Florida sales tax on Palladium, silver artwork, accessories and copper  order over $500.00 order is taxable
     * Author:
     * Status: Complete
     * Ticket: JMB-6375
     *****************************************************************/
    @Test (priority = 5)
    public void floridaTaxMultipleItemsUnder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 12);
        Q_Slv_CartSteps.addPdpProduct("/1-oz-canadian-palladium-maple-leaf/", "1");
        Q_Slv_CartSteps.silver1("1");
        Q_Slv_CartSteps.addPdpProduct("/41-mm-air-tite-coin-tubes/", "10");
        Q_Slv_CartSteps.addPdpProduct("/1-oz-us-quarter-copper-rounds/", "10");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 7);

    }
    /*******************************************************************
     * Description:Verify all items are taxable if items other than Palladium, silver artwork, accessories and copper  order under $500.00 order is taxable
     * Author:
     * Status: Complete
     * Ticket: JMB-6375
     *****************************************************************/
    @Test (priority = 6)
    public void floridaTaxMultipleItemsPlusNoTaxItemUnder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.gold2("1");
        Q_Slv_AccountSteps.login("acc.login.link.xp", 12);
        Q_Slv_CartSteps.addPdpProduct("/1-oz-canadian-palladium-maple-leaf/", "1");
        Q_Slv_CartSteps.silver1("1");
        Q_Slv_CartSteps.addPdpProduct("/41-mm-air-tite-coin-tubes/", "10");
        Q_Slv_CartSteps.addPdpProduct("/1-oz-us-quarter-copper-rounds/", "10");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 8);

    }
    /*******************************************************************
     * Description:Verify tax only applied to Palladium, silver artwork, accessories and copper  if remaining item on order over $500.00
     * Author:
     * Status: Complete
     * Ticket: JMB-6375
     *****************************************************************/
    @Test (priority = 7)
    public void floridaTaxItemsOver500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.gold1("1");
        Q_Slv_AccountSteps.login("acc.login.link.xp", 12);
        Q_Slv_CartSteps.addPdpProduct("/1-oz-canadian-palladium-maple-leaf/", "1");
        Q_Slv_CartSteps.silver1("1");
        Q_Slv_CartSteps.addPdpProduct("/41-mm-air-tite-coin-tubes/", "10");
        Q_Slv_CartSteps.addPdpProduct("/1-oz-us-quarter-copper-rounds/", "10");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 8);
    }
    /*******************************************************************
     * Description:Verify tax only applied to Palladium, silver artwork, accessories and copper 
     * if remaining item on order over $500.00 for Guest user
     * Author:
     * Status: Complete
     * Ticket: JMB-6375
     *****************************************************************/
    @Test(priority = 8)
    public static void guestFloridaTaxUnder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.addPdpProduct("/1-oz-canadian-palladium-maple-leaf/", "1");
        Q_Slv_CartSteps.silver1("1");
        Q_Slv_CartSteps.addPdpProduct("/41-mm-air-tite-coin-tubes/", "10");
        Q_Slv_CartSteps.addPdpProduct("/1-oz-us-quarter-copper-rounds/", "10");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "qa+8jmb@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(3);
        Q_Slv_CheckoutSteps.shippingAutoAddress(34);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 7);

    }
    /*******************************************************************
     * Description:Verify guest order tax applies Palladium, silver artwork, accessories and copper  regardless of order total
     * Author:
     * Status: Complete
     * Ticket: JMB-6375
     *****************************************************************/
    @Test(priority = 9)
    public static void guestFloridaTaxAllItemsTaxable() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.addPdpProduct("/1-oz-canadian-palladium-maple-leaf/", "1");
        Q_Slv_CartSteps.silver1("1");
        Q_Slv_CartSteps.addPdpProduct("/41-mm-air-tite-coin-tubes/", "10");
        Q_Slv_CartSteps.addPdpProduct("/1-oz-us-quarter-copper-rounds/", "10");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "qa+8jmb@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(3);
        Q_Slv_CheckoutSteps.shippingAutoAddress(34);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 7);
    }
    /*******************************************************************
     * Description:Verify on guest orders tax only applied to Palladium, silver artwork, accessories and copper  if remaining item on order over $500.00
     * Author:
     * Status: Complete
     * Ticket: JMB-6375
     *****************************************************************/
    @Test(priority = 10)
    public static void guestFloridaTaxMixedItemUnder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);

        Q_Slv_CartSteps.addPdpProduct("/1-oz-canadian-palladium-maple-leaf/", "1");
        Q_Slv_CartSteps.silver1("1");
        Q_Slv_CartSteps.addPdpProduct("/41-mm-air-tite-coin-tubes/", "10");
        Q_Slv_CartSteps.addPdpProduct("/1-oz-us-quarter-copper-rounds/", "10");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "qa+8jmb@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(3);
        Q_Slv_CheckoutSteps.shippingAutoAddress(34);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 8);

    }
    /*******************************************************************
     * Description:Verify on guest orders all items are taxable if items other than Palladium, silver artwork, accessories and copper  order under $500.00 order is taxable
     * Author:
     * Status: Complete
     * Ticket: JMB-6825
     *****************************************************************/
    @Test(priority = 11)
    public static void palladiumCoinunder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        driver.navigate().refresh();
        Q_Slv_CartSteps.addPdpProduct("/2018-w-1-oz-proof-palladium-american-eagle-coins-ngc-ms70-er/", "1");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "qa+8jmb@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(3);
        Q_Slv_CheckoutSteps.shippingAutoAddress(34);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
    }
    /*******************************************************************
     * Description:Verify on guest orders tax only applied to Palladium, silver artwork, accessories and copper  if remaining item on order over $500.00
     * Author:
     * Status: Complete
     * Ticket: JMB-6825
     *****************************************************************/
    @Test(priority = 12)
    public static void PalladiumOver500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.gold2("3");
        Q_Slv_CartSteps.addPdpProduct("/2018-w-1-oz-proof-palladium-american-eagle-coins-ngc-ms70-er/", "2");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "qa+8jmb@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(3);
        Q_Slv_CheckoutSteps.shippingAutoAddress(34);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);

    }
    /*******************************************************************
     * Description:Verify on guest orders tax only applied to Palladium, silver artwork, accessories and copper  if remaining item on order over $500.00
     * Author:
     * Status: Complete
     * Ticket: JMB-6825
     *****************************************************************/
    @Test(priority = 13)
    public static void guestFloridaTaxMixedItemPalladiumUnder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.gold2("3");
        Q_Slv_CartSteps.addPdpProduct("/2018-w-1-oz-proof-palladium-american-eagle-coins-ngc-ms70-er/", "1");
        Q_Slv_CartSteps.silver1("1");
//        Q_CartSteps.addPdpProduct("/33-mm-air-tite-coin-tubes/", "10");
        Q_Slv_CartSteps.addPdpProduct("/41-mm-air-tite-coin-tubes/", "10");
        Q_Slv_CartSteps.addPdpProduct("/1-oz-us-quarter-copper-rounds/", "10");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "qa+8jmb@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(3);
        Q_Slv_CheckoutSteps.shippingAutoAddress(34);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 8);

    }
    /*******************************************************************
     * Description:Verify on guest orders tax only applied to Palladium, silver artwork, accessories and copper  if remaining item on order over $500.00
     * Author:
     * Status: Complete
     * Ticket: JMB-6825
     *****************************************************************/
    @Test(priority = 14)
    public static void guestFloridaTaxMixedItemPalladiumOver500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.gold2("3");
        Q_Slv_CartSteps.addPdpProduct("/2018-w-1-oz-proof-palladium-american-eagle-coins-ngc-ms70-er/", "2");
        Q_Slv_CartSteps.silver1("1");
//        Q_CartSteps.addPdpProduct("/33-mm-air-tite-coin-tubes/", "10");
        Q_Slv_CartSteps.addPdpProduct("/41-mm-air-tite-coin-tubes/", "10");
        Q_Slv_CartSteps.addPdpProduct("/1-oz-us-quarter-copper-rounds/", "10");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "qa+8jmb@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(3);
        Q_Slv_CheckoutSteps.shippingAutoAddress(34);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 8);

    }
    @AfterTest
    public void endReport(){
    }
    @AfterMethod
    public void tearDown() throws Exception {
		Q_Slv_CartSteps.emptyCart();
 		Q_Slv_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
    }
}


