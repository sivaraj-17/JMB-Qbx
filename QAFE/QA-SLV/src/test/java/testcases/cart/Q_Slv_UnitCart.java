package testcases.cart;

import org.testng.annotations.*;
import utils.Q_Slv_Init;


public class Q_Slv_UnitCart extends Q_Slv_Init {

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


    @AfterMethod
    public static void remove(){

        //CartSteps.emptyCart();

    }


}
