package testcases.payPal;

import org.testng.annotations.BeforeClass;

import pageObjects.*;
import utils.Q_JMB_Init;

public class Q_UnitPayPalCheckout extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
    static Q_JMB_CategoryObjects cat = new Q_JMB_CategoryObjects();

    @BeforeClass
    public void tcSetup() throws Exception {

        Q_JMB_Init.setItUp();
    }

}
