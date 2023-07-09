package testcases.account;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.io.FileNotFoundException;


public class Q_JMB_UnitAccountPages extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();

    @BeforeClass
    public void tcSetup () throws Exception {

        Q_JMB_Init.setItUp();
    }
    @Test(priority =2)
    public static void registerGuestUser() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.silverPeaceSilverDollarCoi("2");
        Q_JMB_CategoryObjects.copperUSQuarter("10");
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa5auto@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.completeOrder();
        acc.checkoutRegistration(4, "jm.createRegBtn.id");
    }
}
