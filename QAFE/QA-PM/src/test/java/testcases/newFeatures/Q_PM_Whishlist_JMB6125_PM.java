package testcases.newFeatures;

import java.io.FileNotFoundException;

import org.testng.annotations.*;

import pageObjects.Q_PM_AccountSteps;
import pageObjects.Q_PM_CartSteps;
import pageObjects.Q_PM_WebElm;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

public class Q_PM_Whishlist_JMB6125_PM extends Q_PM_Init {
    @BeforeClass
    public void tcSetup() {
    }
    @BeforeMethod
    public void report() throws Exception {
        Q_PM_Init.setItUp();
    }
    @BeforeTest
    public void setTest() throws Exception {
    }
    /*******************************************************************
     // * Description: PM Wishlist Functionality
     // * Author:
     // * Status:
     *  Ticket : JMB-6125[New WP Page]PM Wishlist Functionality
     * @throws Exception
     */
    @Test (priority = 1,enabled = true)
    public static void myAccountWishList() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(37);
        Q_PM_AccountSteps.accountMenu("MY WISHLIST");
        Q_PM_AccountSteps.addProductToWishList();
        Q_PM_AccountSteps.removeProductFromWishlist();
    }

    @Test (priority = 2,enabled = true)
    public static void myAccountWishListATC() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(37);
        Q_PM_AccountSteps.accountMenu("MY WISHLIST");
        Q_PM_AccountSteps.addProductToWishList();
        Q_PM_AccountSteps.addToCartMyAccountWishList("1");
        Q_PM_WebElm.myWait(4000);
        Q_PM_AccountSteps.accountMenu("MY WISHLIST");
        Q_PM_AccountSteps.removeProductFromWishlist();
    }

    @Test (priority = 3,enabled = true)
    public static void myAccountWishListInstockAlert() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(37);
        Q_PM_AccountSteps.accountMenu("MY WISHLIST");
        Q_PM_AccountSteps.wishListInStockAlert();
        Q_PM_AccountSteps.removeProductFromWishlist();
    }
    @Test (priority = 4,enabled = true)
    public static void myAccountWishListPDPInstockAlert() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(36);
        Q_PM_AccountSteps.accountMenu("MY WISHLIST");
        Q_PM_AccountSteps.wishListInStockAlertPdp();
        Q_PM_AccountSteps.accountMenu("MY WISHLIST");
        Q_PM_AccountSteps.removeProductFromWishlist();
    }

    @Test (priority = 5,enabled = true)
    public static void wishlistPagination() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(38);
        Q_PM_AccountSteps.accountMenu("MY WISHLIST");
        Q_PM_AccountSteps.wishlistPagination();
    }
    @Test (priority = 6)
    public static void addAndRemoveWishListPDP() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(37);
        Q_PM_AccountSteps.addRemoveProductWishlistPDP();
    }
    @Test (priority = 7)
    public static void addWishListPDPGuest() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.addProductWishlistPDPGuest();

    }
    @AfterMethod
    public static void tearDown(){
        Q_PM_CartSteps.deleteItems();
        Q_PM_WebElm.myWait(2000);
        Q_PM_AccountSteps.accountMenu("LOGOUT");
        Q_PM_WebElm.myWait(1000);
        driver.quit();
    }
    @AfterClass
    public static void killDriver(){
    }

}


