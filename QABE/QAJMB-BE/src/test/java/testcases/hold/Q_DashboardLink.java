package testcases.hold;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_DashboardLink extends Init {
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
    // *********************************************************
    // * Description: Dashboard clearing and setting order with Payment Review hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority =1)
    public static void paymentReview(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        hold.checkIfOrdersOnHold(tcName, "hold." + tcName + ".id");

    }

    // *********************************************************
    // * Description: Dashboard clearing and setting order with Decision Manager hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 2)
    public static void decisionManager() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        hold.checkIfOrdersOnHold(tcName, "hold." + tcName + ".id");

    }
    // *********************************************************
    // * Description: Dashboard clearing and setting order with Price Check hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 3)
    public static void priceCheck(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        hold.checkIfOrdersOnHold(tcName, "hold." + tcName + ".id");
    }
    // *********************************************************
    // * Description: Dashboard clearing and setting order with Unpaid Invoice hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 4)
    public static void unpaidInvoice(){
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        hold.checkIfOrdersOnHold(tcName, "hold." + tcName + ".id");
    }
    // *********************************************************
    // * Description: Dashboard clearing and setting order with Final Review hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 5)
    public static void finalReview(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        hold.checkIfOrdersOnHold(tcName, "hold." + tcName + ".id");
        
    }
    // *********************************************************
    // * Description: Dashboard clearing and setting order with Reshipment hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 6)
    public static void reshipmentHold(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        hold.checkIfOrdersOnHold(tcName, "hold." + tcName + ".id");
        
    }
    // *********************************************************
    // * Description: Dashboard clearing and setting order with Sales Tax hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 7)
    public static void salesTaxIssue(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        hold.checkIfOrdersOnHold(tcName, "hold." + tcName + ".id");
    }
    // *********************************************************
    // * Description: Dashboard clearing and setting order with Billing Unpaid hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 8)
    public static void billingUnpaid(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        hold.checkIfOrdersOnHold(tcName, "hold." + tcName + ".id");
    }
    // *********************************************************
    // * Description: Dashboard clearing and setting order with PayPal hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 9)
    public static void payPalReview(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        hold.checkIfOrdersOnHold(tcName, "hold." + tcName + ".id");
    }
    // *********************************************************
    // * Description: Dashboard clearing and setting order with PayPal hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 10)
    public static void basicHold(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        hold.checkIfOrdersOnHold(tcName, "hold." + tcName + ".id");
    }
    // *********************************************************
    // * Description: Dashboard clearing and setting order with Shipping Issues hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 11)
    public static void shippingIssue(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        hold.checkIfOrdersOnHold(tcName, "hold." + tcName + ".id");
    }
    // *********************************************************
    // * Description: Dashboard clearing and setting order with Check Issues hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 12)
    public static void checkIssue(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        hold.checkIfOrdersOnHold(tcName, "hold." + tcName + ".id");
    }
    // *********************************************************
    // * Description: Dashboard clearing and setting order with Address Verification hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 13)
    public static void addressVerification(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        hold.checkIfOrdersOnHold(tcName, "hold." + tcName + ".id");
    }
    // *********************************************************
    // * Description: Dashboard clearing and setting order with Starter Pack hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 14)
    public static void starter(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        hold.checkIfOrdersOnHold(tcName, "hold." + tcName + ".id");
    }
    // *********************************************************
    // * Description: Dashboard clearing and setting order with Security hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 15)
    public static void security(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        hold.checkIfOrdersOnHold(tcName, "hold." + tcName + ".id");
    }
    @AfterTest
    public void endReport(){

    }
    @AfterMethod
    public void tearDown() throws Exception {
//        Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
