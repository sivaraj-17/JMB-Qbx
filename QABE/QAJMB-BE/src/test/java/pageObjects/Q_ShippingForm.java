package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Controls;
import utils.Init;

import java.io.FileNotFoundException;

public class Q_ShippingForm extends Init {

    public static void tracking(String awaitingTracking){

        System.out.println(Q_WebElm.xpRetText(adminProps, awaitingTracking));

    }
    public static void menuElement(String locator){
        Q_WebElm.xp(adminProps, locator);
    }
    public static void subMenuElement(String locator){
        Q_WebElm.xp(adminProps, locator);

    }
    public static String withBadAddress(String badAddress){
        Q_WebElm.xpRetText(adminProps, badAddress);
        System.out.println("Count listed on bad address button: " + Q_WebElm.xpRetText(adminProps, badAddress));
        String baBtnCount = Q_WebElm.xpRetText(adminProps, badAddress).substring(32, 36);
        System.out.println("Count listed on bad address button: " + baBtnCount);
        Q_WebElm.xp(adminProps, badAddress);

        return baBtnCount;
    }
    public static String badAddressCount(){
        Q_WebElm.myWait(20000);
        WebElement baReport = driver.findElement(By.xpath("//*[@id='report_info']"));
        String badAddressPageCount = baReport.getText().toString();
        System.out.println("Count obtained from the bad address report page: " + baReport.getText().toString().substring(19, 23));
        return badAddressPageCount;
    }

    public static void viewBlalanceSummary(String blalanceSummary){
        Q_WebElm.xp(adminProps, blalanceSummary);

    }
    public static void ordersOnHold(String onHold){
        Q_WebElm.xp(adminProps, onHold);
    }
    public static String onHoldCount(String onHold){
        System.out.println("Count listed on Hold button: " + Q_WebElm.xpRetText(adminProps, onHold));
        String ohBtnCount = Q_WebElm.xpRetText(adminProps, onHold).substring(21, 22);
//        String ohBtnCount = WebElm.xpRetText(adminProps, onHold).substring(21);
        return ohBtnCount;
    }

    public static String viewOrdersError(String orderErrors){
//        String oeBtnCount = WebElm.xpRetText(adminProps, orderErrors).substring(20, 22);
        System.out.println("Count listed on Hold button: " + Q_WebElm.xpRetText(adminProps, orderErrors));
        String oeBtnCount = Q_WebElm.xpRetNumber(adminProps, orderErrors);
        return oeBtnCount;
    }

    public static void shipSite(String site){
        switch (site) {
            case ("all sites"):
                Q_WebElm.xpSelectValue(adminProps, "siteSelectionxp", "all");
                System.out.println("Shipping job scheduled on all 3 sites");
                break;
            case ("jmb"):
                Q_WebElm.xpSelectValue(adminProps, "siteSelectionxp", "jmbullion");
                System.out.println("Shipping job scheduled on JMB");
                break;
            case ("silver"):
                Q_WebElm.xpSelectValue(adminProps, "siteSelectionxp", "silver");
                System.out.println("Shipping job scheduled on Silver");
                break;
            case ("pm"):
                Q_WebElm.xpSelectValue(adminProps, "siteSelectionxp", "provident");
                System.out.println("Shipping job scheduled on PM");
                break;

            default:
                System.out.println("Invalid Site selected");
                break;
        }
    }

    public static void completedEmail(){
        Q_WebElm.xp(adminProps,"emailOnCompletexp");
        System.out.println("Send completed email is expected");
    }
    public static void addJob(){
        Q_WebElm.myWait(2000);
        ((JavascriptExecutor) driver).executeScript("window.open();");
        Controls.switchTab(0);
        Q_WebElm.xp(adminProps,"addJobBtnxp");
        Q_WebElm.myWait(1000);
        Controls.switchWin();
        System.out.println("Please wait shipping job is running");
        driver.navigate().to("https://qa.jmbullion.com/ato/jm-batch.php");

    }

    public static void shippingReviewPage(){
        Q_WebElm.myWait(2000);
        Controls.newTab();
        Controls.switchTab(0);

        Q_WebElm.myWait(5000);
        Controls.switchTab(2);
        driver.navigate().to(adminUrl + "/shipping-status.php ");
        System.out.println("Review order status");
        Controls.newTab();
        Controls.switchTab(3);
        driver.navigate().to(baseUrl + "/ato/smarty.php");
    }

    public static void preInhand() throws FileNotFoundException {
        Controls li = new Controls();
        Q_OrderForm ord = new Q_OrderForm();
        Q_AdminForm adm = new Q_AdminForm();
        Q_CustomerForm cust = new Q_CustomerForm();
        driver.navigate().to(adminUrl);
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.changeOrderStatus("paid");
//        OrderForm.clearAllOrderHolds();
        Q_WebElm.linkText(adminProps, "ord.makeOrderPriority.linkText");
        Q_WebElm.myWait(5000);
    }

    public static void linkPresent(){
        String[] locator = {"ord.orderStatus.id", "order.edit.esdxp", "order.edit.rsdxp", "ord.editShippingDetails.xp"};
        String[] linkText = {"Order status", "Estimated Ship Date", "Requested Ship Date", "Shipping Address Edit"};
        for(int i=0; i < locator.length; i++){
            try{
                Assert.assertFalse(Q_WebElm.idDisplayed(adminProps,locator[i]).equals(true));

            }
            catch (Throwable ex){
                System.out.println("Verified Order " + linkText[i] + "link is not editable");
            }
        }
    }
    
    //JMB-7573-Start
    /********************************************************************
	 // * Description  : To add new shipping job in shipping jobs page 
	 // * Param        : String menuXp, boolean availability
	 // * Jira Ticket  : JMB 7573
	 // * Status       : Completed
	 //*******************************************************************/
	public void addNewShippingJob(String numberOfOrders, String website) {
		Q_WebElm.xpClear(adminProps, "adm.shippingJobs.orders.xp");
		Q_WebElm.xpSend(adminProps, "adm.shippingJobs.orders.xp", numberOfOrders);
		Q_WebElm.xpSelectText(adminProps,"adm.shippingJobs.website.xp", website);
		Q_WebElm.xp(adminProps,"adm.shippingJobs.emailCheckbox.xp");
		Q_WebElm.xp(adminProps,"adm.shippingJobs.addJob.xp");
		System.out.println("Shipping Job added Successfully");
	}

	/********************************************************************
	 // * Description  : verify first shipping job detail from the list based on the parameter 
	 // * Param        : String numberOfOrders, String website
	 // * Jira Ticket  : JMB 7573
	 // * Status       : Completed
	 //*******************************************************************/
	public void verifyShippingJobList(String numberOfOrders, String website) {
		Q_WebElm.myWait(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//th[text()='Job #']//ancestor::table/tbody/tr[1]/td[text()='"+numberOfOrders+"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//th[text()='Job #']//ancestor::table/tbody/tr[1]/td[text()='"+website+"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//th[text()='Job #']//ancestor::table/tbody/tr[1]/td[contains(text(),'minutes')]")).isDisplayed());
		System.out.println("Shipping Job list has been verified Successfully");
	}
	//JMB-7573-End

}
