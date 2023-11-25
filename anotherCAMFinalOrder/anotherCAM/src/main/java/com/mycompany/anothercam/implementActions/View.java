package com.mycompany.anothercam.implementActions;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
Represents the View Interface and the following assistance methods.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-23
*/
public interface View {

    /**
     * List the run View function.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the User Object.
     * @param scanObj Scanner Object to take in inputs.
     * @return 
     */
    boolean runView(ArrayList<Camp> campArray, User cookie, Scanner scanObj);
}
