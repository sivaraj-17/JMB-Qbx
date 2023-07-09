package pageObjects;

import jsonWrappers.AddressContainer;
import jsonWrappers.CreditContainer;
import jsonWrappers.UserContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Q_JMB_CheckoutObjects extends Q_JMB_Init {
    public Q_JMB_CheckoutObjects formXp(String locator) {
        Q_JMB_WebElm.xp(jmbProps, locator);
        return this;
    }

    public Q_JMB_CheckoutObjects formXp(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xp(jmbProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_JMB_CheckoutObjects formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_JMB_WebElm.xp(jmbProps, begXp, row, midXp, column, endXp);
        return this;
    }

    public Q_JMB_CheckoutObjects formInputXp(String locator, String inputValue) {
        Q_JMB_WebElm.xpClear(jmbProps, locator);
        Q_JMB_WebElm.xpSend(jmbProps, locator, inputValue);
        return this;
    }

    public Q_JMB_CheckoutObjects formInputXp(String begXp, Integer lineItem, String endXP, String inputValue) {
        Q_JMB_WebElm.xpClear(jmbProps, begXp, lineItem, endXP);
        Q_JMB_WebElm.xpSend(jmbProps, begXp, lineItem, endXP, inputValue);
        return this;
    }

    public static String strXpText(String locator) {
        return Q_JMB_WebElm.xpRetText(jmbProps, locator);
    }

    public static String strXpText(String begXp, Integer lineItem, String endXp) {
        return Q_JMB_WebElm.xpRetText(jmbProps, begXp, lineItem, endXp);
    }

    public static String strXpText(String begXp, Integer row, String midXp, Integer cell, String endXp) {
        return Q_JMB_WebElm.xpRetText(jmbProps, begXp, row, midXp, cell, endXp);
    }

    public static String numberReturn(String locator) {
        return Q_JMB_WebElm.xpRetTextReplace(jmbProps, locator);
    }

    public static String numberReturn(String begXp, Integer lineItem, String endXp) {
        return Q_JMB_WebElm.xpRetTextReplace(jmbProps, begXp, lineItem, endXp);
    }

    public static String numberReturn(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_JMB_WebElm.xpRetTextReplace(jmbProps, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public Q_JMB_CheckoutObjects formReturnText(String locator) {
        Q_JMB_WebElm.xpRetText(jmbProps, locator);
        return this;
    }

    public Q_JMB_CheckoutObjects formReturnText(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xpRetText(jmbProps, begXp, lineItem, endXp);
        return this;
    }

    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_JMB_WebElm.xpRetText(jmbProps, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public static String formReturnTextReplace(String locator) {
        return Q_JMB_WebElm.xpRetTextReplace(jmbProps, locator);
    }

    public Q_JMB_CheckoutObjects formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xpRetTextReplace(jmbProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_JMB_CheckoutObjects formReturnAttribute(String locator, String attr) {
        Q_JMB_WebElm.xpRetAttr(jmbProps, locator, attr);
        return this;
    }

    public static String attReturn(String locator, String attr) {
        return Q_JMB_WebElm.xpRetAttr(jmbProps, locator, attr);

    }

    public static String attReturn(String begXp, Integer lineItem, String endXp, String attr) {
        return Q_JMB_WebElm.xpAttribute(jmbProps, begXp, lineItem, endXp, attr);
    }

    public Q_JMB_CheckoutObjects formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_JMB_WebElm.xpAttribute(jmbProps, begXp, lineItem, endXp, attr);
        return this;
    }

    public Q_JMB_CheckoutObjects formReturnAttributeReplace(String locator) {
        Q_JMB_WebElm.xpReturnAttributeReplace(jmbProps, locator);
        return this;
    }

    public Q_JMB_CheckoutObjects formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xpReturnAttributeReplace(jmbProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_JMB_CheckoutObjects formXpDisplayed(String locator) {
        try {
            Q_JMB_WebElm.xpDisplayed(jmbProps, locator).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Q_JMB_CheckoutObjects formXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_JMB_WebElm.xpDisplayed(jmbProps, begXp, lineItem, endXP).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Q_JMB_CheckoutObjects formXpTab(String locator) {
        Q_JMB_WebElm.xpSendTab(jmbProps, locator);
        return this;
    }

    public Q_JMB_CheckoutObjects formXpTab(String begXp, Integer lineItem, String endXP) {
        Q_JMB_WebElm.xpSendTab(jmbProps, begXp, lineItem, endXP);
        return this;
    }

    public Q_JMB_CheckoutObjects formXpEnter(String locator) {
        Q_JMB_WebElm.xpSendEnter(jmbProps, locator);
        return this;
    }

    public Q_JMB_CheckoutObjects formXpEnter(String begXp, Integer lineItem, String endXP) {
        Q_JMB_WebElm.xpSendEnter(jmbProps, begXp, lineItem, endXP);
        return this;
    }

    public static boolean isXpDisplayed(String locator) {
        return Q_JMB_WebElm.xpEnabled(jmbProps, locator).equals(true);
    }

    public static boolean isXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_JMB_WebElm.xpDisplayed(jmbProps, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            System.out.println(ex);
            return false;
        }
    }

    public static boolean isXpCheckSelected(String locator) {
        return Q_JMB_WebElm.xpSelected(jmbProps, locator).equals(true);
    }

    public static boolean isXpCheckSelected(String begXp, Integer lineItem, String endXP) {
        return Q_JMB_WebElm.xpSelected(jmbProps, begXp, lineItem, endXP).equals(true);
    }

    public static boolean isXpCheckEnabled(String locator) {
        return Q_JMB_WebElm.xpEnabled(jmbProps, locator).equals(true);
    }

    public static boolean isXpCheckEnabled(String begXp, Integer lineItem, String endXP) {
        try {
            Q_JMB_WebElm.xpEnabled(jmbProps, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            return false;
        }
    }

    public Q_JMB_CheckoutObjects formXpSelectIndex(String locator, Integer index) {
        Q_JMB_WebElm.xpSelectIndex(jmbProps, locator, index);
        return this;
    }

    public Q_JMB_CheckoutObjects formXpSelectValue(String locator, String value) {
        Q_JMB_WebElm.xpSelectValue(jmbProps, locator, value);
        return this;
    }

    public Q_JMB_CheckoutObjects formXpSelectText(String locator, String text) {
        Q_JMB_WebElm.xpSelectText(jmbProps, locator, text);
        return this;
    }

    public Q_JMB_CheckoutObjects formId(String locator) {
        Q_JMB_WebElm.id(jmbProps, locator);
        return this;
    }

    public Q_JMB_CheckoutObjects formInputId(String locator, String inputValue) {
        Q_JMB_WebElm.idClear(jmbProps, locator);
        Q_JMB_WebElm.idSend(jmbProps, locator, inputValue);
        return this;
    }

    public Q_JMB_CheckoutObjects formIdTab(String locator) {
        Q_JMB_WebElm.idSendTab(jmbProps, locator);
        return this;
    }

    public static String strIdText(String locator) {
        return Q_JMB_WebElm.idRetText(jmbProps, locator);
    }

    public static String idStrRet(String locator) {
        return Q_JMB_WebElm.idRetText(jmbProps, locator);
    }

    public static String idNumberReturn(String locator) {
        return Q_JMB_WebElm.idRetTextRep(jmbProps, locator);
    }

    public static String idAttRet(String locator, String attr) {
        return Q_JMB_WebElm.idAttrRet(jmbProps, locator, attr);
    }

    public static boolean isIdDisplayed(String locator) {
        return Q_JMB_WebElm.idDisplayed(jmbProps, locator).equals(true);
    }

    public static boolean isIdCheckEnabled(String locator) {
        return Q_JMB_WebElm.idEnabled(jmbProps, locator).equals(true);
    }

    public Q_JMB_CheckoutObjects formIdSelectIndex(String locator, Integer index) {
        Q_JMB_WebElm.idSelectIndex(jmbProps, locator, index);
        return this;
    }

    public Q_JMB_CheckoutObjects formIdSelectValue(String locator, String value) {
        Q_JMB_WebElm.idSelectValue(jmbProps, locator, value);
        return this;
    }

    public Q_JMB_CheckoutObjects formIdSelectText(String locator, String text) {
        Q_JMB_WebElm.idSelectText(jmbProps, locator, text);
        return this;
    }

    public static Integer rowCount(String locator) {
        Integer count = Q_JMB_WebElm.xpCountTableRows(jmbProps, locator);
        return count;
    }

    public Q_JMB_CheckoutObjects selectItem(String item, Integer quan) throws FileNotFoundException {
        Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
        switch ( item ){
            case("10 Gram Perth Mint Gold Bar"):
                driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar/");
                Q_JMB_WebElm.myWait(1000);
                cart.addItemToCart(quan);
                break;
            case("1 oz American Gold Eagle Coin"):
                driver.navigate().to(baseUrl + "/1-oz-american-gold-eagle/");
                Q_JMB_WebElm.myWait(1000);
                cart.addItemToCart(quan);
                break;
            case("2.5 Gram Valcambi Gold Bar"):
                driver.navigate().to(baseUrl + "/2-5-gram-valcambi-gold-bar/");
                Q_JMB_WebElm.myWait(1000);
                cart.addItemToCart(quan);
                cart.selectPaymentType("credit card");
                Q_JMB_WebElm.id(jmbProps, "cart.preSaleMsgCheckbox.id");
                break;
            case("3 Gram Chinese Gold Panda"):
                driver.navigate().to(baseUrl + "/3-gram-chinese-gold-panda-varied/");
                cart.addItemToCart(quan);
                break;
            case("10 oz gold bar"):
                driver.navigate().to(baseUrl + "/10-oz-credit-suisse-gold-bar/");
                cart.addItemToCart(quan);
                break;
            case("1994 1 oz American Silver Eagle Coin"):
                driver.navigate().to(baseUrl + "/1994-american-silver-eagle/");
                cart.addItemToCart(quan);
                break;
            case("100 oz Geiger Security"):
                driver.navigate().to(baseUrl + "/100-oz-geiger-security-line-silver-bar/");
                cart.addItemToCart(quan);
                break;
            case("Peace Silver Dollar"):
                driver.navigate().to(baseUrl + "/peace-silver-dollar/");
                cart.addItemToCart(quan);
                break;
            case("2016 30 g chinese silver panda"):
                driver.navigate().to(baseUrl + "/2016-30-g-chinese-silver-panda/");
                cart.addItemToCart(quan);
                break;
            case("1 oz American Platinum Eagle Coin"):
                System.out.println("Verified user is on the customer page pages");
                driver.navigate().to(baseUrl + "/1-oz-american-platinum-eagle-varied/");
                cart.addItemToCart(quan);
                break;
            case("1 oz pamp suisse platinum bar"):
                driver.navigate().to(baseUrl + "/1-oz-pamp-suisse-platinum-bar/");
                cart.addItemToCart(quan);
                break;
            case("10 oz pamp suisse platinum bar"):
                driver.navigate().to(baseUrl + "/10-oz-pamp-suisse-platinum-bar-new-w-assay/");
                cart.addItemToCart(quan);
                break;
            case("1 oz US Quarter Copper"):
                driver.navigate().to(baseUrl + "/1-oz-quarter-copper-round/");
                cart.addItemToCart(quan);
                cart.selectPaymentType("credit card");

                break;
            case("walking-liberty"):
                driver.navigate().to(baseUrl + "/1-oz-walking-liberty-copper-round/");
                cart.addItemToCart(quan);
                cart.selectPaymentType("credit card");

                break;
            case("33mm CoinSafe Coin Tube"):
                driver.navigate().to(baseUrl + "/33-mm-air-tite-coin-tube/");
                cart.addItemToCart(quan);
                break;
            case("1 oz Canadian Silver Maple Leaf Coin"):
                driver.navigate().to(baseUrl + "/canadian-silver-maple-leaf-varied-year/");
                cart.addItemToCart(quan);
                break;
            case("2019 Canadian Silver Maple Leaf Tube (25 Coins, BU)"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf-tube");
                cart.addItemToCart(quan);
                break;
            case("2019 Canadian Silver Maple Leaf Monster Box (500 Coins, BU)"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf-monster-box/");
                cart.addItemToCart(quan);
                break;
            case("multiple products 2"):
                driver.navigate().to(baseUrl + "/1-oz-quarter-copper-round/");
                cart.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar/");
                cart.addItemToCart(quan);
                break;
            default:
                System.out.println("Item not found");

                break;
        }
        return this;
    }
    public Q_JMB_CheckoutObjects bridgeGuest() {
        Q_JMB_WebElm.myWait(2000);
        formXp("chk.bridgeGuestBtn.xp");
        Q_JMB_WebElm.myWait(2000);
        return this;
    }

    public Q_JMB_CheckoutObjects bridgeLogin(Integer userIndex) {
        UserContainer uc = new UserContainer(userIndex);
        Q_JMB_WebElm.myWait(2000);
        formInputId("chk.bridge.email.id", uc.userEmail);
        formInputId("chk.bridge.pwd.id", uc.passwd);
        formXp("chk.bridgeBtn.xp");
        return this;
    }

    public Q_JMB_CheckoutObjects guestEmail(String emailAdd) {
        formInputId("chk.guest.email.id", emailAdd);
        return this;
    }

    public Q_JMB_CheckoutObjects existingEmail() {
        try {
            isIdDisplayed("chk.guestExistingEmailModal.xp");
            formXp("chk.guestExistingEmailClose.xp");
            driver.navigate().to(baseUrl + "/cart");
            System.out.println("Guest user using a registered email");
        } catch (Throwable ex) {
            System.out.println("Failed to verify existing email test");
            Assert.fail("Failed to verify existing email test");
        }
        return this;
    }

    public Q_JMB_CheckoutObjects shippingAddressForm(Integer addIndex) throws FileNotFoundException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS.SECONDS);
        AddressContainer ship = new AddressContainer(addIndex);
        formInputId("chk.shipping.firstName.id", ship.firstName);
        formInputId("chk.shipping.lastName.id", ship.lastName);
        formInputId("chk.shipping.address.id", ship.street);
        Q_JMB_WebElm.myWait(1000);
        formIdTab("chk.shipping.address.id");
        Q_JMB_WebElm.myWait(1000);
        formIdTab("chk.shipping.address.id");
        Q_JMB_WebElm.myWait(1000);
        formInputId("chk.shipping.city.id", ship.city);
        formIdSelectValue("chk.shipping.state.id", ship.state);
        Q_JMB_WebElm.myWait(2000);
        formInputId("chk.shipping.zip.id", ship.zipcode);
        formInputId("chk.shipping.phone.id", ship.phoneNumber);
        Q_JMB_WebElm.myWait(2000);
        return this;
    }

    public Q_JMB_CheckoutObjects creditCardForm(Integer index) throws FileNotFoundException {
        CreditContainer card = new CreditContainer(index);
        Q_JMB_WebElm.myWait(2000);
        Assert.assertTrue(Q_JMB_WebElm.idDisplayed(jmbProps, "chk.cardName.id"));
        formInputId("chk.cardName.id", card.cdName);
        formInputId("chk.cardNumber.id", card.cdNumber);
        formIdSelectValue("chk.cardMonth.id", card.monthV);
        formIdSelectIndex("chk.cardYear.id", card.year);
        Q_JMB_WebElm.idSend(jmbProps, "chk.cardCvv.id", card.code);
        return this;
    }

    public Q_JMB_CheckoutObjects saveShippingAddress() {
        formId("chk.shipping.validate.id");
        Q_JMB_WebElm.myWait(1000);
        if(isIdDisplayed("chk.shipping.error.id")){
            formId("chk.shipping.ContinueWithAdd.id");
        }
       Q_JMB_WebElm.myWait(1000);
        return this;
    }
    public Q_JMB_CheckoutObjects saveShippingAddress(String alertText) {
        formId("chk.shipping.validate.id");
        Assert.assertEquals(Q_JMB_Controls.getAlertText(), alertText);
        return this;
    }
    public Q_JMB_CheckoutObjects attemptOrder(String tcName){
        Q_JMB_WebElm.myWait(2000);
        Q_JMB_WebElm.xpExecutor(jmbProps, "chk.consent.xp");
        Q_JMB_WebElm.myWait(1000);
        formId("chk.finishAndPlace.id");
        System.out.println("Error message: " + Q_JMB_WebElm.xpRetText(jmbProps, "chk.woocommerce.error.xp"));
        Q_JMB_WebElm.myWait(2000);
        Q_JMB_Controls.captureScreen(driver, tcName);
        return this;
    }
    public Q_JMB_CheckoutObjects validateErrorrMsgContains(String expected){
        System.out.println("Error message: " + Q_JMB_WebElm.xpRetText(jmbProps, "chk.woocommerce.error.xp"));
        Assert.assertTrue(Q_JMB_WebElm.xpRetText(jmbProps, "chk.woocommerce.error.xp").contains(expected));
        return this;
    }
    public Q_JMB_CheckoutObjects validateErrorrMsg(String expected){
        Assert.assertTrue(Q_JMB_WebElm.xpRetText(jmbProps, "chk.woocommerce.error.xp").contains(expected));
        return this;
    }
    public Q_JMB_CheckoutObjects completeOrder() {
        Q_JMB_WebElm.myWait(2000);
//        formXp("chk.consent.xp");
        Q_JMB_WebElm.xpExecutor(jmbProps, "chk.consent.xp");
        Q_JMB_WebElm.myWait(1000);
        formId("chk.finishAndPlace.id");
        return this;
    }

    public Q_JMB_CheckoutObjects thankYouPage() {
        Q_JMB_WebElm.myWait(5000);
        isXpDisplayed("chk.ThankYouPage.xp");
        System.out.println("Order Number ORD-" + numberReturn("chk.orderCompleteThankYouPage.xp"));
        return this;
    }

    public Q_JMB_CheckoutObjects quickCart() {
        Integer cartItems = Integer.valueOf(numberReturn("chk.quickCart.xp"));
        System.out.println("Current cart = :    " + cartItems);
        Assert.assertTrue(cartItems >= 1);
        return this;
    }

    public Q_JMB_CheckoutObjects cvvCardType(Integer cvvIndex) throws Exception {
        //WebElm.myWait(5000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        String cardTypeText = strXpText("chk.selectedCard.xp");
        System.out.println(cardTypeText);
        CreditContainer cvv = new CreditContainer(cvvIndex);
        if (cardTypeText.contains("American Express")) {
            formInputId("chk.cvv.id", cvv.code);
            //Log.info("\t Verified master card holder can complete order and checkout successfully");
            System.out.println(strXpText("chk.selectedCard.xp").substring(0, 32));
        } else if (cardTypeText.contains("MasterCard")) {
            formInputId("chk.cvv.id", cvv.code);
            //Log.info("\t Verified master card holder can complete order and checkout successfully");
            System.out.println(strXpText("chk.selectedCard.xp").substring(0, 26));
        } else if (cardTypeText.contains("Visa")) {
            formInputId("chk.cvv.id", cvv.code);
            //Log.info("\t Verified master card holder can complete order and checkout successfully");
            System.out.println(strXpText("chk.selectedCard.xp").substring(0, 20));
        } else if (cardTypeText.contains("Discover")) {
            formInputId("chk.cvv.id", cvv.code);
            //Log.info("\t Verified master card holder can complete order and checkout successfully");
            System.out.println(strXpText("chk.selectedCard.xp").substring(0, 24));
        } else {
            System.out.println("No credit card on file");
        }
        Q_JMB_WebElm.myWait(1000);
        return this;
    }
    public static void itemTax(){
        Integer itemCount = rowCount("chk.itemCount.xp");
        System.out.println("Items in order " + itemCount);
        for(int i = 5; i < itemCount; i++){
            System.out.println(strXpText("chk.itemBeg.xp", i, "chk.itemDescription.end.xp") + "\t \t" +
                    "Item tax: " + "\t" + strXpText("chk.itemBeg.xp", i, "chk.itemTax.end.xp"));
        }
    }
    public static List<Float> revPriceList() {
        Q_JMB_WebElm.myWait(2000);
        List<Float> priceList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(idNumberReturn("chk.revSubtotal.id"));

        Float tax = Float.valueOf(idNumberReturn("chk.revTax.id"));

        Float shipping = Float.valueOf(idNumberReturn("chk.revShipping.id"));

        Float total = Float.valueOf(idNumberReturn("chk.revTotal.id"));
        priceList.add(subtotal);
        priceList.add(shipping);
        priceList.add(tax);
        priceList.add(total);
        return priceList;
    }

    public static List<Float> orderPriceList() {
        Q_JMB_WebElm.myWait(4000);
        List<Float> orderList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(idNumberReturn("chk.orderSubtotal.id"));
        Float tax = Float.valueOf(idNumberReturn("chk.orderSalesTax.id"));
        Float shipping = Float.valueOf(idNumberReturn("chk.orderShipping.id"));
        Float total = Float.valueOf(idNumberReturn("chk.orderTotal.id"));
        orderList.add(subtotal);
        orderList.add(shipping);
        orderList.add(tax);
        orderList.add(total);

        return orderList;
    }

    public static List<Float> revPriceListNoTax() {
        Q_JMB_WebElm.myWait(2000);
        List<Float> priceList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(idNumberReturn("chk.revSubtotal.id"));
        Float shipping = Float.valueOf(idNumberReturn("chk.revShipping.id"));
        Float total = Float.valueOf(idNumberReturn("chk.revTotal.id"));
        priceList.add(subtotal);
        priceList.add(shipping);
        priceList.add(total);
        return priceList;
    }

    public static List<Float> orderPriceListNoTax() {
        Q_JMB_WebElm.myWait(2000);
        List<Float> orderList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(idNumberReturn("chk.orderSubtotal.id"));
        orderList.add(subtotal);
        if (idNumberReturn("chk.orderShipping.id").contains("Free")) {
            Float shipping = Float.valueOf(idNumberReturn("chk.orderShipping.id").replaceAll("[^0-9?!\\.]", "0"));
            orderList.add(shipping);
        } else {
            Float shipping = Float.valueOf(idNumberReturn("chk.orderShipping.id"));
            orderList.add(shipping);
        }
        Float total = Float.valueOf(idNumberReturn("chk.orderTotal.id"));
        orderList.add(total);
        return orderList;
    }

    public static List<Float> revPriceListSh() {
        Q_JMB_WebElm.myWait(2000);
        DecimalFormat df = new DecimalFormat("#.00");
        List<Float> priceList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(idNumberReturn("chk.revSubtotal.id"));
        String subtax = df.format(Float.valueOf(idNumberReturn("chk.revTax.id")));
        String shTax = df.format(Float.valueOf(idNumberReturn("chk.revShiptax.id")));
        System.out.println("Merchendise tax: " + subtax + "\n" + "Shipping Tax: " + shTax);
        Float tax1 = Float.valueOf(subtax);
        Float tax2 = Float.valueOf(shTax);
        String taxTotal = String.format("%.2f", tax1 + tax2);
        Float tax = Float.valueOf(taxTotal);
        Float shipping = Float.valueOf(idNumberReturn("chk.revShipping.id"));
        Float total = Float.valueOf(idNumberReturn("chk.revTotal.id"));
        priceList.add(subtotal);
        priceList.add(shipping);
        priceList.add(tax);
        priceList.add(total);
        return priceList;
    }

    public Q_JMB_CheckoutObjects regShippingUpgrade(String shippingOption) {
        Q_JMB_WebElm.myWait(1000);
        switch ( shippingOption ) {
            case "default":
                Q_JMB_WebElm.xpExecutor(jmbProps,"chk.reg.shippingOptionBase.xp");
                System.out.println("shipping charge: " + numberReturn("chk.reg.shippingDefaultCharge.xp"));
                break;
            case "option 2":
                Q_JMB_WebElm.xpExecutor(jmbProps,"chk.reg.shippingOptionPriority.xp");
                System.out.println("shipping charge: " + numberReturn("chk.reg.shippingPriorityCharge.xp"));
                break;
            case "option 3":
               Q_JMB_WebElm.xpExecutor(jmbProps,"chk.reg.shippingOption3day.xp");
                System.out.println("shipping charge: " + numberReturn("chk.reg.shipping3dayCharge.xp"));
                break;
            case "guest default":
                formXp("chk.guest.shippingOptionBase.xp");
                System.out.println("shipping charge: " + numberReturn("chk.guest.shippingDefaultCharge.xp"));
                break;
            case "guest option 2":
                Q_JMB_WebElm.xpExecutor(jmbProps,"chk.guest.shippingOptionPriority.xp");
                System.out.println("shipping charge: " + numberReturn("chk.guest.shipping.PriorityCharge.xp"));
                break;
            case "guest option 3":
                Q_JMB_WebElm.xpExecutor(jmbProps,"chk.guest.shippingOption3day.xp");
                System.out.println("shipping charge: " + numberReturn("chk.guest.shipping3dayCharge.xp"));
                break;
            case "paypal default":
                Q_JMB_WebElm.xpExecutor(jmbProps,"chk.paypal.shippingOption1.xp");
                System.out.println("shipping charge: " + numberReturn("chk.paypal.shippingOption1Charge.xp"));
                break;
            case "paypal option 2":
                if (Q_JMB_WebElm.xpSelected(jmbProps, "chk.paypal.shippingOption2.xp").equals(true)) {
                    Q_JMB_WebElm.xpExecutor(jmbProps,"chk.paypal.shippingOption2.xp");
                    System.out.println("shipping charge: " + numberReturn("chk.paypal.shippingOption2Charge.xp"));
                } else {
                    driver.navigate().refresh();
                    Q_JMB_WebElm.xpExecutor(jmbProps,"chk.paypal.shippingOption2.xp");
                    System.out.println("shipping charge: " + numberReturn("chk.paypal.shippingOption2Charge.xp"));
                }
                break;
            case "paypal option 3":
                formXp("chk.paypal.shippingOption3.xp");
                System.out.println("shipping charge: " + numberReturn("chk.paypal.shippingOption3Charge.xp"));
                break;
            case "local pickup":
            	Q_JMB_WebElm.xpExecutor(jmbProps, "chk.reg.LocalPickup.xp");
                System.out.println("shipping charge: " + numberReturn("chk.reg.LocalPickupText.xp"));
                break;
        }
        Q_JMB_WebElm.myWait(3000);
        return this;
    }
    public Q_JMB_CheckoutObjects verifyOrderCharges(List revCharges, List orderCharges) {
        System.out.println("Review Page " + revCharges);
        System.out.println("Order Page " + orderCharges);
        if (revCharges.size() > orderCharges.size()) {
            Object[] renCh = revCharges.toArray();
            Object[] orderCh = orderCharges.toArray();
        }
        for (int i = 0; i < orderCharges.size(); i++) {
            System.out.println("Review Page " + strXpText("chk.begOrderCharges.xp", (i + 1), "chk.endOrderCharges.xp") + "  " + revCharges.get(i));
            System.out.println("Order Page  " + strXpText("chk.begOrderCharges.xp", (i + 1), "chk.endOrderCharges.xp") + "  " + orderCharges.get(i));
            Assert.assertEquals(revCharges.get(i), orderCharges.get(i));
        }
        return this;
    }

    public Q_JMB_CheckoutObjects verifyGuestOrderCharges(List revCharges, List orderCharges) {
        System.out.println("Review Page " + revCharges);
        System.out.println("Order Page " + orderCharges);
        if (revCharges.size() > orderCharges.size()) {
            Object[] renCh = revCharges.toArray();
            Object[] orderCh = orderCharges.toArray();
        }
        for (int i = 0; i < orderCharges.size(); i++) {
            System.out.println("Review Page " + strXpText("chk.begGuestOrderCharges.xp", (i + 1), "chk.endOrderCharges.xp") + "  " + revCharges.get(i));
            System.out.println("Order Page  " + strXpText("chk.begGuestOrderCharges.xp", (i + 1), "chk.endOrderCharges.xp") + "  " + orderCharges.get(i));
            Assert.assertEquals(revCharges.get(i), orderCharges.get(i));
        }
        return this;
    }

    public Q_JMB_CheckoutObjects orderStatus(String expectedstatus) {
        Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
        String orderNo = numberReturn("chk.orderCompleteThankYouPage.xp");
        System.out.println(orderNo);
        acc.myAccount("orders");
        String status = Q_JMB_WebElm.xpRetText(jmbProps, "acc.orderTopStatus.xp");
        Assert.assertEquals(orderNo, Q_JMB_WebElm.xpRetText(jmbProps, "acc.orderTop.xp"));
        Assert.assertEquals(status, expectedstatus);
        System.out.println("Verified order status for order number: " + orderNo + "\t status is: " + expectedstatus);
        return this;
    }
    public Q_JMB_CheckoutObjects newCardClick() {
        Q_JMB_WebElm.xpExecutor(jmbProps,"chk.newcard.xp");
        Q_JMB_WebElm.myWait(1000);
        return this;
    }
    public Q_JMB_CheckoutObjects selectCard(String cardType, String cvv){
        switch(cardType ){
            case "visa":
                Q_JMB_WebElm.myWait(1000);
                Q_JMB_WebElm.xp(jmbProps, "chk.visa.xp");
                ccvCode(cvv);
                break;
            case "mc":
                Q_JMB_WebElm.myWait(1000);
                Q_JMB_WebElm.xp(jmbProps, "chk.masterCard.xp");
                Q_JMB_WebElm.xp(jmbProps, "chk.masterCard.xp");
                ccvCode(cvv);
                break;
            case "amex":
                Q_JMB_WebElm.myWait(1000);
                Q_JMB_WebElm.xp(jmbProps, "chk.amex.xp");
                ccvCode(cvv);
                break;
            default:
                System.out.println("card type incorrect or not supported");
        }
        return this;
    }
    public static void ccvCode(String cvv) {
        Q_JMB_WebElm.idClear(jmbProps, "chk.cardCvv.id");
        Q_JMB_WebElm.idSend(jmbProps, "chk.cardCvv.id",cvv);
    }

    public Q_JMB_CheckoutObjects switchCard() {
        Q_JMB_WebElm.myWait(1000);
        try {
            Assert.assertTrue(Q_JMB_WebElm.nameSelected(jmbProps, "chk.checkout.reg.slectedPayment.name"));
            formXp("chk.reg.inactiveCard2.xp");
        } catch (Throwable ex) {
            formXp("chk.reg.inactiveCard1.xp");
        }
        System.out.println("Switched payment from default to non default payment");
        return this;
    }

    public Q_JMB_CheckoutObjects switchAddress() {
        if (Q_JMB_WebElm.xpSelected(jmbProps, "chk.reg.shAddressDefault.xp").equals(true)) {
            System.out.print("Current address " + strXpText("chk.reg.shDefaulAddressDetails.xp"));
            System.out.println("\n");
            Q_JMB_WebElm.xpExecutor(jmbProps, "chk.reg.shAddressReview.xp");
            System.out.print("New selected address " + Q_JMB_WebElm.xpRetText(jmbProps,"chk.newSelectedAddressDetais.xp" ));

        } else {
            Q_JMB_WebElm.xpExecutor(jmbProps, "chk.reg.shAddressAccept.xp");
            System.out.print("Switched to " + Q_JMB_WebElm.xpRetText(jmbProps,"chk.reg.shDefaulAddressDetails.xp" ));
            System.out.println("\n");
        }
        return this;
    }

    public Q_JMB_CheckoutObjects editShipping(String saveShippingAdd) {
        formXp("chk.reg.edditFirstShippingAddressBtn.xp");
        String shAdd1 ="";
        String shAdd2 ="";
        shAdd1 = attReturn("chk.reg.shaddress1.xp", "value");
        System.out.println("Shipping Address is " + shAdd1);
        if (attReturn("chk.reg.shaddress1.xp", "value").compareTo("8525 N Tryon St") == 0) {
            formInputXp("chk.reg.shaddress1.xp", "5225 N Tryon St");
            Q_JMB_WebElm.myWait(1000);
            formId("chk.shipping.firstName.id");
            formId("chk.shipping.lastName.id");
            System.out.println("");
            shAdd2 =  attReturn("chk.reg.shaddress1.xp", "value");

        } else {
            formInputXp("chk.reg.shaddress1.xp", "8525 N Tryon St");
            Q_JMB_WebElm.myWait(2000);
            formId("chk.shipping.firstName.id");
            //formId("chk.shipping.lastName.id");
            shAdd2 = attReturn("chk.reg.shaddress1.xp", "value");
        }

        System.out.println("Shipping Address is " + shAdd1);
        System.out.println("Shipping Address is " + shAdd2);
        saveShippingAddress();
        return this;
    }

    public Q_JMB_CheckoutObjects creditCardRequired() {
        isIdDisplayed("chk.reg.newCard.id");
        Q_JMB_WebElm.cn(jmbProps, "chk.reviewOrderNodify.className");
        return this;
    }

    public Q_JMB_CheckoutObjects echeckForm(String account) {
        Q_JMB_WebElm.myWait(1000);
        switch ( account ) {
            case "echeck":
                Assert.assertTrue(strXpText("chk.echeck.selectedAcc.xp").contains("5309"));
                break;
            case "plaid":
                Assert.assertTrue(strXpText("chk.echeck.selectedAcc.xp").contains("1111"));
                break;
            case "new echeck":

                formXp("chk.echeckBtn.xp");
                Q_JMB_WebElm.idSend(jmbProps, "chk.reg.echeck.routing.id", "031202084");
                Q_JMB_WebElm.xpSend(jmbProps, "chk.reg.echeckAcc1.xp", "8675309");
                Q_JMB_WebElm.xpSend(jmbProps, "chk.reg.echeckAcc2.xp", "8675309");
                formXp("chk.reg.echeckAuth.xp");

                formId("chk.echeck.continuebtn.id");
                break;
            case "new ach":
                formXp("chk.guestAch.xp");
                driver.switchTo().frame("plaid-link-iframe-1");
                Q_JMB_WebElm.myWait(1000);
                formId("chk.plaid.continue.id");

                formXp("chk.plaidChase.xp");
                Q_JMB_WebElm.idSend(jmbProps, "chk.plaid.chase.user.id", "user_good");
                Q_JMB_WebElm.idSend(jmbProps, "chk.plaid.chase.pass.id", "pass_good");
                formId("chk.plaid.chase.submit.id");
                Q_JMB_WebElm.myWait(4000);
                formXp("chk.guestPlaidChecking.xp");
                formXp("chk.plaidVerifiedContinue.xp");
                driver.switchTo().defaultContent();
                break;
            default:
                break;
        }
        return this;
    }

    public Q_JMB_CheckoutObjects completeOrderError() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Q_JMB_WebElm.myWait(2000);
        formXp("chk.consent.xp");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("submit"))));
        try {
            formId("chk.finishAndPlace.id");
            String orderNo = numberReturn("chk.thankyouOrderNumber.xp");
            System.out.println("Order Number " + orderNo);
        } catch (Exception e) {
            Assert.assertTrue(Q_JMB_WebElm.cnDisplayed(jmbProps, "chk.guest.woocommerce.error.className"));
        }
        return this;
    }
    public Q_JMB_CheckoutObjects checkoutModal(String tcName){
        Q_JMB_WebElm.xp(jmbProps, "chk.consent.xp");
        Q_JMB_WebElm.id(jmbProps, "chk.finishAndPlace.id");
        Q_JMB_WebElm.myWait(1000);

        driver.switchTo().frame("step-up-iframe");
//        System.out.println(WebElm.xpRetText(jmbProps, "text.xp"));
        WebElement frameElement = driver.findElement(By.xpath("/html/body/div[1]/div/iframe"));
        driver.switchTo().frame(frameElement);
        Q_JMB_WebElm.myWait(1000);
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "chk.checkoutModalChallenge.xp").toString());
        Q_JMB_WebElm.xpClear(jmbProps, "chk.checkoutModalChallenge.xp");
        Q_JMB_WebElm.xpSend(jmbProps, "chk.checkoutModalChallenge.xp", "1234");
        Q_JMB_WebElm.xpExecutorScrolToElement(jmbProps, "chk.checkoutModalSubmit.xp");
        Q_JMB_WebElm.xp(jmbProps, "chk.checkoutModalSubmit.xp");
        //Q_JMB_Controls.captureScreen(driver, tcName);
        Q_JMB_WebElm.myWait(5000);
		try {
			Q_JMB_WebElm.myWait(1000);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			//exception handling
			System.out.println("Recovering from exception when handling switching from frame due to detached frame.");
		}
        return this;
    }
    public Q_JMB_CheckoutObjects checkoutModalError(){
        Q_JMB_WebElm.xp(jmbProps, "chk.consent.xp");
        Q_JMB_WebElm.id(jmbProps, "chk.finishAndPlace.id");
        Q_JMB_WebElm.myWait(1000);

        driver.switchTo().frame("step-up-iframe");
//        System.out.println(WebElm.xpRetText(jmbProps, "text.xp"));
        WebElement frameElement = driver.findElement(By.xpath("/html/body/div[1]/div/iframe"));
        driver.switchTo().frame(frameElement);
        Q_JMB_WebElm.myWait(1000);
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "chk.checkoutModalChallenge.xp").toString());
        Q_JMB_WebElm.xpClear(jmbProps, "chk.checkoutModalChallenge.xp");
        Q_JMB_WebElm.xpSend(jmbProps, "chk.checkoutModalChallenge.xp", "1234");
        Q_JMB_Controls.xpExecutorScrollToView(jmbProps, "chk.checkoutModalSubmit.xp");
        Q_JMB_WebElm.xp(jmbProps, "chk.checkoutModalSubmit.xp");
        try {
			Q_JMB_WebElm.myWait(1000);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			//exception handling
			System.out.println("Recovering from exception when handling switching from frame due to detached frame.");
		}
        Q_JMB_WebElm.myWait(4000);
        return this;
    }
    public static void modalErrorMsg(String tcName){
        driver.switchTo().frame("step-up-iframe");
        System.out.println("modal error " + Q_JMB_WebElm.xpRetText(jmbProps, "chk.checkoutModalErrorText.xp"));
        //Q_JMB_Controls.captureScreen(driver, tcName);
        try {
			Q_JMB_WebElm.myWait(1000);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			//exception handling
			System.out.println("Recovering from exception when handling switching from frame due to detached frame.");
		}
    }
    public static void isOrderComplete(String tcName){
        Q_JMB_WebElm.myWait(3000);
        System.out.println(driver.getCurrentUrl());
        String orderNo = numberReturn("chk.orderCompleteThankYouPage.xp");
        System.out.println("Order Number: " + orderNo);
        Q_JMB_Controls.captureScreen(driver, tcName);
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "chk.ThankYouPage.xp"), "Thank You For Your Order!");
    }
    public Q_JMB_CheckoutObjects editShippingName(Integer index) throws FileNotFoundException {
        formXp("chk.reg.shaddress2EditBtn.xp");
        AddressContainer ship = new AddressContainer(index);
        formInputId("chk.shipping.firstName.id", ship.firstName);
        formInputId("chk.shipping.lastName.id", ship.lastName);
        return this;
    }

    public Q_JMB_CheckoutObjects payPalCheckout(String paymentType, String chkOutBtn, String originalWindow) {
        Q_JMB_WebElm.idExecutor(jmbProps, paymentType);
        Q_JMB_WebElm.myWait(2000);
        Q_JMB_WebElm.xp(jmbProps, chkOutBtn);
        Q_JMB_WebElm.myWait(2000);
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertTrue(isIdDisplayed("chk.paypal.checkout.ppEmail.id"));
        Q_JMB_WebElm.myWait(2000);
        return this;
    }

    public Q_JMB_CheckoutObjects payPal(String emailValue, String password, String originalWindow) {
//        try{
//            ElemSteps.myWait(1000);
//            ElemSteps.xpElement(jmbProps,"paypal.cookie.btn.xpath");
//        }
//        catch(Throwable ex){
//            System.out.println("Cookie consent not displayed");
//        }

        formInputId("chk.paypal.checkout.ppEmail.id", emailValue);
        formId("chk.paypal.checkout.ppNext.id");
        Q_JMB_Controls.scrolDownPixel(400);
        Q_JMB_WebElm.myWait(1000);
        formInputId("chk.paypal.checkout.ppPass.id", password);
        formId("chk.paypal.checkout.ppLogin.id");
        Q_JMB_WebElm.myWait(5000);
        Q_JMB_Controls.scrolDownPixel(400);
        Q_JMB_WebElm.idExecutor(jmbProps, "chk.paypal.checkout.ppContinue.id");
        Q_JMB_WebElm.myWait(5000);
        driver.switchTo().window(originalWindow);
        Q_JMB_WebElm.myWait(5000);
		try {
			Q_JMB_WebElm.myWait(1000);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			//exception handling
			System.out.println("Recovering from exception when handling switching from frame due to detached frame.");
		}
        return this;
    }
    public Q_JMB_CheckoutObjects pplogout(){
        driver.navigate().to("https://www.sandbox.paypal.com/myaccount/home");
        formId("chk.paypal.checkout.pplogout.id");
        return this;
    }
    public Q_JMB_CheckoutObjects shippingOptionValue(){
        Q_JMB_WebElm.xpExecutor(jmbProps,"chk.paypal.shippingOption2.xp");
        Q_JMB_WebElm.myWait(1000);
        String xp = strXpText("chk.paypal.shippingOption2Charge.xp");
        System.out.println(xp);
        Assert.assertTrue(Q_JMB_WebElm.xpSelected(jmbProps,"chk.paypal.shippingOption2.xp"));
        return this;
    }
    public Q_JMB_CheckoutObjects paypalCheckoutWithCoupon(String paymentType, String coupon, String chkOutBtn, String originalWindow) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
        Q_JMB_WebElm.idExecutor(jmbProps, paymentType);
        Q_JMB_WebElm.myWait(2000);
        cart.giftCertificateInput(coupon);
        cart.giftCertificateApply();
        Q_JMB_WebElm.myWait(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='paybraintree_paypal']//div[@class='paypal-button']")));
        Q_JMB_WebElm.xp(jmbProps, chkOutBtn);
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertTrue(isIdDisplayed("chk.paypal.checkout.ppEmail.id"));
        Q_JMB_WebElm.myWait(2000);
        return this;
    }

    //JMB-6420 Start
    //*******************************************************************
    // * Description: Verifies credit card number error message displays
    // * Param: NA
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    //*******************************************************************
// * Description: Verifies credit card number error message displays
// * Param: NA
// * Returns: NA
// * Status: Complete
//*******************************************************************/
    public Q_JMB_CheckoutObjects CCVError() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Q_JMB_WebElm.myWait(2000);
        try {
            String value;
            value = Q_JMB_WebElm.idRetText(jmbProps, "chk.cc.ccerror.id");
            System.out.println("Msg value" + value);
            String exp= "Please verify the Credit Card Number, Expiration Date, Security Code, and Billing Address is correct. Please review any highlighted fields, enter the correct information, and try again. If you keep receiving this error, please contact your card provider.";
            Assert.assertEquals(value, exp,"CVV Error message is incorrect");


        } catch (Exception e) {
            Assert.assertTrue(Q_JMB_WebElm.cnDisplayed(jmbProps, "chk.guest.woocommerce.error.className"));
        }
        return this;
    }

    public Q_JMB_CheckoutObjects CCVError(String locator, String errorMsg) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Q_JMB_WebElm.myWait(2000);
        String value = Q_JMB_WebElm.xpRetText(jmbProps, locator);
        System.out.println("Msg value" + value);
        Assert.assertEquals(value, errorMsg);

        return this;
    }
    //JMB-6413 Start
    //*******************************************************************
    // * Description: Selects the first instance specific shipping address by zip code text
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public static void selectShippingAddressByZipCode(Properties proper, String catQtyBeg, String zip, String catQtyEnd) {
        driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + zip + proper.getProperty(catQtyEnd))).click();
    }
    public static void selectShippingAddressByZipCode(String zip) {
        int countShippingAdd = Q_JMB_WebElm.xpCountTableRows(jmbProps, "chk.shippingAddCount.xp");
        System.out.println("No of addresses " + countShippingAdd);
        for(int i=1; i<countShippingAdd; i++){
            String addressDetails = strXpText("chk.shippingAdd.beg.xp",i, "chk.shippingAddDetails.end.xp");
            System.out.println("Address Details " + addressDetails);
            if(addressDetails.contains(zip)){
                System.out.println("Bingo");
                Q_JMB_WebElm.xp(jmbProps, "chk.shippingAdd.beg.xp",i, "chk.shippingAddRadioBtnInput.end.xp");
                break;
            }
        }
    }
//JMB-6413 End
//JMB-6527 Start
//*******************************************************************
// * Description: Validate that Shipping methods & costs match expected
// * Param: String
// * Returns: NA
// * Status: Complete
//*******************************************************************/
public static void verifyAvailableShippingMethodsAndCosts(String availableShippingCosts) {
    List<WebElement> shippingMethods = driver.findElements(By.xpath(jmbProps.getProperty("chk.shipping.shippingMethods.xp")));
    List<WebElement> shippingCosts = driver.findElements(By.xpath(jmbProps.getProperty("chk.shipping.shippingCosts.xp")));
    ArrayList<String> actualShippingCosts = new ArrayList<String>();
    ArrayList<String> expectedShippingCosts = new ArrayList<String>(Arrays.asList(availableShippingCosts.split(";")));
    String currentMethod, currentCosts;
    System.out.println("Actual cost" + actualShippingCosts);
    System.out.println("Expected cost " + expectedShippingCosts);
    System.out.println(shippingMethods.size());
    if (shippingMethods.size() == 0) {
        Assert.fail("[Fail] Unable to find avaiable shipping methods to verify on application.");
    }
    if (shippingCosts.size() == 0) {
        Assert.fail("[Fail] Unable to find avaiable shipping costs to verify on application.");
    }
    for (int counter = 0; counter < shippingCosts.size(); counter++)
    {
        currentMethod = shippingMethods.get(counter).getText().replaceAll("\n"," ");
        currentCosts = shippingCosts.get(counter).getText();
        actualShippingCosts.add(currentMethod + ":" + currentCosts);
    }

    if (!(actualShippingCosts.equals(expectedShippingCosts)))
    {
        Assert.fail("[Fail] Invalid shipping methods found. Expected values " + expectedShippingCosts + " did not match actual values" + actualShippingCosts + ".");
    }
    else
    {
        System.out.println("[Pass] Validation that shipping options " + expectedShippingCosts +" are the only options that appears.");
    }
}
    //JMB-6527 End
    //JMB-6650 Start
    //*******************************************************************
    // * Description: Edits an existing Shipping Address with non Smarty Address,
    // * saves and confirms that Continue with this Address button appears
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public static void editShippingAndVerifyCwtAButtonAppears(String editShippingAdd) {
        Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
        chk.formXp("chk.reg.shaddress2EditBtn.xp");
        System.out.println("Shipping Address is " + chk.attReturn("chk.reg.shaddress2.xp", "value"));
        chk.formInputXp("chk.reg.shaddress2.xp", editShippingAdd);
        Q_JMB_WebElm.myWait(1000);
        chk.formId("chk.shipping.validate.id");
        Q_JMB_WebElm.myWait(2000);
        // Had to use style attribute to see if Continue with this Address button appears
        // as Displayed is always returning true
        boolean verifyCondition = verifyAttrDoesNotContainsValueWithinTimeout(jmbProps, "chk.shipping.ContinueWithAdd.id", "style", "display: none", 5);
        Assert.assertTrue(verifyCondition, "Continue with this Address is not visible when it should be.");
    }
    //*******************************************************************
    // * Description: Clicks on Add New Shipping Address and confirms that
    // * Continue with this Address button does not appear
    // * Param: None
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public static void clickOnNewAddrAndVerifyCwtAButtonDoesNotAppear() {
        Q_JMB_WebElm.xpExecutor(jmbProps, "chk.shipping.addShippingAddress.xp");
        Q_JMB_WebElm.myWait(1000);
        // Had to use style attribute to see if Continue with this Address button appears
        // as Displayed is always returning true
        boolean verifyCondition = idVerifyAttrContainsValueWithinTimeout(jmbProps, "chk.shipping.ContinueWithAdd.id", "style", "display: none", 5);
        Assert.assertTrue(verifyCondition, "Continue with this Address button after clicking on New Shipping Address when it should not be visible.");
    }
    //*******************************************************************
    // * Description: Verifies element attribute contains a certain value within a timeout
    // * Param: Properties property, String location, String attribute, String value, Integer timeout
    // * Returns: Boolean; true if condition matches expected with timeout, otherwise false
    // * Status: Complete
    //*******************************************************************/
    public static boolean idVerifyAttrContainsValueWithinTimeout(Properties property, String location, String attribute, String value, Integer timeout) {
        boolean verifyCondition = false;
        int counter = 1;
        do {
            Q_JMB_WebElm.myWait(1000);
            if (Q_JMB_WebElm.idAttrRet(property, location, attribute).contains(value)) {
                verifyCondition = true;
                break;
            }
            counter++;
        } while (counter < timeout);
        return verifyCondition;
    }
    //*******************************************************************
    // * Description: Verifies element attribute does not contains a certain value within a timeout
    // * Param: Properties property, String location, String attribute, String value, Integer timeout
    // * Returns: Boolean; true if condition matches expected with timeout, otherwise false
    // * Status: Complete
    //*******************************************************************/
    public static boolean verifyAttrDoesNotContainsValueWithinTimeout(Properties property, String location, String attribute, String value, Integer timeout) {
        boolean verifyCondition = false;
        int counter = 1;
        do {
            Q_JMB_WebElm.myWait(1000);
            if (!Q_JMB_WebElm.idAttrRet(property, location, attribute).contains(value)) {
                verifyCondition = true;
                break;
            }
            counter++;
        } while (counter < timeout);
        return verifyCondition;
    }
    //JMB-6650 End
    //JMB-6752 Start
    //*******************************************************************
    // * Description: Verifies Local Drop Displayed property based on parameter passed
    // * Param: Boolean shouldDisplay
    // * Returns: None
    // * Status: Complete
    //*******************************************************************/
    public static void verifyLocalDropOffOptionDisplay (Boolean shouldDisplay) {
        if (shouldDisplay) {
            Assert.assertTrue(Q_JMB_WebElm.idDisplayed(jmbProps, "chk.reg.shippingOptionLocalPickupLI.id"), "Local Dropoff option is not displayed.");
            System.out.println("Local Dropoff option is displayed.");
        } else {
            Assert.assertFalse(Q_JMB_WebElm.idDisplayed(jmbProps, "chk.reg.shippingOptionLocalPickupLI.id"), "Local Dropoff option is displayed.");
            System.out.println("Local Dropoff option is not displayed.");
        }
    }
    //*******************************************************************
    // * Description: Creates a New Address with Non Participating Pickup/Drop Off
    // * zipcode with non Smarty Address and clicks on save button.
    // * Param: Boolean shouldDisplay
    // * Returns: None
    // * Status: Complete
    //*******************************************************************/
    public static void createNewAddressWithNonPartZipAndSave() throws FileNotFoundException {
        Q_JMB_CheckoutObjects chk= new Q_JMB_CheckoutObjects();
        Q_JMB_WebElm.xpExecutor(jmbProps, "chk.shipping.addShippingAddress.xp");
        Q_JMB_WebElm.myWait(1000);
        chk.shippingAddressForm(4);
        try {
            Q_JMB_WebElm.idExecutor(jmbProps, "chk.shipping.validate.id");
        } catch (Exception e) {
            System.out.println("Save Address did not appear due to Smarty.");
        }
        Q_JMB_WebElm.myWait(1000);
    }
    //JMB-6752 End
    
    //JMB-3594 Start
  	/******************************************************************
       * Description: Verify the correct PDP is launched when product 
       * description is clicked on Thank You page
       * Parameters: None
       * Returns: None
       * Status: Complete
       *******************************************************************/
  	public void verifyProductDescOnThankYouPage()	{
  		String productDesc =  Q_JMB_WebElm.xpRetText(jmbProps, "chk.productDesc.thankYouPage.xp");
  		Q_JMB_WebElm.xp(jmbProps, "chk.productDesc.thankYouPage.xp");
  		Q_JMB_Controls.switchWin();
  		Assert.assertEquals(productDesc, Q_JMB_WebElm.xpRetText(jmbProps, "cart.productPage.productDesc.xp"), 
  				"Incorrect Product Window launched");
  		System.out.println("Correct PDP launched when product description is clicked on Thank You page.");
  	}
  	
  	/******************************************************************
       * Description: Verify the correct PDP is launched when product 
       * image is clicked on Thank You page
       * Parameters: None
       * Returns: None
       * Status: Complete
       *******************************************************************/
  	public void verifyProductImageOnThankYouPage()	{
  		String productDesc =  Q_JMB_WebElm.xpRetText(jmbProps, "chk.productDesc.thankYouPage.xp");
  		Q_JMB_WebElm.xp(jmbProps, "chk.productImage.thankYouPage.xp");
  		Q_JMB_Controls.switchWin();
  		Assert.assertEquals(productDesc, Q_JMB_WebElm.xpRetText(jmbProps, "cart.productPage.productDesc.xp"), 
  				"Incorrect Product Window launched");
  		System.out.println("Correct PDP launched when product image is clicked on Thank You page.");
  	}
  	//JMB-3594 End
  	//Start JMB-4230
  	/********************************************************************
  	* Description: Add required details in Billing address form
  	* Author: Tamilselvan
  	* Param: Integer
  	* Returns: NA
  	* Status: Complete 
  	*******************************************************************/
     public void billingAddressForm(Integer addIndex) throws FileNotFoundException {
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS.SECONDS);
          AddressContainer ship = new AddressContainer(addIndex);
          formInputId("chk.billingFirstName.id", ship.firstName);
          formInputId("chk.billingLastName.id", ship.lastName);
          formInputId("chk.billingAddress.id", ship.street);
          Q_JMB_WebElm.myWait(1000);
          formInputId("chk.billingCity.id", ship.city);
          Q_JMB_WebElm.idSelectValue(jmbProps, "chk.billingState.id", ship.state);
          Q_JMB_WebElm.myWait(3000);
          formInputId("chk.billingZip.id", ship.zipcode);
          formInputId("chk.billingPhone.id", ship.phoneNumber);
          Q_JMB_WebElm.myWait(2000);
      }
  	/********************************************************************
  	* Description: Click save billing address after enter the required details 
  	* Author: Tamilselvan
  	* Param: NA
  	* Returns: NA
  	* Status: Complete 
  	*******************************************************************/
      public void saveBillingAddress() {
      	Q_JMB_WebElm.id(jmbProps,"chk.saveBillingAddress.id");
          Q_JMB_WebElm.myWait(1000);
      }
  	/********************************************************************
  	* Description: Click change billing address button 
  	* Author: Tamilselvan
  	* Param: NA
  	* Returns: NA
  	* Status: Complete 
  	*******************************************************************/
      public void changeBillingAddressButton() {
  		Q_JMB_WebElm.xp(jmbProps, "chk.changeBillingAddress.xp");
          Q_JMB_WebElm.myWait(3000);
      }
  	/********************************************************************
  	* Description: Click add new billing address 
  	* Author: Tamilselvan
  	* Param: NA
  	* Returns: NA
  	* Status: Complete 
  	*******************************************************************/
      public void clickAddNewBillAddress() {
      	Q_JMB_WebElm.xp(jmbProps,"chk.addNewBill.xp");
          Q_JMB_WebElm.myWait(2000);
      }
  	/********************************************************************
  	* Description: Click remove existing billing address 
  	* Author: Tamilselvan
  	* Param: NA
  	* Returns: NA
  	* Status: Complete 
  	*******************************************************************/
   public void removeBillAddress(){    	
      	try {
      		Q_JMB_WebElm.xpDisplayed(jmbProps, "chk.removeOldBill.xp");
      		Q_JMB_WebElm.xpExecutor(jmbProps, "chk.removeOldBill.xp");
      		Q_JMB_Controls.checkAndGetAlertText();
              Q_JMB_WebElm.myWait(2000);
  		} catch (NoSuchElementException e) {
  			Assert.assertTrue(true);
  			System.out.println("No existing billing address");
  		}
    }
  	/********************************************************************
  	* Description: Delete all existing cards in my account 
  	* Author: Tamilselvan
  	* Param: NA
  	* Returns: NA
  	* Status: Complete 
  	*******************************************************************/
      public void deleteAllExistingCard() {
      	driver.navigate().to(baseUrl+"/cybersource-reset.php");
      	Q_JMB_WebElm.xp(jmbProps, "jm.deleteExistingCard.xp");
      }
  	
  	/********************************************************************
  	* Description: Verify Billing Address Field  
  	* Author: Tamilselvan
  	* Param: NA
  	* Returns: NA
  	* Status: Complete 
  	*******************************************************************/
  	public void verifyBillingAddressField() {
      	Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "chk.billingAddress.xp"));
      	System.out.println("Billing Address field displayed successfully");
  	}
  	//End JMB-4230
  	
  	//JMB-7670 Start
  	/**********************************************************************
     * Description:     Verifies the proper items for revenue is displayed on checkout page
     * Author:          Paul Patterson
     * Param:      		boolean hasSalesTax, boolean hasStateFee, boolean hasShippingTax, boolean hasGiftCert
     * Returns:         List<String>
     **********************************************************************/
	public List<String> verifyAndReturnCheckoutPriceList(boolean hasSalesTax, boolean hasStateFee, 
			boolean hasShippingTax, boolean hasGiftCert) 
	{
        Q_JMB_WebElm.myWait(2000);
        driver.manage().timeouts().implicitlyWait(1, SECONDS);
        System.out.println("[Info] Start verification of checkout price list.");
        List<String> priceList = new ArrayList<String>();
        try {
        	Q_JMB_WebElm.idDisplayed(jmbProps, "chk.revSubtotal.id");
        	System.out.println("[Pass] Subtotal successfully found.");
        	priceList.add("Subtotal: ");
        } catch (Throwable ex) {
        	Assert.fail("[Fail] Subtotal was not found.");
        }

        if (hasSalesTax)
        {
        	try {
            	Q_JMB_WebElm.idDisplayed(jmbProps,"chk.revTax.id");
            	System.out.println("[Pass] Sales Tax successfully found.");
            	priceList.add("Sales Tax: ");
            } catch (Throwable ex) {
            	Assert.fail("[Fail] Sales Tax was not found.");
            }
        } else {
        	try {
            	Q_JMB_WebElm.idDisplayed(jmbProps,"chk.revTax.id");
            	Assert.fail("[Fail] Sales Tax was found but no expected.");
            } catch (Throwable ex) {
            	System.out.println("[Pass] Sales Tax was not found.");
            }
        }
        
        if (hasStateFee)
        {
        	try {
            	Q_JMB_WebElm.idDisplayed(jmbProps,"chk.revStateFee.xp");
            	System.out.println("[Pass] State Fee successfully found.");
            	priceList.add("State Fee: ");
            } catch (Throwable ex) {
            	Assert.fail("[Fail] State Fee was not found.");
            }
        } else {
        	try {
            	Q_JMB_WebElm.idDisplayed(jmbProps,"chk.revStateFee.xp");
            	Assert.fail("[Fail] State Fee was found but no expected.");
            } catch (Throwable ex) {
            	System.out.println("[Pass] State Fee was not found.");
            }
        }

        try {
        	Q_JMB_WebElm.idDisplayed(jmbProps, "chk.revShipping.id");
        	System.out.println("[Pass] Shipping successfully found.");
        	priceList.add("Shipping: ");
        } catch (Throwable ex) {
        	Assert.fail("[Fail] Shipping was not found.");
        }
        
        if (hasShippingTax)
        {
        	try {
            	Q_JMB_WebElm.idDisplayed(jmbProps,"chk.revShiptax.id");
            	System.out.println("[Pass] Shipping Tax successfully found.");
            	priceList.add("Shipping Tax: ");
            } catch (Throwable ex) {
            	Assert.fail("[Fail] Shipping Tax was not found.");
            }
        } else {
        	try {
            	Q_JMB_WebElm.idDisplayed(jmbProps,"chk.revShiptax.id");
            	Assert.fail("[Fail] Shipping Tax was found but no expected.");
            } catch (Throwable ex) {
            	System.out.println("[Pass] Shipping Tax was not found.");
            }
        }
        
        if (hasGiftCert)
        {
        	try {
            	Q_JMB_WebElm.idDisplayed(jmbProps,"chk.revDiscount.id");
            	System.out.println("[Pass] Discount successfully found.");
            	priceList.add("Discount: ");
            } catch (Throwable ex) {
            	Assert.fail("[Fail] Discount was not found.");
            }
        } else {
        	try {
            	Q_JMB_WebElm.idDisplayed(jmbProps,"chk.revDiscount.id");
            	Assert.fail("[Fail] Discount was found but no expected.");
            } catch (Throwable ex) {
            	System.out.println("[Pass] Discount was not found.");
            }
        }

        try {
        	Q_JMB_WebElm.idDisplayed(jmbProps, "chk.revTotal.id");
        	System.out.println("[Pass] Total successfully found.");
        	priceList.add("Total: ");
        } catch (Throwable ex) {
        	Assert.fail("[Fail] Total was not found.");
        }
        
        System.out.println("[Info] End verification of checkout price list.");
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        return priceList;
    }
	
	/**********************************************************************
     * Description:     Captures revenue items from the Checkout Page
     * Author:          Paul Patterson
     * Param:      		boolean hasSalesTax, boolean hasStateFee, boolean hasShippingTax, boolean hasGiftCert
     * Returns:         List<Float>
     **********************************************************************/
	public List<Float> checkoutPriceList(boolean hasSalesTax, boolean hasStateFee, 
			boolean hasShippingTax, boolean hasGiftCert) 
	{
        Q_JMB_WebElm.myWait(2000);
        List<Float> priceList = new ArrayList<Float>();
        Float calcTotal = Float.valueOf(0);
        Float subtotal = Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps,"chk.revSubtotal.id"));
        calcTotal = calcTotal + subtotal;
        priceList.add(subtotal);

        if (hasSalesTax)
        {
        	Float tax = Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps,"chk.revTax.id"));
        	calcTotal = calcTotal + tax;
        	if (hasShippingTax)
            {
            	Float shippingTax = Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps,"chk.revShiptax.id"));
            	calcTotal = calcTotal + shippingTax;
            	tax = tax + shippingTax;
            	tax = Float.valueOf(String.format("%.02f", tax));
            }
        	priceList.add(tax);
        }
        
        if (hasStateFee)
        {
        	Float stateFee = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"chk.revStateFee.xp"));
        	calcTotal = calcTotal + stateFee;
        	priceList.add(stateFee);
        }

        Float shipping = Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps,"chk.revShipping.id"));
        calcTotal = calcTotal + shipping;
        priceList.add(shipping);
        
        
        
        if (hasGiftCert)
        {
        	Float discount = Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps,"chk.revDiscount.id"));
        	calcTotal = calcTotal - discount;
        	priceList.add(discount);
        }

        calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
        Float total = Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps,"chk.revTotal.id"));
        priceList.add(total);
        Assert.assertEquals(total, calcTotal, "Checkout Page total does not match calculated revenue items.");
        System.out.println("[Pass] Checkout Page total matches calculated revenue items.");
        return priceList;
    }
	
	/**********************************************************************
     * Description:     Captures revenue items from the Thank You Page
     * Author:          Paul Patterson
     * Param:      		boolean hasSalesTax, boolean hasStateFee, boolean hasShippingTax, boolean hasGiftCert
     * Returns:         List<Float>
     **********************************************************************/
	public List<Float> thankYouPriceList(boolean hasSalesTax, boolean hasStateFee, 
			boolean hasShippingTax, boolean hasGiftCert) 
	{
        Q_JMB_WebElm.myWait(2000);
        List<Float> priceList = new ArrayList<Float>();
        Float calcTotal = Float.valueOf(0);
        Float subtotal = Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps,"chk.orderSubtotal.id"));
        calcTotal = calcTotal + subtotal;
        priceList.add(subtotal);

        if (hasSalesTax)
        {
        	Float tax = Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps,"chk.orderSalesTax.id"));
        	calcTotal = calcTotal + tax;
        	priceList.add(tax);
        }
        
        if (hasStateFee)
        {
        	Float stateFee = Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps,"chk.orderStateFee.id"));
        	calcTotal = calcTotal + stateFee;
        	priceList.add(stateFee);
        }

        Float shipping = Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps,"chk.orderShipping.id"));
        calcTotal = calcTotal + shipping;
        priceList.add(shipping);
        
        // Locators will need to be updated for this to work
        //if (hasShippingTax)
        //{
        	//Float shippingTax = Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps,"chk.orderShipTax.id"));
        	//calcTotal = calcTotal + shippingTax;
        	//priceList.add(shippingTax);
        //}
        
        if (hasGiftCert)
        {
        	Float discount = Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps,"chk.orderDiscount.id"));
        	calcTotal = calcTotal - discount;
        	priceList.add(discount);
        }

        calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
        Float total = Float.valueOf(Q_JMB_WebElm.idRetTextRep(jmbProps,"chk.orderTotal.id"));
        priceList.add(total);
        Assert.assertEquals(total, calcTotal, "Thank You Page total does not match calculated revenue items.");
        System.out.println("[Pass] Thank You Page total matches calculated revenue items.");
        return priceList;
    }
  	/**********************************************************************
     * Description:     Compares pricing on Checkout Page with Another Page
     * Author:          Paul Patterson
     * Param:      		compareCheckoutToOtherPageRev(String compareToPage, List priceList, List revCharges, List orderCharges
     * Returns:         None
     **********************************************************************/
	public void compareCheckoutToOtherPageRev(String compareToPage, List priceList, List revCharges, List orderCharges) {
		System.out.println("[Info] Start verification of Checkout Page price list to " + compareToPage + " Page price list.");
        System.out.println("Checkout Page " + revCharges);
        System.out.println(compareToPage + " Page " + orderCharges);
        
        for (int i = 0; i < orderCharges.size(); i++) {
            System.out.println("Checkout Page " + priceList.get(i) + " " + revCharges.get(i));
            System.out.println(compareToPage + " Page " + priceList.get(i) + " " + orderCharges.get(i));
            Assert.assertEquals(revCharges.get(i), orderCharges.get(i));
        }
        System.out.println("[Info] End verification of Checkout Page price list to " + compareToPage + " Page price list.");
    }
	
    /**********************************************************************
     * Description:     Verifys the Value of State Fee on Checkout Page
     * Author:          Paul Patterson
     * Param:      		String expectedStateFee
     * Returns:         None
     **********************************************************************/
	public void verifyStateFeeValue(String expectedStateFee) {
		Float actualStateFee = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"chk.revStateFee.xp"));
		Assert.assertEquals(Float.valueOf(expectedStateFee), actualStateFee, "[Fail] Expected state fee " + expectedStateFee + " did not match actual " + actualStateFee);
	}
	
	
	/********************************************************************
	* Description: Click to select first billing address to use on order
	* Author: Paul Patterson
	* Param: NA
	* Returns: NA
	* Status: Complete 
	*******************************************************************/
    public void clickSelectFirstBillingAddress() {
    	Q_JMB_WebElm.myWait(2000);
        driver.manage().timeouts().implicitlyWait(1, SECONDS);
    	try {
    		Q_JMB_WebElm.xp(jmbProps,"chk.billingBillToAddress1.xp");
    	} catch (Throwable ex) {
    		Q_JMB_WebElm.xp(jmbProps,"chk.billingUseCurrentAdddress1.xp");
    	}
    	driver.manage().timeouts().implicitlyWait(10, SECONDS);
        Q_JMB_WebElm.myWait(2000);
    }
    
    /********************************************************************
	* Description: Click to select shipping address as billing address to use on order
	* Author: Paul Patterson
	* Param: NA
	* Returns: NA
	* Status: Complete 
	*******************************************************************/
    public void clickSelectShippingAddressAsBillingAddress() {
    	try {
    		Q_JMB_WebElm.xp(jmbProps,"chk.billingBUseShipAddillToAddress.xp");
    	} catch (Throwable ex) {
    		Q_JMB_WebElm.xp(jmbProps,"chk.billingUseShipAddCurrentAdddress.xp");
    	}
        Q_JMB_WebElm.myWait(2000);
    }
	//JMB-7670 End
    
    //JMB-7655 Start
    /*****************************************************
    // * Description: To get the OrderId for an Order
    // * Param      : NA
    // * Jira Ticket: JMB 7655
    // * Status     : Completed
    //****************************************************/  
	public String getOrderId() {
		String orderId=Q_JMB_WebElm.xpRetText(jmbProps,"thankyou.getOrderId.xp").replaceAll("Order Number: ORD-", "").trim();
		System.out.println(orderId);
		return orderId;
	}
	//JMB-7655 End
	
	//JMB-7855 Start
	/*****************************************************
	// * Description : To get the Order Total for an Order
	// * Param       : NA
	// * Jira Ticket : 7855
	// * Status      : Completed
	//****************************************************/  
	public String getOrderTotal() {
		String orderTotal = Q_JMB_WebElm.xpRetText(jmbProps, "chk.thankYou.getOrderTotal.xp").replaceAll("Order Total:", "").trim();
		System.out.println(orderTotal);
		return orderTotal;
	}
	//JMB-7855 End
}
