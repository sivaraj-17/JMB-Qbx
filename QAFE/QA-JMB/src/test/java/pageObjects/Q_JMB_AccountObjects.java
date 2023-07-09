package pageObjects;

import jsonWrappers.AddressContainer;
import jsonWrappers.InvalidPasswordContainer;
import jsonWrappers.UserContainer;
//import org.junit.Assert;
import org.testng.Assert;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Q_JMB_AccountObjects extends Q_JMB_Init {

    public Q_JMB_AccountObjects formXp(String locator) {
        Q_JMB_WebElm.xp(jmbProps, locator);
        return this;
    }

    public Q_JMB_AccountObjects formXp(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xp(jmbProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_JMB_AccountObjects formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_JMB_WebElm.xp(jmbProps, begXp, row, midXp, column, endXp);
        return this;
    }

    public Q_JMB_AccountObjects formInputXp(String locator, String inputValue) {
        Q_JMB_WebElm.xpClear(jmbProps, locator);
        Q_JMB_WebElm.xpSend(jmbProps, locator, inputValue);
        return this;
    }

    public Q_JMB_AccountObjects formInputXp(String begXp, Integer lineItem, String endXP, String inputValue) {
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

    public Q_JMB_AccountObjects formReturnText(String locator) {
        Q_JMB_WebElm.xpRetText(jmbProps, locator);
        return this;
    }

    public Q_JMB_AccountObjects formReturnText(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xpRetText(jmbProps, begXp, lineItem, endXp);
        return this;
    }

    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_JMB_WebElm.xpRetText(jmbProps, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public static String formReturnTextReplace(String locator) {
        return Q_JMB_WebElm.xpRetTextReplace(jmbProps, locator);
    }

    public Q_JMB_AccountObjects formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xpRetTextReplace(jmbProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_JMB_AccountObjects formReturnAttribute(String locator, String attr) {
        Q_JMB_WebElm.xpRetAttr(jmbProps, locator, attr);
        return this;
    }

    public static String attReturn(String locator, String attr) {
        return Q_JMB_WebElm.xpRetAttr(jmbProps, locator, attr);

    }

    public static String attReturn(String begXp, Integer lineItem, String endXp, String attr) {
        return Q_JMB_WebElm.xpAttribute(jmbProps, begXp, lineItem, endXp, attr);
    }

    public Q_JMB_AccountObjects formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_JMB_WebElm.xpAttribute(jmbProps, begXp, lineItem, endXp, attr);
        return this;
    }

    public Q_JMB_AccountObjects formReturnAttributeReplace(String locator) {
        Q_JMB_WebElm.xpReturnAttributeReplace(jmbProps, locator);
        return this;
    }

    public Q_JMB_AccountObjects formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xpReturnAttributeReplace(jmbProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_JMB_AccountObjects formXpDisplayed(String locator) {
        try {
            Q_JMB_WebElm.xpDisplayed(jmbProps, locator).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Q_JMB_AccountObjects formXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_JMB_WebElm.xpDisplayed(jmbProps, begXp, lineItem, endXP).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Q_JMB_AccountObjects formXpTab(String locator) {
        Q_JMB_WebElm.xpSendTab(jmbProps, locator);
        return this;
    }

    public Q_JMB_AccountObjects formXpTab(String begXp, Integer lineItem, String endXP) {
        Q_JMB_WebElm.xpSendTab(jmbProps, begXp, lineItem, endXP);
        return this;
    }

    public Q_JMB_AccountObjects formXpEnter(String locator) {
        Q_JMB_WebElm.xpSendEnter(jmbProps, locator);
        return this;
    }

    public Q_JMB_AccountObjects formXpEnter(String begXp, Integer lineItem, String endXP) {
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

    public Q_JMB_AccountObjects formXpSelectIndex(String locator, Integer index) {
        Q_JMB_WebElm.xpSelectIndex(jmbProps, locator, index);
        return this;
    }

    public Q_JMB_AccountObjects formXpSelectValue(String locator, String value) {
        Q_JMB_WebElm.xpSelectValue(jmbProps, locator, value);
        return this;
    }

    public Q_JMB_AccountObjects formXpSelectText(String locator, String text) {
        Q_JMB_WebElm.xpSelectText(jmbProps, locator, text);
        return this;
    }

    public Q_JMB_AccountObjects formId(String locator) {
        Q_JMB_WebElm.id(jmbProps, locator);
        return this;
    }

    public Q_JMB_AccountObjects formInputId(String locator, String inputValue) {
        Q_JMB_WebElm.idClear(jmbProps, locator);
        Q_JMB_WebElm.idSend(jmbProps, locator, inputValue);
        return this;
    }

    public Q_JMB_AccountObjects formIdTab(String locator) {
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

    public Q_JMB_AccountObjects formIdSelectIndex(String locator, Integer index) {
        Q_JMB_WebElm.idSelectIndex(jmbProps, locator, index);
        return this;
    }

    public Q_JMB_AccountObjects formIdSelectValue(String locator, String value) {
        Q_JMB_WebElm.idSelectValue(jmbProps, locator, value);
        return this;
    }

    public Q_JMB_AccountObjects formIdSelectText(String locator, String text) {
        Q_JMB_WebElm.idSelectText(jmbProps, locator, text);
        return this;
    }

    public static Integer rowCount(String locator) {
        Integer count = Q_JMB_WebElm.xpCountTableRows(jmbProps, locator);
        return count;
    }

    public Q_JMB_AccountObjects registerLink() {
        Q_JMB_WebElm.id(jmbProps,"acc.createAccount.id");
        return this;
    }
    public Q_JMB_AccountObjects registerFirstName(String firstName) {
        Q_JMB_WebElm.idSend(jmbProps, "acc.createFname.id", firstName);
        return this;
    }
    public Q_JMB_AccountObjects registerLastName(String lastName) {
        Q_JMB_WebElm.idSend(jmbProps, "acc.createLname.id", lastName);
        return this;
    }
    public Q_JMB_AccountObjects registerPhoneNumber(String phoneNumber) {
        Q_JMB_WebElm.idSend(jmbProps, "acc.createPhone.id", phoneNumber);
        return this;
    }
    public Q_JMB_AccountObjects registerEmail(String registerEmail) {
        Q_JMB_WebElm.idSend(jmbProps, "acc.createEmail.id", registerEmail);
        return this;
    }
    public Q_JMB_AccountObjects registerPassword(String password) {
        Q_JMB_WebElm.idSend(jmbProps, "acc.createPwd.id", password);
        return this;
    }
    public Q_JMB_AccountObjects registerConfirmPassword(String confirmPassword) {
        Q_JMB_WebElm.idSend(jmbProps, "acc.createConfirm.id", confirmPassword);
        return this;
    }
    public Q_JMB_AccountObjects registerAgree() {
        Q_JMB_WebElm.name(jmbProps, "acc.regAgree.name");
        return this;
    }
    public Q_JMB_AccountObjects registerButton() {
        Q_JMB_WebElm.id(jmbProps, "acc.createRegBtn.id");
        return this;
    }

    public Q_JMB_AccountObjects loginLink() {
        Q_JMB_WebElm.id(jmbProps, "acc.login.id");
        return this;
    }
    public Q_JMB_AccountObjects userEmail(Integer user) {
        UserContainer uc = new UserContainer(user);
        Q_JMB_WebElm.idSend(jmbProps, "acc.loginEmail.id", uc.userEmail);
        return this;
    }

    public Q_JMB_AccountObjects userPassword(Integer user) {
        UserContainer uc = new UserContainer(user);
        Q_JMB_WebElm.idSend(jmbProps, "acc.loginPwd.id", uc.passwd);
        return this;
    }

    public Q_JMB_AccountObjects loginButton() {
        Q_JMB_WebElm.id(jmbProps, "acc.loginSubmitBtn.id");
        Assert.assertTrue(Q_JMB_WebElm.cnRetText(jmbProps, "acc.welcomeMsg.className").contains("Welcome"));

        return this;
    }

    public Q_JMB_AccountObjects bridgeGuest() {

        return this;
    }

    public Q_JMB_AccountObjects accountRegistration(Integer user) {
        registerLink();
        UserContainer newUser = new UserContainer(user);
        registerFirstName(newUser.firstName);
        registerLastName(newUser.lastName);
        registerPhoneNumber(newUser.phoneNumber);
        registerEmail(newUser.userEmail);
        registerPassword(newUser.passwd);
        registerConfirmPassword(newUser.passwd);

        registerAgree();
        registerButton();
        return this;
    }
    public Q_JMB_AccountObjects checkoutRegistration(int user, String regButton){
        Q_JMB_WebElm.myWait(5000);
        UserContainer newUser = new UserContainer(user);
        Q_JMB_WebElm.xpClear(jmbProps, "acc.createPwd.xp");
        Q_JMB_WebElm.xpSend(jmbProps, "acc.createPwd.xp", newUser.passwd);
        Q_JMB_WebElm.xpClear(jmbProps, "acc.createConfirm.xp");
        Q_JMB_WebElm.xpSend(jmbProps, "acc.createConfirm.xp", newUser.passwd);
        Q_JMB_WebElm.myWait(5000);
        try{
            Q_JMB_WebElm.id(jmbProps, regButton);
            Q_JMB_WebElm.myWait(1000);
            deleteUser();
            Q_JMB_WebElm.myWait(5000);
        }
        catch(Throwable ex){
            System.out.println(ex);
        }
        return this;
    }

    public Q_JMB_AccountObjects deleteUser(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS.SECONDS);
        Assert.assertTrue(Q_JMB_WebElm.cnDisplayed(jmbProps, "acc.welcomeMsg.className"));
        Q_JMB_WebElm.myWait(1000);
        driver.navigate().to(baseUrl +"/cybersource-reset.php");
        Q_JMB_WebElm.myWait(1000);
        System.out.println(driver.getCurrentUrl());
        Q_JMB_WebElm.id(jmbProps, "acc.deleteUser.id");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().to(baseUrl);
        Assert.assertTrue(Q_JMB_WebElm.idDisplayed(jmbProps, "acc.login.id"));
        System.out.println("Delete user");
        return this;
    }
    public Q_JMB_AccountObjects loginUser(Integer user) {
        Q_JMB_WebElm.myWait(500);
        loginLink();
        userEmail(user);
        userPassword(user);
        loginButton();
        return this;
    }
    public Q_JMB_AccountObjects logoutUser() {
            Q_JMB_WebElm.id(jmbProps, "acc.logoutLink.id");
            Q_JMB_WebElm.myWait(3000);
            return this;
    }
    public static void logoutUser(String logoutLink) {
        try {
            Assert.assertTrue(Q_JMB_WebElm.idDisplayed(jmbProps, logoutLink));
            Q_JMB_WebElm.id(jmbProps, logoutLink);
        } catch (Throwable ex) {
            driver.navigate().to(baseUrl);
        }
    }
    public Q_JMB_AccountObjects accounttMenuLinks(String accLink) {
        Q_JMB_WebElm.moveIt(jmbProps, "acc.myAccount.link.xp");
        System.out.println("Megam Menu " + accLink);
        switch (accLink) {
            case "orders":
                Q_JMB_WebElm.xp(jmbProps, "acc.account.orders.xp");
                break;
            case "sell to us":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountSellToUs.xp");
                break;
            case "my information":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountMyInfo.xp");
                break;
            case "addresses":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountAddresses.xp");
                break;
            case "payments":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountPayment.xp");
                Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "acc.account.PaymentPage.xp"), "Your Credit and Debit Cards");
                break;
            case "wish list":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountWishList.xp");
                break;
            case "alerts":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountAlerts.xp");
                break;
            default:
                System.out.println("Invalid option for account link");
                break;
        }
        return this;
    }
    public Q_JMB_AccountObjects myAccount(String accTab){
        Q_JMB_WebElm.myWait(2000);
        Q_JMB_WebElm.moveIt(jmbProps, "acc.myAccountLink.xp");
        switch ( accTab ){
            case"orders":
                Q_JMB_WebElm.myWait(500);
                Q_JMB_WebElm.xp(jmbProps, "acc.accountOrders.xp");
                break;
            case"sell to us":
                Q_JMB_WebElm.myWait(500);
                Q_JMB_WebElm.xp(jmbProps, "acc.accountSellToUs.xp");
                break;
            case"my information":
                Q_JMB_WebElm.myWait(500);
                Q_JMB_WebElm.xp(jmbProps, "acc.accountMyInfo.xp");
                break;
            case"addresses":
                Q_JMB_WebElm.myWait(500);
                Q_JMB_WebElm.xp(jmbProps, "acc.accountAddresses.xp");
                Q_JMB_WebElm.myWait(500);
                break;
            case"payments":
                Q_JMB_WebElm.myWait(500);
                Q_JMB_WebElm.xp(jmbProps, "acc.accountPayment.xp");
                Q_JMB_WebElm.myWait(2000);
                Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "acc.account.PaymentPage.xp"),"Your Credit and Debit Cards");
                break;
            case"wishlist":
                Q_JMB_WebElm.myWait(500);
                Q_JMB_WebElm.xp(jmbProps, "acc.accountWishList.xp");

                break;
            case"alerts":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountAlerts.xp");
                break;
            default:
                System.out.println("Invalid option for account tab");
                break;
        }
        return this;
    }
    public Q_JMB_AccountObjects accountTabs(String accLink){
        formXp( "acc.myAccountLink.xp");
        switch ( accLink ){
            case"orders":
                Q_JMB_WebElm.xp(jmbProps,"acc.accountTabOrders.xp");
                break;
            case"my information":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountTabMyInfo.xp");
                break;
            case"addresses":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountTabAddresses.xp");
                break;
            case"payments":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountTabPayment.xp");
                Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "acc.account.PaymentPage.xp"),"Your Credit and Debit Cards");
                break;
            case"alerts":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountTabAlerts.xp");
                break;
            case"wish list":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountTabWishList.xp");

                break;
            default:
                System.out.println("Invalid option for account tab");
                break;
        }
        return this;
    }
    public Q_JMB_AccountObjects orderActions(String orderAction){
        switch(orderAction){
            case"noOrders":
                Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "acc.accountNoOrders.xp"), "No Recent Orders");
                System.out.println("Verified no orders for this user");
                break;
            case"pagination":
                int recordsPerPage = 15;
                Assert.assertTrue(Q_JMB_WebElm.cnDisplayed(jmbProps, "acc.accountOrdersPagination.className"));
                System.out.println("Verified order pagination");
                break;
            case"viewPending":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountOrdersView.xp");
                break;
            case"viewPaid":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountOrdersView.xp");
                break;
            case"status":
                Q_JMB_WebElm.xpRetText(jmbProps, "acc.orderTop.xp");
                System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "acc.orderTop.xp"));
                Q_JMB_WebElm.xpRetText(jmbProps, "acc.orderTopStatus.xp");
                System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "acc.orderTopStatus.xp"));
                break;
            case"switch to ach":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountOrdersView.xp");
                Q_JMB_Controls.scrolDownPixel(600);
                Q_JMB_WebElm.id(jmbProps, "acc.account.SwitchPayment.id");
                Q_JMB_Controls.checkAlert();
                Q_JMB_WebElm.myWait(1000);
                Q_JMB_WebElm.xp(jmbProps, "acc.account.TopPaymentOption.xp");
                Q_JMB_WebElm.xp(jmbProps, "acc.account.SwitchSave.xp");
                Q_JMB_WebElm.myWait(2000);
                Q_JMB_Controls.checkAlert();
                Q_JMB_WebElm.myWait(2000);
                System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "acc.account.SwitchVerify.xp"));
                Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "acc.account.SwitchVerify.xp"),"ACH");
                Q_JMB_Controls.checkAlert();

                break;
            case"mail check":
                Q_JMB_WebElm.xp(jmbProps, "acc.accountOrdersView.xp");
                Q_JMB_WebElm.id(jmbProps, "acc.account.Order.CheckMailed.id");
                Q_JMB_WebElm.myWait(1000);
                Q_JMB_WebElm.idSend(jmbProps, "acc.account.CheckMailedNote.id", "Check is in the mail Automated");
                Q_JMB_WebElm.myWait(1000);
                Q_JMB_WebElm.id(jmbProps, "acc.account.CheckMailedSubmit.id");
                Q_JMB_WebElm.myWait(1000);
                Q_JMB_Controls.checkAlert();
                break;
            default:
                System.out.println("Invalid payment options");
        }
        try {
        }
        catch (Throwable ex){
            Assert.fail(" Failed to verify no orders for user");
        }
        return this;
    }
    public Q_JMB_AccountObjects paymentMethods(String paymentAction) throws FileNotFoundException {
        switch(paymentAction){
            case"saved cards":
                System.out.println(Q_JMB_WebElm.xpRetText(jmbProps, "acc.account.PaymentCardNumbers1.xp"));
                Assert.assertTrue(Q_JMB_WebElm.xpRetText(jmbProps, "acc.account.PaymentCardNumbers1.xp").contains("Visa Ending in: 0002"));
                System.out.println(" Card 1 text: " + Q_JMB_WebElm.xpRetText(jmbProps, "acc.account.PaymentCardNumbers1.xp"));
                Assert.assertTrue(Q_JMB_WebElm.xpRetText(jmbProps, "acc.account.PaymentCardNumbers2.xp").contains("MasterCard Ending in: 0007"));
                System.out.println(" Card 2 text: " + Q_JMB_WebElm.xpRetText(jmbProps, "acc.account.PaymentCardNumbers2.xp"));
                break;
            case"change default":
                Q_JMB_WebElm.myWait(500);
                if(Q_JMB_WebElm.xpSelected(jmbProps, "acc.account.PaymentSetcard1.xp").equals(true)){
                    Q_JMB_WebElm.xp(jmbProps, "acc.account.PaymentSetcard2.xp");
                    Q_JMB_WebElm.myWait(1000);
                    System.out.println("Second card is selected " + Q_JMB_WebElm.xpRetText(jmbProps, "acc.account.PaymentMessage.xp"));
                    Assert.assertTrue(Q_JMB_WebElm.idDisplayed(jmbProps, "acc.account.PaymentUpdated.id"));
                }
                else{
                    Q_JMB_WebElm.xp(jmbProps, "acc.account.PaymentSetcard1.xp");
                    Q_JMB_WebElm.myWait(2000);
                    System.out.println("First card is selected " + Q_JMB_WebElm.xpRetText(jmbProps, "acc.account.PaymentMessage.xp"));
//                    Assert.assertTrue(WebElm.idDisplayed(jmbProps,"acc.account.PaymentUpdated.id"));
                }
                break;
            case"add card":
                Q_JMB_WebElm.xp(jmbProps, "acc.account.AddCard.xp");
                Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
                chk.creditCardForm(2);
                billingAddress(3);
                Q_JMB_WebElm.id(jmbProps,"acc.accSaveNewCC.id");
                Q_JMB_WebElm.myWait(2000);
                Q_JMB_Controls.checkAlert();
                break;
            case"delete card":
                Q_JMB_WebElm.xp(jmbProps, "acc.account.PaymentDeleteCard.xp");
                Q_JMB_WebElm.myWait(2000);
                Q_JMB_Controls.checkAlert();
                Q_JMB_WebElm.myWait(2000);
                Assert.assertTrue(Q_JMB_WebElm.idDisplayed(jmbProps, "acc.account.PaymentNocard.id"));
                break;
            case"ach payment":
                Assert.assertTrue(Q_JMB_WebElm.xpRetText(jmbProps, "acc.account.PaymentAch1.xp").contains("Chase Plaid Checking"));
                System.out.println(" ACH Account 1: " + Q_JMB_WebElm.xpRetText(jmbProps, "acc.account.PaymentAch1.xp"));

                break;
            case"expiring card":
                Q_JMB_CheckoutObjects chk1 = new Q_JMB_CheckoutObjects();
                Q_JMB_WebElm.xp(jmbProps,"acc.account.AddCard.xp");
                chk1.creditCardForm(12);
                billingAddress(3);
                Q_JMB_WebElm.myWait(2000);
//                Controls.checkAlert();
                Q_JMB_WebElm.myWait(4000);
                String alertError = Q_JMB_Controls.checkAndGetAlertText();
                System.out.println("Alert Text      " + alertError);
//                myAccount("payments");
                String alertMessage="General Error. To resolve this issue, please contact your bank using the number on the back of your card to proceed.";
                Q_JMB_Controls.scrolUpPixel(300);

//                String errMsg = "Important Note: Your Credit card has expired or is expiring this month. Please add a new valid Credit Card before proceeding. Click here to add a new credit card.";
//                System.out.println("Error message      " + WebElm.idRetText(jmbProps, "acc.account.ccAlert.msg.id"));
//                org.testng.Assert.assertEquals(WebElm.idRetText(jmbProps, "acc.account.ccAlert.msg.id"), errMsg);
                break;
        }
        return this;
    }
    public Q_JMB_AccountObjects billingAddress(Integer index) throws FileNotFoundException {
        AddressContainer ship = new AddressContainer(index);
        Q_JMB_WebElm.idSend(jmbProps, "chk.account.Payment.newCC.fname.id", ship.firstName);
        Q_JMB_WebElm.idSend(jmbProps, "chk.account.Payment.newCC.lname.id", ship.lastName);
        Q_JMB_WebElm.idSendchord(jmbProps,"chk.account.Payment.newCC.street.id", ship.street);
        Q_JMB_WebElm.idSendchord(jmbProps,"chk.account.Payment.newCC.city.id", ship.city);
        Q_JMB_WebElm.idSelectValue(jmbProps,"chk.account.Payment.newCC.state.id", ship.state);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS.SECONDS);
        Q_JMB_WebElm.myWait(1000);
        Q_JMB_WebElm.idSend(jmbProps, "chk.account.Payment.newCC.zicode.id", ship.zipcode);
        Q_JMB_WebElm.idSend(jmbProps, "chk.account.Payment.newCC.phone.id", ship.phoneNumber);
        Q_JMB_WebElm.myWait(1000);
        Q_JMB_WebElm.id(jmbProps,"acc.accSaveNewCC.id");
        return this;
    }
    public Q_JMB_AccountObjects addressTab(String addressAction) throws FileNotFoundException {
        Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
        switch ( addressAction ) {
            case"add new address":
                Q_JMB_WebElm.myWait(2000);
                Q_JMB_WebElm.id(jmbProps, "acc.accountAddressAdd.id");
                acc.acctShippingAddress(16);
                Q_JMB_WebElm.myWait(2000);
                validateAccountAddress();
                Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.secondAdd.xp").equals(true));
                System.out.println("Verified address was added and displayed");
                break;
            case"edit address":
                Q_JMB_WebElm.xp(jmbProps, "acc.account.EditAddress.xp");
                acc.acctShippingAddress(14);
                Q_JMB_WebElm.myWait(2000);
//                validateAddress("acc.saveAddress.id", "acc.addressContinueWithAdd.id", "acc.addressShippingError.id", "save-address");
                break;
            case"delete address":
                Q_JMB_WebElm.xp(jmbProps, "acc.account.AddressDelete.xp");
                Q_JMB_WebElm.myWait(500);
                Q_JMB_Controls.checkAlert();
                System.out.println("Verified address deleted ");
                driver.navigate().refresh();
                break;
        }
        return this;
    }
    public Q_JMB_AccountObjects acctShippingAddress(Integer addIndex) throws FileNotFoundException {
        AddressContainer address = new AddressContainer(addIndex);
        Q_JMB_WebElm.idClear(jmbProps, "acc.account.AddressShippingFirstName.id");
        Q_JMB_WebElm.idSend(jmbProps, "acc.account.AddressShippingFirstName.id", address.firstName);
        Q_JMB_WebElm.idClear(jmbProps, "acc.account.AddressShippingLastName.id");
        Q_JMB_WebElm.idSend(jmbProps, "acc.account.AddressShippingLastName.id", address.lastName);
        Q_JMB_WebElm.idClear(jmbProps, "acc.account.AddressShippingAddress.id");
        Q_JMB_WebElm.idSend(jmbProps, "acc.account.AddressShippingAddress.id", address.street);
        Q_JMB_WebElm.myWait(1000);
        Q_JMB_WebElm.idSendTab(jmbProps, "acc.account.AddressShippingAddress.id");
        Q_JMB_WebElm.myWait(3000);
        Q_JMB_WebElm.idClear(jmbProps, "acc.account.AddressShippingCity.id");
        Q_JMB_WebElm.idSend(jmbProps, "acc.account.AddressShippingCity.id", address.city);
        Q_JMB_WebElm.idSendTab(jmbProps, "acc.account.AddressShippingCity.id");
        Q_JMB_WebElm.myWait(2000);
        Q_JMB_WebElm.id(jmbProps, "acc.account.AddressShippingState.id");
        Q_JMB_WebElm.idSelectValue(jmbProps, "acc.account.AddressShippingState.id", address.state);
        Q_JMB_WebElm.myWait(2000);
        Q_JMB_WebElm.idClear(jmbProps, "acc.account.AddressShippingZip.id");
        Q_JMB_WebElm.idSend(jmbProps, "acc.account.AddressShippingZip.id",address.zipcode);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS.SECONDS);
        //JavascriptExecutor executor = (JavascriptExecutor)driver;executor.executeScript("arguments[0].clear()",(driver.find(By.id(jmbProps.getProperty("guestCheckout.guest.shipping.zip.id")))));
        Q_JMB_WebElm.myWait(500);

        Q_JMB_WebElm.idClear(jmbProps, "acc.account.AddressShippingPhone.id");
        Q_JMB_WebElm.idSend(jmbProps, "acc.account.AddressShippingPhone.id", address.phoneNumber);
        return this;
    }
    public Q_JMB_AccountObjects validateAccountAddress() {
//        WebDriverWait wait = new WebDriverWait(driver, 60);
        Q_JMB_WebElm.id(jmbProps, "chk.saveAddress.id");
        try {
            Q_JMB_WebElm.myWait(2000);
            org.testng.Assert.assertTrue(Q_JMB_WebElm.idDisplayed(jmbProps, "chk.addressShippingError.id").equals(true));
            Q_JMB_WebElm.idDisplayed(jmbProps, "chk.addressContinueWithAdd.id");
            Q_JMB_WebElm.id(jmbProps, "chk.addressContinueWithAdd.id");

//                Assert.assertTrue(WebElm.idDisplayed(jmbProps, continueWith).equals(false));

        } catch (Throwable ex) {
        }
        return this;
    }
    public Q_JMB_AccountObjects adminLogout() {
        driver.navigate().to(baseUrl);
        logoutUser();
        return this;
    }

    public Q_JMB_AccountObjects invalidPasswordInputs(int addIndex) throws FileNotFoundException {

        InvalidPasswordContainer password = new InvalidPasswordContainer(addIndex);
        formId("acc.createAccount.id");
        Q_JMB_WebElm.myWait(2000);
        formInputId("acc.createFname.id", password.firstName);
        formInputId( "acc.createLname.id", password.lastName);
        formInputId(  "acc.createPhone.id", password.phoneNumber);
        formInputId(  "acc.createEmail.id", password.email+"@testmail.com");
        formInputId(  "acc.createPwd.id", password.passwd);
        System.out.println(password.passwd);
        formInputId(  "acc.createConfirm.id", password.confPassword);
        Q_JMB_WebElm.name(jmbProps, "acc.regAgree.name");
        Q_JMB_WebElm.id(jmbProps, "acc.createRegBtn.id");
        Q_JMB_WebElm.myWait(500);
        String actualMsg=strXpText("acc.passworMessage.xp");
        System.out.println(actualMsg);
        String expectedMsg="The password must be between 8 to 30 characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
        Assert.assertEquals(actualMsg, expectedMsg);
        driver.navigate().to(baseUrl);
        driver.navigate().refresh();
        
        return this;
    }

    public Q_JMB_AccountObjects invalidPasswordInputsRegisterPage(int addIndex) throws FileNotFoundException {
        InvalidPasswordContainer password = new InvalidPasswordContainer(addIndex);
        driver.navigate().to("https://qa.jmbullion.com/register/");
        formInputId( "acc.createFname.id", password.firstName);
        formInputId( "acc.createLname.id", password.lastName);
        formInputId( "acc.createPhone.id", password.phoneNumber);
        formInputId( "acc.createEmail.id", password.email+"@testmail.com");
        formInputId( "acc.createPwd.id", password.passwd);
        System.out.println(password.passwd);
        formInputId( "acc.createConfirm.id", password.confPassword);
        Q_JMB_WebElm.name(jmbProps, "acc.regAgree.name");
        Q_JMB_WebElm.id(jmbProps, "acc.createRegBtn.id");
        Q_JMB_WebElm.myWait(500);
        String actualMsg=strXpText("acc.passworMessage.xp");
        System.out.println(actualMsg);
        String expectedMsg="The password must be between 8 to 30 characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
        Assert.assertEquals(actualMsg, expectedMsg);
    return this;
    }
    public Q_JMB_AccountObjects checkoutRegistrationInvalidPassword(int addIndex) throws FileNotFoundException{
        Q_JMB_WebElm.myWait(3000);
        InvalidPasswordContainer password = new InvalidPasswordContainer(addIndex);
        formInputXp("acc.createPwd.xp", password.passwd);
        System.out.println(password.passwd);
        formInputXp("acc.createConfirm.xp", password.confPassword);
        Q_JMB_WebElm.myWait(2000);
        try{
            Q_JMB_WebElm.myWait(1000);
            formId( "acc.createRegBtn.id");
            Q_JMB_WebElm.myWait(1000);
            //        WebElement validationMsg=driver.findElement(By.xpath("//div[contains(text(),'The password must have')]"));
//        String actualMsg=validationMsg.getText();
            String actualMsg=strXpText("acc.passworMessage.xp");
            System.out.println(actualMsg);
            String expectedMsg="The password must be between 8 to 30 characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
            Assert.assertEquals(actualMsg, expectedMsg);
        }
        catch(Throwable ex){
            System.out.println(ex);
        }
        return this;
    }
        public Q_JMB_AccountObjects myInfo(String myInfoAction){
        switch(myInfoAction){
            case "edit my info":
                formId("acc.editMyInfo.id");
                break;
            case"change password":
                Q_JMB_WebElm.myWait(2000);
                formId("acc.changeMyPassword.id");
                break;
            case "changeMy email":
                formId("acc.changeMyEmail.id");
                break;
            default:
                System.out.println("Invalid action selected");
                break;
        }
        return this;
    }
    public Q_JMB_AccountObjects changePassInvalidInputs(int index) throws FileNotFoundException {
        Q_JMB_WebElm.myWait(2000);
        InvalidPasswordContainer password = new InvalidPasswordContainer(index);
        formInputId("acc.pass.current.id", "Jan@2020");
        formInputId("acc.newPass.id", password.passwd);
        formInputId("acc.confirmPass.id", password.confPassword);
        System.out.println(password.confPassword);
        formId("acc.passChang.save.id");
        Q_JMB_Controls.checkAlert();
        return this;
    }
    public Q_JMB_AccountObjects validPasswordInputsRegisterPage(int index) throws FileNotFoundException {
        driver.navigate().to(baseUrl + "/register/");
        InvalidPasswordContainer password = new InvalidPasswordContainer(index);
        formInputId( "acc.createFname.id", password.firstName);
        formInputId( "acc.createLname.id", password.lastName);
        formInputId( "acc.createPhone.id", password.phoneNumber);
        formInputId( "acc.createEmail.id", System.currentTimeMillis()+password.email+"@jmbullion.com");
        formInputId( "acc.createPwd.id", password.passwd);
        System.out.println(password.passwd);
        formInputId( "acc.createConfirm.id", password.confPassword);
        registerAgree();
        registerButton();
        return this;
    }
    public Q_JMB_AccountObjects changePassvalidInputs(int index, String currPassword) throws FileNotFoundException {
        Q_JMB_WebElm.myWait(2000);
        InvalidPasswordContainer password = new InvalidPasswordContainer(index);
        formInputId( "acc.pass.current.id", currPassword);
        formInputId( "acc.newPass.id", password.passwd);
        formInputId( "acc.confirmPass.id", password.confPassword);
        System.out.println(password.confPassword);
        formId("acc.passChang.save.id");
        Q_JMB_Controls.checkAlert();
        return this;
    }
    public Q_JMB_AccountObjects checkoutRegistrationInvalidPassword(String password, String confPassword, String regButton){
        Q_JMB_WebElm.myWait(3000);
        formInputXp("acc.createPwd.xp", password);
        System.out.println(password);
        formInputXp("acc.createConfirm.id", confPassword);
        Q_JMB_WebElm.myWait(2000);
        try{
            Q_JMB_WebElm.myWait(1000);
            formId(regButton);
            Q_JMB_WebElm.myWait(1000);
            String actualMsg=strXpText("acc.passworMessage.xp");
            System.out.println(actualMsg);
            String expectedMsg="The password must be between 8 to 30 characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
            Assert.assertEquals(actualMsg, expectedMsg);

        }
        catch(Throwable ex){
            System.out.println(ex);
        }
        return this;
    }
    public  void addProductsToAlert() {
        Q_JMB_AccountObjects account = new Q_JMB_AccountObjects();
        account.myAccount("alerts");
        Q_JMB_WebElm.myWait(1500);
        String msg1="You have not yet added any products.";
        org.testng.Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps,"acc.alerts.noProducts.xp"),msg1);
        driver.navigate().to(baseUrl + "/1-2-oz-proof-american-gold-eagles-ry-capsules-only/");
        Q_JMB_WebElm.xp(jmbProps, "acc.wishlist.instockAlert.Btn.xp");
        driver.navigate().to(baseUrl + "/2019-w-1-10-oz-proof-american-gold-eagle-coin/");
        Q_JMB_WebElm.xp(jmbProps, "acc.wishlist.instockAlert.Btn.xp");
        driver.navigate().to(baseUrl + "/2019-w-1-4-oz-proof-american-gold-eagle-coin/");
        Q_JMB_WebElm.xp(jmbProps, "acc.wishlist.instockAlert.Btn.xp");
    }
    public  void removeProductsFromAlert() {
        Q_JMB_AccountObjects account = new Q_JMB_AccountObjects();
        account.myAccount("alerts");
//     driver.manage().window().fullscreen();
        System.out.println(Q_JMB_WebElm.xpRetText(jmbProps,"acc.alerts.presentProducts.xp"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps,"acc.alerts.presentProducts.xp"),"You are currently on in-stock alert for the following products:");
        List<WebElement> products = driver.findElements(By.xpath("//a[@class='wcwl_remove_product']"));
        int productCount = products.size();
        System.out.println(products.size());
        for(int i = 0;i<=productCount-1;i++) {
            Q_JMB_WebElm.myWait(1000);
            Q_JMB_WebElm.xp(jmbProps, "acc.alerts.removeProduct.xp");
            String msg2="You have removed";
            System.out.println(Q_JMB_WebElm.xpRetText(jmbProps,"acc.alerts.removedInstockAlertProduct.msg.xp"));
            org.testng.Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps,"acc.alerts.removedInstockAlertProduct.msg.xp").contains(msg2),true);
            Q_JMB_Controls.xpExecutorScrollToView(jmbProps, "acc.accountAlerts.xp");
            Q_JMB_WebElm.myWait(1000);
//   		account.myAccount("alerts");
        }
    }
    public  void addProductToWishList() {
        Q_JMB_AccountObjects account = new Q_JMB_AccountObjects();
        driver.navigate().to(baseUrl + "/1-oz-canadian-palladium-maple-leaf/");
        Q_JMB_WebElm.myWait(1000);
        Q_JMB_WebElm.xp(jmbProps, "pdp.addToWishlist.xp");
        Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "pdp.removeFromWishlist.xp").equals(true));
        account.myAccount("wishlist");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "pdp.verifyWishListProduct.xp").equals(true));
        Q_JMB_WebElm.myWait(1000);

    }
    public  void addRemoveProductWishlistPDP() {
        try {
            driver.navigate().to(baseUrl + "/1-2-oz-american-gold-eagle/");
            Q_JMB_WebElm.myWait(2000);
            Q_JMB_WebElm.xp(jmbProps, "pdp.addToWishlist.xp");
            if(Q_JMB_WebElm.xpDisplayed(jmbProps, "pdp.removeFromWishlist.xp") && Q_JMB_WebElm.xpDisplayed(jmbProps, "pdp.wishlist.ItemsAddedORRemoved.msg.xp")) {
                Q_JMB_WebElm.xp(jmbProps, "pdp.removeFromWishlist.xp");
                Q_JMB_WebElm.xpDisplayed(jmbProps, "pdp.addToWishlist.xp");
            }
            if(Q_JMB_WebElm.xpDisplayed(jmbProps, "pdp.wishlist.instockAlert.Btn.xp")) {
                Q_JMB_WebElm.xp(jmbProps, "pdp.wishlist.instockAlert.Btn.xp");
                Q_JMB_WebElm.xpDisplayed(jmbProps, "pdp.wishlist.addedToInstockAlert.msg.xp");
                Q_JMB_WebElm.xp(jmbProps, "pdp.wishlist.removeInstockAlert.Btn.xp");
                Q_JMB_WebElm.xpDisplayed(jmbProps, "pdp.wishlist.removedFromInstockAlert.msg.xp");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public  void addProductWishlistPDPGuest() {
        try {
            driver.navigate().to(baseUrl + "/1-2-oz-american-gold-eagle/");
            Q_JMB_WebElm.myWait(2000);
            Q_JMB_WebElm.xp(jmbProps, "pdp.addToWishlist.guest.xp");
            //ElemSteps.idElement(jmbProps, "pdp.wishlist.loginAccount.id");
            Q_JMB_WebElm.xpDisplayed(jmbProps, "pdp.wishlist.loginModalDisplay.xp");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public  void wishListInStockAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Q_JMB_AccountObjects account = new Q_JMB_AccountObjects();
        addProductToWishlistPdp();
        Q_JMB_WebElm.myWait(2000);
        account.myAccount("wishlist");
        wishlistPageAddInStockAlert();
        removeInStockAlertInnAlertTab();
        addInStockAlertExistingWishlist();
        account.myAccount("alerts");
        removeInStockAlert();

    }
    public  void addProductToWishlistPdp() {
        driver.navigate().to(baseUrl + "/1-2-oz-proof-american-gold-eagles-ry-capsules-only/");
        Q_JMB_WebElm.myWait(1000);
        Q_JMB_WebElm.xp(jmbProps, "pdp.addToWishlist.xp");
        Q_JMB_WebElm.xpDisplayed(jmbProps, "pdp.removeFromWishlist.xp");
    }
    public  void wishlistPageAddInStockAlert() {
        Q_JMB_WebElm.xpDisplayed(jmbProps, "pdp.verifyWishListProduct.xp");
        Q_JMB_WebElm.myWait(4000);
        Q_JMB_WebElm.xpExecutor(jmbProps, "acc.wishlist.instockAlert.Btn.xp");
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps,"acc.wishlist.productAdded.msg.xp"),"In-stock alert has been added.");
        Q_JMB_WebElm.xpExecutor(jmbProps, "acc.alerts.tab.xp");
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps,"acc.alerts.presentProducts.xp"),"You are currently on in-stock alert for the following products:");
        Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.alerts.wishlistproduct.xp");
        System.out.println("Product present on alert tab : "+ Q_JMB_WebElm.xpRetText(jmbProps, "acc.alerts.wishlistproduct.xp"));
    }
    public void removeInStockAlertInnAlertTab(){
        Q_JMB_WebElm.xpExecutor(jmbProps, "acc.wishlist.removeInstockAlert.Btn.xp");
        Q_JMB_WebElm.xpExecutor(jmbProps, "acc.alerts.tab.xp");
        String msg1="You have not yet added any products.";
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps,"acc.alerts.noProducts.xp"),msg1);
    }
    public void addInStockAlertExistingWishlist(){
        Q_JMB_Controls.scrolUpPixel(800);
        Q_JMB_WebElm.moveIt(jmbProps, "acc.accountTabWishList.xp");
        Q_JMB_WebElm.xp(jmbProps, "acc.accountTabWishList.xp");
        Q_JMB_Controls.scrolUpPixel(800);
        Q_JMB_WebElm.xpExecutor(jmbProps, "acc.wishlist.instockAlert.Btn.xp");
    }
    public  void removeInStockAlert() {
        Q_JMB_WebElm.xp(jmbProps, "acc.alerts.removeProduct.xp");
        String msg2="You have removed";
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps,"acc.alerts.removedInstockAlertProduct.msg.xp").contains(msg2),true);
        Q_JMB_Controls.scrolUpPixel(800);
        Q_JMB_WebElm.xp(jmbProps, "acc.accountWishListTab.xp");
        Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.wishlist.instockAlert.Btn.xp");
    }
    public  void wishListInStockAlertPdp() {
        try {
            Q_JMB_AccountObjects account = new Q_JMB_AccountObjects();
            String partialUrl="/1-2-oz-american-gold-eagle/";
            driver.navigate().to(baseUrl +partialUrl);
            Q_JMB_WebElm.myWait(2000);
            Q_JMB_WebElm.xp(jmbProps, "pdp.addToWishlist.xp");
            Q_JMB_WebElm.xpDisplayed(jmbProps, "pdp.removeFromWishlist.xp");
            account.myAccount("wishlist");
            Q_JMB_WebElm.xpDisplayed(jmbProps, "pdp.verifyWishListProduct.xp");
            Q_JMB_WebElm.myWait(2000);
            Q_JMB_WebElm.xpExecutor(jmbProps, "acc.wishlist.instockAlert.Btn.xp");
            driver.navigate().to(baseUrl +partialUrl);
            driver.navigate().refresh();
            Q_JMB_WebElm.myWait(2000);
            Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.pdp.removeInstockAlert.btn.xp");
            account.myAccount("wishlist");
            Q_JMB_WebElm.xp(jmbProps, "acc.wishlist.removeInstockAlert.Btn.xp");
            driver.navigate().to(baseUrl +partialUrl);
            Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.pdp.instockAlert.btn.xp");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public  void addToCartMyAccountWishList(String quan) {
            Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
            Q_JMB_AccountObjects account = new Q_JMB_AccountObjects();
            Q_JMB_WebElm.xpSend(jmbProps,"acc.wishlist.productQty.xp",quan );
            Q_JMB_WebElm.xp(jmbProps, "acc.wishlist.ATC.button.xp");
            Q_JMB_WebElm.xp(jmbProps, "acc.modal.CheckoutNow.xp");
            cart.selectPaymentType("wire");
            Assert.assertEquals(quan, Q_JMB_WebElm.xpRetAttr(jmbProps,"acc.cart.quantity.xp", "value"));
            cart.removeItems();
    }
    public static void addMultipleProductsToWishList(){
        driver.navigate().to(baseUrl + "/5-gram-pamp-suisse-lunar-dragon-gold-bar/");
        Q_JMB_WebElm.xp(jmbProps, "pdp.addToWishlist.xp");
        driver.navigate().to(baseUrl + "/30-g-chinese-gold-panda-varied/");
        Q_JMB_WebElm.xp(jmbProps, "pdp.addToWishlist.xp");
        driver.navigate().to(baseUrl + "/1990-american-silver-eagle/");
        Q_JMB_WebElm.xp(jmbProps, "pdp.addToWishlist.xp");
        driver.navigate().to(baseUrl + "/mexican-silver-libertad/");
        Q_JMB_WebElm.xp(jmbProps, "pdp.addToWishlist.xp");
    }
    public  void wishlistPagination() {
        List<WebElement> pages= driver.findElements(By.xpath("//div[@id='bo-pagination']/a"));
        int pageCount=pages.size();
        System.out.println("Page Count : "+pageCount);
        for(int i=1;i<=pageCount;i++) {
            WebElement pageNo = driver.findElement(By.xpath("//div[@id='bo-pagination']/a["+i+"]"));
            System.out.println("Page :"+pageNo.getText()+" clicking");
            pageNo.click();
            Q_JMB_WebElm.myWait(4000);
        }
    }
    public  void removeProductFromWishlist() {
        Q_JMB_AccountObjects account = new Q_JMB_AccountObjects();
        account.myAccount("wishlist");
        if(Q_JMB_WebElm.xpDisplayed(jmbProps, "pdp.verifyWishListProduct.xp")==true) {
            Q_JMB_WebElm.xp(jmbProps, "acc.pdp.remove.Product1.FromWishlist.xp");
            Q_JMB_WebElm.myWait(1000);
            System.out.println("Product was removed from wishlist successfully...");
        }
        else {
            System.out.println("No Products to remove from wishlist on my account");
        }
    }
    public void buyAgain() {
        Q_JMB_WebElm.xp(jmbProps, "acc.orders.vieworbuyagain.xp");
        Q_JMB_WebElm.id(jmbProps, "acc.vieworders.buyagain.id");
        Q_JMB_WebElm.myWait(3000);
        if(Q_JMB_WebElm.idSelected(jmbProps, "cart.paymentType.CC.id")==false) {
            Q_JMB_WebElm.idExecutor(jmbProps, "cart.paymentType.CC.id");
        }
//        if(WebElm.xpDisplayed(jmbProps, "preSaleMsg.xp")) {
//            WebElm.id(jmbProps, "preSaleMsgCheckbox.id");
//        }
        Q_JMB_Controls.scrolDownPixel(500);
        Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
        cart.selectcheckoutBtn("bottom");
    }
    
    //JMB-5689 Start
  	/******************************************************************
  	* Description: Set the Fraud option on Customer View
  	* Parameters: String email - email of user to register
  	* Returns: None
  	* Status: Complete
  	*******************************************************************/	
  	public void deviceFingerprintAccountRegistration(String email) {
  		System.out.println("Registering user: " + email);
  		registerLink();
        registerFirstName("JMB");
        registerLastName("Device Fingerprint");
        registerPhoneNumber("9619611234");
        registerEmail(email);
        registerPassword("1212Te$t");
        registerConfirmPassword("1212Te$t");
        registerAgree();
        registerButton();
  	}
  	
  	/******************************************************************
     * Description: Verifies that the Account Registration Blocking Rules Applies
     * Parameters: None
     * Returns: None
     * Status: Complete
     *******************************************************************/
    public void verifyUserRegistrationBlockedBlock() {
        Q_JMB_WebElm.myWait(500);
        try {
     	   Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.registeredUserBlockMessage.xp");
     	   System.out.println("Account Registration was successfully blocked.");
        } catch (Throwable ex) {
     	   deleteUser();
     	   Assert.fail("Account Registration was not successfully blocked.");
        }
    }
    
    /******************************************************************
     * Description: Add Credit Card
     * Parameters: int cardIndex - index for JSON file
     * Returns: NA
     * Status: Complete
     *******************************************************************/
	public void deviceFingerprintAddCreditCard (int cardIndex) throws FileNotFoundException {
		System.out.println("Adding Credit Card with JSON index: " + cardIndex);
        Q_JMB_WebElm.xp(jmbProps, "acc.account.AddCard.xp");
        Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
        chk.creditCardForm(cardIndex);
        billingAddress(3);
        Q_JMB_WebElm.id(jmbProps,"acc.accSaveNewCC.id");
        Q_JMB_WebElm.myWait(2000);
	}
	
	/******************************************************************
     * Description: Delete Credit Card
     * Parameters: None
     * Returns: None
     * Status: Complete
     *******************************************************************/
	public void deviceFingerprintDeleteCreditCard() throws FileNotFoundException {
		Q_JMB_WebElm.xp(jmbProps, "acc.account.PaymentDeleteCard.xp");
        Q_JMB_WebElm.myWait(2000);
        Q_JMB_Controls.checkAlert();
        Q_JMB_WebElm.myWait(2000);         
    }
	
	/******************************************************************
	    * Description: Submits a forgot password request
	    * Parameters: None
	    * Returns: None
	    * Status: Complete
	    *******************************************************************/
	   public void forgetPassword(String email) {
	       Q_JMB_WebElm.myWait(500);
	       loginLink();
	       Q_JMB_WebElm.myWait(500);
	       Q_JMB_WebElm.xp(jmbProps, "acc.forgotPasswordLink.xp");
	       Q_JMB_WebElm.myWait(500);
	       Q_JMB_WebElm.xpSend(jmbProps, "acc.resetPasswordEmail.xp", email);
	       Q_JMB_WebElm.xp(jmbProps, "acc.resetPasswordCheckbox.xp");
	       Q_JMB_WebElm.xp(jmbProps, "acc.sendPasswordResetEmail.xp");
	       Q_JMB_WebElm.myWait(500);
	       try {
	    	   Q_JMB_WebElm.idDisplayed(jmbProps, "acc.restPasswordMessage.id");
	    	   System.out.println("Reset password email successfully sent.");
	       } catch (Throwable ex) {
	    	   Assert.fail("Reset password email not successfully sent.");
	       }
	   }
	   
	   /******************************************************************
	    * Description: Submits a forgot password request that should be blocked
	    * Parameters: None
	    * Returns: None
	    * Status: Complete
	    *******************************************************************/
	   public void forgetPasswordBlock(String email) {
	       Q_JMB_WebElm.myWait(500);
	       loginLink();
	       Q_JMB_WebElm.myWait(500);
	       Q_JMB_WebElm.xp(jmbProps, "acc.forgotPasswordLink.xp");
	       Q_JMB_WebElm.myWait(500);
	       Q_JMB_WebElm.xpSend(jmbProps, "acc.resetPasswordEmail.xp", email);
	       Q_JMB_WebElm.xp(jmbProps, "acc.resetPasswordCheckbox.xp");
	       Q_JMB_WebElm.xp(jmbProps, "acc.sendPasswordResetEmail.xp");
	       Q_JMB_WebElm.myWait(2000);
	       Assert.assertTrue(Q_JMB_Controls.checkAndGetAlertText().equals("Too many password resets. Please try again later."), 
	    		   "Password reset email not successfully blocked.");
	   }
	   
	   /******************************************************************
	    * Description: Logins in to user expecting Blocking Rules to apply
	    * Parameters: Integer user
	    * Returns: None
	    * Status: Complete
	    *******************************************************************/
	   public void loginUserBlock(Integer user) {
	       Q_JMB_WebElm.myWait(500);
	       loginLink();
	       userEmail(user);
	       userPassword(user);
	       Q_JMB_WebElm.id(jmbProps, "acc.loginSubmitBtn.id");
	       Q_JMB_WebElm.myWait(3000);
	       try {
	    	   Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.loginBlockMessage.xp");
	    	   System.out.println("Login was successfully blocked.");
	       } catch (Throwable ex) {
	    	   Assert.fail("Login was not successfully blocked.");
	       }
	   }
	   
	   /******************************************************************
	    * Description: Logins in to user expecting login to fail due to wrong password
	    * Parameters: Integer user
	    * Returns: None
	    * Status: Complete
	    *******************************************************************/
	   public void loginUserWrongPassword(Integer user) {
	       Q_JMB_WebElm.myWait(500);
	       loginLink();
	       userEmail(user);
	       Q_JMB_WebElm.idSend(jmbProps, "acc.loginPwd.id", "Bad Password");
	       Q_JMB_WebElm.id(jmbProps, "acc.loginSubmitBtn.id");
	       Q_JMB_WebElm.myWait(3000);
	       try {
	    	   Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.loginWrongPasswordMessage.xp");
	    	   System.out.println("Login was successfully blocked.");
	       } catch (Throwable ex) {
	    	   Assert.fail("Login was not successfully blocked.");
	       }
	   }
  	//JMB-5689 End
	//JMB-7670 Start
   /**********************************************************************
     * Description:     Captures revenue items from the My Account Page
     * Author:          Paul Patterson
     * Param:      		boolean hasSalesTax, boolean hasStateFee, boolean hasShippingTax, boolean hasGiftCert
     * Returns:         List<Float>
     **********************************************************************/
	public List<Float> myAccountPriceList(boolean hasSalesTax, boolean hasStateFee, 
			boolean hasShippingTax, boolean hasGiftCert) 
	{
		Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
		acc.accountTabs("orders");
		Q_JMB_WebElm.xp(jmbProps, "acc.accountOrdersView.xp");
        Q_JMB_WebElm.myWait(2000);
        List<Float> priceList = new ArrayList<Float>();
        Float calcTotal = Float.valueOf(0);
        Float subtotal = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"acc.order.subtotal.xp"));
        calcTotal = calcTotal + subtotal;
        priceList.add(subtotal);

        if (hasSalesTax)
        {
        	Float tax = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"acc.order.salesTax.xp"));
        	calcTotal = calcTotal + tax;
        	priceList.add(tax);
        }
        
        if (hasStateFee)
        {
        	Float stateFee = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"acc.order.stateFee.xp"));
        	calcTotal = calcTotal + stateFee;
        	priceList.add(stateFee);
        }

        String temp = Q_JMB_WebElm.xpRetText(jmbProps,"acc.order.shipping.xp");
        if (temp.equals("Free")) {
        	Float shipping = Float.valueOf("0.0");
        	calcTotal = calcTotal + shipping;
        	priceList.add(shipping);
        } else {
        	Float shipping = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"acc.order.shipping.xp"));
        	calcTotal = calcTotal + shipping;
        	priceList.add(shipping);
        }
        
        // Locators will need to be updated for this to work
        //if (hasShippingTax)
        //{
        	//Float shippingTax = Float.valueOf(Q_JMB_WebElm.xpRetTextRep(jmbProps,"acc.order.shipTax.xp"));
        	//calcTotal = calcTotal + shippingTax;
        	//priceList.add(shippingTax);
        //}
        
        if (hasGiftCert)
        {
        	Float discount = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"acc.order.discount.xp"));
        	calcTotal = calcTotal - discount;
        	priceList.add(discount);
        }
        
        calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
        Float total = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"acc.order.total.xp"));
        priceList.add(total);
        Assert.assertEquals(total, calcTotal, "My Account Order Page total does not match calculated revenue items.");
        System.out.println("[Pass] My Account Order Page total matches calculated revenue items.");
        return priceList;
    }
	//JMB-7670 End
	
	//JMB-7605 Start	
	/******************************************************
 	// * Description: To close the Popup in Checkout page
 	// * Param : String popupClose
	// * Jira Ticket: JMB 7605
	// * Status: Completed
	 //******************************************************/  
	public void closeLoginPopup(String popupClose) {
		Q_JMB_WebElm.xp(jmbProps, popupClose);		
	}
	//JMB-7605 End
	
	//JMB-7655 Start
	/***********************************************************************
    // * Description: To get the Customer name from Admin and Accounts Page
    // * Param      : String page
    // * Jira Ticket: JMB 7655
    // * Status     : Completed
    //**********************************************************************/  
	public String getCustomerName(String page) {
		String customerName=null;
		switch (page) {
		case "AccountPage":
			customerName=Q_JMB_WebElm.xpRetText(jmbProps,"acc.welcomeMessage.xp").replace("Welcome back,", "").trim();
			break;

		case "AdminPage":
			customerName=Q_JMB_WebElm.xpRetText(jmbProps,"adm.ordersForm.customerName.xp").replace("Customer:","").trim();				
			break;
		}
		return customerName;
	}
	//JMB-7655 End
	
	//JMB-6778-Start
	/********************************************************************
	// * Description  : To verify Order status in my accounts  
	// * Param        : NA
	// * Jira Ticket  : JMB 6778
	// * Status       : Completed
	//*******************************************************************/
	public void verifyMyAccountOrderStatus() {
		try {
			Q_JMB_WebElm.xpDisplayed(jmbProps, "myAccount.orderDisplay.xp");
			int count = Q_JMB_WebElm.xpCountTableRows(jmbProps, "myAccount.orders.orderNo.xp");
			accounttMenuLinks("orders");
			for (int rowElement = 0; rowElement < count; rowElement++) {
				String orderStatus = Q_JMB_WebElm.xpRetText(jmbProps, "myAccount.ordersStatus.beg.xp", rowElement,"myAccount.ordersStatus.end.xp");
				if (orderStatus.equals("Pending")) {
					System.out.println(orderStatus);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Orders Not available!");
		}
	}
	
	/********************************************************************
	// * Description  : To change the Order status in admin page  
	// * Param        : String text
	// * Jira Ticket  : JMB 6778
	// * Status       : Completed
	//*******************************************************************/
	public void changeOrderStatus(String text) {
		Q_JMB_WebElm.myWait(2000);
		Q_JMB_WebElm.idExecutor(jmbProps, "ord.orderStatus.id");
		System.out.println(Q_JMB_WebElm.idAttrRet(jmbProps, "ord.orderStatusSelect.id", "value"));
		Q_JMB_WebElm.myWait(2000);
		switch (text) {
			case "cancelled":
				Q_JMB_WebElm.idSelectValue(jmbProps, "ord.orderStatusSelect.id", text);
				break;
			case "paid":
				Q_JMB_WebElm.idSelectValue(jmbProps, "ord.orderStatusSelect.id", text);
				Q_JMB_WebElm.myWait(500);
				Q_JMB_WebElm.xpClear(jmbProps, "ord.orderStatusNote.xp");
				Q_JMB_WebElm.xpSend(jmbProps, "ord.orderStatusNote.xp", "Automated Test");
				Q_JMB_WebElm.id(jmbProps, "ord.orderStatusNoteUpdateBtn.id");
				Q_JMB_WebElm.myWait(2000);
				break;
			case "shipped":
				Q_JMB_WebElm.idSelectValue(jmbProps, "ord.orderStatusSelect.id", text);
				Q_JMB_WebElm.myWait(1500);
				Q_JMB_WebElm.id(jmbProps, "ord.orderStatusShippedBatchBtn.id");
				break;
			case "completed":
				Q_JMB_WebElm.idSelectValue(jmbProps, "ord.orderStatusSelect.id", text);
				Q_JMB_WebElm.myWait(500);
				Q_JMB_WebElm.xpClear(jmbProps, "ord.orderStatusNote.xp");
				Q_JMB_WebElm.xpSend(jmbProps, "ord.orderStatusNote.xp", "Automated Test");
				Q_JMB_WebElm.id(jmbProps, "ord.orderStatusNoteUpdateBtn.id");
				break;
			default:
				System.out.println("Invalid order status");
		}
	}
	
	/********************************************************************
	// * Description  : To verify Order status in my accounts  
	// * Param        : boolean availablity
	// * Jira Ticket  : JMB 6778
	// * Status       : Completed
	//*******************************************************************/
	public void verifyDeleteLink(boolean availablity) {
		driver.navigate().to(baseUrl+"/my-account/");
		myAccount("payments");
		if (availablity) {
			Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.account.paymentDeleteCard.xp"),"Delete link is not available!");
			System.out.println("Delete link is available!");
		} else {
			try {
				Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.account.paymentDeleteCard.emptyBox.xp"), "Delete link should be available");
				System.out.println("Delete link is Not available!");
			} catch (Exception e) {
				System.out.println("Delete link is available!");
			}
		}
	}
	//JMB-6778-End
}
