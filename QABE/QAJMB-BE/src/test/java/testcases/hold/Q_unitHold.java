package testcases.hold;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_unitHold extends Init {
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
    @Test(priority =1)
    public static void paymentReview() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Link Count : " + hold.onHoldMenuItems(tcName));
        System.out.println("Review page Countt : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=payment" );
    }

}
