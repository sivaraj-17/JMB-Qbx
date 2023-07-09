package testcases.shipping;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_unitSHipping extends Init {
	static Q_AdminForm adm = new Q_AdminForm();
	static Q_CustomerForm cust = new Q_CustomerForm();
	static Q_ProductForm prod = new Q_ProductForm();
	static Q_HoldsForm hold = new Q_HoldsForm();
	static Q_OrderForm ord = new Q_OrderForm();
	static Q_Buyback bb = new Q_Buyback();
	static Q_CheckoutForm chk = new Q_CheckoutForm();
	static Q_NewFeatures nfal = new Q_NewFeatures();
	static Controls li = new Controls();

	@BeforeClass
	public void setEnv() throws Exception {
		setItUp();
		Controls.adminLogin();
	}
	@BeforeMethod
	public void setPath() throws Exception {

		Q_WebElm.myWait(3000);
	}

}