package testcases.sanity;


import org.testng.annotations.BeforeMethod;
import utils.Init;


public class Q_unitFrontEnd extends Init {
	//static ExcelUtils ReadInput = new ExcelUtils();
	@BeforeMethod
	public void setEnv (){
		setItUp();
	}

}
