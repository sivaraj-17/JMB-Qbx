package testcases.shipping;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_TodaysShipping extends Init {
	static Q_AdminForm adm = new Q_AdminForm();
	static Q_CustomerForm cust = new Q_CustomerForm();
	static Q_ProductForm prod = new Q_ProductForm();
	static Q_HoldsForm hold = new Q_HoldsForm();
	static Q_OrderForm ord = new Q_OrderForm();
	static Q_Buyback bb = new Q_Buyback();
	static Q_CheckoutForm chk = new Q_CheckoutForm();
	static Q_NewFeatures nfal = new Q_NewFeatures();
	static Q_ShippingForm ship = new Q_ShippingForm();
	static Controls li = new Controls();

	@BeforeClass
	public void tcSetup (){

	}
	@BeforeMethod
	public void report() throws Exception {
		Init.setItUp();
	}
	@BeforeTest
	public void setTest() throws Exception {
	}
	/******************************************************************
	 // * Description: Verify Today's Shipping page header listings
	 // * Jira Ticket:
	 // * Author:
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 1) // Verify count listed on button matches the count of listed orders
	public void headerListings() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		li.adminLogin();
		Q_ShippingForm.menuElement("ship.shipping.xp");
		Q_ShippingForm.subMenuElement("ship.today.xp");

		Q_ShippingForm.tracking("ship.awaitingTracking.xp");
		System.out.println(Q_WebElm.xpCountTableRows(adminProps, "ship.pending.orders.count.xp"));
		System.out.println("\n ");
	}

	/******************************************************************
	 // * Description: Verify count for bad orders
	 // * Jira Ticket:
	 // * Author:
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 2)
	   public void badAddress() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		headerListings();
		String baButton = Q_ShippingForm.withBadAddress("ship.badAddress.xp").replaceAll("[^0-9?!\\.]","");
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		li.switchWin();
		System.out.println("Count obtained from the bad address report page: " + Q_ShippingForm.badAddressCount());
		String baReport = Q_ShippingForm.badAddressCount().substring(19).replaceAll("[^0-9?!\\.]","");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		Assert.assertEquals(baButton, baReport);
		System.out.println("The count from the Today's shipping matches the count on the Bad Address Report");
		try{


		}
		catch (Throwable ex){
			System.out.println("The count did not match");
			Assert.fail("The count did not match");
		}
	}
	/******************************************************************
	 // * Description: Verify Pre Draw and Post Draw balance
	 // * Jira Ticket:
	 // * Author:
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 3) // Verify Pre Draw and Post Draw balance
	public void drawBalance() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		headerListings();
		Q_ShippingForm.viewBlalanceSummary("ship.blalanceSummary.xp");
		Integer count = Controls.countTableRowsXpath(adminProps, "ship.prodCount.xp");
		System.out.println("Number of products in this table " + count /2 +"\n");
		for (int i = 1; i <= count; i++) {
			if (i % 2 > 0) {
//				System.out.println("What is i atm " + i);
				String productName = Q_WebElm.xpRetText(adminProps, "ship.summaryBeg.xp", i , "ship.prodName.xp");
//				System.out.println("Product Name " + productName);
				String summaryDemand = Q_WebElm.xpRetText(adminProps, "ship.summaryBeg.xp", i , "ship.summaryDemmand.xp");
//				System.out.println("Demand " + summaryDemand);
				String summarySupply = Q_WebElm.xpRetText(adminProps, "ship.summaryBeg.xp", i , "ship.summarySupply.xp");
//				System.out.println("Supply  " + summarySupply);
				String summaryRepoDraw = Q_WebElm.xpRetText(adminProps, "ship.summaryBeg.xp", i , "ship.SummRepoDraw.xp");
//				System.out.println("Rep Draw " + summaryRepoDraw);
				String summaryPreDrawSt = Q_WebElm.xpRetText(adminProps, "ship.summaryBeg.xp", i , "ship.SummPreDrawBalance.xp");
//				System.out.println("Pre Draw String " + summaryPreDrawSt);
				Integer summaryPreDraw = Integer.parseInt(summaryPreDrawSt);
//				System.out.println("Pre Draw  " + summaryPreDraw);
				String summaryPostDrawSt = Q_WebElm.xpRetText(adminProps, "ship.summaryBeg.xp", i , "ship.SummPostDrawBlance.xp");
//				System.out.println("Post Draw String  " + summaryPostDrawSt);
				Integer summaryPostDraw = Integer.parseInt(summaryPostDrawSt);
//				System.out.println("Post Draw " + summaryPostDraw);
				String summaryOrders = Q_WebElm.xpRetText(adminProps, "ship.summaryBeg.xp", i , "ship.SummOreders.xp");
//				System.out.println("Orders " + summaryOrders);
				Integer calculatedPreDraw = Integer.parseInt(summarySupply) - Integer.parseInt(summaryDemand);
//				System.out.println("Calculated Pre Draw " + calculatedPreDraw);
				Integer calculatedPostDraw =  Integer.parseInt(summaryPreDrawSt) + Integer.parseInt(summaryRepoDraw);
//				System.out.println("Calculated post Draw " + calculatedPostDraw);
				try {
					Assert.assertEquals(calculatedPreDraw, summaryPreDraw);
//					System.out.println("Verified Pre Draw Balance for " + productName +"\t Calculated Value : " + calculatedPreDraw + "\t " + "Posted Value: " + summaryPreDraw);

				} catch (Throwable ex) {
					System.out.println("Calculated Pre Draw Balance did not match posted Pre Draw Balance");
					Assert.fail("Calculated Pre Draw Balance did not match posted Pre Draw Balance");
				}

				try {
					Assert.assertEquals(calculatedPostDraw, summaryPostDraw);
					System.out.println("Verified Post Draw Balance for " + productName + "\t Calculated Value : " + calculatedPostDraw + "\t " + "Posted Value: " + summaryPostDraw);

				} catch (Throwable ex) {
					System.out.println("Calculated Post Draw Balance did not match posted Post Draw Balance");
					Assert.fail("Calculated Post Draw Balance did not match posted Post Draw Balance");
				}
			}
		}
	}
	/******************************************************************
	 // * Description: Verify user can create wire for a Provident supplier
	 // * Jira Ticket:
	 // * Author:
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 4) //
	public void viewOnHoldOrders() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		headerListings();
		Q_ShippingForm.ordersOnHold("ship.onHold.xp");
		Integer onHoldButton = Integer.parseInt(Q_ShippingForm.onHoldCount("ship.onHold.xp"));
		Integer orderCount = Controls.countTableRowsXpath(adminProps, "ship.onHoldRowCount.xp");

		try {
			Assert.assertEquals(onHoldButton, orderCount);
			System.out.println("Verified on Hold Orders listed on button matches the actual orders displayed ");

		} catch (Throwable ex) {
			System.out.println("Actual orders on hold count did not match number listed on button");
			Assert.fail("Actual orders on hold count did not match number listed on button");
		}
	}
	/******************************************************************
	 // * Description: Verify count listed on button matches the count of listed orders
	 // * Jira Ticket:
	 // * Author:
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 5)
	public void viewOrdersError() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		headerListings();
		Q_ShippingForm.viewOrdersError("ship.orderErrors.xp");
		Integer orderErrorBtn = Integer.parseInt(Q_ShippingForm.viewOrdersError("ship.orderErrors.xp"));
		System.out.println("Count listed on order errors button: " + orderErrorBtn);
		Q_WebElm.xp(adminProps, "ship.orderErrors.xp");
		Integer orderCount = Controls.countTableRowsXpath(adminProps, "ship.orderErrorRowCount.xp");
		System.out.println("Count obtained from order listings page : " + orderCount);
		try {
			Assert.assertEquals(orderErrorBtn, orderCount);
			System.out.println("Verified Orders Errors listed on button matches the actual orders displayed ");

		} catch (Throwable ex) {
			System.out.println("Actual orders error count did not match number listed on button");
			Assert.fail("Actual orders error count did not match number listed on button");
		}
	}
	
	/********************************************************
    // * Description: Verify Shipping job menu without Permission 30 (Better Visibility on Shipping Batch Issues)
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 7573
	 *********************************************************/
    @Test(priority = 6, enabled = true)
    public void verifyShippingJobsWithoutPermission30() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName); 
		Controls.adminLogin();
		adm.navigateToQaTestGroupManagePermission();
		adm.removePermission("Ship Orders (API)");
		Q_WebElm.myWait(5000);
		driver.get(adminUrl);
		Q_WebElm.myWait(2000);
		adm.verifyMenuAvailability("adm.menuShippingJobs.xp",false);
	}
    
	/********************************************************
    // * Description: Verify Shipping job menu with Permission 30 (Better Visibility on Shipping Batch Issues)
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 7573
	 *********************************************************/
    @Test(priority = 7, enabled = true)
    public void verifyShippingJobsWithPermission30() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName); 
		Controls.adminLogin();
		adm.navigateToQaTestGroupManagePermission();
		adm.grantPermission("Ship Orders (API)");
		Q_WebElm.myWait(5000);
		driver.get(adminUrl);
		Q_WebElm.myWait(2000);
		adm.verifyMenuAvailability("adm.menuShippingJobs.xp",true);
		Q_ShippingForm.menuElement("adm.menuShipping.xp");
		adm.subMenuElement("adm.menuShippingJobs.xp");
		ship.addNewShippingJob("3","JM Bullion");
		ship.verifyShippingJobList("3","Jmbullion");
	}
	@AfterTest
	public void endReport(){
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Controls.tearDown();
	}
	@AfterClass
	public void exitClass(){
		System.out.println("After Class");
	}

}
