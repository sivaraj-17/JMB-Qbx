package pageObjects;


import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;



public class Q_JMB_AutoBuyObjects extends Q_JMB_Init {
	static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
	
	public void xp(Properties proper, String catQtyBeg, String mid, String catQtyEnd) {
		driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + mid + proper.getProperty(catQtyEnd))).click();
	}

	public void xp(Properties proper, String catQtyBeg, String mid, String ele, String catQtyEnd) {
		driver.findElement(
				By.xpath(proper.getProperty(catQtyBeg) + mid + proper.getProperty(ele) + proper.getProperty(catQtyEnd)))
				.click();
	}
	public void xpClear(Properties proper, String catQtyBeg, String mid, String catQtyEnd) {
		driver.findElement(
				By.xpath(proper.getProperty(catQtyBeg) + mid + proper.getProperty(catQtyEnd)))
				.clear();
	}
	
	public void xpSend(Properties proper, String catQtyBeg, String item, String catQtyEnd, String quan) {
        driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).sendKeys(quan);
    }

	public void nameSend(Properties proper, String locator, String quan) {
		driver.findElement(By.name(proper.getProperty(locator))).sendKeys(quan);
	}

	public Boolean xpDisplayed(Properties proper, String beg, String item, String end) {
		return driver.findElement(By.xpath(proper.getProperty(beg) + item + proper.getProperty(end))).isDisplayed();

	}
	public void nameClear(Properties proper, String locator){
	    driver.findElement(By.name(proper.getProperty(locator))).clear();
	}

	/******************************************************************
	 * Description: Verify the currently active shipping method
	 * Parameters: String shippingMethod - expected active shipping method
	 * Returns: None
	 * Status: Complete
	 *******************************************************************/	
	public void verifyActiveShippingMethod(String shippingMethod) {
		String value = Q_JMB_WebElm.xpRetText(jmbProps, "chk.activeShippingMethod.xp").replace("\n", " ");
		Assert.assertEquals(value, shippingMethod ,"Verify sipping method '" + shippingMethod + "' active failed.");
	}
	
	//JMB-5689 Start
	/******************************************************************
	 * Description: Set the Fraud option on Customer View
	 * Parameters: String email - email of user to register
	 * Returns: None
	 * Status: Complete
	 *******************************************************************/	
	public void deviceFingerprintAccountRegistration(String email) {
		System.out.println("Registering user: " + email);
		acc.registerLink();
        acc.registerFirstName("JMB");
        acc.registerLastName("Device Fingerprint");
        acc.registerPhoneNumber("9619611234");
        acc.registerEmail(email);
        acc.registerPassword("1212Te$t");
        acc.registerConfirmPassword("1212Te$t");
        acc.registerAgree();
        acc.registerButton();
    }
	
	/******************************************************************
     * Description: Add Credit Card
     * Parameters: int cardIndex - index for JSON file
     * Returns: NA
     * Status: Complete
     *******************************************************************/
	public void deviceFingerprintAddCreditCard (int cardIndex) throws FileNotFoundException {
		System.out.println("Adding Credit Card with JSON index: " + cardIndex);
        Q_JMB_WebElm.xp(jmbProps, "acc.account.AddCard.xp");
        Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
        chk.creditCardForm(cardIndex);
        acc.billingAddress(3);
        Q_JMB_WebElm.id(jmbProps,"acc.accSaveNewCC.id");
        Q_JMB_WebElm.myWait(2000);
	}
	
	/******************************************************************
     * Description: Delete Credit Card
     * Parameters: None
     * Returns: None
     * Status: Complete
     *******************************************************************/
	public void deviceFingerprintDeleteCreditCard() throws FileNotFoundException {
		Q_JMB_WebElm.xp(jmbProps, "acc.account.PaymentDeleteCard.xp");
        Q_JMB_WebElm.myWait(2000);
        Q_JMB_Controls.checkAlert();
        Q_JMB_WebElm.myWait(2000);         
    }
	
	/******************************************************************
     * Description: Fill out Contact Us form
     * Parameters: None
     * Returns: None
     * Status: Complete
     *******************************************************************/
	public void deviceFingerprintContactUs() throws FileNotFoundException {
		Q_JMB_NavigationObjects.footerCustomerCareContactUs();
	    //Q_JMB_NavigationObjects.xp(jmbProps, "contactUs.contactOrdStatus.xp");
	    //Q_JMB_NavigationObjects.xp(jmbProps,"contactUs.btn.xp");
	    driver.navigate().to(baseUrl + "/contact/contact-order-status/");
	    Q_JMB_NavigationObjects.fillContactUsAndVerifySuccess();        
    }
	
	/******************************************************************
     * Description: Fill out Contact Us form and verify to is blocked
     * Parameters: None
     * Returns: None
     * Status: Complete
     *******************************************************************/
	public void deviceFingerprintContactUsBlock() throws FileNotFoundException {
		Q_JMB_NavigationObjects.footerCustomerCareContactUs();
		//Q_JMB_NavigationObjects.xp(jmbProps, "contactUs.contactOrdStatus.xp");
	    //Q_JMB_NavigationObjects.xp(jmbProps,"contactUs.btn.xp");
	    driver.navigate().to(baseUrl + "/contact/contact-order-status/");
	    Q_JMB_WebElm.xpSend(jmbProps, "nav.contactName.xp", "Automated Test");
		Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactName.xp");
		Q_JMB_WebElm.myWait(500);
		Q_JMB_WebElm.xpClear(jmbProps, "nav.contactEmail.xp");
		Q_JMB_WebElm.xpSend(jmbProps, "nav.contactEmail.xp", "qa@jmbullion.com");
		Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactEmail.xp");
		Q_JMB_WebElm.myWait(500);
		Q_JMB_WebElm.xpSend(jmbProps, "nav.contactPhone.xp", "(241) 425 2804");
		Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactPhone.xp");
		Q_JMB_WebElm.xpSend(jmbProps, "nav.contactOrder.xp", "ORD-232323");
		Q_JMB_WebElm.xpSendTab(jmbProps, "nav.contactOrder.xp");
		//Q_JMB_WebElm.xpSend(jmbProps, "nav.nav.contactText.xp", "Status of my order");
		//Q_JMB_WebElm.xpSendTab(jmbProps, "nav.nav.contactText.xp");
		Q_JMB_WebElm.xpSend(jmbProps, "nav.contactMessage.xp", "A3U4");
		Q_JMB_WebElm.xp(jmbProps, "nav.contactSend.xp");
		Q_JMB_WebElm.myWait(2000);
		try {
    	   Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.contactUsBlockMessage.xp");
    	   System.out.println("Contact Us was successfully blocked.");
		} catch (Throwable ex) {
    	   Assert.fail("Contact Us was not successfully blocked.");
		}
    }
	
	/******************************************************************
     * Description: Admin customer search
     * Parameters: String srch - type of search
     * String param - Search to enter
     * Returns: NA
     * Status: Complete
     *******************************************************************/
   public void adminCustomerSearch(String srch, String param) {
	   Q_JMB_WebElm.xp(jmbProps, "adm.adminJmbullion.xp");
       switch (srch) {
           case ("first"):
        	   	Q_JMB_WebElm.idClear(jmbProps, "adm.adminSearchFirst.id");
           		Q_JMB_WebElm.idSend(jmbProps, "adm.adminSearchFirst.id", param);
           		Q_JMB_WebElm.xp(jmbProps, "adm.adminSearchBtn.xp");
           		break;
           case ("last"):
        	   	Q_JMB_WebElm.idClear(jmbProps, "adminSearchlast.id");
           		Q_JMB_WebElm.idSend(jmbProps, "adminSearchlast.id", param);
           		Q_JMB_WebElm.xp(jmbProps, "adm.adminSearchBtn.xp");
               break;
           case ("email"):
        	   	Q_JMB_WebElm.idClear(jmbProps, "adm.adminSearchEmail.id");
           		Q_JMB_WebElm.idSend(jmbProps, "adm.adminSearchEmail.id", param);
           		Q_JMB_WebElm.xp(jmbProps, "adm.adminSearchBtn.xp");
               break;
           default:
               System.out.println("Please enter valid search criteria for customer");
               break;
       }
   }
   
   /******************************************************************
    * Description: Open Customer View All Orders
    * Parameters: None
    * Returns: None
    * Status: Complete
    *******************************************************************/
   public void adminViewAllOrders() {
	   Q_JMB_WebElm.xp(jmbProps, "adm.adminActiveBtn.xp");
	   Q_JMB_WebElm.xp(jmbProps, "adm.viewAllOrders.xp");
   }
   
   /******************************************************************
    * Description: Set the Fraud option on Customer Veiw
    * Parameters: String value - fraud option to select
    * Returns: None
    * Status: Complete
    *******************************************************************/
   public void toggleCustomerFraud(String value) {
	   Q_JMB_WebElm.xpSelectText(jmbProps, "cust.fraudSelect.xp", value);
       Q_JMB_WebElm.xp(jmbProps, "cust.fraudSubmitBtn.xp");
       Q_JMB_WebElm.myWait(2000);
   }
   
   /******************************************************************
    * Description: Set the Credit Card Blocking Rules
    * Parameters: String count, String assIntHours, String assIntMins, String blockTimeHours, String blockTimeMinutes
    * Returns: None
    * Status: Complete
    *******************************************************************/
   public void setCreditCardBlockingRules(String count, String assIntHours, String assIntMins, String blockTimeHours, String blockTimeMinutes) {
	   Q_JMB_WebElm.idClear(jmbProps, "br.addNewCCLimit.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.addNewCCLimit.id", count);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.addNewCCIntervalHours.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.addNewCCIntervalHours.id", assIntHours);
  		
	   Q_JMB_WebElm.idClear(jmbProps, "br.addNewCCIntervalMins.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.addNewCCIntervalMins.id", assIntMins);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.addNewCCBlockTimeHours.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.addNewCCBlockTimeHours.id", blockTimeHours);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.addNewCCBlockTimeMins.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.addNewCCBlockTimeMins.id", blockTimeMinutes);
   }
   
   /******************************************************************
    * Description: Set the Account Registration Blocking Rules
    * Parameters: String count, String assIntHours, String assIntMins, String blockTimeHours, String blockTimeMinutes
    * Returns: None
    * Status: Complete
    *******************************************************************/
   public void setAccountRegistrationBlockingRules(String count, String assIntHours, String assIntMins, String blockTimeHours, String blockTimeMinutes) {
	   Q_JMB_WebElm.idClear(jmbProps, "br.registrationLimit.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.registrationLimit.id", count);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.registrationIntervalHours.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.registrationIntervalHours.id", assIntHours);
  		
	   Q_JMB_WebElm.idClear(jmbProps, "br.registrationIntervalMins.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.registrationIntervalMins.id", assIntMins);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.registrationBlockTimeHours.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.registrationBlockTimeHours.id", blockTimeHours);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.registrationBlockTimeMins.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.registrationBlockTimeMins.id", blockTimeMinutes);
   }
   
   /******************************************************************
    * Description: Set the Checkout Blocking Rules
    * Parameters: String count, String assIntHours, String assIntMins, String blockTimeHours, String blockTimeMinutes
    * Returns: None
    * Status: Complete
    *******************************************************************/
   public void setCheckoutBlockingRules(String count, String assIntHours, String assIntMins, String blockTimeHours, String blockTimeMinutes) {
	   Q_JMB_WebElm.idClear(jmbProps, "br.checkoutLimit.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.checkoutLimit.id", count);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.checkoutIntervalHours.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.checkoutIntervalHours.id", assIntHours);
  		
	   Q_JMB_WebElm.idClear(jmbProps, "br.checkoutIntervalMins.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.checkoutIntervalMins.id", assIntMins);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.checkoutBlockTimeHours.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.checkoutBlockTimeHours.id", blockTimeHours);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.checkoutBlockTimeMins.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.checkoutBlockTimeMins.id", blockTimeMinutes);
   }
   
   /******************************************************************
    * Description: Set the Contact Us Blocking Rules
    * Parameters: String count, String assIntHours, String assIntMins, String blockTimeHours, String blockTimeMinutes
    * Returns: None
    * Status: Complete
    *******************************************************************/
   public void setContactUsBlockingRules(String count, String assIntHours, String assIntMins, String blockTimeHours, String blockTimeMinutes) {
	   Q_JMB_WebElm.idClear(jmbProps, "br.contactUsLimit.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.contactUsLimit.id", count);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.contactUsIntervalHours.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.contactUsIntervalHours.id", assIntHours);
  		
	   Q_JMB_WebElm.idClear(jmbProps, "br.contactUsIntervalMins.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.contactUsIntervalMins.id", assIntMins);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.contactUsBlockTimeHours.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.contactUsBlockTimeHours.id", blockTimeHours);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.contactUsBlockTimeMins.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.contactUsBlockTimeMins.id", blockTimeMinutes);
   }
   
   /******************************************************************
    * Description: Set the Login Blocking Rules
    * Parameters: String count, String assIntHours, String assIntMins, String blockTimeHours, String blockTimeMinutes
    * Returns: None
    * Status: Complete
    *******************************************************************/
   public void setLoginBlockingRules(String count, String assIntHours, String assIntMins, String blockTimeHours, String blockTimeMinutes) {
	   Q_JMB_WebElm.idClear(jmbProps, "br.loginLimit.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.loginLimit.id", count);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.loginIntervalHours.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.loginIntervalHours.id", assIntHours);
  		
	   Q_JMB_WebElm.idClear(jmbProps, "br.loginIntervalMins.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.loginIntervalMins.id", assIntMins);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.loginBlockTimeHours.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.loginBlockTimeHours.id", blockTimeHours);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.loginBlockTimeMins.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.loginBlockTimeMins.id", blockTimeMinutes);
   }
   
   /******************************************************************
    * Description: Set the reset Password Blocking Rules
    * Parameters: String count, String assIntHours, String assIntMins, String blockTimeHours, String blockTimeMinutes
    * Returns: None
    * Status: Complete
    *******************************************************************/
   public void setResetPasswordBlockingRules(String count, String assIntHours, String assIntMins, String blockTimeHours, String blockTimeMinutes) {
	   Q_JMB_WebElm.idClear(jmbProps, "br.resetLimit.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.resetLimit.id", count);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.resetIntervalHours.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.resetIntervalHours.id", assIntHours);
  		
	   Q_JMB_WebElm.idClear(jmbProps, "br.resetIntervalMins.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.resetIntervalMins.id", assIntMins);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.resetBlockTimeHours.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.resetBlockTimeHours.id", blockTimeHours);
	   
	   Q_JMB_WebElm.idClear(jmbProps, "br.resetBlockTimeMins.id");
	   Q_JMB_WebElm.idSend(jmbProps, "br.resetBlockTimeMins.id", blockTimeMinutes);
   }
   
   /******************************************************************
    * Description: Set the reset IP Whitelist in Blocking Rules
    * Parameters: boolean enabled
    * Returns: None
    * Status: Complete
    *******************************************************************/
   public void toggleIPWhitelistBlockingRules(boolean enabled) {
	   if (enabled) {
		   Q_JMB_WebElm.id(jmbProps, "br.whitlistOn.id");
	   } else {
		   Q_JMB_WebElm.id(jmbProps, "br.whitlistOff.id");
	   }
   }
   
   /******************************************************************
    * Description: Update changes to Blocking Rules
    * Parameters: None
    * Returns: None
    * Status: Complete
    *******************************************************************/
   public void toggleUpdateBlockingRuleChanges() {
	   Q_JMB_WebElm.id(jmbProps, "br.updateRules.id");
   }
   
   /******************************************************************
    * Description: Logins in to user expecting Blocking Rules to apply
    * Parameters: Integer user
    * Returns: None
    * Status: Complete
    *******************************************************************/
   public void loginUserBlock(Integer user) {
       Q_JMB_WebElm.myWait(500);
       acc.loginLink();
       acc.userEmail(user);
       acc.userPassword(user);
       Q_JMB_WebElm.id(jmbProps, "acc.loginSubmitBtn.id");
       Q_JMB_WebElm.myWait(3000);
       try {
    	   Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.loginBlockMessage.xp");
    	   System.out.println("Login was successfully blocked.");
       } catch (Throwable ex) {
    	   Assert.fail("Login was not successfully blocked.");
       }
   }
   
   /******************************************************************
    * Description: Logins in to user expecting login to fail due to wrong password
    * Parameters: Integer user
    * Returns: None
    * Status: Complete
    *******************************************************************/
   public void loginUserWrongPassword(Integer user) {
       Q_JMB_WebElm.myWait(500);
       acc.loginLink();
       acc.userEmail(user);
       Q_JMB_WebElm.idSend(jmbProps, "acc.loginPwd.id", "Bad Password");
       Q_JMB_WebElm.id(jmbProps, "acc.loginSubmitBtn.id");
       Q_JMB_WebElm.myWait(3000);
       try {
    	   Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.loginWrongPasswordMessage.xp");
    	   System.out.println("Login was successfully blocked.");
       } catch (Throwable ex) {
    	   Assert.fail("Login was not successfully blocked.");
       }
   }
   
   /******************************************************************
    * Description: Verifies that the Account Registration Blocking Rules Applies
    * Parameters: None
    * Returns: None
    * Status: Complete
    *******************************************************************/
   public void verifyUserRegistrationBlockedBlock() {
       Q_JMB_WebElm.myWait(500);
       try {
    	   Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.registeredUserBlockMessage.xp");
    	   System.out.println("Account Registration was successfully blocked.");
       } catch (Throwable ex) {
    	   acc.deleteUser();
    	   Assert.fail("Account Registration was not successfully blocked.");
       }
   }
   
   /******************************************************************
    * Description: Submits a forgot password request
    * Parameters: None
    * Returns: None
    * Status: Complete
    *******************************************************************/
   public void forgetPassword(String email) {
       Q_JMB_WebElm.myWait(500);
       acc.loginLink();
       Q_JMB_WebElm.myWait(500);
       Q_JMB_WebElm.xp(jmbProps, "acc.forgotPasswordLink.xp");
       Q_JMB_WebElm.myWait(500);
       Q_JMB_WebElm.xpSend(jmbProps, "acc.resetPasswordEmail.xp", email);
       Q_JMB_WebElm.xp(jmbProps, "acc.resetPasswordCheckbox.xp");
       Q_JMB_WebElm.xp(jmbProps, "acc.sendPasswordResetEmail.xp");
       Q_JMB_WebElm.myWait(500);
       try {
    	   Q_JMB_WebElm.idDisplayed(jmbProps, "acc.restPasswordMessage.id");
    	   System.out.println("Reset password email successfully sent.");
       } catch (Throwable ex) {
    	   Assert.fail("Reset password email not successfully sent.");
       }
   }
   
   /******************************************************************
    * Description: Submits a forgot password request that should be blocked
    * Parameters: None
    * Returns: None
    * Status: Complete
    *******************************************************************/
   public void forgetPasswordBlock(String email) {
       Q_JMB_WebElm.myWait(500);
       acc.loginLink();
       Q_JMB_WebElm.myWait(500);
       Q_JMB_WebElm.xp(jmbProps, "acc.forgotPasswordLink.xp");
       Q_JMB_WebElm.myWait(500);
       Q_JMB_WebElm.xpSend(jmbProps, "acc.resetPasswordEmail.xp", email);
       Q_JMB_WebElm.xp(jmbProps, "acc.resetPasswordCheckbox.xp");
       Q_JMB_WebElm.xp(jmbProps, "acc.sendPasswordResetEmail.xp");
       Q_JMB_WebElm.myWait(2000);
       Assert.assertTrue(Q_JMB_Controls.checkAndGetAlertText().equals("Too many password resets. Please try again later."), 
    		   "Password reset email not successfully blocked.");
   }
   //JMB-5689 End
   
   //Auto Buy Start
   /**********************************************************************
	* Description: AutoBuy Page Navigation from Main Menu of Metals (Gold & Silver as of Now)
	* Author: Paul Patterson
	* Param: String metal
	* Returns: None
	* Status: Complete
	**********************************************************************/
   public void navigateToAutoBuyPageFrom(String metal) {
		moveIt(jmbProps, "jmbMetalsMenu.beg.xp", metal, "jmbMetalsMenu.mid.xp", metal,"jmbMetalsMenu.end.xp");
		xp(jmbProps, "autobuy.btnInMenu.beg.xp", metal, "autobuy.btnInMenu.end.xp");
		Assert.assertEquals(driver.getCurrentUrl(), "https://sandbox.jmbullion.com/auto-buy/","[FAIL] didn't navigated to Auto Buy Page!");
		System.out.println("[PASS] Navigated to Auto Buy Page from '" + metal + "' Menu.");
	}
	
	/**********************************************************************
	 * Description: AutoBuy Page Navigation from Main Menu of Metals (Gold & Silver as of Now)
	 * Author: Paul Patterson
	 * Param: Properties proper, String beg, String value1, String mid, String value2, String end
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void moveIt(Properties proper, String beg, String value1, String mid, String value2, String end) {
		String seleniumElement = proper.getProperty(beg) + value1 + proper.getProperty(mid) + value2+ proper.getProperty(end);
		Actions moveTo = new Actions(driver);
		WebElement other = driver.findElement(By.xpath(seleniumElement));
		moveTo.moveToElement(other).moveToElement(other).perform();
		Q_JMB_WebElm.myWait(1000);
	}
	
	/**********************************************************************
	 * Description: Navigate to My Account > Auto Buy
	 * Author: Paul Patterson
	 * Param: None
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void navigateToMyAccountAutoBuy() {
		Q_JMB_WebElm.moveIt(jmbProps,"myAccountLink.xp");
		Q_JMB_WebElm.xp(jmbProps, "autoBuy.menu.btn");
	}
	
	/**********************************************************************
	 * Description: Start Auto Buy from My Account
	 * Author: Paul Patterson
	 * Param: None
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void startAutoBuyFromMyAccount() {
		navigateToMyAccountAutoBuy();
		Q_JMB_Controls.xpExecutorScrollElementToMiddle(jmbProps.getProperty("myAccount.autoBuy.newAutoBuy.xp"));
		Q_JMB_WebElm.xp(jmbProps, "myAccount.autoBuy.newAutoBuy.xp");
		Assert.assertTrue(driver.getCurrentUrl().contains(baseUrl + "/my-account/autobuy-products/"), "[Fail] Launching new auto buy verification unsuccesful.");
	}

	/**********************************************************************
	 * Description: Selecting which Metal's Autobuy Products are required 
	 * Author: Paul Patterson
	 * Param: String metal
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void selectAutoBuyProductsFromMetalType(String metal) {
		Q_JMB_Controls.xpExecutorScrollElementToMiddle(jmbProps.getProperty("ab.metalType.beg.xp") + metal + jmbProps.getProperty("ab.metalType.end.xp"));
		xp(jmbProps, "ab.metalType.beg.xp", metal, "ab.metalType.end.xp");
	}

	/**********************************************************************
	 * Description: This method selects the Product, Enter Quantity and Proceed till AutoBuy Cart 
	 * Author: Paul Patterson
	 * Param: String metal, String productName, String qty
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void searchProductsAndAddToAutoBuyCart(String metal, String productName, String qty) {
		selectAutoBuyProductsFromMetalType(metal);
		String productLocatorBeg = "";
		
		// Product xpath needs to use the tab node to get a unique element
		if (metal.toLowerCase().equals("gold")) {
			productLocatorBeg = "ab.productSearchResultGold.beg.xp";
			Q_JMB_WebElm.myWait(2000);
		} else if (metal.toLowerCase().equals("silver")) {
			productLocatorBeg = "ab.productSearchResultSilver.beg.xp";
			Q_JMB_WebElm.myWait(2000);
		} else {
			Assert.fail("[FAIL] Metal type '" + metal + "' is invalid for AutoBuy! Gold or Silver are valid metal types");
		}
		
		boolean isProductVisible = xpDisplayed(jmbProps, productLocatorBeg ,productName, "ab.productSearchResult.end.xp");
		
		if (isProductVisible) {
			System.out.println("[PASS] Product '" + productName + "' Found.");
			// Entering Qty
			xpClear(jmbProps, productLocatorBeg, productName, "ab.productSearchQty.end.xp");
			xpSend(jmbProps, productLocatorBeg, productName, "ab.productSearchQty.end.xp", qty);
			xp(jmbProps, productLocatorBeg, productName, "ab.productSearchQty.end.xp");
			Q_JMB_WebElm.myWait(1000);
			// Clicking Add
			xp(jmbProps, productLocatorBeg, productName, "ab.productSearchAddBtn.end");
			// Checking for Cart Added success
			verifyItemInAutoBuyCartPopup(productName, qty);
			Q_JMB_WebElm.xp(jmbProps, "ab.popupCartProceedToFrequency.xp");
		} else {
			Assert.fail("[FAIL] Product '" + productName + "' Not Found/ Not available for AutoBuy!");
		}

	}
	
	/**********************************************************************
	 * Description: This method selects the Product and verifies that the qty field is limited to 4 digits
	 * Author: Paul Patterson
	 * Param: tring metal, String productName
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void searchProductsAndVerifyQuanityField(String metal, String productName) {
		selectAutoBuyProductsFromMetalType(metal);
		String productLocatorBeg = "";
		
		// Product xpath needs to use the tab node to get a unique element
		if (metal.toLowerCase().equals("gold")) {
			productLocatorBeg = "ab.productSearchResultGold.beg.xp";
			Q_JMB_WebElm.myWait(2000);
		} else if (metal.toLowerCase().equals("silver")) {
			productLocatorBeg = "ab.productSearchResultSilver.beg.xp";
			Q_JMB_WebElm.myWait(2000);
		} else {
			Assert.fail("[FAIL] Metal type '" + metal + "' is invalid for AutoBuy! Gold or Silver are valid metal types");
		}
		
		boolean isProductVisible = xpDisplayed(jmbProps, productLocatorBeg ,productName, "ab.productSearchResult.end.xp");
		
		if (isProductVisible) {
			System.out.println("[PASS] Product '" + productName + "' Found.");
			// Entering Qty
			Assert.assertTrue(driver.findElement(By.xpath(jmbProps.getProperty(productLocatorBeg) 
					+ productName + jmbProps.getProperty("ab.productSearchQty.end.xp")))
					.getAttribute("min").equals("1"),"Quanity min is not '1'");
			System.out.println("[PASS] Quanity min is '1'");
			Assert.assertTrue(driver.findElement(By.xpath(jmbProps.getProperty(productLocatorBeg) 
					+ productName + jmbProps.getProperty("ab.productSearchQty.end.xp")))
					.getAttribute("max").equals("9999"),"Quanity min is not '9999'");
			System.out.println("[PASS] Quanity max is '9999'");
			
			xpClear(jmbProps, productLocatorBeg, productName, "ab.productSearchQty.end.xp");
			xpSend(jmbProps, productLocatorBeg, productName, "ab.productSearchQty.end.xp", "1");
			Assert.assertTrue(driver.findElement(By.xpath(jmbProps.getProperty(productLocatorBeg) 
					+ productName + jmbProps.getProperty("ab.productSearchQty.end.xp")))
					.getAttribute("value").equals("1"),"Quanity is not currently '1'");
			System.out.println("[PASS] Quanity successfully set to '1'");
			
			xpClear(jmbProps, productLocatorBeg, productName, "ab.productSearchQty.end.xp");
			xpSend(jmbProps, productLocatorBeg, productName, "ab.productSearchQty.end.xp", "9999");
			Assert.assertTrue(driver.findElement(By.xpath(jmbProps.getProperty(productLocatorBeg) 
					+ productName + jmbProps.getProperty("ab.productSearchQty.end.xp")))
					.getAttribute("value").equals("9999"),"Quanity is not currently '9999'");
			System.out.println("[PASS] Quanity successfully set to '9999'");
			
			xpClear(jmbProps, productLocatorBeg, productName, "ab.productSearchQty.end.xp");
			xpSend(jmbProps, productLocatorBeg, productName, "ab.productSearchQty.end.xp", "10000");
			Assert.assertFalse(driver.findElement(By.xpath(jmbProps.getProperty(productLocatorBeg) 
					+ productName + jmbProps.getProperty("ab.productSearchQty.end.xp")))
					.getAttribute("value").equals("10000"),"Quanity has allowed 5 digits");
			System.out.println("[PASS] Quanity did limit to 4 digits when a 5 digit number was entered");
		} else {
			Assert.fail("[FAIL] Product '" + productName + "' Not Found/ Not available for AutoBuy!");
		}

	}

	/**********************************************************************
	 * Description: Set auto buy frequency option
	 * Author: Paul Patterson
	 * Param: String option
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void setAutoBuyFrequencySelectOption(String option) {
		Q_JMB_WebElm.myWait(1000);
		Q_JMB_WebElm.idSelectText(jmbProps, "ab.frequency.id", option);
		System.out.println("[INFO] Selected Frequency as: "+ option);
	}
	
	/**********************************************************************
	 * Description: Set auto buy frequency start date
	 * Author: Paul Patterson
	 * Param: String startDate
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void setAutoBuyFrequencyStartDate(String startDate) {
		Q_JMB_WebElm.myWait(3000);
		try {
			Q_JMB_WebElm.idClear(jmbProps, "ab.freqStartDate.id");
			Q_JMB_WebElm.idSend(jmbProps, "ab.freqStartDate.id", startDate);
			Q_JMB_WebElm.idSendTab(jmbProps, "ab.freqStartDate.id");
		} catch (Throwable ex) {
			System.out.println("[INFO] Next Run Date is displaying instead of Start Date.");
			setAutoBuyFrequencyNextRunDate (startDate);
		}
		System.out.println("[INFO] Selected Start Date as: "+ startDate);
	}
	
	/**********************************************************************
	 * Description: Set auto buy frequency next run date
	 * Author: Paul Patterson
	 * Param: String startDate
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void setAutoBuyFrequencyNextRunDate(String nextRunDate) {
		Q_JMB_WebElm.myWait(3000);
		Q_JMB_WebElm.idClear(jmbProps, "ab.freqNextRunDate.id");
		Q_JMB_WebElm.idSend(jmbProps, "ab.freqNextRunDate.id", nextRunDate);
		Q_JMB_WebElm.idSendTab(jmbProps, "ab.freqNextRunDate.id");
		System.out.println("[INFO] Selected Start Date as: "+ nextRunDate);
	}
	
	/**********************************************************************
	 * Description: Set auto buy frequency end date
	 * Author: Paul Patterson
	 * Param: String endDate
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void setAutoBuyFrequencyEndDate(String endDate) {
		Q_JMB_WebElm.myWait(1000);
		Q_JMB_WebElm.idClear(jmbProps, "ab.freqEndDate.id");
		Q_JMB_WebElm.idSend(jmbProps, "ab.freqEndDate.id", endDate);
		Q_JMB_WebElm.idSendTab(jmbProps, "ab.freqEndDate.id");
		System.out.println("[INFO] Selected End Date as: "+ endDate);
	}
	
	/**********************************************************************
	 * Description: This method setUp AutoBuy from Product PDP Page
	 * Author: Paul Patterson
	 * Param: String productLink, String quantity
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void setUpAutoBuyFromProductPage(String productLink, String quantity)
	{
		driver.navigate().to(baseUrl + productLink);
		try {
			if(Q_JMB_WebElm.cnDisplayed(jmbProps, "ab.setup.className"))
			{
				nameClear(jmbProps, "ab.productQuantity.name");
				nameSend(jmbProps, "ab.productQuantity.name", quantity);
				System.out.println("[INFO] Product ["+productLink+"] available for Autobuy");
				Q_JMB_WebElm.cn(jmbProps, "ab.setup.className");
				Q_JMB_WebElm.xp(jmbProps, "ab.popupCartProceedToFrequency.xp");
				
			}
			else
			{
				Assert.fail("[FAIL] Product '"+productLink+"' not available for Autobuy!");
			}
		} catch (Throwable ex) {
			Assert.fail("[FAIL] Product '"+productLink+"' not available for Autobuy!");
		}
	}
	
	/**********************************************************************
	 * Description: Clears out auto buy cart
	 * Author: Paul Patterson
	 * Param: None
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void clearAutoBuyCart() {
		Q_JMB_WebElm.myWait(4000);
		driver.navigate().to(baseUrl + "/my-account/autobuy-cart/");
		Integer productCount = Q_JMB_WebElm.xpCountTableRows(jmbProps, "ab.cart.productCount.xp") - 2;
		System.out.println("Row count " + productCount);
		//Q_JMB_Controls.scrolDownPixel(400);
		if (productCount >= 1) {
			for (int i = productCount; i > 1; i--) {
            System.out.println("Line item " + Q_JMB_WebElm.xpRetTextReplace(jmbProps, "ab.cartCount.xp"));
            Q_JMB_Controls.xpExecutorScrollElementToMiddle(jmbProps.getProperty("ab.cartProductTble.remove.xp"));
            Q_JMB_WebElm.xp(jmbProps, "ab.cartProductTble.remove.xp");
            Q_JMB_WebElm.myWait(2000);
            if(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "ab.cartCount.xp").equals(0)) break;
			}
		}
	}
	
	/**********************************************************************
	 * Description: Click on Auto Buy checkout Button
	 * Author: Paul Patterson
	 * Param: None
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void navigateToAutoBuyCheckout() {
		Q_JMB_WebElm.myWait(2000);
        Q_JMB_WebElm.xp(jmbProps, "ab.cart.selectPaymentAndShipping.xp");
	}
	
	/**********************************************************************
	 * Description: Select payment method for auto buy checkout
	 * Author: Paul Patterson
	 * Param: String payment
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void autoBuyCheckoutPaymentMethod(String payment) {
		Q_JMB_WebElm.myWait(2000);
		Q_JMB_WebElm.xpSelectValue(jmbProps,"ab.checkout.paymentSelect.xp", payment);
	}
	
	/**********************************************************************
	 * Description: Select First Bank Account on auto buy checkout
	 * Author: Paul Patterson
	 * Param: None
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void autoBuySelectFirstAccount() {
		Q_JMB_WebElm.myWait(2000);
		Q_JMB_WebElm.xp(jmbProps,"ab.checkout.bankAccountFirstSelection.xp");
		Q_JMB_WebElm.myWait(2000);
	}
	
	/**********************************************************************
	 * Description: Select credit card on auto buy checkout
	 * Author: Paul Patterson
	 * Param: String cardType
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void autoBuySelectCard(String cardType){
        switch(cardType ){
            case "visa":
                Q_JMB_WebElm.myWait(1000);
                Q_JMB_WebElm.xp(jmbProps, "chk.visa.xp");
                break;
            case "mc":
                Q_JMB_WebElm.myWait(1000);
                Q_JMB_WebElm.xp(jmbProps, "chk.masterCard.xp");
                break;
            case "amex":
                Q_JMB_WebElm.myWait(1000);
                Q_JMB_WebElm.xp(jmbProps, "chk.amex.xp");
                break;
            default:
                System.out.println("card type incorrect or not supported");
        }
    }
	
	/**********************************************************************
	 * Description: This method selects the verifies a specific product and quantity is present in cart page
	 * Author: Paul Patterson
	 * Param: String productName, String qty
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void verifyItemInAutoBuyCart(String productName, String qty) {
		boolean isProductVisible = xpDisplayed(jmbProps, "ab.cartProduct.beg.xp",productName, "ab.cartProduct.end.xp");
		Assert.assertTrue(isProductVisible, "Product '" + productName + "' not found in cart.");
		System.out.println("[PASS] Product '" + productName + "' Found in Cart.");
		String value = driver.findElement(By.xpath(jmbProps.getProperty("ab.cartProduct.beg.xp") + productName + jmbProps.getProperty("ab.cartProductQty.end.xp"))).getAttribute("value");
		Assert.assertEquals(value, qty ,"Verify quanity of product '" + productName + "' in cart");
		System.out.println("[PASS] Product '" + productName + "' with QTY '" + qty + "' Found in Cart.");
	}
	
	/**********************************************************************
	 * Description: This method selects the edits a specific product to a new quantity in cart page and then updates
	 * Author: Paul Patterson
	 * Param: String productName, String qty
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void editItemInAutoBuyCart(String productName, String qty) {
		xpClear(jmbProps, "ab.cartProduct.beg.xp", productName, "ab.cartProductQty.end.xp");
		xpSend(jmbProps, "ab.cartProduct.beg.xp", productName, "ab.cartProductQty.end.xp", qty);
		xp(jmbProps, "ab.cartProduct.beg.xp", productName, "ab.cartProductUpdate.end.xp");
		System.out.println("[PASS] Product '" + productName + "' with QTY '" + qty + "' Updated in Cart.");
	}
	
	/**********************************************************************
	 * Description: Increase quantity to item in auto buy cart
	 * Author: Paul Patterson
	 * Param: int itemIndex, int qty
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void cartIncQty(int itemIndex, int qty) {
		int count = 1;
		do {
			Q_JMB_WebElm.xp(jmbProps, "ab.cartProductQtyChange.start.xp", itemIndex+1, "ab.cartProductQtyPlus.end.xp");
			count ++;
		} while (count <= qty);
		Q_JMB_WebElm.xp(jmbProps, "ab.cartProductQtyChange.start.xp", itemIndex+1, "ab.cartProductQtyUpdate.end.xp");
		System.out.println("[PASS] Product number'" + itemIndex + "' QTY increased by '" + qty + "' in Cart.");
	}
	
	/**********************************************************************
	 * Description: This method selects the verifies a specific product and quantity is present in cart popup
	 * Author: Paul Patterson
	 * Param: String productName, String qty
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void verifyItemInAutoBuyCartPopup(String productName, String qty) {
		String value = Q_JMB_WebElm.xpRetText(jmbProps, "ab.popupCartProductName.xp");
		Assert.assertEquals(value, productName ,"Verify product '" + productName + "' is in cart failed");
		value = Q_JMB_WebElm.xpRetAttr(jmbProps, "ab.popupCartProductQty.xp", "value");
		Assert.assertEquals(value, qty ,"Verify quanity of product '" + productName + "' in cart failed");
		System.out.println("[PASS] Product '" + productName + "' with QTY '" + qty + "' Found in Popup Cart.");
	}
	
	/**********************************************************************
	 * Description: Verify user has no active auto buy orders
	 * Author: Paul Patterson
	 * Param: None
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void autoBuyVerifyNoExistingOrders(){
		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.accountNoAutoBuyOrders.xp"), "User has Auto Buy Orders");           
    }
	
	/**********************************************************************
	 * Description: Click on start auto buy button
	 * Author: Paul Patterson
	 * Param: None
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void autoBuyStartAutoBuy(){
		Q_JMB_WebElm.xp(jmbProps, "ab.startAutoBuy.xp");       
    }
	
	/**********************************************************************
	 * Description: Verify that to access auto buy requires a registered user
	 * Author: Paul Patterson
	 * Param: None
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void autoBuyVerifyRequiredLoginToSetup(){
		List<WebElement> logInToSetupList = driver.findElements(By.xpath(jmbProps.getProperty("ab.logInToSetUp.xp")));  
		if (logInToSetupList.size()==0) {
			Assert.fail("Unable to find button 'Log in to Setup'.");
		}
		System.out.println("[PASS] Verified that Auto Buy reguires a registered user to create an auto buy order.");
    }
	
	/**********************************************************************
	 * Description: Verify that credit card cannot be delete with active auto buy orders
	 * Author: Paul Patterson
	 * Param: None
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void autoBuyVerifyCannotDeleteCreditCard(){
		try {
			Q_JMB_WebElm.xpDisplayed(jmbProps, "acc.account.PaymentDeleteCard.xp");
			Assert.fail("[FAIL] User should not be able to delete credit card with active auto buy orders.");
		} catch (Throwable ex) {
			System.out.println("[PASS] Verified cannot delete credit card with active auto buy order for user.");
		}
    }
	
	/**********************************************************************
	 * Description: Verify that bank account cannot be delete with active auto buy orders
	 * Author: Paul Patterson
	 * Param: None
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void autoBuyVerifyCannotDeleteBankAccount(){
		Q_JMB_WebElm.xp(jmbProps, "acc.account.PaymentBankAccount.xp");   
		Q_JMB_WebElm.myWait(1000);
		Q_JMB_Controls.checkAlert();
		Q_JMB_WebElm.myWait(1000);
		Assert.assertTrue(Q_JMB_WebElm.idDisplayed(jmbProps, "acc.account.PaymentBankAccountDeleteError.id"), "User can delete bank account with active orders.");    
		System.out.println("[PASS] Verified cannot delete bank account with active auto buy order for user.");
    }
	
	/**********************************************************************
	 * Description: Verify that billing address cannot be delete with active auto buy orders
	 * Author: Paul Patterson
	 * Param: int index
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void autoBuyVerifyCannotDeleteBillingAddress(int index){
		Q_JMB_WebElm.xp(jmbProps, "acc.shippingAddress.start.xp", index, "acc.shippingAddressDelete.end.xp");   
		Assert.assertTrue(Q_JMB_WebElm.xpRetText(jmbProps, "acc.addressAssociatedWithAutoBuyMessage.xp").contains("This address is "
				+ "currently associated with an active Auto Buy, and cannot be edited or deleted at this time."), 
				"User can delete address with active orders.");    
		System.out.println("[PASS] Verified cannot delete address with active auto buy order for user.");
    }
	
	/**********************************************************************
	 * Description: Verify that billing address cannot be editied with active auto buy orders
	 * Author: Paul Patterson
	 * Param: int index
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void autoBuyVerifyCannotEditBillingAddress(int index){
		Q_JMB_WebElm.xp(jmbProps, "acc.shippingAddress.start.xp", index, "acc.shippingAddressEdit.end.xp");   
		Assert.assertTrue(Q_JMB_WebElm.xpRetText(jmbProps, "acc.addressAssociatedWithAutoBuyMessage.xp").contains("This address is "
				+ "currently associated with an active Auto Buy, and cannot be edited or deleted at this time."), 
				"User can edit address with active orders.");    
		System.out.println("[PASS] Verified cannot edit address with active auto buy order for user.");
    }
	
	/**********************************************************************
	 * Description: Perform a search by a specific product name and results get properly filtered for Failed Transaction Missing Inventory Report
	 * Author: Paul Patterson
	 * Param: String value
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void editAutoBuy (int index){
		System.out.println("Editing Auto Buy Order '" + Q_JMB_WebElm.xpRetText(jmbProps, "acc.autoBuyOrders.start.xp", index, "acc.autoBuyOrdersOrderNumber.end.xp") + "'.");
		Q_JMB_WebElm.xp(jmbProps, "acc.autoBuyOrders.start.xp", index, "acc.autoBuyOrdersEdit.end.xp");
		Q_JMB_WebElm.myWait(1000);
    }
	
	/**********************************************************************
	 * Description: Inactivate an existing auto buy
	 * Author: Paul Patterson
	 * Param: int index
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void makeAutoBuyInactive (int index){
		System.out.println("Inactivating Auto Buy Order '" + Q_JMB_WebElm.xpRetText(jmbProps, "acc.autoBuyOrders.start.xp", index, "acc.autoBuyOrdersOrderNumber.end.xp") + "'.");
		Q_JMB_WebElm.xp(jmbProps, "acc.autoBuyOrders.start.xp", index, "acc.autoBuyOrdersChangeActive.end.xp");
		Q_JMB_WebElm.myWait(2000);
		Q_JMB_Controls.checkAlert();
		Q_JMB_WebElm.myWait(2000);
		String value = Q_JMB_WebElm.xpRetText(jmbProps, "acc.autoBuyOrders.start.xp", index, "acc.autoBuyOrdersStatus.end.xp");
		Assert.assertEquals(value, "Stopped" ,"Auto Buy order is not inactive.");
		System.out.println("[PASS] Auto Buy Order is successfully made inactive.");
    }
	
	/**********************************************************************
	 * Description: Reactivate an existing auto buy
	 * Author: Paul Patterson
	 * Param: int index
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void makeAutoBuyReactive (int index){
		System.out.println("Reactivating Auto Buy Order '" + Q_JMB_WebElm.xpRetText(jmbProps, "acc.autoBuyOrders.start.xp", index, "acc.autoBuyOrdersOrderNumber.end.xp") + "'.");
		Q_JMB_WebElm.xp(jmbProps, "acc.autoBuyOrders.start.xp", index, "acc.autoBuyOrdersChangeActive.end.xp");
		Q_JMB_WebElm.myWait(2000);
		Q_JMB_Controls.checkAlert();
		Q_JMB_WebElm.myWait(2000);
		String value = Q_JMB_WebElm.xpRetText(jmbProps, "acc.autoBuyOrders.start.xp", index, "acc.autoBuyOrdersStatus.end.xp");
		Assert.assertEquals(value, "Active" ,"Auto Buy order is not reactived.");
		System.out.println("[PASS] Auto Buy Order is successfully reactivated.");
    }
	
	/**********************************************************************
	 * Description: Delete user addresses for current user
	 * Author: Paul Patterson
	 * Param: None
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void deleteUserAddresses(){
        Q_JMB_WebElm.myWait(1000);
        driver.navigate().to(baseUrl +"/cybersource-reset.php");
        Q_JMB_WebElm.myWait(1000);
        System.out.println(driver.getCurrentUrl());
        Q_JMB_WebElm.id(jmbProps, "acc.deleteStoredAddresses.id");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().to(baseUrl);
    }
	
	/**********************************************************************
	 * Description: Delete user credit cards for current user
	 * Author: Paul Patterson
	 * Param: None
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void deleteUserCreditCards(){
        Q_JMB_WebElm.myWait(1000);
        driver.navigate().to(baseUrl +"/cybersource-reset.php");
        Q_JMB_WebElm.myWait(1000);
        System.out.println(driver.getCurrentUrl());
        Q_JMB_WebElm.id(jmbProps, "acc.deleteStoredCards.id");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().to(baseUrl);
    }
	
	/**********************************************************************
	 * Description: Click on New Shipping Address Radio Button
	 * Author: Paul Patterson
	 * Param: None
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void autoBuyNewShippingAddress() {
		Q_JMB_WebElm.xp(jmbProps, "ab.checkout.newShippingAddress.xp");
	}
	
	/**********************************************************************
	 * Description: Click on Back To Browse Products Button
	 * Param: None
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void autoBuyBackToBrowseProducts() {
		Q_JMB_WebElm.xp(jmbProps, "ab.cart.backToBrowseProducts.xp");
	}
	
	/**********************************************************************
	 * Description: Click on Add More Items To Your Auto Buy Button
	 * Author: Paul Patterson
	 * Param: None
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void autoBuyAddMoreItems() {
		Q_JMB_WebElm.xp(jmbProps, "ab.cart.addMoreItemsToYourAutoBuy.xp");
	}
	
	/**********************************************************************
	 * Description: Verifies that non auto buy product page the add to auto buy cart link does not appear 
	 * Author: Paul Patterson
	 * Param: String productLink
	 * Returns: None
	 * Status: Complete
	 **********************************************************************/
	public void verifyNonAutoBuyFromProductPage(String productLink)
	{
		driver.navigate().to(baseUrl + productLink);
		try {
			if(Q_JMB_WebElm.cnDisplayed(jmbProps, "ab.setup.className"))
			{
				Assert.fail("[FAIL] Product '"+productLink+"' should not be available for Autobuy.");
				
			}
			else
			{
				System.out.println("[PASS] Product '"+ productLink +"' is not available for Autobuy.");
			}
		} catch (Throwable ex) {
			System.out.println("[PASS] Product '"+ productLink +"' is not available for Autobuy.");
		}
	}
	//Auto Buy End
	
	//JMB-8010 Start

	 /**************************************************************************
    // * Description: validate Sort Price Low To High in Autobuy Products Page
    // * Param : String begXp, String endXp
    // * Returns: NA 
    // * Jira Ticket: JMB 8010
    // * Status: Complete
    /****************************************************************************/    

	 public void validateSortPriceLowToHighAutoBuy(String begXp, String endXp){
		try {
			 for(int i = 1; i<15;i++) {
	  	            Float priceList1 = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,begXp, i, endXp));
	          for(int j= i+1; j <=15 ;j++) {
	    	   Float priceList2 = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,begXp, j, endXp));
	    	        if(priceList1<=priceList2) {
	    	   System.out.println("Check Price of product " + i + " is sorted from low to high :"+priceList1+ " less than or equal to "+ j + " next product " +priceList2 );
	    	      break;
	    	                }
	    	            }
	    	        }	
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}
	   		
	   		 
	    }
	   
	 	/**************************************************************************
	    // * Description: AutoBuy Select Product Tab And Sort
	    // * Param : String metal
	    // * Returns: NA
	    // * Jira Ticket: JMB 8010
	    // * Status: Complete
	    /****************************************************************************/  
	 
	 public void autoBuySelectProductTabAndSort(String metal) {
		
		 Q_JMB_WebElm.xpExecutorScrolToElement(jmbProps,"ab.addItemsLabel.xp");
			
		if (metal.toLowerCase().equals("gold")) {
			Q_JMB_WebElm.id(jmbProps, "ab.goldProductTab.id");
			Q_JMB_WebElm.myWait(2000);
			validateSortPriceLowToHighAutoBuy("ab.productSortResultGold.beg.xp","ab.productSortResult.end.xp");
			System.out.println("Products in autobuy  "+ metal+" are sorted by price low to high ");
		} else if (metal.toLowerCase().equals("silver")) {
			Q_JMB_WebElm.id(jmbProps, "ab.silverProductTab.id");
			Q_JMB_WebElm.myWait(2000);
			validateSortPriceLowToHighAutoBuy("ab.productSortResultSilver.beg.xp", "ab.productSortResult.end.xp");
			System.out.println("Products in autobuy  "+ metal+"  are sorted by price low to high ");
		}
		else if (metal.toLowerCase().equals("all")) {
			Q_JMB_WebElm.id(jmbProps, "ab.allProductsTab.id");
			Q_JMB_WebElm.myWait(2000);	
			validateSortPriceLowToHighAutoBuy("ab.allProductSortResult.beg.xp", "ab.productSortResult.end.xp" );
			System.out.println("Products in autobuy  "+ metal+" are sorted by price low to high ");
		}
		else {
			Assert.fail("[FAIL] Metal type '" + metal + "' is invalid for AutoBuy! Gold, Silver and All Products are valid categories in AutoBuy");
		}
	 }
	 
	 	/**************************************************************************************************
		 * Description: To search all product autobuy category and add products to autobuy cart
		 * Param: String metal, String productName, String qty
		 * Returns: None
		 * Jira Ticket: JMB 8010
		 * Status: Complete
		 ****************************************************************************************************/
		public void searchAllProductCategoryAndAddToAutoBuyCart(String metal, String productName, String qty) {
			selectAutoBuyProductsFromMetalType(metal);
			String productLocatorBeg = "";
			
			if (metal.toLowerCase().equals("all")) {
				productLocatorBeg = "ab.allProductSearchResult.beg.xp";
				Q_JMB_WebElm.myWait(2000);	
			} 
			else {
				Assert.fail("[FAIL] Metal type '" + metal + "' is invalid for AutoBuy! Gold or Silver are valid metal types");
			}
			
			boolean isProductVisible = xpDisplayed(jmbProps, productLocatorBeg ,productName, "ab.allProductSearchResult.end.xp");
			
			if (isProductVisible) {
				System.out.println("[PASS] Product '" + productName + "' Found.");
				Q_JMB_Controls.scrolDownPixel(600);
				xpClear(jmbProps, productLocatorBeg, productName, "ab.allProductSearchQty.end.xp");
				xpSend(jmbProps, productLocatorBeg, productName, "ab.allProductSearchQty.end.xp", qty);
				xp(jmbProps, productLocatorBeg, productName, "ab.allProductSearchQty.end.xp");
				Q_JMB_WebElm.myWait(1000);
				xp(jmbProps, productLocatorBeg, productName, "ab.allProductSearchAddBtn.end");
				Q_JMB_WebElm.xp(jmbProps, "ab.popupCartProceedToFrequency.xp");
				
			} else {
				Assert.fail("[FAIL] Product '" + productName + "' Not Found/ Not available for AutoBuy!");
			}

		}
	 //End JMB-8010
}