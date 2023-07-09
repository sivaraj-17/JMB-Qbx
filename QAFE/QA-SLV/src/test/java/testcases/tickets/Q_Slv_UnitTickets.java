package testcases.tickets;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

//import steps.AccountSteps;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Q_Slv_AccountSteps;
import pageObjects.Q_Slv_CartSteps;
import pageObjects.Q_Slv_CheckoutSteps;
import pageObjects.Q_Slv_WebElm;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.io.IOException;
import java.util.ArrayList;


public class Q_Slv_UnitTickets extends Q_Slv_Init {
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
	public void tearDown() throws Exception {
		Q_Slv_Controls.tearDown();
	}
	
	@AfterClass
	public void exitClass(){
	}
}
