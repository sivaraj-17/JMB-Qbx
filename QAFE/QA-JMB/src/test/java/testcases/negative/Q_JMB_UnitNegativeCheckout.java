package testcases.negative;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

public class Q_JMB_UnitNegativeCheckout extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_StuObjects stu = new Q_JMB_StuObjects();

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
    @Test(priority = 7)
    public static void firstNameBlank ()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(20);
        chk.selectItem("1 oz US Quarter Copper", 49);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.editShippingName(9);
        chk.saveShippingAddress("Please enter your first name.");
        Q_JMB_Controls.checkAlert();
        Q_JMB_CartPageObjects.removeItems();
        acc.logoutUser();
    }
}
