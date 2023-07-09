package pageObjects;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import jsonWrappers.*;
import utils.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class Q_HoldsForm extends Init {
	static Q_CheckoutForm chk = new Q_CheckoutForm();	

    public Q_HoldsForm formXp(String locator) {
        Q_WebElm.xp(adminProps, locator);
        return this;
    }

    public Q_HoldsForm formXp(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xp(adminProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_HoldsForm formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_WebElm.xp(adminProps, begXp, row, midXp, column, endXp);
        return this;
    }

    public Q_HoldsForm formInput(String locator, String inputValue) {
        Q_WebElm.xpClear(adminProps, locator);
        Q_WebElm.xpSend(adminProps, locator, inputValue);
        return this;
    }

    public Q_HoldsForm formInput(String begXp, Integer lineItem, String endXP, String inputValue) {
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
    public static String strXpText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, recordNumber, midXp, lineItem, endXp);
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
    public static String formReturnNumber(String locator) {
        return Q_WebElm.xpRetNumber(adminProps, locator);
    }

    public static String formReturnNumber(String begXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetNumber(adminProps, begXp, lineItem, endXp);
    }
    public static String formReturnNumber(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetNumber(adminProps, begXp, recordNumber, midXp, lineItem, endXp);
    }
    public Q_HoldsForm formReturnText(String locator) {
        Q_WebElm.xpRetText(adminProps, locator);
        return this;
    }
    public static String formReturnText(String begXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, lineItem, endXp);

    }
    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, recordNumber, midXp, lineItem, endXp);
    }
    public Q_HoldsForm formReturnTextReplace(String locator) {
        Q_WebElm.xpRetNumber(adminProps, locator);
        return this;
    }

    public Q_HoldsForm formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpRetNumber(adminProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_HoldsForm formReturnAttribute(String locator, String attr) {
        Q_WebElm.xpRetAttr(adminProps, locator, attr);
        return this;
    }

    public Q_HoldsForm formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp, attr);
        return this;
    }
    public static String attReturn(String locator, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, locator, attr);

    }
    public Q_HoldsForm formReturnAttributeReplace(String locator) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, locator);
        return this;
    }

    public Q_HoldsForm formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_HoldsForm formTab(String locator) {
        Q_WebElm.xpSendTab(adminProps, locator);
        return this;
    }

    public Q_HoldsForm formTab(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendTab(adminProps, begXp, lineItem, endXP);
        return this;
    }

    public Q_HoldsForm formEnter(String locator) {
        Q_WebElm.xpSendEnter(adminProps, locator);
        return this;
    }

    public Q_HoldsForm formEnter(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendEnter(adminProps, begXp, lineItem, endXP);
        return this;
    }

    public static boolean isXpDisplayed(String locator) {
        try {
            Q_WebElm.xpDisplayed(adminProps, locator);
            return true;
        } catch (Throwable ex) {
            System.out.println(ex);
            return false;
        }
    }
    public static boolean isXpDisplayed(String begXp, Integer lineItem, String endXP) {
        return Q_WebElm.xpDisplayed(adminProps, begXp, lineItem, endXP).equals(true);
    }

    public Q_HoldsForm displayedAssertion(String locator){
       try{
           driver.manage().timeouts().implicitlyWait(3, SECONDS);
           Assert.assertTrue(isXpDisplayed(locator));
           System.out.println("Desired  is displayed");
       }
       catch (Throwable ex){
           System.out.println(" not displayed");
       }
       return this;
    }
    public static boolean isXpCheckSelected(String locator) {

        return Q_WebElm.xpEnabled(adminProps, locator).equals(true);
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
    public Q_HoldsForm formSelectIndex(String locator, Integer index) {
        Q_WebElm.xpSelectIndex(adminProps, locator, index);
        return this;
    }

    public Q_HoldsForm formSelectValue(String locator, String value) {
        Q_WebElm.xpSelectValue(adminProps, locator, value);
        return this;
    }
    public Q_HoldsForm formSelectText(String locator, String text) {
        Q_WebElm.xpSelectText(adminProps, locator, text);
        return this;
    }
    public Q_HoldsForm formId(String locator) {
        Q_WebElm.id(adminProps, locator);
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

    public static Integer rowCount(String locator) {
        Integer count = Q_WebElm.xpCountTableRows(adminProps, locator);
        return count;
    }
    public Q_HoldsForm holdSystem(String hold){
        Q_AdminForm adm = new Q_AdminForm();
        adm.adminMenu("orders");
        Q_WebElm.xpExecutor(adminProps, "adm.orderHoldSystem.xp");
        Q_WebElm.myWait(1000);
        switch ( hold ) {

            case ("paymentReview"):
                formId("hold.paymentReview.id");
                try{
                    Assert.assertEquals(driver.getCurrentUrl(), adminUrl +"/holds.php?ordertype=payment");
                }
                catch (Throwable ex){
                    org.testng.Assert.fail("Check URL", ex);
                }
                break;

            case ("decisionManager"):
                formId("hold.decisionManager.id");
                // orderPageCheck(hold, "decisionManager.id", "/holds.php?ordertype=dm", "page.orderCount.xpath");

                break;
            case ("unpaidInvoice"):
                formId("hold.unpaidInvoice.id");
                // orderPageCheck(hold, "unpaidInvoice.id", "/holds.php?ordertype=invoice", "page.orderCount.xpath");
                break;
            case ("billingUnpaid"):
                formId("hold.billingUnpaid.id");
                break;
            case ("billingPaid"):
                formId("hold.billingPaid.id");
                break;
            case ("payPalReview"):
                formId("hold.payPalReview.id");
                break;
            case ("checkIssue"):
                formId("hold.checkIssue.id");
                break;
            case ("finalReview"):
                formId("hold.finalReview.id");
                break;
            case ("ebay"):
                formId("hold.ebay.id");
                break;
            case ("zipCodeReview"):
                formId("hold.zipCodeReview.id");
                break;
            case ("buybackReview"):
                formId("hold.buybackReview.id");
                break;
            case ("addressVerification"):
                formId("hold.addressVerification.id");
                break;

            case ("priceCheck"):
                formId("hold.priceCheck.id");
                break;
            case ("reshipmentHold"):
                formId("hold.reshipmentHold.id");
                break;
            case ("salesTaxIssue"):
                formId("hold.salesTaxIssue.id");
                break;
            case ("basicHold"):
                formId("hold.basicHold.id");
                break;
            case ("shippingIssue"):
                formId("hold.shippingIssue.id");
                break;
            case ("starterPack"):
                formId("ord.hold.starter.id");
                break;
            case ("security"):
                formId("ord.hold.security.id");
                break;
            case ("postShipment"):
                formId("hold.postShipment.id");
                break;
            case ("oversold"):
                formId("hold.oversold.id");
                break;
            case ("achError"):
                formId("hold.achError.id");
                break;
            default:
                System.out.println("Invalid hold system link");
                break;
        }
    return this;
    }

    public static Integer onHoldMenuItems(String tcName) {
        Integer linkCount = Integer.valueOf(idNumberReturn("hold." + tcName + ".id"));
        Q_WebElm.id(adminProps, "hold." + tcName + ".id");
        return linkCount;
    }
    public Q_HoldsForm dashboardTopOrderEdit() {
        String orderNumber = strXpText("hold.dashBoardTopOrderLink.xp");
        formXp("hold.dashBoardTopOrderLink.xp");
        System.out.println("Editing Order Number    " + orderNumber);
        String orderId = driver.getCurrentUrl();
        Q_WebElm.myWait(2000);
        Controls.switchWin();
        return this;
    }
    public Q_HoldsForm checkIfOrdersOnHold(String tcName, String holdLink) {
        Integer beforeCount = onHoldMenuItems(tcName);
        Q_OrderForm ord = new Q_OrderForm();
        System.out.println("Number of Orders on link before clearing " + beforeCount);
        if (beforeCount > 0) {
            formId(holdLink);
            formXp("hold.dashBoardReviewLink.xp");

            String orderId = editReviewOrder();
            Q_WebElm.myWait(1000);
            System.out.println(orderId);
            dashReviewFlag(tcName);
            Q_WebElm.myWait(2000);
            driver.navigate().refresh();
            Q_WebElm.myWait(1000);
            int afterCount = Integer.valueOf(idNumberReturn(holdLink));
            System.out.println("Number of Orders on link after clearing " + afterCount);
            int check = beforeCount - afterCount;
            int shouldBe = 1;
            System.out.println("Checking " + check);
            Assert.assertEquals(check, shouldBe);
            Q_WebElm.myWait(2000);
            driver.navigate().to(orderId);
            ord.orderOnHolFlag(tcName);
            driver.navigate().back();
            Integer finalCount = Integer.valueOf(idNumberReturn(holdLink));
            Q_WebElm.myWait(1000);
            System.out.println("Number of Orders on link after test reset " + finalCount);
            Assert.assertEquals((beforeCount - finalCount), 0);
        }
        return this;
    }
    public static String editReviewOrder() {

        String orderNumber = strXpText("hold.rev.editOrder.xp");
        System.out.println("Editing Order Number for review link " + orderNumber);
        Q_WebElm.xp(adminProps, "hold.rev.editOrder.xp");
        Q_WebElm.myWait(2000);
        Controls.switchWin();
        String orderId = driver.getCurrentUrl();
        Controls.closeTabsSwitchWinMain();
        return orderId;
    }
    public Q_HoldsForm dashReviewFlag(String tcName) {
        Q_WebElm.myWait(1000);
        switch ( tcName ) {
            case ("paymentReview"):
                Q_WebElm.cn(adminProps, "hold.dash.review.paymentReview.class");
                formXp("hold.dashReviewUpdateBtn.xp");
                break;
            case ("addressVerification"):
                Q_WebElm.cn(adminProps, "hold.dash.review.addressVerification.class");
                formXp("hold.dashReviewUpdateBtn.xp");
                break;
            case ("decisionManager"):
                Q_WebElm.cn(adminProps, "hold.dash.review.decisionManager.class");
                formXp("hold.dashReviewUpdateBtn.xp");
                break;
            case ("priceCheck"):
                Q_WebElm.cn(adminProps, "hold.dash.review.priceCheck.class");
                formXp("hold.dashReviewUpdateBtn.xp");
                break;
            case ("unpaidInvoice"):
                Q_WebElm.cn(adminProps, "hold.dash.review.unpaidInvoice.class");
                formXp("hold.dashReviewUpdateBtn.xp");
                break;
            case ("reshipmentHold"):
                Q_WebElm.cn(adminProps, "hold.dash.review.reshipmentHold.class");
                formXp("hold.dashReviewUpdateBtn.xp");
                break;
            case ("salesTaxIssue"):
                Q_WebElm.cn(adminProps, "hold.dash.review.salesTaxIssue.class");
                Q_WebElm.myWait(1000);
                formXp("hold.dashReviewUpdateBtn.xp");
                break;
            case ("billingUnpaid"):
                Q_WebElm.cn(adminProps, "hold.dash.review.billingReview.class");
                Q_WebElm.myWait(1000);
                formXp("hold.dashReviewUpdateBtn.xp");
                break;
            case ("payPalReview"):
                Q_WebElm.cn(adminProps, "hold.dash.review.payPalReview.class");
                formXp("hold.dashReviewUpdateBtn.xp");
                break;
            case ("basicHold"):
                Q_WebElm.cn(adminProps, "hold.dash.review.basicHold.class");
                formXp("hold.dashReviewUpdateBtn.xp");
                break;
            case ("shippingIssue"):
                Q_WebElm.cn(adminProps, "hold.dash.review.shippingIssue.class");
                formXp("hold.dashReviewUpdateBtn.xp");
                break;
            case ("checkIssue"):
                Q_WebElm.cn(adminProps, "hold.dash.review.checkIssue.class");
                formXp("hold.dashReviewUpdateBtn.xp");
                break;
            case ("starter"):
                formId("hold.dash.review.starter.id");
                formXp("hold.dashReviewUpdateBtn.xp");
                break;
            case ("security"):
                formXp("hold.dash.review.security.xp");
                Q_WebElm.myWait(1000);
                formXp("hold.dashReviewUpdateBtn.xp");
                break;
            case ("finalReview"):
                Q_WebElm.cn(adminProps, "hold.dash.review.final.class");
                formXp("hold.dashReviewUpdateBtn.xp");
                break;
            default:
                System.out.println("Hold flag is invalid");
        }
        return this;
    }
    public static Integer holdCount(String holdName){
        Q_AdminForm adm = new Q_AdminForm();
        Q_HoldsForm hold = new Q_HoldsForm();
        Q_WebElm.myWait(1000);
        adm.adminMenu("orders");
        hold.holdSystem(holdName);
        Integer holdCount = hold.onHoldMenuItems(holdName);
        return holdCount;
    }
    public Q_HoldsForm editOrderOnHold(String xp, String condition){

        int rowCount = rowCount("hold.orderCount.xp");
        System.out.println("new Number of Orders " + rowCount);
        for (int i=1 ;i <= rowCount; i++){
            if (strXpText("hold.order.beg.xp", i, xp).equals(condition)){
                Q_WebElm.myWait(1000);
                formXp("hold.order.beg.xp", i, "hold.order.number.end.xp");
                break;
            }
        }
        return this;
    }
    public static Integer revPageCount() {
        Integer revPageOrderCount = Integer.valueOf(rowCount("hold.revPageDashCount.xp"));
        return revPageOrderCount;
    }
    
    // JMB-4521 Start
 	/**
 	 * Sets operations hold for both guest & registered user
 	 * 
 	 * @param reason
 	 */
 	public void setOperationsHold(String reason) {
 		Q_WebElm.xpSelectText(adminProps, "cust.operationsHoldSelect.xp", "Yes");
 		Q_WebElm.idClear(adminProps, "cust.operationsHoldReason.id");
 		Q_WebElm.idSend(adminProps, "cust.operationsHoldReason.id", reason + Keys.ENTER);
 		Assert.assertEquals(Q_WebElm.idAttrRet(adminProps, "cust.operationsHoldReason.id", "value"), reason,
 				"Reason not accepted");
 		System.out.println("Customer has Operations Hold status as Yes");
 	}

 	/**
 	 * Launches the first order on a registered customer page
 	 */
 	public void editTopOrder_custPage() {
 		Q_WebElm.xp(adminProps, "cust.orderTopView.xp");
 		Q_WebElm.xp(adminProps, "cust.orderTopEdit.xp");
 	}

 	/**
 	 * Removes the operations hold from both registered & guest customer page
 	 */
 	public void removeOperationsHold() {
 		Q_WebElm.xpSelectText(adminProps, "cust.operationsHoldSelect.xp", "No");
 		Q_WebElm.xp(adminProps, "cust.operationsHoldSubmit.xp");
 		System.out.println("Customer is of Operations Hold status to NO");
 	}

 	/**
 	 * Verify the operation hold message is displayed on the top of an order form
 	 * 
 	 * @param reason
 	 */
 	public void verifyOperationHoldMsg_isDisplayed_order(String reason) {
 		Q_WebElm.xpDisplayed(adminProps, "ord.operationsHold.alertText.xp");
 		Assert.assertTrue(Q_WebElm.xpRetText(adminProps, "ord.operationsHold.alertText.xp").contains(reason),
 				"Incorrect message displayed");
 	}

 	/**
 	 * Search a buyback using email address and open it
 	 * 
 	 * @param email
 	 */
 	public void buybackEmailSearchAndEdit(String email) {
 		Q_Buyback bb = new Q_Buyback();
 		bb.bbMenuItem("list");
 		bb.search("email", "bb.searchEmail.xp", email);
 		bb.editOrder();
 	}

 	/**
 	 * Verify the operation hold message is displayed on the top of a buyback
 	 * 
 	 * @param reason
 	 */
 	public void verifyOperationHoldMsg_isDisplayed_buyback(String reason) {
 		Q_WebElm.xpDisplayed(adminProps, "bb.operationsHold.alertText.xp");
 		Assert.assertTrue(Q_WebElm.xpRetText(adminProps, "bb.operationsHold.alertText.xp").contains("Attention: Customer account has been placed on an operations hold for: " + reason),
 				"Incorrect message displayed");
 	}

 	/**
 	 * Clicks on Checkout securely button when checking out as guest in FE
 	 */
 	public void bridgeGuest() {
 		Q_WebElm.myWait(2000);
 		Q_WebElm.xp(adminProps, "fe.checkout.guestCheckoutBtn.xp");
 		Q_WebElm.myWait(2000);
 	}

 	/**
 	 * Fills the checkout page for guest customer with address, email & credit card
 	 * details
 	 * 
 	 * @param email
 	 * @throws FileNotFoundException
 	 */
 	public void guestCheckout(String email) throws FileNotFoundException {
 		Q_WebElm.idSend(adminProps, "fe.checkout.email.id", email);
 		shippingAddressForm(3);
 		Q_WebElm.id(adminProps, "fe.checkout.continueWithAdd.id");
 		creditCardForm(2);
 	}

 	/**
 	 * Send input to Shipping details on Guest checkout page
 	 * 
 	 * @param addIndex
 	 * @throws FileNotFoundException
 	 */
 	public void shippingAddressForm(Integer addIndex) throws FileNotFoundException {
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS.SECONDS);
 		AddressContainer ship = new AddressContainer(addIndex);
 		Q_WebElm.idSend(adminProps, "fe.checkout.firstName.id", ship.firstName);
 		Q_WebElm.idSend(adminProps, "fe.checkout.lastName.id", ship.lastName);
 		Q_WebElm.idSend(adminProps, "fe.checkout.address.id", ship.street);
 		Q_WebElm.myWait(1000);
 		Q_WebElm.idSendTab(adminProps, "fe.checkout.address.id");
 		Q_WebElm.myWait(1000);
 		Q_WebElm.idSendTab(adminProps, "fe.checkout.address.id");
 		Q_WebElm.myWait(1000);
 		Q_WebElm.idSend(adminProps, "fe.checkout.city.id", ship.city);
 		Q_WebElm.idSelectValue(adminProps, "fe.checkout.state.id", ship.state);
 		Q_WebElm.myWait(2000);
 		Q_WebElm.idSend(adminProps, "fe.checkout.zip.id", ship.zipcode);
 		Q_WebElm.idSend(adminProps, "fe.checkout.phone.id", ship.phoneNumber);
 		Q_WebElm.myWait(2000);
 	}

 	/**
 	 * Send input to credit card details on Guest checkout page
 	 * 
 	 * @param index
 	 * @throws FileNotFoundException
 	 */
 	public void creditCardForm(Integer index) throws FileNotFoundException {
 		CreditContainer card = new CreditContainer(index);
 		Q_WebElm.myWait(2000);
 		Assert.assertTrue(Q_WebElm.idDisplayed(adminProps, "fe.checkout.cardName.id"));
 		Q_WebElm.idSend(adminProps, "fe.checkout.cardName.id", card.cdName);
 		Q_WebElm.idSend(adminProps, "fe.checkout.cardNumber.id", card.cdNumber);
 		Q_WebElm.idSelectValue(adminProps, "fe.checkout.cardMonth.id", card.monthV);
 		Q_WebElm.idSelectIndex(adminProps, "fe.checkout.cardYear.id", card.year);
 		Q_WebElm.idSend(adminProps, "fe.checkout.cardCvv.id", card.code);
 	}

 	/**
 	 * Launch and switch to guest customer page using email on order form
 	 * 
 	 * @param noOfTab
 	 */
 	public void guestPage(int noOfTab) {
 		Q_WebElm.xp(adminProps, "ord.custEmail.xp");
 		Controls.switchTab(noOfTab);
 	}
 	//JMB-4521 End
 	
 	//JMB-6885 Start
	/**
	 * Create csv file with 3 sets of data
	 * @param downloadPath
	 * @param fileName
	 * @throws IOException 
	 */
	public void createCSV(String creationPath, String email1, String id1, String email2, String id2, String email3, String id3) throws IOException	{
		File dir = new File(creationPath);
		dir.createNewFile();
		List<List<String>> rows = Arrays.asList(Arrays.asList(id1, email1), Arrays.asList(id2, email2),
				Arrays.asList(id3, email3));
		FileWriter csvWriter = new FileWriter(creationPath);
		csvWriter.append("CustGuestID");
		csvWriter.append(",");
		csvWriter.append("CustGuestEmail");
		csvWriter.append("\n");
		for (List<String> rowData : rows) {
			csvWriter.append(String.join(",", rowData));
			csvWriter.append("\n");
		}
		csvWriter.flush();
		csvWriter.close();
		Q_WebElm.myWait(2000);
	}
	
	/**
	 * Upload file from local system
	 * @param creationPath
	 * @throws AWTException
	 */
	public void uploadCSV(String creationPath, String name) throws AWTException {
		Q_NewFeatures nfal = new Q_NewFeatures();
		Actions moveTo = new Actions(driver);
		moveTo.click(nfal.webElement(adminProps, "adm.customerOpsHoldsChooseFileBtn.xp")).perform();
		Robot rb = new Robot();
		String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		// There is an issue with some macs that switch to reactive Chrome browser does not work.
		if (uAgent.contains("Macintosh"))	{
			String path= creationPath + "//" + name;
			System.out.println(path);
			StringSelection stringSelection= new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			rb.keyPress(KeyEvent.VK_META);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_META);
			rb.keyRelease(KeyEvent.VK_TAB);
			rb.delay(500);
			rb.keyPress(KeyEvent.VK_META);
			rb.keyPress(KeyEvent.VK_SHIFT);
			rb.keyPress(KeyEvent.VK_G);
			rb.keyRelease(KeyEvent.VK_META);
			rb.keyRelease(KeyEvent.VK_SHIFT);
			rb.keyRelease(KeyEvent.VK_G);
			rb.keyPress(KeyEvent.VK_META);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_META);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			rb.delay(1500);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}	else	if (uAgent.contains("Windows"))	{
			String path= creationPath + "\\" + name;
			StringSelection str = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			Q_WebElm.myWait(2000);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}
	}

	/**
	 * Pass set of data to verify in the table displayed after dry run
	 * @param noOfUsers
	 * @param email1
	 * @param id1
	 * @param email2
	 * @param id2
	 * @param email3
	 * @param id3
	 */
	public void verifyList_dryRun(int noOfUsers,String email1, String id1, String email2, String id2, String email3, String id3)	{
		Q_WebElm.myWait(2000);
		Q_WebElm.xp(adminProps, "adm.customerOpsHoldsCreateBtn.xp");
		Q_WebElm.myWait(3000);
		if (Q_WebElm.xpRetText(adminProps, "adm.customerOpsHolds.updateStatus.xp").contains("Uploading"))	{
			Q_WebElm.xp(adminProps, "adm.customerOpsHoldsCreateBtn.xp");
		}
		Assert.assertTrue(rowCount("adm.customerOpsHolds.displayedTable.xp").equals(noOfUsers),"All the users not displayed.");
		Assert.assertTrue(Q_WebElm.xpElementList(adminProps, "adm.customerOpsHolds.displayedTable.xp").get(0).getText().contains(id1)
				&& Q_WebElm.xpElementList(adminProps, "adm.customerOpsHolds.displayedTable.xp").get(0).getText().contains(email1),
				"The row does not contain" + email1);
		Assert.assertTrue(Q_WebElm.xpElementList(adminProps, "adm.customerOpsHolds.displayedTable.xp").get(1).getText().contains(id2)
				&& Q_WebElm.xpElementList(adminProps, "adm.customerOpsHolds.displayedTable.xp").get(1).getText().contains(email2),
				"The row does not contain" + email2);
		Assert.assertTrue(Q_WebElm.xpElementList(adminProps, "adm.customerOpsHolds.displayedTable.xp").get(2).getText().contains(id3)
				&& Q_WebElm.xpElementList(adminProps, "adm.customerOpsHolds.displayedTable.xp").get(2).getText().contains(email3),
				"The row does not contain" + email3);
		for (WebElement element : Q_WebElm.xpElementList(adminProps, "adm.customerOpsHolds.displayedTable.xp")) {
			Assert.assertTrue(element.getText().contains("[DRY-RUN] Customer has ops hold due to high incidents of returns, claims, and/or cancels."),
					"Unexpected message in result column.");
		}
	}
	
	/**
	 * Verify if the operation hold status result has changed after live run
	 * @param noOfUsers
	 */
	public void verifyList_liveRun(int noOfUsers,String email1, String id1, String email2, String id2, String email3, String id3) {
		Q_WebElm.myWait(2000);
		Q_WebElm.id(adminProps, "adm.customerOpsHolds.liveRunBtn.id");
		Q_WebElm.xp(adminProps, "adm.customerOpsHoldsCreateBtn.xp");
		Q_WebElm.myWait(2000);
		Assert.assertTrue(Q_WebElm.xpElementList(adminProps, "adm.customerOpsHolds.displayedTable.xp").get(0+ noOfUsers).getText().contains(id1)
				&& Q_WebElm.xpElementList(adminProps, "adm.customerOpsHolds.displayedTable.xp").get(0+ noOfUsers).getText().contains(email1),
				"The row does not contain" + email1);
		Assert.assertTrue(Q_WebElm.xpElementList(adminProps, "adm.customerOpsHolds.displayedTable.xp").get(1+ noOfUsers).getText().contains(id2)
				&& Q_WebElm.xpElementList(adminProps, "adm.customerOpsHolds.displayedTable.xp").get(1+ noOfUsers).getText().contains(email2),
				"The row does not contain" + email2);
		Assert.assertTrue(Q_WebElm.xpElementList(adminProps, "adm.customerOpsHolds.displayedTable.xp").get(2+ noOfUsers).getText().contains(id3)
				&& Q_WebElm.xpElementList(adminProps, "adm.customerOpsHolds.displayedTable.xp").get(2+ noOfUsers).getText().contains(email3),
				"The row does not contain" + email3);
		for (int result = 0; result <= rowCount("adm.customerOpsHolds.displayedTable.xp"); result++) {
			if (!((result + noOfUsers) == rowCount("adm.customerOpsHolds.displayedTable.xp"))) {
				Assert.assertTrue(Q_WebElm.xpElementList(adminProps, "adm.customerOpsHolds.displayedTable.xp").get(result + noOfUsers).getText().contains(
								"[ADDED]: Customer has ops hold due to high incidents of returns, claims, and/or cancels."), 
						"Operation Hold status change unsuccessful!");
			} else
				break;
		}
	}
	//JMB-6885 End
	//Start JMB-6927
	/********************************************************************
	 * Description: Verify Mail Forwarder Hold is Checked on order with ship address as Mail Box Store
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void verifyMailForwarderHoldChecked() {
		try {
	    	Assert.assertTrue(isXpDisplayed("jm.mailForwarderHoldChecked.xp"));
		}
		catch(NoSuchElementException e) {
			Assert.fail("Address Change Hold is not Checked");
		}
	}
	/********************************************************************
	 * Description: Verify Mail Forwarder Hold is Unchecked
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void verifyMailForwarderUnchecked() {
		try {
	    	Assert.assertTrue(isXpDisplayed("jm.mailForwarderHoldUnchecked.xp"));
		}
		catch(NoSuchElementException e) {
			Assert.fail("Address Change Hold is not Checked");
		}
	}
	/********************************************************************
	 * Description: Verify Mail Forwarder Hold is Displayed in order form
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void verifyMailForwarderAddDisplayed() {
		try {
	    	Assert.assertTrue(isXpDisplayed("jm.mailForwarderAdd.xp"));
		}
		catch(NoSuchElementException e) {
			Assert.fail("Mail forwarder address tag not displayed in order form shipping address section");
		}
	}	
	/********************************************************************
	 * Description: Click Mail Forwarder Hold in Hold System menu
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void clickMailForwarderHold() {
		Q_WebElm.xp(adminProps, "jm.clickMailForwarderHoldSystem.xp");
	}
	/********************************************************************
	 * Description: Uncheck the Mail Forwarder hold in order form
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void uncheckMailForwarder() {
		Q_WebElm.xp(adminProps, "jm.clickMailForwarderHold.xp");
        Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
        formId("ord.hold.updateHolds.id");
        Q_WebElm.myWait(2000);
	}
	/********************************************************************
	 * Description: Verify Mail Forwarder Address not displayed under shipping address section 
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void verifyMailForwarderAddNotDisplayed() {
		try {
	    	Assert.assertFalse(isXpDisplayed("jm.mailForwarderAdd.xp"));
		}
		catch(NoSuchElementException e) {
			Assert.assertTrue(true, "Mail forwarder address tag not displayed in order form shipping address section");
		}
	}
	//End JMB-6927
	//Start JMB-3692
	/********************************************************************
	 * Description: Verify address Change Hold Displayed in order form under hold reasons
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void addressChangeHoldDisplayed() {
    	Assert.assertTrue(isXpDisplayed("jm.addressChangeHold.xp"), "Address Change Hold is not Displayed under Hold Reasons");
	}
	/********************************************************************
	 * Description: Verify address Change Hold is Checked after add new address
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void verifyAddressChangeHoldChecked() {
		try {
	    	Assert.assertTrue(isXpDisplayed("jm.addressChangeHoldChecked.xp"));
		}
		catch(NoSuchElementException e) {
			Assert.fail("Address Change Hold is not Checked");
		}
	}
	/********************************************************************
	 * Description: Verify address Change Hold is Unchecked
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void verifyAddressChangeHoldUnchecked() {
		try {
	    	Assert.assertTrue(isXpDisplayed("jm.addressChangeHoldUnchecked.xp"));
		}
		catch(NoSuchElementException e) {
			Assert.fail("Address Change Hold is not Checked");
		}
	}
	/********************************************************************
	 * Description: Click Change History in order form
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void clickChangeHistory() {
		Controls.xpExecutorScrollElementToMiddle(adminProps.getProperty("jm.clickChangeHistory.xp"));
    	Q_WebElm.id(adminProps, "jm.clickChangeHistory.id");
	}	
	/********************************************************************
	 * Description: Verify Notes in history for shipping address change  
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void shippingAddressChangedDisplayedInHistory() {    	
		String notes = Q_WebElm.xpRetText(adminProps, "jm.shippingAddressChangeNotes.xp");
		if (notes.contains("Notes: Shipping Address Changed")) {
			System.out.println("Shipping address change activity displayed in history");
		}
		else {
			Assert.fail("Shipping address change activity is not displayed in history");
		}
	}
	/********************************************************************
	 * Description: Uncheck the address change hold in order form
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void uncheckAddressChangeHold() {
		Q_WebElm.xp(adminProps, "jm.addressChangeHoldChecked.xp");
        Q_WebElm.idSend(adminProps, "ord.hold.notes.id", "Automated test case");
        formId("ord.hold.updateHolds.id");
        Q_WebElm.myWait(2000);
	}
	/********************************************************************
	 * Description: Click address Change Hold in Hold System menu
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void clickAddressChangeHold() {
		Q_WebElm.xp(adminProps, "jm.clickHoldSystemAddressChange.xp");
	}
	/********************************************************************
	 * Description: Verify order id in hold system for Changes made for Hold in order form
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void verifyCheckedOrdIdInHoldSystem(String ordNo, String orderOnHoldName) {
		Q_ProductForm prod = new Q_ProductForm();
		int size = prod.retXpSize(adminProps, "jm.addHoldOrder.xp");
		int flag =0; String ordNoInHoldSystem;
		for(int index=1; index<=size;index++) {
			ordNoInHoldSystem = Q_WebElm.xpRetText(adminProps, "jm.holdOrderId.xp.beg",index,"jm.holdOrderId.xp.end");
			System.out.println(ordNoInHoldSystem);
			if (ordNo.contains(ordNoInHoldSystem)) {
				flag++;
//					Q_WebElm.xp(adminProps, "jm.holdOrderId.xp.beg",index,"jm.holdOrderId.xp.end");
				// Modify this Switch Tap based on the requirement and make sure not impacting the existing methods
//					Controls.switchTab(2);
				break;
			}
		}
			if (flag == 1) {
				System.out.println("[Pass]The order Id is displayed in "+orderOnHoldName);
			} else if (flag == 0) {
				Assert.fail("[Fail ]The order Id is not displayed in "+orderOnHoldName);
			}	
	}
	/********************************************************************
	 * Description: Verify order id from address hold system for address change hold Unchecked order 
	 * Author: Tamilselvan
	 * Param: NA
	 * Returns: NA
	 * Status: Complete 
	 *******************************************************************/
	public void verifyUncheckedOrdIdInHoldSystem(String OrdNo, String orderOnHoldName) {
		Q_ProductForm prod = new Q_ProductForm();
		int size = prod.retXpSize(adminProps, "jm.addHoldOrder.xp");
		int flag =0; String ordNoInHoldSystem;
		if (size>0)
		{
		for(int index=1; index<=size;index++) {
			ordNoInHoldSystem = Q_WebElm.xpRetText(adminProps, "jm.holdOrderId.xp.beg",index,"jm.holdOrderId.xp.end");
			if (ordNoInHoldSystem.contains(OrdNo)) {
				flag++;
			}
		}
			if (flag == 0) {
				System.out.println("[Pass]The order Id is not displayed in "+orderOnHoldName);
			} else if (flag == 1) {
				Assert.fail("[Fail ]The order Id is displayed in "+orderOnHoldName);
			}
		}
		else
		{
			Assert.fail("No matches found; returns 0 list");
		}
	}
	//End JMB-3692
	
	//JMB-7106 Start
	/******************************************************************
    // * Description: To verify Operations Hold checkbox is checked
    // * Param : boolean isChecked, int minutes
    // * Jira Ticket: JMB 7106
    // * Status: Completed
    //*******************************************************************/ 
	
	public void verifyOperationsHoldIsChecked(boolean isChecked,int minutes) {
		
		for(int i=0;i<=(minutes*6);i++) {
			if(isChecked) {
				if(Q_WebElm.xpSelected(adminProps, "guest.operationsHold.xp")) {
					break;
				}else {
					driver.navigate().refresh();
				}
			}else {
				if(!Q_WebElm.xpSelected(adminProps, "guest.operationsHold.xp")) {
					break;
				}else {
					driver.navigate().refresh();
				}
			}Q_WebElm.myWait(10000);
		}
	}
	
	/******************************************************************
    // * Description: To place an order as a guest based on parameters
    // * Param : String guestID, String product, int count, String paymentType
    // * Jira Ticket: JMB 7106
    // * Status: Completed
    //*******************************************************************/ 	
	
	public void placeAnOrderAsGuest(String guestID, String product, int count, String paymentType) throws FileNotFoundException {
		driver.navigate().to(product);		
		chk.addItemToCart(count);
		chk.selectPaymentType(paymentType);
		chk.selectcheckoutBtn("top");
		bridgeGuest();
		guestCheckout(guestID);
		chk.completeOrder();		
		Q_WebElm.myWait(9000);		
	}
	//JMB-7106 End
	
	//JMB-7554 Start
	/******************************************************************
    // * Description: To verify the Operations hold message and Time stamp in Orders form page (Added assertions in existing method from Q_HoldsForm class)
    // * Param : String reason, String date
    // * Jira Ticket: JMB 7554
    // * Status: Completed
    //*******************************************************************/
 	public void verifyOperationHoldMsgAndTimestamp_isDisplayed_order(String reason, String date) {
 		Q_WebElm.xpDisplayed(adminProps, "ord.operationsHold.alertText.xp");
 		Assert.assertTrue(Q_WebElm.xpRetText(adminProps, "ord.operationsHold.alertText.xp").contains(reason),"Incorrect message displayed");
 		Assert.assertTrue(Q_WebElm.xpRetText(adminProps, "ord.operationsHold.alertText.xp").contains(date),"Incorrect message displayed");
 	}
	/******************************************************************
    // * Description: To get the current EST Time
    // * Param : NA
    // * Jira Ticket: JMB 7554
    // * Status: Completed
    //*******************************************************************/
	public String getCurrentESTDateAndTime() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		df.setTimeZone(TimeZone.getTimeZone("EST"));  
		Calendar cal = Calendar.getInstance();
		Date currentDate = cal.getTime();
		cal.setTime(currentDate);
		String CurrentESTDateandTime = df.format(cal. getTime());
		return CurrentESTDateandTime;		
	}
	//JMB-7554 End
}
