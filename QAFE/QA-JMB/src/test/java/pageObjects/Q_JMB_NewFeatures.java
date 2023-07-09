package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.Q_JMB_Init;

public class Q_JMB_NewFeatures extends Q_JMB_Init {
    public Q_JMB_NewFeatures formXp(String locator) {
        Q_JMB_WebElm.xp(newProp, locator);
        return this;
    }

    public Q_JMB_NewFeatures formXp(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xp(newProp, begXp, lineItem, endXp);
        return this;
    }

    public Q_JMB_NewFeatures formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_JMB_WebElm.xp(newProp, begXp, row, midXp, column, endXp);
        return this;
    }

    public Q_JMB_NewFeatures formInputXp(String locator, String inputValue) {
        Q_JMB_WebElm.xpClear(newProp, locator);
        Q_JMB_WebElm.xpSend(newProp, locator, inputValue);
        return this;
    }

    public Q_JMB_NewFeatures formInputXp(String begXp, Integer lineItem, String endXP, String inputValue) {
        Q_JMB_WebElm.xpClear(newProp, begXp, lineItem, endXP);
        Q_JMB_WebElm.xpSend(newProp, begXp, lineItem, endXP, inputValue);
        return this;
    }

    public static String strXpText(String locator) {
        return Q_JMB_WebElm.xpRetText(newProp, locator);
    }

    public static String strXpText(String begXp, Integer lineItem, String endXp) {
        return Q_JMB_WebElm.xpRetText(newProp, begXp, lineItem, endXp);
    }

    public static String strXpText(String begXp, Integer row, String midXp, Integer cell, String endXp) {
        return Q_JMB_WebElm.xpRetText(newProp, begXp, row, midXp, cell, endXp);
    }

    public static String numberReturn(String locator) {
        return Q_JMB_WebElm.xpRetTextReplace(newProp, locator);
    }

    public static String numberReturn(String begXp, Integer lineItem, String endXp) {
        return Q_JMB_WebElm.xpRetTextReplace(newProp, begXp, lineItem, endXp);
    }

    public static String numberReturn(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_JMB_WebElm.xpRetTextReplace(newProp, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public Q_JMB_NewFeatures formReturnText(String locator) {
        Q_JMB_WebElm.xpRetText(newProp, locator);
        return this;
    }

    public Q_JMB_NewFeatures formReturnText(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xpRetText(newProp, begXp, lineItem, endXp);
        return this;
    }

    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_JMB_WebElm.xpRetText(newProp, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public static String formReturnTextReplace(String locator) {
        return Q_JMB_WebElm.xpRetTextReplace(newProp, locator);
    }

    public Q_JMB_NewFeatures formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xpRetTextReplace(newProp, begXp, lineItem, endXp);
        return this;
    }

    public Q_JMB_NewFeatures formReturnAttribute(String locator, String attr) {
        Q_JMB_WebElm.xpRetAttr(newProp, locator, attr);
        return this;
    }

    public static String attReturn(String locator, String attr) {
        return Q_JMB_WebElm.xpRetAttr(newProp, locator, attr);

    }

    public static String attReturn(String begXp, Integer lineItem, String endXp, String attr) {
        return Q_JMB_WebElm.xpAttribute(newProp, begXp, lineItem, endXp, attr);
    }

    public Q_JMB_NewFeatures formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_JMB_WebElm.xpAttribute(newProp, begXp, lineItem, endXp, attr);
        return this;
    }

    public Q_JMB_NewFeatures formReturnAttributeReplace(String locator) {
        Q_JMB_WebElm.xpReturnAttributeReplace(newProp, locator);
        return this;
    }

    public Q_JMB_NewFeatures formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_JMB_WebElm.xpReturnAttributeReplace(newProp, begXp, lineItem, endXp);
        return this;
    }

    public Q_JMB_NewFeatures formXpDisplayed(String locator) {
        try {
            Q_JMB_WebElm.xpDisplayed(newProp, locator).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Q_JMB_NewFeatures formXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_JMB_WebElm.xpDisplayed(newProp, begXp, lineItem, endXP).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Q_JMB_NewFeatures formXpTab(String locator) {
        Q_JMB_WebElm.xpSendTab(newProp, locator);
        return this;
    }

    public Q_JMB_NewFeatures formXpTab(String begXp, Integer lineItem, String endXP) {
        Q_JMB_WebElm.xpSendTab(newProp, begXp, lineItem, endXP);
        return this;
    }

    public Q_JMB_NewFeatures formXpEnter(String locator) {
        Q_JMB_WebElm.xpSendEnter(newProp, locator);
        return this;
    }

    public Q_JMB_NewFeatures formXpEnter(String begXp, Integer lineItem, String endXP) {
        Q_JMB_WebElm.xpSendEnter(newProp, begXp, lineItem, endXP);
        return this;
    }

    public static boolean isXpDisplayed(String locator) {
        return Q_JMB_WebElm.xpEnabled(newProp, locator).equals(true);
    }

    public static boolean isXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_JMB_WebElm.xpDisplayed(newProp, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            System.out.println(ex);
            return false;
        }
    }

    public static boolean isXpCheckSelected(String locator) {
        return Q_JMB_WebElm.xpSelected(newProp, locator).equals(true);
    }

    public static boolean isXpCheckSelected(String begXp, Integer lineItem, String endXP) {
        return Q_JMB_WebElm.xpSelected(newProp, begXp, lineItem, endXP).equals(true);
    }

    public static boolean isXpCheckEnabled(String locator) {
        return Q_JMB_WebElm.xpEnabled(newProp, locator).equals(true);
    }

    public static boolean isXpCheckEnabled(String begXp, Integer lineItem, String endXP) {
        try {
            Q_JMB_WebElm.xpEnabled(newProp, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            return false;
        }
    }

    public Q_JMB_NewFeatures formXpSelectIndex(String locator, Integer index) {
        Q_JMB_WebElm.xpSelectIndex(newProp, locator, index);
        return this;
    }

    public Q_JMB_NewFeatures formXpSelectValue(String locator, String value) {
        Q_JMB_WebElm.xpSelectValue(newProp, locator, value);
        return this;
    }

    public Q_JMB_NewFeatures formXpSelectText(String locator, String text) {
        Q_JMB_WebElm.xpSelectText(newProp, locator, text);
        return this;
    }

    public Q_JMB_NewFeatures formId(String locator) {
        Q_JMB_WebElm.id(newProp, locator);
        return this;
    }

    public Q_JMB_NewFeatures formInputId(String locator, String inputValue) {
        Q_JMB_WebElm.idClear(newProp, locator);
        Q_JMB_WebElm.idSend(newProp, locator, inputValue);
        return this;
    }

    public Q_JMB_NewFeatures formIdTab(String locator) {
        Q_JMB_WebElm.idSendTab(newProp, locator);
        return this;
    }

    public static String strIdText(String locator) {
        return Q_JMB_WebElm.idRetText(newProp, locator);
    }

    public static String idStrRet(String locator) {
        return Q_JMB_WebElm.idRetText(newProp, locator);
    }

    public static String idNumberReturn(String locator) {
        return Q_JMB_WebElm.idRetTextRep(newProp, locator);
    }

    public static String idAttRet(String locator, String attr) {
        return Q_JMB_WebElm.idAttrRet(newProp, locator, attr);
    }

    public static boolean isIdDisplayed(String locator) {
        return Q_JMB_WebElm.idDisplayed(newProp, locator).equals(true);
    }

    public static boolean isIdCheckEnabled(String locator) {
        return Q_JMB_WebElm.idEnabled(newProp, locator).equals(true);
    }

    public Q_JMB_NewFeatures formIdSelectIndex(String locator, Integer index) {
        Q_JMB_WebElm.idSelectIndex(newProp, locator, index);
        return this;
    }

    public Q_JMB_NewFeatures formIdSelectValue(String locator, String value) {
        Q_JMB_WebElm.idSelectValue(newProp, locator, value);
        return this;
    }

    public Q_JMB_NewFeatures formIdSelectText(String locator, String text) {
        Q_JMB_WebElm.idSelectText(newProp, locator, text);
        return this;
    }

    public static Integer rowCount(String locator) {
        Integer count = Q_JMB_WebElm.xpCountTableRows(newProp, locator);
        return count;
    }
    
    //JMB-6657 Start	
    //*******************************************************************
    // * Description: SSO site login
    // * Param: NA
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
  	public static void ssoLogin() {
  		String baseUrl = "https://sso.jmbullion.com/login/login.htm?";
  		driver.get(baseUrl);
  		Q_JMB_WebElm.xpSend(newProp, "jm.login.xp", "qa@jmbullion.com");
  		Q_JMB_WebElm.xpSend(newProp, "jm.password.xp", "Te$t2022");
  		Q_JMB_WebElm.xp(newProp, "jm.loginSubmit.xp");

  	}

  	//*******************************************************************
  	// * Description: SSO login for JM
  	// * Param: String
  	// * Returns: NA
  	// * Status: Complete
  	//*******************************************************************/
  	public static void ssoLoginJM() {
  		WebDriverWait wait = new WebDriverWait(driver, 30);
  		if (baseUrl == "https://qa.jmbullion.com") {
  			Q_JMB_WebElm.xp(newProp, "jm.qaJMB.xp");
  			Q_JMB_WebElm.myWait(3000);
  			switchWin();
  			wait.until(ExpectedConditions
  					.visibilityOfElementLocated(By.xpath(jmbProps.getProperty("acc.myAccountLink.xp"))));
  			String QAJM = driver.getCurrentUrl();
  			System.out.println("Current URL:" + QAJM);
  			Assert.assertEquals("https://qa.jmbullion.com/", QAJM);
  		} else if (baseUrl == "https://staging.jmbullion.com") {
  			Q_JMB_WebElm.xp(newProp, "jm.stagingJMB.xp");
  			Q_JMB_WebElm.myWait(3000);
  			switchWin();
  			wait.until(
  					ExpectedConditions.visibilityOfElementLocated(By.id(jmbProps.getProperty("acc.myAccountLink.xp"))));
  			String StageJM = driver.getCurrentUrl();
  			System.out.println("Current URL:" + StageJM);
  			Assert.assertEquals("https://staging.jmbullion.com/", StageJM);
  		} else {
  			Assert.fail("Enter a valid environment QA/Staging");
  		}
  	}

  	//*******************************************************************
  	// * Description: Verify plugin version
  	// * Param: String
  	// * Returns: NA
  	// * Status: Complete
  	//*******************************************************************/
  	public static void pluginVersion(String activePlugin, String version) {

  		int flag = 0;
  		driver.navigate().to(baseUrl + "/wp-admin/plugins.php");
  		Q_JMB_WebElm.xp(newProp, "jm.plugins.xp");
  		int size = driver.findElements(By.xpath(newProp.getProperty("jm.pluginVersion.xp.beg") + "*"
  				+ newProp.getProperty("jm.pluginVersion.xp.end"))).size();
  		System.out.println("Total size of active plugin: " + size);

  		for (int i = 1; i <= size; i++) {
  			String totalActive = driver.findElement(By.xpath(newProp.getProperty("jm.pluginVersion.xp.beg") + i
  					+ newProp.getProperty("jm.pluginVersion.xp.end"))).getText();
  			if (totalActive.contains(activePlugin)) {
  				flag = 1;
  				System.out.println("activeplugin: " + activePlugin);
  				String currentVersion = Q_JMB_WebElm.xpRetText(newProp, "jm.version.xp.beg",i,"jm.version.xp.end");
  				System.out.println("currentVersion: " + currentVersion);
  				Assert.assertTrue(currentVersion.contains(version));
  				break;
  			}
  		}

  		Assert.assertTrue(flag == 1, "Plugin Not Found");

  	}
  	
  	public static void switchWin() {
  		String winHandleBefore = driver.getWindowHandle();
  		for (String winHandle : driver.getWindowHandles()) {
  			driver.switchTo().window(winHandle);
  		}
  	}
  	// JMB-6657 End

  	//JMB-6652 Start
    /**
	 * Searches the page with the @param to tell if its present and return its
	 * status
	 * 
	 * @param productTitle
	 */
    public static void searchThroughMainBox(String input) {
    	Q_JMB_NewFeatures nf= new Q_JMB_NewFeatures();
    	nf.formInputId("homepage.searchField.id", input);
    	nf.formXp("homepage.searchIcon.xp");
    	Q_JMB_WebElm.myWait(2000);
    }
	/**
	 * Searches the page with the @param to know if the price is 
	 * displayed for an OOS product
	 * 
	 * @param productTitle
	 */
	public static void priceInfo_OOSproducts() {
		int count = Q_JMB_WebElm.xpCountTableRows(newProp, "count.products.xp");
		for (int i = 1; i <= count; i++) {
			if (productStatus_SearchPage(i).contains("Out of Stock")) {
				System.out.println(strXpText("itemDescription.beg.xp", i, "itemDescription.end.xp"));
				Assert.assertFalse(Q_JMB_WebElm.xpDisplayed(newProp, "products.priceText.beg.xp", i, "products.priceText.end.xp"), "An OOS product has price displayed");
			}
		}
	}
	/**
	 * To return product status if its in or out of stock
	 * 
	 * @param item- Integer
	 * @return visible text from concatenated xpath
	 */
	public static String productStatus_SearchPage(Integer item) {
		String begQtyXp = "itemDescription.beg.xp";
		String endQtyXp = "product.status.end.xp";
		return Q_JMB_WebElm.xpRetText(newProp, begQtyXp, item, endQtyXp);
	}
	//JMB-6652 End
	
	//JMB-6786 Start
	//*******************************************************************
	// * Description: Verify DisableEmbeds securities 
	// * Param: String
	// * Returns: NA
	// * Status: Complete
	//*****************************************************************/
	
	public static void verifyDisableEmbeds(String text) {
		String value1=driver.getPageSource();
		Assert.assertFalse(value1.contains(text), "HTML source code contains text of: "+text);
		System.out.println("HTML source code doesn't contain the text: "+text);
	}
	//JMB-6786 End
	
	//JMB-7211 Start
	/*******************************************************************
    // * Description: verify palladium product link
    // * Para: NA
    // * Status: Complete
    //*******************************************************************/
	public void verifyPalladiumProductLink() {
			Q_JMB_WebElm.xp(jmbProps, "jm.palladiumBars.xp");
			String url1=driver.getCurrentUrl();
			System.out.println("Current URL"+ url1);
			Assert.assertEquals(url1, "https://qa.jmbullion.com/palladium/palladium-bars/", "The link did not navigates to right page");
			System.out.println("The link navigates to Palladium bars page correctly: " + url1);
			Q_JMB_WebElm.myWait(2000);
			driver.navigate().back();
			Q_JMB_WebElm.xp(jmbProps, "jm.palladiumCoins.xp");
			String url2=driver.getCurrentUrl();
			System.out.println("Current URL"+ url2);
			Assert.assertEquals(url2, "https://qa.jmbullion.com/palladium/palladium-coins/", "The link did not navigates to right page");
			System.out.println("The link navigates to Palladium coins page correctly" + url1);
	}
	//JMB-7211 End
	
	//JMB-6967 Start
	/**
	 * This method selects the verifies the active Shipping Method
	 * 
	 * @param shippingMethod
	 */
	public void verifyActiveShippingMethod(String shippingMethod) {
		String value = Q_JMB_WebElm.xpRetText(newProp, "chk.activeShippingMethod.xp").replace("\n", " ");
		Assert.assertEquals(value, shippingMethod, "Verify sipping method '" + shippingMethod + "' active failed.");
	}

	/**
	 * This method Verify user can able to search any item in the search box
	 * 
	 * @param SearchMethod
	 */	
	public void topSearchBar(String topSearchBar) {

		Q_JMB_WebElm.xp(newProp, "sch.searchBarTop.xp");
		Q_JMB_WebElm.xpSend(newProp, "sch.enterTextSearchBarTop.xp", topSearchBar);
		Q_JMB_WebElm.xp(newProp, "sch.clickSearchButtonTop.xp");
		Q_JMB_WebElm.xpDisplayed(newProp, "sch.searchResultsText.xp");
	}		

	/**
	 * This method Verify user can able to search any item in the search box at the
	 * bottom
	 * 
	 * @param SearchMethod at bottom
	 */
	public void innerSearchBar(String innerSearchBar) {

		Q_JMB_WebElm.xpClear(newProp, "sch.enterTextSearchBarInner.xp");
		Q_JMB_WebElm.xpSend(newProp, "sch.enterTextSearchBarInner.xp", innerSearchBar);
		Q_JMB_WebElm.xp(newProp, "sch.clickSearchButtonInner.xp");
		Q_JMB_WebElm.xpDisplayed(newProp, "sch.searchResultsText.xp");
	}
	//JMB-6967 End
	
}
