package pageObjects;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Q_JMB_StuObjects extends Q_JMB_Init {

    public Q_JMB_StuObjects formXp(String locator) {
        Q_JMB_WebElm.xp(jmbProps, locator);
        return this;
    }

    public Q_JMB_StuObjects formXp(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xp(jmbProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_JMB_StuObjects formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_JMB_WebElm.xp(jmbProps, begXp, row, midXp, column, endXp);
        return this;
    }

    public Q_JMB_StuObjects formInputXp(String locator, String inputValue) {
        Q_JMB_WebElm.xpClear(jmbProps, locator);
        Q_JMB_WebElm.xpSend(jmbProps, locator, inputValue);
        return this;
    }

    public Q_JMB_StuObjects formInputXp(String begXp, Integer lineItem, String endXP, String inputValue) {
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

    public Q_JMB_StuObjects formReturnText(String locator) {
        Q_JMB_WebElm.xpRetText(jmbProps, locator);
        return this;
    }

    public Q_JMB_StuObjects formReturnText(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xpRetText(jmbProps, begXp, lineItem, endXp);
        return this;
    }

    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_JMB_WebElm.xpRetText(jmbProps, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public static String formReturnTextReplace(String locator) {
        return Q_JMB_WebElm.xpRetTextReplace(jmbProps, locator);
    }

    public Q_JMB_StuObjects formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xpRetTextReplace(jmbProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_JMB_StuObjects formReturnAttribute(String locator, String attr) {
        Q_JMB_WebElm.xpRetAttr(jmbProps, locator, attr);
        return this;
    }

    public static String attReturn(String locator, String attr) {
        return Q_JMB_WebElm.xpRetAttr(jmbProps, locator, attr);

    }

    public static String attReturn(String begXp, Integer lineItem, String endXp, String attr) {
        return Q_JMB_WebElm.xpAttribute(jmbProps, begXp, lineItem, endXp, attr);
    }

    public Q_JMB_StuObjects formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_JMB_WebElm.xpAttribute(jmbProps, begXp, lineItem, endXp, attr);
        return this;
    }

    public Q_JMB_StuObjects formReturnAttributeReplace(String locator) {
        Q_JMB_WebElm.xpReturnAttributeReplace(jmbProps, locator);
        return this;
    }

    public Q_JMB_StuObjects formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xpReturnAttributeReplace(jmbProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_JMB_StuObjects formXpDisplayed(String locator) {
        try {
            Q_JMB_WebElm.xpDisplayed(jmbProps, locator).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Q_JMB_StuObjects formXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_JMB_WebElm.xpDisplayed(jmbProps, begXp, lineItem, endXP).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Q_JMB_StuObjects formXpTab(String locator) {
        Q_JMB_WebElm.xpSendTab(jmbProps, locator);
        return this;
    }

    public Q_JMB_StuObjects formXpTab(String begXp, Integer lineItem, String endXP) {
        Q_JMB_WebElm.xpSendTab(jmbProps, begXp, lineItem, endXP);
        return this;
    }

    public Q_JMB_StuObjects formXpEnter(String locator) {
        Q_JMB_WebElm.xpSendEnter(jmbProps, locator);
        return this;
    }

    public Q_JMB_StuObjects formXpEnter(String begXp, Integer lineItem, String endXP) {
        Q_JMB_WebElm.xpSendEnter(jmbProps, begXp, lineItem, endXP);
        return this;
    }

    public static boolean isXpDisplayed(String locator) {
        return Q_JMB_WebElm.xpDisplayed(jmbProps, locator).equals(true);
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

    public Q_JMB_StuObjects formXpSelectIndex(String locator, Integer index) {
        Q_JMB_WebElm.xpSelectIndex(jmbProps, locator, index);
        return this;
    }

    public Q_JMB_StuObjects formXpSelectValue(String locator, String value) {
        Q_JMB_WebElm.xpSelectValue(jmbProps, locator, value);
        return this;
    }

    public Q_JMB_StuObjects formXpSelectText(String locator, String text) {
        Q_JMB_WebElm.xpSelectText(jmbProps, locator, text);
        return this;
    }

    public Q_JMB_StuObjects formId(String locator) {
        Q_JMB_WebElm.id(jmbProps, locator);
        return this;
    }

    public Q_JMB_StuObjects formInputId(String locator, String inputValue) {
        Q_JMB_WebElm.idClear(jmbProps, locator);
        Q_JMB_WebElm.idSend(jmbProps, locator, inputValue);
        return this;
    }

    public Q_JMB_StuObjects formIdTab(String locator) {
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

    public Q_JMB_StuObjects formIdSelectIndex(String locator, Integer index) {
        Q_JMB_WebElm.idSelectIndex(jmbProps, locator, index);
        return this;
    }

    public Q_JMB_StuObjects formIdSelectValue(String locator, String value) {
        Q_JMB_WebElm.idSelectValue(jmbProps, locator, value);
        return this;
    }

    public Q_JMB_StuObjects formIdSelectText(String locator, String text) {
        Q_JMB_WebElm.idSelectText(jmbProps, locator, text);
        return this;
    }

    public static Integer rowCount(String locator) {
        Integer count = Q_JMB_WebElm.xpCountTableRows(jmbProps, locator);
        return count;
    }

    /*******************************************************************
     // * Description: Does yhe user have permission to acccess DIY Buyback
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    // @Step
    public Q_JMB_StuObjects diyConfigSettings() {
        Q_JMB_Controls.adminLogin();

        formXp("stu.admin.jmbullion.xp");
        formXp("adm.menuSettings.xp");
        formXp("stu.settings.config.xp");
        Q_JMB_WebElm.myWait(6000);
        return this;
    }

    /*******************************************************************
     // * Description: Does yhe user have permission to access DIY Buyback
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    // @Step
    public Q_JMB_StuObjects diyBbForAll(String enableIt) {
        switch(enableIt) {
            case "ON":
                formXp("stu.diyBuyback.everyOne.ON.xp");
                formXp("stu.setting.config.save.xp");
                Q_JMB_WebElm.myWait(3000);
                System.out.println("DIY Buyback : " + isXpCheckSelected("stu.diyBuyback.everyOne.OFF.xp"));
                Assert.assertFalse(isXpCheckSelected("stu.diyBuyback.everyOne.OFF.xp"));
                break;
            case"OFF":
                formXp("stu.diyBuyback.everyOne.OFF.xp");
                formXp("stu.setting.config.save.xp");
                Q_JMB_WebElm.myWait(1000);
                System.out.println("DIY Buyback : " + isXpCheckSelected("stu.diyBuyback.everyOne.ON.xp"));
                Assert.assertFalse(isXpCheckSelected("stu.diyBuyback.everyOne.ON.xp"));
                break;
            default:
                System.out.println("State is either ON or OFF");
                break;
        }
        return this;
    }


    /*******************************************************************
     // * Description: Does yhe user have permission to acccess DIY Buyback
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    // @Step
    public Q_JMB_StuObjects grantUserDIYBBPermission(String userToCheck) {
        Q_JMB_Controls.adminLogin();

        driver.navigate().to(driver.getCurrentUrl() + "/customers.php?show=" + userToCheck);
        System.out.println(Q_JMB_WebElm.nameRetAttr(jmbProps, "stu.DiyBB.name", "value"));
        if (Q_JMB_WebElm.nameRetAttr(jmbProps, "stu.DiyBB.name", "value").equals("0")) {
            Q_JMB_WebElm.nameSelectValue(jmbProps, "stu.DiyBB.name", "1");
            formXp("stu.DiyBB.submit.xp");
            System.out.println("Should have access " + Q_JMB_WebElm.nameRetAttr(jmbProps, "stu.DiyBB.name", "value"));
            Assert.assertEquals(Q_JMB_WebElm.nameRetAttr(jmbProps, "stu.DiyBB.name", "value"), "1");
        }
        return this;
    }

    public Q_JMB_StuObjects removeUserDIYBBPermission(String userToCheck) {
        Q_JMB_Controls.adminLogin();
        driver.navigate().to(driver.getCurrentUrl() + "/customers.php?show=" + userToCheck);
        System.out.println(Q_JMB_WebElm.nameRetAttr(jmbProps,"stu.DiyBB.name" , "value"));
        if (Q_JMB_WebElm.nameRetAttr(jmbProps, "stu.DiyBB.name", "value").equals("1")) {
            Q_JMB_WebElm.nameSelectValue(jmbProps,"stu.DiyBB.name", "0");
            formXp("stu.DiyBB.submit.xp");
            System.out.println("Access should be removed " + Q_JMB_WebElm.nameRetAttr(jmbProps, "stu.DiyBB.name", "value"));
            Assert.assertEquals(Q_JMB_WebElm.nameRetAttr(jmbProps, "stu.DiyBB.name", "value"), "0");

        }
//        AccountSteps.adminLogout();
        return this;
    }
    //
//    /*******************************************************************
//    // * Description: selToUs
//    // * Param: String
//    // * Returns: NA
//    // * Status: Complete
//    //*******************************************************************/
//    // @Step
    public Q_JMB_StuObjects selToUs() {
        formXp("stu.link.xp");
        formXp("stu.btn.xp");
        return this;
    }
    public Q_JMB_StuObjects selToUsOff() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Q_JMB_WebElm.moveIt(jmbProps, "jm.myAccountLink.xp");
        Q_JMB_WebElm.myWait(2000);

//        if(WebElm.xpDisplayed(jmbProps,"jm.accountSellToUs.xp")){
//            WebElm.xp(jmbProps, "jm.accountSellToUs.xp");
            System.out.println("Now is Sell to us " + Q_JMB_WebElm.xpDisplayed(jmbProps,"jm.accountSellToUs.xp"));
            Assert.assertFalse(Q_JMB_WebElm.xpDisplayed(jmbProps,("jm.accountSellToUs.xp")));
//        }
        return this;
    }
    //
//    /*******************************************************************
//    // * Description: Add another item
//    // * Param: String
//    // * Returns: NA
//    // * Status: Complete
//    //*******************************************************************/
//    // @Step
    public Q_JMB_StuObjects addAnother(String locator) {
        formXp("stu.cart.addAnother.xp");
        return this;
    }

    public Q_JMB_StuObjects checkout() {
        formXp("stu.cart.checkout.xp");
        return this;
    }
//
//            public static void addMetalType(String metalType, Integer item, String quantity, String modalAction) {
//                StuObjects stu = new StuObjects();
//                WebDriverWait wait = new WebDriverWait(driver, 30);
//                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("silver"))));
//                switch ( metalType ) {
//                    case ("popular products"):
//                        WebElm             stu.addBbItem("bbPopularProducts.qty.beg.xp", item, quantity, modalAction);
//                break;
//            case ("gold"):
//
//                WebElm.xp(jmbProps, "bbMetal.gold.xp");
//                WebElm.myWait(1000);
//                stu.addBbItem("bbGoldProducts.qty.beg.xp", item, quantity, modalAction);
//                WebElm.myWait(1000);
//                break;
//            case ("silver"):
//                WebElm.myWait(1000);
//                WebElm.xp(jmbProps,"bbMetal.silver.xp");
//                WebElm.myWait(1000);
//                stu.addBbItem("bbsilverProducts.qty.beg.xp", item, quantity, modalAction);
//                break;
//            case ("platinum"):
//                WebElm.xp(jmbProps,"bbMetal.platinum.xp");
//                WebElm.myWait(1000);
//                stu.addBbItem("bbPlatinumProducts.qty.beg.xp", item, quantity, modalAction);
//                break;
//            case ("palladium"):
//                WebElm.xp(jmbProps,"bbMetal.palladium.xp");
//                WebElm.myWait(1000);
//                stu.addBbItem("bbPalladiumProducts.qty.beg.xp", item, quantity, modalAction);
//                break;
//            default:
//                System.out.println("Invalid Metal Type");
//                break;
//        }
//
//    }


    public Q_JMB_StuObjects selectBbPayment(String payment) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Q_JMB_WebElm.myWait(2000);
        switch ( payment ) {
            case ("ach"):
                formXp("stu.payment.select.xp");
                formXp("stu.payment.ach.xp");
                isXpDisplayed("stu.agree.xp");
                break;
            case ("wire"):
                formXp("stu.payment.select.xp");
                formXpSelectValue("stu.payment.select.xp", "wire");
                isXpDisplayed("stu.agree.xp");
                break;
            case ("check"):
                formXp("stu.payment.select.xp");
                formXp("stu.payment.check.xp");
                isXpDisplayed("stu.agree.xp");
                break;

            default:
                System.out.println("Invalid Payment Option");
                break;
        }
        return this;
    }
    public Q_JMB_StuObjects verifyCheckoutErrorMessage(String messageToBeVerified){

        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "stu.woocommerceErrorMessage.xp"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "stu.woocommerceErrorMessage.xp"),("Please select a bank account"));
        return this;
    }

    public static List<Float> stuRvPriceList() {
        Q_JMB_WebElm.myWait(2000);
        DecimalFormat df = new DecimalFormat("#.00");

        List<Float> priceList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(idNumberReturn("stu.rev.subtotal.id"));
        Float bbFee = Float.valueOf(idNumberReturn("stu.rev.paymentFee.id"));
        Float total = Float.valueOf(idNumberReturn("stu.rev.total.id"));
        priceList.add(subtotal);
        priceList.add(bbFee);
        priceList.add(total);
        System.out.println("Review page " + priceList);
        return priceList;
    }

    public static List<Float> stuBbOrderPriceList() {
        Q_JMB_WebElm.myWait(4000);
        List<Float> orderList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(numberReturn("stu.orderSub.xp"));
        Float adjustment = Float.valueOf(numberReturn("stu.orderAdj.xp"));
        Float total = Float.valueOf(numberReturn("stu.orderTotal.xp"));
        orderList.add(subtotal);
        orderList.add(adjustment);
        orderList.add(total);
        System.out.println("Sale complete page " + orderList);
        return orderList;
    }
    //
//    /*******************************************************************
//    // * Description: Verify the order toal
//    // * Param: String
//    // * Returns: NA
//    // * Status: Complete
//    //*******************************************************************/
//    //@Step
//    public static void stuVerifyBbOrderCharges(List revCharges, List orderCharges) {
//        System.out.println("Review Page " + revCharges);
//        System.out.println("Order Page " + orderCharges);
//        if (revCharges.size() > orderCharges.size()) {
//            Object[] revCh = revCharges.toArray();
//            Object[] orderCh = orderCharges.toArray();
//
//        }
//        Controls.scrolDownPixel(900);
//        for (int i = 0; i < orderCharges.size(); i++) {
//            System.out.println("Review Page " + ElemSteps.xpCompoundRetText(jmbProps, "stu.orderDetailsTitle.beg.xpath", (i + 1), "stu.orderDetailsTitle.end.xpath") + "  " + revCharges.get(i));
//            System.out.println("Order Page  " + ElemSteps.xpCompoundRetText(jmbProps, "stu.orderDetailsTitle.beg.xpath", (i + 1), "stu.orderDetailsTitle.end.xpath") + "  " + orderCharges.get(i));
//            WebElm.myWait(1000);
//            Assert.assertEquals(revCharges.get(i), orderCharges.get(i));
//        }
//    }
//
//    /*******************************************************************
//    // * Description: Complete sale order
//    // * Param: String
//    // * Returns: NA
//    // * Status: Complete
//    //*******************************************************************/
//    // @Step
    public Q_JMB_StuObjects completeSale() {
        formXp("stu.agree.xp");
        formXp("stu.submitOrder.xp");
        Q_JMB_Controls.checkAlert();
        return this;
    }

    public Q_JMB_StuObjects orderDetails() {
        System.out.println(" Buyback Number Order details " + strXpText("stu.bbNumber.xp"));
        System.out.println(" Buyback Total " + strXpText("stu.orderTotal.xp"));
        return this;
    }
    public Q_JMB_StuObjects selectMetalType(String metal){
        switch ( metal ) {
            case ("popular"):
//                WebElm.myWait(8000);
                Q_JMB_WebElm.xp(jmbProps, "stu.bbMetal.popular.xp");
                break;
            case ("gold"):
                Q_JMB_WebElm.xp(jmbProps, "stu.bbMetal.gold.xp");
                break;
            case ("silver"):
                Q_JMB_WebElm.xp(jmbProps, "stu.bbMetal.silver.xp");
                break;
            case ("platinum"):
                Q_JMB_WebElm.xp(jmbProps, "stu.bbMetal.platinum.xp");
                break;
            case ("palladium"):
                Q_JMB_WebElm.xp(jmbProps, "stu.bbMetal.palladium.xp");
                break;
            default:
                System.out.println("Invalid Metal Type");
                break;
        }
        return this;
    }
    public Q_JMB_StuObjects addBbItem(String metalType, Integer item, String quan) {
        switch(metalType){
            case "popular":
                Q_JMB_WebElm.xp(jmbProps, "stu.bbMetal.popular.xp");
                Q_JMB_WebElm.myWait(1000);
                formInputXp("stu.bbPopularProducts.qty.beg.xp", item, "stu.bbProducts.qty.end.xp", quan);
                formXp("stu.bbPopularProducts.qty.beg.xp", item, "stu.bbProducts.Atc.end.xp");
                System.out.println("Modal Price " + strXpText("stu.modal.price.xp"));
                formXp("stu.modal.checkout.xp");
                break;
            case "gold":
                Q_JMB_WebElm.myWait(2000);
                Q_JMB_WebElm.xp(jmbProps, "stu.bbMetal.gold.xp");
                Q_JMB_WebElm.myWait(1000);
                formInputXp("stu.bbGoldProducts.qty.beg.xp", item, "stu.bbProducts.qty.end.xp", quan);
                formXp("stu.bbGoldProducts.qty.beg.xp", item, "stu.bbProducts.Atc.end.xp");

                System.out.println("Modal Price " + strXpText("stu.modal.price.xp"));
                formXp("stu.modal.checkout.xp");
                break;
            case "silver":
                Q_JMB_WebElm.myWait(2000);
                Q_JMB_WebElm.xp(jmbProps, "stu.bbMetal.silver.xp");
                Q_JMB_WebElm.myWait(1000);
                formInputXp("stu.bbsilverProducts.qty.beg.xp", item, "stu.bbProducts.qty.end.xp", quan);
                formXp("stu.bbsilverProducts.qty.beg.xp", item, "stu.bbProducts.Atc.end.xp");
                System.out.println("Modal Price " + strXpText("stu.modal.price.xp"));
                formXp("stu.modal.checkout.xp");
                break;
            case "platinum":
                Q_JMB_WebElm.myWait(2000);
                Q_JMB_WebElm.xp(jmbProps, "stu.bbMetal.platinum.xp");
                Q_JMB_WebElm.myWait(1000);
                formInputXp("stu.bbPlatinumProducts.qty.beg.xp", item, "stu.bbProducts.qty.end.xp", quan);
                formXp("stu.bbPlatinumProducts.qty.beg.xp", item, "stu.bbProducts.Atc.end.xp");

                System.out.println("Modal Price " + strXpText("stu.modal.price.xp"));
                formXp("stu.modal.checkout.xp");
                break;
            case "palladium":
                Q_JMB_WebElm.myWait(2000);
                Q_JMB_WebElm.xp(jmbProps, "stu.bbMetal.palladium.xp");
                Q_JMB_WebElm.myWait(1000);
                formInputXp("stu.bbPalladiumProducts.qty.beg.xp", item, "stu.bbProducts.qty.end.xp", quan);
                formXp("stu.bbPalladiumProducts.qty.beg.xp", item, "stu.bbProducts.Atc.end.xp");

                System.out.println("Modal Price " + strXpText("stu.modal.price.xp"));
                formXp("stu.modal.checkout.xp");
                break;
            default:
                System.out.println("Make sure the metal type is correct");
                break;
        }
        return this;
    }
    public Q_JMB_StuObjects modalAddItem(){
        formXp("stu.modalAddAnotherItem.xp");
        return this;
    }
    public Q_JMB_StuObjects modalCheckout(){
        formXp("stu.modalAddAnotherItem.xp");
        return this;
    }
    public Q_JMB_StuObjects addAnotherProduct(){
        formXp("stu.cartAddAnother.xp");
        return this;
    }
    public Q_JMB_StuObjects checkoutNow(){
        formXp("stu.cart.checkout.xp");
        return this;
    }

    public static Integer cartCount() {
        Integer count = Integer.valueOf(rowCount( "stu.itemCount.xp"));
        System.out.println("Count initially " + count);
        return count;
    }
    public static void cartContent() {
        Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
//        Integer count = StuObjects.cartCount();
        Integer count = 0;
//        stu.selectMetalType("popular");
        stu.addBbItem("popular", 3, "100");
        count = count + 1;
        Assert.assertEquals((Integer.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"stu.itemCount.xp"))), count);
        stu.addAnotherProduct();

//        stu.selectMetalType("gold");
        stu.addBbItem("gold", 2, "2");
        count = count + 1;
        Assert.assertEquals((Integer.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"stu.itemCount.xp"))), count);
        stu.addAnotherProduct();

//        stu.selectMetalType("silver");
        stu.addBbItem("silver", 5, "10");
        count = count + 1;
        Assert.assertEquals((Integer.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"stu.itemCount.xp"))), count);
        stu.addAnotherProduct();

//        stu.selectMetalType("platinum");
        stu.addBbItem("platinum", 2, "2");
        count = count + 1;
        Assert.assertEquals((Integer.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"stu.itemCount.xp"))), count);
        stu.addAnotherProduct();

//        stu.selectMetalType("palladium");
        stu.addBbItem("palladium", 1, "2");
        count = count + 1;
        Assert.assertEquals((Integer.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"stu.itemCount.xp"))), count);
    }
    public Q_JMB_StuObjects removeCartPageContent() {
//        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
//        Controls.testStarted(tcName);
        Q_JMB_WebElm.myWait(4000);
        driver.navigate().to(baseUrl + "/my-account/buyback-cart/");
        Integer productCount = rowCount("cart.stu.cart.productCount.xp") - 2;
        System.out.println("Row count " + productCount);
        Q_JMB_Controls.scrolDownPixel(400);
        if (productCount >= 1) {
            for (int i = productCount; i > 1; i--) {
                System.out.println("Line item " + numberReturn("stu.cartCount.xp"));
                formXp("stu.cartProductTble.remove.xp");
                Q_JMB_WebElm.myWait(2000);
                if(numberReturn("stu.cartCount.xp").equals(0))
                    break;
            }
        }
        return this;
    }

    public Q_JMB_StuObjects isReportable() {
        try{
            isXpDisplayed("stu.cart.reportable.xp");
            formXp("stu.cart.reportable.xp");
        }
        catch (Throwable ex){
        }
        return this;
    }

    public Q_JMB_StuObjects myAccoutbb(String bbItem, Integer row) {
        switch ( bbItem ) {
            case ("number"):
                Q_JMB_WebElm.myWait(1000);
                System.out.println("buybak number " + Q_JMB_WebElm.xpRetText(jmbProps, "acc.bb.orderNumber.beg.xp", row, "acc.bb.orderNumber.end.xp"));
                Q_JMB_WebElm.xp(jmbProps, "acc.bb.orderNumber.beg.xp", row, "acc.bb.orderNumber.end.xp");
                break;
            case ("date"):
                System.out.println("buybak number " + Q_JMB_WebElm.xpRetText(jmbProps, "acc.bb.orderNumber.beg.xp", row, "acc.bb.orderDate.end.xp"));
                break;
            case ("amount"):
                System.out.println("buybak number " + Q_JMB_WebElm.xpRetText(jmbProps, "acc.bb.orderNumber.beg.xp", row, "acc.bb.orderTotal.end.xp"));
                break;
            case ("status"):
                System.out.println("buybak status " + Q_JMB_WebElm.xpRetText(jmbProps, "acc.bb.orderNumber.beg.xp", row, "acc.bb.orderStatus.end.xp"));
                break;
            case ("view"):
                System.out.println("buybak view " + Q_JMB_WebElm.xpRetText(jmbProps, "acc.bb.orderNumber.beg.xp", row, "acc.bb.orderView.end.xp"));
                Q_JMB_WebElm.xp(jmbProps, "acc.bb.orderNumber.beg.xp", row, "acc.bb.orderView.end.xp");
                break;
            default:
                System.out.println("Invalid bb item");
                break;
        }
        return this;
    }

    public static String getbuybackNumber(Integer row) {
        System.out.println("buybak number " + Q_JMB_WebElm.xpRetText(jmbProps, "acc.bb.orderNumber.beg.xp", row, "acc.bb.orderNumber.end.xp"));
        String buybackNumber = Q_JMB_WebElm.xpRetText(jmbProps,"acc.bb.orderNumber.beg.xp", row, "acc.bb.orderNumber.end.xp");
        return buybackNumber;
    }

    public Q_JMB_StuObjects mailLabel(Integer optionIndex) {
        switch ( optionIndex ) {
            case 1:
                formXp( "stu.mailOption1.xp");
                String makeMe = strXpText("stu.mailOption1Text.xp");
                System.out.println();
                Assert.assertEquals(makeMe, "Fully Insured In-Transit by JM Bullion");
                break;
            case 2:
                formXp("stu.mailOption2.xp");
                String myOwn = strXpText("stu.mailOption2Text.xp");
                Assert.assertEquals(myOwn, "I Accept Risk of Loss In-Transit");
                break;
            // PJP Added Drop Off Mail option
            case 3:
            	Q_JMB_WebElm.id(jmbProps, "stu.mailOptionDropOff.id");
            	String myLocalDropOff = Q_JMB_WebElm.idRetText(jmbProps, "stu.mailOptionDropOffText.id");
                Assert.assertEquals(myLocalDropOff, "Drop-off at 4150 Eldorado Pkwy, McKinney, TX 75070");
                break;
            default:
                System.out.println("Invalid mailing label option" + "\n\n");
        }
        return this;
    }
    public static void bbpage(Integer user) {
        Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
        Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
        acc.loginUser(26);
        stu.selToUs();
        stu.addBbItem("platinum", 2, "2");
        stu.checkoutNow();
        stu.selectBbPayment("ach");
        System.out.println(strXpText("stu.mailOption2Text.xp"));
    }

    public Q_JMB_StuObjects verifyTrackingNum(){
        boolean tn = isXpDisplayed("stu.trackingNum.xp");
        if(tn==true){
            String trackingNum = ("ORD-" + Q_JMB_Controls.startTimeStriped() + "trackit");
            formInputXp("stu.trackinNumInp.xp", trackingNum);
        }
        System.out.println(strXpText("stu.trackingNumButton.xp"));
        Assert.assertEquals(strXpText("stu.trackingNumButton.xp"), "Save");
        formXp("stu.trackingNumButton.xp");
        Q_JMB_WebElm.myWait(2000);
        Assert.assertEquals(strXpText("stu.trackingNumButton.xp"), "Update");
        return this;
    }

    public Q_JMB_StuObjects updateTrackingNum() {
        boolean tn = isXpDisplayed("stu.trackingNum.xp");
        if (tn == true) {
            String trackingNum = ("ORD-" + Q_JMB_Controls.startTimeStriped() + "trackit");
            formInputXp("stu.trackinNumInp.xp", trackingNum);
        }
        System.out.println(strXpText("stu.trackingNumButton.xp"));
        Assert.assertEquals(strXpText("stu.trackingNumButton.xp"), "Update");
        formXp("stu.trackingNumButton.xp");
        Q_JMB_WebElm.myWait(2000);
        Assert.assertEquals(strXpText("stu.trackingNumButton.xp"), "Update");
        return this;
    }
    public Q_JMB_StuObjects isLegacyEcheckQc(){
        isXpDisplayed("stu.legacyEcheck.btn.xp");
        return this;
    }
    public Q_JMB_StuObjects creditCardRequired(){
        isIdDisplayed("stu.cardRequired.id");
        return this;
    }
    
  //JMB-7384-Start
  	/************************************************************
      // * Description :  Search and Select the product
      // * Param       :  String product
      // * Jira Ticket :  JMB 7384
      // * Status      :  Completed
      //***********************************************************/	
  	public void searchBuyBackProduct(String product) {
  		Q_JMB_WebElm.xpClear(jmbProps, "chk.stu.productSearch.xp");
  		Q_JMB_WebElm.xpSend(jmbProps, "chk.stu.productSearch.xp",product);
  		Q_JMB_WebElm.xpSendEnter(jmbProps, "chk.stu.productSearch.xp");
  		Q_JMB_WebElm.xp(jmbProps, "chk.stu.electProduct.xp");
  	}
  	
  	/************************************************************
      // * Description :  Select the new shipping address
      // * Param       :  NA
      // * Jira Ticket :  JMB 7384
      // * Status      :  Completed
      //***********************************************************/
  	public void isSelectNewShippingAddress() {
  		try {
  			Q_JMB_WebElm.xpDisplayed(jmbProps, "chk.stu.newShippAddress.xp");
  			Q_JMB_WebElm.xp(jmbProps, "chk.stu.newShippAddress.xp");

  		} catch (Exception e) {
  			System.out.println("Create address!");
  		}
  	}
   
  	/************************************************************
      // * Description :  Select the shipping method 
      // * Param       :  String shippingMethod
      // * Jira Ticket :  JMB 7384
      // * Status      :  Completed
      //***********************************************************/
  	public void shippingMethod(String shippingMethod) {

  		switch (shippingMethod) {
  			case "Send Me a Shipping Kit and Label":
  				Q_JMB_WebElm.xp(jmbProps, "chk.stu.sendMeKitLabel.xp");
  				break;
  			case "Make Me a Label":
  				Q_JMB_WebElm.xp(jmbProps, "chk.stu.makeMeLabel.xp");
  				break;
  			case "Use My Own Label":
  				Q_JMB_WebElm.xp(jmbProps, "chk.stu.useMyOwnLabel.xp");
  				break;
  		}
  	}
  	
  	/************************************************************
      // * Description :  Continue the Address
      // * Param       :  NA
      // * Jira Ticket :  JMB 7384
      // * Status      :  Completed
      //***********************************************************/
  	public void continueWithAddress() {
  		Q_JMB_WebElm.id(jmbProps, "chk.shipping.ContinueWithAdd.id");
  		Q_JMB_WebElm.myWait(1000);
  	}
  	
  	//JMB-7384-End

}

