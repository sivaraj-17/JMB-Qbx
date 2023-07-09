package pageObjects;



import org.openqa.selenium.By;

import org.testng.Assert;


import utils.Q_JMB_Controls;
//import io.appium.java_client.functions.ExpectedCondition;
import utils.Q_JMB_Init;



public class Q_JMB_TicketsObjects extends Q_JMB_Init {
	
	static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();

	/**
	 * This method selects the verifies the active Shipping Method
	 * @param shippingMethod
	 */
	public void verifyActiveShippingMethod(String shippingMethod) {
		String value = Q_JMB_WebElm.xpRetText(ticketsProp, "chk.activeShippingMethod.xp").replace("\n", " ");
		Assert.assertEquals(value, shippingMethod ,"Verify sipping method '" + shippingMethod + "' active failed.");
	}
	
	
	/****************************************** JMB-Ticket Specific********************************************/
	
	//JMB-7855-Start
	
	/******************************************************************
	// * Description : To checkout a product using Payal 
	// * Param       : String paymentType, String chkOutBtn, String originalWindow
	// * Jira Ticket : JMB 7655 (Reused this Method from ticket JMB 7655)
	// * Status      : Completed
	//*******************************************************************/  
	public void payPalCheckout(String paymentType, String chkOutBtn, String originalWindow) {
		Q_JMB_WebElm.idExecutor(ticketsProp, paymentType);
		Q_JMB_WebElm.myWait(4000);
		Q_JMB_WebElm.xp(ticketsProp, chkOutBtn);
		System.out.println("Paypal checkout clicked");
		Q_JMB_WebElm.myWait(2000);
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}
		
	/*****************************************************
	// * Description  : To get the OrderId for an Order
	// * Param        : NA
	// * Jira Ticket  : JMB 7655 (Reused this Method from ticket JMB 7655)
	// * Status       : Completed
	//****************************************************/  
	public String getOrderId() {
		String orderId = Q_JMB_WebElm.xpRetText(ticketsProp, "chk.thankYou.getOrderId.xp").replaceAll("Order Number: ORD-", "").trim();
		System.out.println(orderId);
		return orderId;
	}
	
	/*****************************************************
	// * Description : To get the Order Total for an Order
	// * Param       : NA
	// * Jira Ticket : 7855
	// * Status      : Completed
	//****************************************************/  
	public String getOrderTotal() {
		String orderTotal = Q_JMB_WebElm.xpRetText(ticketsProp, "chk.thankYou.getOrderTotal.xp").replaceAll("Order Total:", "").trim();
		System.out.println(orderTotal);
		return orderTotal;
	}
	
	/************************************************************
    // * Description :  To select order based on orderId in admin page
    // * Param       :  String orderId
    // * Jira Ticket :  JMB 7655(Reused this Method from ticket JMB 7655)
    // * Status      :  Completed
    //***********************************************************/ 	
	public void navigateToEditOrderInAdminPage(String orderId) {
		Q_JMB_Controls.adminLogin();		
		driver.get("https://qa.jmbullion.com/admin/orders.php?ordertype=new");
		Q_JMB_WebElm.myWait(5000);
		Q_JMB_WebElm.xpClear(ticketsProp,"adm.orderNumberSearch.xp");
		Q_JMB_WebElm.xpSend(ticketsProp,"adm.orderNumberSearch.xp",orderId);
		Q_JMB_WebElm.xp(ticketsProp,"adm.orderSearchSubmit.xp");	
		Q_JMB_WebElm.myWait(3000);
		Q_JMB_Controls.switchTab(1);
	}

	/************************************************************
    // * Description :  To verify order id and order total
    // * Param       :  String orderId, String orderTotal
    // * Jira Ticket :  JMB 7855
    // * Status      :  Completed
    //***********************************************************/
	public void verifyCustomerOrders(String orderId, String orderTotal) {
		Q_JMB_WebElm.xp(ticketsProp, "adm.customer.xp");
		Q_JMB_WebElm.myWait(2000);
		Q_JMB_Controls.switchWin();
		driver.findElement(By.xpath("//table[1]/tbody//child::a[contains((.),'" + orderId+ "')]//parent::td//following-sibling::td[contains((.),'" + orderTotal + "')]")).isDisplayed();
	}
	//JMB-7855-End
	
	//JMB-7384-Start
	/************************************************************
    // * Description :  Search and Select the product
    // * Param       :  String product
    // * Jira Ticket :  JMB 7384
    // * Status      :  Completed
    //***********************************************************/	
	public void searchBuyBackProduct(String product) {
		Q_JMB_WebElm.xpClear(ticketsProp, "chk.stu.productSearch.xp");
		Q_JMB_WebElm.xpSend(ticketsProp, "chk.stu.productSearch.xp",product);
		Q_JMB_WebElm.xpSendEnter(ticketsProp, "chk.stu.productSearch.xp");
		Q_JMB_WebElm.xp(ticketsProp, "chk.stu.electProduct.xp");
	}
	
	/************************************************************
    // * Description :  Select the new shipping address
    // * Param       :  NA
    // * Jira Ticket :  JMB 7384
    // * Status      :  Completed
    //***********************************************************/
	public void isSelectNewShippingAddress() {
		try {
			Q_JMB_WebElm.xpDisplayed(ticketsProp, "chk.stu.newShippAddress.xp");
			Q_JMB_WebElm.xp(ticketsProp, "chk.stu.newShippAddress.xp");

		} catch (Exception e) {
			System.out.println("Create address!");
		}
	}
 
	/************************************************************
    // * Description :  Select the shipping method 
    // * Param       :  String shippingMethod
    // * Jira Ticket :  JMB 7384
    // * Status      :  Completed
    //***********************************************************/
	public void shippingMethod(String shippingMethod) {

		switch (shippingMethod) {
			case "Send Me a Shipping Kit and Label":
				Q_JMB_WebElm.xp(ticketsProp, "chk.stu.sendMeKitLabel.xp");
				break;
			case "Make Me a Label":
				Q_JMB_WebElm.xp(ticketsProp, "chk.stu.makeMeLabel.xp");
				break;
			case "Use My Own Label":
				Q_JMB_WebElm.xp(ticketsProp, "chk.stu.useMyOwnLabel.xp");
				break;
		}
	}
	
	/************************************************************
    // * Description :  Continue the Address
    // * Param       :  NA
    // * Jira Ticket :  JMB 7384
    // * Status      :  Completed
    //***********************************************************/
	public void continueWithAddress() {
		Q_JMB_WebElm.id(jmbProps, "chk.shipping.ContinueWithAdd.id");
		Q_JMB_WebElm.myWait(1000);
	}
	//JMB-7384-End
	
	//JMB-6778-Start
	/********************************************************************
	// * Description  : To verify Order status in my accounts  
	// * Param        : NA
	// * Jira Ticket  : JMB 6778
	// * Status       : Completed
	//*******************************************************************/
	public void verifyMyAccountOrderStatus() {
		try {
			Q_JMB_WebElm.xpDisplayed(ticketsProp, "myAccount.orderDisplay.xp");
			int count = Q_JMB_WebElm.xpCountTableRows(ticketsProp, "myAccount.orders.orderNo.xp");
			acc.accounttMenuLinks("orders");
			for (int rowElement = 0; rowElement < count; rowElement++) {
				String orderStatus = Q_JMB_WebElm.xpRetText(ticketsProp, "myAccount.ordersStatus.beg.xp", rowElement,"myAccount.ordersStatus.end.xp");
				if (orderStatus.equals("Pending")) {
					System.out.println(orderStatus);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Orders Not available!");
		}
	}
	
	/********************************************************************
	// * Description  : To change the Order status in admin page  
	// * Param        : String text
	// * Jira Ticket  : JMB 6778
	// * Status       : Completed
	//*******************************************************************/
	public void changeOrderStatus(String text) {
		Q_JMB_WebElm.myWait(2000);
		Q_JMB_WebElm.idExecutor(ticketsProp, "ord.orderStatus.id");
		System.out.println(Q_JMB_WebElm.idAttrRet(ticketsProp, "ord.orderStatusSelect.id", "value"));
		Q_JMB_WebElm.myWait(2000);
		switch (text) {
			case "cancelled":
				Q_JMB_WebElm.idSelectValue(ticketsProp, "ord.orderStatusSelect.id", text);
				break;
			case "paid":
				Q_JMB_WebElm.idSelectValue(ticketsProp, "ord.orderStatusSelect.id", text);
				Q_JMB_WebElm.myWait(500);
				Q_JMB_WebElm.xpClear(ticketsProp, "ord.orderStatusNote.xp");
				Q_JMB_WebElm.xpSend(ticketsProp, "ord.orderStatusNote.xp", "Automated Test");
				Q_JMB_WebElm.id(ticketsProp, "ord.orderStatusNoteUpdateBtn.id");
				Q_JMB_WebElm.myWait(2000);
				break;
			case "shipped":
				Q_JMB_WebElm.idSelectValue(ticketsProp, "ord.orderStatusSelect.id", text);
				Q_JMB_WebElm.myWait(1500);
				Q_JMB_WebElm.id(ticketsProp, "ord.orderStatusShippedBatchBtn.id");
				break;
			case "completed":
				Q_JMB_WebElm.idSelectValue(ticketsProp, "ord.orderStatusSelect.id", text);
				Q_JMB_WebElm.myWait(500);
				Q_JMB_WebElm.xpClear(ticketsProp, "ord.orderStatusNote.xp");
				Q_JMB_WebElm.xpSend(ticketsProp, "ord.orderStatusNote.xp", "Automated Test");
				Q_JMB_WebElm.id(ticketsProp, "ord.orderStatusNoteUpdateBtn.id");
				break;
			default:
				System.out.println("Invalid order status");
		}
	}
	
	/********************************************************************
	// * Description  : To verify Order status in my accounts  
	// * Param        : boolean availablity
	// * Jira Ticket  : JMB 6778
	// * Status       : Completed
	//*******************************************************************/
	public void verifyDeleteLink(boolean availablity) {
		driver.navigate().to(baseUrl+"/my-account/");
		acc.myAccount("payments");
		if (availablity) {
			Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(ticketsProp, "acc.account.paymentDeleteCard.xp"),"Delete link is not available!");
			System.out.println("Delete link is available!");
		} else {
			try {
				Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(ticketsProp, "acc.account.paymentDeleteCard.emptyBox.xp"), "Delete link should be available");
				System.out.println("Delete link is Not available!");
			} catch (Exception e) {
				System.out.println("Delete link is available!");
			}
		}
	}
	//JMB-6778-End
}