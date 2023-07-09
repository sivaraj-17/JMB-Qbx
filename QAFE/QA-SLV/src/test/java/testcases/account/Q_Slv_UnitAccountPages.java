package testcases.account;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.Q_Slv_AccountSteps;
import pageObjects.Q_Slv_CartSteps;
import pageObjects.Q_Slv_CheckoutSteps;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.io.FileNotFoundException;


public class Q_Slv_UnitAccountPages extends Q_Slv_Init {

    @BeforeClass
    public void tcSetup () throws Exception {

        Q_Slv_Init.setItUp();
    }
    @Test(priority =2)
    public static void registerGuestUser() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.copper2("50");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "qa5auto@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(1);
        Q_Slv_CheckoutSteps.shippingAutoAddress(1);


        Q_Slv_CheckoutSteps.completeOrder("chk.finishAndPlace.id");
        Q_Slv_AccountSteps.createAccount();
        Q_Slv_AccountSteps.deleteUser();

    }
}
