/**
 View suggestions and the following assistance methods.
 Allow the staff to View the suggestions
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-11
 */


package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.SuggestionList;
import com.mycompany.anothercam.Suggestions;
import java.util.ArrayList;

import static com.mycompany.anothercam.SuggestionList.suggestionsList;

/**
 * Runs the Staff Menu Application which allow the staff to view ,set the status of the suggestion
 */



class ViewSuggestionStaff {
    private ArrayList<Suggestions> suggestionList;
    SuggestionList suggestionlist = new SuggestionList();

    /**
     * Contructor to constructor for the staff menu
     */

    public ViewSuggestionStaff() {
        this.suggestionList = suggestionsList;
    }

    /**
     * View the all the suggestions that has been created
     */

    public void view() {
        showSuggestionsForStaff();
    }

    /**
     * View the all the suggestions that has been created but with fewer details
     */

    private void showSuggestionsForStaff() {
        System.out.println("You selected Show Suggestions:");
        System.out.println("=== Suggestions List ===");
        if(suggestionsList.isEmpty() == true){
            System.out.println("There is no suggestion available");
        }
        for (Suggestions suggestion : suggestionsList) {
            System.out.println("================================");
            suggestion.viewSuggestions();
        }
    }

    /**
     * View the all the suggestions that has been created but with fewer details
     */

    public Boolean showsuggestionsmini (){ //show a small portion of the things the student can edit
        System.out.println("=== Suggestions List IDs ===");
        if (!suggestionsList.isEmpty()) {

            for (Suggestions suggestion : suggestionsList) {
                System.out.println("================================");
                suggestion.viewSuggestionsmini();
            }
            return true;
        } else {
            System.out.println("There is no suggestion available");
            return false;
        }
    }
}


