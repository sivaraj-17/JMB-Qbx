package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Q_Slv_CartSteps extends Q_Slv_Init {



    // @Step
    //
    // Add gold item from category Gold American Eagles sub category Brilliant Uncirculated Gold Eagles. Item was added in the sub category quantity box and then AddToCart button
    // Product id = 74
    //
    public static void gold1(String quan){
        Integer lineItem = 4;
        Q_Slv_WebElm.xp(SLVqProp, "cart.metal.gold.xp");
        Q_Slv_WebElm.xp(SLVqProp, "cart.gold.americanGoldEagle.xp");
        Q_Slv_WebElm.myWait(1000);
//        WebElm.xpElement(SLVqProp, "sil.gold.sub.goldEagleBU.xp");
        Q_Slv_WebElm.xp(SLVqProp, "cart.gold.sub.goldEagleBU.xp");
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.atc.beg.xp", lineItem, "cart.atc.end.xp");
        Q_Slv_WebElm.myWait(6000);
        //WebElm.idElement(SLVqProp,"cart.paymentType.PC.id");
        //Assert.assertEquals(driver.getTitle(),"Cart | Silver.com");

    }
    // @Step
    //
    // Add gold item from category Gold Bars 1 Gram Sunshine Mint Gold Bars (New in Assay). Item was added by clicking the AddToCart button
    // Product id = 166617
    //
    public static void gold2(String quan){
        Integer lineItem = 2;
        Q_Slv_WebElm.xp(SLVqProp, "cart.metal.gold.xp");
        Q_Slv_WebElm.xp(SLVqProp, "cart.gold.bars.xp");
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.atc.beg.xp", lineItem, "cart.atc.end.xp");
        Q_Slv_WebElm.myWait(6000);
        //WebElm.idElement(SLVqProp,"cart.paymentType.PC.id");
        //Assert.assertEquals(driver.getTitle(),"Cart | Silver.com");
    }

    // @Step
    //
    //  Test case to add 2 of the 2016 15 Gram Gold Chinese Panda Coins (BU) form the Chinese Gold Pandas sub category.  Item added in the product page quantity input.
    // Product id = 790539
    //
    public static void gold3(String quan){
        Q_Slv_WebElm.myWait(1000);
        Integer lineItem = 10;
        Q_Slv_WebElm.xp(SLVqProp, "cart.metal.gold.xp");
        Q_Slv_WebElm.xp(SLVqProp, "cart.gold.panda.xp");
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.atc.beg.xp", lineItem, "cart.atc.end.xp");
        Q_Slv_WebElm.myWait(6000);
        //WebElm.idElement(SLVqProp,"cart.paymentType.PC.id");
        //Assert.assertEquals(driver.getTitle(),"Cart | Silver.com");
    }

    // @Step
    //
    // Add gold item with quantity 1 of the 10 oz Credit Suisse Gold Bars (New w/ Assay) from category Gold Bars. Item was added in the category page quantity box and then AddToCart button
    // Product id = 492
    //
    public static void gold4(String quan){
        Integer lineItem = 49;
        Q_Slv_WebElm.xp(SLVqProp, "cart.metal.gold.xp");
        Q_Slv_WebElm.xp(SLVqProp, "cart.gold.bars.xp");
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.atc.beg.xp", lineItem, "cart.atc.end.xp");
        Q_Slv_WebElm.myWait(6000);
        // WebElm.idElement(SLVqProp,"cart.paymentType.PC.id");
        //Assert.assertEquals(driver.getTitle(),"Cart | Silver.com");
    }
    //
//  Silver Products
//
//
    // @Step
    //
    // 790071 This test case to add 3 of the 2016 30 Chinese Panda
    //
    public static void silver1(String quan){
        Integer lineItem = 3;
        Q_Slv_WebElm.xp(SLVqProp, "cart.metal.silver.xp");

        Q_Slv_WebElm.xp(SLVqProp, "cart.cat.Panda.xp");
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.atc.beg.xp", lineItem, "cart.atc.end.xp");
        Q_Slv_WebElm.myWait(6000);
        //Assert.assertEquals(driver.getTitle(),"Cart | Silver.com");
    }
    // @Step
    //
    // This test case to add 1 of the 100 oz Geiger Security Line Silver Bars (New) silver bar sub category item. Item was added in the sub category by clicking the AddToCart button
    // Product id = 228908
    //
    public static void silver2(String quan){
        Integer lineItem = 4;
        Q_Slv_WebElm.xp(SLVqProp, "cart.metal.silver.xp");
        Q_Slv_WebElm.xp(SLVqProp, "cart.cat.silver.bars.xp");
        Q_Slv_WebElm.xp(SLVqProp, "cart.silver.100ozBars.xp");
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.atc.beg.xp", lineItem, "cart.atc.end.xp");
        Q_Slv_WebElm.myWait(6000);
        //WebElm.idElement(SLVqProp,"cart.paymentType.PC.id");
        //Assert.assertEquals(driver.getTitle(),"Cart | Silver.com");
    }
    // @Step
    //
    // This test case to add 6 of the 2016 5 oz Shawnee National Forest ATB Silver Coins NGC MS69 PL ER silver coin sub category item. Item was added in the product page quantity box.
    // Product id 951461
    //
    public static void silver3(String quan) {
        Integer lineItem = 4;
        Q_Slv_WebElm.xp(SLVqProp, "cart.metal.silver.xp");
        Q_Slv_WebElm.xp(SLVqProp, "cart.cat.silver.ATB.xp");
        Q_Slv_WebElm.xp(SLVqProp, "cart.sub.cat.2016atb.xp");
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.atc.beg.xp", lineItem, "cart.atc.end.xp");
        Q_Slv_WebElm.myWait(6000);
        //WebElm.idElement(SLVqProp,"cart.paymentType.PC.id");
        //Assert.assertEquals(driver.getTitle(),"Cart | Silver.com");
    }
    
    // JMB-6489 Start
    /*******************************************************************
    * Description: Adds 2016 1 oz Silver American Eagle Coins (BU) category item
    * Param: String
    * Status: Complete
    *******************************************************************/
    public static void silver4(String quan) {
    	Integer lineItem = 4;
    	Q_Slv_WebElm.xp(SLVqProp, "cart.metal.silver.xp");
		Q_Slv_WebElm.xp(SLVqProp, "cart.cat.silver.AmerSilverEagle.xp");
		Q_Slv_WebElm.xp(SLVqProp, "cart.su.cat.silverEagle.xp");
		Q_Slv_WebElm.xpClear(SLVqProp, "cart.category.qty.beg.xp", lineItem, "cart.category.qty.end.xp");
		Q_Slv_WebElm.xpSend(SLVqProp, "cart.category.qty.beg.xp", lineItem, "cart.category.qty.end.xp", quan);
		Q_Slv_WebElm.xp(SLVqProp, "cart.atc.beg.xp", lineItem, "cart.atc.end.xp");
		Q_Slv_WebElm.myWait(6000);
    }
    // JMB-6489 End
//
//  Platinum Products
//
    // @Step
    //
    //	This test case to add 2 of the 1 Gram PAMP Suisse Fortuna Platinum Bars (New in Assay) Platinum Bars category item. Item was added in the category page quantity input
    //	Product id = 390
    //
    public static void platinum1(String quan) {
        Integer lineItem = 1;
        Q_Slv_WebElm.xp(SLVqProp, "cart.metal.platinum.xp");
        Q_Slv_WebElm.xp(SLVqProp, "cart.cat.platinum.bars.xp");
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.atc.beg.xp", lineItem, "cart.atc.end.xp");
        Q_Slv_WebElm.myWait(6000);
        //WebElm.idElement(SLVqProp,"cart.paymentType.PC.id");
        //Assert.assertEquals(driver.getTitle(),"Cart | Silver.com");
    }
    // @Step
    //
    //	 This test case to add 1 oz Platinum American Eagle Coins (Varied Year, BU) category item. Item was added in the category page AddToCartButton
    //	 Product id = 473269
    //
    public static void platinum2(String quan) {
        Integer lineItem = 12;
        Q_Slv_WebElm.xp(SLVqProp, "cart.metal.platinum.xp");
        Q_Slv_WebElm.xp(SLVqProp, "cart.cat.platinum.coins.xp");
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp", quan);
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.xp(SLVqProp, "cart.atc.beg.xp", lineItem, "cart.atc.end.xp");
        Q_Slv_WebElm.myWait(6000);
        //WebElm.idElement(SLVqProp,"cart.paymentType.PC.id");
        //Assert.assertEquals(driver.getTitle(),"Cart | Silver.com");
    }
    // @Step
    //
    //	This test case to add 2 of the 10 oz PAMP Suisse Fortuna Platinum Bars (New in Assay) Platinum Bars category item. Item was added in the product page quantity input
    //	Product id = 557644
    //
    public static void platinum3(String quan) {
        Integer lineItem = 3;
        Q_Slv_WebElm.xp(SLVqProp, "cart.metal.platinum.xp");
        Q_Slv_WebElm.xp(SLVqProp, "cart.cat.platinum.bars.xp");
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.atc.beg.xp", lineItem, "cart.atc.end.xp");
        Q_Slv_WebElm.myWait(6000);
        //WebElm.idElement(SLVqProp,"cart.paymentType.PC.id");
        //Assert.assertEquals(driver.getTitle(),"Cart | Silver.com");
    }

//
//  Copper Products
//
//
    // @Step
    //
    //	This test case to add 1 oz US Quarter Copper Round (New) Rounds category item. Item was added in the category page
    //	quantity inputProduct id = 171573
    //
    public static void copper1(String quan) {
        driver.navigate().to(baseUrl + "/copper-bullion/");
        Integer lineItem = 14;
        Q_Slv_WebElm.xp(SLVqProp, "cart.cat.copper.round.xp");
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.atc.beg.xp", lineItem, "cart.atc.end.xp");
        Q_Slv_WebElm.myWait(6000);
        //WebElm.idElement(SLVqProp,"cart.paymentType.PC.id");
        //Assert.assertEquals(driver.getTitle(),"Cart | Silver.com");
    }
    // @Step
    //
    //	This test case to add 1 oz Walking Liberty Copper Round (New) category item. Item was added in the category page
    //	quantity inputProduct id = 148508
    //
    public static void copper2(String quan) {
        driver.navigate().to(baseUrl + "/copper-bullion/");
        Integer lineItem = 1;
        Q_Slv_WebElm.xp(SLVqProp, "cart.cat.copper.round.xp");
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.category.qty.beg.xp",lineItem, "cart.category.qty.end.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.category.qty.beg.xp", lineItem, "cart.atc.end.xp");
        Q_Slv_WebElm.myWait(6000);
        //WebElm.idElement(SLVqProp,"cart.paymentType.PC.id");
        //Assert.assertEquals(driver.getTitle(),"Cart | Silver.com");
    }
    //@Step
    public static void accessories(String quan) {  // Accessories
        driver.navigate().to(baseUrl + "/dollar-air-tite-coin-tubes/");
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.pdp.qty.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.pdp.qty.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.pdp.atc.xp");
    }
    public static void paymentType(String locator){
        Q_Slv_WebElm.id(SLVqProp, locator);
    }
    public static void addPdpProduct(String item, String quan) {
        driver.navigate().to(baseUrl + item);
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.pdp.qty.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.pdp.qty.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.pdp.atc.xp");
//        paymentType("cart.paymentType.PC.id");
//        WebElm.xp(SLVqProp, "sil.proceedToChk.btn.xp");
        Q_Slv_WebElm.myWait(1000);
    }

    //@Step
    public static void emptyCart(){
        driver.navigate().to(baseUrl + "/cart/");
        Integer cartItems = Integer.valueOf(Q_Slv_WebElm.cnRetText(SLVqProp, "cart.MyCart.className").replaceAll("[^\\d.]", ""));
        System.out.println("Current cart = :    " + cartItems);

        if (cartItems >= 1) {

            int count = Q_Slv_WebElm.xpCountTableRows(SLVqProp, "cart.description.beg.xp");
            System.out.println(count);
            for(int i=1; i <= count; i++){
                Q_Slv_WebElm.myWait(2000);
                Q_Slv_WebElm.xp(SLVqProp, "cart.remove.xp");
            }
            /*
            do
            {
                myWait(2000);
                //xpCompoundElement(SLVqProp,"cart.remove.beg.xp" , i , "cart.remove.end.xp");
                xpElement(SLVqProp,"cart.remove.xp");
                //cnElement(SLVqProp, "cart.remove.className");
                //cssElement(SLVqProp, "cart.lineItem.remove.end.cssSelector");
                i--;
            }
            while(i > 1);
            */
            Q_Slv_WebElm.myWait(3000);
            System.out.println("cart after: " + Q_Slv_WebElm.cnRetText(SLVqProp, "cart.MyCart.className").replaceAll("[^\\d.]", ""));
            Assert.assertEquals(Q_Slv_WebElm.cnRetText(SLVqProp, "cart.MyCart.className").replaceAll("[^\\d.]", ""), "0");

        }
    }

    //@Step
    public static void verifyCartContent(){
        int count = Q_Slv_WebElm.countTableRows(SLVqProp, "cart.description.beg.xp");

        System.out.println(count);

        for(int i =1; i<= count; i++){
            //System.out.println(xpCompoundRetText(SLVqProp, "cart.qty.beg.xp",  i, "cart.description.end.xp") + "\t" +
            //        xpElementAttribute(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp"));
            switch ( i ){
                case 1:

                    Assert.assertEquals(Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp","value"), "3");
                    break;
                case 2:
                    break;
                case 3:
                    Assert.assertEquals( Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp","value"),"2");
                    break;

                case 4:
                    Assert.assertEquals( Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp","value"),"3");
                    break;
                case 5:
                    Assert.assertEquals(Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp","value"),"1");
                    break;
                case 6:
                    Assert.assertEquals(Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp","value"),"2");
                    break;
                case 7:
                    Assert.assertEquals( Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp","value"),"2");
                    break;

                case 8:
                    Assert.assertEquals(Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp","value"),"1");
                    break;

                case 9:
                    Assert.assertEquals(Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp","value"),"1");
                    break;
                case 10:
                    Assert.assertEquals( Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp","value"),"10");
                    break;
                }
            System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.qty.beg.xp",  i, "cart.description.end.xp")+
                    "\t\t" + Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp","value"));
            }

    }
    //@Step
    public static void editCart(){
        int count = Q_Slv_WebElm.xpCountTableRows(SLVqProp, "cart.description.beg.xp");
        for(int i =1; i<= count ; i++){
            String before = Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp", "value");
            if(i <= 2 ){
                Q_Slv_WebElm.xpClear(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp");
                Q_Slv_WebElm.xpSend(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp","1");
                Q_Slv_WebElm.xp(SLVqProp, "cart.qty.beg.xp",  i, "cart.update.end.xp");
            }
            else if(i==3){
                Q_Slv_WebElm.xpClear(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp");
                Q_Slv_WebElm.xpSend(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp","3");
                Q_Slv_WebElm.xp(SLVqProp, "cart.qty.beg.xp",  i, "cart.update.end.xp");
            }
            else if(i==4){
                Q_Slv_WebElm.xpClear(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp");
                Q_Slv_WebElm.xpSend(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp","2");
                Q_Slv_WebElm.xp(SLVqProp, "cart.qty.beg.xp",  i, "cart.update.end.xp");
            }
            else{
                Q_Slv_WebElm.xp(SLVqProp, "cart.remove.xp");
            }
            switch (i){
                case 1:
                    Assert.assertEquals("1", Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp", "value"));
                    break;
                case 2:
                    Assert.assertEquals("1", Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp", "value"));
                    break;
                case 3:
                    Assert.assertEquals("3", Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp", "value"));
                    break;

                case 4:
                    Assert.assertEquals("2", Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp", "value"));
                    break;

            }
            if(i <=  4 ){
                System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.qty.beg.xp",  i, "cart.description.end.xp") +
                        "\t\t Before :" + before + "\t\t After :" + Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp", "value"));

            }

        }

    }
    // @Step
    public static void cartMax(){
        int count = Q_Slv_WebElm.xpCountTableRows(SLVqProp, "cart.description.beg.xp");
        for(int i =1; i<= count ; i++){
            Assert.assertEquals(Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp", "value"), "1020");
            System.out.println("Truncated quantity :" + Q_Slv_WebElm.xpRetAttr(SLVqProp, "cart.qty.beg.xp",  i, "cart.qty.end.xp", "value"));
        }
    }
    // @Step
    public static void cartLimit(String quan){
        driver.navigate().to(baseUrl + "/copper-bullion/");
        Q_Slv_WebElm.xp(SLVqProp, "cart.cat.copper.round.xp");
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.category.qty.beg.xp",5, "cart.category.qty.end.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.category.qty.beg.xp",5, "cart.category.qty.end.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.atc.beg.xp", 5, "cart.atc.end.xp");

        try {
            Q_Slv_Controls.checkAlert();
            driver.navigate().to(baseUrl + "/cart/");

            System.out.println("Sorry, we only have 6736 of this item available for immediate shipping");
        }
        catch(Throwable ex){
            System.out.println("Sorry, we only have 6736 of this item available for immediate shipping");
        }
    }
    // @Step
    public static void applyGiftCertificate(String quan) {
        DecimalFormat df = new DecimalFormat("#.00");
        copper1(quan);
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.coupon.input.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.coupon.input.xp", "Automation");
        Q_Slv_WebElm.name(SLVqProp, "cart.coupon.apply.name");
        float subtotal = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp, "cart.subtotal.bottom.xp"));
        float shipping = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp, "cart.shipping.xp"));
        float adjustment = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp, "cart.adjustment.xp"));
        float total = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp, "cart.total.xp"));
        System.out.println("Order subtotal:  " + subtotal + "\n" + "Shipping " + shipping + "\n" + "Coupon value:  " + adjustment + "\n" + "Order Total:  " + total);
        float calculatedTotal = (subtotal + shipping) - adjustment;
        System.out.println(df.format(calculatedTotal) + "\t" + df.format(total));
        Assert.assertEquals(df.format(calculatedTotal), df.format(total));
        System.out.println("Calculated total : " + calculatedTotal + "\t Order total : " + total);
    }
    public static void applyGiftCertificate(String quan, String coupon) {
        DecimalFormat df = new DecimalFormat("#.00");
        copper1(quan);
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.coupon.input.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.coupon.input.xp", coupon);
        Q_Slv_WebElm.name(SLVqProp, "cart.coupon.apply.name");
        float subtotal = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp, "cart.subtotal.bottom.xp"));
        float shipping = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp, "cart.shipping.xp"));
        float adjustment = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp, "cart.adjustment.xp"));
        float total = Float.valueOf(Q_Slv_WebElm.xpRetTextReplace(SLVqProp, "cart.total.xp"));
        System.out.println("Order subtotal:  " + subtotal + "\n" + "Shipping " + shipping + "\n" + "Coupon value:  " + adjustment + "\n" + "Order Total:  " + total);
        float calculatedTotal = (subtotal + shipping) - adjustment;
        System.out.println(df.format(calculatedTotal) + "\t" + df.format(total));
        Assert.assertEquals(df.format(calculatedTotal), df.format(total));
        System.out.println("Calculated total : " + calculatedTotal + "\t Order total : " + total);
    }
    public static void paperCheckCartLanguage()
    {
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_WebElm.id(SLVqProp, "cart.paymentType.PC.id");
        Q_Slv_WebElm.myWait(4000);
        //      String s1= "Ships within 4-6 Business Days After Payment Received/Processed";
        String s1= "Ships Within 4-6 Business Days After Receipt of Payment";
        String s2 = "Paper Checks are approved for orders between $0.00 and $75,000.00. Order Confirmation Email will include all information necessary to complete payment.";
        String s3 = "Due to unprecedented USPS delays delivering paper checks, we highly recommend choosing eCheck (ACH) or Bank Wire as your payment type.";
        //      String s4 = "All Paper Check Orders Receive a 4% Discount Relative to Credit Card/PayPal Pricing";
        String s4 = "All Paper Check Orders Receive a 4% Discount Relative to Card/PayPal Pricing";
        String s5 = "May Require a Credit Card on File to Lock in Pricing";
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.pc.heading.xp"));
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.pc.line1.xp"));
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.pc.line2.xp"));
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.pc.line3.xp"));
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.pc.line4.xp"));
        Assert.assertEquals(s1, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.pc.heading.xp"));
        Assert.assertEquals(s2, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.pc.line1.xp"));
        Assert.assertEquals(s3, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.pc.line2.xp"));
        Assert.assertEquals(s4, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.pc.line3.xp"));
        Assert.assertEquals(s5, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.pc.line4.xp"));
    }
    public static void achCartLanguage()
    {
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_WebElm.id(SLVqProp, "cart.paymentType.EC.id");
        Q_Slv_WebElm.myWait(4000);
//        String s1= "Ships within 3-5 Business Days After Funds Clear";
        String s1= "Ships Within 3-5 Business Days After Receipt of Payment";
        String s2 = "eCheck (ACH) are approved for orders between $0.00 and $75,000.00.";
        String s3 = "Easier and Faster Than Paper Check";
        String s4 = "All eCheck (ACH) Orders Receive a 4% Discount vs. Card/PayPal Pricing";
        String s5 = "Pay Online Instantly by Linking Your Bank Account to Your Silver Account";
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.ach.heading.xp"));
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.ach.line1.xp"));
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.ach.line2.xp"));
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.ach.line3.xp"));
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.ach.line4.xp"));
        Assert.assertEquals(s1, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.ach.heading.xp"));
        Assert.assertEquals(s2, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.ach.line1.xp"));
        Assert.assertEquals(s3, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.ach.line2.xp"));
        Assert.assertEquals(s4, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.ach.line3.xp"));
        Assert.assertEquals(s5, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.ach.line4.xp"));
    }
    public static void wireCartLanguage()
    {
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_WebElm.id(SLVqProp, "cart.paymentType.BW.id");
        Q_Slv_WebElm.myWait(4000);
        //     String s1= "Ships within 1 Business Day";
        String s1= "Ships Within 1 Business Day";
        String s2 = "Bank Wires are approved for orders between $1,000.00 and $500,000.00. Order Confirmation Email will include all information necessary to complete payment.";
        String s3= "Fastest Method from Your Bank Account";
        //     String s4 = "All Bank Wire Orders Receive a 4% Discount Relative to Credit Card/Paypal Pricing";
        String s4 = "All Bank Wire Orders Receive a 4% Discount Relative to Card/Paypal Pricing";
        String s5 = "Bank Wires May Require a Trip to Your Bank. Must Send a Wire, not eCheck (ACH).";
        String s6 = "May Require a Credit Card on File to Lock in Pricing";
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.wire.heading.xp"));
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.wire.line1.xp"));
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.wire.line2.xp"));
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.wire.line3.xp"));
        System.out.println(Q_Slv_WebElm.xpRetText(SLVqProp, "cart.wire.line4.xp"));
        Assert.assertEquals(s1, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.wire.heading.xp"));
        Assert.assertEquals(s2, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.wire.line1.xp"));
        Assert.assertEquals(s3, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.wire.line2.xp"));
        Assert.assertEquals(s4, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.wire.line3.xp"));
        Assert.assertEquals(s5, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.wire.line4.xp"));
        Assert.assertEquals(s6, Q_Slv_WebElm.xpRetText(SLVqProp, "cart.wire.line5.xp"));
    }
    /*******************************************************************
     // * Description: For CA tax test caes
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    public static void chineseSilverPanda201630gms(String quan)
    {
        driver.navigate().to(baseUrl + "/2016-30-g-silver-chinese-pandas/");
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.pdp.qty.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.pdp.qty.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.pdp.atc.xp");

    }

    // JMB-6867 Start
     public static void categoryProduct(String MetalType, String Category, String subCategory, String bexp, Integer lineItem, String endxp,  String quan){
        Q_Slv_WebElm.xp(SLVqProp, MetalType);
        Q_Slv_WebElm.xp(SLVqProp, Category);
         Q_Slv_WebElm.xp(SLVqProp, subCategory);
        Q_Slv_WebElm.xpClear(SLVqProp, bexp,lineItem, endxp);
        Q_Slv_WebElm.xpSend(SLVqProp, bexp,lineItem, endxp, quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.atc.beg.xp", lineItem, "cart.atc.end.xp");
     }
    public static void pdpProduct(String item, String quan){
        driver.navigate().to(baseUrl + item);
        Q_Slv_WebElm.myWait(1000);
        Q_Slv_WebElm.xpClear(SLVqProp, "cart.pdp.qty.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "cart.pdp.qty.xp", quan);
        Q_Slv_WebElm.xp(SLVqProp, "cart.pdp.atc.xp");
    }

    //JMB-7670 Start
    public void xp(Properties proper, String catQtyBeg, String mid, String catQtyEnd) {
		driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + mid + proper.getProperty(catQtyEnd))).click();
	}

	public void xp(Properties proper, String catQtyBeg, String mid, String ele, String catQtyEnd) {
		driver.findElement(
				By.xpath(proper.getProperty(catQtyBeg) + mid + proper.getProperty(ele) + proper.getProperty(catQtyEnd)))
				.click();
	}
	public void xpClear(Properties proper, String catQtyBeg, String mid, String catQtyEnd) {
		driver.findElement(
				By.xpath(proper.getProperty(catQtyBeg) + mid + proper.getProperty(catQtyEnd)))
				.clear();
	}
	
	public void xpSend(Properties proper, String catQtyBeg, String item, String catQtyEnd, String quan) {
        driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).sendKeys(quan);
    }

	public void nameSend(Properties proper, String locator, String quan) {
		driver.findElement(By.name(proper.getProperty(locator))).sendKeys(quan);
	}

	public Boolean xpDisplayed(Properties proper, String beg, String item, String end) {
		return driver.findElement(By.xpath(proper.getProperty(beg) + item + proper.getProperty(end))).isDisplayed();

	}
	public void nameClear(Properties proper, String locator){
	    driver.findElement(By.name(proper.getProperty(locator))).clear();
	}
    
  	
  	/**********************************************************************
     * Description:     Controller for pulling data from excel for adding, removing, or updating products for a given test case
     * Author:          Paul Patterson
     * Param:      		String testCaseName, int testcaseIndex
     * Returns:         None
     **********************************************************************/
  	public void productsController (String testCaseName, int testcaseIndex) throws FilloException, IOException 
  	{
  		Q_Slv_Controls cont = new Q_Slv_Controls();
  		System.out.println("[INFO] Getting data for Test Case '" + testCaseName + "' with Test Case Index '" + testcaseIndex + "' for data file 'AutomationTestDataFile.xlsx'.");
  		LinkedHashMap <Object, Map<String, String>> productTestDataRecordSet;
  		Map <String, String> innerMap;
  		String selectQuery = "Select * From SLVProductTestData Where TestCaseName='" + testCaseName +"' And TestCaseIndex='" + testcaseIndex + "'";
  		productTestDataRecordSet = cont.queryExcelToLinkedHashMap(System.getProperty("user.dir") + "/src/main/resources/excelFiles/AutomationTestDataFile.xlsx", selectQuery);
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
  		Q_Slv_Controls cont = new Q_Slv_Controls();
  		System.out.println("[INFO] Starting action '" + actionType + "' on product '" + productName + "' using the method '" + selectionMethod + "'.");
  		switch(actionType) {
  			case "Add":
  				LinkedHashMap <Object, Map<String, String>> productDetailsRecordSet;
  				String selectQuery = "Select * From SLVProducts Where ProductName='" + productName +"'";;
  				Map <String, String> innerMap;
  				productDetailsRecordSet = cont.queryExcelToLinkedHashMap(System.getProperty("user.dir") + "/src/main/resources/excelFiles/AutomationTestDataFile.xlsx", selectQuery);
  				innerMap = productDetailsRecordSet.get(1);
  				switch(selectionMethod) {
  					case "URL":
  						addProductByURL (innerMap.get("ProductURL"), qty);
  						break;
  					case "PDP":
  						addProductByPDP (productName, innerMap.get("MetalType"), innerMap.get("Category1"), 
  								innerMap.get("Category2"), innerMap.get("Category3"), 
  								innerMap.get("Category4"), qty);
  						break;
  					case "PLP":
  						addProductByPLP (productName, innerMap.get("MetalType"), innerMap.get("Category1"), 
  								innerMap.get("Category2"), innerMap.get("Category3"), 
  								innerMap.get("Category4"), qty);
  						break;
  				}
  				break;
  			case "Update":
  				switch(selectionMethod) {
  					case "Cart":
  						updateProductInCart (productName, qty);
  						break;
  				}
  				break;
  			case "Delete":
  				switch(selectionMethod) {
  					case "Cart":
  						deleteProductInCart (productName);
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
  		if (metalType.equals("COPPER") || metalType.equals("ACCESSORIES")) {
  			xp(SLVqProp, "nav.topMenu.beg.xp", "OTHER", "nav.topMenu.end.xp");
  			xp(SLVqProp, "nav.subMenu.beg.xp", metalType, "nav.subMenu.end.xp");
  		} else
  		{
  			xp(SLVqProp, "nav.topMenu.beg.xp", metalType, "nav.topMenu.end.xp");
  		}
  		
  		if (!category1.isEmpty()) {
  			xp(SLVqProp, "nav.categorySelection.beg.xp", category1, "nav.categorySelection.end.xp");
  		}
  		
  		if (!category2.isEmpty()) {
  			xp(SLVqProp, "nav.categorySelection.beg.xp", category2, "nav.categorySelection.end.xp");
  		}
  		
  		if (!category3.isEmpty()) {
  			xp(SLVqProp, "nav.categorySelection.beg.xp", category3, "nav.categorySelection.end.xp");
  		}
  		
  		if (!category4.isEmpty()) {
  			xp(SLVqProp, "nav.categorySelection.beg.xp", category4, "nav.categorySelection.end.xp");
  		}
  	}
  	
  	/**********************************************************************
     * Description:     Adds a product and navigate through URL
     * Author:          Paul Patterson
     * Param:      		String productURL, String qty
     * Returns:         None
     **********************************************************************/
  	public void addProductByURL (String productURL, String qty) 
  	{
  		Q_Slv_CartSteps cart = new Q_Slv_CartSteps();
  		driver.navigate().to(baseUrl + productURL);
  		Q_Slv_WebElm.xpClear(SLVqProp, "pdp.product.qty.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "pdp.product.qty.xp", qty);
        Q_Slv_WebElm.xp(SLVqProp, "pdp.product.addToCart.xp");
        Q_Slv_WebElm.myWait(4000);
  	}
  	
  	/**********************************************************************
     * Description:     Adds a product and navigate through PDP
     * Author:          Paul Patterson
     * Param:      		String productName, String metalType, String category1, String category2, String category3, String category4, String qty
     * Returns:         None
     **********************************************************************/
  	public void addProductByPDP (String productName, String metalType, String category1, String category2, 
  			String category3, String category4, String qty) 
  	{
  		Q_Slv_CartSteps cart = new Q_Slv_CartSteps();
  		driver.navigate().to(baseUrl);
  		navigateToPLPPage (metalType, category1, category2, category3, category4);
  		xp(SLVqProp, "plp.productLink.beg.xp", productName, "plp.productLink.end.xp");
  		Q_Slv_WebElm.xpClear(SLVqProp, "pdp.product.qty.xp");
        Q_Slv_WebElm.xpSend(SLVqProp, "pdp.product.qty.xp", qty);
        Q_Slv_WebElm.xp(SLVqProp, "pdp.product.addToCart.xp");
        Q_Slv_WebElm.myWait(4000);
  	}
  	
  	/**********************************************************************
     * Description:     Adds a product and navigate through PLP
     * Author:          Paul Patterson
     * Param:      		String productName, String metalType, String category1, String category2, String category3, String category4, String qty
     * Returns:         None
     **********************************************************************/
  	public void addProductByPLP (String productName, String metalType, String category1, String category2, 
  			String category3, String category4, String qty) 
  	{
  		driver.navigate().to(baseUrl);
  		navigateToPLPPage (metalType, category1, category2, category3, category4);
  		xpSend(SLVqProp, "plp.product.beg.xp", productName, "plp.productQty.end.xp", qty);
  		xp(SLVqProp, "plp.product.beg.xp", productName, "plp.productAddToCart.end.xp");
  		Q_Slv_WebElm.myWait(4000);
  	}
  	
  	/**********************************************************************
     * Description:     Updates a specific item in the cart
     * Author:          Paul Patterson
     * Param:      		String productName, String qty
     * Returns:         None
     **********************************************************************/
  	public void updateProductInCart (String productName, String qty) 
  	{
  		Q_Slv_CartSteps cart = new Q_Slv_CartSteps();
  		driver.navigate().to(baseUrl + "/cart/");
  		Q_Slv_WebElm.id(SLVqProp, "cart.paymentType.PC.id");
  		xpClear(SLVqProp, "cart.product.beg.xp", productName, "cart.productQty.end.xp");
  		xpSend(SLVqProp, "cart.product.beg.xp", productName, "cart.productQty.end.xp", qty);
  		xp(SLVqProp, "cart.product.beg.xp", productName, "cart.productUpdateCart.end.xp");
  	}
  	
  	/**********************************************************************
     * Description:     Deletes a specific item in the cart
     * Author:          Paul Patterson
     * Param:      		String productName, String qty
     * Returns:         None
     **********************************************************************/
  	public void deleteProductInCart (String productName)
  	{
  		Q_Slv_CartSteps cart = new Q_Slv_CartSteps();
  		driver.navigate().to(baseUrl + "/cart/");
  		Q_Slv_WebElm.id(SLVqProp, "cart.paymentType.PC.id");
  		xp(SLVqProp, "cart.product.beg.xp", productName, "cart.productRemove.end.xp");
  	}
   	//JMB-7670 End
}
