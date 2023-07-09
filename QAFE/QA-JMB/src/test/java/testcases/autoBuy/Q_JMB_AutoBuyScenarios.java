package testcases.autoBuy;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

public class Q_JMB_AutoBuyScenarios extends Q_JMB_Init {
	Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
	Q_JMB_AutoBuyObjects autobuy = new Q_JMB_AutoBuyObjects();
	Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
	Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMddyyyy");  
	LocalDateTime currentDate, futureDate;
	int addDays;
	String frequency, startDate, endDate;
	boolean deleteUser = false;

	@BeforeMethod
    public void report() throws Exception  {
		try {
			Q_JMB_Init.setItUp();
		} catch (Throwable ex) {
			System.out.println("Issue with lauching browser: " + ex.getMessage());
		}
        	
        currentDate = LocalDateTime.now();
        startDate = dateFormat.format(currentDate);
    }
	
	/*******************************************************************
     * Description: Navigate to AUTO BUY Landing Page from Gold & Silver
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=0,enabled=false)
	public void launchAutoBuyLandingPage()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(1);
		autobuy.navigateToAutoBuyPageFrom("gold");
		autobuy.navigateToAutoBuyPageFrom("silver");
	}
	
	/*******************************************************************
     * Description: Verify that auto buy quanity is limited to 4 digits
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=1)
	public void verifyAutoBuyQuantityLimit()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 3;
		frequency = "Weekly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(1);
		autobuy.startAutoBuyFromMyAccount();
		autobuy.searchProductsAndVerifyQuanityField("silver", "10 oz SilverTowne Prospector Silver Bar (New)");
	}
	
	/*******************************************************************
     * Description: Selecting AutoBuy Gold Product and Adding to AutoBuy Cart
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=2)
	public void selectAutoBuyProductsGold()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 3;
		frequency = "Weekly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(1);
		autobuy.startAutoBuyFromMyAccount();
		autobuy.searchProductsAndAddToAutoBuyCart("gold", "1 oz Gold Bar (Varied Condition, Any Mint)", "2");
		autobuy.verifyItemInAutoBuyCart("1 oz Gold Bar (Varied Condition, Any Mint)", "2");
	}
	
	/*******************************************************************
     * Description: Selecting AutoBuy Silver Product and Adding to AutoBuy Cart
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=3)
	public void selectAutoBuyProductsSilver()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 3;
		frequency = "Weekly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(1);
		autobuy.startAutoBuyFromMyAccount();
		autobuy.searchProductsAndAddToAutoBuyCart("silver", "10 oz SilverTowne Prospector Silver Bar (New)", "20");
		autobuy.verifyItemInAutoBuyCart("10 oz SilverTowne Prospector Silver Bar (New)", "20");
	}
	
	/*******************************************************************
     * Description: Selecting AutoBuy Gold and Silver Products and Adding to AutoBuy Cart
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=4)
	public void selectAutoBuyProductsMultipleMetals()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 3;
		frequency = "Weekly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(1);
		autobuy.startAutoBuyFromMyAccount();
		autobuy.searchProductsAndAddToAutoBuyCart("silver", "10 oz SilverTowne Prospector Silver Bar (New)", "20");
		autobuy.autoBuyBackToBrowseProducts();
		autobuy.searchProductsAndAddToAutoBuyCart("gold", "1 oz Gold Bar (Varied Condition, Any Mint)", "2");
		autobuy.verifyItemInAutoBuyCart("10 oz SilverTowne Prospector Silver Bar (New)", "20");
		autobuy.verifyItemInAutoBuyCart("1 oz Gold Bar (Varied Condition, Any Mint)", "2");
	}

	/*******************************************************************
     * Description: Adding to AutoBuy Cart (from PDP Page)
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=5)
	public void selectAutoBuyProductFromProdPage()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		addDays = 3;
		frequency = "Weekly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(1);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "4");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
	}
	
	/*******************************************************************
     * Description: AutoBuy verify able to edit cart
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=6)
	public void autoBuyEditCart()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(1);
		autobuy.startAutoBuyFromMyAccount();
		autobuy.searchProductsAndAddToAutoBuyCart("gold", "1 oz Gold Bar (Varied Condition, Any Mint)", "2");
		driver.navigate().to(baseUrl);
		driver.navigate().to(baseUrl + "/my-account/autobuy-cart/");
		autobuy.editItemInAutoBuyCart("1 oz Gold Bar (Varied Condition, Any Mint)", "3");
		autobuy.verifyItemInAutoBuyCart("1 oz Gold Bar (Varied Condition, Any Mint)", "3");
	}
	
	/*******************************************************************
     * Description: AutoBuy Checkout using Weekly Frequency
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=7)
	public void autoBuyWeekly()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 14;
		frequency = "Weekly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(1);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "4");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("ach");
		autobuy.autoBuySelectFirstAccount();
		chk.completeOrder();
        chk.thankYouPage();
	}
	
	/*******************************************************************
     * Description: Verify that user can edit an existing autobuy and add an additional item
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=8)
	public void autoBuyEditAddAdditionalItem()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(1);
		autobuy.navigateToMyAccountAutoBuy();
		autobuy.editAutoBuy(1);
		autobuy.autoBuyAddMoreItems();
		autobuy.searchProductsAndAddToAutoBuyCart("silver", "10 oz SilverTowne Prospector Silver Bar (New)", "20");
		autobuy.verifyItemInAutoBuyCart("10 oz SilverTowne Prospector Silver Bar (New)", "20");
		autobuy.navigateToAutoBuyCheckout();
		chk.completeOrder();
		chk.thankYouPage();
	}
	

	/*******************************************************************
     * Description: AutoBuy Checkout using Bi-Weekly Frequency
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=9)
	public void autoBuyBIWeekly()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 30;
		frequency = "Bi-Weekly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(1);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "4");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("cc");
		autobuy.autoBuySelectCard("visa");
		chk.completeOrder();
        chk.thankYouPage();
	}
	

	/*******************************************************************
     * Description: Verify that user can edit an existing autobuy
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=10)
	public void autoBuyEditOrderChangeToACH()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(1);
		autobuy.navigateToMyAccountAutoBuy();
		autobuy.editAutoBuy(1);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("ach");
		autobuy.autoBuySelectFirstAccount();
		chk.completeOrder();
		chk.thankYouPage();
	}
	
	/*******************************************************************
     * Description: AutoBuy Checkout using Monthly Frequency
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=11)
	public void autoBuyMonthly()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 62;
		frequency = "Monthly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(1);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "4");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("ach");
		autobuy.autoBuySelectFirstAccount();
		chk.completeOrder();
        chk.thankYouPage();
	}
	
	/*******************************************************************
     * Description: Verify that user can edit an existing autobuy and change the Qty and Frequency
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=12)
	public void autoBuyEditOrderChangeQtyAndFrequency()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 3;
		frequency = "Weekly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(1);
		autobuy.navigateToMyAccountAutoBuy();
		autobuy.editAutoBuy(1);
		autobuy.cartIncQty(1,2);
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyNextRunDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		chk.completeOrder();
		chk.thankYouPage();
	}
	
	/*******************************************************************
     * Description: Verify that user can edit an existing autobuy and change the payment type and shipping option
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=13)
	public void autoBuyEditOrderChangeToCCAndUpgradeShipping()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 60;
		frequency = "Weekly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(1);
		autobuy.navigateToMyAccountAutoBuy();
		autobuy.editAutoBuy(1);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("cc");
		autobuy.autoBuySelectCard("visa");
		chk.regShippingUpgrade("option 2");
		chk.completeOrder();
		chk.thankYouPage();
	}
	
	
	/*******************************************************************
     * Description: AutoBuy Checkout Expedited Shipping over 5K and 16 oz
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=14)
	public void autoBuyShippingUpgradeExpShipOver5k()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 62;
		frequency = "Monthly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(1);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "4");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("ach");
		autobuy.autoBuySelectFirstAccount();
		//Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
		Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$12.99");
        chk.regShippingUpgrade("option 2");
		chk.completeOrder();
        chk.thankYouPage();
	}
	
	/*******************************************************************
     * Description: AutoBuy Checkout Expedited Shipping under 5K and 16 oz
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=15)
	public void autoBuyShippingUpgradeExpShipUnder5k()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 62;
		frequency = "Monthly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(1);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "1");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("ach");
		autobuy.autoBuySelectFirstAccount();
		Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
		Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
				+ "USPS Priority:$13.99;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$12.99");
        chk.regShippingUpgrade("option 3");
		chk.completeOrder();
        chk.thankYouPage();
	}
	
	/*******************************************************************
     * Description: AutoBuy Checkout with USPS Shipping Option
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=16)
	public void autoBuyShippingUpgradeUSPS()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 62;
		frequency = "Monthly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(1);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "1");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("ach");
		autobuy.autoBuySelectFirstAccount();
		Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
		Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
				+ "USPS Priority:$13.99;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$12.99");
        chk.regShippingUpgrade("option 2");
		chk.completeOrder();
        chk.thankYouPage();
	}
	
	/*******************************************************************
     * Description: AutoBuy Checkout with Local Pickup Shipping Option
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=17, enabled=false)
	public void autoBuyShippingUpgradeLocalPickup()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 62;
		frequency = "Monthly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(1);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "1");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("ach");
		autobuy.autoBuySelectFirstAccount();
		Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
		Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
				+ "USPS Priority:$7.99;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$12.99");
        chk.regShippingUpgrade("local pickup");
		chk.completeOrder();
        chk.thankYouPage();
	}
	
	/*******************************************************************
     * Description: AutoBuy Checkout using Visa Card
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=18)
	public void autoBuyCreditCardVisa()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 30;
		frequency = "Bi-Weekly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(1);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "4");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("cc");
		autobuy.autoBuySelectCard("visa");
		chk.completeOrder();
        chk.thankYouPage();
	}
	
	/*******************************************************************
     * Description: AutoBuy Checkout using Master Card
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=19)
	public void autoBuyCreditCardMasterCard()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 30;
		frequency = "Bi-Weekly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(1);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "4");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("cc");
		autobuy.autoBuySelectCard("mc");
		chk.completeOrder();
        chk.thankYouPage();
	}
	
	/*******************************************************************
     * Description: AutoBuy Checkout using AMEX card
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=20)
	public void autoBuyCreditCardAMEX()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 30;
		frequency = "Bi-Weekly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(29);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "4");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("cc");
		autobuy.autoBuySelectCard("amex");
		chk.completeOrder();
        chk.thankYouPage();
	}
	
	/*******************************************************************
     * Description: Verify that user with no auto buy orders in my account
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=21)
	public void autoBuyNoOrders()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(2);
		autobuy.navigateToMyAccountAutoBuy();
		autobuy.autoBuyVerifyNoExistingOrders();
	}
	
	/*******************************************************************
     * Description: Verify that user can edit an existing autobuy inactive
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=22)
	public void autoBuyInactivateOrder()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(1);
		autobuy.navigateToMyAccountAutoBuy();
		autobuy.makeAutoBuyInactive(1);
	}
	
	/*******************************************************************
     * Description: Verify that user can reactivate an existing autobuy
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=23)
	public void autoBuyReactivateOrder()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(1);
		autobuy.navigateToMyAccountAutoBuy();
		autobuy.makeAutoBuyReactive(1);
	}
	
	/*******************************************************************
     * Description: Verify that user can complete with entering a new credit card and shipping address
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
	 * @throws FileNotFoundException 
     ********************************************************************/
	@Test(priority=24)
	public void autoBuyOrderNoPreviousCCOrShipAddrCCPayment() throws FileNotFoundException
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 3;
		frequency = "Weekly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(52);
		autobuy.deleteUserAddresses();
        autobuy.deleteUserCreditCards();
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "4");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("cc");
        chk.creditCardForm(2);
        autobuy.autoBuyNewShippingAddress();
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
		chk.completeOrder();
        chk.thankYouPage();
        autobuy.deleteUserAddresses();
        autobuy.deleteUserCreditCards();
	}
	
	/*******************************************************************
     * Description: Verify that user can complete an ach order with no credit card on file
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
	 * @throws FileNotFoundException 
     ********************************************************************/
	@Test(priority=25)
	public void autoBuyOrderNoPreviousCCOrShipAddrACHPayment() throws FileNotFoundException
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 3;
		frequency = "Weekly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(52);
		autobuy.deleteUserAddresses();
        autobuy.deleteUserCreditCards();
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "4");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("ach");
		autobuy.autoBuySelectFirstAccount();
        autobuy.autoBuyNewShippingAddress();
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
		chk.completeOrder();
        chk.thankYouPage();
        autobuy.deleteUserAddresses();
        autobuy.deleteUserCreditCards();
	}
	
	/*******************************************************************
     * Description: Able to complete an order without entering data for end date
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
	 * @throws FileNotFoundException 
     ********************************************************************/
	@Test(priority=26)
	public void autoBuyCompleteWithNoEndDate() throws FileNotFoundException
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 3;
		frequency = "Weekly";
		acc.loginUser(1);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "4");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("cc");
		chk.completeOrder();
        chk.thankYouPage();
	}
	
	/********************************************************************
	 * Description: Verify Autobuy update product page 
	 * Author: Karthick D
 	 * Status: Complete  
	 * Ticket: JMB-8010 
	 *******************************************************************/
    @Test (priority=27, enabled=true)
    public void autoBuyUpdateProductPage(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
	    Q_JMB_WebElm.myWait(2000);
	    autobuy.startAutoBuyFromMyAccount();	
	    autobuy.autoBuySelectProductTabAndSort("all");
	    autobuy.autoBuySelectProductTabAndSort("gold");
	    autobuy.autoBuySelectProductTabAndSort("silver"); 
	    autobuy.searchAllProductCategoryAndAddToAutoBuyCart("all", "1 oz Silver Round (Varied Condition, Any Mint)", "2");
	    addDays = 30;
		frequency = "Monthly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("cc");
		autobuy.autoBuySelectCard("mc");
	    chk.completeOrder();
	    chk.thankYouPage();
	    Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps,"ab.thankYouPage.xp"),
	    		" There is an error while placing an AutoBuy order");
    }
    
	@AfterMethod
	public void tearDown() throws Exception {
		try {
			autobuy.clearAutoBuyCart();
		} catch (Throwable ex) {
			System.out.println("Issue with clearing out AutoBuy cart: " + ex.getMessage());
		}
		try {
			Q_JMB_Controls.tearDown();
		} catch (Throwable ex) {
			System.out.println("Issue with tearing down browser: " + ex.getMessage());
		}
	}
}
