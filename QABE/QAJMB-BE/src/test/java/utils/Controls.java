package utils;

//import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import pageObjects.Q_WebElm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Controls extends Init {
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
	public static Long currentTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		long date = System.currentTimeMillis();
		return date;
	}
	public static String currentDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dateobj = new Date();
		String toDay = df.format(dateobj);
		return toDay;
	}
	//
	// Start Time function
	//

	public static String startTimeStriped() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String date1 = "";
		date1 = dateFormat.format(date).replaceAll("[^\\d.]", date1);
		return date1;
	}



	//
	// Print test passed
	//
	public static void testPassed(String tcName) {
		System.out.println("***************************************************");
		System.out.println("       T E S T  " + tcName + "   P A S S E D         ");
		System.out.println("***************************************************");
	}


	//This is to print log for the ending of the test case
	public static void endTestCase(String sTestCaseName) {
		System.out.println("*******       " + "Finished execution" + "   " + Controls.startTimeStriped()+"  ********");
		System.out.println("________________________________________________________________________________________");
		System.out.println(" ");
	}
	//
// Admin login
//
//	public static void adminLogin() {
//		driver.get(adminUrl);
//		WebElm.myWait(1000);
//		WebElm.idClear(adminProps, "admin.user.id");
//		WebElm.idSend(adminProps, "admin.user.id", "qa@jmbullion.com");
//		WebElm.idClear(adminProps, "admin.pwd.id");
//		WebElm.idSend(adminProps, "admin.pwd.id", "1212Te$t");
//		WebElm.id(adminProps, "admin.loginSubmit.id");
//		WebElm.myWait(3000);
//		driver.navigate().to(baseUrl + "/admin");
//	}
	public static void adminLogin() {
		driver.get(adminUrl);
//		WebElm.myWait(1000);
		Q_WebElm.idClear(adminProps, "adm.okta.admin.user.id");
		Q_WebElm.idSend(adminProps, "adm.okta.admin.user.id", "qa@jmbullion.com");
		Q_WebElm.idClear(adminProps, "adm.okta.admin.pwd.id");
		Q_WebElm.idSend(adminProps, "adm.okta.admin.pwd.id", "Te$t2023A");
		Q_WebElm.id(adminProps, "adm.okta.admin.loginSubmit.id");
		Q_WebElm.myWait(5000);
//		driver.navigate().to(baseUrl + "/admin");
	}
	public static void adminLogin(String user, String pwd) {
		driver.get(adminUrl);
		Q_WebElm.myWait(2000);
		Q_WebElm.xp(adminProps, "adm.nonOkta.userName.xp");
		Q_WebElm.xpSend(adminProps, "adm.nonOkta.userName.xp", "qa@jmbullion.com");
		Q_WebElm.xpSend(adminProps, "adm.nonOkta.userPwd.xp", "T3$t2016");
		Q_WebElm.xp(adminProps, "adm.nonOkta.signInBtn.xp");
		Q_WebElm.myWait(3000);
	}
	//
// Check for alerts
//
	public static boolean checkAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println(" Alert message is  " + alert.getText());
			alert.accept();

			return true;
		} catch (Exception e) {
			//exception handling
			return false;
		}
	}
	public static String checkAndGetAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message is  " + alert.getText());
			String alertText= alert.getText();
			alert.accept();
			return alertText;
		} catch (Exception e) {
			//exception handling
			Assert.fail();
			return "failed alert verification";

		}
	}
	public static String getAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message is  " + alert.getText());
			String alertText= alert.getText();
			return alertText;
		} catch (Exception e) {
			//exception handling
			Assert.fail();
			return "failed alert verification";
		}
	}
	//
//  Check for alerts
//
	public static boolean isAlertPresent() {
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message is  " + alert.getText());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//
	//Compare two strings and returns boolean and clear cart
	//
	public static int countTableRowsXpath(Properties proper, String locator) {
		int count = 0;
		List<WebElement> rowNum = driver.findElements(By.xpath(proper.getProperty(locator)));
		for (WebElement r : rowNum) {
			count++;
		}
		System.out.println("Row count " + count);
		return count;
	}

	public static void switchWin() {
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

	}
	public static void newTab (){
		((JavascriptExecutor) driver).executeScript("window.open();");
		Controls.switchWin();
	}
	public static void newTabLaunch (String partialUrl){
		((JavascriptExecutor) driver).executeScript("window.open();");
		Controls.switchWin();
		driver.navigate().to(baseUrl + partialUrl);
	}

	public static void switchTab(Integer tabNo) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabNo));
	}

	public static void closeTabs() {
		for(int i = driver.getWindowHandles().size() -1 ; i > 0 ; i--){
			String winHandle = driver.getWindowHandles().toArray()[i].toString();
			driver.switchTo().window(winHandle);
			driver.close();
		}
	}
	public static void closeTabsSwitchWinMain() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		int count = tabs.size();
		for(int i=1; i < count; i++){
			driver.switchTo().window(tabs.get(i));
			driver.close();
		}

		driver.switchTo().window(tabs.get(0));

	}
	//
	// scroll Up function  scroll by pixels
	//
	public static void scrolUpPixel(Integer pix) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, " + -pix + ")", "");
	}

	//
	// scroll down function  scroll by pixels
	//
	public static void scrolDownPixel(Integer pix) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, " + pix + ")", "");
	}
	public static void xpExecutorScrollToView(Properties proper, String subCategory) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", (driver.findElement(By.xpath(proper.getProperty(subCategory)))));

	}
	public static int randomRow(Integer lowerbound, Integer upperbound) {
		Random rowNo = new Random(); //instance of random class
		int i = 0;
		i = lowerbound + rowNo.nextInt(upperbound - lowerbound + 1);
		System.out.println("int random :" + i);
		return i;
	}
	public static void tearDown(){
		if (driver.toString().contains("firefox")) {
//			Q_AdminSteps.logout("jm.logoutLink.id");
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

	public static ArrayList readFileToList(String path){
		ArrayList <String> items = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line;
			while((line = br.readLine()) != null){
				items.add(line);
			}
		} catch (IOException e) {
			System.out.println("readFileToList Error: file " + path + " could not be open");
			e.printStackTrace();
			System.exit(1);
		}

		return(items);
	}
	public static ArrayList partialReadFileToList(String path, Integer lineNum){
		ArrayList <String> items = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			for(int i=1; i <= lineNum; i++){
				items.add(br.readLine());
			}
		} catch (IOException e) {
			System.out.println("readFileToList Error: file " + path + " could not be open");
			e.printStackTrace();
			System.exit(1);
		}

		return(items);
	}
	public static void captureScreen(String tcName){
		String path;
		//String tcName = "screen";
		try {
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String now = "";
			now = Controls.startTimeStriped();
			path = "./screenshots/" + tcName + "  " + localYYMMDDTimeCentral() + ".png";
			FileUtils.getFileUtils().copyFile(source, new File(path));
		} catch (IOException e) {
			//e.printStackTrace();
			path = "Failed to capture screenshot: " + e.getMessage();
		}
	}
	public static void captureScreen(WebDriver driver, String tcName, String number){
		String path;
		//String tcName = "screen";
		try {
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String now = "";
			now = Controls.startTimeStriped();
			path = "./screenshots/" + tcName + number + "  " + now + ".png";

			//  path = "./screenshots/" + tcName + "  " +source.getName();
			// Now you can do whatever you need to do with it, for example copy somewhere

			FileUtils.getFileUtils().copyFile(source, new File(path));
		} catch (IOException e) {
			//e.printStackTrace();
			path = "Failed to capture screenshot: " + e.getMessage();
		}
	}


	public static void xpExecutorScrollElementToMiddle(String xpath) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",(driver.findElement(By.xpath(xpath))));
	}
	public static void idExecutorScrollElementToMiddle(String id) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",(driver.findElement(By.id(id))));
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
	//JMB-6357-Start
	/********************************************************************
	 // * Description  : Login to ProvidentMetals Admin site
	 // * Param        : NA
	 // * Jira Ticket  : JMB 6357
	 // * Status       : Completed
	 //*******************************************************************/
	public void providentMetalsAdminLogin() {
		driver.get("https://qa.providentmetals.com/admin/");
		Q_WebElm.idClear(adminProps, "adm.okta.admin.user.id");
		Q_WebElm.idSend(adminProps, "adm.okta.admin.user.id", "qa@jmbullion.com");
		Q_WebElm.idClear(adminProps, "adm.okta.admin.pwd.id");
		Q_WebElm.idSend(adminProps, "adm.okta.admin.pwd.id", "Te$t2023A");
		Q_WebElm.id(adminProps, "adm.okta.admin.loginSubmit.id");
		Q_WebElm.myWait(5000);
	}

   //JMB-6357-End
}
