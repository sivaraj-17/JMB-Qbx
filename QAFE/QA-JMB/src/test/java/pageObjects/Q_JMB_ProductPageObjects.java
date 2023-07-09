package pageObjects;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;

import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Properties;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Q_JMB_ProductPageObjects extends Q_JMB_Init {

    public Q_JMB_ProductPageObjects() {

    }
    
    public void xp(Properties proper, String catQtyBeg, String mid, String catQtyEnd) {
		driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + mid + proper.getProperty(catQtyEnd))).click();
	}
    
    public void xpSend(Properties proper, String catQtyBeg, String item, String catQtyEnd, String quan) {
        driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).sendKeys(quan);
    }

    public static String itemDescription(Integer item) {
        String begDescXp = "cart.cart.description.beg.xp";
        String endDescXp = "cart.cart.description.end.xp";
        return Q_JMB_WebElm.xpRetText(jmbProps, begDescXp, item, endDescXp);
    }

    public Q_JMB_ProductPageObjects lineQty(String quan) {
        Q_JMB_WebElm.myWait(1000);
        String productPageQuantityXp= "cart.productPage.quantity.xp";
        Q_JMB_WebElm.xpClear(jmbProps, productPageQuantityXp);
        Q_JMB_WebElm.xpSend(jmbProps, productPageQuantityXp, quan);
        return this;
    }

    public Q_JMB_ProductPageObjects atc() {
        String productPageATCXp= "cart.productpage.AddToCart.xp";
        Q_JMB_WebElm.xp(jmbProps, productPageATCXp);
        return this;
    }

    public static float pdpCheckPrice() {
        DecimalFormat df = new DecimalFormat("#.00");
        float checkPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.product.price.check.xp"));
        return checkPrice;
    }

    public static float pdpBitcoinPrice() {
        DecimalFormat df = new DecimalFormat("#.00");
        float bitCoinPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.product.price.bitCoin.xp"));
        return bitCoinPrice;
    }

    public static float pdpCreditPrice() {
        DecimalFormat df = new DecimalFormat("#.00");
        float creditPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.product.price.creditCard.xp"));
        return creditPrice;
    }
    public Q_JMB_ProductPageObjects productPagePaymentTypePricing(String product, Integer item){
        DecimalFormat df = new DecimalFormat("#.00");
        Q_JMB_CategoryObjects coin = new Q_JMB_CategoryObjects();
        coin.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        coin.categoryItemLink(item);
        System.out.println();
        System.out.println( "Check price" + String.valueOf(df.format(pdpCheckPrice())));
        System.out.println("Bitcoin price" + String.valueOf(df.format(pdpBitcoinPrice())));
        System.out.println("Credit card price " + String.valueOf(df.format(pdpCreditPrice())));
        if (pdpCheckPrice() < pdpBitcoinPrice() || pdpBitcoinPrice() < pdpCreditPrice()) {
            System.out.println("Product page payment type pricing verified");
        }
        else{
            System.out.println("Product page payment type pricing failed");
        }
        return this;
    }
    public Q_JMB_ProductPageObjects pdpPlus(){
        Q_JMB_WebElm.cn(jmbProps, "cart.modal.plus.className");
        return this;
    }
    public Q_JMB_ProductPageObjects pdpMinus(){
        Q_JMB_WebElm.cn(jmbProps, "cart.modal.minus.className");
        return this;
    }
    public Q_JMB_ProductPageObjects modalContinue() {
        Q_JMB_WebElm.xp(jmbProps, "cart.modal.CheckoutNow.xp");
        return this;
    }

    public Q_JMB_ProductPageObjects productItem(Integer item, String quan) {
        lineQty(quan);
        pdpPlus();
        atc();
        modalContinue();
        Assert.assertTrue(Q_JMB_WebElm.idDisplayed(jmbProps, "cart.paymentType.BC.id"));
        return this;
    }
    public static void platinumAmericanEagle(String quan){
        Integer item = 3;
        Q_JMB_NavigationObjects.selectFromMenu("platinum");
        Q_JMB_CartPageObjects.category("platinum coins");
        Q_JMB_CategoryObjects coin = new Q_JMB_CategoryObjects();
//        coin.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        String itemDescription = Q_JMB_CategoryObjects.itemDescription(item);
        coin.categoryItemLink(item);
        Q_JMB_ProductPageObjects pdp = new Q_JMB_ProductPageObjects();
        pdp.lineQty(quan);
        pdp.pdpPlus();
        pdp.atc();
        pdp.modalContinue();
        System.out.println("Added: " + (Integer.valueOf(quan) + 1) + " " + itemDescription);
    }
    public static void platinumRampSuisseFortuna(String quan){
        Integer item = 2;
        Q_JMB_NavigationObjects.selectFromMenu("platinum");
        Q_JMB_CartPageObjects.category("platinum bars");
        Q_JMB_CategoryObjects bar = new Q_JMB_CategoryObjects();
        bar.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        String itemDescription = Q_JMB_CategoryObjects.itemDescription(item);
        bar.categoryItemLink(item);
        Q_JMB_ProductPageObjects pdp = new Q_JMB_ProductPageObjects();
        pdp.lineQty(quan);
        pdp.pdpMinus();
        pdp.atc();
        pdp.modalContinue();
        System.out.println("Added: " + (Integer.valueOf(quan) -1) + " " + itemDescription);

    }
    public static void platinumRampSuisseFortuna10oz(String quan){
        Integer item = 8;
        Q_JMB_NavigationObjects.selectFromMenu("platinum");
        Q_JMB_CartPageObjects.category("platinum ira");
        Q_JMB_CategoryObjects bar = new Q_JMB_CategoryObjects();
        bar.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        String itemDescription = Q_JMB_CategoryObjects.itemDescription(item);
        bar.categoryItemLink(item);
        Q_JMB_ProductPageObjects pdp = new Q_JMB_ProductPageObjects();
        pdp.lineQty(quan);
        pdp.atc();
        pdp.modalContinue();
        System.out.println( "Added: " + quan + " " + itemDescription);

    }

    public Q_JMB_ProductPageObjects productPagePrice(String quan){
        Integer item = 8;
        Q_JMB_NavigationObjects.selectFromMenu("platinum");
        Q_JMB_CartPageObjects.category("platinum ira");
        Q_JMB_CategoryObjects bar = new Q_JMB_CategoryObjects();
        bar.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        String itemDescription = Q_JMB_CategoryObjects.itemDescription(item);
        bar.categoryItemLink(item);
        float checkPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.product.price.check.xp"));
        float bitCoinPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.product.price.bitCoin.xp"));
        float creditPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.product.price.creditCard.xp"));
        try {
            if (checkPrice < bitCoinPrice || bitCoinPrice < creditPrice) {
                System.out.print("Product page Check / Wire Price: " + checkPrice + "\n" + "Product page Bitcoin / Bitcoin Cash Price: " + bitCoinPrice + "\n" + "Product page Credit Card Price: " + creditPrice + "\n");
            }
            else {
                System.out.print("\t Failed to verify payment method unit price in the product page");
            }
        }
        catch (Throwable ex){
            org.testng.Assert.fail("Failed to verify payment method unit price");
        }
        return this;
    }
    public Q_JMB_ProductPageObjects productStocK(String prodId, String status) {
        Q_JMB_Controls.adminLogin();
        driver.navigate().to(adminUrl + "/products-form.php?id=" + prodId);
        switch(status){
            case("inStock"):
                Q_JMB_WebElm.xpSelectValue(jmbProps, "cart.jmStockStatus.xp", "instock");
                Q_JMB_WebElm.xp(jmbProps, "cart.prodPage.save.xp");
                Q_JMB_WebElm.myWait(3000);
                driver.navigate().refresh();
                System.out.println("Stock Status is: " + Q_JMB_WebElm.xpRetAttr(jmbProps, "cart.productStockStatus.xp", "value"));
                Assert.assertEquals(Q_JMB_WebElm.xpRetAttr(jmbProps, "cart.productStockStatus.xp", "value"), "instock");
                Q_JMB_Controls.adminLogout();
                break;
            case("outOfStock"):
                Q_JMB_WebElm.xpSelectValue(jmbProps, "cart.jmStockStatus.xp", "outofstock");
                Q_JMB_WebElm.xp(jmbProps, "cart.prodPage.save.xp");
                Q_JMB_WebElm.myWait(3000);
                driver.navigate().refresh();
                System.out.println("Stock Status is: " + Q_JMB_WebElm.xpRetAttr(jmbProps, "cart.productStockStatus.xp", "value"));
                Assert.assertEquals( Q_JMB_WebElm.xpRetAttr(jmbProps, "cart.productStockStatus.xp", "value"), "outofstock");
                Q_JMB_Controls.adminLogout();
                break;
            default:

                break;
        }
        return this;
    }
    public Q_JMB_ProductPageObjects addStockAlert(){
//        System.out.println("Expected text " + WebElm.xpRetText(jmbProps, "stockAlert.xp"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "cart.stockAlert.xp"), "In-Stock Alert");
        Q_JMB_WebElm.xp(jmbProps, "cart.stockAlert.xp");
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "cart.stockAlert.xp"), "Remove In-Stock Alert");
        return this;
    }
    public Q_JMB_ProductPageObjects removeStockAlert(){
//        System.out.println("Expected text " + WebElm.xpRetText(jmbProps, "stockAlert.xp"));
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "cart.stockAlert.xp"), "Remove In-Stock Alert");
        Q_JMB_WebElm.xp(jmbProps, "cart.stockAlert.xp");
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "cart.stockAlert.xp"), "In-Stock Alert");
        return this;
    }
    public Q_JMB_ProductPageObjects selectItem(String item, Integer quan)  {
        Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
        Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
        driver.navigate().to(baseUrl + item);
        cart.addProductpageItemToCart(quan);
        return this;
    }
    public Q_JMB_ProductPageObjects selectTaxableItem(String item, Integer quan) throws Exception {
        Q_JMB_WebElm.myWait(1000);
        Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
        Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
        switch ( item ) {
            case ("Palladium Under 500"):
                driver.navigate().to(baseUrl + "/2018-w-1-oz-proof-american-palladium-eagle-coin-ngc-pf70-er/");
                cart.addProductpageItemToCart(quan);
                cart.selectPaymentType("credit card");
                cart.selectcheckoutBtn("top");
                chk.cvvCardType(3);
                chk.itemTax();
                ArrayList<Float> reviewPricesPalladium = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
                chk.completeOrder();
                chk.thankYouPage();
                ArrayList<Float> orderPricesPalladium = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
                chk.verifyOrderCharges(reviewPricesPalladium, orderPricesPalladium);
                break;

            case ("Palladium"):
                driver.navigate().to(baseUrl + "/1-oz-palladium-bar-varied/");
                cart.addProductpageItemToCart(quan);
                cart.selectPaymentType("credit card");
                cart.selectcheckoutBtn("top");
                chk.cvvCardType(3);
                chk.itemTax();
                ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
                chk.completeOrder();
                chk.thankYouPage();
                ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
                chk.verifyOrderCharges(reviewPrices, orderPrices);
                break;

            case("silver artwork"):
                driver.navigate().to(baseUrl + "/5-oz-silvertowne-prospector-stackable-silver-round/");
                cart.addProductpageItemToCart(quan);
                cart.selectPaymentType("credit card");
                cart.selectcheckoutBtn("top");
                chk.cvvCardType(3);
                chk.itemTax();
                ArrayList<Float> review4ozSil = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
                chk.completeOrder();
                chk.thankYouPage();
                ArrayList<Float> order4OzSil = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
                chk.verifyOrderCharges(review4ozSil, order4OzSil);
                break;
            case("silver skull") :
                driver.navigate().to(baseUrl + "/2-oz-scottsdale-stacker-silver-round/");
                cart.addProductpageItemToCart(quan);
                cart.selectPaymentType("credit card");
                cart.selectcheckoutBtn("top");
                chk.cvvCardType(3);
                chk.itemTax();
                ArrayList<Float> reviewSilSkull = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
                chk.completeOrder();
                chk.thankYouPage();
                ArrayList<Float> orderSilSkull = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
                chk.verifyOrderCharges(reviewSilSkull, orderSilSkull);
                break;

            case("38mm coin tube") :
                driver.navigate().to(baseUrl + "/dollar-air-tite-coin-tube/");
                cart.addProductpageItemToCart(quan);
                cart.selectPaymentType("credit card");
                cart.selectcheckoutBtn("top");
                chk.cvvCardType(3);
                ArrayList<Float> reviewAccess = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
                chk.completeOrder();
                chk.thankYouPage();
                chk.itemTax();
                ArrayList<Float> orderAccess = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
                chk.verifyOrderCharges(reviewAccess, orderAccess);
                break;
            case("copperUSQuarter"):
                driver.navigate().to(baseUrl + "/1-oz-quarter-copper-round/");
                cart.addProductpageItemToCart(quan);
                cart.selectPaymentType("credit card");
                cart.selectcheckoutBtn("top");
                chk.cvvCardType(3);
                chk.itemTax();
                ArrayList<Float> reviewCopper = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
                chk.completeOrder();
                chk.thankYouPage();
                ArrayList<Float> orderCopper = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
                chk.verifyOrderCharges(reviewCopper, orderCopper);
                break;

            case ("all taxable metal"):
                chk.itemTax();
                driver.navigate().to(baseUrl + "/1-oz-palladium-bar-varied/");
                cart.addProductpageItemToCart(quan);
                driver.navigate().to(baseUrl + "/5-oz-silvertowne-prospector-stackable-silver-round/");
                cart.addProductpageItemToCart(quan);
                driver.navigate().to(baseUrl + "/dollar-air-tite-coin-tube/");
                cart.addProductpageItemToCart(quan);
                driver.navigate().to(baseUrl + "/1-oz-quarter-copper-round/");
                cart.addProductpageItemToCart(quan);
                cart.selectPaymentType("cheque");
                cart.selectcheckoutBtn("top");
                ArrayList<Float> reviewTaxable = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
                chk.completeOrder();
                chk.thankYouPage();
                ArrayList<Float> orderTaxable = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
                chk.verifyOrderCharges(reviewTaxable, orderTaxable);
                break;
//            case("") :
//
//                break;

        }
        return this;
    }


    //JMB-6214 Start
    /**
     * Searches the page with the @param to tell if its present and return its status
     * @param productTitle
     * @return product status
     */
    public static String productStatusThroughList(String productTitle)
    {
        String status= " ";
        int count= Q_JMB_WebElm.xpCountTableRows(jmbProps, "chk.count.products.xp");
        for (int i=1; i<= count; i++)
            if (Q_JMB_CategoryObjects.itemDescription(i).equalsIgnoreCase(productTitle))
            {
                System.out.println(Q_JMB_CategoryObjects.itemDescription(i));
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
        String begQtyXp = "cart.quantity.beg.xp";
        String endQtyXp = "cart.product.status.end.xp";
        return Q_JMB_WebElm.xpRetText(jmbProps, begQtyXp, item, endQtyXp);
    }
    //JMB-6214 End
    
    //JMB-7670 Start
    /**********************************************************************
     * Description:     Controller for pulling data from excel for adding, removing, or updating products for a given test case
     * Author:          Paul Patterson
     * Param:      		String testCaseName, int testcaseIndex
     * Returns:         None
     **********************************************************************/
	public void productsController (String testCaseName, int testcaseIndex) throws FilloException, IOException 
	{
		Q_JMB_Controls cont = new Q_JMB_Controls();
		System.out.println("[INFO] Getting data for Test Case '" + testCaseName + "' with Test Case Index '" + testcaseIndex + "' for data file 'AutomationTestDataFile.xlsx'.");
		LinkedHashMap <Object, Map<String, String>> productTestDataRecordSet;
		Map <String, String> innerMap;
		String selectQuery = "Select * From JMBProductTestData Where TestCaseName='" + testCaseName +"' And TestCaseIndex='" + testcaseIndex + "'";
		productTestDataRecordSet = cont.queryExcelToLinkedHashMap(System.getProperty("user.dir") + "/src/main/resources/excelFiles/AutomationTestDataFile.xlsx", selectQuery);
		//productTestDataRecordSet = queryExcelToLinkedHashMap("//Users//sdmac002//git//QAJMB_Testing//QAFE//QA-JMB//src//main//resources//excelFiles//AutomationTestDataFile.xlsx", selectQuery);
		for (int index = 1; index <= productTestDataRecordSet.size(); index++)
		{
			innerMap = productTestDataRecordSet.get(index);
			productSelectMethodContoller (innerMap.get("ProductName"), innerMap.get("ActionType"), 
					innerMap.get("SelectionMethod"), innerMap.get("Qty"));
		}
	}
	
	/**********************************************************************
     * Description:     Controller for determining proper method calls for a single product action
     * Author:          Paul Patterson
     * Param:      		String productName, String actionType, String selectionMethod, String qty
     * Returns:         None
     **********************************************************************/
	public void productSelectMethodContoller (String productName, String actionType, String selectionMethod, String qty) throws FilloException
	{
		Q_JMB_Controls cont = new Q_JMB_Controls();
		System.out.println("[INFO] Starting action '" + actionType + "' on product '" + productName + "' using the method '" + selectionMethod + "'.");
		Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
		switch(actionType) {
			case "Add":
				LinkedHashMap <Object, Map<String, String>> productDetailsRecordSet;
				String selectQuery = "Select * From JMBProducts Where ProductName='" + productName +"'";;
				Map <String, String> innerMap;
				productDetailsRecordSet = cont.queryExcelToLinkedHashMap(System.getProperty("user.dir") + "/src/main/resources/excelFiles/AutomationTestDataFile.xlsx", selectQuery);
				//productDetailsRecordSet = queryExcelToLinkedHashMap("//Users//sdmac002//git//QAJMB_Testing//QAFE//QA-JMB//src//main//resources//excelFiles//AutomationTestDataFile.xlsx", selectQuery);
				innerMap = productDetailsRecordSet.get(1);
				switch(selectionMethod) {
					case "URL":
						cart.addProductByURL (innerMap.get("ProductURL"), qty);
						break;
					case "PDP":
						cart.addProductByPDP (productName, innerMap.get("MetalType"), innerMap.get("Category1"), 
								innerMap.get("Category2"), innerMap.get("Category3"), 
								innerMap.get("Category4"), qty);
						break;
					case "PLP":
						cart.addProductByPLP (productName, innerMap.get("MetalType"), innerMap.get("Category1"), 
								innerMap.get("Category2"), innerMap.get("Category3"), 
								innerMap.get("Category4"), qty);
						break;
				}
				break;
			case "Update":
				switch(selectionMethod) {
					case "Cart":
						cart.updateProductInCart (productName, qty);
						break;
				}
				break;
			case "Delete":
				switch(selectionMethod) {
					case "Cart":
						cart.deleteProductInCart (productName);
						break;
				}
				break;
		}
		System.out.println("[INFO] Finished action '" + actionType + "' on product '" + productName + "' using the method '" + selectionMethod + "'.");
	}
	
	/**********************************************************************
     * Description:     Navigate to PLP category page
     * Author:          Paul Patterson
     * Param:      		String metalType, String category1, String category2, String category3, String category4
     * Returns:         None
     **********************************************************************/
	public void navigateToPLPPage (String metalType, String category1, String category2, 
			String category3, String category4) 
	{	
		if (metalType.equals("Copper") || metalType.equals("Accessories")) {
			xp(jmbProps, "nav.topMenu.beg.xp", "Other", "nav.topMenu.end.xp");
			xp(jmbProps, "nav.subMenu.beg.xp", metalType, "nav.subMenu.end.xp");
		} else
		{
			xp(jmbProps, "nav.topMenu.beg.xp", metalType, "nav.topMenu.end.xp");
		}
		
		xp(jmbProps, "nav.categorySelection.beg.xp", category1, "nav.categorySelection.end.xp");
		
		if (!category2.isEmpty()) {
			xp(jmbProps, "nav.categorySelection.beg.xp", category2, "nav.categorySelection.end.xp");
		}
		
		if (!category3.isEmpty()) {
			xp(jmbProps, "nav.categorySelection.beg.xp", category3, "nav.categorySelection.end.xp");
		}
		
		if (!category4.isEmpty()) {
			xp(jmbProps, "nav.categorySelection.beg.xp", category4, "nav.categorySelection.end.xp");
		}
	}
	//JMB-7670 End
}
