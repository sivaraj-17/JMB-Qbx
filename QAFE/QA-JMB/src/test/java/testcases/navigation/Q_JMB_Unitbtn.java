package testcases.navigation;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

public class Q_JMB_Unitbtn extends Q_JMB_Init {
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
//        System.out.println(System.getProperty("user.dir"));

    }
    /*******************************************************************
    // * Description: Verify security validation is required for contact form
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 6, enabled =true)
    public void  contactForm(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
//        Assert.assertFalse(ElemSteps.xpElementDisplayed(navProp, "warning.xpath"));
        Q_JMB_NavigationObjects.selectFromMenu("contact");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Contact Us | JM Bullion"));

        Q_JMB_NavigationObjects.contactForm();

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
