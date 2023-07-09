package pageObjects;


import jsonWrappers.AddressContainer;
import jsonWrappers.InvalidPasswordContainer;
import jsonWrappers.UserContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Q_PM_AccountSteps extends Q_PM_Init {
    //*******************************************************************
    // * Description: Calls User Registration Form
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void registerNow(String loginLink, String registerLink, Integer user, String regButton) throws FileNotFoundException {
        UserContainer newUser = new UserContainer(user);
        Q_PM_WebElm.idExecutor(pmQaProps,loginLink);
        Q_PM_WebElm.idExecutor(pmQaProps,registerLink);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.fname.id", newUser.firstName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.lname.id", newUser.lastName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.phone.id", newUser.phoneNumber);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.email.id", newUser.user);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.pwd.id", newUser.passwd);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.confirm.id", newUser.passwd);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xp(pmQaProps, "acc.create.consent.xp");
        Q_PM_WebElm.id(pmQaProps, regButton);
        Q_PM_WebElm.myWait(500);
        //Assert.assertTrue(WebElm.cnDisplayed(pmQaProps, "account.welcomeMessgae.className"));

    }
    //*******************************************************************
    // * Description: Populate User Registration Form
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void checkoutRegistration(int user, String regButton){

        UserContainer newUser = new UserContainer(user);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.pwd.id", newUser.passwd);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.confirm.id", newUser.passwd);
        Q_PM_WebElm.id(pmQaProps, regButton);
        Q_PM_WebElm.myWait(2000);
    }
    //*******************************************************************
    // * Description: Populate User Login Form
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step

    public static void deleteUser(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Q_PM_WebElm.myWait(2000);
        driver.navigate().to(baseUrl + "/cybersource-reset.php");
        System.out.println(driver.getCurrentUrl());
        Q_PM_WebElm.myWait(5000);
        Q_PM_WebElm.id(pmQaProps, "acc.deleteUser.id");
        driver.navigate().back();
        driver.navigate().refresh();
//        driver.navigate().to(baseUrl);
//        WebElm.myWait(2000);
//        Assert.assertTrue(WebElm.idDisplayed(pmQaProps,"login.id"));

    }
    // @Step
    public static void loginUser(int user)  {
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loginaccounts"))));
//
//        try{
//            WebElm.id(pmQaProps, "login.id");
//            WebElm.myWait(2000);
//        }
//            catch (Throwable ex){
//                System.out.println("Error in clicking login");
//            }
        Q_PM_WebElm.id(pmQaProps, "acc.login.id");
        UserContainer uc = new UserContainer(user);
        Q_PM_WebElm.idSend(pmQaProps, "acc.login.email.id", uc.user);
        Q_PM_WebElm.idSend(pmQaProps, "acc.login.pwd.id", uc.passwd);
        Q_PM_WebElm.idExecutor(pmQaProps, "acc.login.submitBtn.id");
        Q_PM_WebElm.myWait(2000);
        Assert.assertTrue(Q_PM_WebElm.cnDisplayed(pmQaProps, "acc.welcomeMsg.className").equals(true));
//        WebElm.myWait(3000);

    }
    //*******************************************************************
    // * Description: My Account
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void accountMenu(String  menuItem){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("welcome-message"))));
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.xp(pmQaProps, "acc.accountDropdown.xp");
        switch ( menuItem ){
            case "DASHBOARD":

                Q_PM_WebElm.xp(pmQaProps, "acc.accountDashCount.xp");
                Q_PM_WebElm.myWait(1000);
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("page-title"))));
                System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className"));
                Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className").contains("MY DASHBOARD"));
                break;
            case "MY ORDERS":
//                Assert.assertTrue(WebElm.xpRetText(pmQaProps, "accountMyorders.xp").contains("MY ORDERS"));
                Q_PM_WebElm.xpExecutor(pmQaProps, "acc.accountMyorders.xp");
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("page-title"))));
                System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className"));
                Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className").contains("MY ORDERS"));
                break;
            case "MY WISHLIST":
//              Assert.assertTrue(ElemSteps.xpElementRetText(pmQaProps, "accountMyorders.xpath").contains("MY ORDERS"));
                Q_PM_WebElm.xpExecutor(pmQaProps, "acc.accountMyWishlist.xp");
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("page-title"))));
                System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className"));
                Q_PM_WebElm.myWait(3000);
                Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className").contains("MY WISHLIST"));
                break;
            case "LOGOUT":
                if(Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.welcomeMsg.xp")){
                    Q_PM_WebElm.myWait(2000);
                    Q_PM_WebElm.xp(pmQaProps, "acc.accountLogout.xp");
//                    Assert.assertTrue(driver.getCurrentUrl().contains("log-in"));
                }
                break;
            default:
                System.out.println("Either wrong option or unable to access account dropdown");
                break;
        }

    }

    //*******************************************************************
    // * Description: My Account
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void myAccountMenu(String  menuItem){
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("page-title"))));
        Q_PM_WebElm.cn(pmQaProps, "acc.welcomeMsg.className");
        switch ( menuItem ){
            case "Account Dashboard":
                Q_PM_WebElm.xp(pmQaProps, "accPageDashboard.xp");
                System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className"));
                Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className").contains("MY DASHBOARD"));
                break;
            case "My Orders":
//
//                System.out.println("Orders Page Title " + WebElm.cnRetText(pmQaProps, "accountPageTitle.className"));
//                WebElm.xp(pmQaProps, "accPageMyOrders.xp");
                Q_PM_WebElm.xp(pmQaProps, "acc.accountMyorders.xp");
                Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className").contains("MY ORDERS"));
                break;

            case "Account Information":
                Q_PM_WebElm.xp(pmQaProps, "acc.accPageInformation.xp");
                System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className"));
                Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className").contains("EDIT ACCOUNT INFORMATION"));
                break;

            case "Address Book":
                Q_PM_Controls.scrolUpPixel(300);
                Q_PM_WebElm.myWait(1000);
                Q_PM_WebElm.linkText(pmQaProps, "acc.addressBook.linktext");
                System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className").substring(0, 15));
//                Assert.assertTrue(WebElm.cnRetText(pmQaProps, "accountPageTitle.className").contains("ADDRESS BOOK"));
                break;
            case "Payment Methods":
                //Assert.assertTrue(WebElm.xpCompoundRetText(pmQaProps, "begAccLinkLi.xp" , i , "endAccLinkLi.xp").contains("MY ORDERS"));
//                WebElm.xp(pmQaProps, "accPagePaymentMethods.xp");
                Q_PM_WebElm.linkText(pmQaProps, "acc.paymentMethod.linktext");
                System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className"));
                Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className").contains("PAYMENT METHODS"));
                break;
            case "My Alerts":
                Q_PM_WebElm.xp(pmQaProps, "acc.accPageMyAlerts.xp");
                System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className"));
                Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className").contains("MY PRODUCT REVIEWS"));
                break;
            case "My Product Reviews":
                Q_PM_WebElm.xp(pmQaProps, "acc.accPageProductReviews.xp");
                System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className"));
                Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accountPageTitle.className").contains("MY PRODUCT REVIEWS"));
                break;
            default:
                System.out.println("No menu selection");
                break;

        }

    }
    //*******************************************************************
    // * Description: My Account Dashboard page
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void confirmAccountPage(){
        //accountMenu("DASHBOARD", 1);
        Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.recentOrders.xp").equals(true));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "acc.recentOrders.xp").substring(0, 13));
        Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "acc.recentOrders.xp").contains("RECENT ORDERS"));
        Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.accountInfo.xp").equals(true));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "acc.accountInfo.xp").substring(0, 19));
        Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "acc.accountInfo.xp").contains("ACCOUNT INFORMATION"));
        Q_PM_Controls.scrolDownPixel(400);
        Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.addressBook.xp").equals(true));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "acc.addressBook.xp"));
        Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "acc.addressBook.xp").contains("ADDRESS BOOK"));
        Q_PM_Controls.scrolDownPixel(500);
        Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.paymentMethod.xp").equals(true));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "acc.paymentMethod.xp"));
        Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "acc.paymentMethod.xp").contains("PAYMENT METHODS"));
        Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.stockAlerts.xp").equals(true));
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "acc.stockAlerts.xp"));
        Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "acc.stockAlerts.xp").contains("MY ALERTS"));
    }

    //*******************************************************************
    // * Description: My Account Edit Address
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void accAddress(String action) throws FileNotFoundException {
        myAccountMenu("Address Book");
        Integer num = Q_PM_WebElm.xpCountTableRows(pmQaProps, "acc.countAddress.xp");
        switch(action){
            case "new address":
                Q_PM_WebElm.xp(pmQaProps, "acc.accAddNewAddress.xp");
                Q_PM_CheckoutSteps.shippingForm(0);
                Q_PM_Controls.scrolDownPixel(400);
                Q_PM_WebElm.id(pmQaProps, "acc.accSaveAddress.id");
                Q_PM_WebElm.myWait(1000);
                System.out.println("chec " + Q_PM_WebElm.xpRetText(pmQaProps, "acc.accAddMessage.xp"));
                if (Q_PM_WebElm.xpRetText(pmQaProps, "acc.accAddMessage.xp").equals("Address Added")){
                    //Assert.assertTrue(WebElm.xpRetText(pmQaProps,"accAddedAdd.xp").contains("Address Added"));
                    Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accAddedAdd.className").contains("Address Added"));
                }
                else {
                    Q_PM_WebElm.id(pmQaProps, "acc.accContinueAddress.id");
                }
                Q_PM_WebElm.myWait(1000);

                Q_PM_Controls.scrolUpPixel(500);
                myAccountMenu("Address Book");
                Integer num2 = Integer.valueOf(Q_PM_WebElm.xpCountTableRows(pmQaProps, "acc.countAddress.xp"));
                System.out.println(num2 + "     " + num) ;
                Assert.assertEquals(num2 - num, 1);
                break;
            case "edit first address":
                Q_PM_WebElm.xp(pmQaProps, "acc.editAddress1.xp");
                Q_PM_CheckoutSteps.shippingFormEdit(21);
                Q_PM_WebElm.myWait(1000);
                Q_PM_AccountSteps.validateAddress("acc.accSaveAddress.id", "chk.acc.ContinueWith.id", "chk.accShError.classsName");
                Q_PM_WebElm.myWait(1000);
                myAccountMenu("Address Book");
//                System.out.println("test " + WebElm.xpRetText(pmQaProps, "firstAddressText.xp"));
                Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "acc.firstAddressText.xp").contains("13401 Metcalf"));
                Q_PM_WebElm.xp(pmQaProps, "acc.editAddress1.xp");
                Q_PM_CheckoutSteps.shippingFormEdit(20);
                Q_PM_WebElm.myWait(1000);
                Q_PM_AccountSteps.validateAddress("acc.accSaveAddress.id", "chk.acc.ContinueWith.id", "chk.accShError.classsName");
                Q_PM_WebElm.myWait(1000);
                myAccountMenu("Address Book");
                Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "acc.firstAddressText.xp").contains("13448 Metcalf"));
                break;

            case "delete":
                for (int i=1; i < num; i++){
                    Q_PM_WebElm.xp(pmQaProps, "acc.editAddress2.xp");
                    Q_PM_Controls.checkAlert();
                    Q_PM_WebElm.myWait(2000);
                    driver.navigate().refresh();
                }


                //CheckoutSteps.validateAddress("accSaveAddress.id","acc.ContinueWith.id");
                break;
            default:
                System.out.println("No address action selected");
                break;

        }
    }
    //*******************************************************************
    // * Description: Fill out Billing Address Form
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void billingForm(Integer index) throws FileNotFoundException {
        AddressContainer ship = new AddressContainer(index);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.idClear(pmQaProps, "acc.bilFirstName.id");
        Q_PM_WebElm.idClear(pmQaProps, "acc.bilLastName.id");
        Q_PM_WebElm.idClear(pmQaProps, "acc.bilAddress.id");
        Q_PM_WebElm.idClear(pmQaProps, "acc.bilCity.id");
        Q_PM_WebElm.idClear(pmQaProps, "acc.bilZip.id");
        Q_PM_WebElm.idClear(pmQaProps, "acc.bilPhone.id");

        Q_PM_WebElm.idSend(pmQaProps, "acc.bilFirstName.id", ship.firstName);

        Q_PM_WebElm.idSend(pmQaProps, "acc.bilLastName.id", ship.lastName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.bilAddress.id", ship.street);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.idSend(pmQaProps, "acc.bilCity.id", ship.city);
        Q_PM_WebElm.idSelectValue(pmQaProps, "acc.bilState.id", ship.state);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS.SECONDS);
        //JavascriptExecutor executor = (JavascriptExecutor)driver;executor.executeScript("arguments[0].clear()",(driver.findElement(By..id(pmQaProps.getProperty("guestCheckout.guest.shipping.zip.id")))));

        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.idSend(pmQaProps, "acc.bilZip.id", ship.zipcode);
        Q_PM_WebElm.idSend(pmQaProps, "acc.bilPhone.id", ship.phoneNumber);
        //validateAddress("accSaveAddress.id","acc.ContinueWith.id");
    }
    //*******************************************************************
    // * Description: My Account Payment Accounts
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void accPayments(String action, Integer cardIndex, Integer addressIndex) throws FileNotFoundException {
        myAccountMenu("Payment Methods");
        Integer num = Q_PM_WebElm.xpCountTableRows(pmQaProps, "acc.accCardCount.xp");

        switch ( action ){
            case "new card":
                Q_PM_WebElm.xp(pmQaProps, "acc.addNewCard.xp");
                Q_PM_CheckoutSteps.creditForm(cardIndex);
                billingForm(addressIndex);
                Q_PM_WebElm.myWait(2000);
                try{
                    Q_PM_WebElm.xp(pmQaProps, "acc.saveNewCc.xp");
                    Q_PM_WebElm.myWait(2000);
                }
                catch(Throwable ex){
                    Q_PM_WebElm.xp(pmQaProps, "acc.saveNewCc.xp");
                    Q_PM_WebElm.myWait(2000);
                }

                System.out.println(Q_PM_WebElm.cnRetText(pmQaProps, "acc.newCcSuccessMessage.className"));
                Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "acc.newCcSuccessMessage.className").contains("Successfully stored Credit Card"));
                break;
            case "delete cards":
                System.out.println(" Number of cards on file: " + num);
                while (num >= 1){
                    Q_PM_WebElm.xp(pmQaProps, "acc.begAccCard.xp", num, "acc.endAccCardDelete.xp");
                    Q_PM_Controls.checkAlert();
                    Q_PM_WebElm.myWait(1000);
                    Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accWooMessage.className").contains("Payment Info Removed"));
                    driver.navigate().refresh();
                    num--;
                }
                break;
            case "set default":
                System.out.println(" Number of cards on file: " + num);
                Q_PM_WebElm.xp(pmQaProps, "acc.begAccCard.xp", 2, "acc.endCardDefault.xp");
                Q_PM_WebElm.myWait(2000);
                Assert.assertEquals(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accWooMessage.className"),"Payment Info Updated.");
                driver.navigate().refresh();
                Q_PM_WebElm.xp(pmQaProps, "acc.begAccCard.xp", 1, "acc.endCardDefault.xp");
                Q_PM_WebElm.myWait(1000);
                Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "acc.accWooMessage.className").contains("Payment Info Updated"));

                break;
            case "list cards":
                System.out.println(" Number of cards on file: " + num);
                for (int i=1; i <= num; i++){
                    Q_PM_WebElm.xp(pmQaProps, "acc.begAccCard.xp", i, "acc.endAccCardTxt.xp");
                    if (i == 1){
                        System.out.println("Card " + i + " " + Q_PM_WebElm.xpRetText(pmQaProps, "acc.begAccCard.xp", i, "acc.endAccCardTxt.xp"));
                        Assert.assertEquals(Q_PM_WebElm.xpRetText(pmQaProps, "acc.begAccCard.xp", i, "acc.endAccCardTxt.xp"), "MasterCard Ending in: 0007");
                    }

                    if (i == 2){
                        System.out.println("Card " + i + " " + Q_PM_WebElm.xpRetText(pmQaProps, "acc.begAccCard.xp", i, "acc.endAccCardTxt.xp"));
                        Assert.assertEquals(Q_PM_WebElm.xpRetText(pmQaProps, "acc.begAccCard.xp", i, "acc.endAccCardTxt.xp"), "Amex Ending in: 3961");
                    }
                }
                break;
            case "expiring card":
                Q_PM_WebElm.xp(pmQaProps, "acc.addNewCard.xp");
                Q_PM_CheckoutSteps.creditForm(cardIndex);
                Q_PM_WebElm.myWait(4000);
                billingForm(addressIndex);
                Q_PM_WebElm.myWait(2000);
//                try{
                Q_PM_WebElm.xp(pmQaProps, "acc.saveNewCc.xp");
                Q_PM_WebElm.myWait(2000);
//                    WebElm.xp(pmQaProps, "backLink.xp");
//                }
//                catch(Throwable ex){
//                    WebElm.xp(pmQaProps, "saveNewCc.xp");
//                    WebElm.myWait(2000);
//                }

                System.out.println(Q_PM_WebElm.idRetText(pmQaProps, "acc.expiringCard.errMsg.id"));
                Assert.assertTrue(Q_PM_WebElm.idRetText(pmQaProps, "acc.expiringCard.errMsg.id").contains("Important Note: Your Credit card has expired or is expiring this month."));
                break;
            default:
                System.out.println("No payment action selected");
                break;
        }
    }

    //    //*******************************************************************
//    // * Description: My Account Payment Accounts
//    // * Param: String
//    // * Returns: NA
//    // * Status: Complete
//    //*******************************************************************/
//    // @Step
//    public static void accPayments(String action) throws FileNotFoundException {
//        myAccountMenu("Payment Methods", 3);
//        Integer num = WebElm.xpTableRows(pmQaProps, "accCardCount.xp");
//        System.out.println(num);
//        switch ( action ){
//            case "new card":
//                WebElm.xp(pmQaProps, "addNewCard.xp");
//                CheckoutSteps.creditForm(1);
//                billingForm(1);
//                WebElm.myWait(1000);
//                WebElm.xp(pmQaProps, "saveNewCc.xp");
//                break;
//            case "delete cards":
//                System.out.println(num);
//                while (num >= 1){
//                    WebElm.xpCompound1(pmQaProps, "begAccCard.xp", num, "endAccCardDelete.xp");
//                    Controls.checkAlert();
//                    WebElm.myWait(1000);
//                    Assert.assertTrue(WebElm.cnRetText(pmQaProps, "accWooMessage.className").contains("Payment Info Removed"));
//                    driver.navigate().refresh();
//                    num--;
//                }
//                break;
//            default:
//                System.out.println("No payment action selected");
//                break;
//        }
//    }
    //*******************************************************************
    // * Description: My Account Order Status
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void accOrderStatus(String status) throws FileNotFoundException {

        switch ( status ){
            case "paid":
                Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "acc.myOrdersStatus.xp").equals("Paid"));
                Q_PM_WebElm.xp(pmQaProps, "acc.viewOrder.xp");
                Q_PM_WebElm.myWait(2000);
                Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.confirmedPayment.xp").equals(true));
                System.out.println("Verified Paid order status");
                break;
            case "pending":
                Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "acc.myOrdersStatus.xp").equals("Pending"));
                Q_PM_WebElm.xp(pmQaProps, "acc.viewOrder.xp");
                Q_PM_WebElm.myWait(2000);
                Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.processingPayment.xp").equals(true));
                System.out.println("Verified Pending order status");
                break;
            case "paging":
                Q_PM_Controls.scrolDownPixel(500);
                Assert.assertTrue(Q_PM_WebElm.idDisplayed(pmQaProps, "acc.ordersPaging.id").equals(true));
                Q_PM_WebElm.id(pmQaProps, "acc.pagingNext.id");
                Assert.assertTrue(driver.getCurrentUrl().contains("/order/history/"));
                Q_PM_WebElm.id(pmQaProps, "acc.pagingPrev.id");
                System.out.println("Verified order paging ");
                break;
            default:
                System.out.println("No order selected");
                break;
        }
    }
    //*******************************************************************
    // * Description: Fill out Shipping Address Form
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void validateAddress(String save, String continueWith, String errorMsg) {
        try {
            Q_PM_Controls.scrolDownPixel(200);
            Q_PM_WebElm.idDisplayed(pmQaProps, save);
            Q_PM_WebElm.id(pmQaProps, save);
            Q_PM_WebElm.myWait(2000);
            //System.out.println("Successfully detected and auto filled shipping address");
            System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "acc.accAddMessage.xp"));
            Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "acc.accAddMessage.xp").contains("Address Updated"));
            Q_PM_Controls.scrolUpPixel(600);

        } catch (Throwable ex) {

            Q_PM_WebElm.idDisplayed(pmQaProps, continueWith);
            Q_PM_WebElm.id(pmQaProps, continueWith);
            Q_PM_WebElm.myWait(2000);
            System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "acc.accAddMessage.xp"));
            Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "acc.accAddMessage.xp").contains("Address Updated"));
            Q_PM_Controls.scrolUpPixel(600);
        }
    }
    public static void validPasswordInputsViaRegisterPage(String loginLink,String registerLink,String fName, String lName, String phoneNumber,String email,String passwd, String confPassword,String regButton) throws FileNotFoundException {
        driver.navigate().to("https://qa.providentmetals.com/register/");
//    	WebElm.idExecutor(pmQaProps,loginLink);
//    	WebElm.idExecutor(pmQaProps,registerLink);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.fname.id",fName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.lname.id",lName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.phone.id",phoneNumber);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.email.id", System.currentTimeMillis()+email);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.pwd.id", passwd);
        System.out.println(passwd);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.confirm.id",confPassword);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xp(pmQaProps, "acc.create.consent.xp");
        Q_PM_WebElm.id(pmQaProps, regButton);
        Q_PM_WebElm.myWait(500);
        //Assert.assertTrue(WebElm.cnDisplayed(pmQaProps, "account.welcomeMessgae.className"));

    }
    public static void validPasswordInputsViaRegisterPage(int index) throws FileNotFoundException {
        driver.navigate().to(baseUrl + "/register/");
        InvalidPasswordContainer password = new InvalidPasswordContainer(index);
//    	WebElm.idExecutor(pmQaProps,loginLink);
//    	WebElm.idExecutor(pmQaProps,registerLink);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.fname.id",password.firstName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.lname.id",password.lastName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.phone.id",password.phoneNumber);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.email.id", System.currentTimeMillis()+password.email+"@jmbullion.com");
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.pwd.id", password.passwd);
        System.out.println(password.passwd);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.confirm.id",password.confPassword);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xp(pmQaProps, "acc.create.consent.xp");
        Q_PM_WebElm.id(pmQaProps, "acc.create.regBtn.id");
        Q_PM_WebElm.myWait(500);
        //Assert.assertTrue(WebElm.cnDisplayed(pmQaProps, "account.welcomeMessgae.className"));

    }

    public static void invalidPasswordInputsViaRegisterPage(String loginLink,String registerLink,String fName, String lName, String phoneNumber,String email,String passwd, String confPassword,String regButton) throws FileNotFoundException {
        driver.navigate().to("https://qa.providentmetals.com/register/");
//    	WebElm.idExecutor(pmQaProps,loginLink);
//    	WebElm.idExecutor(pmQaProps,registerLink);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.fname.id",fName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.lname.id",lName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.phone.id",phoneNumber);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.email.id", System.currentTimeMillis()+email);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.pwd.id", passwd);
        System.out.println(passwd);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.confirm.id",confPassword);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xp(pmQaProps, "acc.create.consent.xp");
        Q_PM_WebElm.id(pmQaProps, regButton);
        Q_PM_WebElm.myWait(500);
        String actualMsg= Q_PM_WebElm.xpRetText(pmQaProps, "acc.passwordMessage.xp");
        //String actualMsg=validationMsg.getText();
        System.out.println(actualMsg);
        String expectedMsg="The password must be between 8 to 30 characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
        Assert.assertEquals(actualMsg, expectedMsg);
        //Assert.assertTrue(WebElm.cnDisplayed(pmQaProps, "account.welcomeMessgae.className"));

    }
    public static void invalidPasswordInputsViaRegisterPage(int index) throws FileNotFoundException {
        driver.navigate().to("https://qa.providentmetals.com/register/");
        InvalidPasswordContainer password = new InvalidPasswordContainer(index);
//    	WebElm.idExecutor(pmQaProps,"login.id");
//    	WebElm.idExecutor(pmQaProps,"createAccount.id");
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.fname.id",password.firstName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.lname.id",password.lastName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.phone.id",password.phoneNumber);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.email.id", System.currentTimeMillis()+password.email+"@jmbullion.com");
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.pwd.id", password.passwd);
        System.out.println(password.passwd);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.confirm.id",password.confPassword);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xp(pmQaProps, "acc.create.consent.xp");
        Q_PM_WebElm.id(pmQaProps, "acc.create.regBtn.id");
        Q_PM_WebElm.myWait(1000);
        String actualMsg= Q_PM_WebElm.xpRetText(pmQaProps, "acc.passwordMessage.xp");
        //String actualMsg=validationMsg.getText();
        System.out.println(actualMsg);
        String expectedMsg="The password must be between 8 to 30 characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
        Assert.assertEquals(actualMsg, expectedMsg);
        driver.navigate().refresh();
        //Assert.assertTrue(WebElm.cnDisplayed(pmQaProps, "account.welcomeMessgae.className"));

    }
    public static void invalidPasswordInputs(String loginLink,String registerLink,String fName, String lName, String phoneNumber,String email,String passwd, String confPassword,String regButton) throws FileNotFoundException {
        Q_PM_WebElm.idExecutor(pmQaProps,loginLink);
        Q_PM_WebElm.idExecutor(pmQaProps,registerLink);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.fname.id",fName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.lname.id",lName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.phone.id",phoneNumber);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.email.id", System.currentTimeMillis()+email);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.pwd.id", passwd);
        System.out.println(passwd);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.confirm.id",confPassword);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xp(pmQaProps, "acc.create.consent.xp");
        Q_PM_WebElm.id(pmQaProps, regButton);
        Q_PM_WebElm.myWait(500);
        String actualMsg= Q_PM_WebElm.xpRetText(pmQaProps, "acc.passwordMessage.xp");
        //String actualMsg=validationMsg.getText();
        System.out.println(actualMsg);
        String expectedMsg="The password must be between 8 to 30 characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
        Assert.assertEquals(actualMsg, expectedMsg);
        //Assert.assertTrue(WebElm.cnDisplayed(pmQaProps, "account.welcomeMessgae.className"));

    }
    public static void invalidPasswordInputs(int index) throws FileNotFoundException {
        InvalidPasswordContainer password = new InvalidPasswordContainer(index);
        Q_PM_WebElm.idExecutor(pmQaProps, "acc.login.id");
        Q_PM_WebElm.idExecutor(pmQaProps, "acc.createAccount.id");
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.fname.id",password.firstName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.lname.id",password.lastName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.phone.id",password.phoneNumber);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.email.id", System.currentTimeMillis()+password.email+"@jmbullion.com");
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.pwd.id", password.passwd);
        System.out.println(password.passwd);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.confirm.id",password.confPassword);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xp(pmQaProps, "acc.create.consent.xp");
        Q_PM_WebElm.id(pmQaProps, "acc.create.regBtn.id");
        Q_PM_WebElm.myWait(500);
        String actualMsg= Q_PM_WebElm.xpRetText(pmQaProps, "acc.passwordMessage.xp");
        //String actualMsg=validationMsg.getText();
        System.out.println(actualMsg);
        String expectedMsg="The password must be between 8 to 30 characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
        Assert.assertEquals(actualMsg, expectedMsg);
        driver.navigate().refresh();
        //Assert.assertTrue(WebElm.cnDisplayed(pmQaProps, "account.welcomeMessgae.className"));

    }
    public static void checkoutRegistrationInvalidPasswordValidation(String regButton,String password,String confPassword){


        Q_PM_WebElm.idSend(pmQaProps, "acc.create.pwd.id", password);
        System.out.println(password);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.confirm.id", confPassword);
        Q_PM_WebElm.id(pmQaProps, regButton);
        Q_PM_WebElm.myWait(2000);
        String actualMsg= Q_PM_WebElm.xpRetText(pmQaProps, "acc.passwordMessage.xp");
        //String actualMsg=validationMsg.getText();
        System.out.println(actualMsg);
        String expectedMsg="The password must have at least eight characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
        Assert.assertEquals(actualMsg, expectedMsg);
    }
    public static void checkoutRegistrationInvalidPasswordValidation(int index) throws FileNotFoundException{

        InvalidPasswordContainer password = new InvalidPasswordContainer(index);
        Q_PM_WebElm.idClear(pmQaProps, "acc.create.pwd.id");
        Q_PM_WebElm.idClear(pmQaProps, "acc.create.confirm.id");
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.pwd.id", password.passwd);
        System.out.println(password.passwd);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.confirm.id", password.confPassword);
        Q_PM_WebElm.id(pmQaProps, "acc.create.regBtn.id");
        Q_PM_WebElm.myWait(2000);
        String actualMsg= Q_PM_WebElm.xpRetText(pmQaProps, "acc.passwordMessage.xp");
        //String actualMsg=validationMsg.getText();
        System.out.println(actualMsg);
        String expectedMsg="The password must be between 8 to 30 characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
        Assert.assertEquals(actualMsg, expectedMsg);
    }
    public static void resetPasswordInvalidPasswordInputValidation(String currPassword, String newPassword,String confPassword)
    {
        Q_PM_WebElm.idSend(pmQaProps, "acc.myacccountInfo.currentPassword.id", currPassword);
        Q_PM_WebElm.idSend(pmQaProps, "acc.myaccountInfo.newPassword.id", newPassword);
        System.out.println(newPassword);
        Q_PM_WebElm.idSend(pmQaProps, "acc.myaccountInfo.confNewPassword.id", confPassword);
        Q_PM_WebElm.id(pmQaProps, "acc.myaccountInfo.updateBtn");
        Q_PM_Controls.checkAlert();

    }
    public static void resetPasswordInvalidPasswordInputValidation(int index) throws FileNotFoundException
    {
        InvalidPasswordContainer password = new InvalidPasswordContainer(index);
        Q_PM_WebElm.idSend(pmQaProps, "acc.myacccountInfo.currentPassword.id", "1212Te$t");
        Q_PM_WebElm.idSend(pmQaProps, "acc.myaccountInfo.newPassword.id", password.passwd);
        System.out.println(password.passwd);
        Q_PM_WebElm.idSend(pmQaProps, "acc.myaccountInfo.confNewPassword.id", password.confPassword);
        Q_PM_WebElm.id(pmQaProps, "acc.myaccountInfo.updateBtn");
        Q_PM_Controls.checkAlert();
        driver.navigate().refresh();

    }
    public static void validPasswordInputs(String loginLink,String registerLink,String fName, String lName, String phoneNumber,String email,String passwd, String confPassword,String regButton) throws FileNotFoundException {
        Q_PM_WebElm.idExecutor(pmQaProps,loginLink);
        Q_PM_WebElm.idExecutor(pmQaProps,registerLink);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.fname.id",fName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.lname.id",lName);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.phone.id",phoneNumber);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.email.id", System.currentTimeMillis()+email);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.pwd.id", passwd);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.confirm.id",confPassword);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xp(pmQaProps, "acc.create.consent.xp");
        Q_PM_WebElm.id(pmQaProps, regButton);
        Q_PM_WebElm.myWait(500);

        //Assert.assertTrue(WebElm.cnDisplayed(pmQaProps, "account.welcomeMessgae.className"));

    }
    public static void checkoutRegistrationvalidPasswordValidation(String regButton,String password,String confPassword){


        Q_PM_WebElm.idSend(pmQaProps, "acc.create.pwd.id", password);
        System.out.println(password);
        Q_PM_WebElm.idSend(pmQaProps, "acc.create.confirm.id", confPassword);
        Q_PM_WebElm.id(pmQaProps, regButton);
        Q_PM_WebElm.myWait(2000);
//        String actualMsg=WebElm.xpRetText(pmQaProps,"passwordMessage.xp");
//        //String actualMsg=validationMsg.getText();
//        System.out.println(actualMsg);
//        String expectedMsg="The password must have at least eight characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";

    }
    public static void resetPassword(String currPassword, String newPassword,String confPassword)
    {
        Q_PM_WebElm.idSend(pmQaProps, "acc.myacccountInfo.currentPassword.id", currPassword);
        Q_PM_WebElm.idSend(pmQaProps, "acc.myaccountInfo.newPassword.id", newPassword);
        Q_PM_WebElm.idSend(pmQaProps, "acc.myaccountInfo.confNewPassword.id", confPassword);
        Q_PM_WebElm.id(pmQaProps, "acc.myaccountInfo.updateBtn");
        Q_PM_Controls.checkAlert();
        System.out.println("Password Changed Successfully....");
    }
    public static void resetPassword(int index) throws FileNotFoundException
    {
        InvalidPasswordContainer password = new InvalidPasswordContainer(index);
        Q_PM_WebElm.idSend(pmQaProps, "acc.myacccountInfo.currentPassword.id", "Jan@2021");
        Q_PM_WebElm.idSend(pmQaProps, "acc.myaccountInfo.newPassword.id", password.passwd);
        Q_PM_WebElm.idSend(pmQaProps, "acc.myaccountInfo.confNewPassword.id", password.confPassword);
        Q_PM_WebElm.id(pmQaProps, "acc.myaccountInfo.updateBtn");
        Q_PM_Controls.checkAlert();
        System.out.println("Password Changed Successfully....");
    }
    public static void resetPasswordloginUser(int user,String newPassword)  {

        try{
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loginaccounts"))));
            Q_PM_WebElm.id(pmQaProps, "acc.login.id");
            UserContainer uc = new UserContainer(user);
            Q_PM_WebElm.idSend(pmQaProps, "acc.login.email.id", uc.user);
            Q_PM_WebElm.idSend(pmQaProps, "acc.login.pwd.id", newPassword);
            Q_PM_WebElm.id(pmQaProps, "acc.login.submitBtn.id");
            Q_PM_WebElm.myWait(2000);
            Assert.assertTrue(Q_PM_WebElm.cnDisplayed(pmQaProps, "acc.welcomeMsg.className").equals(true));
            System.out.println("Logged in with new password :"+newPassword+" after password reset");
        }
        catch (Throwable ex){
            System.out.println("Error while trying to login");
        }
    }

    public static void resetPassvalidInputs(int index) throws IOException {
        UserContainer user = new UserContainer(index);
        String newPassword="";
        Q_PM_WebElm.myWait(2000);
        if(user.passwd.equals("1212Te$t")) {
            newPassword="1212Te$t";
        } else if(user.passwd.equals("1212Te$t")) {
            newPassword="1212Te$t";
        }
        Q_PM_WebElm.myWait(2000);
        UserContainer user1 = new UserContainer(index,newPassword);
        Q_PM_WebElm.idSend(pmQaProps, "acc.myacccountInfo.currentPassword.id", user.passwd);
        Q_PM_WebElm.idSend(pmQaProps, "acc.myaccountInfo.newPassword.id", newPassword);
        Q_PM_WebElm.idSend(pmQaProps, "acc.myaccountInfo.confNewPassword.id", newPassword);
        Q_PM_WebElm.id(pmQaProps, "acc.myaccountInfo.updateBtn");
        Q_PM_Controls.checkAlert();
        driver.navigate().to(baseUrl);
        Q_PM_AccountSteps.accountMenu("LOGOUT");
        Q_PM_AccountSteps.resetPasswordloginUser(36,newPassword);
    }

    public static void validatePMIRAForm() throws IOException
    {
        int index=0;
        UserContainer user = new UserContainer(0);
        driver.navigate().to(baseUrl + "/self-directed-ira-precious-metals.html");
//        driver.manage().window().maximize();
        Q_PM_WebElm.xpSelectValue(pmQaProps, "acc.ira.questions.option.xp", "Questions about Providers");
        Q_PM_WebElm.xpSend(pmQaProps, "acc.ira.name.xp", user.firstName);
        Q_PM_WebElm.xpSend(pmQaProps, "acc.ira.email.xp", user.firstName+"@jmbullion.com");
        Q_PM_WebElm.xpSend(pmQaProps, "acc.ira.phone.xp", user.phoneNumber);
        Q_PM_WebElm.xpSend(pmQaProps, "acc.ira.message.xp", user.firstName);
        Q_PM_WebElm.xp(pmQaProps, "acc.ira.submit.xp");
        String actualMsg = "Your message was sent successfully. Thanks.";
        Assert.assertEquals(actualMsg, Q_PM_WebElm.xpRetText(pmQaProps, "acc.ira.success.msg.xp"));
        Q_PM_Controls.scrolDownPixel(500);


    }
    public static void addProductToWishList() {
        driver.navigate().to(baseUrl + "/1-4-oz-us-american-gold-eagle-coin-dates-our-choice.html");
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.xpExecutor(pmQaProps, "acc.pdp.addToWishlist.xp");
        Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.removeFromWishlist.xp");
        Q_PM_AccountSteps.accountMenu("MY WISHLIST");
        Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.verifyWishListProduct.xp");
        Q_PM_WebElm.myWait(2000);
    }
    public static void removeProductFromWishlist() {
        if(Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.verifyWishListProduct.xp")==true) {
            Q_PM_WebElm.xp(pmQaProps, "acc.pdp.remove.Product1.FromWishlist.xp");
            Q_PM_WebElm.myWait(2000);
            System.out.println("Product was removed from wishlist successfully...");
        } else {
            System.out.println("No Products to remove from wishlist on my account");
        }
    }
    public static void addToCartMyAccountWishList(String quan) {
        Q_PM_WebElm.xpSend(pmQaProps, "acc.pm.wishlist.productQty.xp",quan );
        System.out.println("Quantity added on wishlist page : "+quan);
        Q_PM_WebElm.xp(pmQaProps, "acc.pm.wishlist.ATC.button.xp");
        Q_PM_WebElm.myWait(500);
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        System.out.println("Quantity present on cart page : "+ Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.wishlist.cart.Qty.xpath", "value"));
        Assert.assertEquals(quan, Q_PM_WebElm.xpRetAttr(pmQaProps, "cart.wishlist.cart.Qty.xpath", "value"));
    }
    public static void wishListInStockAlert() {
        driver.navigate().to(baseUrl + "/1-oz-american-gold-eagle-pcgs-ms69-dates-our-choice.html");
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.xp(pmQaProps, "acc.pdp.addToWishlist.xp");
        Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.removeFromWishlist.xp");
        Q_PM_AccountSteps.accountMenu("MY WISHLIST");
        Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.verifyWishListProduct.xp");
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.xp(pmQaProps, "acc.pm.wishlist.instockAlert.Btn.xp");
        Assert.assertEquals(Q_PM_WebElm.xpRetText(pmQaProps, "acc.pm.wishlist.productAdded.msg.xp"),"In-stock alert has been added.");
        Q_PM_WebElm.xp(pmQaProps, "acc.pm.alerts.tab.xp");
//		 Assert.assertEquals(WebElm.xpRetText(pmQaProps,"pm.alerts.presentProducts.xpath"),"You are currently on in-stock alert for the following products:");
        Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pm.alerts.wishlistproduct.xp");
        System.out.println("Product present on alert tab : "+ Q_PM_WebElm.xpRetText(pmQaProps, "acc.pm.alerts.wishlistproduct.xp"));
        Q_PM_WebElm.xp(pmQaProps, "acc.pm.account.wishlist.xp");
        Q_PM_WebElm.xpExecutor(pmQaProps, "acc.pm.wishlist.removeInstockAlert.Btn.xp");
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.xp(pmQaProps, "acc.pm.alerts.tab.xp");
        String msg1="You have not yet added any products.";
        Assert.assertEquals(Q_PM_WebElm.xpRetText(pmQaProps, "acc.pm.alerts.noProducts1.xp"),msg1);
        Q_PM_WebElm.xp(pmQaProps, "acc.pm.account.wishlist.xp");
        Q_PM_WebElm.xpExecutor(pmQaProps, "acc.pm.wishlist.instockAlert.Btn.xp");
        Q_PM_WebElm.myWait(3000);
        Q_PM_WebElm.xp(pmQaProps, "acc.pm.alerts.tab.xp");
        Q_PM_WebElm.myWait(6000);
        Q_PM_WebElm.xp(pmQaProps, "acc.pm.alerts.removeProduct.xp");
//		 String msg2="You do not have any products added to in-stock alerts.";
//		 Assert.assertEquals(WebElm.xpRetText(pmQaProps,"pm.alerts.noProducts1.xpath").contains(msg2),true);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xp(pmQaProps, "acc.pm.account.wishlist.xp");
        Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pm.wishlist.instockAlert.Btn.xp");

    }
    public static void removeProductFromAlert() {
        Q_PM_WebElm.xp(pmQaProps, "acc.pm.alerts.tab.xp");
        Q_PM_WebElm.xp(pmQaProps, "acc.pm.alerts.removeProduct.xp");
        System.out.println("Product was removed from instock alert...");
    }
    public static void wishListInStockAlertPdp() {
        String partialUrl="/1-oz-american-gold-eagle-pcgs-ms69-dates-our-choice.html";
        driver.navigate().to(baseUrl + partialUrl);
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.xp(pmQaProps, "acc.pdp.addToWishlist.xp");
        Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.removeFromWishlist.xp");
        Q_PM_AccountSteps.accountMenu("MY WISHLIST");
        Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.verifyWishListProduct.xp");
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.xpExecutor(pmQaProps, "acc.pm.wishlist.instockAlert.Btn.xp");
        driver.navigate().to(baseUrl +partialUrl);
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.removeInstockAlert.btn.xp");
        Q_PM_AccountSteps.accountMenu("MY WISHLIST");
        Q_PM_WebElm.xp(pmQaProps, "acc.pm.wishlist.removeInstockAlert.Btn.xp");
        driver.navigate().to(baseUrl +partialUrl);
        Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.instockAlert.btn.xp");

    }
    public static void wishlistPagination() {
        List<WebElement> pages= driver.findElements(By.xpath("//div[@id='bo-pagination']/a"));
        int pageCount=pages.size();
        System.out.println("Page Count : "+pageCount);
        for(int i=1;i<=pageCount;i++) {
            WebElement pageNo = driver.findElement(By.xpath("//div[@id='bo-pagination']/a["+i+"]"));
            System.out.println("Page :"+pageNo.getText()+" clicking");
            pageNo.click();
            Q_PM_WebElm.myWait(3000);

        }
    }
    public static void addRemoveProductWishlistPDP() {
        driver.navigate().to(baseUrl + "/1-oz-us-american-gold-eagle-coin-dates-our-choice.html");
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.xp(pmQaProps, "acc.pdp.addToWishlist.xp");
        System.out.println("Is product added " + Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.removeFromWishlist.xp"));
        if(Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.removeFromWishlist.xp") && Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.wishlist.ItemsAddedORRemoved.msg.xp")) {
            Q_PM_WebElm.xp(pmQaProps, "acc.pdp.removeFromWishlist.xp");
            Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.addToWishlist.xp");
            Q_PM_WebElm.myWait(2000);
        }
        driver.navigate().to(baseUrl + "/2019-1-oz-american-gold-eagle-coin.html");
        if(Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.instockAlert.btn.xp")) {
            Q_PM_WebElm.xp(pmQaProps, "acc.pdp.instockAlert.btn.xp");
            Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.wishlist.addedToInstockAlert.msg.xp");
            Q_PM_WebElm.xp(pmQaProps, "acc.pdp.wishlist.removeInstockAlert.Btn.xp");
            Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.wishlist.removedFromInstockAlert.msg.xp");
        }
    }
    public static void addProductWishlistPDPGuest() {
        driver.navigate().to(baseUrl + "/1-oz-gold-coin-random-design.html/");
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.xp(pmQaProps, "acc.pdp.addToWishlist.guest.xp");
        Q_PM_WebElm.id(pmQaProps, "acc.pdp.wishlist.loginAccount.id");
        Q_PM_WebElm.xpDisplayed(pmQaProps, "acc.pdp.wishlist.loginModalDisplay.xp");

    }
    public static void buyAgain() {
        Q_PM_WebElm.xp(pmQaProps, "acc.orders.vieworbuyagain.xp");
        Q_PM_WebElm.id(pmQaProps, "acc.viewOrder.buyagainButton.id");
        Q_PM_WebElm.myWait(3000);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(2000);
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");

    }
    
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
  		Q_PM_AccountSteps.accountMenu("MY ORDERS");
  		Q_PM_WebElm.xp(pmQaProps, "acc.viewOrder.xp");
        Q_PM_WebElm.myWait(2000);
	    List<Float> priceList = new ArrayList<Float>();
	    Float calcTotal = Float.valueOf(0);
	    Float subtotal = Float.valueOf(Q_PM_WebElm.idRetTextRep(pmQaProps,"acc.order.subtotal.id"));
	    calcTotal = calcTotal + subtotal;
	    priceList.add(subtotal);
	
	    if (hasSalesTax)
	    {
	      	Float tax = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"acc.order.salesTax.xp"));
	      	calcTotal = calcTotal + tax;
	      	priceList.add(tax);
	    }
	      
	    if (hasStateFee)
	    {
	      	Float stateFee = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"acc.order.stateFee.xp"));
	      	calcTotal = calcTotal + stateFee;
	      	priceList.add(stateFee);
	    }
	
	    String temp = Q_PM_WebElm.idRetText(pmQaProps,"acc.order.shipping.id");
	    if (temp.equals("Free")) {
	      	Float shipping = Float.valueOf("0.0");
	      	calcTotal = calcTotal + shipping;
	      	priceList.add(shipping);
	    } else {
	      	Float shipping = Float.valueOf(Q_PM_WebElm.idRetTextRep(pmQaProps,"acc.order.shipping.id"));
	      	calcTotal = calcTotal + shipping;
	      	priceList.add(shipping);
	    }
	      
	    if (hasGiftCert)
	    {
	      	Float discount = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"acc.order.discount.xp"));
	      	calcTotal = calcTotal - discount;
	      	priceList.add(discount);
	    }
	      
	    calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
	    Float total = Float.valueOf(Q_PM_WebElm.idRetTextRep(pmQaProps,"acc.order.total.id"));
	    priceList.add(total);
	    Assert.assertEquals(total, calcTotal, "My Account Order Page total does not match calculated revenue items.");
	    System.out.println("[Pass] My Account Order Page total matches calculated revenue items.");
	    return priceList;
      }
   	//JMB-7670 End
  	
  	//JMB-6606 Start	

  	/********************************************************************
  	 // * Description  : To verify the email instruction
  	 // * Jira Ticket  : JMB-6606
  	 // * Status       : Complete
  	 //*******************************************************************/    
  	public void validateCannotChangeEmailAddressMessage(String value) {
  		String expectedMessage = "If you want to change the email address, you can call us at 1-800-313-3315 or email us to help@providentmetals.com";
  		String actualMessage=null;
  		switch (value) {
  			case "howToChangeEmailAddress":
  				Q_PM_WebElm.xp(pmQaProps, "acc.howToChangeEmailAddress.xp");
  		        Q_PM_WebElm.myWait(2000);
  				actualMessage=Q_PM_WebElm.xpRetText(pmQaProps, "acc.howToChangeEmailAddressMessage.xp");
  				break;
  			case "editButton":
  				Q_PM_WebElm.xp(pmQaProps, "acc.accountInformationEdit.xp");
  				actualMessage=Q_PM_WebElm.xpRetText(pmQaProps, "acc.howToChangeEmailAddressMessage.xp");
  				break;
  		}
  		Assert.assertTrue(actualMessage.contains(expectedMessage), "User can change the email address");
  	}

  	//JMB-6606 End	
}
