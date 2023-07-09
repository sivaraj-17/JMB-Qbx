package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Controls;
import utils.Init;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.*;

public class Q_Buyback extends Init {
	
	static Q_ProductForm prod = new Q_ProductForm();

    public Q_Buyback formXp(String locator) {
        Q_WebElm.xp(adminProps, locator);
        return this;
    }
    public Q_Buyback formXp(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xp(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public Q_Buyback formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_WebElm.xp(adminProps, begXp, row, midXp, column, endXp);
        return this;
    }
    public Q_Buyback formInput(String locator, String inputValue) {
        Q_WebElm.xpClear(adminProps, locator);
        Q_WebElm.xpSend(adminProps, locator, inputValue);
        return this;
    }
    public Q_Buyback formInput(String begXp, Integer lineItem, String endXP, String inputValue) {
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
    public Q_Buyback formReturnText(String locator) {
        Q_WebElm.xpRetText(adminProps, locator);
        return this;
    }
    public static String formReturnText(String begXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, lineItem, endXp);
    }
    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, recordNumber, midXp, lineItem, endXp);
    }
    public Q_Buyback formReturnTextReplace(String locator) {
        Q_WebElm.xpRetNumber(adminProps, locator);
        return this;
    }
    public Q_Buyback formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpRetNumber(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public Q_Buyback formReturnAttribute(String locator, String attr) {
        Q_WebElm.xpRetAttr(adminProps, locator, attr);
        return this;
    }
    public Q_Buyback formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp, attr);
        return this;
    }
    public Q_Buyback formInputXp(String locator, String inputValue) {
        Q_WebElm.xpClear(adminProps, locator);
        Q_WebElm.myWait(500);
        Q_WebElm.xpSend(adminProps, locator, inputValue);
        Q_WebElm.myWait(500);
        return this;
    }
    public Q_Buyback formInputXp(String begXp, Integer lineItem, String endXP, String inputValue) {
        Q_WebElm.xpClear(adminProps, begXp, lineItem, endXP);
        Q_WebElm.xpSend(adminProps, begXp, lineItem, endXP, inputValue);
        return this;
    }
    public static String attReturn(String locator, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, locator, attr);
    }
    public static String attReturn(String begXp, Integer lineItem, String endXp, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp, attr);
    }
    public Q_Buyback formReturnAttributeReplace(String locator) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, locator);
        return this;
    }
    public Q_Buyback formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public Q_Buyback formTab(String locator) {
        Q_WebElm.xpSendTab(adminProps, locator);
        return this;
    }
    public Q_Buyback formTab(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendTab(adminProps, begXp, lineItem, endXP);
        return this;
    }
    public Q_Buyback formEnter(String locator) {
        Q_WebElm.xpSendEnter(adminProps, locator);
        return this;
    }
    public Q_Buyback formEnter(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendEnter(adminProps, begXp, lineItem, endXP);
        return this;
    }
    public static boolean isXpDisplayed(String locator) {
        return Q_WebElm.xpDisplayed(adminProps, locator);
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
    public Q_Buyback displayedAssertion(String locator) {
        try {
            driver.manage().timeouts().implicitlyWait(3, SECONDS);
            assertTrue(isXpDisplayed(locator));
            System.out.println("Desired element is displayed");
        } catch (Throwable ex) {
            System.out.println("Element not displayed");
        }
        return this;
    }
    public Q_Buyback formId(String locator) {
        Q_WebElm.id(adminProps, locator);
        return this;
    }
    public Q_Buyback formIdInput(String locator, String inputValue) {
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
    public Q_Buyback noBuybackPermission() {
        Q_WebElm.moveIt(adminProps, "adm.menuReceipts.xp");
        try {
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
            assertFalse(isXpDisplayed("bb.buybackOption.xp"));
        } catch (Throwable ex) {
            System.out.println("Buyback not available due to user permissions");
        }
        return this;
    }
    public Q_Buyback buybackPermitted() {
        Q_WebElm.moveIt(adminProps, "adm.menuReceipts.xp");
        try {
            driver.manage().timeouts().implicitlyWait(3, SECONDS);
            assertTrue(isXpDisplayed("bb.buybackOption.xp"));
            System.out.println("Buyback is available and user permitted");
        } catch (Throwable ex) {
            System.out.println("Buyback not available due to user permissions");
        }
        return this;
    }
    public Q_Buyback bbMenuItemOld(String item) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
//        WebElm.moveIt(adminProps, "menuReceipts.xp");
        Q_WebElm.xp(adminProps, "adm.menuReceipts.xp");
        String menuItem = item;
        switch ( menuItem ) {
            case ("new"):
                Q_WebElm.xp(adminProps, "bb.new.xp");
                break;
            case ("list"):
                Q_WebElm.xp(adminProps, "bb.listBuybacks.xp");

                break;
            case ("listReceived"):
                Q_WebElm.xp(adminProps, "listReceivedPaid.xp");
                break;
            case ("cancelled"):
                Q_WebElm.xp(adminProps, "bb.cancelled.xp");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fieldOrderNumber")));
                break;
            case ("require attention"):
                Q_WebElm.xp(adminProps, "bb.requireAttention.xp");
                break;
            case ("completed"):
                Q_WebElm.xp(adminProps, "bb.completed.xp");
                break;
            case ("initiated"):
                Q_WebElm.xp(adminProps, "bb.initiated.xp");
                break;
            case ("products"):
                Q_WebElm.xp(adminProps, "bb.products.xp");
                break;
            case ("bbCustomer"):
                Q_WebElm.xp(adminProps, "bb.newCustomer.xp");
                break;
            case ("fraudReview"):
                Q_WebElm.xp(adminProps, "bb.fraudReviw.xp");
                break;
            case ("accountingReport"):
                Q_WebElm.xp(adminProps, "accountReport.xp");
                break;
            case ("reportable"):
                Q_WebElm.xp(adminProps, "reportable.xp");
                break;
            case ("ACHReport"):
                Q_WebElm.xp(adminProps, "bb.aCHReport.xp");
                break;
            case ("packages report"):
                Q_WebElm.xp(adminProps, "bb.packages.xp");
                break;
            case ("wire"):
                Q_WebElm.xp(adminProps, "bb.wires.xp");
                break;
            default:
                System.out.println("Invalid Buyback Menu Option");
                break;
        }
        return this;
    }
    public Q_Buyback newBuyBack(String email, Integer supplierIndex) {
        formInput("bb.createBbEmail.xp", email);
        formSelectIndex("bb.createBbSupplier.xp", supplierIndex);
        formXp("bb.createBbSearch.xp");
        return this;
    }
    public Q_Buyback existingCustomer(String email, Integer supplierIndex) {
        formInput("bb.createBbEmail.xp", email);
        formSelectIndex("bb.createBbSupplier.xp", supplierIndex);
        checkNew();
        formXp("bb.createBbSearch.xp");
        return this;
    }
    public Q_Buyback emailAddress(String email) {
        formInput("bb.createBbEmail.xp", email);
        return this;
    }
    public Q_Buyback formSelectIndex(String locator, Integer index) {
        Q_WebElm.xpSelectIndex(adminProps, locator, index);
        return this;
    }
    public Q_Buyback formSelectValue(String locator, String value) {
        Q_WebElm.xpSelectValue(adminProps, locator, value);
        return this;
    }
    public Q_Buyback formSelectText(String locator, String text) {
        Q_WebElm.xpSelectText(adminProps, locator, text);
        return this;
    }
    public Q_Buyback checkNew() {
        formXp("bb.createBbIsNew.xp");
        return this;
    }
    public Q_Buyback newSearch() {
        formXp("bb.createBbSearch.xp");
        return this;
    }
    public Q_Buyback createFirstName(String firstName) {
        formInput("bb.newCustomerBBfirstName.xp", firstName);
        return this;
    }
    public Q_Buyback createLastName(String lastName) {
        formInput("bb.lastName.xp", lastName);
        return this;
    }
    public Q_Buyback selectAddress() { // 2 for first address
        Q_WebElm.myWait(1000);
        formXp("bb.existingBbAddress.beg.xp", 2, "bb.existingBbAddress.end.xp");
        return this;
    }
    public Q_Buyback selectAddress(Integer address) { // 2 for first address
        formXp("bb.existingBbAddress.beg.xp", address, "bb.existingBbAddress.end.xp");
        return this;
    }
    public Q_Buyback editAddress() {
        formInput("bb.newStreetAddress.xp", "33-1 S Greenfield Rd");
        formInput("bb.newAddressField2.xp", "Auto Edited");
        formInput("bb.newCityAddress.xp", "Gilbert");
        formInput("bb.newStateAddress.xp", "Az");
        formInput("bb.newZipcodeAddress.xp", "85297");
        formInput("bb.newPhoneAddress.xp", "9613003301");
        return this;
    }
    public Q_Buyback newAddress() {
        formXp("bb.newBbAddress.xp");
        formInput("bb.newStreetAddress.xp", "3301 S Greenfield Rd");
        formInput("bb.newAddressField2.xp", "Auto Added");
        formInput("bb.newCityAddress.xp", "Gilbert");
        formInput("bb.newStateAddress.xp", "Az");
        formInput("bb.newZipcodeAddress.xp", "85297");
        formInput("bb.newPhoneAddress.xp", "9613003301");
        return this;
    }
    public Q_Buyback addCustomer(Integer supplierIndex) {   // 1 PM, 2 JMB
        emailAddress(Controls.currentTime() + "Auto@jmbullion.com");
//        emailAddress("qa+10jmb@jmbullion.com");
        formSelectIndex("bb.createBbSupplier.xp", supplierIndex);
        checkNew();
        newSearch();
        formInput("bb.newCustomerBBfirstName.xp", "Auto");
        formInput("bb.lastName.xp", "Buyback");
        formInput("bb.address1.xp", "4100 Imaginary ST");
        formInput("bb.city.xp", "McKinney");
        formInput("bb.state.xp", "TX");
        formInput("bb.zipcode.xp", "75070");
        formInput("bb.phoneNumber.xp", "9619600001");
        formInput("bb.phoneExtension.xp", "2323");
        formInput("bb.companyName.xp", "Lala Toys");
        formXp("bb.addCustomer.xp");
        System.out.println("Adding new customer ");
        Q_WebElm.myWait(1000);
//        driver.navigate().refresh();
        return this;
    }
    public Q_Buyback editCustomer(String firstName, String lastName) {
        editOrder();
        formXp("bb.editBbCustomerBtn.xp");
        Q_WebElm.myWait(1000);
        Q_WebElm.myWait(1000);
        formInput("bb.editFirstName.xp", firstName);
        formInput("bb.editLastName.xp", lastName);
        formXp("bb.saveBbCustomerBtn.xp");
        formInput("bb.editAddress.Company.xp", "Lala Toys");
        skipCreditCard();
        saveBb();
        Q_WebElm.myWait(1000);
        return this;
    }
    public Q_Buyback editSssnAndEin() {
        editOrder();
        formXp("bb.ssnEinEditBtn.xp");
        Q_WebElm.myWait(500);
            if(Q_WebElm.xpDisplayed(adminProps, "bb.taxChooseFile.xp").equals(true)){
                System.out.println("Choose File button visible: " + isXpDisplayed("bb.taxChooseFile.xp"));
            }
        Assert.assertEquals(isXpDisplayed("bb.taxChooseFile.xp"),true);
        return this;
    }
    public Q_Buyback editCompanyName() {
        editOrder();
//        formXp("companyName.xp");
        Q_WebElm.myWait(1000);
        Q_WebElm.myWait(1000);
        System.out.println("Current company name:  " + attReturn("bb.companyName.xp", "value"));
        String companyName = "Auto Company Name_" + Controls.startTimeStriped();
        formInput("bb.editAddress.Company.xp", companyName);
        skipCreditCard();
        formXp("bb.saveBb.xp");
        Q_WebElm.myWait(1000);
        System.out.println("Company Name :" + attReturn("bb.companyName.xp", "value"));
        Assert.assertEquals(attReturn("bb.companyName.xp", "value"), companyName);
        return this;
    }
    public Q_Buyback deleteCompanyName() {
        editOrder();
//        formXp("editBbCustomerIcon.xp");
        Q_WebElm.myWait(1000);
        Q_WebElm.myWait(1000);
        formInput("bb.editAddress.Company.xp", "");
        skipCreditCard();
        formXp("bb.saveBb.xp");
        Q_WebElm.myWait(1000);
        System.out.println("Company Name :" + attReturn("bb.companyName.xp", "value"));
        Assert.assertEquals(attReturn("bb.companyName.xp", "value"), "");
        return this;
    }
    public Q_Buyback companyCheckbox() {
        editOrder();
        formXp("bb.checkCompanyName.xp");
        formXp("bb.saveBb.xp");
        return this;
    }
    public Q_Buyback selectBank() {  // 2 for first bank
        formReturnAttribute("bb.newBbBank.xp", "0");
//        formXp("newBbBank.beg.xp", bank, "newBbBank.end.xp");
        System.out.println("Selected bank account ");
        return this;
    }
    public Q_Buyback selectBank(Integer bank) {  // 1 for first bank
        formXp("bb.newBbBank.beg.xp", bank, "bb.newBbBank.end.xp");
        System.out.println("Selected bank account ");
        return this;
    }
    public Q_Buyback addBankInfo(Integer bank, Integer accountTypeIndex, String routingNum) {  // 2 for first bank
        Q_WebElm.myWait(2000);
//        selectBank(bank); // 2 is the first radio button
        formInput("bb.routingNumber.xp", routingNum);
        formInput("bb.routingNumberConfirm.xp", routingNum);
        formInput("bb.bankAccount.xp", "9871234567");
        formInput("bb.bankAccountConfirm.xp", "9871234567");
        formInput("bb.bankName.xp", "First Fake");
        formSelectValue("bb.accountType.xp", "ACH");    //  0 ACh, 1 wire , 3 ACH & Wire
        addBankButton();
        Controls.checkAlert();
        System.out.println("Added new Bank account");
        return this;
    }
    public Q_Buyback addBankButton(){
        formXp("bb.addBankButton.xp");
        Q_WebElm.myWait(1000);
        Controls.checkAlert();
        Q_WebElm.myWait(1000);
        return this;
    }
    public Q_Buyback Ffc(String aacNum, String accName, String custodian){
        Q_WebElm.myWait(1000);
        formId("bb.selectFFC.id");
        formIdInput("bb.FccAccountNumber.id",aacNum);
        formIdInput("bb.FccAccountName.id",accName);
        formIdInput("bb.FccCustodian.id", custodian);
        Q_WebElm.myWait(1000);
        formId("bb.FccSave.id");
        Q_WebElm.myWait(2000);
        String alertText = Controls.checkAndGetAlertText();
        System.out.println(alertText);
        Assert.assertEquals(alertText, "For Further Credit Account successfully saved!");
        return this;
    }
    public Q_Buyback FfcNoSave(String aacNum, String accName, String custodian){
        formId("bb.selectFFC.id");
        formIdInput("bb.FccAccountNumber.id",aacNum);
        formIdInput("bb.FccAccountName.id",accName);
        formIdInput("bb.FccCustodian.id", custodian);
        return this;
    }
    public Q_Buyback verifyFFCBank(Integer bank, String tcName) throws IOException {
        Q_WebElm.myWait(1000);
        switch(bank){
            case 1 :
                selectBank(1);
                Ffc("987987123", "Fake Bank", "CareOf");
                Q_WebElm.myWait(1000);
                System.out.println(idAttRet("bb.FccAccountNumber.id", "value"));
                Assert.assertEquals(idAttRet("bb.FccAccountNumber.id", "value"), "987987123");
                Controls.captureScreen(tcName);
                clearFfc();
                break;
            case 2 :
                selectBank(2);
                Ffc("45451234", "SecondBB", "Custody");
                Q_WebElm.myWait(1000);
                Assert.assertEquals(idAttRet("bb.FccAccountNumber.id", "value"), "45451234");
                Controls.captureScreen(tcName);
                clearFfc();
                break;
            default :
                System.out.println("Invalid bank selection");
                break;
        }
        return this;
    }
    public Q_Buyback verifySavedFFC(String tcName) throws IOException {
        System.out.println(idAttRet("bb.FccAccountNumber.id", "value"));
        Assert.assertEquals(idAttRet("bb.FccAccountNumber.id", "value"), "987987123");
        Controls.captureScreen(tcName);
        clearFfc();
        return this;
    }
    public Q_Buyback clearFfc(){
        formId("bb.selectFFC.id");
        Q_WebElm.idClear(adminProps, "bb.FccAccountNumber.id");
        Q_WebElm.idClear(adminProps, "bb.FccAccountName.id");
        Q_WebElm.idClear(adminProps, "bb.FccCustodian.id");
        formId("bb.FccSave.id");
        Q_WebElm.myWait(2000);
        String alertText = Controls.checkAndGetAlertText();
        System.out.println(alertText);
        return this;
    }
    public Q_Buyback verifyW9Information(String messageToBeVerified) {
        try {
            Q_WebElm.xpDisplayed(adminProps, "bb.w2Alert.xp").equals(true);
            System.out.println(strXpText("bb.w2Alert.xp"));
            Assert.assertEquals(strXpText("bb.w2Alert.xp"), messageToBeVerified);
            System.out.println("Customer missing tax information");
        } catch (Throwable ex) {
            System.out.println("Customer has previously entered tax information or non reportable item");
        }
        return this;
    }
    public Q_Buyback verifyMessageContains(String messageToBeVerified) {
        try {
            Q_WebElm.xpDisplayed(adminProps, "bb.w2Alert.xp").equals(true);
            System.out.println(strXpText("bb.w2Alert.xp"));
            Assert.assertTrue(strXpText("bb.w2Alert.xp").contains(messageToBeVerified));
            System.out.println(strXpText("bb.w2Alert.xp"));
        } catch (Throwable ex) {
            System.out.println("Customer has previously entered tax information");
        }
        return this;
    }
    public Q_Buyback addIraInfo() {
        formInput("bb.newIraAccountNumber.xp", "3213213214");
        formInput("bb.newIraAccountName.xp", "Personal Acc");
        formInput("bb.newIraCustodian.xp", "Fidelity 2B");
        System.out.println("Added new IRA account");
        return this;
    }
    public Q_Buyback selectPayment(String payment) {  //ACH, WIRE, CHECK
        Q_WebElm.myWait(500);
        formSelectValue("bb.newPayment.xp", payment);
        System.out.println("Selected " + payment);
        return this;
    }
    public Q_Buyback selectInternalStatusIndex(Integer internalStatusIndex) { // 1 CUSTOMERRESPONSE, 2 LABEL, 3 RA_JMB, 4 RA_AMGL, 5 REC_PVCI, 6 COMPLETED, 7 AMGL_CLARIFY, 8 REQATT_JMBV
        formSelectIndex("bb.internalStatus.xp", internalStatusIndex);
        System.out.println("Internal status" + strXpText("bb.internalStatus.xp"));
        return this;
    }
    public Q_Buyback selectInternalStatusValue(String value) { // CUSTOMERRESPONSE, LABEL, RA_JMB, RA_AMGL, REC_PVCI, COMPLETED, AMGL_CLARIFY, REQATT_JMBV
        formSelectValue("bb.internalStatus.xp", value);
        System.out.println("Internal status" + strXpText("bb.internalStatus.xp"));
        return this;
    }
    public Q_Buyback selectInternalStatusText(String text) { //  Awaiting Customer Response,  Shipping Label Requested,  Requires Attention - JMB,  Requires Attention - AMGL,  Received - Pending Vault Check In,  Completed,  AMGL - Clarification, Requires Attn: JMBV
        showAddresses();
        selectAddress(2);
        formSelectText("bb.internalStatus.xp", text);
        System.out.println("Internal status" + strXpText("bb.internalStatus.xp"));
        System.out.println("Selected new internal status" + text);
        return this;
    }
    public Q_Buyback selectPaymentType(Integer paymentIndex) { // 1 ACh, 2 Wire, 3 Check
        formSelectIndex("bb.newPayment.xp", paymentIndex);
        String payment = "";
        if (paymentIndex == 1) {
            payment = "ACH";
        } else if (paymentIndex == 2) {
            payment = "Wire";
            paymentFee("25.00");
        } else if (paymentIndex == 3) {
            payment = "Check";
            paymentFee("30.00");
        }
        System.out.println("Selected " + payment + " payment type");
        return this;
    }
    public Q_Buyback editCartNumber() {
        String ticketNumber = attReturn("bb.searchOrder.xp", "value");
        formInput("bb.newCartNumber.xp", "MyC-" + ticketNumber);
        skipCreditCard();
        saveBb();
        return this;
    }
    public Q_Buyback selectCreditCard(Integer address) {  // 1 for first address
        formXp("bb.newCreditCard.beg.xp", address, "bb.newCreditCard.end.xp");
        System.out.println("Selected credit card ");
        Controls.scrolDownPixel(800);
        return this;
    }
    public Q_Buyback addNewCreditCard(Integer lineItem) {
        formInput("bb.newCreditCardNumber.beg.xp", lineItem, "bb.newCreditCardNumber.end.xp", "4000000000000002");
        formInput("bb.newCreditCardExpiration.beg.xp", lineItem, "bb.newCreditCardExpiration.end.xp", "12/2028");
        formInput("bb.newCreditCardCvv.beg.xp", lineItem, "bb.newCreditCardCvv.end.xp", "321");
        selectDefaultCard(1, 6);
        formXp("bb.newCreditCardNew.xp");
//        System.out.println( "Added new credit card ");
        return this;
    }
    public Q_Buyback addCreditCard(Integer lineItem) {
        formInput("bb.newCreditCardNumber.beg.xp", lineItem, "bb.newCreditCardNumber.end.xp", "4000000000000002");
        formInput("bb.newCreditCardExpiration.beg.xp", lineItem, "bb.newCreditCardExpiration.end.xp", "12/2028");
        formInput("bb.newCreditCardCvv.beg.xp", lineItem, "bb.newCreditCardCvv.end.xp", "321");
        selectDefaultCard(1, 6);
        formXp("bb.newCreditCardAdd.beg.xp", 1, "bb.newCreditCardAdd.end.xp");
        System.out.println("Added new credit card ");
        return this;
    }
    public Q_Buyback addExpiredCreditCard(Integer lineItem) {
        formInput("bb.newCreditCardNumber.beg.xp", lineItem, "bb.newCreditCardNumber.end.xp", "4000000000000002");
        formInput("bb.newCreditCardExpiration.beg.xp", lineItem, "bb.newCreditCardExpiration.end.xp", "12/2020");
        formInput("bb.newCreditCardCvv.beg.xp", lineItem, "bb.newCreditCardCvv.end.xp", "321");
        selectDefaultCard(1, 6);
        formXp("bb.newCreditCardAdd.beg.xp", 1, "bb.newCreditCardAdd.end.xp");
        Q_WebElm.myWait(1500);
        assertEquals(Controls.checkAndGetAlertText(), "Your card has expired. Please resubmit your order with an active card.");
//        System.out.println( "Added new credit card ");
        return this;
    }
    /******************   Credit card for JM Supplier*******************/
    public Q_Buyback inputjmCreditCard(Integer lineItem) {
        formInput("jmOnlyCreditCardNumber.xp", "4000000000000002");
        formInput("mOnlyCreditCardExpiration.xp", "12/2028");
        formInput("mOnlyCreditCardCvv.xp", "321");
//        selectJMDefaultCard(1,6);
        formXp("mOnlyCreditCardDefault.xp");
        formXp("mOnlyCreditCardAddBtn.xp");
        return this;
    }
    public Q_Buyback selectDefaultCard(Integer row, Integer col) {  // row for card col for corresponding default
        formXp("bb.newDefaultCard.beg.xp", row, "bb.newDefaultCard.mid.xp", col, "bb.newDefaultCard.end.xp");
        return this;
    }
    public Q_Buyback skipCreditCard() {
        formXp("bb.skipCard.xp");
        System.out.println("Skipped credit");
        return this;
    }

    public Q_Buyback productQty(Integer lineItem, String qty) {
        formInput("bb.qtyBeg.xp", lineItem, "bb.qtyEnd.xp", qty);
        return this;
    }
    public Q_Buyback productQtyTab(Integer lineItem) {
        formTab("bb.qtyBeg.xp", lineItem, "bb.qtyEnd.xp");
        return this;
    }
    public Q_Buyback productDropdown(Integer lineItem) {
        formXp("bb.productDropdownBeg.xp", lineItem, "bb.productDropdownEnd.xp");
        return this;
    }
    public Q_Buyback productDropdownTab(Integer lineItem) {
        formTab("bb.productDropdownBeg.xp", lineItem, "bb.productDropdownEnd.xp");
        return this;
    }
    public Q_Buyback productDescription(Integer lineItem, String productDescription) {
        formInput("bb.productTextBeg.xp", lineItem, "bb.productTextEnd.xp", productDescription);
//        WebElm.myWait(1000);
        return this;
    }
    public Q_Buyback productDescriptionDel(Integer lineItem) {
        Q_WebElm.xpSendDelete(adminProps, "bb.productTextBeg.xp", lineItem, "bb.productTextEnd.xp");
        return this;
    }
    public Q_Buyback productDropdownEnter(Integer lineItem) {
        formEnter("bb.productDropdownBeg.xp", lineItem, "bb.productDropdownEnd.xp");
        return this;
    }
    public Q_Buyback productSelectorActive(Integer lineItem) {
//        WebElm.myWait(2000);
        formEnter("bb.productSelectorActiveBeg.xp", lineItem, "bb.productSelectorActiveEnd.xp");
        return this;
    }
    public Q_Buyback productUnitPriceSend(Integer lineItem, String unitPrice) {
        formInput("bb.actualUnitPriceBeg.xp", lineItem, "bb.actualUnitPriceEnd.xp", unitPrice);
        formInput("bb.actualUnitPriceBeg.xp", lineItem, "bb.actualUnitPriceEnd.xp", unitPrice);
        formTab("bb.actualUnitPriceBeg.xp", lineItem, "bb.actualUnitPriceEnd.xp");
        return this;
    }
    public Q_Buyback reportable() {
        Controls.scrolDownPixel(200);
        formXp("bb.reportableBtn.xp");
        System.out.println(Controls.getAlertText());
        Q_WebElm.myWait(1000);
        Controls.checkAlert();
        Q_WebElm.myWait(2000);
        System.out.println("buyback Total:  " + Q_Buyback.bbTotal());
        return this;
    }
    public Q_Buyback validateReportable() {
        try {
            Q_WebElm.idEnabled(adminProps, "bb.newProduct1Reportable.id").equals(true);
            System.out.println("Verified reportable product");
            Controls.checkAlert();
        } catch (Throwable ex) {
            System.out.println("Product is not  reportable");
        }
        return this;
    }
    public Q_Buyback validateReportable(Integer lineitem, String attrib) {
        Boolean reportable = Q_WebElm.css("#reportable\\[", lineitem, "\\]", attrib);
        try {
            assertEquals(reportable, true);
            System.out.println("This is a reportable product");
        } catch (Throwable ex) {
            System.out.println("Product is not  reportable");
        }

        return this;
    }
    public Q_Buyback validateReportable(String attrib) {
        driver.navigate().refresh();
        Integer initialCount = rowCount("bb.newProductCount.xp");
        System.out.println("count " + initialCount);
        for (int i = 1; i <= initialCount - 2; i++) {
            Boolean reportable = Q_WebElm.css("#reportable\\[", i, "\\]", attrib);
            try {
                assertEquals(reportable, true);
                System.out.println("This is a reportable product");
            } catch (Throwable ex) {
                System.out.println("Product is not  reportable");
            }
        }
        return this;
    }
    public Q_Buyback productValidation() {
        driver.manage().timeouts().implicitlyWait(05, SECONDS);
        if(Q_WebElm.xpDisplayed(adminProps, "bb.productValidationText.xp")){
            Q_WebElm.name(adminProps, "bb.forceSave.name");
            reportable();
            Q_WebElm.myWait(1000);
        }

        return this;
    }
    public Q_Buyback premiumValidation() {
        Q_WebElm.myWait(2000);
//        formXp("saveBb.xp");
        Controls.checkAlert();
        if(Q_WebElm.xpDisplayed(adminProps, "bb.premiumValidation.xp")){
            formXp("bb.premiumValidation.xp");
            formXp("bb.saveBb.xp");
            Q_WebElm.myWait(1000);
        }
        return this;
    }
    public Q_Buyback addBbProduct(Integer lineItem, String quan, String product) {
        productQty(lineItem, quan);
        productQtyTab(lineItem);
        productDropdown(lineItem);
        productDescription(lineItem, product);
        productDescriptionDel(lineItem);
        productSelectorActive(lineItem);
        Q_WebElm.myWait(1000);
        System.out.println("Added buyback product");
        Q_WebElm.myWait(1000);
        return this;
    }
    public Q_Buyback addNonBbProduct(Integer lineItem, String quan, String product, String price) {
        productQty(lineItem, quan);
        productQtyTab(lineItem);
        productDropdown(lineItem);
        productDescription(lineItem, product);
        productSelectorActive(lineItem);
        productUnitPriceSend(lineItem, price);
        Q_WebElm.myWait(2000);
        productUnitPriceSend(lineItem, price);
        Controls.scrolDownPixel(100);
        System.out.println("Added non-buyback product");
        return this;
    }

    public Q_Buyback addMultipleItems(Integer productCount, String quan) {
        ArrayList<String> links;
        links = Controls.readFileToList("Files/products");
        for (int i = 2; i <= productCount; i++) {
            if (i > 3 && i < productCount)
                formXp("bb.addAnotherProduct.xp");
            productQty(i, quan);
            productQtyTab(i);
            productDropdown(i);
            productDescription(i, links.get(i - 2));
            productDescriptionDel(i);
            productSelectorActive(i);
            Controls.scrolDownPixel(100);
        }
        return this;
    }
    public Q_Buyback addProductEditMode() {
        Integer i = productCount() + 1;
        formXp("bb.addAnotherProduct.xp");
        Q_WebElm.myWait(500);
        addBbProduct(i, "10", "10 oz Sunshine Silver Bar (New, MintMar");
        return this;
    }

    public static String returnAttribute(String locator) {
        DecimalFormat df = new DecimalFormat("#.00");
        return Q_WebElm.xpReturnAttributeReplace(adminProps, locator);
    }
    public static String bbTotal() {
        return numberReturn("bb.Total.xp");
    }
    public Q_Buyback saveBb() {
        Q_WebElm.myWait(2000);
        Controls.xpExecutorScrollToView(adminProps, "bb.saveBb.xp");
        Controls.scrolUpPixel(50);
        formXp("bb.saveBb.xp");
        Q_WebElm.myWait(1000);
        try {
            assertTrue(Controls.isAlertPresent());
            Controls.checkAlert();
            Q_WebElm.myWait(2000);
            premiumValidation();
        } catch (Throwable ex) {
        }
        return this;
    }
    public Q_Buyback paymentFee(String paymentFee) {
        System.out.println("Verified Payment fee of  " + Q_Buyback.returnAttribute("bb.paymentFee.xp"));
        assertEquals(Q_Buyback.returnAttribute("bb.paymentFee.xp").substring(0, 5), paymentFee);
        System.out.println("Verified Payment fee of  " + paymentFee);
        return this;
    }

    public Q_Buyback saveVerifyNotes(String textToBeVerified) {
//        WebElm.myWait(5000);
        formXp("bb.saveBb.xp");
        premiumValidation();
        Q_WebElm.myWait(4000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmit")));
//        System.out.println("Notes" + WebElm.xpRetText(adminProps, "notesBottomCreated.xp"));
        assertTrue(Q_WebElm.xpRetText(adminProps, "bb.notesBottomCreated.xp").contains(textToBeVerified));
        System.out.println(textToBeVerified);
        return this;
    }

    public Q_Buyback verifyNotes(String textToBeVerified) {
        Q_WebElm.myWait(2000);
        Q_WebElm.myWait(2000);
        assertTrue(Q_WebElm.xpRetText(adminProps, "bb.notesBottomCreated.xp").contains(textToBeVerified));
        System.out.println(textToBeVerified);
        return this;
    }
    public Q_Buyback verifyEditedNotes(String textToBeVerified) {
        Q_WebElm.myWait(2000);
        formXp("bb.saveBb.xp");
        assertTrue(Q_WebElm.xpRetText(adminProps, "bb.notesBottomEdited.xp").contains(textToBeVerified));
        System.out.println(textToBeVerified);
        return this;
    }
    public Q_Buyback verifyPmNotes(String textToBeVerified) {
        Q_WebElm.myWait(2000);
        assertTrue(Q_WebElm.xpRetText(adminProps, "bb.notesPmBottomCreated.xp").contains(textToBeVerified));
        System.out.println(textToBeVerified);
        return this;
    }
    public Q_Buyback verifyCreditCardRequired(String textToBeVerified) {
        formXp("bb.saveBb.xp");
        System.out.println("Alert text: " + Controls.checkAndGetAlertText());
        try {
            System.out.println(Controls.getAlertText());
            assertEquals(Controls.checkAndGetAlertText(), "A credit card is required for orders of $1000 or more.");
        } catch (Throwable ex) {
        }
        return this;
    }
    public Q_Buyback verifyBankAccountRequired() {
        Q_WebElm.myWait(2000);
        formXp("bb.saveBb.xp");
        System.out.println("Alert text: " + Controls.getAlertText());
        System.out.println(Controls.getAlertText());
        try {
            assertEquals(Controls.checkAndGetAlertText(), "Please select an existing bank account or provide new bank account and routing number.");
        } catch (Throwable ex) {
        }
        return this;
    }
    public Q_Buyback verifyAlertPopup(String message) {
        Q_WebElm.myWait(2000);
        formXp("bb.saveBb.xp");
        System.out.println("Alert text: " + Controls.getAlertText());
        System.out.println(Controls.getAlertText());
        try {
            assertEquals(Controls.checkAndGetAlertText(), message);
        } catch (Throwable ex) {
        }
        return this;
    }
    public Q_Buyback verifyRoutingNumber(String routingNum, String textToBeVerified) {
        formInput("bb.routingNumber.xp", routingNum);
        formTab("bb.routingNumber.xp");
        System.out.println("Alert text: " + Controls.checkAndGetAlertText());
        try {
            System.out.println(Controls.getAlertText());
            assertEquals(Controls.checkAndGetAlertText(), "Routing Number is incorrect.");
        } catch (Throwable ex) {
        }
        return this;
    }
    public Q_Buyback verifyDuplicateProduct() {
        System.out.println(Controls.getAlertText());
        try {
            assertEquals(Controls.checkAndGetAlertText(), "This product already exists in this buyback. Please consider adding the quantity to the existing product!");
        } catch (Throwable ex) {
        }
        return this;
    }
    public Q_Buyback selectLocation(String location) {
        switch(location){
            case "Dallas":
                formXp("bb.locationDallas.xp");
                break;
            case "Vegas":
                formXp("bb.locationVegas.xp");
                break;
            default:
                System.out.println("Invalid location");
                break;
        }
        return this;
    }
    public Q_Buyback verifyAlertText(String textToBeVerified) {
        System.out.println(Controls.getAlertText());
        try {
            assertEquals(Controls.checkAndGetAlertText(), textToBeVerified);
        } catch (Throwable ex) {
        }
        return this;
    }
    public Q_Buyback verifyTextAssertion(String locator, String textToBeVerified) {
        System.out.println("Verified message " + strXpText(locator));
        try {
            assertEquals(strXpText(locator), textToBeVerified);
        } catch (Throwable ex) {
        }
        return this;
    }
    public Q_Buyback verifyAttributeAssertion(String locator, String value, String textToBeVerified) {
        System.out.println("Verified message " + attReturn(locator, value));
        assertEquals(attReturn(locator, value), textToBeVerified);

        return this;
    }
    public Q_Buyback verifyAttributeAssertion(String locator, String value, Integer begIndex, Integer endIndex, String textToBeVerified) {
        String encryptedTax = attReturn(locator, value).substring(begIndex, endIndex);
        System.out.println("Verified message " + encryptedTax);
        assertEquals(encryptedTax, textToBeVerified);

        return this;
    }

    public Q_Buyback verifyStatus(String textToBeVerified) {
        try {
            System.out.println(textToBeVerified);
            assertEquals(Q_WebElm.xpRetText(adminProps, "bb.statusAwaitingDelivery.xp"), textToBeVerified);
        } catch (Throwable ex) {
        }
        return this;
    }

    public Q_Buyback strTextAssertion(String strTextLocator, String textToBeVerified) {
        assertEquals(Q_WebElm.xpRetText(adminProps, strTextLocator), textToBeVerified);
        System.out.println("Buyback Assertion on " + strTextLocator + "Matched Text " + textToBeVerified);
        return this;
    }

    public Q_Buyback retAttributAssertion(String strTextLocator, String textToBeVerified) {
        assertEquals(Q_WebElm.xpRetAttr(adminProps, strTextLocator, "value"), textToBeVerified);
        System.out.println("Attribute matched " + textToBeVerified);
        return this;
    }

    public Q_Buyback verifyTicketNumberUrl() {
        assertTrue(driver.getCurrentUrl().contains(ticketNumber("bb.formTicketNumber.xp")));
        return this;
    }

    public Q_Buyback search(String srchType, String locator, String locatorValue) {
        switch ( srchType ) {
//            case ("ticket5883"):
            case ("order"):
                Q_WebElm.xpClear(adminProps, "bb.searchOrder.xp");
                Q_WebElm.xpClear(adminProps, "bb.searchOrder.xp");
                Q_WebElm.xpClear(adminProps, locator);
                Q_WebElm.xpSend(adminProps, locator, locatorValue);
                Q_WebElm.xp(adminProps, "bb.searchBtn.xp");

                break;
            case ("email"):
                Q_WebElm.xpClear(adminProps, "bb.searchEmail.xp");
                Q_WebElm.xpClear(adminProps, "bb.searchEmail.xp");
                Q_WebElm.xpClear(adminProps, locator);
                Q_WebElm.xpSend(adminProps, locator, locatorValue);
                Q_WebElm.xp(adminProps, "bb.searchBtn.xp");
                break;
            case ("name"):
                Q_WebElm.xpClear(adminProps, "bb.searchName.xp");
                Q_WebElm.xpClear(adminProps, "bb.searchName.xp");
                Q_WebElm.xpClear(adminProps, locator);
                Q_WebElm.xpSend(adminProps, locator, locatorValue);
                Q_WebElm.xp(adminProps, "bb.searchBtn.xp");
                break;
            case ("customer"):
                formSelectIndex("bb.searchCreatedBy.xp", 1);
                Q_WebElm.xp(adminProps, "bb.searchBtn.xp");
                break;
            case ("rep"):
                formSelectIndex("bb.searchCreatedBy.xp", 2);
                Q_WebElm.xp(adminProps, "bb.searchBtn.xp");
                break;
            default:
                System.out.println("invalid search option");
                break;
        }
        return this;
    }
    public Q_Buyback editOrder() {
        try{
            Q_Buyback.formReturnNumber("bb.listTableEmail.beg.xp", 1, "bb.listTableTicket.end.xp");
            System.out.println("BB Number : " + Q_Buyback.formReturnNumber("bb.listTableEmail.beg.xp", 1, "bb.listTableTicket.end.xp"));
            Q_WebElm.linkText(adminProps, "bb.listEditLinkText");
            System.out.println("Buyback in edit mode ");
        }
        catch(Throwable ex){

        }
        return this;
    }
    public Q_Buyback editOrder(Integer rowNum) {
        Q_Buyback.formReturnNumber("bb.listRightTicket.beg.xp", rowNum, "bb.listRightEdit.end.xp");
        formXp("bb.listRightTicket.beg.xp", rowNum, "bb.listRightEdit.end.xp");
//        WebElm.linkText(adminProps,"listEditLinkText");
        System.out.println("Buyback in edit mode ");
        return this;
    }
    public Q_Buyback showAddresses() {
        Q_WebElm.myWait(1000);
        if(isXpDisplayed("bb.showExistingAddresses.xp")){
            formXp("bb.showExistingAddresses.xp");
        }
        return this;
    }

    public Q_Buyback switchAddresses() {
        showAddresses();
        selectAddress(3);
        return this;
    }
    public static String ticketNumber(String locator) {
        Controls.scrolDownPixel(1000);
        return Q_WebElm.xpRetAttr(adminProps, locator, "value");
    }
    public static String ticketNumber(String begXp, Integer line, String endXp) {
        return formReturnNumber(begXp, line, endXp);
    }
    public static String ticketNumber(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return formReturnNumber(begXp, recordNumber, midXp, lineItem, endXp);
    }
    public Q_Buyback deleteItems(String begxp, String deleteEndxp) {
        Controls.scrolDownPixel(1500);
        Integer initialCount = rowCount("bb.newProductCount.xp");
        System.out.print("number of products  " + initialCount);

        formXp(begxp, initialCount - 1, deleteEndxp);

        if (Controls.getAlertText().equals("Do you wish to delete this line item?"))
            Controls.checkAlert();
        Q_WebElm.myWait(8000);
        Integer finalCount = rowCount("bb.newProductCount.xp");

        System.out.print("final products cont " + finalCount);
        assertEquals(finalCount - initialCount, -1);
        System.out.println("Verified product count dropped from " + initialCount + " to final product count " + finalCount);
        return this;
    }
    public Q_Buyback enterCartNo() {
        formInput("bb.newCartNumber.xp", "MyC-" + ticketNumber("bb.formTicketNumber.xp"));
        Controls.scrolDownPixel(500);
        skipCreditCard();
        saveBb();
        premiumValidation();
        selectCreditCard(1);
        saveBb();
        return this;
    }
    public Q_Buyback orderSearchOld(String orderNumber) {
        formInput("bb.orderSearch.xp", orderNumber);
//        formXp("btnSearch.xp");
        String ticketNumber = formReturnNumber("bb.orderDetails.beg.xp", 1, "bb.orderDetails.mid.xp", 2, "bb.orderDetailBuybackNumber.end.xp");
//        Assert.assertEquals(ticketNumber, orderNumber);
//        System.out.println( "Verified search of " + orderNumber, ticketNumber);
        return this;
    }
    public Q_Buyback emailSearchOld(String eamilSearch) {
        formInput("bb.emailSearch.xp", eamilSearch);
//        formXp("btnSearch.xp");
        String email = formReturnText("bb.orderDetails.beg.xp", 1, "bb.orderDetails.mid.xp", 5, "bb.orderDetailEmail.end.xp");
//        Assert.assertEquals(email, eamilSearch);
//        System.out.println( "Verified search of " + eamilSearch + " " + email);
        return this;
    }
    public Q_Buyback cartNumberSerach(String cartNum) {
        formInput("bb.newCartNumber.xp", cartNum);
//        formXp("btnSearch.xp");
        String email = formReturnText("bb.orderDetails.beg.xp", 1, "bb.orderDetails.mid.xp", 5, "bb.orderDetailEmail.end.xp");
//        Assert.assertEquals(email, eamilSearch);
//        System.out.println( "Verified search of " + cartNum, email);
        return this;
    }
    public Q_Buyback noRecordFound() {
        String eamilSearch = "qa1jmb@jmbullion.com";
        formInput("bb.emailSearch.xp", eamilSearch);
        formXp("bb.btnSearch.xp");
        String noRecord = strXpText("bb.noRecords.xp");
        assertEquals(noRecord, "There is no data to report.");
        System.out.println("Verified 0 record search result for " + eamilSearch);
        return this;
    }
    public Q_Buyback nameSearchOld(String nameText) {
        formInput("bb.nameSearch.xp", nameText);
//        formXp("btnSearch.xp");
        String customerName = formReturnText("bb.orderDetails.beg.xp", 1, "bb.orderDetails.mid.xp", 3, "bb.orderDetailCustomerName.end.xp");
//        Assert.assertEquals(customerName, nameText);
        System.out.println("Verified search of " + nameText + " " + customerName);
        return this;
    }
    public Q_Buyback initiateBbClaim() {
        editOrder();
        formXp("bb.initiateClaim.xp");
        formSelectIndex("bb.claimReason.xp", 2);
        formSelectIndex("bb.claimStatus.xp", 3);
        formSelectIndex("bb.claimResolution.xp", 4);
        formSelectIndex("bb.claimTotalShipping.xp", 2);
        formSelectIndex("bb.claimDeclaration.xp", 2);
        formXp("bb.claimSubmit.xp");
        return this;
    }
    public Q_Buyback removeBbClaim() {
        editOrder();
        formXp("bb.removeClaim.xp");
        formXp("bb.deleteClaim.xp");
        return this;
    }
    public Q_Buyback viewBbChangeLog() {
        editOrder();
        formXp("bb.viewChangeLog.xp");
        formXp("bb.viewBuybackBtn.xp");
        return this;
    }
    public Q_Buyback typeSearch(Integer index) {  // 1 DIY 2 Buyback rep
        formSelectIndex("bb.typeSearch.xp", index);
//        formXp("btnSearch.xp");
        switch ( index ) {
            case (1):
                String createdBy = formReturnText("bb.orderDetails.beg.xp", 1, "bb.orderDetails.mid.xp", 15, "bb.orderDetailCreatedBy.end.xp");
//                Assert.assertEquals(createdBy, "CUSTOMER");
                System.out.println("Verified search Created By Customer (DIY)  CUSTOMER");
                break;
            case (2):
                createdBy = formReturnText("bb.orderDetails.beg.xp", 1, "bb.orderDetails.mid.xp", 15, "bb.orderDetailCreatedBy.end.xp");
//                Assert.assertEquals(createdBy, "JMBullion");
                System.out.println("Verified search Created By Buybacks Rep JMBullion");
                break;
            case (3):
            	String ira = formReturnText("bb.orderDetails.beg.xp", 1, "bb.orderDetails.mid.xp", 16, "bb.orderDetailCreatedBy.end.xp");
//              Assert.assertEquals(createdBy, "JMBullion");
              	System.out.println("Verified search Created By IRA");
              	break;
            default:
                System.out.println("Selection is not a valid tpe search");
                break;
        }
//        System.out.println( "Verified search of " + nameText, customerName);
        return this;
    }
    public Q_Buyback statusSearch(Integer index) {  // 1 Awaiting Delivery, 2 Pending Inspection, 3 Accepted,4 Paid, 5 Cancelled, 6 Payment Declined
        formSelectIndex("bb.statusSearch.xp", index);
//        formXp("btnSearch.xp");
        return this;
    }
    public Q_Buyback secondSearchType(String firstSerch, String firstSerchInput, Integer type) {
        formInput(firstSerch, firstSerchInput);
        typeSearch(type);
        return this;
    }
    public Q_Buyback secondSearchStatus(String firstSearch, String firstSearchInput, Integer status) {
        formInput(firstSearch, firstSearchInput);
        statusSearch(status);
        return this;
    }
    public Q_Buyback commitSearch() {
        formXp("bb.btnSearch.xp");
        Q_WebElm.myWait(2000);
        return this;
    }
    public Q_Buyback searchSupplier(String supplier) {
        Integer recordsInPage = rowCount("bb.recordInPage.xp");
        Integer count = 0;
        for (int i = 1; i <= recordsInPage; i++) {
            String formSupplier = formReturnText("bb.orderDetails.beg.xp", i, "bb.orderDetailSupplies.end.xp");
//            System.out.println(" Supplier out is " + formSupplier);
            if (formSupplier.equals(supplier)) {
                System.out.println(" Ticket is " + ticketNumber("bb.orderDetails.beg.xp", i, "bb.orderDetailTicket.end.xp"));
                editOrder(i);
                count = count + 1;
                break;
            }
        }
//        System.out.println("There are "+ count + " Recorde for " + supplier);
        return this;
    }
    public Q_Buyback searchSupplier(String email, String supplier) {
        emailSearch(email);
        commitSearch();
        Integer recordsInPage = rowCount("bb.recordInPage.xp");
        Integer count = 0;
        for (int i = 1; i <= recordsInPage; i++) {
            String formSupplier = formReturnText("bb.orderDetails.beg.xp", i, "bb.orderDetailSupplies.end.xp");
            System.out.println(" Supplier out is " + formSupplier);
            if (formSupplier.equals(supplier)) {
                System.out.println(" Ticket is " + ticketNumber("bb.orderDetails.beg.xp", i, "bb.orderDetailTicket.end.xp"));
                editOrder(i);
                count = count + 1;
                break;
            }
        }
//        System.out.println("There are "+ count + " Recorde for " + supplier);
        return this;
    }
    public static String totalPages() {
        String totalPages = strXpText("bb.pages.xp");
//        System.out.println("Last page " + totalPages.substring(1));
        return totalPages;
    }
    public Q_Buyback paging(String page) {
        switch ( page ) {
            case "last":
                if (Integer.valueOf(totalPages().substring(3)) > 1) {
                    formXp("bb.lastPage.xp");
                    System.out.println("current page " + Integer.valueOf(totalPages().substring(0, 1)) + " Page " + Integer.valueOf(totalPages().substring(3)) + " is the last page");
                }
                break;
            case "next":
                if (Integer.valueOf(totalPages().substring(3)) > 1) {
                    formXp("bb.firstPage.xp");
                    formXp("bb.nextPage.xp");
                    String currentPage = totalPages().substring(0, 1);
                    System.out.println("Current page " + currentPage);
                    System.out.println("Current page " + (Integer.valueOf(currentPage) - 1) + " Page " + Integer.valueOf(currentPage) + " is the next page");
                }
                break;
            case "previous":
                if (Integer.valueOf(totalPages().substring(3)) > 1) {
                    formXp("bb.lastPage.xp");
                    formXp("bb.previousPage.xp");
                    System.out.println("Current page " + Integer.valueOf(totalPages().substring(3)) + " Page " + (Integer.valueOf(totalPages().substring(3)) - 1) + " is the previous page");
                }
                break;
            case "first":
                if (Integer.valueOf(totalPages().substring(3)) > 1) {
                    String currentPage = totalPages().substring(0, 1);
                    formXp("bb.firstPage.xp");
                    System.out.println("Current page " + Integer.valueOf(currentPage) + " Page " + (Integer.valueOf(currentPage) - 1) + " is the first page");
                }
                break;
            default:
                System.out.println("Pagination error ");
                break;
        }
        return this;
    }
    public Q_Buyback receiveEntireOrder() {
        driver.manage().timeouts().implicitlyWait(3, SECONDS);
        formXp("bb.entireArrived.xp");
        Q_WebElm.myWait(3000);
        formXp("bb.entireArrived.xp");
        Q_WebElm.myWait(10000);
        String timer = strXpText("bb.receiveProductBtn.beg.xp", 2, "bb.receiveProductBtn.end.xp");
        Q_WebElm.myWait(1000);
        System.out.println("Receive timer " + timer);
        assertTrue(timer.contains("Unreceive Product"));
        System.out.println("Mark order arrived verified timer");
        return this;
    }
    public static Integer productCount() {
        Integer numberOfProductInBb = Q_WebElm.xpCountTableRows(adminProps, "bb.newProductCount.xp");
        System.out.print("number of products  " + numberOfProductInBb + "\n");
        return numberOfProductInBb;
    }
    public static Integer tableRows(String locator) {
        Integer numberOfProductInBb = Q_WebElm.xpCountTableRows(adminProps, locator);
        System.out.print("number of products  " + numberOfProductInBb + "\n");
        return numberOfProductInBb;
    }
    public Q_Buyback receiveProductIndividually() {
        System.out.println("Total product count " + rowCount("bb.newProductCount.xp"));
        for (int i = 2; i < rowCount("bb.newProductCount.xp"); i++) {
            formXp("bb.receiveProductBtn.beg.xp", i, "bb.receiveProductBtn.end.xp");
            Q_WebElm.myWait(3000);
            formXp("bb.receiveProductBtn.beg.xp", i, "bb.receiveProductBtn.end.xp");
            Q_WebElm.myWait(8000);
            String timer = strXpText("bb.receiveProductBtn.beg.xp", 2, "bb.receiveProductBtn.end.xp");
            System.out.println("Receive timer " + timer);
//            Assert.assertTrue(timer.contains("Unreceive Product ("));
            System.out.println("Mark individual products arrived " + timer);
        }
        return this;
    }
    public Q_Buyback unreceiveProductIndividually() {
        System.out.println("Total product count " + rowCount("bb.newProductCount.xp"));
        for (int i = 2; i < rowCount("bb.newProductCount.xp"); i++) {
            formXp("bb.receiveProductBtn.beg.xp", i, "bb.receiveProductBtn.end.xp");
            Q_WebElm.myWait(10000);
            String timer = strXpText("bb.receiveProductBtn.beg.xp", i, "bb.receiveProductBtn.end.xp");
            System.out.println("Receive timer " + timer);
//            Assert.assertTrue(timer.contains("Unreceive Product ("));
            System.out.println( "Mark individual products arrived " + timer);
        }
        Q_WebElm.myWait(3000);
        return this;
    }
    public Q_Buyback lineItemNote(String noteText) {
        System.out.println("Total product count " + productCount());
        Integer rowCount = Controls.countTableRowsXpath(adminProps, "bb.newProductCount.xp");
        for (int i = 2; i < rowCount; i++) {
            Q_WebElm.myWait(500);
            Q_WebElm.xp(adminProps, "bb.lineItemNote.beg.xp", i, "bb.lineItemNote.end.xp");
            formInput("bb.lineItemText.xp", noteText);
            Q_WebElm.myWait(500);
            formXp("bb.linItemSaveNote.xp");

        }
        return this;
    }
    public Q_Buyback numOfWiresEntries(Integer entry) { // 0- 10 records, 1- 25 records, 2- 50 records, 3- 100 records
        Q_WebElm.myWait(1000);
        formSelectIndex("bb.wireSearchRecord.xp", entry);
        System.out.println("Total number of wires " + Q_Buyback.strXpText("bb.wirePages.xp").substring(19, 21));
        return this;
    }
    public Q_Buyback viewWire(Integer wireNo) {
        formXp("bb.wireList.beg.xp", wireNo, "bb.wireView.end.xp");
        System.out.println(strXpText("bb.wireNumber.xp") + "\n");
        System.out.println("ACH Amount " + formReturnNumber("bb.wireDetailsAchSubtotal.xp") + "\n");
        System.out.println("Wire Amount " + formReturnNumber("bb.wireDetailsWireSubtotal.xp") + "\n");
        System.out.println("Check Amount " + formReturnNumber("bb.wireDetailsCheckSubtotal.xp") + "\n");
        return this;
    }
    public Q_Buyback wirePagingForward() {
        if (Integer.valueOf(strXpText("bb.wirePages.xp").substring(19, 21)) > 10) {
            formXp("bb.wirePagingNext.xp");
            System.out.println("Wire Page 2 as we clicked on Next");
            //System.out.println("Showing" + strText("wirePages.xp").substring(14,16));
        }
        return this;
    }
    public Q_Buyback wirePagingBack() {
        if (Integer.valueOf(strXpText("bb.wirePages.xp").substring(14, 16)) > 10) {
            formXp("bb.wirePagingPrevious.xp");
            System.out.println("Wire Page 2 as we clicked on Previous");
        }
        return this;
    }
    public Q_Buyback addWire(String supplier) {    // CUSTOMER External // Provident
        formXp("bb.wireAdd.xp");
        formSelectText("bb.wireNewSelectSupplier.xp", supplier);
        formXp("bb.wireNewSearch.xp");
        driver.manage().timeouts().implicitlyWait(180, SECONDS);
        Integer count = Q_WebElm.xpCountTableDiv(adminProps, "bb.wirePayBb.divCount.xp") - 1;
//        Integer count= rowCount("wireBbCount.xp");
        System.out.println("Available Buybacks for wire " + count);
        for (int i = count; i > count - 1; i--) {
            System.out.println(" current index " + i);
            Q_WebElm.myWait(500);
            System.out.println(" check company " + formReturnText("bb.wirePayBb.beg.xp", i, "bb.wirePayBb.mid.xp", 4, "bb.wireCompany.end.xp").contains("Company"));

            if (formReturnText("bb.wirePayBb.beg.xp", i, "bb.wirePayBb.mid.xp", 4, "bb.wireCompany.end.xp").contains("Company")) {
                formXp("bb.wirePayBb.beg.xp", i, "bb.wirePayBb.mid.xp", 9, "bb.wirePayBb.end.xp");
                Q_WebElm.myWait(500);
                System.out.println("Pay to Company ");
            }else {
                formXp("bb.wirePayBb.beg.xp", i, "bb.wirePayBb.mid.xp", 8, "bb.wirePayBb.end.xp");
                Q_WebElm.myWait(500);
                System.out.println("Pay to Individual ");
            }
        }
        formXp("bb.wireSave.xp");
        return this;
    }
    public Q_Buyback wireBbOnHold(String tcName, String supplier, String bbNum) {
        formXp("bb.wireAdd.xp");
        formSelectText("bb.wireNewSelectSupplier.xp", supplier);
        formXp("bb.wireNewSearch.xp");
        Controls.captureScreen(tcName + "_" + (new Object() {
        }.getClass().getEnclosingMethod().getName()));
        driver.manage().timeouts().implicitlyWait(180, SECONDS);
        Integer count = Q_WebElm.xpCountTableDiv(adminProps, "bb.wirePayBb.divCount.xp") - 1;
//        Integer count= rowCount("wireBbCount.xp");
        System.out.println("Available Buybacks for wire " + count);
        for (int i = 2; i <= count - 1; i++) {
            String availableBuybacks = strXpText("bb.wirePayBb.beg.xp", i, "bb.wirePayBbNum.end.xp");
            System.out.println("wire on hold buyback number: " + availableBuybacks);
            Assert.assertNotEquals(availableBuybacks, bbNum);
        }
        return this;
    }
    public Q_Buyback validWire(String tcName, String supplier) {
        formXp("bb.wireAdd.xp");
        formSelectText("bb.wireNewSelectSupplier.xp", supplier);
        formXp("bb.wireNewSearch.xp");
//        WebDriverWait wait = new WebDriverWait(driver, 120);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("selectAll"))));
        Q_WebElm.myWait(9000);
        String holdBuyback = strXpText("bb.wirePayBb.beg.xp", 2, "bb.wirePayBbNum.end.xp");
        System.out.println(Q_WebElm.xpCountTableDiv(adminProps, "bb.wirePayBb.divCount.xp"));
        editBuybackWire(tcName, holdBuyback);
//        Controls.captureScreen(tcName + "_" + (new Object() {}.getClass().getEnclosingMethod().getName()));
        restoreBuybackWire(tcName, holdBuyback);
        return this;
    }
    public Q_Buyback editBuybackWire(String tcName, String holdBuyback) {
        Controls.newTab();
        Controls.switchWin();
        System.out.println("holdBuyback    "+ holdBuyback);
        driver.navigate().to(adminUrl + "/api/buybacks/edit/" + holdBuyback);
        formXp("bb.placeBbHold.xp");
        Controls.switchTab(0);
        driver.navigate().refresh();
        Controls.checkAlert();
        Q_WebElm.myWait(10000);

        Integer count = Q_WebElm.xpCountTableDiv(adminProps, "bb.wirePayBb.divCount.xp") - 1;
//        Integer count= rowCount("wireBbCount.xp");
        System.out.println("Available Buybacks for wire " + count);
        Q_WebElm.myWait(15000);
        for (int i = 2; i <= count - 1; i++) {

//            WebDriverWait wait = new WebDriverWait(driver, 35);
//            wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.className("form-group"))));
            String availableBuybacks = strXpText("bb.wirePayBb.beg.xp", i, "bb.wirePayBbNum.end.xp");
            System.out.println("wire Available buyback : " + availableBuybacks);
            Assert.assertNotEquals(availableBuybacks, holdBuyback);
        }
        return this;
    }
    public Q_Buyback restoreBuybackWire(String tcName, String holdBuyback) {
        Controls.switchWin();
        formXp("bb.removeBbHold.xp");
        Controls.switchTab(0);
        driver.navigate().refresh();
        Controls.checkAlert();
        Q_WebElm.myWait(25000);
//        Controls.captureScreen(tcName + "_" + (new Object() {}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals(strXpText("bb.wirePayBb.beg.xp", 2, "bb.wirePayBbNum.end.xp"), holdBuyback);
        return this;
    }
    public Q_Buyback wireError(String tcName, String supplier) {
        formXp("bb.wireAdd.xp");
        formSelectText("bb.wireNewSelectSupplier.xp", supplier);
        formXp("bb.wireNewSearch.xp");
        String holdBuyback = strXpText("bb.wirePayBb.beg.xp", 2, "bb.wirePayBbNum.end.xp");
        formXp("bb.wirePayBb.beg.xp", 2, "bb.wirePayBb.mid.xp", 8, "bb.wirePayBb.end.xp");
        Q_WebElm.myWait(1000);
        Controls.newTab();
        Controls.switchWin();
        driver.navigate().to(adminUrl + "/api/buybacks/edit/" + holdBuyback);
        formXp("bb.placeBbHold.xp");
        Controls.switchTab(0);
        formXp("bb.wireSave.xp");
        Controls.captureScreen(tcName + "_" + (new Object() {
        }.getClass().getEnclosingMethod().getName()));
        try {
            verifyMessageContains("Failed to create wire");
            Controls.captureScreen(tcName);
            Q_WebElm.myWait(1000);
            Controls.switchWin();
            formXp("bb.removeBbHold.xp");
            Controls.switchTab(0);
            Controls.captureScreen(tcName + "_" + (new Object() {
            }.getClass().getEnclosingMethod().getName()));
            Assert.assertEquals(strXpText("bb.wirePayBb.beg.xp", 2, "bb.wirePayBbNum.end.xp"), holdBuyback);
//            restoreBuybackWire(holdBuyback);
        } catch (Throwable ex) {

        }
        return this;
    }
    public Q_Buyback wireSearch(String locator, String supplier) {
        formInput(locator, supplier);

        return this;
    }

    public Q_Buyback viewWire(String status) {
        Integer wireCount = rowCount("bb.wireRowsCount.xp");
        for (int i = 1; i <= wireCount; i++) {
            System.out.println("Status for this wire " + i + "\t" + strXpText("bb.wireList.beg.xp", i, "bb.wireListStatus.end.xp"));
            if (strXpText("bb.wireList.beg.xp", i, "bb.wireListStatus.end.xp").equals(status)) {
                formXp("bb.wireList.beg.xp", i, "bb.wireView.end.xp");
                break;
            }
        }
        return this;
    }
    public Q_Buyback wireStatus(String Action, String status) {
        switch ( Action ) {
            case "initiate":
                viewWire(status);
                formXp("bb.initiateWire.xp");
                break;
            case "complete":
                viewWire(status);
                formXp("bb.completeWire.xp");
                break;
            case "delete":
                Integer wireCount = rowCount("bb.wireRowsCount.xp");
                for (int i = 1; i <= wireCount; i++) {
                    System.out.println("Status for this wire " + i + "\t" + strXpText("bb.wireList.beg.xp", i, "bb.wireListStatus.end.xp"));
                    if (strXpText("bb.wireList.beg.xp", i, "bb.wireListStatus.end.xp").equals(status)) {
                        formXp("bb.wireList.beg.xp", i, "bb.wireDelete.end.xp");
                        Controls.checkAlert();
                        break;
                    }
                }
                break;
            default:
                System.out.println("Invalid wire state");
                break;
        }
        return this;
    }
    public Q_Buyback removeBbFromWire() {
        formXp("bb.viewWireIcon.xp");
        formXp("bb.removeBbFromWire.xp");
        Q_WebElm.myWait(2000);
        Controls.checkAlert();
        return this;
    }
    public Q_Buyback dontCancel() {
        formXp("bb.cancelBuyback.xp");
        displayedAssertion("bb.processCancellation.xp");
        formXp("bb.dontCancel.xp");
        return this;
    }
    public Q_Buyback skipFeeBbCancelFee() {
//        System.out.println("Returned MLF " + potentialLoss(1, 10));
        if (Q_Buyback.potentialLoss(1, 10, 0f) > 0f)
            formXp("bb.cancelBuyback.xp");
        formXp("bb.processCancellation.xp");
        formXp("bb.reinstateBuyback.xp");
        System.out.println("Ticket number " + Q_Buyback.ticketNumber("bb.formTicketNumber.xp"));
        return this;
    }
    public Q_Buyback reinstateCancelled() {
        if (Q_Buyback.potentialLoss(1, 10, 0f) > 0f)
            formXp("bb.cancelBuyback.xp");
        displayedAssertion("bb.processCancellation.xp");
        formXp("bb.processCancellation.xp");
        formXp("bb.reinstateBuyback.xp");
        return this;
    }
    public Q_Buyback reinstateCancelledBb() {
        formXp("bb.reinstateBuyback.xp");
        return this;
    }
    public static float potentialLoss(Integer begIndex, Integer endIndex, float marketLoss) {
        driver.manage().timeouts().implicitlyWait(3, SECONDS);
        Integer buybackCount = rowCount("bb.recordInPage.xp");
//        System.out.println("Buyback count for this search " + buybackCount);
        float mlf = 0f;
        Q_Buyback bb = new Q_Buyback();
        for (int i = begIndex; i <= endIndex; i++) {
            try {
                bb.editOrder(i);
                mlf = Float.valueOf(numberReturn("bb.marketMessage.xp"));
                if (mlf > marketLoss)
                    break;
            } catch (Throwable ex) {
                bb.formXp("bb.goBackBtn.xp");
                bb.secondSearchStatus("bb.emailSearch.xp", "qa+1jmb@jmbullion.com", 1);
                bb.commitSearch();
//                 bb.searchSupplier("Provident");
            }
        }
        return mlf;
    }
    public Q_Buyback pageThruBuybacks(Integer begIndex, Integer endIndex, String email, String supplier, float desireMlf){
        for(int i=begIndex; i <= endIndex; i++){
            Q_Buyback bb = new Q_Buyback();
            emailSearch(email);
            commitSearch();
            String formSupplier = formReturnText("bb.orderDetails.beg.xp", i, "bb.orderDetailSupplies.end.xp");
            System.out.println(" Supplier out is " + formSupplier);
//            try {
                bb.editOrder(i);
                Q_WebElm.myWait(5000);
                System.out.println("Market Loss " + Q_Buyback.mlf());
                String ticketNum = Q_Buyback.attReturn("bb.formTicketNumber.xp", "value");
                System.out.println("Form supplier is " + supplier + "\t Ticket Number " + ticketNum);
                assertEquals(supplier,formSupplier);

                if(Q_Buyback.mlf() > desireMlf){
                    formXp("bb.cancelBuyback.xp");
                    break;
                }
                else{
                    bb.formXp("bb.goBackBtn.xp");
                }
//            }
//            catch(Throwable ex){
//                Q_WebElm.myWait(500);
//                bb.formXp("bb.goBackBtn.xp");
////                searchSupplier(email, supplier);
//            }
        }
        return this;
    }
    public Q_Buyback cancelBuybacNum(String bbNum){
        driver.navigate().to("https://staging.jmbullion.com/admin/api/buybacks/edit/" + bbNum);
        String ticketNum="505926";
        formXp("bb.cancelBuyback.xp");
        return this;
    }
    public static float mlf() {
        driver.manage().timeouts().implicitlyWait(3, SECONDS);
        String marketLoss = numberReturn("bb.marketMessage.xp").substring(72);
        System.out.println(strXpText("bb.marketMessage.xp"));
//        float marketLoss = Float.valueOf(numberReturn("bb.marketMessage.xp"))/100;
        System.out.println("Market Loss  " + marketLoss);
        return Float.valueOf(marketLoss);
    }
    public Q_Buyback processBbCancellation() {
        formXp("bb.processCancellation.xp");
        return this;
    }
    public Q_Buyback whichSite(String supplier){
        System.out.println(supplier);
        if(supplier.equals("JM Bullion")){
            driver.navigate().to(adminUrl);
        }
        else{
            driver.navigate().to("https://qa.providentmetals.com/admin/");
            try{
                Q_WebElm.xp(adminProps, "adm.nonOkta.userName.xp");
                Q_WebElm.xpSend(adminProps, "adm.nonOkta.userName.xp", "qa@jmbullion.com");
                Q_WebElm.xpSend(adminProps, "adm.nonOkta.userPwd.xp", "T3$t1212");
                Q_WebElm.xp(adminProps, "adm.nonOkta.signInBtn.xp");
                Q_WebElm.myWait(3000);
            }
            catch(Throwable x){
            }
        }
        return this;
    }
    public Q_Buyback verifyCustomerPageInvoiceLink(String email) {
        Q_AdminForm adm = new Q_AdminForm();
        Q_CustomerForm cust = new Q_CustomerForm();
        adm.adminCustomerSearch("email", email);
        adm.adminViewAllOrders();
        cust.invoiceLink(1, adminUrl + "/api/buybacks/edit/");
        return this;
    }
    public Q_Buyback markBuybackCustomerInvoicePaid(String email) {
        Q_AdminForm adm = new Q_AdminForm();
        Q_CustomerForm cust = new Q_CustomerForm();
        adm.adminCustomerSearch("email", email);
        adm.adminViewAllOrders();
        cust.markCustomerInvoicePaid(1);
        return this;
    }
    public Q_Buyback premiumLogger() {
        driver.navigate().to(adminUrl + "/supplier-premium-log.php?id=22");
        strTextAssertion("bb.premiumLoggerUser.xp", "qa@jmbullion.com");
        strTextAssertion("bb.premiumLoggerWarning.xp", "Yes");
        return this;
    }
    public Q_Buyback buybackHold(String tcName) {
        Q_WebElm.myWait(1000);
        formXp("bb.placeBbHold.xp");
        editCartNumber();
        Controls.captureScreen(tcName + "_" + (new Object() {
        }.getClass().getEnclosingMethod().getName()));
        formXp("bb.removeBbHold.xp");
        return this;
    }
    public Q_Buyback listHoldBuyback(String tcName) {
        bbMenuItem("list");
        formXp("bb.searchHoldCheckbox.xp");
        commitSearch();
        Controls.captureScreen(tcName + "_" + (new Object() {
        }.getClass().getEnclosingMethod().getName()));
        return this;
    }
    public Q_Buyback removeBbHold(String tcName) {
        editOrder();
        formXp("bb.removeBbHold.xp");
        listHoldBuyback(tcName);
        return this;
    }

    //start JMB-5883
    public Q_Buyback selToUs() {
        driver.navigate().to(baseUrl);
        formXp("bb.stu.link.xp");
        formXp("bb.stu.btn.xp");
        Q_WebElm.myWait(1000);
        return this;
    }
    // JMB-5883 end
    public Q_Buyback uploadedFileLink(String partialText){
        Q_WebElm.partialLinkText(adminProps, "bb.uploadedImgLink.linkText");
        Controls.switchWin();
        Q_WebElm.myWait(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains(partialText));
        Controls.closeTabsSwitchWinMain();
        return this;
    }
    /*
    * Return calculated buyback total
    */
    public String bbCalculatedTotal(){
        DecimalFormat df = new DecimalFormat("#.00");
        Integer productCount = rowCount("bb.newProductCount.xp");
        int productIndex =0;
        if(isXpDisplayed("bb.paymentFee.xp")){
            productIndex = 1;
        }
        else{
            productIndex =2;
        }
        double productSum =0;
        List<Float> subtotal = new ArrayList<Float>();
        for(int i=productIndex; i< productCount; i++){
            float productSub = Float.valueOf(attReturn("bb.actualUnitPriceBeg.xp", i, "bb.subtotal.end.xp", "value"));
            subtotal.add(productSub);
            productSum += subtotal.get(i-productIndex);
        }
        String sumOfProducts = df.format(productSum);
//        System.out.println("item Subtotal " + subtotal + "\n");
        return sumOfProducts;
    }
    /*
    * Verify buyback calculated total matches buyback listed total
    */
    public Q_Buyback verifyBbTotal(){
        System.out.println("Calculated buyback total " + bbCalculatedTotal() + "\n");
        String actualBBTotal = numberReturn("bb.Total.xp");
        System.out.println("Actual buyback total " + bbCalculatedTotal() + "\n");
        Assert.assertEquals(actualBBTotal, bbCalculatedTotal());
        return this;
    }
    public Q_Buyback shippinWeight(){
//        String shipWeight = "";
        float totalWeight =0f;
        List<WebElement>shippingWeight = driver.findElements(By.xpath("//*[text()[2][contains(.,'AVDP')]]"));
        ArrayList<String>shipWeight = new ArrayList<>();
        ArrayList<String> qty = new ArrayList<>();
        ArrayList<Float> itemTotalWeight = new ArrayList<>();
        for(int i=0; i< shippingWeight.size(); i++) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            String itemWeight  = (executor.executeScript("return arguments[0].childNodes[2].textContent;", shippingWeight.get(i)).toString()).replaceAll("[^0-9\\.]","");
//            System.out.println("Ship weight " + itemWeight);
            shipWeight.add(itemWeight);
            String itemQty = attReturn("bb.qtyBeg.xp", i+2, "bb.qtyEnd.xp", "value");
            qty.add(itemQty);
//            itemTotalWeight.add(String.valueOf(shippingWeight.get(i)) * qty.get(i));
            float ship = Float.valueOf(shipWeight.get(i)) * Float.valueOf(qty.get(i));

            itemTotalWeight.add(ship);
            totalWeight += itemTotalWeight.get(i);
            System.out.println("Buyback total weight " + totalWeight);
        }
//        System.out.println("weight " + shipWeight);
//        System.out.println("quantity " + qty);
//        System.out.println("Item total shipping " + itemTotalWeight);
        double weightInPound = totalWeight /16.00;
        System.out.println(strXpText("bb.qtyBeg.xp", productCount() , "bb.TotalWeight.final.xp"));
        String totalVerifiedWeight = String.valueOf(totalWeight).substring(1,3);
        Assert.assertTrue(strXpText("bb.qtyBeg.xp", productCount(), "bb.TotalWeight.final.xp").contains(totalVerifiedWeight));
        return this;
    }
    // start JMB-6208
    public Q_Buyback addBbItem(String metalType, Integer item, String quan) {
        switch(metalType){
            case "gold":
                Q_WebElm.myWait(2000);
                Q_WebElm.xp(adminProps, "bb.Metal.gold.xp");
                Q_WebElm.myWait(2000);
                formInput("bb.GoldProducts.qty.beg.xp", item, "bb.Products.qty.end.xp", quan);
                formXp("bb.GoldProducts.qty.beg.xp", item, "bb.Products.Atc.end.xp");

                System.out.println("Modal Price " + strXpText("bb.modal.price.xp"));
                formXp("bb.modal.checkout.xp");
                break;
            case "silver":
                Q_WebElm.xp(adminProps, "bb.Metal.silver.xp");
                Q_WebElm.myWait(2000);
                formInput("bb.silverProducts.qty.beg.xp", item, "bb.Products.qty.end.xp", quan);
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
    public Q_Buyback creditThreshold(String ccLimit){
        formInput("bb.jm5883.CreditThreshold.xp", ccLimit);
        Q_WebElm.xp(adminProps, "adm.saveConfigSettings.xp");
        retAttributAssertion("bb.jm5883.CreditThreshold.xp", ccLimit);

        return this;
    }
    public Q_Buyback orderLowerLimit(String lowLimit){
        formInput("bb.jm5883.LowerOrderLimit.xp", lowLimit);
        Q_WebElm.xp(adminProps, "adm.saveConfigSettings.xp");
        Controls.checkAlert();
        retAttributAssertion("bb.jm5883.LowerOrderLimit.xp", lowLimit);
        return this;
    }
    public Q_Buyback orderUpperLimit(String highLimit){
        formInput("bb.jm5883.UpperOrderLimit.xp", highLimit);
        Q_WebElm.xp(adminProps, "adm.saveConfigSettings.xp");
        Controls.checkAlert();
        retAttributAssertion("bb.jm5883.UpperOrderLimit.xp", highLimit);
        return this;
    }
    public Q_Buyback removeCartPageContent() { ;
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

    // JMB-6208 end
    //JMB-6414 Start
    //*******************************************************************
    // * Description: Select delivery method of buy back
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public Q_Buyback deliveryMethod(String deliveryOption) {
        Q_WebElm.myWait(1000);
        switch (deliveryOption) {
            case "shipment":
                Q_WebElm.idExecutor(adminProps, "bb.deliveryMethodShipmentOption.id");
                break;
            case "local drop off":
                Q_WebElm.idExecutor(adminProps, "bb.deliveryMethodLocalDropOffOption.id");
                String myLocalDropOff = Q_WebElm.idRetText(adminProps, "bb.localDropOffAddress.id");
                Assert.assertEquals(myLocalDropOff, "4150 Eldorado Pkwy, McKinney, TX 75070");
                break;
            default:
                Assert.fail("Delivery option '" + deliveryOption + "' is invalid.");
                break;
        }
        return this;
    }
    //JMB-6414 End
    
    //JMB-6756 Start
    //JMB:6756 - Verify Notes can be added to BB and it is displayed as "Newest First"
	public static void addAndVerifyNoteInBB(String noteToBeAdded)
	{
		if (Q_WebElm.xpDisplayed(adminProps, "bbNoteHeader.xp")&&(Q_WebElm.idDisplayed(adminProps, "bbComments.id"))) {
			System.out.println("[PASS] Notes Section is Displayed.");
			Date timeStamp = Calendar.getInstance().getTime();
			Q_WebElm.xpSend(adminProps, "ord.fullReshipNotes.xp", noteToBeAdded + timeStamp);
			Q_WebElm.id(adminProps, "bbAddNoteBtn.id");
			Q_WebElm.myWait(2000);
			String existingNotes = Q_WebElm.idRetText(adminProps, "bbComments.id");
			String existingNotesArray[] = existingNotes.split("\\r?\\n");
			// As per TC, the latest note should display first - so selecting first index
			System.out.println("[INFO] The First Note is : " + existingNotesArray[0]);
			Assert.assertTrue(existingNotesArray[0].contains(noteToBeAdded+String.valueOf(timeStamp)));
			System.out.println("[PASS] The Latest Note is Displaying first.");

		} else {
			Assert.fail("[FAIL] Notes Section is not Displayed!");
		}
		
	}
	//JMB:6756 - Verify Logs are  displayed as "Newest First"
	public static void verifyLogsSectionInBB(String buyBackInfoNotes) {
		Q_Buyback buyBack = new Q_Buyback();
		if (Q_WebElm.xpDisplayed(adminProps, "bbLogsHeader.xp")&& (Q_WebElm.xpDisplayed(adminProps, "bbExistingLogs.xp"))) {
			System.out.println("[PASS] Logs Section is Displayed.");
			Q_WebElm.idClear(adminProps, "bbInfoNotes.txtArea.id");
			Q_WebElm.idSend(adminProps, "bbInfoNotes.txtArea.id", buyBackInfoNotes);
			buyBack.saveBb();
			// While Fetching the first log, it has a timestamp of EST time, for verifying that, below lines are used.
			TimeZone zone = TimeZone.getTimeZone("America/New_York");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm");
			dateFormat.setTimeZone(zone);
			String timeStamp = dateFormat.format(new Date());
			System.out.println("Current EST Date & Time [Without Daylight] :" + timeStamp);
			String existingLogs = Q_WebElm.xpRetText(adminProps, "bbExistingLogs.xp");
			String existingLogsArray[] = existingLogs.split("\\r?\\n");
			// As per TC, the latest Log should display first - so selecting first index  value
			System.out.println("[INFO] The First Log is : " + existingLogsArray[0]);
			Assert.assertTrue(existingLogsArray[0].contains(String.valueOf(timeStamp)));
			System.out.println("[PASS] The Latest Log is Displaying first.");

		} else {
			Assert.fail("[FAIL] Logs Section is not Displayed!");
		}
	}
  	//JMB-6756 End
	
	// JMB-6579 Start

	/*********************************************************************
	 * Description: Add Bank Info on Click Save Buyback button
	 * Param: String, String
	 * Jira Ticket: JMB-6579
	 * Status: Complete
	 *******************************************************************/

	public static void addBankInfoClickSaveBuyback(String routingNum, String accountNum) {
		Q_WebElm.myWait(2000);
		Q_Buyback bb = new Q_Buyback();
		Q_WebElm.xp(adminProps, "jm.addNewRecord.xp");
		bb.formInput("bb.routingNumber.xp", routingNum);
		bb.formInput("bb.routingNumberConfirm.xp", routingNum);
		bb.formInput("bb.bankAccount.xp", accountNum);
		bb.formInput("bb.bankAccountConfirm.xp", accountNum);
		bb.formInput("bb.bankName.xp", "First Fake");
		bb.formSelectValue("bb.accountType.xp", "ACH");
		bb.saveBb();

	}

	/*********************************************************************
	 * Description: Verify Duplicate Buyback Payment Account details
	 * Param: None
	 * Jira Ticket: JMB-6579
	 * Status: Complete
	 *******************************************************************/
	public static void verifyDuplicateBankAccount() {
		Q_Buyback.addBankInfoClickSaveBuyback("026001591", "123456789");
		int value2 = Q_WebElm.retXpListSize(adminProps, "jm.acTableSize.xp");
		System.out.println("Total records after add duplicate value: " + value2);
		int flag = 0;
		int s = Q_WebElm.retXpListSize(adminProps, "jm.acTableRecord.xp");
		System.out.println("S: " + s);
		for (int i = 1; i <= s; i++) {
			String records = Q_WebElm.xpRetText(adminProps, "jm.acTablevalu.beg.xp", i, "jm.acTablevalu.end.xp");
			System.out.println("Record value: " + records);
			if (records.equals("026001591")) {
				flag++;
				break;
			}
		}
		System.out.println("Flag value is: " + flag);

		if (flag < 0) {
			Assert.fail("New bank account details not added"); 

		}
		if (flag == 1) {
			System.out.println("New bank account details added succesfully & no duplicate record found");
		} else if (flag >= 2) {
			Assert.fail("Duplicate record added in bank account field");

		}
	}
	// JMB-6579 End
	
	//JMB-6803 Start
	/**
	 * Verify if the click on Edit BB page navigates back to Buyback search result page
	 * @param url
	 */
	public void verifyGoBackBtn_editBB(String url)	{
		Q_Buyback bb = new Q_Buyback();
		bb.formXp("bb.goBackBtn.xp");
		Q_WebElm.myWait(2500);
		Assert.assertEquals(driver.getCurrentUrl(), url);
	}
	//JMB-6803 End
	
	//JMB-6488 Start
	/**********************************************************************
	 * Description: Verify Adjustment to the Buybacks Requiring Attention search report 
	 * Param: String 
	 * Jira Ticket: JMB-6488
	 * Status: Complete
	 **********************************************************************/
	public void verifyAdjustmentBBAttentionReport(String status) {
		int flag = 0;
			Q_WebElm.xp(adminProps, "jm.search.xp");
			int size = prod.retXpSize(adminProps, "jm.BBstatus.xp");
			for (int count1 = 1; count1 <= size; count1++) {
				String BBstatus = Q_WebElm.xpRetText(adminProps, "jm.BBstatus.xp.beg", count1, "jm.BBstatus.xp.end");
				if (BBstatus.contains(status)) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println(status
						+ " order status not displayed in BB Requiring Attention search report");
			} else if (flag == 1) {
				Assert.fail(status + " order status displayed in BB Requiring Attention search report");
			}	
		}
	/********************************************************************
	 * // * Description: Verify order status dropdown list
	 * // * Param: NA 
	 * // * Jira Ticket: JMB-6488 
	 * // * Status: Complete 
	 *******************************************************************/	
	public void verifyStatus() {
		int flag=0;
		List<WebElement> list=xpSelectValue("jm.orderStatus.xp");
		System.out.println(list);
		for(int integer=1; integer<=list.size(); integer++) {
		if(list.contains("Paid") && list.contains("Cancelled")) {
			flag=1;
		}
		}
		if (flag == 0) {
			System.out.println("order status Paid & Cancelled are not displayed in BB Requiring Attention dropdown report");
		} else if (flag == 1) {
			Assert.fail("order status Paid & Cancelled are displayed in BB Requiring Attention dropdown report");
		}
	}
	/********************************************************************
	 * // * Description: Select all options value
	 * // * Param: String 
	 * // * Jira Ticket: JMB-6488 
	 * // * Status: Complete 
	 * @return 
	 *******************************************************************/	
	 public static List<WebElement> xpSelectValue(String locator){
		 List<WebElement> list =  new Select(driver.findElement(By.xpath(adminProps.getProperty(locator)))).getOptions();
	        for (int i=0;i<list.size();i++)
	        	System.out.println(list.get(i).getText());
			return list;
	    }
	//JMB-6488 End
	 
	//JMB-6458 Start
	/**
	 * Verify the total of Buyback against a given limit i.e. $750k
	 */
	public void verifyBBTotal(String limit) {
		float bbTotal = Float.parseFloat(bbTotal());
		float bbLimit = Float.parseFloat(limit);
		Assert.assertTrue(bbTotal >= bbLimit, "The order total not enough to satisfy the test criteria");
	}

	/**
	 * Verify the 'Ship brink' alert message when verified with the BB total value while saving the buyback
	 * @param alertMsg
	 */
	public void saveBB_alertVerification(String alertMsg) {
		Q_WebElm.myWait(2000);
		Controls.xpExecutorScrollToView(adminProps, "bb.saveBb.xp");
		Controls.scrolUpPixel(50);
		Q_WebElm.xp(adminProps, "bb.saveBb.xp");
		Q_WebElm.myWait(1000);
		Assert.assertTrue(Controls.isAlertPresent());
		Assert.assertEquals(Controls.checkAndGetAlertText(), alertMsg, "Expected Alert Message not present");
		Q_WebElm.myWait(2000);
		premiumValidation();
	}
	//JMB-6458 End
	
	//Start JMB-6774
	/********************************************************************
	 * Description: Verify product moved to other place by drag & drop
	 * Author: Tamilselvan
	 * Status: Complete 
	 * Ticket: JMB-6774
	 *******************************************************************/  
    public void verifyProductRankByDragAndDrop(int fromvalue){
		String productName=Q_WebElm.xpRetText(adminProps, "jm.initailProductName.xp.beg",fromvalue,"jm.initailProductName.xp.end");
		System.out.println("Product in Source position before update: "+productName);
		WebElement sourceElement=driver.findElement(By.xpath("(//div[@id='sortable']//div[@class='ui-state-default sortable-object split_order'])["+fromvalue+"]"));
		WebElement targetElement=driver.findElement(By.xpath(adminProps.getProperty("jm.manageTopBBOrder.xp")));
		int x = targetElement.getLocation().x;
	    int y = targetElement.getLocation().y;
	    Actions actions = new Actions(driver);
	    actions.moveToElement(sourceElement).dragAndDropBy(sourceElement, x, y).build().perform();
        Q_WebElm.myWait(3000);                 
		String targetProduct=Q_WebElm.xpRetText(adminProps, "jm.initailProductName.xp.beg",fromvalue,"jm.initailProductName.xp.end");
		System.out.println("Product in source Position after update: "+targetProduct);
		Assert.assertTrue(!productName.equals(targetProduct),"Not updated successfully!");
    }
	/********************************************************************
	 * Description: Verify product moved properly by entering rank
	 * Author: Tamilselvan
	 * Status: Complete 
	 * Ticket: JMB-6774
	 *******************************************************************/  
    public void verifyProductRankByEnterRank(int initialRank, int targetRank) {
		String productName=Q_WebElm.xpRetText(adminProps, "jm.initailProductName.xp.beg",initialRank,"jm.initailProductName.xp.end");
		System.out.println("Product name: "+productName);
		Q_WebElm.xp(adminProps, "jm.initialProductClick.xp.beg",initialRank,"jm.initialProductClick.xp.end");
		Q_WebElm.xpClear(adminProps, "jm.initailProductInput.xp.beg",initialRank,"jm.initailProductInput.xp.end");
		Q_WebElm.xpSendInteger(adminProps, "jm.initailProductInput.xp.beg",initialRank,"jm.initailProductInput.xp.end", targetRank);
        Q_WebElm.myWait(1000);
		Q_WebElm.xp(adminProps, "jm.allProductsAdminBB.xp");
		String targetProduct= Q_WebElm.xpRetText(adminProps,"jm.targetProductName.xp.beg",targetRank,"jm.targetProductName.xp.end");
		System.out.println("Target Product: "+targetProduct);
		Assert.assertEquals(productName, targetProduct);
    }
	/********************************************************************
	 * Description: Verify all metal displayed in top BB page
	 * Author: Tamilselvan
	 * Status: Complete 
	 * Ticket: JMB-6774
	 *******************************************************************/  
    public void verifyMetalTypeInTopBBPage() {
    	Q_WebElm.xpDisplayed(adminProps, "jm.metalTypeGold.xp");
    	Q_WebElm.xpDisplayed(adminProps, "jm.metalTypeSilver.xp");
    	Q_WebElm.xpDisplayed(adminProps, "jm.metalTypePlatinum.xp");
    	Q_WebElm.xpDisplayed(adminProps, "jm.metalTypePalladium.xp");
		System.out.println("The Metal type Gold, Silver, Platinum & Palladium are displayed successfully");
    }
    //End JMB-6774
    
    //JMB-7200 Start
  	/*******************************************************************************
  	 * Description: Verify BBs with Internal Status as None, cancelled BBs and DIY 
  	 * BBs not found under IRA filter
  	 * Author: Asfi.Khaliq
  	 * Returns: None
  	 * Status: Complete
  	 ******************************************************************************/
  	public void verifyInternalStatus_cancelledBB_DiyBB_notPresentInIraFilter()	{
  		Assert.assertTrue(Q_WebElm.xpCountTableRows(adminProps, "bb.searchCancelledStatus.xp") == 0,"BB with Cancelled status found.");
  		Assert.assertTrue(Q_WebElm.xpCountTableRows(adminProps, "bb.searchBbInternalStatus.xp") == 0,"BB with Internal status as None found.");
  		Assert.assertTrue(Q_WebElm.xpCountTableRows(adminProps, "bb.searchDiyBuybacks.xp") == 0,"DIY BB found.");
  		System.out.println("BBs with Internal Status as None, cancelled BBs and DIY BBs not found under IRA filter");
  	}
  	//JMB-7200 End
  	
  	//Start JMB-6682
    /********************************************************************
	 * Description: Edit First BB on clicking list BB link (without login admin) 
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/   
    public void editFirstBbProductQty()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        bbMenuItem("list");
        secondSearchStatus("bb.nameSearch.xp", "Auto Testcase", 1);
        commitSearch();
        editOrder();
        productQty(2, "5");
        productQtyTab(2);
        reportable();
        productValidation();
        premiumValidation();
    }
    /********************************************************************
	 * Description: verify Popup On BB Above $500000
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/   
    public void verifyPopupOnBBAbove$500000() {
        String popupMsg=Q_WebElm.xpRetText(adminProps, "jm.popupMsg.xp");
        System.out.println("Popup Message: " + popupMsg);
        Assert.assertTrue(popupMsg.contains("This buyback requires a 3% hold, or must be locked on arrival. Please reach out to the buybacks team"), "Popup messgae is not match");
    	System.out.println("Popup messgae displayed correctly");
    	Assert.assertTrue(popupMsg.contains("I have spoken with the BB department and customer has chosen how they would like to proceed"), "Popup message is not match");
    	System.out.println("Popup agree messgae displayed correctly");
        Q_WebElm.myWait(3000);
        Q_WebElm.xp(adminProps, "jm.alertcheck.xp");
        Q_WebElm.myWait(3000);
        Q_WebElm.id(adminProps, "jm.clickPriorBBAlert.id");
        Q_WebElm.myWait(5000);
    }
    //End JMB-6682
    
    //JMB-7173 Start
  	/***************************************************************
  	 * Description: Process and verify cancellation of a Buyback
  	 * Author: Asfi Khaliq
  	 * Param: None
  	 * Returns: None
  	 * Status: Complete
  	 **************************************************************/
  	public void cancelBuyback() {
  		Q_Buyback bb = new Q_Buyback();
  		Q_WebElm.xp(adminProps,"bb.cancelBuyback.xp");
  		Q_WebElm.xp(adminProps,"bb.processCancellation.xp");
  		Q_WebElm.myWait(10000);
  	    driver.navigate().refresh();
  	    bb.displayedAssertion("bb.reinstateBuyback.xp");
  	}
  	//JMB-7173 End
  	
  	//Start JMB-7406
    /********************************************************************
	 * Description: Verify Warning message on edit BB with the BB total change amount is more than $5k
	 * Author: Tamilselvan
	 * Param: Float
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
  	public void largeEditBbWarning(float totalBbValueBeforeEdit, float totalBbValueAfterEdit) {
  		Assert.assertTrue(totalBbValueBeforeEdit<totalBbValueAfterEdit, "The edit BB change is not more than $5K");
  		System.out.println("The edit BB change value is more than $5K");
  	    String largeEditBbWarningMsg=Q_WebElm.xpRetText(adminProps, "jm.largeEditBbWarningMsg.xp");
	    System.out.println("Large Edit BB Warning Message: "+largeEditBbWarningMsg);
	    Assert.assertTrue(largeEditBbWarningMsg.contains("The edits you have made caused a large change in the buyback total. Please double-check that you did not make an error"), "Warning messgae is not match/Displayed");
	    System.out.println("Large Edit BB warning messgae displayed successfully");
	}
    /********************************************************************
	 * Description: Close BB warning message on edit BB total value change more than $5k
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
  	public void closeLargeBbWarningMsg() {
  	   	Q_WebElm.xp(adminProps, "jm.closeLargeBbWarningMsg.xp");
  	}
    /********************************************************************
	 * Description: Click Ok BB warning message on edit BB total value change more than $5k
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
  	public void clickOklargeEditBbWarning() {
  		Q_WebElm.xp(adminProps, "jm.clickOkWarningMsg.xp");
  	}
  	//End JMB-7406
  	//Start JMB-5904
  	/********************************************************************
	 * Description: Verify product deleted in BB form displayed in claim form with 0 value
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: String
	 * Status: Complete 
	 *******************************************************************/
	public String buybackClaimModification() {
		Q_WebElm.xp(adminProps, "bb.initiateClaim.xp");
		Assert.assertTrue(isXpDisplayed("jm.lastProductValue.xp"), "Last product value is not 0");
		System.out.println("[Pass] The value of Item deleted in BB form is Displayed correctly as 0");
		formInput("jm.setfirstProdValueInClaimForm.xp", "0");
		String deletedProductClaimForm = Q_WebElm.xpRetText(adminProps, "jm.firstProductClaimForm.xp");
		System.out.println("Deleted product name in claim form: " + deletedProductClaimForm);
		formSelectIndex("bb.claimReason.xp", 2);
		formSelectIndex("bb.claimStatus.xp", 3);
		formSelectIndex("bb.claimResolution.xp", 4);
		formSelectIndex("bb.claimTotalShipping.xp", 2);
		formSelectIndex("bb.claimDeclaration.xp", 2);
		Q_WebElm.xp(adminProps, "bb.claimSubmit.xp");
		return deletedProductClaimForm;
	}
	/********************************************************************
	 * Description: Click Edit Claim link in BB form
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void clickEditClaim() {
	    	Q_WebElm.xp(adminProps, "jm.editClaimInBBForm.xp");
	} 
	/********************************************************************
	 * Description: Verify product deleted in claim form is not displayed in claim form after submit changes
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void verifyProductInClaimForm(String deletedProdId) {
		int size = prod.retXpSize(adminProps, "jm.productsInClaimForm.xp");
		for (int index = 1; index <= size; index++) {
			String prodId = Q_WebElm.xpRetText(adminProps, "jm.productsInClaimForm.xp.beg", index,
					"jm.productsInClaimForm.xp.end");
			System.out.println("ProdId in claim form: " + prodId);
			System.out.println("DeletedProdId in claim form: " + deletedProdId);
			Assert.assertFalse(prodId.contains(deletedProdId), "The product is still displayed in claim form");
		}
		System.out.println("[Pass] The product Id deleted in Claim form is not displayed after submit the changes");
	}
	//End JMB-5904
	
	//JMB-7263 Start
	
	/***************************************************************************************
    // * Description: To create a new BuyBack Quote based on parameters for existing customer
    // * Param : String email, Integer supplierIndex
    // * Jira Ticket: JMB 7263
    // * Status: Completed
    //**************************************************************************************/ 	
	
	public void newBuybackQuote(String email, Integer supplierIndex) {   // supplierIndex  1-PM, 2 -JMB
		formInput("bb.createBbEmail.xp", email);
		formSelectIndex("bb.createBbSupplier.xp", supplierIndex);
		formXp("bb.createQuote.xp");
		formXp("bb.createBbSearch.xp");

	}
	//JMB-7263 End
	
	//JMB-7264 Start

	/******************************************************************
    // * Description: To create a new BuyBack Quote based on parameters (Reused method from JMB-7263)
    // * Param : String email, Integer supplierIndex
    // * Jira Ticket: JMB 7263 
    // * Status: Completed
    //*******************************************************************/ 	
	public void newBuyBackQuote(String email, Integer supplierIndex) {   // supplierIndex  1-PM, 2 -JMB
		formInput("bb.createBbEmail.xp", email);
		formSelectIndex("bb.createBbSupplier.xp", supplierIndex);
        formXp("bb.createQuote.xp");
		formXp("bb.createBbSearch.xp");
	}

	/******************************************************************
    // * Description: To select menu from Receipts (Added case in existing method for List Buyback Quotes menu)
    // * Param : String item
    // * Jira Ticket: JMB 7264
    // * Status: Completed
    //*******************************************************************/ 	
	public void bbMenuItem(String item) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Q_WebElm.xp(adminProps, "adm.menuReceipts.xp");
        String menuItem = item;
        switch ( menuItem ) {
        	case ("new"):
        		Q_WebElm.xp(adminProps, "bb.new.xp");
             	break;
        	case ("list"):
              	Q_WebElm.xp(adminProps, "bb.listBuybacks.xp");
              	break;
        	case ("listReceived"):
        		Q_WebElm.xp(adminProps, "listReceivedPaid.xp");
              	break;
        	case ("list bb quote"):  //Added the case in existing method
        		Q_WebElm.xp(adminProps, "bb.listBuybacksQuotes.xp");
  				break;
        	case ("cancelled"):
        		Q_WebElm.xp(adminProps, "bb.cancelled.xp");
              	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fieldOrderNumber")));
              	break;
        	case ("require attention"):
        		Q_WebElm.xp(adminProps, "bb.requireAttention.xp");
              	break;
        	case ("completed"):
        		Q_WebElm.xp(adminProps, "bb.completed.xp");
              	break;
        	case ("initiated"):
        		Q_WebElm.xp(adminProps, "bb.initiated.xp");
              	break;
        	case ("products"):
        		Q_WebElm.xp(adminProps, "bb.products.xp");
              	break;
        	case ("bbCustomer"):
        		Q_WebElm.xp(adminProps, "bb.newCustomer.xp");
              	break;
        	case ("fraudReview"):
        		Q_WebElm.xp(adminProps, "bb.fraudReviw.xp");
              	break;
        	case ("accountingReport"):
        		Q_WebElm.xp(adminProps, "accountReport.xp");
              	break;
        	case ("reportable"):
        		Q_WebElm.xp(adminProps, "reportable.xp");
              	break;
        	case ("ACHReport"):
        		Q_WebElm.xp(adminProps, "bb.aCHReport.xp");
              	break;
        	case ("packages report"):
        		Q_WebElm.xp(adminProps, "bb.packages.xp");
             	break;
        	case ("wire"):
        		Q_WebElm.xp(adminProps, "bb.wires.xp");
              	break;
        	default:
        		System.out.println("Invalid Buyback Menu Option");
        		break;
      }
  }

	/******************************************************************
    // * Description: To search Buybacks/Buyback Quotes based on Order Number (Updated Assertions and locators in existing method)
    // * Param : String item
    // * Jira Ticket: JMB 7264
    // * Status: Completed
    //*******************************************************************/ 	
	public void orderSearch(String orderNumber) {
		formInput("bb.orderSearch.xp", orderNumber);
		formXp("bb.btnSearch.xp");
		String ticketNumber = Q_Buyback.formReturnNumber("bb.orderDetails.beg.xp", 1, "bb.orderDetails.mid.xp", 2, "bb.orderDetailBuybackNumber.end.xp");
		Assert.assertEquals(ticketNumber, orderNumber, "Order number is Incorrect");
		System.out.println( "Verified search of " + orderNumber + "," +  ticketNumber);
	}

	/******************************************************************
    // * Description: To search Buybacks/Buyback Quotes based on Customer email (Updated Assertions and locators in existing method)
    // * Param : String item
    // * Jira Ticket: JMB 7264
    // * Status: Completed
    //*******************************************************************/ 	
	public void emailSearch(String eamilSearch) {
		formInput("bb.emailSearch.xp", eamilSearch);
		formXp("bb.btnSearch.xp");
		String email = Q_Buyback.formReturnText("bb.orderDetails.beg.xp", 1, "bb.orderDetails.mid.xp", 5, "bb.orderDetailEmail.end.xp");
		Assert.assertEquals(email, eamilSearch, "Customer Email is Incorrect");
		System.out.println( "Verified search of " + eamilSearch + " " + email);
	}

	/******************************************************************
    // * Description: To search Buybacks/Buyback Quotes based on Customer name (Updated Assertions and locators in existing method)
    // * Param : String item
    // * Jira Ticket: JMB 7264
    // * Status: Completed
    //*******************************************************************/ 	
	public void nameSearch(String nameText) {
		formInput("bb.nameSearch.xp", nameText);
		formXp("bb.btnSearch.xp");
		String customerName = Q_Buyback.formReturnText("bb.orderDetails.beg.xp", 1, "bb.orderDetails.mid.xp", 3, "bb.orderDetailCustomerName.end.xp");
		Assert.assertEquals(customerName, nameText, "Customer Name is Incorrect");
		System.out.println("Verified search of " + nameText + " " + customerName);
	}

	//JMB-7264 End

	//JMB-7266 Start

	public void saveBBQuoteAndVerifyNotes(String textToBeVerified) {
		formXp("bb.saveBb.xp");
		premiumValidation();
		Q_WebElm.myWait(4000);
		Assert.assertTrue(strXpText("bb.quoteCreatedMessage.xp").contains(textToBeVerified));
		System.out.println(textToBeVerified);
	}

	//JMB-7266 End
	
	//JMB-6499-Start
	/********************************************************************
	 // * Description  : verify the Move Buyback button in Edit Buyback (Reused method from JMB-6409)
	 // * Param        : String CustomerEmail
	 // * Jira Ticket  : JMB 6409
	 // * Status       : Completed
	 //*******************************************************************/
	public void updateCustomerEmailInMoveBuybacks(String CustomerEmail) {
		formXp("adm.moveBuyBack.customerDropDown.xp");
		xpSendInputEnter("adm.moveBuyBack.enterCustomerEmail.xp", CustomerEmail);
		formXp("adm.moveBuyBack.selectCustomerEmail.xp");
		formXp("adm.moveBuyBack.saveChangeBtn.xp");
		Q_WebElm.myWait(2000);
		try {
			assertTrue(Controls.isAlertPresent());
			Controls.checkAlert();
			Q_WebElm.myWait(2000);
		} catch (Throwable ex) {
		}
	}
	
	public void xpSendInputEnter(String locator, String value){
		Q_WebElm.xpClear(adminProps, locator);
		driver.findElement(By.xpath(adminProps.getProperty(locator))).sendKeys(value,Keys.ENTER);
	}
	
	/********************************************************************
	 // * Description  : Verify the Shipping Address in Buyback page
	 // * Param        : String Address
	 // * Jira Ticket  : JMB 6499
	 // * Status       : Completed
	 //*******************************************************************/
    public void verifyBBShippingAddress(String Address) {
    	String[] addressDetails = Address.split(",");
    	Q_WebElm.xpSelected(adminProps,"bb.newBbBank.xp");
    	Assert.assertTrue(Arrays.asList(addressDetails).contains(Q_Buyback.attReturn("bb.address1.xp", "value")));
    	Assert.assertTrue(Arrays.asList(addressDetails).contains(Q_Buyback.attReturn("bb.address2.xp", "value")));
    	Assert.assertTrue(Arrays.asList(addressDetails).contains(Q_Buyback.attReturn("bb.city.xp", "value")));
    	Assert.assertTrue(Arrays.asList(addressDetails).contains(Q_Buyback.attReturn("bb.state.xp", "value")));
    	Assert.assertTrue(Arrays.asList(addressDetails).contains(Q_Buyback.attReturn("bb.zipcode.xp", "value")));
    	Assert.assertTrue(Arrays.asList(addressDetails).contains(Q_Buyback.attReturn("bb.phoneNumber.xp", "value")));
    }
    
	/********************************************************************
	 // * Description  : Verify the Bank details in Buyback page
	 // * Param        : String bankDetails
	 // * Jira Ticket  : JMB 6499
	 // * Status       : Completed
	 //*******************************************************************/
    public void verifyBBBankDetails(String bankDetails) {
    	String[] addressDetails = bankDetails.split(",");
    	for (String string : addressDetails) {
    		Assert.assertTrue(driver.findElement(By.xpath("//tbody[@id='bank_accounts_table_body']/tr/td[text()='"+string+"']")).isDisplayed());
		}
    }
	//JMB-6499-End	
    
    //JMB-6357-Start
  	/********************************************************************
  	 // * Description  : Search for customer using email and click on initiate buyback button
  	 // * Param        : String email
  	 // * Jira Ticket  : JMB 6357
  	 // * Status       : Completed
  	 //*******************************************************************/
  	public void findCustomerByEmailAndInitiateBuyback(String email, String initiateType) {
  		Q_WebElm.idClear(adminProps, "adminFindCustEmailInput.id");
  		Q_WebElm.idSend(adminProps, "adminFindCustEmailInput.id", email);
  		Q_WebElm.xp(adminProps, "adminFindCustEmailSearchButton.xp");
          
          switch (initiateType) {
  			case "viewOrders":
  	            Q_WebElm.xp(adminProps,"adm.findOrCreateCustomer.viewOrders.xp");
  	        	Q_WebElm.myWait(2000);
  	            Q_WebElm.xp(adminProps,"adm.findOrCreateCustomer.initiateBuyback.xp");
  				break;
  			case "initiateBB":
  	            Q_WebElm.xp(adminProps,"adm.findOrCreateCustomer.initiateBuyback.xp");
  				break;
  		}        
      }
  	//JMB-6357-End
  	
  	// Start JMB-7364 	
    /************************************************************************************
    // * Description: Verify IRA account information details in edit buyback page
    // * Param : NA
    // * Returns: NA
    // * Jira Ticket: JMB 7364
    // * Status: Completed
    /************************************************************************************/    	
	
	public void verifyIraAccountInformationDetails() {
		
		Q_WebElm.xpExecutorScrolToElement(adminProps, "bb.showExistingAddresses.xp");
		Q_WebElm.myWait(2000);
		System.out.println(Q_WebElm.xpRetText(adminProps,"bb.iraInformationLabel.xp"));
		Assert.assertNotNull(Q_WebElm.xpRetAttr(adminProps,"bb.newIraAccountNumber.xp","value"), "Account Number in IRA information table is null");
		System.out.println("Account Number :"+Q_WebElm.xpRetAttr(adminProps,"bb.newIraAccountNumber.xp","value"));
		Assert.assertNotNull(Q_WebElm.xpRetAttr(adminProps,"bb.newIraAccountName.xp","value"), "Account Name in IRA information table is null");
		System.out.println("Account Name :" + Q_WebElm.xpRetAttr(adminProps,"bb.newIraAccountName.xp","value"));
		Assert.assertNotNull(Q_WebElm.xpRetAttr(adminProps,"bb.newIraCustodian.xp","value"), "Custodian information in IRA information table is null");
		System.out.println("Custodian:" +Q_WebElm.xpRetAttr(adminProps,"bb.newIraCustodian.xp","value") );
			
	}
	// End JMB-7364	
}

