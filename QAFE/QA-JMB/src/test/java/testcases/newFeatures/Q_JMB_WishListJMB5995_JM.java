package testcases.newFeatures;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.io.FileNotFoundException;

public class Q_JMB_WishListJMB5995_JM extends Q_JMB_Init {
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
 /*******************************************************************
	// * Description: This test case verifies user can add credit cards from their customer profile
	// * Author:
	// * Status: Complete
	 *  Ticket : JMB-5995(Wishlist In Stock Alert)
	 */
	//*******************************************************************/
	@Test (priority = 1,enabled = true)
	public static void myAccountWishList() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(36);
		acc.myAccount("wishlist");
		acc.addProductToWishList();
		acc.removeProductFromWishlist();
	}
	@Test (priority = 2,enabled = true)
	public static void myAccountWishListATC() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(36);
		Q_JMB_WebElm.myWait(2000);
		acc.myAccount("wishlist");
		acc.addProductToWishList();
		acc.addToCartMyAccountWishList("3");
		acc.removeProductFromWishlist();
	}
	@Test (priority = 3,enabled = true)
	public static void myAccountWishListInstockAlert() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(36);
		acc.myAccount("wishlist");
		acc.wishListInStockAlert();
		acc.removeProductFromWishlist();
	}
	@Test (priority = 4,enabled = true)
	public static void myAccountWishListPDPInstockAlert() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(36);
		acc.myAccount("wishlist");
		acc.wishListInStockAlertPdp();
		acc.removeProductFromWishlist();
	}
	@Test (priority = 5,enabled = true)
	public static void wishlistPagination() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(36);
		acc.myAccount("wishlist");
		acc.wishlistPagination();
	}
	@Test (priority = 6)
	public static void addAndRemoveWishListPDP() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(36);
		acc.addRemoveProductWishlistPDP();
	}
	@Test (priority = 7)
	public static void addWishListPDPGuest() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.addProductWishlistPDPGuest();
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

