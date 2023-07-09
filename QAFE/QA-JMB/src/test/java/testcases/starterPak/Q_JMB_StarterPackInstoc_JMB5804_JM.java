package testcases.starterPak;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

public class Q_JMB_StarterPackInstoc_JMB5804_JM extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
    static Q_JMB_CategoryObjects cat = new Q_JMB_CategoryObjects();
    static Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();

    static String tcName = "";

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
     // * Description: JMB-5804 Out of stock Starter pack verify guest user must login to add in stock alert
     // * Author:
     // * Status: Complete
     // *  Ticket : JMB-5804)
     // * *****************************************************************/
    @Test(priority = 1)
    public static void starterOutOfStockGuest() throws Exception {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        prod.productStocK("1598250", "outOfStock");
        driver.navigate().to(baseUrl + "/starter-pack/");
        System.out.println("Expected text " + Q_JMB_WebElm.xpRetText(jmbProps, "starter.GuestLogin.xp"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "starter.GuestLogin.xp"), "Log in");
        Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "starter.GuestLogin.xp").equals(true));
        System.out.println("starter. back message 1: " + Q_JMB_WebElm.xpRetText(jmbProps, "starter.PackMsg1.xp"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "starter.PackMsg1.xp"), "Limited Time Offer");
        System.out.println("starter. back message 2: " + Q_JMB_WebElm.xpRetText(jmbProps, "starter.PackMsg2.xp"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "starter.PackMsg2.xp"), "1 Max per Person/Household");
    }

    /*******************************************************************
     // * Description: JMB-5804 Out of stock Starter pack verify logged user can add in stock alert
     // * Author:
     // * Status: Complete
     // *  Ticket : JMB-5804)
     // * *****************************************************************/
    @Test(priority = 2)
    public static void starterOutOfStockLoggedAddAlert() throws Exception {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(27);
        driver.navigate().to(baseUrl + "/starter-pack/");
        System.out.println("Expected text " + Q_JMB_WebElm.xpRetText(jmbProps, "starter.LoggedStockAlert.xp"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "starter.LoggedStockAlert.xp"), "In-Stock Alert");
        Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "starter.LoggedStockAlert.xp").equals(true));
        System.out.println("starter. back message 1: " + Q_JMB_WebElm.xpRetText(jmbProps, "starter.PackMsg1.xp"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "starter.PackMsg1.xp"), "Limited Time Offer");
        System.out.println("starter. back message 2: " + Q_JMB_WebElm.xpRetText(jmbProps, "starter.PackMsg2.xp"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "starter.PackMsg2.xp"), "1 Max per Person/Household");
        prod.addStockAlert();
        acc.logoutUser();
    }

    /*******************************************************************
     // * Description: JMB-5804 Out of stock Starter pack verify logged user can remove in stock alert
     // * Author:
     // * Status: Complete
     // *  Ticket : JMB-5804)
     // * *****************************************************************/
    @Test(priority = 3)
    public static void starterOutOfStockLoggedRemoveAlert() throws Exception {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(27);
        driver.navigate().to(baseUrl + "/starter-pack/");
        System.out.println("Expected text " + Q_JMB_WebElm.xpRetText(jmbProps, "starter.LoggedStockAlert.xp"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "starter.LoggedStockAlert.xp"), "Remove In-Stock Alert");
        Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "starter.LoggedStockAlert.xp").equals(true));
        prod.removeStockAlert();
        acc.logoutUser();
    }

    /*******************************************************************
     // * Description: JMB-5804 Verify users who had previously purchased starter pack don't see the In Stock alert button
     // * Author:
     // * Status: Complete
     // *  Ticket : JMB-5804)
     // * *****************************************************************/
    @Test(priority = 4)
    public static void noInStockALertBtnForUsersWhoBoughtStarter() {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        prod.productStocK("1598250", "outOfStock");
        acc.loginUser(0);
        driver.navigate().to(baseUrl + "/starter-pack/");
        System.out.println("Expected text " + Q_JMB_WebElm.xpRetText(jmbProps, "starter.OutOfStock.xp"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "starter.OutOfStock.xp"), "Currently Out of Stock");
        acc.logoutUser();
    }

    /*******************************************************************
     // * Description: JMB-5804 Verify users who had previously purchased starter pack don't see the Add To Cart button
     // * Author:
     // * Status: Complete
     // *  Ticket : JMB-5804)
     // * *****************************************************************/
    @Test(priority = 5)
    public static void starterInStockPreiouslyOrderd() {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        prod.productStocK("1598250", "inStock");
        acc.loginUser(0);
        driver.navigate().to(baseUrl + "/starter-pack/");
        System.out.println("Expected text " + Q_JMB_WebElm.xpRetText(jmbProps, "starter.PreviuslyBoughtMessage.xp"));
        String reahedLimit = "You have reached our 1 per person/household max, unavailable for additional purchases.";
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "starter.PreviuslyBoughtMessage.xp"), reahedLimit);
        acc.logoutUser();
    }

    /*******************************************************************
     // * Description: JMB-5804 Out of stock Starter pack verify guest user must login to add in stock alert
     // * Author:
     // * Status: Complete
     // *  Ticket : JMB-5804)
     // * *****************************************************************/
    @Test(priority = 6)
    public static void starterInOfStockGuest() throws Exception {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        driver.navigate().to(baseUrl + "/starter-pack/");
        System.out.println("Expected text " + Q_JMB_WebElm.xpRetText(jmbProps, "starter.AddToCart.xp"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "starter.AddToCart.xp"), "Add to Cart");
        Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "starter.AddToCart.xp").equals(true));
//        System.out.println("starter. back message 1: " + WebElm.xpRetText(jmbProps, "starter.PackMsg1.xp"));
//        Assert.assertEquals(WebElm.xpRetText(jmbProps, "starter.PackMsg1.xp"), "Limited Time Offer");
//        System.out.println("starter. back message 2: " + WebElm.xpRetText(jmbProps, "starter.PackMsg2.xp"));
//        Assert.assertEquals(WebElm.xpRetText(jmbProps, "starter.PackMsg2.xp"), "1 Max per Person/Household");
        prod.productStocK("1598250", "outOfStock");
    }

    
    @AfterMethod
    public static void tearDown(ITestResult rest) {
        Q_JMB_Controls.tearDown();
    }

    @AfterClass
    public static void kill() {

    }

}


