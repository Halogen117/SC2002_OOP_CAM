package com.mycompany.anothercam.implementActions;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 Delete Interface class.
 Runs the delete interface
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-12
 */
public interface Delete {

    /**
     * Interface to run Delete.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the Student Object.
     * @param scanObj Scanner Object to take in inputs.
     * @return 
     */
    boolean runDelete(ArrayList<Camp> campArray, User cookie, Scanner scanObj);
}
