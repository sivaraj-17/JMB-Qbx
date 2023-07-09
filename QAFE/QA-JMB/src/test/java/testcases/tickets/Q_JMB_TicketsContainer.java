package testcases.tickets;

import org.testng.annotations.*;
import utils.Q_JMB_Init;
//import utils.Log;


public class Q_JMB_TicketsContainer extends Q_JMB_Init {
    @BeforeMethod
    public void report() throws Exception {
        Q_JMB_Init.setItUp();
    }


    @AfterMethod
    public void tearDown() throws Exception {
        // CartPageObjects.removeItems();
        // AccountObjects acc = new AccountObjects();

        // acc.logoutUser();
//        Controls.tearDown();
    }
}