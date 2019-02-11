package com.Pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.asserts.SoftAssert;

import com.PageFactory.ElementFactory;
import com.Utility.ConfigReader;
import com.Utility.MethodFactory;
import com.Utility.ReadExcel;
import com.Utility.TakeScreenshot;
import com.Utility.UtilMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MatchingSupplyPage {
	
	WebDriver driver;
	MethodFactory mf = new MethodFactory();
	ConfigReader config = new ConfigReader();
	public static String getResourcePersonnalNumberforDraft=null;
	public static String skillSelectedOnSupplyPage=null;
	public static int rowNumber;
	public String TS;
	public static String rrdNumber;
	public static String ResPersNo=null,ResCapttiveFlag=null;
	public static String EmpID=null;
	public static String NRresourceName=null;
	public static String NRrrd=null;
	public static int j = 1;
	public static boolean status;
	public static boolean  nrStatus;
	SoftAssert softly = new SoftAssert();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	// Test Data ReadExcel Path
	//Screenshot Paths
	public String MatchingSupplySSPath1 = System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC01/MS_";
	public String MatchingSupplySSPath2 = System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC02/MS_";
	public String MatchingSupplySSPath3 = System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC03/MS_";
	public String MatchingSupplySSPath4 = System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC04/MS_";
	public String MatchingSupplySSPath5 = System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC05/MS_";
	public String MatchingSupplySSPath6 = System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC06/MS_";
	public String MatchingSupplySSPath7 = System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC07/MS_";
	public String MatchingSupplySSPath8_1 = System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC08/MS_Central_";
	public String MatchingSupplySSPath8_2= System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC08/MS_DU_";
	public String MatchingSupplySSPath8_3= System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC08/MS_NR_";
	public String MatchingSupplySSPath9 = System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC09/MS_";
	public String MatchingSupplySSPath10= System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC010/MS_";
	public String MatchingSupplySSPath11= System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC011/MS_";
	public String MatchingSupplySSPath12= System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC012/MS_";
	public String MatchingSupplySSPath13= System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC013/MS_";
	public String MatchingSupplySSPath14= System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC014/MS_";
	public String MatchingSupplySSPath15= System.getProperty("user.dir")+"/Screenshots/MatchingSupply_Validations/TC015/MS_";


	
	@FindBy(xpath=".//*[@id='DemDetDemBySkills']//*[@class='dropdown-toggle ng-binding btn btn-default']") public WebElement skillDropdownFilter;
	@FindBy(xpath=".//*[@id='DemDetDemBySkills']//*[@class='dropdown-header']/input") public WebElement skillDropdownFilterSearchField;
	@FindBy(xpath=".//*[@id='DemDetDemBySkills']//*[@class='ng-binding ng-scope']") public WebElement selectSkillValue;
	@FindBy(xpath="//*[@id='DemDetFilterByProj']//*[@class='dropdown-toggle ng-binding btn btn-default']") public WebElement projectDropdownFilter;
	@FindBy(xpath=".//*[@id='DemDetFilterByProj']//*[@class='dropdown-header']/input") public WebElement projectDropdownFilterSearchField;
	@FindBy(xpath=".//*[@id='DemDetFilterByProj']//*[@class='ng-binding ng-scope']") public WebElement selectProjectValue;

	
	@FindBy(xpath=".//*[@id='DemDEtFilterByLevel']//*[@class='multiselect-parent btn-group dropdown-multiselect']/button") public WebElement levelDropdownFilter;
	@FindBy(xpath=".//*[@id='DemDEtFilterByLevel']//*[@class='dropdown-header']/input") public WebElement levelDropdownFilterSearchField;
	@FindBy(xpath=".//*[@class='option']//*[@class='ng-binding ng-scope']") public List <WebElement> selectLevelInValue;
	
	@FindBy(xpath=".//*[@class='option']") public List <WebElement> filterDropdownValues;

	@FindBy(xpath=".//*[@id='DemDetActions']/div/button[1]") public WebElement applyButtonDemandPage;
	@FindBy(xpath=".//*[@id='byChannelContent']/section/ul/div") public WebElement byChannelContent;
	@FindBy(xpath=".//*[@id='supplyContent']/section/div[2]/div/matching-supply-resource-list/section/div/div[1]/div") public WebElement byChannelContentSupplyPage;
    
    @FindBy(xpath=".//*[@class='ui-grid-canvas']/div[1]//*[@class='ng-scope']//*[@class='handicon ng-binding ng-scope']") public WebElement firstRRDonDemandPage;
	@FindBy(xpath=".//*[@class='ui-grid-canvas']//*[@class='ng-scope']//*[@class='handicon ng-binding ng-scope']") public List <WebElement> rrdNumberOnDemandPage;
	@FindBy(xpath=".//*[@class='ui-grid-canvas']//*[@class='ng-scope']//*[@class='ng-binding ng-scope']") public List <WebElement> srNumberOnDemandPage;

	@FindBy(xpath=".//*[@id='ms_actions']/span/a") public List <WebElement> actionButtonSupplyPage;
	@FindBy(xpath=".//*[@id='ms_tagged_action_items']/a") public List <WebElement> actionButtonTaggedTab;
	@FindBy(xpath=".//*[@id='ms_tagged_action_items']/ul") public  WebElement actionFrameTaggedTab;

	
	@FindBy(xpath=".//*[@class='identifier-icons']//*[@id='ms_tagged_cell']") public List <WebElement> resNameTaggedTab;
	@FindBy(xpath=".//*[@id='taggedContent']//*[@class='text-center ng-scope']") public List <WebElement> noDataAvailableaggedTab;

	
	
	@FindBy(xpath=".//*[@id='matching_supply']/div[1]/div[1]/div/a") public WebElement backButtonOnDemandPage;
	@FindBy(xpath=".//*[@class='col-md-8 ng-scope']//*[@class='ng-binding']") public WebElement rrdNoDetails;
	@FindBy(xpath=".//*[@id='matching_supply']//*[@class='btn btn-primary ng-binding extHire']") public List <WebElement> updateSRButtonOnRRDPage;
	@FindBy(xpath=".//*[@class='supply-info']/span") public WebElement rrdBasicDetails;
	@FindBy(xpath=".//*[@id='matching_supply']//*[@class='btn btn-primary ng-binding']") public List <WebElement> recommendForExternalHireButton;
	@FindBy(xpath=".//*[@class='btn btn-primary btn-delete']") public List <WebElement> demandCancelButton;
	@FindBy(xpath=".//*[@id='MSResourceWithinIGGraph']//*[@class='nv-groups']//*[@class='bar-values']") public List <WebElement> countWithinIGBarGraph;
	@FindBy(xpath=".//*[@id='MSResourceWithinIGGraph']//*[@class='nv-groups']//*[@class='nv-bar positive']") public List <WebElement> WithinIGBarGraph;

	
	
	@FindBy(xpath=".//*[@class='btn close-page acn-cross']") public WebElement backButtonOnResourcePage;
	@FindBy(xpath=".//*[@class='add-supply-link']/a") public WebElement addSupplyButtonOnSupplyPage;
	@FindBy(xpath=".//*[@id='AddSupplyModal']//*[@class='right-inner-addon-1 BoxText']/input") public WebElement addSupplyInputField;
	@FindBy(xpath=".//*[@class='ng-binding ng-scope']/strong") public WebElement addSupplyAutoPopulatedValue;
	@FindBy(xpath=".//*[@id='AddSupplyModal']//*[@class='col-sm-12 ng-scope']") public WebElement addSupplyResultTable;

	

	@FindBy(css="text.nvd3") public List <WebElement> noDataAvailable;
	@FindBy(xpath=".//*[@id='taggedContent']/section/div/div/div/div/matching-supply-tagged-list/section/div[2]") public List <WebElement> noSupplyTagged;
	@FindBy(xpath=".//*[@id='taggedContent']/section/div/div/div/div/matching-supply-tagged-list/section/div[2]") public  WebElement noSupplyTaggedElement;
	@FindBy(xpath=".//*[@id='ms_tagged_cell']//*[@class='identifier-icons']") public  List <WebElement> resStatusOnTaggedTab;
	  
	@FindBy(css="#MSResourceWithinIGGraph > svg > g > g > g.nv-barsWrap.nvd3-svg > g > g > g > g > rect:nth-child(1)") public WebElement benchWithinIGBarGraph;
	@FindBy(css="#MSResourceWithinIGGraph > svg > g > g > g.nv-barsWrap.nvd3-svg > g > g > g > g > rect:nth-child(2)") public WebElement rovWithinIGBarGraph;
	@FindBy(css="#MSResourceWithinIGGraph > svg > g > g > g.nv-barsWrap.nvd3-svg > g > g > g > g > rect:nth-child(3)") public WebElement benchJoinerWithinIGBarGraph;
	
	@FindBy(css="#MSResourceOutsideIGGraph > svg > g > g > g.nv-barsWrap.nvd3-svg > g > g > g > g > rect:nth-child(1)") public WebElement benchOtherIGBarGraph;
	@FindBy(css="#MSResourceOutsideIGGraph > svg > g > g > g.nv-barsWrap.nvd3-svg > g > g > g > g > rect:nth-child(2)") public WebElement rovOtherIGBarGraph;
	@FindBy(css="#MSResourceOutsideIGGraph > svg > g > g > g.nv-barsWrap.nvd3-svg > g > g > g > g > rect:nth-child(3)") public WebElement benchJoinerOtherIGBarGraph;

	@FindBy(css="#MSResourceOutsideIGGraph > svg > g > g > g.nv-barsWrap.nvd3-svg > g > g > g > g > text") public List <WebElement> countBenchOtherIGBarGraph;

	
	@FindBy(xpath=".//*[@id='ms_resource_cell']//*[@class='identifier-icons']/a[1]") public  List <WebElement> resNameListRRDPage;

	
	@FindBy(xpath=".//*[@class='supply-list']//*[@class='container-fluid']/section/div/div/label") public List <WebElement> filtersOnSupplyPage;
    public String[] expFilterOnSupplyPage = {"FILTER BY BADGE", "FILTER BY PRIMARY SKILL", "FILTER BY LEVEL", "FILTER BY LOCATION", "FILTER BY IG", "FILTER BY MATCHING INDEX", "SEARCH", "FILTER BY CAPTIVE FLAG"};
	@FindBy(xpath=".//*[@id='ms_resource_list_filterbyskill']//*[@class='dropdown-toggle ng-binding btn btn-default']") public WebElement filterBySkillField;
	@FindBy(xpath=".//*[@class='dropdown-menu dropdown-menu-form ng-scope']//*[@class='ng-binding ng-scope']") public List <WebElement> filterBySkillDropdownValues;
	@FindBy(xpath=".//*[@id='ms_resource_list_filter_actions']//*[@class='btn btn-primary btn-sm apply-btn']") public WebElement filterApplyButtonOnSupplyPage;
	@FindBy(xpath=".//*[@class='ui-grid-viewport ng-isolate-scope']//*[@class='ng-isolate-scope']/div[4]/div") public List <WebElement> listofSkillSupplyPageGrid;
	@FindBy(xpath=".//*[@class='ui-grid-header-cell-row']//*[@class='ui-grid-cell-contents ui-grid-header-cell-primary-focus']/span[1]") public List <WebElement> gridColumnsOnSupplyPage;
    public String[] expGridColumnsOnSupplyPage = {"MATCHING INDEX", "NAME", "IG", "PRIMARY SKILL", "LEVEL", "LOCATION", "AVAILABILITY", "TAGGED TO OTHER DEMANDS", ""};

	@FindBy(xpath=".//*[@id='Span2']/a/span") public List <WebElement> chatBoxForResource;
	@FindBy(xpath="//*[@id='ms_resource_list_filter_actions']/div/button[2]") public WebElement filterClearButtonOnSupplyPage;
	
	@FindBy(xpath=".//*[@class='dropdown grid-more open']//*[text()='SOFT LOCK']") public List <WebElement> softLockButtonSupplyAction;
	@FindBy(xpath=".//*[@class='dropdown grid-more open']//*[text()='TAG SUPPLY']") public List <WebElement> tagSupplyButtonSupplyAction;
	@FindBy(xpath=".//*[@class='dropdown grid-more open']//*[text()='HARD LOCK']") public List <WebElement> hardLockSupplyAction;
	@FindBy(xpath=".//*[@class='dropdown grid-more open']//*[text()='SHADOW HARD LOCK']") public List <WebElement> shadowHardLockButtonSupplyAction;
	@FindBy(xpath=".//*[@class='dropdown grid-more open']//*[text()='NOT REACHABLE']") public List <WebElement> notReachableButtonSupplyAction;
	@FindBy(xpath=".//*[@class='dropdown grid-more open']//*[text()='REJECT']") public List <WebElement> rejectButtonSupplyAction;
	@FindBy(xpath=".//*[@class='dropdown grid-more open']//*[text()='REFUSE']") public List <WebElement> refuseButtonSupplyAction;
	@FindBy(xpath=".//*[@class='dropdown grid-more open']//*[text()='FUTURE SOFT LOCK']") public List <WebElement> futureSoftLockButtonSupplyAction;
	@FindBy(xpath=".//*[@class='dropdown grid-more open']//*[text()='FUTURE HARD LOCK']") public List <WebElement> futureHardLockSupplyAction;
	@FindBy(xpath=".//*[@class='dropdown grid-more open']//*[text()='FUTURE SHADOW HARD LOCK']") public List <WebElement> futureShadowHardLockButtonSupplyAction;
	@FindBy(xpath=".//*[@class='dropdown grid-more open']//*[text()='CHALLENGE']") public List <WebElement> challengeButtonSupplyAction;
	@FindBy(xpath=".//*[@class='dropdown grid-more open']//*[text()='SL to HL CONVERSION']") public List <WebElement> sltoHLConversionButtonSupplyAction;
	@FindBy(xpath=".//*[@class='dropdown grid-more open']//*[text()='SL TO SHADOW HL CONVERSION']") public List <WebElement> sltoShadowHLConversionButtonSupplyAction;
	
	@FindBy(xpath=".//*[@class='ng-scope sortable']/div[1]/span[2]/i") public List <WebElement> sortingIconOnSupplyPage;
	@FindBy(xpath=".//*[@id='evalPendingTab']/div[1]") public WebElement pendingEvaluationTabDemandPage;
    @FindBy(xpath=".//*[@class='ui-grid-canvas']/div[1]//*[@class='ng-scope']//*[@class='dropdown grid-more']") public WebElement firstresActionButtonOnTaggedTab;
	@FindBy(xpath=".//*[@class='searchfilters']/div/div/div/label") public List <WebElement> filterLabelsOnTaggedTab;
    public String[] expFilterValueOnTaggedTab = {"FILTER BY IG", "FILTER BY BADGE", "FILTER BY PRIMARY SKILL", "FILTER BY LEVEL", "FILTER BY LOCATION"};
	@FindBy(xpath=".//*[@class='searchfilters']/div/div/div/div/div/button") public List <WebElement> filterButtonOnTaggedTab;
	@FindBy(xpath=".//*[@class='ui-grid-cell-contents ui-grid-header-cell-primary-focus']/span[1]") public List <WebElement> attributesOnTaggedTab;
    public String[] expAttributesOnTaggedTab = {"MATCHING INDEX", "NAME", "STATUS", "AVAILABILITY", "IG", "PRIMARY SKILL", "LEVEL", "LOCATION", ""};
	@FindBy(xpath=".//*[@id='jobDescrContent']//*[@class='desc-title']") public List <WebElement> jobDescriptionContentTitleList;
	@FindBy(xpath=".//*[@id='jobDescrTab']") public WebElement jobDescriptionTab;
	public String[] expjobDescriptionContentTitleList = {"Role", "Role Description", "Job Requirements", "Must to have skills", "Good to have skills"};

	@FindBy(xpath=".//*[@id='LockActionExpand']//*[@class='expand-row-icon']") public List <WebElement> expandButtonOnLockPage;
	@FindBy(xpath=".//*[@class='expanded-content ng-scope']//*[@class='control-label']") public List <WebElement> expandedHeaderOptions;
	@FindBy(xpath=".//*[text()='Pending Approval']") public WebElement pendingApprovalText;
	@FindBy(xpath=".//*[@id='demand']//*[@class='src-info ng-binding']") public WebElement resInfo;
	@FindBy(xpath=".//*[@id='matching_supply']//*[@class='supply-info']/span") public WebElement demandInfo;

	@FindBy(xpath=".//*[@id='ms_resource_cell']//*[@class='handicon icons acn-unlocked ng-scope']") public List <WebElement> lockSymbolOnResSupplyPage;

	@FindBy(xpath=".//*[@class='ui-grid-cell-contents ng-scope']/div/a[2]") public List <WebElement> lockSymbolOnAddSupplyModelPage;

	
	@FindBy(xpath=".//*[@id='demand']/ui-view/section/div[1]/div/div/div/div[1]/div/div/section/div/p/text()[2]") public WebElement resInfofirstline;

	@FindBy(xpath=".//*[@id='AddSupplyModal']//*[@class='close']") public WebElement addSupplyModalCloseButton;

	@FindBy(xpath=".//*[@class='ui-grid-canvas']//*[@class='skill-status ontologyspeciality']") public List <WebElement> purpleColourIcon;
	@FindBy(xpath=".//*[@class='ui-grid-canvas']//*[@class='skill-status secondary']") public List <WebElement> cyanColourIcon;

	@FindBy(xpath=".//*[@class='ng-binding Evaluation-color']") public List <WebElement> resHighlightInRedTaggedTab;
	@FindBy(xpath=".//*[@id='NotReachable_Tagged']/a") public WebElement notReachableOptionActionButton;
	@FindBy(xpath=".//*[@id='NotReachableLabel']") public WebElement notReachableModalPopUp;
	@FindBy(xpath=".//*[@id='NotReachableDate']") public WebElement notReachableDateField;

	@FindBy(xpath="//table[@class='table-condensed']//td") public static List <WebElement> notReachableDdates;
	@FindBy(xpath=".//*[@id='NotReachableComments']") public WebElement notReachableCommentsField;
	@FindBy(xpath=".//*[@class='modal-body']/div[2]/button") public WebElement notReachableSubmitButton;
	@FindBy(xpath=".//*[@id='ShadowLockpopup']/div/div/div[2]/div/p") public WebElement notReachableSuccessPopup;
	@FindBy(xpath=".//*[@id='matching_supply']//*[@class='col-md-8 ng-scope']/h1") public WebElement rrdNumberInfo;

	@FindBy(xpath="//button[@class = 'btn btn-link btn-sm']") public WebElement filterClearButtonOnDemandPage;
	@FindBy(xpath=".//a[@class = 'trend-outside-link ng-scope']") public WebElement trendOutsideAccLink;
	@FindBy(xpath=".//a[@class = 'trend-outside-link ng-scope']") public List <WebElement> trendOutsideAccLinkList;

	@FindBy(xpath=".//div[@class = 'title ng-binding']") public WebElement trendOutsideAccLabel;
	@FindBy(xpath="//*[name() = 'g']/*[name() = 'g'][@class = 'g']/*[name() = 'rect']") public List <WebElement> miBargraph ;
	@FindBy(xpath="//*[name() = 'g']/*[name() = 'g'][@class = 'g']") public List <WebElement> miBargraphCount;
	@FindBy(xpath=".//*[name() = 'g'][@class = 'x axis']/*") public List <WebElement> miBargraphLabels;
	@FindBy(xpath="//div[@class = 'pool-title ng-binding']") public WebElement miActiveBargraphLabels;
	@FindBy(xpath="//div[@class = 'clearfix']//li") public List <WebElement> careerLevelLabels;
	//TC11 xpath's
	@FindBy(xpath=".//*[@class='supplyIg active']//*[@class='rov tab-text ng-binding']") public WebElement withinIG;
	@FindBy(xpath=".//*[@class='supplyGu']//*[@class='rov tab-text ng-binding']") public WebElement withinDu;
	@FindBy(xpath=".//*[@class='supplyClient']//*[@class='rov tab-text ng-binding']") public WebElement withinClient;
	@FindBy(xpath=".//*[@id='ms_resource_list_filterbyCaptiveflag']/label") public WebElement captiveFilter;
	@FindBy(xpath=".//*[@id='ms_resource_list_filterbyCaptiveflag']//button") public WebElement selectCaptiveFilter;
	@FindBy(xpath=".//*[@id='ms_resource_list_filterbyCaptiveflag']//input") public WebElement inputCaptiveValue;
	@FindBy(xpath=".//*[@id='ms_resource_list_filterbyCaptiveflag']//a") public WebElement selectCaptiveFilterValue;

	//Captive
	@FindBy(xpath=".//*[@id='DemDetFilterByCaptiveFlag']//*[@class='dropdown-toggle ng-binding btn btn-default']") public WebElement captiveDropdownFilter;
	@FindBy(xpath=".//*[@id='DemDetFilterByCaptiveFlag']//*[@class='dropdown-header']/input") public WebElement captiveDropdownFilterSearchField;
	@FindBy(xpath=".//*[@id='DemDetFilterByCaptiveFlag']//*[@class='ng-binding ng-scope']") public List <WebElement> selectCaptiveValue;
	@FindBy(xpath=".//*[@class='ui-grid-canvas']//*[@class='ng-scope']//*[@class='ng-scope']/img") public List <WebElement> captiveIconListDemandPagee;

	@FindBy(xpath=".//*[@class='list-unstyled angulartabs']/li") public List <WebElement> tabOnDemandPage;
	@FindBy(css="#MSResourceWithinIGGraph > svg > g > g > g.nv-barsWrap.nvd3-svg > g > g > g > g > rect:nth-child(1)") public List <WebElement> benchWithinIGBarGraphList;
	@FindBy(css="#MSResourceWithinIGGraph > svg > g > g > g.nv-barsWrap.nvd3-svg > g > g > g > g > text:nth-child(4)") public WebElement CountbenchWithinIGBarGraph;
	@FindBy(xpath=".//*[@class='supply-list']//*[@class='container-fluid']//*[@class='dropdown-toggle ng-binding btn btn-default']") public List <WebElement> filtersOnSupplyPageList;

	@FindBy(xpath="//*[@id='ms_resource_list_filterbyCaptiveflag']//*[@class='option']//*[@class='ng-binding ng-scope']") public List <WebElement> CaptiveFilterValuesListSupplyPage;
	@FindBy(xpath=".//*[@id='ms_resource_cell']//*[@class='handicon captiveposition ng-scope']") public List <WebElement> captiveIconListSupplyPage;
	@FindBy(xpath=".//*[@class='ng-scope']//*[@class='handicon captiveposition ng-scope']/img") public List <WebElement> captiveIndicatorSLLSupply;

	@FindBy(xpath=".//*[@class='ng-scope']//*[@class='identifier-icons']//*[@class='ng-binding']") public WebElement resNameOnSearchSLL;

	
	
    public WebDriver applyProjectFilter(WebDriver driver, String path, ExtentTest logger, int a ,int b) throws InterruptedException
    {
    	UtilMethods.clickOn(logger, projectDropdownFilter, "FILTER BY Project Dropdown");
    	UtilMethods.waitTillElementIsVisible(logger,driver,filterDropdownValues.get(0));
    	Thread.sleep(1000);
    	int project = ReadExcel.getIntegerData("MatchingSupply",a,b);
    	String projectName = Integer.toString(project);
    	UtilMethods.setText(logger ,projectDropdownFilterSearchField, projectName);// Enter Project Name
    	UtilMethods.clickOn(logger, selectProjectValue,"Project: "+project);
    	return driver;
    }
    public WebDriver applySkillFilter(WebDriver driver, String path, ExtentTest logger, int a ,int b) throws InterruptedException
    {
    	Thread.sleep(4000);
    	UtilMethods.clickOn(logger, skillDropdownFilter, "FILTER BY SKILL Dropdown");
    	Thread.sleep(4000);
    	//new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfAllElements(filterDropdownValues)); 
    	UtilMethods.waitTillElementIsVisible(logger,driver,filterDropdownValues.get(10));
    	Thread.sleep(2000);
    	String skill = ReadExcel.getData("MatchingSupply",a,b);
    	UtilMethods.setText(logger ,skillDropdownFilterSearchField, skill);// Enter Skill Name
    	UtilMethods.clickOn(logger, selectSkillValue,"Skill: "+skill);
    	Thread.sleep(2000);
		TakeScreenshot.captureScreenshots(driver, "FILTER BY SKILL Dropdown", path);
    	UtilMethods.clickOn(logger, skillDropdownFilter, "FILTER BY SKILL Dropdown");
    	return driver;
    }
    
    public WebDriver applyCaptiveFilter(WebDriver driver, String path, ExtentTest logger, String CaptiveValue) throws InterruptedException
    {
    	Thread.sleep(4000);
    	UtilMethods.clickOn(logger, captiveDropdownFilter, "FILTER BY CAPTIVE FLAG Dropdown");
    	Thread.sleep(2000);
    	UtilMethods.waitForListLoading(driver, logger,filterDropdownValues, "Captive Filter Dropdown");
    	if(CaptiveValue.equalsIgnoreCase("Y"))
    		UtilMethods.clickOn(logger, selectCaptiveValue.get(1),"Captive: "+CaptiveValue);
    	else
    		UtilMethods.clickOn(logger, selectCaptiveValue.get(0),"Captive: "+CaptiveValue);
    	Thread.sleep(2000);
		TakeScreenshot.captureScreenshots(driver, "FILTER BY CAPTIVE FLAG Dropdown", path);
    	UtilMethods.clickOn(logger, captiveDropdownFilter, "FILTER BY CAPTIVE FLAG Dropdown Filter");
    	return driver;
    }
    
    public WebDriver applyLevelFilter(WebDriver driver, String path, ExtentTest logger, int a ,int b, int listCount) throws InterruptedException
    {
    	Thread.sleep(3000);
    	UtilMethods.clickOn(logger, levelDropdownFilter, "FILTER BY LEVEL Dropdown");
    //	new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfAllElements(filterDropdownValues));  
    	UtilMethods.waitTillElementIsVisible(logger,driver,filterDropdownValues.get(2));
    	Thread.sleep(2000);
    	UtilMethods.clickOn(logger, selectLevelInValue.get(listCount),"LEVEL: "+selectLevelInValue.get(listCount).getText() );// Select Level 12
    	Thread.sleep(2000);
		
    	return driver;
    }
    
    public WebDriver applyMoreLevels(WebDriver driver, String path, ExtentTest logger, int a ,int b, int listCount) throws InterruptedException
    {
    	Thread.sleep(2000);
    	UtilMethods.clickOn(logger, selectLevelInValue.get(listCount),"LEVEL: "+selectLevelInValue.get(listCount).getText() );// Select Level 12
    	Thread.sleep(2000);
    	return driver;
    }
    public WebDriver applyButtonDemandPage(WebDriver driver, String path, ExtentTest logger) throws InterruptedException
    {
    	String beforeContent = byChannelContent.getText();
    	UtilMethods.waitTillElementIsVisible(logger,driver,applyButtonDemandPage);
    	UtilMethods.clickOn(logger, applyButtonDemandPage, "Apply Button On Demand Page");
    	
    	for(int i=0;i<=60;i++)
    	{
    		String AfterContent = byChannelContent.getText();
    		if(!beforeContent.equals(AfterContent))
    		{
    			break;
    		}
    	}
		System.out.println("Filter Search Successfully");
    	return driver;
    }
    
    
    public WebDriver clickPendingEvaluationTab(WebDriver driver, String path, ExtentTest logger) throws InterruptedException
    {
    	UtilMethods.clickOn(logger, pendingEvaluationTabDemandPage, "Pending Evaluation Tab On Demand Page");
    	UtilMethods.waitTillElementIsVisible(logger,driver,firstRRDonDemandPage);
    	return driver;
    }
    
    public WebDriver navigateToJobDescriptionTab(WebDriver driver, String path, ExtentTest logger) throws InterruptedException
    {
    	UtilMethods.clickOn(logger, firstRRDonDemandPage, "First RRD on Demand Page");
    	UtilMethods.waitTillElementIsVisible(logger,driver,jobDescriptionTab);
    	clickJobDescriptionTab( driver, path, logger);
    	return driver;
    }
    
	public WebDriver enterRRDNumber(WebDriver driver, String path,String rrdNumber, ExtentTest logger)
	{
    	UtilMethods.waitTillElementIsVisible(logger,driver,ElementFactory.mainSearchIconClick);
		UtilMethods.clickOn(logger,ElementFactory.mainSearchIconClick,"MainSearchClick");
		UtilMethods.setText(logger ,ElementFactory.mainSearch, rrdNumber);
		TakeScreenshot.captureScreenshots(driver, "enterRRDNumber",path);
		UtilMethods.clickOn(logger,ElementFactory.rrdMainSearch,"Select RRD Main Search");
		
		return driver;
	}
    public WebDriver clickJobDescriptionTab(WebDriver driver, String path, ExtentTest logger) throws InterruptedException
    {
    	UtilMethods.clickOn(logger, jobDescriptionTab, "Job Description Tab On RRD Supply Page");
    	Thread.sleep(1000);
    	return driver;
    }
    public WebDriver applyButtonSupplyPage(WebDriver driver, String path, ExtentTest logger) throws InterruptedException
    {
    	String beforeContent = byChannelContentSupplyPage.getText();
    	UtilMethods.clickOn(logger,filterApplyButtonOnSupplyPage , "Apply Button On Supply Page");
    	
    	for(int i=0;i<=60;i++)
    	{
    		String AfterContent = byChannelContentSupplyPage.getText();
    		if(!beforeContent.equals(AfterContent))
    		{
    			break;
    		}
    	}
		System.out.println("Filter Search Successfully");
    	return driver;
    }
    
	@FindBy(xpath=".//*[@id='DemDetActions']//*[@class='form-group apply-filter']/button[2]") public  WebElement clearButtonDemandPage;
    
    public boolean clickRRD(WebDriver driver, String path, ExtentTest logger, List<WebElement> wb) throws InterruptedException
    {
    	int j = 1;
    	int i;
		 for ( i=0; i< rrdNumberOnDemandPage.size(); i++)
		 {
			 UtilMethods.waitTillElementIsVisible(logger,driver,rrdNumberOnDemandPage.get(i));
			 
			 if(i==30)
			 {
				 UtilMethods.waitTillElementIsVisible(logger,driver,clearButtonDemandPage);
				 UtilMethods.clickOn(logger,clearButtonDemandPage,"Clear Button");
				 Thread.sleep(10000);
			 }
			 
			 int k=i+1;
			 String srNumber = ".//*[@class='ui-grid-canvas']//*[@class='ui-grid-row ng-scope']["+k+"]//*[@class='ng-scope']//*[@class='ng-binding ng-scope']";

			 if((driver.findElements(By.xpath(srNumber)).size())==0)
			 {
			
			 rrdNumber= rrdNumberOnDemandPage.get(i).getText();
			 UtilMethods.clickOn(logger, rrdNumberOnDemandPage.get(i),"RRD: "+rrdNumber);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			 Thread.sleep(4000);
			 String supplyStatus = inactiveRRD.getText();
			 int a = 0;
			 if(supplyStatus.equalsIgnoreCase("Resource Allocated"))
			 {
				 a=1;
				logger.log(LogStatus.INFO, "Inactive RRD: "+rrdNumber);
				System.out.println( "Inactive RRD: "+rrdNumber);
			 }
			 
			 if (a == 0) 
			 {
			 
				 if(wb.size()!=0 && updateSRButtonOnRRDPage.size()==0 )
				 {
					j=0;
					break;
				 }
				 else
				 {
					 UtilMethods.clickOn(logger,backButtonOnDemandPage,"Back Button On Demand Page");
					 Thread.sleep(2000);
				 }
	    	
				}
			 else {
					UtilMethods.clickOn(logger, backButtonOnDemandPage, "Back Button On Demand Page");
					Thread.sleep(4000);
				} 
		 }
    }
		if(j==0)
		{
			System.out.println("RRD Found: "+rrdNumber);
			return true;
		}
		else
		{
			System.out.println("RRD Not Found");
			return false;
		}

    }
    
    
    public WebDriver checkSupplyDashboard(WebDriver driver, String path, ExtentTest logger,List<WebElement> wb ) throws InterruptedException
    {  
    	boolean status =clickRRD(driver,path,logger, wb);
    	softly.assertTrue(status);
    	if(status=true)
	    	{
				TakeScreenshot.captureScreenshots(driver, "supplyDashboardShown", path);
				logger.log(LogStatus.PASS, "Supply Dashboard Shown to User");
	    	}
    	else 
	    	{
				System.out.println("Supply Dashboard not Shown to User");
				TS=TakeScreenshot.captureScreenshots(driver, "supplyDashboardNotShown", path);
				logger.log(LogStatus.FAIL, "Supply Dashboard not Shown to User"+logger.addScreenCapture(TS));
	    	}
    	
    	return driver;
    
    }
    public WebDriver checkDemandDetailsCentralTeamUser(WebDriver driver, String path, ExtentTest logger, String user) throws InterruptedException
    {  

    	// To check Demand RRD Number and Assigned Role details on top
		 UtilMethods.waitTillElementIsVisible(logger,driver,rrdNoDetails);
    	String rrdnumberinfo = rrdNoDetails.getText();
    	if(rrdnumberinfo!=null)
	    	{
    			System.out.println("RRD Number and Assigned Role shown as: "+rrdnumberinfo);
				TakeScreenshot.captureScreenshots(driver, "rrdNumberInfoShown", path);
				logger.log(LogStatus.PASS, "RRD Number and Assigned Role shown as: "+rrdnumberinfo);
				softly.assertTrue(true);
	    	}
    	else 
	    	{
				System.out.println("RRD Number and Assigned Role not shown to user");
				TS=TakeScreenshot.captureScreenshots(driver, "rrdNumberInfoNotShown", path);
				logger.log(LogStatus.FAIL, "RRD Number and Assigned Role not shown to user"+logger.addScreenCapture(TS));
				softly.assertTrue(false);
	    	}
    	
    	//To check Demand Basic Details
       	String rrdBasicinfo = rrdBasicDetails.getText();
    	if(rrdBasicinfo!=null)
	    	{
    			System.out.println("RRD Basic Details shown as: "+rrdBasicinfo);
				TakeScreenshot.captureScreenshots(driver, "rrdBasicInfoShown", path);
				logger.log(LogStatus.PASS, "RRD Basic Details shown as: "+rrdBasicinfo);
				softly.assertTrue(true);
	    	}
    	else 
	    	{
				System.out.println("RRD Basic Details not shown to user");
				TS=TakeScreenshot.captureScreenshots(driver, "rrdBasicInfoNotShown", path);
				logger.log(LogStatus.FAIL, "RRD Basic Details not shown to user"+logger.addScreenCapture(TS));
				softly.assertTrue(false);
	    	}
    	
    	 //To check Recommend For External Hire option available or not
    	
    	if(user.equals("DU"))
    		checkExternalHireOptionForDUuser(driver, path, logger);
    	
    	if(user.equals("Central Team"))
    		checkExternalHireOptionForCentralTeam(driver, path, logger);
    	
		 //To check Demand Cancellation option should not available for TFS user
		 if(demandCancelButton.size()!=0)
		 	{
				System.out.println("Demand Cancellation Button Shown to user");
				TS=TakeScreenshot.captureScreenshots(driver, "demandCancelButton", path);
				logger.log(LogStatus.FAIL, "Demand Cancellation Button Shown to user"+logger.addScreenCapture(TS));
				softly.assertTrue(false);
		 	}
	    else 
	    	{
				System.out.println("Demand Cancellation Button Not Shown to user");
				TakeScreenshot.captureScreenshots(driver, "demandCancelButton", path);
				logger.log(LogStatus.PASS, "Demand Cancellation Button Not Shown to user");
				softly.assertTrue(true);
	    	}
    	
    	return driver;
    
    }
    
    public WebDriver checkExternalHireOptionForCentralTeam(WebDriver driver, String path, ExtentTest logger)
    {
		 if(recommendForExternalHireButton.size()!=0)
		 	{
				System.out.println("'RECOMMEND FOR EXTERNAL HIRE' Button Shown to user");
				TakeScreenshot.captureScreenshots(driver, "rrdRecommendForExternalHireButtonShown", path);
				logger.log(LogStatus.PASS, "'RECOMMEND FOR EXTERNAL HIRE' Button Shown to user");
				softly.assertTrue(true);
		 	}
	    else 
	    	{
				System.out.println("'RECOMMEND FOR EXTERNAL HIRE' Button NOT Shown to user");
				TS=TakeScreenshot.captureScreenshots(driver, "rrdRecommendForExternalHireButtonNotShown", path);
				logger.log(LogStatus.FAIL, "'RECOMMEND FOR EXTERNAL HIRE' Button NOT Shown to user"+logger.addScreenCapture(TS));
				softly.assertTrue(false);
	    	}
		 return driver;
    }
    
    public WebDriver checkExternalHireOptionForDUuser(WebDriver driver, String path, ExtentTest logger)
    {
    	String status = recommendForExternalHireButton.get(0).getAttribute("disabled");
		 if(status.equals("true"))
		 	{
	    		TakeScreenshot.captureScreenshots(driver, "rrdRecommendForExternalHireButtonNotShown", path);
				System.out.println("'RECOMMEND FOR EXTERNAL HIRE' Button NOT Shown to user");
				logger.log(LogStatus.PASS, "'RECOMMEND FOR EXTERNAL HIRE' Button NOT Shown to user");
				softly.assertTrue(true);
		 	}
	    else 
	    	{
				System.out.println("'RECOMMEND FOR EXTERNAL HIRE' Button Shown to user");
				TS= TakeScreenshot.captureScreenshots(driver, "rrdRecommendForExternalHireButtonShown", path);
				logger.log(LogStatus.FAIL, "'RECOMMEND FOR EXTERNAL HIRE' Button Shown to user"+logger.addScreenCapture(TS));
				softly.assertTrue(false);
	    	}
		 return driver;
    }
    
	@FindBy(xpath=".//*[@id='supplyTab']") public WebElement inactiveRRD;
    public WebDriver checkGraph(WebDriver driver, String path, ExtentTest logger,  List <WebElement> wb, int barNumber) throws InterruptedException
    {
    	int j = 1;
    	int i;
		 for ( i=0; i< rrdNumberOnDemandPage.size(); i++)
		 {
			 if(i==20)
			 {
				 UtilMethods.waitTillElementIsVisible(logger,driver,clearButtonDemandPage);
				 UtilMethods.clickOn(logger,clearButtonDemandPage,"Clear Button");
				 Thread.sleep(10000);
			 }
			 UtilMethods.waitTillElementIsVisible(logger,driver,rrdNumberOnDemandPage.get(i));
			 rrdNumber= rrdNumberOnDemandPage.get(i).getText();
			 UtilMethods.clickOn(logger, rrdNumberOnDemandPage.get(i),"RRD: "+rrdNumber);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			 Thread.sleep(4000);
			 String supplyStatus = inactiveRRD.getText();
			 int a = 0;
			 if(supplyStatus.equalsIgnoreCase("Resource Allocated"))
			 {
				 a=1;
				logger.log(LogStatus.INFO, "Inactive RRD: "+rrdNumber);
				System.out.println( "Inactive RRD: "+rrdNumber);
			 }
			 
			 if (a == 0) 
			 {
				if (noDataAvailable.size() == 0 ) 
				{

					String count = wb.get(barNumber).getText();
					int countnew = Integer.valueOf(count);
					System.out.println("Bench count is " + countnew);
					if (countnew > 10) {
						j = 0;
						break;
					} else {
						UtilMethods.clickOn(logger, backButtonOnDemandPage, "Back Button On Demand Page");
						Thread.sleep(4000);
					}
				} else {
					UtilMethods.clickOn(logger, backButtonOnDemandPage, "Back Button On Demand Page");
					Thread.sleep(4000);
				} 
			}
			 else {
					UtilMethods.clickOn(logger, backButtonOnDemandPage, "Back Button On Demand Page");
					Thread.sleep(4000);
				} 
    	
		 }
		if(j==0)
		{
			logger.log(LogStatus.PASS, "Graph Shown properly");
			softly.assertTrue(true);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Graph not Shown properly");
			softly.assertTrue(false);
		}
		
		
		return driver;
    }
    public WebDriver checkTaggedSupply(WebDriver driver, String path, ExtentTest logger, String expStatus) throws InterruptedException
    {
    	int l = 0;
    	int i;
		 for ( i=0; i< rrdNumberOnDemandPage.size(); i++)
		 {
			 if(i==20)
			 {
				 UtilMethods.waitTillElementIsVisible(logger,driver,clearButtonDemandPage);
				 UtilMethods.clickOn(logger,clearButtonDemandPage,"Clear Button");
				 Thread.sleep(10000);
			 }
			 UtilMethods.waitTillElementIsVisible(logger,driver,rrdNumberOnDemandPage.get(i));
			 Thread.sleep(2000);
			 rrdNumber= rrdNumberOnDemandPage.get(i).getText();
			 UtilMethods.clickOn(logger, rrdNumberOnDemandPage.get(i),"RRD: "+rrdNumber);
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 Thread.sleep(4000);
			 String supplyStatus = inactiveRRD.getText();
			 int a = 0;
			 if(supplyStatus.equalsIgnoreCase("Resource Allocated"))
			 {
				 a=1;
				logger.log(LogStatus.INFO, "Inactive RRD: "+rrdNumber);
				System.out.println( "Inactive RRD: "+rrdNumber);
			 }
			 
			 if (a == 0) 
			 {
				 
			 mf.taggedTab(driver,path, logger);
			 WebDriverWait wait = new WebDriverWait(driver, 60);
	   		 
			 wait.until(ExpectedConditions.or(
		   		         ExpectedConditions.visibilityOf(firstresActionButtonOnTaggedTab),
		   		         ExpectedConditions.visibilityOf(noSupplyTaggedElement)));

				 if(noSupplyTagged.size()==0)
				 {
					 for(int k=0;k< actionButtonTaggedTab.size();k++ )
						 {
						 	String status = resStatusOnTaggedTab.get(k).getText();
							 if(status.equals(expStatus)) 
								{
								 	j=0;
								 	rowNumber=k;
								 	break;
								}
							 else
								{
								 	l=l+1;
									continue;
								}
						 }
					 if(l==actionButtonTaggedTab.size())
					 {
						 	UtilMethods.clickOn(logger,backButtonOnDemandPage,"Back Button On Demand Page");
						 	Thread.sleep(2000);
					 }
				 }
				 else
				 	{
					 	UtilMethods.clickOn(logger,backButtonOnDemandPage,"Back Button On Demand Page");
					 	Thread.sleep(2000);
					}
				}
			 else {
					UtilMethods.clickOn(logger, backButtonOnDemandPage, "Back Button On Demand Page");
					Thread.sleep(4000);
				} 
		 }
		if(j==0)
		{
			logger.log(LogStatus.PASS, "Supply Shown Under Tagged Tab with Atleast One Resource having Status 'Evaluation pending'");
			softly.assertTrue(true);
		}
		else
		{
			logger.log(LogStatus.FAIL, "There is No Supply with Status 'Evaluation pending'");
			softly.assertTrue(false);
		}
		
		return driver;
    }
    
    public WebDriver checkTaggedSupplyForElement(WebDriver driver, String path, ExtentTest logger,  List <WebElement> wb) throws InterruptedException
    {
    	int l = 0;
    	int i;
    	int count=0;
		 for ( i=0; i< rrdNumberOnDemandPage.size(); i++)
		 {
			 if(i==20)
			 {
				 UtilMethods.waitTillElementIsVisible(logger,driver,clearButtonDemandPage);
				 UtilMethods.clickOn(logger,clearButtonDemandPage,"Clear Button");
				 Thread.sleep(10000);
			 }
			 UtilMethods.waitTillElementIsVisible(logger,driver,rrdNumberOnDemandPage.get(i));
			 Thread.sleep(2000);
			 rrdNumber= rrdNumberOnDemandPage.get(i).getText();
			 UtilMethods.clickOn(logger, rrdNumberOnDemandPage.get(i),"RRD: "+rrdNumber);
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 String supplyStatus = inactiveRRD.getText();
			 int a = 0;
			 if(supplyStatus.equalsIgnoreCase("Resource Allocated"))
			 {
				 a=1;
				logger.log(LogStatus.INFO, "Inactive RRD: "+rrdNumber);
				System.out.println( "Inactive RRD: "+rrdNumber);
			 }
			 
			 if (a == 0) 
			 {
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 mf.taggedTab(driver,path, logger);
				 WebDriverWait wait = new WebDriverWait(driver, 60);
		   		 
				 wait.until(ExpectedConditions.or(
			   		         ExpectedConditions.visibilityOf(firstresActionButtonOnTaggedTab),
			   		         ExpectedConditions.visibilityOf(noSupplyTaggedElement)));
				 Thread.sleep(4000);
			 if(noSupplyTagged.size()==0)
			 {
				 for(int k=0;k< actionButtonTaggedTab.size();k++ )
				 {
				 	count=k+1;
				 	String status = resStatusOnTaggedTab.get(k).getText();
					 if(status.equalsIgnoreCase("Evaluation pending")) 
						{
				
						 		TakeScreenshot.captureScreenshots(driver, "EvaluationpendingResourceFound", path);
							    j=0;
							    break;
								 
						}
					 else
						{
						 		l=l+1;
						 		continue;
						}
				 }
				 if(j!=0) 
				 	{
						 if(l==actionButtonTaggedTab.size()||count==actionButtonTaggedTab.size())
							 {
								 	UtilMethods.clickOn(logger,backButtonOnDemandPage,"Back Button On Demand Page");
								 	Thread.sleep(2000);
							 }
				 	}
			 }
			 else
			 	{
				 	UtilMethods.clickOn(logger,backButtonOnDemandPage,"Back Button On Demand Page");
				 	Thread.sleep(2000);
				}
			 }
			 
			 else
			 {
					UtilMethods.clickOn(logger, backButtonOnDemandPage, "Back Button On Demand Page");
					Thread.sleep(4000);
			 }
		 }
		if(j==0)
		{
			logger.log(LogStatus.INFO, "Supply Shown Under Tagged Tab with Atleast One Resource having Status 'Evaluation pending'");
			softly.assertTrue(true);
		}
		else
		{
			logger.log(LogStatus.INFO, "There is No Supply with Status 'Evaluation pending'");
			softly.assertTrue(false);
		}
		
		return driver;
    }
    
    
    public WebDriver clickBenchWithinIGBarGraph(WebDriver driver, ExtentTest logger) throws InterruptedException
    {
    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    	UtilMethods.clickOn(logger,benchWithinIGBarGraph,"Bench Within IG Bar Graph");
    	Thread.sleep(2000);
    	UtilMethods.waitTillElementIsVisible(logger,driver,actionButtonSupplyPage.get(0));
    	return driver;
    	
    }
    public boolean clickBenchOtherIGBarGraph(WebDriver driver, ExtentTest logger) throws InterruptedException
    {
    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
     	String count = countBenchOtherIGBarGraph.get(0).getText();
   	 	int countnew = Integer.valueOf(count);
		System.out.println("benchOtherIGBarGraph count is "+countnew);
		if(countnew > 1) 
		{
		   	UtilMethods.clickOn(logger,benchOtherIGBarGraph,"Bench Other IG Bar Graph");
	    	Thread.sleep(2000);
	    	UtilMethods.waitTillElementIsVisible(logger,driver,actionButtonSupplyPage.get(0));
	    	return true;
		}
		else
		{
	    	System.out.println("BenchwithinIG count is "+countnew+ ", Hence skipping");
	    	logger.log(LogStatus.INFO,  "BenchwithinIG count is "+countnew+ ", Hence skipping");
	    	return false;

		}

    	
    }
    
    public boolean clickROVwithinIGBarGraph(WebDriver driver, ExtentTest logger) throws InterruptedException
    {
    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    	String count = countWithinIGBarGraph.get(1).getText();
   	 	int countnew = Integer.valueOf(count);
		System.out.println("ROVwithinIG count is "+countnew);
		if(countnew > 1) 
		{
	    	UtilMethods.clickOn(logger,rovWithinIGBarGraph,"ROV Within IG Bar Graph");
	    	UtilMethods.waitTillElementIsVisible(logger,driver,actionButtonSupplyPage.get(0));
	    	return true;
		}
		else
		{
	    	System.out.println("ROVwithinIG count is "+countnew+ ", Hence skipping");
	    	logger.log(LogStatus.INFO,  "ROVwithinIG count is "+countnew+ ", Hence skipping");
	    	return false;

		}
    	
    }
    public WebDriver setFilter(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
    	UtilMethods.clickOn(logger,filterBySkillField,"Filter By Primary Skill Field");
    	UtilMethods.waitTillElementIsVisible(logger,driver,filterBySkillDropdownValues.get(0));
    	skillSelectedOnSupplyPage = filterBySkillDropdownValues.get(0).getText();
    	UtilMethods.clickOn(logger,filterBySkillDropdownValues.get(0),"Primary Skill: "+skillSelectedOnSupplyPage);
		//new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfAllElements(filterBySkillDropdownValues));
		Thread.sleep(2000);
    	System.out.println(skillSelectedOnSupplyPage);
    	UtilMethods.waitTillElementIsVisible(logger,driver,filterBySkillField);
    	UtilMethods.clickOn(logger,filterBySkillField,"Filter By Primary Skill Field");
    	applyButtonSupplyPage( driver, path, logger);
    	return driver;
    }
    
    public WebDriver checkSetFilter(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
    	int j=0;
    	int i;
		for ( i=0; i< listofSkillSupplyPageGrid.size(); i++)
		 {
			String actualSkill=listofSkillSupplyPageGrid.get(i).getText();
			if(actualSkill.equals(skillSelectedOnSupplyPage))
			{
				j=j+1;
			}
			else
			{
		    	  int b=i+1;
		    	  logger.log(LogStatus.FAIL,  "Not Matched on "+b+" Skill Value"+" Expected-"+skillSelectedOnSupplyPage+" and Actual- "+actualSkill);
		    	  continue;
			}
			
		 }
		  if (j==listofSkillSupplyPageGrid.size())
		  {
				System.out.println("Matched "+j+"/"+listofSkillSupplyPageGrid.size()+" Dropdrown Values"+" For Skill Filter");
				logger.log(LogStatus.PASS, "Matched "+j+"/"+listofSkillSupplyPageGrid.size()+" Dropdrown Values"+" For Skill Filter");
				softly.assertTrue(true);
		  }
		  else
		  {
				System.out.println("Matched "+j+"/"+listofSkillSupplyPageGrid.size()+" Dropdrown Values"+" For Skill Filter");
				logger.log(LogStatus.FAIL, "Matched "+j+"/"+listofSkillSupplyPageGrid.size()+" Dropdrown Values"+" For Skill Filter");
				softly.assertTrue(false);
		  }
    	
	    	UtilMethods.clickOn(logger,filterClearButtonOnSupplyPage,"Clear Button");
	    	Thread.sleep(3000);
	    	
    	return driver;
    	
    }
    
    public WebDriver checkGridValues( WebDriver driver,  List <WebElement> dropdown, String exp[], ExtentTest logger, String method) 
    {

    	int i;
    	int j=0;
    		  for (i=0; i<dropdown.size(); i++)
    		  {
    		 	 String Expected = exp[i];
    		 	 String Actual = dropdown.get(i).getText();
    		 	   if (Actual.equals(Expected))
    		      {	
    		    	  j=j+1;
    		      }
    		      else
    		      {
    		    	  int b=i+1;
    		    	   logger.log(LogStatus.FAIL,  "Not Matched on "+b+" Dropdrown Value"+" Expected-"+exp[i]+" and Actual- "+dropdown.get(i).getText());
    		    	  continue;
    		      }
    		    }
    		  if (j==dropdown.size())
    		  {
    				System.out.println("Matched "+j+"/"+dropdown.size()+" Dropdrown Values"+" For "+method);
    				logger.log(LogStatus.PASS, "Matched "+j+"/"+dropdown.size()+" Dropdrown Values"+" For "+method);
    				softly.assertTrue(true);
    		  }
    		  else
    		  {
    				System.out.println("Matched "+j+"/"+dropdown.size()+" Dropdrown Values"+" For "+method);
    				logger.log(LogStatus.FAIL, "Matched "+j+"/"+dropdown.size()+" Dropdrown Values"+" For "+method);
    				softly.assertTrue(false);
    		  }
    		  return driver;
    }
    
    public WebDriver checkChatBox(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
    
    	if(chatBoxForResource.size()!=0)
    	{
			System.out.println("Chat box displayed on supply page");
			TS=TakeScreenshot.captureScreenshots(driver, "chatBoxDisplayed", path);
			logger.log(LogStatus.FAIL, "Chat box displayed on supply page"+logger.addScreenCapture(TS));
			softly.assertTrue(false);
    	}
    	else
    	{
    		System.out.println("Chat box Not displayed on supply page");
			logger.log(LogStatus.PASS, "Chat box Not displayed on supply page" );
			softly.assertTrue(true);
    	}
    	

		return driver;
    }
    
    public WebDriver checkActionsForSupplyForCentralTeam(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
    	int j=0;
    	for(int i=0; i<actionButtonSupplyPage.size(); i++)
    	{
    		
	    	UtilMethods.clickOn(logger,actionButtonSupplyPage.get(i),"Action Button");
	    	Thread.sleep(3000);
	    	if((softLockButtonSupplyAction.size()!=0) && (tagSupplyButtonSupplyAction.size()!=0) && (hardLockSupplyAction.size()!=0) && (shadowHardLockButtonSupplyAction.size()!=0))
	    	{
	    		System.out.println("All the actions shown on supply properly");
	    		TS = TakeScreenshot.captureScreenshots(driver,"supplyAction",path);
				logger.log(LogStatus.PASS, "All the actions shown on supply properly" );
				UtilMethods.clickOn(logger,actionButtonSupplyPage.get(i),"Action Button");
				softly.assertTrue(true);
				break;
	    	}	
	    	else
	    	{
	    		j=i+1;
	    		UtilMethods.clickOn(logger,actionButtonSupplyPage.get(i),"Action Button");
	    	}
    		
    	}
    	
    	if(j==actionButtonSupplyPage.size())
    	{
			 TS = TakeScreenshot.captureScreenshots(driver,"noSupplyMatched",path);
		     logger.log(LogStatus.FAIL, "Supply Dont have below options in action button 1.TAG SUPPLY 2.SOFT LOCK 3.HARD LOCK 4.SHADOW HARD LOCK"+logger.addScreenCapture(TS));
			 softly.assertTrue(false);
    	}
		return driver;
    }
    
    public WebDriver checkActionsForSupplyForDUTeam(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
    	int j=0;
    	for(int i=0; i<actionButtonSupplyPage.size(); i++)
    	{
    		
	    	UtilMethods.clickOn(logger,actionButtonSupplyPage.get(i),"Action Button");
	    	Thread.sleep(3000);
	    	if((softLockButtonSupplyAction.size()!=0) && (tagSupplyButtonSupplyAction.size()!=0) && (hardLockSupplyAction.size()!=0))
	    	{
	    		System.out.println("All the actions shown on supply properly");
	    		TS = TakeScreenshot.captureScreenshots(driver,"supplyAction",path);
				logger.log(LogStatus.PASS, "All the actions shown on supply properly" );
				UtilMethods.clickOn(logger,actionButtonSupplyPage.get(i),"Action Button");
				softly.assertTrue(true);
				break;
	    	}	
	    	else
	    	{
	    		j=i+1;
	    		UtilMethods.clickOn(logger,actionButtonSupplyPage.get(i),"Action Button");
	    	}
    		
    	}
    	
    	if(j==actionButtonSupplyPage.size())
    	{
			 TS = TakeScreenshot.captureScreenshots(driver,"noSupplyMatched",path);
		     logger.log(LogStatus.FAIL, "Supply Dont have below options in action button 1.TAG SUPPLY 2.SOFT LOCK 3.HARD LOCK"+logger.addScreenCapture(TS));
			 softly.assertTrue(false);
    	}
		return driver;
    }
    public WebDriver checkActionsBenchOtherIGSupplyForCentralTeam(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
    	
    	int j=0;
    	for(int i=0; i<actionButtonSupplyPage.size(); i++)
    	{
    		
	    	UtilMethods.clickOn(logger,actionButtonSupplyPage.get(i),"Action Button");
	    	Thread.sleep(1000);
	    	if((softLockButtonSupplyAction.size()!=0) && (tagSupplyButtonSupplyAction.size()!=0) && (hardLockSupplyAction.size()!=0) && (shadowHardLockButtonSupplyAction.size()!=0))
	    	{
	    		System.out.println("All the actions shown on supply properly");
	    		TS = TakeScreenshot.captureScreenshots(driver,"supplyAction",path);
				logger.log(LogStatus.PASS, "All the actions shown on supply properly" );
				UtilMethods.clickOn(logger,actionButtonSupplyPage.get(i),"Action Button");
				softly.assertTrue(true);
				break;
	    	}	
	    	else
	    	{
	    		j=i+1;
	    		UtilMethods.clickOn(logger,actionButtonSupplyPage.get(i),"Action Button");
	    	}
    		
    	}
    	
    	if(j==actionButtonSupplyPage.size())
    	{
			 TS = TakeScreenshot.captureScreenshots(driver,"noSupplyMatched",path);
		     logger.log(LogStatus.FAIL, "Supply Dont have below options in action button 1.TAG SUPPLY 2.SOFT LOCK 3.HARD LOCK 4.SHADOW HARD LOCK"+logger.addScreenCapture(TS));
			 softly.assertTrue(false);
    	}
		return driver;
    }
    public WebDriver checkActionsROVWithinIGSupplyForCentralTeam(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
    	
    	int j=0;
    	for(int i=0; i<actionButtonSupplyPage.size(); i++)
    	{
	    	UtilMethods.clickOn(logger,actionButtonSupplyPage.get(i),"Action Button");
	    	Thread.sleep(1000);
	    	if((futureSoftLockButtonSupplyAction.size()!=0) && (tagSupplyButtonSupplyAction.size()!=0) && (futureHardLockSupplyAction.size()!=0) && (futureShadowHardLockButtonSupplyAction.size()!=0))
	    	{
	    		System.out.println("All the actions shown on supply properly");
	    		TS = TakeScreenshot.captureScreenshots(driver,"supplyAction",path);
				logger.log(LogStatus.PASS, "All the actions shown on supply properly" );
				UtilMethods.clickOn(logger,actionButtonSupplyPage.get(i),"Action Button");
				softly.assertTrue(true);
				break;
	    	}	
	    	else
	    	{
	    		j=i+1;
	    		UtilMethods.clickOn(logger,actionButtonSupplyPage.get(i),"Action Button");
	    	}
    		
    	}
    	
    	if(j==actionButtonSupplyPage.size())
    	{
			 TS = TakeScreenshot.captureScreenshots(driver,"noSupplyMatched",path);
		     logger.log(LogStatus.FAIL, "Supply Dont have below options in action button 1.TAG SUPPLY 2.FUTURE SOFT LOCK 3.FUTURE HARD LOCK 4.FUTURE SHADOW HARD LOCK"+logger.addScreenCapture(TS));
			 softly.assertTrue(false);
    	}
		return driver;
    }
    
    public WebDriver checkSortingAvailability(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
    	
    	if(sortingIconOnSupplyPage.size()!=0)
    	{
    		System.out.println("Sort Icons are available on Supply Page");
    		TakeScreenshot.captureScreenshots(driver,"sortIconAvailable",path);
			logger.log(LogStatus.PASS, "Sort Icons are available on Supply Page" );
			softly.assertTrue(true);
    	}
    	else
    	{
    		System.out.println("Sort Icons are Not available on Supply Page");
			TS = TakeScreenshot.captureScreenshots(driver,"sortIconNotAvailable",path);
		    logger.log(LogStatus.FAIL, "Sort Icons are Not available on Supply Page"+logger.addScreenCapture(TS));
			softly.assertTrue(false);
    	}
    	
    	return driver;
    }
    
    public WebDriver checkFiltersTaggedTab(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
    	boolean Status = UtilMethods.checkDropdownValues( driver, filterLabelsOnTaggedTab, expFilterValueOnTaggedTab,  logger, "Filters On Tagged Tab");
    	softly.assertTrue(Status);
    	return driver;
    }
    
    public WebDriver checkFiltersClickableTaggedTab(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
    	
    	try {
			for(int i=0; i<filterButtonOnTaggedTab.size(); i++)
			{
				UtilMethods.clickOn(logger,filterButtonOnTaggedTab.get(i),"Filter Button "+expFilterValueOnTaggedTab[i]);
				Thread.sleep(1000);
				UtilMethods.clickOn(logger,filterButtonOnTaggedTab.get(i),"Filter Button "+expFilterValueOnTaggedTab[i]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			TS = TakeScreenshot.captureScreenshots(driver,"sortIconNotAvailable",path);
		    logger.log(LogStatus.FAIL, e.getMessage()+logger.addScreenCapture(TS));
		    softly.assertTrue(false);
		}
    	return driver;
    }
    
    public WebDriver checkAttributesTaggedTab(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
    	boolean Status = UtilMethods.checkDropdownValues( driver, attributesOnTaggedTab, expAttributesOnTaggedTab,  logger, "Attributes On Tagged Tab");
    	softly.assertTrue(Status);
  
    	return driver;
    }	
    public WebDriver validateActionsTaggedTabForTFSUser(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {	
    	
    		Actions dragger = new Actions(driver);
    		dragger.moveToElement(actionButtonTaggedTab.get(rowNumber));
			UtilMethods.clickOn(logger,actionButtonTaggedTab.get(rowNumber),"Resource Action Button");
	    	Thread.sleep(1000);
	    	if((challengeButtonSupplyAction.size()!=0) || (softLockButtonSupplyAction.size()!=0) || (hardLockSupplyAction.size()!=0) || (notReachableButtonSupplyAction.size()!=0) || (rejectButtonSupplyAction.size()!=0) || (refuseButtonSupplyAction.size()!=0) || (shadowHardLockButtonSupplyAction.size()!=0))
	    	{
	    		dragger.moveToElement(actionFrameTaggedTab);
	    		System.out.println("All the actions shown on Tag supply properly");
	    		TS = TakeScreenshot.captureScreenshots(driver,"TagsupplyAction",path);
				logger.log(LogStatus.PASS, "All the actions shown on Tag supply properly" );
				softly.assertTrue(true);
	    	}	
	    	else
	    	{
				 TS = TakeScreenshot.captureScreenshots(driver,"TagsupplyActionFail",path);
			     logger.log(LogStatus.FAIL, "Tag Supply Dont have below options in action button 1.SOFT LOCK 2.HARD LOCK 3.SHADOW HARD LOCK 4.NOT REACHABLE 5.REJECT 6.REFUSE "+logger.addScreenCapture(TS));
				 softly.assertTrue(false);
	    	}
	    	
	    	UtilMethods.clickOn(logger,actionButtonTaggedTab.get(rowNumber),"Resource Action Button");
		return driver;

    }
    
    public WebDriver validateActionsTaggedTabForDUUser(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {	
    	
    		Actions dragger = new Actions(driver);
    		dragger.moveToElement(actionButtonTaggedTab.get(rowNumber));
			UtilMethods.clickOn(logger,actionButtonTaggedTab.get(rowNumber),"Resource Action Button");
	    	Thread.sleep(1000);
	    	if(((challengeButtonSupplyAction.size()!=0) || softLockButtonSupplyAction.size()!=0) || (hardLockSupplyAction.size()!=0) || (notReachableButtonSupplyAction.size()!=0) || (rejectButtonSupplyAction.size()!=0) || (refuseButtonSupplyAction.size()!=0) || (shadowHardLockButtonSupplyAction.size()!=0))
	    	{
	    		dragger.moveToElement(actionFrameTaggedTab);
	    		System.out.println("All the actions shown on Tag supply properly");
	    		TS = TakeScreenshot.captureScreenshots(driver,"TagsupplyAction",path);
				logger.log(LogStatus.PASS, "All the actions shown on Tag supply properly" );
				softly.assertTrue(true);
	    	}	
	    	else
	    	{
				 TS = TakeScreenshot.captureScreenshots(driver,"TagsupplyActionFail",path);
			     logger.log(LogStatus.FAIL, "Tag Supply Dont have below options in action button 1.SOFT LOCK 2.HARD LOCK 3.SHADOW HARD LOCK 4.NOT REACHABLE 5.REJECT 6.REFUSE "+logger.addScreenCapture(TS));
				 softly.assertTrue(false);
	    	}
	    	
	    	UtilMethods.clickOn(logger,actionButtonTaggedTab.get(rowNumber),"Resource Action Button");
		return driver;

    }
    public WebDriver validateOnJobDescriptionTab(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {	
    	boolean Status = UtilMethods.checkDropdownValues( driver, jobDescriptionContentTitleList, expjobDescriptionContentTitleList,  logger, "Title on Job Description Page");
    	softly.assertTrue(Status);

    	return driver;
    }
    public WebDriver checkLockStatus(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {	
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfAllElements(expandButtonOnLockPage));
    	UtilMethods.clickOn(logger,expandButtonOnLockPage.get(0),"Expand Button");
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfAllElements(expandedHeaderOptions));
		Thread.sleep(2000);
    	if(pendingApprovalText.isDisplayed())
    	{
    		System.out.println("There is an Pending Approval exist for this LR");
    		TakeScreenshot.captureScreenshots(driver,"pendingApprovalLR",path);
			logger.log(LogStatus.PASS, "There is an Pending Approval exist for this LR" );
			softly.assertTrue(true);
    	}
    	else
    	{
    		 System.out.println("There is No Pending Approval exist for this LR");
			 TS = TakeScreenshot.captureScreenshots(driver,"pendingApprovalLR",path);
		     logger.log(LogStatus.FAIL, "There is No Pending Approval exist for this LR"+logger.addScreenCapture(TS));
			 softly.assertTrue(false);
    	}
    	
    	return driver;
    }
    
    public WebDriver checkBillandCostCode(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {	
        String resinfo = resInfo.getText();
        String billCode = "Bill Code";
        String costCode = "Cost Code";
        
        // To check Bill code is present in resource information 
        if (resinfo.toLowerCase().contains(billCode.toLowerCase())) 
        {
    		System.out.println("Bill Code displayed properly in Resource screen");
    		TakeScreenshot.captureScreenshots(driver,"checkBillCode",path);
			logger.log(LogStatus.PASS, "Bill Code displayed properly in Resource screen" );
			softly.assertTrue(true);

        } else {

   		 	System.out.println("Bill Code NOT displayed in Resource screen");
			TS = TakeScreenshot.captureScreenshots(driver,"checkBillCode",path);
		    logger.log(LogStatus.FAIL, "Bill Code NOT displayed in Resource screen, Actual resource Information: "+resinfo+logger.addScreenCapture(TS));
			softly.assertTrue(false);
        }
        
        // To check Cost code is present in resource information 
        if (resinfo.toLowerCase().contains(costCode.toLowerCase())) 
        {
    		System.out.println("Cost Code displayed properly in Resource screen");
    		TakeScreenshot.captureScreenshots(driver,"checkCostCode",path);
			logger.log(LogStatus.PASS, "Cost Code displayed properly in Resource screen" );
			softly.assertTrue(true);

        } else {

   		 	System.out.println("Cost Code NOT displayed in Resource screen");
			TS = TakeScreenshot.captureScreenshots(driver,"checkCostCode",path);
		    logger.log(LogStatus.FAIL, "Cost Code NOT displayed in Resource screen, Actual resource Information: "+resinfo+logger.addScreenCapture(TS));
			softly.assertTrue(false);
        }
    	
    	return driver;
    }
    
    public WebDriver getResource(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {	
    	UtilMethods.clickOn(logger,resNameListRRDPage.get(0),"First Resource on Supply Page");
    	UtilMethods.waitTillElementIsVisible(logger,driver,resInfo);
	
    	return driver;
    }
    
    public boolean checkRRD(WebDriver driver, String path, ExtentTest logger, List<WebElement> wb) throws InterruptedException
    {
    	int j = 1;
    	int i;
    	Thread.sleep(4000);
		System.out.println("Total RRD: "+rrdNumberOnDemandPage.size());
		 for ( i=0; i< rrdNumberOnDemandPage.size(); i++)
		 {
			 if(i==20)
			 {
				 UtilMethods.waitTillElementIsVisible(logger,driver,clearButtonDemandPage);
				 UtilMethods.clickOn(logger,clearButtonDemandPage,"Clear Button");
				 Thread.sleep(10000);
			 }
			 UtilMethods.waitTillElementIsVisible(logger,driver,rrdNumberOnDemandPage.get(i));
			 rrdNumber= rrdNumberOnDemandPage.get(i).getText();
			 int count=i+1;
			 UtilMethods.clickOn(logger, rrdNumberOnDemandPage.get(i),"RRD "+count+" : "+rrdNumber);
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 if(wb.size()!=0)
			 {
				j=0;
				break;
			 }
			 else
			 {
				 UtilMethods.clickOn(logger,backButtonOnDemandPage,"Back Button On Demand Page");
				 Thread.sleep(1000);
			 }
    	
		 }
		if(j==0)
		{
			TakeScreenshot.captureScreenshots(driver,"rrdFound",path);
			System.out.println("RRD Found: "+rrdNumber);
			return true;
		}
		else
		{
			System.out.println("Required RRD Not Found. Hence toolTip validation can,t be cheched.");
			TS=TakeScreenshot.captureScreenshots(driver,"rrdFound",path);
		    logger.log(LogStatus.INFO, "Required RRD Not Found. Hence toolTip validation can,t be cheched.s"+logger.addScreenCapture(TS));
			return false;
		}

    }
    
    
    public boolean checkRRDTwoList(WebDriver driver, String path, ExtentTest logger, List<WebElement> wb1, List<WebElement> wb2) throws InterruptedException
    {
    	int j = 1;
    	int i;
		 for ( i=0; i< rrdNumberOnDemandPage.size(); i++)
		 {
			 if(i==20)
			 {
				 UtilMethods.waitTillElementIsVisible(logger,driver,clearButtonDemandPage);
				 UtilMethods.clickOn(logger,clearButtonDemandPage,"Clear Button");
				 Thread.sleep(10000);
			 }
			 UtilMethods.waitTillElementIsVisible(logger,driver,rrdNumberOnDemandPage.get(i));
			 rrdNumber= rrdNumberOnDemandPage.get(i).getText();
			 int count=i+1;
			 UtilMethods.clickOn(logger, rrdNumberOnDemandPage.get(i),"RRD "+count+" : "+rrdNumber);
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 if(wb1.size()!=0 && wb2.size()!=0)
			 {
				j=0;
				break;
			 }
			 else
			 {
				 UtilMethods.clickOn(logger,backButtonOnDemandPage,"Back Button On Demand Page");
				 Thread.sleep(1000);
			 }
    	
		 }
		if(j==0)
		{
			TakeScreenshot.captureScreenshots(driver,"rrdFound",path);
			System.out.println("RRD Found: "+rrdNumber);
			return true;
		}
		else
		{
			System.out.println("RRD Not Found");
		    logger.log(LogStatus.FAIL, "RRD Not Found"+logger.addScreenCapture(TS));
			return false;
		}

    }
    public WebDriver validateToolTipSupplyPage(WebDriver driver,String path, ExtentTest logger) throws InterruptedException, AWTException
    {	

    	status =checkRRD( driver, path,  logger, lockSymbolOnResSupplyPage);
    	//softly.assertTrue(status);
    	
    	if (status) {
			Actions ToolTip1 = new Actions(driver);
			ToolTip1.moveToElement(lockSymbolOnResSupplyPage.get(0));
			ToolTip1.clickAndHold(lockSymbolOnResSupplyPage.get(0)).perform();
			TakeScreenshot.captureScreenshots(driver, "validateToolTipResSupplyPage", path);
			String ToolTipText = lockSymbolOnResSupplyPage.get(0).getAttribute("data-original-title");
			System.out.println("ToolTip Information: " + ToolTipText);
			// To check if Tool Tip information has soft lock details
			if (ToolTipText.contains("Soft Locked by")) {
				System.out.println("Soft Lock details are mentioned on resource ToolTip icon");
				TakeScreenshot.captureScreenshots(driver, "validateToolTipSupplyPage", path);
				logger.log(LogStatus.PASS, "Soft Lock details are mentioned on resource ToolTip icon");
				softly.assertTrue(true);

			} else {

				System.out.println("Soft Lock details are NOT mentioned on resource ToolTip icon");
				TS = TakeScreenshot.captureScreenshots(driver, "validateToolTipSupplyPage", path);
				logger.log(LogStatus.FAIL,
						"Soft Lock details are NOT mentioned on resource ToolTip icon, Actual ToolTip Details: "
								+ ToolTipText + logger.addScreenCapture(TS));
				softly.assertTrue(false);
			}
			// TO Open SL resource and get the Personnal Number
			clickSLResorce(driver, path, logger);
			UtilMethods.waitTillElementIsVisible(logger, driver, resInfo);
			String resinfo = resInfo.getText();
			ResPersNo = mf.getResPersNumberFromResPage(resinfo);
			System.out.println("Resource Personnal Number:" + ResPersNo);
			EmpID = mf.getResEmpIDFromResPage(resinfo);
			System.out.println("Resource Employee ID:" + EmpID);
			UtilMethods.clickOn(logger, backButtonOnResourcePage, "Back Button On Resource Page");
			UtilMethods.waitTillElementIsVisible(logger, driver, addSupplyButtonOnSupplyPage);
		}
		return driver;
    }
     
    
    
    public WebDriver clickSLResorce(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {	
		Actions dragger = new Actions(driver);
		 for (int i=0; i< actionButtonSupplyPage.size(); i++)
		 {
			 UtilMethods.clickOn(logger, actionButtonSupplyPage.get(i),"Action Button on Supply Page");
			 dragger.moveToElement(actionButtonSupplyPage.get(i));
		    	if((challengeButtonSupplyAction.size()!=0) || (sltoHLConversionButtonSupplyAction.size()!=0) || (sltoShadowHLConversionButtonSupplyAction.size()!=0))
		    	{
		    		UtilMethods.clickOn(logger, actionButtonSupplyPage.get(i),"Action Button on Supply Page");
		    		Thread.sleep(1000);
			    	UtilMethods.clickOn(logger, resNameListRRDPage.get(i),"SL Resource "+resNameListRRDPage.get(i).getText());
		  		   	break;
		    	}	
		    	else 
		    	{
			    	UtilMethods.clickOn(logger, actionButtonSupplyPage.get(i),"Action Button on Supply Page");

		    	}
		 }
    	

    	
      	return driver;
    }
     
    
    
    public WebDriver validateToolTipAddSupply(WebDriver driver,String path, ExtentTest logger) throws InterruptedException, AWTException
    {	
    	if (status) 
    	{
		 TakeScreenshot.captureScreenshots(driver,"validateToolTipAddSupply",path);
		 UtilMethods.clickOn(logger, addSupplyButtonOnSupplyPage,"Add SUpply Button On Supply Page");
		 UtilMethods.waitTillElementIsVisible(logger,driver,addSupplyInputField);
		 UtilMethods.setText(logger ,addSupplyInputField, ResPersNo);// Enter Personnal Number of SL Resource
		 UtilMethods.waitTillElementIsVisible(logger,driver,addSupplyAutoPopulatedValue);
		 UtilMethods.clickOn(logger, addSupplyAutoPopulatedValue,"AutoPopulated Personnal Number");
		 UtilMethods.waitTillElementIsVisible(logger,driver,addSupplyResultTable);
		 TakeScreenshot.captureScreenshots(driver,"addSupplyResultTable",path);

		 if(lockSymbolOnAddSupplyModelPage.size()!=0)
		 {
		    	Actions ToolTip1 = new Actions(driver);
		    	ToolTip1.moveToElement(lockSymbolOnAddSupplyModelPage.get(0));
		    	ToolTip1.clickAndHold(lockSymbolOnAddSupplyModelPage.get(0)).perform();
		    	String ToolTipText = lockSymbolOnAddSupplyModelPage.get(0).getAttribute("data-original-title");
		        System.out.println("ToolTip Information on Add Supply Page: "+ ToolTipText);

		        // To check if Tool Tip information has soft lock details
		        if (ToolTipText.contains("Soft Locked by")) 
		        {
		    		System.out.println("Soft Lock details are mentioned on resource ToolTip icon on Add Supply model Page");
		    		TakeScreenshot.captureScreenshots(driver,"validateToolTipAddSupplyPage",path);
					logger.log(LogStatus.PASS, "Soft Lock details are mentioned on resource ToolTip icon on Add Supply model Page" );
					softly.assertTrue(true);

		        } else {

		   		 	System.out.println("Soft Lock details are NOT mentioned on resource ToolTip icon");
					TS = TakeScreenshot.captureScreenshots(driver,"validateToolTipAddSupplyPage",path);
				    logger.log(LogStatus.FAIL, "Soft Lock details are NOT mentioned on resource ToolTip icon, Actual ToolTip Details: "+ToolTipText+logger.addScreenCapture(TS));
					softly.assertTrue(false);
		        }
		 }
		 else
		 {

	   		 	System.out.println("Soft Lock icon Not shown on Resource in Add Supply Page");
				TS = TakeScreenshot.captureScreenshots(driver,"validateToolTipAddSupplyPage",path);
			    logger.log(LogStatus.FAIL, "Soft Lock icon Not shown on Resource in Add Supply Page"+logger.addScreenCapture(TS));
				softly.assertTrue(false);	
		 }
		 
    	}
    	
      	return driver;
    }
     	
    	
    public WebDriver demandSkillHighlight(WebDriver driver,String path, ExtentTest logger) throws InterruptedException, AWTException
    {
		status =checkRRDTwoList( driver, path,  logger,purpleColourIcon ,cyanColourIcon);
    	softly.assertTrue(status);
		int countOntology = 0;
		int secondaryskill= 0;
    	int matchedSkills =0;
    	int j=0;
     	if (status) 
    	{
     		String demandinfo = demandInfo.getText();
     		for (int i=0; i< actionButtonSupplyPage.size(); i++)
     		{
     			j=i+1;
     			String resSkillNameXpath = ".//*[@class='ui-grid-canvas']/div["+j+"]//*[@class='ng-isolate-scope']/div/div[4]/div";
     			String ResSkillName= driver.findElement(By.xpath(resSkillNameXpath)).getText();
     			if(!demandinfo.contains(ResSkillName))
	     			{
     				String ontologyspecialitySkillXpath =".//*[@class='ui-grid-canvas']/div["+j+"]/div/div/div[4]/div/*[@class='skill-status ontologyspeciality']";
     				List <WebElement> ontologyspecialitySkill = driver.findElements(By.xpath(ontologyspecialitySkillXpath));
     				String secondarySkillXpath =".//*[@class='ui-grid-canvas']/div["+j+"]/div/div/div[4]/div/*[@class='skill-status secondary']";
     				List <WebElement> secondarySkill = driver.findElements(By.xpath(secondarySkillXpath));
	     				if(ontologyspecialitySkill.size()!=0 || secondarySkill.size()!=0)
			     			{
	     						if(ontologyspecialitySkill.size()!=0 && countOntology==0)
	     						{
	    	     		     		System.out.println("Resource "+j+" Skill other than primary & secondary skills is matched with demand's skill and skill is highlighted in purple color");
	    	     				    logger.log(LogStatus.PASS, "Resource "+j+" Skill other than primary & secondary skills is matched with demand's skill and skill is highlighted in purple color");
	    	     				    countOntology=countOntology+1;
	    	     				    softly.assertTrue(true);
	     						}
	     						if(secondarySkill.size()!=0 && secondaryskill==0)
	     						{
	    	     		     		System.out.println("Resource "+j+" Secondary Skill Matched with Demand Skill, and Skill of the resource is highlighted in cyan color");
	    	     				    logger.log(LogStatus.PASS, "Resource "+j+" Secondary Skill Matched with Demand Skill, and Skill of the resource is highlighted in cyan color");
	    	     				    secondaryskill=secondaryskill+1;
	    	     				    softly.assertTrue(true);
	     						}
	     						if((countOntology>=1) && (secondaryskill>=1))
	     						{
	     							break;
	     						}	
			     			}
	     				else 
		     				{
	     		   		 	System.out.println("Skills are not Highlighted in Any Colour");
	     					TS = TakeScreenshot.captureScreenshots(driver,"demandSkillHighlightFail",path);
	     				    logger.log(LogStatus.FAIL, "Skills are not Highlighted in Any Colour"+logger.addScreenCapture(TS));
	     					softly.assertTrue(false);	
		     				}
	     			}
     			else
	     			{
     					matchedSkills=matchedSkills+1;
     					continue;	
	     			}
     		}
     		if(matchedSkills>0)
     		{
     			System.out.println(matchedSkills+" Resources Skills Matched with Demand Skill, and Primary skill of the resource is not highlighted as Expected");
				logger.log(LogStatus.PASS,matchedSkills+" Resources Skills Matched with Demand Skill, and Primary skill of the resource is not highlighted as Expected");
				softly.assertTrue(true);
     		}
    	}
    	return driver;
    }

    
    public WebDriver checkStatusHighlight(WebDriver driver,String path, ExtentTest logger)
    {
	
    	if(resHighlightInRedTaggedTab.size()!=0)
	    	{
    			TakeScreenshot.captureScreenshots(driver,"checkStatusHighlight",path);
	 			System.out.println("Supply with 'Pending Evaluation' status & available greater than 3 days are highlighted in RED");
				logger.log(LogStatus.PASS,"Supply with 'Pending Evaluation' status & available greater than 3 days are highlighted in RED");
				softly.assertTrue(true);
	    	}
    	else
	    	{
		   		System.out.println("Supply with 'Pending Evaluation' status & available less than 3 days are NOT highlighted in RED");
				TakeScreenshot.captureScreenshots(driver,"checkStatusHighlight",path);
				logger.log(LogStatus.PASS, "Supply with 'Pending Evaluation' status & available less than 3 days are NOT highlighted in RED");
				softly.assertTrue(true);	
	    	}
    
		return driver;
    }
   
    public WebDriver checkNotReachableStatusHighlight(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
	
    	if(nrStatus)
    	{
	   		 mf.closeFC(driver,path, logger);
	   		 enterRRDNumber( driver, path,NRrrd, logger);
	   		 mf.taggedTab(driver,path, logger);
	   		 
	   		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 Thread.sleep(4000);
			 String supplyStatus = inactiveRRD.getText();
			 int a = 0;
			 if(supplyStatus.equalsIgnoreCase("Resource Allocated"))
			 {
				 a=1;
				logger.log(LogStatus.INFO, "Inactive RRD: "+rrdNumber);
				System.out.println( "Inactive RRD: "+rrdNumber);
			 }
			 
			 if (a == 0) 
			 {

		   		 if (noSupplyTagged.size()== 0) 
		   		 {
					String actualNRresourceName;
					int k;
					for (k = 0; k < actionButtonTaggedTab.size(); k++) {
						actualNRresourceName = resNameTaggedTab.get(k).getText();
						System.out.println(actualNRresourceName);
						if (NRresourceName.equals(actualNRresourceName)) {
							System.out.println("resource found:" + actualNRresourceName);
							break;
						}
	
					}
					int p=0;
					if (resStatusOnTaggedTab.get(k).getText().contains("Not reachable")) {
						if (resHighlightInRedTaggedTab.size() != 0) {
							for (int m = 0; m < resHighlightInRedTaggedTab.size(); m++) {
								String highlightRresourceName = resHighlightInRedTaggedTab.get(m).getText();
								if (NRresourceName.equals(highlightRresourceName)) {
										p=1;
								}
							}
							if(p==1)
							{
								System.out.println("Not Reachable resource is highlighted in RED");
								TS = TakeScreenshot.captureScreenshots(driver, "checkNotReachableStatusHighlightFail",
										path);
								logger.log(LogStatus.FAIL,
										"Not Reachable resource is highlighted in RED" + logger.addScreenCapture(TS));
								softly.assertTrue(false);
							} else {
								TakeScreenshot.captureScreenshots(driver, "checkNotReachableStatusHighlight", path);
								System.out.println("Not Reachable resource is NOT highlighted in RED as Expected");
								logger.log(LogStatus.PASS,
										"Not Reachable resource is NOT highlighted in RED as Expected");
								softly.assertTrue(true);
	
							}
								
							
							
							
						} else {
							TakeScreenshot.captureScreenshots(driver, "checkNotReachableStatusHighlight", path);
							System.out.println("Not Reachable resource is NOT highlighted in RED as Expected");
							logger.log(LogStatus.PASS, "Not Reachable resource is NOT highlighted in RED as Expected");
							softly.assertTrue(true);
						}
	
					} else {
						System.out.println("Resource Status Not changed to 'Not Reachable'");
						TS = TakeScreenshot.captureScreenshots(driver, "checkNotReachableStatusHighlightFail", path);
						logger.log(LogStatus.FAIL,
								"Resource Status Not changed to 'Not Reachable'" + logger.addScreenCapture(TS));
						softly.assertTrue(false);
					} 
				}
		   		 else
		   		 {
		     		logger.log(LogStatus.INFO, "Skipping this exception as 'No Data Available on Tagged Tab' for RRD:"+NRrrd);
		    		throw new SkipException("Skipping this exception as 'No Data Available on Tagged Tab' for RRD:"+NRrrd); 
		   		 }
	   		 
		    	
			}
			 else {
						UtilMethods.clickOn(logger, backButtonOnDemandPage, "Back Button On Demand Page");
						Thread.sleep(4000);
					}    		 
	   		 
	   		 
	   		 
    	}
		
    	else
    	{
    		logger.log(LogStatus.INFO, "Skipping this exception as Resource Status not marked as 'Not Reachable' in Test Case01");
    		throw new SkipException("Skipping this exception as Resource Status not marked as 'Not Reachable' in Test Case01");
    	}
    
		return driver;
    }
    
    public boolean getNotReachableResource(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
	
   
    		String NRrrdInfo=rrdNumberInfo.getText();
    		NRrrd=NRrrdInfo.substring(0, 8);
    		System.out.println(NRrrd);
			//NRresourceName = resHighlightInRedTaggedTab.get(0).getText();
			
			for (int k = 0; k < actionButtonTaggedTab.size(); k++) {
					NRresourceName = resNameTaggedTab.get(k).getText();
					UtilMethods.clickOn(logger, actionButtonTaggedTab.get(k), "Action Button on Supply Page");
					Thread.sleep(2000);
					if(notReachableButtonSupplyAction.size()!=0)
					{
						System.out.println(NRresourceName);
						break;
					}
					
					else {
						System.out.println("Not Reachable action button not shown to user"+k+1);
						UtilMethods.clickOn(logger, actionButtonTaggedTab.get(k), "Action Button on Supply Page");
					}
						
				
				}
			UtilMethods.waitTillElementIsVisible(logger, driver, notReachableOptionActionButton);
			UtilMethods.clickOn(logger, notReachableOptionActionButton, "Not Reachable link");
			UtilMethods.waitTillElementIsVisible(logger, driver, notReachableModalPopUp);
			UtilMethods.clickOn(logger, notReachableDateField, "Not Reachable Date Field");
			MethodFactory.selectDate(driver, notReachableDateField, notReachableDdates, 0, logger);
			UtilMethods.setText(logger, notReachableCommentsField, "Enter Comments From Tester");// Enter Comments
			UtilMethods.clickOn(logger, notReachableSubmitButton, "Submit Button");
			UtilMethods.waitTillElementIsVisible(logger, driver, notReachableSuccessPopup);
			String notReachableSuccessMessage = notReachableSuccessPopup.getText();
			System.out.println(notReachableSuccessMessage);
			if(notReachableSuccessMessage.contains("successfully"))
				{
					System.out.println("Resource " + NRresourceName + " Marked as Not Reachable Successfully, Success Message: "+ notReachableSuccessMessage);
					logger.log(LogStatus.INFO, "Resource " +NRresourceName+ " Marked as Not Reachable Successfully, Success Message: " + notReachableSuccessMessage);
					return true;
				}
			else
					System.out.println("Resource Not Marked as Not Reachable");
					logger.log(LogStatus.INFO, "Resource Not Marked as Not Reachable");
					return false;
		
		
    }
    
    public WebDriver trendOutsideAccLinkChk(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
    	Thread.sleep(3000);
    	UtilMethods.clickOn(logger, firstRRDonDemandPage, "first RRD on Demand Page");
    	Thread.sleep(8000);
    	
    	System.out.println(" Trend Outside Accenture Link check for InActive MI skill ");
    
    		if(trendOutsideAccLinkList.size()!=0)
    		{
    			TakeScreenshot.captureScreenshots(driver,"Trend Outside Accenture Link",path);
     			System.out.println("Trend Outside Accenture Link is visible for MI Inactive Skils");
    			logger.log(LogStatus.FAIL,"Trend Outside Accenture Link is visible for MI Inactive Skils");
    			softly.assertTrue(false);
        	}
	    	else
		    	{
		    	        System.out.println("Trend Outside Accenture Link is not visible for MI Inactive Skils ");
		    			TakeScreenshot.captureScreenshots(driver,"Trend Outside Accenture Link",path);
		    			logger.log(LogStatus.PASS, "Trend Outside Accenture Link is not visible for MI Inactive Skils");
		    			softly.assertTrue(true);
		    	}
    	
    	//Thread.sleep(3000);
   		 UtilMethods.waitTillElementIsVisible(logger,driver,backButtonOnDemandPage);
    	UtilMethods.clickOn(logger, backButtonOnDemandPage, "back Button On Demand Page");
    	Thread.sleep(2000);
  		 UtilMethods.waitTillElementIsVisible(logger,driver,filterClearButtonOnDemandPage);
    	UtilMethods.clickOn(logger, filterClearButtonOnDemandPage, "filter Clear Button On Demand Page");
    	Thread.sleep(5000);
    	applySkillFilter(driver, path,logger, 2 ,1);
 		 UtilMethods.waitTillElementIsVisible(logger,driver,applyButtonDemandPage);
 		applyButtonDemandPage(driver,path,logger);
		 UtilMethods.waitTillElementIsVisible(logger,driver,firstRRDonDemandPage);
    	UtilMethods.clickOn(logger, firstRRDonDemandPage, "first RRD on Demand Page");
    	
    	
    	System.out.println(" Trend Outside Accenture Link check for Active MI skill ");
    	Thread.sleep(8000);
    	
    	if(trendOutsideAccLinkList.size()!=0)
    		{
				TakeScreenshot.captureScreenshots(driver,"Trend Outside Accenture Link",path);
	 			System.out.println("Trend Outside Accenture Link is visible for MI active Skils");
				logger.log(LogStatus.PASS,"Trend Outside Accenture Link is visible for MI active Skils");
				softly.assertTrue(true);
    		}
		else
	    	{
		   		System.out.println("Trend Outside Accenture Link is not visible for MI active Skils ");
				TakeScreenshot.captureScreenshots(driver,"Trend Outside Accenture Link",path);
				logger.log(LogStatus.FAIL, "Trend Outside Accenture Link is not visible for MI active Skils");
				softly.assertTrue(false);	
	    	}
		return driver;
    
    }
    
    public WebDriver miBarGraphCountChk(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
    	int totalCountAdd = 0;
    	UtilMethods.clickOn(logger, trendOutsideAccLink, "Trend Outside Acc Link");
    	Thread.sleep(2000);
    	
    	String trendOutAccLabel = trendOutsideAccLabel.getText();
    	System.out.println(trendOutAccLabel);
        int index = trendOutAccLabel.indexOf("(");
		String count = trendOutAccLabel.substring(index+1, trendOutAccLabel.length()-1);
		int totalCount = Integer.parseInt(count);
		
		String [] barGraphCount = new String[miBargraphCount.size()];
		
		 for(int i=2; i<  miBargraphCount.size(); i++)
		 {
			 WebElement bargraphCount = miBargraphCount.get(i);
			 barGraphCount[i] = bargraphCount.getText();
			 
			 System.out.println("Bar Count: " + barGraphCount[i]);
			 
			 int singleGraphCount = Integer.parseInt(barGraphCount[i]);
			 totalCountAdd += singleGraphCount;
			 
		 }
    	
		 System.out.println("Total Count: " + totalCount);
		 System.out.println("Sum of bar Graphs: " + totalCountAdd);
		 if(totalCount==totalCountAdd)
	    	{
				TakeScreenshot.captureScreenshots(driver,"Total count of all available resources",path);
	 			System.out.println("Correct total count of all available resources");
				logger.log(LogStatus.PASS, "Correct total count of all available resources");
				softly.assertTrue(true);
	    	}
		else
	    	{
		   		System.out.println("InCorrect total count of all available resources");
				TakeScreenshot.captureScreenshots(driver,"Total count of all available resources",path);
				logger.log(LogStatus.FAIL, "InCorrect total count of all available resources");
				softly.assertTrue(false);	
	    	}
    	
		return driver;
    }
    
    public WebDriver miLocationLevelChk(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
    	
    	String [] locations = {"BENGALURU","CHENNAI","HYDERABAD","KOLKATA","MUMBAI","NCR","OTHERS","PUNE"};
    	String [] milevel = {"SE","SSE","TL","AM"};
    	
    	for(int i= 4; i< miBargraphLabels.size()-1; i++)
    	{
    		WebElement mibar = miBargraphCount.get(i-2);
    		UtilMethods.clickOn(logger, mibar , "MI Bar graph ");
    		
    		WebElement label = miBargraphLabels.get(i);
    		String miLoc = label.getText();
    		
    		String activeLabelText = miActiveBargraphLabels.getText();
    		
    		int index = activeLabelText.indexOf(" ");
    		
    		String activeLabel = activeLabelText.substring(0, index);
    		
    		System.out.println(miLoc + " is clicked");
    		System.out.println(activeLabel + " is Displayed");
    		
    		if(miLoc.equalsIgnoreCase(locations[i-4])&& miLoc.equalsIgnoreCase(activeLabel))
	    	{
				TakeScreenshot.captureScreenshots(driver,"MI Location Check",path);
	 			System.out.println("Correct MI Location is displayed");
				logger.log(LogStatus.PASS, "Correct MI Location is displayed");
				softly.assertTrue(true);
	    	}
		else
	    	{
		   		System.out.println("InCorrect MI Location is displayed");
				TakeScreenshot.captureScreenshots(driver,"MI Location Check",path);
				logger.log(LogStatus.FAIL, "InCorrect MI Location is displayed");
				softly.assertTrue(false);	
	    	}
    	}
    	
    	for(int i= 0; i< careerLevelLabels.size(); i++)
    	{
    		WebElement level = careerLevelLabels.get(i);
    		String levels = level.getText();
    		int index = levels.indexOf("(");
    		
    		String miLevels = levels.substring(0, index);
    		if(miLevels.equalsIgnoreCase(milevel[i]))
    		{
    			System.out.println("Correct Level is displayed: " + miLevels);
    		}
    		else
    		{
    			System.out.println("InCorrect Level is displayed: " + miLevels);
    		}
    	}
    	
    	
    	return driver;
    	
    }
    
    public WebDriver miLocationCountChk(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {	
    	
    	
    	for(int i=2; i<miBargraphCount.size(); i++)
		 {
    		WebElement mibar = miBargraphCount.get(i);
    		UtilMethods.clickOn(logger, mibar , "MI Bar graph ");
    		
    		WebElement bargraphCount = miBargraphCount.get(i);
    	    String bargraphCountText = bargraphCount.getText();
    	    int barCount = Integer.parseInt(bargraphCountText);
    		
    		String activeGraphLabel = miActiveBargraphLabels.getText();
    		int index = activeGraphLabel.indexOf("-");
    		String countText = activeGraphLabel.substring(index+2, activeGraphLabel.length());
    		int locationCount = Integer.parseInt(countText);
    		
    		WebElement bargraphLabel = miBargraphLabels.get(i+2);
    	    String bargraphText = bargraphLabel.getText();
    		
    		if(barCount==locationCount)
	    	{
				TakeScreenshot.captureScreenshots(driver,"Active Bar Count Check",path);
	 			System.out.println(bargraphText + " Bar Graph Count is equal as Active location Count");
				logger.log(LogStatus.PASS, "Bar Graph Count is equal as Active location Count");
				softly.assertTrue(true);
	    	}
		else
	    	{
		   		System.out.println(bargraphText + " Bar Graph Count is not equal as Active location Count");
				TakeScreenshot.captureScreenshots(driver,"Active Bar Count Check",path);
				logger.log(LogStatus.FAIL, "Bar Graph Count is not equal as Active location Count");
				softly.assertTrue(false);	
	    	}
    		
		 }
    	
    	return driver;
    	
    }
    
    public WebDriver CheckWithinRovBifurcation(WebDriver driver,String path, ExtentTest logger) throws InterruptedException
    {
    	//Actions action = new Actions(driver);
    	//action.doubleClick(ElementFactory.demandTab).perform();
	    //UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.firstRRDonDemandPage,"First RRD Link"); 
	   	//UtilMethods.clickOn(logger, ElementFactory.firstRRDonDemandPage, "Clicked on First RRD"); 
	   		 
        Thread.sleep(2000);
	
        String withinIGName = withinIG.getText();
        String withinDUName = withinDu.getText();
        String withinClientName = withinClient.getText();
        
		System.out.println("withinIGName:"+withinIGName+" , withinDUName:"+withinDUName+" , withinClientName:"+withinClientName);
		logger.log(LogStatus.INFO, "withinIGName:"+withinIGName+" , withinDUName:"+withinDUName+" , withinClientName:"+withinClientName);

        
    	if(withinIGName!=null)
    	{
    		System.out.println("WitinIG Bifurcation under WithinRov tab present");
    		TakeScreenshot.captureScreenshots(driver,"withinIG",path);
			logger.log(LogStatus.PASS, "WitinIG Bifurcation under WithinRov tab present" );
			softly.assertTrue(true);
    	}
    	else
    	{
    		 System.out.println("No WitinIG bifurcation under WithinRov tab present");
			 TS = TakeScreenshot.captureScreenshots(driver,"withinIG",path);
		     logger.log(LogStatus.FAIL, "No WitinIG bifurcation under WithinRov tab present"+logger.addScreenCapture(TS));
			 softly.assertTrue(false);
    
		 }
    	if(withinDUName!=null)
    	{	
    	
    		System.out.println("WitinDu Bifurcation under WithinRov tab present");
		TakeScreenshot.captureScreenshots(driver,"pendingApprovalLR",path);
		logger.log(LogStatus.PASS, "WitinDu Bifurcation under WithinRov tab present" );
		softly.assertTrue(true);
	}
    	else
    	{
    		 System.out.println("No WitinDu bifurcation under WithinRov tab present");
			 TS = TakeScreenshot.captureScreenshots(driver,"pendingApprovalLR",path);
		     logger.log(LogStatus.FAIL, "No WitinDu bifurcation under WithinRov tab present"+logger.addScreenCapture(TS));
			 softly.assertTrue(false);
    	}
    	
    	if(withinClientName!=null)
    	{	
    	
    		System.out.println("withinClient Bifurcation under WithinRov tab present");
		TakeScreenshot.captureScreenshots(driver,"pendingApprovalLR",path);
		logger.log(LogStatus.PASS, "withinClient Bifurcation under WithinRov tab present" );
		softly.assertTrue(true);
	}
    	else
    	{
    		 System.out.println("No withinClient bifurcation under WithinRov tab present");
			 TS = TakeScreenshot.captureScreenshots(driver,"pendingApprovalLR",path);
		     logger.log(LogStatus.FAIL, "No withinClient bifurcation under WithinRov tab present"+logger.addScreenCapture(TS));
			 softly.assertTrue(false);
    	}
    	
    	return driver;
    }
    
    
    public WebDriver checkGraphForROV(WebDriver driver, String path, ExtentTest logger,  List <WebElement> wb, int barNumber) throws InterruptedException
    {
    	int j = 1;
    	int i;
		 for ( i=0; i< rrdNumberOnDemandPage.size(); i++)
		 {
			 if(i==20)
			 {
				 UtilMethods.waitTillElementIsVisible(logger,driver,clearButtonDemandPage);
				 UtilMethods.clickOn(logger,clearButtonDemandPage,"Clear Button");
				 Thread.sleep(10000);
			 }
			 UtilMethods.waitTillElementIsVisible(logger,driver,rrdNumberOnDemandPage.get(i));
			 rrdNumber= rrdNumberOnDemandPage.get(i).getText();
			 UtilMethods.clickOn(logger, rrdNumberOnDemandPage.get(i),"RRD: "+rrdNumber);
			 WebDriverWait wait = new WebDriverWait(driver, 60);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			 Thread.sleep(4000);
			 String supplyStatus = inactiveRRD.getText();
			 int a = 0;
			 if(supplyStatus.equalsIgnoreCase("Resource Allocated"))
			 {
				 a=1;
				logger.log(LogStatus.INFO, "Inactive RRD: "+rrdNumber);
				System.out.println( "Inactive RRD: "+rrdNumber);
			 }
			 
			 if (a == 0) 
			 {
				 if(noDataAvailable.size()==0)
				 {
	
					 String count =wb.get(1).getText();
					 int countnew = Integer.valueOf(count);
					 System.out.println("Bench count is "+countnew);
					 if(countnew > 0) 
						{
						 	j=0;
							UtilMethods.clickOn(logger, rovWithinIGBarGraph, "ROV Within IG Bar Graph");
							wait.until(ExpectedConditions.visibilityOfAllElements(resNameListRRDPage));
						 	break;
						}
					 else
						{
							UtilMethods.clickOn(logger,backButtonOnDemandPage,"Back Button On Demand Page");
							Thread.sleep(4000);
						}
				 }
				 else
				 	{
					 	UtilMethods.clickOn(logger,backButtonOnDemandPage,"Back Button On Demand Page");
					 	Thread.sleep(4000);
					}
			 
		    	
				}
				 else {
						UtilMethods.clickOn(logger, backButtonOnDemandPage, "Back Button On Demand Page");
						Thread.sleep(4000);
					} 
    	
		 }
		if(j==0)
		{
			logger.log(LogStatus.PASS, "Graph Shown properly");
			softly.assertTrue(true);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Graph not Shown properly");
			softly.assertTrue(false);
		}
		
		
		return driver;
    }
    
    public WebDriver captiveFilterVisibility(WebDriver driver, String path, ExtentTest logger)
	  {
    	try {
			Thread.sleep(7000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		TakeScreenshot.captureScreenshots(driver, "Captive Fitler", path);

    	try {
			if(captiveFilter.isDisplayed())
			  {
				logger.log(LogStatus.PASS, "Captive Fitler is displayed");
				softly.assertTrue(true);

			  }
		} catch (Exception e) {
			 TS= TakeScreenshot.captureScreenshots(driver, "Captive Filter", path);
			 logger.log(LogStatus.FAIL, "Captive Fitler is not displayed" +logger.addScreenCapture(TS));
			   softly.assertTrue(false);
	
		}
		  return driver;
	  }
    
    
    public WebDriver selectCaptiveFilterValue(WebDriver driver, String path, ExtentTest logger,String value)
    {
		 UtilMethods.clickOn(logger, selectCaptiveFilter,"captive Filter");
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 TakeScreenshot.captureScreenshots(driver, "Captive Filter Values", path);
		 UtilMethods.setText(logger, inputCaptiveValue, value);
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 UtilMethods.clickOn(logger, selectCaptiveFilterValue,"captive Filter value");
		 TakeScreenshot.captureScreenshots(driver, "Captive Filter value select", path);
    	return driver;
    }
    
    
    public String getResPersNumberFromResPage(String data, int a)
	{
		String captive = null;
		String s = data;
		char c ='|'; //character c is static...can be modified to accept user input
		int count=0;
		for(int i=0;i<s.length();i++)
	       {
	    	   if(s.charAt(i)==c)
	    	   {
	    		   count=count+1;
	    		   if(count==a)
	    		   {
		    		   String secondpart =  s.substring(i, s.length());
		    		   captive =  secondpart.substring(2,18);
		    		   System.out.println("Value of captive is: "+captive);
		    		   break;
	    		   }
	    	   }
	       }
		
	    return captive;
	}
    
    public WebDriver valdiateResCaptiveFlag(WebDriver driver, String path, ExtentTest logger, WebElement we, int a) throws InterruptedException
    {
    	Thread.sleep(8000);
		 UtilMethods.waitTillElementIsVisible(logger,driver,we);
    	String resinfo = we.getText();
    	ResCapttiveFlag = getResPersNumberFromResPage(resinfo, a);
    	TakeScreenshot.captureScreenshots(driver, "Resource Info", path);
    	if(ResCapttiveFlag.contains("N"))
    	{
    		logger.log(LogStatus.PASS, "Captive Flag is correct");
			softly.assertTrue(true);
    	}
    	else
    	{
    		
    		TS= TakeScreenshot.captureScreenshots(driver, "Captive Flag for resource", path);
    		logger.log(LogStatus.FAIL, "Captive Flag is not correct" +logger.addScreenCapture(TS));
			   softly.assertTrue(false);
       	}
		return driver;
    	
    }
    
    
    public WebDriver checkDemandCaptiveFlag(WebDriver driver, String path, ExtentTest logger, String TabName) throws InterruptedException
    {
    	
		 //UtilMethods.waitForListLoading(driver, logger,captiveIconListDemandPagee, "Captive Flag");
		 Thread.sleep(2000);
    	int j = 0;
    	if(captiveIconListDemandPagee.size()>0)
    	{
         UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.firstRRDonDemandPage, "RRD on Demand Page");
		 for(int i=0; i < captiveIconListDemandPagee.size(); i++)
			{
			 String captiveFlagTitle = captiveIconListDemandPagee.get(i).getAttribute("data-original-title");
				if(!captiveFlagTitle.equalsIgnoreCase("Captive"))
					  {
					 	j=1;
					  }
			}
		 
			if(j==0)
				 {
					System.out.println("Indicators are present for Captive Demands");
				    logger.log(LogStatus.PASS, "Indicators are present for Captive Demands");
				    softly.assertTrue(true);
				  }
			else
				  {	
					 System.out.println("Indicators are NOT present for Captive Demands");
				     TS= TakeScreenshot.captureScreenshots(driver, "Indicators are not present for Captive Demands", path);
				     logger.log(LogStatus.FAIL, "Indicators are not present for Captive Demands" +logger.addScreenCapture(TS));
					 softly.assertTrue(false);
				  }	
    	}	
    	else
    	{
		     TS= TakeScreenshot.captureScreenshots(driver, "There Are No Demands Present", path);
		     logger.log(LogStatus.INFO, "There Are No Demands Present in: "+TabName+logger.addScreenCapture(TS));

    	}
		return driver;
    	
    }
    
    public WebDriver clickTab(WebDriver driver, String path, ExtentTest logger, int tabIndex, String TabName) throws InterruptedException
    {
    	Thread.sleep(2000);
    	UtilMethods.waitForListLoading(driver, logger,tabOnDemandPage,TabName);
    	UtilMethods.clickOn(logger, tabOnDemandPage.get(tabIndex), TabName+"On Demand Page");
    	UtilMethods.clickOn(logger, tabOnDemandPage.get(tabIndex), TabName+"On Demand Page");
    	return driver;
    }
    
    public WebDriver searchRRDForCaptiveSupply(WebDriver driver, String path, ExtentTest logger, String TabName, List<WebElement> wb ) throws InterruptedException
    {
    	int j=0;
		 //UtilMethods.waitForListLoading(driver, logger,captiveIconListDemandPagee, "Captive Flag");
		 Thread.sleep(2000);
    	if(captiveIconListDemandPagee.size()>0)
    	{
         UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.firstRRDonDemandPage, "RRD on Demand Page");
         for (int  i=0; i< rrdNumberOnDemandPage.size(); i++)
			{
        	 j=i+1;
			 UtilMethods.waitTillElementIsVisible(logger,driver,rrdNumberOnDemandPage.get(i));
			 rrdNumber= rrdNumberOnDemandPage.get(i).getText();
			 UtilMethods.clickOn(logger, rrdNumberOnDemandPage.get(i),"RRD: "+rrdNumber);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 if(wb.size()!=0)
				 {
				 	String count=CountbenchWithinIGBarGraph.getText();
					int countnew = Integer.valueOf(count);
					System.out.println("BenchwithinIG count is "+countnew);
				 	if(countnew>=2)
					{
					    logger.log(LogStatus.INFO, "Supply Found");
						System.out.println("BenchwithinIG Supply Found");
				    	UtilMethods.waitForListLoading(driver, logger,filtersOnSupplyPageList,"Filters On Supply page");
						UtilMethods.clickOn(logger, filtersOnSupplyPageList.get(6),"FILTER BY CAPTIVE FLAG On Supply Page");
						
						if(CaptiveFilterValuesListSupplyPage.size()==1)
						{
							if(CaptiveFilterValuesListSupplyPage.get(0).getText()=="Y")
							{
						    	UtilMethods.waitForListLoading(driver, logger,filtersOnSupplyPageList,"Yes Captive Filter Flag On Supply Page");
								UtilMethods.clickOn(logger, CaptiveFilterValuesListSupplyPage.get(0),"Yes Captive Filter Flag On Supply Page");
								applyButtonSupplyPage(driver, path, logger);
								break;
							}
							else
							{
							 	 System.out.println("Captive Supply Not Available. Searching another demand");
								 UtilMethods.clickOn(logger,backButtonOnDemandPage,"Back Button On Demand Page");
								 Thread.sleep(1000);
							}
						}
						else
						{
					    		UtilMethods.waitForListLoading(driver, logger,filtersOnSupplyPageList,"Yes Captive Filter Flag On Supply Page");
								UtilMethods.clickOn(logger, CaptiveFilterValuesListSupplyPage.get(1),"Yes Captive Filter Flag On Supply Page");
								applyButtonSupplyPage(driver, path, logger);
								break;
						}
	
					}
					else
					 {
						 UtilMethods.clickOn(logger,backButtonOnDemandPage,"Back Button On Demand Page");
						 Thread.sleep(1000);
					 }
					
				 }
			else
				 {
					 UtilMethods.clickOn(logger,backButtonOnDemandPage,"Back Button On Demand Page");
					 Thread.sleep(1000);
				 }
			}
         if(j==rrdNumberOnDemandPage.size())
         {
	     		logger.log(LogStatus.INFO, "Skipping this exception as 'No Demand Available with captive resources in Within Bench IG Grapth");
	    		throw new SkipException("Skipping this exception as 'No Demand Available with captive resources in Within Bench IG Grapth"); 
         }
		
    	}
    	else
    	{
		     TS= TakeScreenshot.captureScreenshots(driver, "There Are No Demands Present", path);
		     logger.log(LogStatus.INFO, "There Are No Demands Present in: "+TabName+logger.addScreenCapture(TS));

    	}

		return driver;
    	
    }
    
    public int captiveStatus;
    public WebDriver checkSupplyCaptiveFlag(WebDriver driver, String path, ExtentTest logger) throws InterruptedException
    {
    	
		 //UtilMethods.waitForListLoading(driver, logger,captiveIconListDemandPagee, "Captive Flag");
		 Thread.sleep(2000);
		 captiveStatus = 0;
    	if(captiveIconListSupplyPage.size()>0)
    	{
    	 Thread.sleep(2000);
		 for(int i=0; i < captiveIconListSupplyPage.size(); i++)
			{
			 	UtilMethods.waitTillElementIsVisible(logger,driver,captiveIconListSupplyPage.get(i));
			 	String captiveFlagTitle = captiveIconListSupplyPage.get(i).getAttribute("data-original-title");
				if(!captiveFlagTitle.equalsIgnoreCase("Captive"))
					  {
					captiveStatus=1;
					  }
			}
		 
			if(captiveStatus==0)
				 {
					System.out.println("Indicators are present on Supply for Captive Demands");
				    logger.log(LogStatus.PASS, "Indicators are present on Supply for Captive Demands");
				    softly.assertTrue(true);
				  }
			else
				  {	
					 System.out.println("Indicators are NOT present on few Supply for Captive Demands");
				     TS= TakeScreenshot.captureScreenshots(driver, "Indicators are NOT present on few Supply for Captive Demands", path);
				     logger.log(LogStatus.FAIL, "Indicators are NOT present on few Supply for Captive Demands" +logger.addScreenCapture(TS));
					 softly.assertTrue(false);
				  }	
    	}	
    	else
    	{
			 System.out.println("There Are No Supply Present with Captive indicator Even though Filter By Capive flag selected as 'Y'");
		     TS= TakeScreenshot.captureScreenshots(driver, "There Are No Supply Present with Captive indicator Even though Filter By Capive flag selected as 'Y'", path);
		     logger.log(LogStatus.FAIL, "There Are No Supply Present with Captive indicator Even though Filter By Capive flag selected as 'Y' "+logger.addScreenCapture(TS));

    	}
		return driver;
    	
    }
    
    
    public WebDriver checkSupplyCaptiveFlagSLLSearch(WebDriver driver, String path, ExtentTest logger) throws InterruptedException
    {
    	
    	if(captiveStatus==0)
    	{
		 	UtilMethods.waitTillElementIsVisible(logger,driver,resNameListRRDPage.get(0));
			UtilMethods.clickOn(logger, resNameListRRDPage.get(0),"Yes Captive Filter Flag On Supply Page");
			UtilMethods.waitTillElementIsVisible(logger, driver, resInfo);
			String resinfo = resInfo.getText();
			ResPersNo = mf.getResPersNumberFromResPage(resinfo);
			System.out.println("Resource Personnal Number:" + ResPersNo);
			mf.refreshPg(driver);
			mf.enterUsedEnterpriseId(driver, path, ResPersNo , logger);
			UtilMethods.waitTillElementIsVisible(logger, driver, resNameOnSearchSLL);
			Thread.sleep(2000);
			 if(captiveIndicatorSLLSupply.size()!=0)
				 {
					System.out.println("Captive Indicator for Supply is shown corretly on searching SLL through Direct Search");
				    logger.log(LogStatus.PASS, "Captive Indicator for Supply is shown corretly on searching SLL through Direct Search");
				    softly.assertTrue(true);
				 }
			 else
				 {
					 System.out.println("Captive Indicator for Supply is Not shown corretly on searching SLL through Direct Search");
				     TS= TakeScreenshot.captureScreenshots(driver, "Captive Indicator for Supply is Not shown corretly on searching SLL through Direct Search", path);
				     logger.log(LogStatus.FAIL, "Captive Indicator for Supply is Not shown corretly on searching SLL through Direct Search" +logger.addScreenCapture(TS));
					 softly.assertTrue(false);
				 }
			
    	}
    	else
    	{
   		 System.out.println("There Are No Supply Present with Captive indicator Hence SLL Search for supply scenario is skipped");
	     TS= TakeScreenshot.captureScreenshots(driver, "There Are No Supply Present with Captive indicator Hence SLL Search for supply scenario is skipped", path);
	     logger.log(LogStatus.INFO, "There Are No Supply Present with Captive indicator Hence SLL Search for supply scenario is skipped"+logger.addScreenCapture(TS));	
    	}
    	
		return driver;
    	
    }
	@FindBy(xpath=".//*[@aria-label='Export']") public List <WebElement> demandExportLink;
	String[] demandColumns = new String[] {"Demand No.","Client","Account Group","Delivery Group","Delivery Unit",
				"Project Name","Demand Talent Fulfillment Specialist","Client Requirement Start Date",
				"Client Requirement Status","Demand Status","Position Status","Ready to Hard Lock","Fulfillment Entity",
				"Primary Skill","Career Level","Level Flex","Work Location","Office Location","Location Flex",
				"Onsite Component Present","Onsite Country","OnSite City","Job Description"
				,"Good to Have Skills","Must to have Skills","Client Interview Required",
				"Ready to Hard Lock Changed On","No. of Resources Tagged","Demand Flagged","IJP Applicant(s)",
				" ACM Applicant(s)","Channel","SR No","Lock Type / SR Status","SR Type of Approval","SR Approval Status","Captive"};
   
	
    
public void checkallassert()

	{
		softly.assertAll(); 
	}


}
