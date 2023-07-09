package testcases.sanity;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Q_WebElm;
import utils.Controls;
import utils.Init;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class Q_BackEnd extends Init {

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


	@Test (priority = 2)// Check text message
	   public void checkingText() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);

	 	String expectedTxtMessage = "Due to additional costs incurred from shipping to your area, your order will be subject to an additional shipping fee, shown on the right of this page.";
		driver.navigate().to(baseUrl + "/admin/function-view.php?test=jm_get_text&text=1");

		String actualTxtMessage = Q_WebElm.xpRetText(sanProps, "checkProductInHand.xp");


		try {
			Assert.assertEquals(expectedTxtMessage, actualTxtMessage);
			System.out.println(tcName + " Passed");
		}
		catch(Throwable ex){
			System.out.println(tcName + " Failed");
			Assert.fail();
		}

	}
	@Test (priority = 3)// Directory Listing
	   public void directoryListing() throws Exception {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);

		//String[] page = {"chartload", "configs", "fancybox", "genesys", "google","max","partials", "phpchart", "utilities"};
		String[] page = {"chartload", "chartload", "fancybox", "google", "max", "partials", "phpchart", "utilities"};

		for (int i = 0; i < page.length; i++) {
			//System.out.println(page[i] + "\n");
			driver.navigate().to(baseUrl + "/" + page[i] + "/");
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}
	}

@Test(priority = 6)// Product limit
public void getProductLimit() throws Exception {
	String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
	Controls.testStarted(tcName);

    String expectedLimit = "53";
    driver.navigate().to(baseUrl + "/admin/products-form.php?id=16");

    //WebElement limit = driver.findElement(sqlParser.getObjectLocator("productLimit"));
    String actualLimit = Q_WebElm.xpRetAttr(sanProps, "productLimit.xp", "value");
    
	System.out.println(actualLimit + " Passed");
    try {
        Assert.assertEquals(expectedLimit, actualLimit);
        System.out.println(tcName + " Passed");
    }
    catch(Throwable ex){
        System.out.println(tcName + " Failed");
        System.out.println(tcName + " ::     Failed to verify product limit");
        Assert.fail();
    }

}

@Test (priority = 7)// Verify product margin
public void getProductMargin() throws Exception {
	String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
	Controls.testStarted(tcName);
    //
    // Getting product margin from the product page
    //
    driver.navigate().to(baseUrl + "/admin/products-form.php?id=166617");
	Float jmp = Float.parseFloat(Q_WebElm.idAttrRet(sanProps, "prod.jmPremium.id", "value"));
	Float supPremium = Float.parseFloat(Q_WebElm.idAttrRet(sanProps, "prod.supplierPremium.id", "value"));
    Float margin = jmp - supPremium;
    Float calculatedMargin = (margin * 1);
    BigDecimal roundOff = new BigDecimal(calculatedMargin);
    BigDecimal expectedMargin = roundOff.setScale(2);
    String expectedProductMargin = expectedMargin.toString();
    System.out.println("Expected Margin is  " + "\t" + expectedMargin);
    //
    // Obtain the margin for the product specified by the get_product_function
    //
    driver.navigate().to(baseUrl + "/admin/function-view.php?test=jm_get_product_margin&product=166617&qty=1&subtotal=1000&payment=credit_card");

    String actualProductMargin = Q_WebElm.xpRetText(sanProps, "prod.productMargin.xp").substring(0,4);
	System.out.println("actualTestValue " + "\t" + actualProductMargin);
	try {
        Assert.assertEquals(expectedProductMargin, actualProductMargin);
        System.out.println(tcName + " Passed");
        System.out.println(tcName + " ::     Verified the get_product_margin calculated correctly");
    }
    catch(Throwable ex){
        System.out.println(tcName + " Failed");
        System.out.println(tcName + " ::     Failed to verify product margin");
        Assert.fail();
    }
}

@Test  (priority = 8)// Validate product meta
public void getProductMeta() throws Exception {
	String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
	Controls.testStarted(tcName);
    driver.navigate().to(baseUrl + "/admin/products-form.php?id=105");
	String expectedProductInHand = Q_WebElm.xpRetText(sanProps, "inhandQty.xp").substring(9);
	System.out.println("in hand qty From admin page" + "\t" + expectedProductInHand);
    Thread.sleep(3000);
    driver.navigate().to(baseUrl + "/admin/function-view.php?test=jm_get_productmeta&product=105&column=inhand");
	String actualInHandFunction = Q_WebElm.xpRetText(sanProps, "checkProductInHand.xp");
    System.out.println("in hand qty function return " + "\t" + actualInHandFunction);

    try {
        if (expectedProductInHand.compareTo(actualInHandFunction) == 0)

        System.out.println(tcName + " Passed");
        System.out.println(tcName + " ::     In Hand qty verified ");
    }
    catch(Throwable ex){
        System.out.println(tcName + " Failed");
        System.out.println(tcName + " ::     Failed to verify In Hand qty");
        Assert.fail();
    }

}

    @Test (priority = 9)// Validate product supplier
    public void getSupplier() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
        driver.navigate().to(baseUrl + "/admin/function-view.php?test=jm_get_supplier&supplier=1");
        String expectedSupplier = "Dillon Gage";
		String actualSupplier = Q_WebElm.xpRetText(sanProps,"orderWooProduct.xp");
		System.out.println("Supplier : " + actualSupplier);

        try {
            Assert.assertEquals(expectedSupplier, actualSupplier);
            System.out.println(tcName + " Passed");
            System.out.println(tcName + " ::     Verified the expected supplier name is returned");

        }
        catch(Throwable ex){
            System.out.println(tcName + " Failed");
            System.out.println(tcName + " ::     Failed verification for supplier name");
            Assert.fail();
        }

    }

    @Test (priority = 10)// Display order type expected result "normal"
    public void orderType() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
        driver.navigate().to(baseUrl + "/admin/function-view.php?test=jm_get_order_type&order=1651421");
        String expectedOrderType = "normal";
		String actualOrderType = Q_WebElm.xpRetText(sanProps, "orderWooProduct.xp");

        System.out.println("Woo product type is " + "\t" + actualOrderType);


        try {
            Assert.assertEquals(expectedOrderType, actualOrderType);
            System.out.println(tcName + " Passed");
            System.out.println(tcName + " ::     Verified the expected order type is returned");

        }
        catch(Throwable ex){
            System.out.println(tcName + " Failed");
            System.out.println(tcName + " ::     Failed verification for order type");
            Assert.fail();
        }
    }

    @Test (priority = 11)// Validate product in hand quantity for a specific order
    public void productInHand() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
        String expectedProductInHand = "IN Hand: 8";
        String expectedInHandFunction = "item: 166617 inhand check: 1";
        driver.navigate().to(baseUrl + "/admin/products-form.php?id=166617");
		String actualProductInHand = Q_WebElm.xpRetText(sanProps,"inhandQty.xp");


        driver.navigate().to(baseUrl + "/admin/function-view.php?test=check_product_inhand&order=1652056");
		String actualInHandFunction = Q_WebElm.xpRetText(sanProps, "checkProductInHand.xp").substring(10);
        System.out.println("in hand qty " + "\t" + actualProductInHand);
        System.out.println("actualInHandFunction: " + actualInHandFunction);

        Assert.assertEquals(expectedProductInHand, actualProductInHand);

        try{
            System.out.println("Step 1: Passed");

            }
        catch(Throwable ex){
            //System.out.println("Step 1: Failed");
            System.out.println(tcName + " ::     Failed on step1 product in hand");
            }
        String check1 = "Pass";
        System.out.println("Function View Actual" + "\t" + actualInHandFunction);
        System.out.println("Function View Expected: " + actualInHandFunction);
        Assert.assertEquals(expectedInHandFunction, actualInHandFunction);
        String check2 = "Pass";

        try{
            Assert.assertEquals(check1, check2);
            System.out.println(tcName + " ::     In Hand qty verified ");
            System.out.println(tcName + " Passed");

            }
        catch(Throwable ex){
            System.out.println(tcName + " Failed");
            System.out.println(tcName + " ::     Failed to verify product in hand");
            }
    }

	@Test (priority = 12)// Validate product in hand quantity
	   public void productInHandQuantity() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
			String expectedProductInHand = "8";
			driver.navigate().to(baseUrl + "/admin/products-form.php?id=166617");
			String actualProductInHand = Q_WebElm.xpRetText(sanProps, "inhandQty.xp").toString().substring(9);
			System.out.println("in hand qty Expected" + "\t" + expectedProductInHand);
			System.out.println("in hand qty " + "\t" + actualProductInHand);

			try {
				Assert.assertEquals(expectedProductInHand, actualProductInHand);
				System.out.println(tcName + " Passed");
				System.out.println(tcName + " ::     In Hand qty verified ");

			}
			catch(Throwable ex){
				System.out.println(tcName + " Failed");
				System.out.println(tcName + " ::     Failed to verify In Hand Quantity");
				Assert.fail();
			}
		}


	@Test (priority = 13)// Verify setting order meta delay
	public void setOrderMetaDelay() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		driver.navigate().to(baseUrl + "/admin/function-view.php?test=update_orders_meta_delay&order=1652056");
		//String expectedPresetDelay = blindSQL.getCellData(6, 2);
		String expectedPresetDelay = "item: 166617 product delay: 0000-00-00 order delay: 0000-00-00";
		//System.out.println("expected Preset Delay " + expectedPresetDelay);
		String actualPresetDelay = Q_WebElm.xpRetText(sanProps,"orderMetaDelay.xp").substring(10);
		//System.out.println("actual Preset Delay " + actualPresetDelay);
		try {
			Assert.assertEquals(expectedPresetDelay, actualPresetDelay);
			System.out.println("expected Preset Delay " + expectedPresetDelay +"\n" + "\t\t\t\t\t" + actualPresetDelay);
			System.out.println(tcName + " ::     Verifying the preset order delay");
		}
		catch(Throwable ex)	{
			System.out.println(tcName + " ::     Failed verification preset order delay");
		}
		driver.navigate().to(baseUrl + "/admin/products-form.php?id=166617");
		Q_WebElm.nameClear(sanProps, "delay.name");
		Q_WebElm.nameSend(sanProps, "delay.name", "2021-01-02");
		Q_WebElm.myWait(1000);
		Q_WebElm.xp(sanProps, "productSave.xp");
		Thread.sleep(1000);
		driver.navigate().to(baseUrl + "/admin/function-view.php?test=update_orders_meta_delay&order=1652056");
		String expectedSetDelay = "item: 166617 product delay: 2021-01-02 order delay: 2021-01-02";

		String actualSetDelay = Q_WebElm.xpRetText(sanProps, "orderMetaDelay.xp").substring(10);

		try {
			Assert.assertEquals(expectedSetDelay, actualSetDelay);
			System.out.println("expected Set Delay " + expectedSetDelay +"\n" + "\t\t\t\t\t" + actualSetDelay);
			System.out.println(tcName + " ::     Verifying the Set order delay");

		}
		catch(Throwable ex){
			System.out.println("Failed");
			System.out.println(tcName + " ::     Failed verification Set order delay");
		}

		driver.navigate().to(baseUrl + "/admin/products-form.php?id=166617");
		Q_WebElm.nameClear(sanProps, "delay.name");
		Q_WebElm.nameSend(sanProps, "delay.name", "0000-00-00");
		Q_WebElm.xpExecutor(sanProps, "productSave.xp");

		Thread.sleep(1000);
		driver.navigate().to(baseUrl + "/admin/function-view.php?test=update_orders_meta_delay&order=1652056");
		String actualResetDelay = Q_WebElm.xpRetText(sanProps,"orderMetaDelay.xp").substring(10);
		try {
			Assert.assertEquals("item: 166617 product delay: 0000-00-00 order delay: 0000-00-00",  actualResetDelay);
			System.out.println("Order ReSet Delay " + Q_WebElm.xpRetText(sanProps,"orderMetaDelay.xp").substring(10));
			System.out.println(tcName + " Passed");
			System.out.println(tcName + " ::     Order delay verified");
		}
		catch(Throwable ex){
			System.out.println(tcName + " Failed");
			System.out.println(tcName + " ::     Failed to verify order delay");
			Assert.fail();
		}
	}

    @Test (priority = 14)// Verify that in hand quantity can be set for a product
    public void setProductInHand() throws Exception {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		String expectedProductInHand = "10205";
		String expectedInHandIncrease = "10305";
		String expectedInHandDecrease = "10205";
		driver.navigate().to(baseUrl + "/admin/products-form.php?id=166617");
		String actualProductInHand = Q_WebElm.xpRetText(sanProps, "inhandQty.xp").substring(9);
		System.out.println("Original in hand qty " + "\t" + actualProductInHand);
		Thread.sleep(3000);
		driver.navigate().to(baseUrl + "/admin/function-view.php?test=set_product_inhand&product_id=166617&qty=100");
		String actualInHandIncrease = Q_WebElm.xpRetText(sanProps, "setProductInHand.xp").substring(37);
		System.out.println("New In Hand quantity " + "\t" + actualInHandIncrease);
		driver.navigate().to(baseUrl + "/admin/function-view.php?test=set_product_inhand&product_id=166617&qty=-100");
		Thread.sleep(3000);
		String actualInHandDecrease = Q_WebElm.xpRetText(sanProps, "setProductInHand.xp").substring(37);
		System.out.println("Reset to original " + "\t" + actualInHandDecrease);
		try {
			if (expectedProductInHand.compareTo(actualProductInHand) == 0)
				System.out.println(tcName + " ::     Verified initial In Hand qty successfully");
			else
				System.out.println(tcName + " ::     Failed to update initial in Hand quantity");
			if (expectedInHandIncrease.compareTo(actualInHandIncrease) == 0)
				System.out.println(tcName + " ::     Verified setting In Hand qty successfully");
			else
				System.out.println(tcName + " ::     Failed to Set in Hand quantity");
			if (expectedInHandDecrease.compareTo(actualInHandDecrease) == 0)
				System.out.println(tcName + " ::     Verified Reseting In Hand qty successfully");
			else
				System.out.println(tcName + " ::     Failed to reset in Hand quantity");
			System.out.println(tcName + " Passed");
			System.out.println(tcName + " ::     Verified In Hand qty updated successfully");
		} catch (Throwable ex) {
			System.out.println(tcName + " Failed");
			System.out.println(tcName + " ::     Failed to update in Hand quantity");
			Assert.fail();
		}
	}




    @Test (priority = 15)// Verify that for a product can be set
    public void setProductLimit() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
         String expectedPreValue = "349";
        String expectedTestValue = "347";
        String expectedPostValue = "349";
        driver.navigate().to(baseUrl + "/admin/products-form.php?id=166617");
		String actualPreValue = Q_WebElm.xpRetAttr(sanProps,  "limitedQty.xp", "value");

        try {
            Assert.assertEquals(expectedPreValue, actualPreValue);
            System.out.println(tcName + " ::     Orginal limited value verified ");
        }
        catch(Throwable ex){
            System.out.println(tcName + " ::     Failed to verify original limited value");
        }


        //
        // Run function-view.php?test=set_product_limit
        //
        driver.navigate().to(baseUrl + "/admin/function-view.php?test=set_product_limit&product=166617&limit=2");
        driver.navigate().to(baseUrl + "/admin/products-form.php?id=166617");
		String actualTestValue = Q_WebElm.xpRetAttr(sanProps, "limitedQty.xp", "value");
        try {
            Assert.assertEquals(expectedTestValue, actualTestValue);
            System.out.println(tcName + " ::     Verified updated value verified ");
        }
        catch(Throwable ex){
            System.out.println(tcName + " ::     Failed to verify updated limited value");
        }
        //
        // Reset limited value
        //
        driver.navigate().to(baseUrl + "/admin/function-view.php?test=set_product_limit&product=166617&limit=-2");
        driver.navigate().to(baseUrl + "/admin/products-form.php?id=166617");
		String actualPostValue = Q_WebElm.xpRetAttr(sanProps,  "limitedQty.xp", "value");
        try {
            Assert.assertEquals(expectedPostValue, actualPostValue);

            System.out.println(tcName + " ::     Restored Limited product value ");
        }
        catch(Throwable ex){
            System.out.println(tcName + " ::     Failed to restore Limited product value");
        }
    }

	@Test (priority = 16)// Verify order meta Sync with woocommerce
	   public void updateOrderMeta() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		driver.navigate().to(baseUrl + "/admin/function-view.php?test=update_orders_meta&order=1652056");
		String expectedWooProduct = "item: 166617 qty: 3wp_jm_orders_meta Products:item: 166617 qty: 3";
		//WebElm.xpRetText(sanProps, "orderWooProduct.xp")
		//WebElement orderMeta = driver.findElement(sqlParser.getObjectLocator("orderWooProduct"));
		System.out.println("Actual all        " + "\n" + Q_WebElm.xpRetText(sanProps, "orderWooProduct.xp"));
		String actualWooProduct = Q_WebElm.xpRetText(sanProps, "orderWooProduct.xp").substring(14,33) +
				Q_WebElm.xpRetText(sanProps, "orderWooProduct.xp").substring(36,63) +
				Q_WebElm.xpRetText(sanProps, "orderWooProduct.xp").substring(64);

		try {
			Assert.assertEquals(expectedWooProduct, actualWooProduct);
			System.out.println("Expected" + "\n" + expectedWooProduct);
			System.out.println("Woo product" + "\n" + actualWooProduct);

			System.out.println(tcName + " Passed");
			System.out.println(tcName + " ::     Oreder Meta woocommerce verified");

		}
		catch(Throwable ex){
			System.out.println(tcName + " Failed");
			System.out.println(tcName + " ::     Failed verification Oreder Meta");
			Assert.fail();
		}
	}

//	@Test (priority = 17)// Verify updating product limit for a product
	   public void updateProductLimit() throws Exception {
		   String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		   Controls.testStarted(tcName);
			String expectedUpdatedLimit = "351";
			String expectedResetLimit = "349";
			String check1 = "";
			String check2 = "";
			driver.navigate().to(baseUrl + "/admin/products-form.php?id=166617");


			driver.navigate().to(baseUrl + "/admin/function-view.php?test=update_product_limit&product=166617&limited=1&limit=351");
			driver.navigate().to(baseUrl + "/admin/products-form.php?id=166617");
			String actuaUpdatedLLimit = Q_WebElm.xpRetAttr(sanProps, "productLimit.xp", "value");

			System.out.println("Limit initially is set to    " + actuaUpdatedLLimit);

			try {
				Assert.assertEquals(expectedUpdatedLimit, actuaUpdatedLLimit);
				check1 = "pass";
				System.out.println(tcName + " ::     Verified product limit updated ");
			}
			catch(Throwable ex){
				System.out.println(tcName + " ::     Failed to verify product limit updated");
			}

			driver.navigate().to(baseUrl + "/admin/function-view.php?test=update_product_limit&product=166617&limited=1&limit=349");
			driver.navigate().to(baseUrl + "/admin/products-form.php?id=166617");
			String actualResetLimit = Q_WebElm.xpRetAttr(sanProps, "productLimit.xp", "value");
			System.out.println("Limit is set to              " + actualResetLimit);

			try {
				Assert.assertEquals(expectedResetLimit, actualResetLimit, "Pass");
			   check2 = "pass";
			   System.out.println(tcName + " ::     Product Limit been restored");
			}
			catch(Throwable ex){
				System.out.println(tcName + " ::     Failed to restore product limit");
			}
			try{
				Assert.assertEquals(check1, check2, "Pass");
				System.out.println(tcName + " Passed");
				System.out.println(tcName + " ::     Verified product Limit update successfully");
			}
			catch(Throwable ex){
				System.out.println(tcName + " Failed");
				System.out.println(tcName + " ::     Failed to update product limit");
				Assert.fail();
			}
		}

	@Test (priority = 18)// Verify setting stock quantity for a product
	public void setProductStock() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		String check1 = "";
		String check2 = "";

		//
		driver.navigate().to(baseUrl + "/admin/function-view.php?test=set_product_stock&product=166617");

		driver.navigate().to(baseUrl + "/admin/function-view.php?test=set_product_stock&product=166617&stock=10");
		String actualUpdtaedStockValue = Q_WebElm.xpRetText(sanProps, "productStock.xp");

		//WebElement updatedStock = driver.findElement(sqlParser.getObjectLocator("productStock"));
		String expectedPreUpdateValue = "2786";
		String expectedResetStackValue = "2796";


		//String actualUpdtaedStockValue = updatedStock.getText().toString();
		System.out.println("Expected Stock Value " + "\t" + expectedPreUpdateValue + "\t" + "Updtaed Stock Value " + "\t" + actualUpdtaedStockValue);


		try {
		Assert.assertEquals(expectedPreUpdateValue, actualUpdtaedStockValue);
		 check1 = "Pass";

		System.out.println(tcName + " ::     Decreasing Stock amount by 10 verified ");
		}
		catch(Throwable ex){
		System.out.println(tcName + " ::     Failed to decrease Stock amount");
		}
		//
		// Reset Stock value increasing by 10
		//
		driver.navigate().to(baseUrl + "/admin/function-view.php?test=set_product_stock&product=166617&stock=-10");

		String actualResetStockValue = Q_WebElm.xpRetText(sanProps, "productStock.xp");
		System.out.println("Expected reset Value " + "\t" +expectedResetStackValue + "\t" +"actual reset Value " + "\t" + actualResetStockValue);

		try {
		Assert.assertEquals(expectedResetStackValue, actualResetStockValue);
		 check2 = "Pass";

		System.out.println(tcName + " ::     Added back 10 to the stock amount");
		}
		catch(Throwable ex){
		System.out.println(tcName + " ::     Failed to reset stock amount");
		}

		try {
		 Assert.assertEquals(check1, check2, "Pass");
		System.out.println(tcName + " Passed");
		System.out.println(tcName + " ::     Test case ran successfully ");
		}
		catch(Throwable ex){
		System.out.println(tcName + " Failed");
		System.out.println(tcName + " ::     Failed to verify some test steps");
		Assert.fail();
		}
	}
    @AfterTest
    public void endReport(){
    }
    @AfterMethod
    public void tearDown() throws Exception {
        Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
