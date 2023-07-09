package pageObjects;


import org.openqa.selenium.By;
import org.testng.Assert;

import utils.Controls;
import utils.Init;

public class Q_Tickets extends Init {	
	
	static Q_OrderForm ord = new Q_OrderForm();
	static Q_AdminForm adm = new Q_AdminForm();
	static Q_CheckoutForm chk = new Q_CheckoutForm();
	static Q_NewFeatures nf = new Q_NewFeatures();
	static Q_CustomerForm cust = new Q_CustomerForm();
	static Q_Buyback bb = new Q_Buyback();
	/****************************************** JMB-Ticket Specific********************************************/
	
	
	//JMB-7279-Start

	/********************************************************************
	// * Description  : Verify shipping message status in JMB admin page
	// * Param        : String shippingStatus
	// * Jira Ticket  : JMB 7279
	// * Status       : Completed
	//*******************************************************************/
	public void verifyShippingMsgStatus(String shippingStatus) {
		driver.navigate().refresh();
		Q_WebElm.myWait(1500);
		String shippingMessage = Q_WebElm.xpRetText(ticketsProps,"adm.verify.shippingStatusMsg.xp");
		Assert.assertTrue(shippingMessage.contains(shippingStatus), "Shipping is not ready");
	}

	/********************************************************************
	// * Description  : Uncheck all the operation hold reasons on the orders from admin page
	// * Param        : NA
	// * Jira Ticket  : JMB 7279
	// * Status       : Completed
	//*******************************************************************/
	public void uncheckAllOperationHold() {
		Integer numberOfPermissions = Q_WebElm.xpCountTableRows(ticketsProps,"adm.hold.xp");
		for (int i = 1; i < numberOfPermissions; i++) {

			if (Q_WebElm.xpSelected(ticketsProps,"adm.holdLabel.beg.xp", i, "adm.holdLabel.end.xp")) {
				Q_WebElm.xp(ticketsProps, "adm.holdLabel.beg.xp", i, "adm.holdLabel.end.xp");
			}
		}
		System.out.println("Uncheck the allcheckboxes");
		ord.formInputId("ord.hold.notes.id", "Automated test case");
		ord.formId("ord.hold.updateHolds.id");
	}

	/********************************************************************
	// * Description  : Clear all the unpaid invoices on the customer from admin page
	// * Param        : NA
	// * Jira Ticket  : JMB 7279
	// * Status       : Completed
	//*******************************************************************/
	public void payAllUnpaidInvoicesForCustomer() {

		try {
			Assert.assertTrue(Q_OrderForm.isXpDisplayed("cust.unpaidInvoiceHeader.xp"));
			int noOfInvoices = Q_OrderForm.rowCount("cust.noOfInvoices.xp");
			for (int i = 0; i < noOfInvoices; i++) {
				Q_WebElm.listOfElements(ticketsProps, "adm.customer.unpaidInvoice.viewBtn.xp").get(i).click();
				Controls.switchWin();
				Q_WebElm.xp(ticketsProps, "adm.unpaidInvoice.markInvoicePaidBtn.xp");
				Q_WebElm.myWait(1000);
				Controls.checkAlert();
				System.out.println("Invoice paid");
				driver.close();
				Controls.switchTab(2);
				driver.navigate().refresh();
				payAllUnpaidInvoicesForCustomer();
			}
		}catch (Exception e){
			driver.close();
			Controls.switchTab(1);
		}
	}

	/********************************************************************
	// * Description  : Place an order in JMB
	// * Param        : String product, String paymentType
	// * Jira Ticket  : JMB 5763 (Reusable method)
	// * Status       : Completed
	//*******************************************************************/
	public String placeAnOrder(String product, String paymentType) {
		driver.navigate().to(baseUrl +product );
		chk.addItemToCart(1);
		chk.selectPaymentType(paymentType);
		chk.selectcheckoutBtn("top");
		Q_WebElm.xpClear(ticketsProps, "cust.secureCheckout.enterCSC.xp");
		Q_WebElm.xpSend(ticketsProps, "cust.secureCheckout.enterCSC.xp", "110");
		chk.completeOrder();
		String orderId = Q_WebElm.xpRetText(ticketsProps,"adm.thankyou.getOrderId.xp").replaceAll("Order Number: ORD-", "").trim();
		return orderId;
	}

	/********************************************************************
	// * Description  : Search order in admin page
	// * Param        : String orderId
	// * Jira Ticket  : JMB 7279
	// * Status       : Completed
	//*******************************************************************/
	public void searchOrderAndNavigateToCustomerPage(String orderId) {
		Q_WebElm.myWait(1000);
		Q_WebElm.xpClear(ticketsProps, "adm.orderNumberSearch.xp");
		Q_WebElm.xpSend(ticketsProps, "adm.orderNumberSearch.xp", orderId);
		Q_WebElm.xp(ticketsProps,"adm.orderSearchSubmit.xp");
		Q_WebElm.myWait(3000);
		Controls.switchTab(1);
		Q_WebElm.myWait(3000);
		Q_WebElm.xp(ticketsProps,"adm.customer.xp"); 
		Controls.switchTab(2);
	}
	//JMB-7279-End


	// JMB-8395-Start	

	/********************************************************************
	// * Description : Remove and Add new discount tiers in admin page  
	// * Author      : Sivaraj
    // * Param       : int numberOfTires, String site, String addBtn
	// * Return      : NA
	// * Status      : Complete
	//*******************************************************************/
	public void removeAndAddDiscountTiers(int numberOfTires, String site, String addBtn) {
		Controls.scrolDownPixel(1000); 	
		for (int i = 0; i <numberOfTires; i++) {
			Q_WebElm.myWait(2000);
			driver.findElement(By.xpath("//table[@id='"+site+"']//a[normalize-space()='Remove']")).click();
		}
		String[] fromQty = {"1", "10", "25", "100"};
		String[] toQty = {"9", "24", "99", "10000"};
		String[] amt = {"0", "1", "2", "3"};
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.xpath("//table[@id='"+site+"']/tfoot/tr[1]/td[1]/input")).sendKeys(fromQty[i]);
			driver.findElement(By.xpath("//table[@id='"+site+"']/tfoot/tr[1]/td[2]/input")).sendKeys(toQty[i]);
			driver.findElement(By.xpath("//table[@id='"+site+"']/tfoot/tr[1]/td[3]/input")).sendKeys(amt[i]);
			Q_WebElm.xp(ticketsProps, addBtn);
			driver.findElement(By.xpath("//table[@id='"+site+"']/tfoot/tr[1]/td[1]/input")).clear();
			driver.findElement(By.xpath("//table[@id='"+site+"']/tfoot/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='"+site+"']/tfoot/tr[1]/td[3]/input")).clear();
		}
		Q_WebElm.myWait(2000);
		Q_WebElm.xp(adminProps, "prod.prodPage.save.xp");
		Q_WebElm.myWait(2000);
		Assert.assertTrue(Q_WebElm.listOfElements(ticketsProps, "prod.bgascDiscount.errorMsg.xp").size()==0, "Error message is not displayed!");
	}

	/********************************************************************
	// * Description : Remove discount tiers amount in product page  
	// * Author      : Sivaraj
	// * Param       : String siteDiscount, String counter, String site 
	// * Return      : NA
	// * Status      : Complete
	//*******************************************************************/    
	public void removeDiscountTiers(String siteDiscount, String counter, String site ) {
		Controls.switchWin();
		Controls.scrolDownPixel(1200);
		Q_WebElm.myWait(2000);
		Q_WebElm.xp(ticketsProps, siteDiscount);
		Integer count = Q_WebElm.xpCountTableRows(ticketsProps, counter);
		for(int i= count; i >= 1; i--) {
			Q_WebElm.myWait(2000);
			driver.findElement(By.xpath("//table[@id='"+site+"']/tbody/tr[1]/td[7]/a[text()='Remove']")).click();
			System.out.println("Deleted discount tier " + i);
		}
	}

	/********************************************************************
	// * Description : Reset discount tiers in admin page  
	// * Author      : Sivaraj
	// * Param       : String site, String addBtn 
	// * Return      : NA
	// * Status      : Complete
	//*******************************************************************/        
	public void resetDiscountTiers(String site, String addBtn) {
		Q_WebElm.myWait(2000);
		driver.findElement(By.xpath("//table[@id='"+site+"']/tfoot/tr[1]/td[1]/input")).sendKeys("1");
		driver.findElement(By.xpath("//table[@id='"+site+"']/tfoot/tr[1]/td[2]/input")).sendKeys("10000");
		driver.findElement(By.xpath("//table[@id='"+site+"']/tfoot/tr[1]/td[3]/input")).sendKeys("0");
		Q_WebElm.xp(ticketsProps, addBtn);
		driver.findElement(By.xpath("//table[@id='"+site+"']/tfoot/tr[1]/td[1]/input")).clear();
		driver.findElement(By.xpath("//table[@id='"+site+"']/tfoot/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='"+site+"']/tfoot/tr[1]/td[3]/input")).clear();
		Q_WebElm.myWait(2000);
		Q_WebElm.xp(adminProps, "prod.prodPage.save.xp");	
	}

	/********************************************************************
	// * Description : To get number of tires   
	// * Author      : Sivaraj
	// * Param       : String environmentName
	// * Return      : numberOfTires
	// * Status      : Complete
	//*******************************************************************/    
	public int getNumberOfTires(String environmentName) {
		Controls.switchWin();
		int numberOfTires = 0;
		switch (environmentName) {
			case "JMB":
				Q_WebElm.xp(adminProps, "prod.jmDiscount.xp");
				numberOfTires = Q_WebElm.xpCountTableRows(adminProps, "prod.jmDiscount.rowCount.xp");
				break;
	
			case "PM":
				Q_WebElm.xp(adminProps, "prod.pmDiscount.xp");
				numberOfTires = Q_WebElm.xpCountTableRows(adminProps, "prod.pmDiscount.rowCount.xp");
				break;
	
			case "SLV":
				Q_WebElm.xp(adminProps, "prod.silverDiscount.xp");
				numberOfTires = Q_WebElm.xpCountTableRows(adminProps, "prod.silverDiscount.rowCount.xp");
				break;
	
			case "BGASC":
				Q_WebElm.xp(ticketsProps, "prod.bgascDiscount.xp");
				numberOfTires = Q_WebElm.xpCountTableRows(ticketsProps, "prod.bgascDiscount.count.xp");
				break;
		}
		return numberOfTires;
	}

	/********************************************************************
	// * Description : To verify discount amount    
	// * Author      : Sivaraj
	// * Param       : String onSite, String pdpBegXp, String pdpEndXp
	// * Return      : NA
	// * Status      : Complete
	//*******************************************************************/    
	public void pdpDiscount(String onSite, String pdpBegXp, String pdpEndXp) {
		Controls.switchWin();
		Controls.scrolUpPixel(2000);
		Q_WebElm.xp(ticketsProps, onSite);
		Controls.switchWin();
		Q_WebElm.myWait(2000);
		String tier1 = Q_WebElm.xpRetNumber(ticketsProps, pdpBegXp,1,pdpEndXp);
		System.out.println("check price tier 1 " + tier1);
		
        String tier2 = Q_WebElm.xpRetNumber(ticketsProps, pdpBegXp, 2, pdpEndXp);
        System.out.println("check price tier 2 " + tier2);
        float disc1 = Float.valueOf(tier1 )- Float.valueOf(tier2);
        Assert.assertEquals(disc1, 1f);

        String tier3 = Q_WebElm.xpRetNumber(ticketsProps, pdpBegXp, 3, pdpEndXp);
        System.out.println("check price tier 3 " + tier3);
        float disc2 = Float.valueOf(tier1 )- Float.valueOf(tier3);
        Assert.assertEquals(disc2, 2f);

        String tier4 = Q_WebElm.xpRetNumber(ticketsProps, pdpBegXp, 4, pdpEndXp);
        System.out.println("check price tier 4 " + tier4);
        float disc3 = Float.valueOf(tier1 )- Float.valueOf(tier4);
        Assert.assertEquals(disc3, 3f);
	}

	// JMB-8395-End 

}