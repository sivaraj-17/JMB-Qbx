package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import utils.*;

public class Q_PM_AdminPmSteps extends Q_PM_Init {

    public static Integer limitCount(String product){
        driver.navigate().to(jmAdmin + "/products-form.php?id=" + product);
        String currentLimit = Q_PM_WebElm.xpRetAttr(pmQaProps,"adm.prod.limited.input.xp", "value");
        driver.navigate().to(baseUrl);
        System.out.println("product Limit " + Integer.valueOf(currentLimit));
        return Integer.valueOf(currentLimit);
    }
    
    public Q_PM_AdminPmSteps adminMenu(String item) {

        String menuItem = item;
        switch ( menuItem ) {
            case ("settings"):
            	Q_PM_WebElm.xp(pmQaProps, "adm.menuSettings.xp");
                break;
            default:
                System.out.println("Invalid admin menu option");
        }
        return this;
    }
    
    public Q_PM_AdminPmSteps adjust3dsSettings (String value) {
    	Q_PM_WebElm.myWait(1000);
    	if (value.toLowerCase().equals("on")) {
    		if (!Q_PM_WebElm.xpSelected(pmQaProps, "adm.configSettings.3dsOn.xp")) {
    			Q_PM_WebElm.xp(pmQaProps, "adm.configSettings.3dsOn.xp");
    			Q_PM_WebElm.myWait(1000);
    			Assert.assertTrue(Q_PM_WebElm.xpSelected(pmQaProps, "adm.configSettings.3dsOn.xp"),"3ds is not turned on!");
    			Q_PM_WebElm.xp(pmQaProps, "adm.configSettings.save.xp");
    			Q_PM_WebElm.myWait(4000);
    		}
    	}
    	else {
    		if (!Q_PM_WebElm.xpSelected(pmQaProps, "adm.configSettings.3dsOff.xp")) {
    			Q_PM_WebElm.xp(pmQaProps, "adm.configSettings.3dsOff.xp");
    			Q_PM_WebElm.myWait(1000);
    			Assert.assertTrue(Q_PM_WebElm.xpSelected(pmQaProps, "adm.configSettings.3dsOff.xp"),"3ds is not turned on!");
    			Q_PM_WebElm.xp(pmQaProps, "adm.configSettings.save.xp");
    			Q_PM_WebElm.myWait(4000);
    		}
    	}
    	return this;
    }
    
    //JMB-7670 Start
    /******************************************************************
     * Description: Admin customer search
     * Parameters: String srch - type of search
     * String param - Search to enter
     * Returns: NA
     * Status: Complete
     *******************************************************************/
   public void adminCustomerSearch(String srch, String param) {
	   Q_PM_WebElm.xp(pmQaProps, "adm.adminJmbullion.xp");
       switch (srch) {
           case ("first"):
        	   	Q_PM_WebElm.idClear(pmQaProps, "adm.adminSearchFirst.id");
           		Q_PM_WebElm.idSend(pmQaProps, "adm.adminSearchFirst.id", param);
           		Q_PM_WebElm.xp(pmQaProps, "adm.adminSearchBtn.xp");
           		break;
           case ("last"):
        	   	Q_PM_WebElm.idClear(pmQaProps, "adminSearchlast.id");
           		Q_PM_WebElm.idSend(pmQaProps, "adminSearchlast.id", param);
           		Q_PM_WebElm.xp(pmQaProps, "adm.adminSearchBtn.xp");
               break;
           case ("email"):
        	   	Q_PM_WebElm.idClear(pmQaProps, "adm.adminSearchEmail.id");
           		Q_PM_WebElm.idSend(pmQaProps, "adm.adminSearchEmail.id", param);
           		Q_PM_WebElm.xp(pmQaProps, "adm.adminSearchBtn.xp");
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
	   Q_PM_WebElm.xp(pmQaProps, "adm.adminActiveBtn.xp");
	   Q_PM_WebElm.xp(pmQaProps, "adm.viewAllOrders.xp");
   }
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
  		Q_PM_AccountSteps.accountMenu("LOGOUT");
  		Q_PM_Controls.adminLoginPM();
  		adminCustomerSearch ("email", email);
  		adminViewAllOrders();
  		adminEditCustomerOrder(orderIndex);
  		Q_PM_WebElm.xpDisplayed(pmQaProps,"adm.order.total.xp");
        int rowCount = Q_PM_WebElm.xpCountTableRows(pmQaProps,"adm.order.orderTableRows.xp");
        List<Float> priceList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(0);
        Float calcTotal = Float.valueOf(0);
        for (int index = 1; index <= rowCount; index++)
        {
        	subtotal = subtotal + Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.order.orderTableProductRow.beg.xp", index, "adm.order.orderTableProductRowTotal.end.xp"));
          	subtotal = Float.valueOf(String.format("%.02f", subtotal));
        }
        calcTotal = calcTotal + subtotal;
        priceList.add(subtotal);

        if (hasSalesTax)
        {
          	Float tax = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.order.salesTax.xp"));
          	calcTotal = calcTotal + tax;
          	priceList.add(tax);
        }
          
        if (hasStateFee)
        {
          	Float stateFee = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.order.stateFee.xp"));
          	calcTotal = calcTotal + stateFee;
          	priceList.add(stateFee);
        }
          
        Float shipping = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.order.shipping.xp"));
        calcTotal = calcTotal + shipping;
        priceList.add(shipping);
          
        // Locators will need to be updated for this to work
//        if (hasShippingTax)
//        {
//          	Float shippingTax = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.order.shipTax.xp"));
//          	calcTotal = calcTotal + shippingTax;
//          	priceList.add(shippingTax);
//        }
          
        if (hasGiftCert)
        {
          	Float discount = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.order.cartDiscount.xp"));
          	calcTotal = calcTotal - discount;
          	priceList.add(discount);
        }

        calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
        Float total = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.order.total.xp"));
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
		Q_PM_WebElm.xp(pmQaProps,"adm.order.invoiceLink.xp");
		Q_PM_Controls.switchWin();
        List<Float> priceList = new ArrayList<Float>();
        Float calcTotal = Float.valueOf(0);
        Float subtotal = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.invoice.subTotal.xp"));
        calcTotal = calcTotal + subtotal;
        priceList.add(subtotal);

        if (hasSalesTax)
        {
        	Float tax = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.invoice.salesTax.xp"));
        	calcTotal = calcTotal + tax;
        	priceList.add(tax);
        }
        
        if (hasStateFee)
        {
        	Float stateFee = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.invoice.stateFee.xp"));
        	calcTotal = calcTotal + stateFee;
        	priceList.add(stateFee);
        }
        
        Float shipping = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.invoice.shipping.xp"));
        calcTotal = calcTotal + shipping;
        priceList.add(shipping);
        
        
        if (hasGiftCert)
        {
        	Float discount = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.invoice.discount.xp"));
        	calcTotal = calcTotal - discount;
        	priceList.add(discount);
        }

        calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
        Float total = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.invoice.total.xp"));
        priceList.add(total);
        Assert.assertEquals(total, calcTotal, "Admin Order Invoice Page total does not match calculated revenue items.");
        System.out.println("[Pass] Admin Order Invoice Page total matches calculated revenue items.");
        Q_PM_Controls.closeTabsSwitchWinMain();
        Q_PM_Controls.switchTab(0);
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
		Q_PM_WebElm.xp(pmQaProps,"adm.order.claimInvoiceLink.xp");
		Q_PM_Controls.switchWin();
		List<Float> priceList = new ArrayList<Float>();
        Float calcTotal = Float.valueOf(0);
        Float subtotal = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.invoice.subTotal.xp"));
        calcTotal = calcTotal + subtotal;
        priceList.add(subtotal);

        if (hasSalesTax)
        {
        	Float tax = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.invoice.salesTax.xp"));
        	calcTotal = calcTotal + tax;
        	priceList.add(tax);
        }
        
        if (hasStateFee)
        {
        	Float stateFee = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.invoice.stateFee.xp"));
        	calcTotal = calcTotal + stateFee;
        	priceList.add(stateFee);
        }
        
        Float shipping = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.invoice.shipping.xp"));
        calcTotal = calcTotal + shipping;
        priceList.add(shipping);
        
        
        if (hasGiftCert)
        {
        	Float discount = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.invoice.discount.xp"));
        	calcTotal = calcTotal - discount;
        	priceList.add(discount);
        }

        calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
        Float total = Float.valueOf(Q_PM_WebElm.xpRetTextReplace(pmQaProps,"adm.invoice.total.xp"));
        priceList.add(total);
        Assert.assertEquals(total, calcTotal, "Admin Order Claim Invoice Page total does not match calculated revenue items.");
        System.out.println("[Pass] Admin Order Claim Invoice Page total matches calculated revenue items.");
        Q_PM_Controls.closeTabsSwitchWinMain();
        Q_PM_Controls.switchTab(0);
        return priceList;
    }
    /**********************************************************************
     * Description:     Edits order on the Customer View Page
     * Author:          Paul Patterson
     * Param:      		int index
     * Returns:         None
     **********************************************************************/
  	public void adminEditCustomerOrder(int index) {
      	Q_PM_WebElm.xp(pmQaProps,"adm.order.beg.xp", index, "adm.order.edit.end.xp");
      	Q_PM_WebElm.xp(pmQaProps,"adm.order.beg.xp", index, "adm.order.editOrder.end.xp");
    }
   	//JMB-7670 End
}
