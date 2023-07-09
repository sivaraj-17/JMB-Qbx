package pageObjects;

import jsonWrappers.AddressContainer;
import jsonWrappers.CreditContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Q_Slv_CheckoutSteps extends Q_Slv_Init {
	
    //@Step
    public static void guestCheckoutEx(String paymentType, String chkOutBtn, String guestCheckBtn, String emailLocator, String emailValue, String modalLocator){
        Q_Slv_WebElm.idExecutor(SLVqProp,paymentType);
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.xp(SLVqProp, chkOutBtn);
        Q_Slv_WebElm.xp(SLVqProp, guestCheckBtn);
        guestEmail(emailLocator, emailValue);
        Q_Slv_WebElm.myWait(4000);
        try {
            Assert.assertTrue(Q_Slv_WebElm.cnEnabled(SLVqProp, modalLocator).equals(true));
            driver.navigate().to(baseUrl + "/cart");
            Q_Slv_CartSteps.emptyCart();
            System.out.println("Guest user using a registered email");
        }
        catch (Throwable ex){
            System.out.println("Failed to verify existing email test");
            Assert.fail("Failed to verify existing email test");
        }


    }
    //@Step
    public static void guestCheckout(String paymentType, String chkOutBtn, String guestCheckBtn) {
        Q_Slv_WebElm.id(SLVqProp, paymentType);
        Q_Slv_WebElm.myWait(1000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='button_area']/a/div")));
        Q_Slv_WebElm.xp(SLVqProp, chkOutBtn);
        Q_Slv_WebElm.xp(SLVqProp, guestCheckBtn);

    }

    //@Step
    public static void guestEmail(String locator, String emailValue){
        Q_Slv_WebElm.idSend(SLVqProp,locator, emailValue);
    }
    //@Step
    public static void guestcdName(String locator, String cdName){
        Q_Slv_WebElm.idSend(SLVqProp,locator, cdName);
    }


    public static void newCreditCard(){
        Q_Slv_WebElm.xp(SLVqProp, "chk.addNewCreditCard.xp");
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "chk.reg.newcard.id"));
    }
    public static void creditCardInput(Integer index) throws FileNotFoundException {
        CreditContainer card = new CreditContainer(index);
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.card.cardName.id", card.cdName);
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_WebElm.idSendTab(SLVqProp, "chk.guest.card.cardName.id");
//        WebElm.idClear(SLVqProp, cdNumber);
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.card.cardNumber.id", card.cdNumber);
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.idSelectValue(SLVqProp, "chk.guest.card.month.id", card.monthV);
        Q_Slv_WebElm.idSendTab(SLVqProp, "chk.guest.card.month.id");
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.idSelectIndex(SLVqProp, "chk.guest.card.yesr.id", card.year);
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.card.cvv.id", card.code);
    }

    //@Step
    public static void guestShippingAutoSectionInput(String fnLocator, String firstName, String lnLocator, String lastName, String streeetLocator, String street, String cityLocator, String city,
                                                     String statelocator, Integer state, String zipLocator, String zipcode, String phLocator, String phoneNumber){


    }
    public static void shippingAutoAddress(Integer index) throws FileNotFoundException {
        AddressContainer ship = new AddressContainer(index);

        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.shipping.firstName.id", ship.firstName);
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.shipping.lastName.id", ship.lastName);
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.shipping.address.id", ship.street);
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.idSendTab(SLVqProp, "chk.guest.shipping.address.id");
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.idSendTab(SLVqProp, "chk.guest.shipping.address.id");
//        WebElm.id(SLVqProp,"guestCheckout.guest.shipping.firstName.id");
//        WebElm.id(SLVqProp,"guestCheckout.guest.shipping.lastName.id");
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.idClear(SLVqProp, "chk.guest.shipping.city.id");
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.shipping.city.id", ship.city);

        Q_Slv_WebElm.idSelectValue(SLVqProp, "chk.guest.shipping.state.id", ship.state);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS.SECONDS);
        //JavascriptExecutor executor = (JavascriptExecutor)driver;executor.executeScript("arguments[0].clear()",(driver.findElement(By.id(SLVqProp.getProperty("guestCheckout.guest.shipping.zip.id")))));
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.idClear(SLVqProp, "chk.guest.shipping.zip.id");
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.shipping.zip.id", ship.zipcode);
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.shipping.phone.id", ship.phoneNumber);
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_Controls.scrolDownPixel(200);
        guestSaveShippingAddress("chk.guest.shipping.validate.xp", "chk.guest.shipping.error.xp", "chk.guest.shipping.ContinueWithAdd.xp");

    }
    //@Step
    public static void editShippingFile(String editShipAddress2, String fnLocator, String firstName, String lnLocator, String lastName) throws FileNotFoundException {
        Q_Slv_WebElm.xp(SLVqProp, "chk.reg.shaddress2.editBtn.xp");
        Q_Slv_WebElm.idClear(SLVqProp, fnLocator);
        Q_Slv_WebElm.idSend(SLVqProp, fnLocator, firstName);
        Q_Slv_WebElm.idClear(SLVqProp, lnLocator);
        Q_Slv_WebElm.idSend(SLVqProp, lnLocator, lastName);

    }

    public static void guestSaveShippingAddress(String saveAddress, String errorMsg, String forceSaveAddress){
        try {
            Q_Slv_WebElm.xpDisplayed(SLVqProp,saveAddress);
            Q_Slv_WebElm.xp(SLVqProp,saveAddress);
            Q_Slv_WebElm.myWait(1000);
            System.out.println("Successfully detected and auto filled shipping address");

        }
        catch (Throwable ex){
            System.out.println("Auto correct save address not present");
            //WebElm.myWait(1000);
        }

        try{
            Q_Slv_WebElm.myWait(1000);
            Q_Slv_WebElm.xpDisplayed(SLVqProp, errorMsg);
            Q_Slv_WebElm.xpDisplayed(SLVqProp,forceSaveAddress);
            Q_Slv_WebElm.xp(SLVqProp,forceSaveAddress);
            Q_Slv_WebElm.myWait(1000);
        }
        catch (Throwable ex){
            System.out.println("Force saving shipping address failed");
        }


    }


    public static List<Float> revPriceListNoTax() {
        Q_Slv_WebElm.myWait(5000);
        List<Float> priceList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.subtotal.id").replaceAll("[^0-9?!\\.]",""));
        priceList.add(subtotal);
        Float shipping = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.shipping.id").replaceAll("[^0-9?!\\.]",""));
        priceList.add(shipping);
        Float total = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.total.id").replaceAll("[^0-9?!\\.]",""));
        priceList.add(total);
        System.out.println("Review Page List " + priceList);
        return priceList;
    }

    public static List<Float> orderPriceListNoTax() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("thank_top")));
//        WebElm.xpElement(SLVqProp, "linkToOrder.xp");

        List<Float> orderList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.order.orderSubtotal.id").replaceAll("[^0-9?!\\.]",""));
        orderList.add(subtotal);
        Float shipping = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.order.orderShipping.id").replaceAll("[^0-9?!\\.]","0"));
        orderList.add(shipping);

        Float total = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.order.orderTotal.id").replaceAll("[^0-9?!\\.]",""));
        orderList.add(total);
        System.out.println("Order complete list"  + orderList);
        return orderList;
    }

    public static List<Float> revPriceListTax() {
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_Controls.scrolDownPixel(300);
        List<Float> priceList = new ArrayList<Float>();

        float subtotal = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.subtotal.id").replaceAll("[^0-9?!\\.]",""));
        priceList.add(subtotal);
        float shipping = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.shipping.id").replaceAll("[^0-9?!\\.]",""));
        priceList.add(shipping);
        float tax = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.tax.id").replaceAll("[^0-9?!\\.]",""));
        priceList.add(tax);

        float total = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.total.id").replaceAll("[^0-9?!\\.]",""));
        priceList.add(total);
        System.out.println("Review Page List " + priceList);
        return priceList;
    }

    public static List<Float> orderPriceListTax() {
        Q_Slv_WebElm.myWait(5000);
//        WebElm.xpElement(SLVqProp, "linkToOrder.xp");

        List<Float> orderList = new ArrayList<Float>();
        Q_Slv_WebElm.myWait(2000);
        Float subtotal = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.order.orderSubtotal.id").replaceAll("[^0-9?!\\.]",""));
        orderList.add(subtotal);

        Float shipping = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.order.orderShipping.id").replaceAll("[^0-9?!\\.]","0"));
        orderList.add(shipping);
        Float orderTax = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.order.orderSalesTax.id").replaceAll("[^0-9?!\\.]",""));
        orderList.add(orderTax);
        Float total = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.order.orderTotal.id").replaceAll("[^0-9?!\\.]",""));
        orderList.add(total);
        System.out.println("Order complete list"  + orderList);
        return orderList;
    }
    // @Step
    public static List<Float> revPriceListSh() {
        Q_Slv_WebElm.myWait(2000);
        DecimalFormat df = new DecimalFormat("#.00");

        List<Float> revList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.subtotal.id").replaceAll("[^0-9?!\\.]",""));

        String subtax = df.format(Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.tax.id").replaceAll("[^0-9?!\\.]","")));
        String shTax = df.format(Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.Shiptax.id").replaceAll("[^0-9?!\\.]","")));
        System.out.println("Merchendise tax: " + subtax +"\n" + "Shipping Tax: " + shTax);
        Float tax1 = Float.valueOf(subtax);
        Float tax2 = Float.valueOf(shTax);

        String taxTotal = String.format("%.2f", tax1 + tax2);
//        System.out.println(taxTotal);
        Float tax = Float.valueOf(taxTotal);
        System.out.println("total tax   " + tax);


        Float shipping = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.shipping.id").replaceAll("[^0-9?!\\.]","0"));
        Float total = Float.valueOf(Q_Slv_WebElm.idRetText(SLVqProp, "chk.reviewOrder.total.id").replaceAll("[^0-9?!\\.]",""));
        revList.add(subtotal);
        revList.add(shipping);
        revList.add(tax);
        revList.add(total);
        return revList;
    }
    
    public static void attemptOrder(String tcName) {
        Q_Slv_WebElm.xp(SLVqProp, "chk.sil.consent.xp");
        Q_Slv_WebElm.id(SLVqProp, "chk.finishAndPlace.id");
        Q_Slv_WebElm.myWait(2000);
        System.out.println("Error message " + Q_Slv_WebElm.cnRetText(SLVqProp, "chk.woocommerceError.cn"));
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_Controls.captureScreen(driver, tcName);

    }
    public static void completeOrder() {
        try{
            Q_Slv_WebElm.xp(SLVqProp, "chk.sil.consent.xp");
            Q_Slv_WebElm.id(SLVqProp, "chk.finishAndPlace.id");
            Q_Slv_WebElm.myWait(1000);
            System.out.println("Order Number :" + Q_Slv_WebElm.xpRetText(SLVqProp, "chk.orderNumber.xp"));
        }
        catch (Exception e){
            System.out.println("Failed at complete order");
            System.out.println("Error message " + Q_Slv_WebElm.cnRetText(SLVqProp, "chk.woocommerceError.cn"));
        }
    }
    public static void validateErrorrMsg(String expected){
        Assert.assertEquals(Q_Slv_WebElm.cnRetText(SLVqProp, "chk.woocommerceError.cn"),expected);
    }
    public static void validateErrorrMsgContains(String expected){
        Assert.assertTrue(Q_Slv_WebElm.cnRetText(SLVqProp, "chk.woocommerceError.cn").contains(expected));
    }
    public static void completeOrder(String locator) {
        Q_Slv_Controls.scrolDownPixel(400);
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.xp(SLVqProp, "chk.sil.consent.xp");
        Q_Slv_WebElm.id(SLVqProp, locator);
        try{
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sa_close")));
            Assert.assertFalse(Q_Slv_WebElm.idDisplayed(SLVqProp, "chk.complete.rateUs.id").equals(true));
            Q_Slv_WebElm.idRetText(SLVqProp, "chk.complete.rateUs.id");
        }
        catch (Exception e){
            System.out.println("Shopper approved not presented");

        }
    }
    public static  void checkoutModal(String tcName){
        Q_Slv_WebElm.xp(SLVqProp, "chk.sil.consent.xp");
        Q_Slv_WebElm.id(SLVqProp, "chk.finishAndPlace.id");
        Q_Slv_WebElm.myWait(1000);

        driver.switchTo().frame("step-up-iframe");
//        System.out.println(WebElm.xpRetText(SLVqProp, "text.xp"));
        WebElement frameElement = driver.findElement(By.xpath("/html/body/div[1]/div/iframe"));
        driver.switchTo().frame(frameElement);
        Q_Slv_WebElm.myWait(1000);
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "chk.checkoutModalChallenge.xp").toString());
        Q_Slv_WebElm.xpClear(SLVqProp, "chk.checkoutModalChallenge.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "chk.checkoutModalChallenge.xp", "1234");
        Q_Slv_WebElm.xp(SLVqProp, "chk.checkoutModalSubmit.xp");
        //Q_Slv_Controls.captureScreen(driver, tcName);
        Q_Slv_WebElm.myWait(5000);
        try {
			Q_Slv_WebElm.myWait(1000);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			//exception handling
			System.out.println("Recovering from exception when handling switching from frame due to detached frame.");
		}
    }
    public static  void checkoutModalError(){
        Q_Slv_WebElm.xp(SLVqProp, "chk.sil.consent.xp");
        Q_Slv_WebElm.id(SLVqProp, "chk.finishAndPlace.id");
        Q_Slv_WebElm.myWait(1000);

        driver.switchTo().frame("step-up-iframe");
//        System.out.println(WebElm.xpRetText(SLVqProp, "text.xp"));
        WebElement frameElement = driver.findElement(By.xpath("/html/body/div[1]/div/iframe"));
        driver.switchTo().frame(frameElement);
        Q_Slv_WebElm.myWait(1000);
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "chk.checkoutModalChallenge.xp").toString());
        Q_Slv_WebElm.xpClear(SLVqProp, "chk.checkoutModalChallenge.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "chk.checkoutModalChallenge.xp", "1234");
        Q_Slv_WebElm.xp(SLVqProp, "chk.checkoutModalSubmit.xp");
        try {
			Q_Slv_WebElm.myWait(1000);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			//exception handling
			System.out.println("Recovering from exception when handling switching from frame due to detached frame.");
		}
        Q_Slv_WebElm.myWait(4000);

    }
    public static void modalErrorMsg(String tcName){
        driver.switchTo().frame("step-up-iframe");
        System.out.println("modal error " + Q_Slv_WebElm.xpRetText(SLVqProp, "chk.checkoutModalErrorText.xp"));
        //Q_Slv_Controls.captureScreen(driver, tcName);
        try {
			Q_Slv_WebElm.myWait(1000);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			//exception handling
			System.out.println("Recovering from exception when handling switching from frame due to detached frame.");
		}
    }
    public static void isOrderComplete(String tcName){
        Q_Slv_WebElm.myWait(3000);
        System.out.println(driver.getCurrentUrl());
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "chk.orderNumber.xp"));
        Q_Slv_Controls.captureScreen(driver, tcName);
        Assert.assertEquals(Q_Slv_WebElm.xpRetText(SLVqProp, "chk.thankYou.xp"), "Thank you for your order!");
    }

    public static void verifyOrderCharges(List revCharges, List orderCharges, int procuctCountOffset) {
        System.out.println("Review Page " + revCharges);
        System.out.println("Order Page " + orderCharges);

        for(int i=0; i < orderCharges.size(); i++){
            System.out.println("Review Page " + Q_Slv_WebElm.xpRetText(SLVqProp, "chk.begOrderCharges.xp", (i+procuctCountOffset), "chk.endOrderCharges.xp")/*.replaceAll("[0-9!@#$%^&*()Free_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]", "")*/ + " "+ revCharges.get(i));
            System.out.println("Order Page  " + Q_Slv_WebElm.xpRetText(SLVqProp, "chk.begOrderCharges.xp", (i+procuctCountOffset), "chk.endOrderCharges.xp")/*.replaceAll("[0-9!@#$%^&*()Free_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]", "") */ + " "+  orderCharges.get(i));
            Assert.assertEquals(revCharges.get(i), orderCharges.get(i));
        }

    }

    public static void isWoocommerceErrorDisplayed(){
        Assert.assertTrue(Q_Slv_WebElm.cnDisplayed(SLVqProp, "chk.woocommerceError.cn").equals(true));
        System.out.println("Error message " + Q_Slv_WebElm.cnRetText(SLVqProp, "chk.woocommerceError.cn"));
    }

    public static void reviewPageNoTax(){
//        WebElm.xpElement(SLVqProp, "sil.agree.xp");
        float revShipping = 0f;
        float revTax = 0f;
        float revSubtotal = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp, "chk.reviewOrder.subtotal.id"));
        try{
            Assert.assertTrue(Q_Slv_WebElm.idDisplayed(SLVqProp, "chk.reviewOrder.shipping.id"));
            revShipping = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp, "chk.reviewOrder.shipping.id"));
        }
        catch (Throwable ex){
            System.out.println("No shipping charges for this order" );
        }
        float revTotal = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp, "chk.reviewOrder.total.id"));
        System.out.println("Order review subtotal:  " + revSubtotal);
        System.out.println("Order review shipping charges:  " + revShipping);
        System.out.println("Order review sales tax:  " + revTax);
        System.out.println("Order review total:  " + revTotal);

        Q_Slv_WebElm.idExecutor(SLVqProp, "chk.finishAndPlace.id");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        //wait.until(ExpectedConditions.titleContains("Order Received | Silver.com"));
        //Assert.assertTrue(driver.getTitle().contains("Order Received | Silver.com"));

        Q_Slv_OrderCompleteSteps.closeRateUs();
        float orderShipping = 0f;
        float orderTax = 0f;
        float orderSubtotal = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp, "chk.order.orderSubtotal.id"));
        try{
            Assert.assertTrue(Q_Slv_WebElm.idDisplayed(SLVqProp, "chk.order.orderShipping.id"));
            orderShipping = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp, "chk.order.orderShipping.id"));
        }
        catch (Throwable ex){
            System.out.println("No shipping charges for this order" );
        }

        float orderTotal = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp, "chk.order.orderTotal.id"));
        System.out.println("Order complete subtotal:  " + orderSubtotal);
        System.out.println("Order complete shipping charges:  " + orderShipping);
        System.out.println("Order complete sales tax:  " + orderTax);
        System.out.println("Order complete total:  " + orderTotal);
        Assert.assertEquals(revSubtotal,orderSubtotal);
        Assert.assertEquals(revShipping,orderShipping);
        //Assert.assertEquals(revTax,orderTax);
        Assert.assertEquals(revTotal,orderTotal);

    }
    //@Step
    public static void regCheckout(String paymentType, String chkOutBtn, String title) {
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_WebElm.id(SLVqProp, paymentType);
        Q_Slv_WebElm.myWait(8000);
//        WebElm.id(SLVqProp, chkOutBtn);
        Q_Slv_WebElm.xp(SLVqProp, chkOutBtn);
        //WebDriverWait wait = new WebDriverWait(driver, 60);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.no-morgin:nth-child(1) > div:nth-child(2) > p:nth-child(2)")));

        Q_Slv_WebElm.myWait(2000);
//        Assert.assertTrue(driver.getTitle().contains(title));
    }

    public static void cardType(Integer cvvIndex, String selectedCard, String cvvlocator) throws Exception {
        //WebElm.myWait(5000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("authorize-net-cim-payment-profile-id")));

        String cardTypeText = Q_Slv_WebElm.xpRetText(SLVqProp, selectedCard);
        System.out.println("Selected Card " + cardTypeText);
//        System.out.println(WebElm.xpElementRetText(SLVqProp, "sil.selected.xp"));
        CreditContainer cvv = new CreditContainer(cvvIndex);
        Q_Slv_WebElm.myWait(1000);
        if (cardTypeText.contains("American Express")) {
            Q_Slv_WebElm.xpClear(SLVqProp,cvvlocator);
            Q_Slv_WebElm.xpSend(SLVqProp,cvvlocator, cvv.code);
            //Log.info("\t Verified master card holder can complete order and checkout successfully");
            System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, selectedCard));
        }

        else if (cardTypeText.contains("MC")){
            Q_Slv_WebElm.xpClear(SLVqProp,cvvlocator);
            Q_Slv_WebElm.xpSend(SLVqProp,cvvlocator, cvv.code);
            System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, selectedCard));
//            System.out.println(WebElm.xpElementRetText(SLVqProp, selectedCard).substring(0, 26));
        }

        else if (cardTypeText.contains("Visa")) {
            Q_Slv_WebElm.xpClear(SLVqProp,cvvlocator);
            Q_Slv_WebElm.xpSend(SLVqProp,cvvlocator, cvv.code);
            //Log.info("\t Verified master card holder can complete order and checkout successfully");
            System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, selectedCard));
        }

        else if (cardTypeText.contains("Discover")){
            Q_Slv_WebElm.xpClear(SLVqProp,cvvlocator);
            Q_Slv_WebElm.xpSend(SLVqProp,cvvlocator, cvv.code);
            //Log.info("\t Verified master card holder can complete order and checkout successfully");
            System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, selectedCard));
        }
        else{
            System.out.println("No credit card on file");
        }
    }
    //@Step
    public static void orderStatus(String confirmOrderNumber, String accOrderNoTop, String orderStatus,String expectedstatus ){
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, confirmOrderNumber));
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, confirmOrderNumber).replaceAll("[^0-9?!\\.]",""));
        String orderNo = Q_Slv_WebElm.xpRetText(SLVqProp, confirmOrderNumber).replaceAll("[^0-9?!\\.]","");
        Q_Slv_AccountSteps.myAccount();
        String topOrdreNo = Q_Slv_WebElm.xpRetText(SLVqProp,accOrderNoTop).replaceAll("[^0-9?!\\.]","");
        String status = Q_Slv_WebElm.xpRetText(SLVqProp, orderStatus);
        //Assert.assertEquals(orderNo, topOrdreNo);
        Assert.assertTrue(orderNo.contains(topOrdreNo));
        System.out.println("Verified order status for order number: " + orderNo + "\t status is: " + expectedstatus);
        Assert.assertEquals(Q_Slv_WebElm.xpRetText(SLVqProp, orderStatus), expectedstatus);


    }

    //@Step
    public static void switchCard(String switchedCard,String selectedPayment, String inactive1, String inactive2){
        Q_Slv_WebElm.myWait(1000);
        System.out.println("selected " + Q_Slv_WebElm.nameSelected(SLVqProp, selectedPayment).toString());
        try{
            Assert.assertTrue(Q_Slv_WebElm.nameSelected(SLVqProp, selectedPayment));
            Q_Slv_WebElm.xpExecutor(SLVqProp, inactive2);

        }
        catch (Throwable ex){
            Q_Slv_WebElm.xp(SLVqProp, inactive1);
        }
        System.out.println("Switched selected card: " + Q_Slv_WebElm.xpRetText(SLVqProp, switchedCard));
    }
    public static void switchCard(String cardType, String ccv){
        switch(cardType){
            case "visa":
                Q_Slv_WebElm.myWait(1000);
                Q_Slv_WebElm.xp(SLVqProp, "chk.visa.xp");
                ccvCode(ccv);
                break;
            case "mc":
                Q_Slv_WebElm.myWait(1000);
                Q_Slv_WebElm.xp(SLVqProp, "chk.masterCard.xp");
                ccvCode(ccv);
                break;
            case "amex":
                Q_Slv_WebElm.myWait(1000);
                Q_Slv_WebElm.xp(SLVqProp, "chk.amex.xp");
                ccvCode(ccv);
                break;
            default:
                System.out.println("card type incorrect or not supported");
        }
    }
    public static void ccvCode(String ccv) {
            Q_Slv_WebElm.xpClear(SLVqProp, "chk.cvv.xp");
            Q_Slv_WebElm.xpSend(SLVqProp, "chk.cvv.xp", ccv);
    }
    //@Step
    public static void switchAddress(String selectedAddress, String shAddressAccept,String shAddressReview){
        if(Q_Slv_WebElm.nameSelected(SLVqProp, selectedAddress).equals(true)){
            Q_Slv_WebElm.xpExecutor(SLVqProp, shAddressReview);
            System.out.print("Switched shipping address to 4108 Honeysuckle Dr \n");
        }
        else{
            Q_Slv_WebElm.xpExecutor(SLVqProp, shAddressAccept);
            System.out.print("Switched shipping address to 4106 Honeysuckle Dr \n");
        }
    }
    //@Step
    public static void editShipping(String editShipAddress2,String shippingAddress2,String fnLocator, String lnLocator) {
        Q_Slv_WebElm.xp(SLVqProp, editShipAddress2);
        System.out.println("Shipping Address is " + Q_Slv_WebElm.xpRetAttr(SLVqProp, shippingAddress2, "value"));
        if(Q_Slv_WebElm.xpRetAttr(SLVqProp, shippingAddress2, "value").compareTo("4108 Honeysuckle Dr")==0){
            Q_Slv_WebElm.xpClear(SLVqProp, shippingAddress2);
            Q_Slv_WebElm.xpSend(SLVqProp,shippingAddress2,"4106 Honeysuckle Dr");
            Q_Slv_WebElm.myWait(1000);
            Q_Slv_WebElm.id(SLVqProp, fnLocator);
            Q_Slv_WebElm.id(SLVqProp, lnLocator);
            System.out.println("Shipping Address reset to 4106 Honeysuckle Dr");
            Q_Slv_WebElm.xp(SLVqProp, "chk.guest.shipping.validate.xp");
        }
        else {
            Q_Slv_WebElm.myWait(1000);
            Q_Slv_WebElm.xpClear(SLVqProp, shippingAddress2);
            Q_Slv_WebElm.xpSend(SLVqProp, shippingAddress2, "4108 Honeysuckle Dr");
            Q_Slv_WebElm.myWait(3000);
            Q_Slv_WebElm.id(SLVqProp, fnLocator);
            //WebElm.id(SLVqProp, lnLocator);
            System.out.println("Shipping address switched back to  4108 Honeysuckle Dr");
            Q_Slv_WebElm.xp(SLVqProp, "chk.guest.shipping.validate.xp");
        }
        Q_Slv_Controls.scrolDownPixel(400);

        if (Q_Slv_WebElm.xpDisplayed(SLVqProp, "chk.guest.shipping.error.xp").equals(true)){
            Q_Slv_WebElm.xpDisplayed(SLVqProp, "chk.guest.shipping.ContinueWithAdd.xp");
            Q_Slv_WebElm.xp(SLVqProp, "chk.guest.shipping.ContinueWithAdd.xp");
        }

    }
    //@Step
    public static void regEcheckForm(){
//        WebElm.idSend(SLVqProp, "sil.reg.echeck.routing.id", "031202084");
//        WebElm.xpElementSend(SLVqProp, "sil.reg.echeck.acc1.xp","8675309");
//        WebElm.xpElementSend(SLVqProp, "sil.reg.echeck.acc2.xp","8675309");
//        WebElm.xpElement(SLVqProp, "sil.reg.echeck.auth.xp");
        Q_Slv_WebElm.xp(SLVqProp, "chk.reg.topAch.xp");
    }

    //@Step
    public static void shippingOption(String option){
        Q_Slv_WebElm.myWait(1000);
        switch(option){
            case "1":
                Q_Slv_WebElm.xp(SLVqProp, "chk.reg.option1.xp");

                Assert.assertTrue(Q_Slv_WebElm.xpSelected(SLVqProp, "chk.reg.option1.xp"));
                Q_Slv_WebElm.myWait(1000);
                break;
            case "2":
                Q_Slv_WebElm.xp(SLVqProp, "chk.reg.option2.xp");
                Assert.assertTrue(Q_Slv_WebElm.xpSelected(SLVqProp, "chk.reg.option2.xp"));
                Q_Slv_WebElm.myWait(1000);
                break;
            case "3":
                Q_Slv_WebElm.xp(SLVqProp, "chk.reg.option3.xp");
                Assert.assertTrue(Q_Slv_WebElm.xpSelected(SLVqProp, "chk.reg.option3.xp"));
                Q_Slv_WebElm.myWait(1000);
                break;
            default:
                System.out.println("Invalid Shipping Option");
                break;

        }
    }
    //@Step
    public static void shippingOptionValue(String option, String charges){
        Q_Slv_WebElm.myWait(5000);
        Q_Slv_WebElm.xp(SLVqProp,option);
        Q_Slv_WebElm.myWait(1000);
        String xp = Q_Slv_WebElm.xpRetText(SLVqProp, charges);
        System.out.println(xp);
        Assert.assertTrue(Q_Slv_WebElm.xpSelected(SLVqProp,option));

    }
    //@Step
    public static void payPalCheckout(String paymentType, String chkOutBtn) {
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_WebElm.idExecutor(SLVqProp, paymentType);
        Q_Slv_WebElm.myWait(3000);
        Q_Slv_WebElm.cn(SLVqProp, chkOutBtn);
        Q_Slv_WebElm.myWait(5000);
        try{
//        if(WebElm.xpElementDisplayed(SLVqProp,"paypal.alt.login.xp").equals(true)){
            Q_Slv_WebElm.xp(SLVqProp, "chk.paypal.alt.login.xp");
        }
        catch (Throwable ex){
            System.out.println("Continue to PayPal");

        }

    }
    //@Step
    public static void pplogout(){
        driver.navigate().to("https://www.sandbox.paypal.com/myaccount/home");
        Q_Slv_WebElm.id(SLVqProp, "chk.paypal.checkout.pplogout.id");
    }
    //@Step
    public static void payPal( String emailValue, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        Q_Slv_WebElm.myWait(3000);
        Q_Slv_WebElm.xp(SLVqProp, "chk.paypal.cookie.btn.xp");
        Q_Slv_WebElm.idClear(SLVqProp, "chk.paypal.checkout.ppEmail.id");
        Q_Slv_WebElm.idSend(SLVqProp, "chk.paypal.checkout.ppEmail.id", emailValue);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNext")));
        Q_Slv_WebElm.id(SLVqProp, "chk.paypal.checkout.ppNext.id");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        Q_Slv_WebElm.idClear(SLVqProp, "chk.paypal.checkout.ppPass.id");
        Q_Slv_WebElm.idSend(SLVqProp, "chk.paypal.checkout.ppPass.id", password);
        Q_Slv_WebElm.id(SLVqProp, "chk.paypal.checkout.ppLogin.id");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmButtonTop")));
        Q_Slv_WebElm.id(SLVqProp, "chk.paypal.checkout.ppContinue.id");
        wait.until(ExpectedConditions.titleContains("Review Order | Silver.com"));

    }
    //@Step
    public static void payPalNext( String emailValue, String password) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        Q_Slv_WebElm.idClear(SLVqProp, "chk.paypal.checkout.ppEmail.id");
        Q_Slv_WebElm.idSend(SLVqProp, "chk.paypal.checkout.ppEmail.id", emailValue);
        Q_Slv_WebElm.id(SLVqProp, "chk.paypal.checkout.ppNext.id");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        Q_Slv_WebElm.idClear(SLVqProp, "chk.paypal.checkout.ppPass.id");
        Q_Slv_WebElm.idSend(SLVqProp, "chk.paypal.checkout.ppPass.id", password);
        Q_Slv_WebElm.id(SLVqProp, "chk.paypal.checkout.ppLogin.id");
        Q_Slv_WebElm.myWait(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment-submit-btn")));
        Q_Slv_WebElm.idExecutor(SLVqProp, "chk.paypal.checkout.ppContinue.id");
//        WebElm.myWait(3000);
//        WebElm.idExecutor(SLVqProp, "paypal.checkout.ppContinue.id");
        Q_Slv_WebElm.myWait(5000);
    }
    //@Step
    public static void reviewPagePayPal(String tax) {
        Assert.assertTrue(driver.getTitle().contains("PayPal Checkout"));
        Q_Slv_WebElm.xp(SLVqProp, "chk.agree.xp");
        Q_Slv_WebElm.myWait(2000);
        float revShipping = 0.00f;
        float revTax = 0.00f;
        float revSubtotal = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp, "chk.reviewOrder.subtotal.id"));
        try{
            Assert.assertTrue(Q_Slv_WebElm.idDisplayed(SLVqProp, "chk.reviewOrder.shipping.id"));
            revShipping = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp, "chk.reviewOrder.shipping.id"));
        }
        catch (Throwable ex){
            System.out.println("No shipping charges for this order" );
        }
        try {
            // if(WebElm.idDisplayed(SLVqProp,"checkout.guest.reviewOrder.tax.id").equals(true));
            // revTax = Float.valueOf(WebElm.idRetTextRep(SLVqProp, "checkout.guest.reviewOrder.tax.id"));
            Assert.assertTrue(Q_Slv_WebElm.idDisplayed(SLVqProp,tax));
            revTax = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp, tax));
        }
        catch (Throwable ex){
            System.out.println("No sales tax for this order" );
        }

        float revTotal = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp, "chk.reviewOrder.total.id"));
        System.out.println("Order review subtotal:  " + revSubtotal);
        System.out.println("Order review shipping charges:  " + revShipping);
        System.out.println("Order review sales tax:  " + revTax);
        System.out.println("Order review total:  " + revTotal);

        Q_Slv_WebElm.idExecutor(SLVqProp, "chk.finishAndPlace.id");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.titleContains("Order Received | Silver.com"));
        Assert.assertTrue(driver.getTitle().contains("Order Received | Silver.com"));
        Q_Slv_OrderCompleteSteps.closeRateUs();
        float orderShipping = 0f;
        float orderTax = 0f;
        float orderSubtotal = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp, "chk.order.orderSubtotal.id"));
        try{
            Assert.assertTrue(Q_Slv_WebElm.idDisplayed(SLVqProp, "chk.order.orderShipping.id"));
            orderShipping = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp, "chk.order.orderShipping.id"));
        }
        catch (Throwable ex){
            System.out.println("No shipping charges for this order" );
        }
        try {
            Assert.assertTrue(Q_Slv_WebElm.idDisplayed(SLVqProp, "chk.order.orderSalesTax.id"));
            orderTax = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp, "chk.order.orderSalesTax.id"));
        }
        catch (Throwable ex){
            System.out.println("No sales tax for this order" );
        }

        float orderTotal = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp, "chk.order.orderTotal.id"));
        System.out.println("Order complete subtotal:  " + orderSubtotal);
        System.out.println("Order complete shipping charges:  " + orderShipping);
        System.out.println("Order complete sales tax:  " + orderTax);
        System.out.println("Order complete total:  " + orderTotal);
        Assert.assertEquals(revSubtotal,orderSubtotal);
        Assert.assertEquals(revShipping,orderShipping);
        Assert.assertEquals(revTax,orderTax);
        Assert.assertEquals(revTotal,orderTotal);

    }

    //JMB-6527 Start
    //*******************************************************************
    // * Description: Validate that Shipping costs match expected 
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public static void verifyAvailableShippingCosts(String availableShippingCosts) {
    	List<WebElement> shippingMethods = driver.findElements(By.xpath(SLVqProp.getProperty("chk.reg.shippingMethods.xp")));
    	List<WebElement> shippingCosts = driver.findElements(By.xpath(SLVqProp.getProperty("chk.reg.shippingCosts.xp")));
    	ArrayList<String> actualShippingCosts = new ArrayList<String>();
        ArrayList<String> expectedShippingCosts = new ArrayList<String>(Arrays.asList(availableShippingCosts.split(";")));
    	String[] shippingMethod;
    	String currentMethod, currentCosts;
    	if (shippingMethods.size() == 0) {
    		Assert.fail("[Fail] Unable to find avaiable shipping costs to verify on application.");
    	}
    	for (int counter = 0; counter < shippingCosts.size(); counter++)
    	{
    		if (shippingMethods.get(counter).getText().contains(".99"))
    		{
    			shippingMethod = shippingMethods.get(counter).getText().replace("\n","")
    					.replace("- Tracking Included    (Est. 1-3 Business Days in Transit Once Processed & Cleared)", "")
    					.replace("- Tracking & Signature Required    (1-3 Business Days in Transit Once Processed & Cleared)", "")
    					.replace("  - RECOMMENDED", "").split(".99");
        		currentMethod = shippingMethod[1].trim();
    		}
    		else
    		{
    			currentMethod = shippingMethods.get(counter).getText();
    		}
    		
    		shippingMethod = currentMethod.split("with");
    		currentMethod = shippingMethod[0].trim();
    		if(currentMethod.contains("Free")) {
    			currentCosts = "FREE";
    		}
    		else
    		{
    			currentCosts = shippingCosts.get(counter).getText();
    		}
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
    //*******************************************************************
    // * Description: Validate that Shipping costs match expected on PayPal checkout
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public static void verifyAvailableShippingCostsPayPal(String availableShippingCosts) {
    	List<WebElement> shippingMethods = driver.findElements(By.xpath(SLVqProp.getProperty("chk.pp.shippingMethods.xp")));
    	List<WebElement> shippingCosts = driver.findElements(By.xpath(SLVqProp.getProperty("chk.pp.shippingCosts.xp")));
    	ArrayList<String> actualShippingCosts = new ArrayList<String>();
        ArrayList<String> expectedShippingCosts = new ArrayList<String>(Arrays.asList(availableShippingCosts.split(";")));
    	String[] shippingMethod;
    	String currentMethod, currentCosts;
    	if (shippingMethods.size() == 0) {
    		Assert.fail("[Fail] Unable to find avaiable shipping costs to verify on application.");
    	}
    	for (int counter = 0; counter < shippingCosts.size(); counter++)
    	{
    		if (shippingMethods.get(counter).getText().contains(".99"))
    		{
    			shippingMethod = shippingMethods.get(counter).getText().replace("\n","")
    					.replace("- Tracking Included    (Est. 1-3 Business Days in Transit Once Processed & Cleared)", "")
    					.replace("- Tracking & Signature Required    (1-3 Business Days in Transit Once Processed & Cleared)", "")
    					.replace("  - RECOMMENDED", "").split(".99");
        		currentMethod = shippingMethod[1].trim();
    		}
    		else
    		{
    			currentMethod = shippingMethods.get(counter).getText();
    		}
    		
    		shippingMethod = currentMethod.split("with");
    		currentMethod = shippingMethod[0].trim();
    		if(currentMethod.contains("Free")) {
    			currentCosts = "FREE";
    		}
    		else
    		{
    			currentCosts = shippingCosts.get(counter).getText();
    		}
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
        Q_Slv_WebElm.xp(SLVqProp, "chk.reg.shaddress2.editBtn.xp");
        Q_Slv_WebElm.xpClear(SLVqProp, "chk.reg.shaddress2.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "chk.reg.shaddress2.xp", editShippingAdd);
        Q_Slv_WebElm.id(SLVqProp, "chk.shipping.firstName.id");
        try {
            Q_Slv_WebElm.id(SLVqProp, "chk.shipping.saveAddress.id");
        } catch (Throwable ex) {
            System.out.println();
        }
        // Had to use style attribute to see if Continue with this Address button appears
        // as Displayed is always returning true
        boolean verifyCondition = verifyAttrDoesNotContainsValueWithinTimeout(SLVqProp, "chk.shipping.continueWithThisAddress.id", "style", "display: none", 5);
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
        Q_Slv_WebElm.xpExecutor(SLVqProp, "chk.shipping.addShippingAddress.xp");
        Q_Slv_WebElm.myWait(1000);
        // Had to use style attribute to see if Continue with this Address button appears
        // as Displayed is always returning true
        boolean verifyCondition = verifyAttrContainsValueWithinTimeout(SLVqProp, "chk.shipping.continueWithThisAddress.id", "style", "display: none", 5);
        Assert.assertTrue(verifyCondition, "Continue with this Address button after clicking on New Shipping Address when it should not be visible.");
    }

    //*******************************************************************
    // * Description: Verifies element attribute contains a certain value within a timeout
    // * Param: Properties property, String location, String attribute, String value, Integer timeout
    // * Returns: Boolean; true if condition matches expected with timeout, otherwise false
    // * Status: Complete
    //*******************************************************************/
    public static boolean verifyAttrContainsValueWithinTimeout(Properties property, String location, String attribute, String value, Integer timeout) {
        boolean verifyCondition = false;
        int counter = 1;
        do {
            Q_Slv_WebElm.myWait(1000);
            if (Q_Slv_WebElm.idAttrRet(property, location, attribute).contains(value)) {
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
           Q_Slv_WebElm.myWait(1000);
            if (!Q_Slv_WebElm.idAttrRet(property, location, attribute).contains(value)) {
                verifyCondition = true;
                break;
            }
            counter++;
        } while (counter < timeout);
        return verifyCondition;
    }
    //JMB-6650 End
    
    // JMB-3594 Start
 	/******************************************************************
 	 * Description: Verify the correct PDP is launched when product description is
 	 * clicked on Thank You page 
 	 * Parameters: None 
 	 * Returns: None 
 	 * Status: Complete
 	 *******************************************************************/
 	public void verifyProductDescOnThankYouPage() {
 		String productDesc = Q_Slv_WebElm.xpRetText(SLVqProp, "chk.productDesc.thankYouPage.xp");
 		Q_Slv_WebElm.xp(SLVqProp, "chk.productDesc.thankYouPage.xp");
 		Q_Slv_Controls.switchWin();
 		Assert.assertEquals(productDesc, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.productPage.productDesc.xp"),
 				"Incorrect Product Window launched");
 		System.out.println("Correct PDP launched when product description is clicked on Thank You page.");
 	}
 	// JMB-3594 End
 	
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
  		Q_Slv_WebElm.xpSend(SLVqProp,"chk.billingFirstName.xp", ship.firstName);
  		Q_Slv_WebElm.xpSend(SLVqProp,"chk.billingLastName.xp", ship.lastName);
  		Q_Slv_WebElm.xpSend(SLVqProp,"chk.billingStreet.xp", ship.street);
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.xpSend(SLVqProp,"chk.billingCity.xp", ship.city);
        Q_Slv_WebElm.xpSelectValue(SLVqProp, "chk.billingState.xp", ship.state);
        Q_Slv_WebElm.myWait(3000);
        Q_Slv_WebElm.xpClear(SLVqProp,"chk.billingZip.xp");
        Q_Slv_WebElm.xpSend(SLVqProp,"chk.billingZip.xp", ship.zipcode);
        Q_Slv_WebElm.xpSend(SLVqProp,"chk.billingPhone.xp", ship.phoneNumber);
        Q_Slv_WebElm.myWait(2000);
     }
 	/********************************************************************
 	* Description: Click save billing address after enter the required details 
 	* Author: Tamilselvan
 	* Param: NA
 	* Returns: NA
 	* Status: Complete 
 	*******************************************************************/
     public void saveBillingAddress() {
     	Q_Slv_WebElm.id(SLVqProp,"chk.saveBillingAddress.id");
        Q_Slv_WebElm.myWait(1000);
     }
 	/********************************************************************
 	* Description: Click change billing address button 
 	* Author: Tamilselvan
 	* Param: NA
 	* Returns: NA
 	* Status: Complete 
 	*******************************************************************/
     public void changeBillingAddressButton() {
 		Q_Slv_WebElm.xp(SLVqProp, "chk.changeBillingAddress.xp");
        Q_Slv_WebElm.myWait(3000);
     }
 	/********************************************************************
 	* Description: Click add new billing address 
 	* Author: Tamilselvan
 	* Param: NA
 	* Returns: NA
 	* Status: Complete 
 	*******************************************************************/
     public void clickAddNewBillAddress() {
     	Q_Slv_WebElm.xp(SLVqProp,"chk.addNewBill.xp");
        Q_Slv_WebElm.myWait(2000);
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
     		Q_Slv_WebElm.xpDisplayed(SLVqProp, "chk.removeOldBill.xp");
     		Q_Slv_WebElm.xpExecutor(SLVqProp, "chk.removeOldBill.xp");
     		Q_Slv_Controls.checkAlert();
            Q_Slv_WebElm.myWait(2000);
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
     	Q_Slv_WebElm.xp(SLVqProp, "chk.deleteExistingCard.xp");
     }
 	/********************************************************************
 	* Description: Verify Billing Address Field  
 	* Author: Tamilselvan
 	* Param: NA
 	* Returns: NA
 	* Status: Complete 
 	*******************************************************************/
 	public void verifyBillingAddressField() {
     	Assert.assertTrue(Q_Slv_WebElm.xpDisplayed(SLVqProp, "chk.billingAddress.xp"));
     	System.out.println("Billing Address field displayed successfully");
 	}
 	//End JMB-4230
 	
 	//JMB-7670 Start
 	/**********************************************************************
     * Description:     Verifies the proper itmes for revenue is displayed on checkout page
     * Author:          Paul Patterson
     * Param:      		boolean hasSalesTax, boolean hasStateFee, boolean hasShippingTax, boolean hasGiftCert
     * Returns:         List<String>
     **********************************************************************/
  	public List<String> verifyAndReturnCheckoutPriceList(boolean hasSalesTax, boolean hasStateFee, 
  			boolean hasShippingTax, boolean hasGiftCert) 
  	{
          Q_Slv_WebElm.myWait(2000);
          driver.manage().timeouts().implicitlyWait(1, SECONDS);
          System.out.println("[Info] Start verification of checkout price list.");
          List<String> priceList = new ArrayList<String>();
          try {
          	Q_Slv_WebElm.idDisplayed(SLVqProp, "chk.reviewOrder.subtotal.id");
          	System.out.println("[Pass] Subtotal successfully found.");
          	priceList.add("Subtotal: ");
          } catch (Throwable ex) {
          	Assert.fail("[Fail] Subtotal was not found.");
          }

          if (hasSalesTax)
          {
          	try {
              	Q_Slv_WebElm.idDisplayed(SLVqProp,"chk.reviewOrder.tax.id");
              	System.out.println("[Pass] Sales Tax successfully found.");
              	priceList.add("Sales Tax: ");
              } catch (Throwable ex) {
              	Assert.fail("[Fail] Sales Tax was not found.");
              }
          } else {
          	try {
              	Q_Slv_WebElm.idDisplayed(SLVqProp,"chk.reviewOrder.tax.id");
              	Assert.fail("[Fail] Sales Tax was found but no expected.");
              } catch (Throwable ex) {
              	System.out.println("[Pass] Sales Tax was not found.");
              }
          }
          
          if (hasStateFee)
          {
          	try {
              	Q_Slv_WebElm.xpDisplayed(SLVqProp,"chk.revStateFee.xp");
              	System.out.println("[Pass] State Fee successfully found.");
              	priceList.add("State Fee: ");
              } catch (Throwable ex) {
              	Assert.fail("[Fail] State Fee was not found.");
              }
          } else {
          	try {
              	Q_Slv_WebElm.idDisplayed(SLVqProp,"chk.revStateFee.xp");
              	Assert.fail("[Fail] State Fee was found but no expected.");
              } catch (Throwable ex) {
              	System.out.println("[Pass] State Fee was not found.");
              }
          }

          try {
          	Q_Slv_WebElm.idDisplayed(SLVqProp, "chk.reviewOrder.shipping.id");
          	System.out.println("[Pass] Shipping successfully found.");
          	priceList.add("Shipping: ");
          } catch (Throwable ex) {
          	Assert.fail("[Fail] Shipping was not found.");
          }
          
          // Placeholder for Shipping Tax will need to update later
          if (hasShippingTax)
          {
          	try {
              	Q_Slv_WebElm.idDisplayed(SLVqProp,"chk.revShiptax.id");
              	System.out.println("[Pass] Shipping Tax successfully found.");
              	priceList.add("Shipping Tax: ");
              } catch (Throwable ex) {
              	Assert.fail("[Fail] Shipping Tax was not found.");
              }
          } else {
          	try {
              	Q_Slv_WebElm.idDisplayed(SLVqProp,"chk.revShiptax.id");
              	Assert.fail("[Fail] Shipping Tax was found but no expected.");
              } catch (Throwable ex) {
              	System.out.println("[Pass] Shipping Tax was not found.");
              }
          }
          
          if (hasGiftCert)
          {
          	try {
              	Q_Slv_WebElm.idDisplayed(SLVqProp,"chk.revDiscount.id");
              	System.out.println("[Pass] Discount successfully found.");
              	priceList.add("Discount: ");
              } catch (Throwable ex) {
              	Assert.fail("[Fail] Discount was not found.");
              }
          } else {
          	try {
              	Q_Slv_WebElm.idDisplayed(SLVqProp,"chk.revDiscount.id");
              	Assert.fail("[Fail] Discount was found but no expected.");
              } catch (Throwable ex) {
              	System.out.println("[Pass] Discount was not found.");
              }
          }

          try {
          	Q_Slv_WebElm.idDisplayed(SLVqProp, "chk.reviewOrder.total.id");
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
          Q_Slv_WebElm.myWait(2000);
          List<Float> priceList = new ArrayList<Float>();
          Float calcTotal = Float.valueOf(0);
          Float subtotal = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp,"chk.reviewOrder.subtotal.id"));
          calcTotal = calcTotal + subtotal;
          priceList.add(subtotal);

          if (hasSalesTax)
          {
          	Float tax = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp,"chk.reviewOrder.tax.id"));
          	calcTotal = calcTotal + tax;
          	if (hasShippingTax)
            {
            	Float shippingTax = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp,"chk.revShiptax.id"));
            	calcTotal = calcTotal + shippingTax;
            	tax = tax + shippingTax;
            	tax = Float.valueOf(String.format("%.02f", tax));
            }
          	priceList.add(tax);
          }
          
          if (hasStateFee)
          {
          	Float stateFee = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"chk.revStateFee.xp"));
          	calcTotal = calcTotal + stateFee;
          	priceList.add(stateFee);
          }

          Float shipping = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp,"chk.reviewOrder.shipping.id"));
          calcTotal = calcTotal + shipping;
          priceList.add(shipping);
          
          if (hasGiftCert)
          {
          	Float discount = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp,"chk.revDiscount.id"));
          	calcTotal = calcTotal - discount;
          	priceList.add(discount);
          }

          calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
          Float total = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp,"chk.reviewOrder.total.id"));
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
          Q_Slv_WebElm.myWait(2000);
          List<Float> priceList = new ArrayList<Float>();
          Float calcTotal = Float.valueOf(0);
          Float subtotal = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp,"chk.order.orderSubtotal.id"));
          calcTotal = calcTotal + subtotal;
          priceList.add(subtotal);

          if (hasSalesTax)
          {
          	Float tax = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp,"chk.order.orderSalesTax.id"));
          	calcTotal = calcTotal + tax;
          	priceList.add(tax);
          }
          
          if (hasStateFee)
          {
          	Float stateFee = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp,"chk.orderStateFee.id"));
          	calcTotal = calcTotal + stateFee;
          	priceList.add(stateFee);
          }

          Float shipping = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp,"chk.order.orderShipping.id"));
          calcTotal = calcTotal + shipping;
          priceList.add(shipping);
             
          if (hasGiftCert)
          {
          	Float discount = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"chk.orderDiscount.xp"));
          	calcTotal = calcTotal - discount;
          	priceList.add(discount);
          }

          calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
          Float total = Float.valueOf(Q_Slv_WebElm.idRetTextRep(SLVqProp,"chk.order.orderTotal.id"));
          priceList.add(total);
          Assert.assertEquals(total, calcTotal, "Thank You Page total does not match calculated revenue items.");
          System.out.println("[Pass] Thank You Page total matches calculated revenue items.");
          return priceList;
      }
 	/**********************************************************************
     * Description:     Capares pricing on Checkout Page with Another Page
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
		Float actualStateFee = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"chk.revStateFee.xp"));
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
    	Q_Slv_WebElm.myWait(2000);
        driver.manage().timeouts().implicitlyWait(1, SECONDS);
    	try {
    		Q_Slv_WebElm.xp(SLVqProp,"chk.billingBillToAddress1.xp");
    	} catch (Throwable ex) {
    		Q_Slv_WebElm.xp(SLVqProp,"chk.billingUseCurrentAdddress1.xp");
    	}
    	driver.manage().timeouts().implicitlyWait(10, SECONDS);
        Q_Slv_WebElm.myWait(2000);
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
    		Q_Slv_WebElm.xp(SLVqProp,"chk.billingBUseShipAddillToAddress.xp");
    	} catch (Throwable ex) {
    		Q_Slv_WebElm.xp(SLVqProp,"chk.billingUseShipAddCurrentAdddress.xp");
    	}
        Q_Slv_WebElm.myWait(2000);
    }
 	//JMB-7670 End
    
    //JMB-7551-Start
  	/********************************************************************
  	// * Description  : To complete the online checking account
  	// * Param        : NA
  	// * Jira Ticket  : JMB 7551
  	// * Status       : Completed
  	//*******************************************************************/
  	public void loginToOnlineCheckingAccount() {
  		Q_Slv_WebElm.xp(SLVqProp, "chk.onlineCheckingAccountLogin.xp");
  		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='plaid-link-iframe-1']"));
  		driver.switchTo().frame(frameElement);
  		Q_Slv_WebElm.xp(SLVqProp, "chk.eCheckContinue.xp");
  		Q_Slv_WebElm.xp(SLVqProp, "chk.eCheckCitiBankOnline.xp");
  		Q_Slv_WebElm.xpClear(SLVqProp, "chk.eCheckUserId.xp");
  		Q_Slv_WebElm.xpSend(SLVqProp, "chk.eCheckUserId.xp", "user_good");
  		Q_Slv_WebElm.xpClear(SLVqProp, "chk.eCheckPassWord.xp");
  		Q_Slv_WebElm.xpSend(SLVqProp, "chk.eCheckPassWord.xp", "pass_good");
  		Q_Slv_WebElm.xp(SLVqProp, "chk.eCheckSubmit.xp");
  		Q_Slv_WebElm.myWait(3000);
  		Q_Slv_WebElm.xp(SLVqProp, "chk.eCheckPlaidChecking.xp");
  		Q_Slv_WebElm.xp(SLVqProp, "chk.eCheckContinue.xp");
  		Q_Slv_WebElm.xpDisplayed(SLVqProp, "chk.eCheckSuccess.xp");
  		Q_Slv_WebElm.xp(SLVqProp, "chk.eCheckContinue.xp");
  		driver.switchTo().defaultContent();
  		Q_Slv_WebElm.myWait(3000);
  		Q_Slv_WebElm.xpDisplayed(SLVqProp, "chk.eCheckAccount.xp");
  	}

  	/********************************************************************
  	// * Description  : Complete the guest order
  	// * Param        : NA
  	// * Jira Ticket  : JMB 7551
  	// * Status       : Completed
  	//*******************************************************************/
  	public void completeGuestOrder() {
  		Q_Slv_WebElm.xp(SLVqProp, "chk.sil.consent.xp");
  		Q_Slv_WebElm.id(SLVqProp, "chk.finishAndPlace.id");
  		Q_Slv_WebElm.myWait(1000);        
  	}
  	//JMB-7551-End
}
