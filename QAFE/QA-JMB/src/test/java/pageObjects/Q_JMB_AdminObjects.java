package pageObjects;

import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import pageObjects.*;

public class Q_JMB_AdminObjects extends Q_JMB_Init {

    public static Integer limitCount(String product){
        driver.navigate().to(adminUrl + "/products-form.php?id=" + product);
        String currentLimit = Q_JMB_WebElm.xpRetAttr(jmbProps,"adm.prod.limited.input.xp", "value");
        driver.navigate().to(baseUrl);
        Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
        return Integer.valueOf(currentLimit);
    }
    
    public Q_JMB_AdminObjects adminMenu(String item) {

        String menuItem = item;
        switch ( menuItem ) {
            case ("settings"):
            	Q_JMB_WebElm.xp(jmbProps, "adm.menuSettings.xp");
                break;
            default:
                System.out.println("Invalid admin menu option");
        }
        return this;
    }
    
    public Q_JMB_AdminObjects adjust3dsSettings (String value) {
    	Q_JMB_WebElm.myWait(1000);
    	if (value.toLowerCase().equals("on")) {
    		if (!Q_JMB_WebElm.xpSelected(jmbProps, "adm.configSettings.3dsOn.xp")) {
    			Q_JMB_WebElm.xp(jmbProps, "adm.configSettings.3dsOn.xp");
    			Q_JMB_WebElm.myWait(1000);
    			Q_JMB_WebElm.xp(jmbProps, "adm.configSettings.save.xp");
    			Q_JMB_WebElm.myWait(4000);
    			driver.navigate().refresh();
    			Q_JMB_WebElm.myWait(1000);
    			Assert.assertTrue(Q_JMB_WebElm.xpSelected(jmbProps, "adm.configSettings.3dsOn.xp"),"3ds is not turned on!");
    			System.out.println("3DS setting has been turned on.");
    		}
    	}
    	else {
    		if (!Q_JMB_WebElm.xpSelected(jmbProps, "adm.configSettings.3dsOff.xp")) {
    			Q_JMB_WebElm.xp(jmbProps, "adm.configSettings.3dsOff.xp");
    			Q_JMB_WebElm.myWait(1000);
    			Q_JMB_WebElm.xp(jmbProps, "adm.configSettings.save.xp");
    			Q_JMB_WebElm.myWait(4000);
    			driver.navigate().refresh();
    			Q_JMB_WebElm.myWait(1000);
    			Assert.assertTrue(Q_JMB_WebElm.xpSelected(jmbProps, "adm.configSettings.3dsOff.xp"),"3ds is not turned off!");
    			System.out.println("3DS setting has been turned off.");
    		}
    	}
    	return this;
    }
    
    
    //JMB-5689 Start
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
    //JMB-5689 End
    
    //JMB-7670 Start
    /**********************************************************************
     * Description:     Captures revenue items from the Admin Order Page
     * Author:          Paul Patterson
     * Param:      		String email, boolean hasSalesTax, boolean hasStateFee, 
     * 					boolean hasShippingTax, boolean hasGiftCert, int orderIndex
     * Returns:         List<Float>
     **********************************************************************/
	public List<Float> adminOrderPriceList(String email, boolean hasSalesTax, boolean hasStateFee, 
			boolean hasShippingTax, boolean hasGiftCert, int orderIndex) 
	{
		Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
		acc.logoutUser();
		Q_JMB_Controls.adminLogin();
		adminCustomerSearch ("email", email);
		adminViewAllOrders();
		adminEditCustomerOrder(orderIndex);
		Q_JMB_WebElm.xpDisplayed(jmbProps,"adm.order.total.xp");
        int rowCount = Q_JMB_WebElm.xpCountTableRows(jmbProps,"adm.order.orderTableRows.xp");
        List<Float> priceList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(0);
        Float calcTotal = Float.valueOf(0);
        for (int index = 1; index <= rowCount; index++)
        {
        	subtotal = subtotal + Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.order.orderTableProductRow.beg.xp", index, "adm.order.orderTableProductRowTotal.end.xp"));
        	subtotal = Float.valueOf(String.format("%.02f", subtotal));
        }
        calcTotal = calcTotal + subtotal;
        priceList.add(subtotal);

        if (hasSalesTax)
        {
        	Float tax = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.order.salesTax.xp"));
        	calcTotal = calcTotal + tax;
        	if (hasShippingTax)
            {
            	Float shippingTax = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.order.shipTax.xp"));
            	calcTotal = calcTotal + shippingTax;
            	tax = tax + shippingTax;
            	tax = Float.valueOf(String.format("%.02f", tax));
            }
        	priceList.add(tax);
        }
        
        if (hasStateFee)
        {
        	Float stateFee = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.order.stateFee.xp"));
        	calcTotal = calcTotal + stateFee;
        	priceList.add(stateFee);
        }
        
        Float shipping = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.order.shipping.xp"));
        calcTotal = calcTotal + shipping;
        priceList.add(shipping);
        
        if (hasGiftCert)
        {
        	Float discount = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.order.cartDiscount.xp"));
        	calcTotal = calcTotal - discount;
        	priceList.add(discount);
        }

        calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
        Float total = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.order.total.xp"));
        priceList.add(total);
        Assert.assertEquals(total, calcTotal, "Admin Order Page total does not match calculated revenue items.");
        System.out.println("[Pass] Admin Order Page total matches calculated revenue items.");
        return priceList;
    }
	
	/**********************************************************************
     * Description:     Captures revenue items from the Invoice on Admin Order Page
     * Author:          Paul Patterson
     * Param:      		String email, boolean hasSalesTax, boolean hasStateFee, 
     * 					boolean hasShippingTax, boolean hasGiftCert, int orderIndex
     * Returns:         List<Float>
     **********************************************************************/
	public List<Float> adminOrderInvoicePriceList(boolean hasSalesTax, boolean hasStateFee, 
			boolean hasShippingTax, boolean hasGiftCert, int orderIndex) 
	{
		Q_JMB_WebElm.xp(jmbProps,"adm.order.invoiceLink.xp");
		Q_JMB_Controls.switchWin();
        List<Float> priceList = new ArrayList<Float>();
        Float calcTotal = Float.valueOf(0);
        Float subtotal = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.invoice.subTotal.xp"));
        calcTotal = calcTotal + subtotal;
        priceList.add(subtotal);

        if (hasSalesTax)
        {
        	Float tax = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.invoice.salesTax.xp"));
        	calcTotal = calcTotal + tax;
        	priceList.add(tax);
        }
        
        if (hasStateFee)
        {
        	Float stateFee = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.invoice.stateFee.xp"));
        	calcTotal = calcTotal + stateFee;
        	priceList.add(stateFee);
        }
        
        Float shipping = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.invoice.shipping.xp"));
        calcTotal = calcTotal + shipping;
        priceList.add(shipping);
        
        
        if (hasGiftCert)
        {
        	Float discount = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.invoice.discount.xp"));
        	calcTotal = calcTotal - discount;
        	priceList.add(discount);
        }

        calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
        Float total = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.invoice.total.xp"));
        priceList.add(total);
        Assert.assertEquals(total, calcTotal, "Admin Order Invoice Page total does not match calculated revenue items.");
        System.out.println("[Pass] Admin Order Invoice Page total matches calculated revenue items.");
        Q_JMB_Controls.closeTabsSwitchWinMain();
        Q_JMB_Controls.switchTab(0);
        return priceList;
    }
	
	/**********************************************************************
     * Description:     Captures revenue items from the Claim Invoice on Admin Order Page
     * Author:          Paul Patterson
     * Param:      		String email, boolean hasSalesTax, boolean hasStateFee, 
     * 					boolean hasShippingTax, boolean hasGiftCert, int orderIndex
     * Returns:         List<Float>
     **********************************************************************/
	public List<Float> adminOrderClaimInvoicePriceList(boolean hasSalesTax, boolean hasStateFee, 
			boolean hasShippingTax, boolean hasGiftCert, int orderIndex) 
	{
		Q_JMB_WebElm.xp(jmbProps,"adm.order.claimInvoiceLink.xp");
		Q_JMB_Controls.switchWin();
		List<Float> priceList = new ArrayList<Float>();
        Float calcTotal = Float.valueOf(0);
        Float subtotal = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.invoice.subTotal.xp"));
        calcTotal = calcTotal + subtotal;
        priceList.add(subtotal);

        if (hasSalesTax)
        {
        	Float tax = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.invoice.salesTax.xp"));
        	calcTotal = calcTotal + tax;
        	priceList.add(tax);
        }
        
        if (hasStateFee)
        {
        	Float stateFee = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.invoice.stateFee.xp"));
        	calcTotal = calcTotal + stateFee;
        	priceList.add(stateFee);
        }
        
        Float shipping = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.invoice.shipping.xp"));
        calcTotal = calcTotal + shipping;
        priceList.add(shipping);
        
        
        if (hasGiftCert)
        {
        	Float discount = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.invoice.discount.xp"));
        	calcTotal = calcTotal - discount;
        	priceList.add(discount);
        }

        calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
        Float total = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps,"adm.invoice.total.xp"));
        priceList.add(total);
        Assert.assertEquals(total, calcTotal, "Admin Order Claim Invoice Page total does not match calculated revenue items.");
        System.out.println("[Pass] Admin Order Claim Invoice Page total matches calculated revenue items.");
        Q_JMB_Controls.closeTabsSwitchWinMain();
        Q_JMB_Controls.switchTab(0);
        return priceList;
    }
	
	//JMB-7670 Start
	/**********************************************************************
     * Description:     Edits order on the Customer View Page
     * Author:          Paul Patterson
     * Param:      		int index
     * Returns:         None
     **********************************************************************/
	public void adminEditCustomerOrder(int index) {
    	Q_JMB_WebElm.xp(jmbProps,"adm.order.beg.xp", index, "adm.order.edit.end.xp");
    	Q_JMB_WebElm.xp(jmbProps,"adm.order.beg.xp", index, "adm.order.editOrder.end.xp");
    }
	//JMB-7670 End
	
	//JMB-7655 Start
	/************************************************************
    // * Description : To select order based on orderId in admin page
    // * Param       : String orderId
    // * Jira Ticket : JMB 7655
    // * Status      : Completed
    //***********************************************************/ 	
	public void navigateToEditOrderInAdminPage(String orderId) {
		Q_JMB_Controls.adminLogin();		
		driver.get("https://qa.jmbullion.com/admin/orders.php?ordertype=new");
		Q_JMB_WebElm.myWait(5000);
		Q_JMB_WebElm.xpClear(jmbProps,"adm.orderNumberSearch.xp");
		Q_JMB_WebElm.xpSend(jmbProps,"adm.orderNumberSearch.xp",orderId);
		Q_JMB_WebElm.xp(jmbProps,"adm.orderSearchSubmit.xp");	
		Q_JMB_WebElm.myWait(4000);
		Q_JMB_Controls.switchTab(1);
	}
	//JMB-7655 End
	
	//JMB-7855-Start
	/************************************************************
    // * Description :  To verify order id and order total
    // * Param       :  String orderId, String orderTotal
    // * Jira Ticket :  JMB 7855
    // * Status      :  Completed
    //***********************************************************/
	public void verifyCustomerOrders(String orderId, String orderTotal) {
		Q_JMB_WebElm.xp(jmbProps, "adm.customer.xp");
		Q_JMB_WebElm.myWait(2000);
		Q_JMB_Controls.switchWin();
		driver.findElement(By.xpath("//table[1]/tbody//child::a[contains((.),'" + orderId+ "')]//parent::td//following-sibling::td[contains((.),'" + orderTotal + "')]")).isDisplayed();
	}
	//JMB-7855-End
	
	//JMB-7654 Start
	/************************************************************
	// * Description : To disable PayPal via BrainTree
	// * Param       : NA
	// * Jira Ticket : JMB 7654
	// * Status      : Completed
	//***********************************************************/ 	
	public void setPayPalViaBrainTree() {
		driver.navigate().to(baseUrl + "/wp-admin/admin.php?page=wc-settings&tab=checkout&section=braintree_paypal");
		boolean isSelected=Q_JMB_WebElm.xpSelected(jmbProps, "wordPressAdmin.brainTreePayPalGateway.xp");
		if(isSelected) {
			Q_JMB_WebElm.xp(jmbProps, "wordPressAdmin.brainTreePayPalGateway.xp");
		} 
		Q_JMB_WebElm.xp(jmbProps, "wordPressAdmin.brainTreePayPal.saveChangesBtn.xp");
	}

	/************************************************************
	// * Description : To enable PayPal Express
	// * Param       : NA
	// * Jira Ticket : JMB 7654
	// * Status      : Completed
	//***********************************************************/ 	
	public void setPayPalExpress() {
		driver.navigate().to(baseUrl + "/wp-admin/admin.php?page=wc-settings&tab=checkout&section=paypal_express");
		boolean isSelected=Q_JMB_WebElm.xpSelected(jmbProps, "wordPressAdmin.payPalExpress.xp");
		if(!(isSelected)) {
			Q_JMB_WebElm.xp(jmbProps, "wordPressAdmin.payPalExpress.xp");
			Q_JMB_WebElm.myWait(2000);
		}
		Q_JMB_WebElm.xp(jmbProps, "wordPressAdmin.brainTreePayPal.saveChangesBtn.xp");		
	}

	/************************************************************
	// * Description : To reset the original 
	// * Param       : NA
	// * Jira Ticket : JMB 7654
	// * Status      : Completed
	//***********************************************************/ 	
	public void resetBrainTreeAndPayPalExpress() {
		driver.navigate().to(baseUrl + "/wp-admin/admin.php?page=wc-settings&tab=checkout&section=braintree_paypal");
		Q_JMB_WebElm.xp(jmbProps, "wordPressAdmin.brainTreePayPalGateway.xp");
		Q_JMB_WebElm.xp(jmbProps, "wordPressAdmin.brainTreePayPal.saveChangesBtn.xp");
		driver.navigate().to(baseUrl + "/wp-admin/admin.php?page=wc-settings&tab=checkout&section=paypal_express");
		Q_JMB_WebElm.xp(jmbProps, "wordPressAdmin.payPalExpress.xp");
		Q_JMB_WebElm.myWait(2000);
		Q_JMB_WebElm.xp(jmbProps, "wordPressAdmin.brainTreePayPal.saveChangesBtn.xp");		
	}
	//JMB-7654 End
}
