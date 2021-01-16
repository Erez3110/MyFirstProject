package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class dbActions extends commonOps
{
    @Step("Get Credentials from DB Table")
    public static List<String> getCredentials(String query)
    {
        List<String> credentials = new ArrayList<String>();
        try
        {
            rs = stmt.executeQuery(query);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
        }
        catch (Exception e)
        {
            System.out.println("Error Occurred While Executing SQL Query, See Details: " + e);
        }
        return credentials;
    }
}
