package pageObjects;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Q_PM_Init;

public class Q_PM_NavigationSteps extends Q_PM_Init {

    //*******************************************************************
    // * Description: Sort Options
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void sort(String locator,String sortOption) {
        Q_PM_WebElm.xp(pmQaProps,locator);
        switch(sortOption){
            case ("Popularity"):
                Q_PM_WebElm.id(pmQaProps, "cart.sort.popular.id");
                Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "cart.sort.xp").contains("Popularity"));
                break;
            case ("Recently Added"):
                Q_PM_WebElm.id(pmQaProps, "cart.sort.radded.id");
                Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "cart.sort.xp").contains("Recently Added"));
                break;
            case ("Low to High"):
                Q_PM_WebElm.id(pmQaProps, "cart.sort.plh.id");
                Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "cart.sort.xp").contains("Low to High"));
                break;
            case ("High to Low"):
                Q_PM_WebElm.id(pmQaProps, "cart.sort.phl.id");
                Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "cart.sort.xp").contains("High to Low"));
                break;
            case ("Weight Ascending"):
                Q_PM_WebElm.id(pmQaProps, "cart.sort.wace.id");
                Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "cart.sort.xp").contains("Weight Ascending"));
                break;
            case ("Weight Descending"):
                Q_PM_WebElm.id(pmQaProps, "cart.sort.wdes.id");
                Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "cart.sort.xp").contains("Weight Descending"));
                break;
            default:
                break;
        }
    }
    //*******************************************************************
    // * Description: Selects Metal
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void selectMetal(String metalType) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("gold"))));
        Q_PM_WebElm.myWait(2000);
        switch (metalType){
            case ("gold"):
                Q_PM_WebElm.cn(pmQaProps, "cart.gold.className");
                Q_PM_WebElm.cnmove(pmQaProps, "cart.quickCartCount.className");
                //Assert.assertTrue(driver.getCurrentUrl().contains("gold.html"));
                break;
            case ("silver"):
                Q_PM_WebElm.myWait(2000);
                Q_PM_WebElm.cn(pmQaProps, "cart.silver.className");
                Q_PM_WebElm.cnmove(pmQaProps, "cart.quickCartCount.className");
//                WebElm.xp(pmQaProps, "silver.xp");
                //Assert.assertTrue(driver.getCurrentUrl().contains("silver.html"));
                break;
            case ("copper-rounds"):
                driver.get(baseUrl + "/copper/copper-rounds.html");
                //Assert.assertTrue(driver.getCurrentUrl().contains("copper-rounds.html"));
                break;
            case ("copper-bars"):
                driver.get(baseUrl + "/copper/copper-bars.html");
                //Assert.assertTrue(driver.getCurrentUrl().contains("copper-bars.html"));
                break;
            case ("other-copper"):
                driver.get(baseUrl + "/copper/other-copper-bullion.html");
                //Assert.assertTrue(driver.getCurrentUrl().contains("other-copper-bullion.html"));
                break;
            case ("platinum"):
                driver.get(baseUrl + "/platinum.html");
                //Assert.assertTrue(driver.getCurrentUrl().contains("platinum.html"));
                break;
            case ("palladium"):
                driver.get(baseUrl + "/palladium.html");
                Assert.assertTrue(driver.getCurrentUrl().contains("palladium.html"));
                break;
            case ("rhodium"):
                driver.get(baseUrl + "/rhodium.html");
                //Assert.assertTrue(driver.getCurrentUrl().contains("rhodium.html"));
                break;
            case ("iraplatinum"):
                driver.get(baseUrl + "/self-directed-ira-precious-metals/platinum-in-ira.html");
                //Assert.assertTrue(driver.getCurrentUrl().contains("platinum-in-ira.html"));
                break;
            case ("irapalladium"):
                driver.get(baseUrl + "/self-directed-ira-precious-metals/palladium-in-ira.html");
                //Assert.assertTrue(driver.getCurrentUrl().contains("palladium-in-ira.html"));
                break;
        }


    }
    //*******************************************************************
    // * Description: Category level
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    // @Step
    public static void category(String subCategory, Integer row, Integer col) {
        switch ( subCategory ) {
            case ("firstLevel"):
                //System.out.println(WebElm.xpCompound2(pmQaProps, "begCat.xp" , row , "midCat.xp" , col , "endCat.xp"));
                Q_PM_WebElm.xp(pmQaProps, "cart.begCat.xp", row , "cart.midCat.xp", col , "cart.endCat.xp");
                Q_PM_WebElm.myWait(2000);
                break;

            case ("secondLevel"):
                Q_PM_WebElm.xp(pmQaProps, "cart.begsubCat1.xp", row , "cart.midsubCat1.xp", col , "cart.endsubCat1.xp");
                Q_PM_WebElm.myWait(2000);
                break;

            case ("thirdLevel"):
                Q_PM_WebElm.xp(pmQaProps, "cart.begsubCat1.xp", row , "cart.midsubCat1.xp", col , "cart.endsubCat1.xp");
                Q_PM_WebElm.myWait(1000);
                break;
            default:
                System.out.println("Invalid category");
                break;

        }
    }

    public static void productItem (Integer item){
        Q_PM_WebElm.xp(pmQaProps, "cart.begProductList.xp", item, "cart.endProductList.xp");
    }
}
