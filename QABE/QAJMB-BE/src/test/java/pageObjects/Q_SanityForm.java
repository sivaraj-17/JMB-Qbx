package pageObjects;

import utils.Controls;
import utils.Init;

public class Q_SanityForm extends Init {

//    public static void adminLogin() throws Exception {
//
//        String user = "qa@jmbullion.com";
//        String pwd = "T3$t2016";
//        String baseUrl = "http://staging.jmbullion.com/admin";
//        driver.get(baseUrl);
//
//        pwd.idClear(adminProps,"user.id");
//        pwd.idSend(adminProps, "user.id", "qa@jmbullion.com");
//        pwd.id(adminProps, "pwd.id");
//        pwd.idSend(adminProps, "pwd.id", "T3$t2016");
//        pwd.name(adminProps,"loginSubmit.name");
//
//    }
    public static void goldCredit() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        driver.navigate().to(baseUrl + "/gold/gold-bars/");
        Q_WebElm.xpExecutor(adminProps, "sunshine5G.xp");
        Q_WebElm.xp(adminProps, "modalCkeckoutLnk.xp");


    }
    public static void creditCard(String ccPaymentType) {
        Q_WebElm.xpExecutor(adminProps, "ccPaymentType.xp");

    }

    public static void ccButton(String ccCheckoutBtnTop) {
        Q_WebElm.xpExecutor(adminProps, "ccCheckoutBtnTop.xp");

    }
    public static void CheckoutSecurelyNow(String guestCheckoutSecurelyNow) {
        Q_WebElm.xp(adminProps, "guestCheckoutSecurelyNow.xp");
    }


}
