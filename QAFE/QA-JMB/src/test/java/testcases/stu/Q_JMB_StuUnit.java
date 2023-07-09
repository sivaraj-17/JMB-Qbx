package testcases.stu;

import org.testng.annotations.*;
import pageObjects.*;

import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;


public class Q_JMB_StuUnit extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
    static Q_JMB_CategoryObjects cat = new Q_JMB_CategoryObjects();
    static Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();

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
    @Test(priority = 23)
    public static void registerOrderPickUpShippingOption()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        stu.selToUs();
        stu.addBbItem("platinum", 2, "2");
        stu.addAnotherProduct();
        stu.addBbItem("gold", 14, "4");
        stu.checkoutNow();
        // Address selection xpath for STU is the same as regular orders
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode(jmbProps, "chk.reg.shippingAddressOptionByText.beg.xp" ,"75070" ,"chk.reg.shippingAddressOptionByText.end.xp");
        // Select Drop Off option
        stu.mailLabel(3);
        stu.completeSale();
    }
    @AfterMethod
    public void tearDown() throws Exception {
       //        stu.removeCartPageContent();
//        Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }

}
