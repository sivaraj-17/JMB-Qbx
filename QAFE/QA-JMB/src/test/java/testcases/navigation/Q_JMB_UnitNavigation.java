package testcases.navigation;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.text.DecimalFormat;

public class Q_JMB_UnitNavigation extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();

    @BeforeClass
    public void tcSetup (){

    }
    @BeforeMethod
    public void report() throws Exception {
        Q_JMB_Init.setItUp();

    }
    @BeforeTest
    public void setExtent() throws Exception {

    }
    @Test()
    public void loanToValueCalculator(String gold, String silver,String platinum,String palladium) {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        DecimalFormat df = new DecimalFormat("#.00");
        Q_JMB_WebElm.xpSend(jmbProps, "nav.loans.GoldOunce.textbox.xp", gold);
        Q_JMB_WebElm.xpSend(jmbProps, "nav.loans.SilverOunce.textbox.xp", silver);
        Q_JMB_WebElm.xpSend(jmbProps, "nav.loans.PlatinumOunce.textbox.xp", platinum);
        Q_JMB_WebElm.xpSend(jmbProps, "nav.loans.PalladiumOunce.textbox.xp", palladium);
        Q_JMB_WebElm.xp(jmbProps, "nav.loans.calculateBtn.xp");

        String goldText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.goldSpot.xp");
        Float goldSpotPrice = Float.valueOf(df.format(goldText.replaceAll("[^0-9?!\\.]", "")));
        System.out.println("Gold Spot Price : " + goldSpotPrice);
        String goldCountText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.goldcount.xp");
        Float goldCount = Float.valueOf(df.format(goldCountText.replaceAll("[^0-9?!\\.]", "")));
        System.out.println("Gold Count : " + goldCount);
        String goldSpotMultipliedCount = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.goldSpotMultiplyCount.xp");
        Float goldSpotMulCount = Float.valueOf(df.format(goldSpotMultipliedCount.replaceAll("[^0-9?!\\.]", "")));
        System.out.println("Gold Spot * Ounce :" + goldSpotMulCount);
        goldSpotMulCount = goldSpotPrice * goldCount;
        Assert.assertEquals(goldSpotMulCount, goldSpotMulCount);

        String silverText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.silverSpot.xp");
        Float silverSpotPrice = Float.valueOf(silverText.replaceAll("[^0-9?!\\.]", ""));
        System.out.println("Silver Spot Price : " + silverSpotPrice);
        String silverCountText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.silvercount.xp");
        Float silverCount = Float.valueOf(silverCountText.replaceAll("[^0-9?!\\.]", ""));
        System.out.println("Silver Count :" + silverCount);
        String silverSpotMultipliedCount = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.silverSpotMultiplyCount.xp");
        Float silverSpotMulCount = Float.valueOf(silverSpotMultipliedCount.replaceAll("[^0-9?!\\.]", ""));
        System.out.println("Silver Spot * Ounce : " + silverSpotMulCount);
        silverSpotMulCount = silverSpotPrice * silverCount;
        Assert.assertEquals(silverSpotMulCount, silverSpotMulCount);

        String platinumText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.platinumSpot.xp");
        Float platinumSpotPrice = Float.valueOf(platinumText.replaceAll("[^0-9?!\\.]", ""));
        System.out.println("Platinum Spot Price : " + platinumSpotPrice);
        String platinumCountText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.platinumcount.xp");
        Float platinumCount = Float.valueOf(platinumCountText.replaceAll("[^0-9?!\\.]", ""));
        System.out.println("Platinum Count :" + platinumCount);
        String platinumSpotMultipliedCount = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.platinumSpotMultiplyCount.xp");
        Float platinumSpotMulCount = Float.valueOf(platinumSpotMultipliedCount.replaceAll("[^0-9?!\\.]", ""));
        System.out.println("Platinum Spot * Ounce : " + platinumSpotMulCount);
        platinumSpotMulCount = platinumSpotPrice * platinumCount;
        Assert.assertEquals(platinumSpotMulCount, platinumSpotMulCount);

        String palladiumText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.palladiumSpot.xp");
        Float palladiumSpotPrice = Float.valueOf(palladiumText.replaceAll("[^0-9?!\\.]", ""));
        System.out.println("Platinum Spot Price : " + palladiumSpotPrice);
        String palladiumCountText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.palladiumcount.xp");
        Float palladiumCount = Float.valueOf(palladiumCountText.replaceAll("[^0-9?!\\.]", ""));
        System.out.println("Platinum Count :" + palladiumCount);
        String palladiumSpotMultipliedCount = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.palladiumSpotMultiplyCount.xp");
        Float palladiumSpotMulCount = Float.valueOf(palladiumSpotMultipliedCount.replaceAll("[^0-9?!\\.]", ""));
        System.out.println("Platinum Spot * Ounce : " + palladiumSpotMulCount);
        palladiumSpotMulCount = palladiumSpotPrice * palladiumCount;
        Assert.assertEquals(palladiumSpotMulCount, palladiumSpotMulCount);


        String loanUptoText = (String) Q_JMB_WebElm.xpRetText(jmbProps, "nav.loans.loanUptoTotal.xp");
        Float loanUptoTotal = Float.valueOf(loanUptoText.replaceAll("[^0-9?!\\.]", ""));
        System.out.println("Loan Up To : " + loanUptoTotal);

        Float metalTotal = goldSpotMulCount + silverSpotMulCount + platinumSpotMulCount + palladiumSpotMulCount;
        System.out.println("Total Metal Spot Count Value : " + metalTotal);

        Double percentageValue = (Double) (metalTotal * 0.75);
        System.out.println("75% of " + metalTotal + ": " + percentageValue);
        Assert.assertEquals(df.format(percentageValue), df.format(loanUptoTotal));
    }


    @AfterTest
    public void endReport(){


    }
    @AfterMethod
    public void tearDown() throws Exception {

//        Controls.tearDown();
    }

    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
