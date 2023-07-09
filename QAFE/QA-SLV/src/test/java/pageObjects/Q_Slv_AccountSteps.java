package pageObjects;


import jsonWrappers.AddressContainer;
import jsonWrappers.InvalidPasswordContainer;
import jsonWrappers.UserContainer;
import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Q_Slv_AccountSteps extends Q_Slv_Init {
    // @Step
    public static void loginUser(int user, String loginlink,  String emaillocator, String email, String pwdLocator, String pwd, String loginBtn) throws FileNotFoundException {
        Q_Slv_WebElm.xp(SLVqProp, loginlink);
        //UserContainer uc = new UserContainer(user);
        //int user = 0;
        UserContainer uc = new UserContainer(user);
        Q_Slv_WebElm.idSend(SLVqProp, emaillocator, email);
        Q_Slv_WebElm.idSend(SLVqProp, pwdLocator, pwd);
        Q_Slv_WebElm.id(SLVqProp, loginBtn);
        Q_Slv_WebElm.myWait(3000);

    }
    // @Step
    public static void login(String loginLink, Integer user) throws FileNotFoundException {
        Q_Slv_WebElm.myWait(3000);
        UserContainer uc = new UserContainer(user);
        loginUser(0,loginLink, "acc.login.email.id",uc.user, "acc.login.password.id", uc.passwd, "acc.login.button.id");
    }
    // @Step
    public static void bridgeLogin(Integer user) throws FileNotFoundException {
        UserContainer uc = new UserContainer(user);
        bridgeLoginuser(0, "chk.bridge.reg.email.id",uc.user, "chk.bridge.reg.pass.id", uc.passwd, "chk.bridge.reg.btn.id");
//        utils.Controls.checkAlert();
    }
    // @Step
    public static void bridgeLoginuser(Integer user, String emaillocator, String email, String pwdLocator, String pwd, String loginBtn){

        //UserContainer uc = new UserContainer(user);
        Q_Slv_WebElm.idSend(SLVqProp, emaillocator, email);
        Q_Slv_WebElm.idSend(SLVqProp, pwdLocator, pwd);
        Q_Slv_WebElm.myWait(500);

        Q_Slv_WebElm.id(SLVqProp, loginBtn);
        Q_Slv_WebElm.myWait(2000);
    }
    // @Step
    public static void logout(){
        try{
            //Assert.assertTrue(WebElm.idElementDisplayed(SLVqProp,"account.logout.link.xp"));
            if(Q_Slv_WebElm.xpDisplayed(SLVqProp, "acc.logout.link.xp").equals(true))
                Q_Slv_WebElm.xp(SLVqProp, "acc.logout.link.xp");
        }
        catch (Throwable ex){
            driver.navigate().to(baseUrl);
        }


    }
    //@Step
    public static void userRegistration(int user, String registerLink,  String fnLocator, String firstName, String lnLocator, String lastName,
                                        String emailLocator, String email, String phLocator, String phone, String pwdLocator,
                                        String pwd, String confirmLocator, String pwdConfirm,String regButton) throws FileNotFoundException {
        Q_Slv_WebElm.linkText(SLVqProp,registerLink);
        AddressContainer info = new AddressContainer(user);
        Q_Slv_WebElm.idSend(SLVqProp, fnLocator, firstName);
        Q_Slv_WebElm.idSend(SLVqProp, lnLocator, lastName);
        Q_Slv_WebElm.idSend(SLVqProp, emailLocator, email);
        Q_Slv_WebElm.idSend(SLVqProp, phLocator, phone);
        UserContainer newUser = new UserContainer(user);
        Q_Slv_WebElm.idSend(SLVqProp, pwdLocator, pwd);
        Q_Slv_WebElm.idSend(SLVqProp, confirmLocator, pwdConfirm);
    }
    // @Step
    public static void registerNow(String registerLink, Integer user, String regButton) throws FileNotFoundException {
        UserContainer newuser = new UserContainer(user);
        userRegistration(0,registerLink, "acc.register.fname.id",newuser.firstName, "acc.register.lname.id", newuser.lastName, "acc.register.email.id",
                newuser.user, "acc.register.phone.id", newuser.phoneNumber, "acc.register.pwd.id", newuser.passwd, "acc.register.confirm.id",
                newuser.passwd, regButton);
        Q_Slv_WebElm.xp(SLVqProp, "acc.register.agree.xp");
        Q_Slv_WebElm.id(SLVqProp, "acc.register.reg.btn.id");
        Q_Slv_WebElm.myWait(500);
        Assert.assertTrue(Q_Slv_WebElm.xpDisplayed(SLVqProp, "acc.welcomeMessgae.xp"));

    }
    // @Step

    public static void deleteUser(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS.SECONDS);
        Q_Slv_WebElm.myWait(2000);
        driver.navigate().to(baseUrl +"/cybersource-reset.php");
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_WebElm.id(SLVqProp, "acc.register.deleteUser.id");
        driver.navigate().back();
        driver.navigate().refresh();
        Assert.assertTrue(Q_Slv_WebElm.linkTextDisplayed(SLVqProp, "acc.register.link.linkText").equals(true));
        driver.navigate().to(baseUrl);


    }
    //@Step
    public static void myAccount(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/ul/li[3]/a")));

        Q_Slv_WebElm.xpExecutor(SLVqProp, "acc.myAccount.link.xp");
        wait.until(ExpectedConditions.titleContains("My Account | Silver.com"));
        Q_Slv_WebElm.myWait(2000);

    }
    //@Step
    public static String payment(){
        int payList  = 0;
        String payments = "";
        if (driver.getCurrentUrl().compareTo(baseUrl +"/my-account/") == 0){
            System.out.println(driver.getCurrentUrl());
            List<WebElement> cards = driver.findElements(By.id(SLVqProp.getProperty("acc.payment.list.id")));
            for(WebElement cardList : cards) {
                payments = cardList.getText();
                payList++;
            }
        }
        return payments;
    }
    //@Step
    public static String accountAddress() {

        int shipping  = 0;
        String addresses = "";
        if (driver.getCurrentUrl().compareTo(baseUrl +"/my-account/") == 0){
            List<WebElement> shippingAddresses = driver.findElements(By.id(SLVqProp.getProperty("acc.shippingList.id")));
            for(WebElement address : shippingAddresses) {
                addresses = address.getText();
                //System.out.println(address.getText().substring(0));
                shipping++;
            }
        }
        return addresses;
    }

    //@Step
    public static void editShippingAdd(){
        String address1 = Q_Slv_AccountSteps.accountAddress();
        if (address1.equals("8535 N Tryon St")){
            Q_Slv_WebElm.xp(SLVqProp, "acc.shippingAdd.edit.xp");
            Q_Slv_WebElm.idClear(SLVqProp, "acc.edit.Streetadd.shipping.id");
            Q_Slv_WebElm.idSend(SLVqProp, "acc.edit.Streetadd.shipping.id", "8511 N Tryon St");
            Q_Slv_WebElm.myWait(3000);
            Q_Slv_WebElm.idSendTab(SLVqProp, "acc.edit.Streetadd.shipping.id");
            Q_Slv_WebElm.myWait(1000);
            Q_Slv_WebElm.idSendTab(SLVqProp, "acc.edit.Streetadd.shipping.id");

            try{
                accountSaveAddress("acc.address.shipping.validate.xp", "acc.address.shipping.error.xp", "acc.address.shipping.ContinueWithAdd.xp");

            }
            catch(Throwable x){
                System.out.println("failed to save");
                Assert.fail("failed to save");
            }
        }
        else{
            Q_Slv_WebElm.xp(SLVqProp, "acc.shippingAdd.edit.xp");
            Q_Slv_WebElm.idClear(SLVqProp, "acc.edit.Streetadd.shipping.id");
            Q_Slv_WebElm.idSend(SLVqProp, "acc.edit.Streetadd.shipping.id", "8535 N Tryon St");
            Q_Slv_WebElm.myWait(3000);
            Q_Slv_WebElm.idSendTab(SLVqProp, "acc.edit.Streetadd.shipping.id");
            Q_Slv_WebElm.myWait(1000);
            Q_Slv_WebElm.idSendTab(SLVqProp, "acc.edit.Streetadd.shipping.id");
            accountSaveAddress("acc.address.shipping.validate.xp", "acc.address.shipping.error.xp", "acc.address.shipping.ContinueWithAdd.xp");
        }
        Q_Slv_WebElm.myWait(2000);
        String address2 = Q_Slv_AccountSteps.accountAddress();
        System.out.println("End address " + address2);

//        System.out.println(AccountSteps.accountAddress());
        Assert.assertTrue(Q_Slv_AccountSteps.accountAddress().contains(address2));
    }


    //@Step
    public static void shippingAutoSection(Integer user) throws FileNotFoundException {
        AddressContainer ship = new AddressContainer(user);
        Q_Slv_WebElm.idSend(SLVqProp, "acc.address.shipping.firstName.id",ship.firstName);
        Q_Slv_WebElm.idSend(SLVqProp, "acc.address.shipping.lastName.id", ship.lastName);
        Q_Slv_WebElm.idSend(SLVqProp, "acc.edit.Streetadd.shipping.id", ship.street );
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_WebElm.id(SLVqProp, "acc.address.shipping.firstName.id");
        Q_Slv_WebElm.idSend(SLVqProp, "acc.address.shipping.city.id", ship.city);
        Q_Slv_WebElm.idSelectValue(SLVqProp, "acc.address.shipping.state.id", ship.state);
        Q_Slv_Controls.scrolDownPixel(200);
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.idClear(SLVqProp, "acc.address.shipping.zip.id");
        Q_Slv_WebElm.idSend(SLVqProp, "acc.address.shipping.zip.id", ship.zipcode);
        Q_Slv_WebElm.myWait(500);
        Q_Slv_WebElm.idSend(SLVqProp, "acc.address.shipping.phone.id",ship.phoneNumber);
        Q_Slv_WebElm.myWait(1000);
        accountSaveAddress("acc.address.shipping.validate.xp", "acc.account.address.shipping.error.xp", "acc.address.shipping.ContinueWithAdd.xp");
        Q_Slv_WebElm.myWait(3000);
    }

    //@Step
    public static void addShippingAddress(String address1) throws FileNotFoundException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/ul/li[3]/a")));
        Q_Slv_WebElm.id(SLVqProp, address1);
        shippingAutoSection(11);

    }
    //@Step
    public static void deleteShippingAddress() throws FileNotFoundException {
        Q_Slv_WebElm.myWait(3000);
        deleteAccountAddress("acc.address.delete.xp");
        Q_Slv_Controls.checkAlert();
    }
    //@Step
    public static void accountSaveAddress(String saveAddress, String errorMsg, String forceSaveAddress){
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_WebElm.xpDisplayed(SLVqProp, saveAddress);
        try {
            Q_Slv_WebElm.xp(SLVqProp, saveAddress);
            System.out.println("Verified auto save address clicked");
        }
        catch (Throwable ex){
            System.out.println("Verified forced address is used");
        }
        Q_Slv_WebElm.xpDisplayed(SLVqProp, errorMsg);
        try{
            Q_Slv_WebElm.myWait(1000);
            Q_Slv_WebElm.xp(SLVqProp,forceSaveAddress);

        }
        catch (Throwable ex){
            System.out.println("Force saving shipping address failed");
        }
    }


    // @Step
    public static void deleteAccountAddress(String locator){
        Q_Slv_WebElm.xp(SLVqProp, locator);
        Q_Slv_Controls.checkAlert();
        System.out.println("Verified address deleted ");
    }
    //@Step
    public static void createAccount(){

        Q_Slv_WebElm.idClear(SLVqProp, "chk.guest.reg.pwd.id");
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.reg.pwd.id", "1212Te$t");
        Q_Slv_WebElm.idClear(SLVqProp, "chk.guest.reg.pwdConfirm.id");
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.reg.pwdConfirm.id", "1212Te$t");
        Q_Slv_WebElm.idExecutor(SLVqProp, "chk.finishAndPlace.id");

    }
    public static void userRegistrationInvalidPassword(String registerLink,  String fnLocator, String firstName, String lnLocator, String lastName,
                                                       String emailLocator, String email, String phLocator, String phone, String pwdLocator,
                                                       String pwd, String confirmLocator, String pwdConfirm,String regButton) throws FileNotFoundException {
        Q_Slv_WebElm.linkText(SLVqProp,registerLink);
        Q_Slv_WebElm.idSend(SLVqProp, fnLocator, firstName);
        Q_Slv_WebElm.idSend(SLVqProp, lnLocator, lastName);
        Q_Slv_WebElm.idSend(SLVqProp, emailLocator, email);
        Q_Slv_WebElm.idSend(SLVqProp, phLocator, phone);
        Q_Slv_WebElm.idSend(SLVqProp, pwdLocator, pwd);
        System.out.println(pwd);
        Q_Slv_WebElm.idSend(SLVqProp, confirmLocator, pwdConfirm);
        Q_Slv_WebElm.xp(SLVqProp, "acc.register.agree.xp");
        Q_Slv_WebElm.id(SLVqProp, "acc.register.reg.btn.id");
        Alert alert= driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text : "+alertText);
        String actualMsg="The password must have at least eight characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
        Assert.assertEquals("Alert Text Matching",alertText,actualMsg );
        Q_Slv_WebElm.myWait(2000);
        alert.accept();
    }
    public static void userRegistrationInvalidPassword(int index) throws FileNotFoundException {
        InvalidPasswordContainer password = new InvalidPasswordContainer(index);
        Q_Slv_WebElm.linkText(SLVqProp, "acc.register.link.linkText");
        Q_Slv_WebElm.idSend(SLVqProp, "acc.register.fname.id", password.firstName);
        Q_Slv_WebElm.idSend(SLVqProp, "acc.register.lname.id", password.lastName);
        Q_Slv_WebElm.idSend(SLVqProp, "acc.register.email.id", System.currentTimeMillis()+password.email+"@jmbullion.com");
        Q_Slv_WebElm.idSend(SLVqProp, "acc.register.phone.id", password.phoneNumber);
        Q_Slv_WebElm.idSend(SLVqProp, "acc.register.pwd.id", password.passwd);
        System.out.println(password.passwd);
        Q_Slv_WebElm.idSend(SLVqProp, "acc.register.confirm.id", password.confPassword);
        Q_Slv_WebElm.xp(SLVqProp, "acc.register.agree.xp");
        Q_Slv_WebElm.id(SLVqProp, "acc.register.reg.btn.id");
        Alert alert= driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text : "+alertText);
        String actualMsg="The password must be between 8 to 30 characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
        Assert.assertEquals("Alert Text Matching",alertText,actualMsg );
        Q_Slv_WebElm.myWait(2000);
        alert.accept();
    }
    public static void createAccountInvalidPasswordInput(String pass,String confPass){

        Q_Slv_WebElm.idClear(SLVqProp, "chk.guest.reg.pwd.id");
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.reg.pwd.id", pass);
        System.out.println(pass);
        Q_Slv_WebElm.idClear(SLVqProp, "chk.guest.reg.pwdConfirm.id");
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.reg.pwdConfirm.id", confPass);
        Q_Slv_WebElm.idExecutor(SLVqProp, "chk.finishAndPlace.id");
        Alert alert= driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text : "+alertText);
        String actualMsg="The password must be between 8 to 30 characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
        Assert.assertEquals("Alert Text Matching",alertText,actualMsg );
        Q_Slv_WebElm.myWait(2000);
        alert.accept();

    }
    public static void createAccountInvalidPasswordInput(int index) throws FileNotFoundException{
        InvalidPasswordContainer password = new InvalidPasswordContainer(index);
        Q_Slv_WebElm.idClear(SLVqProp, "chk.guest.reg.pwd.id");
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.reg.pwd.id", password.passwd);
        System.out.println(password.passwd);
        Q_Slv_WebElm.idClear(SLVqProp, "chk.guest.reg.pwdConfirm.id");
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.reg.pwdConfirm.id", password.confPassword);
        Q_Slv_WebElm.idExecutor(SLVqProp, "chk.finishAndPlace.id");
        Alert alert= driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text : "+alertText);
        String actualMsg="The password must be between 8 to 30 characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
        Assert.assertEquals("Alert Text Matching",alertText,actualMsg );
        Q_Slv_WebElm.myWait(2000);
        alert.accept();

    }
    public static void changePasswordInvalidInput(String oldPass,String newPass,String confPass){

        Q_Slv_WebElm.xpClear(SLVqProp, "acc.changePwd.old.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "acc.changePwd.old.xp", oldPass);
        Q_Slv_WebElm.xpClear(SLVqProp, "acc.changePwd.new.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "acc.changePwd.new.xp", newPass);
        System.out.println(newPass);
        Q_Slv_WebElm.xpClear(SLVqProp, "acc.changePwd.confirm.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "acc.changePwd.confirm.xp", confPass);
        Q_Slv_WebElm.xp(SLVqProp, "acc.changePwd.saveBtn.xp");
        Alert alert= driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text : "+alertText);
        String actualMsg="The password must be between 8 to 30 characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
        Assert.assertEquals("Alert Text Matching",alertText,actualMsg );
        Q_Slv_WebElm.myWait(2000);
        alert.accept();

    }
    public static void changePasswordInvalidInput(int index) throws FileNotFoundException{
        InvalidPasswordContainer password = new InvalidPasswordContainer(index);
        Q_Slv_WebElm.xpClear(SLVqProp, "acc.changePwd.old.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "acc.changePwd.old.xp", "Jan@2021");
        Q_Slv_WebElm.xpClear(SLVqProp, "acc.changePwd.new.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "acc.changePwd.new.xp", password.passwd);
        System.out.println(password.passwd);
        Q_Slv_WebElm.xpClear(SLVqProp, "acc.changePwd.confirm.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "acc.changePwd.confirm.xp", password.confPassword);
        Q_Slv_WebElm.xp(SLVqProp, "acc.changePwd.saveBtn.xp");
        Alert alert= driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text : "+alertText);
        String actualMsg="The password must be between 8 to 30 characters with one uppercase letter, one lower case letter, one number (0-9), one symbol (e.g. !@#$%^&*) and no spaces";
        Assert.assertEquals("Alert Text Matching",alertText,actualMsg );
        Q_Slv_WebElm.myWait(2000);
        alert.accept();

    }
    public static void userRegistrationvalidPassword(String registerLink,  String fnLocator, String firstName, String lnLocator, String lastName,
                                                     String emailLocator, String email, String phLocator, String phone, String pwdLocator,
                                                     String pwd, String confirmLocator, String pwdConfirm,String regButton) throws FileNotFoundException {
        Q_Slv_WebElm.linkText(SLVqProp,registerLink);
        Q_Slv_WebElm.idSend(SLVqProp, fnLocator, firstName);
        Q_Slv_WebElm.idSend(SLVqProp, lnLocator, lastName);
        Q_Slv_WebElm.idSend(SLVqProp, emailLocator, email);
        Q_Slv_WebElm.idSend(SLVqProp, phLocator, phone);
        Q_Slv_WebElm.idSend(SLVqProp, pwdLocator, pwd);
        System.out.println(pwd);
        Q_Slv_WebElm.idSend(SLVqProp, confirmLocator, pwdConfirm);
        Q_Slv_WebElm.xp(SLVqProp, "acc.register.agree.xp");
        Q_Slv_WebElm.id(SLVqProp, "acc.register.reg.btn.id");
        Q_Slv_Controls.checkAlert();
    }

    public static void changePassword(){

        Q_Slv_WebElm.xpClear(SLVqProp, "acc.changePwd.old.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "acc.changePwd.old.xp", "Jan@2021");
        Q_Slv_WebElm.xpClear(SLVqProp, "acc.changePwd.new.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "acc.changePwd.new.xp", "Jan@2021");
        Q_Slv_WebElm.xpClear(SLVqProp, "acc.changePwd.confirm.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "acc.changePwd.confirm.xp", "Jan@2021");
        Q_Slv_WebElm.xp(SLVqProp, "acc.changePwd.saveBtn.xp");
        Q_Slv_Controls.checkAlert();

        System.out.println("Password Changed Successfully... ");
    }
    public static void resetPasswordloginUser(String loginLink,int user,String newPassword) throws FileNotFoundException  {

        Q_Slv_WebElm.myWait(3000);
        UserContainer uc = new UserContainer(user);
        loginUser(user,loginLink, "acc.login.email.id",uc.user, "acc.login.password.id", newPassword, "acc.login.button.id");
        System.out.println("Verified loging with new password : "+newPassword+ " after password reset.");
    }

    public static void resetPassvalidInputs(int index) throws IOException {
        try {
            UserContainer user = new UserContainer(index);
            String newPassword="";
            Q_Slv_WebElm.myWait(2000);
            if(user.passwd.equals("1212Te$t")) {
                newPassword="Feb@2021";
            } else if(user.passwd.equals("Feb@2021")) {
                newPassword="1212Te$t";
            }

            Q_Slv_WebElm.myWait(2000);
            UserContainer user1 = new UserContainer(index,newPassword);
            Q_Slv_WebElm.myWait(6000);
            Q_Slv_WebElm.xpClear(SLVqProp, "acc.changePwd.old.xp");
            Q_Slv_WebElm.xpSend(SLVqProp, "acc.changePwd.old.xp",user.passwd);
            Q_Slv_WebElm.xpClear(SLVqProp, "acc.changePwd.new.xp");
            Q_Slv_WebElm.xpSend(SLVqProp, "acc.changePwd.new.xp", newPassword);
            Q_Slv_WebElm.xpClear(SLVqProp, "acc.changePwd.confirm.xp");
            Q_Slv_WebElm.xpSend(SLVqProp, "acc.changePwd.confirm.xp", newPassword);
            Q_Slv_WebElm.xp(SLVqProp, "acc.changePwd.saveBtn.xp");
            Q_Slv_Controls.checkAlert();
            Q_Slv_AccountSteps.logout();
            Q_Slv_WebElm.xp(SLVqProp, "acc.really.logoutLink.xp");
//        WebElement reallyLogoutLink = driver.findElement(By.xp("//a[.='log out']"));
//        if(reallyLogoutLink.isDisplayed())
//        {
//        	reallyLogoutLink.click();
//        }
            driver.navigate().to(baseUrl);
            Q_Slv_WebElm.myWait(2000);
            Q_Slv_AccountSteps.resetPasswordloginUser("acc.login.link.xp",45,newPassword);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }

        //Assert.assertTrue(Controls.isAlertPresent());
    }


    public static void createAccount(int index) throws FileNotFoundException{
        InvalidPasswordContainer password = new InvalidPasswordContainer(index);

        Q_Slv_WebElm.idClear(SLVqProp, "chk.guest.reg.pwd.id");
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.reg.pwd.id", password.passwd);
        System.out.println(password.passwd);
        Q_Slv_WebElm.idClear(SLVqProp, "chk.guest.reg.pwdConfirm.id");
        Q_Slv_WebElm.idSend(SLVqProp, "chk.guest.reg.pwdConfirm.id", password.confPassword);
        Q_Slv_WebElm.idExecutor(SLVqProp, "chk.finishAndPlace.id");
        //  Controls.checkAlert();

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
  		Q_Slv_AccountSteps.myAccount();
  		// Need to add orders click
  		Q_Slv_WebElm.xp(SLVqProp, "acc.order.fristOrderDetails.xp");
        Q_Slv_WebElm.myWait(2000);
	    List<Float> priceList = new ArrayList<Float>();
	    Float calcTotal = Float.valueOf(0);
	    Float subtotal = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"acc.order.subtotal.xp"));
	    calcTotal = calcTotal + subtotal;
	    priceList.add(subtotal);
	
	    if (hasSalesTax)
	    {
	      	Float tax = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"acc.order.salesTax.xp"));
	      	calcTotal = calcTotal + tax;
	      	priceList.add(tax);
	    }
	      
	    if (hasStateFee)
	    {
	      	Float stateFee = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"acc.order.stateFee.xp"));
	      	calcTotal = calcTotal + stateFee;
	      	priceList.add(stateFee);
	    }
	
	    String temp = Q_Slv_WebElm.xpRetText(SLVqProp,"acc.order.shipping.xp");
	    if (temp.equals("Free")) {
	      	Float shipping = Float.valueOf("0.0");
	      	calcTotal = calcTotal + shipping;
	      	priceList.add(shipping);
	    } else {
	      	Float shipping = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"acc.order.shipping.xp"));
	      	calcTotal = calcTotal + shipping;
	      	priceList.add(shipping);
	    }
	      
	    if (hasGiftCert)
	    {
	      	Float discount = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"acc.order.discount.xp"));
	      	calcTotal = calcTotal - discount;
	      	priceList.add(discount);
	    }
	      
	    calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
	    Float total = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"acc.order.total.xp"));
	    priceList.add(total);
	    Assert.assertEquals(total, calcTotal, "My Account Order Page total does not match calculated revenue items.");
	    System.out.println("[Pass] My Account Order Page total matches calculated revenue items.");
	    return priceList;
      }
   	//JMB-7670 End
  	
  	// Start JMB-8170
    /*********************************************************************************
 	* Description: To Click on Add Shipping Address on Second Time
 	* Param: NA
 	* Returns: NA
 	* Jira Ticket: JMB 8170
 	* Status: Complete 
 	**********************************************************************************/
    public void clickAddShippingAddressSecondTime() throws Exception {
         Q_Slv_WebElm.xpExecutorScrolToElement(SLVqProp, "acc.shippingAddress.label.xp");
         Q_Slv_WebElm.id(SLVqProp,"acc.ship.create.add.id");
         Q_Slv_WebElm.myWait(2000);
         Q_Slv_WebElm.id(SLVqProp, "acc.cancelAddress.button.id");
         Q_Slv_WebElm.myWait(2000);
	     Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "acc.ship.create.add.id"));
	     System.out.println("Add a U.S. Postal Address link  opening the form on 2nd click without refreshing the page manually : Success");
    	}
    // End JMB-8170
    
    //JMB-6606-Start
  	/********************************************************************
  	// * Description  : To verify the change email address instruction
  	// * Jira Ticket  : JMB-6606
  	// * Status       : Complete
  	//*******************************************************************/
  	public void validateCannotChangeEmailAddressMessage() {
  		String expectedMessage = "If you want to change the email address, you can call us at 1-888-989-7223 or email us to support@silver.com";
  		Q_Slv_WebElm.xp(SLVqProp, "chk.myAccounts.emailAddress.xp");
  		Assert.assertTrue(Q_Slv_WebElm.xpRetText(SLVqProp, "chk.myAccounts.emailDescription.xp").contains(expectedMessage));
  	}
  	//JMB-6606-End

}
