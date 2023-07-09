package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Controls;
import utils.Init;
import java.util.concurrent.ThreadLocalRandom;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class Q_ReceiptForm extends Init {
    static Q_ReceiptForm prod = new Q_ReceiptForm();
    static Q_NewFeatures nf = new Q_NewFeatures();
    static Q_CheckoutForm chk = new Q_CheckoutForm();
    static Controls li = new Controls();

    public Q_ReceiptForm formXp(String locator) {
        Q_WebElm.xp(adminProps, locator);
        return this;
    }
    public Q_ReceiptForm formXp(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xp(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public Q_ReceiptForm formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_WebElm.xp(adminProps, begXp, row, midXp, column, endXp);
        return this;
    }
    public Q_ReceiptForm formInputXp(String locator, String inputValue) {
        Q_WebElm.xpClear(adminProps, locator);
        Q_WebElm.xpSend(adminProps, locator, inputValue);
        return this;
    }
    public Q_ReceiptForm formInputXp(String begXp, Integer lineItem, String endXP, String inputValue) {
        Q_WebElm.xpClear(adminProps, begXp, lineItem, endXP);
        Q_WebElm.xpSend(adminProps, begXp, lineItem, endXP, inputValue);
        return this;
    }
    public static String strXpText(String locator) {
        return Q_WebElm.xpRetText(adminProps, locator);
    }
    public static String strXpText(String begXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, lineItem, endXp);
    }
    public static String strXpText(String begXp, Integer row, String midXp, Integer cell, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, row, midXp, cell,  endXp);
    }
    public static String numberReturn(String locator) {
        return Q_WebElm.xpRetNumber(adminProps, locator);
    }
    public static String numberReturn(String begXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetNumber(adminProps, begXp, lineItem, endXp);
    }
    public static String numberReturn(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetNumber(adminProps, begXp, recordNumber, midXp, lineItem, endXp);
    }
    public Q_ReceiptForm formReturnText(String locator) {
        Q_WebElm.xpRetText(adminProps, locator);
        return this;
    }
    public Q_ReceiptForm formReturnText(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpRetText(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, recordNumber, midXp, lineItem, endXp);
    }
    public static String formReturnTextReplace(String locator) {
        return Q_WebElm.xpRetNumber(adminProps, locator);
    }

    public Q_ReceiptForm formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpRetNumber(adminProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_ReceiptForm formReturnAttribute(String locator, String attr) {
        Q_WebElm.xpRetAttr(adminProps, locator,attr);
        return this;
    }
    public static String attReturn(String locator, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, locator,attr);

    }
    public static String attReturn(String begXp, Integer lineItem, String endXp, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp, attr);
    }
    public Q_ReceiptForm formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp,attr);
        return this;
    }

    public Q_ReceiptForm formReturnAttributeReplace(String locator) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, locator);
        return this;
    }

    public Q_ReceiptForm formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public Q_ReceiptForm formXpDisplayed(String locator) {
        try {
            Q_WebElm.xpDisplayed(adminProps, locator).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }
    public Q_ReceiptForm formXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_WebElm.xpDisplayed(adminProps, begXp, lineItem, endXP).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }
    public Q_ReceiptForm formXpTab(String locator) {
        Q_WebElm.xpSendTab(adminProps, locator);
        return this;
    }

    public Q_ReceiptForm formXpTab(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendTab(adminProps, begXp, lineItem, endXP);
        return this;
    }

    public Q_ReceiptForm formXpEnter(String locator) {
        Q_WebElm.xpSendEnter(adminProps, locator);
        return this;
    }

    public Q_ReceiptForm formXpEnter(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendEnter(adminProps, begXp, lineItem, endXP);
        return this;
    }
    public static boolean isXpDisplayed(String locator) {
        return  Q_WebElm.xpEnabled(adminProps, locator).equals(true);
    }
    public static boolean isXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_WebElm.xpDisplayed(adminProps, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            System.out.println(ex);
            return false;
        }
    }
    public static boolean isXpCheckSelected(String locator) {
        return Q_WebElm.xpSelected(adminProps, locator).equals(true);
    }
    public static boolean isXpCheckSelected(String begXp, Integer lineItem, String endXP) {
        return Q_WebElm.xpSelected(adminProps, begXp, lineItem, endXP).equals(true);
    }
    public static boolean isXpCheckEnabled(String locator) {
        return Q_WebElm.xpEnabled(adminProps, locator).equals(true);
    }

    public static boolean isXpCheckEnabled(String begXp, Integer lineItem, String endXP) {
        try {
            Q_WebElm.xpEnabled(adminProps, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            return false;
        }
    }
    public Q_ReceiptForm formXpSelectIndex(String locator, Integer index) {
        Q_WebElm.xpSelectIndex(adminProps, locator, index);
        return this;
    }

    public Q_ReceiptForm formXpSelectValue(String locator, String value) {
        Q_WebElm.xpSelectValue(adminProps, locator, value);
        return this;
    }
    public Q_ReceiptForm formXpSelectText(String locator, String text) {
        Q_WebElm.xpSelectText(adminProps, locator, text);
        return this;
    }
    public Q_ReceiptForm formId(String locator) {
        Q_WebElm.id(adminProps, locator);
        return this;
    }
    public Q_ReceiptForm formInputId(String locator, String inputValue) {
        Q_WebElm.idClear(adminProps, locator);
        Q_WebElm.idSend(adminProps, locator, inputValue);
        return this;
    }
    public static String strIdText(String locator) {
        return Q_WebElm.idRetText(adminProps, locator);
    }
    public static String idStrRet(String locator) {
        return Q_WebElm.idRetText(adminProps, locator);
    }
    public static String idNumberReturn(String locator) {
        return Q_WebElm.idRetTextRep(adminProps, locator);
    }
    public static String idAttRet(String locator, String attr) {
        return Q_WebElm.idAttrRet(adminProps, locator, attr);
    }
    public static boolean isIdDisplayed(String locator) {
        return  Q_WebElm.idDisplayed(adminProps, locator).equals(true);}
    public Q_ReceiptForm formIdSelectIndex(String locator, Integer index) {
        Q_WebElm.idSelectIndex(adminProps, locator, index);
        return this;
    }

    public Q_ReceiptForm formIdSelectValue(String locator, String value) {
        Q_WebElm.idSelectValue(adminProps, locator, value);
        return this;
    }
    public Q_ReceiptForm formIdSelectText(String locator, String text) {
        Q_WebElm.idSelectText(adminProps, locator, text);
        return this;
    }
    public static Integer rowCount(String locator) {
        Integer count = Q_WebElm.xpCountTableRows(adminProps, locator);
        return count;
    }


    //JMB-6469 Start
  	/***************************************************************
  	 * Description: Create New Wire
  	 * Author: Asfi Khaliq
  	 * Param: String supplier
  	 * Returns: None
  	 * Status: Complete
  	 **************************************************************/
  	public void createNewWire(String supplier, String ticketNo)	{
  		float calculatedTotal= 0;
  		formXp("wire.addNewWire.plusIcon.xp");
  		Q_WebElm.xpSelectText(adminProps, "wire.selectSupplier.xp", supplier);
  		Q_WebElm.myWait(4000);
  		int rowCount = rowCount("wire.addNewWire.payOrder.checkBoxList.xp");
  		List<WebElement> ticketNos = Q_WebElm.listOfElements(adminProps, "wire.addNewWire.ticketNoList.xp");
  		for(int index = 0; index < rowCount; index++)	{
  			if (ticketNos.get(index).getText().equalsIgnoreCase(ticketNo))	{
  				Q_WebElm.listOfElements(adminProps, "wire.addNewWire.payOrder.checkBoxList.xp").get(index).click();
  				List<WebElement> productRows = driver.findElements(By.xpath("//*[@id='accordion']//div[@class='panel-body']/div[" +(index+1)+ "]//td[2]//td/input"));
  				List<WebElement> productRowTotal = driver.findElements(By.xpath("//*[@id='accordion']//div[@class='panel-body']/div[" +(index+1)+ "]//td[2]//td[2]"));
  				System.out.println("Number of products in the receipt = " + productRows.size());
  				for (int row= 0; row < productRows.size(); row++)	{
  					String rowTotal= productRowTotal.get(row).getText().toString().replaceAll("[$,]", "");
  					calculatedTotal= calculatedTotal + Float.parseFloat(rowTotal);	
  				}
  				System.out.println("The receipt total before Shipment cost = " + calculatedTotal);
  				break;
  			}
  		}
  		float wireTotal= Float.parseFloat(strXpText("wire.addNewWire.wireTotal.xp").toString().replaceAll("[$,]", ""));
  		Assert.assertEquals(calculatedTotal, wireTotal, "Variation found in Wire Total");
  		Q_WebElm.xp(adminProps, "jm.returnOrderItemSubmit.xp");
  	}
  	
  	/***************************************************************
  	 * Description: search receipts from List Receipts section through 
  	 * ticket number
  	 * Author: Asfi Khaliq
  	 * Param: String supplier
  	 * Returns: None
  	 * Status: Complete
  	 **************************************************************/
  	public void searchReceiptsByTicketNo(String ticketNo)	{
  		System.out.println("Receipt Number to be searched and edited : " + ticketNo);
  		Q_WebElm.idClear(adminProps, "receipt.searchByTicketNo.id");
  		Q_WebElm.idSend(adminProps, "receipt.searchByTicketNo.id", ticketNo);
  		Q_WebElm.xp(adminProps, "jm.returnOrderItemSubmit.xp");
  	}
  	
  	/***************************************************************
  	 * Description: Add shipment cost to Receipt
  	 * Author: Asfi Khaliq
  	 * Param: String ticketNo
  	 * Returns: None 
  	 * Status: Complete
  	 **************************************************************/
  	public void addShipmentCostToReceipt(String shipmentCost, String ticketNo) {
  		Q_AdminForm adm = new Q_AdminForm();
  		adm.adminMenu("receipts");
  		adm.formXp("adm.recpSub.listReceipts.xp");
  		searchReceiptsByTicketNo(ticketNo);
  		adm.formXp("adm.editTopReceipt.xp");
  		Controls.switchWin();
  		Q_WebElm.xpClear(adminProps, "receipt.addShipmentCost.xp");
  		Q_WebElm.xpSend(adminProps, "receipt.addShipmentCost.xp", shipmentCost);
  		adm.saveReceipt();
  		Q_WebElm.myWait(3000);
  	}
  	
  	/***************************************************************
  	 * Description: generate random number to input as receipt ticket
  	 * number
  	 * Author: Asfi Khaliq
  	 * Param: None
  	 * Returns: order/ticket Number
  	 * Status: Complete
  	 * @return orderNo
  	 **************************************************************/
  	public String addOrderNumberToReceipt()	{
  		int randomNo = ThreadLocalRandom.current().nextInt(0, 99999999);
  		String orderNo= "" + randomNo;
  		System.out.println(orderNo);
  		Q_WebElm.idSend(adminProps, "receipt.orderNumber.id", orderNo);
  		return orderNo;
  	}
  	
  	/***************************************************************
  	 * Description: After adding Shipment cost to receipt and then
  	 * get new wire cost.
  	 * Author: Asfi Khaliq
  	 * Param: String supplier, String ticketNo
  	 * Returns: total cost of products 
  	 * Status: Complete
  	 * @return calculatedTotal
  	 **************************************************************/
  	public float getNewWireCost_addedShipmentCost(String supplier, String ticketNo) {
  		float calculatedTotal = 0;
  		formXp("wire.addNewWire.plusIcon.xp");
  		Q_WebElm.xpSelectText(adminProps, "wire.selectSupplier.xp", supplier);
  		Q_WebElm.myWait(4000);
  		int rowCount = rowCount("wire.addNewWire.payOrder.checkBoxList.xp");
  		List<WebElement> ticketNos = Q_WebElm.listOfElements(adminProps, "wire.addNewWire.ticketNoList.xp");
  		for (int index = 0; index < rowCount; index++) {
  			if (ticketNos.get(index).getText().equalsIgnoreCase(ticketNo)) {
  				Q_WebElm.listOfElements(adminProps, "wire.addNewWire.payOrder.checkBoxList.xp").get(index).click();
  				List<WebElement> productRows = driver.findElements(By.xpath("//*[@id='accordion']//div[@class='panel-body']/div[" + (index + 1) + "]//td[2]//td/input"));
  				List<WebElement> productRowTotal = driver.findElements(By.xpath("//*[@id='accordion']//div[@class='panel-body']/div[" + (index + 1) + "]//td[2]//td[2]"));
  				System.out.println("Number of products in the receipt = " + productRows.size());
  				for (int row = 0; row < productRows.size(); row++) {
  					String rowTotal = productRowTotal.get(row).getText().toString().replaceAll("[$,]", "");
  					calculatedTotal = calculatedTotal + Float.parseFloat(rowTotal);
  				}
  				break;
  			}
  		}
  		return calculatedTotal;
  	}
  	
  	/***************************************************************
  	 * Description: Verify wire total on Add new wire page
  	 * Author: Asfi Khaliq
  	 * Param: String shipmentCost, float calculatedWireTotal
  	 * Returns: None 
  	 * Status: Complete
  	 **************************************************************/
  	public void verifyWireTotal_afterShipmentCostAddition(String shipmentCost, float calculatedWireTotal) {
  		float shipCost = Float.parseFloat(shipmentCost);
  		float wireTotal = Float.parseFloat(strXpText("wire.addNewWire.wireTotal.xp").toString().replaceAll("[$,]", ""));
  		System.out.println("The receipt total after Shipment cost = " + wireTotal);
  		Assert.assertEquals(calculatedWireTotal + shipCost, wireTotal, "Variation found in Wire Total");
  		System.out.println("Verified that total amount displayed is inclusive of Shipping cost.");
  		Q_WebElm.xp(adminProps, "jm.returnOrderItemSubmit.xp");
  	}
  	//JMB-6469 End
  	
  	//JMB-7319 Start
  	/***************************************************************
  	 * Description: Add a product to a Repo
  	 * Author: Asfi Khaliq
  	 * Param: SString product, Integer qty
  	 * Returns: None
  	 * Status: Complete
  	 **************************************************************/
  	public void addRepoProduct(String product, Integer qty) {
  		Q_AdminForm adm = new Q_AdminForm();
  		adm.formInput("adm.repoPo.xp", Controls.startTimeStriped());
  		adm.formXp("adm.repoProductSelect.xp");
  		adm.formInput("adm.repoProductInput.xp", product);
  		adm.formEnter("adm.repoProductInput.xp");
  		Q_WebElm.xpSendInteger(adminProps, "adm.repoQty.xp", qty);
  		adm.formInput("adm.repoSellPrice.xp", "32.01");
  		adm.formInput("adm.repoBuyPrice.xp", "22.02");
  	}
  	
  	/***************************************************************
  	 * Description: Verify Decimal Places of Product's premium and
  	 * total premium
  	 * Author: Asfi Khaliq
  	 * Param: None
  	 * Returns: None
  	 * Status: Complete
  	 **************************************************************/
  	public void verifyPremiumDecimalPlaces()	{
  		String premium= attReturn("adm.repoProductPremium.xp", "value");
  		String[] resultPremium = premium.split("\\.");
  		Assert.assertEquals(6, resultPremium[1].length());
  		String totalPremium= attReturn("adm.repoProductTotalPremium.xp", "value");
  		System.out.println("Premium= " + premium + " & " + "Total Premium= " + totalPremium);
  		String[] resultTotalPremium = totalPremium.split("\\.");
  		Assert.assertEquals(2, resultTotalPremium[1].length());
  	}
  	//JMB-7319 End
  	
  	//JMB-7651 Start
  	/********************************************************************
  	 // * Description  : Update the pricing receipt information 
  	 // * Param        : String currentDate, String supplier, String paidStatus
  	 // * Jira Ticket  : JMB 7651
  	 // * Status       : Completed
  	 //*******************************************************************/
  	public void xpSendInputEnter(String locator, String value){
		Q_WebElm.xpClear(adminProps, locator);
		driver.findElement(By.xpath(adminProps.getProperty(locator))).sendKeys(value,Keys.ENTER);
	}
  	
  	public void formSelectText(String locator, String text) {
        Q_WebElm.xpSelectText(adminProps, locator, text);
    }
  	public void updateReceiptInformation(String currentDate, String supplier, String paidStatus) {
  		switch (paidStatus) {
  			case ("adm.addReceipt.yes.xp"):
  				xpSendInputEnter("adm.addReceipt.arrivalDate.xp", currentDate);
  				formSelectText("adm.addReceipt.supplier.xp", supplier);
  				formXp(paidStatus);
  				formXp("adm.addReceipt.selectProduct.xp");
  				xpSendInputEnter("adm.addReceipt.enterProduct.xp", "2019 1/10 oz American Gold Eagle Coin (BU)");
  				xpSendInputEnter("adm.addReceipt.quantity.xp", "2");
  				xpSendInputEnter("adm.addReceipt.unitPrice.xp", "180.00");
  				break;
  			case ("adm.addReceipt.no.xp"):
  				formXp("adm.addReceipt.addEditBtn.xp");
  				Controls.switchTab(1);
  				xpSendInputEnter("adm.addReceipt.arrivalDate.xp", currentDate);
  				formSelectText("adm.addReceipt.supplier.xp", supplier);
  				formXp(paidStatus);
  				break;
  		}
  		Q_WebElm.myWait(2000);
  		formXp("adm.addReceipt.saveChangesBtn.xp");
  		Q_WebElm.myWait(5000);
  	}

  	/********************************************************************
  	 // * Description  : To get the current EST time (Reused this Method from ticket JMB 7554)
  	 // * Param        : NA
  	 // * Jira Ticket  : JMB 7554
  	 // * Status       : Completed
  	 //*******************************************************************/
  	public String getCurrentESTDateAndTime() {
  		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  		df.setTimeZone(TimeZone.getTimeZone("EST"));
  		Calendar cal = Calendar.getInstance();
  		Date currentDate = cal.getTime();
  		cal.setTime(currentDate);
  		String currentESTDateandTime = df.format(cal.getTime());
  		return currentESTDateandTime;
  	}

  	/********************************************************************
  	 // * Description  : verify the paid status message in receipt information  
  	 // * Param        : String paidStatus
  	 // * Jira Ticket  : JMB 7651
  	 // * Status       : Completed
  	 //*******************************************************************/
  	public void verifyPaidStatusMsg(String paidStatus) {
  		String expectedPaymentSucceedMsg = "Full Order Marked Paid: " + getCurrentESTDateAndTime();
  		String expectedPaymentFailedMsg = "This order has not been paid in full";
  		String actualPaymentStatusMsg = strXpText(paidStatus);
  		if (paidStatus.equals("adm.addReceipt.paidStatusYesMsg.xp")) {
  			Assert.assertTrue(actualPaymentStatusMsg.contains(expectedPaymentSucceedMsg),"Payment comment is Mis-match");
  		} else if (paidStatus.equals("adm.addReceipt.paidStatusNoMsg.xp")) {
  			Assert.assertTrue(actualPaymentStatusMsg.contains(expectedPaymentFailedMsg),"Payment comment is Mis-match");
  		}
  		Q_WebElm.myWait(1000);
  		formXp("adm.addReceipt.closeTab.xp");
  	}
  	
  	/********************************************************************
	 // * Description  : To get the Current date 
	 // * Param        : int date
	 // * Returns      : dateAfter
	 // * Jira Ticket  : JMB 7142
	 // * Status       : Completed
	 //*******************************************************************/
	public String getFutureDateFromCurrentDate(int date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, date);
		String dateAfter = sdf.format(cal.getTime());
		return dateAfter;
	}
  	//JMB-7651 End
	
	//Start JMB-7331
	/********************************************************************
	 * Description: verify yDelete Receipt Button is Displayed
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void verifyDeleteReceiptButtonDisplayed() {
    	Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps,"jm.deleteReceiotButton.xp"));
    	System.out.println("[Pass]Delete Receipt Button is displayed");	
    }
	/********************************************************************
	 * Description: verify yDelete Receipt Button is not Displayed
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void verifyDeleteReceiptButtonNotDisplayed() {
    	try {
        	Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps, "jm.deleteReceiotButton.xp"));
        	Assert.fail("[Fail] Delete Receipt Button is displayed");
		} catch (NoSuchElementException e) {
			 Assert.assertTrue(true);
			 System.out.println("[Pass]Delete Receipt Button is not displayed");
		}
    }    
	/********************************************************************
	 * Description: Click on Delete Receipt button
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void deleteReceipt() {
		Q_WebElm.xp(adminProps, "jm.deleteReceiotButton.xp");
		Controls.checkAlert();
    }
	/********************************************************************
	 * Description: Verify the newly created Receipt is deleted
	 * Author: Tamilselvan
	 * Param: String
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void verifyReceiptDeleted(String deletedReceiptNo) {
		String receiptNo=Q_WebElm.xpRetText(adminProps, "jm.receiptFirstOrder.xp");
		System.out.println("Receipt Number: "+receiptNo);
		Assert.assertTrue(!receiptNo.contains(deletedReceiptNo),"Receipt number not displayed in receipt list");
    }
	/********************************************************************
	 * Description: Click Receipt Arrived 
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void receiptArrived() {
		Q_WebElm.xp(adminProps, "jm.receiptProductArrived.xp");
    }
	//End JMB-7331
}
