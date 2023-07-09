package testcases.newFeatures;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Q_Slv_AccountSteps;
import pageObjects.Q_Slv_CartSteps;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

public class Q_Slv_CheckForErrorsInConfPage_JMB5357_SLV extends Q_Slv_Init {
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
	
	/*******************************************************************
     * Description: Check if page has blank content in body
     * Author:
     * Status: Complete
	 * Ticket : JMB-5357
     ********************************************************************/
	
	@Test
	public static void checkBlankScreen() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		driver.navigate().to(baseUrl + "/wp-content/themes/silver/includes/conf/");
		String pageSource = driver.findElement(By.tagName("Body")).getText();
		if(pageSource.equals(""))
		{
			System.out.println("No Errors");
		}
		else
		{
			Assert.fail("Errors were encountered.");
		}
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Q_Slv_CartSteps.emptyCart();
		Q_Slv_AccountSteps.logout();
		Q_Slv_Controls.tearDown();
	}
	
	@AfterClass
	public void exitClass(){
	}
}
