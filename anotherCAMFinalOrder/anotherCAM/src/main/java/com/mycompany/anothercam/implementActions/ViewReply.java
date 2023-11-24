package com.mycompany.anothercam.implementActions;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;

public interface ViewReply {


    /**
     * Runs runView Interface function
     */
    boolean runView(ArrayList<Camp> camp_array, User cookie, Scanner scanObj);

    /**
     * Runs runReply Interface function
     */

    boolean runReply(Scanner scanObj);
    
}
