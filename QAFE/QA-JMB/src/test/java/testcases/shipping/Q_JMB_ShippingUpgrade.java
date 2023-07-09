package testcases.shipping;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.util.ArrayList;

public class Q_JMB_ShippingUpgrade extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
    static Q_JMB_CategoryObjects cat = new Q_JMB_CategoryObjects();
    static Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();
    static Q_JMB_TicketsObjects tic = new Q_JMB_TicketsObjects();

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
    // * Description: Guest User verify minimum shipping applied
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1)
    public static void guestShippingMinDefault()throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 1);
        chk.selectItem("1 oz US Quarter Copper", 2);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        chk.bridgeGuest();
        chk.guestEmail("qa+8jmb@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        Q_JMB_Controls.scrolUpPixel(200);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println(orderPrices);
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    /*******************************************************************
    // * Description: Guest User verify no shipping charges for orders over $99.00
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2)
    public static void guestDefaultShipping()throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("100 oz Geiger Security", 1);
        chk.selectItem("1 oz US Quarter Copper", 2);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        chk.bridgeGuest();
        chk.guestEmail("qa+8jmb@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        Q_JMB_Controls.scrolUpPixel(200);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println(orderPrices);
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
   }

    /*******************************************************************
    // * Description: Guest User verify orders under $1K shipping upgrade 3 Day Available
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3)
    public static void guestShippingMinUPS3Day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("10 Gram Perth Mint Gold Bar", 1);
        chk.selectItem("1 oz US Quarter Copper", 2);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        chk.bridgeGuest();
        chk.guestEmail("qa+8jmb@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.regShippingUpgrade("option 2");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        Q_JMB_Controls.scrolUpPixel(200);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println(orderPrices);
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }

    /*******************************************************************
    // * Description: Guest User verify orders $500.00 less than $1K priority shipping upgrade Available
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 4)
    public static void guestShippingUpgradePri()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 15);
        chk.selectItem("1 oz US Quarter Copper", 2);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        chk.bridgeGuest();
        chk.guestEmail("qa+8jmb@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.regShippingUpgrade("option 2");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        Q_JMB_Controls.scrolUpPixel(200);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println(orderPrices);
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    /*******************************************************************
    // * Description: Guest User verify orders $500.00 less than $1K shipping upgrade 3 Day Available
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 5)
    public static void guestShippingLess1K3day()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 15);
        chk.selectItem("1 oz US Quarter Copper", 2);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        chk.bridgeGuest();
        chk.guestEmail("qa+8jmb@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.regShippingUpgrade("option 3");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        Q_JMB_Controls.scrolUpPixel(200);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println(orderPrices);
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    /*******************************************************************
    // * Description: Guest User verify orders over $1K shipping upgrade 3 Day Available
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 6)
    public static void guestShipping3DayTc2()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("10 Gram Perth Mint Gold Bar", 3);
        chk.selectItem("1 oz US Quarter Copper", 2);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        chk.bridgeGuest();
        chk.guestEmail("qa+8jmb@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.regShippingUpgrade("option 2");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        Q_JMB_Controls.scrolUpPixel(200);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println(orderPrices);
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
    // * Description: Registered User verify orders total over $00 and less than 1K can be upgrade to priority shipping
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 7)
    public static void regShippingLess500Pri()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 6);
        chk.selectItem("1 oz US Quarter Copper", 2);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");

        chk.regShippingUpgrade("option 2");
        chk.selectCard("mc", "712");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        Q_JMB_Controls.scrolUpPixel(200);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println(orderPrices);
        chk.verifyOrderCharges(reviewPrices, orderPrices);
        acc.logoutUser();
    }
    
    /*******************************************************************
    // * Description: Registered User verify orders less than $100.00 minimum shipping charges applied
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 8)
    public static void registeredMinShippingCharge()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 1);
        chk.selectItem("1 oz US Quarter Copper", 2);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        chk.selectCard("mc", "712");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        Q_JMB_Controls.scrolUpPixel(200);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println(orderPrices);
        chk.verifyOrderCharges(reviewPrices, orderPrices);
        acc.logoutUser();
    }

    /*******************************************************************
    // * Description: Registered User verify orders over $100.00 default shipping is free of charge
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 9)
    public static void registeredMinShippingNoCharge()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 6);
        chk.selectItem("1 oz US Quarter Copper", 2);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        chk.selectCard("mc", "712");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        Q_JMB_Controls.scrolUpPixel(200);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println(orderPrices);
        chk.verifyOrderCharges(reviewPrices, orderPrices);
        acc.logoutUser();
    }
    
    /*******************************************************************
    // * Description: Registered User verify orders total over $00 and less than 1K can be upgrade to 3Day shipping
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 10)
    public static void regLess1K3Dayupgrade()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 10);
        chk.selectItem("1 oz US Quarter Copper", 2);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        chk.regShippingUpgrade("option 3");
        chk.selectCard("mc", "712");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        Q_JMB_Controls.scrolUpPixel(200);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println(orderPrices);
        chk.verifyOrderCharges(reviewPrices, orderPrices);
        acc.logoutUser();
    }
    
    /*******************************************************************
    // * Description: Registered User verify orders total over 1K can be upgrade to 3Day shipping
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 11)
    public static void regOver1K3Dayupgrade()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        chk.selectItem("100 oz Geiger Security", 1);
        chk.selectItem("1 oz US Quarter Copper", 2);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        chk.regShippingUpgrade("option 2");
        chk.selectCard("mc", "712");
        ArrayList<Float> reviewPrices = new ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        Q_JMB_Controls.scrolUpPixel(200);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println(orderPrices);
        chk.verifyOrderCharges(reviewPrices, orderPrices);
        acc.logoutUser();
    }
    
    /*******************************************************************
    // * Description: Registered User verify orders total over 5K only upgrade available is 3Day shipping
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 12)
    public static void regOver5KOnly3Dayupgrade()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        chk.selectItem("100 oz Geiger Security", 4);
        chk.selectItem("1 oz US Quarter Copper", 2);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        chk.regShippingUpgrade("option 2");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        Q_JMB_Controls.scrolUpPixel(200);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println(orderPrices);
        chk.verifyOrderCharges(reviewPrices, orderPrices);
        acc.logoutUser();
    }
    
    /*******************************************************************
    // * Description: Verify user can upgrade shipping options and the shipping charges are corresponds to the option displayed
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 13)
    public static void moveBetweenShippingOptions()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        chk.selectItem("10 Gram Perth Mint Gold Bar", 1);
        chk.selectItem("1 oz US Quarter Copper", 2);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        ArrayList<Float> reviewPrices1 = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        System.out.println("First Option Default: " + reviewPrices1);
        chk.regShippingUpgrade("option 2");
        ArrayList<Float> reviewPrices2 = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        System.out.println("Second Option Priority: " + reviewPrices2);
        chk.regShippingUpgrade("option 3");
        ArrayList<Float> reviewPrices3 = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        System.out.println("Third Option 3 Day Air: " + reviewPrices3);
        Q_JMB_Controls.scrolUpPixel(200);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println(orderPrices);
        chk.verifyOrderCharges(reviewPrices3, orderPrices);
        acc.logoutUser();
    }
    
    /*******************************************************************
    // * Description: Verify user can revert shipping options and the shipping charges are corresponds to the option displayed
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 14)
    public static void revertShippingOptions()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());;
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        chk.selectItem("10 Gram Perth Mint Gold Bar", 1);
        chk.selectItem("1 oz US Quarter Copper", 2);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        chk.regShippingUpgrade("option 3");
        ArrayList<Float> reviewPrices1 = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        System.out.println("First Option 3 Day Air: " + reviewPrices1);
        chk.regShippingUpgrade("option 2");
        ArrayList<Float> reviewPrices2 = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        System.out.println("Second Option Priority: " + reviewPrices2);
        chk.regShippingUpgrade("default");
        ArrayList<Float> reviewPrices3 = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        System.out.println("Third Option Default: " + reviewPrices3);
        Q_JMB_Controls.scrolUpPixel(200);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println(orderPrices);
        chk.verifyOrderCharges(reviewPrices3, orderPrices);
        acc.logoutUser();
    }
    
    /*******************************************************************
     * Description: Verifies that on shipping options for order less than $199
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991
     ********************************************************************/
    @Test(priority = 15)
    public static void verifyShippingOptionsLessThan$199SelectUPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 2);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Base Shipping:$7.99;"
        		+ "USPS Priority:$11.99;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$12.99");
        chk.regShippingUpgrade("option 3");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }

    /*******************************************************************
     * Description: Verifies that on shipping options for order less than $1000
     * and weight less than 16 oz
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 16)
    public static void verifyShippingOptionsLessThan$1000AndLessThan16OzSelectUPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 6);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        chk.selectCard("mc", "321");
        //chk.ccvCode("321");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
        		+ "USPS Priority:$7.99;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$12.99");
        chk.regShippingUpgrade("option 3");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies that on shipping options for order less than $5000
     * and weight less than 16 oz
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 16)
    public static void verifyShippingOptionsLessThan$5000AndLessThan16OzSelectUPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 6);
        chk.selectItem("10 Gram Perth Mint Gold Bar", 2);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        //chk.selectCard("mc", "321");
        //chk.ccvCode("321");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
        		+ "USPS Priority:$7.99;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$12.99");
        chk.regShippingUpgrade("option 3");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }

    /*******************************************************************
     * Description: Verifies that on shipping options for order less than $1000
     * and weight less than 200 oz
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 17)
    public static void verifyShippingOptionsLessThan$1000AndLessThan200OzSelectUPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 16);
        String originalWindow = driver.getWindowHandle();
        chk.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.xp", originalWindow);
        chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
        		+ "USPS Priority:$12.99;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$12.99");
        chk.regShippingUpgrade("option 3");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }


    /*******************************************************************
     * Description: Verifies that on shipping options for order less than $15000
     * and weight less than 16 oz
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 18)
    public static void verifyShippingOptionsLessThan$15000AndLessThan16OzSelectUPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(28);
        chk.selectItem("10 Gram Perth Mint Gold Bar", 1);
        cart.selectPaymentType("echeck");
        cart.selectcheckoutBtn("top");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
        		+ "USPS Priority:$7.99;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$12.99;"
        		+ "Local Pickup:FREE");
        chk.regShippingUpgrade("option 3");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }

    /*******************************************************************
     * Description: Verifies that on shipping options for order less than $5000
     * and weight less than 200 oz
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 19)
    public static void verifyShippingOptionsLessThan$5000AndLessThan200OzSelectUPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 80);
        //chk.selectItem("10 Gram Perth Mint Gold Bar", 5);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
        		+ "USPS Priority:$12.99;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$12.99;"
        		+ "Secure Storage - TDS:6 Months Free");
        chk.regShippingUpgrade("option 3");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }

    /*******************************************************************
     * Description: Verifies that on shipping options for order less than $5000
     * and weight less than 450 oz
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 20)
    public static void verifyShippingOptionsLessThan$5000AndLessThan450OzSelectUPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        //chk.selectItem("1 oz US Quarter Copper", 350);
        chk.selectItem("33mm CoinSafe Coin Tube", 300);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
        		+ "USPS Priority:$21.99;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$24.99");
        chk.regShippingUpgrade("option 3");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }

    /*******************************************************************
     * Description: Verifies that on shipping options for order less than $25000
     * and weight less than 450 oz
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 21)
    public static void verifyShippingOptionsLessThan$25000AndLessThan450OzSelectUPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 300);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("84092");
        Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$24.99;"
        		+ "Secure Storage - TDS:6 Months Free");
        chk.regShippingUpgrade("option 2");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies that on shipping options for order less than $25000
     * and weight less than 200 oz
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 22)
    public static void verifyShippingOptionsLessThan$25000AndLessThan200OzSelectUPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        chk.selectItem("10 Gram Perth Mint Gold Bar", 30);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$12.99;"
        		+ "Secure Storage - TDS:6 Months Free");
        chk.regShippingUpgrade("option 2");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies that on shipping options for order less than $5000
     * and weight less than 300 oz
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 23)
    public static void verifyShippingOptionsLessThan$5000AndLessThan300OzSelectUPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        chk.selectItem("1 oz US Quarter Copper", 250);
        chk.selectItem("10 Gram Perth Mint Gold Bar", 2);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
        		+ "USPS Priority:$17.99;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$16.99");
        chk.regShippingUpgrade("option 3");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies that on shipping options for order less than $25000
     * and weight less than 300 oz
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 24)
    public static void verifyShippingOptionsLessThan$25000AndLessThan300OzSelectUPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 250);
        chk.selectItem("10 Gram Perth Mint Gold Bar", 5);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$16.99;"
        		+ "Secure Storage - TDS:6 Months Free");
        chk.regShippingUpgrade("option 2");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies that on shipping options for order less than $5000
     * and weight less than 750 oz
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 25)
    public static void verifyShippingOptionsLessThan$5000AndLessThan750OzSelectUPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        chk.selectItem("1 oz US Quarter Copper", 500);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
        		+ "USPS Priority:$21.99;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$29.99;");
        chk.regShippingUpgrade("option 3");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies that on shipping options for order less than $15000
     * and weight less than 750 oz
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 25)
    public static void verifyShippingOptionsLessThan$15000AndLessThan750OzSelectUPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        //chk.selectItem("1 oz US Quarter Copper", 500);
        chk.selectItem("2019 Canadian Silver Maple Leaf Monster Box (500 Coins, BU)", 1);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$29.99;"
        		+ "Secure Storage - TDS:6 Months Free");
        chk.regShippingUpgrade("option 2");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies that on shipping options for order less over 750 oz
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 26)
    public static void verifyShippingOptionsOver750OzSelectUPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        chk.selectItem("1 oz US Quarter Copper", 1000);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$29.99");
        chk.regShippingUpgrade("option 2");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies that on shipping options for order over $25000
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 27)
    public static void verifyShippingOptionsOver$25000UPS3DayAir()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        chk.selectItem("10 Gram Perth Mint Gold Bar", 50);
        cart.selectPaymentType("wire");
        cart.selectcheckoutBtn("top");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        Q_JMB_CheckoutObjects.verifyAvailableShippingMethodsAndCosts("Free Shipping:FREE;"
        		+ "Expedited Shipping Our Choice UPS or FedEx:$12.99;"
        		+ "Secure Storage - TDS:6 Months Free");
        chk.regShippingUpgrade("option 2");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies that on shipping options default to base/free shipping after logoff
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 28)
    public static void verifyShippingOptionsDefaultToBaseAfterLogOff()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 2);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        chk.regShippingUpgrade("option 3");
        driver.navigate().to(baseUrl);
        acc.logoutUser();
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 2);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        chk.bridgeGuest();
        tic.verifyActiveShippingMethod("Free Shipping");
    }
    
    /*******************************************************************
     * Description: Verifies that on shipping options change that Order 
     * Review matches and can go back to an option
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6527, JMB-6584, JMB-6991 
     ********************************************************************/
    @Test(priority = 29)
    public static void verifyShippingOptionChangesMatchesOrderReview()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 6);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        //chk.selectCard("mc", "321");
        chk.ccvCode("321");
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode("75070");
        tic.verifyActiveShippingMethod("Free Shipping");
        Assert.assertEquals(Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps, "chk.revShipping.id")), Float.valueOf("0.00"));
        chk.regShippingUpgrade("option 2");
        tic.verifyActiveShippingMethod("USPS Priority");
        Assert.assertEquals(Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps, "chk.revShipping.id")), Float.valueOf("7.99"));
        chk.regShippingUpgrade("option 3");
        tic.verifyActiveShippingMethod("Expedited Shipping Our Choice UPS or FedEx");
        Assert.assertEquals(Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps, "chk.revShipping.id")), Float.valueOf("12.99"));
        chk.regShippingUpgrade("default");
        tic.verifyActiveShippingMethod("Free Shipping");
        Assert.assertEquals(Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps, "chk.revShipping.id")), Float.valueOf("0.00"));
        chk.regShippingUpgrade("option 2");
        tic.verifyActiveShippingMethod("USPS Priority");
        Assert.assertEquals(Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps, "chk.revShipping.id")), Float.valueOf("7.99"));
        chk.regShippingUpgrade("option 3");
        tic.verifyActiveShippingMethod("Expedited Shipping Our Choice UPS or FedEx");
        Assert.assertEquals(Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps, "chk.revShipping.id")), Float.valueOf("12.99"));
        chk.completeOrder();
    }

    @AfterTest
    public void endReport(){
    }
    @AfterMethod
    public void tearDown() throws Exception {
        Q_JMB_CartPageObjects.removeItems();
        Q_JMB_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
