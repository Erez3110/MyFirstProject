package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.apiFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class grafanaAPI extends commonOps
{
//    @Test(description = "Test 01: Get Team from Grafana")
//    @Description("Test Description: Login to Grafana and Get Team Info")
//    public void test01_getTeam()
//    {
//        verifications.text(apiFlows.getTeamProperty("teams[0].name"),"ErezTeam");
//    }

    @Test(description = "Test 02: Add Team to Grafana")
    @Description("Test Description: Add a New Team to Grafana and Verify")
    public void test02_createTeamAndVerify()
    {
        apiFlows.postTeam("ErezTeam1","erez@team1.com");
        verifications.text(apiFlows.getTeamProperty("teams[0].name"),"ErezTeam1");
    }

    @Test(description = "Test 03: Update Team in Grafana")
    @Description("Test Description: Update a Team in Grafana and Verify")
    public void test03_updateTeamAndVerify()
    {
        apiFlows.updateTeam("MyTeam","erez@team1.com", "11");
        verifications.text(apiFlows.getTeamProperty("teams[0].name"),"MyTeam");
    }

    @Test(description = "Test 04: Delete Team from Grafana")
    @Description("Test Description: Delete a Team from Grafana and Verify")
    public void test04_deleteTeamAndVerify()
    {
        apiFlows.deleteTeam("11");
        verifications.text(apiFlows.getTeamProperty("totalCount"),"0");
    }
}
