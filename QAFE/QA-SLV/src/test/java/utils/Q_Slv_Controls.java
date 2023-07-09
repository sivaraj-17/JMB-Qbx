package utils;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import pageObjects.Q_Slv_WebElm;

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
import java.util.Properties;


public class Q_Slv_Controls extends Q_Slv_Init {

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
	public static void testFinished(String tcName){
		System.out.println(ANSI_GREEN +"___________________________  " + tcName + "   Finished Execution at   "  + localYYMMDDTimeCentral() + "  \n" + ANSI_RESET);

	}
	public static void adminLogin() {
		driver.get(jmAdmin);
		Q_Slv_WebElm.myWait(3000);
		Q_Slv_WebElm.idClear(SLVqProp, "admin.okta.user.id");
		Q_Slv_WebElm.idSend(SLVqProp, "admin.okta.user.id", "qa@jmbullion.com");
		Q_Slv_WebElm.idClear(SLVqProp, "admin.okta.pwd.id");
		Q_Slv_WebElm.idSend(SLVqProp, "admin.okta.pwd.id", "Te$t2023A");
		Q_Slv_WebElm.id(SLVqProp, "admin.okta.loginSubmit.id");
		Q_Slv_WebElm.myWait(3000);
		driver.navigate().to(baseUrl + "/admin");
	}
	//
// Screen Capture
//
	public static void captureScreen(WebDriver driver, String tcName){
		String path;
		//String tcName = "screen";
		try {
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String now = "";
			now = Q_Slv_Controls.startTimeStriped();
			path = "./screenshots/" + tcName + "  " + now + ".png";

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
// scroll Up function  scroll by pixels
//
	public static void scrolDownPixel(Integer pix){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, " + pix +")", "");
	}
	public static void xpExecutorScrollToView(Properties proper, String subCategory) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", (driver.findElement(By.xpath(proper.getProperty(subCategory)))));

	}
	//
// Check for alerts
//
	public static boolean checkAlert() {
		try {
			Q_Slv_WebElm.myWait(2000);
			Alert alert = driver.switchTo().alert();
			alert.accept();

			return true;
		} catch (Exception e) {
			//exception handling
			return false;
		}
	}
	public static String checkAndGetAlertText() {
		int counter = 0;
		do
		{
			try {
				Q_Slv_WebElm.myWait(1000);
				Alert alert = driver.switchTo().alert();
				System.out.println("Alert message is  " + alert.getText());
				String alertText= alert.getText();
				alert.accept();
				return alertText;
			} catch (Exception e) {
				//exception handling
				System.out.println("Recovering from exception when handling alert.");
				counter++;
	
			}
		} while (counter < 2);
		if (counter==2) {
			Assert.fail("failed alert verification");
			return "failed alert verification";
		}
		return "failed alert verification";
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
	public static void openNewTab() {
		((JavascriptExecutor)driver).executeScript("window.open('about:blank','_blank');");
	}
	public static void switchTab(Integer tabNo) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabNo));
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
//	public static void adminLogin() {
//		driver.get(adminUrl);
//		WebElm.myWait(1000);
//		WebElm.idClear(adminProps, "okta.admin.user.id");
//		WebElm.idSend(adminProps, "okta.admin.user.id", "qa@jmbullion.com");
//		WebElm.idClear(adminProps, "okta.admin.pwd.id");
//		WebElm.idSend(adminProps, "okta.admin.pwd.id", "Te$t1212");
//		WebElm.id(adminProps, "okta.admin.loginSubmit.id");
//		WebElm.myWait(3000);
//		driver.navigate().to(baseUrl + "/admin");
//	}
//	public static void adminLogin(String user, String pwd) {
//		driver.get(adminUrl);
//		WebElm.myWait(2000);
//		WebElm.xp(adminProps,"nonOkta.userName.xpath");
//		WebElm.xpSend(adminProps, "nonOkta.userName.xpath", "qa@jmbullion.com");
//		WebElm.xpSend(adminProps, "nonOkta.userPwd.xpath", "T3$t2016");
//		WebElm.xp(adminProps, "nonOkta.signInBtn.xpath");
//		WebElm.myWait(3000);
//	}
	public static void adminLogout() {
		driver.navigate().to(baseUrl);
		Q_Slv_WebElm.id(SLVqProp, "jm.logoutLink.id");
	}
	public class ConsoleColors {
		// Reset
		public static final String RESET = "\033[0m";  // Text Reset

		// Regular Colors
		public static final String BLACK = "\033[0;30m";   // BLACK
		public static final String RED = "\033[0;31m";     // RED
		public static final String GREEN = "\033[0;32m";   // GREEN
		public static final String YELLOW = "\033[0;33m";  // YELLOW
		public static final String BLUE = "\033[0;34m";    // BLUE
		public static final String PURPLE = "\033[0;35m";  // PURPLE
		public static final String CYAN = "\033[0;36m";    // CYAN
		public static final String WHITE = "\033[0;37m";   // WHITE

		// Bold
		public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
		public static final String RED_BOLD = "\033[1;31m";    // RED
		public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
		public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
		public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
		public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
		public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
		public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

		// Underline
		public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
		public static final String RED_UNDERLINED = "\033[4;31m";    // RED
		public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
		public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
		public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
		public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
		public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
		public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

		// Background
		public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
		public static final String RED_BACKGROUND = "\033[41m";    // RED
		public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
		public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
		public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
		public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
		public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
		public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

		// High Intensity
		public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
		public static final String RED_BRIGHT = "\033[0;91m";    // RED
		public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
		public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
		public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
		public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
		public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
		public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

		// Bold High Intensity
		public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
		public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
		public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
		public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
		public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
		public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
		public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
		public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

		// High Intensity backgrounds
		public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
		public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
		public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
		public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
		public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
		public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
		public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
		public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
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