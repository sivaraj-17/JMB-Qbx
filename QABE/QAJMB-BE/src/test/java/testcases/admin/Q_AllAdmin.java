package testcases.admin;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_AllAdmin extends Init{
    static Q_AdminForm adm = new Q_AdminForm();
    static Q_CustomerForm cust = new Q_CustomerForm();
    static Q_ProductForm prod = new Q_ProductForm();
    static Q_HoldsForm hold = new Q_HoldsForm();
    static Q_OrderForm ord = new Q_OrderForm();
    static Q_Buyback bb = new Q_Buyback();
    static Q_CheckoutForm chk = new Q_CheckoutForm();
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
     // * Description: Verify when 2 or more users update transactions on Dallas inventory page inventory calculated correctly
     // * Param: String
     // * Jira Ticket: JMB-6722
     // * Author: Hisham Aridi
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 1, enabled = true)
    public static void ImproperCalculationDallasInventory_JMB6722(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        li.testStarted(tcName);
        li.adminLogin();
        adm.dallasInventoryJMB7622();
    }
    /*********************************************************************
     // * Description: Verify if NR warning/error is being generated when slider is edited
     // * and saved without an image.
     // * Author: Asfi Khaliq
     // * Status: Complete
     // * Ticket : JMB-6330
     //********************************************************************/
    @Test(priority = 2, enabled = true)
    public void noSuchFileOrDirectoryInGetImageSize() {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        String title= "Test3 JMB-6330";
        driver.navigate().to(adminUrl + "/settings-slider-form.php");
        adm.enterTitle(title);
        Assert.assertFalse(Q_WebElm.idDisplayed(adminProps, "settings.addSlider.errorField.id"));
        System.out.println("No error was generated");
        Q_WebElm.myWait(4000);
        /*Navigate to manage Slider page to verify the above added Slider*/
        driver.navigate().to(adminUrl + "/sliders.php");
        adm.editSlider(title);
        Controls.switchTab(1);
        /*Edit Display Order of Slider*/
        adm.editDisplayOrder("270");
        Assert.assertFalse(Q_WebElm.idDisplayed(adminProps, "settings.addSlider.errorField.id"));
        System.out.println("No error was generated");
    }

    /******************************************************************
     // * Description: Verify Partial Arrival & Arrived In Full buttons
     // * are display for user with permission 47
     // * Author: Tamilselvan
     // * Status: Completed
     // * Jira Ticket: JMB6138
     *******************************************************************/
    @Test(priority = 3, enabled = true)
    public static void receiptButtonsPermission47on() {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.selectAdminUser();
        adm.grantPermission("Mark Receipts Arrvied");
        adm.addPaidReceipt();
        adm.verifyReceiptButton();
        adm.listPaidRepoReceipt();
    }

    /******************************************************************
     // * Description: Verify Partial Arrival & Arrived In Full buttons are
     // * not displayed when user does not have permission 47
     // * Author: Tamilselvan
     // * Status: Completed
     // * Jira Ticket: JMB6138
     *******************************************************************/
    @Test(priority = 4, enabled = true)
    public static void receiptButtonsPermission47off() {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.selectAdminUser();
        adm.removePermission("Mark Receipts Arrvied");
        adm.verifyReceiptButtonWithoutPermission();
        adm.verifyRepoReceiptButtonWithoutPermission();
        adm.selectAdminUser();
        adm.grantPermission("Mark Receipts Arrvied");
    }

    /******************************************************************
     * Description: Verify able to search for customer by email in
     * Find/Create Customer section of Admin page
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6580
     * Status: Complete
     //*******************************************************************/
    @Test (priority = 5, enabled = true)
    public static void findCustomerByEmail() {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.findCustomerByEmail("qa+1jmb@jmbullion.com");
    }
    
    /******************************************************************
     * Description: Verify able to search for customer by phone in
     * Find/Create Customer section of Admin page
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6580
     * Status: Complete
     //*******************************************************************/
    @Test (priority = 6, enabled = true)
    public static void findCustomerByPhone() {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.findCustomerByPhone("9619611234");
    }
    
    /********************************************************************
	 // * Description: 	Manual spot for On button in admin settings page
	 // * Author: Vignesh
	 // * Param : NA
	 // * Jira Ticket: JMB-7879
	 // * Status: Complete
	 // * IMPORTANT DUE TO WARNINGS THAT TURN ON AND OFF MANAUL SPOT PRICES 
	 // * THAT NOTIFIES THE DEVS DO NOT RUN TEST
	 //*******************************************************************/
	@Test(priority = 7, enabled = false)
	public void verifyManualSpotOnButton() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		driver.navigate().to(adminUrl + "/settings-spot.php");
		adm.verifyManualSpotSaveButton("On", "adm.manualSpotOn.xp");
	}
	
	/********************************************************************
	 // * Description: 	Manual spot save off button in admin settings page
	 // * Author: Vignesh
	 // * Param : NA
	 // * Jira Ticket: JMB-7879
	 // * Status: Complete
	 // * IMPORTANT DUE TO WARNINGS THAT TURN ON AND OFF MANAUL SPOT PRICES 
	 // * THAT NOTIFIES THE DEVS DO NOT RUN TEST
	 //*******************************************************************/
	@Test(priority = 8, enabled = false)
	public void verifyManualSpotOffButton() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		driver.navigate().to(adminUrl + "/settings-spot.php");
		adm.verifyManualSpotSaveButton("Off", "adm.manualSpotOff.xp");
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
