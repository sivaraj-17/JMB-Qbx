package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Q_PM_CartSteps extends Q_PM_Init {

    public static void formIntegerInputXp(String locator, Integer inputValue) {
        Q_PM_WebElm.xpClear(pmQaProps, locator);
        Q_PM_WebElm.xpSend(pmQaProps, locator, String.valueOf(inputValue));

    }
    public static void formXp(String locator) {
        Q_PM_WebElm.xp(pmQaProps, locator);

    }
    
    
//    public static void addProductpageItemToCart(Integer quan){
////        driver.navigate().to(base + productURL);
//        formIntegerInputXp("productPageQty.xp", quan);
//        Q_WebElm.myWait(1000);
//        formXp("productpage.AddToCart.xp");
////        formXp("modalCheckoutNow.xp");
//        Q_WebElm.cn(pmQaProps, "modalCheckoutBtn.className");
//
//    }
    //*******************************************************************
    // * Description: Add to Cart
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void clickATC(String atcLocator, String checkout) {

        Q_PM_WebElm.xp(pmQaProps, atcLocator);
        Q_PM_WebElm.xp(pmQaProps, checkout);

    }

    //*******************************************************************
    // * Description: Add to Cart
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void addToCart(String begQty , Integer item, String endQty, String quan, String endatc, String checkout) {

        Q_PM_WebElm.xpSend(pmQaProps, begQty, item, endQty, quan);
        //WebElm.xp(pmQaProps, atcLocator);
//        WebElm.xp(pmQaProps, atcLocator);
        Q_PM_WebElm.xp(pmQaProps, begQty, item, endatc);
        System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "cart.modalAmount.className").replaceAll("[^0-9?!\\.]",""));
        Q_PM_WebElm.myWait(5000);
        Q_PM_WebElm.cn(pmQaProps, checkout);

    }
    public static void addToCart(String begQty , Integer item, String endQty, String quan, String endatc) {

        Q_PM_WebElm.xpSend(pmQaProps, begQty, item, endQty, quan);
        //WebElm.xp(pmQaProps, atcLocator);
//        WebElm.xp(pmQaProps, atcLocator);
        Q_PM_WebElm.xp(pmQaProps, begQty, item, endatc);
        System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "cart.modalAmount.className").replaceAll("[^0-9?!\\.]",""));

    }
    //*******************************************************************
    // * Description: Return List Price from modal
    // * Param:
    // * Returns: String
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static List<Float> modalPrice() {

        List<Float> priceList = new ArrayList<Float>();

        Q_PM_WebElm.id(pmQaProps, "cart.modalPricingList.id");
        Q_PM_WebElm.xp(pmQaProps, "cart.modalCcPrice.xp");
        Float listPrice = Float.valueOf(Q_PM_WebElm.cnRetText(pmQaProps, "cart.modalAmount.className").replaceAll("[^0-9?!\\.]",""));
        Q_PM_WebElm.myWait(2000);


        Q_PM_WebElm.id(pmQaProps, "cart.modalPricingList.id");
        Q_PM_WebElm.xp(pmQaProps, "cart.modalBitcoinPrice.xp");
        Float achPrice = Float.valueOf(Q_PM_WebElm.cnRetText(pmQaProps, "cart.modalAmount.className").replaceAll("[^0-9?!\\.]",""));
        Q_PM_WebElm.myWait(2000);


        Q_PM_WebElm.id(pmQaProps, "cart.modalPricingList.id");

        Q_PM_WebElm.xp(pmQaProps, "cart.modalAchBwChPrice.xp");
        Float bitPrice = Float.valueOf(Q_PM_WebElm.cnRetText(pmQaProps, "cart.modalAmount.className").replaceAll("[^0-9?!\\.]",""));
        Q_PM_WebElm.myWait(2000);

        priceList.add(listPrice);
        priceList.add(bitPrice);
        priceList.add(achPrice);
        return priceList;
    }
    //*******************************************************************
    // * Description: Modal Pricing
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static Boolean modalPricingList(ArrayList pl) {
        System.out.println(pl);
        float achPrice = (float) pl.get(0);
        System.out.println(achPrice);
        float bitPrice = (float) pl.get(1);
        System.out.println(bitPrice);
        float listPrice = (float) pl.get(2);
        System.out.println(listPrice);

        if((listPrice > bitPrice) && (bitPrice > achPrice)){
            return true;
        }
        else
            return false;
    }
    //*******************************************************************
    // * Description: Product page Pricing
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static List<Float> pdpPricingList(String beg, String end) {
        List priceList = new ArrayList<Float>();

        Float achPrice = Float.valueOf(Q_PM_WebElm.xpRetText(pmQaProps, beg, 2, end).replaceAll("[^0-9?!\\.]",""));
        Float bitPrice = Float.valueOf(Q_PM_WebElm.xpRetText(pmQaProps, beg, 3, end).replaceAll("[^0-9?!\\.]",""));
        Float listPrice = Float.valueOf(Q_PM_WebElm.xpRetText(pmQaProps, beg, 4, end).replaceAll("[^0-9?!\\.]",""));
        priceList.add(achPrice);
        priceList.add(bitPrice);
        priceList.add(listPrice);
        System.out.println(priceList);
        return priceList;
    }
    //*******************************************************************
    // * Description: Return List Price from cart
    // * Param:
    // * Returns: String
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static List<Float> cartPricingList() {
        List<Float> priceList = new ArrayList<Float>();

        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Float listPrice = Float.valueOf(Q_PM_WebElm.xpRetText(pmQaProps, "cart.cartPrice.xp").replaceAll("[^0-9?!\\.]",""));


        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim_echeck");
        Float achPrice = Float.valueOf(Q_PM_WebElm.xpRetText(pmQaProps, "cart.cartPrice.xp").replaceAll("[^0-9?!\\.]",""));

        Q_PM_CheckoutSteps.selectPaymentType("bitpay");
        Float bitPrice = Float.valueOf(Q_PM_WebElm.xpRetText(pmQaProps, "cart.cartPrice.xp").replaceAll("[^0-9?!\\.]",""));
        priceList.add(achPrice);
        priceList.add(bitPrice);
        priceList.add(listPrice);
        return priceList;
    }
    //*******************************************************************
    // * Description: Increase quantity in modal
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void modalPlus(String begQty , Integer item, String endQty, String quan, String atcLocator) {
        Q_PM_WebElm.xpSend(pmQaProps, begQty, item, endQty, quan);
        Q_PM_WebElm.xp(pmQaProps, atcLocator);
        Integer modalquan = Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.modalquantity.xp", "value"));

        System.out.println("before quantity " + modalquan);
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.xp(pmQaProps, "cart.modalPlus.xp");
        System.out.println("after quantity " + Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.modalquantity.xp", "value")));
        System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "cart.modalAmount.className").replaceAll("[^0-9?!\\.]",""));
        Q_PM_WebElm.myWait(2000);
        Assert.assertTrue(Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.modalquantity.xp", "value")).equals(modalquan + 1));
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }
    //*******************************************************************
    // * Description: Increase quantity in modal
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void modalMinus(String begQty , Integer item, String endQty, String quan, String endATC) {
        Q_PM_WebElm.xpSend(pmQaProps, begQty, item, endQty, quan);
        Q_PM_WebElm.xp(pmQaProps, begQty, item, endATC);
        Integer modalquan = Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.modalquantity.xp", "value"));
        System.out.println("before quantity " + modalquan);
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.xp(pmQaProps, "cart.modalMinus.xp");
        Q_PM_WebElm.myWait(2000);
        System.out.println("after quantity " + Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.modalquantity.xp", "value")));
        Assert.assertTrue(Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.modalquantity.xp", "value")).equals(modalquan - 1));
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }
    //*******************************************************************
    // * Description: Add to cart from product page
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void atcPDP(String quan, String checkout) {
        //NavigationSteps.category("firstLevel", 2, 4);
        Q_PM_NavigationSteps.productItem(1);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdpQty.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.pdpQty.xp", quan);
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.cn(pmQaProps, checkout);

    }
    //*******************************************************************
    // * Description: Increase quantity in pdp
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void pdpPlus(String quan, String checkout) {

        Q_PM_NavigationSteps.productItem(1);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdpQty.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.pdpQty.xp", quan);
        Integer pdpquan = Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.pdpQty.xp", "value"));
        System.out.println("before quantity " + pdpquan);
        Q_PM_WebElm.xp(pmQaProps, "cart.pdpPlus.xp");
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        System.out.println("after quantity " + Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.modalquantity.xp", "value")));
        Assert.assertTrue(Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.modalquantity.xp", "value")).equals(pdpquan + 1));
        Q_PM_WebElm.cn(pmQaProps, checkout);
    }
    //*******************************************************************
    // * Description: Decrease quantity in pdp
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void pdpMinus(String quan , String checkout) {
        Q_PM_NavigationSteps.productItem(1);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdpQty.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.pdpQty.xp", quan);
        Integer pdpquan = Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.pdpQty.xp", "value"));
//
        System.out.println("before quantity " + pdpquan);
        Q_PM_WebElm.xp(pmQaProps, "cart.pdpMinus.xp");
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        System.out.println("after quantity " + Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.modalquantity.xp", "value")));
        Assert.assertTrue(Integer.valueOf(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.modalquantity.xp", "value")).equals(pdpquan - 1));
        Q_PM_WebElm.cn(pmQaProps, checkout);
    }
    //*******************************************************************
    // * Description: Verify Cart Content
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void verifyCartItem(String description,String quan) {
        int count = Q_PM_WebElm.xpCountTableRows(pmQaProps, "cart.cartRows.xp") ;
        System.out.println("Total items in cart:" + count);
        Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "cart.cartProductDesciption.xp").contains(description));
        System.out.println("Item description: " + Q_PM_WebElm.xpRetText(pmQaProps, "cart.cartProductDesciption.xp"));
        Assert.assertEquals(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.cartItemQty.xp", "value"), quan);
        System.out.println("Item Count: " + Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.cartItemQty.xp", "value"));
    }
    //*******************************************************************
    // * Description: Verify cart Content
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void verifyCartItems() {
        String[] description = {"1 oz US American Gold Eagle Coin","10 oz Gold Bar","1994 1 oz American Silver Eagle",
                "Peace Silver Dollars | PCGS MS64","100 oz .999 Fine Silver Bar","1 oz US American Platinum Eagle Coin | Random Year"};
        String[] qunatity = {"6","2","6","8","2","1"};
        int count = Q_PM_WebElm.xpCountTableRows(pmQaProps, "cart.cartRows.xp");
        System.out.println("Total items in cart:" + (count - 3));
        for(int i=2; i < count -1; i++){
            Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "cart.begCartDesc.xp", i, "cart.endCartDesc.xp").contains(description[i-2]));
            System.out.println("Item description: " + Q_PM_WebElm.xpRetText(pmQaProps, "cart.begCartDesc.xp", i, "cart.endCartDesc.xp"));
            Assert.assertEquals(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.begCartQty.xp", i, "cart.endCartQty.xp", "value"),qunatity[i-2]);
            System.out.println("Item Quantity: " + Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.begCartQty.xp", i, "cart.endCartQty.xp", "value"));
        }

    }
    //*******************************************************************
    // * Description: Verify Edit cart
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void verifyEditCart() {
        String[] description = {"1 oz US American Gold Eagle Coin","10 gram Perth Mint Gold Bar",
                "1994 1 oz American Silver Eagle"};
        String[] qunatity = {"3","2","2"};
        int count = Q_PM_WebElm.xpCountTableRows(pmQaProps, "cart.cartRows.xp");

//        System.out.println("Total items in cart:" + (count - 3));
//        System.out.println("Total items in cart:" + count);
        for(int i=2; i < count -2; i++){
            switch(i){
                case  2:
                    Q_PM_WebElm.myWait(1000);
                    Q_PM_WebElm.xpClear(pmQaProps, "cart.begCartDesc.xp", i, "cart.endCartQty.xp");
                    Q_PM_WebElm.xpSend(pmQaProps, "cart.begCartDesc.xp", i, "cart.endCartQty.xp", "3");
                    Q_PM_WebElm.xp(pmQaProps, "cart.begCartDesc.xp", i, "cart.endCartUpdate.xp");
                    break;
                case  3:
                    Q_PM_WebElm.myWait(1000);
                    Q_PM_Controls.scrolDownPixel(500);
                    Q_PM_WebElm.xp(pmQaProps, "cart.begCartDesc.xp", i, "cart.endCartMinus.xp");
                    Q_PM_WebElm.myWait(1000);
                    Q_PM_WebElm.xp(pmQaProps, "cart.begCartDesc.xp", i, "cart.endCartUpdate.xp");
                    break;
                case  4:
                    Q_PM_WebElm.xp(pmQaProps, "cart.begCartDesc.xp", i, "cart.endCartPlus.xp");
                    Q_PM_WebElm.xp(pmQaProps, "cart.begCartDesc.xp", i, "cart.endCartUpdate.xp");
                    break;
                case  5:
                    Q_PM_WebElm.xp(pmQaProps, "cart.begCartDesc.xp", i, "cart.endCartRemove.xp");
                    break;
                default:
                    break;
            }

            System.out.println("Item description: " + Q_PM_WebElm.xpRetText(pmQaProps, "cart.begCartDesc.xp", i, "cart.endCartDesc.xp"));
            Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "cart.begCartDesc.xp", i, "cart.endCartDesc.xp").contains(description[i-2]));
            System.out.println("Item Count: " + Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.begCartQty.xp", i, "cart.endCartQty.xp", "value"));
            Assert.assertTrue(Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.begCartQty.xp", i, "cart.endCartQty.xp", "value").equals(qunatity[i-2]));
        }

    }
    //*******************************************************************
    // * Description: Delete single Item from cart
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void paymentType(String condition, ArrayList pt) {
    //public static void paymentType(String condition) {
        Q_PM_WebElm.cn(pmQaProps, "cart.paymentType.className");
        System.out.println("Number of options available:  " + Q_PM_WebElm.cnReturnAllOptions(pmQaProps, "cart.paymentType.className").size());
        for(int i=0; i < pt.size(); i++) {
            System.out.println("Expected;  " + Q_PM_WebElm.cnReturnAllOptions(pmQaProps, "cart.paymentType.className").get(i) +"\t Actual;  " + pt.get(i));
            Assert.assertTrue(Q_PM_WebElm.cnReturnAllOptions(pmQaProps, "cart.paymentType.className").get(i).equals(pt.get(i)));
        }
        }
    //*******************************************************************
    // * Description: Multiple quantity price verification
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void multipleSubtotal(String pmType) {
        Q_PM_CartSteps.cartPricingList();
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CartSteps.cartPricingList());
        System.out.println(prices);

        Float wirePrice = prices.get(0);
        Float bitPayPrice = prices.get(1);
        Float ccPrice = prices.get(2);
//        System.out.println(df.format(ccPrice));
//        System.out.println(df.format(wirePrice));
//        System.out.println(df.format(bitPayPrice));
        DecimalFormat df = new DecimalFormat("#.00");
        switch(pmType){
            case "credit":
                Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
                Q_PM_WebElm.myWait(2000);
                System.out.println("Expected " + df.format(ccPrice * 9) + "  Actual " + df.format(Float.valueOf(Q_PM_WebElm.cnRetText(pmQaProps, "cart.cartSubtotal.className").replaceAll("[^0-9?!\\.]",""))));
                Assert.assertEquals(df.format(ccPrice * 9), df.format(Float.valueOf(Q_PM_WebElm.cnRetText(pmQaProps, "cart.cartSubtotal.className").replaceAll("[^0-9?!\\.]",""))));
                Q_PM_WebElm.myWait(500);
                break;
            case "wire":
                Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim_echeck");
                Q_PM_WebElm.myWait(2000);
                System.out.println("Expected " + df.format(wirePrice * 9) + "  Actual " + df.format(Float.valueOf(Q_PM_WebElm.cnRetText(pmQaProps, "cart.cartSubtotal.className").replaceAll("[^0-9?!\\.]",""))));
                Assert.assertEquals(df.format(wirePrice * 9), df.format(Float.valueOf(Q_PM_WebElm.cnRetText(pmQaProps, "cart.cartSubtotal.className").replaceAll("[^0-9?!\\.]",""))));
                Q_PM_WebElm.myWait(500);
                break;
            case "bitPay":
                Q_PM_CheckoutSteps.selectPaymentType("bitpay");
                Q_PM_WebElm.myWait(2000);
                System.out.println("Expected " + df.format(bitPayPrice * 9) + "  Actual " + df.format(Float.valueOf(Q_PM_WebElm.cnRetText(pmQaProps, "cart.cartSubtotal.className").replaceAll("[^0-9?!\\.]",""))));
                Assert.assertEquals(df.format(bitPayPrice * 9), df.format(Float.valueOf(Q_PM_WebElm.cnRetText(pmQaProps, "cart.cartSubtotal.className").replaceAll("[^0-9?!\\.]",""))));
                Q_PM_WebElm.myWait(500);
                break;

        }
    }
    //*******************************************************************
    // * Description: Apply Coupon
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void applyCoupon() {
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.couponCode.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.couponCode.xp", "Automation");
        Q_PM_WebElm.xp(pmQaProps, "cart.couponBtn.xp");
        System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "cart.woocomerceMessage.className"));
        Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "cart.woocomerceMessage.className").contains("applied successfully"));
        Assert.assertEquals(Q_PM_WebElm.xpRetText(pmQaProps, "cart.couponAmount.xp").replaceAll("[^0-9?!\\.]",""),("10.00"));
        Q_PM_WebElm.myWait(1000);
    }
    public static void applyCoupon(String coupon,String couponValidation) {
        Q_PM_WebElm.myWait(500);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.couponCode.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.couponCode.xp", coupon);
        Q_PM_WebElm.xp(pmQaProps, "cart.couponBtn.xp");
        System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "cart.woocomerceMessage.className"));
        Assert.assertNotEquals(Q_PM_WebElm.cnRetText(pmQaProps, "cart.woocomerceMessage.className"), "applied successfully");
        Assert.assertEquals(Q_PM_WebElm.xpRetText(pmQaProps, "cart.couponAmount.xp").replaceAll("[^0-9?!\\.]",""),(couponValidation));
    }
    //*******************************************************************
    // * Description: Remove Coupon
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void removeCoupon() {
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.couponCode.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.couponCode.xp", "Automation");
        Q_PM_WebElm.xp(pmQaProps, "cart.couponBtn.xp");
        System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "cart.woocomerceMessage.className"));
        Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "cart.woocomerceMessage.className").contains("applied successfully"));
        Q_PM_WebElm.cn(pmQaProps, "cart.removeCoupon.className");
        Q_PM_WebElm.myWait(4000);
        System.out.println("Cart Subtotal " + Q_PM_WebElm.cnRetText(pmQaProps, "cart.cartSubtotal.className").replaceAll("[^0-9?!\\.]",""));
        System.out.println("Cart Total " + Q_PM_WebElm.cnRetText(pmQaProps, "cart.cartTotal.className").replaceAll("[^0-9?!\\.]",""));
        Assert.assertEquals(Q_PM_WebElm.cnRetText(pmQaProps, "cart.cartSubtotal.className").replaceAll("[^0-9?!\\.]",""), Q_PM_WebElm.cnRetText(pmQaProps, "cart.cartTotal.className").replaceAll("[^0-9?!\\.]",""));
    }
    //*******************************************************************
    // * Description: Delete single Item from cart
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void deleteItem() {
        try{
            Q_PM_WebElm.xp(pmQaProps, "cart.removeItem.xp");
            System.out.println("Item deleted from cart");
        }
        catch (Throwable ex){
            System.out.println("Cart has items");
        }
    }

    //*******************************************************************
    // * Description: Add item in product page
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public static void addProductpageItemToCart(Integer quan){
//        driver.navigate().to(base + productURL);
        formIntegerInputXp("prod.productPageQty.xp", quan);
        Q_PM_WebElm.myWait(1000);
        formXp("prod.productpage.AddToCart.xp");
    }
    //*******************************************************************
    // * Description: Remove Coupon
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public static void addProductpageItemToCart(String product, Integer quan){
        driver.navigate().to(baseUrl + product);
        formIntegerInputXp("prod.productPageQty.xp", quan);
        Q_PM_WebElm.myWait(1000);
        formXp("prod.productpage.AddToCart.xp");
//        formXp("modalCheckoutNow.xp");

    }
    public static void modalChekcout(){
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }
    public static void increaseCartQuantity(Integer quan){
        Q_PM_WebElm.xpClear(pmQaProps, "cart.quantityInput.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.quantityInput.xp", String.valueOf(quan));
        Q_PM_WebElm.xp(pmQaProps, "cart.updateBtn.xp");
    }
    //*******************************************************************
    // * Description: Taxable products
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public Q_PM_CartSteps selectTaxableItem(String item, Integer quan) throws Exception {
        Q_PM_TicketsObjects ticket = new Q_PM_TicketsObjects();
        switch ( item ) {

            case ("Palladium"):
                driver.navigate().to(baseUrl + "/canada-maple-leaf-1-oz-9995-fine-palladium.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
                Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
                ArrayList<Float> revPalladium = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
                Q_PM_WebElm.idSend(pmQaProps, "chk.cdCvv.id", "122");
                Q_PM_CheckoutSteps.completeOrder();

                ArrayList<Float> orderPalladium = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
                //System.out.println(orderPrices);
                Q_PM_CheckoutSteps.verifyOrderCharges(revPalladium, orderPalladium);
                //AccountSteps.accountMenu("LOGOUT", 3);
                break;
            case ("Palladium Coin Below 500"):
                driver.navigate().to(baseUrl + "/2018-w-1-oz-proof-american-palladium-eagle-coin-ngc-pf70-ucam-er/");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
                Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
                Q_PM_CheckoutSteps.itemTax();
                ArrayList<Float> revPalladiumCoin = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());
                Q_PM_WebElm.idSend(pmQaProps, "chk.cdCvv.id", "122");
                Q_PM_CheckoutSteps.completeOrder();

                ArrayList<Float> orderPalladiumCoin = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());
                //System.out.println(orderPrices);
                Q_PM_CheckoutSteps.verifyOrderCharges(revPalladiumCoin, orderPalladiumCoin);
                //AccountSteps.accountMenu("LOGOUT", 3);
                break;
            case("silver artwork"):
                driver.navigate().to(baseUrl + "/stackable-prospector-5-oz-silver-round-silvertowne.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
                Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
                Q_PM_CheckoutSteps.itemTax();
                ArrayList<Float> revartwork = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());
                //System.out.println(prices);
                Q_PM_WebElm.idSend(pmQaProps, "chk.cdCvv.id", "122");
                Q_PM_CheckoutSteps.completeOrder();
                ArrayList<Float> orderartwork = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());
                //System.out.println(orderPrices);
                Q_PM_CheckoutSteps.verifyOrderCharges(revartwork, orderartwork);
                //AccountSteps.accountMenu("LOGOUT", 3);
                break;
            case("silver skull") :
                driver.navigate().to(baseUrl + "/2-oz-silver-round-deuce-four-skull.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
                Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
                Q_PM_CheckoutSteps.itemTax();
                ArrayList<Float> revSilverSkull = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());
                //System.out.println(prices);
                Q_PM_WebElm.idSend(pmQaProps, "chk.cdCvv.id", "122");
                Q_PM_CheckoutSteps.completeOrder();
                ArrayList<Float> orderSilverSkull = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());
                //System.out.println(orderPrices);
                Q_PM_CheckoutSteps.verifyOrderCharges(revSilverSkull, orderSilverSkull);
                //AccountSteps.accountMenu("LOGOUT", 3);
                break;

            case("39mm coin tube") :
                driver.navigate().to(baseUrl + "/medallion-silver-round-tube-39mm-coinsafe.html");
                //  /silver-dollar-tubes-coinsafe-morgan-dollar-tube.html
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
                Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
                Q_PM_CheckoutSteps.itemTax();
                ArrayList<Float> revCoinTube = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());
                //System.out.println(prices);
                Q_PM_WebElm.idSend(pmQaProps, "chk.cdCvv.id", "122");
                Q_PM_CheckoutSteps.completeOrder();
                ArrayList<Float> orderCoinTube = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());
                //System.out.println(orderPrices);
                Q_PM_CheckoutSteps.verifyOrderCharges(revCoinTube, orderCoinTube);
                //AccountSteps.accountMenu("LOGOUT", 3);
                break;
            case("copperMapleLeaf"):
                driver.navigate().to(baseUrl + "/maple-leaf-1-oz-copper-round.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
                Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
                Q_PM_CheckoutSteps.itemTax();
                ArrayList<Float> revCopperUSQuarter = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());
                //System.out.println(prices);
                Q_PM_WebElm.idSend(pmQaProps, "chk.cdCvv.id", "122");
                Q_PM_CheckoutSteps.completeOrder();
                ArrayList<Float> orderCopperUSQuarter = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());
                //System.out.println(orderPrices);
                Q_PM_CheckoutSteps.verifyOrderCharges(revCopperUSQuarter, orderCopperUSQuarter);
                //AccountSteps.accountMenu("LOGOUT", 3);
                break;

            case ("all taxable metal"):
                driver.navigate().to(baseUrl + "/canada-maple-leaf-1-oz-9995-fine-palladium.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                driver.navigate().to(baseUrl + "/stackable-prospector-5-oz-silver-round-silvertowne.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                driver.navigate().to(baseUrl + "/medallion-silver-round-tube-39mm-coinsafe.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                driver.navigate().to(baseUrl + "/maple-leaf-1-oz-copper-round.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                Q_PM_CheckoutSteps.selectPaymentType("cheque");
                Q_PM_CheckoutSteps.selectCheckoutBtn("top", "cart.topCheckoutBtn.className");
                Q_PM_CheckoutSteps.itemTax();
                ArrayList<Float> revPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());
                Q_PM_CheckoutSteps.completeOrder();
                ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());
                //System.out.println(orderPrices);
                Q_PM_CheckoutSteps.verifyOrderCharges(revPrices, orderPrices);
                break;
//            case("") :
//
//                break;

        }
        return this;
    }

    //*******************************************************************
    // * Description: Delete single Item from cart
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void deleteItems() {
        Q_PM_WebElm.myWait(2000);
//        try {
//            if(WebElm.xpDisplayed(pmQaProps,"backToCart.xp"))
//                driver.navigate().to(baseUrl);
//        } catch (Throwable ex) {
//            System.out.println("Current URL not checkout page");
//        }
        driver.navigate().to(baseUrl);
        if (Integer.valueOf(Q_PM_WebElm.xpRetText(pmQaProps, "cart.quickCartCount.xp")) > 0){
            System.out.println("Total items in cart:" + Integer.valueOf(Q_PM_WebElm.xpRetText(pmQaProps, "cart.quickCartCount.xp")));
            int count = Integer.valueOf(Q_PM_WebElm.xpRetText(pmQaProps, "cart.quickCartCount.xp"));
            System.out.println("Total items in cart:" + count);
//            Controls.scrolUpPixel(500);
            Q_PM_WebElm.xp(pmQaProps, "cart.quickCartCount.xp");
            for(int i=2; i <= count +1; i++) {
                try {
                    Q_PM_WebElm.xp(pmQaProps, "cart.removeItem.xp");
                    System.out.println("Item deleted from cart");
                } catch (Throwable ex) {
                    System.out.println("Cart has items");
                }
            }
        }
    }
    public static void paperCheckCartLanguage() {
        // 	 String s1= "Ships within 4-6 Business Days After Payment Received/Processed";
        String s1= "Ships Within 4-6 Business Days After Receipt of Payment";
        String s2 = "Paper Check orders have a $0.00 order minimum and a $75,000.00 order maximum.\n" +
                "Order Confirmation Email will include all information necessary to complete payment.";
        String s3 = "Due to unprecedented USPS delays delivering paper checks, we highly recommend choosing eCheck (ACH) or Bank Wire as your payment type.";
        // String s4 = "All Paper Check Orders Receive a 4% Discount Relative to Credit Card/PayPal Pricing";
        String s4 = "All Paper Check Orders Receive a 4% Discount Relative to Card/PayPal Pricing";
        String s5 = "May Require a Credit Card on File to Lock in Pricing";
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.pc.heading.xp"));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.pc.line1.xp"));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.pc.line2.xp"));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.pc.line3.xp"));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.pc.line4.xp"));
        Assert.assertEquals(s1, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.pc.heading.xp"));
        Assert.assertEquals(s2, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.pc.line1.xp"));
        Assert.assertEquals(s3, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.pc.line2.xp"));
        Assert.assertEquals(s4, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.pc.line3.xp"));
        Assert.assertEquals(s5, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.pc.line4.xp"));
    }
    public static void achCartLanguage() {
        //  String s1= "Ships within 3-5 Business Days After Funds Clear";
        String s1= "Ships Within 3-5 Business Days After Receipt of Payment";
        String s2 = "eCheck/ACH orders have no order minimum and a $75,000.00 order maximum";
        String s3 = "Easier and Faster Than Paper Check";
        String s4 = "All eCheck (ACH) Orders Receive a 4% Discount vs. Card/PayPal Pricing";
        String s5 = "Pay Online Instantly by Linking Your Checking Account to Your Provident Account";
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.ach.heading.xp"));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.ach.line1.xp"));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.ach.line2.xp"));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.ach.line3.xp"));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.ach.line4.xp"));
        Assert.assertEquals(s1, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.ach.heading.xp"));
        Assert.assertEquals(s2, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.ach.line1.xp"));
        Assert.assertEquals(s3, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.ach.line2.xp"));
        Assert.assertEquals(s4, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.ach.line3.xp"));
        Assert.assertEquals(s5, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.ach.line4.xp"));
    }
    public static void wireCartLanguage()
    {
//    	   	 String s1= "Ships within 1 Business Day";
        String s1= "Ships Within 1 Business Day";
        String s2 = "Bank Wires are approved for orders between $1,000.00 and $500,000.00. Order Confirmation Email will include all information necessary to complete payment";
        String s3= "Fastest Method from Your Bank Account";
//    	   	 String s4 = "All Bank Wire Orders Receive a 4% Discount Relative to Credit Card/Paypal Pricing";
        String s4 = "All Bank Wire Orders Receive a 4% Discount Relative to Card/Paypal Pricing";
        String s5 = "Bank Wires May Require a Trip to Your Bank. Must Send a Wire, not eCheck (ACH).";
        String s6 = "May Require a Credit Card on File to Lock in Pricing";
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.wire.heading.xp"));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.wire.line1.xp"));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.wire.line2.xp"));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.wire.line3.xp"));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.wire.line4.xp"));
        Assert.assertEquals(s1, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.wire.heading.xp"));
        Assert.assertEquals(s2, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.wire.line1.xp"));
        Assert.assertEquals(s3, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.wire.line2.xp"));
        Assert.assertEquals(s4, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.wire.line3.xp"));
        Assert.assertEquals(s5, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.wire.line4.xp"));
        Assert.assertEquals(s6, Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.wire.line5.xp"));
    }

    public static void continueShoppingButton(){
        boolean isModalDisplayed= Q_PM_WebElm.cnDisplayed(pmQaProps, "cart.pm.checkoutModal.cn");
        if(isModalDisplayed)
        {
            Assert.fail("Continue Button is not working");
        }
        else
        {
            System.out.println("Continue Button does it's duty - The checkout modal diappears!");
        }
    }

    //JMB-4831 Start
    //*******************************************************************
    // * Description: Verify Continue Shopping Button
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public static void clickATCAndStay(String metal )
    {

        Q_PM_NavigationSteps.selectMetal(metal);
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("firstLevel", 1, 2);
        Q_PM_NavigationSteps.category("secondLevel", 1, 2);
        Q_PM_NavigationSteps.category("thirdLevel", 2, 4);
        Q_PM_WebElm.myWait(4000);
        Q_PM_WebElm.xpSend(pmQaProps, "cart.begCatQuan.xp",1, "cart.endCatQuan.xp", "1");
        Q_PM_WebElm.myWait(4000);
        Q_PM_WebElm.xp(pmQaProps, "cart.begCatQuan.xp", 1, "cart.endCatQuan.xp");
        Q_PM_WebElm.myWait(4000);
        Q_PM_WebElm.xp(pmQaProps, "cart.pm.addToCart.xp");

    }
    //JMB-4831 End

    //JMB-5908 End
    public static float checkPrice() {
        float checkPrice = Float.valueOf(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.products.listLowToHigh.Check.Price.xp").replaceAll("[^0-9?!\\.]", ""));
//        System.out.println("checkPrice " + checkPrice);
        return checkPrice;
    }
    public static float cryptoPrice() {
        float bitCoinPrice = Float.valueOf(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.products.listLowToHigh.Bitcoin.Price.xp").replaceAll("[^0-9?!\\.]", ""));
//        System.out.println("bitCoinPrice " + bitCoinPrice);
        return bitCoinPrice;
    }
    public static float cardPrice(){
        float paypalPrice = Float.valueOf(Q_PM_WebElm.xpRetText(pmQaProps, "cart.pm.products.listLowToHigh.Paypal.Price.xp").replaceAll("[^0-9?!\\.]",""));
//        System.out.println("paypalPrice " + paypalPrice);
        return paypalPrice;
    }

    public static void validateSortPriceHighToLow(String Xp){
        int count = Q_PM_WebElm.xpCountTableDiv(pmQaProps, "cart.pm.ListViewProduct.xp");
        System.out.println("Count all divs " + count);
        for(int i = 1; i<count;i++) {
            Float priceList1 = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,Xp));
            for(int j= i+1; j <= count ;j++) {
                Float priceList2 = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,Xp));
                if(priceList1 >= priceList2) {
                    System.out.println("Check Price of product " + i + " is sorted from high to low :"+priceList1+ " greater than or equal to "+ j + " next product " +priceList2 );
                    break;
                }
            }
        }
    }
    public static void validateSortPriceLowToHigh(String Xp){
        int count = Q_PM_WebElm.xpCountTableDiv(pmQaProps, "cart.pm.ListViewProduct.xp");
        System.out.println("Count all divs " + count);
        for(int i = 1; i<count;i++) {
            Float priceList1 = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps, Xp));
            for(int j= i+1; j <= count ;j++) {
                Float priceList2 = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps, Xp));
                if(priceList1<=priceList2) {
                    System.out.println("Check Price of product " + i + " is sorted from high to low :"+priceList1+ " less than or equal to "+ j + " next product " +priceList2 );
                    break;
                }
            }
        }
    }
    public static void productPageListSortingPriceCheck(String sortype){
        Q_PM_NavigationSteps.selectMetal("gold");
        Q_PM_NavigationSteps.category("firstLevel", 1, 2);
        Q_PM_NavigationSteps.category("secondLevel", 1, 3);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.id(pmQaProps, "cart.pm.productsList.id");
        switch (sortype){
            case ("lowToHigh"):
                float checkPrice1 = checkPrice();
                float bitCoinPrice1 = cryptoPrice();
                float paypalPrice1 = cardPrice();
                if (checkPrice1 < bitCoinPrice1 || bitCoinPrice1 < paypalPrice1) {
                    System.out.print("Modal Check / Wire Price(1): " + checkPrice1 + "\n" + "Modal Bitcoin / Bitcoin Cash Price: " + bitCoinPrice1 + "\n" + "Modal Credit Card Price: " + paypalPrice1 + "\n");

                }
                else {
                    System.out.print("Failed to verify payment method unit price in the modal");
                }
                break;
            case ("popularity"):
                Q_PM_WebElm.idExecutor(pmQaProps, "cart.pm.products.popularity.id");
                System.out.println("Sorted Products Popularity wise");
                driver.navigate().refresh();
                float checkPrice2 = checkPrice();
                float bitCoinPrice2 = cryptoPrice();
                float paypalPrice2 = cardPrice();
                if (checkPrice2 < bitCoinPrice2 || bitCoinPrice2 < paypalPrice2) {
                    System.out.print("Modal Check / Wire Price(1): " + checkPrice2 + "\n" +
                            "Modal Bitcoin / Bitcoin Cash Price: " + bitCoinPrice2 + "\n" +
                            "Modal Credit Card Price: " + paypalPrice2 + "\n");
                }
                else {
                    System.out.print("Failed to verify payment method unit price in the modal");
                }
                break;
            case ("recently"):
                Q_PM_WebElm.idExecutor(pmQaProps, "cart.pm.products.recently.id");
                System.out.println("Sorted Products Recently wise");
                driver.navigate().refresh();
                float checkPrice3 = checkPrice();
                float bitCoinPrice3 = cryptoPrice();
                float paypalPrice3 = cardPrice();
                if (checkPrice3 < bitCoinPrice3 || bitCoinPrice3 < paypalPrice3) {
                    System.out.print("Modal Check / Wire Price(1): " + checkPrice3 + "\n" +
                            "Modal Bitcoin / Bitcoin Cash Price: " + bitCoinPrice3 + "\n" +
                            "Modal Credit Card Price: " + paypalPrice3 + "\n");
                }
                else {
                    System.out.print("Failed to verify payment method unit price in the modal");
                }
                break;
            case ("highToLow"):
                Q_PM_WebElm.idExecutor(pmQaProps, "cart.pm.products.highToLow.id");
                System.out.println("Sorted Products High To Low wise");
                driver.navigate().refresh();
                float checkPrice4 = checkPrice();
                float bitCoinPrice4 = cryptoPrice();
                float paypalPrice4 = cardPrice();
                if (checkPrice4 < bitCoinPrice4 || bitCoinPrice4 < paypalPrice4) {
                    System.out.print("Modal Check / Wire Price(1): " + checkPrice4 + "\n" +
                            "Modal Bitcoin / Bitcoin Cash Price: " + bitCoinPrice4 + "\n" +
                            "Modal Credit Card Price: " + paypalPrice4 + "\n");
                }
                else {
                    System.out.print("Failed to verify payment method unit price in the modal");
                }
                break;
            case ("weightAsc"):
                Q_PM_WebElm.idExecutor(pmQaProps, "cart.pm.products.weightAsc.id");
                System.out.println("Sorted Products Weight Ascending wise");
                driver.navigate().refresh();
                float checkPrice5 = checkPrice();
                float bitCoinPrice5 = cryptoPrice();
                float paypalPrice5 = cardPrice();
                if (checkPrice5 < bitCoinPrice5 || bitCoinPrice5 < paypalPrice5) {
                    System.out.print("Modal Check / Wire Price(1): " + checkPrice5 + "\n" +
                            "Modal Bitcoin / Bitcoin Cash Price: " + bitCoinPrice5 + "\n" +
                            "Modal Credit Card Price: " + paypalPrice5 + "\n");
                }
                else {
                    System.out.print("Failed to verify payment method unit price in the modal");
                }
                break;
            case ("weightDesc"):

                Q_PM_WebElm.idExecutor(pmQaProps, "cart.pm.products.weightDesc.id");
                System.out.println("Sorted Products Weight Descending wise");
                driver.navigate().refresh();
                float checkPrice6 = checkPrice();
                float bitCoinPrice6 = cryptoPrice();
                float paypalPrice6 = cardPrice();
                if (checkPrice6 < bitCoinPrice6 || bitCoinPrice6 < paypalPrice6) {
                    System.out.print("Modal Check / Wire Price(1): " + checkPrice6 + "\n" +
                            "Modal Bitcoin / Bitcoin Cash Price: " + bitCoinPrice6 + "\n" +
                            "Modal Credit Card Price: " + paypalPrice6 + "\n");
                }
                else {
                    System.out.print("Failed to verify payment method unit price in the modal");
                }
                break;
        }
    }
    public static void validatePriceHighToLow() {
        Q_PM_WebElm.myWait(2000);
        DecimalFormat df = new DecimalFormat("#.00");
        Integer item;
        validateSortPriceHighToLow("cart.pm.listViewCheckPrice.xp");
        validateSortPriceHighToLow("cart.pm.listViewBitCoinPrice.xp");
        validateSortPriceHighToLow("cart.pm.listViewProductPayPalPrice.xp");

    }
    public static void validatePriceLowToHigh() {
        Q_PM_WebElm.myWait(2000);
        DecimalFormat df = new DecimalFormat("#.00");
        Integer item;
        validateSortPriceLowToHigh("cart.pm.listViewCheckPrice.xp");
        validateSortPriceLowToHigh("cart.pm.listViewBitCoinPrice.xp");
        validateSortPriceLowToHigh("cart.pm.listViewProductPayPalPrice.xp");

    }
    //JMB-5908 End
    
    //JMB-7670 Start
    public void xp(Properties proper, String catQtyBeg, String mid, String catQtyEnd) {
		driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + mid + proper.getProperty(catQtyEnd))).click();
	}

	public void xp(Properties proper, String catQtyBeg, String mid, String ele, String catQtyEnd) {
		driver.findElement(
				By.xpath(proper.getProperty(catQtyBeg) + mid + proper.getProperty(ele) + proper.getProperty(catQtyEnd)))
				.click();
	}
	public void xpClear(Properties proper, String catQtyBeg, String mid, String catQtyEnd) {
		driver.findElement(
				By.xpath(proper.getProperty(catQtyBeg) + mid + proper.getProperty(catQtyEnd)))
				.clear();
	}
	
	public void xpSend(Properties proper, String catQtyBeg, String item, String catQtyEnd, String quan) {
        driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).sendKeys(quan);
    }
    
  	
  	/**********************************************************************
     * Description:     Controller for pulling data from excel for adding, removing, or updating products for a given test case
     * Author:          Paul Patterson
     * Param:      		String testCaseName, int testcaseIndex
     * Returns:         None
     **********************************************************************/
  	public void productsController (String testCaseName, int testcaseIndex) throws FilloException, IOException 
  	{
  		Q_PM_Controls cont = new Q_PM_Controls();
  		System.out.println("[INFO] Getting data for Test Case '" + testCaseName + "' with Test Case Index '" + testcaseIndex + "' for data file 'AutomationTestDataFile.xlsx'.");
  		LinkedHashMap <Object, Map<String, String>> productTestDataRecordSet;
  		Map <String, String> innerMap;
  		String selectQuery = "Select * From PMProductTestData Where TestCaseName='" + testCaseName +"' And TestCaseIndex='" + testcaseIndex + "'";
  		productTestDataRecordSet = cont.queryExcelToLinkedHashMap(System.getProperty("user.dir") + "/src/main/resources/excelFiles/AutomationTestDataFile.xlsx", selectQuery);
  		for (int index = 1; index <= productTestDataRecordSet.size(); index++)
  		{
  			innerMap = productTestDataRecordSet.get(index);
  			productSelectMethodContoller (innerMap.get("ProductName"), innerMap.get("ActionType"), 
  					innerMap.get("SelectionMethod"), innerMap.get("Qty"));
  		}
  	}
  	
  	/**********************************************************************
     * Description:     Controller for determining proper method calls for a single product action
     * Author:          Paul Patterson
     * Param:      		String productName, String actionType, String selectionMethod, String qty
     * Returns:         None
     **********************************************************************/
  	public void productSelectMethodContoller (String productName, String actionType, String selectionMethod, String qty) throws FilloException
  	{
  		Q_PM_Controls cont = new Q_PM_Controls();
  		System.out.println("[INFO] Starting action '" + actionType + "' on product '" + productName + "' using the method '" + selectionMethod + "'.");
  		switch(actionType) {
  			case "Add":
  				LinkedHashMap <Object, Map<String, String>> productDetailsRecordSet;
  				String selectQuery = "Select * From PMProducts Where ProductName='" + productName +"'";;
  				Map <String, String> innerMap;
  				productDetailsRecordSet = cont.queryExcelToLinkedHashMap(System.getProperty("user.dir") + "/src/main/resources/excelFiles/AutomationTestDataFile.xlsx", selectQuery);
  				innerMap = productDetailsRecordSet.get(1);
  				switch(selectionMethod) {
  					case "URL":
  						addProductByURL (innerMap.get("ProductURL"), qty);
  						break;
  					case "PDP":
  						addProductByPDP (productName, innerMap.get("MetalType"), innerMap.get("Category1"), 
  								innerMap.get("Category2"), innerMap.get("Category3"), 
  								innerMap.get("Category4"), qty);
  						break;
  					case "PLP":
  						addProductByPLP (productName, innerMap.get("MetalType"), innerMap.get("Category1"), 
  								innerMap.get("Category2"), innerMap.get("Category3"), 
  								innerMap.get("Category4"), qty);
  						break;
  				}
  				break;
  			case "Update":
  				switch(selectionMethod) {
  					case "Cart":
  						updateProductInCart (productName, qty);
  						break;
  				}
  				break;
  			case "Delete":
  				switch(selectionMethod) {
  					case "Cart":
  						deleteProductInCart (productName);
  						break;
  				}
  				break;
  		}
  		System.out.println("[INFO] Finished action '" + actionType + "' on product '" + productName + "' using the method '" + selectionMethod + "'.");
  	}
  	
  	/**********************************************************************
     * Description:     Navigate to PLP category page
     * Author:          Paul Patterson
     * Param:      		String metalType, String category1, String category2, String category3, String category4
     * Returns:         None
     **********************************************************************/
  	public void navigateToPLPPage (String metalType, String category1, String category2, 
  			String category3, String category4) 
  	{	
  		if (metalType.equals("Copper")) {
  			Q_PM_WebElm.moveToxp(pmQaProps.getProperty("nav.topMenu.beg.xp") + "MORE METALS" 
  					+ pmQaProps.getProperty("nav.topMenu.end.xp"));
  			xp(pmQaProps, "nav.subMenu.beg.xp", category1, "nav.subMenu.end.xp");
  		} else if (metalType.equals("Accessories")) {
  			xp(pmQaProps, "nav.topMenu.beg.xp", "SUPPLIES", "nav.topMenu.end.xp");
  			xp(pmQaProps, "nav.categorySelection.beg.xp", category1, "nav.categorySelection.end.xp");
  		} else
  		{
  			xp(pmQaProps, "nav.topMenu.beg.xp", metalType, "nav.topMenu.end.xp");
  			xp(pmQaProps, "nav.categorySelection.beg.xp", category1, "nav.categorySelection.end.xp");
  		}
  		
  		if (!category2.isEmpty()) {
  			xp(pmQaProps, "nav.categorySelection.beg.xp", category2, "nav.categorySelection.end.xp");
  		}
  		
  		if (!category3.isEmpty()) {
  			xp(pmQaProps, "nav.categorySelection.beg.xp", category3, "nav.categorySelection.end.xp");
  		}
  		
  		if (!category4.isEmpty()) {
  			xp(pmQaProps, "nav.categorySelection.beg.xp", category4, "nav.categorySelection.end.xp");
  		}
  	}
  	
  	/**********************************************************************
     * Description:     Adds a product and navigate through URL
     * Author:          Paul Patterson
     * Param:      		String productURL, String qty
     * Returns:         None
     **********************************************************************/
  	public void addProductByURL (String productURL, String qty) 
  	{
  		Q_PM_CartSteps cart = new Q_PM_CartSteps();
  		driver.navigate().to(baseUrl + productURL);
        cart.addProductpageItemToCart(Integer.parseInt(qty));
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
  	}
  	
  	/**********************************************************************
     * Description:     Adds a product and navigate through PDP
     * Author:          Paul Patterson
     * Param:      		String productName, String metalType, String category1, String category2, String category3, String category4, String qty
     * Returns:         None
     **********************************************************************/
  	public void addProductByPDP (String productName, String metalType, String category1, String category2, 
  			String category3, String category4, String qty) 
  	{
  		Q_PM_CartSteps cart = new Q_PM_CartSteps();
  		driver.navigate().to(baseUrl);
  		navigateToPLPPage (metalType, category1, category2, category3, category4);
  		xp(pmQaProps, "plp.productLink.beg.xp", productName, "plp.productLink.end.xp");
  		cart.addProductpageItemToCart(Integer.parseInt(qty));
  		Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
  	}
  	
  	/**********************************************************************
     * Description:     Adds a product and navigate through PLP
     * Author:          Paul Patterson
     * Param:      		String productName, String metalType, String category1, String category2, String category3, String category4, String qty
     * Returns:         None
     **********************************************************************/
  	public void addProductByPLP (String productName, String metalType, String category1, String category2, 
  			String category3, String category4, String qty) 
  	{
  		driver.navigate().to(baseUrl);
  		navigateToPLPPage (metalType, category1, category2, category3, category4);
  		xpSend(pmQaProps, "plp.product.beg.xp", productName, "plp.productQty.end.xp", qty);
  		xp(pmQaProps, "plp.product.beg.xp", productName, "plp.productAddToCart.end.xp");
  		Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
  	}
  	
  	/**********************************************************************
     * Description:     Updates a specific item in the cart
     * Author:          Paul Patterson
     * Param:      		String productName, String qty
     * Returns:         None
     **********************************************************************/
  	public void updateProductInCart (String productName, String qty) 
  	{
  		Q_PM_CartSteps cart = new Q_PM_CartSteps();
  		driver.navigate().to(baseUrl + "/cart/");
  		Q_PM_CheckoutSteps.selectPaymentType("cheque");
  		xpClear(pmQaProps, "cart.product.beg.xp", productName, "cart.productQty.end.xp");
  		xpSend(pmQaProps, "cart.product.beg.xp", productName, "cart.productQty.end.xp", qty);
  		xp(pmQaProps, "cart.product.beg.xp", productName, "cart.productUpdateCart.end.xp");
  	}
  	
  	/**********************************************************************
     * Description:     Deletes a specific item in the cart
     * Author:          Paul Patterson
     * Param:      		String productName, String qty
     * Returns:         None
     **********************************************************************/
  	public void deleteProductInCart (String productName)
  	{
  		Q_PM_CartSteps cart = new Q_PM_CartSteps();
  		driver.navigate().to(baseUrl + "/cart/");
  		Q_PM_CheckoutSteps.selectPaymentType("cheque");
  		xp(pmQaProps, "cart.product.beg.xp", productName, "cart.productRemove.end.xp");
  	}
   	//JMB-7670 End
}
