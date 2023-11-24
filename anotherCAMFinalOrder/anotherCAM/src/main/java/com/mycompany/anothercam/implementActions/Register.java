/**
Represents the Register Object and the following assistance methods.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-27
*/
package com.mycompany.anothercam.implementActions;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;


interface Register {
    /**
    * Runs Register Interface function
    */
    boolean runRegister(ArrayList<Camp> camp_array, User cookie);
    /**
    * Runs UnRegister Interface function
    */
    boolean runUnregister(ArrayList<Camp> camp_array, User cookie);
}
