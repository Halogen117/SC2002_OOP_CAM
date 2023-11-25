package com.mycompany.anothercam.implementActions;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
Represents the combineAllAction Interface and the following assistance methods.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-1
*/
public interface combineAllActions extends GenerateReportAndReply, ViewEditDelete{
    /**
     * List the run view function.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the User Object.
     * @param scanObj Scanner Object to take in inputs.
     * @return 
     */
    boolean runView(ArrayList<Camp> campArray, User cookie, Scanner scanObj);
    /**
     * List the run edit function.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the User Object.
     * @param scanObj Scanner Object to take in inputs.
     * @return 
     */
    boolean runEdit(ArrayList<Camp> campArray, User cookie, Scanner scanObj);
    /**
     * List the run delete function.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the User Object.
     * @param scanObj Scanner Object to take in inputs.
     * @return 
     */
    boolean runDelete(ArrayList<Camp> campArray, User cookie, Scanner scanObj);
    /**
     * List the run generate report function.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the User Object.
     * @return 
     */
    boolean runGenerateReport(ArrayList<Camp> campArray, User cookie);
    /**
     * List the run reply function.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the User Object.
     * @return 
     */
    boolean runReply(ArrayList<Camp> campArray, User cookie);
}
