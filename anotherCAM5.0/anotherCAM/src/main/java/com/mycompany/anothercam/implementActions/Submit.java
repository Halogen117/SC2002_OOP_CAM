/**
Represents the Submit Interface and the following methods that follow.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-27
*/
package com.mycompany.anothercam.implementActions;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;


interface Submit {
    /**
    * Runs runSubmit Interface function
    */
    boolean runSubmit(ArrayList<Camp> camp_array, User cookie);
}
