package testcases.salesTax;

import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageObjects.Q_PM_AccountSteps;
import pageObjects.Q_PM_CartSteps;
import pageObjects.Q_PM_CheckoutSteps;
import testcases.cart.Q_PM_AddToCart;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

import java.util.ArrayList;

public class Q_PM_FloridaSaleTax_JMB6375_PM extends Q_PM_Init {
	@BeforeClass
	public void tcSetup() {
	}
	@BeforeMethod
	public void report() throws Exception {
		Q_PM_Init.setItUp();
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
		Q_PM_Controls.testStarted(tcName);
		Q_PM_CartSteps cart = new Q_PM_CartSteps();
		Q_PM_AccountSteps.loginUser(12);
		cart.selectTaxableItem("Palladium", 1);

	}
	/*******************************************************************
	 // * Description: Verifies Florida tax on silver artwork order under $500.00 order is taxable
	 // * Author:
	 // * Status: Complete
	 // * Ticket: JMB-6375
	 // * ***************************************************************/
	@Test (priority = 2)
	public void silverStatue() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_PM_Controls.testStarted(tcName);
		Q_PM_CartSteps cart = new Q_PM_CartSteps();
		Q_PM_AccountSteps.loginUser(12);
		cart.selectTaxableItem("silver artwork", 1);

	}
//	@Test (priority = 3)
//	public void silverSkull() throws Exception {
//		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
//		Controls.testStarted(tcName);
//		CartSteps cart = new CartSteps();
//		AccountSteps.loginUser(12);
//		ticket.selectTaxableItem("silver skull", 1);
//
//	}
	/*******************************************************************
	 // * Description: Verifies Florida tax on accessories order under $500.00 order is taxable
	 // * Author:
	 // * Status: Complete
	 // * Ticket: JMB-6375
	 // * ***************************************************************/
	@Test (priority = 4)
	public void accessories() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_PM_Controls.testStarted(tcName);
		Q_PM_CartSteps cart = new Q_PM_CartSteps();
		Q_PM_AccountSteps.loginUser(12);
		cart.selectTaxableItem("39mm coin tube", 1);

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
		Q_PM_Controls.testStarted(tcName);
		Q_PM_CartSteps cart = new Q_PM_CartSteps();
		Q_PM_AccountSteps.loginUser(12);
		cart.selectTaxableItem("copperMapleLeaf", 20);

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
		Q_PM_Controls.testStarted(tcName);
		Q_PM_CartSteps cart = new Q_PM_CartSteps();
		Q_PM_AccountSteps.loginUser(12);
		cart.selectTaxableItem("all taxable metal", 1);

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
		Q_PM_Controls.testStarted(tcName);
		Q_PM_CartSteps cart = new Q_PM_CartSteps();
		Q_PM_AccountSteps.loginUser(12);
		Q_PM_AddToCart.gold_2_2555362("1");
		cart.selectTaxableItem("all taxable metal", 1);

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
		Q_PM_Controls.testStarted(tcName);
		Q_PM_CartSteps cart = new Q_PM_CartSteps();
		Q_PM_AccountSteps.loginUser(12);
		Q_PM_AddToCart.gold_3_2553276("2");
		Q_PM_AddToCart.gold_3_2553276("2");
		cart.selectTaxableItem("all taxable metal", 1);

	}
	/*******************************************************************
	 // * Description:Verify guest order tax applies Palladium, silver artwork, accessories and copper  regardless of order total
	 // * Author:
	 // * Status: Complete
	 // * Ticket: JMB-6375
	 // * ***************************************************************/
	@Test (priority = 9)
	public void guestAllTaxable() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_PM_Controls.testStarted(tcName);
		Q_PM_CartSteps cart = new Q_PM_CartSteps();
		driver.navigate().to(baseUrl + "/1-oz-9995-fine-palladium-bar.html");
		Q_PM_CartSteps.addProductpageItemToCart(1);
		driver.navigate().to(baseUrl + "/2-oz-atlantis-skull-and-crossbones-poured-silver-bar.html");
		cart.addProductpageItemToCart(1);
		driver.navigate().to(baseUrl + "/medallion-silver-round-tube-39mm-coinsafe.html");
		cart.addProductpageItemToCart(1);
		driver.navigate().to(baseUrl + "/maple-leaf-1-oz-copper-round.html");
		cart.addProductpageItemToCart(1);
		Q_PM_CartSteps.modalChekcout();
		Q_PM_CheckoutSteps.selectPaymentType("cheque");
		Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
		Q_PM_CheckoutSteps.bridgePage("guest", "chk.checkoutNowGuest.xp");

		Q_PM_CheckoutSteps.validateAddress();
		Q_PM_CheckoutSteps.itemTax();
		ArrayList<Float> revPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());
		Q_PM_CheckoutSteps.completeOrder();
		ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());
		//System.out.println(orderPrices);
		Q_PM_CheckoutSteps.verifyOrderCharges(revPrices, orderPrices);


	}
	/*******************************************************************
	 // * Description:Verify on guest orders tax only applied to Palladium, silver artwork, accessories and copper  if remaining item on order over $500.00
	 // * Author:
	 // * Status: Complete
	 // * Ticket: JMB-6375
	 // * ***************************************************************/
	@Test (priority = 10)
	public void guestAllTaxableUnder500() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_PM_Controls.testStarted(tcName);

		//System.out.println(orderPrices);
		Q_PM_CartSteps cart = new Q_PM_CartSteps();
		Q_PM_AddToCart.gold_3_2553276("2");
		driver.navigate().to(baseUrl + "/1-oz-9995-fine-palladium-bar.html");
		cart.addProductpageItemToCart(1);
		driver.navigate().to(baseUrl + "/2-oz-atlantis-skull-and-crossbones-poured-silver-bar.html");
		cart.addProductpageItemToCart(1);
		driver.navigate().to(baseUrl + "/medallion-silver-round-tube-39mm-coinsafe.html");
		cart.addProductpageItemToCart(1);
		driver.navigate().to(baseUrl + "/maple-leaf-1-oz-copper-round.html");
		cart.addProductpageItemToCart(1);
		Q_PM_CartSteps.modalChekcout();
		Q_PM_CheckoutSteps.selectPaymentType("cheque");
		Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
		Q_PM_CheckoutSteps.bridgePage("guest", "chk.checkoutNowGuest.xp");

		Q_PM_CheckoutSteps.validateAddress();
		Q_PM_CheckoutSteps.itemTax();
		ArrayList<Float> revPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());
		Q_PM_CheckoutSteps.completeOrder();
		ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());
		Q_PM_CheckoutSteps.verifyOrderCharges(revPrices, orderPrices);


	}
	/*******************************************************************
	 // * Description:Verify on guest orders all items are taxable if items other than Palladium, silver artwork, accessories and copper  order under $500.00 order is taxable
	 // * Author:
	 // * Status: Complete
	 // * Ticket: JMB-6375
	 // * ***************************************************************/
	@Test (priority = 11)
	public void guestAllTaxableOver500() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_PM_Controls.testStarted(tcName);
		Q_PM_CartSteps cart = new Q_PM_CartSteps();
		Q_PM_AddToCart.gold_2_2555362("2");
		Q_PM_AddToCart.gold_3_2553276("2");

		driver.navigate().to(baseUrl + "/1-oz-9995-fine-palladium-bar.html");
		cart.addProductpageItemToCart(1);
		driver.navigate().to(baseUrl + "/2-oz-atlantis-skull-and-crossbones-poured-silver-bar.html");
		cart.addProductpageItemToCart(1);
		driver.navigate().to(baseUrl + "/medallion-silver-round-tube-39mm-coinsafe.html");
		cart.addProductpageItemToCart(1);
		driver.navigate().to(baseUrl + "/maple-leaf-1-oz-copper-round.html");
		cart.addProductpageItemToCart(1);
		Q_PM_CartSteps.modalChekcout();
		Q_PM_CheckoutSteps.selectPaymentType("cheque");
		Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
		Q_PM_CheckoutSteps.bridgePage("guest", "chk.checkoutNowGuest.xp");

		Q_PM_CheckoutSteps.validateAddress();
		Q_PM_CheckoutSteps.itemTax();
		ArrayList<Float> revPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());
		Q_PM_CheckoutSteps.completeOrder();
		ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());
		//System.out.println(orderPrices);
		Q_PM_CheckoutSteps.verifyOrderCharges(revPrices, orderPrices);

	}
	/*******************************************************************
	 // * Description: Verifies Florida sales tax on Palladium tender order under $500.00 order is taxable
	 // * Author:
	 // * Status: Complete
	 // * Ticket: JMB-6375
	 // * ***************************************************************/
	@Test (priority = 12)
	public void palladiumTenderUnder500() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_PM_Controls.testStarted(tcName);
		Q_PM_CartSteps cart = new Q_PM_CartSteps();
		Q_PM_AccountSteps.loginUser(12);
		cart.selectTaxableItem("Palladium Coin Below 500", 1);

	}
	/*******************************************************************
	 // * Description: Verifies Florida sales tax on Palladium tender order over $500.00 order is not taxable
	 // * Author:
	 // * Status: Complete
	 // * Ticket: JMB-6825
	 // * ***************************************************************/
	@Test (priority = 13)
	public void palladiumTenderOver500() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_PM_Controls.testStarted(tcName);
		Q_PM_CartSteps cart = new Q_PM_CartSteps();
		Q_PM_AccountSteps.loginUser(12);
		Q_PM_CartSteps.addProductpageItemToCart("/2018-w-1-oz-proof-american-palladium-eagle-coin-ngc-pf70-ucam-er/", 2);
		Q_PM_CartSteps.modalChekcout();
		Q_PM_CheckoutSteps.selectPaymentType("cheque");
		Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
		Q_PM_CheckoutSteps.itemTax();
		ArrayList<Float> revPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
		Q_PM_CheckoutSteps.completeOrder();
		ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
		Q_PM_CheckoutSteps.verifyOrderCharges(revPrices, orderPrices);

	}
	/*******************************************************************
	 // * Description:Verify no tax only applied to Palladium, silver artwork, accessories and copper  if remaining item on order under $500.00
	 // * Author:
	 // * Status: Complete
	 // * Ticket: JMB-6825
	 // * ***************************************************************/
	@Test (priority = 14)
	public void guestAllTaxableUnderPalladiumUnder500() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_PM_Controls.testStarted(tcName);
		//System.out.println(orderPrices);
		Q_PM_CartSteps cart = new Q_PM_CartSteps();
		Q_PM_AccountSteps.loginUser(12);
		Q_PM_AddToCart.gold_3_2553276("2");
		Q_PM_CartSteps.addProductpageItemToCart("/2018-w-1-oz-proof-american-palladium-eagle-coin-ngc-pf70-ucam-er/", 1);
		Q_PM_CartSteps.addProductpageItemToCart( "/2-oz-atlantis-skull-and-crossbones-poured-silver-bar.html", 1);
		Q_PM_CartSteps.addProductpageItemToCart( "/medallion-silver-round-tube-39mm-coinsafe.html", 1);
		Q_PM_CartSteps.addProductpageItemToCart("/maple-leaf-1-oz-copper-round.html", 1);
		Q_PM_CartSteps.modalChekcout();
		Q_PM_CheckoutSteps.selectPaymentType("cheque");
		Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");


		Q_PM_CheckoutSteps.itemTax();
		ArrayList<Float> revPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());
		Q_PM_CheckoutSteps.completeOrder();
		ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());
		Q_PM_CheckoutSteps.verifyOrderCharges(revPrices, orderPrices);


	}
	/*******************************************************************
	 // * Description:Verify on guest orders tax only applied to Palladium, silver artwork, accessories and copper  if remaining item on order over $500.00
	 // * Author:
	 // * Status: Complete
	 // * Ticket: JMB-6825
	 // * ***************************************************************/
	@Test (priority = 15)
	public void guestAllTaxableUnderPalladiumOver500() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_PM_Controls.testStarted(tcName);
		//System.out.println(orderPrices);
		Q_PM_CartSteps cart = new Q_PM_CartSteps();
		Q_PM_AddToCart.gold_3_2553276("2");
		Q_PM_CartSteps.addProductpageItemToCart("/2018-w-1-oz-proof-american-palladium-eagle-coin-ngc-pf70-ucam-er/", 2);
		Q_PM_CartSteps.addProductpageItemToCart( "/2-oz-atlantis-skull-and-crossbones-poured-silver-bar.html", 1);
		Q_PM_CartSteps.addProductpageItemToCart( "/medallion-silver-round-tube-39mm-coinsafe.html", 1);
		Q_PM_CartSteps.addProductpageItemToCart("/maple-leaf-1-oz-copper-round.html", 1);
		Q_PM_CartSteps.modalChekcout();
		Q_PM_CheckoutSteps.selectPaymentType("cheque");
		Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
		Q_PM_CheckoutSteps.bridgePage("guest", "chk.checkoutNowGuest.xp");
		Q_PM_CheckoutSteps.validateAddress();
		Q_PM_CheckoutSteps.itemTax();
		ArrayList<Float> revPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());
		Q_PM_CheckoutSteps.completeOrder();
		ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());
		Q_PM_CheckoutSteps.verifyOrderCharges(revPrices, orderPrices);

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


