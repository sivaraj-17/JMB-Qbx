package testcases.cart;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Q_PM_CartSteps;
import pageObjects.Q_PM_WebElm;
import pageObjects.Q_PM_NavigationSteps;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;


public class Q_PM_AddToCart extends Q_PM_Init {

    @BeforeClass
    public void tcSetup () throws Exception {

    }
    @BeforeMethod
    public void setUser () throws Exception {
        Q_PM_Init.setItUp();
    }
    @Test(priority = 1)
    public static void gold_1_gram(Integer quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);

        String description= "1-gram-gold-bar-sunshine-mint";
        driver.navigate().to(baseUrl + "/1-gram-gold-bar-sunshine-mint.html");
        Q_PM_CartSteps.addProductpageItemToCart(quan);
    }
    @Test(priority = 1)
    public static void gold_5_gram(Integer quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);

        String description= "5-gram-perth-mint-gold-bar";
        driver.navigate().to(baseUrl + "/5-gram-perth-mint-gold-bar.html");
        Q_PM_CartSteps.addProductpageItemToCart(quan);
    }
    /*******************************************************************
    // * Description: Add Gold Coin Category Subcategory 1 item 7
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1)
    public static void gold_1_2553140(String quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "1 oz US American Gold Eagle Coin";
        Q_PM_NavigationSteps.selectMetal("gold");
        Q_PM_WebElm.myWait(1000);
        Q_PM_NavigationSteps.category("firstLevel", 1, 1);
        Q_PM_WebElm.myWait(1000);
        Q_PM_NavigationSteps.category("secondLevel", 1, 1);
        Q_PM_WebElm.myWait(2000);
        Q_PM_CartSteps.addToCart("cart.begCatQuan.xp", 4, "cart.endCatQuan.xp", quan, "cart.endCatAtc.xp", "cart.modalCheckoutBtn.className");
        Q_PM_WebElm.myWait(2000);
        
    }

    /*******************************************************************
    // * Description: Add 5grams gold bar sub category 2
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 2)
    public static void gold_2_2555362(String quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "10 gram Perth Mint Gold Bar";
        Q_PM_NavigationSteps.selectMetal("gold");
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("firstLevel", 1, 2);
        Q_PM_NavigationSteps.category("secondLevel", 1, 2);
        Q_PM_NavigationSteps.category("thirdLevel", 1, 4);
        Q_PM_WebElm.myWait(2000);
        Q_PM_CartSteps.modalPlus("cart.begCatQuan.xp", 1, "cart.endCatQuan.xp", quan, "cart.goldTC2555362.xp");
        Q_PM_WebElm.myWait(2000);
        
    }
    /*******************************************************************
    // * Description: Add 1/4 oz Chinese Gold Panda sub category 1
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 3)
    public static void gold_3_2553276(String quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "1/4 oz Chinese Gold Panda";
        Q_PM_WebElm.myWait(1000);
        Q_PM_NavigationSteps.selectMetal("gold");
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("firstLevel", 1, 5);
        Q_PM_WebElm.myWait(1000);
        Q_PM_NavigationSteps.category("secondLevel", 2, 4);
        Q_PM_WebElm.myWait(4000);

        Q_PM_CartSteps.modalMinus("cart.begCatQuan.xp", 4, "cart.endCatQuan.xp", quan, "cart.endCatAtc.xp");
        Q_PM_WebElm.myWait(2000);
        
    }
    /*******************************************************************
    // * Description: Add 10 oz Gold Bar sub category 2
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 4)
    public static void gold_4_2569050(String quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "10 oz Gold Bar";
        Q_PM_NavigationSteps.selectMetal("gold");
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("firstLevel", 1, 2);
        Q_PM_NavigationSteps.category("secondLevel", 1, 2);
        Q_PM_NavigationSteps.category("thirdLevel", 2, 4);
        Q_PM_WebElm.myWait(4000);
        Q_PM_CartSteps.addToCart("cart.begCatQuan.xp", 1, "cart.endCatQuan.xp", quan, "cart.endCatAtc.xp", "cart.modalCheckoutBtn.className");
        Q_PM_WebElm.myWait(2000);
        
    }
    /*******************************************************************
     // * Description: Add 5grams gold bar sub category 2
     // * Author:
     // * Status: Complete
     //*******************************************************************/
//    @Test (priority = 5)
    public static void gold_5_63(String quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "1/4 oz US American Gold Eagle Coin";
        Q_PM_NavigationSteps.selectMetal("gold");
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("firstLevel", 1, 1);
        Q_PM_NavigationSteps.category("secondLevel", 1, 1);

        Q_PM_WebElm.myWait(2000);
        Q_PM_CartSteps.addToCart("cart.begCatQuan.xp", 1, "cart.endCatQuan.xp", quan, "cart.endCatAtc.xp");
        Q_PM_WebElm.myWait(2000);

    }
    /*******************************************************************
    // * Description: Add 1994 1 oz American Silver Eagle sub category 2
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 5)
    public static void silver_1_2553427(String quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "1994 1 oz American Silver Eagle";
        Q_PM_NavigationSteps.selectMetal("silver");
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("firstLevel", 1, 3);
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("secondLevel", 1, 1);
        Q_PM_WebElm.myWait(2000);
        //Q_PM_NavigationSteps.category("thirdLevel", 1, 1);
        //Q_PM_WebElm.myWait(4000);
        Q_PM_CartSteps.addToCart("cart.begCatQuan.xp", 16, "cart.endCatQuan.xp", quan, "cart.endCatAtc.xp", "cart.modalCheckoutBtn.className");
        Q_PM_WebElm.myWait(2000);
        
    }
    /*******************************************************************
    // * Description: Add Peace Silver Dollar Coin PCGS MS64 (1922-26, 1934-35 sub category 1
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 6)
    public static void silver_2_2553739(String quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "Peace Silver Dollars | PCGS MS64)";
        Q_PM_NavigationSteps.selectMetal("silver");
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("firstLevel", 3, 2);
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("secondLevel", 1, 2);
        Q_PM_WebElm.myWait(2000);
        Q_PM_CartSteps.addToCart("cart.begCatQuan.xp", 3, "cart.endCatQuan.xp", quan, "cart.endCatAtc.xp", "cart.modalCheckoutBtn.className");
        Q_PM_WebElm.myWait(2000);
    }
    /*******************************************************************
    // * Description: Add PAMP 100 oz Silver Bar sub category 1
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 7)
    public static void silver_3_2568377(String quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "100 oz .999 Fine Silver Bar";
        Q_PM_NavigationSteps.selectMetal("silver");
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("firstLevel", 1, 2);
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("secondLevel", 2, 1);
        Q_PM_WebElm.myWait(4000);
        Q_PM_CartSteps.addToCart("cart.begCatQuan.xp", 1, "cart.endCatQuan.xp", quan, "cart.endCatAtc.xp", "cart.modalCheckoutBtn.className");
        Q_PM_WebElm.myWait(2000);
    }
    /*******************************************************************
    // * Description: Add 2019 1 oz Platinum American Eagle sub category 1 Product page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 8)
    public static void platinum_1_2568821(String quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "1 oz US American Platinum Eagle Coin | Random Year";
        Q_PM_NavigationSteps.selectMetal("platinum");
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("firstLevel", 1, 1);
        Q_PM_CartSteps.atcPDP( quan, "cart.modalCheckoutBtn.className");
        Q_PM_WebElm.myWait(2000);        
    }
    
    /*******************************************************************
    // * Description: PAMP Suisse 1/2 oz Platinum Fortuna Bar sub category 1 Increase quantity Product page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 9)
    public static void platinum_2_2568502(String quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "Valcambi 1 oz Platinum Bar";
        Q_PM_NavigationSteps.selectMetal("platinum");
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("secondLevel", 2, 3);
        Q_PM_CartSteps.pdpPlus(quan, "cart.modalCheckoutBtn.className");
        Q_PM_WebElm.myWait(2000);        
    }
    
    /*******************************************************************
    // * Description: 10 oz Platinum Bar | Credit Suisse sub category 1 Decrease quantity Product page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 10)
    public static void platinum_3_2566983(String quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "10 oz Platinum Bar | Credit Suisse";
        Q_PM_NavigationSteps.selectMetal("platinum");
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("secondLevel", 3, 2);
        driver.navigate().to(baseUrl + "/platinum/credit-suisse-platinum.html");
        Q_PM_CartSteps.pdpMinus(quan, "cart.modalCheckoutBtn.className");
        Q_PM_WebElm.myWait(2000);       
    }
    
    /*******************************************************************
    // * Description: Canadian 1 oz Palladium Maple Leaf sub category 1
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 11)
    public static void palladium_1_2555121(String quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "Canadian 1 oz Palladium Maple Leaf";
        Q_PM_NavigationSteps.selectMetal("palladium");
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("secondLevel", 1, 2);
        Q_PM_WebElm.myWait(2000);
        Q_PM_CartSteps.addToCart("cart.begCatQuan.xp", 1, "cart.endCatQuan.xp", quan, "cart.endCatAtc.xp", "cart.modalCheckoutBtn.className");
        Q_PM_WebElm.myWait(2000);
    }
    
    /*******************************************************************
    // * Description: Baird & Co. | 1 oz .999 Fine Rhodium Bar no category
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 12)
    public static void rhodium_1_2560157(String quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "Baird & Co. | 1 oz .999 Fine Rhodium Bar";
        Q_PM_NavigationSteps.selectMetal("rhodium");
        Q_PM_CartSteps.clickATC("cart.rhodium2560157.xp", "cart.modalCheckoutBtn.className");
        Q_PM_WebElm.myWait(2000);
        Q_PM_CartSteps.verifyCartItem(description, "1");
    }
    
    /*******************************************************************
    // * Description: Add Trade Dollar 1 oz Copper Round no category
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 13)
    public static void copper_1_2563821(String quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "Trade Dollar 1 oz Copper Round";
        Q_PM_NavigationSteps.selectMetal("copper-rounds");
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("secondLevel", 1, 1);
        Q_PM_WebElm.myWait(2000);
        Q_PM_CartSteps.addToCart("cart.begCatQuan.xp", 1, "cart.endCatQuan.xp", quan, "cart.endCatAtc.xp", "cart.modalCheckoutBtn.className");
        Q_PM_WebElm.myWait(2000);
    }
    
    /*******************************************************************
    // * Description: Add 2 Pound .999 Fine Copper | Our Choice  no category
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 14)
    public static void copper_2_2563818(String quan){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        String description= "Maple Leaf 1 oz Copper Round";
        Q_PM_NavigationSteps.selectMetal("copper-rounds");
        Q_PM_WebElm.myWait(2000);
        Q_PM_NavigationSteps.category("secondLevel", 1, 1);
        Q_PM_WebElm.myWait(2000);
        Q_PM_CartSteps.addToCart("cart.begCatQuan.xp", 2, "cart.endCatQuan.xp", quan, "cart.endCatAtc.xp", "cart.modalCheckoutBtn.className");
    }

    /*******************************************************************
    // * Description: Palladium for tax test cases
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void taxPalladiunCoin(String quan) {  // Bullion, Legal tender, Palladium
        driver.navigate().to(baseUrl + "/canada-maple-leaf-1-oz-9995-fine-palladium.html");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdp.qty.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.pdp.qty.xp", quan);
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }

    public static void taxPalladiunBar10g(String quan) {  // Bullion and Palladium
        driver.navigate().to(baseUrl + "/shop/uncategorized/10-gram-pamp-suisse-fortuna-palladium-bar-new-w-assay/");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdp.qty.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.pdp.qty.xp", quan);
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }

    /*******************************************************************
    // * Description: Palladium Bar for tax test caes
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    //@Step
    public static void taxCopper(String quan) {
        driver.navigate().to(baseUrl + "/trade-dollar-1-oz-copper-round.html");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdp.qty.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.pdp.qty.xp", quan);
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }
    
    /*******************************************************************
    // * Description: Palladium Bar for tax test caes
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    public static void taxSiNumsmatic(String quan) {
        driver.navigate().to(baseUrl + "/shop/uncategorized/2016-1-oz-canadian-silver-peregrine-falcon-reverse-proof-coin-ngc-pf70-er/");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdp.qty.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.pdp.qty.xp", quan);
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }
    
    public static void taxSiBullion(String quan) {  // Bullion, Legal tender
        driver.navigate().to(baseUrl + "/2016-american-silver-eagle.html");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdp.qty.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.pdp.qty.xp", quan);
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }
    
    public static void taxSiBullion2(String quan) {  // Bullion, Min purity 995
        driver.navigate().to(baseUrl + "/asahi-1-kilo-silver-bar.html");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdp.qty.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.pdp.qty.xp", quan);
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }
    
    public static void taxGoArtWork(String quan) { // Artwork, Min purity 995
        driver.navigate().to(baseUrl + "/5-g-atlantis-mint-poured-silver-bar.html");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdp.qty.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.pdp.qty.xp", quan);
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }
    
    /*******************************************************************
    // * Description: Gold for tax test cases
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    public static void taxGoldLegalTender(String quan) {  //Bullion, Legal tender, US Face Value
        driver.navigate().to(baseUrl + "/1-oz-us-american-gold-eagle-coin-dates-our-choice.html");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdp.qty.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.pdp.qty.xp", quan);
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");

    }
    
    public static void taxGoNumsmatic(String quan) { //Numsmatic, Bullion, Ciculating Currency, Legal ender, US Face Value
        driver.navigate().to(baseUrl + "/10-liberty-us-mint-gold-eagle-low-premium.html");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdp.qty.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.pdp.qty.xp", quan);
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }

    /*******************************************************************
    // * Description: Platinum Bar for tax test caes
    // * Author:
    // * Status: Complete
    //*******************************************************************/
        public static void taxPlatinumCoin(String quan) { // Bullion, legal tender, platinum, Min purity 995, US Face Value
        driver.navigate().to(baseUrl + "/2019-british-1-10-oz-platinum-britannia.html");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdp.qty.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.pdp.qty.xp", quan);
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }
    
    public static void taxPlatinumBar(String quan) { // Bullion and platinum, Min purity 995
        driver.navigate().to(baseUrl + "/1-oz-9995-platinum-bar-pamp-suisse.html");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdp.qty.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.pdp.qty.xp", quan);
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }
    
    /*******************************************************************
    // * Description: Palladium Bar for tax test caes
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    public static void taxAccessories(String quan) {  // Accessories
        driver.navigate().to(baseUrl + "/american-gold-eagle-tubes-33-mm.html");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xpClear(pmQaProps, "cart.pdpQty.xp");
        Q_PM_WebElm.xpSend(pmQaProps, "cart.pdpQty.xp", quan);
        Q_PM_WebElm.xp(pmQaProps, "cart.pdp.atc.xp");
        Q_PM_WebElm.cn(pmQaProps, "cart.modalCheckoutBtn.className");
    }

//    @AfterClass(alwaysRun = true)
//    public static void remove(){
//        CartSteps.verifyCartItems();
//        CartSteps.deleteItems();
//    }

}
