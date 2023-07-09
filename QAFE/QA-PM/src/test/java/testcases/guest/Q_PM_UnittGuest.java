package testcases.guest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.Q_PM_AccountSteps;
import pageObjects.Q_PM_CartSteps;

import utils.Q_PM_Controls;
import utils.Q_PM_Init;

public class Q_PM_UnittGuest extends Q_PM_Init {

    @BeforeClass
    public void tcSetup () throws Exception {

        Q_PM_Init.setItUp();
    }

    /*******************************************************************
     // * Description: Verifies Florida sales tax on Palladium tender order under $500.00 order is taxable
     // * Author:
     // * Status: Complete
     // * Ticket: JMB-6375
     // * ***************************************************************/
    @Test (priority = 5)
    public void palladiumTenderUnder500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_CartSteps cart = new Q_PM_CartSteps();
        Q_PM_AccountSteps.loginUser(12);
        cart.selectTaxableItem("Palladium Coin Below 500", 1);

    }
    @AfterMethod
    public static void tearDown(){

        //CartSteps.emptyCart();

    }
    @AfterClass
    public static void killDriver(){
//        if (driver.toString().contains("Firefox")) {
//            driver.quit();
//        }
    }
}
