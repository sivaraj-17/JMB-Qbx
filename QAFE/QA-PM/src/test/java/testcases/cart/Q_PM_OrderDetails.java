package testcases.cart;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Q_PM_CartSteps;
import pageObjects.Q_PM_CheckoutSteps;
import pageObjects.Q_PM_WebElm;
import pageObjects.Q_PM_NavigationSteps;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Q_PM_OrderDetails extends Q_PM_Init {

    @BeforeClass
    public void tcSetup () throws Exception {
        Q_PM_Init.setItUp();
    }
    
    @BeforeMethod
    public void setUser () throws FileNotFoundException, InterruptedException {
    }

    /*******************************************************************
    // * Description: Price per payment method in modal
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1)
    public static void modalPriceList() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "1 oz US American Gold Eagle Coin";
        Q_PM_NavigationSteps.selectMetal("gold");
        Q_PM_NavigationSteps.category("firstLevel", 1, 1);
        Q_PM_NavigationSteps.category("secondLevel", 1, 1);
        Q_PM_WebElm.xp(pmQaProps, "cart.goldATC2553140.xp");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CartSteps.modalPrice());
        System.out.println(prices);
        Assert.assertTrue(Q_PM_CartSteps.modalPricingList(prices).equals(true));
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }
    
    /*******************************************************************
    // * Description: Price per payment method in pdp
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 2)
    public static void pdpPriceList(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "1 oz US American Gold Eagle Coin";
        Q_PM_NavigationSteps.selectMetal("platinum");
        Q_PM_NavigationSteps.category("secondLevel", 1, 1);
        Q_PM_NavigationSteps.productItem(1);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdpQty.xp");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CartSteps.pdpPricingList("cart.begPdpCheckPrice.xp", "cart.endPdpCheckPrice.xp"));
        System.out.println(prices);
        Assert.assertTrue(Q_PM_CartSteps.modalPricingList(prices).equals(true));
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }
    
    /*******************************************************************
    // * Description: Price per payment method in cart
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 3)
    public static void cartPriceList(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "1 oz US American Gold Eagle Coin";
        Q_PM_AddToCart.gold_1_2553140("1");
        Q_PM_CartSteps.cartPricingList();
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CartSteps.cartPricingList());
        System.out.println(prices);
        Assert.assertTrue(Q_PM_CartSteps.modalPricingList(prices).equals(true));
    }
    
    /*******************************************************************
    // * Description: Multiple quantity price verification
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 4)
    public static void multipleQuantityPricing(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "1 oz US American Gold Eagle Coin";
        Q_PM_AddToCart.silver_1_2553427("9");
        Q_PM_CartSteps.multipleSubtotal("credit");
        Q_PM_CartSteps.multipleSubtotal("wire" );
        Q_PM_CartSteps.multipleSubtotal("bitPay");
    }
    
    /*******************************************************************
    // * Description: Apply coupon to order
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 5)
    public static void addCoupon(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "10 gram Perth Mint Gold Bar";
        Q_PM_AddToCart.gold_2_2555362("1");
        Q_PM_CartSteps.verifyCartItem(description, "2");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CartSteps.applyCoupon();
    }
    
    /*******************************************************************
    // * Description: Remove Coupon from order
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 6)
    public static void removeDiscount(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "10 gram Perth Mint Gold Bar";
        Q_PM_AddToCart.gold_2_2555362("1");
        Q_PM_CartSteps.verifyCartItem(description, "2");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CartSteps.removeCoupon();
    }
    
    @AfterMethod
    public static void tearDown(){
        //CartSteps.verifyCartItems();
        Q_PM_CartSteps.deleteItems();
    }
    
    @AfterClass
    public static void killDriver(){
        if (driver.toString().contains("Firefox")) {
            driver.quit();
        }
    }
}
