package testcases.navigation;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

public class Q_JMB_FooterNavigation extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();
    static Q_JMB_NavigationObjects nav = new Q_JMB_NavigationObjects();

    //    protected static Properties navProp = ResourceUtils.NavigateProperties();
    @BeforeClass
    public void tcSetup (){

    }
    @BeforeMethod
    public void report() throws Exception {
        Q_JMB_Init.setItUp();
//        ExtentTestManager.startTest(new Object(){}.getClass().getEnclosingMethod().getName(), "Test 1");
    }
    @BeforeTest
    public void setExtent() throws Exception {
//        Init.setItUp();
//        System.out.println(System.getProperty("user.dir"));

    }
    /*******************************************************************
     // * Description: Verify Customer Care links in the footer login page.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 1, enabled = true)
    public void footerCustomerCareLogin(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerCustomerCareMyAccount("Log In | JM Bullion");
        Q_JMB_NavigationObjects.footerLoginPage(3);
//        
    }
    /*******************************************************************
     // * Description: Verify Customer Care links in the footer when user is already logged he/she directed to My Account page.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2, enabled = true)
    public void footerCustomerCareLogedInUser(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(3);
        Q_JMB_NavigationObjects.footerCustomerCareMyAccount("My Account | JM Bullion");
        acc.logoutUser();
//        
    }

    /*******************************************************************
     // * Description: Verify Customer Care links in the footer user presented with contact us form .
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3, enabled = true)
    public void footerCustomerCareContactUs(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerCustomerCareContactUs();
        Q_JMB_NavigationObjects.contactForm();
//        
    }
    /*******************************************************************
     // * Description: Verify user can Search the FAQ page from Customer Care links in the footer section.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4, enabled =true)
    public void footerCustomerCareFAQSearch(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerCustomerCareFAQ();
        Q_JMB_NavigationObjects.footerCustomerCareFAQSearch();
//        
    }
    /*******************************************************************
     // * Description: Verify user have access to JMB Privacy Policy page from Customer Care links in the footer section.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5, enabled =true)
    public void footerCustomerCarePrivacyPolicyLink(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerCustomerCarePrivacyPolicyText();
//        
    }
    /*******************************************************************
     // * Description: Verify user have access to Cookie Policy page from Customer Care links in the footer section.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6, enabled =true)
    public void footerCustomerCareCookiePolicyLink(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerCustomerCareCookiePolicyText();
//        
    }
    /*******************************************************************
     // * Description: Verify user have access to JMB Terms and Conditions from Customer Care links in the footer section.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7, enabled =true)
    public void footerCustomerTermsAndConditionsLink(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerCustomerCareTermsAndConditionsText();
        
    }
    /*******************************************************************
     // * Description: Verify user have access to JMB Commitment to Accessibility  from Customer Care links in the footer section.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8, enabled =true)
    public void footerCustomerCareAccessibilityLink(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerCustomerCareAccessibilityText();
        
    }
    /*******************************************************************
     // * Description: Verify Account Login link in the footer section allows user to log in to his/her account.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9, enabled =true)
    public void footerMyAccountAccountLogin(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerMyAccountAccountLogin();
        Q_JMB_NavigationObjects.footerLoginPage(23);
        acc.logoutUser();
        
    }
    /*******************************************************************
     // * Description: Verify if user is already logged and clicks Account Login link in the footer section he/she is presented
     // * with a link to Forgot Password page. Also, verify user clicking the Forgot password link user presented with forgot password form.
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 10, enabled =true)
    public void footerMyAccountAccountLoginUserLoggedIn(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(12);
        Q_JMB_NavigationObjects.footerMyAccountAccountLogin();
        Q_JMB_NavigationObjects.footerMyAccountForgotPassword("Forgot Password | JM Bullion");
//        acc.forgotPassword(navProp,"footerForgotPasswordValue.xp", "qa1jmb@gmail.com" ,
//                "footerForgotPasswordHuman.xp", "footerForgotPasswordSubmit.xp");
//        Controls.checkAlert();
        
    }
    /*******************************************************************
     // * Description: Verify if user can track their orders by clicking Track An Order in the footer section
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 11, enabled =true)
    public void footerMyAccountAccountTrackOrder(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerMyAccountTrackAnOrderUserLoggedIn("Order Status | JM Bullion");
        Q_JMB_NavigationObjects.footerMyAccountTrackAnOrder("Order Status | JM Bullion");
        
    }
    /*******************************************************************
     // * Description: Verify if user is logged in and clicks Order History link in the footer section he/she directed to Account page
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 13, enabled =true)
    public void footerMyAccountTrackAnOrderUserLoggedIn(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(12);
        Q_JMB_NavigationObjects.footerMyAccountOrderHistory("My Account | JM Bullion");

        acc.logoutUser();
        
    }
    /*******************************************************************
     // * Description: Verify if user is logged in and clicks Track An Order link in the footer section he/she directed to Account page
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 14, enabled =true)
    public void footerMyAccountOrderHistoryUserLoggedIn(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(12);
        Q_JMB_NavigationObjects.footerMyAccountOrderHistory("My Account | JM Bullion");
        acc.logoutUser();
        
    }
    /*******************************************************************
     // * Description: Verify if user is logged in not and clicks Track An Order link in the footer section he/she prompted to login
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 15, enabled =true)
    public void footerMyAccountOrderHistoryGuest(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerMyAccountOrderHistory("Log In | JM Bullion");
        
    }
    /*******************************************************************
     // * Description: Verify user can check their Price Alerts from the footer menu
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 16, enabled =true)
    public void footerMyAccountPriceAlerts(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerMyAccountPriceAlerts();
        
    }
    /*******************************************************************
     // * Description: Verify storage information is available to users when they click Storage link  from the footer menu
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 17, enabled =true)
    public void footerMyAccountStorage(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerMyAccountStorage();
        
    }
    /*******************************************************************
     // * Description: Verify users are presented with Right to Opt Out when they click Do Not Sell My link from the footer menu
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 18, enabled =true)
    public void footerMyAccountPersonalInformation(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerMyAccountDoNotSellMyPersonalInformation();
        
    }
    /*******************************************************************
     // * Description: Verify users can navigate all the buttons on the About JM Bullion link in the footer menu
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 19, enabled =true)
    public void footerAboutUs(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerAboutUsAboutJMBullion();
        
    }
    /*******************************************************************
     // * Description: Verify users can navigate all the buttons on the About JM Bullion link in the footer menu
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 20, enabled =true)
    public void footerAboutUsCareers(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerAboutUsAboutJMBullion();
        
    }
    /*******************************************************************
    // * Description: Verify users can navigate to Job Listings from  career page / Benefits and back to Career page via page buttons
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 21, enabled =true)
    public void footerAboutUsCareersBenefits(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerAboutUsCareers();
        Q_JMB_NavigationObjects.footerAboutUsCareersBenefits();
        Q_JMB_NavigationObjects.footerAboutUsCareersBenefitsJobListing();
        
    }
    /*******************************************************************
     // * Description: Verify users Job Listings from career page in the Abouts Us footer section
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 22, enabled =true)
    public void footerAboutUsCareersJobOpenings(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerAboutUsCareers();
        Q_JMB_NavigationObjects.footerAboutUsCareersBenefitsJobs();
        
    }
    /*******************************************************************
     // * Description: Verify users have access to Shipping and Insurance information at Abouts Us footer section
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 23, enabled =true)
    public void footerAboutUsCareersShipping(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerAboutUsShippingAndInsurance();
        
    }
    /*******************************************************************
     // * Description: Verify users view and review all Payment Methods at Abouts Us footer section
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 24, enabled =true)
    public void footerAboutUsPaymentMethods(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerAboutUsPaymentMetods();
        
    }
    /*******************************************************************
     // * Description: Verify users view customer Reviews at Abouts Us footer section
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 25, enabled =true)
    public void footerAboutUsCustomerReviews(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerAboutUsReviews();
        
    }
    /*******************************************************************
     // * Description: Verify information about Government and Private Mints are listed at Abouts Us footer section
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 26, enabled =true)
    public void footerAboutUsMintsInformation(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerAboutUsMints();
        
    }
    /*******************************************************************
     // * Description: Verify information about Government and Private Mints are listed at Abouts Us footer section
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 27, enabled =true)
    public void footerInfoSalesTax(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_NavigationObjects.footerInfoSalesTaxCollectibles();

    }
    
    /******************************************************************
	 * Description: Improve confirmation that a Contact Us has been sent
	 * Author: Mobin
	 * Status:Complete
	 * Ticket: JMB-6279
	 *******************************************************************/
	@Test(priority = 28, enabled =true)
	public void contactUsConfirmation() throws InterruptedException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		Q_JMB_NavigationObjects.footerCustomerCareContactUs();
		Q_JMB_NavigationObjects.xp(jmbProps, "contactUs.contactOrdStatus.xp");
		Q_JMB_NavigationObjects.xp(jmbProps,"contactUs.btn.xp");
		Q_JMB_NavigationObjects.verifyReqFieldsInContactUsForm();
		Q_JMB_NavigationObjects.fillContactUsAndVerifySuccess();
	}
	
	/*******************************************************************
    // * Description: Verify FAQ Recent Article & FAQ category links 
    // * Parameter: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 29,enabled=true)
    public void verifyFAQRecentArticleAndCategoryLinks() {
    	String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		Q_JMB_NavigationObjects.footerCustomerCareFAQ();
		Q_JMB_WebElm.myWait(3000);
		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "jm.faqRecentArticles.xp"));
		System.out.println("Recent Articles displayed correctly");
		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "jm.faqCategories.xp"));
		System.out.println("FAQ Categories displayed correctly");
		nav.faqArticleCategoryLink();
		nav.faqFAQCategoriesLink();
	}
    
    /********************************************************************
	 * Description: Verify Add Footer Note in Loan Page Calculator
	 * Author: Karthick D
 	 * Status: Complete  
	 * Ticket: JMB-7292 
	 *******************************************************************/
   @Test (priority=30, enabled=true)
   public void verifyAddFootnoteToLoansPageCalculator(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
	    Q_JMB_WebElm.myWait(2000);
	    nav.verifyFootnoteIsDisplayed();
	    
    }
	
    @AfterTest
    public void endReport(){


    }
    @AfterMethod
    public void tearDown() throws Exception {

        Q_JMB_Controls.tearDown();
    }

    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
