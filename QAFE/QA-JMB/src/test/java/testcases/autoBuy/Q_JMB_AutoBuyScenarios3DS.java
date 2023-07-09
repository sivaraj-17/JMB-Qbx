package testcases.autoBuy;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Q_JMB_AutoBuyScenarios3DS extends Q_JMB_Init {
    Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
    Q_JMB_CategoryObjects cat = new Q_JMB_CategoryObjects();
    Q_JMB_AdminObjects admin = new Q_JMB_AdminObjects();
    Q_JMB_Controls cont = new Q_JMB_Controls();
    Q_JMB_AutoBuyObjects autobuy = new Q_JMB_AutoBuyObjects();
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMddyyyy");  
	LocalDateTime currentDate, futureDate;
	int addDays;
	String frequency, startDate, endDate;

    @BeforeClass
    public void tcSetup (){
    }
    @BeforeMethod
    public void report() throws Exception {
        Q_JMB_Init.setItUp();
        currentDate = LocalDateTime.now();
        startDate = dateFormat.format(currentDate);
    }
    @BeforeTest
    public void setTest() throws Exception {
    }

    /*******************************************************************
    // * Description: Turns 3DS on
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1,enabled=true)
    public void turn3DSOn() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_Controls.adminLogin();
        admin.adminMenu("settings");
        Q_JMB_WebElm.xp(jmbProps, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("on");
        Q_JMB_WebElm.myWait(1000);
    }
    
    /*******************************************************************
     * Description: AutoBuy Checkout using Visa Card
     * Author: Paul Patterson
     * Status: In Progress
	 * Ticket: 
     ********************************************************************/
	@Test(priority=2)
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
	@Test(priority=3)
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
	@Test(priority=4)
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
    // * Description: Turns 3DS off
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 10,enabled=true)
    public void turn3DSOff() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_Controls.adminLogin();
        admin.adminMenu("settings");
        Q_JMB_WebElm.xp(jmbProps, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("off");
        Q_JMB_WebElm.myWait(1000);
    }
    
    @AfterTest
    public void endReport(){
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
    
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
