package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Controls;
import utils.Init;

import java.time.LocalDate;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class Q_ProductForm extends Init {
    static Q_ProductForm prod = new Q_ProductForm();
    static Q_NewFeatures nf = new Q_NewFeatures();
    static Q_CheckoutForm chk = new Q_CheckoutForm();
    static Controls li = new Controls();

    public Q_ProductForm formXp(String locator) {
        Q_WebElm.xp(adminProps, locator);
        return this;
    }
    public Q_ProductForm formXp(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xp(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public Q_ProductForm formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_WebElm.xp(adminProps, begXp, row, midXp, column, endXp);
        return this;
    }
    public Q_ProductForm formInputXp(String locator, String inputValue) {
        Q_WebElm.xpClear(adminProps, locator);
        Q_WebElm.xpSend(adminProps, locator, inputValue);
        return this;
    }
    public Q_ProductForm formInputXp(String begXp, Integer lineItem, String endXP, String inputValue) {
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
    public Q_ProductForm formReturnText(String locator) {
        Q_WebElm.xpRetText(adminProps, locator);
        return this;
    }
    public Q_ProductForm formReturnText(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpRetText(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_WebElm.xpRetText(adminProps, begXp, recordNumber, midXp, lineItem, endXp);
    }
    public static String formReturnTextReplace(String locator) {
        return Q_WebElm.xpRetNumber(adminProps, locator);
    }

    public Q_ProductForm formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpRetNumber(adminProps, begXp, lineItem, endXp);
        return this;
    }

    public Q_ProductForm formReturnAttribute(String locator, String attr) {
        Q_WebElm.xpRetAttr(adminProps, locator,attr);
        return this;
    }
    public static String attReturn(String locator, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, locator,attr);

    }
    public static String attReturn(String begXp, Integer lineItem, String endXp, String attr) {
        return Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp, attr);
    }
    public Q_ProductForm formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_WebElm.xpRetAttr(adminProps, begXp, lineItem, endXp,attr);
        return this;
    }

    public Q_ProductForm formReturnAttributeReplace(String locator) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, locator);
        return this;
    }

    public Q_ProductForm formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_WebElm.xpReturnAttributeReplace(adminProps, begXp, lineItem, endXp);
        return this;
    }
    public Q_ProductForm formXpDisplayed(String locator) {
        try {
            Q_WebElm.xpDisplayed(adminProps, locator).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }
    public Q_ProductForm formXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_WebElm.xpDisplayed(adminProps, begXp, lineItem, endXP).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }
    public Q_ProductForm formXpTab(String locator) {
        Q_WebElm.xpSendTab(adminProps, locator);
        return this;
    }

    public Q_ProductForm formXpTab(String begXp, Integer lineItem, String endXP) {
        Q_WebElm.xpSendTab(adminProps, begXp, lineItem, endXP);
        return this;
    }

    public Q_ProductForm formXpEnter(String locator) {
        Q_WebElm.xpSendEnter(adminProps, locator);
        return this;
    }

    public Q_ProductForm formXpEnter(String begXp, Integer lineItem, String endXP) {
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
    public Q_ProductForm formXpSelectIndex(String locator, Integer index) {
        Q_WebElm.xpSelectIndex(adminProps, locator, index);
        return this;
    }

    public Q_ProductForm formXpSelectValue(String locator, String value) {
        Q_WebElm.xpSelectValue(adminProps, locator, value);
        return this;
    }
    public Q_ProductForm formXpSelectText(String locator, String text) {
        Q_WebElm.xpSelectText(adminProps, locator, text);
        return this;
    }
    public Q_ProductForm formId(String locator) {
        Q_WebElm.id(adminProps, locator);
        return this;
    }
    public Q_ProductForm formInputId(String locator, String inputValue) {
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
    public Q_ProductForm formIdSelectIndex(String locator, Integer index) {
        Q_WebElm.idSelectIndex(adminProps, locator, index);
        return this;
    }

    public Q_ProductForm formIdSelectValue(String locator, String value) {
        Q_WebElm.idSelectValue(adminProps, locator, value);
        return this;
    }
    public Q_ProductForm formIdSelectText(String locator, String text) {
        Q_WebElm.idSelectText(adminProps, locator, text);
        return this;
    }
    public static Integer rowCount(String locator) {
        Integer count = Q_WebElm.xpCountTableRows(adminProps, locator);
        return count;
    }
    
    public void xpSendInputEnter(Properties proper, String locator, String value){
		Q_WebElm.xpClear(adminProps, locator);
		driver.findElement(By.xpath(proper.getProperty(locator))).sendKeys(value,Keys.ENTER);
	}


    public Q_ProductForm productsMenu(String menuItem) {
        Q_AdminForm adm = new Q_AdminForm();
        adm.adminMenu("products");
        switch ( menuItem ) {
            case ("gold"):
                formXp("prod.products.gold.xp");
                break;
            case ("silver"):
                formXp("products.silver.x");
                break;
            case ("platinum"):
                formXp("prod.products.platinum.xp");
                break;
            case ("copper"):
                formXp("prod.products.copper.xp");
                break;
            case ("buy back"):
                formXp("prod.products.buyback.xp");
                break;
        }
        return this;
    }
    public Q_ProductForm productsIdSearch(String productid) {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        productsMenu("gold");
        Q_WebElm.myWait(5000);
        formInputXp("prod.searchInput.xp", productid);
        Q_WebElm.myWait(3000);
        formXp("prod.productId.xp");
        Q_WebElm.myWait(4000);
        formXp("prod.searchBtn.xp");
        Q_WebElm.myWait(2000);
        formXp("prod.editProduct.xp");
        Q_WebElm.myWait(2000);
        assertProdDescription(Q_WebElm.xpRetText(adminProps, "prod.product.searchTitle.xp"));
        return this;
    }
    public Q_ProductForm assertProdDescription(String message){
        String productIdTitle = Q_WebElm.xpRetText(adminProps, "prod.product.searchTitle.xp");
        System.out.println("Product ID search result " + productIdTitle);
        Assert.assertEquals(message, productIdTitle);
        return this;
    }
    public Q_ProductForm ProductsSKUSearch(String sku) {
        productsMenu("gold");
        formInputXp("prod.searchInput.xp", sku);
        Q_WebElm.myWait(2000);
        formXp("prod.sku.xp");
        Q_WebElm.myWait(2000);
        formXp("prod.searchBtn.xp");
        Q_WebElm.myWait(2000);
        formXp("prod.editProduct.xp");
        String productSKUTitle = Q_WebElm.xpRetText(adminProps, "prod.product.searchTitle.xp");

        return this;
    }

    public Q_ProductForm checkOSS(){
        Q_WebElm.myWait(2000);
        Controls.switchWin();
        System.out.println("Is Don't Display When OOS checked: " + strXpText("prod.displayOOS.xp"));
        try{
            Assert.assertTrue(isXpCheckEnabled("prod.displayOOS.xp"));
            formXp("prod.displayOOS.xp");
            Q_WebElm.myWait(2000);
            formXp("prod.prodPage.save.xp");
            Q_WebElm.myWait(5000);
            Assert.assertTrue(isXpCheckEnabled("prod.displayOOS.xp"));
            System.out.println("OOS is selected ");
        }
        catch(Throwable exp){
            System.out.println("OOS is Already selected");
        }
        return this;
    }

    public Q_ProductForm uncheckOSS(){
        Q_WebElm.myWait(4000);
        Controls.switchWin();
        System.out.println("Is OOS checked: " + isXpCheckSelected("prod.displayOOS.xp"));
        try{
            Assert.assertTrue(isXpCheckSelected("prod.displayOOS.xp"));
            formXp("prod.displayOOS.xp");
//        WebElm.name(adminProps, "OOS.name");
            Q_WebElm.myWait(2000);
            formXp("prod.prodPage.save.xp");
            Q_WebElm.myWait(5000);
            Assert.assertTrue(isXpCheckSelected("prod.displayOOS.xp"));
            System.out.println("OOS is unchecked in this step ");
        }
        catch(Throwable exp){
            System.out.println("OOS is Already unchecked ");
        }
        return this;
    }

    public Q_ProductForm jmInStock(){
        Q_WebElm.myWait(2000);
        Controls.switchWin();
        System.out.println("Is OOS checked: " + isXpCheckSelected("prod.displayOOS.xp"));
        formXpSelectValue("prod.jmStockStatus.xp", "instock");
        Q_WebElm.myWait(2000);
        formXp("prod.prodPage.save.xp");
        Q_WebElm.myWait(7000);
        Controls.scrolUpPixel(1200);
        formXp("prod.jmOnSite.xp");
        try{
            Controls.switchWin();
            Assert.assertEquals(strXpText("prod.jmPDP.atcBtnText.xp"), "Add to Cart");
            System.out.println("ATC button  is Add to Cart");
            Q_WebElm.myWait(2000);
            Controls.switchTab(1);
        }
        catch(Throwable exp){
            System.out.println("PDP page displays the product not available ");
        }
        return this;
    }

    public Q_ProductForm addNote(String  noteText){
        Q_WebElm.myWait(3000);
        Controls.switchWin();
        formInputXp("prod.product.notes.xp", noteText);
        formXp("prod.prodPage.save.xp");
        Q_WebElm.myWait(2000);
        String newNote = strXpText("prod.product.firstNotes.xp");
        System.out.println("First  note : " + newNote);
        Assert.assertEquals("Product automated test cases do not modify", newNote);
        Controls.closeTabsSwitchWinMain();
        return this;
    }

    public Q_ProductForm jmOutOfStock(String btnText){
        Q_WebElm.myWait(2000);
        Controls.switchWin();
        System.out.println("Is OOS checked: " + isXpCheckSelected("prod.displayOOS.xp"));
        formXpSelectValue("prod.jmStockStatus.xp", "outofstock");
        Q_WebElm.myWait(2000);
        formXp("prod.prodPage.save.xp");
        Q_WebElm.myWait(7000);
        Controls.scrolUpPixel(1200);
        formXp("prod.jmOnSite.xp");
        try{
            Controls.switchWin();
            Assert.assertEquals(strXpText("prod.jmPDP.inStockAlert.xp"), btnText);
            System.out.println("The button text is In-Stock Alert");
            Q_WebElm.myWait(2000);
            Controls.switchTab(1);
        }
        catch(Throwable exp){
            System.out.println("PDP page displays the product not available ");
        }
        return this;
    }
    public Q_ProductForm verifyPdpAccess(String prodUrl){
        driver.navigate().to(baseUrl + prodUrl);
        System.out.println(rowCount("prod.PDP.accCount.xp"));
        Assert.assertEquals(Q_WebElm.xpCountTableRows(adminProps, "prod.PDP.accCount.xp") , 3);
        Assert.assertTrue(Q_WebElm.idRetText(adminProps, "prod.pdp.showMoreAcc.id").equals("Show More >"));
        return this;
    }

    public static Integer inHand(){
        Q_WebElm.myWait(2000);
        String inhandQty = numberReturn("prod.inhand.xp");
        Integer inhand = Integer.valueOf(inhandQty);
        Assert.assertTrue(inhand.equals(10));
        return inhand;
    }
    
    public static Boolean priceType(){
        Boolean price = isXpDisplayed("prod.price.normal.xp");
        if (price.equals(true)){
            System.out.println("Verified that product pricing is Normal");
            return true;
        }
        else{
            System.out.println("Verified that product pricing is Normal");
            return false;
        }
    }

    public Q_ProductForm isFixedPrice(){
        isIdDisplayed("prod.price.fixed.xp");
        return this;
    }

    public Q_ProductForm uncheckLimited(){
        Q_WebElm.myWait(2000);
        Controls.switchWin();
        System.out.println("Is Limit checked: " + isXpCheckSelected("prod.limited.checkBox.xp"));
        try{
            Assert.assertTrue(isXpCheckSelected("prod.limited.checkBox.xp"));
            formXp("prod.limited.checkBox.xp");
            Q_WebElm.myWait(2000);
            formXp("prod.prodPage.save.xp");
            Q_WebElm.myWait(2000);
            Assert.assertTrue(isXpCheckSelected("prod.limited.checkBox.xp"));
            System.out.println("Limit check box is now unchecked in this step ");
        }
        catch(Throwable exp){
            System.out.println("Limit check box is already unchecked ");

        }
        return this;
    }

    public Q_ProductForm preSaleSet(Integer numMonths, Integer week, Integer day){
        Controls.switchWin();
        formXp("prod.presale.xp");
        for(int i =1; i<= numMonths; i++){
            formXp("prod.presale.calander.monthForward.xp");
        }
        formXp("adm.presale.datePicker.beg.xp", week, "adm.presale.datePicker.mid.xp", day, "adm.presale.datePicker.end.xp");
        formXp("prod.prodPage.save.xp");
        Controls.scrolUpPixel(700);
        return this;
    }

    public Q_ProductForm preSaleRemove(){
        Q_WebElm.myWait(2000);
        Controls.scrolUpPixel(800);
        formXp("prod.presale.xp");
        Q_WebElm.myWait(2000);
        formInputXp("prod.presale.xp","0000-00-00");
        Q_WebElm.myWait(3000);
        formXpTab("prod.presale.xp");
        formXp("prod.prodPage.save.xp");
        Q_WebElm.myWait(8000);
        driver.navigate().refresh();
        Assert.assertEquals(attReturn("prod.presale.xp", "value"), "0000-00-00");

        Controls.closeTabsSwitchWinMain();
        return this;
    }

    public Q_ProductForm setAsBuyBack(String newPremium) {
		Controls.switchWin();
		try {
			Assert.assertTrue(isXpCheckSelected("prod.checkBuyback.xp"));
			String bbPremium = attReturn("prod.buybac.inputPrice.xp", "value");
			System.out.println("Buyback Premium " + bbPremium);
		} catch (Throwable setBB) {
			Assert.assertFalse(isXpCheckSelected("prod.checkBuyback.xp"));
			formXp("prod.checkBuyback.xp");
			Q_WebElm.myWait(1000);
			formInputXp("prod.buybac.inputPrice.xp", newPremium);
			formXp("prod.prodPage.save.xp");
			Q_WebElm.myWait(6000);
			System.out.println("New Premium " + attReturn("prod.buybac.inputPrice.xp", "value"));
			Assert.assertEquals(attReturn("prod.buybac.inputPrice.xp", "value"), newPremium);
		}
		return this;
	}
    public Q_ProductForm removeAsBuyBack() {
		Controls.switchWin();
		try {
			Assert.assertFalse(isXpCheckSelected("prod.checkBuyback.xp"));
			String bbPremium = attReturn("prod.buybac.inputPrice.xp", "value");
			System.out.println("Buyback Premium " + bbPremium);
		} catch (Throwable ex) {
			Assert.assertTrue(isXpCheckSelected("prod.checkBuyback.xp"));
			String bbPremium = attReturn("prod.buybac.inputPrice.xp", "value");
			System.out.println("Buyback Premium " + bbPremium);
			formXp("prod.checkBuyback.xp");
			formXp("prod.prodPage.save.xp");
			Q_WebElm.myWait(6000);
			Assert.assertFalse(isXpCheckSelected("prod.checkBuyback.xp"));
		}
		return this;
	}

    public Q_ProductForm checkLimited(){
        Q_WebElm.myWait(2000);
        Controls.switchWin();
        System.out.println("Is Limit checked: " + isXpCheckSelected("prod.limited.checkBox.xp"));
        try{
            Assert.assertTrue(isXpCheckSelected("prod.limited.checkBox.xp"));
            formXp("prod.limited.checkBox.xp");
            Q_WebElm.myWait(2000);
            formXp("prod.prodPage.save.xp");
            Q_WebElm.myWait(5000);
            System.out.println("Limit value is set to: " + attReturn("prod.limited.input.xp", "value"));
            Assert.assertTrue(isXpCheckSelected("prod.limited.checkBox.xp"));
            System.out.println("Limit check box is now checked in this step ");
        }
        catch(Throwable exp){
            System.out.println("Limit check box is already checked ");
            System.out.println("Limit value is set to: " + attReturn("prod.limited.input.xp", "value"));
        }
        return this;
    }
    public Q_ProductForm checkLimited(String quan){
        Q_WebElm.myWait(2000);
        Controls.switchWin();
        System.out.println("Is Limit checked: " + isXpCheckSelected("prod.limited.checkBox.xp"));
        try{
            Assert.assertTrue(isXpCheckSelected("prod.limited.checkBox.xp"));
            formXp("prod.limited.checkBox.xp");


            String currentLimitqty = attReturn("prod.limited.input.xp", "value");
            System.out.println("Limit value is set to: " + currentLimitqty);
            formInputXp("prod.limited.input.xp", quan);
            formXp("prod.prodPage.save.xp");
            Q_WebElm.myWait(2000);
            Assert.assertEquals(attReturn("prod.limited.input.xp", "value"), quan);
            System.out.println("Limit check box is now checked in this step ");
        }
        catch(Throwable exp){
            System.out.println("Limit check box is already checked ");
            formInputXp("prod.limited.input.xp", quan);
            formXp("prod.prodPage.save.xp");
            Q_WebElm.myWait(2000);
            Assert.assertEquals(attReturn("prod.limited.input.xp", "value"), quan);
        }
        return this;
    }

    public Q_ProductForm accessoriesAdd(String accessory) {
        Controls.scrolDownPixel(1200);
        Q_WebElm.myWait(3000);
        formXp("prod.accessories.link.xp");
        Q_WebElm.myWait(1000);
        formXp("prod.accessories.dropdown.xp");
        Q_WebElm.myWait(3000);
        Q_WebElm.xpSend(adminProps, "prod.accessories.input.xp", accessory);
        //formInputXp("prod.accessories.input.xp", accessory);
        Q_WebElm.myWait(3000);
        formXpTab("prod.accessories.input.xp");
//        formXp("accessories.result.xp");
        formXp("prod.accessories.add.xp");
        formXp("prod.prodPage.save.xp");
        System.out.println("Added accessory " + accessory);
        return this;
    }

    public Q_ProductForm accessoriesCheck(Integer numAccess){
        Q_WebElm.myWait(5000);
        Controls.scrolDownPixel(1200);
        formXp("prod.accessories.link.xp");
        Integer access = rowCount("prod.jmAccessory.count.xp");
        System.out.println("accessories " + access);
        Assert.assertEquals(access, numAccess);
        System.out.println("Verify accessory added" );
        Q_WebElm.myWait(2000);
        return this;
    }

    public Q_ProductForm accessoriesRemove() {
        driver.navigate().refresh();
        Controls.scrolDownPixel(1200);

        formXp("prod.accessories.link.xp");
        Q_WebElm.myWait(2000);
        System.out.println("Delete accessory" );
        try{
            formXp("prod.accessories.remove.xp");
            Q_WebElm.myWait(2000);
            formXp("prod.prodPage.save.xp");
            Q_WebElm.myWait(2000);
            driver.navigate().refresh();
        }
        catch(Throwable ex){
            System.out.println("Failed to delete accessory \n \n" );
            System.out.println(ex);
        }
        return this;
    }
    public Q_ProductForm addBuybacNote(){
        Q_WebElm.myWait(2000);
        Q_WebElm.nameSend(adminProps, "prod.buyback.notes.name", "Automated Test case");
        formXp("prod.prodPage.save.xp");
        Q_WebElm.myWait(3000);
        return this;
    }

    public static Float calculatePremium () {
        Controls.switchWin();
        DecimalFormat df = new DecimalFormat("#.00");
        Float jmp = Float.parseFloat(idAttRet("prod.jmPremium.id", "value"));
//        System.out.println("Expected Margin is  " + "\t" + jmp );
        Float supPremium = Float.parseFloat(idAttRet("prod.supplierPremium.id", "value"));
//        System.out.println("Expected Margin is  " + "\t" + supPremium );
        Float margin = jmp - supPremium;
        System.out.println("Expected Margin is  " + "\t" + margin);
        return margin;
    }

    public static Float getPremium (String productId) {
        driver.navigate().to(baseUrl + "/admin/function-view.php?test=jm_get_product_margin&product="+ productId  +"&qty=1&subtotal=1000&payment=credit_card");
        System.out.println(driver.getCurrentUrl());
//        String actualProductMargin = numberReturn("productMargin.xp");
        String actualProductMargin = Q_WebElm.xpRetNumber(adminProps, "prod.productMargin.xp");
        System.out.println("actualTestValue " + "\t" + actualProductMargin);
        return Float.valueOf(actualProductMargin);
    }
    
    public Q_ProductForm removeDiscount(String siteDiscount, String counter, String remBeg, String remEnd){
        Controls.switchWin();
        Controls.scrolDownPixel(1200);
        Q_WebElm.myWait(2000);
        formXp( siteDiscount);
        Integer count = rowCount(counter);
        for(int i= count; i >= 1; i--) {
            formXp( remBeg, i, remEnd);
            System.out.println("Deleted discount tier " + i);
        }
        Q_WebElm.myWait(2000);
        formXp("prod.prodPage.save.xp");
        Q_WebElm.myWait(2000);
        return this;
    }
    
    public Q_ProductForm addDiscount(String siteDiscount, String begXp, String from, String to, String amount, String addBtn) {
        Controls.switchWin();
        Controls.scrolDownPixel(1000);
        formXp( siteDiscount);
        String[] fromQty = {"1", "10", "25", "100"};
        String[] toQty = {"9", "24", "99", "1000"};
        String[] amt = {"0", "1", "2", "3"};
        for (int i = 0; i < 4; i++) {
            formInputXp(begXp, 1, from, fromQty[i]);
            formInputXp( begXp, 1, to, toQty[i]);
            formInputXp(begXp, 1, amount, amt[i]);
            formXp( addBtn);
            System.out.println("Added discounts from " + fromQty[i] + "\t to " + toQty[i] + "\t discount amount " + amt[i]);
        }
        Q_WebElm.myWait(2000);
        formXp("prod.prodPage.save.xp");
        Q_WebElm.myWait(2000);
        return this;
    }
    
    public Q_ProductForm addDiscountSilver(String siteDiscount, String begXp, String from, String to, String amount, String addBtn) {
        Controls.switchWin();
        Controls.scrolDownPixel(1000);
        formXp( siteDiscount);
        String[] fromQty = {"1", "10", "25", "100"};
        String[] toQty = {"9", "24", "99", "1000"};
        String[] amt = {"0", "1", "2", "3"};
        for (int i = 0; i < 4; i++) {
            formInputXp(begXp, 1, from, fromQty[i]);
            formInputXp(begXp, 2, to, toQty[i]);
            formInputXp(begXp, 3, amount, amt[i]);
            formXp( addBtn);
            System.out.println("Added discounts from " + fromQty[i] + "\t to " + toQty[i] + "\t discount amount " + amt[i]);
        }
        Q_WebElm.myWait(2000);
        formXp("prod.prodPage.save.xp");
        Q_WebElm.myWait(2000);
        return this;
    }
    
    public Q_ProductForm pdpDiscount(String onSite, String pdpBegXp, String pdpEndXp){
        Controls.switchWin();
        formXp( onSite);
        Controls.switchWin();
        String tier1 = numberReturn(pdpBegXp , 1, pdpEndXp);
        System.out.println("check price tier 1 " + tier1);
        String tier2 = numberReturn(pdpBegXp, 2, pdpEndXp);
        System.out.println("check price tier 2 " + tier2);
        float disc1 = Float.valueOf(tier1 )- Float.valueOf(tier2);
        Assert.assertEquals(disc1, 1f);

        String tier3 = numberReturn(pdpBegXp, 3, pdpEndXp);
        System.out.println("check price tier 3 " + tier3);
        float disc2 = Float.valueOf(tier1 )- Float.valueOf(tier3);
        Assert.assertEquals(disc2, 2f);

        String tier4 = numberReturn(pdpBegXp, 4, pdpEndXp);
        System.out.println("check price tier 4 " + tier4);
        float disc3 = Float.valueOf(tier1 )- Float.valueOf(tier4);
        Assert.assertEquals(disc3, 3f);
        return this;
    }
    public Q_ProductForm premiumAdjusted(){
        Q_AdminForm adm = new Q_AdminForm();
        DecimalFormat df = new DecimalFormat("#.00");
        Float calculatePrem = Q_ProductForm.calculatePremium();
        System.out.println("premium " + Q_ProductForm.calculatePremium());
        Float obtainedPrem = Q_ProductForm.getPremium("46");
        System.out.println("Premium from function " + Q_ProductForm.getPremium("46"));
        Float masterPriceAdj = adm.masterPriceAdj("adm.configMpa.gold.xp");

        System.out.println("Master Price adjustment " + adm.masterPriceAdj("adm.configMpa.gold.xp"));
        Float adjPremium = calculatePrem + masterPriceAdj;
        System.out.println("Adjusted premium " + adjPremium);
        Assert.assertEquals(df.format(adjPremium), df.format(obtainedPrem));
        return this;
    }

    public static int randomRow(){
        Random rowNo = new Random(); //instance of random class
        int lowerbound = 1;
        int upperbound = 75;
        int i = 0;
        i = rowNo.nextInt(upperbound - lowerbound) + 1;
        System.out.println("int random :" + i);
        return i;
    }
    //JMB-6184 Start
    //Method created for JMB:6184 - Verifying Notes from Product Safe Limit Page
    public static void verifyProductNoteInPrdSafeLimit()
    {
        Q_NewFeatures goTo= new Q_NewFeatures();
        System.out.println("-------Verifying in Product Safe Limit Page-------");
        goTo.navProd("/productSafeLimit.php");
        Q_WebElm.xpSend(adminProps, "prod.prdSafeLimit.prd.txtArea.beg.xp", 46, "prod.prdSafeLimit.prd.txtArea.end.xp", "Product used for automated test cases(prdSafeLimit) please do not modify");
        Q_WebElm.xp(adminProps, "prod.prdStockAndSafeLimit.addNote.btn.beg.xp", 46, "prod.prdStockAndSafeLimit.addNote.btn.end.xp");
        Q_WebElm.myWait(2000);
        Controls.checkAndGetAlertText();
        Q_WebElm.xp(adminProps, "prod.prdSafeLimit.prd.prdLink.beg.xp", 46, "prod.prdSafeLimit.prd.prdLink.end.xp");
        Controls.switchWin();
        String newNote = Q_ProductForm.strXpText("prod.product.firstNotes.xp");
        System.out.println("First  note in Product Form after adding note in Product Safe Limit Page : " + newNote);
        Assert.assertEquals("Product used for automated test cases(prdSafeLimit) please do not modify", newNote);
        Q_WebElm.myWait(2000);
    }

    //Method created for JMB:6184 - Verifying Notes from Product Stock Page
    public static void verifyProductNoteInPrdStock()
    {
        Q_NewFeatures goTo= new Q_NewFeatures();
        System.out.println("-------Verifying in Product Stock Page-------");
        goTo.navProd("/productStock.php");
        Q_WebElm.xpSend(adminProps, "prod.prdStock.prd.txtArea.beg.xp", 148524, "prod.prdStock.prd.txtArea.end.xp", "Product used for automated test cases(prdStock) please do not modify");
        Q_WebElm.xp(adminProps, "prod.prdStockAndSafeLimit.addNote.btn.beg.xp", 148524, "prod.prdStockAndSafeLimit.addNote.btn.end.xp");
        Q_WebElm.myWait(3000);
        Controls.checkAndGetAlertText();
        Q_WebElm.xp(adminProps, "prod.prdStock.prd.prdLink.beg.xp", 148524, "prod.prdStock.prd.prdLink.end.xp");
        Controls.switchWin();
        String noteInPrdForm = Q_ProductForm.strXpText("prod.product.firstNotes.xp");
        System.out.println("First  note in Product Form after adding note in Product Stock Page : " + noteInPrdForm);
        Assert.assertEquals("Product used for automated test cases(prdStock) please do not modify", noteInPrdForm);
    }
    //JMB-6184 End

    //JMB-6214 Start
    /**
     * Searches the page with the @param to tell if its present and return its status 
     * @param productTitle
     * @return product status
     */
    public static String productStatusThroughList(String productTitle)
    {
        String status= " ";
        int count= Q_WebElm.xpCountTableRows(adminProps, "prod.count.products.xp");
        for (int i=1; i<= count; i++)
            if (strXpText("prod.itemDescription.beg.xp", i, "prod.itemDescription.end.xp").equalsIgnoreCase(productTitle))
            {
                System.out.println(strXpText("prod.itemDescription.beg.xp", i, "prod.itemDescription.end.xp"));
                return status= productStatus(i);
            }
            else if (i== count)
                return status= "The product is not displayed";
        return status;
    }

    /**
     * To return product status if its in or out of stock
     * @param item- Integer
     * @return visible text from concatenated xpath
     */
    public static String productStatus(Integer item) {
        String begQtyXp = "prod.itemDescription.beg.xp";
        String endQtyXp = "prod.product.status.end.xp";
        return Q_WebElm.xpRetText(adminProps, begQtyXp, item, endQtyXp);
    }
    //JMB-6214 End
    // JMB-6717 Start
    public static void productStatusShowEntries(String entries)	{
        Q_WebElm.xpSelectText(adminProps, "prod.showEntries.xp", entries);
    }

    public static boolean verifySafeInv_hopefulInv_carryCount() {
        boolean result= true;
        int count = Q_WebElm.xpCountTableRows(adminProps, "prod.countRows.xp");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + "\t" + elementList(adminProps, "prod.table.rowProduct.xp").get(i).getText()
                    + "\t" + elementList(adminProps, "prod.table.rowSafeInv.xp").get(i).getText() + "\t"
                    + elementList(adminProps, "prod.table.rowHopefulInv.xp").get(i).getText() + "\t"
                    + elementList(adminProps, "prod.table.rowCarry.xp").get(i).getText());
            if (elementList(adminProps, "prod.table.rowSafeInv.xp").get(i).getText().equals("0")
                    && elementList(adminProps, "prod.table.rowHopefulInv.xp").get(i).getText().equals("0")
                    && elementList(adminProps, "prod.table.rowCarry.xp").get(i).getText().equals("0")) {
                System.out.println(elementList(adminProps, "prod.table.rowProduct.xp").get(i).getText()
                        + "has Safe Inventory, Hopeful Inventory, and Carry zero");
                result= false;
            }
        }
        return result;
    }

    public static boolean verifyCarrySort() {
        boolean result= true;
        double[] arr = new double[Q_WebElm.xpCountTableRows(adminProps, "prod.countRows.xp")];
        for (int i = 0; i < arr.length - 1; i++) {
            DecimalFormat df = new DecimalFormat("#");
            df.setMaximumFractionDigits(5);
            arr[i] = Double.parseDouble(elementList(adminProps, "prod.table.rowCarry.xp").get(i).getText());
            System.out.println(df.format(arr[i]));
            if (arr[i] < arr[i + 1])
                result= false;
        }
        return result;
    }

    public static List<WebElement> elementList(Properties proper, String locator) {
        return driver.findElements(By.xpath(proper.getProperty(locator)));
    }
    // JMB-6717 End
    //JMB-6738 Start
    public static void xpSend(Properties proper, String catQtyBeg, String locatorText, String catQtyEnd, String quan) {
        driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + locatorText + proper.getProperty(catQtyEnd))).sendKeys(quan);
    }

    //JMB-6738 :Search for PO in repo page(/admin/repos.php)
    public static void searchPOinRepoAndEdit(String PONum)
    {
        Q_WebElm.xpSend(adminProps, "repo.find.SearchTxtBox.xp", PONum);
        Q_WebElm.xp(adminProps, "repo.find.SearchBtn.xp");
        Q_WebElm.xp(adminProps, "repo.record.ActionBtn.xp");
        Q_WebElm.xp(adminProps, "repo.record.EditBtn.xp");
        Controls.switchWin();
    }

    // JMB-6738 : Deleting the specific product from a repo based on index
    public Q_ProductForm deleteItemFromRepoByIndex(int itemIndex) {
        String deletedProdName = Q_WebElm.xpRetText(adminProps, "repo.record.Prd.beg.xp", itemIndex,"repo.record.Prd.end.xp");
        System.out.println("Index " + itemIndex + "  product is :"+ Q_WebElm.xpRetText(adminProps, "repo.record.Prd.beg.xp", itemIndex, "repo.record.Prd.end.xp"));
        Q_WebElm.xp(adminProps, "repo.record.Prd.Delete.beg.xp", itemIndex, "repo.record.Prd.Delete.end.xp");
        Q_WebElm.myWait(1000);
        Controls.checkAlert();
        Q_WebElm.myWait(1000);
        driver.navigate().refresh();
        Q_WebElm.myWait(1000);
        if (driver.findElements(By.xpath("//input[@name='product_id[]']/parent::td[normalize-space()='" + deletedProdName + "']")).size() == 0) {

            System.out.println(
                    "[PASS] Index " + itemIndex + "  product [" + deletedProdName + "] got deleted successfully.");
        } else {
            Assert.fail("FAIL] Index  " + itemIndex + " product [" + deletedProdName + "]  didnt got deleted !");
        }
        return this;
    }
    //JMB-6738 : Adding products to the repo by comparing with existing list of products
    public static void addItemsToRepo(ArrayList availableProdList) {
        String productsArray[] = { "2019 1 oz British Gold Royal Arms Coin (BU)","1 oz Silver Bar (Varied Condition, Any Mint)" };
        for (int counter = 0; counter <= productsArray.length - 1; counter++) {
            if (availableProdList.contains(productsArray[counter])) {
                System.out.println("[INFO] " + productsArray[counter] + " :is already there!");
            } else {
                Q_WebElm.xp(adminProps, "repo.record.Prd.addProduct.xp");
                Q_WebElm.xp(adminProps, "repo.record.Prd.search.autoDropdown.btn.xp");
                Q_WebElm.myWait(4000);
                Q_WebElm.xpSend(adminProps, "repo.record.Prd.search.autoDropdown.txtBox.xp",productsArray[counter]);
                Q_WebElm.myWait(3000);
                Q_WebElm.xpSendEnter(adminProps, "repo.record.Prd.search.autoDropdown.txtBox.xp");
                Q_WebElm.myWait(2000);
                prod.xpSend(adminProps, "repo.record.Prd.info.beg.xp", productsArray[counter],"repo.record.Prd.qty.xp", "100");
                prod.xpSend(adminProps, "repo.record.Prd.info.beg.xp", productsArray[counter],"repo.record.Prd.sells.xp", "100");
                prod.xpSend(adminProps, "repo.record.Prd.info.beg.xp", productsArray[counter],"repo.record.Prd.buys.xp", "100");
                Q_WebElm.myWait(2000);
                Controls.xpExecutorScrollToView(adminProps, "adm.repo.save.xp");
                Q_WebElm.xp(adminProps, "adm.repo.save.xp");
                Q_WebElm.myWait(3000);
                System.out.println("[INFO] Product : [" + productsArray[counter] + "] added successfully!");
            }
        }

    }
    public static void addProductsAndDeleteProducts(int noOfProducts)
    {
        ArrayList<String> availableProducts = new ArrayList<String>();
        // Printing Available Products in the existing buyback record
        List<WebElement> prodList = driver.findElements(By.xpath("//div[@class='premwarn']/parent::td"));
        for (WebElement e : prodList) {
            availableProducts.add(e.getText());
        }
        System.out.println("Available Products are :" + "\n" + availableProducts);
        if (availableProducts.size() >= 3) {
            //Deleting the second item and verifies it's being deleted [only if the products count is >3 ]
            prod.deleteItemFromRepoByIndex(noOfProducts);
        }
        else
        {	//If the sufficient amount of products are not there, the below method add products to the repo
            prod.addItemsToRepo(availableProducts);
            //After Adding, the below method will try to delete the second index product
            prod.deleteItemFromRepoByIndex(noOfProducts);
        }
    }

    // Method created for JMB-4220 : This method returns the In Hand Quantity for the productID which is supplied(Regular Inventory)
    public static int verifyInhandQtyRegularInventory(String metalType, String prodID) {
        prod.productsMenu(metalType);
        prod.productsIdSearch(prodID);
        Q_WebElm.myWait(2000);
        Controls.switchWin();
        String inHandQty = Q_WebElm.xpRetNumber(adminProps, "prod.inhand.xp");
        Integer inHand = Integer.valueOf(inHandQty);
        System.out.println("[REGULAR INVENTORY] In Hand Qty of " + prodID + " is :" + inHand);
        return inHand;

    }
    //JMB-6738 End

    //JMB-4220 Start
    // Method created for JMB-4220 :Exchange products in both Regular and Dallas Inventory
    public Q_ProductForm exchangeProdInventory(String inventory, String prd1, String prd2, int qty) {
        Q_NewFeatures goTo = new Q_NewFeatures();
        String inventoryURL = null;
        if (inventory.equalsIgnoreCase("regular")) {
            inventoryURL = "/exchange-products.php";
        } else if (inventory.equalsIgnoreCase("dallas")) {
            inventoryURL = "/exchange-products.php?loc=dallas";
        } else {
            Assert.fail("[FAIL] Enter a valid Inventory!");
        }
        goTo.navProd(inventoryURL);
        // Populating Details for First product
        Q_WebElm.nameSend(adminProps, "exchangeProducts.minusQty.name", String.valueOf(qty));
        Q_WebElm.xp(adminProps, "repo.record.Prd.search.autoDropdown.btn.xp");
        Q_WebElm.xpSend(adminProps, "exchangeProducts.search.beg.xp", 1, "exchangeProducts.search.end.xp", prd1);
        Q_WebElm.myWait(1000);
        //Added Code to Delete the characters here, since the test was failing for few people.
        Q_WebElm.xpSendDelete(adminProps, "exchangeProducts.search.beg.xp", 1, "exchangeProducts.search.end.xp");
        Q_WebElm.myWait(1000);
        Q_WebElm.xpSendTab(adminProps, "exchangeProducts.search.beg.xp", 1, "exchangeProducts.search.end.xp");
        Q_WebElm.myWait(1000);
        Q_WebElm.nameSend(adminProps, "exchangeProducts.minusNotes.name","Decreased :" + qty + " Nos " + "- QA Test Automation");
        // Populating Details for Second Product
        Q_WebElm.nameSend(adminProps, "exchangeProducts.plusQty.name", String.valueOf(qty));
        Q_WebElm.xp(adminProps, "repo.record.Prd.search.autoDropdown.btn.xp");
        Q_WebElm.xpSend(adminProps, "exchangeProducts.search.beg.xp", 2, "exchangeProducts.search.end.xp", prd2);
        Q_WebElm.myWait(1000);
        Q_WebElm.xpSendTab(adminProps, "exchangeProducts.search.beg.xp", 2, "exchangeProducts.search.end.xp");
        Q_WebElm.myWait(1000);
        Q_WebElm.nameSend(adminProps, "exchangeProducts.plusNotes.name","Increased :" + qty + " Nos " + "- QA Test Automation");
        Q_WebElm.xp(adminProps, "exchangeProduct.exchangeBtn.xp");
        Q_WebElm.myWait(1000);
        Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps, "exchangeproduct.exchangeSuccessAlert.xp"),"[FAIL] Exchange Success Alert is not displayed!");
        return this;
    }

    // Method created for JMB-4220 : This method returns the In Hand Quantity for the productID which is supplied(Dallas Inventory)
    public static int verifyInhandQtyDallasInventory(String prodID) {

        nf.navProd("/inventory-dallas.php");
        Q_WebElm.xpSend(adminProps, "dallasInventory.search.xp", prodID);
        System.out.println("Product is: " + Q_WebElm.xpRetText(adminProps, "dallasInventory.prodTitle.xp"));
        String inHandQty = Q_WebElm.xpRetNumber(adminProps, "dallasInventory.prodInHand.xp");
        Integer inHand = Integer.valueOf(inHandQty);
        System.out.println("[DALLAS INVENTORY] In Hand Qty of " + prodID + " is :" + inHand);
        return inHand;

    }
    //JMB-4220 End
    
    
    // JMB-6804 Start
 	// ******************************************************************
 	// * Description: Verify Dallas In Hand coloumn in inventory reports
 	// * Param: String
 	// * Jira Ticket: JMB-6804
 	// * Status: Complete
 	// *********************************************************************/
 	public static void dallasInHandReport(String link) {
 		driver.navigate().to(link);
 		String value = Q_WebElm.xpRetText(adminProps, "jm.inHand.xp");
 		Assert.assertEquals("Dallas IN Hand", value);
 		System.out.println("Verified the link "+link+" and IN Hand coloumn presence in the report");
 	}
 	
	  // ******************************************************************
	  // * Description: Verify Dallas In Hand coloumn in inventory reports by searcing different metal type
	  // * Param: String
	  // * Jira Ticket: JMB-6804
	  // * Status: Complete
	  // *********************************************************************/
	 public static void dallasInHandReportSearch(String metalType) {
		driver.navigate().to(adminUrl+"/inventory-full.php");
        switch(metalType){
            case "Gold":
            	Q_WebElm.xpSelectText(adminProps, "jm.selItem1.xp", "Gold");
            	Q_WebElm.xpSelectText(adminProps, "jm.selItem2.xp", "Bullion");
            	Q_WebElm.xp(adminProps, "jm.submit.xp");
        		String columnValue = Q_WebElm.xpRetText(adminProps, "jm.inventorytable.xp");
        		Assert.assertEquals("Dallas IN Hand", columnValue);
        		System.out.println("Verified and Dallas IN Hand coloumn in the report for Gold metaltype");
                break;
            case "Silver":
            	Q_WebElm.xpSelectText(adminProps, "jm.selItem1.xp", "Silver");
            	Q_WebElm.xpSelectText(adminProps, "jm.selItem2.xp", "Bullion");
            	Q_WebElm.xp(adminProps, "jm.submit.xp");
        		String columnValue1 = Q_WebElm.xpRetText(adminProps, "jm.inventorytable.xp");
        		Assert.assertEquals("Dallas IN Hand", columnValue1);
        		System.out.println("Verified and Dallas IN Hand coloumn in the report for Silver metaltype");
                break;	 
            case "Platinum":
            	Q_WebElm.xpSelectText(adminProps, "jm.selItem1.xp", "Platinum");
            	Q_WebElm.xpSelectText(adminProps, "jm.selItem2.xp", "Bullion");
            	Q_WebElm.xp(adminProps, "jm.submit.xp");
        		String columnValue2 = Q_WebElm.xpRetText(adminProps, "jm.inventorytable.xp");
        		Assert.assertEquals("Dallas IN Hand", columnValue2);
        		System.out.println("Verified and Dallas IN Hand coloumn in the report for Platinum metaltype");
                break;	
            case "Palladium":
            	Q_WebElm.xpSelectText(adminProps, "jm.selItem1.xp", "Palladium");
            	Q_WebElm.xpSelectText(adminProps, "jm.selItem2.xp", "Bullion");
            	Q_WebElm.xp(adminProps, "jm.submit.xp");
        		String columnValue3 = Q_WebElm.xpRetText(adminProps, "jm.inventorytable.xp");
        		Assert.assertEquals("Dallas IN Hand", columnValue3);
        		System.out.println("Verified and Dallas IN Hand coloumn in the report for Palladium metaltype");
                break;	
            case "Copper":
            	Q_WebElm.xpSelectText(adminProps, "jm.selItem1.xp", "Copper");
            	Q_WebElm.xpSelectText(adminProps, "jm.selItem2.xp", "Bullion");
            	Q_WebElm.xp(adminProps, "jm.submit.xp");
        		String columnValue4 = Q_WebElm.xpRetText(adminProps, "jm.inventorytable.xp");
        		Assert.assertEquals("Dallas IN Hand", columnValue4);
        		System.out.println("Verified and Dallas IN Hand coloumn in the report for Copper metaltype");
                break;	
            case "Accessories":
            	Q_WebElm.xpSelectText(adminProps, "jm.selItem1.xp", "Accessories");
            	Q_WebElm.xpSelectText(adminProps, "jm.selItem2.xp", "Bullion");
            	Q_WebElm.xp(adminProps, "jm.submit.xp");
        		String columnValue5 = Q_WebElm.xpRetText(adminProps, "jm.inventorytable.xp");
        		Assert.assertEquals("Dallas IN Hand", columnValue5);
        		System.out.println("Verified and Dallas IN Hand coloumn in the report for Accessories metaltype");
                break;	
            default:
                System.out.println("Make sure the metal type is correct");
                break;
        }
 	}
 	// JMB-6804 End
    
	// JMB-4461 Start

	/********************************************************************
	 * // * Description: Verify Add Dollar Total to top of Safe Inventory Carry Page
	 * values // * Param: String // * Returns: NA // * Status: Complete // * @throws
	 * ParseException // *
	 *******************************************************************/

	public static void verifyCarryTotal(String targetlink) throws ParseException {
		driver.navigate().to(targetlink);
		String carryTotal = driver.findElement(By.xpath(adminProps.getProperty("jm.carrytotal.xp"))).getText();
		String carryTotalSplit[] = carryTotal.split(" ");
		System.out.println("Total of Top value: " + carryTotal);

		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		symbols.setDecimalSeparator('.');
		String pattern = "#,##0.0";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
		decimalFormat.setParseBigDecimal(true);
		int carryTotalVal, sumTotalVal;

		if (carryTotalSplit[2].contains("$"))
			carryTotal = carryTotalSplit[2].replace("$", "");
		else if (carryTotalSplit[3].contains("$"))
			carryTotal = carryTotalSplit[3].replace("$", "");

		// parse the string

		double totalConvert = ((BigDecimal) decimalFormat.parse(carryTotal)).doubleValue();

		String total = decimalFormat.format(Math.round(totalConvert));

		carryTotalVal = ((BigDecimal) decimalFormat.parse(total)).intValue();
		System.out.println("Total value in the top: " + carryTotalVal);

		int size = driver.findElements(By
				.xpath(adminProps.getProperty("jm.carry.beg.xp") + "*" + adminProps.getProperty("jm.carry.end.xp")))
				.size();

		double sum = 0.0;

		for (int i = 1; i <= size; i++) {

			carryTotal = driver.findElement(By.xpath(
					adminProps.getProperty("jm.carry.beg.xp") + i + adminProps.getProperty("jm.carry.end.xp")))
					.getText();
			sum += ((BigDecimal) decimalFormat.parse(carryTotal.replace("$", ""))).doubleValue();

		}
		carryTotal = decimalFormat.format(Math.round(sum));
		sumTotalVal = ((BigDecimal) decimalFormat.parse(carryTotal)).intValue();
		System.out.println("Toatl of value of sum: " + sumTotalVal);

		Assert.assertTrue((carryTotalVal == sumTotalVal || (carryTotalVal == (sumTotalVal - 1))),
				"The values are equal");
	}
	//JMB-4461 End
	
	//JMB-6078 Start
	/**
	 * Verifying that performing  "UnArrive" results in reducing the In Hand Qty
	 * @param prodName - Supply the Product Full Name
	 * @param id -Supply the Product's id found in Products Page
	 * @param qty - Provide the Qty which you need to increase /decrease
	 */
	public static void verifyUnArriveDecreaseIHQ(String prodName, String id, int qty) {
		Q_NewFeatures goTo = new Q_NewFeatures();
		goTo.arriveItemReceipts();
		String inHandQtyAfterArrive = Q_WebElm.xpRetNumber(adminProps, "prod.inhand.xp");
		System.out.println("[INFO] In Hand Qty after 'Arrived' :  " + inHandQtyAfterArrive);
		driver.navigate().back();
		Q_WebElm.myWait(2000);
		Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps, "createReciepts.unarrive.xp"),"[FAIL] Unarrive buttton doesnot exist");
		// Marking as unarrived
		Q_WebElm.xp(adminProps, "createReciepts.unarrive.xp");
		Q_WebElm.myWait(2000);
		goTo.navProd("/products-form.php?id=" + id);
		Q_WebElm.myWait(4000);
		driver.navigate().refresh();
		Q_WebElm.myWait(1000);
		String inHandQtyAfterUnArrive = Q_WebElm.xpRetNumber(adminProps, "prod.inhand.xp");
		System.out.println("[INFO] In Hand Qty after 'Unarrived' :" + inHandQtyAfterUnArrive);
		Assert.assertEquals(Integer.parseInt(inHandQtyAfterUnArrive), Integer.parseInt(inHandQtyAfterArrive) - qty);
		System.out.println("[PASS] In Hand Qty reduced from [" + inHandQtyAfterArrive + "]  to ["+ inHandQtyAfterUnArrive + "] upon doing 'UnArrive' ");
	}
	
	//JMB-6078 End
	
	//JMB-6861 Start
    //*******************************************************************
    // * Description: Updates the manual limit of a product
    // * Param: int quan - limit to set product to
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public static void updateProductManualLimit(int quan){
        int currentLimitqty = getProductCurrentLimit();
        System.out.println("Current Limit value is set to: " + currentLimitqty);
        // If current limit is 0 then make sure to update site status to "In stock"
        Q_WebElm.xpSelectText(adminProps, "prod.limited.select.xp", "Manual");
        Q_WebElm.xpClear(adminProps,"prod.limited.input.xp");
        Q_WebElm.xpSend(adminProps,"prod.limited.input.xp",String.valueOf(quan));
        Q_WebElm.xp(adminProps, "prod.prodPage.save.xp");
        Q_WebElm.myWait(6000);
        Assert.assertEquals(Q_WebElm.xpRetAttr(adminProps, "prod.limited.input.xp", "value"), String.valueOf(quan));
        System.out.println("New Limit value is set to: " + quan);
    }
    
    //*******************************************************************
    // * Description: Updates the manual limit of a product
    // * Param: None
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public static void updateProductInStock(){
    	Q_WebElm.xpSelectText(adminProps, "prod.jmStockStatus.xp", "In stock");
    	Q_WebElm.xpSelectText(adminProps, "prod.silverStockStatus.xp", "In stock");
    	Q_WebElm.xpSelectText(adminProps, "prod.pmStockStatus.xp", "In stock");
    }
    
    //*******************************************************************
    // * Description: Updates the manual limit of a product
    // * Param: None
    // * Returns: int current product limit value
    // * Status: Complete
    //*******************************************************************/
    public static int getProductCurrentLimit(){
    	String currentLimitqty = Q_WebElm.xpRetAttr(adminProps, "prod.limited.input.xp", "value");
    	if (currentLimitqty.contentEquals("")) {
    		currentLimitqty = "0";
    	}
        return Integer.parseInt(currentLimitqty);
    }
    
    //*******************************************************************
    // * Description: Updates the manual limit of a product
    // * Param: productId - product id number, int quan - limit to set product to
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public static void updateProductLimit(String productId, int quan) {
    	System.out.println("Navigating to product: " + productId);
    	driver.navigate().to(adminUrl + "/products-form.php?id=" + productId);
    	updateProductInStock();
    	updateProductManualLimit(quan);
    }
    
    //*******************************************************************
    // * Description: Updates the manual limit of a product
    // * Param: productId - product id number
    // * Returns: int current product limit value
    // * Status: Complete
    //*******************************************************************/
    public static int getProductInventory(String productId) {
    	driver.navigate().to(adminUrl+ "/products-form.php?id=" + productId);
    	return getProductCurrentLimit();
    }
    
    //*******************************************************************
    // * Description: Updates the manual limit of a product
    // * Param: int startParentInventory - starting inventory for parent product, 
    // * int startChild1Inventory - starting inventory for child 1 product, 
    // * int startChild2Inventory - starting inventory for child 2 product
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public static void reset2019AmericanSilverEagleProductsLimits(int startParentInventory, int startChild1Inventory, int startChild2Inventory) {
    	// Reset parent product limit
    	updateProductLimit("2098824", startParentInventory);
        // Reset child 1 product limit
    	updateProductLimit("2187069", startChild1Inventory);
        // Reset child 2 product limit
    	updateProductLimit("2187081", startChild2Inventory);
    	// Navigates back to main admin
    	driver.navigate().to(adminUrl);
    }
    
    //*******************************************************************
    // * Description: Updates the manual limit of a product
    // * Param: String productId - product id number, int quan - limit to set product to
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public static void productCreateFrontendOrder(String productId, int quan) {
    	driver.navigate().to(adminUrl+ "/products-form.php?id=" + productId);
    	Q_WebElm.xp(adminProps, "prod.jmOnSite.xp");
    	Q_WebElm.myWait(2000);
        Controls.switchTab(1);
    	chk.addItemToCart(quan);
    	chk.selectPaymentType("cheque");
        chk.selectcheckoutBtn("top");
        chk.completeOrder();
        String orderNo = Q_WebElm.xpRetText(adminProps, "fe.jm.thankyouOrderNumber.xp").replaceAll("[^0-9?!\\.]","");
        System.out.println("Order Number " + orderNo);
    	Controls.closeTabsSwitchWinMain();
    }
    
    //*******************************************************************
    // * Description: Updates the manual limit of a product
    // * Param: productId - product id number, int quan - limit to set product to, 
    // * int startParentInventory - starting inventory for parent product, 
    // * int startChild1Inventory - starting inventory for child 1 product, 
    // * int startChild2Inventory - starting inventory for child 2 product
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    public static void verify2019AmericanSilverEagleProductsLimits(String productId, int quan, int startParentInventory, int startChild1Inventory, int startChild2Inventory) {
    	int expectedParentInventory, expectedChild1Invenotry, expectedChild2Inventory;
    	int actualParentInventory, actualChild1Invenotry, actualChild2Inventory;
    	int numberCoinsOrdered;
    	
    	// Convert quan to total number of coins ordered
    	if (productId.contentEquals("2187081")) {
    		numberCoinsOrdered = quan * 500;
    	} else if (productId.contentEquals("2187069")) {
    		numberCoinsOrdered = quan * 20;
    	} else {
    		numberCoinsOrdered = quan;
    	}
    	
    	// Calculate the expected product inventory after order
    	expectedParentInventory = startParentInventory-numberCoinsOrdered;
    	if (expectedParentInventory < 20) {
    		expectedChild1Invenotry = 0;
    	} else {
    		expectedChild1Invenotry = startChild1Inventory-(numberCoinsOrdered/20);
    	}
    	if (expectedParentInventory < 500) {
    		expectedChild2Inventory = 0;
    	} else {
    		expectedChild2Inventory = startChild2Inventory-(numberCoinsOrdered/500);
    	}
    	
    	// Get the actual product inventory after order
    	actualParentInventory = getProductInventory("2098824");
    	actualChild1Invenotry = getProductInventory("2187069");
    	actualChild2Inventory = getProductInventory("2187081");
    	
    	Assert.assertEquals(actualParentInventory, expectedParentInventory, "[Fail] 2019 American Silver Eagle Parent '2098824' inventory does not match");
    	Assert.assertEquals(actualChild1Invenotry, expectedChild1Invenotry, "[Fail] 2019 American Silver Eagle Child 1 '2187069' inventory does not match");
    	Assert.assertEquals(actualChild2Inventory, expectedChild2Inventory, "[Fail] 2019 American Silver Eagle Child 2 '2187081' inventory does not match");
    	System.out.println("[Pass] 2019 American Silver Eagle Parent, Child 1, and Child 2 inventory matches after order has been placed.");
    }
    //JMB-6861 End
    
    //JMB-6839 Start	
  	public static void xpSendDelete(Properties proper, String locator){
  		driver.findElement(By.xpath(proper.getProperty(locator))).sendKeys(Keys.DELETE);
  	}
  	
  	/******************************************************************
   	 * Description: Verify inventory adjust reports positive & negative Integer values and special character)
   	 * Param: String, String
   	 * Jira Ticket: JMB-6839
   	 * Status: Complete
   	 *********************************************************************/
  	public static void adjustInhandIntegerValues(String link, String values) {
  		driver.navigate().to(link);
  		if (values.matches("[0-9]+") || (values.contains("-"))) {
  			String reportName = Q_WebElm.xpRetText(adminProps, "jm.adjustInhand.xp");
  			System.out.println("Inventory Adjust Name: " + reportName);

  			Q_WebElm.xp(adminProps, "jm.adjustInhand.productButton.xp");
  			Q_WebElm.xpSend(adminProps, "jm.adjustInhand.productSearch.xp", "1 oz Silver Melt");
  			Q_WebElm.myWait(1000);
  			Q_ProductForm.xpSendDelete(adminProps, "jm.adjustInhand.productSearch.xp");
  			Q_WebElm.myWait(1000);
  			Q_WebElm.xpSendTab(adminProps, "jm.adjustInhand.productSearch.xp");
  			Q_WebElm.myWait(1000);

  			Q_WebElm.xpSend(adminProps, "jm.adjustInhand.qty.xp", values);
  			Q_WebElm.xpSend(adminProps, "jm.adjustInhand.notes.xp", "testing");

  			Q_WebElm.xp(adminProps, "jm.adjustInhand.submit.xp");
  			Q_WebElm.xp(adminProps, "jm.adjustInhand.yes.xp");
  			System.out.println("Integer positive/negative values "+values+" is accepted");
  			
  		} else if (values.matches("[!@#$%&*()_+=|<>?{}\\[\\]~]")||values.matches("[a-zA-Z]+")) {
  			driver.navigate().to(link);
  			String reportName = Q_WebElm.xpRetText(adminProps, "jm.adjustInhand.xp");
  			System.out.println("Inventory Adjust Name:" + reportName);

  			Q_WebElm.xp(adminProps, "jm.adjustInhand.productButton.xp");
  			Q_WebElm.xpSend(adminProps, "jm.adjustInhand.productSearch.xp", "1 oz Silver Melt");
  			Q_WebElm.myWait(1000);
  			
  			Q_ProductForm.xpSendDelete(adminProps, "jm.adjustInhand.productSearch.xp");
  			Q_WebElm.myWait(1000);
  			Q_WebElm.xpSendTab(adminProps, "jm.adjustInhand.productSearch.xp");
  			Q_WebElm.myWait(1000);

  			Q_WebElm.xpSend(adminProps, "jm.adjustInhand.qty.xp", values);
  			Q_WebElm.xpSend(adminProps, "jm.adjustInhand.notes.xp", "testing");

  			Q_WebElm.xp(adminProps, "jm.adjustInhand.submit.xp");
  			Assert.assertTrue((Q_WebElm.xpDisplayed(adminProps, "jm.adjustInhand.error.xp")), "Special characters accepted");
  			System.out.println("Special characters/Alphabets "+values+" is not accepted and deleted automatically");

  		} else {
  			Assert.fail("The input values are not accepted or ");
  		}
  	}

  	/******************************************************************
  	 * Description: Verify inventory exchange reports positive & negative Integer values and special character)
  	 * Param: String, String, String
  	 * Jira Ticket: JMB-6839
  	 * Status: Complete
  	 *********************************************************************/
  	public static void productInhandExchangeInventory(String link, String valueMinus, String valuePlus) {

  		if (valueMinus.matches("[0-9]+") || (valueMinus.contains("-")) && valuePlus.matches("[0-9]+")
  				|| (valuePlus.contains("-"))) {
  			driver.navigate().to(link);
  			String reportName = Q_WebElm.xpRetText(adminProps, "jm.productInhand.inventory.xp");
  			System.out.println("Product Inhand Exchange report: " + reportName);

  			Q_WebElm.xpSend(adminProps, "jm.productInhand.minusqty.xp", valueMinus);
  			Q_WebElm.xpSend(adminProps, "jm.productInhand.productMinus.xp", "1 oz Silver Melt");
  			Q_WebElm.myWait(1000);
  			Q_ProductForm.xpSendDelete(adminProps, "jm.adjustInhand.productSearch.xp");
  			Q_WebElm.myWait(1000);
  			Q_WebElm.xpSendTab(adminProps, "jm.adjustInhand.productSearch.xp");
  			Q_WebElm.myWait(1000);

  			Q_WebElm.xpSend(adminProps, "jm.productInhand.minusNote.xp", "testing");

  			Q_WebElm.xpSend(adminProps, "jm.productInhand.plusqty.xp", valuePlus);
  			Q_WebElm.xpSend(adminProps, "jm.productInhand.productPlus.xp", "1 oz Silver Melt");
  			Q_WebElm.myWait(2000);

  			Q_WebElm.xp(adminProps, "jm.productInhand.plusNote.xp");
  			Q_WebElm.xpSend(adminProps, "jm.productInhand.plusNote.xp", "testing");

  			Q_WebElm.xp(adminProps, "jm.productInhand.exchangeClick.xp");
  			Assert.assertTrue((Q_WebElm.xpDisplayed(adminProps, "jm.productInhand.alert.xp")));
  			System.out.println("Positive/negative integer values, " + valueMinus + " && " + valuePlus + " are accepted");
  			
  		} else if (valueMinus.matches("[!@#$%&*()_+=|<>?{}\\[\\]~]")
  				|| (valuePlus.matches("[!@#$%&*()_+=|<>?{}\\[\\]~]"))||(valueMinus.matches("[a-zA-Z]+")
  						|| (valuePlus.matches("[a-zA-Z]+")))) {
  			driver.navigate().to(link);
  			String reportName = Q_WebElm.xpRetText(adminProps, "jm.productInhand.inventory.xp");
  			System.out.println("Product Inhand Exchange" + reportName);

  			Q_WebElm.xpSend(adminProps, "jm.productInhand.minusqty.xp", valueMinus);
  			Q_WebElm.xpSend(adminProps, "jm.productInhand.productMinus.xp", "1 oz Silver Melt");
  			Q_WebElm.myWait(2000);

  			Q_WebElm.xp(adminProps, "jm.productInhand.minusNote.xp");
  			Q_WebElm.xpSend(adminProps, "jm.productInhand.minusNote.xp", "testing");

  			Q_WebElm.xpSend(adminProps, "jm.productInhand.plusqty.xp", valuePlus);
  			Q_WebElm.xpSend(adminProps, "jm.productInhand.productPlus.xp", "1 oz Silver Melt");
  			Q_WebElm.myWait(2000);

  			Q_WebElm.xp(adminProps, "jm.productInhand.plusNote.xp");
  			Q_WebElm.xpSend(adminProps, "jm.productInhand.plusNote.xp", "testing");

  			Q_WebElm.xp(adminProps, "jm.productInhand.exchangeClick.xp");
  			Controls.checkAlert();
  			System.out.println("Alphabets & Special characters, " + valueMinus + " & " + valuePlus
  					+ " are not accepted and deleted automatically");

  		} else {
  			Assert.fail("The input values are not accepted or ");
  		}
  	}
  	//JMB-6839 End
    
    // JMB-4511 Start
	/*********************************************************************
	 * Description: Normal Button is disabled for Copper
	 * Param: None
	 * Jira Ticket: JMB-4511
	 * Status: Complete
	 *******************************************************************/

	public static void verifyNormalBtnDisabledForCopper() {

		// Checks Copper is selected by default and Normal link is disabled
		Q_ProductForm.isXpDisplayed("jm.prod.copper.xp");
		Q_ProductForm.isXpDisplayed("jm.prod.normal.disabled.xp");
		System.out.println("\"Normal\" option for the Fixed Price Selector is disabled");
		Q_WebElm.xp(adminProps, "jm.prod.saveChanges.xp");
		Q_WebElm.myWait(2000);
		String actualMsg = Q_WebElm.xpRetText(adminProps, "jm.prod.errorMsg.xp");
		System.out.println("Error message: " + actualMsg);
		String errorMsg = "Copper may only use Fixed pricing. Check Product Details";
		Assert.assertTrue(actualMsg.contains(errorMsg), "Error message not displayed");
	}

	/*********************************************************************
	 * Description: Metal Type Price Selection
	 * Param: None
	 * Jira Ticket: JMB-4511
	 * Status: Complete
	 *******************************************************************/
	public static void metalTypeSelection() {
		// Clicks Metal type one by one and validates Normal link enabled/disabled based
		// on the selection
		String[] metaltype = { "Silver", "Gold", "Copper", "Platinum", "Palladium", "Accessory" };
		String[] metalvalue = { "XAG", "XAU", "XCU", "XPT", "XPD", "ACC" };
		String act;
		int s = driver.findElements(By.xpath("(//label[text()='Metal Type']/..//input)")).size();

		for (int i = 1; i <= s; i++) {
			if (i != 3) {
				Q_WebElm.xp(adminProps, "jm.prod.metaltype.xp.beg", i, "jm.prod.metaltype.xp.end");
				String val = Q_WebElm.xpRetAttr(adminProps, "jm.prod.metaltype.xp.beg", i, "jm.prod.metaltype.xp.end",
						"value");
				val = Q_WebElm.xpRetAttr(adminProps, "jm.prod.metaltype.xp.beg", i, "jm.prod.metaltype.xp.end",
						"value");
				Assert.assertTrue(val.equals(metalvalue[i - 1]), val + " label not enabled");
				val = Q_WebElm.xpRetText(adminProps, "jm.prod.metaltype.xp.beg", i, "jm.prod.metaltype.xp.end1");
				System.out.println("Metal value: " + val);
				Assert.assertTrue(val.contains(metaltype[i - 1]), "Silver label not enabled");
				act = Q_WebElm.xpRetText(adminProps, "jm.prod.normal.enabled.xp");
				System.out.println("Normal label value is " + act);
				Assert.assertTrue(act.contains("Normal"), "Normal label not enabled");
			}
		}
	}
	// JMB-4511 End
	
	//JMB 6852 Start
	
	/**
     * JMB-6852- This Method verifies the values before and after AMARK update of the product which is in "Missing Shiphawk Products"
     */
    public static void verifyProductHawkDetailsBeforeAfterAMARKUpdate()
    {
    	//Getting the Product ID
    	String productID = Q_WebElm.xpRetText(adminProps, "shipHawkProd.details.beg.xp", 1,"shipHawkProd.details.end.xp");
		System.out.println("[INFO] Product ID Selected: [" + productID + "]");
		getBeforeAMARKUpdateValues();
		performAMARKUpdate(productID);
		getAfterAMARKUpdateValues();

    }
    
    /**
     *JMB-6852  This Method fetch values of the Product which is in "Missing Shiphawk Products" before AMARK Update
     * @return beforeAMARKUpdateList - Which stores the values
     */
    public static ArrayList<String> getBeforeAMARKUpdateValues()
    {
    	ArrayList<String> beforeAMARKUpdateList= new ArrayList<String>();
    	beforeAMARKUpdateList.add(Q_WebElm.xpRetText(adminProps, "shipHawkProd.details.beg.xp", 8, "shipHawkProd.details.end.xp"));
		beforeAMARKUpdateList.add(Q_WebElm.xpRetText(adminProps, "shipHawkProd.details.beg.xp", 7, "shipHawkProd.details.end.xp"));
		beforeAMARKUpdateList.add(Q_WebElm.xpRetText(adminProps, "shipHawkProd.details.beg.xp", 6, "shipHawkProd.details.end.xp"));
		return beforeAMARKUpdateList;
    }
    
    /**
     * JMB-6852 Performing AMARK Update
     * @param productID
     */
    public static void performAMARKUpdate(String productID)
    {
    	String parent=driver.getWindowHandle();
		Q_WebElm.xp(adminProps, "shipHawkProd.EditBtn.beg.xp", Integer.parseInt(productID), "shipHawkProd.EditBtn.end.xp");
		Controls.switchWin();
		//Doing the AMARK Update
		Q_WebElm.id(adminProps, "productForm.updateBtn.id");
		driver.switchTo().window(parent);
		driver.navigate().refresh();
		Q_WebElm.myWait(3000);
		Q_WebElm.xpSend(adminProps, "shipHawkProd.search.xp", productID);	
    }
    
    /**
     * JMB-6852 This Method fetch values of the Product which is in "Missing Shiphawk Products" after AMARK Update
     */
    public static void getAfterAMARKUpdateValues()
    {
    	ArrayList<String> beforeAMARKValuesList= new ArrayList<String>(getBeforeAMARKUpdateValues());
    	String weightVarianceAfter=Q_WebElm.xpRetText(adminProps, "shipHawkProd.details.beg.xp", 8, "shipHawkProd.details.end.xp");
		String currShipWeightAfter=Q_WebElm.xpRetText(adminProps, "shipHawkProd.details.beg.xp", 7, "shipHawkProd.details.end.xp");
		String shipHawkWeightAfter=Q_WebElm.xpRetText(adminProps, "shipHawkProd.details.beg.xp", 6, "shipHawkProd.details.end.xp");
		System.out.println("----------------------------------------");
		System.out.println("[INFO] Weight Variance(After AMARK Update): ["+weightVarianceAfter+"]");
		System.out.println("[INFO] Current Ship Weight(After AMARK Update): ["+currShipWeightAfter+"]");
		System.out.println("[INFO] ShipHawk Weight:(After AMARK Update) ["+shipHawkWeightAfter+"]");
		//Checking Weight Variance(After) becomes Zero
		Assert.assertEquals(weightVarianceAfter, "0","[FAIL] AMARK Update did't changed the Weight Variance to Zero");
		//Checking Current Ship Weight(After AMARK Update) == Ship Hawk Weight(After AMARK Update)
		Assert.assertEquals(currShipWeightAfter, shipHawkWeightAfter,"[FAIL] AMARK Update didn't override the Current Ship Date to Ship Hawk Weight");
		Assert.assertEquals(shipHawkWeightAfter, beforeAMARKValuesList.get(2),"[FAIL] AMARK Update impacted the ShipHawk Weight!");
    }
    //JMB 6852 End
    
    
    // JMB-6721 Start
  	/**
  	 * To input into follow up date for a product in High Priority tab
  	 * @param productID
  	 * @param date
  	 */
    public static void update_followUpDateColumn_highPriority(String productID, String date) {
  		int count = Q_WebElm.xpCountTableRows(adminProps, "lowInventory.productID.high.list.xp");
  		System.out.println(count);
  		for (int index = 0;index < count;index++) {
  			if (Q_WebElm.listOfElements(adminProps, "lowInventory.productID.high.list.xp").get(index).getText().equals(productID)) {
  				Q_WebElm.listOfElements(adminProps, "lowInventory.followUpDate.high.datePicker.xp").get(index).clear();
  				Q_WebElm.listOfElements(adminProps, "lowInventory.followUpDate.high.datePicker.xp").get(index).sendKeys(date + Keys.TAB);
  				Q_WebElm.myWait(3000);
  				Q_WebElm.listOfElements(adminProps, "lowInventory.followUpDate.high.updateBtn.xp").get(index).click();
  				driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
  				try {
  					Q_WebElm.xpDisplayed(adminProps, "lowInventory.lowPrority.tab.xp");
  					System.out.println("The page did not load as expected");
  				} catch (Throwable exp)	{
  					Assert.fail("The page loaded unexpectedly.", exp);
  				}
  				Q_WebElm.myWait(1500);
  				System.out.println(Controls.checkAlert());
  				break;
  			}
  			else if (index == count-1)	{
  				Assert.fail("Product " + productID + " not found.");
  			}
  		}
  	}

  	/**
  	 * To input into follow up date for a product in Low Priority tab of Low Inventory
  	 * @param productID
  	 * @param date
  	 */
    public static void update_followUpDateColumn_lowPriority(String productID, String date) {
  		int count = Q_WebElm.xpCountTableRows(adminProps, "lowInventory.productID.low.list.xp");
  		System.out.println(count);
  		for (int index = 0; index < count; index++) {
  			if (Q_WebElm.listOfElements(adminProps, "lowInventory.productID.low.list.xp").get(index).getText().equals(productID)) {
  				Q_WebElm.listOfElements(adminProps, "lowInventory.followUpDate.low.datePicker.xp").get(index).clear();
  				Q_WebElm.listOfElements(adminProps, "lowInventory.followUpDate.low.datePicker.xp").get(index).sendKeys(date + Keys.TAB);
  				Q_WebElm.myWait(3000);
  				Q_WebElm.listOfElements(adminProps, "lowInventory.followUpDate.low.updateBtn.xp").get(index).click();
  				driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
  				try {
  					Q_WebElm.xpDisplayed(adminProps, "lowInventory.lowPrority.tab.xp");
  					System.out.println("The page did not load as expected");
  				} catch (Throwable exp)	{
  					Assert.fail("The page loaded unexpectedly.", exp);
  				}
  				Q_WebElm.myWait(1500);
  				System.out.println(Controls.checkAlert());
  				break;
  			}
  			else if (index == count-1)	{
  				Assert.fail("Product " + productID + " not found.");
  			}
  		}
  	}

  	/**
  	 * Verify the sorting in Follow Up Date column in High priority tab of Low Inventory
  	 * @param order
  	 * @throws ParseException
  	 */
  	public static void sortFollowUpDateColumn_highPriority(String order) throws ParseException {
  		int count = Q_WebElm.xpCountTableRows(adminProps, "lowInventory.productID.high.list.xp");
  		Q_WebElm.myWait(3000);
  		Controls.xpExecutorScrollToView(adminProps, "lowInventory.lowPrority.tab.xp");
  		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  		switch (order) {
  		case "ascending":
  			sortColumn_ascending(order, "lowInventory.followUpDate.high.header.xp");
  			for (int index = 0; index < count; index++) {
  				List<WebElement> followUpDate = Q_WebElm.listOfElements(adminProps,"lowInventory.followUpDate.high.datePicker.xp");
  				if (!followUpDate.get(index).getAttribute("value").isBlank() && index >= 1) {
  					String s1 = followUpDate.get(index).getAttribute("value"); // getting date as string from user
  					String s2 = followUpDate.get(index - 1).getAttribute("value");
  					System.out.println(s1 + "----" + s2);
  					Date d1 = dateFormat.parse(s1);
  					Date d2 = dateFormat.parse(s2);
  					Assert.assertTrue(d1.compareTo(d2) > 0||d1.compareTo(d2) == 0, "Sorting unsuccessful");
  				} 
  				else if (followUpDate.get(index).getAttribute("value").isBlank() && index!= 0) {
  					String s2 = "";
  					String s1 = followUpDate.get(index).getAttribute("value"); // getting date as string from user
  					if (index != count-1)
  						s2 = followUpDate.get(index + 1).getAttribute("value");
  					Assert.assertTrue(s1.isBlank());
  					Assert.assertTrue(s2.isBlank());
  					index++;
  				}
  			}
  			break;
  		case "descending":
  			sortColumn_descending(order, "lowInventory.followUpDate.high.header.xp");
  			for (int index = count - 1; index > 0; index--) {
  				List<WebElement> followUpDate = Q_WebElm.listOfElements(adminProps,"lowInventory.followUpDate.high.datePicker.xp");
  				if (!followUpDate.get(index - 1).getAttribute("value").isBlank()) {
  					String s1 = followUpDate.get(index - 1).getAttribute("value"); // getting date as string from user
  					String s2 = followUpDate.get(index).getAttribute("value");
  					System.out.println(s1 + "----" + s2);
  					Date d1 = dateFormat.parse(s1);
  					Date d2 = dateFormat.parse(s2);
  					Assert.assertTrue(d1.compareTo(d2) > 0, "Sorting unsuccessful");
  				} 
  				else if (followUpDate.get(index - 1).getAttribute("value").isBlank() && index!= count - 1) {
  					String s1 = followUpDate.get(index - 1).getAttribute("value"); // getting date as string from user
  					String s2 = followUpDate.get(index - 2).getAttribute("value");
  					Assert.assertTrue(s1.isBlank());
  					Assert.assertTrue(s2.isBlank());
  					index--;
  				}
  			}
  			break;
  		}
  	}

  	/**
  	 * Verify the sorting in Follow Up Date column in Low priority tab of Low Inventory
  	 * @param order
  	 * @throws ParseException
  	 */
  	public static void sortFollowUpDateColumn_lowPriority(String order) throws ParseException {
  		int count = Q_WebElm.xpCountTableRows(adminProps, "lowInventory.productID.low.list.xp");
  		Q_WebElm.myWait(3000);
  		Controls.xpExecutorScrollToView(adminProps, "lowInventory.lowPrority.tab.xp");
  		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  		switch (order) {
  		case "ascending":
  			sortColumn_ascending(order, "lowInventory.followUpDate.low.header.xp");
  			for (int index = 0; index < count; index++) {
  				List<WebElement> followUpDate = Q_WebElm.listOfElements(adminProps,"lowInventory.followUpDate.low.datePicker.xp");
  				if (!followUpDate.get(index).getAttribute("value").isBlank() && index >= 1) {
  					String s1 = followUpDate.get(index).getAttribute("value"); // getting date as string from user
  					String s2 = followUpDate.get(index - 1).getAttribute("value");
  					System.out.println(s1 + "----" + s2);
  					Date d1 = dateFormat.parse(s1);
  					Date d2 = dateFormat.parse(s2);
  					Assert.assertTrue(d1.compareTo(d2) > 0 || d1.compareTo(d2) == 0, "Sorting unsuccessful");
  				} 
  				else if (followUpDate.get(index).getAttribute("value").isBlank() && index!= 0) {
  					String s1 = followUpDate.get(index).getAttribute("value"); // getting date as string from user
  					String s2 = "";
  					if (index != count-1)
  						s2 = followUpDate.get(index + 1).getAttribute("value");
  					Assert.assertTrue(s1.isBlank());
  					Assert.assertTrue(s2.isBlank());
  					index++;
  				}
  			}
  			break;
  		case "descending":
  			sortColumn_descending(order, "lowInventory.followUpDate.low.header.xp");
  			for (int index= count - 1; index > 0; index--) {
  				List<WebElement> followUpDate = Q_WebElm.listOfElements(adminProps,"lowInventory.followUpDate.low.datePicker.xp");
  				if (!followUpDate.get(index - 1).getAttribute("value").isBlank()) {
  					String s1 = followUpDate.get(index - 1).getAttribute("value"); // getting date as string from user
  					String s2 = followUpDate.get(index).getAttribute("value");
  					System.out.println(s1 + "----" + s2);
  					Date d1 = dateFormat.parse(s1);
  					Date d2 = dateFormat.parse(s2);
  					Assert.assertTrue(d1.compareTo(d2) > 0, "Sorting unsuccessful");
  				} 
  				else if (followUpDate.get(index - 1).getAttribute("value").isBlank() && index!= count - 1) {
  					String s1 = followUpDate.get(index- 1).getAttribute("value"); // getting date as string from user
  					String s2 = followUpDate.get(index- 2).getAttribute("value");
  					Assert.assertTrue(s1.isBlank());
  					Assert.assertTrue(s2.isBlank());
  					index--;
  				}
  			}
  			break;
  		}
  	}

  	/**
  	 * Select priority tab in Low Inventory
  	 * @param priority
  	 */
  	public static void selectPriority(String priority) {
  		switch (priority) {
  		case "Low Priority":
  			Q_WebElm.myWait(6000);
  			Controls.xpExecutorScrollToView(adminProps, "lowInventory.multiplier.saveChangesBtn.xp");
  			Q_WebElm.xp(adminProps,"lowInventory.lowPrority.tab.xp");
  			Q_WebElm.myWait(7000);
  			break;
  		case "High Priority":
  			Q_WebElm.myWait(2000);
  			Q_WebElm.xp(adminProps, "lowInventory.highPrority.tab.xp");
  			break;
  		}
  	}

  	/**
  	 * Verify past date in Follow up date column is highlighted for low priority products
  	 * @throws ParseException
  	 */
  	public static void verifyHighlight_pastDate_lowPriority() throws ParseException {
  		int count = Q_WebElm.xpCountTableRows(adminProps, "lowInventory.productID.low.list.xp");
  		Q_WebElm.myWait(3000);
  		Controls.xpExecutorScrollToView(adminProps, "lowInventory.lowPrority.tab.xp");
  		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  		if (Q_WebElm.xpRetAttr(adminProps, "lowInventory.followUpDate.low.header.xp", "aria-sort").equals("descending")) {
  			Q_WebElm.xp(adminProps,"lowInventory.followUpDate.low.header.xp");
  		}
  		for (int index = 0; index < count; index++) {
  			String followUpDate = Q_WebElm.listOfElements(adminProps, "lowInventory.followUpDate.low.datePicker.xp").get(index).getAttribute("value");
  			if (!followUpDate.isBlank()) {
  				Date repodate = dateFormat.parse(followUpDate);
  				Date currDate = dateFormat.parse(dateFormat.format(new Date()));
  				if (currDate.compareTo(repodate) > 0) {
  					System.out.println(currDate);
  					System.out.println(repodate);
  					String productID = Q_WebElm.listOfElements(adminProps, "lowInventory.productID.low.list.xp").get(index).getAttribute("class");
  					Assert.assertTrue(productID.equals("highlight "));
  				} 
  				else {
  					String productID = Q_WebElm.listOfElements(adminProps, "lowInventory.productID.low.list.xp").get(index).getAttribute("class");
  					Assert.assertTrue(productID.isBlank());
  				}
  			} 
  			else
  				break;
  		}
  	}

  	/**
  	 * Verify past date in Follow up date column is highlighted for high priority products
  	 * @throws ParseException
  	 */
  	public static void verifyHighlight_pastDate_highPriority() throws ParseException {
  		int count = Q_WebElm.xpCountTableRows(adminProps, "lowInventory.productID.high.list.xp");
  		Q_WebElm.myWait(3000);
  		Controls.xpExecutorScrollToView(adminProps, "lowInventory.highPrority.tab.xp");
  		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  		if (Q_WebElm.xpRetAttr(adminProps, "lowInventory.followUpDate.high.header.xp", "aria-sort").equals("descending")) {
  			Q_WebElm.xp(adminProps,"lowInventory.followUpDate.high.header.xp");
  		}
  		for (int index = 0; index < count; index++) {
  			WebElement followUpDate = Q_WebElm.listOfElements(adminProps, "lowInventory.followUpDate.high.datePicker.xp").get(index);
  			if (!followUpDate.getAttribute("value").isBlank()) {
  				Date repodate = dateFormat.parse(followUpDate.getAttribute("value"));
  				Date currDate = dateFormat.parse(dateFormat.format(new Date()));
  				if (currDate.compareTo(repodate) > 0) {
  					System.out.println(currDate);
  					System.out.println(repodate);
  					String productID = Q_WebElm.listOfElements(adminProps, "lowInventory.productID.high.list.xp").get(index).getAttribute("class");
  					Assert.assertTrue(productID.equals("highlight "));
  				} 
  				else {
  					String productID = Q_WebElm.listOfElements(adminProps, "lowInventory.productID.high.list.xp").get(index).getAttribute("class");
  					Assert.assertTrue(productID.isBlank());
  				}
  			} 
  			else
  				break;
  		}
  	}

  	/**
  	 * Sorts the column in ascending order
  	 * @param order
  	 * @param locator
  	 */
  	public static void sortColumn_ascending(String order, String locator) {
  		Q_WebElm.xp(adminProps,locator);
  		Q_WebElm.myWait(5000);
  		String sort = Q_WebElm.xpRetAttr(adminProps, locator, "aria-sort");
  		System.out.println(sort);
  		Assert.assertTrue(sort.equals(order), "Sorting not applied");
  		Q_WebElm.myWait(3000);
  	}

  	/**
  	 * Sorts the column in descending order
  	 * @param order
  	 * @param locator
  	 */
  	public static void sortColumn_descending(String order, String locator) {
  		Q_WebElm.xp(adminProps,locator);
  		Q_WebElm.xp(adminProps,locator);
  		Q_WebElm.myWait(5000);
  		String sort1 = Q_WebElm.xpRetAttr(adminProps, locator, "aria-sort");
  		System.out.println(sort1);
  		Assert.assertTrue(sort1.equals(order), "Sorting not applied");
  		Q_WebElm.myWait(3000);
  	}
  	// JMB-6721 End
 	
 	//JMB-6718 Start
	/**********************************************************************
	* // * Description: Read only size from xpath locator  
	* // * Param: String 
	* // * Status: Complete
	**********************************************************************/
    public int retXpSize(Properties proper, String locator){
        List<WebElement> values =driver.findElements(By.xpath(proper.getProperty(locator)));
        System.out.println(values.size());
        return values.size();
    }
	/**********************************************************************
	 * // * Description: Verify presence of JM, Silver & PM 
	 * // * Param: NA 
	 * // * Jira Ticket: JMB-6718 
	 * // * Status: Complete
	 **********************************************************************/
    public void verifyDisplayJMPMSilverProductPage() {
		String StatusJM = Q_WebElm.xpRetText(adminProps, "jm.statusJMB.xp");
		// Verify Display of JMB in top of the column
		if ((StatusJM.contains("Status")) && (StatusJM.contains("JMB"))) {
			System.out.println("JMB is Displayed in productstock page");
		} else {
			Assert.fail("JMB is not Displayed in productstock page");
		}
		// Verify Display of Silver in top of the column
		String StatusSilver = Q_WebElm.xpRetText(adminProps, "jm.statusSilver.xp");
		if ((StatusSilver.contains("Status")) && (StatusSilver.contains("Silver"))) {
			System.out.println("PM is Displayed in productstock page");
		} else {
			Assert.fail("Silver is not Displayed in productstock page");
		}
		// Verify Display of PM in top of the column
		String StatusPM = Q_WebElm.xpRetText(adminProps, "jm.statusPM.xp");
		if ((StatusPM.contains("Status")) && (StatusPM.contains("Prov."))) {
			System.out.println("JMB is Displayed in productstock page");
		} else {
			Assert.fail("PM is not Displayed in productstock page");
		}
    }
	/**********************************************************************
	 * // * Description: Verify all OOS product selected in Product stock screen and the same has been moved to ignore product stock screen 
	 * // * Param: String 
	 * // * Jira Ticket: JMB-6718 
	 * // * Status: Complete
	 * @return 
	 **********************************************************************/  
	public String verifyOOSProductStock() {
		int total = retXpSize(adminProps, "jm.readStatusofSites.productStock.xp");
		System.out.println("Total list " + total);
		List<String> status = new ArrayList<String>();
		String iorder_no,ordernumber = null;
		int flag = 0, size = 0, flag1 = 0, flag2 = 0;
		for (int index = 1; index <= total; index++) {
			ordernumber = Q_WebElm.xpRetText(adminProps, "jm.readorder.xp.beg", index, "jm.readorder.xp.end");
			for (int count = 1; count <= 3; count++) {
				status.add(Q_WebElm.xpRetText(adminProps, "jm.readStatusofSites.xp.beg", index,
						"jm.readStatusofSites.xp.end"));
				System.out.println("Status of JMB/Silver/PM: " + status.get(flag2));
				index++;
				flag2++;
			}
			for (int index1 = 0; index1 < status.size(); index1++) {
				if (status.get(index1).contains("outofstock")) {
					if (!Q_WebElm.xpSelected(adminProps, "jm.statuscheckbox.xp.beg", index1 + 1,
							"jm.statuscheckbox.xp.end")) {
						Q_WebElm.xp(adminProps, "jm.statuscheckbox.xp.beg", index1 + 1, "jm.statuscheckbox.xp.end");
						Q_WebElm.myWait(6000);
						Controls.checkAlert();
					} else if (Q_WebElm.xpSelected(adminProps, "jm.statuscheckbox.xp.beg", index1 + 1,
							"jm.statuscheckbox.xp.end")) {
						Q_WebElm.xp(adminProps, "jm.statuscheckbox.xp.beg", index1 + 1, "jm.statuscheckbox.xp.end");
						Q_WebElm.myWait(6000);
						Controls.checkAlert();
						Q_WebElm.xp(adminProps, "jm.statuscheckbox.xp.beg", index1 + 1, "jm.statuscheckbox.xp.end");
						Q_WebElm.myWait(6000);
						Controls.checkAlert();
					}
					flag1++;
				}
			}
			System.out.println("order number is " + ordernumber);
			Q_WebElm.xp(adminProps, "jm.ignoredproductstocktab.xp");
			size = retXpSize(adminProps, "jm.ignorestocksize.xp");
			for (int index1 = 0; index1 <= size; index1++) {
				iorder_no = Q_WebElm.xpRetText(adminProps, "jm.ignorestockorderno.xp.beg", index1 + 1,
						"jm.ignorestockorderno.xp.end");
				if (iorder_no.equals(ordernumber)) {
					System.out.println(
							"Order number " + ordernumber + " is shown as expected under Ignored Product Stock");
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				Assert.fail("Order number " + ordernumber + " is not shown as expected under Ignored Product Stock");
			}
			status.clear();
			flag2 = 0;
			if (flag1 >= 1) {
				break;
			}
		}
		return ordernumber;
	}
	
	/**********************************************************************
	 * Description: Verify all OOS product selected in ignore product stock screen and the same has been moved to Product stock screen
	 * Param: String
	 * Jira Ticket: JMB-6718 
	 * Status: Complete
	 **********************************************************************/

	public void removeOOSIgnoredProductStock(String ordernumber)  {
		int total = retXpSize(adminProps, "jm.readStatusofSites.productStock.xp");
		System.out.println("Total list " + total);
		List<String> status = new ArrayList<String>();
		int sum = total;
		String iorder_no;
		int flag = 0, flag1 = 0, flag2 = 0;
		for (int index = total; index >= 0; index--) {
			for (int count = 1; count <= 3; count++) {
				status.add(Q_WebElm.xpRetText(adminProps, "jm.readStatusofSites.xp.beg", index,
						"jm.readStatusofSites.xp.end"));
				System.out.println("Status of JMB/Silver/PM: " + status.get(flag2));
				index--;
				flag2++;
			}
			for (int index1 = 0; index1 < status.size(); index1++) {
				if (status.get(index1).contains("outofstock")) {
					Q_WebElm.xp(adminProps, "jm.statuscheckbox.xp.beg", sum, "jm.statuscheckbox.xp.end");
					Q_WebElm.myWait(6000);
					Controls.checkAlert();
					flag1++;
				}
				sum--;
			}
			System.out.println("order number is " + ordernumber);
			int total_count = retXpSize(adminProps, "jm.readorder.xp");
			Q_WebElm.xpExecutor(adminProps, "jm.productStock.xp");
			for (int index2 = 0; index2 <= total_count; index2++) {
				iorder_no = Q_WebElm.xpRetText(adminProps, "jm.readorder.xp.beg", index2 + 1, "jm.readorder.xp.end");
				if (iorder_no.equals(ordernumber)) {
					System.out
							.println("Order number " + ordernumber + " is shown as expected under Product Stock page");
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				Assert.fail("Order number " + ordernumber + " is not shown as expected under Ignored Product Stock");
			}
			status.clear();
			flag2 = 0;
			if (flag1 >= 1) {
				break;
			}
		}
	}

	/**********************************************************************
	 * Description: Select instock product in Product stock screen and verify it is not moved to any other screen 
	 * Param: String 
	 * Jira Ticket: JMB-6718
	 * Status: Complete
	 **********************************************************************/
	public void verifyISProductStock(String ordernumber) {
		int total = retXpSize(adminProps, "jm.readStatusofSites.productStock.xp");
		System.out.println("Total list " + total);
		List<String> status = new ArrayList<String>();
		String iorder_no;
		int flag = 0, flag1 = 0, flag2 = 0;
		for (int index = 1; index <= total; index++) {
			ordernumber = Q_WebElm.xpRetText(adminProps, "jm.readorder.xp.beg", index, "jm.readorder.xp.end");
			for (int count = 1; count <= 3; count++) {
				status.add(Q_WebElm.xpRetText(adminProps, "jm.readStatusofSites.xp.beg", index,
						"jm.readStatusofSites.xp.end"));
				System.out.println("Status of JMB/Silver/PM: " + status.get(flag2));
				index++;
				flag2++;
			}
			for (int index1 = 0; index1 < status.size(); index1++) {
				if (status.get(index1).contains("instock")) {
					if (!Q_WebElm.xpSelected(adminProps, "jm.statuscheckbox.xp.beg", index1 + 1,
							"jm.statuscheckbox.xp.end")) {
						Q_WebElm.xp(adminProps, "jm.statuscheckbox.xp.beg", index1 + 1, "jm.statuscheckbox.xp.end");
						Q_WebElm.myWait(6000);
						Controls.checkAlert();
					} else if (Q_WebElm.xpSelected(adminProps, "jm.statuscheckbox.xp.beg", index1 + 1,
							"jm.statuscheckbox.xp.end")) {
						Q_WebElm.xp(adminProps, "jm.statuscheckbox.xp.beg", index1 + 1, "jm.statuscheckbox.xp.end");
						Q_WebElm.myWait(6000);
						Controls.checkAlert();
						Q_WebElm.xp(adminProps, "jm.statuscheckbox.xp.beg", index1 + 1, "jm.statuscheckbox.xp.end");
						Q_WebElm.myWait(5000);
						Controls.checkAlert();
					}
					flag1++;
				}
			}
			System.out.println("order number is " + ordernumber);
			int total_count = retXpSize(adminProps, "jm.readorder.xp");
			for (int index1 = 0; index1 <= total_count; index1++) {
				iorder_no = Q_WebElm.xpRetText(adminProps, "jm.readorder.xp.beg", index1 + 1, "jm.readorder.xp.end");
				if (iorder_no.equals(ordernumber)) {
					System.out
							.println("Order number " + ordernumber + " is shown as expected under Product Stock page");
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				Assert.fail("Order number " + ordernumber + " is not shown as expected under Ignored Product Stock");
			}
			status.clear();
			flag2 = 0;
			if (flag1 >= 1) {
				break;
			}
		}
	}
	//JMB-6718 End
	//JMB-6942 Start
	/**
	 * Select product for ASE report
	 * 
	 * @param product
	 */
	public void productSelection(String product) {
		Q_WebElm.xp(adminProps, "repo.productDropdown.xp");
		Q_WebElm.myWait(2000);
		Q_WebElm.xpSend(adminProps, "repo.productDesc.xp", product + Keys.TAB);
		Q_WebElm.myWait(2000);
	}

	/**
	 * To select the date range for the report generation
	 * 
	 * @param startDate
	 */
	public void dateSelection(String startDate) {
		Q_NewFeatures nfal = new Q_NewFeatures();
		//formInput("repo.startDate.xp", startDate + Keys.ENTER);
		Q_WebElm.xpClear(adminProps, "repo.startDate.xp");
		Q_WebElm.xpSend(adminProps, "repo.startDate.xp", startDate + Keys.ENTER);
		nfal.webElement(adminProps, "repo.endDate.xp").sendKeys(Keys.ENTER);
	}

	/**
	 * Searches for the product report and verify if the data is displayed
	 */
	public void searchData_ASEReport() {
		Q_WebElm.myWait(2000);
		Q_WebElm.id(adminProps, "fe.finishAndPlace.id");
		Q_WebElm.myWait(2000);
		Assert.assertTrue(Q_WebElm.xpRetAttr(adminProps, "repo.tableTotal.xp", "innerHTML").split("&nbsp")[0]
				.contains("Total: "), "Data not displayed");
	}

	/**
	 * Downloads CSV for product admin lookout
	 */
	public void downloadProductReportCSV() {
		Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps, "repo.downloadCsvBtn.xp"));
		Q_WebElm.xp(adminProps, "repo.downloadCsvBtn.xp");
		Q_WebElm.myWait(6000);
	}

	/**
	 * Read and compare csv file if it matches the displayed data
	 * 
	 * @param downloadPath
	 * @param fileName
	 * @throws IOException
	 * @throws CsvException
	 */
	public void verifyProductReportCSVContentMatchesAdmin(String downloadPath, String fileName) throws IOException, CsvException {
		int countOfRows = rowCount("repo.noOfTableRows.xp");
		int countOfColumns = rowCount("repo.noOfTableColumns.xp");
		String[][] arrlist = new String[countOfRows][(countOfColumns - 1)];
		for (int row = 0; row < countOfRows; row++) {
			for (int column = 0; column < countOfColumns - 1; column++) {
				arrlist[row][column] = Q_WebElm.xpRetText(adminProps, "repo.tableRow.beg.xp", row + 1, "repo.tableRow.mid.xp",column + 2, "adm.repoNum.end.xp");
			}
		}
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		for (int file = 0; file < dirContents.length; file++) {
			if (dirContents[file].getName().contains(fileName)) {
				System.out.println(downloadPath + "//" + dirContents[file].getName());
				CSVReader reader = new CSVReader(new FileReader(downloadPath + "//" + dirContents[file].getName()));
				List<String[]> li = reader.readAll();
				System.out.println("Total rows which we have is " + li.size() + " on csv.");
				Assert.assertEquals(li.size()-1, countOfRows);
				Iterator<String[]> i1 = li.iterator();
				while (i1.hasNext()) {
					String[] str;
					for (int row = 0; row < countOfRows; row++) {
						if (row == 0) {
							str = i1.next();
						}
						str = i1.next();
						for (int column = 0; column < str.length; column++) {
							Assert.assertEquals(str[column], arrlist[row][column]);
						}
					}
				}
				reader.close();
			}
		}
	}

	/**
	 * Deletes the existing file in the local directory with the given path and
	 * required file name.
	 * 
	 * @param downloadPath
	 * @param fileName
	 */
	public void existingFileDelete(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		for (int file = 0; file < dirContents.length; file++) {
			if (dirContents[file].getName().contains(fileName)) {
				System.out.println(dirContents[file].getName());
				dirContents[file].delete();
			}
		}
	}
	//JMB-6942 Ends
	
	//JMB-7042 Starts
    /******************************************************************
    // * Description: Verify Hedge page Palladium values
    // * Param : NA
    // * Jira Ticket: JMB 7042 
    // * Status: Complete
    //*******************************************************************/  
    
    public void verifyHedgePalladiumInvetoryWithOffset() {
    	String inventoryValue=Q_WebElm.xpRetText(adminProps, "jm.inventoryPalladium.xp").replace(",","" );
    	String contractOffset=Q_WebElm.xpRetText(adminProps, "jm.contractOffsetPalladium.xp");
    	double value=Double.parseDouble(inventoryValue);
    	double valueofInventory=(value/100)*-1;
    	double valueofContractOffset=Double.parseDouble(contractOffset.replace("(Short)", "")); 
    	System.out.println(valueofInventory);
    	System.out.println(valueofContractOffset);
    	Assert.assertEquals(valueofInventory, valueofContractOffset,"Values are not matched!");
		System.out.println("The values are equal");

    }
    //JMB-7042 Ends
    
    //JMB-7045 Start
    /******************************************************************
    // * Description: Verify Force each product to have a min and a max inventory
    // * Param : NA
    // * Jira Ticket: JMB 7045 
    // * Status: Complete
    //*******************************************************************/      
    public void verifyProductMinAndMaxInventory(int min, int max) {
    	String stockStatusJM=xpRetSelectedText(adminProps, "jm.stockStatusJM.xp");
    	System.out.println(stockStatusJM);
    	String stockStatusSIL=xpRetSelectedText(adminProps, "jm.stockStatusSIL.xp");
    	System.out.println(stockStatusSIL);
    	String stockStatusPM=xpRetSelectedText(adminProps, "jm.stockStatusPM.xp");
    	System.out.println(stockStatusPM);
    	if(stockStatusJM.contains("In stock")||stockStatusSIL.contains("In stock")||stockStatusPM.contains("In stock")) {
    		if(min==0 && max==0) {
    			Q_WebElm.xpClear(adminProps, "jm.minInventory.xp");
    			Q_WebElm.xpSendInteger(adminProps, "jm.minInventory.xp", min);  			
    			Q_WebElm.xpClear(adminProps, "jm.maxInventory.xp");
    			Q_WebElm.xpSendInteger(adminProps, "jm.maxInventory.xp", max);
        		formXp("jm.saveChanges.xp");
        		Q_WebElm.myWait(3000);
        		String altMsg=li.checkAndGetAlertText();
        		Assert.assertEquals(altMsg, "Max Inventory has to be greater than or equal to Min or 1!", "Alert message is not match");
        		System.out.println("Alert present and the error messgae displayed correctly");
    		}
    		else if(min>max) {
    			Q_WebElm.xpClear(adminProps, "jm.minInventory.xp");
    			Q_WebElm.xpSendInteger(adminProps, "jm.minInventory.xp", min);			
    			Q_WebElm.xpClear(adminProps, "jm.maxInventory.xp");
    			Q_WebElm.xpSendInteger(adminProps, "jm.maxInventory.xp", max);
        		formXp("jm.saveChanges.xp");
        		String altMsg=li.checkAndGetAlertText();
        		Assert.assertEquals(altMsg, "Max Inventory has to be greater than or equal to Min or 1!", "Alert message is not match");
        		System.out.println("Alert present and the error messgae displayed correctly");
        	}
    		else if(min<=max) {
    			Q_WebElm.xpClear(adminProps, "jm.minInventory.xp");
    			Q_WebElm.xpSendInteger(adminProps, "jm.minInventory.xp", min);
    			Q_WebElm.xpClear(adminProps, "jm.maxInventory.xp");
    			Q_WebElm.xpSendInteger(adminProps, "jm.maxInventory.xp", max);
            	Q_WebElm.myWait(3000);
        		formXp("jm.saveChanges.xp");
            	Q_WebElm.myWait(5000);
        		driver.navigate().refresh();
        		int liveMin=Integer.parseInt(Q_WebElm.xpRetAttr(adminProps, "jm.minInventory.xp", "value"));
        		System.out.println(liveMin);
        		int liveMax=Integer.parseInt(Q_WebElm.xpRetAttr(adminProps, "jm.maxInventory.xp", "value"));
        		System.out.println(liveMax);
        		Assert.assertEquals(min, liveMin , "The given min Inventory value not updated");
        		System.out.println("min Inventory updated successfully with the given value");
        		Assert.assertEquals(max, liveMax , "The given max Inventory value not updated");
        		System.out.println("max Inventory updated successfully with the given value");
    		}
        }
    	else
    		Assert.fail("No In stock found for the product");
    }
	/********************************************************************
	 * // * Description: Read Text from Selected Option
	 * // * Param: String 
	 * // * Status: Complete 
	 *******************************************************************/   
    public static String xpRetSelectedText(Properties proper, String locator) {

        Select supplier = new Select(driver.findElement(By.xpath(proper.getProperty(locator))));
        WebElement option = supplier.getFirstSelectedOption();

        return option.getText();
    }
	/********************************************************************
	 * // * Description: Verify alert present in a page 
	 * // * Param: long 
	 * // * Status: Complete 
	 *******************************************************************/   
    public Boolean xpIsAlertPresent(long timeOutInSeconds) {
    	try {
    		new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
    		return true;
    	} catch(TimeoutException ex) {
    		return false;   		
    	}
    }
	/********************************************************************
	 * // * Description: Generate random number 
	 * // * Param: NA 
	 * // * Status: Complete 
	 *******************************************************************/   
    public int[] twoRandomNumGenWithInRange()
    {
    	int min=1,max=50,min1=51,max1=100;
    	int[] random = new int[3];
    	random[0] = (int)Math.floor(Math.random()*(max-min+1)+min);
    	System.out.println("random[0]"+random[0]);
    	random[1] = (int)Math.floor(Math.random()*(max1-min1+1)+min1); 	
    	System.out.println("random[1]"+random[1]);
    
		return random;
    }
    //JMB-7045 End
    
    //JMB-6896 Start
  	/**
  	 * Download Low Inventory csv report
  	 */
  	public void downloadLowInventoryCSV() {
  		Q_WebElm.xp(adminProps, "lowInventory.downloadCSV.xp");
  		Q_WebElm.myWait(6000);
  	}

  	/**
  	 * Gets Product ID & FollowUp date to compare with the values in downloaded csv
  	 * report based on high & low priority products.
  	 * 
  	 * @param priority
  	 * @param downloadPath
  	 * @param fileName
  	 * @throws CsvException
  	 */
  	public void verifyLowInventoryReportCSV(String priority, String downloadPath, String fileName) throws CsvException {
  		List<WebElement> tableData = driver.findElements(By.xpath("//div[@id='" + priority + "']//tbody/tr/td[9]/input"));
  		int index, countOfRows = tableData.size();
  		LinkedHashMap<Object, Map<String, String>> outerMap = new LinkedHashMap<>();
  		Map<String, String> innerMap;
  		String productId, columnValue;
  		for (index = 0; index < countOfRows; index++) {
  			productId = ""; 	// Clear out productId for each iteration
  			innerMap = new LinkedHashMap<String, String>();
  			columnValue = tableData.get(index).getAttribute("value");
  			if (columnValue.isEmpty())
  				break;
  			System.out.println(tableData.get(index).getAttribute("value"));
  			innerMap.put("Date", columnValue);
  			if (priority.equalsIgnoreCase("high"))
  				productId = Q_WebElm.listOfElements(adminProps, "lowInventory.productID.high.list.xp").get(index).getText();
  			else
  				productId = Q_WebElm.listOfElements(adminProps, "lowInventory.productID.low.list.xp").get(index).getText();
  			System.out.println(productId);
  			outerMap.put(productId, innerMap);
  		}
  		System.out.println(outerMap.values());
  		System.out.println(outerMap.keySet());
  		File dir = new File(downloadPath);
  		File[] dirContents = dir.listFiles();
  		for (int file = 0; file < dirContents.length; file++) {
  			if (dirContents[file].getName().contains(fileName)) {
  				System.out.println(downloadPath + "//" + dirContents[file].getName());
  				for (Entry<Object, Map<String, String>> set : outerMap.entrySet()) {
  					System.out.println(set.getKey() + " = " + set.getValue());
  					try {
  						FileReader fileReader = new FileReader(downloadPath + "//" + dirContents[file].getName());
  						CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
  						List<String[]> allData = csvReader.readAll();
  						for (String[] row : allData) {
  							if (set.getKey().toString().equals(row[0])) {
  								Assert.assertTrue(set.getValue().toString().contains(row[9]));
  								System.out.println(row[0] + "\t" + row[9]);
  								break;
  							}
  						}
  						csvReader.close();
  						fileReader.close();
  					} catch (Exception e) {
  						System.out.println(e);
  					}
  				}
  			}
  		}
  	}
  	//JMB-6896 End
  	
  	//Start JMB-6460
  	/********************************************************************
  	 * Description: Verify admin product error log by run cron job 
  	 * Param: String
  	 * Author: Tamilselvan
  	 * Status: Complete 
  	 *******************************************************************/   
      public void verifyAdminProductErrorLogByCron(String prodID) {
      	driver.get("https://qa.jmbullion.com/admin/amark_api/product-modify-cron.php");
  		String msg=Q_WebElm.xpRetText(adminProps, "jm.getErrorMsg.xp");
  		Assert.assertTrue(msg.contains(prodID), "Update unsuccessful for the product ID: "+prodID +"& verify the error in the following link: https://qa.jmbullion.com/admin/product-update-log.php");
  		Assert.assertTrue(msg.contains("\"error\":0,\"message\""), "Error found on change details for the product ID: "+prodID+"& verify the error in the following link: https://qa.jmbullion.com/admin/product-update-log.php");
  		System.out.println("Product updated sucessfully: " + msg);
      }
      //End JMB-6460
      
    //JMB-6938 Start
  	/****************************************************************************
  	* Description: Verify “Supplier Premium”, “Silver Premium”,“PM Premium”, and
  	* “JM Premium” fields are displayed on Add Product page
  	* Author: Asfi.Khaliq
  	* Param: None
  	* Returns: None
  	* Status: Complete
  	****************************************************************************/
  	public void verifyJmPrem_supplierPrem_silver_Prem_pmPrem_areDisplayed_addProdPage()	{
  		Q_WebElm.xpDisplayed(adminProps, "prod.createProd.supplierPrem.xp");
  		Q_WebElm.xpDisplayed(adminProps, "prod.createProd.silverPrem.xp");
  		Q_WebElm.xpDisplayed(adminProps, "prod.createProd.jmPrem.xp");
  		Q_WebElm.xpDisplayed(adminProps, "prod.createProd.pmPrem.xp");
  		System.out.println("Supplier Premium, Silver Premium, PM Premium, and JM Premium fields are displayed. "
  				+ "Verification of the Add Product Page is successful");
  	}
  	
  	/*****************************************************************************
  	 * Description: Add & save required details to create a product of desired 
  	 * metal type
  	 * Author: Asfi.Khaliq
  	 * @param title
  	 * @param sku
  	 * @param metalType
  	 * @param weight
  	 * @param units
  	 * @param supplierPrem
  	 * @param silverPrem
  	 * @param jmPrem
  	 * @param pmPrem
  	 * Returns: None
  	 * Status: Complete
  	 *****************************************************************************/
  	public void createProduct(String title, String sku, String metalType, String weight, String units,
  			String supplierPrem, String silverPrem, String jmPrem, String pmPrem) {
  		System.out.println("Adding details to create a product " + title);
  		Q_WebElm.idClear(adminProps, "prod.createProd.title.id");
  		Q_WebElm.idSend(adminProps, "prod.createProd.title.id", title);
  		Q_WebElm.idClear(adminProps, "prod.createProd.sku.id");
  		Q_WebElm.idSend(adminProps, "prod.createProd.sku.id", sku);
  		switch (metalType) {
  		case "Silver":
  			Q_WebElm.listOfElements(adminProps, "prod.createProd.metalTypeList.xp").get(0).click();
  			break;
  		case "Gold":
  			Q_WebElm.listOfElements(adminProps, "prod.createProd.metalTypeList.xp").get(1).click();
  			break;
  		case "Copper":
  			Q_WebElm.listOfElements(adminProps, "prod.createProd.metalTypeList.xp").get(2).click();
  			break;
  		case "Platinum":
  			Q_WebElm.listOfElements(adminProps, "prod.createProd.metalTypeList.xp").get(3).click();
  			break;
  		case "Palladium":
  			Q_WebElm.listOfElements(adminProps, "prod.createProd.metalTypeList.xp").get(4).click();
  			break;
  		}
  		Q_WebElm.idClear(adminProps, "prod.createProd.weight.id");
  		Q_WebElm.idSend(adminProps, "prod.createProd.weight.id", weight);
  		Q_WebElm.idClear(adminProps, "prod.createProd.units.id");
  		Q_WebElm.idSend(adminProps, "prod.createProd.units.id", units);
  		Q_WebElm.listOfElements(adminProps, "prod.createProd.supplierPrem.xp").get(1).sendKeys(supplierPrem);
  		Q_WebElm.listOfElements(adminProps, "prod.createProd.silverPrem.xp").get(1).sendKeys(silverPrem);
  		Q_WebElm.listOfElements(adminProps, "prod.createProd.jmPrem.xp").get(1).sendKeys(jmPrem);
  		Q_WebElm.listOfElements(adminProps, "prod.createProd.pmPrem.xp").get(1).sendKeys(pmPrem);
  		Q_WebElm.xp(adminProps, "prod.prodPage.save.xp");
  		Q_WebElm.myWait(4000);
  		System.out.println(title + " of " + metalType + "type added successfully.");
  	}
  	
  	/*******************************************************************************
  	 * Description: Verify “Supplier Premium”, “Silver Premium”, “PM Premium”, and
  	 * “JM Premium” values are the same as the values given while creating the 
  	 * product.
  	 * Author: Asfi.Khaliq
  	 * @param supplierPrem
  	 * @param silverPrem
  	 * @param jmPrem
  	 * @param pmPrem
  	 * Returns: None
  	 * Status: Complete
  	 ******************************************************************************/
  	public void verifyProductPremiums(String supplierPrem, String silverPrem, String jmPrem, String pmPrem)	{
  		Assert.assertEquals(Q_WebElm.idAttrRet(adminProps, "prod.jmPremium.id", "value"), jmPrem);
  		Assert.assertEquals(Q_WebElm.idAttrRet(adminProps, "prod.supplierPremium.id", "value"), supplierPrem);
  		Assert.assertEquals(Q_WebElm.idAttrRet(adminProps, "prod.silverPremium.id", "value"), silverPrem);
  		Assert.assertEquals(Q_WebElm.idAttrRet(adminProps, "prod.providentPremium.id", "value"), pmPrem);
  		System.out.println("Supplier Premium, Silver Premium, PM Premium, and JM Premium fields with correct values are displayed.");
  	}
  	//JMB-6938 End
  	
  	//JMB-6968 Start
  	/**
  	 * To input note for any of the product based on the product id from JMB/Silver/PM on Product List page
  	 * @param site
  	 * @param productID
  	 * @param note
  	 */
  	public void updateNotes_productStatusList(String site, String productID, String note) {
  		switch (site) {
  		case "JMB":
  			int count = Q_WebElm.xpCountTableRows(adminProps, "prod.statusList.jmbID.list.xp");
  			System.out.println(count);
  			for (int index = 0; index < count; index++) {
  				if (Q_WebElm.listOfElements(adminProps, "prod.statusList.jmbID.list.xp").get(index).getText().equals(productID)) {
  					Q_WebElm.listOfElements(adminProps, "prod.statusList.inputNote.list.xp").get(index).clear();
  					Q_WebElm.listOfElements(adminProps, "prod.statusList.inputNote.list.xp").get(index).sendKeys(note);
  					Q_WebElm.myWait(3000);
  					Q_WebElm.listOfElements(adminProps, "prod.statusList.inputNote.updateBtn.list.xp").get(index).click();
  					driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
  					try {
  						Q_WebElm.xpDisplayed(adminProps, "prod.statusList.csvDownloadBtn.xp");
  						System.out.println("The page did not load as expected");
  					} catch (Throwable exp) {
  						Assert.fail("The page loaded unexpectedly.", exp);
  					}
  					Q_WebElm.myWait(1500);
  					System.out.println(Controls.checkAlert());
  					break;
  				}
  				else if (index == count-1)	{
  	  				Assert.fail("Product " + productID + " not found.");
  	  			}
  			}
  		}
  	}
  	
  	/**
  	 * To clear product by hitting Clear product on Product List page
  	 * @param site
  	 * @param productID
  	 */
  	public void clearProduct_productStatusList(String site, String productID) {
  		switch (site) {
  		case "JMB":
  			int count = Q_WebElm.xpCountTableRows(adminProps, "prod.statusList.jmbID.list.xp");
  			System.out.println(count);
  			for (int index = 0; index < count; index++) {
  				if (Q_WebElm.listOfElements(adminProps, "prod.statusList.jmbID.list.xp").get(index).getText().equals(productID)) {
  					Q_WebElm.listOfElements(adminProps, "prod.statusList.clearProductBtn.xp").get(index).click();
  					driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
  					try {
  						Q_WebElm.xpDisplayed(adminProps, "prod.statusList.csvDownloadBtn.xp");
  						System.out.println("The page did not load as expected");
  					} catch (Throwable exp) {
  						Assert.fail("The page loaded unexpectedly.", exp);
  					}
  					Q_WebElm.myWait(1500);
  					System.out.println(Controls.checkAlert());
  					break;
  				}
  				else if (index == count-1)	{
  	  				Assert.fail("Product " + productID + " not found.");
  	  			}
  			}
  		}
  	}
  	//JMB-6968 End
  	
  	//JMB-7075 Start
  	/*******************************************************************************
  	 * Description: Verify difference between values of Prior prem & Blended Prem 
  	 * on Supplier Log page of the product.
  	 * Author: Asfi.Khaliq
  	 * Returns: None
  	 * Status: Complete
  	 ******************************************************************************/
  	public void productSupplierLog()	{
  		formXp("prod.supplierLog.xp");
  		Controls.switchWin();
  		Assert.assertNotEquals(strXpText("prod.supplierLog.priorPrem.xp"), strXpText("prod.supplierLog.BlendedPrem.xp"),
  				"Both Premiums are same. Premium Blender not Working.");
  		System.out.println("Difference found between values of Prior prem & Blended Prem.");
  	}
  	//JMB-7075 End
  	
  	//JMB-7183 Start
  	/*******************************************************************************
  	 * Description: Verify all column headers on Inventory Age Report.
  	 * Author: Asfi.Khaliq
  	 * Returns: None
  	 * Status: Complete
  	 ******************************************************************************/
  	public void verifyColumnNames_invAgeReport()	{
  		Assert.assertEquals(Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.columnNamesList.xp").get(0).getText(), "ID");
  		Assert.assertEquals(Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.columnNamesList.xp").get(1).getText(), "Name");
  		Assert.assertEquals(Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.columnNamesList.xp").get(2).getText(), "SKU");
  		Assert.assertEquals(Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.columnNamesList.xp").get(3).getText(), "Metal Type");
  		Assert.assertEquals(Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.columnNamesList.xp").get(4).getText(), "Min");
  		Assert.assertEquals(Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.columnNamesList.xp").get(5).getText(), "Max");
  		Assert.assertEquals(Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.columnNamesList.xp").get(7).getText(), "30 Day Sales");
  		Assert.assertEquals(Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.columnNamesList.xp").get(8).getText(), "60 Day Sales");
  		Assert.assertEquals(Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.columnNamesList.xp").get(9).getText(), "90 Day Sales");
  		Assert.assertEquals(Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.columnNamesList.xp").get(10).getText(), "Weight");
  		Assert.assertEquals(Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.columnNamesList.xp").get(11).getText(), "Month's In Hand vs 30 Day Sales");
  		Assert.assertEquals(Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.columnNamesList.xp").get(12).getText(), "Month's In Hand vs 60 Day Sales");
  		Assert.assertEquals(Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.columnNamesList.xp").get(13).getText(), "Month's In Hand vs 90 Day Sales");
  		Assert.assertEquals(Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.columnNamesList.xp").get(14).getText(), "Current Price");
  		Assert.assertEquals(Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.columnNamesList.xp").get(15).getText(), "Qty in Repo");
  		System.out.println("All required columns' header verified.");
  	}
  	
  	/*******************************************************************************
  	 * Description: Verify that all Spot column values have not more than 2 decimal
  	 * places.
  	 * Author: Asfi.Khaliq
  	 * Returns: None
  	 * Status: Complete
  	 ******************************************************************************/
  	public void verifyAllSpotPrices_invAgeReport()	{
  		int rowCount=rowCount("reporting.invAgeReport.spotPriceList.xp");
  		System.out.println(rowCount);
  		List<WebElement> spotValueList= Q_WebElm.listOfElements(adminProps, "reporting.invAgeReport.spotPriceList.xp");
  		int integerPlaces;
  		int decimalPlaces;
  		for (int rowIndex = 1; rowIndex < rowCount; rowIndex++)	{
  			String spotValue= spotValueList.get(rowIndex).getText();
  			integerPlaces = spotValue.indexOf('.');
  			decimalPlaces = spotValue.length() - integerPlaces - 1;
  			Assert.assertEquals(decimalPlaces, 2, "Spot column does not comply to condition of 2 decimal places.");
  			if (rowIndex == rowCount-1)	{
  				System.out.println("All Spot column values have no more than 2 decimal places.");
  			}
  		}
  	}
  	//JMB-7183 End
  	
  	//JMB-6842 Start
  	/********************************************************************
  	 * Description: verify Newly created Product status
  	 * Author: Tamilselvan
  	 * Param: NA 
  	 * Status: Complete 
  	 *******************************************************************/   
     public void verifyOosDefaultNewProduct() {
      	String jmStatus=xpRetSelectedText(adminProps, "jm.jmProductStatus.xp");
  		System.out.println("JM Product Status: "+jmStatus);
  		String pmStatus=xpRetSelectedText(adminProps, "jm.pmProductStatus.xp");
  		System.out.println("PM Product Status: "+pmStatus);
  		String silStatus=xpRetSelectedText(adminProps, "jm.silProductStatus.xp");
  		System.out.println("SIL Product Status: "+silStatus);
  		Assert.assertTrue(jmStatus.contains("Out of stock"), "JM Product status is not OOS");
  		Assert.assertTrue(pmStatus.contains("Out of stock"), "PM Product status is not OOS");
  		Assert.assertTrue(silStatus.contains("Out of stock"), "Silver Product status is not OOS");

    }
    //End JMB-6842
      
    //JMB-7214 Start
  	/***************************************************************
  	 * Description: Select payment method for auto buy checkout 
  	 * Author: Asfi Khaliq
  	 * Param: String site, String productID
  	 * Returns: None 
  	 * Status: Complete
  	 **************************************************************/
  	public void selectNeedsContent_productStatusList(String site, String productID) {
  		switch (site) {
  		case "JMB":
  			int count = Q_WebElm.xpCountTableRows(adminProps, "prod.statusList.jmbID.list.xp");
  			System.out.println(count);
  			for (int index = 0; index < count; index++) {
  				if (Q_WebElm.listOfElements(adminProps, "prod.statusList.jmbID.list.xp").get(index).getText()
  						.equals(productID)) {
  					System.out.println(Q_WebElm.listOfElements(adminProps, "prod.statusList.jmbID.list.xp").get(index).getText());
  					if (Q_WebElm.xpSelected(adminProps, "prod.statusList.needsContent.list.xp").equals(false)) {
  						Q_WebElm.listOfElements(adminProps, "prod.statusList.needsContent.list.xp").get(index).click();
  						Q_WebElm.myWait(2000);
  						Assert.assertTrue(Q_WebElm.xpSelected(adminProps, "prod.statusList.needsContent.list.xp"),
  								"Checkbox selection failed");
  						break;
  					} else if (Q_WebElm.xpSelected(adminProps, "prod.statusList.needsContent.list.xp").equals(true)) {
  						Q_WebElm.listOfElements(adminProps, "prod.statusList.needsContent.list.xp").get(index).click();
  						break;
  					}
  				} else if (index == count - 1) {
  					Assert.fail("Product " + productID + " not found.");
  				}
  			}
  		}
  	}

  	/***************************************************************
  	 * Description: Download Product Status List csv 
  	 * Author: Asfi Khaliq
  	 * Param: None
  	 * Returns: None 
  	 * Status: Complete
  	 **************************************************************/
  	public void downloadProductStatusListCSV() {
  		Q_WebElm.xp(adminProps, "prod.statusList.csvDownloadBtn.xp");
  		Q_WebElm.myWait(6000);
  	}

  	/***************************************************************
  	 * Description: Download Product Status List csv 
  	 * Author: Asfi Khaliq
  	 * Param: None
  	 * Returns: None 
  	 * Status: Complete
  	 **************************************************************/
  	public void verifyProductStatusList_csvReport(String priority, String downloadPath, String fileName) {
  		int index, countOfRows = Q_WebElm.xpCountTableRows(adminProps, "prod.statusList.jmbID.list.xp");
  		LinkedHashMap<Object, Map<String, String>> outerMap = new LinkedHashMap<>();
  		Map<String, String> innerMap;
  		String productId, columnValue = null;
  		for (index = 0; index < countOfRows; index++) {
  			productId = "";
  			innerMap = new LinkedHashMap<String, String>();
  			if (Q_WebElm.listOfElements(adminProps, "prod.statusList.needsContent.list.xp").get(index).isSelected())
  				columnValue = "Y";
  			else
  				columnValue = "N";
  			if (columnValue.isEmpty())
  				break;
  			innerMap.put("Date", columnValue);
  			productId = Q_WebElm.listOfElements(adminProps, "prod.statusList.jmbID.list.xp").get(index).getText();
  			System.out.println(productId);
  			outerMap.put(productId, innerMap);
  		}
  		System.out.println(outerMap.values());
  		System.out.println(outerMap.keySet());
  		File dir = new File(downloadPath);
  		System.out.println(downloadPath);
  		File[] dirContents = dir.listFiles();
  		System.out.println(dirContents.length);
  		for (int file = 0; file < dirContents.length; file++) {
  			if (dirContents[file].getName().contains(fileName)) {
  				System.out.println(downloadPath + "//" + dirContents[file].getName());
  				for (Entry<Object, Map<String, String>> set : outerMap.entrySet()) {
  					System.out.println(set.getKey() + " = " + set.getValue());
  					try {
  						FileReader fileReader = new FileReader(downloadPath + "//" + dirContents[file].getName());
  						CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
  						List<String[]> allData = csvReader.readAll();
  						for (String[] row : allData) {
  							if (set.getKey().toString().equals(row[0])) {
  								System.out.println(row[0] + "\t" + row[12]);
  								Assert.assertTrue(set.getValue().toString().contains(row[12]));
  								System.out.println(row[0] + "\t" + row[12]);
  								break;
  							}
  						}
  						csvReader.close();
  						fileReader.close();
  					} catch (Exception e) {
  						System.out.println(e);
  					}
  				}
  			}
  		}
  	}
    //JMB-7214 End
  	
  	//Start JMB-6619
  	/********************************************************************
  	 * Description: Verify No accessory option displayed for S.com related prod in admin
  	 * Author: Tamilselvan
  	 * Param: NA
  	 * Returns: NA
  	 * Status: Complete 
  	 *******************************************************************/
  	public void verifyDisplayProdAdminSilNoAccessory() {
      	Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps,"jm.silNoAccProdAdmin.xp"), "No accessory option displayed for S.com related prod in admin");
  		System.out.println("Silver No Accessory option displayed in Admin Edit Product page");
  	}
  	/********************************************************************
  	 * Description: Click S.com related products in admin
  	 * Author: Tamilselvan
  	 * Param: NA
  	 * Returns: NA
  	 * Status: Complete 
  	 *******************************************************************/
  	public void clickSilRelatedProdAdmin() {
  		Q_WebElm.xp(adminProps, "jm.silReleatedProd.xp");
  	}
  	/********************************************************************
  	 * Description: Select Product under S.com related products in admin
  	 * Author: Tamilselvan
  	 * Param: NA
  	 * Returns: NA
  	 * Status: Complete 
  	 *******************************************************************/
  	public void addAccessorySil(String accessories) {
  		clickSilRelatedProdAdmin();
      	Q_WebElm.xp(adminProps, "jm.silSelectDropDown.xp");
      	Q_WebElm.xpSend(adminProps, "jm.silAccessory.input.xp", accessories);
        Q_WebElm.myWait(2000);
        Q_WebElm.xpSendTab(adminProps, "jm.silAccessory.input.xp");
        Q_WebElm.myWait(1000);
       	Q_WebElm.xp(adminProps, "jm.silAddRelatedProd.xp");
  	}
  	/********************************************************************
  	 * Description: Verify S.com related products No accessory got disabled
  	 * Author: Tamilselvan
  	 * Param: NA
  	 * Returns: NA
  	 * Status: Complete 
  	 *******************************************************************/
  	public void verifyNoAccessoryDisabledForSil() {
      	Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps,"jm.NoAccDisabledSil.xp"), "No accessory option diabled for S.com related prod in admin");
  		System.out.println("No Accessory field disabled for S.com related products");
  	}
  	/********************************************************************
  	 * Description: Remove product for S.com related products
  	 * Author: Tamilselvan
  	 * Param: NA
  	 * Returns: NA
  	 * Status: Complete 
  	 *******************************************************************/
  	public void clickSilRemoveProd() {
      	Q_WebElm.xp(adminProps, "jm.removeSilRelatedProd.xp");
  	}
  	/********************************************************************
  	 * Description: Verify No Accessory enabled for S.com related products in admin
  	 * Author: Tamilselvan
  	 * Param: NA
  	 * Returns: NA
  	 * Status: Complete 
  	 *******************************************************************/
  	public void verifyNoAccessoryEnabledForSil() {
  	try {
  		Q_WebElm.xpDisplayed(adminProps,"jm.NoAccDisabledSil.xp");
      	Assert.fail();
  	}
  	catch(Exception e) {
      	System.out.println("[Pass] No Accessory option is enabled for S.com");
  	}
  	}
  	/********************************************************************
  	 * Description: Click No Accessory for S.com related `ucts in admin
  	 * Author: Tamilselvan
  	 * Param: NA
  	 * Returns: NA
  	 * Status: Complete 
  	 *******************************************************************/
  	public void clickSilNoAccessory() {
      	Q_WebElm.xp(adminProps, "jm.silNoAccessory.xp");
  	}
  	/********************************************************************
  	 * Description: Verify No accessory option displayed for JM related accessories in admin
  	 * Author: Tamilselvan
  	 * Param: NA
  	 * Returns: NA
  	 * Status: Complete 
  	 *******************************************************************/
  	public void verifyDisplayProdAdminJmNoAccessory() {
      	Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps,"jm.jmNoAccAccesAdmin.xp"), "No accessory option displayed for JM related accessories in admin");
  		System.out.println("No Accessory option displayed in Admin Edit Product page for JM related accessories");
  	}
  	/********************************************************************
  	 * Description: Click JM related products in admin
  	 * Author: Tamilselvan
  	 * Param: NA
  	 * Returns: NA
  	 * Status: Complete 
  	 *******************************************************************/
  	public void clickJmRelatedProdAdmin() {
  		Q_WebElm.xp(adminProps, "jm.jmReleatedAcces.xp");
  	}
  	/********************************************************************
  	 * Description: Verify No accessory disabled for JM related accessories
  	 * Author: Tamilselvan
  	 * Param: NA
  	 * Returns: NA
  	 * Status: Complete 
  	 *******************************************************************/
  	public void verifyNoAccessoryDisabledForJm() {
      	Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps,"jm.NoAccDisabledJm.xp"), "No accessory option diabled for JM related accessories in admin");
  		System.out.println("No Accessory field disabled for JM related accessories");
  	}
  	/********************************************************************
  	 * Description: Verify No Accessory enabled for JM related accessories in admin
  	 * Author: Tamilselvan
  	 * Param: NA
  	 * Returns: NA
  	 * Status: Complete 
  	 *******************************************************************/
  	public void verifyNoAccessoryEnabledForJm() {
  	try {
  		Q_WebElm.xpDisplayed(adminProps,"jm.NoAccDisabledJm.xp");
      	Assert.fail();
  	}
  	catch(Exception e) {
      	System.out.println("[Pass] No Accessory option is enabled for JM related accessories");
  	}
  	}
  	/********************************************************************
  	 * Description: Click No Accessory for JM related `accessories in admin
  	 * Author: Tamilselvan
  	 * Param: NA
  	 * Returns: NA
  	 * Status: Complete 
  	 *******************************************************************/
  	public void clickJmNoAccessory() {
      	Q_WebElm.xp(adminProps, "jm.jmNoAccessory.xp");
  	}
  	//End JMB-6619
  	
  	//JMB-7142 Start
  	/********************************************************************
  	 // * Description  : To download the supplier files in JMB admin page
  	 // * Param        : String priorityType
  	 // * Jira Ticket  : JMB 7142
  	 // * Status       : Completed
  	 //*******************************************************************/
  	public void downloadSupplierFiles(String priorityType) {
  		LocalDate date = LocalDate.now();
  		String currentDate = date.toString();		
  		switch (priorityType) {
  		case "High Priority":
  			Q_WebElm.xp(adminProps, "adm.adminInventory.highPriority.selectHigh.xp");
  			xpSendInputEnter(adminProps, "adm.adminInventory.highPriority.inputDate.xp", currentDate);
  			Q_WebElm.xp(adminProps, "adm.adminInventory.highPriority.updateButton.xp");
  			Q_WebElm.myWait(3000);
  			Controls.checkAndGetAlertText();
  			Controls.scrolUpPixel(3000);
  			Q_WebElm.xp(adminProps, "adm.adminInventory.highPriority.buildhighPriorityBtn.xp");
  			String supplierNameHigh = prod.strXpText("adm.adminInventory.highPriority.supplierFile.xp");
  			String supplierHigh = supplierNameHigh.substring(3);
  			driver.findElement(By.xpath("//button[text()='Build High Priority Quote']//parent::div//child::*[@data-name='"+ supplierHigh + "']")).click();
  			break;
  		case "Low Priority":
  			Controls.scrolUpPixel(3000);
  			Q_WebElm.xp(adminProps, "adm.adminInventory.lowPriority.selectLow.xp");
  			xpSendInputEnter(adminProps, "adm.adminInventory.lowPriority.inputDate.xp", currentDate);
  			Q_WebElm.xp(adminProps, "adm.adminInventory.lowPriority.updateBtn.xp");
  			Q_WebElm.myWait(2000);
  			Controls.checkAndGetAlertText();
  			Controls.scrolUpPixel(3000);
  			Q_WebElm.xp(adminProps, "adm.adminInventory.lowPriority.buildLowPriorityBtn.xp");
  			String supplierNameLow = prod.strXpText("adm.adminInventory.lowPriority.supplierFile.xp");
  			String supplierLow = supplierNameLow.substring(3);
  			driver.findElement(
  			By.xpath("//button[text()='Build Low Priority Quote']//parent::div//child::*[@data-name='"
  							+ supplierLow + "']"))
  					.click();
  			break;
  		}
  	}

  	/********************************************************************
  	 // * Description  : To validated CSV report with UI elements
  	 // * Param        : String priorityType, String downloadPath, String fileName
  	 // * Jira Ticket  : JMB 7142
  	 // * Status       : Completed
  	 //*******************************************************************/
  	public void validateInventoryCSVReport(String priorityType, String downloadPath, String fileName) {
  		String productID = null, productTitle, innerPack, outerPack, sugName = null;
  		switch (priorityType) {
  		case "High Priority":
  			sugName = strXpText("adm.adminInventory.highPriority.sugPurchase.xp");
  			productID = strXpText("adm.adminInventory.highPriority.productID.xp");
  			Q_WebElm.xp(adminProps, "adm.adminInventory.highPriority.editBtn.xp");
  			break;

  		case "Low Priority":
  			sugName = strXpText("adm.adminInventory.lowPriority.suggestedPurchase.xp");
  			productID = strXpText("adm.adminInventory.lowPriority.productID.xp");
  			Q_WebElm.xp(adminProps, "adm.adminInventory.lowPriority.editBtn.xp");
  			break;
  		}
  		Controls.switchTab(1);
  		productTitle = strXpText("adm.adminInventory.productTitle.xp");
  		Q_WebElm.myWait(3000);
  		Q_WebElm.xp(adminProps, "adm.adminInventory.specificationsBtn.xp");
  		Q_WebElm.myWait(2000);
  		innerPack = strXpText("adm.adminInventory.innerPack.xp");
  		outerPack = strXpText("adm.adminInventory.outterPack.xp");
  		driver.close();
  		Controls.switchTab(0);

  		// Validating CSV file
  		List<Map<String, String>> entryList = new ArrayList<>();
  		FileReader reader = null;
  		CSVReader csvReader = null;
  		File dir = new File(downloadPath);
  		File[] dirContents = dir.listFiles();

  		for (int file = 0; file < dirContents.length; file++) {
  			if (dirContents[file].getName().contains(fileName)) {
  				try {
  					reader = new FileReader(downloadPath + "//" + dirContents[file].getName());
  					csvReader = new CSVReader(reader);
  					List<String[]> allData = csvReader.readAll();
  					String[] headers = allData.get(4);
  					if (allData.size() > 4) {
  						for (int i = 5; i < allData.size(); i++) {
  							int j = 0;
  							Map<String, String> entry = new HashMap<>();
  							for (String value : allData.get(i)) {
  								entry.put(headers[j], value);
  								j++;
  							}
  							entryList.add(entry);
  						}
  					} else {
  						Assert.assertTrue(false, "There's no record in CSV file");
  					}
  				} catch (Exception e) {
  					System.out.println(e);
  				} finally {
  					try {
  						csvReader.close();
  						reader.close();
  					} catch (IOException e) {

  					}
  				}
  			}
  		}
  		HashMap<String, String> record = (HashMap<String, String>) entryList.get(0);
  		Assert.assertTrue(record.get("Product ID").equals(productID));
  		Assert.assertTrue(record.get("Inner Pack").equals(innerPack));
  		Assert.assertTrue(record.get("Outer Pack").equals(outerPack));
  		Assert.assertTrue(record.get("Product Title").equals(productTitle));
  		Assert.assertTrue(record.get("Suggested Purchase").equals(sugName));
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
  	
  	/********************************************************************
  	 // * Description  : To click the admin menu in JMB admin page
  	 // * Param        : String item
  	 // * Jira Ticket  : JMB 7142
  	 // * Status       : Completed
  	 //*******************************************************************/
  	public void adminMenu(String item) {

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
      }
  	
  	/********************************************************************
  	 // * Description  : To click the sub menu in JMB admin page
  	 // * Param        : String item
  	 // * Jira Ticket  : JMB 7142
  	 // * Status       : Completed
  	 //*******************************************************************/
  	public void inventoryMenu(String item) {
  		String menuItem = item;
          switch ( menuItem ) {
              case ("gold"):
                  formXp("prod.products.gold.xp");
                  break;
              case ("silver"):
                  formXp("products.silver.x");
                  break;
              case ("platinum"):
                  formXp("prod.products.platinum.xp");
                  break;
              case ("copper"):
                  formXp("prod.products.copper.xp");
                  break;
              case ("buy back"):
                  formXp("prod.products.buyback.xp");
                  break;
              case ("low inventory"):
                  formXp("adm.subInventory.lowInventory.xp");
                  break;
          }
      }
  	
  	/********************************************************************
  	 // * Description  : To verify follow-up-date in JMB admin page
  	 // * Param        : NA
  	 // * Jira Ticket  : JMB 7142
  	 // * Status       : Completed
  	 //*******************************************************************/
  	public void verifyFollowUpDateinLowInventory(String expectedDate, String highPriorityDate, String lowPriorityDate) {
  		String actualHighPriorityDate = attReturn(highPriorityDate,"value");
  		Assert.assertTrue(expectedDate.equals(actualHighPriorityDate),"Miss Match in Priority date");
  		formXp("adm.adminInventory.lowPriority.selectLow.xp");
  		String actualLowPriorityDate = attReturn( lowPriorityDate,"value");
  		Assert.assertTrue(expectedDate.equals(actualLowPriorityDate),"Miss Match in Priority date");
  	}
  	
  	//JMB-7142 End
  	
  	//Start JMB-8106
	/***************************************************************************************************************
    // * Description: Navigate to customer account details page by click on email in autobuy failed transaction page 
    // * Param : NA
    // * Returns: NA
    // * Jira Ticket: JMB 8106
    // * Status: Complete
    /****************************************************************************************************************/  
	public void navigateToCustomerDetailsPageByClickOnEmail() {
		Q_WebElm.myWait(2000);
		Q_WebElm.idClear(adminProps, "adm.reportAutobuy.dateField.id");
		Q_WebElm.idSend(adminProps, "adm.reportAutobuy.dateField.id", "2022-11-01");
		Q_WebElm.id(adminProps, "adm.reportAutobuy.searchBtn.id");
		Q_WebElm.xp(adminProps,"adm.reportAutobuy.selectEmail.xp");
		Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps,"adm.autobuyCustomerLabel.xp"),
				"Unable to reach customer page while click on email in Autobuy failed transaction page"); 
	} 	
	//End JMB-8106
}
