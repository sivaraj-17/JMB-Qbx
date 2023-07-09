package testcases.shipping;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;
import testcases.cart.Q_PM_AddToCart;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

import java.util.ArrayList;

public class Q_PM_ShippingUpgrade extends Q_PM_Init {
	static Q_PM_TicketsObjects tic = new Q_PM_TicketsObjects();
	
    @BeforeMethod
    public void report() throws Exception {
        Q_PM_Init.setItUp();
    }
	
    /*******************************************************************
	 * Description: Verifies that on shipping options for order less than $199
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 1)
	public void verifyShippingOptionsLessThan$199SelectUPS3Day() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.silver_1_2553427("2");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Base Shipping - Our Choice of Carrier:$7.99;"
        		+ "USPS Priority:$11.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $1000
	 * and weight less than 16 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 2)
	public static void verifyShippingOptionsLessThan$1000AndLessThan16OzSelectUPS3Day() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //Q_PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.silver_1_2553427("6");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.cardSelection("Amex");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "USPS Priority:$7.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        Q_PM_CartSteps.deleteItems();
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $5000
	 * and weight less than 16 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 2)
	public static void verifyShippingOptionsLessThan$5000AndLessThan16OzSelectUPS3Day() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //Q_PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.silver_1_2553427("6");
        Q_PM_AddToCart.gold_5_gram(4);
        Q_PM_WebElm.myWait(5000);
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "USPS Priority:$7.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        Q_PM_CartSteps.deleteItems();
    }
	
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $15000
	 * and weight less than 16 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 3)
	public static void verifyShippingOptionsLessThan$15000AndLessThan16OzSelectUPS3Day() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //Q_PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(28);
        Q_PM_AddToCart.gold_5_gram(20);
        Q_PM_WebElm.myWait(5000);
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim_echeck");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 2");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        Q_PM_CartSteps.deleteItems();
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $1000
	 * and weight less than 200 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 4)
	public static void verifyShippingOptionsLessThan$1000AndLessThan200OzSelectUPS3Day() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //Q_PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.silver_1_2553427("17");
        Q_PM_WebElm.myWait(5000);
        Q_PM_CheckoutSteps.selectPaymentType("paypal_express");
        Q_PM_CheckoutSteps.payPal("test1@jmbullion.com", "2014gold");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "USPS Priority:$12.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        Q_PM_CartSteps.deleteItems();
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $5000
	 * and weight less than 200 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 5)
	public static void verifyShippingOptionsLessThan$5000AndLessThan200OzSelectUPS3Day() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //Q_PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.copper_1_2563821("150");
        Q_PM_AddToCart.gold_5_gram(12);
        Q_PM_WebElm.myWait(5000);
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "USPS Priority:$12.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        Q_PM_CartSteps.deleteItems();
    }

	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $15000
	 * and weight less than 200 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 5, enabled=false)
	public static void verifyShippingOptionsLessThan$15000AndLessThan200OzSelectUPS3Day() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //Q_PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.silver_1_2553427("150");
        Q_PM_AddToCart.gold_5_gram(12);
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "USPS Priority:$12.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        Q_PM_CartSteps.deleteItems();
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $25000
	 * and weight less than 200 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 6)
	public static void verifyShippingOptionsLessThan$25000AndLessThan200OzSelectUPS3Day() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //Q_PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.silver_1_2553427("150");
        Q_PM_AddToCart.gold_5_gram(34);
        Q_PM_WebElm.myWait(5000);
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 2");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        Q_PM_CartSteps.deleteItems();
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $5000
	 * and weight less than 300 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 7)
	public static void verifyShippingOptionsLessThan$5000AndLessThan300OzSelectUPS3Day() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //Q_PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.copper_1_2563821("250");
        Q_PM_AddToCart.gold_5_gram(5);
        Q_PM_WebElm.myWait(5000);
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "USPS Priority:$17.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$16.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        Q_PM_CartSteps.deleteItems();
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $25000
	 * and weight less than 300 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 8)
	public static void verifyShippingOptionsLessThan$25000AndLessThan300OzSelectUPS3Day() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //Q_PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.silver_1_2553427("250");
        Q_PM_AddToCart.gold_5_gram(23);
        Q_PM_WebElm.myWait(5000);
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$16.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 2");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        Q_PM_CartSteps.deleteItems();
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $15000
	 * and weight less than 450 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 9)
	public static void verifyShippingOptionsLessThan$15000AndLessThan450OzSelectUPS3Day() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //Q_PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.copper_1_2563821("350");
        //driver.navigate().to(baseUrl + "/american-silver-eagle-tubes-coin-safe-41mm.html");
        //Q_PM_WebElm.xpClear(pmQaProps, "cart.pdpQty.xp");
        //Q_PM_WebElm.xpSend(pmQaProps, "cart.pdpQty.xp", "300");
        //Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.myWait(5000);
        //Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "USPS Priority:$21.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$24.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        Q_PM_CartSteps.deleteItems();
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $25000
	 * and weight less than 450 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 10)
	public static void verifyShippingOptionsLessThan$25000AndLessThan450OzSelectUPS3Day() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //Q_PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.silver_1_2553427("300");
        Q_PM_WebElm.myWait(5000);
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$24.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 2");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        Q_PM_CartSteps.deleteItems();
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $5000
	 * and weight less than 750 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 11)
	public static void verifyShippingOptionsLessThan$5000AndLessThan750OzSelectUPS3Day() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //Q_PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.copper_1_2563821("500");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "USPS Priority:$21.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$29.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        Q_PM_CartSteps.deleteItems();
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order less than $15000
	 * and weight less than 750 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 11)
	public static void verifyShippingOptionsLessThan$15000AndLessThan750OzSelectUPS3Day() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //Q_PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.copper_1_2563821("500");
        //driver.navigate().to(baseUrl + "/2018-american-silver-eagle-monster-box.html");
        //Q_PM_WebElm.xpClear(pmQaProps, "cart.pdpQty.xp");
        //Q_PM_WebElm.xpSend(pmQaProps, "cart.pdpQty.xp", "1");
        //Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.myWait(5000);
        //Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "USPS Priority:$21.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$29.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        Q_PM_CartSteps.deleteItems();
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order over 750 oz
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 12)
	public static void verifyShippingOptionsOver750OzSelectUPS3Day() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //Q_PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.copper_1_2563821("1000");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$29.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 2");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        Q_PM_CartSteps.deleteItems();
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options for order over $25000
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 13)
	public static void verifyShippingOptionsOver$25000SelectUPS3DayAir() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //Q_PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.gold_5_gram(91);
        Q_PM_WebElm.myWait(5000);
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
        Q_PM_CheckoutSteps.selectPaymentType("bacs");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Free Shipping - Our Choice of Carrier:FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 2");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        Q_PM_CartSteps.deleteItems();
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options default to base/free shipping after logoff
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 14)
	public void verifyShippingOptionsDefaultToBaseAfterLogOff() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.silver_1_2553427("2");
        Q_PM_WebElm.myWait(5000);
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        //Q_PM_CheckoutSteps.verifyAvailableShippingMethodsAndCosts("Base Shipping - Our Choice UPS, USPS, or FedEx:$7.99;USPS Priority:$11.99;Expedited Shipping - Our Choice UPS or FedEx:$12.99");
        Q_PM_CheckoutSteps.regShippingUpgrade("option 3");
        driver.navigate().to(baseUrl);
        Q_PM_AccountSteps.accountMenu("LOGOUT");
        Q_PM_AddToCart.silver_1_2553427("2");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
        Q_PM_CheckoutSteps.bridgePage("guest", "chk.checkoutNowGuest.xp");
        tic.verifyActiveShippingMethod("Base Shipping");
    }
	
	/*******************************************************************
	 * Description: Verifies that on shipping options change that Order 
     * Review matches and can go back to an option
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6527, JMB-6584, JMB-6991
	 ********************************************************************/
	@Test(priority = 15)
	public static void verifyShippingOptionChangesMatchesOrderReview() throws Exception{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        //PM_AccountSteps.loginUser(22);
        Q_PM_AccountSteps.loginUser(6);
        Q_PM_AddToCart.silver_1_2553427("6");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.cardSelection("Amex");
        tic.verifyActiveShippingMethod("Free Shipping - Our Choice of Carrier");
        Assert.assertEquals(Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revShipping.id").replaceAll("[^0-9?!\\.]","")), Float.valueOf("0.00"));
        Q_PM_CheckoutSteps.regShippingUpgrade("option 2");
        tic.verifyActiveShippingMethod("USPS Priority");
        Assert.assertEquals(Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revShipping.id").replaceAll("[^0-9?!\\.]","")), Float.valueOf("7.99"));
        Q_PM_CheckoutSteps.regShippingUpgrade("option 3");
        tic.verifyActiveShippingMethod("Expedited Shipping - Our Choice UPS or FedEx");
        Assert.assertEquals(Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revShipping.id").replaceAll("[^0-9?!\\.]","")), Float.valueOf("12.99"));
        Q_PM_CheckoutSteps.regShippingUpgrade("option 1");
        tic.verifyActiveShippingMethod("Free Shipping - Our Choice of Carrier");
        Assert.assertEquals(Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revShipping.id").replaceAll("[^0-9?!\\.]","")), Float.valueOf("0.00"));
        Q_PM_CheckoutSteps.regShippingUpgrade("option 2");
        tic.verifyActiveShippingMethod("USPS Priority");
        Assert.assertEquals(Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revShipping.id").replaceAll("[^0-9?!\\.]","")), Float.valueOf("7.99"));
        Q_PM_CheckoutSteps.regShippingUpgrade("option 3");
        tic.verifyActiveShippingMethod("Expedited Shipping - Our Choice UPS or FedEx");
        Assert.assertEquals(Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revShipping.id").replaceAll("[^0-9?!\\.]","")), Float.valueOf("12.99"));
        Q_PM_CheckoutSteps.completeOrder();
    }
	
    @AfterMethod
    public void killDriver() throws Exception{
    	Q_PM_CartSteps.deleteItems();
    	Q_PM_Controls.tearDown();
    }
}
