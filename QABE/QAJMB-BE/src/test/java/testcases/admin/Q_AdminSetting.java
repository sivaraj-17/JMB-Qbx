package testcases.admin;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_AdminSetting extends Init {
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
     * Description: Verify Auto Clear in the admin page clears
     * Author: Mobin
     * Status:Completed
     * Ticket: JMB-6017
     *******************************************************************/
    @Test(priority = 1, enabled = true)
    public void verifyAutoClearbutton() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("settings");
        Q_WebElm.xp(adminProps, "adm.config.Shopping.xp");
        Q_WebElm.xp(adminProps, "adm.autoClearRadio.OFF.xp");
        Q_WebElm.myWait(1000);
        Q_WebElm.xp(adminProps, "adm.saveConfigSettings.xp");
        Q_WebElm.myWait(1000);
        li.newTabLaunch("/ato/clearOrders.php");
        li.newTabLaunch("/ato/clearOrders.php");
        li.newTabLaunch("/ato/clearOrders.php");
        adm.testAutoClearFunctionalityOFF();
        adm.testAutoClearFunctionalityON();
    }
    
    /******************************************************************
     * Description: Verify oversold hold permissions
     * Author: Mobin
     * Status:Completed
     * Ticket: JMB-6112
     *******************************************************************/
    @Test(priority =2)
    public static void oversold_JMB6112() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.selectAdminUser();
        adm.removePermission("Post Shipment Hold");
        ord.ordersMenu("list");
        ord.editOrderStatus("paid");
        Assert.assertFalse(ord.isHoldChecked("ord.hold.oversold.cn"));
        adm.selectAdminUser();
        adm.grantPermission("Post Shipment Hold");
        ord.ordersMenu("list");
        ord.editOrderStatus("paid");
//        ord.editOrder(25);
        Assert.assertTrue(ord.isHoldChecked("ord.hold.oversold.cn"));

    }
    /******************************************************************
     // * Description: Verify status options shipped and completed if user does not have Move Order to Shipped/Completed permission
     // * Param: String
     // * Jira Ticket: JMB-6209
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3, enabled = true)
    public static void permissionToMarkOrdersCompleted(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.selectAdminUser();
        adm.removePermission("Move Order to Shipped/Completed");
        ord.ordersMenu("list");
        ord.editOrderStatus("paid");
        ord.shipPermissionDenied(4);
        adm.selectAdminUser();
        adm.grantPermission("Move Order to Shipped/Completed");
        ord.ordersMenu("list");
        ord.editOrderStatus("pending");
        ord.changeOrderStatus("paid");
        ord.shipPermissionDenied(5);
        ord.changeOrderStatus("ship");
        ord.shipPermissionDenied(6);
        ord.changeOrderStatus("completed");
        ord.changeOrderStatus("paid");
        ord.changeOrderStatus("pending");
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
