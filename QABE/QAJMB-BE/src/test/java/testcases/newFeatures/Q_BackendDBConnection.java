package testcases.newFeatures;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.jcraft.jsch.JSchException;

import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_BackendDBConnection extends Init {
	
	@BeforeMethod
    public void report() throws Exception {
        Init.setItUp(); // Needed for baseURL so code knows what environment DB to open
    }
	
	//******************************************************************
    // * Description: Test for confirming backend connection to the site DBs
    // * Created By: Paul Patterson
    // * Jira Ticket: JMB-6861
    // * Status: Complete
    //********************************************************************/
	@Test(priority = 1, enabled = true)
	public static void testDBConnectionJMB() throws JSchException, SQLException, ClassNotFoundException{
		LinkedHashMap<Object, Map<String,String>> dbQueryData;
		Map<String,String> innerMap;
		String reportDetails;
		Controls.tearDown();
		Q_NewFeatures.connectToSSHAndJMBDB();
		dbQueryData = Q_NewFeatures.queryAndConvertRecordSetToLinkedHashMap("SELECT * FROM buyback_address;");
		for (int index = 0; index < dbQueryData.size(); index ++) {
			innerMap = dbQueryData.get(index + 1);
			reportDetails = "Data for record # " + (index+1) + " -";
			for (String innerKey : innerMap.keySet()) {
				reportDetails = reportDetails + " column: " + innerKey + " value: " + innerMap.get(innerKey);
			}
			System.out.println (reportDetails);
		}
		Q_NewFeatures.closeAllDBAndSSHConnections();
		Q_NewFeatures.connectToSSHAndSilverDB();
		dbQueryData = Q_NewFeatures.queryAndConvertRecordSetToLinkedHashMap("SELECT * From order_guest;");
		for (int index = 0; index < dbQueryData.size(); index ++) {
			innerMap = dbQueryData.get(index + 1);
			reportDetails = "Data for record # " + (index+1) + " -";
			for (String innerKey : innerMap.keySet()) {
				reportDetails = reportDetails + " column: " + innerKey + " value: " + innerMap.get(innerKey);
			}
			System.out.println (reportDetails);
		}
		Q_NewFeatures.closeAllDBAndSSHConnections();
		Controls.tearDown();
	}
	
	//******************************************************************
    // * Description: Test for confirming backend connection to the site DBs
    // * Created By: Paul Patterson
    // * Jira Ticket: JMB-6861
    // * Status: Complete
    //********************************************************************/
	@Test(priority = 2, enabled = true)
	public static void testDBConnectionPM() throws JSchException, SQLException, ClassNotFoundException{
		LinkedHashMap<Object, Map<String,String>> dbQueryData;
		Map<String,String> innerMap;
		String reportDetails;
		Controls.tearDown();
		Q_NewFeatures.connectToSSHAndPMDB();
		dbQueryData = Q_NewFeatures.queryAndConvertRecordSetToLinkedHashMap("SELECT * FROM buyback_address;");
		for (int index = 0; index < dbQueryData.size(); index ++) {
			innerMap = dbQueryData.get(index + 1);
			reportDetails = "Data for record # " + (index+1) + " -";
			for (String innerKey : innerMap.keySet()) {
				reportDetails = reportDetails + " column: " + innerKey + " value: " + innerMap.get(innerKey);
			}
			System.out.println (reportDetails);
		}
		Q_NewFeatures.closeAllDBAndSSHConnections();
		Q_NewFeatures.connectToSSHAndSilverDB();
		dbQueryData = Q_NewFeatures.queryAndConvertRecordSetToLinkedHashMap("SELECT * From order_guest;");
		for (int index = 0; index < dbQueryData.size(); index ++) {
			innerMap = dbQueryData.get(index + 1);
			reportDetails = "Data for record # " + (index+1) + " -";
			for (String innerKey : innerMap.keySet()) {
				reportDetails = reportDetails + " column: " + innerKey + " value: " + innerMap.get(innerKey);
			}
			System.out.println (reportDetails);
		}
		Q_NewFeatures.closeAllDBAndSSHConnections();
		Controls.tearDown();
	}
	
}
