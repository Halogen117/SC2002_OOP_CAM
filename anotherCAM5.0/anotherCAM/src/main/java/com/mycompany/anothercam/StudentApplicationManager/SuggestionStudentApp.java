/**
 Represents the SuggestionStudentApp and the following assistance methods.
 A SuggestionStudentApp can be run multiple times depending on User
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-10
 */

package com.mycompany.anothercam.StudentApplicationManager;

import com.mycompany.anothercam.Camp;
import java.util.ArrayList;
import java.util.Scanner;

import com.mycompany.anothercam.Suggestions;
import com.mycompany.anothercam.SuggestionList;
import com.mycompany.anothercam.User;





public class SuggestionStudentApp {


    /**
     * Runs the Student suggestion Application allowing student to choose which sumbit,view,delete,edit their suggestions
     * @param campArray the CampArray which the camp object is stored at
     * @param cookie the User Object (A Student) and their details
     * @param scanObj takes in the scanner Object for automated testing.
     * @return the boolean value whether the edit of camp object was successful.
     */

    // change it to MAIN com only...
    public boolean runSuggestionStudentApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj) {
        SuggestionList suggestionList = new SuggestionList();
        SuggestionStudentMenuOptions menu = new SuggestionStudentMenuOptions(suggestionList);

        while (true) {
            System.out.println("=== Suggestion UI ===");
            System.out.println("1. Submit Suggestion");
            System.out.println("2. View Suggestions");
            System.out.println("3. Delete Suggestions");
            System.out.println("4. Edit Suggestions");
            //System.out.println("5. ??? Suggestions");
            //System.out.println("7. Set to teacher privilage");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanObj.nextInt();
            scanObj.nextLine();  // Consume the newline character

            switch (choice) {
                case 1 -> menu.Addsuggestions(campArray,cookie);
                case 2 -> menu.runView(campArray,cookie,scanObj);
                case 3 -> menu.runDelete(campArray,cookie,scanObj);
                case 4 -> menu.runEdit(campArray,cookie,scanObj);
                case 0 -> {
                    System.out.println("Goodbye!");
                    return true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }


        }
    }

}
