package testcases.registered;

//import steps.AccountSteps;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Q_Slv_AccountSteps;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.io.IOException;


public class Q_Slv_UnitRegistered extends Q_Slv_Init {
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
    @Test(priority =12)
    public static void changePasswordWithvalidInput() throws IOException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
//    	try {
        Q_Slv_AccountSteps.login("acc.login.link.xp",46);
//        AccountSteps.changePassword();
        Q_Slv_AccountSteps.resetPassvalidInputs(46);
        Q_Slv_AccountSteps.logout();
//    	} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Assert.fail();
//		}
    }
}
