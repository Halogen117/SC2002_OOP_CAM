/**
Represents the GenerateReportAndReply Interface and the following methods that follow.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-11
*/
package com.mycompany.anothercam.implementActions;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;


public interface GenerateReportAndReply{
    /**
    * Runs GenerateReport Interface function
    */
    boolean runGenerateReport(ArrayList<Camp> campArray, User cookie);
    
    /**
    * Runs Reply Interface function
    */
    boolean runReply(ArrayList<Camp> camp_array, User cookie);
}
