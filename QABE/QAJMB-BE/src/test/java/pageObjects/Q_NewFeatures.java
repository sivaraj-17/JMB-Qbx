package pageObjects;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.sql.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import utils.Controls;
import utils.Init;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Q_NewFeatures extends Init {
    static Q_AdminForm adm = new Q_AdminForm();
    static Q_CustomerForm cust = new Q_CustomerForm();
    static Q_ProductForm prod = new Q_ProductForm();
    static Q_HoldsForm hold = new Q_HoldsForm();
    static Q_OrderForm ord = new Q_OrderForm();
    static Q_Buyback bb = new Q_Buyback();
    static Q_CheckoutForm chk = new Q_CheckoutForm();
    static Q_NewFeatures nfal = new Q_NewFeatures();
    static Controls li = new Controls();


    public Q_NewFeatures formXp(String locator) {
        Q_WebElm.xp(adminProps, locator);
        Q_WebElm.myWait(500);
        return this;
    }

    public Q_NewFeatures formXp(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xp(adminProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_NewFeatures formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_WebElm.xp(adminProps, begXp, row, midXp, column, endXp);
        return this;
    }

    public Q_NewFeatures formInputXp(String locator, String inputValue) {
        Q_WebElm.xpClear(adminProps, locator);
        Q_WebElm.myWait(500);
        Q_WebElm.xpSend(adminProps, locator, inputValue);
        Q_WebElm.myWait(500);
        return this;
    }
    public Q_NewFeatures formIntegerInputXp(String locator, Integer inputValue) {
        Q_WebElm.xpClear(adminProps, locator);
        Q_WebElm.xpSend(adminProps, locator, String.valueOf(inputValue));
        return this;
    }

    public Q_NewFeatures formInputXp(String begXp, Integer lineItem, String endXP, String inputValue) {
        Q_WebElm.xpClear(adminProps, begXp, lineItem, endXP);
        Q_WebElm.xpSend(adminProps, begXp, lineItem, endXP, inputValue);
        return this;
    }

    public static String strXpText(String locator) {
        return Q_WebElm.xpRetText(adminProps, locator);
    }

    public static String strXpText(String begXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, lineItem, endXp);
    }

    public static String strXpText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public static String numberReturn(String locator) {
        return Q_WebElm.xpRetNumber(adminProps, locator);
    }

    public static String numberReturn(String begXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetNumber(adminProps, begXp, lineItem, endXp);
    }

    public static String numberReturn(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetNumber(adminProps, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public static String formReturnNumber(String locator) {
        return Q_WebElm.xpRetNumber(adminProps, locator);
    }

    public static String formReturnNumber(String begXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetNumber(adminProps, begXp, lineItem, endXp);
    }

    public static String formReturnNumber(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetNumber(adminProps, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public Q_NewFeatures formReturnText(String locator) {
        Q_WebElm.xpRetText(adminProps, locator);
        return this;
    }

    public static String formReturnText(String begXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, lineItem, endXp);

    }

    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public Q_NewFeatures formReturnTextReplace(String locator) {
        Q_WebElm.xpRetNumber(adminProps, locator);
        return this;
    }

    public Q_NewFeatures formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpRetNumber(adminProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_NewFeatures formReturnAttribute(String locator, String attr) {
        Q_WebElm.xpRetAttr(adminProps, locator, attr);
        return this;
    }

    public Q_NewFeatures formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp, attr);
        return this;
    }

    public static String attReturn(String locator, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, locator, attr);

    }

    public Q_NewFeatures formReturnAttributeReplace(String locator) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, locator);
        return this;
    }

    public Q_NewFeatures formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_NewFeatures formTab(String locator) {
        Q_WebElm.xpSendTab(adminProps, locator);
        return this;
    }

    public Q_NewFeatures formTab(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendTab(adminProps, begXp, lineItem, endXP);
        return this;
    }

    public Q_NewFeatures formEnter(String locator) {
        Q_WebElm.xpSendEnter(adminProps, locator);
        return this;
    }

    public Q_NewFeatures formEnter(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendEnter(adminProps, begXp, lineItem, endXP);
        return this;
    }

    public static boolean isXpDisplayed(String locator) {
        return Q_WebElm.xpDisplayed(adminProps, locator);
//        try {
//            WebElm.xpDisplayed(adminProps, locator);
//            return true;
//        } catch (Throwable ex) {
//            System.out.println(ex);
//            return false;
//        }
    }

    public static boolean isXpDisplayed(String begXp, Integer lineItem, String endXP) {
        return Q_WebElm.xpDisplayed(adminProps, begXp, lineItem, endXP).equals(true);
    }

    public static boolean isXpCheckSelected(String locator) {
        return Q_WebElm.xpSelected(adminProps, locator).equals(true);
    }

    public static boolean isXpCheckSelected(String begXp, Integer lineItem, String endXP) {
        return Q_WebElm.xpSelected(adminProps, begXp, lineItem, endXP).equals(true);
    }

    public static boolean isXpCheckEnabled(String locator) {
        try {
            Q_WebElm.xpEnabled(adminProps, locator).equals(true);
            return true;
        } catch (Throwable ex) {
            System.out.println(ex);
            return false;
        }
    }

    public static boolean isXpCheckEnabled(String begXp, Integer lineItem, String endXP) {
        try {
            Q_WebElm.xpEnabled(adminProps, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            return false;
        }
    }

    public Q_NewFeatures displayedAssertion(String locator) {
        try {
            driver.manage().timeouts().implicitlyWait(3, SECONDS);
            assertTrue(isXpDisplayed(locator));
            System.out.println("Desired element is displayed");
        } catch (Throwable ex) {
            System.out.println("Element not displayed");
        }

        return this;
    }

    public Q_NewFeatures formId(String locator) {
        Q_WebElm.id(adminProps, locator);
        return this;
    }

    public static String strIdText(String locator) {
        return Q_WebElm.idRetText(adminProps, locator);
    }

    public static String idStrRet(String locator) {
        return Q_WebElm.idRetText(adminProps, locator);
    }

    public static String idNumberReturn(String locator) {
        return Q_WebElm.idRetTextRep(adminProps, locator);
    }

    public static String idAttRet(String locator, String attr) {
        return Q_WebElm.idAttrRet(adminProps, locator, attr);
    }

    public static Integer rowCount(String locator) {
        Integer count = Q_WebElm.xpCountTableRows(adminProps, locator);
        return count;
    }

    public Q_NewFeatures creditThreshold(String ccLimit){
        formInputXp("bb.jm5883.CreditThreshold.xp", ccLimit);
        formXp("adm.saveConfigSettings.xp");
        retAttributAssertion("bb.jm5883.CreditThreshold.xp", ccLimit);

        return this;
    }
    public Q_NewFeatures orderLowerLimit(String lowLimit){
        formInputXp("bb.jm5883.LowerOrderLimit.xp", lowLimit);
        formXp("adm.saveConfigSettings.xp");
        retAttributAssertion("bb.jm5883.LowerOrderLimit.xp", lowLimit);
        return this;
    }
    public Q_NewFeatures orderUpperLimit(String highLimit){
        formInputXp("bb.jm5883.UpperOrderLimit.xp", highLimit);
        formXp("adm.saveConfigSettings.xp");
        retAttributAssertion("bb.jm5883.UpperOrderLimit.xp", highLimit);
        return this;
    }
    public Q_NewFeatures saveSettings(){
        formXp("adm.saveConfigSettings.xp");
        return this;
    }

    public Q_NewFeatures strTextAssertion(String strTextLocator, String textToBeVerified) {
        assertEquals(Q_WebElm.xpRetText(adminProps, strTextLocator), textToBeVerified);
        System.out.println("Buyback Assertion on " + strTextLocator + "Matched Text " + textToBeVerified);
        return this;
    }

    public Q_NewFeatures retAttributAssertion(String strTextLocator, String textToBeVerified) {
        assertEquals(Q_WebElm.xpRetAttr(adminProps, strTextLocator, "value"), textToBeVerified);
        System.out.println("Attribute matched " + textToBeVerified);
        return this;
    }

    public Q_NewFeatures selToUsOff() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Q_WebElm.moveIt(adminProps, "jm.myAccountLink.xp");
        System.out.println("Now is Sell to us " + Q_WebElm.xpDisplayed(adminProps,"jm.accountSellToUs.xp"));
        Assert.assertFalse(Q_WebElm.xpDisplayed(adminProps,("jm.accountSellToUs.xp")));
        return this;
    }
    public Q_NewFeatures selToUs() {
        driver.navigate().to(baseUrl);
//        WebElm.moveIt(adminProps, "myAccountLink.xp");
//        formXp("accountSellToUs.xp");
        formXp("bb.stu.link.xp");
        formXp("bb.stu.btn.xp");
        Q_WebElm.myWait(1000);
        return this;
    }
    public Q_NewFeatures addItem(Integer item, String quan){
//        driver.manage().timeouts().pageLoadTimeout(30,SECONDS);
        Q_WebElm.myWait(2000);
        formInputXp("bb.GoldProducts.qty.beg.xp", item, "bb.Products.qty.end.xp", quan);
        formXp("bb.GoldProducts.qty.beg.xp", item, "bb.Products.Atc.end.xp");
        System.out.println("Modal Price " + strXpText("bb.modal.price.xp"));
        formXp("bb.modal.checkout.xp");
        return this;
    }
    public Q_NewFeatures removeCartPageContent() { ;
        driver.navigate().to(baseUrl + "/my-account/buyback-cart/");
        Integer productCount = rowCount("bb.cart.productCount.xp") - 2;
        System.out.println("Row count " + productCount);
        Controls.scrolDownPixel(400);
        if (productCount >= 1) {
            for (int i = productCount; i > 1; i--) {
                System.out.println("Line item " + numberReturn("bb.cartCount.xp"));
                formXp("bb.cartProductTble.remove.xp");
                Q_WebElm.myWait(2000);
                if(numberReturn("bb.cartCount.xp").equals(0))
                    break;
            }
        }
        return this;
    }
    public Q_NewFeatures addBbItem(String metalType, Integer item, String quan) {
        switch(metalType){
            case "gold":
                Q_WebElm.myWait(2000);
                Q_WebElm.xp(adminProps, "bb.Metal.gold.xp");
                Q_WebElm.myWait(2000);
                formInputXp("bb.GoldProducts.qty.beg.xp", item, "bb.Products.qty.end.xp", quan);
                formXp("bb.GoldProducts.qty.beg.xp", item, "bb.Products.Atc.end.xp");

                System.out.println("Modal Price " + strXpText("bb.modal.price.xp"));
                formXp("bb.modal.checkout.xp");
                break;
            case "silver":
                Q_WebElm.xp(adminProps, "bb.Metal.silver.xp");
                Q_WebElm.myWait(2000);
                formInputXp("bb.silverProducts.qty.beg.xp", item, "bb.Products.qty.end.xp", quan);
                formXp("bb.silverProducts.qty.beg.xp", item, "bb.Products.Atc.end.xp");

                System.out.println("Modal Price " + strXpText("bb.modal.price.xp"));
                formXp("bb.modal.checkout.xp");
                break;

            default:
                System.out.println("Make sure the metal type is correct");
                break;
        }
        return this;
    }
    /****************************************** JMB-2860********************************************/
    public Q_NewFeatures nfAutoLimitLimitedSelect(String value){         // 0 -> umlimited, 1 -> Manual, 2 -> Limited
        switch(value){
            case("0"):
                Q_WebElm.xpSelectValue(adminProps, "prod.alLimited.xp", "0");
                formXp("prod.prodPage.save.xp");
                Q_WebElm.myWait(2000);
                System.out.println("Limit value input box " + isXpDisplayed("prod.alLimitValue.xp"));
                Assert.assertEquals(isXpDisplayed("prod.alLimitValue.xp"),false);
                Q_WebElm.myWait(2000);
                break;
            case("1"):
                Q_WebElm.xpSelectValue(adminProps, "prod.alLimited.xp", "1");
                formInputXp("prod.alLimitValue.xp", "45");
                formXp("prod.prodPage.save.xp");
                Q_WebElm.myWait(2000);
                driver.navigate().refresh();
                retAttributAssertion("prod.alLimitValue.xp", "45");
                Q_WebElm.myWait(2000);
                break;
            case("2"):
                Q_WebElm.xpSelectValue(adminProps, "prod.alLimited.xp", "2");
                formXp("prod.alFetch.xp");
                Q_WebElm.myWait(2000);
                String safeInventory =  strXpText("prod.alFetch.xp");
                System.out.println("safe inventory value " + safeInventory);
                formXp("prod.prodPage.save.xp");
                Q_WebElm.myWait(2000);
                retAttributAssertion("prod.alLimitValue.xp", safeInventory);

                break;
            default:
                System.out.println("Invalid product limit option");
                break;
        }
        return this;
    }
    public Q_NewFeatures damagedProductQty(Integer qty) {
        Q_WebElm.myWait(500);
        formIntegerInputXp("prod.alDamagedProductQty.xp", qty);
        return this;
    }
    public Q_NewFeatures damagedProductDropdown() {
        Q_WebElm.myWait(500);
        formXp("prod.alDamagedProductProduct.xp");
        return this;
    }
    public Q_NewFeatures damagedProductDescription(String productDescription) {
        Q_WebElm.myWait(500);
        formInputXp("prod.alDamagedProductSelect.xp", productDescription);
//        WebElm.myWait(1000);
        return this;
    }
    public Q_NewFeatures damagedProductNote(String productDescription) {
        Q_WebElm.myWait(500);
        formInputXp("prod.alDamagedProductNotes.xp", productDescription);
//        WebElm.myWait(1000);
        return this;
    }
    public Q_NewFeatures damagedProductAdd() {
        Q_WebElm.myWait(1000);
        formXp("prod.alDamagedProductAdd.xp");
        Q_WebElm.myWait(2000);
//        driver.navigate().back();
        return this;
    }

    public static Integer safeInventory(){
        Q_WebElm.xp(adminProps, "prod.alFetch.xp");
        Q_WebElm.myWait(2000);
        Integer safeInventory =  Integer.valueOf(strXpText("prod.alFetch.xp"));
//        System.out.println("safe inventory value " + safeInventory);
        return safeInventory;
    }
    public static Integer newSafe(Integer qty){
        System.out.println("SafeInventory " + Integer.valueOf(safeInventory()));
        System.out.println("Quantity " + Integer.valueOf(qty));
        Integer newSafe = safeInventory() - qty;
        System.out.println("New safe " + newSafe);
        return newSafe;
    }
    public Q_NewFeatures navProd(String locator){
        Q_WebElm.myWait(2000);
        driver.navigate().to(adminUrl + locator);
        return this;
    }
    public Q_NewFeatures verifyProductLimitAndSafeInventory(){
        Integer productLimit = Integer.valueOf(attReturn("prod.alLimitValue.xp", "value"));
        System.out.println("safe inventory value " + safeInventory()  + "\t Product limit " + productLimit );
        Assert.assertEquals(safeInventory(), Integer.valueOf(attReturn("prod.alLimitValue.xp", "value")));
        return this;
    }
    public Q_NewFeatures autoLimitDamagedProduct(Integer qty){
        Integer originalInv = safeInventory();
        navProd("/damaged-products.php");
        System.out.println("Damaged Product URL " + driver.getCurrentUrl());
        damagedProductQty(qty);
        damagedProductDropdown();
        damagedProductDescription("1 oz Silver Bar (Varied Condition, Any");
        damagedProductNote("Automated test");
        damagedProductAdd();
        navProd("/products-form.php?id=16");
        Integer newSafe = originalInv - qty;
        System.out.println("safe inventory value " + originalInv  + "\t NewSafe " + newSafe + "\t Quantity " + qty);
        Assert.assertEquals(safeInventory(), newSafe);
        verifyProductLimitAndSafeInventory();
        return this;
    }
    public Q_NewFeatures autoLimitInHandAdjust(Integer qty){
        Integer originalInv = safeInventory();
        navProd("/products-adjust-inhand.php");
        System.out.println("Adjusted inhand URL " + driver.getCurrentUrl());
        formXp("prod.alInHandAdjustProductSelect.xp");
        formInputXp("prod.alInHandAdjustProductInput.xp", "1 oz Silver Bar (Varied Condition, Any");
        formIntegerInputXp("prod.alInHandAdjustQty.xp", qty);
        formInputXp("prod.alInHandAdjustNote.xp", "Automated test");
        formXp("prod.alInHandAdjustSubmit.xp");
        formXp("prod.alInHandAdjustConfirm.xp");
        Q_WebElm.myWait(2000);
        navProd("/products-form.php?id=16");
        Integer newSafe = originalInv + qty;
        System.out.println("safe inventory value " + originalInv  + "\t NewSafe " + newSafe + "\t Quantity " + qty);
        Assert.assertEquals(safeInventory(), newSafe);
        verifyProductLimitAndSafeInventory();
        return this;
    }
    public Q_NewFeatures autoLimitAdjustRepo(Integer qty){
        Integer originalInv = safeInventory();
        navProd( "/products-adjust-repo.php");
        System.out.println("Adjusted Repo URL " + driver.getCurrentUrl());
        formXp("prod.alInHandAdjustProductSelect.xp");
        formInputXp("prod.alInHandAdjustProductInput.xp", "1 oz Silver Bar (Varied Condition, Any");
        formIntegerInputXp("prod.alInHandAdjustQty.xp", qty);
        Q_WebElm.myWait(500);
        formInputXp("prod.alInHandAdjustNote.xp", "Automated test");
        formXp("prod.alInHandAdjustSubmit.xp");
        Q_WebElm.myWait(500);
        formXp("prod.alInHandAdjustConfirm.xp");
        Q_WebElm.myWait(1000);
        driver.navigate().back();
        Integer newSafe = originalInv + qty;
        System.out.println("safe inventory value " + originalInv  + "\t NewSafe " + newSafe + "\t Quantity " + qty);
        Assert.assertEquals(Integer.valueOf(Q_NewFeatures.safeInventory()), newSafe);
        verifyProductLimitAndSafeInventory();
        return this;
    }

    public Q_NewFeatures orderReducingLimit(Integer qty) throws FileNotFoundException {
        Q_CheckoutForm chk = new Q_CheckoutForm();
        Integer preOrderLimit = safeInventory();
        chk.selectItem("auto limit", qty);
        Q_WebElm.myWait(3000);
        navProd("/products-form.php?id=16");
        Integer postOrderLimit = safeInventory();
        Q_WebElm.myWait(3000);
        Integer newSafe = postOrderLimit + qty;
        System.out.println("safe inventory value " + preOrderLimit  + "\t NewSafe " + newSafe + "\t Quantity " + qty);
        Assert.assertEquals(preOrderLimit, newSafe);
        verifyProductLimitAndSafeInventory();
        return this;
    }
        public Q_NewFeatures autoLimitCancelOrder(){
        Q_CheckoutForm chk = new Q_CheckoutForm();
        Integer preCancellation = safeInventory();
        Q_OrderForm ord = new Q_OrderForm();
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.changeOrderStatus("cancelled");
        Q_WebElm.myWait(2000);
        Q_WebElm.xp(adminProps, "ord.orderProcessCancellation.xp");
        Q_WebElm.myWait(2000);
        navProd("/products-form.php?id=16");
        Integer postOrderLimit = safeInventory() - 100;
        System.out.println("Post order safe Inventory " + safeInventory());
        System.out.println("safe inventory value " + preCancellation  + "\t NewSafe " + postOrderLimit + "\t Quantity " + 100);
        Assert.assertEquals(preCancellation, postOrderLimit);
        verifyProductLimitAndSafeInventory();
        return this;
    }
    public Q_NewFeatures autoLimitRestoreOrder(Integer qty) throws FileNotFoundException {
        Q_CheckoutForm chk = new Q_CheckoutForm();
        Integer preRestore = safeInventory();
//        chk.selectItem("auto limit", qty);
        Q_OrderForm ord = new Q_OrderForm();
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.changeOrderStatus("pending");
        navProd("/products-form.php?id=16");
        Integer newSafe = safeInventory() + 100;
        System.out.println("Original inventory value " + preRestore  + "\t NewSafe " + newSafe + "\t Post restore " + safeInventory());
        Assert.assertEquals(preRestore, newSafe);
        verifyProductLimitAndSafeInventory();
        return this;
    }

    public Q_NewFeatures autoLimitLineItem(Integer qty , String locator) throws FileNotFoundException {
        Q_OrderForm ord = new Q_OrderForm();
        Integer preAdjustment = safeInventory();

        ord.ordersMenu("list");
        ord.editTopOrder();
        orderItemDetails(qty, locator);
        ord.recalculateTax();
        navProd("/products-form.php?id=16");
        Integer postAdjust = safeInventory();
        Integer newSafe = safeInventory() + qty;
        System.out.println("Original inventory value " + preAdjustment  + "\t NewSafe " + newSafe + "\t Post adjustment " + postAdjust);
        Assert.assertEquals(preAdjustment, newSafe);
        verifyProductLimitAndSafeInventory();
        return this;
    }
    public Q_NewFeatures orderItemDetails(Integer qty, String locator){
        String origQuantity = Q_WebElm.xpRetText(adminProps, "ord.order.editQuantity.xp");
        Q_WebElm.xp(adminProps, "ord.item.edit.xp");
        Q_WebElm.myWait(1000);
        for(int i=1; i <= Math.abs(qty); i++){
            Q_WebElm.xp(adminProps,locator);
        }
        Q_WebElm.xpSend(adminProps, "ord.item.editNote.xp", "Automated test case");
        Q_WebElm.xpSendTab(adminProps, "ord.item.editNote.xp");
        Q_WebElm.xp(adminProps, "ord.item.editUpdate.xp");
        Q_WebElm.myWait(1000);
        driver.navigate().refresh();
        Q_WebElm.myWait(2000);
        String finalQuantity = Q_WebElm.xpRetText(adminProps, "ord.order.editQuantity.xp");
        String productLimit = Q_WebElm.xpRetText(adminProps, "ord.orderListedLimit.xp");
        System.out.println("Edited quantity: " + finalQuantity + "\t Order product limit " + productLimit);
        return this;
    }
    public Q_NewFeatures orderReship(Integer qty) throws FileNotFoundException {
        Q_OrderForm ord = new Q_OrderForm();
        Q_CheckoutForm chk = new Q_CheckoutForm();
        Integer preOrderLimit = safeInventory();
        chk.selectItem("auto limit", qty);
        navProd("/products-form.php?id=16");
        driver.navigate().to(adminUrl);
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.buttonFullReship();
        Integer newLimit = preOrderLimit - 2 * qty;
        navProd("/products-form.php?id=16");
        Integer newSafe = safeInventory();
        System.out.println("Pre test safe limit: " + preOrderLimit + "\t New product limit " + newLimit);
        Assert.assertEquals(newSafe, newLimit);
        verifyProductLimitAndSafeInventory();
        return this;
    }

    public Q_NewFeatures repoValueDate(String product, Integer qty){
        Integer preOrderLimit = safeInventory();
        Q_AdminForm adm = new Q_AdminForm();
        adm.repoMenu("add repo");
        adm.addRepo(product, qty);
        adm.repoForceValueDate();
        navProd("/products-form.php?id=16");
        Integer newSafe = safeInventory();
        System.out.println("Pre test safe limit: " + preOrderLimit + "\t New product limit " + newSafe);
        Integer reducedBy =  newSafe - preOrderLimit;
        Assert.assertEquals(reducedBy, qty);
        verifyProductLimitAndSafeInventory();
        return this;
    }

    public Q_NewFeatures arriveReceipts(){
        Integer preOrderLimit = safeInventory();
        Q_AdminForm adm = new Q_AdminForm();
        adm.adminMenu("receipts");
        adm.addReceipt();
        adm.addReceiptProduct(1,"1 oz Silver Bar (Varied Condition, An", 100, "26.89");
        adm.saveReceipt();
        Q_WebElm.xp(adminProps, "adm.markOrderArrived.xp");
        navProd("/products-form.php?id=16");
        System.out.println("Pre test safe limit: " + preOrderLimit + "\t New product limit " + safeInventory());
        Integer newSafe =  preOrderLimit  + 100;
        Assert.assertEquals(safeInventory(), newSafe);
        verifyProductLimitAndSafeInventory();
        return this;
    }

    public Q_NewFeatures arriveItemReceipts(){
    	Q_WebElm.myWait(3000);
    	Integer preOrderLimit = safeInventory();
        Q_AdminForm adm = new Q_AdminForm();
        adm.adminMenu("receipts");
        adm.addReceipt();
        adm.addReceiptProduct(1,"1 oz Silver Bar (Varied Condition, An", 100, "26.89");
        Q_WebElm.myWait(6000);
        adm.addReceiptProduct(2, "1 oz American Gold Eagle Coin (Varied Ye", 10, "1486.03");

        adm.saveReceipt();
        Q_WebElm.xp(adminProps, "adm.itemArrived.beg.xp", 1 , "adm.itemArrived.end.xp");
        navProd("/products-form.php?id=16");
        Q_WebElm.myWait(2000);
        System.out.println("Pre test safe limit: " + preOrderLimit + "\t New product limit " + safeInventory());
        Integer newSafe =  preOrderLimit  + 100;
        Assert.assertEquals(safeInventory(), newSafe);
        //verifyProductLimitAndSafeInventory();
        return this;
    }
    public Q_NewFeatures singleProductBb(){
        Integer preOrderLimit = safeInventory();
        Q_AdminForm adm = new Q_AdminForm();
        Q_Buyback bb = new Q_Buyback();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+3jmb@jmbullion.com" ,2);
        bb.selectAddress(2);
        bb.selectBank(2);
        bb.selectPayment("ACH");
        bb.selectDefaultCard(1, 6);
        bb.addBbProduct(2, "10","1 oz Silver Bar (Varied Condition, An");
        bb.reportable();
        bb.productValidation();
        bb.saveVerifyNotes("Buyback created");
        bb.selectLocation("Vegas");
        bb.editCartNumber();
        bb.receiveEntireOrder();
        navProd("/products-form.php?id=16");
        Integer newSafe = preOrderLimit + 10;
        System.out.println("Pre test safe limit: " + preOrderLimit + "\t New product limit " + safeInventory());
        Assert.assertEquals(safeInventory(), newSafe);
        verifyProductLimitAndSafeInventory();
        return this;
    }
    public Q_NewFeatures multipleProductBb(){
        Integer preOrderLimit = safeInventory();
        Q_AdminForm adm = new Q_AdminForm();
        Q_Buyback bb = new Q_Buyback();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+3jmb@jmbullion.com" ,2);
        bb.selectAddress(2);
        bb.selectBank(2);
        bb.selectPayment("ACH");
        bb.selectDefaultCard(1, 6);
        bb.addBbProduct(2, "10","1 oz Silver Bar (Varied Condition, An");
        bb.addBbProduct(3, "10","1 oz Gold Bar (Varied Condition,");
        bb.reportable();
        bb.productValidation();
        bb.saveVerifyNotes("Buyback created");
        bb.selectLocation("Vegas");
        bb.editCartNumber();
        bb.receiveProductIndividually();
        navProd("/products-form.php?id=16");
        Integer newSafe = preOrderLimit + 10;
        System.out.println("Pre test safe limit: " + preOrderLimit + "\t New product limit " + safeInventory());
        Assert.assertEquals(safeInventory(), newSafe);verifyProductLimitAndSafeInventory();
        return this;
    }
    public Q_NewFeatures unReceiveBbProduct(){
        Integer preOrderLimit = safeInventory();
        Q_AdminForm adm = new Q_AdminForm();
        Q_Buyback bb = new Q_Buyback();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp", "qa+3jmb@jmbullion.com", 3);
        bb.commitSearch();
        bb.searchSupplier("JM Bullion");
//        bb.editOrder();
        bb.unreceiveProductIndividually();
        navProd("/products-form.php?id=16");
        Integer newSafe = preOrderLimit - 10;
        System.out.println("Pre test safe limit: " + preOrderLimit + "\t New product limit " + safeInventory());
        Assert.assertEquals(safeInventory(), newSafe);
        verifyProductLimitAndSafeInventory();
        return this;
    }
    //JMB-6534 Start
    /**
     * Clicking an element using Sikuli
     * @param imgName (with extension. eg:"click.png"
     * @throws FindFailed
     */
    public static void sikuliClick(String imgName) throws FindFailed {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/BEsikuliScreenshots/";
        Screen screenArea = new Screen();
        Pattern elementToClick = new Pattern(filePath + imgName);
        screenArea.wait(elementToClick, 10);
        screenArea.hover(elementToClick);
        screenArea.click(elementToClick);
    }

    /**
     * Deleting the individual file from home directory
     *
     * @param pathToFile (eg. /Downloads/file.pdf )
     */
    public static void deleteFileFromHomeDir(String pathToFile) throws IOException, InterruptedException {
        File file = new File(System.getProperty("user.home") + pathToFile);
        if (new File(System.getProperty("user.home") + pathToFile).isFile()) {
            String fileName = file.getName();
            System.out.println("[INFO] Detected File :" + fileName);
            if (file.delete()) {
                System.out.println("[PASS] Deleted  File :" + fileName);
            } else {
                Assert.fail("[FAIL] Couldn't Delete :" + fileName);

            }

        } else {
            System.out.println("[INFO] No file detected. ");
        }
    }

    /**
     * Load the pdf from current home directory and print contents
     *
     * @param linkToPDF (eg. /Downloads/file.pdf )
     * @return content
     * @throws IOException
     */
    public static String loadAndStripPDFContents(String linkToPDF) throws IOException {
        File file = new File(System.getProperty("user.home") + linkToPDF);
        FileInputStream fis = new FileInputStream(file);
        PDDocument doc = PDDocument.load(fis);
        String content = new PDFTextStripper().getText(doc);
        System.out.println("PDF Contents are :" + "\n" + content);
        return content;

    }
    /**
     * Grab the text as string and return as Integer
     * @param properties file,locators,Index,attribute
     * return convertedInteger
     * @throws NumberFormatException
     */

    public static int grabStringAndRetInteger(Properties proper, String catQtyBeg, Integer item, String catQtyEnd, String attr) throws NumberFormatException {

        WebElement elementToGrab = driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd)));
        String textGrabbedInString = elementToGrab.getAttribute(attr);
        int textGrabbedInInteger = Integer.parseInt(textGrabbedInString);
        return textGrabbedInInteger;
    }

    /**
     * Check for the file existence in home directory within Time Limits
     * @param pathToFile
     * @param timeOut
     * @return isFileExists
     */
    public static boolean isFileExistsInDirWithinTimeOut(String pathToFile, Integer timeOut) {


        boolean isFileExists = false;
        int counter = 1;
        do {
            Q_WebElm.myWait(1000);
            if (new File(System.getProperty("user.home") + pathToFile).isFile()) {
                isFileExists = true;
                break;
            }
            counter++;
        } while (counter < timeOut);
        return isFileExists;

    }
    public Q_NewFeatures verifyCostInPackageSlip(String BBcostBeforeEdit,String BBcostAfterEdit) throws IOException, InterruptedException, FindFailed {
        Assert.assertNotEquals(BBcostBeforeEdit, BBcostAfterEdit);
        Q_NewFeatures.deleteFileFromHomeDir("/Downloads/index.pdf");// Deleting index.pdf if available in downloads
        Q_WebElm.xp(adminProps, "bb.printPackingSlip.xp"); // make method
        Q_NewFeatures.sikuliClick("MACsaveAtPDFPreview.png");
        Q_NewFeatures.sikuliClick("MACsaveAtDownloadLoc.png");
        Q_NewFeatures.isFileExistsInDirWithinTimeOut("/Downloads/index.pdf", 5);
        String pdfContents = Q_NewFeatures.loadAndStripPDFContents("/Downloads/index.pdf");
        Assert.assertTrue(pdfContents.contains(BBcostAfterEdit));
        System.out.println("[PASS] Verified that the updated amount in Buy Back after editing reflects in Package Slip.");
        return this;
    }
    public Q_NewFeatures  modifyBBQuantity(String operation,int quantityToModify) {
        int quantityToSend = 0;
        int currentQty = Q_NewFeatures.grabStringAndRetInteger(adminProps,"bbEdit.qty.beg.xp", 1, "bbEdit.qty.end.xp","value");
        System.out.println("Existing Qty is :" + currentQty);
        if(operation.equalsIgnoreCase("increase")) {
            quantityToSend =currentQty + quantityToModify;
        } else if(operation.equalsIgnoreCase("decrease")) {
            quantityToSend =currentQty - quantityToModify;
        } else {
            Assert.fail("[FAIL] Enter a valid operation to execute.");
        }
        System.out.println("Updated Qty  is :" + quantityToSend);
        bb.productQty(2, String.valueOf(quantityToSend));
        return this;
    }
    public static String xpRetText(Properties proper, String locator) {
        WebElement element = driver.findElement(By.xpath(proper.getProperty(locator)));
        element.getText();
        return element.getText();
    }
    //JMB-6534 End
    
    // Start DB variables and methods
    protected static Session session;
	//protected static String jumpServerHostJMB = "35.168.5.34";
	protected static String jumpServerHostJMB = "18.235.173.80";
	protected static String jumpServerHostPM = "107.20.183.100";
	protected static String jumpServerUsername = "paul.patterson";
	protected static String privateKeyPath = "~/.ssh/JMB_Automation";
	protected static String databaseHost = "webscale-jmbullion-bionic-staging-v3-cluster-cluster.cluster-ccebjgebvh6v.us-east-1.rds.amazonaws.com";
	protected static String databaseUsername = "jmbull_wpadwp";
	protected static String databasePassword = "4Kq3d2swigywPjwSZq3m";
	protected static int databasePort = 3306;
	protected static int localPort = 3307;
	protected static String dbQAJMBUrl = "jdbc:mysql://localhost:" + localPort + "/jmbull_qa4";
	protected static String dbQASilverUrl = "jdbc:mysql://localhost:" + localPort + "/silver_qa4";
	protected static String dbStagingJMBUrl = "jdbc:mysql://localhost:" + localPort + "/jmbull_staging";
	protected static String dbStagingSilverUrl = "jdbc:mysql://localhost:" + localPort + "/silver_staging";
	protected static Connection dbConnection;
	protected static Statement dbStatement;
	protected static ResultSet dbRecordSet;
    
	
	/**************************************************************************
     * Description: Establishes session to JMB SSH server
     * @param: none
     * @return: none
     * Status: complete
     *************************************************************************/
    public static void connectToSSHSessionJMB() throws JSchException {
    	// Public key authentication
    	JSch jsch = new JSch();
    	jsch.addIdentity(privateKeyPath);
    
    	// Connect to SSH jump server 
    	session = jsch.getSession(jumpServerUsername, jumpServerHostJMB, 22);
    	java.util.Properties config = new java.util.Properties(); 
		config.put("StrictHostKeyChecking", "no");
		config.put("Compresion", "yes");
		config.put("ConnectionAttempts","2");
		session.setConfig(config);
		session.connect();
		System.out.println("SSH session has been opened.");
    }
    
    /**************************************************************************
     * Description: Establishes session to PM SSH server
     * @param: none
     * @return: none
     * Status: complete
     *************************************************************************/
    public static void connectToSSHSessionPM() throws JSchException {
    	// Public key authentication
    	JSch jsch = new JSch();
    	jsch.addIdentity(privateKeyPath);
    
    	// Connect to SSH jump server 
    	session = jsch.getSession(jumpServerUsername, jumpServerHostJMB, 22);
    	java.util.Properties config = new java.util.Properties(); 
		config.put("StrictHostKeyChecking", "no");
		config.put("Compresion", "yes");
		config.put("ConnectionAttempts","2");
		session.setConfig(config);
		session.connect();
		System.out.println("SSH session has been opened.");
    }
    
    /**************************************************************************
     * Description: Forwards Local Port through SSH session to DB server
     * @param: none
     * @return: none
     * Status: complete
     *************************************************************************/
    public static void forwardLocalPortThroughSSHSession() throws JSchException {
    	session.setPortForwardingL(localPort, databaseHost, databasePort);
    	String[] test = session.getPortForwardingL();
		System.out.println("Local port through the SSH channel to database host/port complete : " + test[0]);
    }
    
    /**************************************************************************
     * Description: Disconnects session to SSH server
     * @param: none
     * @return: none
     * Status: complete
     *************************************************************************/
    public static void disconnectFromSSHSession() {
    	session.disconnect();
    	System.out.println("SSH session has been closed.");
    }
    
    /**************************************************************************
     * Description: Closes connection to DB
     * @param: none
     * @return: none
     * Status: complete
     *************************************************************************/
    public static void closeDBConnection() throws SQLException {
    	dbConnection.close();
    	System.out.println("Connection to database has been closed.");
    }
    
    /**************************************************************************
     * Description: Closes DB statement
     * @param: none
     * @return: none
     * Status: complete
     *************************************************************************/
    public static void closeDBStatement() throws SQLException {
    	dbStatement.close();
    	System.out.println("Current DB statement has been closed.");
    }
    
    
    /**************************************************************************
     * Description: Closes DB recordset
     * @param: none
     * @return: none
     * Status: complete
     *************************************************************************/
    public static void closeDBRecordSet() throws SQLException {
    	dbRecordSet.close();
    	System.out.println("Current DB recordset has been closed.");
    }
    
    /**************************************************************************
     * Description: Connects to JMB DB through SSH server
     * @param: none
     * @return: none
     * Status: complete
     *************************************************************************/
    public static void connectToSSHAndJMBDB() throws JSchException, ClassNotFoundException, SQLException {
    	connectToSSHSessionJMB();
    	forwardLocalPortThroughSSHSession();
    	//connectToQAJMBDB();
    	if (baseUrl.contains("https://qa")) {
    		dbConnection = DriverManager.getConnection(dbQAJMBUrl, databaseUsername, databasePassword);
    	} else {
    		dbConnection = DriverManager.getConnection(dbStagingJMBUrl, databaseUsername, databasePassword);
    	}
    	System.out.println("Connection open to JMB database.");
    }
    
    /**************************************************************************
     * Description: Connects to Silver DB through SSH server
     * @param: none
     * @return: none
     * Status: complete
     *************************************************************************/
    public static void connectToSSHAndSilverDB() throws JSchException, ClassNotFoundException, SQLException {
    	connectToSSHSessionJMB();
    	forwardLocalPortThroughSSHSession();
    	//connectToQASilverDB();
    	if (baseUrl.contains("https://qa")) {
    		dbConnection = DriverManager.getConnection(dbQASilverUrl, databaseUsername, databasePassword);
    	} else {
    		dbConnection = DriverManager.getConnection(dbStagingSilverUrl, databaseUsername, databasePassword);
    	}
    	System.out.println("Connection open to Silver database.");
    }
    
    /**************************************************************************
     * Description: Connects to Silver DB through SSH server
     * @param: none
     * @return: none
     * Status: complete
     *************************************************************************/
    public static void connectToSSHAndPMDB() throws JSchException, ClassNotFoundException, SQLException {
    	connectToSSHSessionPM();
    	forwardLocalPortThroughSSHSession();
    	//connectToQASilverDB();
    	if (baseUrl.contains("https://qa")) {
    		dbConnection = DriverManager.getConnection(dbQAJMBUrl, databaseUsername, databasePassword);
    	} else {
    		dbConnection = DriverManager.getConnection(dbStagingJMBUrl, databaseUsername, databasePassword);
    	}
    	System.out.println("Connection open to Silver database.");
    }
    
    /**************************************************************************
     * Description: Queries open DB connection and creates record set
     * @param: String selectStatement - select query to run against DB
     * @return: boolean - true if data is returned, otherwise false
     * Status: complete
     *************************************************************************/
    public static boolean queryDBAndGetRecordSet(String selectStatement) throws SQLException {
    	if (!(selectStatement.toLowerCase().contains("select"))) {
    		System.out.println("Current DB query '" + selectStatement + "' is not a SELECT statement. SQL statement must be a select.");
			return false;
    	}
    	dbStatement = dbConnection.createStatement();
    	dbRecordSet = dbStatement.executeQuery(selectStatement);
    	if (!dbRecordSet.isBeforeFirst()) {
    		System.out.println("Current DB query '" + selectStatement + "' did not return any results.");
			return false;
			
		}
    	else {
    		System.out.println("Current DB query '" + selectStatement + "' did return results.");
    		return true;
    	}
    }
    
    /**************************************************************************
     * Description: Queries open DB connection and stores data returned into a Linked Hash Map
     * @param: String selectStatement - select query to run against DB
     * @return: 2 dimensional Linked Hash Map with values contained in the recordset,
     * 				otherwise null
     * Status: complete
     *************************************************************************/
    public static LinkedHashMap<Object, Map<String,String>> queryAndConvertRecordSetToLinkedHashMap(String selectStatement) throws SQLException {
    	LinkedHashMap<Object, Map<String,String>> outerMap = new LinkedHashMap <>();
    	Map <String, String> innerMap;
    	ResultSetMetaData dbRecordSetMetaData;
    	int rowNumber = 1;
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    	Boolean errorFlag = false;
    	
    	// Query DB to create recordset
    	if (!queryDBAndGetRecordSet(selectStatement)) {
			Assert.fail("DB query of statement '" + selectStatement + "' did not return any results.");
		}
    	
    	// Cycle through recordset to insert data into Linked Hash Map
    	// All values will be insert as a string
    	dbRecordSetMetaData = dbRecordSet.getMetaData();
    	while (dbRecordSet.next()) {
    		innerMap = new LinkedHashMap<String, String>();
			for (int index = 1; index <= dbRecordSetMetaData.getColumnCount(); index ++) {
				switch (dbRecordSetMetaData.getColumnTypeName(index)) {
					case "INT": case "INTEGER": case "SMALLINT": 
						innerMap.put(dbRecordSetMetaData.getColumnName(index), String.valueOf(dbRecordSet.getInt(index)));
						break;
					case "FLOAT": 
						innerMap.put(dbRecordSetMetaData.getColumnName(index), String.valueOf(dbRecordSet.getFloat(index)));
						break;
					case "DOUBLE": 
						innerMap.put(dbRecordSetMetaData.getColumnName(index), String.valueOf(dbRecordSet.getDouble(index)));
						break;
					case "LONG": 
						innerMap.put(dbRecordSetMetaData.getColumnName(index), String.valueOf(dbRecordSet.getLong(index)));
						break;
					case "VARCHAR": case "CHAR": case "TEXT": 
						innerMap.put(dbRecordSetMetaData.getColumnName(index), dbRecordSet.getString(index));
						break;
					case "TIMESTAMP": case "DATETIME":
						innerMap.put(dbRecordSetMetaData.getColumnName(index), dbRecordSet.getTimestamp(index).toString());
						break;
					case "DATE": 
						innerMap.put(dbRecordSetMetaData.getColumnName(index), dateFormat.format(dbRecordSet.getDate(index)));
						break;
					default: 
						System.out.println("[FAIL] Invalid type: '" + dbRecordSetMetaData.getColumnTypeName(index) + "' for grabbing data for column: '" 
							+ dbRecordSetMetaData.getColumnName(index) + "' for row '" + rowNumber + "'. Code may need to be updated.");
						errorFlag = true;
						break;
				}
			}
			outerMap.put(rowNumber, innerMap);
			rowNumber++;
		}
    	
    	if (errorFlag) {
    		Assert.fail("Errors occured when try to get values form query '" + selectStatement + "' and store them into Linked Hash Map.");
    	}
    	System.out.println("DB query '" + selectStatement + "' recordset dats has been successfully inserted into Link Hash Map.");
    	return outerMap;
    }
    
    /**************************************************************************
     * Description: Close and disconnect the following: DB Recordset, DB Statement,
     * DB Connection, SSH session
     * @param: none
     * @return: none
     * Status: complete
     *************************************************************************/
    public static void closeAllDBAndSSHConnections() throws SQLException {
    	closeDBRecordSet();
    	closeDBStatement();
    	closeDBConnection();
    	disconnectFromSSHSession();
    }    
    // End DB variables and methods

    
    //JMB-5883 Start	
  	/**
  	 * Sends text to blank note field on order form 
  	 * @param note
  	 * @param reason
  	 */
  	public void addNote_orderForm(String note, String reason)	{
  		Q_WebElm.idSend(adminProps, "ord.addNoteText.id", note);
  		Q_WebElm.idSelectText(adminProps, "ord.addNoteCategory.id", reason);
  	}
  	
  	/**
  	 * Returns webelement through xpath
  	 * @param proper
  	 * @param locator
  	 * @return WebElement
  	 */
  	public WebElement webElement(Properties proper, String locator)	{
  		return driver.findElement(By.xpath(proper.getProperty(locator)));
  	}
  	
  	/**
  	 * Performs double click on a button
  	 * @param button
  	 */
  	public void doubleClick(String button)	{
  		Actions moveTo = new Actions(driver);
        moveTo.doubleClick(webElement(adminProps, button)).perform();
        Q_WebElm.myWait(3000);
  	}

  	/**
  	 * Verify each note in the listed note section of order form is not duplicated
  	 * @param note
  	 */
  	public void verifyDoubleStatements(String note)	{
  		Assert.assertTrue(Q_WebElm.listOfElements(adminProps, "ord.bottomNotesList.xp").get(0).getText().contains(note));
  		System.out.println(Q_WebElm.listOfElements(adminProps, "ord.bottomNotesList.xp").get(0).getText());
  		Assert.assertFalse(Q_WebElm.listOfElements(adminProps, "ord.bottomNotesList.xp").get(1).getText().contains(note), "Double mention of note found.");
  	}
  	
  	/**
  	 * Fills in the details of invoice on order form 
  	 * @param amount
  	 */
  	public void fillInvoiceDetails(String amount)	{
  		Q_WebElm.myWait(500);
  		Q_WebElm.id(adminProps,"ord.create.invoiceCreateCategory.id");
        Q_WebElm.idSelectText(adminProps,"ord.create.invoiceCreateCategory.id", "Underpayment");
        Q_WebElm.myWait(500);
        Q_WebElm.idSend(adminProps, "ord.create.invoiceCreateAmount.id", amount);
        Q_WebElm.myWait(1000);
        Q_WebElm.idSend(adminProps, "ord.create.invoiceCreateNotes.id", "Automated Test Case");
  	}
  	
  	/**
  	 * Verify each note in the listed note section of the buyback is not duplicated
  	 */
  	public void verifyDoubleStatements_buyback()	{
  		String log= Q_WebElm.xpRetAttr(adminProps, "bb.notesBottomCreated.xp","innerHTML");
  		Assert.assertTrue(log.split("<br>")[0].contains("Packing slip emailed to customer."), "Double mention of note found.");
  		Assert.assertTrue(log.split("<br>")[1].contains("Marked 1 Wire Transfer Fee as reviewed."), "Double mention of note found.");
  		Assert.assertTrue(log.split("<br>")[2].contains("Marked buyback as reviewed."), "Double mention of note found.");
  		Assert.assertTrue(log.split("<br>")[3].contains("Marked 10 1 oz Canadian Palladium Maple Leaf (Random Year, BU) as reviewed."), "Double mention of note found.");
  		Assert.assertTrue(log.split("<br>")[4].contains("Buyback created."), "Double mention of note found.");
  	}
  	
  	/**
  	 * Splits the line item on any receipt
  	 * @param splitQty
  	 */
  	public void splitLineItem(String splitQty)	{
  		Q_WebElm.xp(adminProps, "recp.splitLineItemDropdown.xp");
  		Q_WebElm.idSend(adminProps, "recp.splitItemQty.id", splitQty);
  		doubleClick("recp.splitLineItem.submitBtn.xp");
  	}
  	
  	/**
  	 * Verify if the split has been performed successfully
  	 * @param splitQty
  	 */
  	public void verifySplitLineItem(String splitQty)	{
  		Assert.assertTrue(rowCount("recp.noOfItemRows.xp")== 2);
  		Assert.assertEquals(Q_WebElm.xpRetAttr(adminProps, "adm.receiptProduct.beg.xp", 2, "adm.receiptQty.end.xp","value"),splitQty);
  	}
  	
  	/**
  	 * Fills claim details on order claim form
  	 */
  	public void fillClaimDetails()	{
  		Q_WebElm.myWait(4000);
  		Q_WebElm.xp(adminProps, "ord.initiateFullClaim.xp");
  		Q_WebElm.xp(adminProps, "ord.refund.reason.xp");
  		Q_WebElm.xpSelectText(adminProps, "ord.refund.reason.xp", "Delivered But Not Received");
  		Q_WebElm.xp(adminProps,"ord.refund.status.xp");
        Q_WebElm.xpSelectText(adminProps, "ord.refund.status.xp", "(40%) Awaiting documents from customer");
        Q_WebElm.xp(adminProps,"ord.claimResolution.xp");
        Q_WebElm.xpSelectText(adminProps, "ord.claimResolution.xp", "Claim/Return");
        Q_WebElm.xp(adminProps,"ord.claimDeclaration.xp");
        Q_WebElm.xpSelectText(adminProps, "ord.claimDeclaration.xp", "Missing Items UPS with Signature");
  	}
  	
  	/**
  	 * Fills return details on order return form
  	 */
  	public void fillReturnDetails()	{
  		Q_OrderForm ord= new Q_OrderForm();
  		DecimalFormat df = new DecimalFormat("#.00");
        String shipCost = ord.paymentInfo("shipping cost");
        String shipTax = ord.paymentInfo("shipping tax");
        Controls.scrolUpPixel(1000);
        Q_WebElm.xp(adminProps,"ord.initiateFullReturn.xp");
        String newLineItemTotal = Q_WebElm.xpRetNumber(adminProps,"ord.fullReturnToLineItemTotal.xp");
        System.out.println("Top line item total " + newLineItemTotal);
        Q_WebElm.xp(adminProps,"ord.refund.reason.xp");
        Q_WebElm.xpSelectText(adminProps, "ord.refund.reason.xp", "Missing Items");
        Q_WebElm.xp(adminProps,"ord.refund.status.xp");
        Q_WebElm.xpSelectText(adminProps, "ord.refund.status.xp", "(80%) Pending Receipt of Returned Items");
        Q_WebElm.xp(adminProps,"ord.claimResolution.xp");
        Q_WebElm.xpSelectText(adminProps, "ord.claimResolution.xp", "Coupon Issued Customer Satisfied");
        Q_WebElm.xpSendTab(adminProps,"ord.fullReturn.product1Qty.xp");
        float  totalRefundCalculated = (Float.valueOf(newLineItemTotal) + Float.valueOf(shipCost) + Float.valueOf(shipTax));
        System.out.println("Calculated total Refund " + totalRefundCalculated);
        float totalRefund = Float.valueOf(Q_WebElm.xpRetAttr(adminProps,"ord.fullReturnTotalRefun.xp","value"));
        Assert.assertEquals(df.format(totalRefund), df.format(totalRefundCalculated));
  	}
}
