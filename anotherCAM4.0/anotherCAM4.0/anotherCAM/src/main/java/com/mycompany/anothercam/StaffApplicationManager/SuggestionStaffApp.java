/**
 Represents the SuggestionStaffApp and the following assistance methods.
 A StaffReportApp can be run multiple times depending on staff
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-10
 */


package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Camp;
import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.anothercam.Suggestions;
import com.mycompany.anothercam.SuggestionList;
import com.mycompany.anothercam.User;

public class SuggestionStaffApp {


    /**
     * Runs the Staff suggestion Application.
     * @param campArray the CampArray which the new camp object is stored.
     * @param cookie the User Object (A Staff) which the requested user creates the Camp
     * @param scanObj takes in the scanner Object for automated testing.
     * @return the boolean value whether the edit of camp object was successful.
     */


    public boolean runSuggestionStaffApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){

        //ArrayList<Suggestions> suggestions = new ArrayList<>(); // create the array for suggestions
        SuggestionStaffMenuOptions menu = new SuggestionStaffMenuOptions();


        while (true) {
            System.out.println("=== Suggestion UI ===");
            System.out.println("1. View Suggestions");
            System.out.println("2. Approve/Reject Suggestions");
            //System.out.println("7. Set to Student privilage");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanObj.nextInt();


            switch (choice) {//Staff
                case 1 -> menu.view();
                case 2 -> menu.setStatus();
                case 0 -> {
                    //System.out.println("Goodbye!");
                    return true;
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }
            //Staff
            System.out.print("Press Enter to continue...");
        }
    }
}
   

