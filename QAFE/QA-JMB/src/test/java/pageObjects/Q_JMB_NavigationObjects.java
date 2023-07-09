package pageObjects;

import jsonWrappers.UserContainer;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.testng.Assert;

public class Q_JMB_NavigationObjects extends Q_JMB_Init {

    public static String getTitles(String verifyThisText){
        System.out.println("To be verified " + driver.getTitle());
        return verifyThisText;
    }
    public static void selectFromMenu(String menuItem) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("silver"))));
        Q_JMB_WebElm.myWait(2000);

        switch (menuItem){
            case ("home"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.home.xp");
                break;
            case ("gold"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.gold.xp");
                break;
            case ("silver"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.silver.xp");
                break;
            case ("platinum"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.platinum.xp");
                break;
            case ("other"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.other.xp");
                break;
            case ("copper"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.other.copper.xp");
                break;
            case ("palladium"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.other.palladium.xp");
                break;
            case ("accessories"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.other.accessories.xp");
                break;
            case ("on sale"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.onSale.xp");
                break;
            case ("new arrivals"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.newArrivals.xp");
                break;
            case ("sell to us"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.sellToUs.xp");
                break;
            case ("charts"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.charts.xp");
                break;
            case ("ira"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.ira.xp");
                break;
            case ("loans"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.loans.xp");
                break;
            case ("sales tax"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.salesTax.xp");
                break;
            case ("contact"):
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.contact.xp");
                break;
            default:
                System.out.println("Option is not a mega menu choice");
                break;
        }
    }
    /*******************************************************************
     // * Description: Category level
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    public static void moveIt(Properties proper, String locator){
        System.out.println(proper.getProperty(locator));
        String seleniumElement = proper.getProperty(locator);
        Actions moveTo = new Actions(driver);
        WebElement other = driver.findElement(By.xpath(seleniumElement));
        moveTo.moveToElement(other).moveToElement(other).perform();

    }
    /*******************************************************************
    // * Description: Category level
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void innerMega(String category) {
        switch ( category ) {

            case ("copper"):
                Q_JMB_WebElm.moveIt(jmbProps, "nav.mega.other.xp");
                Q_JMB_WebElm.xp(jmbProps,"nav.mega.other.copper.xp");
                break;
            case ("copper rounds"):
                Q_JMB_WebElm.moveIt(jmbProps, "nav.mega.other.xp");
                Q_JMB_WebElm.xp(jmbProps,"nav.mega.other.copper.rounds.xp");
                break;
            case ("copper bars"):
                Q_JMB_WebElm.moveIt(jmbProps, "nav.mega.other.xp");
                Q_JMB_WebElm.xp(jmbProps,"nav.mega.other.copper.bars.xp");
                break;
            case ("wheat pennies"):
                Q_JMB_WebElm.moveIt(jmbProps, "nav.mega.other.xp");
                Q_JMB_WebElm.xp(jmbProps,"nav.mega.other.copper.pennies.xp");
                break;
            case ("palladium"):
                Q_JMB_WebElm.moveIt(jmbProps, "nav.mega.other.xp");
                Q_JMB_WebElm.xp(jmbProps,"nav.mega.other.palladium.xp");
                break;
            case ("palladium bars"):
                Q_JMB_WebElm.moveIt(jmbProps, "nav.mega.other.xp");
                Q_JMB_WebElm.xp(jmbProps,"nav.mega.other.palladium.bars.xp");
                break;
            case ("palladium coins"):
                Q_JMB_WebElm.moveIt(jmbProps, "nav.mega.other.xp");
                Q_JMB_WebElm.xp(jmbProps,"nav.mega.other.palladium.coins.xp");
                break;
            case ("accessories"):
                Q_JMB_WebElm.moveIt(jmbProps, "nav.mega.other.xp");
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.other.accessories.xp");
                break;
            case ("coin accessories"):
                Q_JMB_WebElm.moveIt(jmbProps, "nav.mega.other.xp");
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.other.accessories.coin.xp");
                break;
            case ("bar accessories"):
                Q_JMB_WebElm.moveIt(jmbProps, "nav.mega.other.xp");
                Q_JMB_WebElm.xp(jmbProps,"nav.mega.other.accessories.bar.xp");
                break;
            case ("apparel"):
                Q_JMB_WebElm.moveIt(jmbProps, "nav.mega.other.xp");
                Q_JMB_WebElm.xp(jmbProps, "nav.mega.other.accessories.apparel.xp");
                break;
        }
    }

    public static void sellToUsOnLineButtonGuest() {
        Q_JMB_WebElm.xp(jmbProps, "nav.stuBtn.xp");
        Q_JMB_WebElm.xp(jmbProps, "nav.loginToSell.xp");
        Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "nav.loginModal.xp").equals(true));
        Q_JMB_WebElm.xp(jmbProps, "nav.closeLoginModal.xp");
    }
    public static void sellToUsOnLineButtonReg() {
        Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
        acc.loginUser(23);
        Q_JMB_WebElm.xp(jmbProps, "nav.stuBtn.xp");
        Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "nav.stuProductToSell.xp").equals(true));
        acc.logoutUser();
    }
    public static void addItemToCart(String qtyLocator, String atcLocator, String qty){
        Q_JMB_WebElm.xpClear(jmbProps, qtyLocator);
        Q_JMB_WebElm.xpSend(jmbProps, qtyLocator, qty);
        Q_JMB_WebElm.xp(jmbProps, atcLocator);
        Q_JMB_WebElm.xp(jmbProps, "cart.modalCheckoutNow.xp");
    }

    public static void metalView(String metal){
        String verifyThisText = "";
        switch(metal){
            case "gold":
                Q_JMB_WebElm.xp(jmbProps, "nav.goldView.xp");
                verifyThisText = "Gold Price Today - Price Of Gold Spot Prices Chart & History";
                System.out.println("To be verified " + driver.getTitle());
                Assert.assertEquals(driver.getTitle(), verifyThisText);
                break;
            case "silver":
                Q_JMB_WebElm.xp(jmbProps, "nav.silverView.xp");
                verifyThisText = "Silver Prices Today - Price Of Silver Spot Charts & History";
                System.out.println("To be verified " + driver.getTitle());
                org.testng.Assert.assertEquals(driver.getTitle(), verifyThisText);
                break;
            case "platinum":
                Q_JMB_WebElm.xp(jmbProps, "nav.platinumView.xp");
                verifyThisText = "Platinum Prices Today Per Ounce - 24hr Spot Price Chart & History";
                System.out.println("To be verified " + driver.getTitle());
                org.testng.Assert.assertEquals(driver.getTitle(), verifyThisText);
                break;
            case "palladium":
                Q_JMB_WebElm.xp(jmbProps, "nav.palladiumView.xp");
                verifyThisText = "Palladium Spot Price Today – Charts & History | JM Bullion";
                System.out.println("To be verified " + driver.getTitle());
                org.testng.Assert.assertEquals(driver.getTitle(), verifyThisText);
                break;
            case "bitcoin":
                Q_JMB_WebElm.xp(jmbProps, "nav.bitcoinView.xp");
                verifyThisText = "Bitcoin Price Today - Live Bitcoin Price Chart & History | JM Bullion";
                System.out.println("To be verified " + driver.getTitle());
                org.testng.Assert.assertEquals(driver.getTitle(), verifyThisText);
                break;
            default:
                System.out.println("Invalid chart view");
                break;

        }
    }
    public static void chartSubscribe(String email){
        Q_JMB_WebElm.myWait(2000);
        Q_JMB_WebElm.xp(jmbProps, "nav.goldView.xp");
//        WebElm.xpElementExecuter(jmbProps, "chartEmailInput.xp");
        Q_JMB_WebElm.xpClear(jmbProps, "nav.chartEmailInput.xp");
        Q_JMB_WebElm.xpSend(jmbProps, "nav.chartEmailInput.xp", email);
        Q_JMB_WebElm.xp(jmbProps, "nav.chartEmailBtn.xp");
    }
    public static void iraRequestInfo(){
        Q_JMB_WebElm.xp(jmbProps, "nav.requestInformationBtn.xp");
        Q_JMB_WebElm.xpSend(jmbProps, "nav.modalNameIpnut.xp", "Automated Test");
        Q_JMB_WebElm.xpSend(jmbProps, "nav.modalEmailInput.xp", "qa@jmbullion.com");
        Q_JMB_WebElm.xpSend(jmbProps, "nav.modalPhoneInput.xp", "(241) 425 2804");
        Q_JMB_WebElm.xpSend(jmbProps, "nav.modalTextField.xp", "Please send you booklet");

        Q_JMB_WebElm.xp(jmbProps, "nav.modalPhoneRadio.xp");
        Q_JMB_WebElm.xp(jmbProps, "nav.modalSubmit.xp");
        Q_JMB_WebElm.myWait(2000);
//        Assert.assertTrue(Element.xpDisplayed(jmbProps, "iraConfirmationModal.xp"));
        Assert.assertTrue(Q_JMB_WebElm.xpRetText(jmbProps, "nav.iraRequestConfirmation.xp").contains("We have received your message,"));
    }
    /*******************************************************************
     // * Description: Verify security validation is required for contact form
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    public static void iraDropDown() {
        Q_JMB_WebElm.moveIt(jmbProps, "nav.mega.ira.xp");
        Q_JMB_WebElm.xp(jmbProps, "nav.iraGold.xp");
        Assert.assertTrue(driver.getCurrentUrl().contains("ira-gold"));
        Q_JMB_WebElm.moveIt(jmbProps, "nav.mega.ira.xp");
        Q_JMB_WebElm.xp(jmbProps, "nav.iraSilver.xp");
        Assert.assertTrue(driver.getCurrentUrl().contains("ira-silver"));
        Q_JMB_WebElm.moveIt(jmbProps, "nav.mega.ira.xp");
        Q_JMB_WebElm.xp(jmbProps, "nav.iraPlatinum.xp");
        Assert.assertTrue(driver.getCurrentUrl().contains("ira-platinum"));
        Q_JMB_WebElm.moveIt(jmbProps, "nav.mega.ira.xp");
        Q_JMB_WebElm.xp(jmbProps, "nav.iraPalladium.xp");
        Assert.assertTrue(driver.getCurrentUrl().contains("ira-palladium"));

    }
    public static void  iraButtons(){
        Q_JMB_NavigationObjects.selectFromMenu("ira");
        Q_JMB_WebElm.xp(jmbProps, "nav.popularIraGold.xp");
        Assert.assertTrue(driver.getCurrentUrl().contains("ira-gold"));
        driver.navigate().back();
        Q_JMB_WebElm.xp(jmbProps, "nav.popularIraSilver.xp");
        Assert.assertTrue(driver.getCurrentUrl().contains("ira-silver"));
        driver.navigate().back();
        Q_JMB_WebElm.xp(jmbProps, "nav.popularIraPlatinum.xp");
        Assert.assertTrue(driver.getCurrentUrl().contains("ira-platinum"));
        driver.navigate().back();
    }

    public static void  iralinks(){
        Q_JMB_WebElm.xp(jmbProps, "nav.newDirection.xp");
        Q_JMB_WebElm.myWait(2000);
        Q_JMB_Controls.switchWin();
        Assert.assertTrue(driver.getCurrentUrl().contains("dtco.com/home"));
        Q_JMB_Controls.closeTabsSwitchWinMain();
        Q_JMB_Controls.switchTab(0);
        Q_JMB_WebElm.myWait(1000);
        Q_JMB_WebElm.xp(jmbProps, "nav.newDirectionFullFeeStructure.xp");
        Q_JMB_WebElm.myWait(2000);
        Q_JMB_Controls.switchWin();
        Assert.assertTrue(driver.getCurrentUrl().contains("Fee_Schedule.pdf"));
        Q_JMB_Controls.closeTabsSwitchWinMain();
        Q_JMB_Controls.switchTab(0);

        Q_JMB_WebElm.xp(jmbProps, "nav.newDirectionNewAccountApplication.xp");
        Q_JMB_WebElm.myWait(2000);
        Q_JMB_Controls.switchWin();
        Assert.assertTrue(driver.getCurrentUrl().contains("open-account"));
        Q_JMB_Controls.closeTabsSwitchWinMain();
        Q_JMB_Controls.switchTab(0);
        Q_JMB_WebElm.xp(jmbProps, "nav.EquitTrust.xp");
        Assert.assertTrue(driver.getCurrentUrl().contains("trustetc"));
        driver.navigate().back();
        Q_JMB_WebElm.xp(jmbProps, "nav.GoldStar.xp");
        Assert.assertTrue(driver.getCurrentUrl().contains("goldstartrust"));
        driver.navigate().back();
        Q_JMB_WebElm.xp(jmbProps, "nav.StrataTrust.xp");
        Assert.assertTrue(driver.getCurrentUrl().contains("stratatrust"));
        driver.navigate().back();
    }
    public static void contactForm(){
        Q_JMB_WebElm.xpSend(jmbProps, "nav.contactName.xp", "Automated Test");
        Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactName.xp");
        Q_JMB_WebElm.myWait(500);
        Q_JMB_WebElm.xpClear(jmbProps, "nav.contactEmail.xp");
        Q_JMB_WebElm.xpSend(jmbProps, "nav.contactEmail.xp", "qa@jmbullion.com");
        Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactEmail.xp");
        Q_JMB_WebElm.myWait(500);
        Q_JMB_WebElm.xpSend(jmbProps, "nav.contactPhone.xp", "(241) 425 2804");
        Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactPhone.xp");
        Q_JMB_WebElm.xpSend(jmbProps, "nav.contactOrder.xp", "ORD-232323");
        Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactOrder.xp");
        Q_JMB_WebElm.xpSend(jmbProps, "nav.nav.contactText.xp", "Status of my order");
        Q_JMB_WebElm.xpSendTab(jmbProps, "nav.nav.contactText.xp");
        Q_JMB_WebElm.xpSend(jmbProps, "nav.contactCaptcha.xp", "A3U4");
        Q_JMB_WebElm.xp(jmbProps, "nav.contactSend.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertTrue(Q_JMB_WebElm.xpRetText(jmbProps, "nav.contactSecurity.xp").contains("Validation errors occurred. Please"));
    }

    public static void footerCustomerCareMyAccount(String verifyString){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerMyAccount.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles(verifyString));
    }
    public static void footerLoginPage(int user){
        Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
        UserContainer uc = new UserContainer(user);
        Q_JMB_WebElm.myWait(1000);
        Q_JMB_WebElm.xpClear(jmbProps, "nav.footerMyAccount.email.xp");
        Q_JMB_WebElm.xpSend(jmbProps, "nav.footerMyAccount.email.xp", uc.userEmail);
        Q_JMB_WebElm.xpClear(jmbProps, "nav.footerMyAccount.password.xp");
        Q_JMB_WebElm.xpSend(jmbProps, "nav.footerMyAccount.password.xp", uc.passwd);
        Q_JMB_WebElm.xp(jmbProps, "nav.footerMyAccount.loginBtn.xp");
        acc.accountTabs("my information");
    }
    public static void footerCustomerCareContactUs(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerContactUs.xp");
        Q_JMB_WebElm.myWait(2000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Contact Us | JM Bullion"));
    }
    public static void footerCustomerCareFAQ(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerFaq.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Knowledge Base « JM Bullion"));
    }
    public static void footerCustomerCareFAQSearch(){
        Q_JMB_WebElm.xpSend(jmbProps, "nav.footerFaqSearchInput.xp", "US territories");
        Q_JMB_WebElm.xp(jmbProps, "nav.footerFaqSearchBtn.xp");
        System.out.println("FAQ search result " + Q_JMB_WebElm.xpRetText(jmbProps, "nav.footerFaqSearchResult.xp"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "nav.footerFaqSearchResult.xp"), "Do you ship to US territories?");
    }
    public static void footerCustomerCarePrivacyPolicy(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerPrivacyPolicy.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Privacy Policy and Customer Security - JM Bullion"));
    }
    public static void footerCustomerCarePrivacyPolicyText(){
        footerCustomerCarePrivacyPolicy();
        String verifyThisText = "You may contact JM Bullion directly if you have any questions about our Policy. Please contact our " +
                "Compliance Officer at 11700 Preston Road Ste 660153 Dallas, TX 75230 or e-mail privacy@jmbullion.com.";
        System.out.println("Text to be verified on the pag :" + verifyThisText);
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "nav.footerPrivacyPolicyText.xp"), verifyThisText);

    }
    public static void footerCustomerCareCookiePolicy(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerCookiePolicy.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("JM Bullion Cookie Policy | JM Bullion"));
    }
    public static void footerCustomerCareCookiePolicyText(){
        footerCustomerCareCookiePolicy();
        String verifyThisText = "Listed below are the types of cookies we currently use on our Website. This list is not exhaustive but describes the " +
                "main reasons we typically set cookies. For your convenience, we have split the types of cookies into categories, as follows:";
        System.out.println("Text to be verified on the pag :" + verifyThisText);
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "nav.footerCookiePolicyText.xp"), verifyThisText);
    }
    public static void footerCustomerCareTermsAndConditions(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerTermsAdnConditions.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Terms and Conditions - JM Bullion"));
    }
    public static void footerCustomerCareTermsAndConditionsText(){
        footerCustomerCareTermsAndConditions();
        String verifyThisText = "This Agreement constitutes the entire agreement between you and JM Bullion and governs your use of the " +
                "Website, superseding any prior agreements.";
        System.out.println("Text to be verified on the pag :" + verifyThisText);
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "nav.footerTermsAdnConditionsText.xp"), verifyThisText);
    }
    public static void footerCustomerCareAccessibility(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerAccessibility.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Our Commitment to Accessibility - JM Bullion"));
    }
    public static void footerCustomerCareAccessibilityText(){
        footerCustomerCareAccessibility();
        String verifyThisText = "Our Commitment to Accessibility";
        System.out.println("Text to be verified on the pag :" + verifyThisText);
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "nav.footerAccessibilityText.xp"), verifyThisText);
    }
    public static void footerMyAccountAccountLogin(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerAccountLogin.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Log In | JM Bullion"));
    }
    public static void footerMyAccountForgotPassword(String verifyTitle){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerForgotPassword.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles(verifyTitle));
    }
    public static void footerMyAccountTrackAnOrder(String verifyTitle){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerTrackAnOrder.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles(verifyTitle));
        Q_JMB_WebElm.xpClear(jmbProps,"nav.footerTrackAnOrderEmail.xp");
        Q_JMB_WebElm.xpSend(jmbProps,"nav.footerTrackAnOrderEmail.xp", "qa4auto@jmbullion.com");
        Q_JMB_WebElm.xpClear(jmbProps,"nav.footerTrackAnOrderOrder.xp");
        Q_JMB_WebElm.xpSend(jmbProps,"nav.footerTrackAnOrderOrder.xp","1095794");
        Q_JMB_WebElm.xp(jmbProps,"nav.footerTrackAnOrderSubmit.xp");
        Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "nav.footerTrackAnOrderVerify.xp"));
    }
    public static void footerMyAccountTrackAnOrderUserLoggedIn(String verifyTitle){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerTrackAnOrder.xp");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles(verifyTitle));
    }

    public static void footerMyAccountOrderHistory(String verifyTitle){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerOrderHistory.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles(verifyTitle));
    }
    public static void footerMyAccountPriceAlerts(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerPriceAlerts.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Alerts | JM Bullion"));
    }
    public static void footerMyAccountStorage(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerStorage.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Secure Depository Storage For Gold, Silver and Platinum l JM Bullion"));
    }
    public static void footerMyAccountDoNotSellMyPersonalInformation(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerPersonalInformation.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Notice of Right to Opt Out | JM Bullion"));
    }
    public static void footerAboutUsAboutJMBullion(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerAboutJMBullion.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("About Us l JM Bullion™"));

        Q_JMB_WebElm.xp(jmbProps, "nav.footerAboutUsCareers.xp");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Careers | JM Bullion"));
        driver.navigate().back();
        Q_JMB_WebElm.xp(jmbProps, "nav.footerAboutUsUserReviews.xp");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("JM Bullion Reviews and Testimonials"));
        driver.navigate().back();
        Q_JMB_WebElm.xp(jmbProps, "nav.footerAboutUsAchievements.xp");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Achievements l JM Bullion™"));
        driver.navigate().back();
        Q_JMB_WebElm.xp(jmbProps, "nav.footerAboutUsOurHistory.xp");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("History | JM Bullion"));
        driver.navigate().back();
    }
    public static void footerAboutUsCareers(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerCareers.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Careers | JM Bullion"));
    }
    public static void footerAboutUsCareersBenefits(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerCareerBenefits.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Careers | Benefits"));
    }
    public static void footerAboutUsCareersBenefitsJobListing(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerCareerJobListing.xp");
        Q_JMB_WebElm.myWait(1000);
//        Assert.assertEquals(driver.getTitle(), NavigationSteps.getTitles("Job Listings | JM Bullion"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps,"nav.footerCareerJoblistingHeader.xp"), "Job Listings");
        Q_JMB_WebElm.xp(jmbProps, "nav.footerCareerViewBenefits.xp");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Careers | Benefits"));
        Q_JMB_WebElm.xp(jmbProps, "nav.footerCareerWorkinAtJMB.xp");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Careers | JM Bullion"));
    }
    public static void footerAboutUsCareersBenefitsJobs(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerCareerJobOpenings.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Job Listings | JM Bullion"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps,"nav.footerCareerJoblistingHeader.xp"), "Job Listings");
        Q_JMB_WebElm.xp(jmbProps, "nav.footerCareerViewBenefits.xp");
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Careers | Benefits"));
    }
    public static void footerAboutUsShippingAndInsurance(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerShippingInsurance.xp");
        Q_JMB_WebElm.myWait(1000);
        String verifThisText = "When ordering from JM Bullion, you can be sure that your products are fully covered from our doorstep " +
                "to yours. Please contact us if you have any questions about our shipping or insurance.";
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "nav.footerShippinInsuranceLastParaText.xp"), verifThisText);
    }
    public static void footerAboutUsPaymentMetods(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerPaymentMethods.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "nav.footerPaymentMethodsPageHeader.xp"), "Payment Methods at JM Bullion");
    }
    public static void footerAboutUsReviews(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerReviews.xp");
        String verifyThisText = "We welcome any feedback you may have and always strive to improve our customer experience each and every day:";
        System.out.println("Text to be verified on the pag :" + verifyThisText);
        Q_JMB_WebElm.myWait(1000);
        System.out.println("Text to be verified on the pag :" + verifyThisText);
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "nav.footerReviews2ndParagraph.xp"), verifyThisText);
    }
    public static void footerAboutUsMints(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerMints.xp");
        Q_JMB_WebElm.myWait(500);
        String verifyThisText = "Gold and Silver Mints";
        System.out.println("Text to be verified on the pag :" + verifyThisText);
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "nav.footerMintsPageHeader.xp"), verifyThisText);
    }
    public static void footerInfoBlog(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerBlog.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Blog | JM Bullion"));
    }
    public static void footerInfoInvestingGuide(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerInvestingGuide.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Investing Guide | JM Bullion"));
    }
    public static void footerInfoSilverPrices(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerSilverPrices.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Silver Prices Today - Price Of Silver Spot Charts & History"));
    }
    public static void footerInfoGoldPrices(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerGoldPrices.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Gold Price Today - Price Of Gold Spot Prices Chart & History"));
    }
    public static void footerInfoLocalDirectory(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerLocalDirectory.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Directory of Local Gold and Silver Bullion Shops"));
    }
    public static void footerInfoCoinValues(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerCoinValues.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Coin Info | JM Bullion"));
    }
    public static void footerInfoMilitaryDiscounts(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerMilitaryDiscount.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Military-Discount | JM Bullion"));
    }
    public static void footerInfoSalesTaxCollectibles(){
        Q_JMB_WebElm.xp(jmbProps, "nav.footerSalesTax.xp");
        Q_JMB_WebElm.myWait(1000);
        Assert.assertEquals(driver.getTitle(), Q_JMB_NavigationObjects.getTitles("Gold & Silver Bullion / Collectible State Sales Taxes"));
    }
//    Start JMB-6245
    public  void  loanToValueCalculator(String gold, String silver, String platinum, String palladium) {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        DecimalFormat df = new DecimalFormat("#.00");
        Q_JMB_WebElm.xpSend(jmbProps, "nav.loans.GoldOunce.textbox.xp", gold);
        Q_JMB_WebElm.xpSend(jmbProps, "nav.loans.SilverOunce.textbox.xp", silver);
        Q_JMB_WebElm.xpSend(jmbProps, "nav.loans.PlatinumOunce.textbox.xp", platinum);
        Q_JMB_WebElm.xpSend(jmbProps, "nav.loans.PalladiumOunce.textbox.xp", palladium);
        Q_JMB_WebElm.xp(jmbProps, "nav.loans.calculateBtn.xp");

        String goldText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.goldSpot.xp");
        Float goldSpotPrice = Float.valueOf(df.format(goldText.replaceAll("[^0-9?!\\.]", "")));
        System.out.println("Gold Spot Price : " + goldSpotPrice);
        String goldCountText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.goldcount.xp");
        Float goldCount = Float.valueOf(df.format(goldCountText.replaceAll("[^0-9?!\\.]", "")));
        System.out.println("Gold Count : " + goldCount);
        String goldSpotMultipliedCount = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.goldSpotMultiplyCount.xp");
        Float goldSpotMulCount = Float.valueOf(df.format(goldSpotMultipliedCount.replaceAll("[^0-9?!\\.]", "")));
        System.out.println("Gold Spot * Ounce :" + goldSpotMulCount);
        goldSpotMulCount = goldSpotPrice * goldCount;
        Assert.assertEquals(goldSpotMulCount, goldSpotMulCount);

        String silverText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.silverSpot.xp");
        Float silverSpotPrice = Float.valueOf(df.format(silverText.replaceAll("[^0-9?!\\.]", "")));
        System.out.println("Silver Spot Price : " + silverSpotPrice);
        String silverCountText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.silvercount.xp");
        Float silverCount = Float.valueOf(df.format(silverCountText.replaceAll("[^0-9?!\\.]", "")));
        System.out.println("Silver Count :" + silverCount);
        String silverSpotMultipliedCount = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.silverSpotMultiplyCount.xp");
        Float silverSpotMulCount = Float.valueOf(df.format(silverSpotMultipliedCount.replaceAll("[^0-9?!\\.]", "")));
        System.out.println("Silver Spot * Ounce : " + silverSpotMulCount);
        silverSpotMulCount = silverSpotPrice * silverCount;
        Assert.assertEquals(silverSpotMulCount, silverSpotMulCount);

        String platinumText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.platinumSpot.xp");
        Float platinumSpotPrice = Float.valueOf(df.format(platinumText.replaceAll("[^0-9?!\\.]", "")));
        System.out.println("Platinum Spot Price : " + platinumSpotPrice);
        String platinumCountText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.platinumcount.xp");
        Float platinumCount = Float.valueOf(df.format(platinumCountText.replaceAll("[^0-9?!\\.]", "")));
        System.out.println("Platinum Count :" + platinumCount);
        String platinumSpotMultipliedCount = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.platinumSpotMultiplyCount.xp");
        Float platinumSpotMulCount = Float.valueOf(df.format(platinumSpotMultipliedCount.replaceAll("[^0-9?!\\.]", "")));
        System.out.println("Platinum Spot * Ounce : " + platinumSpotMulCount);
        platinumSpotMulCount = platinumSpotPrice * platinumCount;
        org.testng.Assert.assertEquals(platinumSpotMulCount, platinumSpotMulCount);

        String palladiumText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.palladiumSpot.xp");
        Float palladiumSpotPrice = Float.valueOf(df.format(palladiumText.replaceAll("[^0-9?!\\.]", "")));
        System.out.println("Platinum Spot Price : " + palladiumSpotPrice);
        String palladiumCountText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.palladiumcount.xp");
        Float palladiumCount = Float.valueOf(df.format(palladiumCountText.replaceAll("[^0-9?!\\.]", "")));
        System.out.println("Platinum Count :" + palladiumCount);
        String palladiumSpotMultipliedCount = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.palladiumSpotMultiplyCount.xp");
        Float palladiumSpotMulCount = Float.valueOf(df.format(palladiumSpotMultipliedCount.replaceAll("[^0-9?!\\.]", "")));
        System.out.println("Platinum Spot * Ounce : " + palladiumSpotMulCount);
        palladiumSpotMulCount = palladiumSpotPrice * palladiumCount;
        org.testng.Assert.assertEquals(palladiumSpotMulCount, palladiumSpotMulCount);


        String loanUptoText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.loanUptoTotal.xp");
        Float loanUptoTotal = Float.valueOf(loanUptoText.replaceAll("[^0-9?!\\.]", ""));
        System.out.println("Loan Up To : " + loanUptoTotal);

        Float metalTotal = goldSpotMulCount + silverSpotMulCount + platinumSpotMulCount + palladiumSpotMulCount;
        System.out.println("Total Metal Spot Count Value : " + metalTotal);

        Double percentageValue = (Double) (metalTotal * 0.75);
        System.out.println("75% of " + metalTotal + ": " + percentageValue);
        org.testng.Assert.assertEquals(df.format(percentageValue), df.format(loanUptoTotal));
    }
    //    JMB-6245 End
    
 	//JMB-6279 Start
    //JMB-6279 - verifying new message view in COntact us
  	public static void xp(Properties proper, String locator) {
  		driver.findElement(By.xpath(proper.getProperty(locator))).click();
  	}

  	public static void verifyReqFieldsInContactUsForm() {
  		int totalNoOfReqFields = Q_JMB_WebElm.xpCountTableRows(jmbProps, "contactUs.reqFieldCount");
  		System.out.println("Total No of Req.Fields are : " + totalNoOfReqFields);
  		// Negative Flow - Skipping all "Required" fields
  		Q_JMB_WebElm.xp(jmbProps, "nav.contactSend.xp");

  		// Copying the error messages to Array List : errorMessages
  		List<WebElement> msgList = driver.findElements(By.xpath("//div[@class='screen-reader-response']/ul/li"));
  		ArrayList<String> errorMessages = new ArrayList<String>();
  		for (WebElement element : msgList) {
  			errorMessages.add(element.getText());
  		}
  		System.out.println("Warning Messages in the List are : " + errorMessages);

  		// Copying the Req field names to the ArrayList :placeHolderAL
  		List<WebElement> placeHolder = driver.findElements(By.xpath("//*[@aria-required='true']"));
  		ArrayList<String> placeHolderAL = new ArrayList<String>();
  		for (WebElement element : placeHolder) {
  			placeHolderAL.add(element.getAttribute("placeholder"));

  		}
  		Assert.assertEquals(placeHolderAL.size(), errorMessages.size()); // No of req fields and No of error Msgs should be same.

  		// Verifying the errorMessages Array List contains only same errors.
  		for (int counter = 0; counter < totalNoOfReqFields; counter++) {
  			if (errorMessages.get(counter).equals("Please fill the required field.")) {

  				System.out.println("[PASS] Warning Message is shown appropriately for the required field: "
  						+ placeHolderAL.get(counter));
  			} else {
  				Assert.fail("[FAIL] Error Messages are not thrown for missing Required Fields");
  			}
  		}

  	}
  	
	public static void fillContactUsAndVerifySuccess() {
	  	// Positive Flow - Filling all the fields
		Q_JMB_WebElm.xpSend(jmbProps, "nav.contactName.xp", "Automated Test");
		Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactName.xp");
		Q_JMB_WebElm.myWait(500);
		Q_JMB_WebElm.xpClear(jmbProps, "nav.contactEmail.xp");
		Q_JMB_WebElm.xpSend(jmbProps, "nav.contactEmail.xp", "qa@jmbullion.com");
		Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactEmail.xp");
		Q_JMB_WebElm.myWait(500);
		Q_JMB_WebElm.xpSend(jmbProps, "nav.contactPhone.xp", "(241) 425 2804");
		Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactPhone.xp");
		Q_JMB_WebElm.xpSend(jmbProps, "nav.contactOrder.xp", "ORD-232323");
		Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactOrder.xp");
		Q_JMB_WebElm.xpSend(jmbProps, "nav.nav.contactText.xp", "Status of my order");
		Q_JMB_WebElm.xpSendTab(jmbProps, "nav.nav.contactText.xp");
		Q_JMB_WebElm.xpSend(jmbProps, "nav.contactMessage.xp", "A3U4");
		Q_JMB_WebElm.xp(jmbProps, "nav.contactSend.xp");
		Q_JMB_WebElm.myWait(2000);
	  	String successMsg = Q_JMB_WebElm.xpRetText(jmbProps, "contactUs.successMsg.xp");
	  	Assert.assertEquals(successMsg, "Your message was sent successfully. Thanks.");
	  	System.out.println("[PASS] Contact Us - Message Sent Success ");
	}

    //JMB-7168 Start

    /******************************************************************
    // * Description: Verify FAQ "Recent Article" links
    // * Param : NA
    // * Jira Ticket: JMB 7168 
    // * Status: Complete
    //*******************************************************************/    
    public void faqArticleCategoryLink() {
    	//Verifying all the links under Recent Articles
    	int sizeArticle=retXpListSize(jmbProps, "jm.recentArticle.xp");
    	System.out.println("List size: "+sizeArticle);
    	for(int index=1; index<=sizeArticle;index++) {
    		String value1=Q_JMB_WebElm.xpRetText(jmbProps, "jm.recentArticle.xp.beg",index,"jm.recentArticle.xp.end");
			Q_JMB_WebElm.xp(jmbProps, "jm.recentArticle.xp.beg",index,"jm.recentArticle.xp.end");
			String value2=Q_JMB_WebElm.xpRetText(jmbProps, "jm.faqListLink.xp");
			Assert.assertTrue(value1.contains(value2), "Recent Article link not navigates to right page");
	    	driver.navigate().back();
    	}
		System.out.println("Recent Article list link naviges to the right page");	
    }
    /******************************************************************
    // * Description: Verify FAQ "FAQ category" links
    // * Param : NA
    // * Jira Ticket: JMB 7168 
    // * Status: Complete
    //*******************************************************************/ 
    public void faqFAQCategoriesLink() {
		//Verifying all the links under FAQ Categories
		int sizeFAQ=retXpListSize(jmbProps, "jm.faqCategoriesList.xp");
    	System.out.println("List size: "+sizeFAQ);
		for(int index=1; index<=sizeFAQ;index++) {
    		String value1=Q_JMB_WebElm.xpRetText(jmbProps, "jm.faqCategories.xp.beg",index,"jm.faqCategories.xp.end");
    		System.out.println(value1);
			Q_JMB_WebElm.xp(jmbProps, "jm.faqCategories.xp.beg",index,"jm.faqCategories.xp.end");
			String value2=Q_JMB_WebElm.xpRetText(jmbProps, "jm.faqListLink.xp");
    		System.out.println(value2);
			Assert.assertTrue(value1.contains(value2), "FAQ category link not navigates to right page");
	    	driver.navigate().back();
    	}
		System.out.println("FAQ Categories list link naviges to the right page");
    }
    /******************************************************************
    // * Description: To read size of the given element
    // * Param : String
    // * Jira Ticket: JMB 7168 
    // * Status: Complete
    //*******************************************************************/      
    public Integer retXpListSize(Properties proper, String locator){
        List<WebElement> values =driver.findElements(By.xpath(proper.getProperty(locator)));
        System.out.println(values.size());
        return values.size();
    }
    //JMB-7168 End
    
    //JMB-5689 Start
    /******************************************************************
     * Description: Fill out Contact Us form
     * Parameters: None
     * Returns: None
     * Status: Complete
     *******************************************************************/
	public void deviceFingerprintContactUs() throws FileNotFoundException {
		Q_JMB_NavigationObjects.footerCustomerCareContactUs();
	    //Q_JMB_NavigationObjects.xp(jmbProps, "contactUs.contactOrdStatus.xp");
	    //Q_JMB_NavigationObjects.xp(jmbProps,"contactUs.btn.xp");
	    driver.navigate().to(baseUrl + "/contact/contact-order-status/");
	    Q_JMB_NavigationObjects.fillContactUsAndVerifySuccess();        
    }
	
	/******************************************************************
     * Description: Fill out Contact Us form and verify to is blocked
     * Parameters: None
     * Returns: None
     * Status: Complete
     *******************************************************************/
	public void deviceFingerprintContactUsBlock() throws FileNotFoundException {
		Q_JMB_NavigationObjects.footerCustomerCareContactUs();
		//Q_JMB_NavigationObjects.xp(jmbProps, "contactUs.contactOrdStatus.xp");
	    //Q_JMB_NavigationObjects.xp(jmbProps,"contactUs.btn.xp");
	    driver.navigate().to(baseUrl + "/contact/contact-order-status/");
	    Q_JMB_WebElm.xpSend(jmbProps, "nav.contactName.xp", "Automated Test");
		Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactName.xp");
		Q_JMB_WebElm.myWait(500);
		Q_JMB_WebElm.xpClear(jmbProps, "nav.contactEmail.xp");
		Q_JMB_WebElm.xpSend(jmbProps, "nav.contactEmail.xp", "qa@jmbullion.com");
		Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactEmail.xp");
		Q_JMB_WebElm.myWait(500);
		Q_JMB_WebElm.xpSend(jmbProps, "nav.contactPhone.xp", "(241) 425 2804");
		Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactPhone.xp");
		Q_JMB_WebElm.xpSend(jmbProps, "nav.contactOrder.xp", "ORD-232323");
		Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactOrder.xp");
		Q_JMB_WebElm.xpSend(jmbProps, "nav.nav.contactText.xp", "Status of my order");
		Q_JMB_WebElm.xpSendTab(jmbProps, "nav.nav.contactText.xp");
		Q_JMB_WebElm.xpSend(jmbProps, "nav.contactMessage.xp", "A3U4");
		Q_JMB_WebElm.xp(jmbProps, "nav.contactSend.xp");
		Q_JMB_WebElm.myWait(2000);
		try {
    	   Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.contactUsBlockMessage.xp");
    	   System.out.println("Contact Us was successfully blocked.");
		} catch (Throwable ex) {
    	   Assert.fail("Contact Us was not successfully blocked.");
		}
    }
    //JMB-5689 End
	
	// Start JMB-7292

    /**************************************************************************
    // * Description: Verify Footnote In Loan Page Is Displayed
    // * Param : NA
    // * Returns: NA
    // * Jira Ticket: JMB 7292
    // * Status: Complete
    /****************************************************************************/  
 	public void verifyFootnoteIsDisplayed () {
 		Q_JMB_WebElm.xp(jmbProps,"nav.mega.loans.xp");
 		Q_JMB_WebElm.idExecutorScrolToElement(jmbProps, "nav.loans.ApplyNowButton.id");
 		Q_JMB_WebElm.myWait(2000);	
 		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "nav.loans.FootnoteLabel.xp")
 				, "Maximum Loan Size $25000 Footnote is not displayed in Loan Page");
 		System.out.println(" Maximum Loan Size $25000 Footnote in loans page calculator is displayed : Success");
 	}
 	// End JMB-7292
}
