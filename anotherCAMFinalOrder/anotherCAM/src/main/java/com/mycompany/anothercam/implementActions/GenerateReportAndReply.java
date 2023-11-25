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

/**
 GenerateReportAndreply Interface class.
 Runs the edit interface
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-28
 */
public interface GenerateReportAndReply{
    /**
     * Lists the run generate report function.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the Student Object.
     * @return 
     */
    boolean runGenerateReport(ArrayList<Camp> campArray, User cookie);
    
    /**
     * Runs Interface to run Reply.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the User Object.
     * @return 
     */
    boolean runReply(ArrayList<Camp> campArray, User cookie);
}
