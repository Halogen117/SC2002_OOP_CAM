/**
 Edit suggestions and the following assistance methods.
 Allow the user to Edit the suggestions
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-10
 */

package com.mycompany.anothercam.StudentCommitteeApplicationManager;

import com.mycompany.anothercam.*;
import com.mycompany.anothercam.implementActions.ViewEditDelete;
import java.util.ArrayList;
import java.util.Scanner;

import static com.mycompany.anothercam.SuggestionList.suggestionsList;

public class EditSuggestionStud{
    private SuggestionList suggestionList;


    /**
     * Contructor to constructor for the Student menu
     */


    public EditSuggestionStud(SuggestionList suggestionList) {
        this.suggestionList = suggestionList;
    }

    /**
     * Edit the Suggestions menu
     *
     * @param camp_array the CampArray which the camp object is stored at
     * @param cookie     the User Object (A Student) and their details
     * @param scanObj    takes in the scanner Object for automated testing.
     */


    public boolean runEdit(ArrayList<Camp> camp_array, User cookie, Scanner scanObj) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You selected Edit Suggestions.");
        if(!ViewSuggestionStud.showsuggestionsmini(cookie)){
            return false;
        }
        System.out.println("=== Suggestion EDIT UI ===");
        System.out.println("1. Edit Description");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        int choice = 0;
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                int suggestionID;
                boolean done = false;
                System.out.println("=====================================");
                System.out.println("Which Suggestion do you want to edit");
                System.out.println("=====================================");
                suggestionID = scanner.nextInt();
                //suggestionList.editSuggestionsDescription(suggestionID, cookie.getUserID());
                //System.out.println("Name of student:" + cookie.getUserID());
                for (Suggestions suggestion : suggestionsList) {
                    //System.out.println("Inside For Loop Will Loop Twice ");
                    if (suggestion.getSuggestionID() == suggestionID) {
                        if (suggestion.getStatus() == Status.REJECTED || suggestion.getStatus() == Status.APPROVED) {
                            System.out.println("Suggestions cannot be edited because it has been approved / rejected");
                        } else {
                            if (suggestion.getNameofStudent().equals(cookie.getUserID())) {
                                String description;
                                System.out.println("Enter the new description:");
                                description = scanner.next();
                                suggestion.setDescription(description);
                                done = true;
                                break;
                            }
                        }
                    }
                }
                if(done){
                    System.out.println("description edit successfully");
                }else{
                    System.out.println("Suggestions not found, please try again");
                }


            case 0:
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
                return false;
        }
    }
}



