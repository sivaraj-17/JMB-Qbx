package testcases.sanity;

import org.testng.annotations.BeforeClass;
import utils.Controls;
import utils.Init;


//import utilities.ExcelUtils;

public class Q_unitBackEnd extends Init {

	@BeforeClass
	public void setEnv() throws Exception {
		setItUp();
		Controls.adminLogin();
	}


}