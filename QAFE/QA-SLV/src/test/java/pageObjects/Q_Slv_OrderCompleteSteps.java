package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Q_Slv_Init;

public class Q_Slv_OrderCompleteSteps extends Q_Slv_Init {


    //@Step
    public static void closeRateUs(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sa_rounded")));
        //ElemSteps.idElementDisplayed(orderProps,"order.complete.rateUs.id");
        Q_Slv_WebElm.myWait(500);
        Q_Slv_WebElm.cn(SLVqProp, "chk.complete.rateUs.id");

    }


}
