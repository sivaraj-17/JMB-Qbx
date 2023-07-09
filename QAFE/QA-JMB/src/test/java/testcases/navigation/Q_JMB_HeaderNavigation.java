package testcases.navigation;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

public class Q_JMB_HeaderNavigation extends Q_JMB_Init {
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
    public void setTest() throws Exception {
    }
    /*******************************************************************
     // * Description: Verify user can return to home page by pressing the Home icon on the mega menu.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 1, enabled = true)
    public static void  homeIcon(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("home");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Buy Gold & Silver Bullion Online | Free Shipping - JM Bullion"));
        
    }
    /*******************************************************************
     // * Description: Verify mega menu navigation to Gold category.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2, enabled =true)
    public static void  gold(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("gold");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Gold « Product categories « JM Bullion"));
        
    }
    /*******************************************************************
     // * Description: Verify mega menu navigation to Silver category.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3, enabled =true)
    public  void  silver(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("silver");

        /*  To force skip test   */
//        if(NavigationSteps.getTitles("Silver « Product categories « JM Bullion").equals("Gold price")){
//            System.out.println("condition not met");
//        }
//        else{
//            ExtentTestManager.getTest().log(LogStatus.INFO, "Test Skipped Here");
//            throw new SkipException("Test skipped");
//        }
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Silver « Product categories « JM Bullion"));
        
    }
    /*******************************************************************
     // * Description: Verify mega menu navigation to Gold category.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4, enabled =true)
    public  void  platinum(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("platinum");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Platinum « Product categories « JM Bullion"));
        
    }
    /*******************************************************************
     // * Description: Verify user can expand the Other mega menu option and navigate to copper.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5, enabled =true)
    public  void copper(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.innerMega("copper");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Copper « Product categories « JM Bullion"));
        driver.navigate().back();
        
    }
    /*******************************************************************
     // * Description: Verify user can expand the Other mega menu option and navigate to copper rounds.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6, enabled =true)
    public  void copperRounds(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.innerMega("copper rounds");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Copper Rounds « Product categories « JM Bullion"));
        
    }
    /*******************************************************************
     // * Description: Verify user can expand the Other mega menu option and navigate to copper bars.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7, enabled =true)
    public  void copperBars(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.innerMega("copper bars");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Copper Bars « Product categories « JM Bullion"));
        
    }
    /*******************************************************************
     // * Description: Verify user can expand the Other mega menu option and navigate to copper wheat pennies.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8, enabled =true)
    public  void copperWheatPennies(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.innerMega("wheat pennies");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Buy Wheat Pennies | JM Bullion™"));
        driver.navigate().back();
        
    }
    /*******************************************************************
     // * Description: Verify user can expand the Other mega menu option and navigate to Palladium.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9, enabled =true)
    public  void palladium(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.innerMega("palladium");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Palladium « Product categories « JM Bullion"));
        driver.navigate().back();
        
    }
    /*******************************************************************
     // * Description: Verify user can expand the Other mega menu option and navigate to Palladium Bars.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 10, enabled =true)
    public  void palladiumBars(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.innerMega("palladium bars");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Palladium Bars « Product categories « JM Bullion"));
        driver.navigate().back();
        
    }
    /*******************************************************************
     // * Description: Verify user can expand the Other mega menu option and navigate to Palladium Coins.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 11, enabled =true)
    public  void palladiumCoins(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.innerMega("palladium coins");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Palladium Coins « Product categories « JM Bullion"));
        driver.navigate().back();
        
    }
    /*******************************************************************
     // * Description: Verify user can expand the Other mega menu option and navigate to Accessories.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 12, enabled =true)
    public  void accessories(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.innerMega("accessories");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Accessories « Product categories « JM Bullion"));
        driver.navigate().back();
        
    }
    /*******************************************************************
     // * Description: Verify user can expand the Other mega menu option and navigate to Coin Accessories.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 13, enabled =true)
    public  void accessoriesCoins(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.innerMega("coin accessories");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Coin Supplies « Product categories « JM Bullion"));
        driver.navigate().back();
        
    }
    /*******************************************************************
     // * Description: Verify user can expand the Other mega menu option and navigate to Bar Accessories.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 14, enabled =true)
    public  void accessoriesBars(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.innerMega("bar accessories");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Bar Supplies « Product categories « JM Bullion"));
        driver.navigate().back();
        
    }
    /*******************************************************************
     // * Description: Verify user can expand the Other mega menu option and navigate to Apparel Accessories.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 15, enabled =true)
    public  void accessoriesApparel(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.innerMega("apparel");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Apparel « Product categories « JM Bullion"));
        driver.navigate().back();
        
    }
    /*******************************************************************
     // * Description: Verify user can navigate to On Sale items from mega menu.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 16, enabled =true)
    public  void  onSale(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("on sale");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("On Sale « Product categories « JM Bullion"));
        
    }
    /*******************************************************************
     // * Description: Verify user can check our New Arrived items from mega menu.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 17, enabled =true)
    public  void  newArrivals(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("new arrivals");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("New Arrivals « Product categories « JM Bullion"));
        
    }
    /*******************************************************************
     // * Description: Verify user can learn how and sell their metal to us from mega menu.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 18, enabled =true)
    public  void  sellToUs(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("sell to us");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Sell Your Gold & Silver Coins & Bars Online - JMBullion.com"));
        
    }
    /*******************************************************************
     // * Description: Verify user can verify all metal prices on the Charts page.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 19, enabled =true)
    public  void  charts(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("charts");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Gold and Silver Prices, Charts, Widgets and Calculators"));
        
    }
    /*******************************************************************
     // * Description: Verify IRA faq text
     // * Author:
     // * Jira Ticket: JMB-5833
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 20, enabled = true)
    public  void  ira(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("ira");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Gold and Silver Precious Metals IRA | JM Bullion"));
        
    }
    /*******************************************************************
     // * Description: Verify security validation is required for contact form
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 21, enabled =true)
    public  void  contact(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("contact");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Contact Us | JM Bullion"));
        
    }
    /*******************************************************************
     // * Description: Verify Loans text
     // * Author:
     // * Jira Ticket: JMB-6394
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 22, enabled = true)
    public static void  loans(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.selectFromMenu("loans");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Gold & Silver Loans | JM Bullion"));

    }
    /*******************************************************************
     // * Description: Loan-To-Value Calculator
     // * Author:
     // * Jira Ticket: JMB-6245
     // * Status: Complete
     //*******************************************************************/

    @Test(priority = 23)
    public static void goldLoans() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects head = new Q_JMB_NavigationObjects();
        loans();
        head.loanToValueCalculator("1", "2", "3","4");

    }
    /*******************************************************************
     // * Description: Top navigation update
     // * Author:
     // * Status: Complete
     *  Ticket : JMB-6394(Top navigation update)
     * @throws Exception
     */

    @Test(priority = 25)
    public static void loansPage() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_HeaderNavigation head = new Q_JMB_HeaderNavigation();
        head.loans();
        Q_JMB_WebElm.xpDisplayed(jmbProps, "nav.footerSalesTax.xp");
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

    }
}
