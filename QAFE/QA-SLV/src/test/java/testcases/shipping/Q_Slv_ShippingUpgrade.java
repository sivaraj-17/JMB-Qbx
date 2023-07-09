package testcases.shipping;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;
import utils.Q_Slv_Controls;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Q_Slv_ShippingUpgrade extends Q_Slv_Init {
	static Q_Slv_TicketsObjects tic = new Q_Slv_TicketsObjects();
	static Q_Slv_CartSteps cart = new Q_Slv_CartSteps();
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
	 * Description: Verifies that on shipping options for order less than $199
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 1)
	public static void verifyShippingOptionsLessThan$199SelectUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 6);
        Q_Slv_CartSteps.silver1("2");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.verifyAvailableShippingCosts("Base Shipping - Our Choice of Carrier - Tracking Included:$7.99;"
        		+ "USPS Priority:$11.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_Slv_CheckoutSteps.shippingOption("3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $1000
	 * and weight less than 16 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 2)
	public static void verifyShippingOptionsLessThan$1000AndLessThan16OzSelectUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        Q_Slv_CartSteps.silver1("6");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("mc", "331");
        Q_Slv_CheckoutSteps.verifyAvailableShippingCosts("Free Shipping - Our Choice of Carrier - Tracking Included:FREE;"
        		+ "USPS Priority:$7.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_Slv_CheckoutSteps.shippingOption("3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than 51000
	 * and weight less than 16 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 2)
	public static void verifyShippingOptionsLessThan$5000AndLessThan16OzSelectUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 6);
        Q_Slv_CartSteps.silver1("6");
        Q_Slv_CartSteps.gold2("20");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.EC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        driver.findElement(By.xpath("(.//input[@name='echeck_profile_id'])[1]")).click();
        Q_Slv_CheckoutSteps.verifyAvailableShippingCosts("Free Shipping - Our Choice of Carrier - Tracking Included:FREE;"
        		+ "USPS Priority:$7.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_Slv_CheckoutSteps.shippingOption("3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $15000
	 * and weight less than 16 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 3)
	public static void verifyShippingOptionsLessThan$15000AndLessThan16OzSelectUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 6);
        Q_Slv_CartSteps.gold2("80");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.EC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        driver.findElement(By.xpath("(.//input[@name='echeck_profile_id'])[1]")).click();
        Q_Slv_CheckoutSteps.verifyAvailableShippingCosts("Free Shipping - Our Choice of Carrier - Tracking Included:FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_Slv_CheckoutSteps.shippingOption("2");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $1000
	 * and weight less than 200 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 4)
	public static void verifyShippingOptionsLessThan$1000AndLessThan200OzSelectUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        Q_Slv_CartSteps.silver1("20");
        Q_Slv_CheckoutSteps.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.className");
        Q_Slv_CheckoutSteps.payPalNext("test1@jmbullion.com", "2014gold");
        Q_Slv_CheckoutSteps.verifyAvailableShippingCostsPayPal("Free Shipping - Our Choice of Carrier - Tracking Included:FREE;"
        		+ "USPS Priority:$12.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        driver.findElement(By.xpath("(.//input[@name='jm_shipping_method'])[3]")).click();
        //Q_Slv_CheckoutSteps.shippingOption("3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $5000
	 * and weight less than 200 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 4)
	public static void verifyShippingOptionsLessThan$5000AndLessThan200OzSelectUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        Q_Slv_CartSteps.silver1("20");
        Q_Slv_CartSteps.gold2("20");
        Q_Slv_CheckoutSteps.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.className");
        Q_Slv_CheckoutSteps.payPalNext("test1@jmbullion.com", "2014gold");
        Q_Slv_CheckoutSteps.verifyAvailableShippingCostsPayPal("Free Shipping - Our Choice of Carrier - Tracking Included:FREE;"
        		+ "USPS Priority:$12.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        driver.findElement(By.xpath("(.//input[@name='jm_shipping_method'])[3]")).click();
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $15000
	 * and weight less than 200 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 5, enabled=false)
	public static void verifyShippingOptionsLessThan$15000AndLessThan200OzSelectUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        Q_Slv_CartSteps.silver1("20");
        Q_Slv_CartSteps.gold2("100");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.verifyAvailableShippingCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_Slv_CheckoutSteps.shippingOption("2");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $25000
	 * and weight less than 200 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 6)
	public static void verifyShippingOptionsLessThan$25000AndLessThan200OzSelectUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        Q_Slv_CartSteps.gold2("300");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.verifyAvailableShippingCosts("Free Shipping - Our Choice of Carrier - Tracking Included:FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_Slv_CheckoutSteps.shippingOption("2");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $5000
	 * and weight less than 300 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 7)
	public static void verifyShippingOptionsLessThan$5000AndLessThan300OzSelectUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        Q_Slv_CartSteps.copper1("250");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.verifyAvailableShippingCosts("Free Shipping - Our Choice of Carrier - Tracking Included:FREE;"
        		+ "USPS Priority:$17.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$16.99");
        Q_Slv_CheckoutSteps.shippingOption("3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $25000
	 * and weight less than 300 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 8)
	public static void verifyShippingOptionsLessThan$25000AndLessThan300OzSelectUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        cart.addProductByURL("/2016-1-oz-silver-american-eagles/?action=edit","250");
        //Q_Slv_CartSteps.silver4("250");
        Q_Slv_CartSteps.gold2("100");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.verifyAvailableShippingCosts("Free Shipping - Our Choice of Carrier - Tracking Included:FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$16.99");
        Q_Slv_CheckoutSteps.shippingOption("2");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
    }

	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $5000
	 * and weight less than 450 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 9)
	public static void verifyShippingOptionsLessThan$5000AndLessThan450OzSelectUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        //Q_Slv_CartSteps.copper1("350");
        //Q_Slv_CartSteps.gold2("100");
        driver.navigate().to(baseUrl + "/33-mm-air-tite-coin-tubes/");
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.pdp.qty.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.pdp.qty.xp", "300");
        Q_Slv_WebElm.xp(SLVqProp, "cart.pdp.atc.xp");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.verifyAvailableShippingCosts("Free Shipping - Our Choice of Carrier - Tracking Included:FREE;"
        		+ "USPS Priority:$21.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$24.99");
        Q_Slv_CheckoutSteps.shippingOption("3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
    }
	

	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $25000
	 * and weight less than 450 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 10)
	public static void verifyShippingOptionsLessThan$25000AndLessThan450OzSelectUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        cart.addProductByURL("/2016-1-oz-silver-american-eagles/?action=edit","300");
        //Q_Slv_CartSteps.silver4("300");
        Q_Slv_CartSteps.gold2("100");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.verifyAvailableShippingCosts("Free Shipping - Our Choice of Carrier - Tracking Included:FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$24.99");
        Q_Slv_CheckoutSteps.shippingOption("2");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $5000
	 * and weight less than 750 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 11)
	public static void verifyShippingOptionsLessThan$5000AndLessThan750OzSelectUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        Q_Slv_CartSteps.copper1("500");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.verifyAvailableShippingCosts("Free Shipping - Our Choice of Carrier - Tracking Included:FREE;"
        		+ "USPS Priority:$21.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$29.99");
        Q_Slv_CheckoutSteps.shippingOption("3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $15000
	 * and weight less than 750 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 11)
	public static void verifyShippingOptionsLessThan$15000AndLessThan750OzSelectUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        Q_Slv_CartSteps.copper1("500");
        //driver.navigate().to(baseUrl + "/2018-silver-american-eagle-monster-boxes/");
        //Q_Slv_WebElm.xpClear(SLVqProp, "cart.pdp.qty.xp");
        //Q_Slv_WebElm.xpSend(SLVqProp, "cart.pdp.qty.xp", "1");
        //Q_Slv_WebElm.xp(SLVqProp, "cart.pdp.atc.xp");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.verifyAvailableShippingCosts("Free Shipping - Our Choice of Carrier - Tracking Included:FREE;"
        		+ "USPS Priority:$21.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$29.99");
        Q_Slv_CheckoutSteps.shippingOption("2");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order weight over than 750 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 12)
	public static void verifyShippingOptionsOver750OzSelectUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        Q_Slv_CartSteps.copper1("1000");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.verifyAvailableShippingCosts("Free Shipping - Our Choice of Carrier - Tracking Included:FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$29.99");
        Q_Slv_CheckoutSteps.shippingOption("2");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order over $25000
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 13)
	public static void verifyShippingOptionsOver$25000SelectUPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        Q_Slv_CartSteps.gold2("400");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.BW.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.verifyAvailableShippingCosts("Free Shipping - Our Choice of Carrier - Tracking Included:FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_Slv_CheckoutSteps.shippingOption("2");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options default to base/free shipping after logoff
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 14)
	public static void verifyShippingOptionsDefaultToBaseAfterLogOff()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 6);
        Q_Slv_CartSteps.silver1("2");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        //Q_Slv_CheckoutSteps.verifyAvailableShippingCosts("Base Shipping - Our Choice UPS, USPS, or FedEx:$7.99;USPS Priority:$11.99;Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_Slv_CheckoutSteps.shippingOption("3");
        Q_Slv_AccountSteps.logout();
        Q_Slv_CartSteps.silver1("2");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        //tic.verifyActiveShippingMethod("Base Shipping - Our Choice of Carrier - Tracking Included    (Est. 1-3 Business Days in Transit Once Processed & Cleared)");
        Assert.assertEquals(Q_Slv_WebElm.xpRetText(SLVqProp, "chk.reviewOrder.shippingMethod.xp"), "Base Shipping - Our Choice of Carrier");
    }
	
	/*******************************************************************
     * Description: Check for guest order 3K order No Shipping Charges
     * Author:
     * Status: Complete
     * Ticket : JMB-5295 - (SLV Order Over $3k Charged Shipping)
     ********************************************************************/
	@Test(priority = 15)
    public void guest3kOrderNoShippingCharges() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		Q_Slv_CartSteps.silver2("2");
		Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.BW.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
		Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "jmbqa4@gmail.com");
		Q_Slv_CheckoutSteps.creditCardInput(1);
		Q_Slv_CheckoutSteps.shippingAutoAddress(1);
		ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
		Q_Slv_CheckoutSteps.completeOrder("chk.finishAndPlace.id");
		ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
		Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
		Assert.assertEquals(prices.get(1).toString(),"0.0");
		Assert.assertEquals(orderPrices.get(1).toString(),"0.0");
    }
	
	/*******************************************************************
     * Description: Check for registered order 3K order No Shipping Charges
     * Author:
     * Status: Complete
     * Ticket : JMB-5295 - (SLV Order Over $3k Charged Shipping)
     ********************************************************************/
	@Test(priority = 16)
    public void reg3kOrderNoShippingCharges() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
		Q_Slv_CartSteps.silver2("2");
		Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.BW.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
		ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
		Q_Slv_CheckoutSteps.completeOrder("chk.finishAndPlace.id");
		ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
		Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices,5);
		Assert.assertEquals(prices.get(1).toString(),"0.0");
    }
	/*******************************************************************
	 * Description: Verifies that on shipping options change that Order 
     * Review matches and can go back to an option
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 17)
	public static void verifyShippingOptionChangesMatchesOrderReview()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        Q_Slv_CartSteps.silver1("8");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("mc", "331");
        //Q_Slv_CheckoutSteps.verifyActiveShippingMethod("chk.activeShippingMethod1.xp","Free Shipping - Our Choice of Carrier - Tracking Included");
        Q_Slv_WebElm.myWait(2000);
        Assert.assertEquals(Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.shipping.id").replaceAll("[^0-9?!\\.]","")), Float.valueOf("0.00"));
        Assert.assertEquals(Q_Slv_WebElm.xpRetText(SLVqProp, "chk.reviewOrder.shippingMethod.xp"), "Free Shipping - Our Choice of Carrier");
        Q_Slv_CheckoutSteps.shippingOption("2");
        //Q_Slv_CheckoutSteps.verifyActiveShippingMethod("chk.activeShippingMethod2.xp","USPS Priority - Tracking & Sig Required    (Est. 1-3 Business Days in Transit Once Processed & Cleared)");
        Q_Slv_WebElm.myWait(2000);
        Assert.assertEquals(Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.shipping.id").replaceAll("[^0-9?!\\.]","")), Float.valueOf("7.99"));
        Assert.assertEquals(Q_Slv_WebElm.xpRetText(SLVqProp, "chk.reviewOrder.shippingMethod.xp"), "USPS Priority");
        Q_Slv_CheckoutSteps.shippingOption("3");
        //Q_Slv_CheckoutSteps.verifyActiveShippingMethod("chk.activeShippingMethod3.xp","Expedited Shipping - Our Choice UPS or FedEx - Tracking & Sig Required    (Est. 1-3 Business Days in Transit Once Processed & Cleared)");
        Q_Slv_WebElm.myWait(2000);
        Assert.assertEquals(Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.shipping.id").replaceAll("[^0-9?!\\.]","")), Float.valueOf("12.99"));
        Assert.assertEquals(Q_Slv_WebElm.xpRetText(SLVqProp, "chk.reviewOrder.shippingMethod.xp"), "Expedited Shipping - Our Choice UPS or FedEx");
        Q_Slv_CheckoutSteps.shippingOption("1");
        //Q_Slv_CheckoutSteps.verifyActiveShippingMethod("chk.activeShippingMethod1.xp","Free Shipping - Our Choice of Carrier - Tracking Included");
        Q_Slv_WebElm.myWait(2000);
        Assert.assertEquals(Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.shipping.id").replaceAll("[^0-9?!\\.]","")), Float.valueOf("0.00"));
        Assert.assertEquals(Q_Slv_WebElm.xpRetText(SLVqProp, "chk.reviewOrder.shippingMethod.xp"), "Free Shipping - Our Choice of Carrier");
        Q_Slv_CheckoutSteps.shippingOption("2");
        //Q_Slv_CheckoutSteps.verifyActiveShippingMethod("chk.activeShippingMethod2.xp","USPS Priority - Tracking & Sig Required    (Est. 1-3 Business Days in Transit Once Processed & Cleared)");
        Q_Slv_WebElm.myWait(2000);
        Assert.assertEquals(Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.shipping.id").replaceAll("[^0-9?!\\.]","")), Float.valueOf("7.99"));
        Assert.assertEquals(Q_Slv_WebElm.xpRetText(SLVqProp, "chk.reviewOrder.shippingMethod.xp"), "USPS Priority");
        Q_Slv_CheckoutSteps.shippingOption("3");
        //Q_Slv_CheckoutSteps.verifyActiveShippingMethod("chk.activeShippingMethod3.xp","Expedited Shipping - Our Choice UPS or FedEx - Tracking & Sig Required    (Est. 1-3 Business Days in Transit Once Processed & Cleared)");
        Q_Slv_WebElm.myWait(2000);
        Assert.assertEquals(Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.shipping.id").replaceAll("[^0-9?!\\.]","")), Float.valueOf("12.99"));
        Assert.assertEquals(Q_Slv_WebElm.xpRetText(SLVqProp, "chk.reviewOrder.shippingMethod.xp"), "Expedited Shipping - Our Choice UPS or FedEx");
        Q_Slv_CheckoutSteps.completeOrder();
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
