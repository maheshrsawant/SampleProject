package com.PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ElementFactory {
	public static String DemandCreation ="DemandCreation";
	public static String RFFdashboard ="RFFdashboard";
	public static String demandDashbaord ="DemandDashboard";
	public static String LockingPage = "LockingPage";
	public static String SR = "SR";
	public static String transferSheet = "TransferData";
	public static String DemandClone = "DemandClone";
	public static String loginPath = System.getProperty("user.dir")+"/Screenshots/Login_Page/login_";
	public static String dataPath = System.getProperty("user.dir")+"/Testdata.xlsx";
	public static String Team ="Team";
	public static String MatchingScore ="MatchingScore";
	 public static String LoginEmail="LoginEmail";
	public static String Failure = System.getProperty("user.dir")+"/Screenshots/Failure/";
	public static String Skipped = System.getProperty("user.dir")+"/Screenshots/Skipped/";
	public static String Passed = System.getProperty("user.dir")+"/Screenshots/Passed/";

	public static String demandDetailsPath1 = System.getProperty("user.dir")+"/Screenshots/DemandDetails/TC01/DemandDetails_";
	public static String demandDetailsPath2 = System.getProperty("user.dir")+"/Screenshots/DemandDetails/TC02/DemandDetails_";
	
	public static String rffDashboardPath1 = System.getProperty("user.dir")+"/Screenshots/RFFDashboard/TC01/RFFDashboard_";
	public static String rffDashboardPath2 = System.getProperty("user.dir")+"/Screenshots/RFFDashboard/TC02/RFFDashboard_";
	public static String rffDashboardPath3 = System.getProperty("user.dir")+"/Screenshots/RFFDashboard/TC03/RFFDashboard_";
	public static String rffDashboardPath4 = System.getProperty("user.dir")+"/Screenshots/RFFDashboard/TC04/RFFDashboard_";
	public static String rffDashboardPath5 = System.getProperty("user.dir")+"/Screenshots/RFFDashboard/TC05/RFFDashboard_";
	public static String rffDashboardPath6 = System.getProperty("user.dir")+"/Screenshots/RFFDashboard/TC06/RFFDashboard_";
	public static String rffDashboardPath7 = System.getProperty("user.dir")+"/Screenshots/RFFDashboard/TC07/RFFDashboard_";
	
	public static String demandClonePath_TC01 = System.getProperty("user.dir")+"/Screenshots/DemandClone/TC01/DemandClone_";
	public static String demandClonePath_TC02 = System.getProperty("user.dir")+"/Screenshots/DemandClone/TC02/DemandClone_";
	public static String demandClonePath_TC03 = System.getProperty("user.dir")+"/Screenshots/DemandClone/TC03/DemandClone_";

	public static String srDetailsVerification_TC01 = System.getProperty("user.dir")+"/Screenshots/srDetailsVerification/TC01/srDetailsVerification_";
	
	public static String transferPath1 = System.getProperty("user.dir")+"/Screenshots/Transfer/TC01/Transfer_";
	public static String transferPath2 = System.getProperty("user.dir")+"/Screenshots/Transfer/TC02/Transfer_";
	public static String transferPath3 = System.getProperty("user.dir")+"/Screenshots/Transfer/TC03/Transfer_";
	public static String transferPath4 = System.getProperty("user.dir")+"/Screenshots/Transfer/TC04/Transfer_";
	public static String transferPath5 = System.getProperty("user.dir")+"/Screenshots/Transfer/TC05/Transfer_";
	public static String transferPath6 = System.getProperty("user.dir")+"/Screenshots/Transfer/TC06/Transfer_";
	public static String transferPath7 = System.getProperty("user.dir")+"/Screenshots/Transfer/TC07/Transfer_";
	public static String transferPath8 = System.getProperty("user.dir")+"/Screenshots/Transfer/TC08/Transfer_";
	public static String transferPath9 = System.getProperty("user.dir")+"/Screenshots/Transfer/TC09/Transfer_";
	public static String transferPath10 = System.getProperty("user.dir")+"/Screenshots/Transfer/TC10/Transfer_";
	public static String transferPath11 = System.getProperty("user.dir")+"/Screenshots/Transfer/TC11/Transfer_";
  	
	public static String QuickEdit ="QuickEdit";
    public static String quickEdit_TC01 = System.getProperty("user.dir")+"/Screenshots/DemandQE/TC01/QE_";
    public static String quickEdit_TC02 = System.getProperty("user.dir")+"/Screenshots/DemandQE/TC02/QE_";
    public static String quickEdit_TC03 = System.getProperty("user.dir")+"/Screenshots/DemandQE/TC03/QE_";
    public static String quickEdit_TC04 = System.getProperty("user.dir")+"/Screenshots/DemandQE/TC04/QE_";
    public static String quickEdit_TC05 = System.getProperty("user.dir")+"/Screenshots/DemandQE/TC05/QE_";
    public static String quickEdit_TC06 = System.getProperty("user.dir")+"/Screenshots/DemandQE/TC06/QE_";
    public static String quickEdit_TC07 = System.getProperty("user.dir")+"/Screenshots/DemandQE/TC07/QE_";
    public static String quickEdit_TC08 = System.getProperty("user.dir")+"/Screenshots/DemandQE/TC08/QE_";
    public static String quickEdit_TC09 = System.getProperty("user.dir")+"/Screenshots/DemandQE/TC09/QE_";

	
	
  	public static String DemandCancellationPath1 = System.getProperty("user.dir")+"/Screenshots/DemandCancellation/TC01/DemandCancellation_";
	public static String DemandCancellationPath2 = System.getProperty("user.dir")+"/Screenshots/DemandCancellation/TC02/DemandCancellation_";
	public static String DemandCancellationPath3 = System.getProperty("user.dir")+"/Screenshots/DemandCancellation/TC03/DemandCancellation_";
	public static String DemandCancellationPath4 = System.getProperty("user.dir")+"/Screenshots/DemandCancellation/TC04/DemandCancellation_";
	public static String DemandCancellationPath5 = System.getProperty("user.dir")+"/Screenshots/DemandCancellation/TC05/DemandCancellation_";
	public static String DemandCancellation ="DemandCancellation";
	
	public static String teamPath1 = System.getProperty("user.dir")+"/Screenshots/Team/TC01/Team_";
	public static String teamPath2 = System.getProperty("user.dir")+"/Screenshots/Team/TC02/Team_";
	public static String teamPath3 = System.getProperty("user.dir")+"/Screenshots/Team/TC03/Team_";
	public static String teamPath4 = System.getProperty("user.dir")+"/Screenshots/Team/TC04/Team_";
	public static String teamPath5 = System.getProperty("user.dir")+"/Screenshots/Team/TC05/Team_";
	public static String teamPath6 = System.getProperty("user.dir")+"/Screenshots/Team/TC06/Team_";
	public static String teamPath7 = System.getProperty("user.dir")+"/Screenshots/Team/TC07/Team_";
	public static String teamPath8 = System.getProperty("user.dir")+"/Screenshots/Team/TC08/Team_";
	public static String teamPath9 = System.getProperty("user.dir")+"/Screenshots/Team/TC09/Team_";
	public static String teamPath10 = System.getProperty("user.dir")+"/Screenshots/Team/TC10/Team_";
	public static String teamPath11 = System.getProperty("user.dir")+"/Screenshots/Team/TC11/Team_";
	
	//Change Roll off
	public static String changeRRSheet = "ChangeRollOff";
	public static String changeRR1 =  System.getProperty("user.dir")+"/Screenshots/ChangeRollOff/TC01/ChangeRollOff_";
	public static String changeRR2 =  System.getProperty("user.dir")+"/Screenshots/ChangeRollOff/TC02/ChangeRollOff_";
	public static String changeRR3 =  System.getProperty("user.dir")+"/Screenshots/ChangeRollOff/TC03/ChangeRollOff_";
	public static String changeRR4 =  System.getProperty("user.dir")+"/Screenshots/ChangeRollOff/TC04/ChangeRollOff_";
	public static String changeRR5 =  System.getProperty("user.dir")+"/Screenshots/ChangeRollOff/TC05/ChangeRollOff_";
	public static String changeRR6 =  System.getProperty("user.dir")+"/Screenshots/ChangeRollOff/TC06/ChangeRollOff_";
	public static String changeRR7 =  System.getProperty("user.dir")+"/Screenshots/ChangeRollOff/TC07/ChangeRollOff_";
	public static String changeRR8 =  System.getProperty("user.dir")+"/Screenshots/ChangeRollOff/TC08/ChangeRollOff_";
	public static String changeRR9 =  System.getProperty("user.dir")+"/Screenshots/ChangeRollOff/TC09/ChangeRollOff_";
	public static String changeRR10 =  System.getProperty("user.dir")+"/Screenshots/ChangeRollOff/TC10/ChangeRollOff_";
	
	//Dev Login details
	@FindBy(xpath=".//*[@id='username']") public WebElement usesrname;
	@FindBy(xpath=".//*[@id='username']/option[1]") public WebElement duUser;
	@FindBy(xpath=".//*[@id='username']/option[2]") public WebElement centralUser;
	@FindBy(xpath=".//*[@id='username']/option") public List<WebElement> usernameList;
	
	@FindBy(xpath=".//*[@id='step1']//*[@id='btnClose']")
	public  WebElement fcClose;
	@FindBy(xpath="//*[@id='userNameInput']") 
	public  WebElement loginUsername;
	@FindBy(xpath="//*[@id='passwordInput']")
	public  WebElement loginPassword;
	@FindBy(xpath="//*[@id='submitButton']")
	public  WebElement loginSubmit;
	@FindBy(xpath=".//*[@id='pwd-content']/input") 
	public  WebElement devSubmit;
	@FindBy(xpath=".//*[@class='ui-select-choices-row ng-scope active']/span")
	public static WebElement selectDropdownValue;
	
	//@FindBy(xpath="..//*[@id='NavigatetoDemand']/a") public static WebElement demandTab;
	
	public static String demandCreationPath_TC01 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC01/NonGCP_";
	public static String demandCreationPath_TC02 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC02/GCP_";
	public static String demandCreationPath_TC03 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC03/TC03_";
	public static String demandCreationPath_TC04 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC04/TC04_";
	public static String demandCreationPath_TC05 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC05/TC05_";
	public static String demandCreationPath_TC06 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC06/TC06_";
	public static String demandCreationPath_TC07 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC07/TC07_";
	public static String demandCreationPath_TC08 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC08/TC08_";
	public static String demandCreationPath_TC09 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC09/TC09_";
	public static String demandCreationPath_TC10 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC10/TC10_";
	public static String demandCreationPath_TC11 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC11/TC11_";
	public static String demandCreationPath_TC12 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC12/TC12_";
	public static String demandCreationPath_TC13 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC13/TC13_";
	public static String demandCreationPath_TC14 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC14/TC14_";
	public static String demandCreationPath_TC15 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC15/TC15_";
	public static String _TC01 = System.getProperty("user.dir")+"/Screenshots/DemandCreation/TC01/NonGCP_";
	
	// Home Page Webelements
	@FindBy(xpath=".//*[@id='NavigatetoDemand']/a") public static WebElement demandTab;
	@FindBy(xpath=".//*[@id='NavigatetoTeam']/a") public static WebElement teamTab;
	@FindBy(xpath=".//*[@id='NavigatetoRequests']/a") public static WebElement requestTab;
	@FindBy(xpath=".//*[@id='NavigatetoReports']/a") public static WebElement reportsTab;
	@FindBy(xpath=".//*[@id='NavigatetoReview']/a") public static WebElement reveiwTab;
	@FindBy(xpath="//*[@id='NavigatetoReview']/a")public static WebElement sourcingStrategyTab;
	
	@FindBy(xpath=".//*[@class='ui-grid-render-container ng-isolate-scope ui-grid-render-container-body']/div[2]/div/div[1]/div/div/div[1]/div/a")  public static WebElement firstRRDonDemandPage;
	@FindBy(xpath=".//*[@id='team_cell']/a") public static WebElement firstResOnTeamPage;
	@FindBy(xpath=".//*[@id='locksContent']/ul") public static WebElement lockHeaderOnReqPage;
	@FindBy(xpath=".//*[@id='reportContent']/ul") public static WebElement reportContentPage;

    @FindBy(how= How.XPATH, using="//*[@id='demand']//*[@class='navbar navbar-inverse navbar-fixed-top']//*[@class='nav navbar-nav navbar-right hidden-xs BoxText']//*[@aria-label='Search']")
    public static WebElement mainSearchIconClick;
    @FindBy(xpath="//*[@id='MainSearch']") public static WebElement mainSearch;
    @FindBy(xpath=".//*[@id='Search_EnterpriseID']/a") public static WebElement enterpriseIDMainSearch;
    @FindBy(xpath=".//*[@id='Search_RRD']/a") public static WebElement rrdMainSearch;
    @FindBy(xpath=".//*[@id='Search_SLL']/a") public static WebElement skillLevelLocationMainSearch;

    // WebElements on RRD page
	@FindBy(xpath=".//*[@id='taggedTab']") public static WebElement taggedTab;
	@FindBy(xpath=".//*[@id='detailsTab']") public static WebElement detailsTab;
	@FindBy(xpath=".//*[@id='jobDescrTab']") public static WebElement jobDescriptionTab;

	
	@FindBy(css=".ui-grid-filter-input") public static WebElement rrdSearchBox;
	@FindBy(css=".rrd-search") public static WebElement rrdSearchIcon;
	
	@FindBy(xpath="//*[@id='supplyContent']//*[@class='add-supply-link']/a") public static WebElement addSupplyButton;
    @FindBy(xpath=".//*[@id='AddSupplyModal']//*[@class='right-inner-addon-1 BoxText']/input") public static WebElement addSupplyInput;
    @FindBy(xpath=".//*[@class='uib-typeahead-match ng-scope active']") public static WebElement addSupplySelectDropdownValue;

    //@FindBy(xpath="//*[@id='refDemand']")public static  WebElement rffTab;
    // WebElements on rffTab
   // @FindBy(how= How.XPATH,using=".//*tab xpath required here']")
   // public static WebElement rffTab;
    
    @FindBy(xpath="//*[@id='refDemand']")public static WebElement rffTab;
    @FindBy(xpath=".//*[@class='ui-grid-canvas']/div[1]/div/div/div[9]/div/a/span[1]")public static WebElement RejDashexpandButton;

    @FindBy(xpath=".//*[@class='ui-grid-canvas']/div[1]/div/div[1]/div/div/div[1]/div") public static WebElement firstCheckBoxButtonOnLockPage; 
    
    @FindBy(xpath=".//*[@class='next']") 
    public static WebElement nextMonth;
    
    //general Edit
    public static String GeneralEdit ="GeneralEdit";    public static String generalEdit_TC01 = System.getProperty("user.dir")+"/Screenshots/DemandGE/TC01/GE_";
    public static String generalEdit_TC02 = System.getProperty("user.dir")+"/Screenshots/DemandGE/TC02/GE_";
    public static String generalEdit_TC03 = System.getProperty("user.dir")+"/Screenshots/DemandGE/TC03/GE_";
    public static String generalEdit_TC04 = System.getProperty("user.dir")+"/Screenshots/DemandGE/TC04/GE_";
    public static String generalEdit_TC05 = System.getProperty("user.dir")+"/Screenshots/DemandGE/TC05/GE_";
    public static String generalEdit_TC06 = System.getProperty("user.dir")+"/Screenshots/DemandGE/TC06/GE_";
    public static String generalEdit_TC07 = System.getProperty("user.dir")+"/Screenshots/DemandGE/TC07/GE_";
    public static String generalEdit_TC08 = System.getProperty("user.dir")+"/Screenshots/DemandGE/TC08/GE_";
    public static String generalEdit_TC09 = System.getProperty("user.dir")+"/Screenshots/DemandGE/TC09/GE_";
     public static String generalEdit_TC10 = System.getProperty("user.dir")+"/Screenshots/DemandGE/TC10/GE_"; 
    
    // Locking
    public static String LockingPagePath_TC01 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC01/LockingPage_";
    public static String LockingPagePath_TC02 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC02/LockingPage_";
    public static String LockingPagePath_TC03 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC03/LockingPage_";
    public static String LockingPagePath_TC04 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC04/LockingPage_";
    public static String LockingPagePath_TC05 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC05/LockingPage_";
    public static String LockingPagePath_TC06 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC06/LockingPage_";
    public static String LockingPagePath_TC07 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC07/LockingPage_";
    public static String LockingPagePath_TC08 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC08/LockingPage_";
    public static String LockingPagePath_TC09 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC09/LockingPage_";
    public static String LockingPagePath_TC10 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC10/LockingPage_";
    public static String LockingPagePath_TC11 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC11/LockingPage_";
    public static String LockingPagePath_TC12 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC12/LockingPage_";
    public static String LockingPagePath_TC13 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC13/LockingPage_";
    public static String LockingPagePath_TC14 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC14/LockingPage_";
    public static String LockingPagePath_TC15 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC15/LockingPage_";
    public static String LockingPagePath_TC16 = System.getProperty("user.dir")+"/Screenshots/LockingPage/TC16/LockingPage_";
    
    
    
    
    //Pending approval
    public static String pendingApprovaPath1 = System.getProperty("user.dir")+"/Screenshots/PendingApproval/TC01/PendingApproval_";
    public static String pendingApprovaPath2 = System.getProperty("user.dir")+"/Screenshots/ PendingApproval /TC02/PendingApproval_";
    public static String pendingApprovaPath3 = System.getProperty("user.dir")+"/Screenshots/ PendingApproval /TC03/PendingApproval_";
    public static String pendingApprovaPath4 = System.getProperty("user.dir")+"/Screenshots/ PendingApproval /TC04/PendingApproval_";

    //Demand Details
    public static String demandDetailsPagePath1 = System.getProperty("user.dir")+"/Screenshots/DemandDetails/TC01/DemandDetails_";
    public static String demandDetailsPagePath2 = System.getProperty("user.dir")+"/Screenshots/DemandDetails/TC02/DemandDetails_";
    public static String demandDetailsPagePath3 = System.getProperty("user.dir")+"/Screenshots/DemandDetails/TC03/DemandDetails_";
    public static String demandDetailsPagePath4 = System.getProperty("user.dir")+"/Screenshots/DemandDetails/TC04/DemandDetails_";
    public static String demandDetailsPagePath5 = System.getProperty("user.dir")+"/Screenshots/DemandDetails/TC05/DemandDetails_";
    public static String demandDetailsPagePath6 = System.getProperty("user.dir")+"/Screenshots/DemandDetails/TC06/DemandDetails_";
    public static String demandDetailsPagePath7 = System.getProperty("user.dir")+"/Screenshots/DemandDetails/TC07/DemandDetails_";

    //SR
    public static String SR_TC01 = System.getProperty("user.dir")+"/Screenshots/SR/TC01/SR_";
    public static String SR_TC02 = System.getProperty("user.dir")+"/Screenshots/SR/TC02/SR_";
    public static String SR_TC03 = System.getProperty("user.dir")+"/Screenshots/SR/TC03/SR_";
    public static String SR_TC04 = System.getProperty("user.dir")+"/Screenshots/SR/TC04/SR_";
    public static String SR_TC05 = System.getProperty("user.dir")+"/Screenshots/SR/TC05/SR_";
    public static String SR_TC06 = System.getProperty("user.dir")+"/Screenshots/SR/TC06/SR_";
    public static String SR_TC07 = System.getProperty("user.dir")+"/Screenshots/SR/TC07/SR_";
    public static String SR_TC08 = System.getProperty("user.dir")+"/Screenshots/SR/TC08/SR_";
    public static String SR_TC09 = System.getProperty("user.dir")+"/Screenshots/SR/TC09/SR_";
    
  //Pending approval
    public static String pendingApprovalPath1 = System.getProperty("user.dir")+"/Screenshots/PendingApproval/TC01/PendingApproval_";
    public static String pendingApprovalPath2 = System.getProperty("user.dir")+"/Screenshots/PendingApproval/TC02/PendingApproval_";
    public static String pendingApprovalPath3 = System.getProperty("user.dir")+"/Screenshots/PendingApproval/TC03/PendingApproval_";
    public static String pendingApprovalPath4 = System.getProperty("user.dir")+"/Screenshots/PendingApproval/TC04/PendingApproval_";

    //Matrching Roles
    public static String matchingRolesPath1 = System.getProperty("user.dir")+"/Screenshots/MatchingRoles/TC01/MatchingRoles_";
    public static String matchingRolesPath2 = System.getProperty("user.dir")+"/Screenshots/MatchingRoles/TC02/MatchingRoles_";
	}
