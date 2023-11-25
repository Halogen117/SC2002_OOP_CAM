package com.mycompany.anothercam.implementActions;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;

/**
Represents the Register Interface and the following assistance methods.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-27
*/
interface Register {
    /**
     * Lists the run register function.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the Student Object.
     * @return 
     */
    boolean runRegister(ArrayList<Camp> camp_array, User cookie);
    /**
     * Lists the run unregister function.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the Student Object.
     * @return 
     */
    boolean runUnregister(ArrayList<Camp> camp_array, User cookie);
}
