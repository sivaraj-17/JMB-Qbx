package pageObjects;

import static java.util.concurrent.TimeUnit.SECONDS;
import jsonWrappers.AddressContainer;
import jsonWrappers.CreditContainer;
import jsonWrappers.UserContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Q_PM_CheckoutSteps extends Q_PM_Init {

    //*******************************************************************
    // * Description: Select product for checkout
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void selectItem(String item, Integer quan) throws FileNotFoundException {

        switch(item){
            case("1 gram gold bar sunshine mint"):
                driver.navigate().to(baseUrl + "/1-gram-gold-bar-sunshine-mint.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;
            case("5 gram perth mint gold bar"):
                driver.navigate().to(baseUrl + "/5-gram-perth-mint-gold-bar.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("1 oz American gold eagle"):
                driver.navigate().to(baseUrl + "/1-oz-us-american-gold-eagle-coin-dates-our-choice.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("10 gram Perth Mint Gold Bar"):
                driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("1/4 oz Chinese Gold Panda"):
                driver.navigate().to(baseUrl + "/1-4-oz-china-gold-panda-brilliant-uncirculated.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("3 gram Chinese Gold Panda"):
                driver.navigate().to(baseUrl + "/3-gram-gold-panda-our-choice.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("10 oz Gold Bar"):
                driver.navigate().to(baseUrl + "/10-oz-gold-bar.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("1994 1 oz American Silver Eagle"):
                driver.navigate().to(baseUrl + "/1994-1-oz-american-silver-eagle.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("Peace Silver Dollars | PCGS MS64)"):
                driver.navigate().to(baseUrl + "/us-peace-silver-dollars-certified-pcgs-ms64.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("30 Gram Chinese Silver Panda"):
                //driver.navigate().to(baseUrl + "/30-gram-silver-panda-our-choice.html");
            	driver.navigate().to(baseUrl + "/2016-30-gram-chinese-silver-panda.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("100 oz .999 Fine Silver Bar"):
                driver.navigate().to(baseUrl + "/100-oz-999-fine-silver-bar-our-choice.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("1 oz US American Platinum Eagle Coin | Random Year"):
                driver.navigate().to(baseUrl + "/1-oz-american-platinum-eagle-brilliant-uncirculated.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("Valcambi 1 oz Platinum Bar"):
                driver.navigate().to(baseUrl + "/valcambi-1-oz-platinum-bar.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("10 oz Platinum Bar | Credit Suisse"):
                driver.navigate().to(baseUrl + "/10-oz-platinum-bar-credit-suisse.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("Canadian 1 oz Palladium Maple Leaf"):
                driver.navigate().to(baseUrl + "/canada-maple-leaf-1-oz-9995-fine-palladium.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("Trade Dollar 1 oz Copper Round"):
                driver.navigate().to(baseUrl + "/trade-dollar-1-oz-copper-round.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("Maple Leaf 1 oz Copper Round"):
                driver.navigate().to(baseUrl + "/maple-leaf-1-oz-copper-round.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            case("american gold eagle tubes 33 mm."):
                driver.navigate().to(baseUrl + "/american-gold-eagle-tubes-33-mm.html");
                Q_PM_CartSteps.addProductpageItemToCart(quan);
                Q_PM_CartSteps.modalChekcout();
                break;

            default:
                break;
        }
    }
    //*******************************************************************
    // * Description: Select Payment Type
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void selectPaymentType(String payWith){       //authorize_net_cim, paypal_express, authorize_net_cim_echeck, cheque, bacs, bitpay
        Q_PM_WebElm.cn(pmQaProps, "cart.paymentType.className");
        Q_PM_WebElm.cnSelectValue(pmQaProps, "cart.paymentType.className", payWith);
        Q_PM_WebElm.myWait(500);
        Q_PM_WebElm.cn(pmQaProps, "cart.paymentType.className");
    }
    //*******************************************************************
    // * Description: Select Payment Type
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void selectCheckoutBtn(String  whichButton){
        Q_PM_WebElm.myWait(2000);
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("checkout"))));
        switch (whichButton){
            case ("top"):
                Q_PM_WebElm.cn(pmQaProps, "cart.topCheckoutBtn.className");
//                WebElm.xp(pmQaProps, "topCheckoutBtn.xp");
                break;
            case ("bottom"):
                Q_PM_WebElm.xp(pmQaProps, "cart.botCheckoutBtCC.xp");
                break;
            default:
                System.out.println("Checkout Button none selected");
                break;
        }
    }
    public static void selectCheckoutBtn(String  whichButton, String checkoutNow){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("checkout"))));
        switch (whichButton){
            case ("top"):
                Q_PM_WebElm.cn(pmQaProps, checkoutNow);
//                WebElm.xp(pmQaProps, checkoutNow);
                break;
            case ("bottom"):
                Q_PM_WebElm.id(pmQaProps, checkoutNow);
                break;
            default:
                System.out.println("Checkout Button none selected");
                break;
        }
    }
    //*******************************************************************
    // * Description: Select Guest Checkout
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void bridgeGuest() {
        Q_PM_WebElm.xp(pmQaProps, "cart.topCheckoutBtn.xp");
        Q_PM_WebElm.xp(pmQaProps, "chk.checkoutNowGuest.xp");
    }
    public static void  guestEmail(String emailAdd) {
        Q_PM_WebElm.idClear(pmQaProps,"chk.guestEmail.id");
        Q_PM_WebElm.idSend(pmQaProps,"chk.guestEmail.id", emailAdd);
    }
    //*******************************************************************
    // * Description: Select Checkout Method Bridge Page
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void bridgePage(String  whichButton, String continueCheckout) throws FileNotFoundException {
        switch (whichButton){
            case ("guest"):
                Q_PM_WebElm.xp(pmQaProps, continueCheckout);
//                WebElm.idSend(pmQaProps, "guestEmai.id", "qa3jmb@gmail.com");
                Q_PM_WebElm.idSend(pmQaProps, "chk.guestEmail.id", "qaGuest1234566789@jmbullion.com");
                creditForm(2);
                //shippingForm(34); // 12

                break;
            case ("existing email"):
                Q_PM_WebElm.xp(pmQaProps, continueCheckout);
                Q_PM_WebElm.idSend(pmQaProps, "chk.guestEmail.id", "qa+1jmb@jmbullion.com");
                Q_PM_WebElm.myWait(2000);
                //Assert.assertTrue(WebElm.cnDisplayed(pmQaProps, "modal.className").equals(true));
                Assert.assertTrue(Q_PM_WebElm.idDisplayed(pmQaProps, "acc.login.pwd.id").equals(true));
                Q_PM_WebElm.cn(pmQaProps, "acc.loginModalClose.className");
                Q_PM_WebElm.myWait(2000);
                Q_PM_WebElm.cn(pmQaProps, "acc.loginModalClose.className");
                driver.navigate().to(baseUrl + "/cart");
                Q_PM_CartSteps.deleteItem();
                System.out.println("verified user attempted to checkout as guest with a registered email ");
                break;
            case ("bridgeUser"):
                UserContainer uc = new UserContainer(29);
                Q_PM_WebElm.idClear(pmQaProps, "chk.bridgeEmail.id");
                Q_PM_WebElm.idSend(pmQaProps, "chk.bridgeEmail.id",uc.user);
                Q_PM_WebElm.idClear(pmQaProps, "chk.bridgePwd.id");
                Q_PM_WebElm.idSend(pmQaProps, "chk.bridgePwd.id",uc.passwd);
                Q_PM_WebElm.xp(pmQaProps, continueCheckout);

                break;
            case ("checkout register"):
                Q_PM_WebElm.xp(pmQaProps, continueCheckout);
//                WebElm.idSend(pmQaProps, "guestEmai.id", "qa3jmb@gmail.com");
                Q_PM_WebElm.idSend(pmQaProps, "chk.guestEmail.id", "qa5auto@jmbullion.com");
                creditForm(2);
                shippingForm(12);
                break;
            default:
                System.out.println("Checkout Button none selected");
                break;
        }
    }
    //*******************************************************************
        // * Description: Fill out Address Form
        // * Param: String, Integer
        // * Returns: NA
        // * Status: Complete
        //*******************************************************************/
        // @Step
        public static void cardSelection(String cardOption){
            switch (cardOption){
                case "defaultCard":
                    Q_PM_WebElm.xpSelected(pmQaProps, "chk.defaultCard.xp");
                    Q_PM_WebElm.idSend(pmQaProps, "chk.cdCvv.id", "121");
                    break;
                case "visa":
                    Q_PM_WebElm.xp(pmQaProps,"chk.visa.xp");
                    Q_PM_WebElm.idSend(pmQaProps, "chk.cdCvv.id", "652");
                    break;
                case "mc":
                    Q_PM_WebElm.myWait(1000);
                    Q_PM_WebElm.xp(pmQaProps, "chk.masterCard.xp");
                    Q_PM_WebElm.idSend(pmQaProps, "chk.cdCvv.id", "934");
                    break;
                case "Amex":
                    Q_PM_WebElm.xp(pmQaProps, "chk.amex.xp");
                    Q_PM_WebElm.idSend(pmQaProps, "chk.cdCvv.id", "1324");
                    break;
                case "newCard":
                    Q_PM_WebElm.xp(pmQaProps, "chk.newCardRadio.xp");
                    break;
                case"switchCard":
                    if(Q_PM_WebElm.xpSelected(pmQaProps, "chk.defaultCard.xp").equals(true)){
                        Q_PM_WebElm.xp(pmQaProps, "chk.nonDefaultCard.xp");
                        Q_PM_WebElm.idSend(pmQaProps, "chk.cdCvv.id", "121");
                    }
                    else{
                        Q_PM_WebElm.xp(pmQaProps, "chk.defaultCard.xp");
                        Q_PM_WebElm.idSend(pmQaProps, "chk.cdCvv.id", "121");
                    }

            }

    }
    //*******************************************************************
    // * Description: Fill out Address Form
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void addressSelection(String cardOption) throws FileNotFoundException {
        switch (cardOption){
            case "switch address":
                if(Q_PM_WebElm.xpSelected(pmQaProps, "chk.shFirstAdd.xp").equals(true)){
                    Q_PM_WebElm.xp(pmQaProps, "chk.shSecAddress.xp");
                    System.out.println("Switched to : " + Q_PM_WebElm.xpRetText(pmQaProps, "chk.shSecAddressValue.xp"));
                    Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "chk.shSecAddressValue.xp").contains("13448 Metcalf Avenue"));
                }
                else {
                    Q_PM_WebElm.xp(pmQaProps, "chk.shFirstAdd.xp");
                }
                break;

            case "new address":
                Q_PM_WebElm.xp(pmQaProps, "chk.shAddNewAddress.xp");
                shippingForm(12);
                Q_PM_Controls.scrolDownPixel(600);
                Q_PM_WebElm.myWait(1000);
                validateAddress();
                break;

        }

    }
    //*******************************************************************
    // * Description: Fill out Credit Form
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void creditForm(Integer index) throws FileNotFoundException {
        CreditContainer card = new CreditContainer(index);
        Q_PM_WebElm.myWait(1000);
        Assert.assertTrue(Q_PM_WebElm.idDisplayed(pmQaProps, "chk.cdName.id"));
        Q_PM_WebElm.idSend(pmQaProps, "chk.cdName.id",card.cdName);
        Q_PM_WebElm.idSend(pmQaProps, "chk.cdNumber.id", card.cdNumber);
        Q_PM_WebElm.idSelectValue(pmQaProps, "chk.cdMonth.id", card.monthV);
        Q_PM_WebElm.idSelectIndex(pmQaProps, "chk.cdYear.id", card.year);
        Q_PM_WebElm.idSend(pmQaProps, "chk.cdCvv.id", card.code);

    }
    //*******************************************************************
    // * Description: Fill out Shipping Address Form Chrome Browser
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void shippingFormEdit(Integer index) throws FileNotFoundException {
        AddressContainer ship = new AddressContainer(index);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.idClear(pmQaProps, "chk.shAddress.id");
        Q_PM_WebElm.idSend(pmQaProps, "chk.shAddress.id", ship.street);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.idSendTab(pmQaProps, "chk.shAddress.id");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.idSendTab(pmQaProps, "chk.shAddress.id");
//        WebElm.xp(pmQaProps, "accountEditAddress.xp");
        Q_PM_Controls.scrolDownPixel(600);

}
    //*******************************************************************
    // * Description: Edit phone number during checkout
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void editPhoneCheckout(String continueBtn){
        Q_PM_WebElm.xp(pmQaProps, "chk.shipping.FirstAddEdit.xp");
        String currentPhoneNo = Q_PM_WebElm.xpRetText(pmQaProps, "chk.shipping.FirstAddEdit.xp")/*.substring(72)*/;
        System.out.println("Displayed Phone Number: " + currentPhoneNo);
        if(currentPhoneNo.equals(currentPhoneNo)){
            String newPhoneNumber = "(961) 820-2804";
            Q_PM_WebElm.idClear(pmQaProps, "chk.shPhone.id");
            Q_PM_WebElm.idSend(pmQaProps, "chk.shPhone.id", newPhoneNumber);
            Q_PM_WebElm.id(pmQaProps, "chk.shValidate.id");
            Q_PM_WebElm.myWait(1000);
//            WebElm.id(pmQaProps, continueBtn);
            String newPhone = Q_PM_WebElm.xpRetText(pmQaProps, "chk.shipping.FirstAddBlock.xp");
            System.out.println("Phone Number changed to: " + newPhone);
//            Assert.assertEquals(newPhoneNumber, newPhone.substring(54));
            Assert.assertTrue(newPhone.contains(newPhoneNumber));
        }
        else{
            String newPhoneNumber = "(961) 001-2804";
            Q_PM_WebElm.idClear(pmQaProps, "chk.shPhone.id");
            Q_PM_WebElm.idSend(pmQaProps, "chk.shPhone.id", newPhoneNumber);
            Q_PM_WebElm.id(pmQaProps, "chk.shValidate.id");
            Q_PM_WebElm.myWait(1000);
            Q_PM_WebElm.id(pmQaProps, continueBtn);
            String newPhone = Q_PM_WebElm.xpRetText(pmQaProps, "chk.shipping.FirstAddBlock.xp");
            System.out.println("Phone Number changed to: " + newPhone);
//            Assert.assertEquals(newPhoneNumber, newPhone.substring(54));
            Assert.assertTrue(newPhone.contains(newPhoneNumber));
        }
//        WebElm.id(pmQaProps, "accSaveAddress.id");

    }
    //*******************************************************************
    // * Description: Fill out Shipping Address Form Firefox Browser
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void shippingForm(Integer index) throws FileNotFoundException {
        AddressContainer ship = new AddressContainer(index);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.idClear(pmQaProps, "chk.shFname.id");
        Q_PM_WebElm.idClear(pmQaProps, "chk.shPhone.id");
        Q_PM_WebElm.idClear(pmQaProps, "chk.shLname.id");
        Q_PM_WebElm.idClear(pmQaProps, "chk.shAddress.id");
        Q_PM_WebElm.idClear(pmQaProps, "chk.shCity.id");
        Q_PM_WebElm.idClear(pmQaProps, "chk.shZip.id");
        Q_PM_WebElm.idSend(pmQaProps, "chk.shFname.id", ship.firstName);
        Q_PM_WebElm.idSend(pmQaProps, "chk.shLname.id", ship.lastName);
        Q_PM_WebElm.idSend(pmQaProps, "chk.shAddress.id", ship.street);
        Q_PM_WebElm.myWait(3000);
        Q_PM_WebElm.idSendTab(pmQaProps, "chk.shAddress.id");
//        WebElm.xp(pmQaProps, "shippingHeader.xp");
        Q_PM_WebElm.idSend(pmQaProps, "chk.shCity.id", ship.city);
        Q_PM_WebElm.myWait(1000);
//        WebElm.xp(pmQaProps, "shippingHeader.xp");
        Q_PM_WebElm.idSelectValue(pmQaProps, "chk.shState.id", ship.state);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS.SECONDS);
        //JavascriptExecutor executor = (JavascriptExecutor)driver;executor.executeScript("arguments[0].click",(driver.findElement(By.id(pmQaProps.getProperty("shZip.id")))));
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.idClear(pmQaProps, "chk.shZip.id");
        Q_PM_WebElm.idSend(pmQaProps, "chk.shZip.id", ship.zipcode);

        Q_PM_WebElm.idSend(pmQaProps, "chk.shPhone.id", ship.phoneNumber);
        //validateAddress("accSaveAddress.id","acc.ContinueWith.id");
    }
    //*******************************************************************
    // * Description: Fill out Shipping Address Form
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void validateAddress() {
        Q_PM_Controls.checkAlert();
        try {
//            WebElm.myWait(2000);
            Q_PM_Controls.scrolUpPixel(500);
            Q_PM_WebElm.idDisplayed(pmQaProps, "chk.shValidate.id");
            Q_PM_WebElm.id(pmQaProps, "chk.shValidate.id");
//            WebElm.myWait(2000);
            //if(WebElm.cnDisplayed(pmQaProps, "shError.classsName").equals(false))
            System.out.println("Successfully detected and auto filled shipping address");
            Q_PM_Controls.checkAlert();
            if (Q_PM_WebElm.cnDisplayed(pmQaProps, "chk.shError.classsName").equals(true)) {
                System.out.println("continue to force address");
                Q_PM_WebElm.myWait(2000);
                Q_PM_WebElm.idDisplayed(pmQaProps, "chk.shContinueWithAdd.id");
                Q_PM_WebElm.id(pmQaProps, "chk.shContinueWithAdd.id");
                Q_PM_WebElm.myWait(2000);
            }
        } catch (Throwable ex) {
            Q_PM_Controls.checkAlert();
            System.out.println("Failed to Force validate address");
        }

//        WebElm.myWait(2000);
    }
    //*******************************************************************
    // * Description: PayPal Checkout New Session
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void payPal( String emailValue, String password) {
        Q_PM_WebElm.myWait(3000);
        Q_PM_WebElm.id(pmQaProps, "cart.botCheckoutBtPP.id");
        Q_PM_WebElm.myWait(4000);
        //Q_PM_WebElm.xp(pmQaProps, "chk.paypal.cookie.btn.xp");
        Q_PM_WebElm.idClear(pmQaProps, "chk.ppEmail.id");
        Q_PM_WebElm.idSend(pmQaProps, "chk.ppEmail.id", emailValue);
        Q_PM_WebElm.id(pmQaProps, "chk.ppNext.id");
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.idClear(pmQaProps, "chk.ppPass.id");
        Q_PM_WebElm.idSend(pmQaProps, "chk.ppPass.id", password);
        Q_PM_WebElm.id(pmQaProps, "chk.ppLogin.id");
        Q_PM_Controls.scrolDownPixel(1000);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.idExecutor(pmQaProps, "chk.ppContinue.id");
        Q_PM_Controls.scrolDownPixel(1000);
//        WebElm.myWait(1000);
//        WebElm.idExecutor(pmQaProps, "ppContinue.id");

    }
    //*******************************************************************
    // * Description: PayPal Checkout New Session
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void payPalChangeAdd( String emailValue, String password) {
        Q_PM_WebElm.id(pmQaProps, "cart.botCheckoutBtPP.id");
        try{
            Q_PM_WebElm.myWait(4000);
            Q_PM_WebElm.xp(pmQaProps, "chk.paypal.cookie.btn.xp");
        }
        catch(Throwable ex){
            System.out.println("Cookie consent not displayed");
        }

        Q_PM_WebElm.idClear(pmQaProps, "chk.ppEmail.id");
        Q_PM_WebElm.idSend(pmQaProps, "chk.ppEmail.id", emailValue);
        Q_PM_WebElm.id(pmQaProps, "chk.ppNext.id");
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.idClear(pmQaProps, "chk.ppPass.id");
        Q_PM_WebElm.idSend(pmQaProps, "chk.ppPass.id", password);
        Q_PM_WebElm.id(pmQaProps, "chk.ppLogin.id");
        Q_PM_WebElm.xp(pmQaProps, "chk.ppChangeAdd.xp");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xp(pmQaProps, "chk.ppAddressSelect.xp");
        Q_PM_WebElm.xp(pmQaProps, "chk.ppPuerto.xp");
        Q_PM_WebElm.myWait(2000);
        Q_PM_Controls.scrolDownPixel(500);
        Q_PM_WebElm.id(pmQaProps, "chk.ppContinue.id");

    }
    //*******************************************************************
    // * Description: PayPal Checkout Existing Session
    // * Param: String, Integer
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void payPalNext( String emailValue, String password) {
        Q_PM_WebElm.id(pmQaProps, "cart.botCheckoutBtPP.id");
        Q_PM_WebElm.idClear(pmQaProps, "chk.ppEmail.id");
        Q_PM_WebElm.idSend(pmQaProps, "chk.ppEmail.id", emailValue);
        //WebElm.id(pmQaProps, "paypal.checkout.ppNext.id");
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.idClear(pmQaProps, "chk.ppPass.id");
        Q_PM_WebElm.idSend(pmQaProps, "chk.ppPass.id", password);
        Q_PM_WebElm.id(pmQaProps, "chk.ppLogin.id");
        Q_PM_WebElm.myWait(3000);
        //WebDriverWait wait = new WebDriverWait(driver, 60);
        //wait.until(ExpectedConditions.visibilityOfLocated(By.id("paypal.checkout.ppContinue.id")));
        Q_PM_WebElm.id(pmQaProps, "chk.ppContinue.id");

    }
    //*******************************************************************
    // * Description: Return review page pricing without Tax
    // * Param:
    // * Returns: Array List
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static List<Float> revPriceListNoTax() {
        Q_PM_WebElm.myWait(2000);
        List<Float> priceList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revSubtotal.id").replaceAll("[^0-9?!\\.]",""));
        priceList.add(subtotal);
        Float shipping = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revShipping.id").replaceAll("[^0-9?!\\.]",""));
        priceList.add(shipping);
        Float total = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revTotal.id").replaceAll("[^0-9?!\\.]",""));
        priceList.add(total);
        return priceList;
    }
    //*******************************************************************
    // * Description: Return review page pricing Without tax
    // * Param:
    // * Returns: Array List
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static List<Float> orderPriceListNoTax() {
        Q_PM_WebElm.myWait(2000);
        Q_PM_WebElm.xp(pmQaProps, "chk.linkToOrder.xp");
        Q_PM_WebElm.myWait(2000);
        List<Float> orderList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.orderSubtotal.id").replaceAll("[^0-9?!\\.]",""));
        orderList.add(subtotal);
        if(Q_PM_WebElm.idRetText(pmQaProps, "chk.orderShipping.id").contains("Free")){
            Float shipping = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.orderShipping.id").replaceAll("[^0-9?!\\.]","0"));
            orderList.add(shipping);
        }
        else{
            Float shipping = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.orderShipping.id").replaceAll("[^0-9?!\\.]",""));
            orderList.add(shipping);
        }


        Float total = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.orderTotal.id").replaceAll("[^0-9?!\\.]",""));
        orderList.add(total);
        return orderList;
    }

    public static void itemTax(){
        Integer itemCount = Q_PM_WebElm.xpCountTableRows(pmQaProps,"chk.itemCount.xp");
        System.out.println("Items in order " + itemCount);
        for(int i = 2; i < itemCount -4; i++){
            System.out.println(Q_PM_WebElm.xpRetText(pmQaProps,"chk.itemBeg.xp", i, "chk.itemDescription.end.xp") + "\t \t" +
                    "Item tax: " + "\t" + Q_PM_WebElm.xpRetText(pmQaProps,"chk.itemBeg.xp", i, "chk.itemTax.end.xp"));
        }
    }
    //*******************************************************************
    // * Description: Return review page pricing with Taxable address
    // * Param:
    // * Returns: Array List
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static List<Float> revPriceListTax() {
        Q_PM_WebElm.myWait(2000);
        List<Float> priceList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revSubtotal.id").replaceAll("[^0-9?!\\.]",""));
        priceList.add(subtotal);
        Float tax = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revTax.id").replaceAll("[^0-9?!\\.]",""));
        priceList.add(tax);

        Float shipping = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revShipping.id").replaceAll("[^0-9?!\\.]",""));
        priceList.add(shipping);
        Float total = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revTotal.id").replaceAll("[^0-9?!\\.]",""));
        priceList.add(total);
        return priceList;
    }
    //*******************************************************************
    // * Description: Return review page pricing Without taxable address
    // * Param:
    // * Returns: Array List
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static List<Float> orderPriceListTax() {
        Q_PM_WebElm.myWait(2000);
//        WebElm.xp(pmQaProps, "linkToOrder.xp");

        List<Float> orderList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.orderSubtotal.id").replaceAll("[^0-9?!\\.]",""));
        orderList.add(subtotal);
        Float orderTax = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.orderTax.id").replaceAll("[^0-9?!\\.]",""));
        orderList.add(orderTax);
        if(Q_PM_WebElm.idRetText(pmQaProps, "chk.orderShipping.id").contains("Free")){
            Float shipping = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.orderShipping.id").replaceAll("[^0-9?!\\.]","0"));
            orderList.add(shipping);
        }
        else{
            Float shipping = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.orderShipping.id").replaceAll("[^0-9?!\\.]",""));
            orderList.add(shipping);
        }


        Float total = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.orderTotal.id").replaceAll("[^0-9?!\\.]",""));
        orderList.add(total);
        return orderList;
    }
    public static  void checkoutModal(String tcName){
        Q_PM_WebElm.xp(pmQaProps, "chk.consent.xp");
        Q_PM_WebElm.id(pmQaProps, "chk.finishPlaceOrder.id");
        Q_PM_WebElm.myWait(1000);

        driver.switchTo().frame("step-up-iframe");
//        System.out.println(WebElm.xpRetText(pmQaProps, "text.xp"));
        WebElement frameElement = driver.findElement(By.xpath("/html/body/div[1]/div/iframe"));
        driver.switchTo().frame(frameElement);
        Q_PM_WebElm.myWait(1000);
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "chk.checkoutModalChallenge.xp").toString());
        Q_PM_WebElm.xpClear(pmQaProps, "chk.checkoutModalChallenge.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "chk.checkoutModalChallenge.xp", "1234");
        Q_PM_WebElm.xp(pmQaProps, "chk.checkoutModalSubmit.xp");
        //Q_PM_Controls.captureScreen(tcName);
        Q_PM_WebElm.myWait(5000);
        try {
			Q_PM_WebElm.myWait(1000);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			//exception handling
			System.out.println("Recovering from exception when handling switching from frame due to detached frame.");
		}
    }
    public static  void checkoutModalError(){
        Q_PM_WebElm.xp(pmQaProps, "chk.consent.xp");
        Q_PM_WebElm.id(pmQaProps, "chk.finishPlaceOrder.id");
        Q_PM_WebElm.myWait(1000);

        driver.switchTo().frame("step-up-iframe");
//        System.out.println(WebElm.xpRetText(pmQaProps, "text.xp"));
        WebElement frameElement = driver.findElement(By.xpath("/html/body/div[1]/div/iframe"));
        driver.switchTo().frame(frameElement);
        Q_PM_WebElm.myWait(1000);
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "chk.checkoutModalChallenge.xp").toString());
        Q_PM_WebElm.xpClear(pmQaProps, "chk.checkoutModalChallenge.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "chk.checkoutModalChallenge.xp", "1234");
        Q_PM_WebElm.xp(pmQaProps, "chk.checkoutModalSubmit.xp");
        try {
			Q_PM_WebElm.myWait(1000);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			//exception handling
			System.out.println("Recovering from exception when handling switching from frame due to detached frame.");
		}
        Q_PM_WebElm.myWait(4000);

    }
    public static void modalErrorMsg(String tcName){
        driver.switchTo().frame("step-up-iframe");
        System.out.println("modal error " + Q_PM_WebElm.xpRetText(pmQaProps, "chk.checkoutModalErrorText.xp"));
        //Q_PM_Controls.captureScreen(tcName);
        try {
			Q_PM_WebElm.myWait(1000);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			//exception handling
			System.out.println("Recovering from exception when handling switching from frame due to detached frame.");
		}
    }

    //*******************************************************************
    // * Description: Attempt order when expecting failure
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void attemptOrder(String tcName) {
        Q_PM_WebElm.xp(pmQaProps, "chk.consent.xp");
        Q_PM_WebElm.id(pmQaProps, "chk.finishPlaceOrder.id");
        Q_PM_WebElm.myWait(2000);
        System.out.println("Error message " + Q_PM_WebElm.cnRetText(pmQaProps, "chk.woocommerceError.cn"));
        Q_PM_WebElm.myWait(2000);
        Q_PM_Controls.captureScreen(tcName);

    }
    //*******************************************************************
    // * Description: Checkout error message validation
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void validateErrorrMsg(String expected){
        Assert.assertEquals(Q_PM_WebElm.cnRetText(pmQaProps, "chk.woocommerceError.cn"),expected);
    }
    public static void validateErrorrMsgContains(String expected){
        Assert.assertTrue(Q_PM_WebElm.cnRetText(pmQaProps, "chk.woocommerceError.cn").contains(expected));
    }
    //*******************************************************************
    // * Description: Complete order
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void completeOrder(String commit) {
        Q_PM_WebElm.myWait(1000);
        Q_PM_Controls.scrolDownPixel(500);
        Q_PM_WebElm.xp(pmQaProps, "chk.consent.xp");
        Q_PM_WebElm.idExecutor(pmQaProps, commit);
        try{
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("sa_close"))));
            Q_PM_WebElm.myWait(2000);
            Q_PM_WebElm.id(pmQaProps, "chk.saClose.id");
        }
        catch (Exception e){
            System.out.println("Shopper Approved did not display");

        }
    }
    //*******************************************************************
    // * Description: Complete order
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void completeOrder() {
        Q_PM_WebElm.myWait(2000);
                Q_PM_WebElm.xp(pmQaProps, "chk.consent.xp");
        try{
            Q_PM_WebElm.idExecutor(pmQaProps, "chk.finishPlaceOrder.id");
            Q_PM_WebElm.myWait(2000);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    //*******************************************************************
    // * Description:If order is complete obtain order number
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void isOrderComplete(String tcName){
        Q_PM_WebElm.myWait(3000);
        System.out.println(driver.getCurrentUrl());
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "chk.orderNumber.xp"));
        Q_PM_Controls.captureScreen(tcName);
        Assert.assertEquals(Q_PM_WebElm.xpRetText(pmQaProps, "chk.thankYou.xp"), "Thank You For Your Order!");
    }
    //*******************************************************************
    // * Description: Verify order charges
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void verifyOrderCharges(List revCharges, List orderCharges) {
        //System.out.println("Review Page " + revCharges);
        //System.out.println("Order Page " + orderCharges);
        for(int i=0; i < orderCharges.size(); i++){
            System.out.println("Review Page " + Q_PM_WebElm.xpRetText(pmQaProps, "chk.begOrderCharges.xp", (i +1), "chk.endOrderCharges.xp").replaceAll("[0-9!@#$%^&*()Free_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]", "") + revCharges.get(i));
            System.out.println("Order Page  " + Q_PM_WebElm.xpRetText(pmQaProps, "chk.begOrderCharges.xp", (i +1), "chk.endOrderCharges.xp").replaceAll("[0-9!@#$%^&*()Free_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]", "")  +  orderCharges.get(i));
            Assert.assertEquals(revCharges.get(i), orderCharges.get(i));
        }

    }
    //*******************************************************************
    // * Description: My account order status
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void orderStatus() {
        Q_PM_WebElm.id(pmQaProps, "chk.finishPlaceOrder.id");
        Q_PM_WebElm.myWait(8000);
        Q_PM_WebElm.id(pmQaProps, "chk.saClose.id");
        Q_PM_WebElm.myWait(2000);
    }
    //*******************************************************************
    // * Description: Thank you page order status
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void tyOrderStatus(String tyStatus) {
        switch ( tyStatus ){
            case "processing payment":
                Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "chk.tyProcessingPayment.xp").equals(true));
                break;
            case "confirmed payment":
                Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "chk.tyConfirmedPayment.xp").equals(true));
                break;
            case "oreder processing":
                Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "chk.tyOrderProcessing.xp").equals(true));
                break;
            case "order shipped":
                Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "chk.tyOrderShipped.xp").equals(true));
                break;
            default:
                System.out.println("Thank you Order Status unavailable");
                break;
        }

    }
    //*******************************************************************
    // * Description: Complete order status
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void completeStatus(String tyStatus) {
        Q_PM_WebElm.myWait(2000);
        switch ( tyStatus ){
            case "processing payment":
                Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "chk.accProcessingPayment.xp").equals(true));
                break;
            case "confirmed payment":
                Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "chk.accConfirmedPayment.xp").equals(true));
                break;
            case "oreder processing":
                Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "chk.accOrderProcessing.xp").equals(true));
                break;
            case "order shipped":
                Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "chk.accOrderShipped.xp").equals(true));
                break;
            default:
                System.out.println("Thank you Order Status unavailable");
                break;
        }

    }
    //*******************************************************************
    // * Description: Shipping options
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void shippinOptions(String option) {
        switch ( option ){
            case "default shipping":
                try{
                    Assert.assertTrue(Q_PM_WebElm.xpSelected(pmQaProps, "chk.freeShipping.xp").equals(true));
                }
                catch(Exception e){
                    Q_PM_WebElm.xp(pmQaProps, "chk.freeShipping.xp");
                    Assert.assertTrue(Q_PM_WebElm.xpSelected(pmQaProps, "chk.freeShipping.xp").equals(true));
                }

                break;
            case "usps priority":
                Q_PM_WebElm.xp(pmQaProps, "chk.uspsPriority.xp");
                Assert.assertTrue(Q_PM_WebElm.xpSelected(pmQaProps, "chk.uspsPriority.xp").equals(true));
                Q_PM_WebElm.myWait(1000);
                break;
            case "ups 3 day":
                Q_PM_WebElm.xp(pmQaProps, "chk.ups3day.xp");
                Assert.assertTrue(Q_PM_WebElm.xpSelected(pmQaProps, "chk.ups3day.xp").equals(true));
                Q_PM_WebElm.myWait(1000);
                break;

            default:
                System.out.println("Shipping option not available");
                break;
        }

    }
    public static String numberReturn(String locator) {
        return Q_PM_WebElm.xpRetTextReplace(pmQaProps, locator);
    }

    public static void regShippingUpgrade(String shippingOption) {
        Q_PM_WebElm.myWait(2000);
        switch ( shippingOption ) {
            case "option 1":
                Q_PM_WebElm.xpExecutor(pmQaProps, "chk.shippingOption1.xp");
                System.out.println("shipping charge: " + numberReturn("chk.shippingOption1.xp"));
                break;
            case "option 2":
                Q_PM_WebElm.xpExecutor(pmQaProps, "chk.shippingOption2.xp");
                System.out.println("shipping charge: " + numberReturn("chk.shippingOption2.xp"));
                break;
            case "option 3":
                Q_PM_WebElm.xpExecutor(pmQaProps, "chk.shippingOption3.xp");
                System.out.println("shipping charge: " + numberReturn("chk.shippingOption3.xp"));
                break;
        }
        Q_PM_WebElm.myWait(2000);
    }

    //*******************************************************************
    // * Description: Switch to ACH
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void switchACH() {
        Q_PM_Controls.scrolDownPixel(600);
        Q_PM_WebElm.id(pmQaProps, "chk.switchPaymentOrder.id");
        Q_PM_WebElm.myWait(1000);
        Q_PM_Controls.checkAlert();
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xp(pmQaProps, "chk.paymentoption1.xp");
        Q_PM_WebElm.myWait(1000);

        Q_PM_WebElm.id(pmQaProps, "chk.saveChanges.id");
        Q_PM_WebElm.xpExecutor(pmQaProps, "chk.saveChanges.xp");
        Q_PM_Controls.checkAlert();
        Q_PM_WebElm.myWait(2000);
        Q_PM_Controls.checkAlert();
        Q_PM_WebElm.myWait(2000);
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "chk.order.paymentMethodtxt.xp"));
        Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "chk.order.paymentMethodtxt.xp").contains("ACH - Using"));
    }

    //JMB-6527 Start
    //*******************************************************************
    // * Description: Validate that Shipping methods & costs match expected
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public static void verifyAvailableShippingMethodsAndCosts(String availableShippingCosts) {
        List<WebElement> shippingMethods = driver.findElements(By.xpath(pmQaProps.getProperty("chk.shippingMethods.xp")));
        List<WebElement> shippingCosts = driver.findElements(By.xpath(pmQaProps.getProperty("chk.shippingCosts.xp")));
        ArrayList<String> actualShippingCosts = new ArrayList<String>();
        ArrayList<String> expectedShippingCosts = new ArrayList<String>(Arrays.asList(availableShippingCosts.split(";")));
        String currentMethod, currentCosts;
        String[] tempArray;
        if (shippingMethods.size() == 0) {
            Assert.fail("[Fail] Unable to find avaiable shipping methods to verify on application.");
        }
        if (shippingCosts.size() == 0) {
            Assert.fail("[Fail] Unable to find avaiable shipping costs to verify on application.");
        }
        for (int counter = 0; counter < shippingCosts.size(); counter++)
        {
            currentMethod = shippingMethods.get(counter).getText();
            tempArray = currentMethod.split("\n");
            currentMethod = tempArray[0];
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

    //*******************************************************************
    // * Description: Grab the price list values from Review page
    // * Param: None
    // * Returns: NA
    // * Status: List<Float>
    //*******************************************************************/
    public static List<Float> revPriceListSh() {
        Q_PM_WebElm.myWait(2000);
        List<Float> priceList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revSubtotal.id").replaceAll("[^0-9?!\\.]",""));
        Float subtax = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revTax.id").replaceAll("[^0-9?!\\.]",""));
        Float shipping = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revShipping.id").replaceAll("[^0-9?!\\.]",""));
        Float total = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revTotal.id").replaceAll("[^0-9?!\\.]",""));
        Float shTax = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revShiipingTax.id").replaceAll("[^0-9?!\\.]",""));
        System.out.println("Merchendise tax: " + subtax + "\n" + "Shipping Tax: " + shTax);
        String taxTotal = String.format("%.2f", subtax + shTax);
        Float tax = Float.parseFloat(taxTotal);
        priceList.add(subtotal);
        priceList.add(tax);
        priceList.add(shipping);
        priceList.add(total);
        return priceList;
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
        Q_PM_WebElm.xp(pmQaProps, "chk.shipping.FirstAddEdit.xp");
        Q_PM_WebElm.idClear(pmQaProps, "chk.shAddress.id");
        Q_PM_WebElm.idSend(pmQaProps, "chk.shAddress.id", editShippingAdd);
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.idSendTab(pmQaProps, "chk.shAddress.id");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.id(pmQaProps, "chk.shValidate.id");
        // Had to use style attribute to see if Continue with this Address button appears
        // as Displayed is always returning true
        boolean verifyCondition = verifyAttrDoesNotContainsValueWithinTimeout(pmQaProps, "chk.shContinueWithAdd.id", "style", "display: none", 5);
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
        Q_PM_WebElm.xpExecutor(pmQaProps, "chk.shipping.addShippingAddress.xp");
        Q_PM_WebElm.myWait(1000);
        // Had to use style attribute to see if Continue with this Address button appears
        // as Displayed is always returning true
        boolean verifyCondition = verifyAttrContainsValueWithinTimeout(pmQaProps, "chk.shContinueWithAdd.id", "style", "display: none", 5);
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
            Q_PM_WebElm.myWait(1000);
            if (Q_PM_WebElm.idAttrRet(property, location, attribute).contains(value)) {
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
            Q_PM_WebElm.myWait(1000);
            if (!Q_PM_WebElm.idAttrRet(property, location, attribute).contains(value)) {
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
 		String productDesc = Q_PM_WebElm.xpRetText(pmQaProps, "chk.productDesc.thankYouPage.xp");
 		Q_PM_WebElm.xp(pmQaProps, "chk.productDesc.thankYouPage.xp");
 		Q_PM_Controls.switchWin();
 		Assert.assertEquals(productDesc, Q_PM_WebElm.xpRetText(pmQaProps, "cart.productPage.productDesc.xp"),
 				"Incorrect Product Window launched");
 		System.out.println("Correct PDP launched when product description is clicked on Thank You page.");
 	}
 	// JMB-3594 End
 	
 	//Start JMB-4230
 	public void formInputId(String locator, String inputValue) {
        Q_PM_WebElm.idClear(pmQaProps, locator);
        Q_PM_WebElm.idSend(pmQaProps, locator, inputValue);
    }
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
         Q_PM_WebElm.myWait(1000);
         formInputId("chk.billingCity.id", ship.city);
         Q_PM_WebElm.idSelectValue(pmQaProps, "chk.billingState.id", ship.state);
         Q_PM_WebElm.myWait(3000);
         formInputId("chk.billingZip.id", ship.zipcode);
         formInputId("chk.billingPhone.id", ship.phoneNumber);
         Q_PM_WebElm.myWait(2000);
     }
 	/********************************************************************
 	* Description: Click save billing address after enter the required details 
 	* Author: Tamilselvan
 	* Param: NA
 	* Returns: NA
 	* Status: Complete 
 	*******************************************************************/
     public void saveBillingAddress() {
     	Q_PM_WebElm.id(pmQaProps,"chk.saveBillingAddress.id");
        Q_PM_WebElm.myWait(1000);
     }
 	/********************************************************************
 	* Description: Click change billing address button 
 	* Author: Tamilselvan
 	* Param: NA
 	* Returns: NA
 	* Status: Complete 
 	*******************************************************************/
     public void changeBillingAddressButton() {
 		Q_PM_WebElm.xp(pmQaProps, "chk.changeBillingAddress.xp");
        Q_PM_WebElm.myWait(3000);
     }
 	/********************************************************************
 	* Description: Click add new billing address 
 	* Author: Tamilselvan
 	* Param: NA
 	* Returns: NA
 	* Status: Complete 
 	*******************************************************************/
     public void clickAddNewBillAddress() {
     	Q_PM_WebElm.xp(pmQaProps,"chk.addNewBill.xp");
         Q_PM_WebElm.myWait(2000);
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
     		Q_PM_WebElm.xpDisplayed(pmQaProps, "chk.removeOldBill.xp");
     		Q_PM_WebElm.xpExecutor(pmQaProps, "chk.removeOldBill.xp");
     		Q_PM_Controls.checkAlert();
             Q_PM_WebElm.myWait(2000);
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
     	Q_PM_WebElm.xp(pmQaProps, "chk.deleteExistingCard.xp");
     }
 	/********************************************************************
 	* Description: Verify Billing Address Field  
 	* Author: Tamilselvan
 	* Param: NA
 	* Returns: NA
 	* Status: Complete 
 	*******************************************************************/
 	public void verifyBillingAddressField() {
     	Assert.assertTrue(Q_PM_WebElm.xpDisplayed(pmQaProps, "chk.billingAddress.xp"));
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
          Q_PM_WebElm.myWait(2000);
          driver.manage().timeouts().implicitlyWait(1, SECONDS);
          System.out.println("[Info] Start verification of checkout price list.");
          List<String> priceList = new ArrayList<String>();
          try {
          	Q_PM_WebElm.idDisplayed(pmQaProps, "chk.revSubtotal.id");
          	System.out.println("[Pass] Subtotal successfully found.");
          	priceList.add("Subtotal: ");
          } catch (Throwable ex) {
          	Assert.fail("[Fail] Subtotal was not found.");
          }

          if (hasSalesTax)
          {
          	try {
              	Q_PM_WebElm.idDisplayed(pmQaProps,"chk.revTax.id");
              	System.out.println("[Pass] Sales Tax successfully found.");
              	priceList.add("Sales Tax: ");
              } catch (Throwable ex) {
              	Assert.fail("[Fail] Sales Tax was not found.");
              }
          } else {
          	try {
              	Q_PM_WebElm.idDisplayed(pmQaProps,"chk.revTax.id");
              	Assert.fail("[Fail] Sales Tax was found but no expected.");
              } catch (Throwable ex) {
              	System.out.println("[Pass] Sales Tax was not found.");
              }
          }
          
          if (hasStateFee)
          {
          	try {
              	Q_PM_WebElm.idDisplayed(pmQaProps,"chk.revStateFee.id");
              	System.out.println("[Pass] State Fee successfully found.");
              	priceList.add("State Fee: ");
              } catch (Throwable ex) {
              	Assert.fail("[Fail] State Fee was not found.");
              }
          } else {
          	try {
              	Q_PM_WebElm.idDisplayed(pmQaProps,"chk.revStateFee.id");
              	Assert.fail("[Fail] State Fee was found but no expected.");
              } catch (Throwable ex) {
              	System.out.println("[Pass] State Fee was not found.");
              }
          }

          try {
          	Q_PM_WebElm.idDisplayed(pmQaProps, "chk.revShipping.id");
          	System.out.println("[Pass] Shipping successfully found.");
          	priceList.add("Shipping: ");
          } catch (Throwable ex) {
          	Assert.fail("[Fail] Shipping was not found.");
          }
          
          if (hasGiftCert)
          {
          	try {
              	Q_PM_WebElm.idDisplayed(pmQaProps,"chk.revDiscount.id");
              	System.out.println("[Pass] Discount successfully found.");
              	priceList.add("Discount: ");
              } catch (Throwable ex) {
              	Assert.fail("[Fail] Discount was not found.");
              }
          } else {
          	try {
              	Q_PM_WebElm.idDisplayed(pmQaProps,"chk.revDiscount.id");
              	Assert.fail("[Fail] Discount was found but no expected.");
              } catch (Throwable ex) {
              	System.out.println("[Pass] Discount was not found.");
              }
          }

          try {
          	Q_PM_WebElm.idDisplayed(pmQaProps, "chk.revTotal.id");
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
          Q_PM_WebElm.myWait(2000);
          List<Float> priceList = new ArrayList<Float>();
          Float calcTotal = Float.valueOf(0);
          Float subtotal = Float.valueOf(Q_PM_WebElm.idRetTextRep(pmQaProps,"chk.revSubtotal.id"));
          calcTotal = calcTotal + subtotal;
          priceList.add(subtotal);

          if (hasSalesTax)
          {
          	Float tax = Float.valueOf(Q_PM_WebElm.idRetTextRep(pmQaProps,"chk.revTax.id"));
          	calcTotal = calcTotal + tax;
          	priceList.add(tax);
          }
          
          if (hasStateFee)
          {
          	Float stateFee = Float.valueOf(Q_PM_WebElm.idRetTextRep(pmQaProps,"chk.revStateFee.id"));
          	calcTotal = calcTotal + stateFee;
          	priceList.add(stateFee);
          }

          Float shipping = Float.valueOf(Q_PM_WebElm.idRetTextRep(pmQaProps,"chk.revShipping.id"));
          calcTotal = calcTotal + shipping;
          priceList.add(shipping);
          
          if (hasGiftCert)
          {
          	Float discount = Float.valueOf(Q_PM_WebElm.idRetTextRep(pmQaProps,"chk.revDiscount.id"));
          	calcTotal = calcTotal - discount;
          	priceList.add(discount);
          }

          calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
          Float total = Float.valueOf(Q_PM_WebElm.idRetTextRep(pmQaProps,"chk.revTotal.id"));
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
          Q_PM_WebElm.myWait(2000);
          List<Float> priceList = new ArrayList<Float>();
          Float calcTotal = Float.valueOf(0);
          Float subtotal = Float.valueOf(Q_PM_WebElm.idRetTextRep(pmQaProps,"chk.orderSubtotal.id"));
          calcTotal = calcTotal + subtotal;
          priceList.add(subtotal);

          if (hasSalesTax)
          {
          	Float tax = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"chk.orderStateTax.xp"));
          	calcTotal = calcTotal + tax;
          	priceList.add(tax);
          }
          
          if (hasStateFee)
          {
          	Float stateFee = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"chk.orderStateFee.xp"));
          	calcTotal = calcTotal + stateFee;
          	priceList.add(stateFee);
          }

          Float shipping = Float.valueOf(Q_PM_WebElm.idRetTextRep(pmQaProps,"chk.orderShipping.id"));
          calcTotal = calcTotal + shipping;
          priceList.add(shipping);
          
          if (hasGiftCert)
          {
          	Float discount = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"chk.orderDiscount.xp"));
          	calcTotal = calcTotal - discount;
          	priceList.add(discount);
          }

          calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
          Float total = Float.valueOf(Q_PM_WebElm.idRetTextRep(pmQaProps,"chk.orderTotal.id"));
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
  		Float actualStateFee = Float.valueOf(Q_PM_WebElm.idRetTextRep(pmQaProps,"chk.revStateFee.id"));
  		Assert.assertEquals(Float.valueOf(expectedStateFee), actualStateFee, "[Fail] Expected state fee " + expectedStateFee + " did not match actual " + actualStateFee);
  	}
  	
  	/**********************************************************************
     * Description:     Strats Guest Checkout
     * Author:          Paul Patterson
     * Param:      		None
     * Returns:         None
     **********************************************************************/
	public void startGuestCheckout() {
		Q_PM_WebElm.xp(pmQaProps, "chk.checkoutNowGuest.xp");
	}
  	
  	/********************************************************************
  	* Description: Click to select first billing address to use on order
  	* Author: Paul Patterson
  	* Param: NA
  	* Returns: NA
  	* Status: Complete 
  	*******************************************************************/
      public void clickSelectFirstBillingAddress() {
      	Q_PM_WebElm.myWait(2000);
          driver.manage().timeouts().implicitlyWait(1, SECONDS);
      	try {
      		Q_PM_WebElm.xp(pmQaProps,"chk.billingBillToAddress1.xp");
      	} catch (Throwable ex) {
      		Q_PM_WebElm.xp(pmQaProps,"chk.billingUseCurrentAdddress1.xp");
      	}
      	driver.manage().timeouts().implicitlyWait(10, SECONDS);
          Q_PM_WebElm.myWait(2000);
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
      		Q_PM_WebElm.xp(pmQaProps,"chk.billingBUseShipAddillToAddress.xp");
      	} catch (Throwable ex) {
      		Q_PM_WebElm.xp(pmQaProps,"chk.billingUseShipAddCurrentAdddress.xp");
      	}
          Q_PM_WebElm.myWait(2000);
      }
 	//JMB-7670 End
}
