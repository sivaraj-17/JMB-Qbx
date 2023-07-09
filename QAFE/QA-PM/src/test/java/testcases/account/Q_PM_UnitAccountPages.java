package testcases.account;


import org.testng.annotations.BeforeClass;
import utils.Q_PM_Init;


public class Q_PM_UnitAccountPages extends Q_PM_Init {

    @BeforeClass
    public void tcSetup() throws Exception {

        Q_PM_Init.setItUp();
//        AccountSteps.loginUser(4);
//        AccountSteps.deleteUser();

    }


}
