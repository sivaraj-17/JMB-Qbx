package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import utils.*;

public class Q_Slv_AdminSlvSteps extends Q_Slv_Init {

    public static Integer limitCount(String product){

        driver.navigate().to(jmAdmin + "/products-form.php?id=" + product);
        String currentLimit = Q_Slv_WebElm.xpRetAttr(SLVqProp,"adm.prod.limited.input.xp", "value");
        driver.navigate().to(baseUrl);
        return Integer.valueOf(currentLimit);
    }
    
    public Q_Slv_AdminSlvSteps adminMenu(String item) {

        String menuItem = item;
        switch ( menuItem ) {
            case ("settings"):
            	Q_Slv_WebElm.xp(SLVqProp, "adm.menuSettings.xp");
                break;
            default:
                System.out.println("Invalid admin menu option");
        }
        return this;
    }
    public Q_Slv_AdminSlvSteps adjust3dsSettings (String value) {
    	Q_Slv_WebElm.myWait(1000);
    	if (value.toLowerCase().equals("on")) {
    		if (!Q_Slv_WebElm.xpSelected(SLVqProp, "adm.configSettings.3dsOn.xp")) {
    			Q_Slv_WebElm.xp(SLVqProp, "adm.configSettings.3dsOn.xp");
    			Q_Slv_WebElm.myWait(1000);
    			Assert.assertTrue(Q_Slv_WebElm.xpSelected(SLVqProp, "adm.configSettings.3dsOn.xp"),"3ds is not turned on!");
    			Q_Slv_WebElm.xp(SLVqProp, "adm.configSettings.save.xp");
    			Q_Slv_WebElm.myWait(4000);
    		}
    	}
    	else {
    		if (!Q_Slv_WebElm.xpSelected(SLVqProp, "adm.configSettings.3dsOff.xp")) {
    			Q_Slv_WebElm.xp(SLVqProp, "adm.configSettings.3dsOff.xp");
    			Q_Slv_WebElm.myWait(1000);
    			Assert.assertTrue(Q_Slv_WebElm.xpSelected(SLVqProp, "adm.configSettings.3dsOff.xp"),"3ds is not turned off!");
    			Q_Slv_WebElm.xp(SLVqProp, "adm.configSettings.save.xp");
    			Q_Slv_WebElm.myWait(4000);
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
	   Q_Slv_WebElm.xp(SLVqProp, "adm.adminJmbullion.xp");
       switch (srch) {
           case ("first"):
        	   	Q_Slv_WebElm.idClear(SLVqProp, "adm.adminSearchFirst.id");
           		Q_Slv_WebElm.idSend(SLVqProp, "adm.adminSearchFirst.id", param);
           		Q_Slv_WebElm.xp(SLVqProp, "adm.adminSearchBtn.xp");
           		break;
           case ("last"):
        	   	Q_Slv_WebElm.idClear(SLVqProp, "adminSearchlast.id");
           		Q_Slv_WebElm.idSend(SLVqProp, "adminSearchlast.id", param);
           		Q_Slv_WebElm.xp(SLVqProp, "adm.adminSearchBtn.xp");
               break;
           case ("email"):
        	   	Q_Slv_WebElm.idClear(SLVqProp, "adm.adminSearchEmail.id");
           		Q_Slv_WebElm.idSend(SLVqProp, "adm.adminSearchEmail.id", param);
           		Q_Slv_WebElm.xp(SLVqProp, "adm.adminSearchBtn.xp");
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
	   Q_Slv_WebElm.xp(SLVqProp, "adm.adminActiveBtn.xp");
	   Q_Slv_WebElm.xp(SLVqProp, "adm.viewAllOrders.xp");
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
  		Q_Slv_AccountSteps.logout();
  		Q_Slv_Controls.adminLogin();
  		adminCustomerSearch ("email", email);
  		adminViewAllOrders();
  		adminEditCustomerOrder(orderIndex);
  		Q_Slv_WebElm.xpDisplayed(SLVqProp,"adm.order.total.xp");
        int rowCount = Q_Slv_WebElm.xpCountTableRows(SLVqProp,"adm.order.orderTableRows.xp");
        List<Float> priceList = new ArrayList<Float>();
        Float subtotal = Float.valueOf(0);
        Float calcTotal = Float.valueOf(0);
        for (int index = 1; index <= rowCount; index++)
        {
        	subtotal = subtotal + Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.order.orderTableProductRow.beg.xp", index, "adm.order.orderTableProductRowTotal.end.xp"));
          	subtotal = Float.valueOf(String.format("%.02f", subtotal));
        }
        calcTotal = calcTotal + subtotal;
        priceList.add(subtotal);

        if (hasSalesTax)
        {
          	Float tax = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.order.salesTax.xp"));
          	calcTotal = calcTotal + tax;
          	if (hasShippingTax)
            {
            	Float shippingTax = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.order.shipTax.xp"));
            	calcTotal = calcTotal + shippingTax;
            	tax = tax + shippingTax;
            	tax = Float.valueOf(String.format("%.02f", tax));
            }
          	priceList.add(tax);
        }
          
        if (hasStateFee)
        {
          	Float stateFee = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.order.stateFee.xp"));
          	calcTotal = calcTotal + stateFee;
          	priceList.add(stateFee);
        }
          
        Float shipping = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.order.shipping.xp"));
        calcTotal = calcTotal + shipping;
        priceList.add(shipping);
          
        // Placeholder for Shipping Tax will need to update later
//        if (hasShippingTax)
//        {
//          	Float shippingTax = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.order.shipTax.xp"));
//          	calcTotal = calcTotal + shippingTax;
//          	priceList.add(shippingTax);
//        }
          
        if (hasGiftCert)
        {
          	Float discount = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.order.cartDiscount.xp"));
          	calcTotal = calcTotal - discount;
          	priceList.add(discount);
        }

        calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
        Float total = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.order.total.xp"));
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
		Q_Slv_WebElm.xp(SLVqProp,"adm.order.invoiceLink.xp");
		Q_Slv_Controls.switchWin();
        List<Float> priceList = new ArrayList<Float>();
        Float calcTotal = Float.valueOf(0);
        Float subtotal = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.invoice.subTotal.xp"));
        calcTotal = calcTotal + subtotal;
        priceList.add(subtotal);

        if (hasSalesTax)
        {
        	Float tax = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.invoice.salesTax.xp"));
        	calcTotal = calcTotal + tax;
        	priceList.add(tax);
        }
        
        if (hasStateFee)
        {
        	Float stateFee = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.invoice.stateFee.xp"));
        	calcTotal = calcTotal + stateFee;
        	priceList.add(stateFee);
        }
        
        Float shipping = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.invoice.shipping.xp"));
        calcTotal = calcTotal + shipping;
        priceList.add(shipping);
        
        
        if (hasGiftCert)
        {
        	Float discount = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.invoice.discount.xp"));
        	calcTotal = calcTotal - discount;
        	priceList.add(discount);
        }

        calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
        Float total = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.invoice.total.xp"));
        priceList.add(total);
        Assert.assertEquals(total, calcTotal, "Admin Order Invoice Page total does not match calculated revenue items.");
        System.out.println("[Pass] Admin Order Invoice Page total matches calculated revenue items.");
        Q_Slv_Controls.closeTabsSwitchWinMain();
        Q_Slv_Controls.switchTab(0);
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
		Q_Slv_WebElm.xp(SLVqProp,"adm.order.claimInvoiceLink.xp");
		Q_Slv_Controls.switchWin();
		List<Float> priceList = new ArrayList<Float>();
        Float calcTotal = Float.valueOf(0);
        Float subtotal = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.invoice.subTotal.xp"));
        calcTotal = calcTotal + subtotal;
        priceList.add(subtotal);

        if (hasSalesTax)
        {
        	Float tax = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.invoice.salesTax.xp"));
        	calcTotal = calcTotal + tax;
        	priceList.add(tax);
        }
        
        if (hasStateFee)
        {
        	Float stateFee = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.invoice.stateFee.xp"));
        	calcTotal = calcTotal + stateFee;
        	priceList.add(stateFee);
        }
        
        Float shipping = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.invoice.shipping.xp"));
        calcTotal = calcTotal + shipping;
        priceList.add(shipping);
        
        
        if (hasGiftCert)
        {
        	Float discount = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.invoice.discount.xp"));
        	calcTotal = calcTotal - discount;
        	priceList.add(discount);
        }

        calcTotal = Float.valueOf(String.format("%.02f", calcTotal)); // Ensure limited to 2 digits
        Float total = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp,"adm.invoice.total.xp"));
        priceList.add(total);
        Assert.assertEquals(total, calcTotal, "Admin Order Claim Invoice Page total does not match calculated revenue items.");
        System.out.println("[Pass] Admin Order Claim Invoice Page total matches calculated revenue items.");
        Q_Slv_Controls.closeTabsSwitchWinMain();
        Q_Slv_Controls.switchTab(0);
        return priceList;
    }
    /**********************************************************************
     * Description:     Edits order on the Customer View Page
     * Author:          Paul Patterson
     * Param:      		int index
     * Returns:         None
     **********************************************************************/
	public void adminEditCustomerOrder(int index) {
    	Q_Slv_WebElm.xp(SLVqProp,"adm.order.beg.xp", index, "adm.order.edit.end.xp");
    	Q_Slv_WebElm.xp(SLVqProp,"adm.order.beg.xp", index, "adm.order.editOrder.end.xp");
    }
   	//JMB-7670 End
}
