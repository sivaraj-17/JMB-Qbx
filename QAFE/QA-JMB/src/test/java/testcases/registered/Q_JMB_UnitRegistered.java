package testcases.registered;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;


public class Q_JMB_UnitRegistered extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
    static Q_JMB_CategoryObjects cat = new Q_JMB_CategoryObjects();

    @BeforeClass
    public void tcSetup (){
    }
    @BeforeMethod
    public void report() throws Exception {
        Q_JMB_Init.setItUp();
    }
    @BeforeTest
    public void setTest() throws Exception {
    }


    @Test (priority = 13)
    public void largeOrder() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(22);
        chk.selectItem("3 Gram Chinese Gold Panda",3);
        chk.selectItem("1 oz US Quarter Copper", 10);
        chk.selectItem("10 Gram Perth Mint Gold Bar", 5);
        chk.selectItem("1 oz American Gold Eagle Coin", 2);
        chk.selectItem("2.5 Gram Valcambi Gold Bar", 3);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 4);
        chk.selectItem("100 oz Geiger Security",2);
        chk.selectItem("Peace Silver Dollar",2);
        chk.selectItem("1 oz American Platinum Eagle Coin",2);
        chk.selectItem("walking-liberty",10);
        chk.selectItem("1 oz Canadian Silver Maple Leaf Coin",2);
        chk.selectItem("2019 Canadian Silver Maple Leaf Tube (25 Coins, BU)",1);
        chk.selectItem("2019 Canadian Silver Maple Leaf Monster Box (500 Coins, BU)",1);
        chk.selectItem("10 oz gold bar",2);
        chk.selectItem("1 oz pamp suisse platinum bar",2);
        chk.selectItem("10 oz pamp suisse platinum bar", 2);
        cart.selectPaymentType("wire");
        cart.selectcheckoutBtn("top");
        chk.editShipping("chk.shipping.validate.id");
    }
}
