package testcases.navigation;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

public class Q_JMB_UnitFooterNavigation extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();

    @BeforeClass
    public void tcSetup (){

    }
    @BeforeMethod
    public void report() throws Exception {
        Q_JMB_Init.setItUp();
//        ExtentTestManager.startTest(new Object(){}.getClass().getEnclosingMethod().getName(), "Test 1");
    }
    @BeforeTest
    public void setExtent() throws Exception {
//        Init.setItUp();
//        System.out.println(System.getProperty("user.dir"));  "Log In | JM Bullion"  "My Account | JM Bullion"

    }
    /*******************************************************************
    // * Description: Verify information about Government and Private Mints are listed at Abouts Us footer section
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 26, enabled = true)
    public void footerAboutUsMintsInformation(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerAboutUsMints();
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
