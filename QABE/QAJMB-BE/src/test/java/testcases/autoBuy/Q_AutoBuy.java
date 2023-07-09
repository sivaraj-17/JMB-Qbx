package testcases.autoBuy;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_AutoBuy extends Init {
	static Q_AdminForm adm = new Q_AdminForm();
	static Q_CustomerForm cust = new Q_CustomerForm();
	static Q_ProductForm prod = new Q_ProductForm();
	static Q_HoldsForm hold = new Q_HoldsForm();
	static Q_OrderForm ord = new Q_OrderForm();
	static Q_Buyback bb = new Q_Buyback();
	static Q_CheckoutForm chk = new Q_CheckoutForm();
	static Q_Tickets tic = new Q_Tickets();
	static Controls li = new Controls();
	LocalDateTime currentDate, pastDate;
	

	@BeforeClass
	public void tcSetup (){

	}
	@BeforeMethod
	public void report() throws Exception {
		Init.setItUp();
		currentDate = LocalDateTime.now();
	}
	@BeforeTest
	public void setTest() throws Exception {
	}
	
	/******************************************************************
     * Description: Verify admin site can open auto buy order and edit like other orders
     * Jira Ticket: NA
     * Status: Complete
     *******************************************************************/
	@Test(priority = 1)
	public void autoBuyVerifyAdminOrderStatus(){
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Controls.testStarted(tcName);
       li.adminLogin();
       adm.adminCustomerSearch("email", "qa2auto@jmbullion.com");
       adm.adminViewAllOrders();
       ord.adminEditAutoBuy(1);
       ord.verifyOrderType("Autobuy");
	}
   
	/******************************************************************
   	 * Description: Verify able to open auto buy on admin site through customer view and verify the details are displayed
   	 * Jira Ticket: NA
   	 * Status: Complete
    *******************************************************************/
	@Test(priority = 2)
   	public void autoBuyVerifyAdminDetails(){
      String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
      Controls.testStarted(tcName);
      li.adminLogin();
      adm.adminCustomerSearch("email", "qa2auto@jmbullion.com");
      adm.adminViewAllOrders();
      ord.adminOpenAutoBuyDetials(1);
      ord.verifyAutoBuyDetails();
   	}
  
   	/******************************************************************
     * Description: Verify able to switch and edit an existing Auto Buy
  	 * Jira Ticket: NA
  	 * Status: Complete
  	 *******************************************************************/
	@Test(priority = 3)
	public void autoBuySwitchToOrder(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		li.adminLogin();
		adm.adminCustomerSearch("email", "qa2auto@jmbullion.com");
		adm.adminViewAllOrders();
		ord.adminSwitchToAutoBuy(1);
	}
	
	/******************************************************************
     * Description: Verify able to view and search the Auto Buy Margin Report 
  	 * Jira Ticket: NA
  	 * Status: Complete
  	 *******************************************************************/
	@Test(priority = 4)
	public void autoBuyVerifyMarginReport(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMddyyyy");  
		String fromDate, toDate;
		int subDays;
		fromDate = dateFormat.format(currentDate);
		subDays = 30;
		pastDate = currentDate.minusDays(subDays);  
		fromDate = dateFormat.format(pastDate);
		toDate = dateFormat.format(currentDate);
		Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/reports-margin.php");
		ord.autoBuyMarginReportDateSearch(fromDate, toDate);
		ord.autoBuyMarginReportShowResults("25");
		ord.autoBuyMarginReportShowResults("50");
		ord.autoBuyMarginReportShowResults("100");
		ord.autoBuyMarginReportShowResults("200");
		ord.autoBuyMarginReportShowResults("500");
		ord.autoBuyMarginReportShowResults("All");
		ord.autoBuyMarginReportSearchByOrder(1);
	}
	/******************************************************************
     * Description: Verify able to view and search the Auto Buy Sales Stats Report 
  	 * Jira Ticket: NA
  	 * Status: Complete
  	 *******************************************************************/
	@Test(priority = 5)
	public void autoBuyVerifyStatsReport(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		String fromDate, toDate;
		int subDays;
		fromDate = dateFormat.format(currentDate);
		subDays = 30;
		pastDate = currentDate.minusDays(subDays);  
		fromDate = dateFormat.format(pastDate);
		toDate = dateFormat.format(currentDate);
		Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/autoBuyStats.php");
		ord.autoBuySalesReportDateSearch(fromDate, toDate);
		ord.autoBuySalesReportShowResults("10");
		ord.autoBuySalesReportShowResults("25");
		ord.autoBuySalesReportShowResults("50");
		ord.autoBuySalesReportShowResults("100");
		ord.autoBuySalesReportSearchByProductName("1 oz Gold Bar (Varied Condition, .999+)");
	}
	
	/******************************************************************
     * Description: Verify able to view and search the Auto Buy Sales Stats Report 
  	 * Jira Ticket: NA
  	 * Status: Complete
  	 *******************************************************************/
	@Test(priority = 6)
	public void autoBuyVerifySalesStatsReport(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		String fromDate, toDate;
		int subDays;
		fromDate = dateFormat.format(currentDate);
		subDays = 30;
		pastDate = currentDate.minusDays(subDays);  
		fromDate = dateFormat.format(pastDate);
		toDate = dateFormat.format(currentDate);
		Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/reports-stats-autobuy-products.php");
		ord.autoBuySalesStatsReportDateSearch(fromDate, toDate);
		ord.autoBuySalesStatsReportShowResults("25");
		ord.autoBuySalesStatsReportShowResults("50");
		ord.autoBuySalesStatsReportShowResults("100");
		ord.autoBuySalesStatsReportShowResults("200");
		ord.autoBuySalesStatsReportShowResults("500");
		ord.autoBuySalesStatsReportShowResults("All");
		ord.autoBuySalesStatsReportSearchByProductName("1 oz Gold Bar (Varied Condition,)");
	}
	
	/******************************************************************
     * Description: Verify able to view and search the Auto Buy Transactions Missing Report 
  	 * Jira Ticket: NA
  	 * Status: Complete
  	 *******************************************************************/
	@Test(priority = 7)
	public void autoBuyVerifyTransactionsMissingInventoryReport(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		String fromDate, toDate;
		int subDays;
		fromDate = dateFormat.format(currentDate);
		subDays = 30;
		pastDate = currentDate.minusDays(subDays);  
		fromDate = dateFormat.format(pastDate);
		toDate = dateFormat.format(currentDate);
		Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/reports-autobuy-failed-transactions-missing-inventory.php");
		ord.autoBuyFailedTransactionsMissingInventoryReportDetailedSearch(fromDate, toDate,"jcooper@jmbullion.com", "1 oz American Gold Eagle Coin (Random Year, BU)", "ACH");
		ord.autoBuyFailedTransactionsMissingInventoryReportDateSearch(fromDate, toDate);
		ord.autoBuyFailedTransactionsMissingInventoryReportShowResults("25");
		ord.autoBuyFailedTransactionsMissingInventoryReportShowResults("50");
		ord.autoBuyFailedTransactionsMissingInventoryReportShowResults("100");
		ord.autoBuyFailedTransactionsMissingInventoryReportShowResults("200");
		ord.autoBuyFailedTransactionsMissingInventoryReportShowResults("500");
		ord.autoBuyFailedTransactionsMissingInventoryReportShowResults("All");
		ord.autoBuyFailedTransactionsMissingInventoryReportSearchByProductName("1 oz American Gold Eagle Coin (Random Year, BU)");
	}
	
	/******************************************************************
     * Description: Verify able to view and search the Auto Buy Margin Report 
  	 * Jira Ticket: NA
  	 * Status: Complete
  	 *******************************************************************/
	@Test(priority = 8)
	public void autoBuyVerifySetupsReport(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		String fromDate, toDate;
		int subDays;
		fromDate = dateFormat.format(currentDate);
		subDays = 90;
		pastDate = currentDate.minusDays(subDays);  
		fromDate = dateFormat.format(pastDate);
		toDate = dateFormat.format(currentDate);
		Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/autobuy-setup.php");
		ord.autoBuySetupReportVerifyOptionsRequiredSearch();
		ord.autoBuySetupReportDetailedSearch("Last Order Date", fromDate, toDate, "", "", "", "", "", "");
		ord.autoBuySetupReportDetailedSearch("", "", "", "AB-1", "", "", "", "", "");
		ord.autoBuySetupReportDetailedSearch("", "", "", "", "qa2auto@jmbullion.com", "", "", "", "");
		ord.autoBuySetupReportDetailedSearch("", "", "", "", "", "", "Weekly", "", "");
		ord.autoBuySetupReportDetailedSearch("", "", "", "", "", "", "", "ACH", "");
		ord.autoBuySetupReportDetailedSearch("", "", "", "", "", "", "", "", "Active");
		ord.autoBuySetupReportDetailedSearch("", "", "", "", "", "1 oz Gold Bar (Varied Condition,", "", "", "");
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
