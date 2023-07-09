package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import org.testng.Assert;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.text.DecimalFormat;
import java.util.Properties;

public class Q_JMB_CartPageObjects extends Q_JMB_Init {


    public Q_JMB_CartPageObjects formIntegerInputXp(String locator, Integer inputValue) {
        Q_JMB_WebElm.xpClear(jmbProps, locator);
        Q_JMB_WebElm.xpSend(jmbProps, locator, String.valueOf(inputValue));
        return this;
    }
    public void xp(Properties proper, String catQtyBeg, String mid, String catQtyEnd) {
		driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + mid + proper.getProperty(catQtyEnd))).click();
	}
    
    public void xpSend(Properties proper, String catQtyBeg, String item, String catQtyEnd, String quan) {
        driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).sendKeys(quan);
    }
    
    public void xpClear(Properties proper, String catQtyBeg, String mid, String catQtyEnd) {
		driver.findElement(
				By.xpath(proper.getProperty(catQtyBeg) + mid + proper.getProperty(catQtyEnd)))
				.clear();
	}
    
    public Q_JMB_CartPageObjects formXp(String locator) {
        Q_JMB_WebElm.xp(jmbProps, locator);
        return this;
    }
    public Q_JMB_CartPageObjects formXp(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xp(jmbProps, begXp, lineItem, endXp);
        return this;
    }
    public Q_JMB_CartPageObjects formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_JMB_WebElm.xp(jmbProps, begXp, row, midXp, column, endXp);
        return this;
    }
    public Q_JMB_CartPageObjects formInputXp(String locator, String inputValue) {
        Q_JMB_WebElm.xpClear(jmbProps, locator);
        Q_JMB_WebElm.xpSend(jmbProps, locator, inputValue);
        return this;
    }
    public Q_JMB_CartPageObjects formInputXp(String begXp, Integer lineItem, String endXP, String inputValue) {
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
        return Q_JMB_WebElm.xpRetText(jmbProps, begXp, row, midXp, cell,  endXp);
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
    public Q_JMB_CartPageObjects formReturnText(String locator) {
        Q_JMB_WebElm.xpRetText(jmbProps, locator);
        return this;
    }
    public Q_JMB_CartPageObjects formReturnText(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xpRetText(jmbProps, begXp, lineItem, endXp);
        return this;
    }
    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_JMB_WebElm.xpRetText(jmbProps, begXp, recordNumber, midXp, lineItem, endXp);
    }
    public static String formReturnTextReplace(String locator) {
        return Q_JMB_WebElm.xpRetTextReplace(jmbProps, locator);
    }

    public Q_JMB_CartPageObjects formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xpRetTextReplace(jmbProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_JMB_CartPageObjects formReturnAttribute(String locator, String attr) {
        Q_JMB_WebElm.xpRetAttr(jmbProps, locator,attr);
        return this;
    }
    public static String attReturn(String locator, String attr) {
        return Q_JMB_WebElm.xpRetAttr(jmbProps, locator,attr);

    }
    public static String attReturn(String begXp, Integer lineItem, String endXp, String attr) {
        return Q_JMB_WebElm.xpAttribute(jmbProps, begXp, lineItem, endXp, attr);
    }
    public Q_JMB_CartPageObjects formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_JMB_WebElm.xpAttribute(jmbProps, begXp, lineItem, endXp,attr);
        return this;
    }

    public Q_JMB_CartPageObjects formReturnAttributeReplace(String locator) {
        Q_JMB_WebElm.xpReturnAttributeReplace(jmbProps, locator);
        return this;
    }

    public Q_JMB_CartPageObjects formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xpReturnAttributeReplace(jmbProps, begXp, lineItem, endXp);
        return this;
    }
    public Q_JMB_CartPageObjects formXpDisplayed(String locator) {
        try {
            Q_JMB_WebElm.xpDisplayed(jmbProps, locator).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }
    public Q_JMB_CartPageObjects formXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_JMB_WebElm.xpDisplayed(jmbProps, begXp, lineItem, endXP).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }
    public Q_JMB_CartPageObjects formXpTab(String locator) {
        Q_JMB_WebElm.xpSendTab(jmbProps, locator);
        return this;
    }

    public Q_JMB_CartPageObjects formXpTab(String begXp, Integer lineItem, String endXP) {
        Q_JMB_WebElm.xpSendTab(jmbProps, begXp, lineItem, endXP);
        return this;
    }

    public Q_JMB_CartPageObjects formXpEnter(String locator) {
        Q_JMB_WebElm.xpSendEnter(jmbProps, locator);
        return this;
    }

    public Q_JMB_CartPageObjects formXpEnter(String begXp, Integer lineItem, String endXP) {
        Q_JMB_WebElm.xpSendEnter(jmbProps, begXp, lineItem, endXP);
        return this;
    }
    public static boolean isXpDisplayed(String locator) {
        return  Q_JMB_WebElm.xpEnabled(jmbProps, locator).equals(true);
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
    public Q_JMB_CartPageObjects formXpSelectIndex(String locator, Integer index) {
        Q_JMB_WebElm.xpSelectIndex(jmbProps, locator, index);
        return this;
    }

    public Q_JMB_CartPageObjects formXpSelectValue(String locator, String value) {
        Q_JMB_WebElm.xpSelectValue(jmbProps, locator, value);
        return this;
    }
    public Q_JMB_CartPageObjects formXpSelectText(String locator, String text) {
        Q_JMB_WebElm.xpSelectText(jmbProps, locator, text);
        return this;
    }
    public Q_JMB_CartPageObjects formId(String locator) {
        Q_JMB_WebElm.id(jmbProps, locator);
        return this;
    }
    public Q_JMB_CartPageObjects formInputId(String locator, String inputValue) {
        Q_JMB_WebElm.idClear(jmbProps, locator);
        Q_JMB_WebElm.idSend(jmbProps, locator, inputValue);
        return this;
    }
    public Q_JMB_CartPageObjects formIdTab(String locator) {
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
        return  Q_JMB_WebElm.idDisplayed(jmbProps, locator).equals(true);}
    public static boolean isIdCheckEnabled(String locator) {
        return Q_JMB_WebElm.idEnabled(jmbProps, locator).equals(true);
    }
    public Q_JMB_CartPageObjects formIdSelectIndex(String locator, Integer index) {
        Q_JMB_WebElm.idSelectIndex(jmbProps, locator, index);
        return this;
    }

    public Q_JMB_CartPageObjects formIdSelectValue(String locator, String value) {
        Q_JMB_WebElm.idSelectValue(jmbProps, locator, value);
        return this;
    }
    public Q_JMB_CartPageObjects formIdSelectText(String locator, String text) {
        Q_JMB_WebElm.idSelectText(jmbProps, locator, text);
        return this;
    }
    public static Integer rowCount(String locator) {
        Integer count = Q_JMB_WebElm.xpCountTableRows(jmbProps, locator);
        return count;
    }

    public static String cartLineItemDescription(Integer item){
        return Q_JMB_WebElm.xpRetText(jmbProps, "cart.cart.description.beg.xp", item, "cart.cart.description.end.xp");
    }
    public static String cartLineItemUnitPrice(Integer item){
        return Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.cart.unitPrice.beg.xp",item, "cart.cart.unitPrice.end.xp");
    }
    public static void cartLineItemQuantityClear(Integer item){
        Q_JMB_WebElm.xpClear(jmbProps, "cart.cart.quantity.beg.xp", item, "cart.cart.quantity.end.xp");
    }
    public static void cartLineItemQuantitySend(Integer item, String quan){
        Q_JMB_WebElm.xpSend(jmbProps, "cart.cart.quantity.beg.xp", item, "cart.cart.quantity.end.xp", quan);
    }
    public static String cartLineItemQuantityValue(Integer item, String attr){
        return Q_JMB_WebElm.xpAttribute(jmbProps, "cart.cart.quantity.beg.xp", item, "cart.cart.quantity.end.xp", attr);
    }
    public static void cartLineItemPlus(Integer item){
        Q_JMB_WebElm.xp(jmbProps, "cart.cart.lineItemTotal.beg.xp", item, "cart.cart.lineItem.plus.end.xp");
    }
    public static void cartLineItemMinus(Integer item){
        Q_JMB_WebElm.xp(jmbProps, "cart.cart.lineItemTotal.beg.xp", item, "cart.cart.lineItem.minus.end.xp");
    }
    public static void cartLineItemUpdateBtn(Integer item){
        Q_JMB_WebElm.xp(jmbProps, "cart.cart.quantity.beg.xp", item, "cart.cart.lineItem.update.end.xp");
    }
    public static void cartLineItemRemoveBtn(Integer item){
        Q_JMB_WebElm.xp(jmbProps, "cart.cart.quantity.beg.xp", item, "cart.cart.lineItem.remove.end.xp");
    }
    public static String cartLineItemTotal(Integer item){
        return Q_JMB_WebElm.xpReturnReplace(jmbProps,"cart.cart.lineItemTotal.beg.xp",item, "cart.cart.lineItemTotal.end.xp");
    }
    public static void presale(){
        Q_JMB_WebElm.id(jmbProps, "cart.preSaleMsgCheckbox.id");
    }
    public static void category(String category) {
        switch (category) {
            case ("gold bars"):
                Q_JMB_WebElm.xp(jmbProps, "cart.goldBar.xp");
                break;

            case ("american gold coin"):
                Q_JMB_WebElm.xp(jmbProps, "cart.americanGoldCoin.xp");
                break;
            case ("uncirculated gold eagle"):
                Q_JMB_WebElm.xp(jmbProps, "cart.uncirculatedGoldEagle.xp");
                break;
            case ("chinese panda"):
                Q_JMB_WebElm.myWait(1000);
                Q_JMB_WebElm.xp(jmbProps, "cart.chinesePanda.xp");

                break;
            case ("silver bars"):
                Q_JMB_WebElm.xp(jmbProps, "cart.silverbars.xp");
                break;
            case ("100 oz bars"):
                Q_JMB_WebElm.xp(jmbProps, "cart.100ozbars.xp");
                break;
            case ("silver coins"):
                Q_JMB_WebElm.xp(jmbProps, "cart.silver.category.silvercoin.xp");
                break;
            case ("american silver eagle"):
                Q_JMB_WebElm.xp(jmbProps, "cart.americansilvereagle.xp");
                break;
            case ("uncirculated silver eagle"):
                Q_JMB_WebElm.xp(jmbProps, "cart.uncirculatedsilvereagle.xp");
                break;
            case ("silver dollar"):
                Q_JMB_WebElm.myWait(000);
                Q_JMB_WebElm.xp(jmbProps, "cart.silverDollar.xp");
                break;
            case ("peace silver dollar"):
                Q_JMB_WebElm.myWait(1000);
                Q_JMB_WebElm.xp(jmbProps, "cart.peaceSilverDollar.xp");
                break;
            case ("platinum bars"):
                Q_JMB_WebElm.xp(jmbProps, "cart.platinumBars.xp");
                break;
            case ("platinum coins"):
//                driver.navigate().to(baseUrl + "/platinum/platinum-coins/"); // staging only
                driver.navigate().to(baseUrl + "/platinum/platinum-coins/american-platinum-eagle/"); // qa
                break;
            case ("British Platinum Coin"):
//                driver.navigate().to(baseUrl + "/platinum/platinum-coins/"); // staging only
                driver.navigate().to(baseUrl + "/platinum/platinum-coins/british-platinum-coins/"); // qa
                break;
            case ("platinum ira"):
                Q_JMB_WebElm.myWait(1000);
                Q_JMB_WebElm.xp(jmbProps, "cart.platinumIRA.xp");
                break;
            case ("copper-rounds"):
                driver.get(baseUrl + "/copper/copper-rounds/");
                break;
            case ("accessories"):
                driver.get(baseUrl + "/accessories/coin-supplies/");
                break;
        }
    }
//    public Q_JMB_CartPageObjects selectPaymentType(String payWith) {
//        Q_JMB_WebElm.myWait(2000);
//        try {
//            switch (payWith) {
//                case "credit card":
//                    Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.CC.id");
//                    break;
//                case "paypal":
//                    Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.PP.id");
//                    break;
//                case "echeck":
//                    Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.EC.id");
//                    break;
//                case "cheque":
//                    Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.PC.id");
//                    break;
//                case "wire":
//                    Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.BW.id");
//                    break;
//                case "bitpay":
//                    Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.BC.id");
//                    break;
//                default:
//                    System.out.println("Invalid Payment type");
//                    break;
//            }
//        } catch (Throwable ex) {
//            System.out.println("Failed to select payment");
//        }
//        return this;
//    }
    public Q_JMB_CartPageObjects selectcheckoutBtn(String  whichButton){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        switch (whichButton){
            case ("top"):
                Q_JMB_Controls.scrolDownPixel(300);
                Q_JMB_WebElm.myWait(1000);
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("checkout"))));
                Q_JMB_WebElm.cn(jmbProps, "cart.topcheckoutnow.className");
                break;
            case ("bottom"):
//                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("jm_cart_btn"))));
                Q_JMB_WebElm.myWait(5000);
                Q_JMB_WebElm.xp(jmbProps, "cart.cart.botBtnCheckoutNow.xp");
                Q_JMB_WebElm.myWait(1000);
                break;
            case ("paypal"):
                Q_JMB_WebElm.cn(jmbProps, "cart.cart.paypal.className");
                break;
            default:
                System.out.println("Checkout Button none selected");
                break;
        }
        return this;
    }
    public static float cartCheckPrice() {
        DecimalFormat df = new DecimalFormat("#.00");
        Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.PC.id");
        float checkPrice = Float.valueOf(cartLineItemUnitPrice(2));
        return checkPrice;
    }
    public static float cartBitcoinPrice() {
        DecimalFormat df = new DecimalFormat("#.00");
        Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.BC.id");
        float bitCoinPrice = Float.valueOf(cartLineItemUnitPrice(2));
        return bitCoinPrice;
    }
    public static float cartCreditPrice() {
        DecimalFormat df = new DecimalFormat("#.00");
        Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.CC.id");
        float creditPrice = Float.valueOf(cartLineItemUnitPrice(2));
        return creditPrice;
    }

    public Q_JMB_CartPageObjects cartPaymentTypePricing(String quan){
        DecimalFormat df = new DecimalFormat("#.00");
        Q_JMB_CategoryObjects.goldEagle(quan);
        System.out.println( "Check price" + String.valueOf(df.format(cartCheckPrice())));
        System.out.println("Bitcoin price"+ String.valueOf(df.format(cartBitcoinPrice())));
        System.out.println("Credit card price" + String.valueOf(df.format(cartCreditPrice())));
        if(cartCheckPrice() < cartBitcoinPrice() || cartBitcoinPrice() < cartCreditPrice()){
            System.out.println("Modal payment type pricing verified");
        }
        else{
            System.out.println("Modal payment type pricing failed");
        }
        return this;
    }

    public Q_JMB_CartPageObjects cartMultipleQuantity(String quan){
        DecimalFormat df = new DecimalFormat("#.00");
        Q_JMB_CategoryObjects.perthMintGoldBar(quan);
        float unitPrice = cartCheckPrice();
        float lineTotal = Float.valueOf(cartLineItemTotal(2));
        int quantity = Integer.valueOf(cartLineItemQuantityValue(2, "value"));
        float calculatedLineItem = Float.valueOf(df.format(unitPrice * quantity));
        Assert.assertEquals(String.valueOf(calculatedLineItem), String.valueOf(lineTotal));
        try{
            System.out.println(String.valueOf(quantity) + "Line item quantity");
            System.out.println(String.valueOf(df.format(unitPrice)) + "Line item unit price");
            System.out.println(String.valueOf(df.format(calculatedLineItem)) + "Line item calculated total price");
            System.out.println(String.valueOf(df.format(lineTotal)) + "Line item total");
        }
        catch(Throwable ex){
            System.out.println("Failed line item multiple quantity verification");
        }
        return this;
    }

    public Q_JMB_CartPageObjects giftCertificateInput() {
        DecimalFormat df = new DecimalFormat("#.00");
        Q_JMB_WebElm.xpClear(jmbProps, "cart.cartCouponInput.xp");
        Q_JMB_WebElm.myWait(1000);
        Q_JMB_WebElm.xpSend(jmbProps, "cart.cartCouponInput.xp", "AutomationTesting");
        return this;
    }
    public Q_JMB_CartPageObjects giftCertificateInput(String gifCode) {
        DecimalFormat df = new DecimalFormat("#.00");
        Q_JMB_WebElm.xpClear(jmbProps, "cart.cartCouponInput.xp");
        Q_JMB_WebElm.myWait(1000);
        Q_JMB_WebElm.xpSend(jmbProps, "cart.cartCouponInput.xp", gifCode);
        return this;
    }
    public Q_JMB_CartPageObjects giftCertificateApply() {
        Q_JMB_WebElm.name(jmbProps, "cart.cartCouponApply.name");
        return this;
    }
    public Q_JMB_CartPageObjects removeGiftCertificate() {
        Q_JMB_WebElm.cn(jmbProps, "cart.cartCouponRemove.className");
        driver.navigate().refresh();
        System.out.println("Gift certificate removed");
        return this;
    }

    public static float giftCertificateSubTotal() {
        float subtotal = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.cartSubtotalBottom.xp"));
        return subtotal;
    }
    public static float giftCertificateAdjustment() {
        float adjustment = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.cartAdjustment.xp"));
        return adjustment;
    }
    public static float giftCertificateTotal() {
        float total = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.cartTotal.xp"));
        return total;
    }
    public Q_JMB_CartPageObjects verifyGiftCertificateTotal(){
        DecimalFormat df = new DecimalFormat("#.00");
        Q_JMB_WebElm.myWait(2000);
        System.out.println("Subtotal " + String.valueOf(df.format(giftCertificateSubTotal())));
        System.out.println("Certificate value" + String.valueOf(df.format(giftCertificateAdjustment())));
        System.out.println("Cart total " + String.valueOf(df.format(giftCertificateTotal())));
        return this;
    }
    public static float cartSubTotal() {
        float subtotal = Float.valueOf(numberReturn("cart.cartSubtotalBottom.xp"));
        return subtotal;
    }
    public static float cartShippingCargeg() {
        float adjustment = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.cartAdjustment.xp"));
        return adjustment;
    }
    public static float cartTotal() {
        float total = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.cartOrderTotalNoGift.xp"));
        return total;
    }
    public Q_JMB_CartPageObjects verifyNoGiftCertificate(){
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Subtotal " + String.valueOf(df.format(cartSubTotal())));
        System.out.println("Cart total " + String.valueOf(df.format(cartTotal())));
        Assert.assertEquals(String.valueOf(df.format(cartSubTotal())), String.valueOf(df.format(cartTotal())));
        return this;
    }
    public static void verifyCartContent(){
        Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
        String begDescriptionXpath = "cart.cart.description.beg.xp";
        String endDescriptionXpath = "cart.cart.description.end.xp";
        String begQuantityXpath = "cart.cart.quantity.beg.xp";
        String endQuantityXpath = "cart.cart.quantity.end.xp";
        String quantity[] = {"3", "4", "6", "5", "1", "4", "2", "2","1", "10"};
        cart.selectPaymentType("wire");
        int count = Q_JMB_WebElm.xpCountTableRows(jmbProps,"cart.cart.table.xp");
        System.out.println("Number of products " + count);
        for(int i =2; i<= count -2 ; i++) {
            System.out.println("Item " + i + "    " + Q_JMB_WebElm.xpRetText(jmbProps, begDescriptionXpath,  i, endDescriptionXpath));
            Assert.assertEquals(quantity[i-2], Q_JMB_WebElm.xpAttribute(jmbProps, begQuantityXpath,  i, endQuantityXpath, "value"));
            System.out.println("Quantity for item " + String.valueOf(i - 2)  + " " +  Q_JMB_WebElm.xpAttribute(jmbProps, begQuantityXpath, i, endQuantityXpath, "value"));

        }
    }
//    public static void returnFromCheckouToCartpage(){
//        WebElm.cnExecuter(checkProps, "jm.reviewOrderNodify.className");
//        System.out.println("Currently on checkout page returning to cart page");
//    }

    public static void editCartContent(){
        Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
        String quantity[] = {"3", "3", "7", "1"};
        cart.selectPaymentType("wire");
        int count = Q_JMB_WebElm.xpCountTableRows(jmbProps,"cart.cart.table.xp");
        System.out.println("Number of products " + count);
        for(int i =2; i<= count -2; i++) {
            System.out.println("Item " + i + "    " + cartLineItemDescription(i));
            if (i <= 3) {
                cartLineItemQuantityClear(i);
                cartLineItemQuantitySend(i, "3");
                cartLineItemUpdateBtn(i);
            } else if (i == 4) {
                cartLineItemPlus(i);
                cartLineItemUpdateBtn(i);
            } else if (i == 5) {
                cartLineItemMinus(i);
                cartLineItemUpdateBtn(i);
            } else {
                cartLineItemRemoveBtn(i);
            }
        }
        int count2 = Q_JMB_WebElm.xpCountTableRows(jmbProps, "cart.cart.table.xp");
        for(int i = 2; i<= count2 -2; i++) {
            System.out.println("Changed quantity for item " + String.valueOf(i - 1)  + " to " + cartLineItemQuantityValue(i, "value"));
            Assert.assertEquals(quantity[i - 2], cartLineItemQuantityValue(i, "value"));
        }
    }

    public static void quickCart() {
        Actions moveTo = new Actions(driver);
        WebElement cart = driver.findElement(By.id("mycart"));
        moveTo.moveToElement(cart).moveToElement(cart).perform();
    }
    public static void removeItems(){
        Q_JMB_WebElm.myWait(1000);
        driver.navigate().to(baseUrl);
        Integer cartItems = Integer.valueOf(Q_JMB_WebElm.xpRetText(jmbProps,"cart.itemsIncart.xp").replaceAll("[^\\d.]", ""));
        System.out.println("Current cart = :    " + cartItems);
        quickCart();

        for(int i = cartItems; i>=1; i--){
            Q_JMB_WebElm.myWait(1000);
            Q_JMB_WebElm.xp(jmbProps, "cart.cart.MyCart.beg.delete.xp", i, "cart.cart.MyCart.end.delete.xp");
            System.out.println("Removing cart item " + i);
            Q_JMB_WebElm.myWait(1000);
        }
        driver.navigate().refresh();
        Q_JMB_WebElm.myWait(1000);
    }
    public static void modalPrice(String quan) {
        DecimalFormat df = new DecimalFormat("#.00");

        Integer item = 7;
        Q_JMB_NavigationObjects.selectFromMenu("gold");
        Q_JMB_CartPageObjects.category("american gold coin");
        Q_JMB_CartPageObjects.category("uncirculated gold eagle");
        Q_JMB_CategoryObjects coin = new Q_JMB_CategoryObjects();
        String itemDescription = Q_JMB_CategoryObjects.itemDescription(item);
        coin.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        coin.lineQty(item,quan);
        coin.atc(item);
        float checkPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.modal.price.Check.xp"));
        System.out.println("checkPrice " + checkPrice);
        float bitCoinPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.modal.price.bitCoin.xp"));
        System.out.println("bitCoinPrice " + bitCoinPrice);
        float creditPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.modal.price.credit.xp"));
        System.out.println("creditPrice " + creditPrice);
//        try {
        if (checkPrice < bitCoinPrice || bitCoinPrice < creditPrice) {
            System.out.print("Modal Check / Wire Price: " + checkPrice + "\n" + "Modal Bitcoin / Bitcoin Cash Price: " + bitCoinPrice + "\n" + "Modal Credit Card Price: " + creditPrice + "\n");
            System.out.print("Bitcoin / Bitcoin Cash Price: " + bitCoinPrice + "\n");
            System.out.print("Credit Card Price: " + creditPrice + "\n");
            Q_JMB_WebElm.xp(jmbProps, "cart.modal.CheckoutNow.xp");

        } else {
            System.out.print("Failed to verify payment method unit price in the modal");
        }
    }
    public static void cartPagePrice(String quan){
        Q_JMB_CategoryObjects.perthMintGoldBar(quan);

        Q_JMB_WebElm.id(jmbProps, "cart.paymentType.PC.id");
        float checkPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.cart.unitPrice.beg.xp",2, "cart.cart.unitPrice.end.xp"));
        Q_JMB_WebElm.id(jmbProps, "cart.paymentType.BC.id");
        float bitCoinPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.cart.unitPrice.beg.xp",2, "cart.cart.unitPrice.end.xp"));
        Q_JMB_WebElm.id(jmbProps, "cart.paymentType.CC.id");
        float creditPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.cart.unitPrice.beg.xp",2, "cart.cart.unitPrice.end.xp"));
        try{

            if(checkPrice < bitCoinPrice || bitCoinPrice<creditPrice)  {
                System.out.print("cart page Check / Wire Price: " + checkPrice + "\n" + "cart page Bitcoin / Bitcoin Cash Price: " + bitCoinPrice + "\n" + "cart page Credit card Price: " + creditPrice + "\n");
            }
            else {
                System.out.print("\t Failed to verify payment method unit price in the cart page");
            }

        }
        catch(Throwable ex){
            org.testng.Assert.fail("Failed to verify payment method unit price");
        }

    }
    public static void multipleItemPricing(String quan){
        Q_JMB_CategoryObjects.perthMintGoldBar(quan);
        Q_JMB_WebElm.id(jmbProps, "cart.paymentType.PC.id");
        DecimalFormat df = new DecimalFormat("#.00");
        float unitPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.cart.unitPrice.beg.xp",2, "cart.cart.unitPrice.end.xp"));
        float lineTotal = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.cart.lineItemTotal.beg.xp",2, "cart.cart.lineItemTotal.end.xp"));
        int quantity = Integer.valueOf(Q_JMB_WebElm.xpAttribute(jmbProps, "cart.cart.quantity.beg.xp", 2, "cart.cart.quantity.end.xp", "value"));
        System.out.println(unitPrice +"\n"+ lineTotal+"\n"+ quantity);
        float calculatedLineItem = Float.valueOf(df.format(unitPrice * quantity));

        System.out.println("order line item total = " + lineTotal + "\t calculated line item = " + calculatedLineItem);
//        Assert.assertEquals(calculatedLineItem, lineTotal);
        System.out.println("order line item total = " + lineTotal + "\t calculated line item = " + calculatedLineItem);
        Assert.assertEquals(calculatedLineItem, lineTotal);

        }
    public static void applyGiftCertificate(){
        DecimalFormat df = new DecimalFormat("#.00");
        Q_JMB_WebElm.xpClear(jmbProps, "cart.cartCouponInput.xp");
        Q_JMB_WebElm.myWait(1000);
        Q_JMB_WebElm.xpSend(jmbProps, "cart.cartCouponInput.xp", "AutomationTesting");
        Q_JMB_WebElm.myWait(1000);
        Q_JMB_WebElm.name(jmbProps, "cart.cartCouponApply.name");
        Q_JMB_WebElm.myWait(1000);
        float subtotal = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.cartSubtotalBottom.xp"));
        float adjustment = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.cartAdjustment.xp"));
        float total = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.cartTotal.xp"));
        System.out.println("Order subtotal:  " + subtotal +"\n"+"Coupon value:  " + adjustment +"\n"+ "Order Total:  "+ total);

        float calculatedTotal = subtotal - adjustment;
        try{
            Assert.assertEquals(df.format(calculatedTotal), df.format(total));
            System.out.println("Calculated total : "+calculatedTotal+"\t Order total : "+ total);
        }
        catch(Throwable ex){
            System.out.println("Failed verification of order total and coupon not applied");
            Assert.fail("Failed verification of order total and coupon not applied");
        }
    }
    public Q_JMB_CartPageObjects paymentType(String payWith) {
        Q_JMB_WebElm.id(jmbProps, payWith);
        return this;
    }
    public Q_JMB_CartPageObjects topChkoutBtn() {
        Q_JMB_WebElm.myWait(3000);
        Q_JMB_WebElm.cn(jmbProps, "cart.topChkoutBtn.className");
        return this;
    }
//    public CartPageObjects bottomChkoutBtn() {
//        WebElm.myWait(3000);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("checkout"))));
////        WebElm.myWait(5000);
//        WebElm.moveToxp(jmbProps.getProperty("cart.cart.botBtnCheckoutNow.xp"));
//        WebElm.cn(jmbProps, "cart.cart.botBtnCheckoutNow.className");
//
//        return this;
//    }

    public  static void militaryCart(){
        Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
        DecimalFormat df = new DecimalFormat("#.00");
        float checkPrice1 = Q_JMB_CategoryObjects.military10ozPlatinumBar("1");
        System.out.println( " Platinum Military Price " + checkPrice1 );
        float checkPrice2 = Q_JMB_CategoryObjects.militaryAcc32mmAirTiteHolder("15");
        System.out.println( " Accessory Military Price " + checkPrice2);
        Q_JMB_WebElm.myWait(1000);
        cart.selectPaymentType("cheque");
        Q_JMB_WebElm.myWait(3000);
        cart.selectcheckoutBtn("bottom");
        int productCount = Q_JMB_WebElm.xpCountTableRows(jmbProps,"cart.reviewOrder.product.count.xp");
        System.out.println( " products before adjusted " + productCount );
        productCount = productCount - 6;
        System.out.println( " products " + productCount );
        Float[] checkPrice = {checkPrice1, checkPrice2};
        Q_JMB_WebElm.myWait(1000);
        for (int i = 6; i < productCount; i++){
            Q_JMB_WebElm.myWait(1000);
//            int quantity = Integer.valueOf(WebElm.xpRetTextReplace(jmbProps,"chk.reviewOrder.quantity.beg.xp", (i + 6), "chk.reviewOrder.quantity.end.xp"));
            int quantity = Integer.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"chk.reviewOrder.quantity.xp="));
            System.out.println( " quantity for line item " + (i + 6)  + " = "  + quantity );
            System.out.println( " Price for line item " + (i + 6)  + " = "  + checkPrice[i] );
            System.out.println( " Calculated line item subtotal  " + df.format(checkPrice[i] * quantity ));
//            Assert.assertEquals(df.format(Float.valueOf(ElemSteps.xpReturnElement(checkProps, "jm.reviewOrder.itemSubtotal.beg.xpath", i + 5, "jm.reviewOrder.itemSubtotal.end.xpath"))), df.format(checkPrice[i] * quantity ));

        }
    }
    public Q_JMB_CartPageObjects addProductpageItemToCart(Integer quan){
//      driver.navigate().to(base + productURL);
        formIntegerInputXp("cart.productPageQty.xp", quan);
        Q_JMB_WebElm.myWait(1000);
        formXp("cart.productpage.AddToCart.xp");
        formXp("cart.modalCheckoutNow.xp");
        return this;
    }
    public Q_JMB_CartPageObjects addProductpageItemToCart(String productUrl, Integer quan){
        driver.navigate().to(baseUrl + productUrl);
        formIntegerInputXp("cart.productPageQty.xp", quan);
        Q_JMB_WebElm.myWait(1000);
        formXp("cart.productpage.AddToCart.xp");
        formXp("cart.modalCheckoutNow.xp");
        return this;
    }
    public Q_JMB_CartPageObjects addItemToCart(Integer quan){
//        driver.navigate().to(base + productURL);
        formIntegerInputXp("cart.productPageQty.xp", quan);
        Q_JMB_WebElm.myWait(1000);
        formXp("cart.productpage.AddToCart.xp");
        formXp("cart.modalCheckoutNow.xp");
        return this;
    }
    public  void paperCheckCartLanguage() {
        //     String s1= "Ships within 4-6 Business Days After Payment Received/Processed";
        String s1= "Ships Within 4-6 Business Days After Receipt of Payment";
        String s2 = "Paper Checks are approved for orders between $0.00 and $75,000.00. Order Confirmation Email will include all information necessary to complete payment.";
        String s3 = "Due to unprecedented USPS delays delivering paper checks, we highly recommend choosing eCheck (ACH) or Bank Wire as your payment type.";
//    	        String s4 = "All Paper Check Orders Receive a 4% Discount Relative to Credit Card/PayPal Pricing";
        String s4 = "All Paper Check Orders Receive a 4% Discount Relative to Card/PayPal Pricing";
        String s5 = "May Require a Credit Card on File to Lock in Pricing";
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.pc.heading.xp"));
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.pc.line1.xp"));
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.pc.line2.xp"));
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.pc.line3.xp"));
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.pc.line4.xp"));
        Assert.assertEquals(s1, Q_JMB_WebElm.xpRetText(jmbProps, "cart.pc.heading.xp"));
        Assert.assertEquals(s2, Q_JMB_WebElm.xpRetText(jmbProps, "cart.pc.line1.xp"));
        Assert.assertEquals(s3, Q_JMB_WebElm.xpRetText(jmbProps, "cart.pc.line2.xp"));
        Assert.assertEquals(s4, Q_JMB_WebElm.xpRetText(jmbProps, "cart.pc.line3.xp"));
        Assert.assertEquals(s5, Q_JMB_WebElm.xpRetText(jmbProps, "cart.pc.line4.xp"));
        Q_JMB_WebElm.myWait(1000);
    }
    public  void achCartLanguage() {
        //    String s1= "Ships within 3-5 Business Days After Funds Clear";
        //     String s1= "Ships Wthin 3-5 Business Days Receipt of Payment";
        String s1= "Ships Within 3-5 Business Days After Receipt of Payment";
        String s2 = "eCheck (ACH) are approved for orders between $0.00 and $75,000.00.";
        String s3 = "Easier and Faster Than Paper Check";
        String s4 = "All eCheck (ACH) Orders Receive a 4% Discount vs. Card/PayPal Pricing";
        String s5 = "Pay Online Instantly by Linking Your Bank Account to Your JMB Account";
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.ach.heading.xp"));
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.ach.line1.xp"));
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.ach.line2.xp"));
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.ach.line3.xp"));
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.ach.line4.xp"));
        Assert.assertEquals(s1, Q_JMB_WebElm.xpRetText(jmbProps, "cart.ach.heading.xp"));
        Assert.assertEquals(s2, Q_JMB_WebElm.xpRetText(jmbProps, "cart.ach.line1.xp"));
        Assert.assertEquals(s3, Q_JMB_WebElm.xpRetText(jmbProps, "cart.ach.line2.xp"));
        Assert.assertEquals(s4, Q_JMB_WebElm.xpRetText(jmbProps, "cart.ach.line3.xp"));
        Assert.assertEquals(s5, Q_JMB_WebElm.xpRetText(jmbProps, "cart.ach.line4.xp"));
        Q_JMB_WebElm.myWait(1000);
    }
    public  void wireCartLanguage() {
        String s1= "Ships Within 1 Business Day";
        String s2 = "Bank Wires are approved for orders between $1,000.00 and $250,000.00. Order Confirmation Email will include all information necessary to complete payment.";
        String s3= "Fastest Method from Your Bank Account";
        //       String s4 = "All Bank Wire Orders Receive a 4% Discount Relative to Credit Card/Paypal Pricing";
        String s4 = "All Bank Wire Orders Receive a 4% Discount Relative to Card/Paypal Pricing";
        String s5 = "Bank Wires May Require a Trip to Your Bank. Must Send a Wire, not eCheck (ACH).";
        String s6 = "May Require a Credit Card on File to Lock in Pricing";
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.wire.heading.xp"));
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.wire.line1.xp"));
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.wire.line2.xp"));
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.wire.line3.xp"));
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.wire.line4.xp"));
        Q_JMB_WebElm.myWait(2000);
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "cart.wire.heading.xp"));
        Assert.assertEquals(s1, Q_JMB_WebElm.xpRetText(jmbProps, "cart.wire.heading.xp"));
        Assert.assertEquals(s2, Q_JMB_WebElm.xpRetText(jmbProps, "cart.wire.line1.xp"));
        Assert.assertEquals(s3, Q_JMB_WebElm.xpRetText(jmbProps, "cart.wire.line2.xp"));
        Assert.assertEquals(s4, Q_JMB_WebElm.xpRetText(jmbProps, "cart.wire.line3.xp"));
        Assert.assertEquals(s5, Q_JMB_WebElm.xpRetText(jmbProps, "cart.wire.line4.xp"));
        Assert.assertEquals(s6, Q_JMB_WebElm.xpRetText(jmbProps, "cart.wire.line5.xp"));
        Q_JMB_WebElm.myWait(1000);
    }
    public static void mmCoinSafeCoinTube(String quan){
        Q_JMB_CategoryObjects cat= new Q_JMB_CategoryObjects();
        Integer item = 1;
        Q_JMB_NavigationObjects.selectFromMenu("other");
        Q_JMB_NavigationObjects.innerMega("coin accessories");
        Q_JMB_CategoryObjects coin = new Q_JMB_CategoryObjects();
        coin.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        cat.itemDescription(item);
        coin.lineQty(item,quan);
        coin.atc(item);
        Q_JMB_WebElm.xp(jmbProps, "cart.modal.CheckoutNow.xp");
//        ExtentTestManager.getTest().log(LogStatus.INFO, "Added: " + quan + " ", itemDescription);
//        ExtentTestManager.getTest().log(LogStatus.INFO,  itemDescription, String.valueOf(modalCreditPrice()));
//        coin.modalContinue();
    }
    // Start JMB-5908
    public static float checkPrice() {
        float checkPrice = Float.valueOf(numberReturn("cart.products.listLowToHigh.Check.Price.xp"));
//        System.out.println("checkPrice " + checkPrice);
        return checkPrice;
    }
    public static float cryptoPrice() {
        float bitCoinPrice = Float.valueOf(numberReturn("cart.products.listLowToHigh.Bitcoin.Price.xp"));
//        System.out.println("bitCoinPrice " + bitCoinPrice);
        return bitCoinPrice;
    }
    public static float cardPrice(){
        float paypalPrice = Float.valueOf(numberReturn("cart.products.listLowToHigh.Paypal.Price.xp"));
//        System.out.println("paypalPrice " + paypalPrice);
        return paypalPrice;
    }
    public static void productPageListSortingPriceCheck(String sortype){
        Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
        Q_JMB_NavigationObjects.selectFromMenu("gold");
        Q_JMB_CartPageObjects.category("gold bars");

        Q_JMB_WebElm.myWait(1000);
        cart.formId("cart.products.list.id");

        switch (sortype){
            case ("lowToHigh"):
                float checkPrice1 = checkPrice();
                float bitCoinPrice1 = cryptoPrice();
                float paypalPrice1 = cardPrice();
                if (checkPrice1 < bitCoinPrice1 || bitCoinPrice1 < paypalPrice1) {
                    System.out.print("Modal Check / Wire Price(1): " + checkPrice1 + "\n" + "Modal Bitcoin / Bitcoin Cash Price: " + bitCoinPrice1 + "\n" + "Modal Credit Card Price: " + paypalPrice1 + "\n");
                } else {
                    System.out.print("Failed to verify payment method unit price in the modal");
                    System.out.println("\t Failed to verify payment method unit price in the modal");
                }
                break;
            case ("popularity"):
                Q_JMB_WebElm.idExecutor(jmbProps, "cart.products.popularity.id");
                System.out.println("Sorted Products Popularity wise");
                driver.navigate().refresh();
                float checkPrice2 = checkPrice();
                float bitCoinPrice2 = cryptoPrice();
                float paypalPrice2 = cardPrice();
                if (checkPrice2 < bitCoinPrice2 || bitCoinPrice2 < paypalPrice2) {
                    System.out.print("Modal Check / Wire Price(1): " + checkPrice2 + "\n" +
                            "Modal Bitcoin / Bitcoin Cash Price: " + bitCoinPrice2 + "\n" +
                            "Modal Credit Card Price: " + paypalPrice2 + "\n");
                } else {
                    System.out.print("Failed to verify payment method unit price in the modal");
                    System.out.println("\t Failed to verify payment method unit price in the modal");
                }
                break;
            case ("recently"):
                Q_JMB_WebElm.idExecutor(jmbProps, "cart.products.recently.id");
                System.out.println("Sorted Products Recently wise");
                driver.navigate().refresh();
                float checkPrice3 = checkPrice();
                float bitCoinPrice3 = cryptoPrice();
                float paypalPrice3 = cardPrice();
                if (checkPrice3 < bitCoinPrice3 || bitCoinPrice3 < paypalPrice3) {
                    System.out.print("Modal Check / Wire Price(1): " + checkPrice3 + "\n" +
                            "Modal Bitcoin / Bitcoin Cash Price: " + bitCoinPrice3 + "\n" +
                            "Modal Credit Card Price: " + paypalPrice3 + "\n");
                } else {
                    System.out.print("Failed to verify payment method unit price in the modal");
                    System.out.println("\t Failed to verify payment method unit price in the modal");
                }
                break;
            case ("highToLow"):
                Q_JMB_WebElm.idExecutor(jmbProps, "cart.products.highToLow.id");
                System.out.println("Sorted Products High To Low wise");
                driver.navigate().refresh();
                float checkPrice4 = checkPrice();
                float bitCoinPrice4 = cryptoPrice();
                float paypalPrice4 = cardPrice();
                if (checkPrice4 < bitCoinPrice4 || bitCoinPrice4 < paypalPrice4) {
                    System.out.print("Modal Check / Wire Price(1): " + checkPrice4 + "\n" +
                            "Modal Bitcoin / Bitcoin Cash Price: " + bitCoinPrice4 + "\n" +
                            "Modal Credit Card Price: " + paypalPrice4 + "\n");
                } else {
                    System.out.print("Failed to verify payment method unit price in the modal");
                    System.out.println("\t Failed to verify payment method unit price in the modal");
                }
                break;
            case ("weightAsc"):
                Q_JMB_WebElm.idExecutor(jmbProps, "cart.products.weightAsc.id");
                System.out.println("Sorted Products Weight Ascending wise");
                driver.navigate().refresh();
                float checkPrice5 = checkPrice();
                float bitCoinPrice5 = cryptoPrice();
                float paypalPrice5 = cardPrice();
                if (checkPrice5 < bitCoinPrice5 || bitCoinPrice5 < paypalPrice5) {
                    System.out.print("Modal Check / Wire Price(1): " + checkPrice5 + "\n" +
                            "Modal Bitcoin / Bitcoin Cash Price: " + bitCoinPrice5 + "\n" +
                            "Modal Credit Card Price: " + paypalPrice5 + "\n");
                } else {
                    System.out.print("Failed to verify payment method unit price in the modal");
                    System.out.println("\t Failed to verify payment method unit price in the modal");
                }
                break;
            case ("weightDesc"):

                Q_JMB_WebElm.idExecutor(jmbProps, "cart.products.weightDesc.id");
                System.out.println("Sorted Products Weight Descending wise");
                driver.navigate().refresh();
                float checkPrice6 = checkPrice();
                float bitCoinPrice6 = cryptoPrice();
                float paypalPrice6 = cardPrice();
                if (checkPrice6 < bitCoinPrice6 || bitCoinPrice6 < paypalPrice6) {
                    System.out.print("Modal Check / Wire Price(1): " + checkPrice6 + "\n" +
                            "Modal Bitcoin / Bitcoin Cash Price: " + bitCoinPrice6 + "\n" +
                            "Modal Credit Card Price: " + paypalPrice6 + "\n");
                } else {
                    System.out.print("Failed to verify payment method unit price in the modal");
                    System.out.println("\t Failed to verify payment method unit price in the modal");
                }
                break;
        }
    }
    public static void validatePriceHighToLow() {
        Q_JMB_WebElm.myWait(2000);
        DecimalFormat df = new DecimalFormat("#.00");
        Integer item;
        validateSortPriceHighToLow("cart.listViewProduct.beg.xp", "cart.listViewProductCheckPrice.end.xp");
        validateSortPriceHighToLow("cart.listViewProduct.beg.xp", "cart.listViewProductBitCoinPrice.end.xp");
        validateSortPriceHighToLow("cart.listViewProduct.beg.xp", "cart.listViewProductPayPalPrice.end.xp");

    }
    public static void validateSortPriceHighToLow(String begXp, String endXp){
        int count = Q_JMB_WebElm.xpCountTableDiv(jmbProps, "cart.ListViewProduct.xp");
        System.out.println("Count all divs " + count);
        for(int i = 1; i<4;i++) {
            Float priceList1 = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,begXp, i, endXp));
            for(int j= i+1; j <= 4 ;j++) {
                Float priceList2 = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,begXp, j, endXp));
                if(priceList1 >= priceList2) {
                    System.out.println("Check Price of product " + i + " is sorted from high to low :"+priceList1+ " greater than or equal to "+ j + " next product " +priceList2 );
                    break;
                }
            }
        }
    }
    public static void validateSortPriceLowToHigh(String begXp, String endXp){
        int count = Q_JMB_WebElm.xpCountTableDiv(jmbProps, "cart.ListViewProduct.xp");
        System.out.println("Count all divs " + count);
        for(int i = 1; i<4;i++) {
            Float priceList1 = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,begXp, i, endXp));
            for(int j= i+1; j <= 4 ;j++) {
                Float priceList2 = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,begXp, j, endXp));
                if(priceList1<=priceList2) {
                    System.out.println("Check Price of product " + i + " is sorted from high to low :"+priceList1+ " less than or equal to "+ j + " next product " +priceList2 );
                    break;
                }
            }
        }
    }
    public static void validatePriceLowToHigh() {
        Q_JMB_WebElm.myWait(2000);
        DecimalFormat df = new DecimalFormat("#.00");
        Integer item;
        validateSortPriceLowToHigh("cart.listViewProduct.beg.xp", "cart.listViewProductCheckPrice.end.xp");
        validateSortPriceLowToHigh("cart.listViewProduct.beg.xp", "cart.listViewProductBitCoinPrice.end.xp");
        validateSortPriceLowToHigh("cart.listViewProduct.beg.xp", "cart.listViewProductPayPalPrice.end.xp");

    }

    // End JMB-5908
    
    //JMB-7670 Start
    /**********************************************************************
     * Description:     Adds a product and navigate through URL
     * Author:          Paul Patterson
     * Param:      		String productURL, String qty
     * Returns:         None
     **********************************************************************/
	public void addProductByURL (String productURL, String qty) 
	{
		Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
		driver.navigate().to(baseUrl + productURL);
        cart.addProductpageItemToCart(Integer.parseInt(qty));
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
		Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
		Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();
		driver.navigate().to(baseUrl);
		prod.navigateToPLPPage (metalType, category1, category2, category3, category4);
		xp(jmbProps, "plp.productLink.beg.xp", productName, "plp.productLink.end.xp");
		cart.addProductpageItemToCart(Integer.parseInt(qty));
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
		Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();
		driver.navigate().to(baseUrl);
		prod.navigateToPLPPage (metalType, category1, category2, category3, category4);
		xpSend(jmbProps, "plp.product.beg.xp", productName, "plp.productQty.end.xp", qty);
		xp(jmbProps, "plp.product.beg.xp", productName, "plp.productAddToCart.end.xp");
		Q_JMB_WebElm.xp(jmbProps, "cart.modal.CheckoutNow.xp");
	}
	
	/**********************************************************************
     * Description:     Updates a specific item in the cart
     * Author:          Paul Patterson
     * Param:      		String productName, String qty
     * Returns:         None
     **********************************************************************/
	public void updateProductInCart (String productName, String qty) 
	{
		Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
		driver.navigate().to(baseUrl + "/cart/");
		cart.paymentType("cart.paymentType.PC.id");
		xpClear(jmbProps, "cart.product.beg.xp", productName, "cart.productQty.end.xp");
		xpSend(jmbProps, "cart.product.beg.xp", productName, "cart.productQty.end.xp", qty);
		xp(jmbProps, "cart.product.beg.xp", productName, "cart.productUpdateCart.end.xp");
	}
	
	/**********************************************************************
     * Description:     Deletes a specific item in the cart
     * Author:          Paul Patterson
     * Param:      		String productName, String qty
     * Returns:         None
     **********************************************************************/
	public void deleteProductInCart (String productName)
	{
		Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
		driver.navigate().to(baseUrl + "/cart/");
		cart.paymentType("cart.paymentType.PC.id");
		xp(jmbProps, "cart.product.beg.xp", productName, "cart.productRemove.end.xp");
	}
    //JMB-7670 End
	
	//JMB-7831-Start
	/********************************************************************
	 // * Description  : Verify Order subtotal in checkout page
	 // * Param        : NA
	 // * Jira Ticket  : JMB 7831
	 // * Status       : Completed
	 //*******************************************************************/
	public void validateOrderSubtotal() {
		Q_JMB_WebElm.myWait(5000);
		List<WebElement> listTotal=driver.findElements(By.xpath("//td[contains(@class,'product-subtotal')]/p/span"));
		double total=0.00;
		for (WebElement i : listTotal) {
			String totalString=i.getText().substring(1);
			double totalDouble= Double.parseDouble(totalString.replaceAll(",", ""));
			total= total + totalDouble;
		}
		String expectedOrderTotal=new DecimalFormat("#.##").format(total);
		String actualOrderTotal=Q_JMB_WebElm.xpRetText(jmbProps, "cart.subtotal.xp").replaceAll(",", "").replaceAll("$", "");
		Assert.assertTrue(actualOrderTotal.contains(expectedOrderTotal), "Subtotal issue Acutal: "+actualOrderTotal+" Expected: "+expectedOrderTotal);
		System.out.println("Subtotal validated succesfully");
	}
	//JMB-7831-End
	
	/************************************************************
	// * Description : To select Paypal as payment type (updated the existing method)
	// * Param       : NA
	// * Jira Ticket : JMB 7654
	// * Status      : Completed 
	//***********************************************************/ 	
	public void selectPaymentType(String payWith) {
		Q_JMB_WebElm.myWait(2000);
		try {
			switch (payWith) {
			case "credit card":
				Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.CC.id");
				break;
			case "paypal":
				Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.PP.id");
				break;
			case "echeck":
				Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.EC.id");
				break;
			case "cheque":
				Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.PC.id");
				break;
			case "wire":
				Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.BW.id");
				break;
			case "bitpay":
				Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.BC.id");
				break;
			case "paypalexpress":
				Q_JMB_WebElm.xp(jmbProps, "cart.paymentType.PP.xp");
				break;   
			default:
				System.out.println("Invalid Payment type");
				break;
			}
		} catch (Throwable ex) {
			System.out.println("Failed to select payment");
		}
	}
}
