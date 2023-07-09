package testcases.navigation;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;

import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

public class Q_JMB_SiteButtons extends Q_JMB_Init {
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
    }
    @BeforeTest
    public void setExtent() throws Exception {

    }
    /*******************************************************************
     // * Description: Verify user can click Sell to Us button.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 1, enabled =true)
    public void  btnSellToUsGuest(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        String className = this.getClass().getSimpleName();
        Q_JMB_NavigationObjects.selectFromMenu("sell to us");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Sell Your Gold & Silver Coins & Bars Online - JMBullion.com"));
        Q_JMB_NavigationObjects.sellToUsOnLineButtonGuest();

    }
    @Test(priority = 2, enabled =true)
    public void  btnSellToUsRegistered(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        String className = this.getClass().getSimpleName();
        Q_JMB_NavigationObjects.selectFromMenu("sell to us");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Sell Your Gold & Silver Coins & Bars Online - JMBullion.com"));
        Q_JMB_NavigationObjects.sellToUsOnLineButtonReg();

    }
    @Test(priority = 3, enabled =true)
    public void  atcOnSale(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("on sale");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("On Sale « Product categories « JM Bullion"));
//        CartSteps.emptyCart();

    }
    /*******************************************************************
     // * Description: Verify user can subscribe to chart pricing
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4, enabled =true)
    public void  charts(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("charts");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Gold and Silver Prices, Charts, Widgets and Calculators"));
        Q_JMB_NavigationObjects.chartSubscribe("qa@jmbullion.com");

    }
    /*******************************************************************
     // * Description: Verify user can request IRA information
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5, enabled =true)
    public void  iraRequest(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("ira");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Gold and Silver Precious Metals IRA | JM Bullion"));
        Q_JMB_NavigationObjects.iraRequestInfo();

    }
    /*******************************************************************
     // * Description: Verify IRA faq text
     // * Author:
     // * Jira Ticket: JMB-5833
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6, enabled =true)
    public static void  iraText(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        String verifyThisText = "IRA orders over $199 ship for free, while orders less than $199 have a $7.99 shipping fee. " +
                "All of the packages we send out include insurance and tracking as well at no additional cost. " +
                "This means you will be able to track your package while it is on its way to the depository. " +
                "Customers can rest easy knowing their metals are fully insured in the rare occurrence of loss or " +
                "damage while the package is in transit.";
        Q_JMB_NavigationObjects.selectFromMenu("ira");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Gold and Silver Precious Metals IRA | JM Bullion"));
        Q_JMB_Controls.scrolDownPixel(5000);
        Q_JMB_WebElm.myWait(2000);
        System.out.println("To be verified " + verifyThisText);
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "nav.ira.faqLast.xp"), verifyThisText);

    }
    /*******************************************************************
     // * Description: Verify IRA mega menu dropdown and ira metal buttons function properly
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7, enabled =true)
    public void  irabuttons(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("ira");
        Q_JMB_NavigationObjects.iraDropDown();
        Q_JMB_NavigationObjects.iraButtons();

    }
    /*******************************************************************
     // * Description: Verify IRA investment links redirect user to the corresponding site
     // * Author:
     // * Status: Complete
     // * Jira Ticket: JMB-6100
     //*******************************************************************/
    @Test(priority = 8, enabled =true)
    public void  iraLinks(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("ira");
        Q_JMB_NavigationObjects.iralinks();


    }
    /*******************************************************************
     // * Description: Verify security validation is required for contact form
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9, enabled =true)
    public void  contactForm(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("contact");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Contact Us | JM Bullion"));
        Q_JMB_NavigationObjects.contactForm();

    }
    @AfterTest
    public void endReport(){


    }
    @AfterMethod
    public void tearDown() throws Exception {
        Q_JMB_Controls.tearDown();
    }

    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
