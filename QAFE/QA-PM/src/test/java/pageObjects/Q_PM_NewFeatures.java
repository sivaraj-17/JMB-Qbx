package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.*;

public class Q_PM_NewFeatures extends Q_PM_Init {
    public Q_PM_NewFeatures formXp(String locator) {
        Q_PM_WebElm.xp(newProp, locator);
        return this;
    }

    public Q_PM_NewFeatures formXp(String begXp, Integer lineItem, String endXp) {
        Q_PM_WebElm.xp(newProp, begXp, lineItem, endXp);
        return this;
    }

    public Q_PM_NewFeatures formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_PM_WebElm.xp(newProp, begXp, row, midXp, column, endXp);
        return this;
    }

    public Q_PM_NewFeatures formInputXp(String locator, String inputValue) {
        Q_PM_WebElm.xpClear(newProp, locator);
        Q_PM_WebElm.xpSend(newProp, locator, inputValue);
        return this;
    }

    public Q_PM_NewFeatures formInputXp(String begXp, Integer lineItem, String endXP, String inputValue) {
        Q_PM_WebElm.xpClear(newProp, begXp, lineItem, endXP);
        Q_PM_WebElm.xpSend(newProp, begXp, lineItem, endXP, inputValue);
        return this;
    }

    public static String strXpText(String locator) {
        return Q_PM_WebElm.xpRetText(newProp, locator);
    }

    public static String strXpText(String begXp, Integer lineItem, String endXp) {
        return Q_PM_WebElm.xpRetText(newProp, begXp, lineItem, endXp);
    }

    public static String strXpText(String begXp, Integer row, String midXp, Integer cell, String endXp) {
        return Q_PM_WebElm.xpRetText(newProp, begXp, row, midXp, cell, endXp);
    }

    public static String numberReturn(String locator) {
        return Q_PM_WebElm.xpRetTextReplace(newProp, locator);
    }

    public static String numberReturn(String begXp, Integer lineItem, String endXp) {
        return Q_PM_WebElm.xpRetTextReplace(newProp, begXp, lineItem, endXp);
    }

    public static String numberReturn(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_PM_WebElm.xpRetTextReplace(newProp, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public Q_PM_NewFeatures formReturnText(String locator) {
        Q_PM_WebElm.xpRetText(newProp, locator);
        return this;
    }

    public Q_PM_NewFeatures formReturnText(String begXp, Integer lineItem, String endXp) {
        Q_PM_WebElm.xpRetText(newProp, begXp, lineItem, endXp);
        return this;
    }

    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_PM_WebElm.xpRetText(newProp, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public static String formReturnTextReplace(String locator) {
        return Q_PM_WebElm.xpRetTextReplace(newProp, locator);
    }

    public Q_PM_NewFeatures formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_PM_WebElm.xpRetTextReplace(newProp, begXp, lineItem, endXp);
        return this;
    }

    public Q_PM_NewFeatures formReturnAttribute(String locator, String attr) {
        Q_PM_WebElm.xpRetAttr(newProp, locator, attr);
        return this;
    }

    public static String attReturn(String locator, String attr) {
        return Q_PM_WebElm.xpRetAttr(newProp, locator, attr);

    }

    public static String attReturn(String begXp, Integer lineItem, String endXp, String attr) {
        return Q_PM_WebElm.xpAttribute(newProp, begXp, lineItem, endXp, attr);
    }

    public Q_PM_NewFeatures formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_PM_WebElm.xpAttribute(newProp, begXp, lineItem, endXp, attr);
        return this;
    }

    public Q_PM_NewFeatures formReturnAttributeReplace(String locator) {
        Q_PM_WebElm.xpReturnAttributeReplace(newProp, locator);
        return this;
    }

    public Q_PM_NewFeatures formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_PM_WebElm.xpReturnAttributeReplace(newProp, begXp, lineItem, endXp);
        return this;
    }

    public Q_PM_NewFeatures formXpDisplayed(String locator) {
        try {
            Q_PM_WebElm.xpDisplayed(newProp, locator).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Q_PM_NewFeatures formXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_PM_WebElm.xpDisplayed(newProp, begXp, lineItem, endXP).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Q_PM_NewFeatures formXpTab(String locator) {
        Q_PM_WebElm.xpSendTab(newProp, locator);
        return this;
    }

    public Q_PM_NewFeatures formXpTab(String begXp, Integer lineItem, String endXP) {
        Q_PM_WebElm.xpSendTab(newProp, begXp, lineItem, endXP);
        return this;
    }

    public Q_PM_NewFeatures formXpEnter(String locator) {
        Q_PM_WebElm.xpSendEnter(newProp, locator);
        return this;
    }

    public Q_PM_NewFeatures formXpEnter(String begXp, Integer lineItem, String endXP) {
        Q_PM_WebElm.xpSendEnter(newProp, begXp, lineItem, endXP);
        return this;
    }

    public static boolean isXpDisplayed(String locator) {
        return Q_PM_WebElm.xpEnabled(newProp, locator).equals(true);
    }

    public static boolean isXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_PM_WebElm.xpDisplayed(newProp, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            System.out.println(ex);
            return false;
        }
    }

    public static boolean isXpCheckSelected(String locator) {
        return Q_PM_WebElm.xpSelected(newProp, locator).equals(true);
    }

    public static boolean isXpCheckSelected(String begXp, Integer lineItem, String endXP) {
        return Q_PM_WebElm.xpSelected(newProp, begXp, lineItem, endXP).equals(true);
    }

    public static boolean isXpCheckEnabled(String locator) {
        return Q_PM_WebElm.xpEnabled(newProp, locator).equals(true);
    }

    public static boolean isXpCheckEnabled(String begXp, Integer lineItem, String endXP) {
        try {
            Q_PM_WebElm.xpEnabled(newProp, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            return false;
        }
    }

    public Q_PM_NewFeatures formXpSelectIndex(String locator, Integer index) {
        Q_PM_WebElm.xpSelectIndex(newProp, locator, index);
        return this;
    }

    public Q_PM_NewFeatures formXpSelectValue(String locator, String value) {
        Q_PM_WebElm.xpSelectValue(newProp, locator, value);
        return this;
    }

    public Q_PM_NewFeatures formXpSelectText(String locator, String text) {
        Q_PM_WebElm.xpSelectText(newProp, locator, text);
        return this;
    }

    public Q_PM_NewFeatures formId(String locator) {
        Q_PM_WebElm.id(newProp, locator);
        return this;
    }

    public Q_PM_NewFeatures formInputId(String locator, String inputValue) {
        Q_PM_WebElm.idClear(newProp, locator);
        Q_PM_WebElm.idSend(newProp, locator, inputValue);
        return this;
    }

    public Q_PM_NewFeatures formIdTab(String locator) {
        Q_PM_WebElm.idSendTab(newProp, locator);
        return this;
    }

    public static String strIdText(String locator) {
        return Q_PM_WebElm.idRetText(newProp, locator);
    }

    public static String idStrRet(String locator) {
        return Q_PM_WebElm.idRetText(newProp, locator);
    }

    public static String idNumberReturn(String locator) {
        return Q_PM_WebElm.idRetTextRep(newProp, locator);
    }

    public static String idAttRet(String locator, String attr) {
        return Q_PM_WebElm.idAttrRet(newProp, locator, attr);
    }

    public static boolean isIdDisplayed(String locator) {
        return Q_PM_WebElm.idDisplayed(newProp, locator).equals(true);
    }

    public static boolean isIdCheckEnabled(String locator) {
        return Q_PM_WebElm.idEnabled(newProp, locator).equals(true);
    }

    public Q_PM_NewFeatures formIdSelectIndex(String locator, Integer index) {
        Q_PM_WebElm.idSelectIndex(newProp, locator, index);
        return this;
    }

    public Q_PM_NewFeatures formIdSelectValue(String locator, String value) {
        Q_PM_WebElm.idSelectValue(newProp, locator, value);
        return this;
    }

    public Q_PM_NewFeatures formIdSelectText(String locator, String text) {
        Q_PM_WebElm.idSelectText(newProp, locator, text);
        return this;
    }

    public static Integer rowCount(String locator) {
        Integer count = Q_PM_WebElm.xpCountTableRows(newProp, locator);
        return count;
    }
    
    // JMB-6657 Start
 	// *******************************************************************
 	// * Description: SSO site login
 	// * Param: NA
 	// * Returns: NA
 	// * Status: Complete
 	// *******************************************************************/
 	public static void ssoLogin() {
 		String baseUrl = "https://sso.jmbullion.com/login/login.htm?";
 		driver.get(baseUrl);
 		Q_PM_WebElm.xpSend(newProp, "nf.pm.login.xp", "qa@jmbullion.com");
 		Q_PM_WebElm.xpSend(newProp, "nf.pm.password.xp", "Te$t2022");
 		Q_PM_WebElm.xp(newProp, "nf.pm.loginSubmit.xp");

 	}

 	// *******************************************************************
 	// * Description: SSO login for JM
 	// * Param: String
 	// * Returns: NA
 	// * Status: Complete
 	// *******************************************************************/
 	public static void ssoLoginPM() {
 		WebDriverWait wait = new WebDriverWait(driver, 30);
 		if (baseUrl.equals("https://qa.providentmetals.com")) {
 			Q_PM_WebElm.xp(newProp, "nf.pm.qaPM.xp");
 			Q_PM_WebElm.myWait(3000);
 			Q_PM_Controls.switchWin();
 			wait.until(ExpectedConditions
 					.visibilityOfElementLocated(By.xpath(newProp.getProperty("nf.pm.pmwelcome.xp"))));
 			String QAPM = driver.getCurrentUrl();
 			System.out.println("Current URL:" + QAPM);
 			Assert.assertEquals(baseUrl + "/", QAPM);
 		} else if (baseUrl.equals("https://staging.providentmetals.com")) {
 			Q_PM_WebElm.xp(newProp, "nf.pm.stagingPM.xp");
 			Q_PM_WebElm.myWait(3000);
 			Q_PM_Controls.switchWin();
 			wait.until(ExpectedConditions
 					.visibilityOfElementLocated(By.xpath(newProp.getProperty("nf.pm.stagingLogout.xp"))));
 			String StagePM = driver.getCurrentUrl();
 			System.out.println("Current URL:" + StagePM);
 			Assert.assertEquals(baseUrl + "/", StagePM);
 		} else {
 			Assert.fail("Enter a valid environment QA/Staging");
 		}

 	}

 	// *******************************************************************
 	// * Description: Verify plugin version
 	// * Param: String
 	// * Returns: NA
 	// * Status: Complete
 	// *******************************************************************/
 	public static void pluginVersion(String activePlugin, String version) {

 		int flag = 0;
 		driver.navigate().to(baseUrl + "/wp-admin/plugins.php");
 		Q_PM_WebElm.xp(newProp, "nf.pm.plugins.xp");
 		int size = driver.findElements(By.xpath(newProp.getProperty("nf.pm.pluginVersion.xp.beg") + "*"
 				+ newProp.getProperty("nf.pm.pluginVersion.xp.end"))).size();
 		System.out.println("Total size of active plugin: " + size);

 		for (int i = 1; i <= size; i++) {
 			String totalActive = driver.findElement(By.xpath(newProp.getProperty("nf.pm.pluginVersion.xp.beg") + i
 					+ newProp.getProperty("nf.pm.pluginVersion.xp.end"))).getText();
 			if (totalActive.contains(activePlugin)) {
 				flag = 1;
 				System.out.println("activeplugin: " + activePlugin);
 				String currentVersion = Q_PM_WebElm.xpRetText(newProp, "nf.pm.version.xp.beg", i, "nf.pm.version.xp.end");
 				System.out.println("currentVersion: " + currentVersion);
 				Assert.assertTrue(currentVersion.contains(version));
 				break;
 			}
 		}

 		Assert.assertTrue(flag == 1, "Plugin Not Found");

 	}
 	// JMB-6657 End
 	
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
	
	//JMB-6867 Start
	/**
	 * This method Verify user can able to search any item in the search box at the
	 * top
	 * 
	 * @param SearchMethod at top
	 */
	public void topSearchBar(String topSearchBar) {
		Q_PM_WebElm.xp(newProp, "sch.searchBarTop.xp");
		Q_PM_WebElm.xpSend(newProp, "sch.enterTextSearchBarTop.xp", topSearchBar);
		Q_PM_WebElm.xp(newProp, "sch.clickSearchButtonTop.xp");
		Q_PM_WebElm.xpDisplayed(newProp, "sch.searchResultsText.xp");
	}
	//JMB-6867 End
}
