package testcases.hold;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

import java.io.FileNotFoundException;

public class Q_SystemSetClear extends Init {
    static Q_AdminForm adm = new Q_AdminForm();
    static Q_CustomerForm cust = new Q_CustomerForm();
    static Q_ProductForm prod = new Q_ProductForm();
    static Q_HoldsForm hold = new Q_HoldsForm();
    static Q_OrderForm ord = new Q_OrderForm();
    static Q_Buyback bb = new Q_Buyback();
    static Q_CheckoutForm chk = new Q_CheckoutForm();
    static Controls li = new Controls();

    @BeforeClass
    public void setEnv () throws Exception {
        setItUp();
        if (driver.toString().contains("Chrome")) {
            Controls.adminLogin();
        }
        else{
            driver.quit();
        }
    }
    @BeforeMethod
    public void tcSetup() throws Exception {
        if (driver.toString().contains("Firefox")) {
            setItUp();
            Controls.adminLogin();
        }
    }

    /*********************************************************
    // * Description: Creating unpaid invoice hold then clear the hold by paying invoice via account page
    // * Author:
    // * status: Complete
    // ********************************************************/
    @Test(priority = 1, enabled = false)
    public static void createUnpaidInvoiceHold(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);

        String tcNamehold = "unpaidInvoice";
        Integer countBefore = Q_HoldsForm.holdCount(tcNamehold);
        System.out.println(hold.holdCount(tcNamehold));
        adm.adminCustomerSearch("email", "qa@jmbullion.com");
        adm.adminViewAllOrders();
//        OrderSteps.custEditRandomOrder(1, 50);
        System.out.println("Order Number: " + Q_WebElm.xpRetText(adminProps, "ord.number.xpath").substring(5, 16));
        try{
            ord.createOrderInvoice("50.56");
            Integer countAfter = Q_HoldsForm.holdCount(tcNamehold);
            Assert.assertEquals(countAfter - countBefore, 1);
        }
        catch(Throwable exp){
            System.out.println("Failed to Create Unpaid Invoice hold");
            Assert.fail();
        }
    }
    /*********************************************************
    // * Description: Clearing unpaid invoice hold via the admin a invoice page
    // * Author:
    // * status: Complete
    // ********************************************************/

    @Test(priority = 2, enabled = false)
    public static void clearUnpaidInvoiceHold(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls li = new Controls();
        Q_HoldsForm hold = new Q_HoldsForm();
        Q_OrderForm ord = new Q_OrderForm();
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        String tcNamehold = "unpaidInvoice";
        Integer countBefore = Q_HoldsForm.holdCount(tcNamehold);
        System.out.println(countBefore);
        hold.editOrderOnHold("hold.order.shipDate.end.xp", "Not Paid");
        Controls.switchWin();
        try{
            Q_WebElm.xp(adminProps, "ord.pay.invoice.xp");
//            ord.payOrderInvoicePage();
            Controls.closeTabsSwitchWinMain();

            Integer countAfter = Q_HoldsForm.holdCount(tcNamehold);
            System.out.println(countAfter);
            Assert.assertEquals(countBefore - countAfter , 1);
        }
        catch(Throwable exp){
            System.out.println("Failed to Clear Unpaid Invoice hold");
            Assert.fail();
        }
    }
    /*********************************************************
    // * Description: Clearing unpaid invoice hold by cancelling the invoice in the order form page
    // * Author:
    // * status: Complete
    // ********************************************************/
    @Test(priority = 3, enabled = false)
    public static void cancelInvoiceToClearHold(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        String tcNamehold = "unpaidInvoice";
        Integer countBefore = Q_HoldsForm.holdCount(tcNamehold);
        System.out.println("Before count " + hold.holdCount(tcNamehold));
        adm.adminCustomerSearch("email", "qa@jmbullion.com");
        adm.adminViewAllOrders();
//        ord.custEditRandomOrder(1, 50);
        String orderNum = Q_WebElm.xpRetText(adminProps, "ord.number.xpath").substring(5, 16);
        hold.editOrderOnHold("hold.order.number.end.xp", orderNum);
        ord.createOrderInvoice("19.99");

        try {
//            ord.cancelOrderInvoice();
            Controls.closeTabsSwitchWinMain();
            Integer countAfter = Q_HoldsForm.holdCount(tcNamehold);
            System.out.println("After count " + countAfter);
            Assert.assertEquals(countBefore, countAfter);
        } catch (Throwable exp) {
            System.out.println("Failed to Clear Unpaid Invoice hold");
        }
    }


    /*********************************************************
    // * Description: Setting a price check hold by upgrading shipping on an order
    // * Author:
    // * status: Complete
    // ********************************************************/
    @Test(priority = 4, enabled = false)
    public static void createPriceCheckAuto() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls li = new Controls();
        Q_HoldsForm hold = new Q_HoldsForm();
        Q_OrderForm ord = new Q_OrderForm();
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        String tcNamehold = "priceCheck";
        Integer beforeHold = Q_HoldsForm.holdCount(tcNamehold);
        System.out.println("Obtain original unpaid invoice  " + beforeHold);
        /* Create order */
//        CheckoutSteps.selectItem("silverEagle1994", "8");
        hold.holdSystem(tcNamehold);
        Integer finalCount = hold.onHoldMenuItems(tcNamehold);
        System.out.println("Final count for unpaid invoice hold " + finalCount);
        driver.navigate().refresh();
        /* Verify final count to be the same to what we  start with */
        Assert.assertEquals(finalCount - beforeHold, 1);
    }
    /*********************************************************
    // * Description: Setting sales tax issue hold and verify hold can be cleared
    // * Author:
    // * status: Complete
    // ********************************************************/

    @Test(priority = 5, enabled = false)
    public static void createSalesTaxIssueHold(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        String tcNamehold = "salesTaxIssue";
        Integer beforeHold = Q_HoldsForm.holdCount(tcNamehold);
        System.out.println("Before count " + beforeHold);
        adm.adminCustomerSearch("email", "qa1auto@jmbullion.com");
        adm.adminViewAllOrders();
//        ord.custEditRandomOrder(1, 50);
//        ord.changeItem1Quantity();
        hold.holdSystem(tcNamehold);
        Integer afterFlag = hold.onHoldMenuItems(tcNamehold);
        System.out.println("After hold count for Sales Tax Issue " + afterFlag);
        Integer finalCount = beforeHold + 1;
        Assert.assertEquals(afterFlag, finalCount);
    }
    /*********************************************************
    // * Description: Clear sales tax issue hold by clicking update tax button
    // * Author:
    // * status: Complete
    // ********************************************************/

    @Test(priority = 6, enabled = false)
    public static void salesTaxIssueClear() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        String tcNamehold = "salesTaxIssue";
        Integer beforeHold = Q_HoldsForm.holdCount(tcNamehold);
        System.out.println("Obtain original unpaid invoice  " + beforeHold);
        hold.editOrderOnHold("hold.order.shipDate.end.xp", "Not Paid");
        Controls.switchWin();
        ord.recalculateTax();
        Controls.closeTabsSwitchWinMain();
        hold.holdSystem(tcNamehold);
        Integer afterFlag = hold.onHoldMenuItems(tcNamehold);
        System.out.println("After hold count for Sales Tax Issue " + afterFlag);
        Assert.assertEquals(beforeHold - afterFlag , 1);
    }

}
