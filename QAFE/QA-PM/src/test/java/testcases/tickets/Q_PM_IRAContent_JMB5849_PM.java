package testcases.tickets;

import java.io.IOException;

import org.testng.annotations.*;

import pageObjects.Q_PM_AccountSteps;
import pageObjects.Q_PM_CartSteps;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

//JMB-5849(PM IRA Contact Form Broken)
public class Q_PM_IRAContent_JMB5849_PM extends Q_PM_Init {
    @BeforeClass
    public void tcSetup() {
    }
    @BeforeMethod
    public void report() throws Exception {
        Q_PM_Init.setItUp();
    }
    @BeforeTest
    public void setTest() throws Exception {
    }
    @Test
    public static void validatePMIRAContactForm() throws IOException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.validatePMIRAForm();

    }

    @AfterTest
    public void endReport(){
    }
    @AfterMethod
    public void tearDown() throws Exception {
		Q_PM_CartSteps.deleteItems();
		Q_PM_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }


}
