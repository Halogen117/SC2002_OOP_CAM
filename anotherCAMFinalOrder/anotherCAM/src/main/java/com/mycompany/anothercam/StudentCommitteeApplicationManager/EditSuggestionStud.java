/**
 Edit suggestions and the following assistance methods.
 Allow the user to Edit the suggestions
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-10
 */

package com.mycompany.anothercam.StudentCommitteeApplicationManager;

import com.mycompany.anothercam.*;
import com.mycompany.anothercam.Login.Verification;
import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.anothercam.implementActions.Edit;

import static com.mycompany.anothercam.SuggestionList.suggestionsList;

public class EditSuggestionStud implements Edit{
    private SuggestionList suggestionList;
    private Verification veri = new Verification();


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
        System.out.println("You selected Edit Suggestions.");
        if(!ViewSuggestionStud.showsuggestionsmini(cookie)){
            return false;
        }
        System.out.println("=== Suggestion EDIT UI ===");
        System.out.println("1. Edit Description");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        int choice = 0;
        choice = veri.verifyScannerNumber(scanObj);
        String description = null;
        switch (choice) {
            case 1:
                int suggestionID;
                boolean done = false;
                System.out.println("=====================================");
                System.out.println("Which Suggestion do you want to edit");
                System.out.println("=====================================");
                suggestionID = veri.verifyScannerNumber(scanObj);
                //suggestionList.editSuggestionsDescription(suggestionID, cookie.getUserID());
                //System.out.println("Name of student:" + cookie.getUserID());
                for (Suggestions suggestion : suggestionsList) {
                    //System.out.println("Inside For Loop Will Loop Twice ");
                    if (suggestion.getSuggestionID() == suggestionID) {
                        if (suggestion.getStatus() == Status.REJECTED || suggestion.getStatus() == Status.APPROVED) {
                            System.out.println("Suggestions cannot be edited because it has been approved / rejected");
                        } else {
                            if (suggestion.getNameofStudent().equals(cookie.getUserID())) {
                                
                                description = veri.verifyDescription(description, "Enter the new description:", scanObj);
                                suggestion.setDescription(description);
                                done = true;
                                break;
                            }
                        }
                    }
                }
                if(done){
                    System.out.println("Description was edited successfully.");
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



