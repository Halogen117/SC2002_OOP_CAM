
package com.mycompany.anothercam.implementActions;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
Represents the ViewEditDelete Interface and the following assistance methods.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-25
*/
public interface ViewEditDelete extends View,Edit,Delete{
    /**
     * List the run View Function.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the User Object.
     * @param scanObj Scanner Object to take in inputs.
     * @return 
     */
    boolean runView(ArrayList<Camp> campArray, User cookie, Scanner scanObj);
    /**
     * List the run Edit Function.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the User Object.
     * @param scanObj Scanner Object to take in inputs.
     * @return 
     */
    boolean runEdit(ArrayList<Camp> campArray, User cookie, Scanner scanObj);
    /**
     * List the run Edit Function.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the User Object.
     * @param scanObj Scanner Object to take in inputs.
     * @return 
     */
    boolean runDelete(ArrayList<Camp> campArray, User cookie, Scanner scanObj);
}
