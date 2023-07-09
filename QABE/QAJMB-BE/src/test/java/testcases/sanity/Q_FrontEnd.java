package testcases.sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Q_CheckoutForm;
import pageObjects.Q_SanityForm;
import pageObjects.Q_WebElm;
import utils.Controls;
import utils.Init;

public class Q_FrontEnd extends Init {
	@BeforeClass
	public void setEnv () throws Exception {
		setItUp();
		if (driver.toString().contains("Chrome")) {
			Controls.adminLogin();
		}
		else{
			driver.quit();
		}
	}
	@BeforeMethod
	public void tcSetup() throws Exception {
		if (driver.toString().contains("Firefox")) {
			setItUp();
			Controls.adminLogin();
		}
	}
/*
	@Test (priority = 1)


	public void productCount() throws Exception {
		String tcName = "productCount";
		Functions.testStarted(tcName);
	 	Log.info(tcName + " ::     Started execution");
		driver.get(baseUrl);
	 	WebElement searchInput = driver.findElement(sqlParser.getObjectLocator("searchInput"));
	   	searchInput.clear();
	   	searchInput.sendKeys(" ");
	   	WebElement searchBtn = driver.findElement(sqlParser.getObjectLocator("searchBtn"));
	   	searchBtn.click();
	   	WebElement totalResult = driver.findElement(sqlParser.getObjectLocator("totalResult"));
	   	String actualTotal = totalResult.getText();


	   	int count = Integer.parseInt(actualTotal);

	   	//System.out.println(count);
	   	if (count > 1500){
	   		System.out.println(tcName + "Product count is greater than 1500");
	   		Functions.testPassed(tcName);
	    	Log.info(tcName + " ::      Obtained and verified product listing");
	   	}
	   	else{
	   		System.out.println(tcName + " Failed");
	    	Log.error(tcName + " ::      Failed to verify product listing");
	    	Assert.fail();
	   	}
	   	Log.info(tcName + "::      Test case Detected Google Rating ");
		Log.endTestCase(tcName + " ::     Test Case " + tcName + " finished execution");
		}
		*/
@Test (priority = 2)
public void siteRating() throws Exception {

	String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
	Controls.testStarted(tcName);
	String testUrl = "https://www.google.com";
	driver.get(testUrl);
	String check1 = "";
	String check2 = "";
	String expectedRating = "https://www.jmbullion.com › 2016-american-silver-eagle";
	String expectedSiteName = "https://www.jmbullion.com";
	WebElement serch = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));

	serch.clear();
	serch.sendKeys("site jmbullion.com 2016 american silver eagles ");
	serch.sendKeys(Keys.TAB);
	//WebDriverWait wait = new WebDriverWait(driver, 30);
	//Thread.sleep(2000);
	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("btnK"))));
	driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).click();
	// //*[@id="tsf"]/div[2]/div[1]/div[3]/center/input[1]
	System.out.println("Started Google Search");
	WebElement rating = driver.findElement(By.className("iUh30"));
	String actualRating = rating.getText();
	System.out.println(actualRating);
	WebElement siteLink = driver.findElement(By.className("iUh30"));
	String actualSiteName = siteLink.getText().substring(0, 25);
	System.out.println(actualSiteName);
	System.out.println("Actual Rating :" +actualRating);
	System.out.println("Expected Rating :" +expectedRating);

	if(actualRating.compareTo(expectedRating)==0){
		check1 = "pass";
		Assert.assertEquals(actualRating, expectedRating);
	}

	System.out.println("Actual Name :" + actualSiteName);
	System.out.println("Expected Name:" + expectedSiteName);
	if(actualSiteName.compareTo(expectedSiteName)==0){
		check2 = "pass";
	}
	System.out.println("Check1 Name :" + check1);
	System.out.println("Check2 Name:" + check2);

	try{
		Assert.assertEquals(check1, check2);
	}
	catch(Throwable ex){
		System.out.println(tcName + " Failed");
		Assert.fail();
	}
}
	@Test (priority = 3)// get spot prices
	public void spotPrices() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);

		String expectedGoldPrice = "";
		String expectedSilverPrice = "";
		driver.navigate().to("https://staging.jmbullion.com");

		String actualGold = Q_WebElm.xpRetText(sanProps, "priceOfGold.xp");
		expectedGoldPrice = Q_WebElm.xpRetText(sanProps, "priceOfGold.xp");

		System.out.println("Actual gold spot price " + actualGold);
		System.out.println("Expected gold spot price " + expectedGoldPrice);

		String actualSilver = Q_WebElm.xpRetText(sanProps, "priceOfSilver.xp");
		expectedSilverPrice = Q_WebElm.xpRetText(sanProps, "priceOfSilver.xp");
		System.out.println("Actual silver spot price " + actualSilver);
		System.out.println("Expected spot price " + expectedSilverPrice);
	 	try{
	 		Assert.assertEquals(expectedGoldPrice, actualGold);
		 	String check1 = "Pass";
	 	 	Assert.assertEquals(expectedSilverPrice, actualSilver);
		 	String check2 = "Pass";
			try {
				Assert.assertEquals(check1, check2, "Pass");
				System.out.println(tcName + " Passed");
				}
		   catch(Throwable ex){
				System.out.println(tcName + " Failed");
				}
	 		}
	 	catch(Throwable ex){
			System.out.println(tcName + " Failed");
			Assert.fail();
		}
		}

	@Test (priority = 5)// Verifying checkout shipping options
	public void getShipCheckout() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
//		Controls.adminLogin();
        Q_CheckoutForm chk = new Q_CheckoutForm();
		String freeUSPS = "true";
		String USPS299 = "true";
		String USPS799 = "true";
		String USPS999 = "true";
		Thread.sleep(2000);
		Q_SanityForm.goldCredit();

		Q_SanityForm.creditCard("ccPaymentType");
		Q_SanityForm.ccButton("ccCheckoutBtnTop");
		Thread.sleep(2000);

// Shipping option 1
		Q_WebElm.xpDisplayed(sanProps,"option1.xp");
		Assert.assertTrue(Q_WebElm.xpDisplayed(sanProps,"option1.xp"));
		String option1 = Boolean.toString(true);
		//System.out.println("Free " + option1);

		try {
			Assert.assertEquals(freeUSPS, option1);
			System.out.println(tcName + " Free Shipping ");

		}
		catch(Throwable ex){
			System.out.println(tcName + " Failed USPS First Class");
			Assert.fail();
		}

// Shipping option 2
		Q_WebElm.xpDisplayed(sanProps,"option2.xp");
		Assert.assertTrue(Q_WebElm.xpDisplayed(sanProps,"option2.xp"));


// Shipping option 3
		Q_WebElm.xpDisplayed(sanProps,"option3.xp");
		Assert.assertTrue(Q_WebElm.xpDisplayed(sanProps,"option3.xp"));
		driver.navigate().to(baseUrl );
//		CartObject.removeItems;
		System.out.println(tcName + " Passed");
	}


}
