package testcases.newFeatures;

import org.testng.annotations.*;
import pageObjects.*;

import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Q_JMB_UpdateLinksOnPalladiumChartsPage_JMB7211 extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
    static Q_JMB_CategoryObjects cat = new Q_JMB_CategoryObjects();
    static Q_JMB_AdminObjects admin = new Q_JMB_AdminObjects();
    static Q_JMB_NewFeatures nf = new Q_JMB_NewFeatures();

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
    
    /*******************************************************************
    // * Description: Verify Palladium Charts Page links
    // * Parameter: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1,enabled=true)
    public void updateLinksOnPalladiumChartsPage() {
    	String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
    	acc.loginUser(21);
        driver.get("https://qa.jmbullion.com/charts/palladium-price/");
    	Q_JMB_WebElm.myWait(3000);
    	nf.verifyPalladiumProductLink();
    }
    
    @AfterTest
    public void endReport(){
    }
    
    @AfterMethod
    public void tearDown() throws Exception {
        Q_JMB_CartPageObjects.removeItems();
        acc.logoutUser();
        Q_JMB_Controls.tearDown();
    }
    
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
