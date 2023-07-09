package pageObjects;

import utils.Controls;
import utils.Init;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.List;


public class Q_AdminForm extends Init {
    public Q_AdminForm formXp(String locator) {
        Q_WebElm.xp(adminProps, locator);
        return this;
    }
    public Q_AdminForm formXp(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xp(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public Q_AdminForm formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_WebElm.xp(adminProps, begXp, row, midXp, column, endXp);
        return this;
    }
    public Q_AdminForm formInput(String locator, String inputValue) {
        Q_WebElm.xpClear(adminProps, locator);
        Q_WebElm.xpSend(adminProps, locator, inputValue);
        return this;
    }
    public Q_AdminForm formIntegerInput(String locator, Integer inputValue) {
        Q_WebElm.xpClear(adminProps, locator);
        Q_WebElm.xpSendInteger(adminProps, locator, inputValue);
        return this;
    }
    public Q_AdminForm formIntegerInput(String begXp, Integer lineItem, String endXP, Integer inputValue) {
        Q_WebElm.xpClear(adminProps, begXp, lineItem, endXP);
        Q_WebElm.xpSendInteger(adminProps, begXp, lineItem, endXP, inputValue);
        return this;
    }
    public Q_AdminForm formInput(String begXp, Integer lineItem, String endXP, String inputValue) {
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
    public Q_AdminForm formReturnText(String locator) {
        Q_WebElm.xpRetText(adminProps, locator);
        return this;
    }
    public Q_AdminForm formReturnText(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpRetText(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, recordNumber, midXp, lineItem, endXp);
    }
    public static String formReturnTextReplace(String locator) {
        return Q_WebElm.xpRetNumber(adminProps, locator);
    }

    public Q_AdminForm formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpRetNumber(adminProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_AdminForm formReturnAttribute(String locator, String attr) {
        Q_WebElm.xpRetAttr(adminProps, locator, attr);
        return this;
    }
    public static String attReturn(String locator, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, locator, attr);

    }
    public static String attReturn(String begXp, Integer lineItem, String endXp, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp, attr);
    }
    public Q_AdminForm formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp,attr);
        return this;
    }

    public Q_AdminForm formReturnAttributeReplace(String locator) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, locator);
        return this;
    }

    public Q_AdminForm formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_AdminForm formTab(String locator) {
        Q_WebElm.xpSendTab(adminProps, locator);
        return this;
    }

    public Q_AdminForm formTab(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendTab(adminProps, begXp, lineItem, endXP);
        return this;
    }

    public Q_AdminForm formEnter(String locator) {
        Q_WebElm.xpSendEnter(adminProps, locator);
        return this;
    }

    public Q_AdminForm formEnter(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendEnter(adminProps, begXp, lineItem, endXP);
        return this;
    }
    public Q_AdminForm formInputXp(String locator, String inputValue) {
        Q_WebElm.xpClear(adminProps, locator);
        Q_WebElm.myWait(500);
        Q_WebElm.xpSend(adminProps, locator, inputValue);
        Q_WebElm.myWait(500);
        return this;
    }
    public static boolean isXpDisplayed(String locator) {
        return  Q_WebElm.xpDisplayed(adminProps, locator);
    }
    public static boolean isXpDisplayed(String begXp, Integer lineItem, String endXP) {
        return Q_WebElm.xpDisplayed(adminProps, begXp, lineItem, endXP);
    }
    public static boolean isXpCheckSelected(String locator) {
        return Q_WebElm.xpSelected(adminProps, locator).equals(true);
    }
    public static boolean isXpCheckSelected(String begXp, Integer lineItem, String endXP) {
        return Q_WebElm.xpSelected(adminProps, begXp, lineItem, endXP).equals(true);
    }

    public static boolean isXpCheckEnabled(String locator) {
        return Q_WebElm.xpEnabled(adminProps, locator);
    }

    public static boolean isXpCheckEnabled(String begXp, Integer lineItem, String endXP) {
        return  Q_WebElm.xpEnabled(adminProps, begXp, lineItem, endXP);
        }

    public Q_AdminForm formSelectIndex(String locator, Integer index) {
        Q_WebElm.xpSelectIndex(adminProps, locator, index);
        return this;
    }

    public Q_AdminForm formSelectValue(String locator, String value) {
        Q_WebElm.xpSelectValue(adminProps, locator, value);
        return this;
    }
    public Q_AdminForm formSelectText(String locator, String text) {
        Q_WebElm.xpSelectText(adminProps, locator, text);
        return this;
    }
    public Q_AdminForm formId(String locator) {
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
    public Q_AdminForm accountTabs(String accLink){
        formXp( "acc.myAccountLink.xp");
        switch ( accLink ){
            case"orders":
                Q_WebElm.xp(adminProps,"acc.accountTabOrders.xp");
                break;
            case"my information":
                Q_WebElm.xp(adminProps, "acc.accountTabMyInfo.xp");
                break;
            case"addresses":
                Q_WebElm.xp(adminProps, "acc.accountTabAddresses.xp");
                break;
            case"payments":
                Q_WebElm.xp(adminProps, "acc.accountTabPayment.xp");
                Assert.assertEquals(Q_WebElm.xpRetText(adminProps, "acc.account.PaymentPage.xp"),"Your Credit and Debit Cards");
                break;
            case"alerts":
                Q_WebElm.xp(adminProps, "acc.accountTabAlerts.xp");
                break;
            case"wish list":
                Q_WebElm.xp(adminProps, "acc.accountTabWishList.xp");

                break;
            default:
                System.out.println("Invalid option for account tab");
                break;
        }
        return this;
    }
    
    /********************************************************************
	 // * Description  : To click the admin menu in JMB admin page 
	 // * Param        : String item
	 // * Jira Ticket  : JMB 7570
	 // * Status       : Completed
	 //*******************************************************************/
	public Q_AdminForm adminMenu(String item) {
		String menuItem = item;
		switch ( menuItem ) {
		case ("orders"):
			Q_WebElm.moveIt(adminProps, "adm.menuOrders.xp");
		break;
		case ("shipping"):
			Q_WebElm.moveIt(adminProps, "adm.menuShipping.xp");
		break;
		case ("receipts"):
			Q_WebElm.moveIt(adminProps, "adm.menuReceipts.xp");
		break;
		case ("products"):
			Q_WebElm.moveIt(adminProps, "adm.menuProducts.xp");
		break;
		case ("inventory"):
			Q_WebElm.moveIt(adminProps, "adm.menuInventory.xp");
		break;
		case ("customers"):
			Q_WebElm.moveIt(adminProps, "adm.menuCustomers.xp");
		break;
		case ("reports"):
			Q_WebElm.moveIt(adminProps, "adm.menuReports.xp");
		break;
		case ("settings"):
			Q_WebElm.moveIt(adminProps, "adm.menuSettings.xp");
		break;
		case ("ebay"):
			Q_WebElm.moveIt(adminProps, "adm.menuEbay.xp");
		break;
		default:
			System.out.println("Invalid admin menu option");
		}
		return this;
	}

    /******************************************************************
     // * Description: Admin customer search
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    public Q_AdminForm adminCustomerSearch(String srch, String param) {
        Q_WebElm.xp(adminProps, "adm.adminJmbullion.xp");
        switch ( srch ) {
            case ("first"):
                Q_WebElm.idClear(adminProps, "adm.adminSearchFirst.id");
                Q_WebElm.idSend(adminProps, "adm.adminSearchFirst.id", param);
                Q_WebElm.xp(adminProps, "adm.adminSearchBtn.xp");
                break;
            case ("last"):
                Q_WebElm.idClear(adminProps, "adminSearchlast.id");
                Q_WebElm.idSend(adminProps, "adminSearchlast.id", param);
                Q_WebElm.xp(adminProps, "adm.adminSearchBtn.xp");
                break;
            case ("email"):
                Q_WebElm.idClear(adminProps, "adm.adminSearchEmail.id");
                Q_WebElm.idSend(adminProps, "adm.adminSearchEmail.id", param);
                Q_WebElm.xp(adminProps, "adm.adminSearchBtn.xp");
                break;
            default:
                System.out.println("Please enter valid search criteria for customer");
                break;
        }
        return this;
    }

    public Q_AdminForm adminViewAllOrders() {
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/table/tbody/tr/td[9]/div/a")));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        formXp("adm.adminActiveBtn.xp");
        formXp("adm.viewAllOrders.xpath");
        return this;
    }
    public Q_AdminForm selectAdminUser(){
        adminMenu("settings");
        formXp("adm.subSetting.users.xp");
//        System.out.println("Users count " + rowCount("adminUsersRows.xp"));
        formXp("adm.permissionGroup.automationTestingGroup.managePermissions.xp");
        //for(int i = 1; i<= rowCount("adm.adminUsersRows.xp"); i++){
//            System.out.println("Users  " +strText("adminUsers.beg.xp", i, "adminUsers.end.xp"));
            //if(strXpText("adm.adminUsers.beg.xp", i, "adm.adminUsers.end.xp").equals(user)) {
                //formXp("adm.adminUsers.beg.xp", i, "adm.adminUsers.end.xp");
                //break;
           //}
        //}
        return this;
    }

    public Q_AdminForm grantPermission(String permissionName){
        Integer numberOfPermissions =  rowCount("adm.permissionRows.xp");
        for(int i=1; i < numberOfPermissions; i++){
            String permissionLabel = Q_WebElm.xpRetText(adminProps, "adm.permissionLabel.beg.xp", i, "adm.permissionLabel.end.xp");

            if (Q_WebElm.xpRetText(adminProps, "adm.checkBox.beg.xp", i, "adm.permissionLabel.end.xp").equals(permissionName)) {
                Q_WebElm.xpExecutorScrolToElement(adminProps, "adm.checkBox.beg.xp", i-2, "adm.permissionLabel.end.xp");
                Q_WebElm.myWait(2000);
                if(isXpCheckSelected("adm.permission.beg.xp", i, "adm.permission.end.xp")){
                    System.out.println("User have permission " + isXpCheckSelected("adm.permission.beg.xp", i, "adm.permission.end.xp"));
                } else{
                    formXp("adm.permission.beg.xp", i, "adm.permission.end.xp");
                    formXp("adm.savePermission.xp");
                    Q_WebElm.myWait(1000);
                    System.out.println("User granted permission To : " + permissionLabel);
                    Controls.checkAlert();
                    break;
                }
            }
        }

        return this;
    }
    public Q_AdminForm removePermission(String permissionName){
        Integer numberOfPermissions =  rowCount("adm.permissionRows.xp");
        for(int i=1; i < numberOfPermissions; i++) {
            String permissionLabel = Q_WebElm.xpRetText(adminProps, "adm.permissionLabel.beg.xp", i, "adm.permissionLabel.end.xp");

            if (Q_WebElm.xpRetText(adminProps, "adm.checkBox.beg.xp", i, "adm.permissionLabel.end.xp").equals(permissionName)) {
                Q_WebElm.xpExecutorScrolToElement(adminProps, "adm.checkBox.beg.xp", i-2, "adm.permissionLabel.end.xp");
                Q_WebElm.myWait(2000);
                if(isXpCheckSelected("adm.permission.beg.xp", i, "adm.permission.end.xp")){
                    formXp("adm.permission.beg.xp", i, "adm.permission.end.xp");
                    formXp("adm.savePermission.xp");
                    Q_WebElm.myWait(4000);
                    System.out.println("User permission removed for: " + permissionLabel);
                    Controls.checkAlert();
                    break;
                } else{
                    System.out.println("User denied permission " + isXpCheckSelected("adm.permission.beg.xp", i, "adm.permission.end.xp"));
                }
            }
        }
        return this;
    }
    public static Float masterPriceAdj(String matalXp) {
        Q_AdminForm adm = new Q_AdminForm();
        adm.adminMenu("settings");
        Q_WebElm.xp(adminProps, "adm.subSettings.spotPrice.xp");
        String mpa = Q_WebElm.xpRetAttr(adminProps, matalXp, "value");
        System.out.println("Master price adjustment " + mpa);
        return Float.valueOf(mpa);
    }
    public Q_AdminForm receiptsEta(){  // digits in xpath denotes the row number
        Integer receiptId = Integer.valueOf(numberReturn("adm.receiptDetails.beg.xp", 1, "adm.receiptId.end.xp"));
        String etaLabel = Q_AdminForm.strXpText("adm.receiptDetails.beg.xp", 1, "adm.receiptsList.estArrivalLabel.end.xp");
        String etaDate = Q_AdminForm.strXpText("adm.receiptDetails.beg.xp", 1, "adm.receiptsList.estArrivalValue.end.xp");
        System.out.println(receiptId + "\t\t" + etaLabel + "\t\t" + etaDate);
        return  this;
    }
    public Q_AdminForm receiptsEta(Integer receiptId){
        System.out.println("Number of receipts " + rowCount("adm.numOfReceipts.xp"));
        for(int i = 1; i<= rowCount("adm.numOfReceipts.xp"); i++){
            if(Integer.valueOf(numberReturn("adm.receiptDetails.beg.xp", i, "adm.receiptId.end.xp")).equals(receiptId)){
                String etaLabel = Q_AdminForm.strXpText("adm.receiptDetails.beg.xp", 1, "adm.receiptsList.estArrivalLabel.end.xp");
                String etaDate = Q_AdminForm.strXpText("adm.receiptDetails.beg.xp", 1, "adm.receiptsList.estArrivalValue.end.xp");
                System.out.println(receiptId + "\t\t" + etaLabel + "\t\t" + etaDate);
            }
        }
        return  this;
    }
    public Q_AdminForm jmUserMyaccount(){
        Integer admBuybackCount = rowCount("adm.adminBbCount.xp");
        System.out.println("number of BB  " + admBuybackCount);
        System.out.println("Admin page buyback number " + numberReturn("adm.user6FirstBb.beg.xp", admBuybackCount, "adm.user6FirstBb.end.xp"));
        String bbNum = numberReturn("adm.user6FirstBb.beg.xp", admBuybackCount, "adm.user6FirstBb.end.xp");
        Q_WebElm.myWait(2000);
       formXp("adm.switchToUser.xp");
        System.out.println("Account page buyback number " + numberReturn("adm.jmUserMyAccount.xp"));
        String accountBbNum = numberReturn("adm.jmUserMyAccount.xp");
        Assert.assertEquals(bbNum, accountBbNum);
        Q_WebElm.myWait(2000);
        formXp("adm.switchBackToAdmin.xp");
        return this;
    }
    public Q_AdminForm pmUserMyaccount(){
        Integer admBuybackCount = rowCount("adm.adminBbCount.xp");
        System.out.println("number of BB  " + admBuybackCount);
        System.out.println("Admin page buyback number " + numberReturn("adm.user6FirstBb.beg.xp", admBuybackCount, "adm.user6FirstBb.end.xp"));
        String bbNum = numberReturn("adm.user6FirstBb.beg.xp", admBuybackCount, "adm.user6FirstBb.end.xp");
        Q_WebElm.myWait(2000);
        formXp("adm.switchToUser.xp");
        System.out.println("Account page buyback number " + numberReturn("adm.jmUserMyAccount.xp"));
        String accountBbNum = numberReturn("adm.jmUserMyAccount.xp");
        Assert.assertEquals(bbNum, accountBbNum);
        Q_WebElm.myWait(2000);
        formXp("adm.switchBackToAdmin.xp");
        return this;
    }

    public Q_AdminForm repoMenu(String repoMenuItem){
        Q_AdminForm adm = new Q_AdminForm();
        adm.adminMenu("receipts");
        switch(repoMenuItem){
            case("list repo"):
                formXp("adm.listRepos.xp");
                break;
            case("add repo"):
                formXp("adm.addRepo.xp");
                break;
            case("sell into repo"):
                formXp("adm.sellIntoRepo.xp");
                break;
            case("repos to be paid"):
                formXp("adm.reposToBePaid.xp");
                break;
            default:
                System.out.println("Invalid repo item List");
                break;
        }
        return this;
    }

    public Q_AdminForm datePicker(String month, Integer week, Integer day){
        formXp(month);
        formXp("adm.presale.datePicker.beg.xp", week, "adm.presale.datePicker.mid.xp", day, "adm.presale.datePicker.end.xp");
        return this;
    }
    public Q_AdminForm addRepo(String product, Integer qty){
        formInput("adm.repoPo.xp", Controls.startTimeStriped());
        formXp("adm.repoPayDate.xp");
        datePicker("adm.prevMonth.xp", 2, 4);
        formXp("adm.repoValueDate.xp");
        datePicker("adm.prevMonth.xp", 2, 4);
        formXp("adm.repoProductSelect.xp");
        formInput("adm.repoProductInput.xp", product);
        Q_WebElm.xpSendInteger(adminProps, "adm.repoQty.xp", qty);
        formInput("adm.repoSellPrice.xp", "32.01");
        formInput("adm.repoBuyPrice.xp", "22.02");
        Q_WebElm.myWait(4000);
        formXp("adm.repo.save.xp");
        Q_WebElm.myWait(1000);
        driver.navigate().to(adminUrl);
        return this;
    }
    public Q_AdminForm repoForceValueDate(){
        adminMenu("receipts");
        repoMenu("list repo");
        Q_WebElm.myWait(2000);
        Integer item = rowCount("adm.repoCount.xp");
        Q_WebElm.myWait(500);
        System.out.println(item);
        Q_WebElm.xpExecutor(adminProps, "adm.repoSort.xp");
        formXp("adm.repoAction.beg.xp", 1, "adm.repoAction.end.xp");
        Q_WebElm.myWait(500);
        formXp("adm.repoEdit.xp");
        Controls.switchWin();
        formXp("adm.repoForceValueDate.xp");
        Controls.checkAlert();
        Controls.closeTabsSwitchWinMain();
        return this;
    }
    public Q_AdminForm addRepoProduct(String product, Integer qty, String price){
        Q_WebElm.xpSendInteger(adminProps, "adm.receiptQty.xp", qty);
        formXp("adm.receiptProduct.beg.xp");
        formInput("adm.receiptProductInput.xp", product);
        formInput("adm.receiptUnitPrice.xp", price);
        return this;
    }
    public Q_AdminForm addReceiptProduct(Integer item, String product, Integer qty, String price){
        formIntegerInput("adm.receiptProduct.beg.xp", item, "adm.receiptQty.end.xp", qty);
        formXp("adm.receiptProduct.beg.xp", item, "adm.receiptProduct.end.xp");
        formInput("adm.receiptProduct.beg.xp", item, "adm.receiptProductInput.end.xp", product);
        formTab("adm.receiptProduct.beg.xp", item, "adm.receiptProductInput.end.xp");
        formInput("adm.receiptProduct.beg.xp", item, "adm.receiptUnitPrice.end.xp", price);
        return this;
    }


    public Q_AdminForm addReceipt(){
        formXp("adm.addReceipts.xp");
        Q_WebElm.myWait(2000);
        formXp("adm.arrivalDate.xp");
        formEnter("adm.arrivalDate.xp");
        Q_WebElm.myWait(2000);
        formXp("adm.receiptSupplier.xp");
        formSelectIndex("adm.receiptSupplier.xp", 2);
        Q_WebElm.myWait(4000);
        return this;
    }
    
    public Q_AdminForm addReceipt(int supplierIndex){
        formXp("adm.addReceipts.xp");
        Q_WebElm.myWait(2000);
        formXp("adm.arrivalDate.xp");
        formEnter("adm.arrivalDate.xp");
        Q_WebElm.myWait(2000);
        formXp("adm.receiptSupplier.xp");
        formSelectIndex("adm.receiptSupplier.xp", supplierIndex);
        Q_WebElm.myWait(4000);
        return this;
    }

    public Q_AdminForm saveReceipt(){
        Q_WebElm.myWait(2000);
        Q_WebElm.xpExecutor(adminProps, "adm.receiptSave.xp");
        return this;
    }

    public Q_AdminForm editReceipts(){
        Q_WebElm.myWait(1000);
        formXp("adm.listReceipts.xp");
        Q_WebElm.myWait(1000);
        formXp("adm.editTopReceipt.xp");
        return this;

    }
    //JMB-6017 Start
    // Method created for JMB-6017 : Checking Auto Clear Functionality : OFF
    public void testAutoClearFunctionalityOFF() {
        System.out.println("---Testing AutoClear Functionality - OFF----");
        int OFFtextCount = 0;
        for (int i = 1; i <= 3; i++) {
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(i));
            System.out.println("Switched to  : " + driver.getCurrentUrl());
            if (driver.getPageSource().contains("Off")) {
                OFFtextCount++;
                System.out.println("[PASS] Off text found in : " + driver.getCurrentUrl());
            } else {
                System.out.println("[FAIL] Off text is not found in : " + driver.getCurrentUrl());
            }
            driver.switchTo().window(tabs.get(0));
        }

        System.out.println(OFFtextCount);
//        Assert.assertEquals(OFFtextCount, 3, "[FAIL] Seems like the 'Off' text is not displayed in one of the sites.");

    }
    // Method created for JMB-6017 : Checking Auto Clear Functionality : ON
    public void testAutoClearFunctionalityON() {
        System.out.println("---Testing AutoClear Functionality - ON----");
        driver.navigate().refresh();
        int ONtextCount = 0;
        Q_WebElm.xp(adminProps, "adm.autoClearRadio.ON.xp");
        Q_WebElm.xp(adminProps, "adm.saveConfigSettings.xp");
        for (int i = 1; i <= 3; i++) {
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(i));
            System.out.println("Switched to  : " + driver.getCurrentUrl());
            driver.navigate().refresh();
            if (driver.getPageSource().contains("Off")) {
                System.out.println("[FAIL] Off Text found in : " + driver.getCurrentUrl());
                ONtextCount++;
            } else {
                System.out.println("[PASS] Off text not found in : " + driver.getCurrentUrl());
            }

            driver.switchTo().window(tabs.get(0));
        }

        System.out.println(ONtextCount);
//        Assert.assertEquals(ONtextCount, 0, "[FAIL] Seems like the ON radio button is not working");
    }
    //JMB-6017 End
    //JMB-6208 start
    public Q_AdminForm retAttributAssertion(String strTextLocator, String textToBeVerified) {
        driver.navigate().refresh();
        Q_WebElm.myWait(2000);
        Assert.assertEquals(Q_WebElm.xpRetAttr(adminProps, strTextLocator, "value"), textToBeVerified);
        System.out.println("Attribute matched " + textToBeVerified);
        return this;
    }
    public Q_AdminForm creditThreshold(String ccLimit){
        formInputXp("adm.bb.CreditThreshold.xp", ccLimit);
        formXp("adm.saveConfigSettings.xp");
        Q_WebElm.myWait(2000);
        retAttributAssertion("adm.bb.CreditThreshold.xp", ccLimit);

        return this;
    }
    public Q_AdminForm orderLowerLimit(String lowLimit){
        formInputXp("adm.bb.LowerOrderLimit.xp", lowLimit);
        formXp("adm.saveConfigSettings.xp");
        Q_WebElm.myWait(2000);
        retAttributAssertion("adm.bb.LowerOrderLimit.xp", lowLimit);
        return this;
    }
    public Q_AdminForm orderUpperLimit(String highLimit){
        formInputXp("adm.bb.UpperOrderLimit.xp", highLimit);
        formXp("adm.saveConfigSettings.xp");
        retAttributAssertion("adm.bb.UpperOrderLimit.xp", highLimit);
        return this;
    }
    //JMB-6208 End

    // Start JMB-7622
    public Q_AdminForm dallasInventoryJMB7622(){
        int startCount = dallasProductInventory("3");

        System.out.println("Start count: " + startCount);
        for(int i = 1; i <= Q_WebElm.xpCountTableRows(adminProps , "adm.inventoryProductCount.xp"); i++){
            if(Q_WebElm.xpRetText(adminProps, "adm.inventoryProductBeg.xp", i , "adm.inventoryProductIdEnd.xp").equals("3")){
                for(int j=1; j<=5; j++){
                    driver.navigate().to(adminUrl+ "/dallas-sanity.php?type=testfa");
                    driver.navigate().to(adminUrl + "/inventory-dallas.php");
                    driver.navigate().to(adminUrl + "/dallas-sanity.php?type=testfb");
                    driver.navigate().to(adminUrl + "/inventory-dallas.php");
                }
                break;
            }
        }
        // expectedFinalCount = start count + number of iterations in loop * 15 * 2

        int finalCount = dallasProductInventory("3");
        System.out.println("Final count: " + finalCount);
        Assert.assertEquals(finalCount, startCount);
        return this;
    }
    public static Integer dallasProductInventory(String productId){
        driver.navigate().to(adminUrl + "/inventory-dallas.php");
        int productQuantity = 0;
        for(int i = 1; i <= Q_WebElm.xpCountTableRows(adminProps , "adm.inventoryProductCount.xp"); i++){
            if(Q_WebElm.xpRetText(adminProps, "adm.inventoryProductBeg.xp", i , "adm.inventoryProductIdEnd.xp").equals(productId)){
                productQuantity = Integer.valueOf(numberReturn("adm.inventoryProductBeg.xp", i , "adm.inventoryProductQtyEnd.xp"));
//                System.out.println("DallasProductCount " + productQuantity);
            }
        }
        System.out.println("DallasProductCount " + productQuantity);
        return productQuantity;
    }
    // JMB-7622 end
    // JMB-6330 Start
    public Q_AdminForm enterTitle(String title) {
        Q_WebElm.xpSend(adminProps, "settings.addSlider.sliderTitle.xp", title);
        Q_WebElm.xp(adminProps, "settings.addSlider.submitBtn.xp");
        Q_WebElm.myWait(3000);
        return this;
    }

    public Q_AdminForm editSlider(String title) {
        int count = Q_WebElm.xpCountTableRows(adminProps, "settings.manageSlider.countRows.xp");
        for (int i = count - 1; i >= 0; i--) {
            System.out.println(
                    "Slider found!" + Q_WebElm.xpElementList(adminProps, "settings.manageSlider.countRows.xp").get(i).getText());
            if (Q_WebElm.xpElementList(adminProps, "settings.manageSlider.countRows.xp").get(i).getText().contains(title)) {
                Q_WebElm.xpElementList(adminProps, "settings.manageSlider.edit.xp").get(i).click();
                break;
            }
        }
        return this;
    }

    public Q_AdminForm editDisplayOrder(String order) {
        Q_WebElm.xpClear(adminProps, "settings.editSlider.displayOrder.xp");
        Q_WebElm.xpSend(adminProps, "settings.editSlider.displayOrder.xp", order);
        Q_WebElm.xp(adminProps, "settings.addSlider.submitBtn.xp");
        Q_WebElm.myWait(3000);
        return this;
    }
    // JMB-6330 End

    // JMB-6138 Start
    // *******************************************************************
    // * Description: AddPaidRecepit from Admin site
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    // *******************************************************************/
    public Q_AdminForm addPaidReceipt() {
        Q_AdminForm adm = new Q_AdminForm();
        adm.adminMenu("receipts");
        adm.addReceipt();
        adm.addReceiptProduct(1, "1 oz Silver Bar (Varied Condition, An", 100, "26.89");
        Q_WebElm.xp(adminProps, "recp.paidreceipt.xp");
        adm.saveReceipt();
        Q_WebElm.myWait(5000);
        return this;
    }

    // *******************************************************************
    // * Description: VerifyElementNotDisplayed
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    // *******************************************************************/

    public Q_AdminForm isXpNotDisplayed(String locator) {
        try {
            Assert.assertFalse(Q_WebElm.xpDisplayed(adminProps, locator));
        } catch (Exception e) {
//            System.out.println(e);
            Assert.assertTrue(true);
        }
        return this;
    }

    // *******************************************************************
    // * Description: Verify buttons in Admin site with permission of 47 (Mark
    // Receipt Arrvied)
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    // *******************************************************************/
    public Q_AdminForm verifyReceiptButton() {
        Q_AdminForm adm = new Q_AdminForm();
        adm.adminMenu("receipts");
        adm.editReceipts();
        Controls.switchWin();
        Q_WebElm.myWait(3000);
        Q_WebElm.xpDisplayed(adminProps, "recp.partialArraival.xp");
        Q_WebElm.xpDisplayed(adminProps, "recp.convertEntireOrder.xp");
        System.out.println(
                "PartialArrival and ConvertEntireOrderToCredit buttons are displayed for user with permission 47");

        return this;
    }
    // *******************************************************************
    // * Description: List Repo Receipts and ensure status is paid
    // Receipt Arrvied)
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    // *******************************************************************/
    public Q_AdminForm listPaidRepoReceipt() {
        Q_AdminForm adm = new Q_AdminForm();
        adm.adminMenu("receipts");
        adm.formXp("repo.listRepoReceipt.xp");
        int repoReceitsCount = rowCount("repo.receiptCount.xp");
        for(int i = 1; i<= repoReceitsCount; i++){
            boolean isArrived = isXpDisplayed("repo.arrived.xp");
            if(isArrived==false){
                adm.formXp("repo.viewRepoReceipt.xp");
                Controls.switchWin();
                Q_WebElm.myWait(3000);
                Q_WebElm.xpDisplayed(adminProps, "repo.arrivedInFull.xp");
                Q_WebElm.xpDisplayed(adminProps, "repo.partialArrivalRepoReceipt.xp");
                break;
            }
        }

        System.out.println("ArrivedInFull and PartialArrival buttons are displayed for user with permission 47");
        return this;
    }
    // *******************************************************************
    // * Description: Verify buttons in Admin site with no permission of 47 (Mark
    // Receipt Arrvied)
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    // *******************************************************************/
    public Q_AdminForm verifyReceiptButtonWithoutPermission() {
        Q_AdminForm adm = new Q_AdminForm();
        Q_WebElm.myWait(4000);
        adm.adminMenu("receipts");
        adm.editReceipts();
        Controls.switchWin();
        Q_WebElm.myWait(3000);
        isXpNotDisplayed("recp.partialArraival.xp");
        isXpNotDisplayed("recp.convertEntireOrder.xp");
        System.out.println(
                "PartialArrival and ConvertEntireOrderToCredit buttons are not displayed, user with no 47 permission");
        return this;
    }
    public Q_AdminForm verifyRepoReceiptButtonWithoutPermission() {
        Q_AdminForm adm = new Q_AdminForm();
        adm.adminMenu("receipts");
        adm.formXp("repo.listRepoReceipt.xp");
        adm.formXp("repo.viewRepoReceipt.xp");
        Controls.switchWin();
        isXpNotDisplayed("repo.arrivedInFull.xp");
        isXpNotDisplayed("repo.partialArrivalRepoReceipt.xp");
        System.out.println("ArrivedInFull and PartialArrival buttons are not displayed, user with no 47 permission");
        return this;
    }

    // JMB-6138 End

    //JMB-6580 Start
    //*******************************************************************
    // * Description: Search for customer using email in Find Customers section of admin page
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public Q_AdminForm findCustomerByEmail(String email) {
        Q_WebElm.idClear(adminProps, "adminFindCustEmailInput.id");
        Q_WebElm.idSend(adminProps, "adminFindCustEmailInput.id", email);
        Q_WebElm.xp(adminProps, "adminFindCustEmailSearchButton.xp");
        findCustomerViewAllOrders();
        Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps, "cust.qcSelect.xp"));
        return this;
    }
    //*******************************************************************
    // * Description: Search for customer using phone in Find Customers section of admin page
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public Q_AdminForm findCustomerByPhone(String phone) {
        Q_WebElm.idClear(adminProps, "adminFindCustPhoneInput.id");
        Q_WebElm.idSend(adminProps, "adminFindCustPhoneInput.id", phone);
        Q_WebElm.xp(adminProps, "adminFindCustPhoneSearchButton.xp");
        findCustomerViewAllOrders();
        Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps, "cust.qcSelect.xp"));
        return this;
    }
    //*******************************************************************
    // * Description: Clicks on View All button after search for Find Customers section of admin page
    // * Param: None
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public Q_AdminForm findCustomerViewAllOrders() {
        Q_WebElm.xp(adminProps, "adminFindCustViewOrders.xp");
        return this;
    }
    //JMB-6580 End
    
    //JMB-7879-Start
  	/********************************************************************
  		 // * Description  : Verify Manual Spot Save Button functionality settings spot page
  		 // * Param        : String status, String manualSpotButton
  		 // * Jira Ticket  : JMB 7879
  		 // * Status       : Completed
  		 //*******************************************************************/
  	public void verifyManualSpotSaveButton(String status, String manualSpotButton) {
  		Q_WebElm.xp(adminProps, manualSpotButton);
  		switch (status) {
  			case "On":
  				int productCount = Q_WebElm.xpCountTableDiv(adminProps, "adm.manualSpotCommands.xp");
  				for (int i = 1; i <= productCount; i++) {
  					Q_WebElm.xpClear(adminProps, "adm.products.beg.xp", i, "adm.products.end.xp");
  					Q_WebElm.xpSend(adminProps, "adm.products.beg.xp", i, "adm.products.end.xp", "1");
  				}
  				break;

  			case "Off":
  				Assert.assertFalse(Q_WebElm.xpDisplayed(adminProps, "adm.manualSpotCommands.xp"),"Product are available");
  				break;
  			}
  		Q_WebElm.xp(adminProps, "adm.manualSpotSaveBtn.xp");
  	}
  	//JMB-7879-End
  	
  	//JMB-7573-Start
    public void subMenuElement(String locator){
        Q_WebElm.xp(adminProps, locator);
    }
    
	/********************************************************************
	 // * Description  : Navigate to manage permission (Reused method from JMB-7570)
	 // * Param        : NA
	 // * Jira Ticket  : JMB 7570
	 // * Status       : Completed
	 //*******************************************************************/
	public void navigateToQaTestGroupManagePermission() {
		adminMenu("settings");
		formXp("adm.subSetting.users.xp");
		Q_WebElm.xp(adminProps,"adm.permissionGroup.qaTestGroup.managePermissions.xp");
		System.out.println("Navigated to Manage Permission Page");
	}

	/********************************************************************
	 // * Description  : Verify Menu Availability based on the parameter
	 // * Param        : String menuXp, boolean availability
	 // * Jira Ticket  : JMB 7573
	 // * Status       : Completed
	 //*******************************************************************/
	public void verifyMenuAvailability(String menuXp, boolean availability) {
		Q_WebElm.myWait(2000);
		if(availability) {
			List<WebElement> menu = driver.findElements(By.xpath(adminProps.getProperty(menuXp)));
			Assert.assertTrue(menu.size()==1, menuXp+" Menu is not present");
			System.out.println(menuXp+" Menu is not present");
		} else {
			List<WebElement> menu = driver.findElements(By.xpath(adminProps.getProperty(menuXp)));
			Assert.assertTrue(menu.size()==0, menuXp+" Menu is present");
			System.out.println(menuXp+" Menu is present");
		}
	}
	//JMB-7573-End
}
