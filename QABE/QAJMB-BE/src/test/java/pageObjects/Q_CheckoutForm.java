package pageObjects;


import jsonWrappers.CreditContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Controls;
import utils.Init;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Properties;

public class Q_CheckoutForm extends Init {
    static Q_CheckoutForm chk = new Q_CheckoutForm();

    public Q_CheckoutForm formXp(String locator) {
        Q_WebElm.xp(adminProps, locator);
        return this;
    }
    public Q_CheckoutForm formXp(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xp(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public Q_CheckoutForm formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_WebElm.xp(adminProps, begXp, row, midXp, column, endXp);
        return this;
    }
    public Q_CheckoutForm formInputXp(String locator, String inputValue) {
        Q_WebElm.xpClear(adminProps, locator);
        Q_WebElm.xpSend(adminProps, locator, inputValue);
        return this;
    }
    public Q_CheckoutForm formInputXp(String begXp, Integer lineItem, String endXP, String inputValue) {
        Q_WebElm.xpClear(adminProps, begXp, lineItem, endXP);
        Q_WebElm.xpSend(adminProps, begXp, lineItem, endXP, inputValue);
        return this;
    }
    public Q_CheckoutForm formIntegerInputXp(String locator, Integer inputValue) {
        Q_WebElm.xpClear(adminProps, locator);
        Q_WebElm.xpSend(adminProps, locator, String.valueOf(inputValue));
        return this;
    }
    public static String strXpText(String locator) {
        return Q_WebElm.xpRetText(adminProps, locator);
    }
    public static String strXpText(String begXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, lineItem, endXp);
    }
    public static String strXpText(String begXp, Integer row, String midXp, Integer cell, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, row, midXp, cell,  endXp);
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
    public Q_CheckoutForm formReturnText(String locator) {
        Q_WebElm.xpRetText(adminProps, locator);
        return this;
    }
    public Q_CheckoutForm formReturnText(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpRetText(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, recordNumber, midXp, lineItem, endXp);
    }
    public static String formReturnTextReplace(String locator) {
        return Q_WebElm.xpRetNumber(adminProps, locator);
    }

    public Q_CheckoutForm formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpRetNumber(adminProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_CheckoutForm formReturnAttribute(String locator, String attr) {
        Q_WebElm.xpRetAttr(adminProps, locator,attr);
        return this;
    }
    public static String attReturn(String locator, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, locator,attr);

    }
    public static String attReturn(String begXp, Integer lineItem, String endXp, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp, attr);
    }
    public Q_CheckoutForm formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp,attr);
        return this;
    }

    public Q_CheckoutForm formReturnAttributeReplace(String locator) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, locator);
        return this;
    }

    public Q_CheckoutForm formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_CheckoutForm formXpTab(String locator) {
        Q_WebElm.xpSendTab(adminProps, locator);
        return this;
    }

    public Q_CheckoutForm formXpTab(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendTab(adminProps, begXp, lineItem, endXP);
        return this;
    }

    public Q_CheckoutForm formXpEnter(String locator) {
        Q_WebElm.xpSendEnter(adminProps, locator);
        return this;
    }

    public Q_CheckoutForm formXpEnter(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendEnter(adminProps, begXp, lineItem, endXP);
        return this;
    }

    public static boolean isXpDisplayed(String locator) {
        return  Q_WebElm.idDisplayed(adminProps, locator).equals(true);
    }
    public static boolean isIdDisplayed(String locator) {
        return  Q_WebElm.xpEnabled(adminProps, locator).equals(true);
    }
    public static boolean isXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_WebElm.xpDisplayed(adminProps, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            System.out.println(ex);
            return false;
        }
    }
    public static boolean isXpCheckSelected(String locator) {
        return Q_WebElm.xpSelected(adminProps, locator).equals(true);
    }
    public static boolean isXpCheckSelected(String begXp, Integer lineItem, String endXP) {
        return Q_WebElm.xpSelected(adminProps, begXp, lineItem, endXP).equals(true);
    }
    public static boolean isXpCheckEnabled(String locator) {
        return Q_WebElm.xpEnabled(adminProps, locator).equals(true);
    }

    public static boolean isXpCheckEnabled(String begXp, Integer lineItem, String endXP) {
        try {
            Q_WebElm.xpEnabled(adminProps, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            return false;
        }
    }
    public Q_CheckoutForm formSelectIndex(String locator, Integer index) {
        Q_WebElm.xpSelectIndex(adminProps, locator, index);
        return this;
    }

    public Q_CheckoutForm formSelectValue(String locator, String value) {
        Q_WebElm.xpSelectValue(adminProps, locator, value);
        return this;
    }
    public Q_CheckoutForm formSelectText(String locator, String text) {
        Q_WebElm.xpSelectText(adminProps, locator, text);
        return this;
    }
    public Q_CheckoutForm formId(String locator) {
        Q_WebElm.id(adminProps, locator);
        return this;
    }
    public Q_CheckoutForm formInputId(String locator, String inputValue) {
        Q_WebElm.idClear(adminProps, locator);
        Q_WebElm.idSend(adminProps, locator, inputValue);
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
    public Q_CheckoutForm addItem(String pdpLink, Integer quan){
        driver.navigate().to(baseUrl + pdpLink);
        chk.addItemToCart(quan);
        return this;
    }

    public Q_CheckoutForm selectItem(String item, Integer quan) throws FileNotFoundException {
        Q_CheckoutForm chk = new Q_CheckoutForm();
        switch ( item ){
            case("perth10g"):
                driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar/");
                Q_WebElm.myWait(1000);
                chk.addItemToCart(quan);
                chk.selectPaymentType("cheque");
                chk.selectcheckoutBtn("top");
                chk.completeOrder();
                driver.navigate().to(adminUrl);
                break;
            case("preSale"):
                driver.navigate().to(baseUrl + "/2-5-gram-valcambi-gold-bar/");
                Q_WebElm.myWait(1000);
                chk.addItemToCart(quan);
                chk.selectPaymentType("cheque");
                formId("fe.preSaleMsgCheckbox.id");
                chk.selectcheckoutBtn("top");
                chk.completeOrder();
                driver.navigate().to(adminUrl);
                break;
            case("auto limit"):
                driver.navigate().to(baseUrl + "/1-oz-silver-bar/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("cheque");
                chk.selectcheckoutBtn("top");
//                CheckoutSteps.cardType(3, "selectedCard.xp", "cvv.id");
                chk.completeOrder();
                driver.navigate().to(adminUrl);
                break;
            case("silverEagle1994"):
                driver.navigate().to(baseUrl + "/1994-american-silver-eagle/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("credit card");
                chk.selectcheckoutBtn("top");
                chk.cardType(3, "fe.selectedCard.xp", "fe.cvv.id");

                chk.completeOrder();
                String orderNo = strXpText("fe.jm.thankyouOrderNumber.xp").replaceAll("[^0-9?!\\.]","");
                System.out.println("Order Number " + orderNo);
                driver.navigate().to(adminUrl);
                break;
            case("platinumEagle1oz"):
                System.out.println("Verified user is on the customer page pages");
                driver.navigate().to(baseUrl + "/1-oz-american-platinum-eagle-varied/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("wire");
                chk.selectcheckoutBtn("top");
                chk.completeOrder();
                break;
            case("copperUSQuarter"):
                driver.navigate().to(baseUrl + "/1-oz-quarter-copper-round/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("credit card");
                chk.selectcheckoutBtn("top");
                chk.cardType(3, "fe.selectedCard.xp", "fe.cvv.id");
                chk.completeOrder();
                break;
            case("2015silverTube"):
                driver.navigate().to(baseUrl + "/2015-american-silver-eagle-tube-20-coins/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("credit card");
                chk.selectcheckoutBtn("top");
                chk.cardType(3, "fe.selectedCard.xp", "fe.cvv.id");
                chk.completeOrder();
            break;
            case("2019 1 oz Canadian Silver Maple Leaf Coin (BU)"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("credit card");
                chk.selectcheckoutBtn("top");
                chk.cardType(3, "fe.selectedCard.xp", "fe.cvv.id");
                chk.completeOrder();
                break;
            case("2019 Canadian Silver Maple Leaf Tube (25 Coins, BU)"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf-tube");
                chk.addItemToCart(quan);

                chk.selectPaymentType("credit card");
                chk.selectcheckoutBtn("top");
                chk.cardType(3, "fe.selectedCard.xp", "fe.cvv.id");
                chk.completeOrder();
                break;
            case("2019 Canadian Silver Maple Leaf Monster Box (500 Coins, BU)"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf-monster-box/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("cheque");
                chk.selectcheckoutBtn("top");
//                CheckoutSteps.cardType(3, "selectedCard.xp", "cvv.id");
                chk.completeOrder();
                break;
            case("2019 Canadian Silver Maple Leaf Combo1"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf/");
                chk.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf-tube");
                chk.addItemToCart(quan);
                chk.selectPaymentType("credit card");
                chk.selectcheckoutBtn("top");
                chk.cardType(3, "fe.selectedCard.xp", "fe.cvv.id");
                chk.completeOrder();
                break;
            case("2019 Canadian Silver Maple Leaf Combo2"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf/");
                chk.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf-tube");
                chk.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf-monster-box/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("cheque");
                chk.selectcheckoutBtn("top");
//                CheckoutSteps.cardType(3, "selectedCard.xp", "cvv.id");
                chk.completeOrder();
                break;
            case("multiple products"):
                driver.navigate().to(baseUrl + "/1-oz-quarter-copper-round/");
                chk.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/1-oz-american-platinum-eagle-varied/");
                chk.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar/");
                chk.addItemToCart(quan);
                Q_WebElm.myWait(1000);


                chk.selectPaymentType("cheque");
                chk.applyGiftCertificate();
                chk.selectcheckoutBtn("top");
                chk.selectshippingOption("option2");
//                CheckoutSteps.cardType(3, "selectedCard.xp", "cvv.id");
                chk.completeOrder();
                break;
            case("10 oz Credit Suisse Gold Bar"):
	            driver.navigate().to(baseUrl + "/10-oz-credit-suisse-gold-bar/");
	            chk.addItemToCart(quan);
	            chk.selectPaymentType("wire");
	            chk.selectcheckoutBtn("top");
	            chk.completeOrder();
	            break;
            default:
                System.out.println("Item not found");

                break;
        }
        return this;
    }
    public Q_CheckoutForm applyGiftCertificate(){
        DecimalFormat df = new DecimalFormat("#.00");
        formInputXp("fe.jm.cartCouponInput.xp", "AutomationTesting");
        Q_WebElm.myWait(1000);
        Q_WebElm.name(adminProps, "fe.jm.cartCouponApply.name");
        Q_WebElm.myWait(1000);
        float subtotal = Float.valueOf(numberReturn("fe.jm.cartSubtotalBottom.xp"));
        float adjustment = Float.valueOf(numberReturn("fe.jm.cartAdjustment.xp"));
        float total = Float.valueOf(numberReturn("fe.jm.cartTotal.xp"));
        System.out.println("Order subtotal:  " + subtotal +"\n"+"Coupon value:  " + adjustment +"\n"+ "Order Total:  "+ total);

        float calculatedTotal = subtotal - adjustment;
        try{
            org.junit.Assert.assertEquals(df.format(calculatedTotal), df.format(total));
            System.out.println("Calculated total : "+calculatedTotal+"\t Order total : "+ total);

        }
        catch(Throwable ex){
            System.out.println("Failed verification of order total and coupon not applied");
            org.junit.Assert.fail("Failed verification of order total and coupon not applied");
        }
        return this;
    }
    public Q_CheckoutForm selectPaymentType(String payWith){

        try{
            switch(payWith){
                case "credit card":
                    formId("fe.paymentType.CC.id");
                    break;
                case "paypal":
                    formId("fe.paymentType.PP.id");
                    break;
                case "echeck":
                    formId("fe.paymentType.EC.id");
                    break;
                case "cheque":
                    formId("fe.paymentType.PC.id");
                    break;
                case "wire":
                    formId("fe.paymentType.BW.id");
                    break;
                case "bitpay":
                    formId( "paymentType.BC.id");
                    break;
                default:
                    System.out.println("Invalid Payment type");
                    break;
            }
        }
        catch (Throwable ex){
            System.out.println("Failed to select payment");
        }
        return this;
    }
    public Q_CheckoutForm selectcheckoutBtn(String whichButton){
        switch (whichButton){
            case ("top"):
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("checkout"))));
                formXp("fe.cartTopcheckoutnow.xp");
                break;
            case ("bottom"):
                Q_WebElm.cn(adminProps, "fe.cart.botcheckoutnow.className");
                break;
            case ("paypal"):
                Q_WebElm.cn( adminProps, "fe.cart.paypal.className");
                break;
            default:
                System.out.println("Checkout Button none selected");
                break;
        }
        return this;
    }

    public Q_CheckoutForm cardType(Integer cvvIndex, String selectedCard, String cvvlocator) throws FileNotFoundException {
        //WebElm.myWait(5000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.no-morgin:nth-child(1) > div:nth-child(2) > p:nth-child(2)")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.no-morgin:nth-child(1) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)")));
        String cardTypeText = strXpText(selectedCard);
        System.out.println(cardTypeText);
        CreditContainer cvv = new CreditContainer(cvvIndex);
        if (cardTypeText.contains("American Express")) {
            formInputId(cvvlocator, cvv.code);
            //Log.info("\t Verified master card holder can complete order and checkout successfully");
            System.out.println(strXpText(selectedCard).substring(0, 32));
        }

        else if (cardTypeText.contains("MasterCard")){
            formInputId(cvvlocator, cvv.code);
            //Log.info("\t Verified master card holder can complete order and checkout successfully");
            System.out.println(strXpText(selectedCard).substring(0, 26));
        }

        else if (cardTypeText.contains("Visa")) {
            formInputId(cvvlocator, cvv.code);
            //Log.info("\t Verified master card holder can complete order and checkout successfully");
            System.out.println(strXpText(selectedCard).substring(0, 20));
        }

        else if (cardTypeText.contains("Discover")){
            formInputId(cvvlocator, cvv.code);
            //Log.info("\t Verified master card holder can complete order and checkout successfully");
            System.out.println(strXpText(selectedCard).substring(0, 24));
        }
        else{
            System.out.println("No credit card on file");
        }
        return this;
    }
    public Q_CheckoutForm selectshippingOption(String option){
        switch(option){
            case("default"):
                formXp("fe.shippingOption1.xp");
                Q_WebElm.myWait(2000);
                break;
            case("option2"):
                formXp("fe.shippingOption2.xp");
                Q_WebElm.myWait(2000);
                break;
            case("option3"):
                formXp("fe.shippingOption3.xp");
                Q_WebElm.myWait(2000);
                break;
            default:
                System.out.println("Invalid shipping option");
                break;
        }
        return this;
    }
    public Q_CheckoutForm completeOrder() {
        Controls.scrolDownPixel(300);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("submit"))));
        Controls.xpExecutorScrollElementToMiddle(adminProps.getProperty("fe.consent.xp"));
        formXp("fe.consent.xp");
        try {
            formId("fe.finishAndPlace.id");
        } catch (Exception e) {
            System.out.println(e);
        }
        Q_WebElm.myWait(4000);
        return this;
    }
    public Q_CheckoutForm completeOrder(String commit) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Controls.scrolDownPixel(500);
        Q_WebElm.myWait(1000);
        formXp("fe.consent.xp");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
            formId(commit);
            Q_WebElm.myWait(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sa_close")));
            formId("fe.saClose.id");
        } catch (Exception e) {
            System.out.println("Shopper Approved did not display");
        }
    return this;
    }
    //*******************************************************************
// * Description: Validate that Shipping Methods displayed on checkout matches expected
// * Param: String
// * Returns: NA
// * Status: Complete
//*******************************************************************/
    public static void verifyAvailableShippingMethods(String availableShippingMethods) {
        List<WebElement> shippingMethods = driver.findElements(By.xpath(".//ul[@class='method-details']/li/div/div/span"));
        String invalidMethods = null, currentMethod;
        if (shippingMethods.size() == 0) {
            Assert.fail("[Fail] Unable to find avaiable shipping methods to verify on application.");
        }
        for (int counter = 0; counter < shippingMethods.size(); counter++)
        {
            currentMethod = shippingMethods.get(counter).getText().replace("\n", " ");
            if (!availableShippingMethods.contains(currentMethod))
            {
                if (invalidMethods == null)
                {
                    invalidMethods = currentMethod;
                }
                else
                {
                    invalidMethods = invalidMethods + ";" + currentMethod;
                }
            }
        }

        if (!(invalidMethods == null))
        {
            Assert.fail("[Fail] Invalid shipping methods found. The following methods were found but not expected '" + invalidMethods + "'.");
        }
        else
        {
            System.out.println("[Pass] Validation that shipping options '" + availableShippingMethods +"' are the only options that appears.");
        }
    }
    public Q_CheckoutForm addItemToCart(Integer quan){
//        driver.navigate().to(base + productURL);
        formIntegerInputXp("fe.productPageQty.xp", quan);
        Q_WebElm.myWait(1000);
        formXp("fe.productpage.AddToCart.xp");
        formXp("fe.modalCheckoutNow.xp");
        return this;
    }
    public Q_CheckoutForm verifyQucickCart(){
        Actions moveTo = new Actions(driver);
        WebElement cart = driver.findElement(By.id("mycart"));
        moveTo.moveToElement(cart).moveToElement(cart).perform();

        System.out.println( "Items in Cart " + rowCount("fe.quickCartCount.xp"));
        for(int i = 1; i<= rowCount("fe.quickCartCount.xp"); i++){
            switch (i){
                case 1:
                    System.out.println("Product " + i + ": " + attReturn("fe.quckCartProdID.beg.xp", i, "fe.quckCartProdID.end.xp", "rel"));
                    System.out.println("Product " + i + ": " + strXpText("fe.quckCartProdID.beg.xp", i, "fe.quckCartDesc.end.xp")+ "\n");
                    Assert.assertEquals(attReturn("fe.quckCartProdID.beg.xp", i, "fe.quckCartProdID.end.xp", "rel"), "148530");
                    formXp("fe.quckCartProdID.beg.xp", i, "fe.quckCartProdID.end.xp");
                    break;
                case 2:
                    System.out.println("Product " + i + ": " + attReturn("fe.quckCartProdID.beg.xp", i, "fe.quckCartProdID.end.xp", "rel"));
                    System.out.println("Product " + i + ": " + strXpText("fe.quckCartProdID.beg.xp", i, "fe.quckCartDesc.end.xp") + "\n");
                    Assert.assertEquals(attReturn("fe.quckCartProdID.beg.xp", i, "fe.quckCartProdID.end.xp", "rel"), "1627313");
                    formXp("fe.quckCartProdID.beg.xp", i, "fe.quckCartProdID.end.xp");
                    break;
                case 3:
                    System.out.println("Product " + i + ": " + attReturn("fe.quckCartProdID.beg.xp", i, "fe.quckCartProdID.end.xp", "rel"));
                    System.out.println("Product " + i + ": " + strXpText("fe.quckCartProdID.beg.xp", i, "fe.quckCartDesc.end.xp")+ "\n");
                    Assert.assertEquals(attReturn("fe.quckCartProdID.beg.xp", i, "fe.quckCartProdID.end.xp", "rel"), "1862685");
                    formXp("fe.quckCartProdID.beg.xp", i, "fe.quckCartProdID.end.xp");
                    break;
                default:
                    System.out.println("Invalid value for product count");
                    break;
            }
        }
        return this;
    }
    //*******************************************************************
    // * Description: Fill out Address Form
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public Q_CheckoutForm creditForm(Integer index) throws FileNotFoundException {
        CreditContainer card = new CreditContainer(index);
        Q_WebElm.myWait(2000);
        Assert.assertTrue(isIdDisplayed("ord.payment.invoiceCdName.xp"));
        Q_WebElm.xpSend(adminProps, "ord.payment.invoiceCdName.xp",card.cdName);
        Q_WebElm.idSend(adminProps, "ord.jm.cardNumber.id", card.cdNumber);
        Q_WebElm.idSelectValue(adminProps, "ord.jm.cardMonth.id", card.monthV);
        Q_WebElm.idSelectIndex(adminProps, "ord.jm.cardYear.id", card.year);
        Q_WebElm.xpSend(adminProps, "ord.payment.invoiceCvv.xp", card.code);
        return this;
    }
    public Q_CheckoutForm emptyCart() {
        Actions moveTo = new Actions(driver);
        WebElement cart = driver.findElement(By.id("mycart"));
        moveTo.moveToElement(cart).moveToElement(cart).perform();

        System.out.println("Items in Cart " + rowCount("fe.quickCartCount.xp"));
        for (int i = 1; i <= rowCount("fe.quickCartCount.xp"); i++) {
            formXp("fe.quckCartProdID.beg.xp", i, "fe.quckCartProdID.end.xp");
        }
        return  this;
    }
    

    /**
	 * Gets total order value
	 * @return cart value
	 */
	public static double frontOrderTotal()	{
		return Double.parseDouble(Q_WebElm.idRetTextRep(adminProps, "frontEnd.checkout.cartTotal.id"));
	}
	
	/**
	 * Select shipping option
	 * @param option
	 */
	public static void selectShippingUpgrade(String option) {
		int count = Q_WebElm.xpCountTableRows(adminProps, "frontEnd.shipping.optionsText.xp");
		for (int i = 0; i < count; i++) {
			WebElement ele = Q_WebElm.listOfElements(adminProps, "frontEnd.shipping.optionsText.xp").get(i);
			if (ele.getText().equals(option)) {
				WebElement btn = Q_WebElm.listOfElements(adminProps, "frontEnd.shipping.options.radioBtn.xp").get(i);
				Assert.assertEquals(ele.getText(), option, "Desired option is not available");
				btn.click();
				if (option.equalsIgnoreCase("Secure Storage - TDS")) {
					Q_WebElm.myWait(3000);
					Q_WebElm.id(adminProps, "frontEnd.shipping.option.secureStorage.checkbox.id");
				}
				break;
			}
			else if (i== count-1)	{
				Assert.fail("Desired option is not available");
			}
		}
	}
	//JMB-7041 Start
	/**
	 * Add a Sell to Us product from Gold category to cart
	 * @param item
	 * @param quan
	 */

    public void addDiyBbItem(String metal, String productName, String quantity) {
    	System.out.println("Adding BB Product: " + productName);
    	Q_WebElm.xp(adminProps, metal);
        enterStuProductSearch(productName);
        stuAddProduct(1, quantity);
    	System.out.println("Added: " + quantity + " " + productName);
    	formXp("stu.modal.checkout.xp");
    }
    
    /**
     * Search product on Sell to Us page
     * @param searchvalue
     */
    public void enterStuProductSearch(String searchvalue) {
    	// added wait since occasional issues without it
    	Q_WebElm.xpClear(adminProps, "stu.productSearchInput.xpath");
    	Q_WebElm.myWait(1000);
    	Q_WebElm.xpSend(adminProps, "stu.productSearchInput.xpath", searchvalue);
    	Q_WebElm.myWait(1000);
    	Q_WebElm.xp(adminProps, "stu.productSearchButton.xp");
    }
    
    /**
     * Add a quantity to a product on Sell to Us page
     * @param index
     * @param quantity
     */
    public void stuAddProduct(int index, String quantity) {
		Q_WebElm.xpSend(adminProps, "stu.productQtyInput.xp", quantity);
		Q_WebElm.xp(adminProps, "stu.productAdd.xp");
	}
	/**
	 * Click on main Sell to Us button which leads to category pages
	 */
	public void selToUs() {
		formXp("stu.link.xp");
		formXp("stu.btn.xp");
	}

	/**
	 * Complete Sell to Us checkout
	 */
	public void sellToUs_checkoutNow() {
		driver.navigate().to(baseUrl + "my-account/buyback-cart/");
		formXp("stu.cart.checkout.xp");
		formXp("stu.agree.xp");
		formXp("stu.submitOrder.xp");
	}
	
	/**
	 * Removes all items in Sell to Us cart
	 */
	public void removeCartPageContent() {
		driver.navigate().to(baseUrl + "/my-account/buyback-cart/");
		Integer productCount = rowCount("cart.stu.cart.productCount.xp") - 2;
		System.out.println("Row count " + productCount);
		Controls.scrolDownPixel(400);
		if (productCount >= 1) {
			for (int i = productCount; i > 1; i--) {
				System.out.println("Line item " + numberReturn("stu.cartCount.xp"));
				formXp("stu.cartProductTble.remove.xp");
				Q_WebElm.myWait(2000);
				if (numberReturn("stu.cartCount.xp").equals(0))
					break;
			}
		}
	}
	//JMB-7041 End
	
	//JMB-5763 Start	 
	/************************************************************
    // * Description: To place an order for a product
    // * Param : String product, String paymentType
    // * Jira Ticket: JMB 5763
    // * Status: Completed
    //***********************************************************/ 		
	public String placeAnOrder(String product, String paymentType) {
		driver.navigate().to(baseUrl +product );
		chk.addItemToCart(1);
		chk.selectPaymentType(paymentType);
		chk.selectcheckoutBtn("top");
		Q_WebElm.xpClear(adminProps, "cust.secureCheckout.enterCSC.xp");
		Q_WebElm.xpSend(adminProps, "cust.secureCheckout.enterCSC.xp", "110");
		chk.completeOrder();
		String orderId = Q_WebElm.xpRetText(adminProps, "adm.thankyou.getOrderId.xp").replaceAll("Order Number: ORD-", "").trim();
		return orderId;
	}
	//JMB-5763 End
	
}
