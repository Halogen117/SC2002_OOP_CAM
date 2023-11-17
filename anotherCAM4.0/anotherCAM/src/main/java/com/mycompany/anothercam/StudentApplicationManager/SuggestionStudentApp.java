package com.mycompany.anothercam.StudentApplicationManager;

import com.mycompany.anothercam.Camp;
import java.util.ArrayList;
import java.util.Scanner;

import com.mycompany.anothercam.Suggestions;
import com.mycompany.anothercam.SuggestionList;
import com.mycompany.anothercam.User;

public class SuggestionStudentApp {
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
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanObj.nextInt();
            scanObj.nextLine();  // Consume the newline character

            switch (choice) {
                case 1 -> menu.Addsuggestions(campArray,cookie);
                case 2 -> menu.runView(campArray,cookie,scanObj);
                case 3 -> menu.runDelete(campArray,cookie,scanObj);
                case 4 -> menu.runEdit(campArray,cookie,scanObj);
                case 8 -> {
                    System.out.println("Goodbye!");
                    return true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }

            System.out.print("Press Enter to continue...");
            scanObj.nextLine();
        }
    }
}