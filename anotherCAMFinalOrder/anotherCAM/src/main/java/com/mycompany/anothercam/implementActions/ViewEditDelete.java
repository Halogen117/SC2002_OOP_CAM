/**
Represents the ViewEditDelete and the following methods that follow
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-25
*/
package com.mycompany.anothercam.implementActions;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;


public interface ViewEditDelete extends View,Edit,Delete{
    /**
    * Runs runView Interface function
    */
    boolean runView(ArrayList<Camp> camp_array, User cookie, Scanner scanObj);
    /**
    * Runs runEdit Interface function
    */
    boolean runEdit(ArrayList<Camp> camp_array, User cookie, Scanner scanObj);
    /**
    * Runs runDelete Interface function
    */
    boolean runDelete(ArrayList<Camp> camp_array, User cookie, Scanner scanObj);
}
