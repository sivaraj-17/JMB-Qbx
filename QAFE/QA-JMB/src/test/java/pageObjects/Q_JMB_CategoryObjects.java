package pageObjects;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Q_JMB_Init;

import java.text.DecimalFormat;
import java.util.Properties;

public class Q_JMB_CategoryObjects extends Q_JMB_Init {

    public Q_JMB_CategoryObjects() {

    }

    public Q_JMB_CategoryObjects spotPrices(Properties proper, String locator) {
        String goldAsk = Q_JMB_WebElm.xpRetText(jmbProps, "cart.gold.spot.xp");
        String silverAsk = Q_JMB_WebElm.xpRetText(jmbProps, "cart.silver.spot.xp");
        String platinumAsk = Q_JMB_WebElm.xpRetText(jmbProps, "cart.platinum.spot.xp");
        String palladiumAsk = Q_JMB_WebElm.xpRetText(jmbProps, "cart.palladium.spot.xp");
        System.out.println("Gold spot price " + goldAsk + "\t Silver spot price " + silverAsk + "\t Platinum spot price " + platinumAsk + "\t Silver spot price " + palladiumAsk);
        System.out.println("Mega Menu Gold spot price " + goldAsk + "\t Silver spot price " + silverAsk + "\t Platinum spot price " + platinumAsk + "\t Silver spot price " + palladiumAsk);
        return this;
    }

    public Q_JMB_CategoryObjects sortLowToHigh(Properties proper, String locator) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Sort By']")));
        Q_JMB_WebElm.xp(jmbProps, locator);
        Q_JMB_WebElm.id(jmbProps, "cart.cart.lowToHigh.id");
        return this;
    }
    public Q_JMB_CategoryObjects sort(String locator, Integer index) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Sort By']")));
        Q_JMB_WebElm.xp(jmbProps, locator);
        Q_JMB_WebElm.myWait(500);
        switch(index){
            case(1):
                Q_JMB_WebElm.id(jmbProps, "cart.cart.popularity.id");
                break;
            case(2):
                Q_JMB_WebElm.id(jmbProps, "cart.cart.recently.id");
                break;
            case(3):
                Q_JMB_WebElm.id(jmbProps, "cart.cart.lowToHigh.id");
                break;
            case(4):
                Q_JMB_WebElm.id(jmbProps, "cart.cart.highToLow.id");
                break;
            case(5):
                Q_JMB_WebElm.id(jmbProps, "cart.cart.weightAsc.id");
                break;
            case(6):
                Q_JMB_WebElm.id(jmbProps, "cart.cart.weightDesc.id");
                break;
            default:
                System.out.println("Invalid sort option selected");
                break;
        }
        return this;
    }

    public static String itemDescription(Integer item) {
        String begQtyXp = "cart.quantity.beg.xp";
        String endDescXp = "cart.link.end.xp";
        return Q_JMB_WebElm.xpRetText(jmbProps, begQtyXp, item, endDescXp);
    }
    public Q_JMB_CategoryObjects categoryItemLink(Integer item) {
        String begQtyXp = "cart.quantity.beg.xp";
        String endDescXp = "cart.link.end.xp";
        Q_JMB_WebElm.xp(jmbProps, begQtyXp, item, endDescXp);
        return this;
    }
    public Q_JMB_CategoryObjects lineQty(Integer item, String quan) {
        String begQtyXp = "cart.quantity.beg.xp";
        String endQtyXp = "cart.quantity.end.xp";
        Q_JMB_WebElm.xpSend(jmbProps, begQtyXp, item, endQtyXp, quan);
        return this;
    }

    public Q_JMB_CategoryObjects atc(Integer item) {
        String begQtyXp = "cart.quantity.beg.xp";
        String endAtcXp = "cart.atc.end.xp";
        Q_JMB_WebElm.xp(jmbProps, begQtyXp, item, endAtcXp);
        return this;
    }

    public static float modalCheckPrice() {
        DecimalFormat df = new DecimalFormat("#.00");
        float checkPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.modal.price.Check.xp"));
        return checkPrice;
    }

    public static float modalBitcoinPrice() {
        DecimalFormat df = new DecimalFormat("#.00");
        float bitCoinPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.modal.price.bitCoin.xp"));
        return bitCoinPrice;
    }

    public static float modalCreditPrice() {
        DecimalFormat df = new DecimalFormat("#.00");
        float creditPrice = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.modal.price.credit.xp"));
        return creditPrice;
    }
    public Q_JMB_CategoryObjects modalPaymentTypePricing(String product, Integer item, String quan){
        DecimalFormat df = new DecimalFormat("#.00");
        Q_JMB_CategoryObjects co = new Q_JMB_CategoryObjects();
        co.lineQty(item, quan);
        co.atc(item);
        System.out.println(product);
        System.out.println("Check price" + String.valueOf(df.format(modalCheckPrice())));
        System.out.println("Bitcoin price" + String.valueOf(df.format(modalBitcoinPrice())));
        System.out.println("Credit card price" + String.valueOf(df.format(modalCreditPrice())));
        if(modalCheckPrice() < modalBitcoinPrice() || modalBitcoinPrice() < modalCreditPrice()){
            System.out.println("Modal payment type pricing verified");
        }
        else{
            System.out.println("Modal payment type pricing failed");
        }
        return this;
    }
    public Q_JMB_CategoryObjects modalContinue() {
        Q_JMB_WebElm.xp(jmbProps, "cart.modal.CheckoutNow.xp");
        return this;
    }
    public Q_JMB_CategoryObjects modalPlus(){
        Q_JMB_WebElm.cn(jmbProps, "cart.modal.plus.className");
        Q_JMB_WebElm.xp(jmbProps, "cart.modal.updateBtn.xp");
        return this;
    }
    public Q_JMB_CategoryObjects modalMinus(){
        Q_JMB_WebElm.cn(jmbProps, "cart.modal.minus.className");
        Q_JMB_WebElm.xp(jmbProps, "cart.modal.updateBtn.xp");
        return this;
    }
    public Q_JMB_CategoryObjects categoryItem(String product, Integer item, String quan) {
        lineQty(item, quan);
        atc(item);
        modalContinue();
        Assert.assertTrue(Q_JMB_WebElm.idDisplayed(jmbProps, "cart.paymentType.BC.id"));
        return this;
    }
    public static void goldEagle(String quan){
        Integer item = 6;
        Q_JMB_NavigationObjects.selectFromMenu("gold");
        Q_JMB_CartPageObjects.category("american gold coin");
        Q_JMB_CartPageObjects.category("uncirculated gold eagle");
        Q_JMB_CategoryObjects coin = new Q_JMB_CategoryObjects();
        String itemDescription = itemDescription(item);
        coin.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        coin.lineQty(item,quan);
        coin.atc(item);
        System.out.println( itemDescription  + " " + String.valueOf(modalCreditPrice()));
        coin.modalContinue();

    }
    public static void quarterGoldEagle(String quan){
        Integer item = 2;
        Q_JMB_NavigationObjects.selectFromMenu("gold");
        Q_JMB_CartPageObjects.category("american gold coin");
        Q_JMB_CartPageObjects.category("uncirculated gold eagle");
        Q_JMB_CategoryObjects coin = new Q_JMB_CategoryObjects();
        String itemDescription = itemDescription(item);
        coin.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        coin.lineQty(item,quan);
        coin.atc(item);
        System.out.println( itemDescription  + " " + String.valueOf(modalCreditPrice()));

    }
    public static void preSale(String quan){
        Integer item = 5;
        Q_JMB_NavigationObjects.selectFromMenu("gold");
        Q_JMB_CartPageObjects.category("gold bars");
        Q_JMB_CategoryObjects bar = new Q_JMB_CategoryObjects();
        bar.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        String itemDescription = itemDescription(item);
        bar.lineQty(item,quan);
        bar.atc(item);
        System.out.println( "Added: " + quan + " " + itemDescription);
        System.out.println(itemDescription + " " + String.valueOf(modalCreditPrice()));
        bar.modalContinue();


    }
    public static void perthMintGoldBar(String quan){
        Integer item = 14;
        Q_JMB_NavigationObjects.selectFromMenu("gold");
        Q_JMB_CartPageObjects.category("gold bars");
        Q_JMB_CategoryObjects bar = new Q_JMB_CategoryObjects();
        bar.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        String itemDescription = itemDescription(item);
        bar.lineQty(item,quan);
        bar.atc(item);
        System.out.println( "Added: " + quan + " " + itemDescription);
        System.out.println(itemDescription + " " + String.valueOf(modalCreditPrice()));
        bar.modalContinue();
    }
    public static void chinesePanda(String quan){
        Integer item = 3;
        Q_JMB_NavigationObjects.selectFromMenu("gold");
        Q_JMB_CartPageObjects.category("chinese panda");
        Q_JMB_CategoryObjects coin = new Q_JMB_CategoryObjects();
        coin.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        String itemDescription = itemDescription(item);
        coin.lineQty(item,quan);
        coin.atc(item);
        System.out.println("Added: " + (Integer.valueOf(quan) + 1) + " " + itemDescription);
        System.out.println(itemDescription + " " + String.valueOf(modalCreditPrice()));
        coin.modalPlus();
        coin.modalContinue();
    }
    public static void goldBar1gSunshine(String quan){
        Integer item = 2;
        Q_JMB_NavigationObjects.selectFromMenu("gold");
        Q_JMB_CartPageObjects.category("gold bars");
        Q_JMB_CategoryObjects bar = new Q_JMB_CategoryObjects();
        bar.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        String itemDescription = itemDescription(item);
        bar.lineQty(item,quan);
        bar.atc(item);
        System.out.println("Added: " + quan + " " + itemDescription);
        System.out.println(itemDescription + " " + String.valueOf(modalCreditPrice()));
        bar.modalContinue();
    }
    public static void goldBar10oz(String quan){
        Integer item = 43;
        Q_JMB_NavigationObjects.selectFromMenu("gold");
        Q_JMB_CartPageObjects.category("gold bars");
        Q_JMB_CategoryObjects bar = new Q_JMB_CategoryObjects();
        bar.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        String itemDescription = itemDescription(item);
        bar.lineQty(item,quan);
        bar.atc(item);
        System.out.println("Added: " + quan + " " + itemDescription);
        System.out.println(itemDescription + " " + String.valueOf(modalCreditPrice()));
        bar.modalContinue();
    }
    public static void silverCoin1994(String quan){
        Integer item = 13;
        Q_JMB_NavigationObjects.selectFromMenu("silver");
//        CartPageObjects.category("silver coins");  //staging only
        Q_JMB_CartPageObjects.category("american silver eagle");
        Q_JMB_CartPageObjects.category("uncirculated silver eagle");
        Q_JMB_CategoryObjects coin = new Q_JMB_CategoryObjects();
        coin.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        String itemDescription = itemDescription(item);
        coin.lineQty(item,quan);
        coin.atc(item);
        System.out.println("Added: " + quan + " " + itemDescription);
        System.out.println(itemDescription + " " + String.valueOf(modalCreditPrice()));
        coin.modalContinue();
    }
    public static void silverGeigerSecurity(String quan){
        Integer item = 3;
        Q_JMB_NavigationObjects.selectFromMenu("silver");
        Q_JMB_CartPageObjects.category("silver bars");
        Q_JMB_CartPageObjects.category("100 oz bars");
        Q_JMB_CategoryObjects bar = new Q_JMB_CategoryObjects();
        bar.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        String itemDescription = itemDescription(item);
        bar.lineQty(item,quan);
        bar.atc(item);
        bar.modalMinus();
        System.out.println("Added: " + (Integer.valueOf(quan) -1)  + " " + itemDescription);
        System.out.println(itemDescription + " " + String.valueOf(modalCreditPrice()));
        bar.modalContinue();
    }

    public static void silverPeaceSilverDollarCoi(String quan){
        Integer item = 1;
        Q_JMB_NavigationObjects.selectFromMenu("silver");
//        CartPageObjects.category("silver coins"); //staging only
        Q_JMB_CartPageObjects.category("silver dollar");
        Q_JMB_CartPageObjects.category("peace silver dollar");
        Q_JMB_CategoryObjects item2 = new Q_JMB_CategoryObjects();
        item2.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        item2.sort("cart.cart.sort.xp", 3);
        String itemDescription = itemDescription(item);
        item2.lineQty(item,quan);
        item2.atc(item);
        System.out.println("Added: " + quan + " " + itemDescription);
        System.out.println(itemDescription + " " + String.valueOf(modalCreditPrice()));
        item2.modalContinue();
    }
    public static void britishCoin(String quan){
        Integer item = 7;
        Q_JMB_CartPageObjects.category("British Platinum Coin");
        Q_JMB_CategoryObjects coin = new Q_JMB_CategoryObjects();
        coin.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        String itemDescription = itemDescription(item);
        coin.lineQty(item,quan);
        coin.atc(item);
    }
    public static void copperUSQuarter(String quan){
        Integer item = 16;
//        NavigationSteps.selectFromMenu("other");
//        NavigationSteps.innerMega("copper rounds");
        driver.navigate().to(baseUrl + "/copper/copper-rounds/");
        Q_JMB_CategoryObjects coin = new Q_JMB_CategoryObjects();
        coin.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        String itemDescription = itemDescription(item);
        coin.lineQty(item,quan);
        coin.atc(item);
        System.out.println("Added: " + quan + " " + itemDescription);
        System.out.println(itemDescription + " " + String.valueOf(modalCreditPrice()));
        coin.modalContinue();
    }
    public static void copperWalkingLiberty(String quan){
        Integer item = 1;
        Q_JMB_NavigationObjects.selectFromMenu("other");
        Q_JMB_NavigationObjects.innerMega("copper rounds");
        Q_JMB_CategoryObjects coin = new Q_JMB_CategoryObjects();
        coin.sortLowToHigh(jmbProps, "cart.cart.sort.xp");
        String itemDescription = itemDescription(item);
        coin.lineQty(item,quan);
        coin.atc(item);
//        ExtentTestManager.getTest().log(LogStatus.INFO, "Added: " + quan + " ", itemDescription);
//        ExtentTestManager.getTest().log(LogStatus.INFO,  itemDescription, String.valueOf(modalCreditPrice()));
//        coin.modalContinue();
    }
    public static float military10ozPlatinumBar(String quan) {
        driver.navigate().to(baseUrl + "/10-oz-credit-suisse-platinum-bar/");
        float checkPrice1 = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.military.check.xp"));

        System.out.println( " Check Price " + checkPrice1 );
        Q_JMB_WebElm.xpClear(jmbProps, "cart.military.quantiy.xp");
        Q_JMB_WebElm.xpSend(jmbProps, "cart.military.quantiy.xp", quan);
        Q_JMB_WebElm.xp(jmbProps, "cart.military.product.atc.xp");
        Q_JMB_WebElm.xp(jmbProps, "cart.modal.CheckoutNow.xp");
        return checkPrice1;
    }
    public static float militaryAcc32mmAirTiteHolder(String quan) {
        driver.navigate().to(baseUrl + "/32-mm-air-tite-coin-holder-df/");
        float checkPrice2 = Float.valueOf(Q_JMB_WebElm.xpRetTextReplace(jmbProps, "cart.military.check.xp"));
        System.out.println( " Military Discount " + Q_JMB_WebElm.xpRetText(jmbProps, "cart.military.discount.xp"));
        Q_JMB_WebElm.xpClear(jmbProps, "cart.military.quantiy.xp");
        Q_JMB_WebElm.xpSend(jmbProps, "cart.military.quantiy.xp", quan);
        Q_JMB_WebElm.xp(jmbProps, "cart.military.product.atc.xp");
        Q_JMB_WebElm.xp(jmbProps, "cart.modal.CheckoutNow.xp");
        return checkPrice2;
    }
    public Q_JMB_CategoryObjects selectItem(String item, Integer quan) throws Exception {
        Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
        Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
        switch ( item ){
            case("perth10g"):
                driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar/");
                Q_JMB_WebElm.myWait(1000);
                cart.addItemToCart(quan);
                cart.selectPaymentType("cheque");
                cart.selectcheckoutBtn("top");
                chk.completeOrder();
                driver.navigate().to(adminUrl);
                break;
            case("preSale"):
                driver.navigate().to(baseUrl + "/2-5-gram-valcambi-gold-bar/");
                Q_JMB_WebElm.myWait(1000);
                cart.addItemToCart(quan);
                cart.selectPaymentType("cheque");
                cart.formId("cart.preSaleMsgCheckbox.id");
                cart.selectcheckoutBtn("top");
                chk.completeOrder();
                driver.navigate().to(adminUrl);
                break;
            case("auto limit"):
                driver.navigate().to(baseUrl + "/1-oz-silver-bar/");
                cart.addItemToCart(quan);
                cart.selectPaymentType("cheque");
                cart.selectcheckoutBtn("top");
//                CheckoutSteps.cardType(3, "selectedCard.xp", "cvv.id");
                chk.completeOrder();
                driver.navigate().to(adminUrl);
                break;
            case("silverEagle1994"):
                driver.navigate().to(baseUrl + "/1994-american-silver-eagle/");
                cart.addItemToCart(quan);
                cart.selectPaymentType("credit card");
                cart.selectcheckoutBtn("top");
                chk.cvvCardType(3);

                chk.completeOrder();
                String orderNo = chk.strXpText("cart.thankyouOrderNumber.xp").replaceAll("[^0-9?!\\.]","");
                System.out.println("Order Number " + orderNo);
                driver.navigate().to(adminUrl);
                break;
            case("platinumEagle1oz"):
                System.out.println("Verified user is on the customer page pages");
                driver.navigate().to(baseUrl + "/1-oz-american-platinum-eagle-varied/");
                cart.addItemToCart(quan);
                cart.selectPaymentType("wire");
                cart.selectcheckoutBtn("top");
                chk.completeOrder();
                break;
            case("copperUSQuarter"):
                driver.navigate().to(baseUrl + "/1-oz-quarter-copper-round/");
                cart.addItemToCart(quan);
                cart.selectPaymentType("credit card");
                cart.selectcheckoutBtn("top");
                chk.cvvCardType(3);
                chk.completeOrder();
                break;
            case("2015silverTube"):
                driver.navigate().to(baseUrl + "/2015-american-silver-eagle-tube-20-coins/");
                cart.addItemToCart(quan);
                cart.selectPaymentType("credit card");
                cart.selectcheckoutBtn("top");
                chk.cvvCardType(3);
                chk.completeOrder();
                break;
            case("2019 1 oz Canadian Silver Maple Leaf Coin (BU)"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf/");
                cart.addItemToCart(quan);
                cart.selectPaymentType("credit card");
                cart.selectcheckoutBtn("top");
                chk.cvvCardType(3);
                chk.completeOrder();
                break;
            case("2019 Canadian Silver Maple Leaf Tube (25 Coins, BU)"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf-tube");
                cart.addItemToCart(quan);

                cart.selectPaymentType("credit card");
                cart.selectcheckoutBtn("top");
                chk.cvvCardType(3);
                chk.completeOrder();
                break;
            case("2019 Canadian Silver Maple Leaf Monster Box (500 Coins, BU)"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf-monster-box/");
                cart.addItemToCart(quan);
                cart.selectPaymentType("cheque");
                cart.selectcheckoutBtn("top");
//                CheckoutSteps.cardType(3, "selectedCard.xp", "cvv.id");
                chk.completeOrder();
                break;
            case("2019 Canadian Silver Maple Leaf Combo1"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf/");
                cart.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf-tube");
                cart.addItemToCart(quan);
                cart.selectPaymentType("credit card");
                cart.selectcheckoutBtn("top");
                chk.cvvCardType(3);
                chk.completeOrder();
                break;
            case("2019 Canadian Silver Maple Leaf Combo2"):
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf/");
                cart.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf-tube");
                cart.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf-monster-box/");
                cart.addItemToCart(quan);
                cart.selectPaymentType("cheque");
                cart.selectcheckoutBtn("top");
//                CheckoutSteps.cardType(3, "selectedCard.xp", "cvv.id");
                chk.completeOrder();
                break;
            case("multiple products"):
                driver.navigate().to(baseUrl + "/1-oz-quarter-copper-round/");
                cart.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/1-oz-american-platinum-eagle-varied/");
                cart.addItemToCart(quan);
                driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar/");
                cart.addItemToCart(quan);
                Q_JMB_WebElm.myWait(1000);


                cart.selectPaymentType("cheque");
                cart.applyGiftCertificate();
                cart.selectcheckoutBtn("top");
                chk.regShippingUpgrade("option2");
//                CheckoutSteps.cardType(3, "selectedCard.xp", "cvv.id");
                chk.completeOrder();
                break;

            default:
                System.out.println("Item not found");

                break;
        }
        return this;
    }

    // start JMB-6867
    // Added  britishCoin(String quan)  Q_CategoryObject


    //jmb-6867 end
}
