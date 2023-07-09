package testcases.salesTax;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

public class Q_JMB_COSalesTaxAndFee_JMB7670_Positive {
	private Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
	private Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
	private Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
	private Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();
	private Q_JMB_AdminObjects adm = new Q_JMB_AdminObjects();
    private boolean hasSalesTax = true;
    private boolean hasStateFee = true;
    private boolean hasShippingTax = false;
    private boolean hasGiftCert = false;
    private String stateFee = "0.27";

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
     * Description: Verifies CO Sales tax & fee on silver artwork Product Taxable order Registered User
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test (priority = 1)
    public void coloradoSalesTaxAndFeeArtworkTaxable_Reg() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(54);
        prod.productsController(tcName, 1);
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
        ArrayList<Float> myAccountPrices = new ArrayList<>(acc.myAccountPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("My Account", priceList, reviewPrices, myAccountPrices);
        ArrayList<Float> adminPrices = new ArrayList<>(adm.adminOrderPriceList("qa+cosalestax@jmbulllion.com", hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order", priceList, reviewPrices, adminPrices);
        ArrayList<Float> adminInvoicePrices = new ArrayList<>(adm.adminOrderInvoicePriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order Invoice", priceList, reviewPrices, adminInvoicePrices);
        ArrayList<Float> adminClaimInvoicePrices = new ArrayList<>(adm.adminOrderClaimInvoicePriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order Claim Invoice", priceList, reviewPrices, adminClaimInvoicePrices);
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee on accessories Product Taxable order Registered User
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test (priority = 2)
    public void coloradoSalesTaxAndFeeAccessoriesTaxable_Reg() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(54);
        prod.productsController(tcName, 1);
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
        ArrayList<Float> myAccountPrices = new ArrayList<>(acc.myAccountPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("My Account", priceList, reviewPrices, myAccountPrices);
        ArrayList<Float> adminPrices = new ArrayList<>(adm.adminOrderPriceList("qa+cosalestax@jmbulllion.com", hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order", priceList, reviewPrices, adminPrices);
        ArrayList<Float> adminInvoicePrices = new ArrayList<>(adm.adminOrderInvoicePriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order Invoice", priceList, reviewPrices, adminInvoicePrices);
        ArrayList<Float> adminClaimInvoicePrices = new ArrayList<>(adm.adminOrderClaimInvoicePriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order Claim Invoice", priceList, reviewPrices, adminClaimInvoicePrices);
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee on Copper Product Taxable order Registered User
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * ***************************************************************/
    @Test (priority = 3)
    public void coloradoSalesTaxAndFeeCopperTaxable_Reg() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(54);
        prod.productsController(tcName, 1);
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
        ArrayList<Float> myAccountPrices = new ArrayList<>(acc.myAccountPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("My Account", priceList, reviewPrices, myAccountPrices);
        ArrayList<Float> adminPrices = new ArrayList<>(adm.adminOrderPriceList("qa+cosalestax@jmbulllion.com", hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order", priceList, reviewPrices, adminPrices);
        ArrayList<Float> adminInvoicePrices = new ArrayList<>(adm.adminOrderInvoicePriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order Invoice", priceList, reviewPrices, adminInvoicePrices);
        ArrayList<Float> adminClaimInvoicePrices = new ArrayList<>(adm.adminOrderClaimInvoicePriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order Claim Invoice", priceList, reviewPrices, adminClaimInvoicePrices);
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee on Multiple Products Taxable Order Registered User
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test (priority = 4)
    public void coloradoSalesTaxAndFeeMultipleTaxable_Reg() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(54);
        prod.productsController(tcName, 1);
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
        ArrayList<Float> myAccountPrices = new ArrayList<>(acc.myAccountPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("My Account", priceList, reviewPrices, myAccountPrices);
        ArrayList<Float> adminPrices = new ArrayList<>(adm.adminOrderPriceList("qa+cosalestax@jmbulllion.com", hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order", priceList, reviewPrices, adminPrices);
        ArrayList<Float> adminInvoicePrices = new ArrayList<>(adm.adminOrderInvoicePriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order Invoice", priceList, reviewPrices, adminInvoicePrices);
        ArrayList<Float> adminClaimInvoicePrices = new ArrayList<>(adm.adminOrderClaimInvoicePriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order Claim Invoice", priceList, reviewPrices, adminClaimInvoicePrices);
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee Verify fee does not change on product qty change
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test (priority = 5)
    public void coloradoSalesTaxAndFeeVerifyFeeDoesNotChangeOnQtyChange_Reg() throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       acc.loginUser(54);
       prod.productsController(tcName, 1);
       cart.paymentType("cart.paymentType.PC.id");
       cart.selectcheckoutBtn("bottom");
       chk.verifyStateFeeValue(stateFee);
       prod.productsController(tcName, 2);
       cart.paymentType("cart.paymentType.PC.id");
       cart.selectcheckoutBtn("bottom");
       chk.verifyStateFeeValue(stateFee);
       prod.productsController(tcName, 3);
       cart.paymentType("cart.paymentType.PC.id");
       cart.selectcheckoutBtn("bottom");
       chk.verifyStateFeeValue(stateFee);
       ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       chk.completeOrder();
       chk.thankYouPage();
       ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
       ArrayList<Float> myAccountPrices = new ArrayList<>(acc.myAccountPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       chk.compareCheckoutToOtherPageRev("My Account", priceList, reviewPrices, myAccountPrices);
       ArrayList<Float> adminPrices = new ArrayList<>(adm.adminOrderPriceList("qa+cosalestax@jmbulllion.com", hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert, 1));
       chk.compareCheckoutToOtherPageRev("Admin Order", priceList, reviewPrices, adminPrices);
       ArrayList<Float> adminInvoicePrices = new ArrayList<>(adm.adminOrderInvoicePriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert, 1));
       chk.compareCheckoutToOtherPageRev("Admin Order Invoice", priceList, reviewPrices, adminInvoicePrices);
       ArrayList<Float> adminClaimInvoicePrices = new ArrayList<>(adm.adminOrderClaimInvoicePriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert, 1));
       chk.compareCheckoutToOtherPageRev("Admin Order Claim Invoice", priceList, reviewPrices, adminClaimInvoicePrices);
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee on Taxable and Non-Taxable product Order Registered User
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test (priority = 6)
    public void coloradoSalesTaxAndFeeTaxableAndNonTaxable_Reg() throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       acc.loginUser(54);
       prod.productsController(tcName, 1);
       cart.paymentType("cart.paymentType.PC.id");
       cart.selectcheckoutBtn("bottom");
       ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       chk.completeOrder();
       chk.thankYouPage();
       ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
       ArrayList<Float> myAccountPrices = new ArrayList<>(acc.myAccountPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       chk.compareCheckoutToOtherPageRev("My Account", priceList, reviewPrices, myAccountPrices);
       ArrayList<Float> adminPrices = new ArrayList<>(adm.adminOrderPriceList("qa+cosalestax@jmbulllion.com", hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert, 1));
       chk.compareCheckoutToOtherPageRev("Admin Order", priceList, reviewPrices, adminPrices);
       ArrayList<Float> adminInvoicePrices = new ArrayList<>(adm.adminOrderInvoicePriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert, 1));
       chk.compareCheckoutToOtherPageRev("Admin Order Invoice", priceList, reviewPrices, adminInvoicePrices);
       ArrayList<Float> adminClaimInvoicePrices = new ArrayList<>(adm.adminOrderClaimInvoicePriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert, 1));
       chk.compareCheckoutToOtherPageRev("Admin Order Claim Invoice", priceList, reviewPrices, adminClaimInvoicePrices);
    }
   
   /*******************************************************************
    * Description: Verifies CO Sales tax & fee on Taxable with CO Shipping Address 
    * and Non-CO Billing Address Registered Order
    * Author: Paul Patterson
    * Status: Complete
    * Ticket: JMB-6375
    * @throws Exception 
    * ***************************************************************/
    @Test (priority = 7)
    public void coloradoSalesTaxAndFeeCOShippingAddressAndNonCOBillingAddress_Reg() throws Exception {
      String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
      Q_JMB_Controls.testStarted(tcName);
      acc.loginUser(54);
      prod.productsController(tcName, 1);
      cart.paymentType("cart.paymentType.CC.id");
      cart.selectcheckoutBtn("bottom");
      chk.selectCard("visa", "321");
      chk.changeBillingAddressButton();
      chk.clickSelectFirstBillingAddress();
      ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert));
      ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert));
      chk.completeOrder();
      chk.thankYouPage();
      ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert));
      chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
      ArrayList<Float> myAccountPrices = new ArrayList<>(acc.myAccountPriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert));
      chk.compareCheckoutToOtherPageRev("My Account", priceList, reviewPrices, myAccountPrices);
      ArrayList<Float> adminPrices = new ArrayList<>(adm.adminOrderPriceList("qa+cosalestax@jmbulllion.com", hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert, 1));
      chk.compareCheckoutToOtherPageRev("Admin Order", priceList, reviewPrices, adminPrices);
      ArrayList<Float> adminInvoicePrices = new ArrayList<>(adm.adminOrderInvoicePriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert, 1));
      chk.compareCheckoutToOtherPageRev("Admin Order Invoice", priceList, reviewPrices, adminInvoicePrices);
      ArrayList<Float> adminClaimInvoicePrices = new ArrayList<>(adm.adminOrderClaimInvoicePriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert, 1));
      chk.compareCheckoutToOtherPageRev("Admin Order Claim Invoice", priceList, reviewPrices, adminClaimInvoicePrices);
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee on taxable Product Taxable order with gift certificate Registered User
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test(priority = 8)
    public void coloradoSalesTaxAndFeeTaxableItemWithGiftCert_Reg() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(54);
        prod.productsController(tcName, 1);
        cart.paymentType("cart.paymentType.PC.id");
        hasGiftCert = true;
        cart.applyGiftCertificate();
        cart.selectcheckoutBtn("bottom");
        ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
        ArrayList<Float> myAccountPrices = new ArrayList<>(acc.myAccountPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("My Account", priceList, reviewPrices, myAccountPrices);
        ArrayList<Float> adminPrices = new ArrayList<>(adm.adminOrderPriceList("qa+cosalestax@jmbulllion.com", hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order", priceList, reviewPrices, adminPrices);
        ArrayList<Float> adminInvoicePrices = new ArrayList<>(adm.adminOrderInvoicePriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order Invoice", priceList, reviewPrices, adminInvoicePrices);
        ArrayList<Float> adminClaimInvoicePrices = new ArrayList<>(adm.adminOrderClaimInvoicePriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order Claim Invoice", priceList, reviewPrices, adminClaimInvoicePrices);
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee on silver artwork Product Taxable order Guest User
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test(priority = 9)
    public void coloradoSalesTaxAndFeeArtworkTaxable_Guest() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        prod.productsController(tcName, 1);
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa+COGuestTest@jmbullion.com");
        chk.shippingAddressForm(36);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee on accessories Product Taxable Guest User
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test(priority = 10)
    public void coloradoSalesTaxAndFeeAccessoriesTaxable_Guest() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        prod.productsController(tcName, 1);
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa+COGuestTest@jmbullion.com");
        chk.shippingAddressForm(36);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee on Copper order Guest User
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test(priority = 11)
    public void coloradoSalesTaxAndFeeCopperTaxable_Guest() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        prod.productsController(tcName, 1);
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa+COGuestTest@jmbullion.com");
        chk.shippingAddressForm(36);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee on Multiple Products Order Guest
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test(priority = 12)
    public void coloradoSalesTaxAndFeeMultipleTaxable_Guest() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        prod.productsController(tcName, 1);
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa+COGuestTest@jmbullion.com");
        chk.shippingAddressForm(36);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee Verify fee does not change Guest
     * 		on product qty change Guest User
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test (priority = 13)
    public void coloradoSalesTaxAndFeeVerifyFeeDoesNotChangeOnQtyChange_Guest() throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       prod.productsController(tcName, 1);
       cart.paymentType("cart.paymentType.PC.id");
       cart.selectcheckoutBtn("bottom");
       chk.bridgeGuest();
       chk.guestEmail("qa+COGuestTest@jmbullion.com");
       chk.shippingAddressForm(36);
       chk.saveShippingAddress();
       chk.verifyStateFeeValue(stateFee);
       prod.productsController(tcName, 2);
       cart.paymentType("cart.paymentType.PC.id");
       cart.selectcheckoutBtn("bottom");
       chk.bridgeGuest();
       chk.verifyStateFeeValue(stateFee);
       prod.productsController(tcName, 3);
       cart.paymentType("cart.paymentType.PC.id");
       cart.selectcheckoutBtn("bottom");
       chk.bridgeGuest();
       chk.verifyStateFeeValue(stateFee);
       chk.guestEmail("qa+COGuestTest@jmbullion.com");
       chk.creditCardForm(2);
       ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       chk.completeOrder();
       chk.thankYouPage();
       ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
    }
   
   /*******************************************************************
    * Description: Verifies CO Sales tax & fee on Taxable and Non-Taxable product Order Registered User
    * Author: Paul Patterson
    * Status: Complete
    * Ticket: JMB-6375
    * @throws Exception 
    * ***************************************************************/
    @Test (priority = 14)
    public void coloradoSalesTaxAndFeeTaxableAndNonTaxable_Guest() throws Exception {
      String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
      Q_JMB_Controls.testStarted(tcName);
      prod.productsController(tcName, 1);
      cart.paymentType("cart.paymentType.PC.id");
      cart.selectcheckoutBtn("bottom");
      chk.bridgeGuest();
      chk.guestEmail("qa+COGuestTest@jmbullion.com");
      chk.shippingAddressForm(36);
      chk.saveShippingAddress();
      chk.creditCardForm(2);
      ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert));
      ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert));
      chk.completeOrder();
      chk.thankYouPage();
      ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert));
      chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee on Taxable with CO Shipping Address 
     * and Non-CO Billing Address Guest Order
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test (priority = 15)
    public void coloradoSalesTaxAndFeeCOShippingAddressAndNonCOBillingAddress_Guest() throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       prod.productsController(tcName, 1);
       cart.paymentType("cart.paymentType.CC.id");
       cart.selectcheckoutBtn("bottom");
       chk.bridgeGuest();
       chk.guestEmail("qa+COGuestTest@jmbullion.com");
       chk.shippingAddressForm(36);
       chk.saveShippingAddress();
       chk.creditCardForm(2);
       chk.verifyBillingAddressField();
       chk.changeBillingAddressButton();
       chk.clickAddNewBillAddress();
       chk.billingAddressForm(6);
       chk.saveBillingAddress();
       ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       chk.completeOrder();
       chk.thankYouPage();
       ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee on taxable Product Taxable order with gift certificate Guest User
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test(priority = 16)
    public void coloradoSalesTaxAndFeeTaxableItemWithGiftCert_Guest() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        prod.productsController(tcName, 1);
        cart.paymentType("cart.paymentType.PC.id");
        hasGiftCert = true;
        cart.applyGiftCertificate();
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa+COGuestTest@jmbullion.com");
        chk.shippingAddressForm(36);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
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
