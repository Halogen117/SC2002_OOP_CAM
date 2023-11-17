package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Camp;
import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.anothercam.Suggestions;
import com.mycompany.anothercam.SuggestionList;
import com.mycompany.anothercam.User;

public class SuggestionStaffApp {
    public boolean runSuggestionStaffApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){

        //ArrayList<Suggestions> suggestions = new ArrayList<>(); // create the array for suggestions
        SuggestionStaffMenuOptions menu = new SuggestionStaffMenuOptions();
   

        while (true) {
            System.out.println("=== Fancy Text-Based UI ===");
            System.out.println("1. View Suggestions");
            System.out.println("2. Approve/Reject Suggestions");
            //System.out.println("7. Set to Student privilage");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanObj.nextInt();
            scanObj.nextLine();  // Consume the newline character

            switch (choice) {//Staff
                case 1 -> menu.view();
                case 2 -> menu.setStatus();
                case 8 -> {
                    System.out.println("Goodbye!");
                    return true;
                }
                    
                default -> System.out.println("Invalid choice. Please try again.");
            }
            //Staff
            System.out.print("Press Enter to continue...");
        }
    }
}
   

