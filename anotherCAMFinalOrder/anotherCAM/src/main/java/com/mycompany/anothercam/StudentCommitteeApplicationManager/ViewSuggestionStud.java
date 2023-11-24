/**
 View suggestions and the following assistance methods.
 Allow the student to View the suggestions
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-10
 */

package com.mycompany.anothercam.StudentCommitteeApplicationManager;

import com.mycompany.anothercam.*;
import com.mycompany.anothercam.implementActions.View;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static com.mycompany.anothercam.Status.*;
import static com.mycompany.anothercam.SuggestionList.suggestionsList;

public class ViewSuggestionStud implements View{
    private static SuggestionList suggestionList;
    /**
     * Contructor to constructor for the Student menu
     */
    public ViewSuggestionStud(SuggestionList suggestionList) {
        this.suggestionList = suggestionList;
    }
    /**
     * Show the suggestions that the student created
     *
     * @param student the User Object
     */
    private void showSuggestionsForStudent(User student) {
        System.out.println("You selected Show Suggestions:");
        //suggestionList.viewSuggestionsStudent(student);
        if(suggestionsList.isEmpty() == true){
            System.out.println("There is no suggestion available");
            return;
        }
        System.out.println("=== Suggestions List ===");
        for (Suggestions suggestion : suggestionsList) {
            if (suggestion.getStatus() == REJECTED || suggestion.getStatus() == APPROVED) {
                // System.out.println("Suggestion: cannot be viewed");
            } else {
                if (Objects.equals(suggestion.getNameofStudent(), student.getUserID())) {
                    System.out.println("================================");
                    suggestion.viewSuggestions();
                }
            }
        }
    }

    /**
     * Show the suggestions that the student created with less detail
     *
     * @param student the User Object
     */
    public static Boolean showsuggestionsmini(User student) {

        //System.out.println("You selected Show Suggestions:");
        if(suggestionsList.isEmpty() == true){
            System.out.println("There is no suggestion available");
            return false;
        }
        System.out.println("=== Suggestions List IDs ===");
        for (Suggestions suggestion : suggestionsList) {
            if (Objects.equals(suggestion.getNameofStudent(), student.getUserID())) {
                if (suggestion.getStatus() == PENDING) {
                    System.out.println("================================");
                    suggestion.viewSuggestionsmini();
                } else { // suggestion.getStatus() == REJECTED || suggestion.getStatus() == APPROVED
                    System.out.println("Suggestion" + suggestion.getSuggestionID() + " has already been Approved/Rejected");
                }
            }
        }//return suggestionList.viewSuggestionsStudentmini(student);
        return true;
    }
    /**
     * Show the suggestions that the student created with less detail
     *
     * @param camp_array the CampArray which the camp object is stored at
     * @param cookie     the User Object (A Student) and their details
     * @param scanObj    takes in the scanner Object for automated testing.
     */
    public boolean runView(ArrayList<Camp> camp_array, User cookie, Scanner scanObj) {
        showSuggestionsForStudent(cookie);
        return false;
    }
}



