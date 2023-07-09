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

public class Q_JMB_AutoBuyNegativeScenarios extends Q_JMB_Init {
	Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
	Q_JMB_AutoBuyObjects autobuy = new Q_JMB_AutoBuyObjects();
	Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
	Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMddyyyy");  
	LocalDateTime currentDate, futureDate;
	int addDays;
	String frequency, startDate, endDate;

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
     * Description: AutoBuy Checkout with ACH requires a bank account
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=1)
	public void autoBuyAchBankAccountRequired()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 62;
		frequency = "Monthly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(25);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "4");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("ach");
		chk.completeOrder();
		Assert.assertTrue(Q_JMB_Controls.checkAndGetAlertText().contains("Please link bank account."), 
	    		   "Required bank account alert did not display.");
	}
	
	/*******************************************************************
     * Description: AutoBuy Checkout with CC requires a credit card
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=2)
	public void autoBuyCCCardRequired()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		addDays = 62;
		frequency = "Monthly";
		futureDate = currentDate.plusDays(addDays);  
		endDate = dateFormat.format(futureDate);
		acc.loginUser(24);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "4");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(endDate);
		autobuy.navigateToAutoBuyCheckout();
		autobuy.autoBuyCheckoutPaymentMethod("cc");
		chk.completeOrder();
		Assert.assertTrue(Q_JMB_Controls.checkAndGetAlertText().contains("Please enter your credit card number."), 
	    		   "Required credit card alert did not display.");
	}
	
	/*******************************************************************
     * Description: Verify that user cannot delete credit card with existing autobuy orders
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=3)
	public void autoBuyVerifyCannotDeleteCreditCardWithActiveOrders()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(1);
		acc.myAccount("payments");
		autobuy.autoBuyVerifyCannotDeleteCreditCard();
	}
	
	/*******************************************************************
     * Description: Verify that user cannot delete bank accounts with existing autobuy orders
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=4)
	public void autoBuyVerifyCannotDeleteBankAccountWithActiveOrders()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(1);
		acc.myAccount("payments");
		autobuy.autoBuyVerifyCannotDeleteBankAccount();
	}
	
	/*******************************************************************
     * Description: Verify that user cannot delete or edit address with existing autobuy orders
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=5)
	public void autoBuyVerifyCannotDeleteOrEditAddressWithActiveOrders()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(29);
		acc.myAccount("addresses");
		autobuy.autoBuyVerifyCannotEditBillingAddress(1);
		driver.navigate().to(baseUrl);
		acc.myAccount("addresses");
		autobuy.autoBuyVerifyCannotDeleteBillingAddress(1);
	}
	
	/*******************************************************************
     * Description: Unable to add a non autobuy product to the autobuy cart
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
	 * @throws FileNotFoundException 
     ********************************************************************/
	@Test(priority=6)
	public void autoBuyVerifyNonAutoBuyProduct() throws FileNotFoundException
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(1);
		autobuy.verifyNonAutoBuyFromProductPage("/2016-american-silver-eagle/");
	}
	
	/*******************************************************************
     * Description: Verify when putting in a past date in start date throws an error
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=7)
	public void autoBuyVerifyFreqStartDatePastDateError() throws FileNotFoundException
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		frequency = "Weekly";
		acc.loginUser(1);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "4");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(dateFormat.format(currentDate.minusDays(14)));
		autobuy.setAutoBuyFrequencyEndDate(dateFormat.format(currentDate));
		autobuy.navigateToAutoBuyCheckout();
		Assert.assertTrue(Q_JMB_Controls.checkAndGetAlertText().contains("Start Date must be greater than or equal to Current date"));
		System.out.println("[PASS] Start Date cannot be less than current date.");
	}
	
	/*******************************************************************
     * Description: Verify when putting in a past date in start date throws an error
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=8)
	public void autoBuyVerifyFreqEndDatePastDateError() throws FileNotFoundException
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		frequency = "Weekly";
		acc.loginUser(1);
		autobuy.setUpAutoBuyFromProductPage("/1-oz-gold-bar/", "4");
		autobuy.setAutoBuyFrequencySelectOption(frequency);
		autobuy.setAutoBuyFrequencyStartDate(startDate);
		autobuy.setAutoBuyFrequencyEndDate(dateFormat.format(currentDate.minusDays(7)));
		autobuy.navigateToAutoBuyCheckout();
		Assert.assertTrue(Q_JMB_Controls.checkAndGetAlertText().contains("End date must be greater than Start date"));
		System.out.println("[PASS] End date cannot be less than Start date.");
	}
	

	/*******************************************************************
     * Description: AutoBuy verification that registered user is required
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=9)
	public void autoBuyGuestVerification()
	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		driver.navigate().to(baseUrl + "/autobuy/");
		autobuy.autoBuyStartAutoBuy();
		autobuy.autoBuyVerifyRequiredLoginToSetup();
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
