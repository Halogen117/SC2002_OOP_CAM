package com.mycompany.anothercam.implementActions;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;

/**
Represents the Submit Interface and the following assistance methods.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-25
*/
interface Submit {
    /**
     * List the run Submit function.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the User Object.
     * @param scanObj Scanner Object to take in inputs.
     * @return 
     */
    boolean runSubmit(ArrayList<Camp> camp_array, User cookie);
}
