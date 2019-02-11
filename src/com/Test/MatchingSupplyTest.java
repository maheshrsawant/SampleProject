package com.Test;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Pages.MatchingSupplyPage;
import com.Utility.TestNGCreation;
import com.relevantcodes.extentreports.LogStatus;

public class MatchingSupplyTest extends TestNGCreation {
	SoftAssert softly = new SoftAssert();

	@Test(enabled=true)
	public void TC01_ToValidateSupplyDetailsForCentralTeam() throws Exception {
	
		 logger = report.startTest( (this.getClass().getSimpleName() +" : TC01_ToValidateSupplyDetailsForCentralTeam"))
				 .assignAuthor("Mahesh Sawant")
				 .assignCategory("Regression Test");
		 //Login to SSA
		 try {
		 login(config.getUserCentral(), config.getpassword());// CentralTeam login
		 mf.clickDemandTab(driver,matchingSupply.MatchingSupplySSPath1,logger);
		 matchingSupply.applySkillFilter( driver, matchingSupply.MatchingSupplySSPath1,logger, 1 ,1);
		 //matchingSupply.applyLevelFilter( driver, matchingSupply.MatchingSupplySSPath1,logger, 1 ,2, 2);
		 matchingSupply.applyButtonDemandPage(driver, matchingSupply.MatchingSupplySSPath1,logger);
		 matchingSupply.checkSupplyDashboard(driver, matchingSupply.MatchingSupplySSPath1,logger, matchingSupply.actionButtonSupplyPage);
		 //TC1:Test To Validate Supply - Demand Details when User with TFS user group role logins to SSA
		 matchingSupply.checkDemandDetailsCentralTeamUser(driver, matchingSupply.MatchingSupplySSPath1,logger, "Central Team");
		 
		 mf.refreshPg(driver);
		 mf.clickDemandTab(driver,matchingSupply.MatchingSupplySSPath1,logger);
		 matchingSupply.applySkillFilter( driver, matchingSupply.MatchingSupplySSPath1,logger, 1 ,1);
		 //matchingSupply.applyLevelFilter( driver, matchingSupply.MatchingSupplySSPath1,logger, 1 ,2, 2);
		 matchingSupply.applyButtonDemandPage(driver, matchingSupply.MatchingSupplySSPath1,logger);
		 
		 //TC03: Test To Validate Supply - Filters Within  IG  when User with TFS user group role logins to SSA 
		 matchingSupply.checkGraph(driver, matchingSupply.MatchingSupplySSPath1,logger, matchingSupply.countWithinIGBarGraph,0);
		 matchingSupply.clickBenchWithinIGBarGraph(driver,logger);
		 matchingSupply.setFilter(driver, matchingSupply.MatchingSupplySSPath1,logger);
		 matchingSupply.checkSetFilter(driver, matchingSupply.MatchingSupplySSPath1,logger);
		 matchingSupply.checkGridValues(driver,matchingSupply.filtersOnSupplyPage , matchingSupply.expFilterOnSupplyPage, logger, "Filters On Supply Page");

		 //TC05:Test To Validate Supply - Resource List  when User with TFS user group role logins to SSA and clicks on RRD
		 matchingSupply.checkGridValues(driver,matchingSupply.gridColumnsOnSupplyPage , matchingSupply.expGridColumnsOnSupplyPage, logger, "Grid Columns on Supply Page");
		 matchingSupply.checkChatBox(driver, matchingSupply.MatchingSupplySSPath1,logger);
		 matchingSupply.checkActionsForSupplyForCentralTeam(driver, matchingSupply.MatchingSupplySSPath1,logger);
		 matchingSupply.checkSortingAvailability(driver, matchingSupply.MatchingSupplySSPath1,logger);// TC07 WithinIG part included here
		 
		 //TC07:Test to valdiate actions for bench resources within and other IG
		 boolean status1 =matchingSupply.clickBenchOtherIGBarGraph(driver,logger);
		 if(status1)
		 matchingSupply.checkActionsBenchOtherIGSupplyForCentralTeam(driver, matchingSupply.MatchingSupplySSPath1,logger);
		 
		 //TC08:Test to validate actions for ROV resources within and other IG
		 boolean status2 = matchingSupply.clickROVwithinIGBarGraph(driver,logger);
		 if(status2)
		 matchingSupply.checkActionsROVWithinIGSupplyForCentralTeam(driver, matchingSupply.MatchingSupplySSPath1,logger);
		 
		 matchingSupply.checkallassert();
		 
		 //Mark resource Not reachable for TC09_NotReachableMatchingSupplyValidations(TC31)
		 mf.refreshPg(driver);
		 mf.clickDemandTab(driver,matchingSupply.MatchingSupplySSPath9,logger);
		 matchingSupply.applySkillFilter( driver, matchingSupply.MatchingSupplySSPath9,logger, 1 ,1);
		 //matchingSupply.applyLevelFilter( driver, matchingSupply.MatchingSupplySSPath9,logger, 1 ,2 ,1);
		 matchingSupply.applyButtonDemandPage(driver, matchingSupply.MatchingSupplySSPath9,logger);
		 matchingSupply.clickPendingEvaluationTab(driver, matchingSupply.MatchingSupplySSPath9,logger);
		 matchingSupply.checkTaggedSupplyForElement(driver, matchingSupply.MatchingSupplySSPath9,logger,matchingSupply.resHighlightInRedTaggedTab);
		 if(!config.getAppUrl().contains("ciodev"))
		 MatchingSupplyPage.nrStatus = matchingSupply.getNotReachableResource(driver, matchingSupply.MatchingSupplySSPath9, logger);
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			    System.out.println(e.getMessage());
			    logger.log(LogStatus.INFO, e.getMessage());
				throw(e);
			}
			 
	}
	

}