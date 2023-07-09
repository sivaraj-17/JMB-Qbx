package pageObjects;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.Controls;
import utils.Init;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

public class Q_CustomerForm extends Init {
	static Q_CheckoutForm chk = new Q_CheckoutForm();
	static Q_AdminForm adm = new Q_AdminForm();

    public Q_CustomerForm formXp(String locator) {
        Q_WebElm.xp(adminProps, locator);
        return this;
    }
    public Q_CustomerForm formXp(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xp(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public Q_CustomerForm formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_WebElm.xp(adminProps, begXp, row, midXp, column, endXp);
        return this;
    }

    public Q_CustomerForm formInput(String locator, String inputValue) {
        Q_WebElm.xpClear(adminProps, locator);
        Q_WebElm.xpSend(adminProps, locator, inputValue);
        return this;
    }

    public Q_CustomerForm formInput(String begXp, Integer lineItem, String endXP, String inputValue) {
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
    public Q_CustomerForm formReturnText(String locator) {
        Q_WebElm.xpRetText(adminProps, locator);
        return this;
    }
    public Q_CustomerForm formReturnText(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpRetText(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, recordNumber, midXp, lineItem, endXp);
    }
    public static String formReturnTextReplace(String locator) {
        return Q_WebElm.xpRetNumber(adminProps, locator);
    }

    public Q_CustomerForm formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpRetNumber(adminProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_CustomerForm formReturnAttribute(String locator, String attr) {
        Q_WebElm.xpRetAttr(adminProps, locator, attr);
        return this;
    }
    public static String attReturn(String locator, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, locator, attr);

    }
    public static String attReturn(String begXp, Integer lineItem, String endXp, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp,attr);
    }
    public Q_CustomerForm formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp,attr);
        return this;
    }

    public Q_CustomerForm formReturnAttributeReplace(String locator) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, locator);
        return this;
    }

    public Q_CustomerForm formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_CustomerForm formTab(String locator) {
        Q_WebElm.xpSendTab(adminProps, locator);
        return this;
    }

    public Q_CustomerForm formTab(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendTab(adminProps, begXp, lineItem, endXP);
        return this;
    }

    public Q_CustomerForm formEnter(String locator) {
        Q_WebElm.xpSendEnter(adminProps, locator);
        return this;
    }

    public Q_CustomerForm formEnter(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendEnter(adminProps, begXp, lineItem, endXP);
        return this;
    }

    public static boolean isXpDisplayed(String locator) {
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
        try {
            Q_WebElm.xpSelected(adminProps, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            return false;
        }
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
    public Q_CustomerForm formSelectIndex(String locator, Integer index) {
        Q_WebElm.xpSelectIndex(adminProps, locator, index);
        return this;
    }

    public Q_CustomerForm formSelectValue(String locator, String value) {
        Q_WebElm.xpSelectValue(adminProps, locator, value);
        return this;
    }
    public Q_CustomerForm formSelectText(String locator, String text) {
        Q_WebElm.xpSelectText(adminProps, locator, text);
        return this;
    }
    public Q_CustomerForm formId(String locator) {
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
    public Q_CustomerForm viewOrderByParam(String orderParam, String paramValue) {
        Integer orderCount = rowCount("cust.ordersTableRows.xp");
        System.out.println("Orders for this customer  " + orderCount);
        System.out.println("Orders param value  " + paramValue);
        switch ( orderParam ) {
            case ("orderNum"):
                for (int i = 1; i <= 38; i++) {
                    if (strXpText("cust.orderNumber.beg.xp", i, "cust.orderNumber.end.xp").equals(paramValue)) {
                        System.out.println("Order number: " + strXpText("cust.orderNumber.beg.xp", i, "cust.orderNumber.end.xp"));
                        Q_WebElm.myWait(2000);
                        formXp("cust.orderNumber.beg.xp", i, "cust.orderDropdown.end.xp");
                        formXp("cust.orderNumber.beg.xp", i, "cust.orderDropdownEditOrder.end.xp");
                        break;
                    }
                }
                break;
            case ("date"):
                System.out.println("Order date ");
                for (int i = 1; i <= 38; i++) {
                    if (strXpText("cust.orderNumber.beg.xp", i, "cust.ordersDate.end.xp").contains(paramValue)) {
                        System.out.println("Order date: " + Q_WebElm.xpRetText(adminProps, "cust.orderNumber.beg.xp", i, "cust.ordersDate.end.xp"));
                        formXp("cust.orderNumber.beg.xp", i, "cust.orderDropdown.end.xp");
                        formXp("cust.orderNumber.beg.xp", i, "cust.orderDropdownEditOrder.end.xp");
                        System.out.println("Order date " + i);
                        break;
                    }
                }
                break;
            case ("total"):
                System.out.println("Order total ");
                for (int i = 1; i <= 38; i++) {
                    if (strXpText("cust.orderNumber.beg.xp", i, "cust.orderTotal.end.xp").equals(paramValue)) {
                        System.out.println("Order total: " + Q_WebElm.xpRetText(adminProps, "cust.orderStatus.end.xp", i, "cust.orderTotal.end.xp"));
                        formXp("cust.orderNumber.beg.xp", i, "cust.orderDropdown.end.xp");
                        formXp("cust.orderNumber.beg.xp", i, "cust.orderDropdownEditOrder.end.xp");
                        break;
                    }
                }
                break;

            case ("status"):
                for (int i = 1; i <= 38; i++) {
//                    System.out.println("Order status ");
//                    System.out.println("Order status: " + WebElm.xpElementRetText(adminProps, "orderNumber.beg.xp", i, "orderStatus.end.xp"));
                    if (strXpText("cust.orderNumber.beg.xp", i, "cust.orderStatus.end.xp").equals(paramValue)) {
                        System.out.println("Order status: " + strXpText("cust.orderNumber.beg.xp", i, "cust.orderStatus.end.xp"));
                        formXp("cust.orderNumber.beg.xp", i, "cust.orderDropdown.end.xp");
                        formXp("cust.orderNumber.beg.xp", i, "cust.orderDropdownEditOrder.end.xp");
                        break;
                    }
                }
                break;
            case ("datePaid"):
                for (int i = 1; i <= 38; i++) {
                    System.out.println("Order date Paid ");
                    if (strXpText("cust.orderNumber.beg.xp", i, "cust.orderDatePaid.end.xp").contains(paramValue)) {
                        System.out.println("Order date paid: " + Q_WebElm.xpRetText(adminProps, "cust.orderNumber.beg.xp", i, "cust.orderDatePaid.end.xp"));
                        formXp("cust.orderNumber.beg.xp", i, "cust.orderDropdown.end.xp");
                        formXp("cust.orderNumber.beg.xp", i, "cust.orderDropdownEditOrder.end.xp");
                        break;
                    }
                }
                break;
            default:
                System.out.println("Order listing failed based on parameter provided");
                break;
        }
        return this;
    }

    public Q_CustomerForm setQc() {
        formXp("cust.qc.xp");
        formSelectText("cust.qcSelect.xp", "Yes");
        formXp("cust.qcSubmit.xp");
        System.out.println("Customer is of QC status to YES");
        Q_WebElm.myWait(1000);
        String logDate= strXpText("cust.custLog.xp");
        System.out.println("Actual Log Date is " + logDate.substring(0,9));
        String cuurentESTTime = Controls.localYYMMDDTimeCentral();
        System.out.println("Expected time " + cuurentESTTime);
//        Assert.assertEquals(logDate.substring(0,9), cuurentESTTime.substring(0,9));
        return this;
    }
    public Q_CustomerForm removeQc() {
        formXp("cust.qc.xp");
        formSelectText("cust.qcSelect.xp", "No");
        formXp("cust.qcSubmit.xp");
        System.out.println("Customer is of QC status to NO");
        Q_WebElm.myWait(1000);
        String logDate= strXpText("cust.custLog.xp");
        System.out.println("Actual Log Date is " + logDate.substring(0, 19));
        String cuurentESTTime = Controls.localYYMMDDTimeCentral();
        System.out.println("Expected time " + cuurentESTTime);
        Assert.assertEquals(logDate.substring(0,9), cuurentESTTime.substring(0,9));
        return this;
    }
    
    public Q_CustomerForm setMilitaryMember() {
        formXp("cust.militaryMem.xp");
        formSelectText("cust.militaryMem.xp", "Yes");
        Q_WebElm.myWait(1000);
        formXp("cust.militaryMemSubmit.xp");
        System.out.println("Customer is to Military Member");
        Q_WebElm.myWait(1000);
        String logDate= strXpText("cust.custLog.xp");
        System.out.println("Actual Log Date is " + logDate.substring(0, 19));
        String cuurentESTTime = Controls.localYYMMDDTimeCentral();
        System.out.println("Expected time " + cuurentESTTime);
        org.testng.Assert.assertEquals(logDate.substring(0,9), cuurentESTTime.substring(0,9));
        return this;
    }

    public Q_CustomerForm removeMilitaryMember() {
        formXp("cust.militaryMem.xp");
        formSelectText("cust.militaryMem.xp", "No");
        Q_WebElm.myWait(1000);
        formXp("cust.militaryMemSubmit.xp");
        System.out.println("Customer status changed to non Military Member");
        Q_WebElm.myWait(1000);
        String logDate= strXpText("cust.custLog.xp");
        System.out.println("Actual Log Date is " + logDate.substring(0, 19));
        String cuurentESTTime = Controls.localYYMMDDTimeCentral();
        System.out.println("Expected time " + cuurentESTTime);
        org.testng.Assert.assertEquals(logDate.substring(0,9), cuurentESTTime.substring(0,9));
        return this;
    }
    public Q_CustomerForm setExtSHipmentDelay() {
        formXp("cust.extendShipping.xp");
        formSelectText("cust.extendShipping.xp", "Yes");
        Q_WebElm.myWait(1000);
        formXp("cust.extendShippingButton.xp");
        System.out.println("Extended Shipment Delay have been set");
        Q_WebElm.myWait(1000);
        String logDate= strXpText("cust.custLog.xp");
        System.out.println("Actual Log Date is " + logDate.substring(0, 19));
        String cuurentESTTime = Controls.localYYMMDDTimeCentral();
        System.out.println("Expected time " + cuurentESTTime);
        org.testng.Assert.assertEquals(logDate.substring(0,9), cuurentESTTime.substring(0,9));
        return this;
    }
    public Q_CustomerForm removeExtSHipmentDelay() {
        formXp("cust.extendShipping.xp");
        formSelectText("cust.extendShipping.xp", "No");
        Q_WebElm.myWait(1000);
        formXp("cust.extendShippingButton.xp");
        System.out.println("Extended Shipment Delay have been removed");
        Q_WebElm.myWait(1000);
        String logDate= strXpText("cust.custLog.xp");
        System.out.println("Actual Log Date is " + logDate.substring(0, 19));
        String cuurentESTTime = Controls.localYYMMDDTimeCentral();
        System.out.println("Expected time " + cuurentESTTime);
        org.testng.Assert.assertEquals(logDate.substring(0,9), cuurentESTTime.substring(0,9));
        return this;
    }
    public Q_CustomerForm setShipMethod(String optionValue) {
        formXp("cust.forceShipMethod.xp");
        formSelectText("cust.forceShipMethod.xp", optionValue);
        Q_WebElm.myWait(1000);
        formXp("cust.forceShipMethodSubmit.xp");
        System.out.println("Customer is set for UPS Delivery");
        Q_WebElm.myWait(1000);
        String logDate= strXpText("cust.custLog.xp");
        System.out.println("Actual Log Date is " + logDate.substring(0, 19));
        String cuurentESTTime = Controls.localYYMMDDTimeCentral();
        System.out.println("Expected time " + cuurentESTTime);
        org.testng.Assert.assertEquals(logDate.substring(0,9), cuurentESTTime.substring(0,9));
        return this;
    }
    public Q_CustomerForm removeShipMethod() {
        formXp("cust.forceShipMethod.xp");
        formSelectText("cust.forceShipMethod.xp", "---REMOVE---");
        Q_WebElm.myWait(1000);
        formXp("cust.forceShipMethodSubmit.xp");

        System.out.println("Removed Ship Method for customer");
        Q_WebElm.myWait(1000);
        String logDate= strXpText("cust.custLog.xp");
        System.out.println("Actual Log Date is " + logDate.substring(0, 19));
        String cuurentESTTime = Controls.localYYMMDDTimeCentral();
        System.out.println("Expected time " + cuurentESTTime);
        org.testng.Assert.assertEquals(logDate.substring(0,9), cuurentESTTime.substring(0,9));
        return this;
    }
    public Q_CustomerForm setForceSignature() {
        formXp("cust.forceSignature.xp");
        formSelectText("cust.forceSignature.xp", "Yes");
        Q_WebElm.myWait(1000);
        formXp("cust.forceSignatureSubmit.xp");
        System.out.println("Force Signature to be set");
        Q_WebElm.myWait(1000);
        String logDate= strXpText("cust.custLog.xp");
        System.out.println("Actual Log Date is " + logDate.substring(0, 19));
        String cuurentESTTime = Controls.localYYMMDDTimeCentral();
        System.out.println("Expected time " + cuurentESTTime);
        org.testng.Assert.assertEquals(logDate.substring(0,9), cuurentESTTime.substring(0,9));
        return this;
    }
    public Q_CustomerForm removeForceSignature() {
        formXp("cust.forceSignature.xp");
        formSelectText("cust.forceSignature.xp", "No");
        Q_WebElm.myWait(1000);
        formXp("cust.forceSignatureSubmit.xp");
        System.out.println("Force Signature to be set");
        Q_WebElm.myWait(1000);
        String logDate= strXpText("cust.custLog.xp");
        System.out.println("Actual Log Date is " + logDate.substring(0, 19));
        String cuurentESTTime = Controls.localYYMMDDTimeCentral();
        System.out.println("Expected time " + cuurentESTTime);
        org.testng.Assert.assertEquals(logDate.substring(0,9), cuurentESTTime.substring(0,9));
        return this;
    }
    public Q_CustomerForm setDIYBuyback() {
        formXp("cust.diy.xp");
        formSelectText("cust.diy.xp", "Yes");
        Q_WebElm.myWait(1000);
        formXp("cust.diySubmit.xp");
        System.out.println("Customer is set for DIY Buybacks");
        Q_WebElm.myWait(1000);
        String logDate= strXpText("cust.custLog.xp");
        System.out.println("Actual Log Date is " + logDate.substring(0, 19));
        String cuurentESTTime = Controls.localYYMMDDTimeCentral();
        System.out.println("Expected time " + cuurentESTTime);
        org.testng.Assert.assertEquals(logDate.substring(0,9), cuurentESTTime.substring(0,9));
        return this;
    }
    public Q_CustomerForm removeDIYBuyback() {
        formXp("cust.diy.xp");
        formSelectText("cust.diy.xp", "No");
        Q_WebElm.myWait(1000);
        formXp("cust.diySubmit.xp");
        System.out.println("Customer is no longer can do DIY Buybacks");
        Q_WebElm.myWait(1000);
        String logDate= strXpText("cust.custLog.xp");
        System.out.println("Actual Log Date is " + logDate.substring(0, 19));
        String cuurentESTTime = Controls.localYYMMDDTimeCentral();
        System.out.println("Expected time " + cuurentESTTime);
        org.testng.Assert.assertEquals(logDate.substring(0,9), cuurentESTTime.substring(0,9));
        return this;
    }
    public Q_CustomerForm editCustomerBilling() {
        formXp("cust.editCustomerBtn.xp");
        formInput("cust.AccFname.xp", "Testcase");
        formInput("cust.AccLname.xp","Automated");
        formInput("cust.BillingFname.xp","Testcase");
        formInput("cust.BillingLname.xp","Automated");
        formInput("cust.Company.xp","Quality One");
        formInput("cust.Phone.xp","9614252804");
        formInput("cust.BillingAdd.xp","123 Wonder St");
        formInput("cust.BillingCity.xp","Reno");
        formInput("cust.BillingState.xp","NV");
        formInput("cust.BillingCountry.xp","USA");
        formInput("cust.BillingZip.xp","89502-0433");
        formInput("cust.Notes.xp","Automated Test case");
        saveVerifyLog();
        return this;
    }
    public Q_CustomerForm saveVerifyLog() {
        formXp("cust.SaveBtn.xp");
        Q_WebElm.myWait(1000);
        String logDate= strXpText("cust.custLog.xp");
        System.out.println("Actual Log Date is " + logDate.substring(0, 19));
        String cuurentESTTime = Controls.localYYMMDDTimeCentral();
        System.out.println("Expected time " + cuurentESTTime);
        return this;
    }
        public Q_CustomerForm shipAddSameAsBillingAdd() {
        formXp("cust.editCustomerBtn.xp");
        formXp("cust.SameAsAbove.xp");
        formInput("cust.Notes.xp","Automated Test case");
        saveVerifyLog();
        return this;
    }
    public Q_CustomerForm editCustomerShipping() {
        formXp("cust.editCustomerBtn.xp");
        formInput("cust.ShippingFname.xp","AutoEdit");
        formInput("cust.ShippingLname.xp","AutoSuite");
        formInput("cust.ShippingAdd.xp","8525 N Tryon St");
        formInput("cust.ShippingCity.xp","Charlotte");
        formInput("cust.ShippingState.xp","NC");
        formInput("cust.ShippingCountry.xp","US");
        formInput("cust.ShippingZip.xp","28262-3420");
        formSelectValue("cust.ShippingDays.xp", "4");
        formInput("cust.Notes.xp","Automated Test case");
        saveVerifyLog();
        return this;
    }
    public Q_CustomerForm sendResetPassEmail() {
        formXp("cust.editCustomerBtn.xp");
        formXp("cust.ChangePass.xp");
        Q_WebElm.myWait(1000);
        Controls.checkAlert();
        Q_WebElm.myWait(1000);
        formXp("cust.CloseBtn.xp");
        return this;
    }
    public Q_CustomerForm labelCustomerFraud() {
        formXp("cust.editCustomerBtn.xp");
        formXp("cust.Fraud.xp");
        formInput("cust.Notes.xp","Automated Test case");
        saveVerifyLog();
        Q_WebElm.myWait(3000);
        formXp("cust.editCustomerBtn.xp");
        formXp("cust.Fraud.xp");
        formInput("cust.Notes.xp","Automated Test case");
        saveVerifyLog();
        return this;
    }

    public Q_CustomerForm viewOrderNumber(String orderNum){
        String customerOrderBexp = Q_OrderForm.isThereCustomerInvoice();
        for(int i = 1; i<= rowCount("cust.ordersTableRows.xp"); i++){
            if(strXpText("cust.orderBeg.xp",i, "cust.orderNum.end.xp").equals("ORD-" + orderNum))
                editOrder(customerOrderBexp, i);
        }
        return this;
    }
    public Q_CustomerForm viewOrderStatus(Integer begIndex, Integer endIndex, String status){
        Q_WebElm.myWait(1000);
        String customerOrderBexp = Q_OrderForm.isThereCustomerInvoice();
        for(int i=begIndex; i<= endIndex; i++){
            if(Q_CustomerForm.getOrderStatus(i).equals(status)){
                editOrder(customerOrderBexp, i);
                break;
            }
        }
        return this;
    }
    public Q_CustomerForm customerPage(String emailAddress) {
        Q_AdminForm adm = new Q_AdminForm();
        Q_CustomerForm cust = new Q_CustomerForm();
        adm.adminCustomerSearch("email", emailAddress);
        adm.adminViewAllOrders();
        return this;
    }
    public static String getOrderStatus(Integer lineItem){
        String customerOrderBexp = Q_OrderForm.isThereCustomerInvoice();
        String status = strXpText(customerOrderBexp,lineItem, "cust.orderStatus.end.xp");
        return status;
    }

    public Q_CustomerForm editOrder(String customerOrderBexp, Integer i){
        formXp(customerOrderBexp,i, "cust.orderEdit.end.xp");
        formXp(customerOrderBexp,i, "cust.orderDropdownEdit.end.xp");
        return this;
    }

    public static String invoiceNumber(Integer rowNum){
        String invoiceNum = strXpText("cust.invoice.beg.xp", rowNum, "cust.invoiceNumber.end.xp");
        return invoiceNum;
    }
    public Q_CustomerForm invoiceNumber(){
        for (int i = 1; i<=rowCount("cust.invoiceTableRows.xp"); i++){
        String invoiceNum = strXpText("cust.invoice.beg.xp", i, "cust.invoiceNumber.end.xp");
        System.out.println("Invoice Number " + invoiceNum);

       }
        return this;
    }
    public Q_CustomerForm invoiceLink(Integer rowNum, String invoiceText){
        String invoiceNum = strXpText("cust.invoice.beg.xp", rowNum, "cust.invoiceNumber.end.xp");
        System.out.println("Invoice Number " + invoiceNum);
        formXp("cust.invoice.beg.xp", rowNum, "cust.invoiceNumber.end.xp");
        Assert.assertTrue(driver.getCurrentUrl().contains(invoiceText));
        return this;
    }
    public Q_CustomerForm markCustomerInvoicePaid(Integer rowNum){
        String invoiceNum = strXpText("cust.invoice.beg.xp", rowNum, "cust.invoiceNumber.end.xp");
        System.out.println("Invoice Number " + invoiceNum);
        Integer initialInvoiceCount = rowCount("cust.invoiceTableRows.xp");
        formXp("cust.invoice.beg.xp", rowNum, "cust.invoiceActionView.end.xp");
        Controls.switchWin();
        formXp("bb.markInvoicePaid.xp");
        Controls.checkAlert();
        Controls.closeTabsSwitchWinMain();
        driver.navigate().refresh();
        Integer finalInvoiceCount = rowCount("cust.invoiceTableRows.xp");
        Assert.assertEquals((initialInvoiceCount - finalInvoiceCount), 1);
        return this;
    }
    //JMB-6038 Start
    public Boolean checkQc(String value){
        Boolean qcCheck;
        qcCheck = verifyQCValue(value);
        if (!qcCheck) {
            setQc();
        }
    return qcCheck;
    }
    public static String xpSelectedValue(Properties proper, String locator){
        return new Select(driver.findElement(By.xpath(proper.getProperty(locator)))).getFirstSelectedOption().getText();
    }
    public Boolean verifyQCValue(String value) {
        Q_WebElm.myWait(1000);
        String selectedValue = xpSelectedValue(adminProps, "cust.qcSelect.xp");
        if (selectedValue.equalsIgnoreCase(value)) {
            return true;
        }
        else
        {
            return false;
        }
    }
    //JMB-6038 End
    //JMB-6153 Start
    /******************************************************************
    // * Description: Edit Customer Add Notes
    // * Param: String
    // * Jira Ticket: JMB-6153
    // * Status: Complete
    // *********************************************************************/
    public Q_CustomerForm editCustomerAddNotes() throws ParseException {
        Q_WebElm.xp(adminProps, "cust.editCustomer.xp");
        Controls.switchWin();
        Q_WebElm.xpSend(adminProps, "cust.editNotes.xp", "Automation test case test");
        Q_WebElm.xp(adminProps, "adm.savePermission.xp");
        driver.navigate().refresh();
        return this;
    }

    /******************************************************************
    // * Description: Verify Customer Notes Timestamp
    // * Param: String
    // * Jira Ticket: JMB-6153
    // * Status: Complete
    // *********************************************************************/
    public Q_CustomerForm verifyCustomerNotesTimestamp() {

        String notes = Q_WebElm.xpRetText(adminProps, "cust.custNotes.xp");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        Date date = new Date();

        // Now format the date
        String dateFormatted = dateFormat.format(date);
        System.out.println("Current date & time: " + dateFormatted);
        Assert.assertTrue(notes.contains(dateFormatted));
        System.out.println("Customer Notes and Timestamp are displayed properly");
        return this;
    }

    /******************************************************************
    // * Description: Edit Customer Remove Notes
    // * Param: String
    // * Jira Ticket: JMB-6153
    // * Status: Complete
    // *********************************************************************/
    public Q_CustomerForm editCustomerRemoveNotes() {

        Q_WebElm.xp(adminProps, "cust.editCustomer.xp");
        Controls.switchWin();
        Q_WebElm.xpClear(adminProps, "cust.editNotes.xp");
        Q_WebElm.xp(adminProps, "adm.savePermission.xp");
        Q_WebElm.myWait(2000);
        System.out.println("after clearing and clicking save button");

        try {
            Assert.assertFalse(Q_WebElm.xpDisplayed(adminProps, "cust.custNotes2.xp"));
        } catch (NoSuchElementException e) {
            System.out.println(e);
            Assert.assertTrue(true);
        }
        System.out.println("Customer Notes & Timestamp deleted and not displayed");
        return this;
    }
    //JMB-6153 End
    
    //JMB-7199 Start
    /******************************************************************
    // * Description: Verify on click "Switch to button" is navigates to the right page
    // * Param : NA
    // * Jira Ticket: JMB 7199 
    // * Status: Complete
    //*******************************************************************/ 
    public void verifySwitcToBtnNavi(String value) {
    	Q_WebElm.xp(adminProps, "jm.switchTo.xp");
    	Q_WebElm.myWait(5000);
    	Q_WebElm.xp(adminProps, "jm.clickMyInfo.xp");
    	String email=Q_WebElm.xpRetText(adminProps, "jm.getMyAccountEmail.xp");
    	System.out.println("Account email: "+email);
    	Assert.assertTrue(email.contains(value), "Page navigates to different account");
    	System.out.println("Swicth to button navigates to correct page");
    }
    /******************************************************************
    // * Description: Switch back to Admin from Frontend 
    // * Param : NA
    // * Jira Ticket: JMB 7199 
    // * Status: Complete
    //*******************************************************************/
    public void switchBackToAdmin() {
    	Q_WebElm.xp(adminProps, "jm.backToQA.xp");
		driver.get(adminUrl);		
    }
    /******************************************************************
    // * Description: Verify Switch User logged in Customer log field
    // * Param : NA
    // * Jira Ticket: JMB 7199 
    // * Status: Complete
    //*******************************************************************/  
    public void verifyCustLog(String value) {
        customerPage(value);
    	String user=Q_WebElm.xpRetText(adminProps, "jm.getUser.xp");
    	String action=Q_WebElm.xpRetText(adminProps, "jm.getUser1.xp");
    	System.out.println("User: "+user);
    	System.out.println("User: "+action);
    	Assert.assertTrue(user.contains("QA Test"), "In Customer log user name is not displayed correctly");
    	Assert.assertTrue(action.contains("User Switch"), "In Customer log action is not displayed correctly");    	
    	System.out.println("Customer log displayed correctly");
    }
    //JMB-7199 End
    
    //JMB-7345-Start
	
  	/********************************************************************
  	 // * Description  : To get the current EST time 
  	 // * Param        : NA
  	 // * Jira Ticket  : JMB 7554 (Reused this Method from ticket JMB 7554)
  	 // * Status       : Completed
  	 //*******************************************************************/
  	public String getCurrentESTDateAndTime() {
  		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
  		df.setTimeZone(TimeZone.getTimeZone("EST"));
  		Calendar cal = Calendar.getInstance();
  		Date currentDate = cal.getTime();
  		cal.setTime(currentDate);
  		String currentESTDateandTime = df.format(cal.getTime());
  		return currentESTDateandTime;
  	}
  	
  	/********************************************************************
  	// * Description  : Reset Gold Starter pack
  	// * Param        : NA
  	// * Jira Ticket  : JMB 7345
  	// * Status       : Completed
  	//*******************************************************************/
  	public void resetGoldStarterPack() {
  		customerPage("qa@jmbullion.com");
  		try {
  			Q_WebElm.xpDisplayed(adminProps, "adm.customerPage.resetGoldStarterPack.xp");
  			Q_WebElm.xp(adminProps, "adm.customerPage.resetGoldStarterPack.xp");
  		} catch (Exception e) {
  			System.out.println("Gold starter pack is active");
  		}
  	}

  	/********************************************************************
  	// * Description  : To order the gold starter pack
  	// * Param        : NA
  	// * Jira Ticket  : JMB 7345
  	// * Status       : Completed
  	//*******************************************************************/	
  	public void orderGoldStarterPack() {
  		driver.navigate().to(baseUrl+"gold-starter-pack/");
  		Q_WebElm.myWait(2000);
  		Q_WebElm.xp(adminProps, "goldStarterPack.addToCart.xp");
  		Q_WebElm.xp(adminProps, "goldStarterPack.checkOutNow.xp");
  		chk.selectPaymentType("cheque");
  		chk.selectcheckoutBtn("top");
  		chk.completeOrder();
  	}

  	/********************************************************************
  	// * Description  : To verify product in gold starter pack 
  	// * Param        : String date
  	// * Jira Ticket  : JMB 7345
  	// * Status       : Completed
  	//*******************************************************************/	

  	public void verifyGoldStarterpackDate(String date) {
  		driver.navigate().to(adminUrl+"/gold-starter-pack.php");
  		driver.findElement(By.xpath("//td[normalize-space()='"+date+"']")).isDisplayed();
  	}
  	
  	//  Start JMB-8018	
 	/********************************************************************
	 // * Description  : Navigate to manage permission 
	 // * Param        : NA
	 // * Jira Ticket  : JMB 8018
	 // * Status       : Completed
	 //*******************************************************************/
 	public void navigateToQaTestGroupManagePermission(){
        adm.adminMenu("settings");
        adm.formXp("adm.subSetting.users.xp");
		Q_WebElm.xp(adminProps,"adm.permissionGroup.qaTestGroup.managePermissions.xp");   
    }
 	
 	/********************************************************************
	 // * Description  : Navigate to the customers sub menu
	 // * Param        : String item
	 // * Jira Ticket  : JMB-8018
	 // * Status       : Complete
	 //*******************************************************************/
 	public void customerMenu(String item) {
		String menuItem = item;
		Q_WebElm.myWait(1000);
        switch ( menuItem ) {
            case ("Cashiers Checks"):
            	Q_WebElm.xp(adminProps,"adm.customer.cashiersChecks.xp");
                break;
            case ("Add Customer"):
            	Q_WebElm.xp(adminProps,"adm.customer.addCust.xp");
                break;
            case ("Coupons"):
            	Q_WebElm.xp(adminProps,"adm.customer.coupons.xp");
                break;           
        }
    }
 	
 	/********************************************************************
	 // * Description  : User with permission accounting 
	 // * Param        : NA
	 // * Jira Ticket  : JMB-8018
	 // * Status       : Complete
	 //*******************************************************************/
	public void userWithPermissionAccounting() {
		Q_WebElm.xpClear(adminProps,"customer.addCust.email.xp");
		Q_WebElm.xpSend(adminProps,"customer.addCust.email.xp", "qa@jmbullion.com");
		Q_WebElm.xp(adminProps,"customer.addCust.searchBtn.xp");
		Q_WebElm.xp(adminProps,"customer.addCust.viewOrderBtn.xp");
		String titleCustPage= Q_WebElm.xpRetText(adminProps,"customer.manageResellerCert.xp");
		Assert.assertTrue(titleCustPage.equals("Manage Reseller Certificates"), "Customer page header text mis-match");
		Assert.assertTrue(Q_WebElm.idEnabled(adminProps, "customer.addNewBtn.id"),"Add new button is not enabled with permission 12");		
	}

 	/********************************************************************
	// * Description  : User without permission accounting 
	// * Param        : NA
	// * Jira Ticket  : JMB-8018
	// * Status       : Complete
	//*******************************************************************/
	public void userWithoutPermissionAccounting() {
		Q_WebElm.xpClear(adminProps,"customer.addCust.email.xp");
		Q_WebElm.xpSend(adminProps,"customer.addCust.email.xp", "qa@jmbullion.com");
		Q_WebElm.xp(adminProps,"customer.addCust.searchBtn.xp");
		Q_WebElm.xp(adminProps,"customer.addCust.viewOrderBtn.xp");
		String titleCustPage= Q_WebElm.xpRetText(adminProps,"customer.resellerCert.xp");
		Assert.assertTrue(titleCustPage.equals("Reseller Certificates"), "Customer page header text mis-match");
	}
	//	End JMB-8018
}
