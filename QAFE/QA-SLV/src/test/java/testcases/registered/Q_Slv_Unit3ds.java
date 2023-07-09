package testcases.registered;

//import steps.AccountSteps;

import org.testng.annotations.*;
import pageObjects.Q_Slv_AccountSteps;
import pageObjects.Q_Slv_CartSteps;
import pageObjects.Q_Slv_CheckoutSteps;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.util.ArrayList;


public class Q_Slv_Unit3ds extends Q_Slv_Init {
    @BeforeClass
    public void tcSetup (){

    }
    @BeforeMethod
    public void report() throws Exception {
        Q_Slv_Init.setItUp();
    }
    @BeforeTest
    public void setTest() throws Exception {
    }
    @Test(priority = 4)
    public void FrictionlessNoAuthVisa() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 37);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
//        CheckoutSteps.creditCardInput(15);
//        CheckoutSteps.attemptOrder();
//        CheckoutSteps.validateErrorrMsg("We are sorry but we are unable to process your credit card.");

        Q_Slv_CheckoutSteps.switchCard("mc", "241");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());

        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_AccountSteps.logout();
    }
}
