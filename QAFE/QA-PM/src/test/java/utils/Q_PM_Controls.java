package utils;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import pageObjects.Q_PM_WebElm;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Q_PM_Controls extends Q_PM_Init {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static String localYYMMDDTimeCentral() {
		LocalDateTime lt = LocalDateTime.now(ZoneId.of("America/Chicago"));
		DateTimeFormatter ltFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String localTime = lt.format(ltFormat);

		return localTime;
	}
	public static void testStarted(String tcName){
		System.out.println(ANSI_BLUE + "___________________________  " + tcName + "   ::execution start time::   "  + localYYMMDDTimeCentral() + "\n" + ANSI_RESET);
	}
//
// Start Time function
//
	public static String startTime(WebDriver driver){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		  //get current date time with Date()
		 Date date = new Date();
		 // Now format the date
		 String date1= dateFormat.format(date);
		 // Print the Date
		 System.out.println("Execution Start date and time " +date1);
		 System.out.println("==================================================================================================================");
		 return date1;
	}
//
// Start Time function
//

	public static String startTimeStriped(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		//get current date time with Date()
		Date date = new Date();
		// Now format the date
		String date1= "";
		date1= dateFormat.format(date).replaceAll("[^\\d.]", date1);
		// Print the Date
		//System.out.println("Execution Start date and time is " +date1);
		//System.out.println("==================================================================================================================");
		return date1;
	}

	//
	// Print test passed
	//
	public static void testPassed(String tcName){
		System.out.println("***************************************************");
		System.out.println("       T E S T  " + tcName + "   P A S S E D         ");
		System.out.println("***************************************************");
	}
	public static void adminLogin() {
		driver.get(jmAdmin);
		Q_PM_WebElm.myWait(3000);
		Q_PM_WebElm.idClear(pmQaProps, "admin.okta.user.id");
		Q_PM_WebElm.idSend(pmQaProps, "admin.okta.user.id", "qa@jmbullion.com");
		Q_PM_WebElm.idClear(pmQaProps, "admin.okta.pwd.id");
		Q_PM_WebElm.idSend(pmQaProps, "admin.okta.pwd.id", "Te$t2023A");
		Q_PM_WebElm.id(pmQaProps, "admin.okta.loginSubmit.id");
		Q_PM_WebElm.myWait(3000);
		driver.navigate().to(baseUrl + "/admin");
	}
	public static void adminLoginPM() {
		driver.get(adminUrl);
		Q_PM_WebElm.myWait(3000);
		Q_PM_WebElm.idClear(pmQaProps, "admin.okta.user.id");
		Q_PM_WebElm.idSend(pmQaProps, "admin.okta.user.id", "qa@jmbullion.com");
		Q_PM_WebElm.idClear(pmQaProps, "admin.okta.pwd.id");
		Q_PM_WebElm.idSend(pmQaProps, "admin.okta.pwd.id", "Te$t2023A");
		Q_PM_WebElm.id(pmQaProps, "admin.okta.loginSubmit.id");
		Q_PM_WebElm.myWait(3000);
		driver.navigate().to(baseUrl + "/admin");
	}
//
// Screen Capture
//
public static void captureScreen(String tcName){
	String path;
	//String tcName = "screen";
	try {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String now = "";
		now = Q_PM_Controls.startTimeStriped();
		path = "./screenshots/" + tcName +  "  " + now + ".png";
		FileUtils.getFileUtils().copyFile(source, new File(path));
	} catch (IOException e) {
		//e.printStackTrace();
		path = "Failed to capture screenshot: " + e.getMessage();
	}
}
	public static void captureScreenSub(WebDriver driver, String tcName, String number){
		String path;
		//String tcName = "screen";
		try {
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String now = "";
			now = Q_PM_Controls.startTimeStriped();
			path = "./screenshots/" + tcName + number + "  " + now + ".png";

			//  path = "./screenshots/" + tcName + "  " +source.getName();
			// Now you can do whatever you need to do with it, for example copy somewhere

			FileUtils.getFileUtils().copyFile(source, new File(path));
		} catch (IOException e) {
			//e.printStackTrace();
			path = "Failed to capture screenshot: " + e.getMessage();
		}
	}
//
// scroll Up function  scroll by pixels
//
	public static void scrolUpPixel(Integer pix){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, " + -pix +")", "");
	}
//
// scroll down function  scroll by pixels
//
	public static void scrolDownPixel(Integer pix){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, " + pix +")", "");
	}
	public static void switchWin() {
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}
	public static void closeTabsSwitchWinMain() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		int count = tabs.size();
		for (int i = 1; i < count; i++) {
			driver.switchTo().window(tabs.get(i));
			driver.close();
		}
	}
	// open new tab
	public static void openNewTab() {
		((JavascriptExecutor)driver).executeScript("window.open('about:blank','_blank');");
	}
	public static void switchTab(Integer tabNo) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabNo));
	}
//
// Check for alerts
//
	public static boolean checkAlert() {
		Q_PM_WebElm.myWait(2000);
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        //wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        alert.accept();

	        return true;
	    } catch (Exception e) {
	        //exception handling
	    	return false;
	    }
	}
	public static void tearDown(){
		if (driver.toString().contains("firefox")) {
//			AdminSteps.logout("jm.logoutLink.id");
			driver.quit();
		}
		else if(driver.toString().contains("edge")){
//			AdminSteps.logout("jm.logoutLink.id");
			driver.quit();
		}
		else if(driver.toString().contains("chrome")){
//			driver.navigate().to(adminUrl);
			driver.quit();
		}
	}
	
	public static void xpExecutorScrollElementToMiddle(String xpath) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",(driver.findElement(By.xpath(xpath))));
    }
	
	/*******************************************************************
     * Description: Will perform diver.navigate().to and recover if there is a loading error
     * Author: Paul Patterson
     * Param: String url
     * Returns: NA
     * Status: Complete
     *******************************************************************/
	public void navigateTo(String url)
	{
		try {
			driver.navigate().to(url);
		}
		catch (WebDriverException e) {
			Assert.assertTrue(e.getMessage().contains("cannot determine loading status"), "Web Driver Exception is not for loading status. It is '" + e.getMessage() + "'.");
			System.out.println("Recovering from Web Driver Exception for loading status");
		}
	}
	
	/**********************************************************************
     * Description:     Takes a web table and store the data into 2 Dimensional LinkedHasMap
     * Author:          Paul Patterson
     * Param:      		String excelPath, String selectQuery
     * Returns:         LinkedHashMap
     **********************************************************************/
  	public LinkedHashMap<Object, Map<String, String>> queryExcelToLinkedHashMap (String excelPath, String selectQuery) throws FilloException
  	{
  		List <String> fieldNames;
  		int rowNumber = 1;
  		LinkedHashMap <Object, Map <String, String>> outerMap = new LinkedHashMap <>();
          Map <String, String> innerMap;
  		//Create an Object of Fillo Class
  	    Fillo fillo = new Fillo();
  	    Connection connection = fillo.getConnection(excelPath);
  	    Recordset recordset = connection.executeQuery(selectQuery);
  	    while(recordset.next()){
  	    	innerMap = new LinkedHashMap<String, String>();
  	    	fieldNames = recordset.getFieldNames();
  	    	for(String fieldName : fieldNames){
  	    		innerMap.put(fieldName, recordset.getField(fieldName));
  	    	}
  	    	outerMap.put(rowNumber, innerMap);
  	    	rowNumber++;
  	    }
  	    recordset.close();
  	    connection.close();
  	    return outerMap;
  	}
}