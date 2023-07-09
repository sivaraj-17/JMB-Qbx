package pageObjects;

import jsonWrappers.AddressContainer;
import jsonWrappers.CreditContainer;
import jsonWrappers.UserContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Keys;
import org.testng.Assert;


import utils.Controls;
import utils.Init;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Q_OrderForm extends Init {
	static Q_AdminForm adm = new Q_AdminForm();
    static Q_OrderForm ord = new Q_OrderForm();
    static Q_ProductForm prod = new Q_ProductForm();
    static Controls li = new Controls();
    static Q_CheckoutForm chk = new Q_CheckoutForm();
    public Q_OrderForm formXp(String locator) {
        Q_WebElm.xp(adminProps, locator);
        return this;
    }
    public Q_OrderForm formXp(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xp(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public Q_OrderForm formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_WebElm.xp(adminProps, begXp, row, midXp, column, endXp);
        return this;
    }
    public Q_OrderForm formInputXp(String locator, String inputValue) {
        Q_WebElm.xpClear(adminProps, locator);
        Q_WebElm.xpSend(adminProps, locator, inputValue);
        return this;
    }
    public Q_OrderForm formInputXp(String begXp, Integer lineItem, String endXP, String inputValue) {
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
    public Q_OrderForm formReturnText(String locator) {
        Q_WebElm.xpRetText(adminProps, locator);
        return this;
    }
    public Q_OrderForm formReturnText(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpRetText(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, recordNumber, midXp, lineItem, endXp);
    }
    public static String formReturnTextReplace(String locator) {
        return Q_WebElm.xpRetNumber(adminProps, locator);
    }

    public Q_OrderForm formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpRetNumber(adminProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_OrderForm formReturnAttribute(String locator, String attr) {
        Q_WebElm.xpRetAttr(adminProps, locator,attr);
        return this;
    }
    public static String attReturn(String locator, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, locator,attr);

    }
    public static String attReturn(String begXp, Integer lineItem, String endXp, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp, attr);
    }
    public Q_OrderForm formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp,attr);
        return this;
    }

    public Q_OrderForm formReturnAttributeReplace(String locator) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, locator);
        return this;
    }

    public Q_OrderForm formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public Q_OrderForm formXpDisplayed(String locator) {
        try {
            Q_WebElm.xpDisplayed(adminProps, locator).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }
    public Q_OrderForm formXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_WebElm.xpDisplayed(adminProps, begXp, lineItem, endXP).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }
    public Q_OrderForm formXpTab(String locator) {
        Q_WebElm.xpSendTab(adminProps, locator);
        return this;
    }

    public Q_OrderForm formXpTab(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendTab(adminProps, begXp, lineItem, endXP);
        return this;
    }

    public Q_OrderForm formXpEnter(String locator) {
        Q_WebElm.xpSendEnter(adminProps, locator);
        return this;
    }

    public Q_OrderForm formXpEnter(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendEnter(adminProps, begXp, lineItem, endXP);
        return this;
    }
    public static boolean isXpDisplayed(String locator) {
        return  Q_WebElm.xpDisplayed(adminProps, locator).equals(true);
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
    public Q_OrderForm formXpSelectIndex(String locator, Integer index) {
        Q_WebElm.xpSelectIndex(adminProps, locator, index);
        return this;
    }

    public Q_OrderForm formXpSelectValue(String locator, String value) {
        Q_WebElm.xpSelectValue(adminProps, locator, value);
        return this;
    }
    public Q_OrderForm formXpSelectText(String locator, String text) {
        Q_WebElm.xpSelectText(adminProps, locator, text);
        return this;
    }
    public Q_OrderForm formId(String locator) {
        Q_WebElm.id(adminProps, locator);
        return this;
    }
    public Q_OrderForm formInputId(String locator, String inputValue) {
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
    public static boolean isIdDisplayed(String locator) {
        return  Q_WebElm.idDisplayed(adminProps, locator).equals(true);}
    public Q_OrderForm formIdSelectIndex(String locator, Integer index) {
        Q_WebElm.idSelectIndex(adminProps, locator, index);
        return this;
    }

    public Q_OrderForm formIdSelectValue(String locator, String value) {
        Q_WebElm.idSelectValue(adminProps, locator, value);
        return this;
    }
    public Q_OrderForm formIdSelectText(String locator, String text) {
        Q_WebElm.idSelectText(adminProps, locator, text);
        return this;
    }
    public static Integer rowCount(String locator) {
        Integer count = Q_WebElm.xpCountTableRows(adminProps, locator);
        return count;
    }

    public static void ordersMenu(String item) {
        Q_AdminForm adm = new Q_AdminForm();
        adm.adminMenu("orders");
        String menuItem = item;
        switch ( menuItem ) {
            case ("list"):
                Q_WebElm.xp(adminProps, "ord.menuList.xp");
                Q_WebElm.myWait(1000);
                break;
            case ("pending"):
                Q_WebElm.xp(adminProps, "ord.menuPending.xp");
                break;
            case ("paid"):
                Q_WebElm.xp(adminProps, "ord.menuPaid.xp");
                break;
            case ("newHolds"):
                Q_WebElm.xpExecutor(adminProps, "orders.newOnHold.xpath");
                break;
            case ("shipped"):
                Q_WebElm.xp(adminProps, "ord.menuShipped.xp");
                break;
            case ("completed"):
                Q_WebElm.xp(adminProps, "ord.menuCompleted.xp");
                break;
            case ("cancelled"):
                Q_WebElm.xp(adminProps, "ord.menuCancelled.xp");
                break;
            case ("holdSystem"):
                Q_WebElm.xp(adminProps, "ord.holdSystem.xp");
                break;
        }
    }
    public static String orderTotal(){
        Q_WebElm.myWait(1000);
        Controls.scrolDownPixel(1000);
        String ordTotal = strXpText("ord.total.xp").substring(1);
        Controls.scrolUpPixel(1000);
        return ordTotal;
    }
    public Q_OrderForm orderTotal(String param){
        Integer orderCount = rowCount("ord.orderRows.xp");
        for(int i=1; i<=orderCount; i++){
            if (strXpText("ord.order.beg.xp", i, "ord.orderList.mid.xp", 3, "ord.orderListOrderNum.end.xp").contains(param)) {
                System.out.println("order Total " + strXpText("ord.order.beg.xp", i, "ord.orderList.mid.xp", 3, "ord.orderListOrderNum.end.xp"));
                formXp("ord.orderAction.beg.xp", i, "ord.orderAction.end.xp");
                formXp("ord.orderAction.beg.xp", i, "ord.orderActionEdit.end.xp");
                break;
            }
        }
        return this;
    }
    public Q_OrderForm skipCacelFee(String emailMsg){
        System.out.println("Estimated fee = " + orderEstCancelFee());
        Q_WebElm.myWait(1000);
        Q_WebElm.xp(adminProps, "ord.orderCancelSkipFee.xp");
        System.out.println("Email message: " + Q_WebElm.idRetText(adminProps, "ord.cancelMailPreview.id"));
//        String emailMsg= "";
        Assert.assertTrue(Q_WebElm.idRetText(adminProps, "ord.cancelMailPreview.id").contains(emailMsg));

        return this;
    }
    public Q_OrderForm processCancellationskipFee(){
        Q_WebElm.myWait(3000);;
        formXp("ord.orderProcessCancellation.xp");
        orderMargin();
        driver.navigate().refresh();
        orderNotes("has been cancelled due to non-payment. We have elected to skip the market loss fees for this order as a one-time courtesy.");
        return this;
    }
    public Q_OrderForm switchCancelReason(){
        ArrayList<String> reason = new ArrayList<String>(Arrays.asList("0","1", "3", "2"));
        for(int i=0; i< reason.size(); i++){
            orderCancelForm(reason.get(i));
            Q_WebElm.id(adminProps, "ord.cancelReason.id");
        }
        return this;
    }
    public Q_OrderForm orderCancelForm(String reason){
        Q_WebElm.myWait(1000);
        switch (reason) {

            case "0":
                System.out.println("CUSTOM " + reason);
                Q_WebElm.idSelectValue(adminProps, "ord.cancelReason.id", "0");
                Q_WebElm.myWait(1000);
                System.out.println(strIdText("ord.cancelEmailPreview.id"));
                Assert.assertTrue(strIdText("ord.cancelEmailPreview.id").contains("Our authorization system indicates that your address has not passed verification"));
                break;
            case "1":
                System.out.println("ADDRESS " + reason);
                Q_WebElm.idSelectValue(adminProps, "ord.cancelReason.id", "1");
                Q_WebElm.myWait(1000);
                System.out.println(strIdText("ord.cancelEmailPreview.id"));
                Assert.assertTrue(strIdText("ord.cancelEmailPreview.id").contains("has been canceled due to our internal reviews process"));
                break;
            case "3":
                System.out.println("HIGH RISK " + reason);
                Q_WebElm.idSelectValue(adminProps, "ord.cancelReason.id", "2");
                Q_WebElm.myWait(1000);
                System.out.println(strIdText("ord.cancelEmailPreview.id"));
                Assert.assertTrue(strIdText("ord.cancelEmailPreview.id").contains("has been canceled due to non-payment"));
                break;
            case "2":
                System.out.println("STARTER PACK " + reason);
                Q_WebElm.idSelectValue(adminProps, "ord.cancelReason.id", "3");
                Q_WebElm.myWait(1000);
                System.out.println(strIdText("ord.cancelEmailPreview.id"));
                Assert.assertTrue(strIdText("ord.cancelEmailPreview.id").contains("already placed an order for a Starter Pack"));
                break;
            default:
                System.out.println("Invalid Reason");
                break;
        }
        return this;
    }
    public static String isThereCustomerInvoice(){
        String customerOrderBexp;
        if(rowCount("ord.invoiceRows.xp")==0){
            customerOrderBexp = "cust.orderBegNoCustomerInvoice.xp";
        }
        else {
            customerOrderBexp = "cust.orderBegCustomerInvoice.xp";
        }
        return customerOrderBexp;
    }
    public Q_OrderForm obtainMLFadm(Integer begIndex, Integer endIndex, String status) {
//        System.out.println("Number of invoice before cancelltion " + rowCount("invoiceRows.xp"));
        Q_CustomerForm cust = new Q_CustomerForm();
        String customerOrderBexp = isThereCustomerInvoice();
        for(int i=begIndex; i<= endIndex; i++) {
            System.out.println(cust.strXpText(customerOrderBexp, i, "cust.orderStatus.end.xp"));
            if(Q_CustomerForm.getOrderStatus(i).equals(status)){
                cust.editOrder(customerOrderBexp, i);
                if (Q_OrderForm.orderEstCancelFee() > 0f) {
                    System.out.println("Order number: ORD-" + numberReturn("ord.OrderNumber.xp"));
                    System.out.println("Cansellation fee " + Q_OrderForm.orderEstCancelFee());
                    changeOrderStatus("cancelled");
                    break;
                }
                driver.navigate().back();
            }
        }
        return this;
    }

    public static Boolean orderNotes(String value){
        try{
            Assert.assertTrue(strXpText("ord.orderNotesAll.xp").contains(value));
            System.out.println("Verified order notes for " + value + " to be true");
            return true;
        }
        catch (Throwable ex){
            System.out.println("Verified order notes for " + value + " to be false");
            return false;
        }
    }
    public Q_OrderForm MLFadm(Integer begIndex, Integer endIndex, Float mlf, String status) {
//        System.out.println("Number of invoice before cancelltion " + rowCount("invoiceRows.xp"));
        Q_CustomerForm cust = new Q_CustomerForm();
        String customerOrderBexp = Q_OrderForm.isThereCustomerInvoice();
        for(int i=begIndex; i<= endIndex; i++) {
            if(Q_CustomerForm.getOrderStatus(i).equals(status)){
                cust.editOrder(customerOrderBexp, i);
                if (Q_OrderForm.orderEstCancelFee() > mlf){
                    System.out.println("Order number: ORD-" + numberReturn("ord.OrderNumber.xp"));
                    System.out.println("Cancellation fee " + Q_OrderForm.orderEstCancelFee());
                    changeOrderStatus("cancelled");
                    break;
                }
                else driver.navigate().back();
            }
        }
        return this;
    }
    public Q_OrderForm MLFadm(Integer begIndex, Integer endIndex, Float mlf) {
        Q_CustomerForm cust = new Q_CustomerForm();
        Q_AdminForm adm = new Q_AdminForm();
        String customerOrderBexp = Q_OrderForm.isThereCustomerInvoice();
        for(int i=begIndex; i<= endIndex; i++) {
           cust.editOrder(customerOrderBexp, i);
           if (Q_OrderForm.orderEstCancelFee() > mlf){
               System.out.println("MLF Condition " + (Q_OrderForm.orderEstCancelFee() > mlf) + "Cansellation fee " + Q_OrderForm.orderEstCancelFee());
               System.out.println("Order number: ORD-" + numberReturn("ord.OrderNumber.xp"));
               System.out.println("Cancellation fee " + Q_OrderForm.orderEstCancelFee());
               changeOrderStatus("cancelled");
               Q_WebElm.myWait(1000);
               break;
           }
            adm.adminCustomerSearch("email", "qa+1jmb@jmbullion.com");
            adm.adminViewAllOrders();
        }
        return this;
    }
    public Q_OrderForm over1k(){
        float mlf = Q_OrderForm.orderEstCancelFee();
        try{
            if(mlf>1000F)
                System.out.println("Invoice is greater than $1000.00");
            driver.navigate().refresh();
        }
        catch(Throwable ex){
        }
        return this;
    }
    public Q_OrderForm cancellationEmail(){
        ArrayList<String> reason = new ArrayList<String>(Arrays.asList("0","1", "3", "2"));
        for(int i=0; i< reason.size(); i++){
            orderCancelForm(reason.get(i));
            formId("ord.cancelReason.id");
        }
        driver.navigate().refresh();
    return this;
    }
    public Q_OrderForm skipFeeEmptyEmail(){
        Q_WebElm.idClear(adminProps, "ord.orderCancel.emailMessage.id");
        Q_WebElm.myWait(1000);
        Q_WebElm.id(adminProps, "ord.orderProcessCancellation.id");
        Q_WebElm.myWait(1000);
        Controls.getAlertText();
        return this;
    }
    public Q_OrderForm saveOrderForm(){
        Controls.scrolDownPixel(2000);
        Q_WebElm.myWait(1000);
        Assert.assertFalse(isXpCheckEnabled("ord.saveBtn.xp"));
        Assert.assertFalse(strXpText("ord.orderNotesAll.xp").contains("Order status changed from Pending to Cancelled."));

        return this;
    }
    public static String viewOrderStatus(Integer lineItem){
        return strXpText("hold.order.beg.xp",lineItem, "cust.orderStatus.end.xp");
    }
//    public Q_OrderForm editOrder(Integer row){
//        formXp("ord.orderAction.beg.xp", row, "ord.orderAction.end.xp");
//        formXp("ord.orderAction.beg.xp", row, "ord.orderActionEdit.end.xp");
//        return this;
//    }
    
    public String editOrder(Integer row){
        Q_WebElm.myWait(1000);
        String firstOrderNo = strXpText("ord.orderTop.xp");
        System.out.println("Order Number " + firstOrderNo);
        formXp("ord.orderAction.beg.xp", row, "ord.orderAction.end.xp");
        formXp("ord.orderAction.beg.xp", row, "ord.orderActionEdit.end.xp");
        return firstOrderNo;
    }
    public Q_OrderForm changeOrderStatus(String text){
        Q_WebElm.myWait(2000);
        Q_WebElm.idExecutor(adminProps, "ord.orderStatus.id");
        System.out.println(idAttRet("ord.orderStatusSelect.id", "value"));
        Q_WebElm.myWait(2000);
        switch (text) {
            case "cancelled":
                Q_WebElm.idSelectValue(adminProps, "ord.orderStatusSelect.id", text);
                break;
            case "pending":
                Q_WebElm.idSelectValue(adminProps, "ord.orderStatusSelect.id", text);
                Q_WebElm.myWait(2000);
                formInputXp("ord.orderStatusNote.xp", "Automated Test");
                formId("ord.orderStatusNoteUpdateBtn.id");
//                orderNotes("Order status changed from Paid to Pending.");
                break;
            case "paid":
                Q_WebElm.idSelectValue(adminProps, "ord.orderStatusSelect.id", text);
                Q_WebElm.myWait(500);
                formInputXp("ord.orderStatusNote.xp", "Automated Test");
                formId("ord.orderStatusNoteUpdateBtn.id");
                Q_WebElm.myWait(2000);
                orderNotes("changed from Pending to Paid");

                break;
            case "ship":
                Q_WebElm.idSelectValue(adminProps, "ord.orderStatusSelect.id", "shipped");
                Q_WebElm.myWait(2000);
                formInputXp("ord.orderStatusNote.xp", "Automated Test");
                formId("ord.orderStatusNoteUpdateBtn.id");
                break;
            case "shipped":
                Q_WebElm.idSelectValue(adminProps, "ord.orderStatusSelect.id", text);

                Q_WebElm.myWait(1500);
                formId("ord.orderStatusShippedBatchBtn.id");
                break;
            case "completed":
                Q_WebElm.idSelectValue(adminProps, "ord.orderStatusSelect.id", text);
                Q_WebElm.myWait(500);
                formInputXp("ord.orderStatusNote.xp", "Automated Test");
                formId("ord.orderStatusNoteUpdateBtn.id");
                break;
            default:
                System.out.println("Invalid order status");
        }
        return this;
    }
    public static void verifyOrderNotes(String message){
        driver.navigate().refresh();
        System.out.println(Q_WebElm.xpRetText(adminProps, "ord.orderNotesAll.xp"));
        Assert.assertTrue(Q_WebElm.xpRetText(adminProps, "ord.orderNotesAll.xp").contains(message));
    }

    public Q_OrderForm viewOrderInvoice(){
        Integer numInvoices = Q_WebElm.xpCountTableRows(adminProps, "ord.invoiceRows.xp");
        System.out.println("Number of invoice on oreder " + numInvoices);
        for(int i=1; i<= numInvoices; i++){
            System.out.println("invoice Action " + Q_WebElm.xpDisplayed(adminProps, "ord.invoiceAction.beg.xp", i, "cust.invoiceActionPay.end.xp"));
        }
    return this;
    }

    public Q_OrderForm isPaymentVisible(Float cancelFee){
        DecimalFormat df = new DecimalFormat("#.00");
        String custEmail = Q_WebElm.xpRetText(adminProps, "ord.orderDataEmailLink.xp").substring(11,27);
        System.out.println("Order email " + custEmail);
        Boolean isWaved = true;
        if(custEmail.equals("qa+1jmb@jmbullion.com")) {
            isWaved = true;
        }

        else if(custEmail.equals("qa+9jmb@jmbullion.com")) {
            isWaved = false;
        }

        Integer feeIndex ;
        if(cancelFee == 0f) {
            feeIndex = 0;
        }
        else if((cancelFee > 0f && cancelFee < 20f) && (isWaved.equals(true))){
            feeIndex = 1;

        }
        else if((cancelFee > 0f && cancelFee < 20f) && (isWaved.equals(false))){
            feeIndex = 2;
            System.out.println("Payment displayed fee never waived");
        }
        else{
            feeIndex = 3;
            System.out.println("Payment required always");
        }
        System.out.println("index is :"  + feeIndex);
        switch (feeIndex){
            case 0:
                Assert.assertFalse(isIdDisplayed("ord.orderCybersource.id"));
                System.out.println("Estimated cancel fee equal 0 no payment section");
                break;
            case 1:
                Assert.assertTrue(isXpDisplayed("ord.orderCancelAlert.xp"));
                Assert.assertTrue(isIdDisplayed("ord.orderCybersource.id"));
                System.out.println("previous fee waiver exercised display alert");
                System.out.println("cancel fee between $0 and $20 display payment section ");

                break;
            case 2:
                Assert.assertFalse(isIdDisplayed("ord.orderCancelAlert.xp"));
                Assert.assertTrue(isIdDisplayed("ord.orderCybersource.id"));
                System.out.println("No previous waiver on cancellation alert not displayed");
                System.out.println("Estimated cancel fee greater than $0 and less than $20 fill out payment section");
                break;
            case 3:
                Assert.assertTrue(isIdDisplayed("ord.orderCybersource.id"));
                System.out.println("Since cancellation fee is greater than $20 payment section always displayed");
                break;
            default:
                System.out.println("Invalid State");
                break;
        }
        driver.navigate().refresh();
        return this;
    }
    public Q_OrderForm cancelFeeWaived(){
        isIdDisplayed("ord.waivedCancelFeeMessage.xp");
        return this;
    }
    public Q_OrderForm processCancellationFee(){
        Q_WebElm.myWait(1000);
        Q_WebElm.idExecutor(adminProps, "ord.orderCybersource.id");

        Q_WebElm.idSelectIndex(adminProps, "ord.orderCybersource.id", 1);
        formXp("ord.orderProcessCancellation.xp");
        try {
            Controls.checkAlert();
            Q_WebElm.myWait(1000);
            orderMargin();
        }
        catch (Throwable e) {
            Q_WebElm.myWait(1000);
            orderMargin();
        }

        return this;
    }
    public Q_OrderForm processCancellationFailedPayment(){
        Q_WebElm.myWait(1000);
        Q_WebElm.idExecutor(adminProps, "ord.orderCybersource.id");

        Q_WebElm.idSelectIndex(adminProps, "ord.orderCybersource.id", 1);
        formXp("ord.orderCybersource.xp");
        formXp("ord.orderProcessCancellation.xp");
        orderMargin();
        return this;
    }
    public Q_OrderForm orderMargin(){
        DecimalFormat df = new DecimalFormat("#.00");
        String margin = numberReturn("ord.orderMargin.xp");
        System.out.println(" Margin = " + margin);
        Q_WebElm.myWait(2000);
        String marginReinstated = df.format(Float.valueOf(numberReturn("ord.orderReinstatedMargin.xp")));
        System.out.println(" Reinstated  Margin = " + marginReinstated);
        return this;
    }

//    public OrderForm preSaleOrder(){
//        driver.navigate().to(baseUrl + "/2-5-gram-valcambi-gold-bar/");
//        formXp("productpage.AddToCart.xp");
//        formXp("modalCheckoutNow.xp");
//        selectPaymentType("cheque");
//        Assert.assertTrue(WebElm.xpDisplayed(checkoutProps, "preSaleMsg.xp"));
//        System.out.println("Verified pre-sale check message ");
//        WebElm.id(adminProps, "preSaleMsgCheckbox.id");
//        selectcheckoutBtn("top");
//        completeOrder();
//        return this;
//    }
    public Q_OrderForm selectcheckoutBtn(String whichButton){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("checkout"))));
        formXp("fe.cartTopcheckoutnow.xp");
        return this;
    }
    public Q_OrderForm selectPaymentType(String payWith){

        try{
            switch(payWith){
                case "credit card":
                    Q_WebElm.idExecutor(adminProps, "fe.paymentType.CC.id");
                    break;
                case "paypal":
                    Q_WebElm.idExecutor(adminProps, "fe.paymentType.PP.id");
                    break;
                case "echeck":
                    Q_WebElm.idExecutor(adminProps, "fe.paymentType.EC.id");
                    break;
                case "cheque":
                    Q_WebElm.idExecutor(adminProps, "fe.paymentType.PC.id");
                    break;
                case "wire":
                    Q_WebElm.idExecutor(adminProps, "fe.paymentType.BW.id");
                    break;
                case "bitpay":
                    Q_WebElm.idExecutor(adminProps, "paymentType.BC.id");
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
    public Q_OrderForm completeOrder() {
        Controls.scrolDownPixel(300);
        formXp("fe.consent.xp");
        try {
            Q_WebElm.id(adminProps, "fe.finishAndPlace.id");
        } catch (Exception e) {
            System.out.println(e);
        }
        return this;
    }
    public String editTopOrder(){
        Q_WebElm.myWait(1000);
        String topListOrder = strXpText("ord.orderTop.xp");
        System.out.println("Order Number " + topListOrder);
        formXp("ord.orderListAction.xp");
        formXp("ord.orderActionEdit.xp");
        return topListOrder;
    }
    public Q_OrderForm orderOnHolFlag(String flag) {

        String order = flag;
        switch ( order ) {
            case ("paymentReview"):
                formId("ord.hold.payment.id");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");
                Q_WebElm.myWait(2000);
                break;
            case ("addressVerification"):
                formId("ord.hold.address.id");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");
                Q_WebElm.myWait(2000);
                break;
            case ("decisionManager"):
                formId("ord.hold.dm.id");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");

                break;
            case ("priceCheck"):
                formId("ord.hold.price.id");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");
                Q_WebElm.myWait(2000);
                break;
            case ("unpaidInvoice"):
                formId("ord.hold.invoice.id");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");
                Q_WebElm.myWait(2000);
                break;
            case ("finalReview"):
                formId("ord.hold.final.id");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");
                break;
            case ("reshipmentHold"):
                formId("ord.hold.reship.id");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");
                Q_WebElm.myWait(2000);
                break;
            case ("salesTaxIssue"):
                formId("ord.hold.sales_tax.id");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");
                Q_WebElm.myWait(2000);
                break;
            case ("billingUnpaid"):
                formId("ord.hold.fraud.id");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");
                Q_WebElm.myWait(2000);
                break;
            case ("payPalReview"):
                formId("ord.hold.paypal.id");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");
                break;
            case ("basicHold"):
                formId("ord.hold.hold.id");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");
                break;
            case ("shippingIssue"):
                formId("ord.hold.shipping.id");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");
                Q_WebElm.myWait(2000);
                break;
            case ("checkIssue"):
                formId("hold.checkIssue.id");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");
                Q_WebElm.myWait(2000);
                break;
            case ("security"):
                formId("ord.hold.security.id");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");
                Q_WebElm.myWait(2000);
                break;
            case ("starter"):
                formId("ord.hold.starter.id");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");
                Q_WebElm.myWait(2000);
                break;
            case ("postShipment"):
                Q_WebElm.cn(adminProps, "ord.hold.pstShipment.cn");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");
                Q_WebElm.myWait(2000);
                break;
            case ("achError"):
                Q_WebElm.cn(adminProps, "ord.hold.achError.cn");
                Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
                formId("ord.hold.updateHolds.id");

                break;
            default:
                System.out.println("Invalid hold flag ");
        }
        return this;
    }
    public Boolean isHoldChecked(String locator){
        Q_WebElm.cn(adminProps,locator);
        System.out.println("is checked   " + Q_WebElm.cnSelected(adminProps, locator));
        return Q_WebElm.cnSelected(adminProps, locator);
    }
    public Q_OrderForm changeHistoryPage() {
        Q_WebElm.myWait(6000);
        formId("ord.changeHistory.id");
        Q_WebElm.myWait(2000);
        Controls.switchWin();
        System.out.println("Order last History  " + strXpText("ord.historyTopRow.xp"));
        driver.close();
        Controls.switchTab(1);
        Q_WebElm.myWait(2000);
        return this;
    }
    public Q_OrderForm resetHistoryPage() {
        formId("ord.changeHistory.id");
        Q_WebElm.myWait(3000);
        Controls.switchWin();
        Q_WebElm.myWait(2000);
        System.out.println("Order History Reset " + strXpText("ord.historyTopRow.xp"));
        Controls.closeTabsSwitchWinMain();
        return this;
    }
    /***************************************************************
  	 * Description: Clear all holds from an order.
  	 * Author: Asfi Khaliq
  	 * Param: None
  	 * Returns: None 
  	 * Status: Complete
  	 **************************************************************/
	public void clearAllOrderHolds() {
		Q_OrderForm ord = new Q_OrderForm();
		Controls.xpExecutorScrollToView(adminProps, "ord.orderMargin.xp");
		int holdCount = rowCount("ord.holdReasonsList.xp");
		for (int i = 0; i < holdCount; i++) {
			try {
				Assert.assertTrue(Q_WebElm.listOfElements(adminProps, "ord.holdReasonsList.xp").get(i).isSelected());
				formXp("ord.Hold.beg.xp", i + 1, "ord.HoldInput.end.xp");
			} catch (Throwable ex) {

			}
		}
		ord.formInputId("ord.hold.notes.id", "Automated test case");
		formId("ord.hold.updateHolds.id");
		Q_WebElm.myWait(2000);
		driver.navigate().refresh();
		System.out.println("Cleared order holds");
		Q_WebElm.myWait(3000);
	}
//    public  OrderForm orderTypeParam(String type){
//        Integer orderCount = rowCount("orderRows.xp");
//        for(int i=1; i<=orderCount; i++){
//            if(attReturn("order.beg.xp", i, "orderType.end.xp", "title").equals(type)
//
//        }
//        return this;
//
//    }
public Q_OrderForm orderListParam(int j, String param){
    rowCount("ord.orderCount.xp");
    System.out.println("orders listed " + rowCount("ord.orderCount.xp"));
    Integer count;
//    System.out.println("Number of orders on page " + rowCount("orderCount.xp"));
    for(int i = 1; i <= rowCount("ord.orderCount.xp") ; i++) {

        switch ( j ) {
            case 1:
                if (strXpText("ord.order.beg.xp", i, "ord.orderList.mid.xp", 1, "ord.orderListOrderNum.end.xp").equals(param)) {
                    System.out.println("order " + strXpText("ord.order.beg.xp", i, "ord.orderList.mid.xp", 1, "ord.orderListOrderNum.end.xp"));
                    formXp("hold.order.beg.xp", i, "ord.orderAction.end.xp");
                    formXp("hold.order.beg.xp", i, "ord.orderActionEdit.end.xp");
                    count = 1;
                    break;
                }
                break;
            case 2:
                if (strXpText("ord.order.beg.xp", i, "ord.orderList.mid.xp", 2, "ord.orderListOrderNum.end.xp").contains(param)) {
                    System.out.println("order date " + strXpText("ord.order.beg.xp", i, "ord.orderList.mid.xp", 2, "ord.orderListOrderNum.end.xp"));
                    formXp("ord.orderAction.beg.xp", i, "ord.orderAction.end.xp");
                    formXp("ord.orderAction.beg.xp", i, "ord.orderActionEdit.end.xp");
                    count = 1;
                    break;
                }

                break;
            case 3:
                if (strXpText("ord.order.beg.xp", i, "ord.orderList.mid.xp", 3, "ord.orderListOrderNum.end.xp").contains(param)) {
                    System.out.println("order Total " + strXpText("ord.order.beg.xp", i, "ord.orderList.mid.xp", 3, "ord.orderListOrderNum.end.xp"));
                    formXp("ord.orderAction.beg.xp", i, "ord.orderAction.end.xp");
                    formXp("ord.orderAction.beg.xp", i, "ord.orderActionEdit.end.xp");
                    count = 1;
                    break;
                }

                break;
            case 4:
                if (attReturn("ord.order.beg.xp", i, "ord.orderType.end.xp", "title").equals(param)) {
                    System.out.println("order Payment " + attReturn("ord.order.beg.xp", i, "ord.orderType.end.xp", "title"));
                    formXp("ord.orderAction.beg.xp", i, "ord.orderAction.end.xp");
                    formXp("ord.orderAction.beg.xp", i, "ord.orderActionEdit.end.xp");
                    count = 1;
                    break;
                }

                break;
            case 5:
                if (strXpText("ord.order.beg.xp", i, "ord.orderList.mid.xp", 5, "ord.orderListOrderNum.end.xp").contains(param)) {
                    System.out.println("User " + strXpText("ord.order.beg.xp", i, "ord.orderList.mid.xp", 5, "ord.orderListOrderNum.end.xp"));
                    formXp("ord.orderAction.beg.xp", i, "ord.orderAction.end.xp");
                    formXp("ord.orderAction.beg.xp", i, "ord.orderActionEdit.end.xp");
                    count = 1;
                    break;
                }

                break;
            case 6:
                if (strXpText("ord.order.beg.xp", i, "ord.orderList.mid.xp", 6, "ord.orderListOrderNum.end.xp").equals(param)) {
                    System.out.println("Order Status " + strXpText("ord.order.beg.xp", i, "ord.orderList.mid.xp", 6, "ord.orderListOrderNum.end.xp"));
                    formXp("ord.orderAction.beg.xp", i, "ord.orderAction.end.xp");
                    formXp("ord.orderAction.beg.xp", i, "ord.orderActionEdit.end.xp");
                    count = 1;
                    break;
                }
                break;
            default:
                System.out.println("Criteria not found on this page");
                break;
        }

    }
    return this;
}
    public Q_OrderForm orderInvoice() {
        formXp("ord.orderInvoiceLink.xp");
        Controls.switchWin();
        System.out.println(strXpText("ord.invoice.shippingAdd.xp"));
        Assert.assertFalse(strXpText("ord.invoice.shippingAdd.xp").equals(null));
        Controls.closeTabsSwitchWinMain();
        return this;
    }
    public Q_OrderForm orderMarginCalculation(){
        DecimalFormat df = new DecimalFormat("#.00");
        float margin = Float.valueOf(numberReturn("ord.orderMargin.xp"));
        System.out.println(" Margin = " + margin);
        String marginReinstated = df.format(Float.valueOf(numberReturn("ord.orderReinstatedMargin.xp")));
        System.out.println(" Reinstated  Margin = " + marginReinstated);
        float cancelFee = orderEstCancelFee();
        float calculatedReinstatedMargin = margin + cancelFee;
        Assert.assertEquals(marginReinstated, df.format(calculatedReinstatedMargin));
        return this;

    }

    public static float orderEstCancelFee(){
        Float cancelFee = Float.valueOf(idNumberReturn("ord.estimatedCancelFee.id"));
        return cancelFee;
    }


    public Q_OrderForm editOrderStatus(String status){
        rowCount("ord.orderCount.xp");
        orderListParam(6, status);
        return this;
    }
    public Q_OrderForm editOrderPaymentType(Integer j, String PaymentType){
        Integer numLineItems = rowCount("hold.orderCount.xp");

        for(int i = 1; i<= rowCount("hold.orderCount.xp"); i++){
            if (attReturn("ord.order.beg.xp", i, "cust.orderType.end.xp", "title").equals(PaymentType)) {
                System.out.println("order Payment " + attReturn("ord.order.beg.xp", i, "cust.orderType.end.xp", "title"));
                formXp("ord.orderAction.beg.xp", i, "ord.orderAction.end.xp");
                formXp("ord.orderAction.beg.xp", i, "ord.orderActionEdit.end.xp");
                System.out.println("Order in edit mode: " + numberReturn("ord.OrderNumber.xp"));
                try{
                    Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps,"ord.latePaymentLink.xp").equals(true));
                    System.out.println("Is link present " + isXpDisplayed("ord.latePaymentLink.xp"));
                    formXp("ord.latePaymentLink.xp");
                    Controls.checkAlert();

                    break;
                }
                catch(Throwable ex){
                    driver.navigate().back();
                    System.out.println("skip late payment email already clicked");
                }
            }
        }
        return this;
    }
    public Q_OrderForm changeItem1Quantity(){
        String origQuantity = strXpText("ord.order.editQuantity.xp");
        System.out.println("Original quantity: " + origQuantity);
        formXp("ord.item.edit.xp");
        Q_WebElm.myWait(2000);
        formXp("ord.item.editQuantityIncrease.xp");
        formInputXp("ord.item.editNote.xp", "Automated test case");
        Q_WebElm.xpSendTab(adminProps, "ord.item.editNote.xp");
        formXp("ord.item.editUpdate.xp");
        Q_WebElm.myWait(2000);
        Q_WebElm.myWait(2000);
        String finalQuantity = strXpText("ord.order.editQuantity.xp");
        System.out.println("Edited quantity: " + finalQuantity);
        return this;
    }
    public Q_OrderForm recalculateTax(){
        Controls.scrolDownPixel(700);
        Q_WebElm.myWait(3000);
        formXp("ord.recalculatTaxBtn.xp");
        return this;
    }
    public Q_OrderForm selectPicKer(String inputText){
        formXp("ord.selectPickerDropDown.xp");
        formInputXp("ord.selectPickerInput.xp",inputText);
        Q_WebElm.myWait(5000);
        formXp("ord.selectPickerActive.xp");
        return this;
    }
    public Q_OrderForm addProduct(){
        Q_OrderForm ord = new Q_OrderForm();
        Q_WebElm.myWait(2000);
        ord.selectPicKer("1 oz Silver Bar (Varied Condition, Any");
        formInputXp("ord.itemAddQty.xp", "2");
        formInputXp("ord.itemAddNotes.xp", "automated test case");
       formXp("ord.itemAddBtn.xp");
        Q_WebElm.myWait(2000);
//        System.out.println(strXpText("order.itemStatus.xp"));
//        Assert.assertTrue(strXpText("order.itemStatus.xp").contains("tem"));
        isXpDisplayed("ord.recalculatTaxBtn.xp");
        return this;
    }
    public Q_OrderForm removeProduct(){
        Q_WebElm.myWait(1000);
        Integer numLineItems =rowCount("ord.lineItemCount.xp");
        System.out.println("Item count " + numLineItems);
        for(int i=1; i<= numLineItems; i++){
            if(strXpText("ord.lineItem.beg.xp", i, "ord.lineItem.end.xp").contains("1 oz Silver Bar (Varied Condition, Any")){
                System.out.println("Item to be deleted " + strXpText("ord.lineItem.beg.xp", i, "ord.lineItem.end.xp"));
                String qty = strXpText("ord.lineItem.beg.xp", i, "ord.lineItemQty.end.xp");
//                Controls.scrolDownPixel(100);
//                WebElm.myWait(1000);
                formXp("ord.lineItem.beg.xp", i, "ord.lineItemRemove.end.xp");
                Q_WebElm.myWait(2000);

                formXp("ord.modal.qty.xp");
                Q_WebElm.xpSelectValue(adminProps, "ord.modal.qty.xp",qty);
                formInputXp("ord.modal.notes.xp","automated test case");
                Q_WebElm.xpSendTab(adminProps, "ord.modal.notes.xp");
                formXp("ord.modal.update.btn.xp");
            }
        }
        Q_WebElm.myWait(2000);
        return this;
        }
    public Q_OrderForm buttonFullClaim(){
        Q_WebElm.myWait(2000);
        formXp("ord.initiateFullClaim.xp");
        formXp("ord.refund.reason.xp");
        formXpSelectText("ord.refund.reason.xp", "Delivered But Not Received");
        formXp("ord.refund.status.xp");
        formXpSelectText("ord.refund.status.xp", "(40%) Awaiting documents from customer");
        formXp("ord.claimResolution.xp");
        formXpSelectText("ord.claimResolution.xp", "Claim/Return");
        formXp("ord.claimDeclaration.xp");
        formXpSelectText("ord.claimDeclaration.xp", "Missing Items UPS with Signature");
        formXp("bb.claimSubmit.xp");
        return this;
    }
    public Q_OrderForm removeClaim(){
        formXp("ord.claimRemove.xp");
        Q_WebElm.myWait(1000);
        formXp("ord.claimRemoveUpdateBtn.xp");
        return this;
    }
    public Q_OrderForm buttonFullReturn(){
        DecimalFormat df = new DecimalFormat("#.00");
        String salesTax =paymentInfo("sales tax");
        String shipCost =paymentInfo("shipping cost");
        String shipTax =paymentInfo("shipping tax");
        Controls.scrolUpPixel(1000);
        formXp("ord.initiateFullReturn.xp");
        String newLineItemTotal = numberReturn("ord.fullReturnToLineItemTotal.xp");
        System.out.println("Top line item total " + newLineItemTotal);
        formXp("ord.refund.reason.xp");
        formXpSelectText("ord.refund.reason.xp", "Missing Items");
        formXp("ord.refund.status.xp");
        formXpSelectText("ord.refund.status.xp", "(80%) Pending Receipt of Returned Items");
        formXp("ord.claimResolution.xp");
        formXpSelectText("ord.claimResolution.xp", "Coupon Issued Customer Satisfied");
        formXpTab("ord.fullReturn.product1Qty.xp");
        float  totalRfundCalculated = (Float.valueOf(newLineItemTotal) + Float.valueOf(shipCost) + Float.valueOf(shipTax));
        System.out.println("Claculated total Refund " + totalRfundCalculated);
        float totalRefund = Float.valueOf(attReturn("ord.fullReturnTotalRefun.xp","value"));
        Assert.assertEquals(df.format(totalRefund), df.format(totalRfundCalculated));

        formXp("bb.claimSubmit.xp");
        Q_WebElm.myWait(2000);
        return this;
    }

    public static String paymentInfo(String topic){
        String topicValue = "";
        Controls.scrolDownPixel(1000);
        switch(topic){
            case "payment method":
                topicValue = strXpText("ord.PaymentMethod.xp");
                Controls.scrolUpPixel(1000);
                System.out.println("Order form payment type " + topicValue);
                break;
            case "order discount":
                topicValue = numberReturn("ord.Discount.xp");
                Controls.scrolUpPixel(1000);
                System.out.println("Order discount " + topicValue);
                break;
            case "cart discount":
                topicValue = numberReturn("ord.CartDisc.xp");
                Controls.scrolUpPixel(1000);
                System.out.println("Cart Discount " + topicValue);
                break;
            case "sales tax":
                topicValue = numberReturn("ord.salesTax.xp");
                Controls.scrolUpPixel(1000);
                System.out.println("Sales tax " + topicValue);
                break;
            case "shipping cost":
                topicValue = numberReturn("ord.shippingCost.xp");
                Controls.scrolUpPixel(1000);
                System.out.println("Shipping cost " + topicValue);
                break;

            case "shipping tax":
                try{
                    topicValue = numberReturn("ord.shippingTax.xp");
                    Controls.scrolUpPixel(1000);
                    System.out.println("Shipping tax " + topicValue);
                }
                catch(Throwable ex){
                    System.out.println("No shipping tax on this order");
                    topicValue = "0";
                }

                break;
            case "shipping method":
                topicValue = strXpText("ord.shippingMethod.xp");
                Controls.scrolUpPixel(1000);
                System.out.println("Shipping method " + topicValue);
                break;
            default:
                System.out.println("topic is nt a valid payment info item");
                break;

        }
        return topicValue;
    }
    public Q_OrderForm removeReturn(){
        formXp("ord.claimRemove.xp");
        Q_WebElm.myWait(1000);
        formXp("ord.claimRemoveUpdateBtn.xp");
        return this;
    }
    public Q_OrderForm buttonRefund(String orderTotal){
        formXp("ord.initiateRefund.xp");
        Q_WebElm.xpSend(adminProps, "ord.refund.reason.xp", "Automated test case");
        formXp("ord.refund.paymentMethod.xp");
        Q_WebElm.xpSelectValue(adminProps, "ord.refund.status.xp", "pending");
        Q_WebElm.xpSend(adminProps, "ord.refund.total.xp", orderTotal);
        String totalRefund = attReturn("ord.refund.total.xp","value");
        System.out.println("Refund amoount: " + totalRefund);
        formXp("ord.refund.paymentMethod.xp");
        formXpSelectText("ord.refund.paymentMethod.xp", "Credit Card");
        formXp("ord.refund.eligibleDate.xp");
        calenderDatePicker("ord.refund.eligibleDate.xp");
        Q_WebElm.myWait(2000);
        formXp("ord.refund.submit.xp");
        Q_WebElm.myWait(2000);
        return this;
    }
    public Q_OrderForm calenderDatePicker(String locator) {
        formXp(locator);
        formXp("ord.calender.nextMnth.xp");
        formXp("ord.calender.nextMnthSecWeek.xp");
        return this;
    }
    public Q_OrderForm buttonFraud(){
        Q_WebElm.myWait(1000);
        formXp("ord.fraud.xp");
        Q_WebElm.myWait(1000);
        formXp("ord.fraud.possible.xp");
        Q_WebElm.xpSend(adminProps, "ord.fraud.notes.xp", "Automated test case");
        formXpTab("ord.fraud.notes.xp");
        Q_WebElm.myWait(2000);
        formXp("ord.fraud.submit.xp");
        Q_WebElm.myWait(2000);
        isXpDisplayed("ord.fraud.warningMsg.xp");
        System.out.println("Warning Message: " + strXpText("ord.fraud.warningMsg.xp"));
        return this;
    }
    public Q_OrderForm removeFraud(){
        Q_WebElm.myWait(1000);
        formXp("ord.fraud.xp");
        Q_WebElm.myWait(1000);
        formXp("ord.fraud.possible.xp");
        Q_WebElm.xpSend(adminProps, "ord.fraud.notes.xp", "Automated test case removing fraud");
        formXpTab("ord.fraud.notes.xp");
        Q_WebElm.myWait(1000);
        formXp("ord.fraud.submit.xp");
        Q_WebElm.myWait(2000);
        Assert.assertFalse(formXpDisplayed("ord.fraud.warningMsg.xp").equals(false));

        return this;
    }
    public Q_OrderForm buttonFullReship(){
        formXp("ord.fullReship.xp");
        Q_WebElm.myWait(1000);
        Controls.switchWin();
        formInputXp("ord.fullReship.PhoneNumber.xp", "961-961-0101");
        Q_WebElm.xpSend(adminProps, "ord.fullReshipNotes.xp", "Automated test case");
        Q_WebElm.myWait(1000);
        formXp("ord.fullReshipUpdate.xp");
        Controls.closeTabsSwitchWinMain();
        driver.navigate().refresh();
        Q_WebElm.myWait(2000);
        System.out.println("Confirmed Reship " + strXpText("ord.fullReshipConfirm.xp"));
        isXpDisplayed("ord.fullReshipConfirm.xp");
        return this;
    }
    public Q_OrderForm buttonAssignSalesRep(){
        formXp("ord.assignSalesRep.xp");
        Q_WebElm.myWait(2000);
        formXp("ord.assign.salesRep.xpath");
        Q_WebElm.myWait(1000);
        Q_WebElm.xpSend(adminProps, "ord.assign.salesRepInput.xp", "qa@jmb ");
        formXp("ord.assign.salesRepResult.xp");
        formXp("ord.assign.salesRepSave.xp");
        Q_WebElm.myWait(2000);
        formXp("ord.assignSalesRep.xp");
        Q_WebElm.myWait(2000);
        Assert.assertEquals(strXpText("ord.salesRep.xp"), "QA Test");
        driver.navigate().refresh();
        return this;
    }
    public Q_OrderForm createOrderInvoice(String amount){
        Q_WebElm.myWait(500);
        formId("ord.create.invoiceCreateCategory.id");
        formIdSelectText("ord.create.invoiceCreateCategory.id", "Underpayment");
        Q_WebElm.myWait(500);
        formInputId("ord.create.invoiceCreateAmount.id", (amount));
        Q_WebElm.myWait(1000);
        Q_WebElm.idSend(adminProps, "ord.create.invoiceCreateNotes.id", "Automated Test Case");
        formId("ord.create.invoiceCreateSubmit.id");
        System.out.println("Invoice created ");

        Q_WebElm.myWait(1000);
        return this;
    }
    public Q_OrderForm editOrderInvoice(String amount){
        Q_WebElm.myWait(1000);
        formXp("ord.edit.invoice.xp");
        Controls.switchWin();
        Q_WebElm.myWait(2000);
        formInputXp("ord.edit.Amount.xp", amount);
        formXp("ord.editSave.xp");
        driver.close();
        Controls.closeTabsSwitchWinMain();
        driver.navigate().refresh();
        Q_WebElm.myWait(1000);
        Assert.assertEquals(strXpText("ord.invoiceTableAmount.xp"), amount);
        return this;
    }
    public Q_OrderForm payOrderInvoicePage() throws FileNotFoundException {
        Q_WebElm.myWait(1000);
        formXp("ord.pay.invoice.xp");
        Controls.switchWin();
        isXpDisplayed("ord.payment.invoiceCdName.xp");
        Q_WebElm.myWait(1000);
        Q_WebElm.xpSend(adminProps, "ord.payment.invoiceCvv.xp", "258");
        Q_WebElm.xpExecutor(adminProps, "ord.payment.invoiceSubmitBtn.xp");
        System.out.println("Invoice paid");
        driver.close();
        Controls.closeTabsSwitchWinMain();
        driver.navigate().refresh();
        return this;
    }
    public Q_OrderForm creditCardForm(Integer index) throws FileNotFoundException {
        CreditContainer card = new CreditContainer(index);
        Q_WebElm.myWait(2000);
        Assert.assertTrue(Q_WebElm.idDisplayed(adminProps, "ord.jm.cardName.id"));
        formInputId("ord.jm.cardName.id", card.cdName);
        formInputId("ord.jm.cardNumber.id", card.cdNumber);
        formIdSelectValue("ord.jm.cardMonth.id", card.monthV);
        formIdSelectIndex("ord.jm.cardYear.id", card.year);
        Q_WebElm.idSend(adminProps, "ord.jm.cardCvv.id", card.code);
        return this;
    }
    public Q_OrderForm payOrderInvoiceViewButton(){
        formXp("ord.view.invoice.xp");
        Controls.switchWin();
        Q_WebElm.myWait(1000);
        formXp("adm.invoice.payBtn.xp");
        Q_WebElm.myWait(1000);
        Controls.checkAlert();
        System.out.println("Invoice paid");
        Controls.closeTabsSwitchWinMain();
        return this;
    }

    public Q_OrderForm cancelOrderInvoice(){
        formXp("ord.cancel.invoice.xp");
        Controls.checkAlert();
        System.out.println("Invoice cancelled");
        return this;
    }
    public Q_OrderForm createdInvocieAmount(String invoiceAmount) {
        System.out.println("Invoice to be created for this amount "+ invoiceAmount);
        String createdInvAmt = strXpText("ord.invoiceTableAmount.xp");
        System.out.println("The created invoice amount is: " + createdInvAmt);
        Assert.assertEquals(createdInvAmt, invoiceAmount.replaceAll("[^0-9?!\\.]",""));
        Controls.closeTabsSwitchWinMain();
        return this;
    }
    public Q_OrderForm shippingDetails() throws FileNotFoundException {
        formXp("ord.editShippingDetails.xp");
        Q_WebElm.myWait(2000);
        formXp("ord.editShipp1DetailsEditBtn.xp");
        shippingDetailsForm(6);
        return this;
    }
    public Q_OrderForm shippingDetailsForm(Integer index) throws FileNotFoundException {
        Q_WebElm.myWait(1000);
        AddressContainer ship = new AddressContainer(index);
        formInputXp("ord.editShippingDetailsFname.xp", ship.firstName);
        formInputXp("ord.editShippingDetailsLname.xp", ship.lastName);
        formInputXp("ord.editShippingDetailsStreet.xp", ship.street);
        Q_WebElm.myWait(1000);
        formXpTab("ord.editShippingDetailsStreet.xp");
        Q_WebElm.myWait(1000);
        Q_WebElm.xp(adminProps,"ord.editShippingDetailsCity.xp");
        Q_WebElm.myWait(1000);
        formInputXp("ord.editShippingDetailsCity.xp", ship.city);
//        WebElm.nameClear(adminProps,"ord.editShippingDetailsCity.name");
//        WebElm.nameSend(adminProps,"ord.editShippingDetailsCity.name", ship.city);
        formXpSelectValue("ord.editShippingDetailsState.xp", ship.state);
        Q_WebElm.myWait(2000);
        formInputXp("ord.editShippingDetailsZip.xp", ship.zipcode);
        formInputXp("ord.editShippingDetailsPhone.xp", ship.phoneNumber);
        Q_WebElm.myWait(2000);
        return this;
    }
    public Q_OrderForm shippingDetailsEdit(Integer index) throws FileNotFoundException {

        AddressContainer ship = new AddressContainer(index);
        formInputXp("ord.editShippingDetailsFname.xp", ship.firstName);
        formInputXp("ord.editShippingDetailsLname.xp", ship.lastName);
        formInputXp("ord.editShippingDetailsStreet.xp", ship.street);
        formXpTab("ord.editShippingDetailsStreet.xp");
        formXpTab("ord.editShippingDetails.addr2.xp");
        Q_WebElm.myWait(1000);

        return this;
    }
    public Q_OrderForm validateShippingAdd(){
        formXp("ord.editShippingDetailsSave.xp");
        Q_WebElm.myWait(1000);
        try{
            isXpDisplayed("ord.editShippingDetailsError.xp");
            formXp("ord.editShippingDetailsContinue.xp");
        }
        catch (Throwable ex){
            System.out.println("Address saved");
        }
        formInputXp("ord.editShippingDetailsNotes.xp", "Automated test case");
        Q_WebElm.myWait(2000);
        formXpTab("ord.editShippingDetailsNotes.xp");
        formXp("ord.editShippingDetailsUpdate.xp");
        Q_WebElm.myWait(2000);
        return this;
    }
    public Q_OrderForm switchShipping() {
        Q_WebElm.myWait(1000);
        formXp("ord.editShippingDetails.xp");
        Q_WebElm.myWait(1000);
        if(isXpCheckSelected("ord.shippingRadio1Selected.xp")){
            Q_WebElm.myWait(1000);
            formXp("ord.shippingRadio2Selected.xp");

            formInputXp("ord.editShippingDetailsNotes.xp", "Automated test case");
            Q_WebElm.myWait(2000);
            formXpTab("ord.editShippingDetailsNotes.xp");
            Q_WebElm.xp(adminProps, "ord.editShippingDetailsUpdate.xp");
        }
        else{
            Q_WebElm.myWait(1000);
            formXp("ord.shippingRadio1Selected.xp");
            Q_WebElm.myWait(1000);
            formInputXp("ord.editShippingDetailsNotes.xp", "Automated test case");
            Q_WebElm.myWait(2000);
            formXpTab("ord.editShippingDetailsNotes.xp");
            formXp("ord.editShippingDetailsUpdate.xp");
        }
        return this;
    }
    public Q_OrderForm newShipping() throws FileNotFoundException {
        Q_WebElm.myWait(1000);
        formXp("ord.editShippingDetails.xp");
        Q_WebElm.myWait(2000);
        formXp("ord.shippingRadio3Selected.xp");
        shippingDetailsForm(22);
        validateShippingAdd();
        return this;
    }
    public Q_OrderForm shipPermissionDenied(Integer NumOfOptions){
        orderListParam(6,"paid");
        Integer statusOption = Q_WebElm.retXpListSize(adminProps, "ord.orderStatusOptions.xp");
        Assert.assertTrue(statusOption.equals(NumOfOptions));
        return this;
    }
    // JMB-6059 Start
    // *******************************************************************
    // * Description: Make fullreship & change status to shipped in JMB backend
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    // *******************************************************************/
    static String Esd = null;
    static SimpleDateFormat sdf;

    public static void fullReshipShipped() {
        Q_OrderForm ord = new Q_OrderForm();
        ord.formXp("ord.fullReship.xp");
        Q_WebElm.myWait(1000);
        Controls.switchWin();
        Q_WebElm.xpSend(adminProps, "ord.fullReshipNotes.xp", "Automated test case");
        ord.formXp("ord.fullReshipUpdate.xp");
        Q_WebElm.myWait(1000);
        ord.changeOrderStatus("ship");
    }
    // *******************************************************************
    // * Description: Verify the reship shipped date in JMB backend
    // * Param: String
    // * Returns: String
    // * Status: Complete
    // *******************************************************************/
    public static String verifyShipmentDateBackend() throws ParseException {
        //String Esd = null;
        //SimpleDateFormat sdf;
        Esd = Q_WebElm.xpRetText(adminProps, "ord.esd.xp");
        System.out.println("BE - Shipment Date " + Esd);
        Q_WebElm.xpDisplayed(adminProps, "ord.esd.xp");
        Date date = new Date();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        Assert.assertTrue(Esd.compareTo(sdf.format(date)) == 0);
        String url = driver.getCurrentUrl();
        String s[] = url.split("=");
        String mainOrder = s[1];
        System.out.println(mainOrder);
        Q_WebElm.myWait(3000);
        return mainOrder;
    }

    // *******************************************************************
    // * Description:JMB Frontend login
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    // *******************************************************************/
    public static void frontendLogin(Integer index) {
        driver.navigate().to(baseUrl);
        UserContainer uc = new UserContainer(index);
        Q_WebElm.id(adminProps, "acc.login.id");
        Q_WebElm.idSend(adminProps, "acc.loginEmail.id", uc.user);
        Q_WebElm.idSend(adminProps, "acc.loginPwd.id", uc.passwd);
        Q_WebElm.id(adminProps, "acc.loginSubmitBtn.id");
        Q_WebElm.myWait(2000);
    }

    // *******************************************************************
    // * Description: Verify the reship shipped date in JMB frontend
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    // *******************************************************************/
    public static void verifyshipDateFrontend() throws ParseException {

        Q_WebElm.myWait(3000);
        String orderNo = Q_WebElm.xpRetText(adminProps, "ord.shippeddate.xp");
        String s[] = orderNo.split(" ");
        sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = sdf.parse(s[2]);
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("FE-Shipment Date " + sdf.format(date));
        Assert.assertTrue(sdf.format(date).compareTo(Esd) <= 0);
        System.out.println("Frontend reship shipped date is matching with admin reship shipped date");
    }

    // *******************************************************************
    // * Description: Logout JMB frontend
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    // *******************************************************************/
    public static void logoutUser() {
        Q_WebElm.myWait(3000);
        Q_WebElm.id(adminProps, "acc.logoutLink.id");
    }
    // JMB-6059 End
    //JMB-6720 Start
    public static void changeShippingMethod(String text){
        Q_WebElm.idExecutorScrolToElement(adminProps,"ord.paymentInformationEdit.id");
        Controls.scrolUpPixel(100);
        try{
            Q_WebElm.myWait(2000);
            Q_WebElm.id(adminProps, "ord.paymentInformationEdit.id");
        }
        catch (Throwable ex){
            System.out.println(ex);
        }

        System.out.println(Q_WebElm.xpRetAttr(adminProps, "ord.paymentInformation.shippingMethodSelect.xp", "value"));
        Q_WebElm.myWait(200);
        Q_WebElm.xpSelectValue(adminProps, "ord.paymentInformation.shippingMethodSelect.xp", text);
        Q_WebElm.myWait(2000);
        Q_WebElm.xpSend(adminProps, "ord.paymentInformation.Notes.xp", "Change Shipping to: " + text);
        Q_WebElm.xp(adminProps, "ord.paymentInformation.UpdateButton.xp");
        Q_WebElm.myWait(2000);
        Assert.assertEquals(Q_WebElm.idRetText(adminProps, "ord.shippingMethodValue.id"), text, "Shipping Method change was unsuccessful");
        System.out.println("Shipping Method for order has been changed to " + text);
        Q_WebElm.myWait(1000);
    }
    //JMB-6720 End
    //JMB-6523 & JMB-6633 Start
    public static void xp(Properties proper, String catQtyBeg, String item, String catQtyEnd) {
        driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).click();
    }

    public static void id(Properties proper, String locator){
        driver.findElement(By.id(proper.getProperty(locator))).click();
    }

    public static String xpRetText(Properties proper, String catQtyBeg, String item, String catQtyEnd) {
        WebElement element = driver
                .findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd)));
        element.getText();
        return element.getText();
    }

    public static String xpRetNumber(Properties proper, String catQtyBeg, String item, String catQtyEnd) {
        return driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd)))
                .getText().replaceAll("[^0-9?!\\.]", "");
    }

    //This method checks or unchecks the list of checkboxes which are provided as input
    public  void checkBoxesHandling(Properties proper,String input, String listOfCheckBoxes) {
        try {
            switch (input) {
                case "check":
                    List<WebElement> checkBoxList = driver.findElements(By.xpath(proper.getProperty(listOfCheckBoxes)));
                    for (int elementIndex = 0; elementIndex < checkBoxList.size(); elementIndex++) {
                        if (!checkBoxList.get(elementIndex).isSelected()) {
                            checkBoxList.get(elementIndex).click();
                            System.out.println("Check box number " + elementIndex + "is checked");
                        } else {
                            System.out.println(elementIndex + " is already checked");
                        }
                    }
                    break;
                case "uncheck":
                    List<WebElement> unCheckBoxList = driver.findElements(By.xpath(proper.getProperty(listOfCheckBoxes)));
                    for (int elementIndex = 0; elementIndex < unCheckBoxList.size(); elementIndex++) {
                        if (unCheckBoxList.get(elementIndex).isSelected()) {
                            unCheckBoxList.get(elementIndex).click();
                            System.out.println("Check box number " + elementIndex + "  is  now Unchecked");
                        } else {
                            System.out.println(elementIndex + " is already un checked");
                        }
                    }
                    break;
                default:
                    System.out.println("Please provide a valid option.");
            }
        } catch (Exception e) {
            System.out.println("Problem with handling checkbox,Please see the stacktrace" + e.getStackTrace());
        }

    }

    /**
     * Verifies the product details in both Order and return Form
     * @param productName
     * @param index
     */
    public static void verifyPrdDetailsInOrderAndReturnForm(String productName, int index) {
        // --------Storing details from Order Form------------
        System.out.println("Product : " + productName);
        System.out.println("--------------------------------------------");
        String qtyInOrderForm = Q_OrderForm.xpRetText(adminProps, "ord.prdDetailsInOrderForm.beg.xp", productName,
                "ord.prdQtyInOrderFrom.end.xp");
        System.out.println("Product Quantity in Order Form: " + qtyInOrderForm);
        String totalInOrderForm = Q_OrderForm.xpRetNumber(adminProps, "ord.prdDetailsInOrderForm.beg.xp", productName,
                "ord.prdTotalInOrderForm.end.xp");
        System.out.println("Product Total in Order Form (Excluding Tax) : " + totalInOrderForm);
        String salesTaxInOrderForm = Q_OrderForm.xpRetNumber(adminProps, "ord.prdDetailsInOrderForm.beg.xp", productName,
                "ord.prdSTinOrderForm.end.xp");
        System.out.println("Product Sales Tax in Order Form : " + salesTaxInOrderForm);
        String premPaidPerUnitInOrderForm = Q_OrderForm.xpRetNumber(adminProps, "ord.prdDetailsInOrderForm.beg.xp",
                productName, "ord.prdPrePaidPUinOrderForm.end.xp");
        System.out.println("Premium Paid Per Unit in Order Form : " + premPaidPerUnitInOrderForm);
        Q_WebElm.myWait(2000);
        Q_OrderForm.xp(adminProps, "ord.prdDetailsInOrderForm.beg.xp", productName, "ord.prdDetailsInOrderForm.return.end.xp");
        // --------Storing details from Return Form-----------
        System.out.println("--------------------------------------------");
        String qtyInReturnForm = Q_WebElm.xpRetAttr(adminProps, "ord.prdItemQtyInReturnForm.beg.xp", index,
                "ord.prdOrderForm.indRetBtn.end.xp", "data-total-qty");
        System.out.println("Product Quantity in Return Form : " + qtyInReturnForm);
        String premPaidPerUnitInReturnForm = Q_OrderForm.xpRetText(adminProps, "ord.prdDetailsInReturnForm.beg.xp",
                productName, "ord.prdItemPremPaidInReturnForm.end.xp");
        System.out.println("Premium Paid in Return Form : " + premPaidPerUnitInOrderForm);
        String salesTaxInReturnForm = Q_OrderForm.xpRetText(adminProps, "ord.prdDetailsInReturnForm.beg.xp", productName,
                "ord.prdItemSTinReturnForm.end.xp");
        System.out.println("Product Sales Tax in Return Form : " + salesTaxInReturnForm);
        String lineTotalInReturnForm = Q_OrderForm.xpRetText(adminProps, "ord.prdDetailsInReturnForm.beg.xp", productName,
                "ord.prdItemLineTotal.end.xp");
        System.out.println("Product Total in Return Form (Including Tax): " + lineTotalInReturnForm);
        // --------Comparing OrderForm Details vs ReturnForm Details
        Assert.assertEquals(qtyInOrderForm, qtyInReturnForm);
        Assert.assertEquals(premPaidPerUnitInOrderForm, premPaidPerUnitInReturnForm);
        Assert.assertEquals(salesTaxInOrderForm, salesTaxInReturnForm);
        Q_WebElm.myWait(1000);
        System.out.println(((Double.parseDouble(totalInOrderForm) + Double.parseDouble(salesTaxInOrderForm))));
        Double totalInDB = (Double.parseDouble(totalInOrderForm) + Double.parseDouble(salesTaxInOrderForm));
        Assert.assertEquals(String.format("%.2f", totalInDB), lineTotalInReturnForm);
        String returnURL = driver.getCurrentUrl();
        Q_WebElm.xp(adminProps, "ord.prdReturnForm.backToOrderForm.xp");
        if (!driver.getCurrentUrl().equals(returnURL)) {
            System.out.println("[PASS] After clicking in Order# Link, successfully navigated back to Order Form.");
        } else {
            Assert.fail("[FAIL] Clicking on Order# Link,not getting navigated back to Order Form");
        }

    }
    /**
     * This method tries to test the limit restriction ( it should not be more then ordered qty )
     * @param itemName
     * @param index
     * JMB-6523 & JMB-6633
     */
    public static void verifyReturnLimitRestriction(String itemName,int index)
    {
        Q_WebElm.myWait(2000);
        Q_OrderForm.xp(adminProps, "ord.prdDetailsInOrderForm.beg.xp", itemName, "ord.prdDetailsInOrderForm.return.end.xp");
        Q_WebElm.xpClear(adminProps, "ord.prdItemQtyInReturnForm.beg.xp",index, "ord.prdOrderForm.indRetBtn.end.xp");
        Q_WebElm.xpSend(adminProps, "ord.prdItemQtyInReturnForm.beg.xp",index, "ord.prdOrderForm.indRetBtn.end.xp","5");
        Q_WebElm.myWait(1000);
        ord.formId("ord.submitBtn.id");
        Q_WebElm.myWait(1000);
        if(Controls.getAlertText().equals("You can't return ("+ itemName +") item qty more than ordered qty")) {
            System.out.println("[PASS] Alert Displayed . Can't return more than ordered Quantity");
            Controls.checkAlert();
        } else {
            Assert.fail("[FAIL] Can return more than ordred Quantity ! ");
        }

        Q_WebElm.xpExecutor(adminProps, "ord.prdReturnForm.backToOrderForm.xp");

    }
    /**
     * Method to return all the records invidually from the order form
     * JMB-6523 & JMB-6633
     */
    public Q_OrderForm returnAllProductsIndividually() {
        try {
            int count = Q_WebElm.retXpListSize(adminProps, "ord.prdOrderForm.returnBtns.xp");
            System.out.println("[INFO] There are " + count + " records to return.");
            for (int returnId = 1; returnId <= count; returnId++) {
                Q_WebElm.xp(adminProps, "ord.prdOrderForm.indRetBtn.beg.xp", returnId, "ord.prdOrderForm.indRetBtn.end.xp");
                Q_WebElm.myWait(2000);
                String urlBeforeReturn = driver.getCurrentUrl();
                Q_WebElm.id(adminProps, "ord.submitBtn.id");
                System.out.println("Returned " + Q_WebElm.xpRetText(adminProps, "ord.prdOrderForm.indPrdName.beg.xp",returnId, "ord.prdOrderForm.indRetBtn.end.xp"));
                if (!urlBeforeReturn.equals(driver.getCurrentUrl())) {
                    System.out.println("[PASS] Returned " + Q_WebElm.xpRetText(adminProps, "ord.prdOrderForm.indPrdName.beg.xp", returnId, "ord.prdOrderForm.indRetBtn.end.xp"));
                } else {
                    Assert.fail("[FAIL] Not Returned " + Q_WebElm.xpRetText(adminProps, "ord.prdOrderForm.indPrdName.beg.xp", returnId, "ord.prdOrderForm.indRetBtn.end.xp"));
                }
            }
        } catch (UnhandledAlertException alertEx) {
            Assert.fail("[INFO] Existing Return Records Found or Tried to return more than ordered Quantity.");
            System.out.println(alertEx.getStackTrace());
        }
        return this;
    }

    /**
     * Method to undo the return process ( individual returns)
     * JMB-6523 & JMB-6633
     */
    public Q_OrderForm undoReturnAllProductsIndividually() {
        int returnRecords = Q_WebElm.retXpListSize(adminProps, "ord.prdOrderForm.return.DltReturnCount.xp");
        if (returnRecords != 0) {
            for (int counter = 1; counter <= returnRecords; counter++) {
                Q_WebElm.myWait(3000);
                Q_WebElm.xp(adminProps, "ord.prdOrderForm.return.DltReturn.xp");
                Q_WebElm.xp(adminProps, "ord.prdOrderForm.return.DltBtn");
                System.out.println("[PASS] Deleted Return for Product : " + counter);

            }
        } else
            Assert.fail("[FAIL] No return records found.");
        return this;
    }

    /**
     * Method to raise "Initiate Full Return" from the admin orders page
     * JMB-6523 & JMB-6633
     */


    public Q_OrderForm initiateFullReturn() {
        int returnRecords = Q_WebElm.retXpListSize(adminProps, "ord.prdOrderForm.return.DltReturnCount.xp");
        if(returnRecords!=0)
        {
            System.out.println("[INFO] Existing Return request found,Try raising Initiate Full Refund after deleting those !");
        }
        else
        {
            Q_WebElm.xp(adminProps, "ord.initiateFullReturn.xp");
            String urlBeforeReturn=driver.getCurrentUrl();
            Q_WebElm.id(adminProps, "ord.submitBtn.id");
            Q_WebElm.myWait(3000);
            Assert.assertNotEquals(urlBeforeReturn, driver.getCurrentUrl());
            System.out.println("[PASS] Initiate Full Return :Success");
        }
        return this;
    }
    public static String xpRetText(Properties proper, String locator) {
        WebElement element = driver.findElement(By.xpath(proper.getProperty(locator)));
        element.getText();
        return element.getText();
    }
    /**
     * Veriy the product details in both Admin Order form and Return form( Qty,Total,Tax) & Check limit restriction
     * JMB-6523 & JMB-6633 
     */
    public Q_OrderForm verifyPrdDetailsAndCheckRestrictions() {
        int count = Q_WebElm.retXpListSize(adminProps, "ord.prdOrderForm.returnBtns.xp");
        for (int returnId = 1; returnId <= count; returnId++) {
            String prod = Q_WebElm.xpRetText(adminProps, "ord.prdOrderForm.indPrdName.beg.xp", returnId, "ord.prdOrderForm.indRetBtn.end.xp");
            Q_OrderForm.verifyPrdDetailsInOrderAndReturnForm(prod, returnId);
            Q_OrderForm.verifyReturnLimitRestriction(prod, returnId);
        }
        return this;
    }
    //JMB-6523 & JMB-6633 End
    
    //JMB-6798 Start
    /*******************************************************************
     * Description: Validate that Shipping Methods displayed on checkout matches expected
     * Param: String
     * Returns: NA
     * Status: Complete
     *******************************************************************/
    public static void verifyAdminOrderShippingMethods(String availableShippingMethods) {
    	List<WebElement> shippingMethods = driver.findElements(By.xpath("//div[@id='shipment_tracking']/ul/li"));
    	ArrayList<String> actualShippingMethods = new ArrayList<String>();
        ArrayList<String> expectedShippingMethods = new ArrayList<String>(Arrays.asList(availableShippingMethods.split(";")));
        String currentMethod;
    	Assert.assertFalse(shippingMethods.size() == 0,"[Fail] Unable to find avaiable shipping methods to verify on application.");
    	
    	for (int counter = 0; counter < shippingMethods.size(); counter++)
    	{
    		currentMethod = shippingMethods.get(counter).getText();
    		actualShippingMethods.add(currentMethod);
    	}
    	
    	if (!(actualShippingMethods.equals(expectedShippingMethods)))
        {
               Assert.fail("[Fail] Invalid shipping methods found. Expected values " + expectedShippingMethods + " did not match actual values" + actualShippingMethods + ".");
        }
        else
        {
               System.out.println("[Pass] Validation that shipping options " + expectedShippingMethods +" are the only options that appears.");
        }
    }
    
    /*******************************************************************
     * Description: Selects the first instance specific shipping address by zip code text
     * Param: String
     * Returns: NA
     * Status: Complete
     *******************************************************************/
    public static void selectShippingAddressByZipCode(String zip) {
    	if (!Q_WebElm.xpRetText(adminProps, "jm.reg.shippingAddressCurrentlySelected.xp").contains(zip)) {
    		Q_WebElm.xp(adminProps, "jm.reg.shippingAddressChange.xp");
    		Q_WebElm.myWait(1000);
    		driver.findElement(By.xpath(adminProps.getProperty("jm.reg.shippingAddressOptionByText.beg.xp") + zip + adminProps.getProperty("jm.reg.shippingAddressOptionByText.end.xp"))).click();
    		Q_WebElm.myWait(1000);
    	}
    }
    
    /*******************************************************************
     * Description: Adds product(s) to a regular order on front end site, 
     * navigates to checkout, selects shipping address
     * Param: String item, Integer quan, String zip
     * Returns: NA
     * Status: Complete
     *******************************************************************/
    public static void regularOrderToCheckout(String item, Integer quan, String zip) throws FileNotFoundException {
        Q_CheckoutForm chk = new Q_CheckoutForm();
        switch (item){
            case("perth10g"):
                driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar/");
            	Q_WebElm.myWait(1000);
                chk.addItemToCart(quan);
                chk.selectPaymentType("cheque");
                chk.selectcheckoutBtn("top");
                selectShippingAddressByZipCode(zip);
                break;
            case("silverEagle1994 & perth10g"):
            	driver.navigate().to(baseUrl + "/1994-american-silver-eagle/");
            	chk.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar/");
            	Q_WebElm.myWait(1000);
                chk.addItemToCart(5);
                chk.selectPaymentType("cheque");
                chk.selectcheckoutBtn("top");
                selectShippingAddressByZipCode(zip);
                break;
            case("preSale"):
                driver.navigate().to(baseUrl + "/2-5-gram-valcambi-gold-bar/");
            	Q_WebElm.myWait(1000);
                chk.addItemToCart(quan);
                chk.selectPaymentType("cheque");
                chk.formId("preSaleMsgCheckbox.id");
                chk.selectcheckoutBtn("top");
                selectShippingAddressByZipCode(zip);
                break;
            case("auto limit"):
                driver.navigate().to(baseUrl + "/1-oz-silver-bar/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("cheque");
                chk.selectcheckoutBtn("top");
                selectShippingAddressByZipCode(zip);
                break;
            case("silverEagle1994"):
                driver.navigate().to(baseUrl + "/1994-american-silver-eagle/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("cheque");
                chk.selectcheckoutBtn("top");
                //chk.cardType(3, "selectedCard.xp", "cvv.id");
                selectShippingAddressByZipCode(zip);
                break;
            case("platinumEagle1oz"):
                System.out.println("Verified user is on the customer page pages");
                driver.navigate().to(baseUrl + "/1-oz-american-platinum-eagle-varied/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("wire");
                chk.selectcheckoutBtn("top");
                selectShippingAddressByZipCode(zip);
                break;
            case("copperUSQuarter"):
                driver.navigate().to(baseUrl + "/1-oz-quarter-copper-round/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("cheque");
                chk.selectcheckoutBtn("top");
                //chk.selectPaymentType("credit card");
                //chk.selectcheckoutBtn("top");
                //chk.cardType(3, "selectedCard.xp", "cvv.id");
                selectShippingAddressByZipCode(zip);
                break;
            case("copperUSQuarter & perth10g"):
            	driver.navigate().to(baseUrl + "/1-oz-quarter-copper-round/");
            	Q_WebElm.myWait(1000);
            	chk.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar/");
            	Q_WebElm.myWait(1000);
                chk.addItemToCart(10);
                chk.selectPaymentType("cheque");
                chk.selectcheckoutBtn("top");
                selectShippingAddressByZipCode(zip);
                break;
            case("2015silverTube"):
                driver.navigate().to(baseUrl + "/2015-american-silver-eagle-tube-20-coins/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("credit card");
                chk.selectcheckoutBtn("top");
                chk.cardType(3, "fe.selectedCard.xp", "fe.cvv.id");
                selectShippingAddressByZipCode(zip);
                break;
            case("2019 1 oz Canadian Silver Maple Leaf Coin (BU)"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("credit card");
                chk.selectcheckoutBtn("top");
                chk.cardType(3, "fe.selectedCard.xp", "fe.cvv.id");
                selectShippingAddressByZipCode(zip);
                break;
            case("2019 Canadian Silver Maple Leaf Tube (25 Coins, BU)"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf-tube");
                chk.addItemToCart(quan);
                chk.selectPaymentType("credit card");
                chk.selectcheckoutBtn("top");
                chk.cardType(3, "fe.selectedCard.xp", "fe.cvv.id");
                selectShippingAddressByZipCode(zip);
                break;
            case("2019 Canadian Silver Maple Leaf Monster Box (500 Coins, BU)"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf-monster-box/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("cheque");
                chk.selectcheckoutBtn("top");
                selectShippingAddressByZipCode(zip);
                break;
            case("2019 Canadian Silver Maple Leaf Combo1"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf/");
                chk.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf-tube");
                chk.addItemToCart(quan);
                chk.selectPaymentType("credit card");
                chk.selectcheckoutBtn("top");
                chk.cardType(3, "fe.selectedCard.xp", "cvv.id");
                selectShippingAddressByZipCode(zip);
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
                selectShippingAddressByZipCode(zip);
                break;
            case("multiple products"):
                driver.navigate().to(baseUrl + "/1-oz-quarter-copper-round/");
                chk.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/1-oz-american-platinum-eagle-varied/");
                chk.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar/");
                chk.addItemToCart(quan);
                chk.selectPaymentType("cheque");
                chk.applyGiftCertificate();
                chk.selectcheckoutBtn("top");
                selectShippingAddressByZipCode(zip);
                break;
            default:
                System.out.println("Item not found");

                break;
        }
    }
    
    public static void thankYouPage() {
    	Q_WebElm.myWait(5000);
        try {
            isXpDisplayed("jm.ThankYouPage.xp");
            System.out.println("Order Number ORD-" + numberReturn("jm.orderCompleteThankYouPage.xp"));
        } catch (Throwable ex) {
            System.out.println(ex);
        }
    }
    //JMB-6798 End
    
	//JMB-6369 Start
	/**
	 * To verify if the hold is enabled
	 * @param hold
	 * @return result
	 */
	public static boolean verifyHold(String hold) {
		boolean result = false;
		for (WebElement ele : Q_WebElm.listOfElements(adminProps, "editOrder.holdList.xp")) {
			if (ele.getText().equals(hold)) {
				result = ele.isEnabled();
				break;
			}
		}
		return result;
	}
	// JMB-6369 End
	
	//JMB-6778 Start
    /**
     * Runs through order table in the FrontEnd to determine invoice status/order status 
     * @return invoice/order status
     */
    public static String orderStatus_frontEnd()	{
    	int count= rowCount("myAccount.orders.orderNo.xp");
    	List<WebElement> orderNo= Q_WebElm.listOfElements(adminProps, "myAccount.orders.orderNo.xp");
		List<WebElement> orderStatus= Q_WebElm.listOfElements(adminProps, "myAccount.orders.status.xp");
		List<WebElement> invoiceStatus= Q_WebElm.listOfElements(adminProps, "myAccount.orders.invoiceStatus.xp");
		for (int rowElement= 0; rowElement< count; rowElement++)	{
			myAccount("orders");
    		System.out.println(orderNo.get(rowElement).getText()+ " "+ orderStatus.get(rowElement).getText()+ " "+ invoiceStatus.get(rowElement).getText());
    		System.out.println(orderNo.get(rowElement+1).getText()+ " "+ orderStatus.get(rowElement).getText()+ " "+ invoiceStatus.get(rowElement+1).getText());
			if (!orderNo.get(rowElement+1).getText().startsWith("Invoice"))	{
				return orderStatus.get(rowElement).getText();
			}
			else if (orderNo.get(rowElement+1).getText().startsWith("Invoice"))	{
				return invoiceStatus.get(rowElement+1).getText();
			}
		}
		return "";
    }
    
    /**
     * Verify if Delete card link is available when all order status is complete and all invoices are paid
     * @param status
     */
    public static void verifyDeleteLink_isDisplayed_forCC(String status)	{
    	myAccount("payments");
    	switch (status)	{
    	case "Completed":	
    		Assert.assertTrue(isXpDisplayed("acc.account.paymentDeleteCard.xp"));
    		break;
    	case "Paid":	
    		Assert.assertTrue(isXpDisplayed("acc.account.paymentDeleteCard.xp"));
    		break;
    	default:
    		Assert.assertTrue(isXpDisplayed("acc.account.paymentDeleteCard.emptyBox.xp"));
    		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"payment_list\"]/div[1]/table/tbody/tr[1]/td[4]")).getText().isBlank());
    	}
    }
    
    /**
     * Changes order status for a customer from Paid to Shipped and then to Completed
     * @param email
     */
    public static void changeOrderStatus_PaidToCompleted(String email) {
    	Q_AdminForm adm = new Q_AdminForm();
    	Q_CustomerForm cust = new Q_CustomerForm();
    	Q_OrderForm ord = new Q_OrderForm();
    	adm.adminCustomerSearch("email", email);
        adm.adminViewAllOrders();
        cust.viewOrderByParam("status", "Paid");
        ord.orderOnHolFlag("security");
        ord.changeOrderStatus("ship");
        ord.changeOrderStatus("completed");
    }
	
    /**
     * Adds and saves credit card in front end
     * @param index
     * @throws FileNotFoundException
     */
	public static void addCreditCard(Integer index) throws FileNotFoundException	{
		Q_WebElm.xp(adminProps, "acc.account.addCard.xp");
		Q_OrderForm ord = new Q_OrderForm();
		ord.creditCardForm(index);
        billingAddress(3);
        Q_WebElm.id(adminProps,"acc.account.saveNewCC.id");
        Q_WebElm.myWait(5000);
        Controls.checkAndGetAlertText();
        Q_WebElm.myWait(3000);
	}
	 
	/**
	 * Navigate to My account section in front-end and choose desired sub-header
	 * @param option
	 */
	public static void navigateFrontEnd_myAccount(String option)	{
		driver.navigate().to("https://qa.jmbullion.com/my-account/");
		myAccount(option);
	}
	
	/**
	 * Input all the details required while adding credit card in front-end
	 * @param index
	 * @throws FileNotFoundException
	 */
	 public static void billingAddress(Integer index) throws FileNotFoundException {
	     AddressContainer ship = new AddressContainer(index);
	     Q_WebElm.idSend(adminProps, "chk.account.payment.newCC.fname.id", ship.firstName);
	     Q_WebElm.idSend(adminProps, "chk.account.payment.newCC.lname.id", ship.lastName);
	     Q_WebElm.idSendchord(adminProps,"chk.account.payment.newCC.street.id", ship.street);
	     Q_WebElm.idSendchord(adminProps,"chk.account.payment.newCC.city.id", ship.city);
	     Q_WebElm.idSelectValue(adminProps,"chk.account.payment.newCC.state.id", ship.state);
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS.SECONDS);
	     Q_WebElm.myWait(1000);
	     Q_WebElm.idSend(adminProps, "chk.account.payment.newCC.zicode.id", ship.zipcode);
	     Q_WebElm.idSend(adminProps, "chk.account.payment.newCC.phone.id", ship.phoneNumber);
	     Q_WebElm.myWait(1000);
	     Q_WebElm.id(adminProps,"acc.account.saveNewCC.id");
	 }
	 
	 /**
	  * Choose desired sub-header from My account section in front-end
	  * @param accTab
	  */
	 public static void myAccount(String accTab)	{
		 Q_WebElm.myWait(2000);
	     switch ( accTab ){
	     	case"orders":
	     		Q_WebElm.myWait(500);
	     		Q_WebElm.xp(adminProps, "acc.accountOrders.xp");
	     		break;
	        case"sell to us":
	        	Q_WebElm.myWait(500);
	        	Q_WebElm.xp(adminProps, "acc.accountSellToUs.xp");
	        	break;
	        case"my information":
	        	Q_WebElm.myWait(500);
	        	Q_WebElm.xp(adminProps, "acc.accountMyInfo.xp");
	        	break;
	        case"addresses":
	        	Q_WebElm.myWait(500);
	        	Q_WebElm.xp(adminProps, "acc.accountAddresses.xp");
	        	Q_WebElm.myWait(500);
	        	break;
	        case"payments":
	        	Q_WebElm.myWait(500);
	        	Q_WebElm.xp(adminProps, "acc.accountPayment.xp");
	        	Q_WebElm.myWait(2000);
	        	Assert.assertEquals(Q_WebElm.xpRetText(adminProps, "acc.account.paymentPage.xp"),"Your Credit and Debit Cards");
	        	break;
	        case"wishlist":
	        	Q_WebElm.myWait(500);
	        	Q_WebElm.xp(adminProps, "acc.accountWishList.xp");
	        	break;
	        case"alerts":
	        	Q_WebElm.xp(adminProps, "acc.accountAlerts.xp");
	        	break;
	        default:
	        	System.out.println("Invalid option for account tab");
	        	break;
	     }
	 }
	 
	 /**
	  * Deletes credit card in front-end
	  */
	 public static void deleteCreditcard()	{
		 Q_WebElm.xp(adminProps, "acc.account.paymentDeleteCard.xp");
         Q_WebElm.myWait(2000);
         Controls.checkAndGetAlertText();
         Q_WebElm.myWait(2000);
         Assert.assertTrue(Q_WebElm.idDisplayed(adminProps, "acc.account.paymentNoCard.id"));
	 }
	 
	 /**
	  * Chooses select card when multiple cards are available and enter cvv code
	  * @param index
	  * @throws FileNotFoundException
	  */
	 public static void selectCard(Integer index) throws FileNotFoundException{
		 CreditContainer card = new CreditContainer(index);
		 Q_WebElm.myWait(1000);
		 Q_WebElm.idSend(adminProps, "ord.jm.cardCvv.id", card.code);
	 }
	 
	 /**
	  * Pay unpaid invoice by navigating from My Account > Orders
	  */
	 public static void payInvoice()	{
		 myAccount("orders");
		 Q_WebElm.xp(adminProps, "myAccount.orders.payInvoiceBtn.xp");
		 Assert.assertTrue(isXpDisplayed("myAccount.payments.invoiceNo.xp"));
		 System.out.println(strXpText("myAccount.payments.invoiceNo.xp"));
	     Q_WebElm.myWait(1000);
	     Q_WebElm.xpSend(adminProps, "ord.payment.invoiceCvv.xp", "258");
	     Q_WebElm.xpExecutor(adminProps, "ord.payment.invoiceSubmitBtn.xp");
	     System.out.println("Invoice paid");
	 }
	 
	 /**
	  * Deletes cookies and login in JM back-end in new tab
	  */
	 public static void launchAdminURL_newTab()	{
		 Controls.newTab();
		 Q_WebElm.myWait(5000);
		 driver.manage().deleteAllCookies();
		 Q_WebElm.myWait(5000);
		 Controls.adminLogin();
	 }
	 
	 /**
	  * Closes current tab and deletes cookies on the previous tab
	  */
	 public static void closeCurrentTab_switchPreviousWin()	{
		  Controls.closeTabsSwitchWinMain();
	      Q_WebElm.myWait(3000);
	      driver.manage().deleteAllCookies();
	      Q_WebElm.myWait(3000);
	 }
	//JMB-6778 End
	 
	//JMB-7020 Start
    /******************************************************************
    // * Description: Verify Cancel invoice and cancel note 
    // * Param : NA
    // * Jira Ticket: JMB 7020 
    // * Status: Complete
    //*******************************************************************/
    public void cancelOrderInvoiceNew(){
    	Q_WebElm.xp(adminProps, "jm.cancelInvoice.ord.xp");
		Q_WebElm.myWait(2000);
    	Assert.assertTrue(ord.isXpDisplayed("jm.cancelModal.xp"), "Add Note Feature is displayed on cancel invoice");
    	System.out.println("Add Note Feature is displayed on cancel invoice");
        Q_WebElm.xpSend(adminProps, "jm.enterCancelNote.xp", "Automated test");
        Q_WebElm.xp(adminProps, "jm.cancelInvoice.xp");
    	Assert.assertTrue(ord.isXpDisplayed("cust.invoices.verifyCancel.xp"), "Invoice not cancelled");
        System.out.println("Invoice cancelled in admin order form page");
     }
    /******************************************************************
    // * Description: Verify Cancel invoicing and cancel note in admin reports menu by click cancel
    // * Param : NA
    // * Jira Ticket: JMB 7020 
    // * Status: Complete
    //*******************************************************************/
    public void cancelInvoicing(){
    	Q_WebElm.xp(adminProps, "jm.clickInvoicing.xp");
    	Q_WebElm.xp(adminProps, "jm.reportsInvoicingActionTop.xp");
    	Q_WebElm.xp(adminProps, "jm.reportsInvoicingCancelTop.xp");
		Q_WebElm.myWait(2000);
    	Assert.assertTrue(ord.isXpDisplayed("jm.cancelModal.xp"), "Add Note Feature is displayed on cancel invoice");
    	System.out.println("Add Note Feature is displayed on cancel invoice");
        Q_WebElm.xpSend(adminProps, "jm.enterCancelNote.xp", "Automated test");
        Q_WebElm.xp(adminProps, "jm.cancelInvoice.xp");
		Q_WebElm.myWait(2000);
        Q_WebElm.xp(adminProps, "cust.clickCancel.xp");
    	Assert.assertTrue(ord.isXpDisplayed("cust.invoices.verifyCancel.xp"), "Invoice cancelled");
        System.out.println("Invoice cancelled in admin reports menu by clicking cancel invoice");
     }
    /******************************************************************
    // * Description: Verify Cancel invoicing and cancel note in admin reports menu by click edit & cancel
    // * Param : NA
    // * Jira Ticket: JMB 7020 
    // * Status: Complete
    //*******************************************************************/
    public void cancelInvoicingEdit(){
    	Q_WebElm.xp(adminProps, "jm.clickInvoicing.xp");
    	Q_WebElm.xp(adminProps, "jm.reportsInvoicingActionTop.xp");
    	Q_WebElm.xp(adminProps, "jm.clickInvoicingEditTop.xp");
    	Q_WebElm.xp(adminProps, "jm.cancelInvoiceOnEditInvoice.xp");
		Q_WebElm.myWait(2000);
    	Assert.assertTrue(ord.isXpDisplayed("jm.cancelModal1.xp"), "Add Note Feature is displayed on cancel invoice");
    	System.out.println("Add Note Feature is displayed on cancel invoice");
        Q_WebElm.xpSend(adminProps, "jm.enterCancelNote.xp", "Automated test");
        Q_WebElm.xp(adminProps, "jm.cancelInvoice.xp");
		Q_WebElm.myWait(2000);
    	Assert.assertTrue(ord.isXpDisplayed("ord.verifyCancel.xp"), "Invoice cancelled");
        System.out.println("Invoice cancelled in admin reports menu by clicking edit & cancel invoice");
     }
	//JMB-7020 End
    
    //JMB-7003 Start
    /******************************************************************
    // * Description: Verify order margin
    // * Param : NA
    // * Jira Ticket: JMB 7003 
    // * Status: Complete
    //*******************************************************************/
    public int[] getOrderMargin(){
    	String value=Q_WebElm.xpRetText(adminProps, "jm.totalMargin.xp");
    	String[] value1=value.split(":");
    	String totalMargin=value1[1].replace("$", "");
    	System.out.println("Total Margin: "+totalMargin);
    	String qty=Q_WebElm.xpRetText(adminProps, "jm.proQty.xp");
    	System.out.println("Initial qty: "+qty);
    	Q_WebElm.xp(adminProps, "jm.clickFirstProd.xp");
		Controls.switchTab(1);
		Q_WebElm.xp(adminProps, "jm.clickJMDiscount.xp");
		int s = prod.retXpSize(adminProps, "jm.readqty.xp");
		System.out.println("size of the table "+s);
		int max =0,qtyvalueint; String qtyvalue;
		for(int index=1; index<=s;index++) {
			qtyvalue = Q_WebElm.xpRetAttr(adminProps, "jm.readqty.xp.beg",index,"jm.readqty.xp.end", "value");
			qtyvalueint=Integer.parseInt(qtyvalue);
			if (qtyvalueint>max)
				max = qtyvalueint;	
		}
		System.out.println("max value is "+max);
		Controls.switchTab(0);
		int[] quantity = {max,Integer.parseInt(qty)};
		return quantity;
    }
    /******************************************************************
    // * Description: Verify Negative Margin
    // * Param : NA
    // * Jira Ticket: JMB 7003 
    // * Status: Complete
    //*******************************************************************/
    public void verifyNegativeMargin(int max) {
		String maxValue=Integer.toString(max);
    	Q_WebElm.xp(adminProps, "jm.editItem.xp");
		Q_WebElm.xpClear(adminProps, "jm.enterQty.xp");
		Q_WebElm.xpSend(adminProps, "jm.enterQty.xp", maxValue);
		Q_WebElm.xpSend(adminProps, "jm.editNotes.xp", "Automation test");
    	Q_WebElm.xp(adminProps, "jm.updateEditBtn.xp");
    	driver.navigate().refresh();
    	String value=Q_WebElm.xpRetText(adminProps, "jm.totalMargin.xp");
    	System.out.println("Total Margin after Qty update: "+value);
    	int flag=0;
    	if(value.contains("-")) {
    		flag++;
    	}	
		Assert.assertEquals(0, flag, "Total margin contains negative value");
    }
	//JMB-7003 End
    
    //JMB-6830 Start
    /**********************************************************************
	 * Description: Verifies Secure Storage Error message displays and if Remove Storage Option button based off user permissions 
	 * Param: boolean  holdPickupOrderPermission - if user permission Hold - Pickup Order is turned on (true) or off (false)
	 * Jira Ticket: JMB-6830
	 * Status: Complete
	 **********************************************************************/
    public void verifyOrderSecureStorage(boolean holdPickupOrderPermission) {
    	boolean removeStorageOptionDisplayed;
    	
    	// Check if error message that order is to be shipped to secure storage
    	try {
    		Q_WebElm.xpDisplayed(adminProps, "ord.error.secureStorageMessage.xp");
    		System.out.println("Order does contain error message for Secure Storeage TDS"); 
        } catch (Throwable ex) {
        	Assert.fail("Order does not contain error message for Secure Storeage TDS");
        }
    	
    	// Check Remove Storage Option button is displayed or not
    	try {
    		Q_WebElm.xpDisplayed(adminProps, "ord.error.secureStorageRemoveOption.xp");
    		removeStorageOptionDisplayed = true;
        } catch (Throwable ex) {
        	removeStorageOptionDisplayed = false;
        }
    	
    	// Assert if Remove Storage Option button is displayed or not based off user permissions
        if (holdPickupOrderPermission) {
        	Assert.assertTrue(removeStorageOptionDisplayed, "Remove Storage Option button does not display with user permission turned on.");
        	System.out.println("Remove Storage Option button is displayed with user permission turned on."); 
        } else {
        	Assert.assertFalse(removeStorageOptionDisplayed, "Remove Storage Option button does display with user permission turned off.");
        	System.out.println("Remove Storage Option button is not displayed with user permission turned off."); 
        }
    }
    
    /**********************************************************************
	 * Description: Removes Secure Storage from order and verify Shipping Option changes to Base Shipping
	 * Param: None
	 * Jira Ticket: JMB-6830
	 * Status: Complete
	 **********************************************************************/
    public void removeSecureStorageFromOrder() {
    	
    	String orderShippingOption;
    	
    	// Verify Shipping Method is currently Secure Storage
    	orderShippingOption = Q_WebElm.xpRetText(adminProps, "ord.shippingMethod.xp");
    	Assert.assertTrue(orderShippingOption.equals("Store Your Metal Securely with TDS"));
    	System.out.println("Confirmed order shipping option is TDS."); 
    	
    	Q_WebElm.xp(adminProps, "ord.error.secureStorageRemoveOption.xp");
    	Q_WebElm.myWait(2000); // Need to ensure some delay before checking Shipping Option as there is no page refresh
    	
    	// Verify Shipping Method is currently Base Shipping
    	orderShippingOption = Q_WebElm.xpRetText(adminProps, "ord.shippingMethod.xp");
    	Assert.assertTrue(orderShippingOption.equals("Base Shipping"), "After removing TDS order did not change to Base Shipping.");
    	System.out.println("Confirmed order shipping option TDS was successfully removed and shipping method is now Base Shipping."); 
    	
    	
    }
    //JMB-6830 End
    
    //JMB-7249 Start
    /**********************************************************************
	 * Description: Takes the current URL and opens it in a new tab
	 * Param: None
	 * Status: Complete
	 **********************************************************************/
    public void openCurrentPageInNewTab() {
    	String currentURL = driver.getCurrentUrl();
    	Controls.newTab();    
    	driver.navigate().to(currentURL);
    }
    
    /**********************************************************************
	 * Description: Verify unable to cancel an order
	 * Param: None
	 * Status: Complete
	 **********************************************************************/
    public void verifyOrderCannotBeCanceled() {
    	Q_WebElm.id(adminProps, "ord.orderProcessCancellation.id");
    	Q_WebElm.myWait(2000);
    	Assert.assertTrue(Controls.getAlertText().contains("Order can not be cancelled at this time due to insufficient permissions."), 
     		   "User was able to successfully canel an order when it should be blocked.");
    	System.out.println("Cancel order was blocked due to lack of permissions.");
    	Controls.checkAlert();
    }
    
    /**********************************************************************
	 * Description: Verify able to cancel an order
	 * Param: None
	 * Status: Complete
	 **********************************************************************/
    public void verifyOrderCanBeCanceled() {
    	Q_WebElm.id(adminProps, "ord.orderProcessCancellation.id");
    	Q_WebElm.myWait(2000);
    	Assert.assertFalse(Controls.checkAlert(),"User was unable to successfully cancel an order.");
    	System.out.println("Cancel order was successful.");
    }
    //JMB-7249 End
    
    //JMB-7121 Start
    /******************************************************************
    // * Description: Verify order & page limit in admin list
    // * Param : NA
    // * Jira Ticket: JMB 7121 
    // * Status: Complete
    //
     * @return *******************************************************************/  
    public void verifyLimitOrderAndLimitPage() {
		int order=50;
		int totalOrders = prod.retXpSize(adminProps, "jm.numberOfOrders.xp");
		System.out.println("Total Orders: "+totalOrders);
		Assert.assertTrue(totalOrders==order, "The page is not navigates to right page");
		System.out.println("Maximun order limit is 50 in the initial page");
		int flag=0;
		for(int index=1;index<=100; index++) {
	    	Q_WebElm.xp(adminProps, "jm.nextPage.xp.beg",index,"jm.nextPage.xp.end");
			int totalOrders1 = prod.retXpSize(adminProps, "jm.numberOfOrders.xp");
			System.out.println("Total Orders: "+totalOrders);
			Assert.assertTrue(totalOrders1==order, "The page: "+index+" does not contain 50 orders");
			flag++;
			}
		System.out.println("The last page is:"+ flag);
		//verify the total page is not exceeding 100
		 try {
			    isXpDisplayed("jm.nextPage.xp");
			    Assert.fail("The total page is exceeds 100");
			 } catch (NoSuchElementException e) {
				 Assert.assertTrue(true);
				 System.out.println("The total page is not exceeding 100");
		    }
		}
 
    //JMB-7121 End
    
    // JMB-6482 Start
	/**********************************************************************
	 * Description: Verify customer fraud status in customer page 
	 * Param: None 
	 * Jira Ticket: JMB-6482 
	 * Status: Complete
	 **********************************************************************/
	public void getCustomerFraudStatus() {
		Q_WebElm.xp(adminProps, "jm.customer.xp");
		Controls.switchTab(1);
		String status = Q_WebElm.xpRetText(adminProps, "jm.custFrauded.xp");
		System.out.println("Customer Frauded status: " + status);
	}

 	/**********************************************************************
 	 * Description: Verify all order fraud status in customer page 
 	 * Param: None 
 	 * Jira Ticket: JMB-6482 
 	 * Status: Complete
 	 **********************************************************************/
 	public void verifyAllPendingOrderFraudStatus() {
 		int count = Q_WebElm.retXpListSize(adminProps, "jm.custPendingOrderStatus.xp");
 		int flag = 0;
 		for (int index = 1; index <= count; index++) {
 			String value = Q_WebElm.xpRetText(adminProps, "jm.custPendingOrdersLink.xp");
 			if (!value.contains("(F)")) {
 				flag++;
 				break;
 			}
 		}
 		if (flag == 1) {
 			System.out.println("Pending orders are not flagged");
 		} else if (flag == 0) {

 			System.out.println("Pending orders are flagged");
 		}
 	}

 	/**********************************************************************
 	* Description: Verify order fraud status for single order 
 	* Param:
 	* String 
 	* Jira Ticket: JMB-6482 
 	* Status: Complete
 	**********************************************************************/
 	public void verifyStatusUnflaggedOrder(String orderno) {
 		int s = Q_WebElm.retXpListSize(adminProps, "jm.custPendingOrderStatus.xp");
 		int flag = 0;
 		for (int i = 1; i <= s; i++) {
 			String value = Q_WebElm.xpRetText(adminProps, "jm.custPendingOrdersLink.xp");
 			if (value.contains(orderno)) {
 				if (!value.contains("(F)")) {
 					flag++;
 				}
 				break;
 			}
 		}
 		if (flag == 1) {
 			System.out.println("Removed flag for Order number: " + orderno);

 		} else if (flag == 0) {
 			Assert.fail("Flag not removed for order number: " + orderno);
 		}
 	}

 	/**********************************************************************
 	* Description: Enable fraud status in order form page by clicking Fraud button 
 	* Param: None 
 	* Jira Ticket: JMB-6482 
 	* Status: Complete
 	**********************************************************************/
 	public void enableFraud() {
 		Q_WebElm.myWait(1000);
 		ord.formXp("ord.fraud.xp");
 		Q_WebElm.myWait(1000);
 		try {
 			if (Q_WebElm.xpSelected(adminProps, "jm.fraudChecked.xp")) {
 				Q_WebElm.xp(adminProps, "jm.closePossibleFraud.xp");
 				Q_WebElm.myWait(2000);
 				System.out.println("Possible Fraud already flagged");
 			}
 		} catch (Exception e) {
 			ord.formXp("ord.fraud.possible.xp");
 			Q_WebElm.xpSend(adminProps, "ord.fraud.notes.xp", "Automated test case");
 			ord.formXpTab("ord.fraud.notes.xp");
 			Q_WebElm.myWait(2000);
 			ord.formXp("ord.fraud.submit.xp");
 			Q_WebElm.myWait(7000);
 			isXpDisplayed("ord.fraud.warningMsg.xp");
 			System.out
 					.println("Warning Message: " + strXpText("ord.fraud.warningMsg.xp") + " & Order has been flagged");
 		}
 	}

 	/**********************************************************************
 	* Description: Disable fraud status in order form page by clicking Fraud button 
 	* Param: None 
 	* Jira Ticket: JMB-6482 
 	* Status: Complete
 	**********************************************************************/
 	public void disableFraud() {
 		Q_WebElm.myWait(1000);
 		ord.formXp("ord.fraud.xp");
 		Q_WebElm.myWait(1000);
 		try {
 			if (Q_WebElm.xpSelected(adminProps, "jm.fraudChecked.xp")) {
 				ord.formXp("ord.fraud.possible.xp");
 				Q_WebElm.xpSend(adminProps, "ord.fraud.notes.xp", "Automated test case");
 				ord.formXpTab("ord.fraud.notes.xp");
 				Q_WebElm.myWait(2000);
 				ord.formXp("ord.fraud.submit.xp");
 				Q_WebElm.myWait(2000);
 				System.out.println("Possible Fraud flag is removed from order level");
 			}
 		} catch (Exception e) {
 			Q_WebElm.xp(adminProps, "jm.closePossibleFraud.xp");
 			Q_WebElm.myWait(2000);
 			System.out.println("Possible Fraud is not flagged");
 		}
 	}

 	/**********************************************************************
 	* Description: Verify Billing review status in order form page 
 	* Param:None 
 	* Jira Ticket: JMB-6482 
 	* Status: Complete
 	**********************************************************************/
 	public void verifyBillingReviewStatus() {
 		if (Q_WebElm.xpDisplayed(adminProps, "jm.billingReviewChecked.xp")) {
 			System.out.println("Billing review is flagged for new order");
 		} else {
 			Assert.fail("Billing review not flagged for new order");
 		}
 	}

 	/**********************************************************************
 	 * // * Description: Verify customer fraud status in customer page 
 	 * // * Param: None 
 	 * // * Jira Ticket: JMB-6482 
 	 * // * Status: Complete
 	 **********************************************************************/
 	public void verifyCustFraudStatusYes() {
 		Q_WebElm.xp(adminProps, "jm.customer.xp");
 		Controls.switchTab(1);
 		Q_WebElm.myWait(2000);
 		String status = Q_WebElm.xpRetText(adminProps, "jm.custFrauded.xp");
 		System.out.println("Customer Frauded status: " + status);
 		if(status.equalsIgnoreCase("Yes")){
 			System.out.println("Customer Frauded updated as Yes");
 		}
 		else {
 			Assert.fail("Customer Frauded still not flagged and status showing as No");
 		}
 	}

 	/**********************************************************************
 	 * // * Description: Remove customer fraud status in customer page 
 	 * // * Param: None 
 	 * // * Jira Ticket: JMB-6482 
 	 * // * Status: Complete
 	 **********************************************************************/

 	public void removeFraudCustomerLevel() {
 		if (Q_WebElm.xpDisplayed(adminProps, "jm.custFrauded.xp")) {
 			Q_WebElm.xpSelectValue(adminProps, "jm.custFraudedStatusSelect.xp", "0");
 			Q_WebElm.xp(adminProps, "jm.custFraudedSubmit.xp");
 			Q_WebElm.myWait(2000);
 			System.out.println("Customer Frauded removed from customer level");
 		} 
 		else {
 			Assert.fail("Customer Frauded not removed and still showing \"Yes\"");
 		}
 	}

 	/**********************************************************************
 	 * // * Description: Oder product from front end as guest user (payment type-Bankwire) 
 	 * // * Param: Integer 
 	 * // * Jira Ticket: JMB-6482 
 	 * // * Status: Complete
 	 * @throws FileNotFoundException
 	 **********************************************************************/
 	public void guestOrderBankwire(Integer quan) throws FileNotFoundException {
 		Q_CheckoutForm chk = new Q_CheckoutForm();
 		driver.get(baseUrl);
 		driver.navigate().to(baseUrl + "/1-oz-american-platinum-eagle-varied/");
 		chk.addItemToCart(quan);
 		chk.selectPaymentType("wire");
 		chk.selectcheckoutBtn("top");
 		Q_WebElm.xp(adminProps, "jm.guestOrderBtn.xp");
 		Q_WebElm.idSend(adminProps, "chk.guest.email.id", "qaguestfraudtest3@gmail.com ");
 		ord.shippingDetailsForm(1);
 		Q_WebElm.id(adminProps, "chk.shipping.validate.id");
 		Q_WebElm.myWait(2000);
 		chk.creditForm(2);
 	}

 	/**********************************************************************
 	 * // * Description: Verify fraud status 
 	 * // * Param: NA 
 	 * // * Jira Ticket: JMB-6482 
 	 * // * Status: Complete
 	 **********************************************************************/
 	public void verifyFraudStatus() {
 		enableFraud();
 		verifyCustFraudStatusYes();
 		Q_WebElm.myWait(2000);
 		verifyAllPendingOrderFraudStatus();
 	}

 	/**********************************************************************
 	 * // * Description: Verify fraud status for new order 
 	 * // * Param: NA 
 	 * // * Jira Ticket: JMB-6482 
 	 * // * Status: Complete
 	 **********************************************************************/
 	public void verifyNewOrderFraudStatus() {
 		Q_OrderForm.ordersMenu("list");
 		String orderno = editTopOrder();
 		System.out.println("ord number: " + orderno);
 		verifyBillingReviewStatus();
 		disableFraud();
 		getCustomerFraudStatus();
 		verifyStatusUnflaggedOrder(orderno);
 		removeFraudCustomerLevel();
 		verifyAllPendingOrderFraudStatus();
 	}
 	// JMB-6482 End
 	
 	//Start JMB-5343
    
	/********************************************************************
	 * Description: Verify claim invoice link and order status 
	 * Param: NA 
	 * Author: Tamilselvan
	 * Status: Complete 
	 *******************************************************************/   
    public void verifyClaimInvoiceLink() {
    	Q_WebElm.xpDisplayed(adminProps, "jm.claimInvoiceLink.xp");
    	Q_WebElm.xp(adminProps, "jm.claimInvoiceLink.xp");
		Controls.switchTab(1);
		String invoice=Q_WebElm.xpRetText(adminProps, "jm.invoice.xp");
		System.out.println("Order invoice: "+invoice);
		String orderStatus=Q_WebElm.xpRetText(adminProps, "jm.orderStatus.xp");
		System.out.println("Order Status "+orderStatus);
		Assert.assertTrue(invoice.contains("Invoice"),"Invoice values are not matched!");
		Assert.assertTrue(orderStatus.contains("Paid"),"orderStatus values are not matched!");	
    }
    //End JMB-5343
    
    //JMB-7072 Start
  	/*******************************************************************************
  	 * Description: Add SKU in an order form based on the input provided.
  	 * Author: Asfi.Khaliq
  	 * @param sku
  	 * Returns: None
  	 * Status: Complete
  	 ******************************************************************************/
  	public void addSKU(String sku)	{
  		Q_OrderForm ord = new Q_OrderForm();
  		Q_WebElm.myWait(2000);
  		ord.selectPicKer(sku);
  		ord.formInputXp("ord.itemAddQty.xp", "2");
  		ord.formInputXp("ord.itemAddNotes.xp", "automated test case");
  		ord.formXp("ord.itemAddBtn.xp");
  		Q_WebElm.myWait(2000);
  		System.out.println("SKU added successfully!");
  		ord.isXpDisplayed("ord.recalculatTaxBtn.xp");
      }
  	//JMB-7072 End
  	
  	//JMB-6541 Start
  	/********************************************************************
  	 * Description: Return order item
  	 * Author: Tamilselvan
  	 * Status: Complete 
  	 * Ticket: JMB-6541
  	 *******************************************************************/    
     public void returnOrderItem() {
      	Assert.assertTrue(isXpDisplayed("jm.returnEntireOrder.xp"));
      	System.out.println("[Pass] Return Entire Order button is displayed: Success");
      	String qty=Q_WebElm.xpRetText(adminProps, "jm.itemQty.xp");
      	System.out.println("Order Item Qty: "+qty);
      	Assert.assertTrue(isXpDisplayed("jm.returnLink.xp"));
      	System.out.println("[Pass] Return link is displayed for shipped orders: Success");
  		Q_WebElm.xp(adminProps, "jm.returnLink.xp");
  		Q_WebElm.xpClear(adminProps, "jm.returnQtyInput.xp");
  		Q_WebElm.xpSend(adminProps, "jm.returnQtyInput.xp", qty);
  		Q_WebElm.xp(adminProps, "jm.returnOrderItemSubmit.xp");
  		// verifying return entire order button disabled after return order item
  		try {
  			isXpDisplayed("jm.returnEntireOrder.xp");
  	    	Assert.fail();
  		}
  		catch(Exception e) {
  	    	System.out.println("[Pass] Return Entire Order button is disabled after return the Order Item");
  		}
  		try {
  	    	isXpDisplayed("jm.returnLink.xp");
  	    	Assert.fail();
  		}
  		catch(Exception e){
  	    	System.out.println("[Pass] Return link disabled after return the Order Item");
  		}
  	}
	/********************************************************************
	 * Description: Receive Returned order item
	 * Author: Tamilselvan
	 * Status: Complete 
	 * Ticket: JMB-6541
	 *******************************************************************/   
    public void receiveReturnOrderItem() {
		//receive returned order item
	  	Assert.assertTrue(isXpDisplayed("jm.receivedReturnItem.xp"));
	  	String qty=Q_WebElm.xpRetText(adminProps, "jm.itemQty.xp");
	  	System.out.println("Order Item Qty: "+qty);
	  	System.out.println("[Pass] Received link is displayed after return the Order Item: Success");
		Q_WebElm.xp(adminProps, "jm.receivedReturnItem.xp");
	  	Q_WebElm.myWait(3000);
		Q_WebElm.xpSelectValue(adminProps, "jm.returnReceivedItem.xp", "damaged");
		Q_WebElm.xpSelectValue(adminProps, "jm.orderRemoveQty.xp", qty);
		Q_WebElm.xpSelectValue(adminProps, "jm.receivedActionType.xp", "refund");
		Q_WebElm.xpSend(adminProps, "jm.returnItemNotes.xp", "Automated test");
		Q_WebElm.xp(adminProps, "jm.returnItemUpdate.xp");
	  	Q_WebElm.myWait(8000);
		try {
			isXpDisplayed("jm.receivedReturnItem.xp");
	    	Assert.fail();
		}
		catch(Exception e) {
	    	System.out.println("[Pass] Received link is disabled after received the returned Item");
		}
	  	Q_WebElm.myWait(5000);
	  	Assert.assertTrue(isXpDisplayed("jm.alertOrderReturn.xp"));
	  	System.out.println("[Pass] Order Item returned successfully");
		Q_WebElm.xp(adminProps, "jm.returnsLink.xp");
	  	Q_WebElm.myWait(3000);
    }
	/********************************************************************
	 * Description: Verify return log to make sure return is logged 
	 * Author: Tamilselvan
	 * Status: Complete 
	 * Ticket: JMB-6541
	 *******************************************************************/   
    public void verifyReturnLog() {
	  	String returnLog=Q_WebElm.xpRetText(adminProps, "jm.returnNotesLog.xp");
	  	System.out.println("Return Log Message: "+returnLog);
	  	Assert.assertTrue(returnLog.contains("New return created"));
	  	System.out.println("[Pass] New return has been logged in Return tap");
    }
    //JMB-6541 End
    
    //JMB-7250 Start
  	/*******************************************************************************
  	 * Description: Mark Invoice Paid in Admin through 'View'.
  	 * Author: Asfi.Khaliq
  	 * Returns: None
  	 * Status: Complete
  	 ******************************************************************************/
  	public void markInvoicePaid()	{
  		Q_WebElm.xp(adminProps, "ord.payment.viewInvoice.xp");
  		Controls.switchWin();
  		Q_WebElm.xp(adminProps, "bb.markInvoicePaid.xp");
          Controls.checkAndGetAlertText();
          Assert.assertEquals(Q_WebElm.xpRetText(adminProps, "ord.payment.markedInvoiceStatus.xp"), "Status: Paid", 
          		"Invoice payment unsuccessful");
          System.out.println("Invoice marked Paid");
  	}
  	//JMB-7250 End
  	
  	//Start JMB-7277
	/********************************************************************
	 * Description: Verify product and API amount should match
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/   
    public void verifyProductAmtAndApiAmount() {
	    int size=prod.retXpSize(adminProps, "jm.productTaxAmount.xp"),flag=0;
	    for(int index=2; index<=size;index++) {
	    	double amountDouble = Double.parseDouble(Q_WebElm.xpRetText(adminProps, "jm.productTaxAmount.xp.beg", index,"jm.productTaxAmount.xp.end"));
	    	System.out.println("Amount: "+amountDouble);
	    	if(amountDouble>0) {
		    	double apiAmountDouble = Double.parseDouble(Q_WebElm.xpRetText(adminProps, "jm.productTaxAPIAmount.xp.beg",index,"jm.productTaxAPIAmount.xp.end"));
		    	System.out.println("APIAmount: "+apiAmountDouble);
		    	Assert.assertEquals(amountDouble, apiAmountDouble);
		    	flag=1;
		    	System.out.println("[Pass] The Product Amount and API Amount are match");
	    	}
	    }
		if(flag==0){
			Assert.fail("[Fail] Product Amount/API Amount is 0 for all the products which is not expected");
	    }
    }
	/********************************************************************
	 * Description: Verify Tax messages between the regular breakdown from the tables on the top and the API breakdown
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/   
    public void verifyTaxMsgAndApiBreakdown(int orderID) {
    	Q_WebElm.myWait(3000);
		driver.get("https://qa.jmbullion.com/admin/tax-breakdown.php?order_id="+orderID);
    	String apiMessage=Q_WebElm.xpRetText(adminProps,"jm.APIMessage.xp");
    	int size=Q_WebElm.retXpListSize(adminProps,"jm.tableSize.xp");
    	for(int index=1; index<=size; index++) {
	    	String isTaxable=Q_WebElm.xpRetText(adminProps,"jm.isTaxable.xp.beg",index,"jm.isTaxable.xp.end");
	    	String productId=Q_WebElm.xpRetText(adminProps,"jm.prodId.xp.beg",index,"jm.prodId.xp.end");
	    	System.out.println("The product id: " + productId + " - Is Taxable: " +isTaxable);		  
	    	if(isTaxable.contains("Yes")) {
	    		Assert.assertTrue(apiMessage.replaceAll("\\s","").replaceAll("\\{", "").replaceAll(":", "").replaceAll("\"", "").replaceAll("\\}", "").replaceAll("\r\n", "").
	    		contains(productId+"taxabletrue"), "Taxable message and API message is not match");
	    		System.out.println("[Pass] Product is Taxable and API breakdown is displayed correctly");
	    	} else if(isTaxable.contains("No")) {
	    		Assert.assertTrue(apiMessage.replaceAll("\\s","").replaceAll("\\{", "").replaceAll(":", "").replaceAll("\"", "").replaceAll("\\}", "").replaceAll("\r\n", "").
		    	contains(productId+"taxablefalse"), "Taxable message and API message is not match");
	    		System.out.println("[Pass] Product is Taxable and API breakdown is displayed correctly");
	    	}
	    	else {
	    		Assert.fail("Taxable table value and API breakdown value is not displayed as expected");
	    	}
    	}
  	}
    //End JMB-7277
    //Start JMB-7278
    /********************************************************************
	 * Description: Select Order with Sales Tax 
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: String id
	 * Status: Complete
     * @return 
	 *******************************************************************/   
    public String selectOrderWithSalesTax(int begIndex, int endIndex, String status) {
    	for(int index=begIndex; index<= endIndex; index++) {
              String salesTax=Q_WebElm.xpRetText(adminProps, "ord.salesTax.xp");
            if(salesTax.equals("$ 0.00")) {
               ord.ordersMenu("list");
               ord.editOrder(index+1);
            } else {
                	Q_WebElm.xp(adminProps, "jm.salesTaxLink.xp");
             		Controls.switchTab(1);
             		break;
            }
    	}  
    	String url=driver.getCurrentUrl();
    	String[] id=url.split("=");
    	System.out.println("ID: "+id[1]);
    	return id[1];
        }	
    //End JMB-7278
    
    //Start JMB-6520
    /********************************************************************
	 * Description: verify Return Entire Order button displayed
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/   
    public void verifyReturnEntireOrderButtonDisplayed() {
    	Assert.assertTrue(isXpDisplayed("jm.returnEntireOrder.xp"), "Return Entire Order button is not displayed");
    	System.out.println("[Pass] Return Entire Order button is displayed: Success");
    	Q_WebElm.myWait(3000);
    }
    /********************************************************************
	 * Description: verify Received link is displayed
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
    public void receiveLinkInOrderFormDisplayed() {
    	Assert.assertTrue(isXpDisplayed("jm.receivedReturnItem.xp"), "Received link is not displayed");
    	System.out.println("[Pass] Received link is displayed after return the Order Item: Success");
    	Q_WebElm.myWait(3000);
    }
    /********************************************************************
	 * Description: verify Return Entire Order button is not displayed
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
    public void verifyReturnEntireOrderButtonNotDisplayed() {
    	try {
	    	Assert.assertTrue(!isXpDisplayed("jm.returnEntireOrder.xp"), "Return Entire Order button is displayed");
		} catch (NoSuchElementException e) {
			 Assert.assertTrue(true);
			 System.out.println("[Pass] Return Entire Order button is not displayed");
		}
    }
    /********************************************************************
	 * Description: verify Received link is not displayed
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
    public void receiveLinkInOrderFormNotDisplayed() {
    	try {
	    	Assert.assertTrue(!isXpDisplayed("jm.receivedReturnItem.xp"), "Received link is displayed");
		} catch (NoSuchElementException e) {
			 Assert.assertTrue(true);
			 System.out.println("[Pass] Received link is not displayed");
		}
    }
    //End JMB-6520
    //JMB-7089 Start
  	/***************************************************************
     * Description: Get Gold threshold value from admin Config Settings 
     * Author: Asfi Khaliq
     * Param: None
     * Returns: String gold threshold value 
     * Status: Complete
     * @return String gold threshold value
     **************************************************************/
  	public String getThresholdValue_configSettings(String value)	{
  		formXp("adm.subSetting.configSettings.xp");
  		Q_WebElm.idClear(adminProps, "adm.configSettings.goldThreshold.id");
  		Q_WebElm.idSend(adminProps, "adm.configSettings.goldThreshold.id", value);
  		Q_WebElm.id(adminProps, "fe.finishAndPlace.id");
  		return Q_WebElm.idAttrRet(adminProps, "adm.configSettings.goldThreshold.id", "value");
  	}
  	
  	/***************************************************************
     * Description: Edit quantity of a product in an order form 
     * Author: Asfi Khaliq
     * Param: String quan
     * Returns: None 
     * Status: Complete
     **************************************************************/
  	public void verifyChangedProductQty_isAboveThresholdValue(String quan, String productName, String thresholdValue)	{
  		String[] splitWeight = productName.split("\\ ");
  		int totalWeight= Integer.parseInt(splitWeight[0].toString())*Integer.parseInt(quan);
  		Assert.assertTrue(totalWeight > Integer.parseInt(getThresholdValue_configSettings(thresholdValue)), "Quantity of the product needs to be increased.");
  		System.out.println("Total weight of the product is " + totalWeight);
  	}
  	
  	/***************************************************************
     * Description: Clear all the pending invoices on the customer from admin. 
     * To update the quantity of the product so as to cross the threshold value and run the 
     * smarty to check if Shipping Hold is enabled on order form or not.
     * Author: Asfi Khaliq
     * Param: String customer, String productQty
     * Returns: None 
     * Status: Complete
     **************************************************************/
  	public void updateProductQtyBeyondThreshold_verifyShippingHoldOnOrderForm(String customer, String productQty)	{
  		Q_OrderForm ord = new Q_OrderForm();
  		Q_CustomerForm cust = new Q_CustomerForm();
  		ord.ordersMenu("list");
          ord.editTopOrder();
          ord.changeOrderStatus("paid");
          Controls.newTabLaunch("/admin");
          cust.customerPage(customer);
          payAllInvoices_customerPage(customer);
//          editProductQty_orderForm(productQty);
          Controls.newTabLaunch("/ato/smarty.php");
          Controls.closeTabsSwitchWinMain();
          driver.navigate().refresh();
          Q_WebElm.myWait(4000);
          Assert.assertEquals(isHoldChecked_withMessage("ord.hold.shipping.id"), "This order needs to ship commercially", 
          		"Incorrect message displayed.");
  	}
  	
  	/***************************************************************
     * Description: Place an order in JM frontend in a new tab and 
     * switch to main once Thank You page is displayed.
     * Author: Asfi Khaliq
     * Param: String productName
     * Returns: None 
     * Status: Complete
     **************************************************************/
  	public void placeNewOrderInNewTab(String productName, String productQty) throws FileNotFoundException	{
  		Q_CheckoutForm chk = new Q_CheckoutForm();
  		Q_OrderForm ord = new Q_OrderForm();
  		Controls.newTab();
  		driver.navigate().to(baseUrl);
  		Q_WebElm.myWait(4000);
  		chk.selectItem(productName, Integer.parseInt(productQty));
  		ord.thankYouPage();
  		Controls.closeTabsSwitchWinMain();
  	}
  	
  	/***************************************************************
     * Description: Verify if the Hold is enabled along with the required message.
     * Author: Asfi Khaliq
     * Param: String locator
     * Returns: String hold message 
     * Status: Complete
     **************************************************************/
  	public String isHoldChecked_withMessage(String locator)	{
  		Controls.xpExecutorScrollToView(adminProps, "ord.orderMargin.xp");
  		Assert.assertTrue(Q_WebElm.idSelected(adminProps, locator), "The Hold is not checked");
  		System.out.println("The Hold is enabled");
  		return strXpText("ord.holdMessage.xp");
  	}
  	
  	/***************************************************************
     * Description: Launch test shipping file of an order by extracting the 
     * order ID from its Url.
     * Author: Asfi Khaliq
     * Param: None
     * Returns: None 
     * Status: Complete
     **************************************************************/
  	public void launchTestShippingFile()	{
  		String currentUrl= driver.getCurrentUrl();
  		String testShippingUrl= "https://qa.jmbullion.com/admin/shipping-test-file.php?site=jmbullion&id=";
  		String[] orderId1 = currentUrl.split("\\=");
  		String[] orderId2 = orderId1[1].toString().split("\\&");
  		String orderId= orderId2[0].toString();
  		System.out.println("Order ID = " + orderId);
  		Controls.newTab();
  		driver.navigate().to(testShippingUrl+orderId);
  	}
  	
  	/***************************************************************
     * Description: Clear all unpaid invoices from customer page
     * Author: Asfi Khaliq
     * Param: String customer
     * Returns: None 
     * Status: Complete
     **************************************************************/
  	public void payAllInvoices_customerPage(String customer)	{
  		try	{
  			Assert.assertTrue(isXpDisplayed("cust.unpaidInvoiceHeader.xp"));
  			int noOfInvoices= rowCount("cust.noOfInvoices.xp");
  			for (int i= 0; i < noOfInvoices; i++)	{
  				Q_WebElm.listOfElements(adminProps, "cust.noOfInvoices.xp").get(i).click();
  		        Controls.switchWin();
  		        Q_WebElm.xpSend(adminProps, "ord.payment.invoiceCvv.xp", "258");
  				Q_WebElm.xpExecutor(adminProps, "ord.payment.invoiceSubmitBtn.xp");
  				Q_WebElm.myWait(2000);
  				Assert.assertEquals(Q_WebElm.xpRetText(adminProps, "ord.payment.invoice.successMsg.xp"),
  						"Your credit/debit card payment has been submitted and processed. Your invoice status has been updated to \"Paid\".",
  						"Invoice payment unsuccessful.");
  				System.out.println("Invoice paid");
  				Controls.switchTab(1);
  		        driver.navigate().refresh();
  		        payAllInvoices_customerPage(customer);
  			}
  		}
  		catch (Exception e) 	{
  			Controls.closeTabsSwitchWinMain();
  		}
  	}
  	//JMB-7089 End
  	
  	//Auto Buy Start
    /**********************************************************************
	 * Description: Edits an auto buy order from customer view
	 * Param: int index
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void adminEditAutoBuy(int index) {
    	System.out.println("order " + strXpText("cust.ordersTableAutoBuyRecord.beg.xp", index, "cust.ordersTableOrderNo.end.xp"));
        String xpath = adminProps.getProperty("cust.ordersTableAutoBuyRecord.beg.xp") + index + adminProps.getProperty("cust.ordersTableOrderNo.end.xp");
    	Controls.xpExecutorScrollElementToMiddle(xpath);
    	formXp("cust.ordersTableAutoBuyRecord.beg.xp", index, "cust.ordersTableEdit.end.xp");
        formXp("cust.ordersTableAutoBuyRecord.beg.xp", index, "cust.ordersTableDropdownEdit.end.xp"); 	
    }
    
    /**********************************************************************
	 * Description: Edits an auto buy order from customer view
	 * Param: int index
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void adminOpenAutoBuyDetials(int index) {
    	System.out.println("auto buy order " + strXpText("cust.autoBuyTable.beg.xp", index + 1, "cust.autoBuyTable.noLink.end.xp"));
        formXp("cust.autoBuyTable.beg.xp", index + 1, "cust.autoBuyTable.noLink.end.xp");
    }
    
    /**********************************************************************
	 * Description: Verifies the Order Type
	 * Param: String value
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void verifyOrderType(String value) {
    	Assert.assertEquals(strXpText("ord.orderType.end.xp"), value, "Order Types is not '" + value + "'.");
    	System.out.println("Order Type is " + value);
    }
    
    /**********************************************************************
	 * Description: Verifies the details on auto buy displays
	 * Param: None
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void verifyAutoBuyDetails () {
    	System.out.println("Auto Buy No is: " + strXpText("ord.autoBuyAdminDetails.no.xp"));
    	System.out.println("Auto Buy No is: " + strXpText("ord.autoBuyAdminDetails.status.xp"));
    	System.out.println("Auto Buy No is: " + strXpText("ord.autoBuyAdminDetails.lastOrderDate.xp"));
    	System.out.println("Auto Buy No is: " + strXpText("ord.autoBuyAdminDetails.nextRunDate.xp"));
    	System.out.println("Auto Buy No is: " + strXpText("ord.autoBuyAdminDetails.startDate.xp"));
    	System.out.println("Auto Buy No is: " + strXpText("ord.autoBuyAdminDetails.endDate.xp"));
    	System.out.println("Auto Buy No is: " + strXpText("ord.autoBuyAdminDetails.recurringInterval.xp"));
    	System.out.println("Auto Buy No is: " + strXpText("ord.autoBuyAdminDetails.paymentMethod.xp"));
    	System.out.println("Auto Buy No is: " + strXpText("ord.autoBuyAdminDetails.deliveryMethod.xp"));
    	System.out.println("Auto Buy No is: " + strXpText("ord.autoBuyAdminDetails.shippingAddress.xp"));
    	System.out.println("Auto Buy No is: " + strXpText("ord.autoBuyAdminDetails.subTotal.xp"));
    	System.out.println("Auto Buy No is: " + strXpText("ord.autoBuyAdminDetails.shipping.xp"));
    	System.out.println("Auto Buy No is: " + strXpText("ord.autoBuyAdminDetails.salesTax.xp"));
    	System.out.println("Auto Buy No is: " + strXpText("ord.autoBuyAdminDetails.shipTax.xp"));
    	System.out.println("Auto Buy No is: " + strXpText("ord.autoBuyAdminDetails.estimatedTotal.xp"));
    }
    
    /**********************************************************************
	 * Description: Edits an auto buy order from customer view
	 * Param: int index
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void adminSwitchToAutoBuy(int index) {
    	System.out.println("auto buy order " + strXpText("cust.autoBuyTable.beg.xp", index + 1, "cust.autoBuyTable.noLink.end.xp"));
    	String xpath = adminProps.getProperty("cust.autoBuyTable.beg.xp") + (index+1) + adminProps.getProperty("cust.autoBuyTable.noLink.end.xp");
    	Controls.xpExecutorScrollElementToMiddle(xpath);
        formXp("cust.autoBuyTable.beg.xp", index + 1, "cust.autoBuyTable.Action.end.xp");
        formXp("cust.autoBuyTable.beg.xp", index + 1, "cust.autoBuyTable.SwitchToEdit.end.xp");
        Assert.assertTrue(driver.getCurrentUrl().contains(baseUrl + "my-account/autobuy-cart/"), "Switch to Auto Buy did not navigate to auto buy cart.");
        System.out.println("Switch to auto buy is successful");
    }
    
    /**********************************************************************
	 * Description: Perform a date search on the auto buy margin report and verify the results
	 * Param: String fromDate, String toDate
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void autoBuyMarginReportDateSearch(String fromDate, String toDate) {
    	Q_WebElm.idClear(adminProps, "marr.fromDate.id");
    	Q_WebElm.idSend(adminProps, "marr.fromDate.id", fromDate);	
    	Q_WebElm.idSendTab(adminProps, "marr.fromDate.id");	
    	Q_WebElm.myWait(1000);
    	Q_WebElm.idClear(adminProps, "marr.toDate.id");
    	Q_WebElm.idSend(adminProps, "marr.toDate.id", toDate);
    	Q_WebElm.idSendTab(adminProps, "marr.toDate.id");	
    	Q_WebElm.myWait(1000);
    	Q_WebElm.xpSendEnter(adminProps, "marr.searchButton.xp");
    	Q_WebElm.myWait(1000);
    	boolean ajaxDisplayed = true;
    	String value = "";
    	int counter = 0;
    	int timeout = 100;
    	do {
    		value = Q_WebElm.xpRetAttr(adminProps, "marr.ajaxLoader.xp", "style");
    		if (value.contains("display: none;")) {
    			ajaxDisplayed = false;
    		} else {
    			Q_WebElm.myWait(1000);
    			counter++;
    		}
    	} while (ajaxDisplayed || counter == timeout);
    	Assert.assertFalse(!ajaxDisplayed && counter == 100, "Margin Report Search did no load within timeout of '"+ timeout +"' seconds");
    	List<WebElement>marginReportResults = driver.findElements(By.xpath(adminProps.getProperty("marr.reportTableRows.xp")));
    	Assert.assertTrue((marginReportResults.size() > 0), "No results in auto buy margin report.");
    	System.out.println("Number of auto buy orders between dates '" + fromDate + "' and '" + toDate + "' is " + marginReportResults.size());
    	System.out.println(Q_WebElm.xpRetText(adminProps, "marr.reportTableHeaderRow.xp"));
    	System.out.println(Q_WebElm.xpRetText(adminProps, "marr.reportTableTotalRow.xp"));
    }
    
    /**********************************************************************
	 * Description: Perform a date search on the auto buy sales stats report and verify the results
	 * Param: String fromDate, String toDate
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void autoBuySalesStatsReportDateSearch(String fromDate, String toDate) {
    	Q_WebElm.idClear(adminProps, "marr.fromDate.id");
    	Q_WebElm.idSend(adminProps, "marr.fromDate.id", fromDate);	
    	Q_WebElm.idSendTab(adminProps, "marr.fromDate.id");	
    	Q_WebElm.myWait(1000);
    	Q_WebElm.idClear(adminProps, "marr.toDate.id");
    	Q_WebElm.idSend(adminProps, "marr.toDate.id", toDate);
    	Q_WebElm.idSendTab(adminProps, "marr.toDate.id");	
    	Q_WebElm.myWait(1000);
    	Q_WebElm.xpSendEnter(adminProps, "marr.searchButton.xp");
    	Q_WebElm.myWait(1000);
    	boolean ajaxDisplayed = true;
    	String value = "";
    	int counter = 0;
    	int timeout = 100;
    	do {
    		value = Q_WebElm.xpRetAttr(adminProps, "marr.ajaxLoader.xp", "style");
    		if (value.contains("display: none;")) {
    			ajaxDisplayed = false;
    		} else {
    			Q_WebElm.myWait(1000);
    			counter++;
    		}
    	} while (ajaxDisplayed || counter == timeout);
    	Assert.assertFalse(!ajaxDisplayed && counter == 100, "Margin Report Search did no load within timeout of '"+ timeout +"' seconds");
    	List<WebElement>salesStatsReportResults = driver.findElements(By.xpath(adminProps.getProperty("sstr.reportTableRows.xp")));
    	Assert.assertTrue((salesStatsReportResults.size() > 0), "No results in auto buy margin report.");
    	System.out.println("Number of auto buy products between dates '" + fromDate + "' and '" + toDate + "' is " + salesStatsReportResults.size());
    	System.out.println(Q_WebElm.xpRetText(adminProps, "sstr.reportTableHeaderRow.xp"));
    	for (WebElement element: salesStatsReportResults) {
    		System.out.println(element.getText());
    	}
    }
    
    /**********************************************************************
	 * Description: Perform a date search on the auto buy sales report and verify the results
	 * Param: String fromDate, String toDate
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void autoBuySalesReportDateSearch(String fromDate, String toDate) {
    	Q_WebElm.idClear(adminProps, "abps.fromDate.id");
    	Q_WebElm.idSend(adminProps, "abps.fromDate.id", fromDate);	
    	Q_WebElm.idSendTab(adminProps, "abps.fromDate.id");	
    	Q_WebElm.myWait(1000);
    	Q_WebElm.idClear(adminProps, "abps.toDate.id");
    	Q_WebElm.idSend(adminProps, "abps.toDate.id", toDate);
    	Q_WebElm.idSendTab(adminProps, "abps.toDate.id");	
    	Q_WebElm.myWait(1000);
    	Q_WebElm.xpSendEnter(adminProps, "abps.searchButton.xp");
    	Q_WebElm.myWait(1000);
    	
    	List<WebElement>salesReportResults = driver.findElements(By.xpath(adminProps.getProperty("abps.reportTableRows.xp")));
    	Assert.assertTrue((salesReportResults.size() > 0), "No results in auto buy margin report.");
    	System.out.println("Number of auto buy sales between dates '" + fromDate + "' and '" + toDate + "' is " + salesReportResults.size());
    	for (WebElement element: salesReportResults) {
    		System.out.println(element.getText());
    	}
    }
    
    /**********************************************************************
	 * Description: Perform a date search on the auto buy failed transactions report and verify the results
	 * Param: String fromDate, String toDate
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void autoBuyFailedTransactionsMissingInventoryReportDateSearch(String fromDate, String toDate) {
    	Q_WebElm.idClear(adminProps, "marr.fromDate.id");
    	Q_WebElm.idSend(adminProps, "marr.fromDate.id", fromDate);	
    	Q_WebElm.idSendTab(adminProps, "marr.fromDate.id");	
    	Q_WebElm.myWait(1000);
    	Q_WebElm.idClear(adminProps, "marr.toDate.id");
    	Q_WebElm.idSend(adminProps, "marr.toDate.id", toDate);
    	Q_WebElm.idSendTab(adminProps, "marr.toDate.id");	
    	Q_WebElm.myWait(1000);
    	Q_WebElm.idClear(adminProps, "ftmi.customerEmail.id");
    	Q_WebElm.idClear(adminProps, "ftmi.productIdName.id");
    	Q_WebElm.xpSelectText(adminProps, "ftmi.paymentMethod.xp", "All");
    	Q_WebElm.xpSendEnter(adminProps, "ftmi.searchButton.xp");
    	Q_WebElm.myWait(20000);
    	List<WebElement>failedTransactionsReportResults = driver.findElements(By.xpath(adminProps.getProperty("sstr.reportTableRows.xp")));
    	Assert.assertTrue((failedTransactionsReportResults.size() > 0), "No results in auto buy margin report.");
    	System.out.println("Number of auto buy products between dates '" + fromDate + "' and '" + toDate + "' is " + failedTransactionsReportResults.size());
    	System.out.println(Q_WebElm.xpRetText(adminProps, "sstr.reportTableHeaderRow.xp"));
    	for (WebElement element: failedTransactionsReportResults) {
    		System.out.println(element.getText());
    	}
    }
    
    /**********************************************************************
	 * Description: Perform a search on the auto buy sales stats report and verify the results
	 * Param: String fromDate, String toDate, String custEmail, String productName, String paymentMethod
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void autoBuyFailedTransactionsMissingInventoryReportDetailedSearch(String fromDate, String toDate, String custEmail, String productName, String paymentMethod) {
    	Q_WebElm.idClear(adminProps, "marr.fromDate.id");
    	Q_WebElm.idSend(adminProps, "marr.fromDate.id", fromDate);	
    	Q_WebElm.idSendTab(adminProps, "marr.fromDate.id");	
    	Q_WebElm.myWait(1000);
    	Q_WebElm.idClear(adminProps, "marr.toDate.id");
    	Q_WebElm.idSend(adminProps, "marr.toDate.id", toDate);
    	Q_WebElm.idSendTab(adminProps, "marr.toDate.id");	
    	Q_WebElm.myWait(1000);
    	Q_WebElm.idClear(adminProps, "ftmi.customerEmail.id");
    	Q_WebElm.idSend(adminProps, "ftmi.customerEmail.id", custEmail);	
    	Q_WebElm.idSendTab(adminProps, "ftmi.customerEmail.id");	
    	Q_WebElm.myWait(1000);
    	Q_WebElm.idClear(adminProps, "ftmi.productIdName.id");
    	Q_WebElm.idSend(adminProps, "ftmi.productIdName.id", productName);	
    	Q_WebElm.idSendTab(adminProps, "ftmi.productIdName.id");	
    	Q_WebElm.myWait(1000);
    	Q_WebElm.xpSelectText(adminProps, "ftmi.paymentMethod.xp", paymentMethod);
    	Q_WebElm.myWait(1000);
    	Q_WebElm.xpSendEnter(adminProps, "ftmi.searchButton.xp");
    	Q_WebElm.myWait(10000);
    	List<WebElement>failedTransactionsReportResults = driver.findElements(By.xpath(adminProps.getProperty("sstr.reportTableRows.xp")));
    	Assert.assertTrue((failedTransactionsReportResults.size() > 0), "No results in auto buy margin report.");
    	System.out.println("Number of auto buy products between email '" + custEmail + "', product '" + productName + "' and payment method '" + paymentMethod + "'is " + failedTransactionsReportResults.size());
    	System.out.println(Q_WebElm.xpRetText(adminProps, "sstr.reportTableHeaderRow.xp"));
    	for (WebElement element: failedTransactionsReportResults) {
    		System.out.println(element.getText());
    	}
    }
    
    /**********************************************************************
	 * Description: Perform a search on the auto buy setup report and verify the results
	 * Param: String searchFor, String fromDate, String toDate, String transId, String custEmail, 
	 * 			String productName, String frequency, String paymentMethod, String status
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void autoBuySetupReportDetailedSearch(String searchFor, String fromDate, String toDate, 
    		String transId, String custEmail, String productName, String frequency, String paymentMethod, String status) {
    	String searchParams = "";
    	Q_WebElm.xpSendEnter(adminProps, "supr.reset.xp");
    	if (!searchFor.equals("")) {
    		Q_WebElm.xpSelectText(adminProps, "supr.searchFor.xp", searchFor);
    		Q_WebElm.myWait(500);
    		searchParams = searchParams + ": Search For - " + searchFor;
    	}
    	if (!fromDate.equals("")) {
	    	Q_WebElm.idClear(adminProps, "supr.fromDate.id");
	    	Q_WebElm.idSend(adminProps, "supr.fromDate.id", fromDate);	
	    	Q_WebElm.idSendTab(adminProps, "supr.fromDate.id");	
	    	Q_WebElm.myWait(500);
	    	searchParams = searchParams + ": From Date - " + fromDate;
    	}
    	if (!toDate.equals("")) {
	    	Q_WebElm.idClear(adminProps, "supr.toDate.id");
	    	Q_WebElm.idSend(adminProps, "supr.toDate.id", toDate);
	    	Q_WebElm.idSendTab(adminProps, "supr.toDate.id");	
	    	Q_WebElm.myWait(500);
	    	searchParams = searchParams + ": To Date - " + toDate;
    	}
    	if (!transId.equals("")) {
	    	Q_WebElm.idClear(adminProps, "supr.transId.id");
	    	Q_WebElm.idSend(adminProps, "supr.transId.id", transId);	
	    	Q_WebElm.idSendTab(adminProps, "supr.transId.id");	
	    	Q_WebElm.myWait(500);
	    	searchParams = searchParams + ": Transaction Id - " + transId;
    	}
    	if (!custEmail.equals("")) {
	    	Q_WebElm.idClear(adminProps, "supr.customerEmail.id");
	    	Q_WebElm.idSend(adminProps, "supr.customerEmail.id", custEmail);	
	    	Q_WebElm.idSendTab(adminProps, "supr.customerEmail.id");	
	    	Q_WebElm.myWait(500);
	    	searchParams = searchParams + ": Customer Email - " + custEmail;
    	}
    	if (!productName.equals("")) {
    		Q_WebElm.xp(adminProps, "supr.productDropdown.xp");
	    	Q_WebElm.xpSend(adminProps, "supr.productSearch.xp", productName);
	    	Q_WebElm.myWait(1000);
	    	driver.findElement(By.xpath(adminProps.getProperty("supr.productSearch.xp"))).sendKeys(Keys.DELETE);
	    	Q_WebElm.myWait(2000);
	    	searchParams = searchParams + ": Product Name - " + productName;
    	}
    	if (!frequency.equals("")) {
    		Q_WebElm.xpSelectText(adminProps, "supr.frequency.xp", frequency);
    		Q_WebElm.myWait(500);
    		searchParams = searchParams + ": Frequency - " + frequency;
    	}
    	if (!paymentMethod.equals("")) {
    		Q_WebElm.xpSelectText(adminProps, "supr.paymentMethod.xp", paymentMethod);
    		Q_WebElm.myWait(500);
    		searchParams = searchParams + ": Payment Method - " + paymentMethod;
    	}
    	if (!status.equals("")) {
    		Q_WebElm.xpSelectText(adminProps, "supr.status.xp", status);
    		Q_WebElm.myWait(500);
    		searchParams = searchParams + ": Status - " + status;
    	}
    	Q_WebElm.xpSendEnter(adminProps, "supr.searchButton.xp");
    	List<WebElement>setupReportResults = driver.findElements(By.xpath(adminProps.getProperty("supr.reportTableRows.xp")));
    	Assert.assertTrue((setupReportResults.size() > 0), "No results in auto buy margin report.");
    	System.out.println("Number of auto buy orders on setup report with the following parameters" + searchParams + " is " + setupReportResults.size());
    }
    
    /**********************************************************************
	 * Description: Verify parameters required to perform a search on auto buy setup report
	 * Param: None
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void autoBuySetupReportVerifyOptionsRequiredSearch() {
    	String searchParams = "";
    	Q_WebElm.xpSendEnter(adminProps, "supr.reset.xp");
    	Q_WebElm.xpSendEnter(adminProps, "supr.searchButton.xp");
    	Q_WebElm.myWait(2000);
    	Assert.assertTrue(Controls.checkAndGetAlertText().equals("Please specify the filter criteria to get autobuy setup data."), "Alert to enter search parameters for Setup Report did not appear.");
    	System.out.println("Alert to enter search parameters for Setup Report appeared.");
    }
    
    /**********************************************************************
	 * Description: Perform a date search on the auto buy margin report and verify the results
	 * Param: String value
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void autoBuyMarginReportShowResults(String value) {
    	Q_WebElm.xpSelectText(adminProps, "marr.showList.xp", value);
    	Q_WebElm.myWait(2000);
    	List<WebElement>marginReportResults = driver.findElements(By.xpath(adminProps.getProperty("marr.reportTableRows.xp")));
    	switch (value.toLowerCase()) {
    		case "all":
    			Assert.assertTrue((marginReportResults.size() > 0), "Verification of auto buy margin report limit to '" + value +"' failed.");
    			System.out.println("Auto Buy Margin Report Reults verification of All option passed.");
    			break;
    		default: 
    			Assert.assertTrue((marginReportResults.size() <= Integer.valueOf(value) && marginReportResults.size() > 0), "Verification of auto buy margin report limit to '" + value +"' failed.");
    			System.out.println("Auto Buy Margin Report Reults verification of '"+ value +"' option passed.");
    			break;
    	}
    	
    }
    
    /**********************************************************************
	 * Description: Perform a date search on the auto buy sales stats report and verify the results
	 * Param: String value
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void autoBuySalesStatsReportShowResults(String value) {
    	Q_WebElm.xpSelectText(adminProps, "sstr.showList.xp", value);
    	Q_WebElm.myWait(2000);
    	List<WebElement>marginReportResults = driver.findElements(By.xpath(adminProps.getProperty("sstr.reportTableRows.xp")));
    	switch (value.toLowerCase()) {
    		case "all":
    			Assert.assertTrue((marginReportResults.size() > 0), "Verification of auto buy margin report limit to '" + value +"' failed.");
    			System.out.println("Auto Buy Sales Stats Report Reults verification of All option passed.");
    			break;
    		default: 
    			Assert.assertTrue((marginReportResults.size() <= Integer.valueOf(value) && marginReportResults.size() > 0), "Verification of auto buy margin report limit to '" + value +"' failed.");
    			System.out.println("Auto Buy Sales Stats Report Reults verification of '"+ value +"' option passed.");
    			break;
    	}
    }
    
    /**********************************************************************
	 * Description: Perform a date search on the auto buy sales report and verify the results
	 * Param: String value
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void autoBuySalesReportShowResults(String value) {
    	Q_WebElm.xpSelectText(adminProps, "abps.showList.xp", value);
    	Q_WebElm.myWait(2000);
    	List<WebElement>marginReportResults = driver.findElements(By.xpath(adminProps.getProperty("abps.reportTableRows.xp")));
    	switch (value.toLowerCase()) {
    		case "all":
    			Assert.assertTrue((marginReportResults.size() > 0), "Verification of auto buy margin report limit to '" + value +"' failed.");
    			System.out.println("Auto Buy Sales Stats Report Reults verification of All option passed.");
    			break;
    		default: 
    			Assert.assertTrue((marginReportResults.size() <= Integer.valueOf(value) && marginReportResults.size() > 0), "Verification of auto buy margin report limit to '" + value +"' failed.");
    			System.out.println("Auto Buy Sales Stats Report Reults verification of '"+ value +"' option passed.");
    			break;
    	}
    }
    
    /**********************************************************************
	 * Description: Perform a date search on the auto buy sales stats report and verify the results
	 * Param: String value
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void autoBuyFailedTransactionsMissingInventoryReportShowResults(String value) {
    	Q_WebElm.xpSelectText(adminProps, "sstr.showList.xp", value);
    	Q_WebElm.myWait(2000);
    	List<WebElement>marginReportResults = driver.findElements(By.xpath(adminProps.getProperty("sstr.reportTableRows.xp")));
    	switch (value.toLowerCase()) {
    		case "all":
    			Assert.assertTrue((marginReportResults.size() > 0), "Verification of auto buy margin report limit to '" + value +"' failed.");
    			System.out.println("Auto Buy Failed Transactions Report Reults verification of 'All' option passed.");
    			break;
    		default: 
    			Assert.assertTrue((marginReportResults.size() <= Integer.valueOf(value) && marginReportResults.size() > 0), "Verification of auto buy margin report limit to '" + value +"' failed.");
    			System.out.println("Auto Buy Failed Transactions Report Reults verification of '"+ value +"' option passed.");
    			break;
    	}
    }
    /**********************************************************************
	 * Description: Perform a search by a specific order number and only one results gets filtered
	 * Param: int index
	 * Jira Ticket:
	 * Status: Complete
	 **********************************************************************/
    public void autoBuyMarginReportSearchByOrder(int index) {
    	// Clear out previous search
    	Q_WebElm.xpClear(adminProps, "marr.searchInput.xp");
    	Q_WebElm.xpSendTab(adminProps, "marr.searchInput.xp");
    	Q_WebElm.myWait(1000);
    	
    	// Enter new search
    	String value = Q_WebElm.xpRetText(adminProps, "marr.reportTableRow.beg.xp", index, "marr.reportTableOrderNumberLink.end.xp");
    	Q_WebElm.xpSend(adminProps, "marr.searchInput.xp", value);	
    	Q_WebElm.xpSendTab(adminProps, "marr.searchInput.xp");	
    	Q_WebElm.myWait(1000);
    	
    	// Verify only on results returned
    	List<WebElement>marginReportResults = driver.findElements(By.xpath(adminProps.getProperty("marr.reportTableRows.xp")));
    	Assert.assertTrue ((marginReportResults.size() > 0), "Failed to filter results by order number '" + value + "'.");
    	System.out.println("Auto Buy Margin Report Filter results by just oreder number '"+ value +"' passed.");
    	
    }
    
    /**********************************************************************
	 * Description: Perform a search by a specific product name and only one results gets filtered on Sales Search Report
	 * Param: String value
	 * Status: Complete
	 **********************************************************************/
    public void autoBuySalesStatsReportSearchByProductName(String value) {
    	// Clear out previous search
    	Q_WebElm.xpClear(adminProps, "marr.searchInput.xp");
    	Q_WebElm.xpSendTab(adminProps, "marr.searchInput.xp");
    	Q_WebElm.myWait(1000);
    	
    	// Enter new search
    	Q_WebElm.xpSend(adminProps, "marr.searchInput.xp", value);	
    	Q_WebElm.xpSendTab(adminProps, "marr.searchInput.xp");	
    	Q_WebElm.myWait(1000);
    	
    	// Verify only on results returned
    	List<WebElement>marginReportResults = driver.findElements(By.xpath(adminProps.getProperty("sstr.reportTableRows.xp")));
    	Assert.assertTrue ((marginReportResults.size() > 0), "Failed to filter results by order number '" + value + "'.");
    	System.out.println("Auto Buy Margin Report Filter results by just oreder number '" + value + "' passed.");	
    }
    
    /**********************************************************************
	 * Description: Perform a search by a specific product name and only one results gets filtered on Sales Search Report
	 * Param: String value
	 * Status: Complete
	 **********************************************************************/
    public void autoBuySalesReportSearchByProductName(String value) {
    	// Clear out previous search
    	Q_WebElm.xpClear(adminProps, "marr.searchInput.xp");
    	Q_WebElm.xpSendTab(adminProps, "marr.searchInput.xp");
    	Q_WebElm.myWait(1000);
    	
    	// Enter new search
    	Q_WebElm.xpSend(adminProps, "marr.searchInput.xp", value);	
    	Q_WebElm.xpSendTab(adminProps, "marr.searchInput.xp");	
    	Q_WebElm.myWait(1000);
    	
    	// Verify only on results returned
    	List<WebElement>marginReportResults = driver.findElements(By.xpath(adminProps.getProperty("abps.reportTableRows.xp")));
    	Assert.assertTrue ((marginReportResults.size() > 0), "Failed to filter results by order number '" + value + "'.");
    	System.out.println("Auto Buy Margin Report Filter results by just oreder number '" + value + "' passed.");	
    }
    
    /**********************************************************************
	 * Description: Perform a search by a specific product name and results get properly filtered for Failed Transaction Missing Inventory Report
	 * Param: String value
	 * Status: Complete
	 **********************************************************************/
    public void autoBuyFailedTransactionsMissingInventoryReportSearchByProductName(String value) {
    	// Clear out previous search
    	Q_WebElm.xpClear(adminProps, "marr.searchInput.xp");
    	Q_WebElm.xpSendTab(adminProps, "marr.searchInput.xp");
    	Q_WebElm.myWait(1000);
    	
    	// Enter new search
    	Q_WebElm.xpSend(adminProps, "marr.searchInput.xp", value);	
    	Q_WebElm.xpSendTab(adminProps, "marr.searchInput.xp");	
    	Q_WebElm.myWait(1000);
    	
    	// Verify only on results returned
    	List<WebElement>failedTransactionsReportResults = driver.findElements(By.xpath(adminProps.getProperty("sstr.reportTableRows.xp")));
    	Assert.assertTrue ((failedTransactionsReportResults.size() > 0), "Failed to filter results by order number '" + value + "'.");
    	System.out.println("Auto Buy Failed Transactions Report Filter results by just oreder number '" + value + "' passed.");	
    }
    //Auto Buy End
    
    // Start JMB-8022
    /************************************************************************************
    // * Description:To Verify Payment Information Button Displayed On completed orders
    // * Param : NA
    // * Returns: NA
    // * Jira Ticket: JMB 8022
    // * Status: Completed
    /************************************************************************************/    
    
    	public void verifyPaymentInformationButtonIsDisplayed() {
    	Q_WebElm.idExecutorScrolToElement(adminProps,"ord.paymentInformationEdit.id");
    	Q_WebElm.myWait(2000);
    	Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps,"ord.paymentInformationButton.xp"));
    	System.out.println("Payment Information button on Completed orders is displayed: Success");
   } 
    // End JMB-8022
    	
	//JMB-4501 Start
	/******************************************************************
    // * Description: To update Cancellation details in Orders form page 
    // * Param : String refund
    // * Jira Ticket: JMB 4501
    // * Status: Completed
    //*******************************************************************/   
	public void cancelOrderWithPotentialRefund(String refund) throws FileNotFoundException {		
		ord.changeOrderStatus("cancelled");
		Q_WebElm.xpClear(adminProps, "adm.editOrder.cancelPotentialRefund.xp");
		Q_WebElm.xpSend(adminProps, "adm.editOrder.cancelPotentialRefund.xp", refund);
		Q_WebElm.xp(adminProps, "adm.editOrder.processCancellation.xp");		
	}

	/******************************************************************
    // * Description: To set Large Invoice Threshold value in Config Settings  
    // * Param : String thresholdValue
    // * Jira Ticket: JMB 4501
    // * Status: Completed
    //*******************************************************************/   
	public void setLargeInvoiceThreshold(String thresholdValue) {
		Q_WebElm.xpClear(adminProps, "adm.config.invoiceThreshold.xp");
		Q_WebElm.xpSend(adminProps, "adm.config.invoiceThreshold.xp", thresholdValue);
		Q_WebElm.xp(adminProps, "adm.saveConfigSettings.xp");
	}
	//JMB-4501 End
	
	//JMB-7253 Start
    
    //*******************************************************************
    // * Description: 	In Admin Claim form page click and edit the Order Claim Status 
    // * Author		:	Vignesh
    // * Param		:	String value
    // * Returns	:	NA
    //*******************************************************************/
    public Q_OrderForm adminClaimFormEditOrderClaimStatus(String value) {
        Q_WebElm.xpExecutorScrolToElement(adminProps,"adm.adminClaimForm.statusDropdown.btn.xp");
        Controls.scrolUpPixel(100);
        Q_WebElm.myWait(200);
        Q_WebElm.xpSelectValue(adminProps, "adm.adminClaimForm.statusDropdown.btn.xp", value);
        System.out.println("Order Claim Status for order has been changed to " + value);
    	return this;
    }
    
    //JMB-7253 End
    
    
    //JMB-7316 Start

    public Q_OrderForm verifyPreSelectedShippingMethod(String shippingMethod) {
    	Q_WebElm.idExecutorScrolToElement(adminProps,"ord.paymentInformationEdit.id");
    	Controls.scrolUpPixel(100);
    	try{
    		Q_WebElm.myWait(2000);
    		Q_WebElm.id(adminProps, "ord.paymentInformationEdit.id");
    	}
    	catch (Throwable ex){
    		System.out.println(ex);
    	}
        Assert.assertEquals(Q_WebElm.xpRetAttr(adminProps, "ord.paymentInformation.shippingMethodSelect.xp", "value"), shippingMethod, "Pre-Selected Shipping Method is Incorrect");
    	return this;
    }
 
    //JMB-7316 End
    
    /********************************************************************
	 // * Description  : To get the Current date 
	 // * Param        : int date
	 // * Returns      : dateAfter
	 // * Jira Ticket  : JMB 7142
	 // * Status       : Completed
	 //*******************************************************************/
	public String getFutureDateFromCurrentDate(int date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, date);
		String dateAfter = sdf.format(cal.getTime());
		return dateAfter;
	}
	
	//Start JMB-8134
	/********************************************************************
	 * Description: Select CS Supervisor Manage permission
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/	
    public void selectCsSupervisorUser(){
        adm.adminMenu("settings");
        adm.formXp("adm.subSetting.users.xp");
        Q_WebElm.xp(adminProps, "jm.permissionGroup.csSupervisorManagePermissions.xp");
    }
	/********************************************************************
	 * Description: verify Order Status Edit Enabled 
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/	
    public void verifyOrderStatusEditEnabled(){
    	Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps, "jm.orderStatusEditLinkEnabled.xp"));
    	System.out.println("[Pass] Order Status Edit Link Displayed");	
    }
    
	/********************************************************************
	 * Description: verify Order Status Edit Disabled
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/	
    public void verifyOrderStatusEditDisabled(){
		try {
	    	Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps, "jm.orderStatusEditLinkEnabled.xp"));
	    	Assert.fail("[Fail] Delete Receipt Button is displayed");
		} catch (NoSuchElementException e) {
			 Assert.assertTrue(true);
			 System.out.println("[Pass] Order Status Edit Link is not Displayed");
		}
    }  
	//End JMB-8134
    
    //JMB-5763 Start	 
	/************************************************************
    // * Description: To add a product in edit Order Admin Page
    // * Param : String quan, String product
    // * Jira Ticket: JMB 5763
    // * Status: Completed
    //***********************************************************/ 		
	public void addProductInEditOrderPage(String quan, String product) {
		adm.formXp("repo.record.Prd.search.autoDropdown.btn.xp");
		Q_WebElm.xpClear(adminProps, "repo.record.product.search.autoDropdown.txtBox.xp");
		driver.findElement(By.xpath(adminProps.getProperty("repo.record.product.search.autoDropdown.txtBox.xp"))).sendKeys(product,Keys.ENTER);
		Q_WebElm.myWait(10000);
		Q_WebElm.xpClear(adminProps, "adm.orderForm.quantity.xp");
		Q_WebElm.xpSend(adminProps, "adm.orderForm.quantity.xp", quan);
		Q_WebElm.myWait(1000);
		Q_WebElm.xpClear(adminProps, "adm.orderForm.notes.xp");
		Q_WebElm.xpSend(adminProps, "adm.orderForm.notes.xp", "Product");
		Q_WebElm.xp(adminProps, "adm.orderForm.add.xp");
		Q_WebElm.myWait(2000);
	}
	
	/************************************************************
    // * Description : To select order based on orderId in admin page
    // * Param       : String orderId
    // * Jira Ticket : JMB 5763
    // * Status      : Completed
    //***********************************************************/ 	
	public void navigateToEditOrderInAdminPage(String orderId) {
		driver.navigate().to(baseUrl + "admin");
		Q_OrderForm.ordersMenu("list");
		Q_WebElm.xpClear(adminProps, "adm.orderNumberSearch.xp");
		Q_WebElm.xpSend(adminProps, "adm.orderNumberSearch.xp", orderId);
		Q_WebElm.xp(adminProps, "adm.orderSearchSubmit.xp");		
		Q_WebElm.myWait(4000);		
	}
	
	/********************************************************
    // * Description : To remove a product from admin page
    // * Param       : String product
    // * Jira Ticket : JMB 5763
    // * Status      : Completed
    //********************************************************/ 	
	public void removeProductInEditOrderPage(String product) {
		Q_WebElm.myWait(1000);
		WebElement removeProduct=driver.findElement(By.xpath("//a[contains(text(),'"+product+"')]//parent::td//following-sibling::td/a[@class='remove-product remove-return']"));
		removeProduct.click();
		System.out.println(product + " - Product has been removed");
		Q_WebElm.xpClear(adminProps, "adm.orderForm.removeNotes.xp");
		Q_WebElm.xpSend(adminProps, "adm.orderForm.removeNotes.xp","test");
		Q_WebElm.xp(adminProps, "adm.orderForm.removeUpdate.xp");		
		driver.navigate().refresh();		
	}
	
	/********************************************************
    // * Description : To get ESD from My Account Page
    // * Param       : NA
    // * Jira Ticket : JMB 5763
    // * Status      : Completed
    //********************************************************/ 	
	public String getMyAccountEsd() {
		driver.navigate().to(baseUrl+"my-account");
		Q_WebElm.xp(adminProps, "acc.accountOrderView.xp");
		String myAccountEsd = Q_WebElm.xpRetText(adminProps, "acc.accountsOrderView.dispatchDate.xp");	
		return myAccountEsd;
	}
	
	/********************************************************
    // * Description : To get ESD from Admin Page
    // * Param       : NA
    // * Jira Ticket : JMB 5763
    // * Status      : Completed
    //********************************************************/ 
	public String getAdminEsd() {
		String adminEsd=Q_WebElm.xpRetText(adminProps, "adm.orderForm.esDate.xp");
		return adminEsd;
	}
	//JMB-5763 End
    
	//JMB-7279-Start
	/********************************************************************
	 // * Description  : Verify shipping message status in JMB admin page
	 // * Param        : String shippingStatus
	 // * Jira Ticket  : JMB 7279
	 // * Status       : Completed
	 //*******************************************************************/
	public void verifyShippingMsgStatus(String shippingStatus) {
		driver.navigate().refresh();
		Q_WebElm.myWait(1500);
		String shippingMessage = Q_WebElm.xpRetText(adminProps,"adm.verify.shippingStatusMsg.xp");
		Assert.assertTrue(shippingMessage.contains(shippingStatus), "Shipping is not ready");
	}

	/********************************************************************
	 // * Description  : Uncheck all the operation hold reasons on the orders from admin page
	 // * Param        : NA
	 // * Jira Ticket  : JMB 7279
	 // * Status       : Completed
	 //*******************************************************************/
	public void uncheckAllOperationHold() {
		Integer numberOfPermissions = Q_WebElm.xpCountTableRows(adminProps,"adm.hold.xp");
		for (int i = 1; i < numberOfPermissions; i++) {

			if (Q_WebElm.xpSelected(adminProps,"adm.holdLabel.beg.xp", i, "adm.holdLabel.end.xp")) {
				Q_WebElm.xp(adminProps, "adm.holdLabel.beg.xp", i, "adm.holdLabel.end.xp");
			}
		}
		System.out.println("Uncheck the allcheckboxes");
		ord.formInputId("ord.hold.notes.id", "Automated test case");
		ord.formId("ord.hold.updateHolds.id");
	}

	/********************************************************************
	 // * Description  : Clear all the unpaid invoices on the customer from admin page
	 // * Param        : NA
	 // * Jira Ticket  : JMB 7279
	 // * Status       : Completed
	 //*******************************************************************/
	public void payAllUnpaidInvoicesForCustomer() {

		try {
			Assert.assertTrue(Q_OrderForm.isXpDisplayed("cust.unpaidInvoiceHeader.xp"));
			int noOfInvoices = Q_OrderForm.rowCount("cust.noOfInvoices.xp");
			for (int i = 0; i < noOfInvoices; i++) {
				Q_WebElm.listOfElements(adminProps, "adm.customer.unpaidInvoice.viewBtn.xp").get(i).click();
				Controls.switchWin();
				Q_WebElm.xp(adminProps, "adm.unpaidInvoice.markInvoicePaidBtn.xp");
				Q_WebElm.myWait(1000);
				Controls.checkAlert();
				System.out.println("Invoice paid");
				Q_WebElm.myWait(5000);
				driver.close();
				Controls.switchTab(2);
				driver.navigate().refresh();
				payAllUnpaidInvoicesForCustomer();
			}
		}catch (Exception e){
			driver.close();
			Controls.switchTab(1);
		}
	}

	/********************************************************************
	 // * Description  : Search order in admin page
	 // * Param        : String orderId
	 // * Jira Ticket  : JMB 7279
	 // * Status       : Completed
	 //*******************************************************************/
	public void searchOrderAndNavigateToCustomerPage(String orderId) {
		Q_WebElm.myWait(1000);
		Q_WebElm.xpClear(adminProps, "adm.orderNumberSearch.xp");
		Q_WebElm.xpSend(adminProps, "adm.orderNumberSearch.xp", orderId);
		Q_WebElm.xp(adminProps,"adm.orderSearchSubmit.xp");
		Q_WebElm.myWait(3000);
		Controls.switchTab(1);
		Q_WebElm.myWait(3000);
		Q_WebElm.xp(adminProps,"adm.customer.xp"); 
		Controls.switchTab(2);
	}
	//JMB-7279-End
	
	//JMB-7570-Start
	/********************************************************************
	 // * Description  : Navigate to manage permission 
	 // * Param        : NA
	 // * Jira Ticket  : JMB 7570
	 // * Status       : Completed
	 //*******************************************************************/
	public void navigateToQaTestGroupManagePermission() {
		adm.adminMenu("settings");
		adm.formXp("adm.subSetting.users.xp");
		Q_WebElm.xp(adminProps,"adm.permissionGroup.qaTestGroup.managePermissions.xp");
	}

	/********************************************************************
	 // * Description  : Verify order list action field
	 // * Param        : String permission
	 // * Jira Ticket  : JMB 7570
	 // * Status       : Completed
	 //*******************************************************************/
	public void verifyEditButtonInCancelledOrders(String permission) {
		Controls.scrolDownPixel(2000);
		String actionFieldStatus = Q_WebElm.xpRetText(adminProps,"ord.item.title.xp");
		switch (permission) {
		case ("with permission 86"):
			Assert.assertTrue(actionFieldStatus.equals("Edit"), "Item List doesn't matched");
		break;
		case ("without permission 86"):
			Assert.assertTrue(actionFieldStatus.equals(""), "Item List not matched");
		break;
		}
	}

	/********************************************************************
	 // * Description  : Search order in admin page
	 // * Param        : String orderId
	 // * Jira Ticket  : JMB 7570
	 // * Status       : Completed
	 //*******************************************************************/
	public void searchOrderInAdminPage(String orderId, int tab) {
		Q_WebElm.myWait(2000);
		Q_WebElm.xpClear(adminProps, "adm.orderNumberSearch.xp");
		Q_WebElm.xpSend(adminProps, "adm.orderNumberSearch.xp", orderId);
		Q_WebElm.xp(adminProps,"adm.orderSearchSubmit.xp");
		Q_WebElm.myWait(3000);
		Controls.switchTab(tab);
		Q_WebElm.myWait(3000);
	}
	//JMB-7570-End
	
		// Start JMB-8081
		/********************************************************************
		 // * Description 	: Verify the Require a valid date to be entered when adding a Requested Ship Date to an order
		 // * Param			: NA
		 // * Jira Ticket	: JMB-8081
		 // * Status		: Complete
		 //*******************************************************************/
		public String placeAnOrders(String product, String paymentType) {
			driver.navigate().to(baseUrl +product );
			chk.addItemToCart(1);
			chk.selectPaymentType(paymentType);
			chk.selectcheckoutBtn("top");
			Q_WebElm.xpClear(adminProps, "cust.secureCheckout.enterCSC.xp");
	        Q_WebElm.xpSend(adminProps, "cust.secureCheckout.enterCSC.xp", "110");
			chk.completeOrder();
			String orderId = Q_WebElm.xpRetText(adminProps,"adm.thankYou.getOrderId.xp").replaceAll("Order Number: ORD-", "").trim();
			return orderId;
		}
	// End JMB-8081
		
		
		/********************************************************************
		 // * Description  : Search order in admin page
		 // * Param        : String orderId
		 // * Jira Ticket  : JMB 7570
		 // * Status       : Completed
		 //*******************************************************************/
		public void searchOrderInAdminPage(String orderId) {
			Q_WebElm.myWait(2000);
			Q_WebElm.xpClear(adminProps, "adm.orderNumberSearch.xp");
			Q_WebElm.xpSend(adminProps, "adm.orderNumberSearch.xp", orderId);
			Q_WebElm.xp(adminProps,"adm.orderSearchSubmit.xp");
			Q_WebElm.myWait(3000);
			Controls.switchWin();
			Q_WebElm.myWait(3000);
		}

		/********************************************************************
		 // * Description  : To update the requested ship date 
		 // * Param        : String expected,int date
		 // * Jira Ticket  : JMB 8081
		 // * Status       : Completed
		 //*******************************************************************/
		public String updateRequestedShipDate(String expected,int date) {
		
			Q_WebElm.xp(adminProps,"adm.orderForm.requestShipEditBtn.xp");
			Controls.checkAlert();
			Q_WebElm.myWait(1000);
			Q_WebElm.xpSelectText(adminProps,"adm.orderForm.requestShipDate.emailType.xp", "Customer Request");
			Q_WebElm.xpClear(adminProps,"adm.orderForm.requestShipDate.notes.xp");
			Q_WebElm.xpSend(adminProps,"adm.orderForm.requestShipDate.notes.xp","Test");
			Q_WebElm.xp(adminProps,"adm.orderForm.requestShipDate.updateBtn.xp");
			String actualAlertValue=Controls.checkAndGetAlertText();
			Assert.assertTrue(expected.equals(actualAlertValue),"Alert value is not matched");
			Q_WebElm.xpClear(adminProps,"adm.orderForm.requestShipDate.inputDate.xp");
			String currentDate = getFutureDateFromCurrentDate(date);
			Q_WebElm.xpSend(adminProps,"adm.orderForm.requestShipDate.inputDate.xp",currentDate);
			Q_WebElm.xp(adminProps,"adm.orderForm.requestShipDate.updateBtn.xp");
			driver.navigate().refresh();
			Q_WebElm.myWait(1000);
			return currentDate;
		}
}
