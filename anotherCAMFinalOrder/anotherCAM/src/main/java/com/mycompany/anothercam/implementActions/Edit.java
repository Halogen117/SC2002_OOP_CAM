package com.mycompany.anothercam.implementActions;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 Edit Interface class.
 Runs the edit interface
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-26
 */
public interface Edit {

    /**
     * Interface to Edit..
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the User Object.
     * @param scanObj Scanner Object to take in inputs.
     * @return 
     */
    boolean runEdit(ArrayList<Camp> campArray, User cookie, Scanner scanObj);
}
